package connection;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PgsqlFactory {
    static String DB_DRIVER;

    public static void createDataConnection() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/properties/database.properties"));

        DB_DRIVER = (String) properties.get("db.driver");

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
