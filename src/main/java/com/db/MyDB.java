package com.db;

import java.sql.*;
import java.util.Random;

public class MyDB {
    public MyDB() {
        String userName = "root";
        String passWord = "12345678";
        String dataBase = "mydb";
        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/"+dataBase, userName, passWord)) {
            if (!connection.isClosed()) // We have a MySQL Connection.
            {
                Statement statement = connection.createStatement();
                Random random = new Random();
                String name = "Anna " + (char)(random.nextInt(56)+67);
                String sql1 = "INSERT INTO person (id, name) VALUES (null,?)";
                PreparedStatement ps1 = connection.prepareStatement(sql1);
                ps1.setString(1,name);
                ps1.executeUpdate();
                String sql = "show databases;";
//				String sql = "select * from person";
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) // loop through rows of result set
                {
                    String firstColumn=resultSet.getString(1);
//					String firstColumn2=resultSet.getString(2); //1-index !! not zero indexbased
                    System.out.println("firstColumn " + firstColumn);
                }
                resultSet.close(); // close result set
                statement.close(); // close statement
            }
        }
        catch (Exception exception)
        {
            System.err.println("Exception: " + exception.getMessage());
        }
    }

}
