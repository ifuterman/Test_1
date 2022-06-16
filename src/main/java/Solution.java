import java.io.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Solution {
    public static void main(String[] arg) {
        if(arg.length < 1){
            System.out.println("File path missed");
            return;
        }
        File file = new File(arg[0]);
        if(!file.isFile()){
            System.out.println("Wrong file path");
            return;
        }
        if(!file.exists()){
            System.out.println("The file does not exists");
            return;
        }
        IPLogFile log = new IPLogFile(file);
        try {
            log.parseFile();
        }catch (Exception e){
            System.out.println("An exception was thrown while parsing the file : " + e);
        }
        System.out.println(log.getUniqueIpCount());
    }
}
