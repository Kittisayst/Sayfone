package Log;

import Tools.JoFileSystem;
import Utility.MyFormat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class querylog {

    public static void saveQueryLog(String message, Object Class) {
        JoFileSystem fileSystem = new JoFileSystem();
        String filePath = fileSystem.getCurrentPath() + "/Log/querylog.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String date = new MyFormat().getDate(new Date());
            String data = date + ": " + Class + " SQL " + message;
            writer.write(data);
            writer.newLine();
        } catch (IOException er) {
            er.printStackTrace();
        }
    }

}
