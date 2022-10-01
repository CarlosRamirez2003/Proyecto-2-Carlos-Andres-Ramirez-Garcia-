package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * <h3></h3>
 *
 * @descripción
 * @autor carlos ramirez
 **/
public class controladorCreacionPreguntas   {
  @FXML
  ComboBox<String>textoxtiempo;
  @FXML
  Label pueba;
  @FXML
  TextField txtpregunta;
  @FXML
  TextField  txtputeo;
  @FXML
  TextField  txtcorrecta;
  @FXML
  TextField  txtincorrecta1;
  @FXML
  TextField  txtincorrecta2;
  @FXML
  TextField  txtincorrecta3;
  @FXML
  Button guardarpregunta;
  @FXML
  Label pinpreguntas;
  private pregunta pregunta;

  private ObservableList<pregunta>preguntas;
  private  ObservableList<pregunta>preguntasgenerales;




@FXML
  public void Select(ActionEvent actionEvent){

    String s= textoxtiempo.getSelectionModel().getSelectedItem().toString();
      pueba.setText(s);


  }
@FXML
    public void initialize(){
      ObservableList<String>list= FXCollections.observableArrayList("5","10","15","20");
      textoxtiempo.setItems(list);

    }

    public void initAtributtes(ObservableList<pregunta>preguntas){
    this.preguntas= preguntas;
    }

    public void initAtributtes2(ObservableList<pregunta>preguntasgenerales){
        this.preguntasgenerales= preguntasgenerales;
    }

    public void recibetitulos(String pin ) {
        pinpreguntas.setText(pin);


    }



    @FXML
  public void  guardar (ActionEvent actionEvent){


try {


    int pincuestionario = Integer.parseInt(String.valueOf(pinpreguntas.getText()));
    String pregunta1 = this.txtpregunta.getText();
    String tiempo2 = this.pueba.getText();
    int puntos = Integer.parseInt(txtputeo.getText());
    String respuestacorrecta = this.txtcorrecta.getText();
    String respuestaincorrecta1 = this.txtincorrecta1.getText();
    String respuestaincorrecta2 = this.txtincorrecta2.getText();
    String respuestaincorrecta3 = this.txtincorrecta3.getText();

    pregunta p = new pregunta(pincuestionario, pregunta1, tiempo2, puntos, respuestacorrecta, respuestaincorrecta1, respuestaincorrecta2, respuestaincorrecta3);
    if (!preguntas.contains(p)) {
        this.pregunta = p;


        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setHeaderText(null);
        alert2.setTitle("INIFIRMACION");
        alert2.setContentText(" pregunta guardada ");
        alert2.showAndWait();

        Stage stage = (Stage) this.guardarpregunta.getScene().getWindow();
        stage.close();

    } else {
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setHeaderText(null);
        alert2.setTitle("INIFIRMACION");
        alert2.setContentText("ya existe ");
        alert2.showAndWait();

        Stage stage = (Stage) this.guardarpregunta.getScene().getWindow();
        stage.close();


    }
}catch (NumberFormatException E){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setHeaderText(null);
    alert.setTitle("Error");
    alert.setContentText("Formato incorrecto ");
    alert.showAndWait();
}


    }

  public com.example.demo2.pregunta getPregunta() {
    return pregunta;
  }
}
