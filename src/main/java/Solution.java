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
        IPRegistrant ipCounter = new IPRegistrant();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                ipCounter.registerIp(line);
            }
        } catch (Exception e) {
            System.out.println(0);
        }
        System.out.println(ipCounter.getUniqueIpCount());
    }
}