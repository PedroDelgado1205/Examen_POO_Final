module com.example.examen_poo_final {
    requires javafx.controls;
    requires javafx.fxml;
            
            requires com.dlsc.formsfx;
                        
    opens com.example.examen_poo_final to javafx.fxml;
    exports com.example.examen_poo_final;
}