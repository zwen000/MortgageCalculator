package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.lang.reflect.InvocationTargetException;


public class Controller {

    @FXML
    private TextField textField1 = new TextField();
    @FXML
    private TextField textField2 = new TextField();
    @FXML
    private TextField textField3= new TextField();

    @FXML
    RadioButton ten;
    @FXML
    RadioButton twenty;
    @FXML
    RadioButton thirty;

    @FXML
    private Label MP;

    @FXML
    public void calculate(){
        Double n = 0.0;
        if(ten.isSelected())
            n = 10.;
        else if(twenty.isSelected())
            n = 20.;
        else if(thirty.isSelected())
            n = 30.;
        Double month = n*12;

        try {
            Double price = new Double(0);
            Double downPayment = new Double(0);
            Double rate = new Double(0);
            if (textField1.getText() != "" && textField2.getText() != "" && textField3.getText() != "") {
                MP.setText("0.0");
                return;
            }

            if(textField1.getText() != "") {
                price = Double.parseDouble(textField1.getText());
            }
            if(textField2.getText() != "") {
                downPayment = Double.parseDouble(textField2.getText());
            }
            if(textField3.getText() != "") {
                rate = Double.parseDouble(textField3.getText());
            }

            if ( (downPayment >= price)  )
            {
                MP.setText("0.0");
                return;
            }

            rate /= 100.0;
            Double loanAmount = price - downPayment;
            Double MonthlyPayment =( loanAmount * Math.pow(1.0+rate,n) )/ month ;
            MP.setText( Double.toString(MonthlyPayment) );
        }
        catch (RuntimeException runtime ){
            MP.setText("Invalid Input");
        }



    }

}
