package jm.task.core.jdbc.util;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();
    static  {
        loadProperties();
    }

    public PropertiesUtil() {
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("app.properties")) {
            PROPERTIES.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
