
package TestConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class FilePath {
    private static final Logger LOGGER = Logger.getLogger(FilePath.class.getName());

    private static final ClassLoader classLoader = FilePath.class.getClassLoader();

    private static final String config = "Config.properties";
    private static final String query = "Query.sql";
    private static final String suite = "TestSuite.xml";

    private static final File Config = new File(classLoader.getResource(config).getFile());
    private static final File Query = new File(classLoader.getResource(query).getFile());
    private static final File Suite = new File(classLoader.getResource(suite).getFile());

    private static FileInputStream fileInputStream;

    public static Properties getConfig() throws FileNotFoundException, IOException {
        fileInputStream = new FileInputStream(Config);
        Properties properties = new Properties();
        properties.load(fileInputStream);

        return properties;
    }

    public static Properties getQuery() throws FileNotFoundException, IOException {
        fileInputStream = new FileInputStream(Query);
        Properties properties = new Properties();
        properties.load(fileInputStream);

        return properties;
    }

    private static String path;

    public static String getSuite() {
        path = Suite.getAbsolutePath();

        return path;
    }
}