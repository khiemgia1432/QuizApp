package com.mycompany.quizapp;

import com.mycompany.utils.MyAlertSingleton;
import com.mycompany.utils.themes.ThemeTypes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class PrimaryController implements Initializable{
    @FXML private ComboBox<ThemeTypes> cbThemes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.cbThemes.setItems(FXCollections.observableArrayList(ThemeTypes.values()));
    }
    public void manageQuestions(ActionEvent e){
        MyAlertSingleton.getInstance().showMsg("[Manage Questions] Coming soon....");
        
    }
    public void pratice(ActionEvent e){
        MyAlertSingleton.getInstance().showMsg("[Pratice Questions] Coming soon....");
        
    }
    public void exams(ActionEvent e){
        MyAlertSingleton.getInstance().showMsg("[Exam Questions] Coming soon....");
        
    }
    
    public void changeTheme(ActionEvent e){
        switch (this.cbThemes.getSelectionModel().getSelectedItem()) {
            case DARK:
                this.cbThemes.getScene().getRoot().getStylesheets().clear();
                this.cbThemes.getScene().getRoot().getStylesheets().add(App.class.getResource("dark.css").toExternalForm());
                break;
            case LIGHT:
                this.cbThemes.getScene().getRoot().getStylesheets().clear();
                this.cbThemes.getScene().getRoot().getStylesheets().add(App.class.getResource("light.css").toExternalForm());
                break;
            default:
                this.cbThemes.getScene().getRoot().getStylesheets().clear();
                this.cbThemes.getScene().getRoot().getStylesheets().add(App.class.getResource("default.css").toExternalForm());
                break;
                    
        }
    }
    
}
