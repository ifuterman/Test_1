import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IPLogFile extends IPRegistrant {
    private final File file;
    public IPLogFile(File file) {
        this.file = file;
    }
    @SuppressWarnings("UnusedReturnValue")
    boolean parseFile() throws IOException {
        boolean result = true;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(!registerIp(line)){
                    result = false;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
}
