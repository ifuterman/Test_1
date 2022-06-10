import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class IPLogFile extends IPRegistrant{
    private File file;
    public IPLogFile(File file) {
        this.file = file;
    }
    boolean parseFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                registerIp(line);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
