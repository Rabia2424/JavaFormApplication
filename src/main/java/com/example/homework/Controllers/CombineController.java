package com.example.homework.Controllers;

import com.example.homework.Models.Lesson;
import com.example.homework.Models.Student;
import com.example.homework.Repository.LessonRepository;
import com.example.homework.Repository.StudentRepository;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class CombineController {
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
    private Label labelTitle1;

    @FXML
    private TextField txtLId;

    @FXML
    private TextField txtLName;

    @FXML
    private TextField txtLCredit;

    @FXML
    private Button btnFetch1;

    @FXML
    private Button btnCreate1;

    @FXML
    private Button btnUpdate1;

    @FXML
    private Button btnDelete1;


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

    @FXML
    void onFetchButtonClick1() throws SQLException {
        LessonRepository lessonRepository = new LessonRepository();
        Lesson s = lessonRepository.getLessonById(Integer.parseInt(txtLId.getText()));
        // System.out.println(c.toString());
        if(s.getId() == 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "No such record!", ButtonType.CLOSE);
            alert.showAndWait();
            txtLId.setText("");
            txtLId.requestFocus();
        }
        txtLName.setText(s.getName());
        txtLCredit.setText(String.valueOf(s.getCredit()));
    }

    @FXML
    private void onCreateButtonClick1() throws SQLException {
        LessonRepository lessonRepository = new LessonRepository();
        Lesson s = new Lesson(Integer.parseInt(txtLId.getText()), txtLName.getText(), Integer.parseInt(txtLCredit.getText()));
        lessonRepository.saveLesson(s);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Lesson created successfully!", ButtonType.CLOSE);
        alert.showAndWait();
        txtLId.setText("");
        txtLName.setText("");
        txtLCredit.setText("");
        txtLId.requestFocus();
    }

    @FXML
    private void onUpdateButtonClick1() throws SQLException {
        LessonRepository lessonRepository = new LessonRepository();
        lessonRepository.updateLesson(Integer.parseInt(txtLId.getText()), txtLName.getText(), Integer.parseInt(txtLCredit.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Lesson updated successfully!", ButtonType.CLOSE);
        alert.showAndWait();
        txtLId.setText("");
        txtLName.setText("");
        txtLCredit.setText("");
        txtLId.requestFocus();
    }

    @FXML
    private void onDeleteButtonClick1() throws SQLException {
        LessonRepository lessonRepository = new LessonRepository();
        lessonRepository.deleteLesson(Integer.parseInt(txtLId.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Lesson deleted successfully!", ButtonType.CLOSE);
        alert.showAndWait();
        txtLId.setText("");
        txtLName.setText("");
        txtLCredit.setText("");
        txtLId.requestFocus();
    }
}
