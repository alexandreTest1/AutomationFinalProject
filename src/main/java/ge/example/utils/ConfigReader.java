package ge.example.utils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {

    /**
     *  კითხულობს მნიშვნელობებს კონფიგ ფაილიდან
     *
     * @param key რის მიხედვითაც უნდა წაიკითხოს ინფორმაცია
     * @return მნიშვნელობა key-სთვის
     */

    public static String read(String key) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = Files.newInputStream(Paths.get("confug.properties"));
            properties.load(inputStream);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return properties.getProperty(key);
    }


    /**
     * კითხულობს მეთოდს key-ს მნიშვნელობის დასაბრუნებლად
     *
     * @param key- სახელი
     * @return მნიშვნელობა key-სთვის
     */

    public static String get(String key) {
        return read(key);
    }

}
