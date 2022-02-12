package com.uldemy.gui.util;
import javafx.scene.control.TextField;

public class Constraints {

    //verifica se o campo é nulo e se tem algum valor diferente de um número
    //caso for verdade o campo vai recusar;
    public static void setTextFieldInteger(TextField txt) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*")) {
                txt.setText(oldValue);
            }
        });
    }

    //verifica se o campo é nulo e se o novo valor é maior que o maximo
    //caso for verdade o campo vai recusar;
    public static void setTextFieldMaxLength(TextField txt, int max) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && newValue.length() > max) {
                txt.setText(oldValue);
            }
        });
    }

    //verifica se o campo é nulo e se o número tem apenas um ponto, se tiver mais de um ponto não aceita
    public static void setTextFieldDouble(TextField txt) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
                txt.setText(oldValue);
            }
        });
    }
}
