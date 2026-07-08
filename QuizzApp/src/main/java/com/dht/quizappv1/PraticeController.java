/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dht.quizappv1;

import com.dht.pojo.Category;
import com.dht.pojo.Level;
import com.dht.pojo.Question;
import com.dht.pojo.QuestionQueryBuilder;
import com.dht.services.question.QuestionServiceDecorator;
import com.dht.utils.Configs;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class PraticeController implements Initializable {

    @FXML
    private ComboBox<Category> cbSearchCates;
    @FXML
    private ComboBox<Level> cbSearchLevels;
    @FXML
    private TextField txtNum;
    
    private List<Question> questions;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
            this.cbSearchCates.setItems(FXCollections.observableList(Configs.cateService.getCates()));
            this.cbSearchLevels.setItems(FXCollections.observableList(Configs.lvlService.getLevels()));
            
        } catch (SQLException ex) {

        }
    }    
    
    public void start(ActionEvent e){
        QuestionQueryBuilder query = new QuestionQueryBuilder().withCategory(this.cbSearchCates.getSelectionModel().getSelectedItem())
                                                               .withlevel(this.cbSearchLevels.getSelectionModel().getSelectedItem())
                                                               .setOrderBy(" rand() ")
                                                               .setLimit(this.txtNum.getText());
        Configs.questionService.setQuery(query);
        try {
            this.questions = new QuestionServiceDecorator(Configs.questionService).getQuestions();
            System.out.println("------");
        } catch (SQLException ex) {
            Logger.getLogger(PraticeController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
