package com.example.eighthexercise;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.math.BigDecimal;

public class MainController {

    @FXML
    private ChoiceBox choiseWindow;

    ObservableList<String> choiseMeterage= FXCollections.observableArrayList("Тонны","Килограммы","Граммы");

    @FXML
    private Label gramWindow;

    @FXML
    private TextField inputWindow;

    @FXML
    private Label kiloWindow;

    @FXML
    private Label tonWindow;

    @FXML
    void valueCalculation(Event event) {

            if (!inputWindow.getText().isEmpty()) switch ((choiseWindow.getValue()).toString()){

                case "Тонны":
                {

                    tonWindow.setText(new BigDecimal(Double.parseDouble(inputWindow.getText())).toPlainString());
                    kiloWindow.setText(new BigDecimal(Double.parseDouble(inputWindow.getText())*1000).toPlainString());
                    gramWindow.setText(new BigDecimal(Double.parseDouble(inputWindow.getText())*1000000).toPlainString());
                    break;

                }

                case  "Килограммы":
                {

                    tonWindow.setText(new BigDecimal(Double.parseDouble(inputWindow.getText())/1000).toPlainString());
                    kiloWindow.setText(new BigDecimal(Double.parseDouble(inputWindow.getText())).toPlainString());
                    gramWindow.setText(new BigDecimal(Double.parseDouble(inputWindow.getText())*1000).toPlainString());
                    break;

                }

                case "Граммы":

                {
                    tonWindow.setText(new BigDecimal(Double.parseDouble(inputWindow.getText())/1000000).toPlainString());
                    kiloWindow.setText(new BigDecimal(Double.parseDouble(inputWindow.getText())/1000).toPlainString());
                    gramWindow.setText(new BigDecimal(Double.parseDouble(inputWindow.getText())).toPlainString());
                    break;

                }

            }
            else{

                tonWindow.setText("");
                kiloWindow.setText("");
                gramWindow.setText("");

            }

    }

    @FXML
    private void  initialize(){

        choiseWindow.setValue("Тонны");
        choiseWindow.setItems(choiseMeterage);

        choiseWindow.setOnAction(event->{

            valueCalculation(event);

        });

        inputWindow.setOnKeyTyped(event->{

            valueCalculation(event);

        });

    }

}