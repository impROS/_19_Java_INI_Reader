import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    private static final String filePath = "settings2.ini";

    public static void main(String[] args) {

        writeINIFile("name", "John");
        writeINIFile("lastName", "Akar");

        readINIFile("name");
        readINIFile("name");
    }

    private static void writeINIFile(String key, String value) {
        try {
            Properties properties = readINIFile();

            properties.setProperty(key, value);

            properties.store(new FileOutputStream(filePath), "Example INI File");
            System.out.println("INI dosyası başarıyla yazıldı.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readINIFile(String key) {
        try {
            Properties properties = new Properties();

            properties.load(new FileInputStream(filePath));

            System.out.println("Key: " + key + " Value: " + properties.getProperty(key));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Properties readINIFile() {
        try {
            Properties properties = new Properties();

            properties.load(new FileInputStream(filePath));

            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            return new Properties();
        }
    }
}