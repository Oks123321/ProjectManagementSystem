package ua.goit.dev6.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManagerConnector {
    private String url;
    private Properties properties;
    private Connection connection;

    public DatabaseManagerConnector(Properties properties, String username, String password){
        init(properties,username,password);
    }

    private void init(Properties properties, String username, String password){
        url = String.format("jdbc:postgresql://%s:%s/%s", properties.get("host"), properties.get("port"), properties.get("databaseName"));
        this.properties = new Properties();
        this.properties.setProperty("user", username);
        this.properties.setProperty("password", password);
    }
    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, properties);
        return connection;
    }
    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
