
package TestCases.Orders;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner(value = "chemyl.inc@gmail.com")
@Epic(value = "Orders")
@Feature(value = "TaskList")
@Story(value = "")

public class GetTaskListTest {

    private static long taskCode;
    private static String taskNum;
    private static long orderCode;
    private static String orderNum;

    private void setTaskCode(long taskCode) {
        this.taskCode = taskCode;
    }

    private void setTaskNum(String taskNum) {
        this.taskNum = taskNum;
    }

    private void setOrderCode(long orderCode) {
        this.orderCode = orderCode;
    }

    private void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    @BeforeTest
    private void connectDb() throws IOException, SQLException {
        TestConfig.DataBase.getConTest();
    }

    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Test(description = "Check Something with  CP clients", groups = {"clientCP"})
    @Severity(CRITICAL)
    public void getTaskList() throws IOException, SQLException {
        query = TestConfig.FilePath.getQuery().getProperty("orders.getTaskList");
        preparedStatement = TestConfig.DataBase.getConTest().prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        resultSet.findColumn("RN");
        resultSet.findColumn("AMOUNT");
        resultSet.findColumn("TASK_CODE");
        resultSet.findColumn("TASK_NUM");
        resultSet.findColumn("EM_CODE");
        resultSet.findColumn("EM_NAME");
        resultSet.findColumn("ORDER_CODE");
        resultSet.findColumn("ORDER_NUM");
        resultSet.findColumn("ORDER_TYPE");
        resultSet.findColumn("ORDER_STATE_CODE");
        resultSet.findColumn("ORDER_STATE_NAME");
        resultSet.findColumn("ORDER_STATE_DATE");
        resultSet.findColumn("TASK_STATE_CODE");
        resultSet.findColumn("TASK_STATE_NAME");
        resultSet.findColumn("TASK_STATE_DATE");
        resultSet.findColumn("CLIENT_REG_CODE");
        resultSet.findColumn("CLIENT_NAME");
        resultSet.findColumn("CLIENT_PHONE");
        resultSet.findColumn("CLASS_CODE");
        resultSet.findColumn("CLASS_NAME");
        resultSet.findColumn("ABOUT");
        resultSet.findColumn("CREATE_DATE");
        resultSet.findColumn("CLIENT_TIMEZONE");
        resultSet.findColumn("RESPONSIBLE_CODE");
        resultSet.findColumn("RESPONSIBLE_LASTNAME");
        resultSet.findColumn("RESPONSIBLE_FIRSTNAME");
        resultSet.findColumn("RESPONSIBLE_LOGIN");
        resultSet.findColumn("TO_IN_CREATE_DATE");
        resultSet.findColumn("QTY_OF_CALL_ATTEMPT");
        setTaskCode(resultSet.getLong("TASK_CODE"));
        setTaskNum(resultSet.getString("TASK_NUM"));
        setOrderCode(resultSet.getLong("ORDER_CODE"));
        setOrderNum(resultSet.getString("ORDER_NUM"));
    }

    @AfterTest
    private void disconnectDb() throws IOException, SQLException {
        resultSet.close();
        preparedStatement.close();
        TestConfig.DataBase.getConTest().close();
    }

    public static long getTaskCode() {
        return taskCode;
    }

    public static String getTaskNum() {
        return taskNum;
    }

    public static long getOrderCode() {
        return orderCode;
    }

    public static String getOrderNum() {
        return orderNum;
    }
}