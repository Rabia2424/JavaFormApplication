package com.example.homework.Repository;

import com.example.homework.Models.Student;
import java.sql.*;

public class StudentRepository {
    private final String URL = "jdbc:mysql://127.0.0.1:3306/school";
    private final String USER = "root";
    private final String PASSWORD = "SqlRabia2424";
    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null;

    public Student getStudentById(int sid) throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String query = "SELECT * FROM students WHERE student_id =" + sid +";";
        stm = conn.createStatement();
        rs = stm.executeQuery(query);
        Student s = new Student();
        while(rs.next()){
            s.setId(rs.getInt("student_id"));
            s.setName(rs.getString("student_name"));
            s.setSurname(rs.getString("student_surname"));
        }
        conn.close();
        return s;
    }

    public void saveStudent(Student s) throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        stm = conn.createStatement();
        String query = "INSERT INTO students VALUES (" + s.getId() +",'" + s.getName() + "','" + s.getSurname() +"');";
        stm.executeUpdate(query);
    }

    public void updateStudent(int sid, String name, String surname) throws SQLException{
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stm = conn.createStatement()){
            Student s = getStudentById(sid);
            s.setId(sid);
            s.setName(name);
            s.setSurname(surname);
            String query = "UPDATE students SET student_name='"+ s.getName() +"', student_surname='"+ s.getSurname() +"' where student_id="+s.getId();
            stm.executeUpdate(query);
        }
    }

    public void deleteStudent(int sid) throws SQLException{
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stm = conn.createStatement()){
            Student s = getStudentById(sid);
            String query = "Delete From students where student_id=" + s.getId();
            stm.executeUpdate(query);
        }
    }

}
