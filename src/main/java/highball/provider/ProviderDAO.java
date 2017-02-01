package highball.provider;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by root on 19.01.17.
 */
public class ProviderDAO {

    private String driver;
    private String url;
    private String user;
    private String password;

    public Connection getConnection() {
        Connection connection = null;
        getProperties();
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver mysql connection did not found.");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Problem with jdbc-driver/login/password");
            System.out.println(e.getMessage());
        }
        return connection;
    }

    private void getProperties() {
        try {
            InputStream inputStream = ProviderDAO.class.getClassLoader().getResourceAsStream("config.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            driver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            user = properties.getProperty("jdbc.user");
            password = properties.getProperty("jdbc.password");
        } catch (IOException e) {
            System.out.println("File not found or damaged. " + e.getMessage());
        }
    }

    public void closeConnectionAndStatement(Connection connection, PreparedStatement statement){
        try{
            if(statement!=null) {
                statement.close();
            }
            if(connection !=null){
                connection.close();
            }
        }catch (SQLException e){
            System.out.println("Exception when call method close() of elements statement or connection");
            System.out.println(e.getMessage());
        }
    }
}
