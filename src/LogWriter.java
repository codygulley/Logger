import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by codygulley on 1/31/16.
 */
public class LogWriter {

    private File file;
    private java.io.FileWriter fw;
    private BufferedWriter bufferWritter = new BufferedWriter(fw);

    public LogWriter() throws IOException {
        fw = new FileWriter(file, true);
    }

    public LogWriter(File fileName) throws IOException {
        file = new File(fileName + ".log");

        //if file doesn't exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        //true = append file
        System.out.println(file);

        bufferWritter.write("\nINFO " + getDateTime() + " Initializing Logs!");
        bufferWritter.flush();

        fw = new FileWriter(file, true);
    }


    public void output(String level, String message) {
        try {
            String source = new Exception().getStackTrace()[1].getClassName();
            bufferWritter.write("\n" + level + " " + getDateTime() + " Class: " + source + " " + message + "\"");
            System.out.println("VIALogger : " + level + " " + getDateTime() + " Class: " + source + " " + message + "\"");
            bufferWritter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

}
