module com.example.proyectoprogramacion2 {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.example.proyectoprogramacion2.Controllers to javafx.fxml;

    opens com.example.proyectoprogramacion2 to javafx.fxml;
    exports com.example.proyectoprogramacion2;
    exports com.example.proyectoprogramacion2.model;
    opens com.example.proyectoprogramacion2.model to javafx.fxml;
}