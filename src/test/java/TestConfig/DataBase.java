
package TestConfig;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private static StringBuilder stringBuilder;
    private static String url;
    private static String driver;
    private static String login;
    private static String password;
    private static String host;
    private static String port;
    private static String service;

    private static String setConTest() throws IOException {
        driver = TestConfig.FilePath.getConfig().getProperty("db.test.driver");
        login = TestConfig.FilePath.getConfig().getProperty("db.test.login");
        password = TestConfig.FilePath.getConfig().getProperty("db.test.pass");
        host = TestConfig.FilePath.getConfig().getProperty("db.test.host");
        port = TestConfig.FilePath.getConfig().getProperty("db.test.port");
        service = TestConfig.FilePath.getConfig().getProperty("db.test.service");

        stringBuilder = new StringBuilder();
        stringBuilder.append(driver);
        stringBuilder.append(":");
        stringBuilder.append(login);
        stringBuilder.append("/");
        stringBuilder.append(password);
        stringBuilder.append("@");
        stringBuilder.append(host);
        stringBuilder.append(":");
        stringBuilder.append(port);
        stringBuilder.append("/");
        stringBuilder.append(service);

        url = stringBuilder.toString();

        return url;
    }

    private static synchronized String setConPilot() throws IOException {
        driver = TestConfig.FilePath.getConfig().getProperty("db.pilot.driver");
        login = TestConfig.FilePath.getConfig().getProperty("db.pilot.login");
        password = TestConfig.FilePath.getConfig().getProperty("db.pilot.pass");
        host = TestConfig.FilePath.getConfig().getProperty("db.pilot.host");
        port = TestConfig.FilePath.getConfig().getProperty("db.pilot.port");
        service = TestConfig.FilePath.getConfig().getProperty("db.pilot.service");

        stringBuilder = new StringBuilder();
        stringBuilder.append(driver);
        stringBuilder.append(":");
        stringBuilder.append(login);
        stringBuilder.append("/");
        stringBuilder.append(password);
        stringBuilder.append("@");
        stringBuilder.append(host);
        stringBuilder.append(":");
        stringBuilder.append(port);
        stringBuilder.append("/");
        stringBuilder.append(service);

        url = stringBuilder.toString();

        return url;
    }

    private static String setConExt() throws IOException {
        driver = TestConfig.FilePath.getConfig().getProperty("db.test.driver");
        login = TestConfig.FilePath.getConfig().getProperty("db.ext.login");
        password = TestConfig.FilePath.getConfig().getProperty("db.ext.pass");
        host = TestConfig.FilePath.getConfig().getProperty("db.test.host");
        port = TestConfig.FilePath.getConfig().getProperty("db.test.port");
        service = TestConfig.FilePath.getConfig().getProperty("db.test.service");

        stringBuilder = new StringBuilder();
        stringBuilder.append(driver);
        stringBuilder.append(":");
        stringBuilder.append(login);
        stringBuilder.append("/");
        stringBuilder.append(password);
        stringBuilder.append("@");
        stringBuilder.append(host);
        stringBuilder.append(":");
        stringBuilder.append(port);
        stringBuilder.append("/");
        stringBuilder.append(service);

        url = stringBuilder.toString();

        return url;
    }

    private static Connection connection;

    public static Connection getConTest() throws IOException, SQLException {
        connection = DriverManager.getConnection(setConTest());

        return connection;
    }

    public static Connection getConPilot() throws IOException, SQLException {
        connection = DriverManager.getConnection(setConPilot());

        return connection;
    }

    public static Connection getConExt() throws IOException, SQLException {
        connection = DriverManager.getConnection(setConExt());
        return connection;
    }
}