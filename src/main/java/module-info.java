module main {
    requires javafx.controls;
    requires javafx.fxml;


    exports main;
    opens main to javafx.fxml;

    exports shapes;
    opens shapes to javafx.fxml;

}