package com.uldemy.gui;

import com.uldemy.model.entities.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private ComboBox<Person> personComboBox;

    @FXML
    private Button btAll;

    private ObservableList<Person> observableList;

    @FXML
    private void onBtAllAction(){
        personComboBox.getItems().forEach(System.out::println);
    }

    @FXML
    public void onComboBoxPersonAction(){
        //vai pegar o elemento selecionado no comboBox e imprimir no console
        Person person = personComboBox.getSelectionModel().getSelectedItem();
        System.out.println(person);
    }

    //ativa os requisitos antes do programa iniciar
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Maria", "maria@gmail.com"));
        list.add(new Person(2, "Alex", "alex@gmail.com"));
        list.add(new Person(3, "Bob", "bob@gmail.com"));

        observableList = FXCollections.observableList(list);
        personComboBox.setItems(observableList);

        // customiza como quer mostrar os itens do comboBox a partir do toString da classe
        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        personComboBox.setCellFactory(factory);
        personComboBox.setButtonCell(factory.call(null));
    }
}