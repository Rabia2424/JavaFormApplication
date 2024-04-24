package com.example.homework.Repository;

import com.example.homework.Models.Lesson;
import com.example.homework.Models.Student;

import java.sql.*;

public class LessonRepository {
    private final String URL = "jdbc:mysql://127.0.0.1:3306/school";
    private final String USER = "root";
    private final String PASSWORD = "SqlRabia2424";
    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null;

    public Lesson getLessonById(int sid) throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String query = "SELECT * FROM courses WHERE course_id =" + sid +";";
        stm = conn.createStatement();
        rs = stm.executeQuery(query);
        Lesson s = new Lesson();
        while(rs.next()){
            s.setId(rs.getInt("course_id"));
            s.setName(rs.getString("course_name"));
            s.setCredit(rs.getInt("course_credit"));
        }
        conn.close();
        return s;
    }

    public void saveLesson(Lesson s) throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        stm = conn.createStatement();
        String query = "INSERT INTO courses VALUES (" + s.getId() +",'" + s.getName() + "','" + s.getCredit() +"');";
        stm.executeUpdate(query);
    }

    public void updateLesson(int sid, String name, int credit) throws SQLException{
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stm = conn.createStatement()){
            Lesson s = getLessonById(sid);
            s.setId(sid);
            s.setName(name);
            s.setCredit(credit);
            String query = "UPDATE courses SET course_name='"+ s.getName() +"', course_credit='"+ s.getCredit() +"' where course_id="+s.getId();
            stm.executeUpdate(query);
        }
    }

    public void deleteLesson(int sid) throws SQLException{
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stm = conn.createStatement()){
            Lesson s = getLessonById(sid);
            String query = "Delete From courses where course_id=" + s.getId();
            stm.executeUpdate(query);
        }
    }
}
