
package TestCases.Clients;

import io.qameta.allure.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import static io.qameta.allure.SeverityLevel.MINOR;

@Owner(value = "chemul.inc@gmail.com")
@Epic(value = "Clients")
@Feature(value = "ClientCP")
@Story(value = "")

class GetClientCpTest {
    private static final Logger LOGGER = Logger.getLogger(GetClientCpTest.class.getName());

    @BeforeTest
    private void connectDb() throws IOException, SQLException {
        TestConfig.DataBase.getConTest();
    }

    private String query;
    private PreparedStatement preparedStatement;

    @Test(description = "Check Something with  CP clients", groups = {"clientCP"})
    @Severity(MINOR)
    public void getClientCp() throws IOException, SQLException {
        query = TestConfig.FilePath.getQuery().getProperty("client.getClientCp");
        preparedStatement = TestConfig.DataBase.getConTest().prepareStatement(query);
        preparedStatement.execute();
    }

    @AfterTest
    private void disconnectDb() throws IOException, SQLException {
        preparedStatement.close();
        TestConfig.DataBase.getConTest().close();
    }
}