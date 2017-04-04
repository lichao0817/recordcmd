package app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import model.Record;
import util.RecordUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Chao on 2017/4/3.
 */
public class Application {
    @Parameter
    private List<String> params;
    @Parameter(names={"--input", "-i"})
    private String inputFilePath;
    @Parameter(names={"--order", "-o"})
    private String order;
    public static void main(String[] args) {
        Application app = new Application();
        new JCommander(app, args);
        app.run();
    }
    private void run() {
        System.out.println();
        if (inputFilePath == null) {
            System.out.println("The input file cannot be found.");
            return;
        }
        if (order == null) {
            System.out.println("Please specify an order.");
        }
        File f = new File(inputFilePath);
        try {
            Scanner scanner = new Scanner(f);
            List<Record> list;
            String message;
            if (order.equals("g") || order.equals("gender")) {
                message = "Sort by gender: ";
                list = RecordUtil.getRecordsByGender(scanner);
            }
            else if (order.equals("n") || order.equals("name")) {
               message = "Sort by last name in descending order: ";
                list = RecordUtil.getRecordsByName(scanner);
            }
            else if (order.equals("b") || order.equals("birth")) {
                message = "Sort by date of birth: ";
                list = RecordUtil.getRecordsByBirthday(scanner);
            }
            else {
                message = "The order is not valid. Sort by default order: gender.";
                list = RecordUtil.getRecordsByGender(scanner);
            }
            System.out.println(message + "\n");
            for (Record r : list) {
                System.out.println(r);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The input file cannot be found.");
        }
    }
}
