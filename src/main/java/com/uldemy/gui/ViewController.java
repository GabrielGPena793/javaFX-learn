package com.uldemy.gui;

import com.uldemy.gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ViewController {

    @FXML
    private Button btTest;

    //chama a função quando clicar no botão
    @FXML
    public void onBtTestAction(){
        Alerts.showAlert("Alert title", null, "Hello", Alert.AlertType.ERROR);
    }

}