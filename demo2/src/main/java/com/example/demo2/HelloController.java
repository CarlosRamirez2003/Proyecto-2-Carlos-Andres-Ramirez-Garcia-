package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {
    @FXML
    Button btnpreguntas;
    @FXML
    Button btnEncuestas;
    @FXML
    Pane panelrespuestas;
    @FXML
    Pane panelEncuestas;
    @FXML
    TableColumn columpin;
    @FXML
    TableColumn columtitulo;
    @FXML
    TableColumn columdescripcion;
    @FXML
    TableColumn columestado;
    @FXML
    TableView tablaencuestas;
    @FXML
    Label txtpinpreguntas;
    @FXML
    Label txtestado;

    @FXML
    Label txttitulo;

    @FXML
    Label txtdescripcion;

    @FXML
    Label txtpin;
    @FXML
    Button agregar;
    @FXML
    TableView tablapreguntasgenerales;
    @FXML
    TableColumn  clpreguntas;
    @FXML
    TableColumn  clpunteo;
    @FXML
    TableColumn  cltiempo;
    @FXML
    TableColumn  clcorrecta;
    @FXML
    TableColumn  clincorrecta1;
    @FXML
    TableColumn  clincorrecta2;
    @FXML
    TableColumn  clincorrecta3;




    public  ObservableList<encuesta>encuestas;
    public ObservableList<pregunta>preguntas;





    @FXML// cambiar pantalla
    public void onClic(ActionEvent actionEvent){
        if(actionEvent.getSource()==btnEncuestas){
            panelEncuestas.toFront();
        }
        if(actionEvent.getSource()==btnpreguntas){
            panelrespuestas.toFront();
        }


    }

    public HelloController() {
    }
    public void  initialize(){
    encuestas = FXCollections.observableArrayList();
        columtitulo.setCellValueFactory(new PropertyValueFactory<encuesta,Integer>("Titulo"));
        columdescripcion.setCellValueFactory(new PropertyValueFactory<encuesta,String>("descripcion"));
        columpin.setCellValueFactory(new PropertyValueFactory<encuesta,String>("pin"));
        columestado.setCellValueFactory(new PropertyValueFactory<encuesta,String>("estado"));

        preguntas = FXCollections.observableArrayList();



    }




    public void cambiarventana(ActionEvent actionEvent){//ventana agregar encuesta

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo2/vistaAgregar.fxml"));



        try {
            Parent root = loader.load();
            controladorvistaagregar controlador = loader.getController();
            controlador.initAtributes(encuestas);




            Scene scene1=new Scene(root);
            Stage stage1 = new Stage();
            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.setScene(scene1);
            stage1.showAndWait();
            encuesta e = controlador.getEncuesta();




            if (e!=null){
                this.encuestas.add(e);
                this.tablaencuestas.setItems(encuestas);

                this.tablaencuestas.refresh();

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
    @FXML
    private  void seleccionar (MouseEvent event){
        encuesta e = (encuesta) this.tablaencuestas.getSelectionModel().getSelectedItem();

        if (e !=null){
        this.txttitulo.setText(e.getTitulo());
        this.txtdescripcion.setText(e.getDescripcion());
        this.txtestado.setText(e.getEstado());
        this.txtpin.setText(e.getPin()+"");
        this.txtpinpreguntas.setText(e.getPinpreguntas()+"");

        }


    }
    @FXML
    private  void Activar(ActionEvent actionEvent){
        encuesta e = (encuesta) this.tablaencuestas.getSelectionModel().getSelectedItem();

        if(e== null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un cuestionario para activarlo");
            alert.showAndWait();



        } else if (e.getEstado()!="REGISTRADO") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("solo se pueden activar los Cuestionarios registradas ");
            alert.showAndWait();



        }else{

            int a = (int) (Math.random()*900000+100000);


            String nuevo_estado ="ACTIVADO";
            int nuevo_pin=a;
            String nuevotitulo="";
            String nuevadescripcion ="";

            encuesta aux= new encuesta(nuevotitulo,nuevadescripcion);

            e.setPin(nuevo_pin);
            e.setEstado(nuevo_estado);
            this.tablaencuestas.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("informacion");
            alert.setContentText("Cuestionario Activado ");
            alert.showAndWait();



        }

    }
    public void  clonar(ActionEvent actionEvent){
        encuesta e = (encuesta) this.tablaencuestas.getSelectionModel().getSelectedItem();


        if(e== null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un cuestionario para activarlo");
            alert.showAndWait();



        } else if (e.getEstado()!="ACTIVADO") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("solo se pueden activar los Cuestionarios Registrados ");
            alert.showAndWait();



        }else{

encuesta P = new encuesta(e.getTitulo(),e.getDescripcion());

            String nuevo_estado ="REGISTRADO";
            String nuevotitulo="";
            String nuevadescripcion ="";

            encuesta aux= new encuesta(nuevotitulo,nuevadescripcion);
            P.setTitulo(e.getTitulo());
            P.setEstado(nuevo_estado);
            P.setPin(e.getPin());
            P.setPinpreguntas(e.getPinpreguntas());
            P.setDescripcion(e.getDescripcion());

            this.encuestas.add(P);

            this.tablaencuestas.refresh();



            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("informacion");
            alert.setContentText("Cuestionario Clonado ");
            alert.showAndWait();



        }


    }
    public void selec(ActionEvent actionEvent){
        FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/com/example/demo2/CreacionPreguntas.fxml"));

        try {
            Parent root2 = loader4.load();

            controladorCreacionPreguntas controlador2 = loader4.getController();


            Scene scene=new Scene(root2);
            Stage stage3 = new Stage();
            stage3.initModality(Modality.APPLICATION_MODAL);
            stage3.setScene(scene);
            stage3.showAndWait();




        } catch (IOException a) {
            throw new RuntimeException(a);
        }







    }




    }











