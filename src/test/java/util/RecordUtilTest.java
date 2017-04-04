package util;

import model.Gender;
import model.Record;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Chao on 2017/3/23.
 */
public class RecordUtilTest {
    @Test
    public void parseRecordTest1() {
        ClassLoader classLoader = getClass().getClassLoader();
        Scanner in = new Scanner(classLoader.getResourceAsStream("comma-delimited.txt"));
        List<Record> list = RecordUtil.getRecordsByBirthday(in);
        for (int i = 1; i < list.size(); i++) {
            Assert.assertTrue(list.get(i - 1).getDateOfBirth().compareTo(list.get(i).getDateOfBirth()) < 0);
        }
    }
    @Test
    public void parseRecordTest2() {
        ClassLoader classLoader = getClass().getClassLoader();
        Scanner in = new Scanner(classLoader.getResourceAsStream("pipe-delimited.txt"));
        List<Record> list = RecordUtil.getRecordsByGender(in);
        for (int i = 1; i < list.size(); i++) {
            Assert.assertTrue(list.get(i - 1).getGender() == Gender.Female ||
                    (list.get(i - 1).getGender() == Gender.Male && list.get(i).getGender() == Gender.Male));
        }
    }
    @Test
    public void parseRecordTest3() {
        ClassLoader classLoader = getClass().getClassLoader();
        Scanner in = new Scanner(classLoader.getResourceAsStream("space-delimited.txt"));
        List<Record> list = RecordUtil.getRecordsByName(in);
        for (int i = 1; i < list.size(); i++) {
            Assert.assertTrue(list.get(i - 1).getLastName().compareTo(list.get(i).getLastName()) >= 0);
        }
    }
}
