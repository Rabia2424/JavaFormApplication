package com.example.homework;

import java.sql.*;

public class MyJDBC {
    public static void main(String[] args){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/school",
                    "root",
                    "SqlRabia2424"
            );

            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("Select * From students");

            while(resultset.next()){
                System.out.println(resultset.getInt("student_id"));
                        System.out.println(resultset.getString("student_name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
