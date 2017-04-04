package util;

import model.Gender;
import model.Record;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Chao on 2017/3/23.
 */
public class RecordUtil {
    private static Comparator<Record> getComparator(Order order) {
        Comparator<Record> comparator;
        switch (order) {
            // Sort by gender
            case GENDER:
                comparator = new Comparator<Record>() {
                    public int compare(Record o1, Record o2) {
                        if (o1.getGender() == o2.getGender()) {
                            return o1.getLastName().compareTo(o2.getLastName());
                        }
                        if (o1.getGender() == Gender.Female) {
                            return -1;
                        }
                        return 1;
                    }
                };
                break;
            // Sort by date in ascending order
            case BIRTHDAY:
                comparator = new Comparator<Record>() {
                    public int compare(Record o1, Record o2) {
                        if (o1.getDateOfBirth().equals(o2.getDateOfBirth())) {
                            o1.getLastName().compareTo(o2.getLastName());
                        }
                        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
                    }
                };
                break;
            // Sort by last name in descending order
            case NAME:
                comparator = new Comparator<Record>() {
                    public int compare(Record o1, Record o2) {
                        if (o1.getLastName().equals(o2.getLastName())) {
                            return o1.getFirstName().compareTo(o2.getFirstName());
                        }
                        return o2.getLastName().compareTo(o1.getLastName());
                    }
                };
                break;
            default:
                comparator = null;
        }
        return comparator;
    }
    private static Gender parseGender(String gender) {
        Gender res = Gender.Female;
        if (gender.equals("F")) {
            res = Gender.Female;

        } else if (gender.equals("M")) {
            res = Gender.Male;

        }
        return res;
    }
    private static Date parseDate(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return df.parse(date);
    }
    private static Record constructRecord(String[] args) throws ParseException {
        return new Record(args[0], args[1], parseGender(args[2]), args[3], parseDate(args[4]));
    }
    public static Record parseLine(String line) {
        String separator = null;
        if (line.contains(", ")) {
            separator = ", ";
        }
        else if (line.contains("|")) {
            separator = " \\| ";
        }
        else {
            separator = " ";
        }
        Record res = null;
        try {
            res = constructRecord(line.split(separator));
        } catch (ParseException e) {
            res = null;
        }
        finally {
            return res;
        }
    }
    private static List<Record> parseRecords(Scanner scanner) {
        List<Record> res = new ArrayList<Record>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            res.add(parseLine(line));
        }
        return res;
    }
    private static void sort(List<Record> list, Order order) {
        Collections.sort(list, getComparator(order));
    }
    public static void sortRecordsByGender(List<Record> records) {
        sort(records, Order.GENDER);
    }
    public static void sortRecordsByBirthDay(List<Record> records) {
        sort(records, Order.BIRTHDAY);
    }
    public static void sortRecordsByName(List<Record> records) {
        sort(records, Order.NAME);
    }
    public static List<Record> getRecordsByGender(Scanner file) {
        List<Record> records = parseRecords(file);
        sortRecordsByGender(records);
        return records;
    }
    public static List<Record> getRecordsByBirthday(Scanner file) {
        List<Record> records = parseRecords(file);
        sortRecordsByBirthDay(records);
        return records;
    }
    public static List<Record> getRecordsByName(Scanner file) {
        List<Record> records = parseRecords(file);
        sortRecordsByName(records);
        return records;
    }
}