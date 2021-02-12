
package TestConfig;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class TestStarter {
    private static final Logger LOGGER = Logger.getLogger(TestStarter.class.getName());

    private static Parser parser;
    private static List<XmlSuite> suites;
    private static TestNG testNG;

    public static void main(String[] args) throws IOException {
        parser = new Parser(TestConfig.FilePath.getSuite());
        suites = parser.parseToList();
        testNG = new TestNG(true);
        testNG.setXmlSuites(suites);
        testNG.run();
    }
}