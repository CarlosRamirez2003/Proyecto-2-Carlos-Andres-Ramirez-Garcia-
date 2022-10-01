package com.example.demo2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * <h3></h3>
 *
 * @descripción
 * @autor carlos ramirez
 **/
public class controladorvistaagregar  extends controladorAgregarpreguntas {

    @FXML
    private TextField txttitulo2;
    @FXML
    private TextField txtdescripcion2;
    @FXML
    private Button botoncancelar;
    @FXML
    private Button botonsiguiente;
    @FXML
    private Label textoprueba;

    private encuesta encuesta;

    private ObservableList<encuesta> encuestas;


    public void initialize(){


    }
    @FXML
    public void initAtributes(ObservableList<encuesta> encuestas) {
        this.encuestas=encuestas;

    }
    @FXML
    public void guardar (ActionEvent event){

        String titulo = this.txttitulo2.getText();
        String descripcion = this.txtdescripcion2.getText();



        encuesta e =new encuesta(titulo,descripcion);


        if (!encuestas.contains(e)){
            this.encuesta =e;



            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("informacion");
            alert.setContentText("se ha añadido correctamente");
            alert.showAndWait();

            Stage stage =(Stage) this.botonsiguiente.getScene().getWindow();
            stage.close();



            //desplegando la ventanda para agregar preguntas

            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/com/example/demo2/agregarpreguntas.fxml"));


            Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
            alert3.setHeaderText(null);
            alert3.setTitle("INIFIRMACION");
            alert3.setContentText("Podra modificar y agregar las pregunas en la siguiente ventana ");
            alert3.showAndWait();

            try {
                Parent root = loader2.load();

                controladorAgregarpreguntas controlador = loader2.getController();
                controlador.initAtributes(encuestas);
                controlador.recibetitulos(titulo,descripcion,e.getPinpreguntas());



                Scene scene=new Scene(root);
                Stage stage2 = new Stage();
                stage2.initModality(Modality.APPLICATION_MODAL);
                stage2.setScene(scene);
                stage2.showAndWait();




            } catch (IOException a) {
                throw new RuntimeException(a);
            }






        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("informacion");
            alert.setContentText("existe una enceusta igual ");
            alert.showAndWait();


        }

    }
    @FXML
    private  void salir(){
        this.encuesta =null;

        Stage stage =(Stage) this.botonsiguiente.getScene().getWindow();
        stage.close();


    }
    @FXML


    public com.example.demo2.encuesta getEncuesta() {
        return encuesta;
    }
}
