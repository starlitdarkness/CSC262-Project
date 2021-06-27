module com.mycompany.robots {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.base;
    requires javafx.graphics;

    opens com.mycompany.robots to javafx.fxml;
    exports com.mycompany.robots;
}
