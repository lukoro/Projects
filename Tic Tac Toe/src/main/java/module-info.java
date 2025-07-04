module org.example.tictaktoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tictaktoe to javafx.fxml;
    exports org.example.tictaktoe;
}