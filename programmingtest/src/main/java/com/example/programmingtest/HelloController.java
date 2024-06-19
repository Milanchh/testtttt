package com.example.programmingtest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {

    public TextField Username;
    public PasswordField Password;
    @FXML
    private Label welcomeText;

    private final String staticUsername = "Milan";
    private final String staticPassword = "123";
    private int failedAttempts = 0;
    private final int maxFailedAttempts = 5;
    private boolean isLocked = false;

    @FXML
    protected void onHelloButtonClick() {
        if (isLocked) {
            welcomeText.setText("Sorry, Your Account is Locked!!!");
            return;
        }

        if (Username.getText().isEmpty() || Password.getText().isEmpty()) {
            welcomeText.setText("Please Provide Username or Password.");
        } else if (Username.getText().equals(staticUsername)) {
            if (Password.getText().equals(staticPassword)) {
                welcomeText.setText("Success!!!");
                failedAttempts = 0;
            } else {
                failedAttempts++;
                if (failedAttempts >= maxFailedAttempts) {
                    isLocked = true;
                    welcomeText.setText("Sorry, Your Account is Locked!!!");
                } else {
                    welcomeText.setText("Sorry, Invalid Password. Attempt " + failedAttempts + " of " + maxFailedAttempts + ".");
                }
            }
        } else {
            welcomeText.setText("Sorry, Invalid Username or Password.");
        }
    }
}
