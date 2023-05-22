module com.example.notekeeper {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.notekeeper to javafx.fxml;
    exports com.example.notekeeper;
}