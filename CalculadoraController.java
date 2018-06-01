package calculadora;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CalculadoraController implements Initializable {

    @FXML
    private TextField valor1TextField;
    @FXML
    private TextField valor2TextField;
    @FXML
    private Button calcularButton;
    @FXML
    private Button usarButton;
    @FXML
    private ComboBox<Operações> operaçõesComboBox;
    @FXML
    private TextField resultadoTextField;
    private List<Operações> listaDeOperações = new ArrayList<Operações>();
    private ObservableList<Operações> observableListOperações;
    private double resultado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxOperações();

    }

    public void comboBoxOperações() {
        Operações adição = new Operações("+ Adição", true);
        Operações subtração = new Operações("- Subtração", true);
        Operações divisão = new Operações("/ Divisão", true);
        Operações multiplicação = new Operações("* Multiplicação", true);
        Operações exponenciação = new Operações("** Exponenciação", true);
        Operações fatorial = new Operações("! Fatorial", false);
        Operações porcentagem = new Operações("% Porcentagem", false);
        Operações negativo = new Operações("_ Negativo", false);

        // adicionando objetos ao ArrayList
        listaDeOperações.add(adição);
        listaDeOperações.add(subtração);
        listaDeOperações.add(divisão);
        listaDeOperações.add(multiplicação);
        listaDeOperações.add(exponenciação);
        listaDeOperações.add(fatorial);
        listaDeOperações.add(porcentagem);
        listaDeOperações.add(negativo);

        // adicionando ao observableList
        observableListOperações = FXCollections.observableArrayList(listaDeOperações);

        operaçõesComboBox.setItems(observableListOperações);

    }
    @FXML
    public void operaçãoescolhida() {
        Double valor1 = Double.parseDouble(valor1TextField.getText());
        Double valor2 = Double.parseDouble(valor2TextField.getText());
        Operações operações = operaçõesComboBox.getSelectionModel().getSelectedItem();
        String ope = operações.getOperações();
        switch (ope) {
            case "+ Adição":
                resultado = valor1 + valor2;
                resultadoTextField.setText(String.valueOf(resultado));
                break;
            case "- Subtração":
                resultado = valor1 - valor2;
                resultadoTextField.setText(String.valueOf(resultado));
                break;
            case "/ Divisão":
                resultado = valor1 / valor2;
                resultadoTextField.setText(String.valueOf(resultado));
                break;
            case "* Multiplicação":
                resultado = valor1 * valor2;
                resultadoTextField.setText(String.valueOf(resultado));
                break;
            case "** Exponenciação":
                resultado = Math.pow(valor1, valor2);
                resultadoTextField.setText(String.valueOf(resultado));

                break;
            case "! Fatorial":
                int fatorial=Integer.parseInt(valor1TextField.getText());
                int b=1;
                for(int i=1;i<=fatorial;i++){
                    b = b*i;
                }                                
                resultadoTextField.setText(String.valueOf(b));
                break;
            case "% Porcentagem":
                resultado = valor1 / 100;
                resultadoTextField.setText(String.valueOf(resultado));
                break;
            case "_ Negativo":
                resultado = -valor1;
                resultadoTextField.setText(String.valueOf(resultado));
                break;

        }

    }
    @FXML
    public void botãoUsar() {
        String valorResultado;
        valorResultado = resultadoTextField.getText();
        valor1TextField.setText(valorResultado);
        valor2TextField.setText(valorResultado);
    }

    @FXML
    public void desabilitarTextField() {
        Operações operações = operaçõesComboBox.getSelectionModel().getSelectedItem();
        String ope = operações.getOperações();
        switch (ope) {
            case "+ Adição":
                valor2TextField.setEditable(true);
                break;
            case "- Subtração":
                valor2TextField.setEditable(true);
                break;
            case "/ Divisão":
                valor2TextField.setEditable(true);
                break;
            case "Multiplicação":
                valor2TextField.setEditable(true);
                break;
            case "** Exponenciação":
                valor2TextField.setEditable(true);
                break;
            case "! Fatorial":
                valor2TextField.setEditable(false);
                break;
            case "% Porcentagem":
                valor2TextField.setEditable(false);
                break;
            case "_ Negativo":
                valor2TextField.setEditable(false);
                break;

        }

    }
}
