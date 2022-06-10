import java.io.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Solution {
    public static void main(String[] arg) {
        if(arg.length < 1){
            System.out.println(0);
            return;
        }
        File file = new File(arg[0]);
        IPLogFile log = new IPLogFile(file);
        log.parseFile();
        System.out.println(log.getUniqueIpCount());
    }
}