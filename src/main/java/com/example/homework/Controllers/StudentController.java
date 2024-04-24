package com.example.homework.Controllers;

import com.example.homework.Models.Student;
import com.example.homework.Repository.StudentRepository;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class StudentController {
    @FXML
    private Label labelTitle;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSurname;

    @FXML
    private Button btnFetch;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    void onFetchButtonClick() throws SQLException {
        StudentRepository studentRepository = new StudentRepository();
        Student s = studentRepository.getStudentById(Integer.parseInt(txtId.getText()));
        // System.out.println(c.toString());
        if(s.getId() == 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "No such record!", ButtonType.CLOSE);
            alert.showAndWait();
            txtId.setText("");
            txtId.requestFocus();
        }
        txtName.setText(s.getName());
        txtSurname.setText(s.getSurname());
    }

    @FXML
    private void onCreateButtonClick() throws SQLException {
        StudentRepository studentRepository = new StudentRepository();
        Student s = new Student(Integer.parseInt(txtId.getText()), txtName.getText(), txtSurname.getText());

        studentRepository.saveStudent(s);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Student created successfully!", ButtonType.CLOSE);
        alert.showAndWait();
        txtId.setText("");
        txtName.setText("");
        txtSurname.setText("");
        txtId.requestFocus();
    }

    @FXML
    private void onUpdateButtonClick() throws SQLException {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.updateStudent(Integer.parseInt(txtId.getText()), txtName.getText(), txtSurname.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Student updated successfully!", ButtonType.CLOSE);
        alert.showAndWait();
        txtId.setText("");
        txtName.setText("");
        txtSurname.setText("");
        txtId.requestFocus();
    }

    @FXML
    private void onDeleteButtonClick() throws SQLException {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.deleteStudent(Integer.parseInt(txtId.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Student deleted successfully!", ButtonType.CLOSE);
        alert.showAndWait();
        txtId.setText("");
        txtName.setText("");
        txtSurname.setText("");
        txtId.requestFocus();
    }
}
