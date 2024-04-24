package com.example.homework.Controllers;

import com.example.homework.Models.Lesson;
import com.example.homework.Models.Student;
import com.example.homework.Repository.LessonRepository;
import com.example.homework.Repository.StudentRepository;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class LessonController {
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
