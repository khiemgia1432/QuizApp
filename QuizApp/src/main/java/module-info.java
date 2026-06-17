module com.mycompany.quizapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.quizapp to javafx.fxml;
    exports com.mycompany.quizapp;
}
