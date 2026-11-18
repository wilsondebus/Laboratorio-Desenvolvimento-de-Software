package org.example.firtsapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private TextField txtNome;

    @FXML
    private Label lblMensagem;

    @FXML
    protected void exibirMensagem() {
        String nome = txtNome.getText();

        if(nome == null || nome.trim().isEmpty()) {
            lblMensagem.setText("Por favor, digite um nome: ");
        } else {
            lblMensagem.setText("Olá: " + nome);
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


}