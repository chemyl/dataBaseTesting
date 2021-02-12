
package TestCases.Clients;

import io.qameta.allure.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import static io.qameta.allure.SeverityLevel.MINOR;

@Owner(value = "chemul.inc@gmail.com")
@Epic(value = "Clients")
@Feature(value = "ClientCP")
@Story(value = "")

class FindClientContTest {
    private static final Logger LOGGER = Logger.getLogger(FindClientContTest.class.getName());

    @BeforeTest
    private void connectDb() throws IOException, SQLException {
        TestConfig.DataBase.getConTest();
    }

    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Test(description = "Find CP client", groups = {"clientCP"})
    @Severity(MINOR)
    public void findClientCont() throws IOException, SQLException {
        query = TestConfig.FilePath.getQuery().getProperty("client.findClientCont");
        preparedStatement = TestConfig.DataBase.getConTest().prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        resultSet.findColumn("CP_CODE");
        resultSet.findColumn("CP_NAME");
        resultSet.findColumn("CLIENT_REG_CODE");
        resultSet.findColumn("CLIENT_LAST_NAME");
        resultSet.findColumn("CLIENT_FIRST_NAME");
        resultSet.findColumn("CLIENT_MIDDLE_NAME");
        resultSet.findColumn("CLIENT_PHONE");
        resultSet.findColumn("CLIENT_EMAIL");
        resultSet.findColumn("CLIENT_CARD");
        resultSet.findColumn("TASK_NOT_FINISHED");
        resultSet.findColumn("CP_TASK_NOT_FINISHED");
        resultSet.findColumn("BUY_SUM");
        resultSet.findColumn("LOCAL_DATETIME");
    }

    @AfterTest
    private void disconnectDb() throws IOException, SQLException {
        resultSet.close();
        preparedStatement.close();
        TestConfig.DataBase.getConTest().close();
    }
}