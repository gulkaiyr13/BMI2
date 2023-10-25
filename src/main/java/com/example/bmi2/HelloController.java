package com.example.bmi2;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.application.Platform;

public class HelloController {

    @FXML
    private MenuItem clear;

    @FXML
    private TextField displayCategory;

    @FXML
    private TextField displayValue;

    @FXML
    private MenuItem exit;

    @FXML
    private TextField lbs;

    @FXML
    private TextField n;
    @FXML
    void calculate(ActionEvent event) {
        try {
            double weight = Double.parseDouble(lbs.getText());
            double height = Double.parseDouble(n.getText());

            if (weight > 0 && height > 0) {
                double bmi = 703 * (weight / (height * height));

                displayValue.setText(String.format("%.2f", bmi));

                String category = getBMICategory(bmi);
                displayCategory.setText(category);
            } else {
                displayValue.setText("Invalid input");
                displayCategory.setText("");
            }
        } catch (NumberFormatException e) {
            displayValue.setText("Invalid input");
            displayCategory.setText("");
        }
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
    public void clearFields() {
        lbs.clear();
        n.clear();
        displayCategory.setText("");
        displayValue.setText("");
    }

    public void showInf() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About BMI Calculator");
        alert.setHeaderText("BMI Calculator Application");
        alert.setContentText("The BMI (Body Mass Index) calculator is a tool that helps you assess your body weight in relation to your height.\n" +
                "Enter weight in kg and height in m.");
        alert.showAndWait();
    }

    public void exitApplication() {
        Platform.exit();
    }

}
