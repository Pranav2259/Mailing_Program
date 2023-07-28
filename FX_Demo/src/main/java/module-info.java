module com.example.fx_demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.mail;

    opens com.example.fx_demo to javafx.fxml;
    exports com.example.fx_demo;
}