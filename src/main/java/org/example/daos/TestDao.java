package org.example.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class TestDao {
    public List<String> testConnection() throws SQLException {
        List<String> databases = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            long start = currentTimeMillis();

            ResultSet resultSet = statement.executeQuery(
                    "SHOW DATABASES;");

            long end = currentTimeMillis();

            out.println("Total time to execute query in milliseconds " + (end - start));

            while (resultSet.next()) {
                databases.add(resultSet.getString("Database"));
            }
        }

        return databases;
    }
}
