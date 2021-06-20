module com.espol.ed.grupo_05_ed {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.espol.ed.grupo_05_ed to javafx.fxml;
    exports com.espol.ed.grupo_05_ed;
}
