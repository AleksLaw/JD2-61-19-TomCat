package by.pvt;

import java.sql.*;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.*;

/**
 *
 */
public class HelloMysqlTest extends DBTestCase {

    public HelloMysqlTest(String name) {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/hello_mysql_junit");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "Kjuby789789987");
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(HelloMysqlTest.class.getResourceAsStream("system_users.xml"));
    }

    @Test
    public void testConnection() throws Exception {
Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection =
                     DriverManager
               .getConnection("jdbc:mysql://localhost:3306/hello_mysql_junit", "root", "Kjuby789789987");
             Statement ps = connection.createStatement();
        ) {
            ResultSet rs = ps.executeQuery("select * from system_users");
            assertNotNull(rs);

            int rawCount = 0;
            int activeUser = 0;

            while (rs.next()) {
                rawCount++;
                if (rs.getBoolean("active")) activeUser++;
            }
            assertEquals(4, rawCount);
            assertEquals(2, activeUser);

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
