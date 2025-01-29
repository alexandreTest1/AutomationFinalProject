package ge.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {

    // პარამეტრის შენახვა
    private static boolean isTestEnabled;

    static {
        // წაიკითხე config.properties ფაილი
        try (FileInputStream input = new FileInputStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            // წაიკითხე "test" პარამეტრი
            isTestEnabled = Boolean.parseBoolean(properties.getProperty("test", "false"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void log(String message) {

        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().info(message);
        }


        if (!isTestEnabled) {
            System.out.println("LOG: " + message);
        }
    }


}
