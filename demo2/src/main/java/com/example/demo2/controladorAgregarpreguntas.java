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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * <h3></h3>
 *
 * @descripción
 * @autor carlos ramirez
 **/
public class controladorAgregarpreguntas extends controladorCreacionPreguntas {
    @FXML
    Label labelcambiartitulo;
    @FXML
    Label labelcambiardescripcion;
    @FXML
    Button botonagregar;
    @FXML
    TableColumn columpreguntas;
    @FXML
    TableColumn columtiempo;
    @FXML
    TableColumn columpunteo;
    @FXML
    TableView tablapreguntas;
    @FXML
    Label idencuesta;
    @FXML
    Button botoneliminar;
    @FXML
    TextField txtnuevapregunta1;
    @FXML
    TextField txtnuevopunteo;
    @FXML
    TextField txtpreguntacorrecta;
    @FXML
    TextField txtpreguntaincorrecta1;
    @FXML
    TextField txtpreguntaincorrecta2;
    @FXML
    TextField txtpreguntaincorrecta3;
    @FXML
    ComboBox <String> texoxnuevotiempo;
    @FXML
    Label tiemposeleccionado;
    @FXML
    Button botonmodificar;
    @FXML
    Button salirpantalla;


    private ObservableList<pregunta> preguntas;
    private ObservableList<encuesta> encuestas;





    public void initialize() {
        preguntas = FXCollections.observableArrayList();
        this.tablapreguntas.setItems(preguntas);

        this.columpreguntas.setCellValueFactory(new PropertyValueFactory("pregunta"));
        this.columtiempo.setCellValueFactory(new PropertyValueFactory("Tiempolimite"));
        this.columpunteo.setCellValueFactory(new PropertyValueFactory("punteo"));

        ObservableList<String>list= FXCollections.observableArrayList("5","10","15","20");
        texoxnuevotiempo.setItems(list);



    }
    public void Selection(ActionEvent actionEvent){

        String s= texoxnuevotiempo.getSelectionModel().getSelectedItem().toString();
        tiemposeleccionado.setText(s);


    }

    public void recibetitulos(String texto, String texto2,int id) {
        labelcambiartitulo.setText(texto);
        labelcambiardescripcion.setText(texto2);
        idencuesta.setText(String.valueOf(id));



    }
    public void initAtributes(ObservableList<encuesta> encuestas) {
        this.encuestas=encuestas;

    }

    public void selec(ActionEvent actionEvent){
        FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/com/example/demo2/CreacionPreguntas.fxml"));


        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setHeaderText(null);
        alert2.setTitle("INIFIRMACION");
        alert2.setContentText("Podra modificar y agregar las pregunas en la siguiente ventana ");
        alert2.showAndWait();

        try {
            Parent root2 = loader4.load();

            controladorCreacionPreguntas controlador2 = loader4.getController();
            controlador2.initAtributtes(preguntas);

            controlador2.recibetitulos(idencuesta.getText());

            Scene scene=new Scene(root2);
            Stage stage3 = new Stage();
            stage3.initModality(Modality.APPLICATION_MODAL);
            stage3.setScene(scene);
            stage3.showAndWait();

             pregunta p= controlador2.getPregunta();

//

            if (p!=null){
                this.preguntas.add(p);
                this.tablapreguntas.refresh();
            }


        } catch (IOException a) {
            throw new RuntimeException(a);
        }

    }
    @FXML
    public void seleccionar1(MouseEvent event){

        pregunta e = (pregunta) this.tablapreguntas.getSelectionModel().getSelectedItem();

        if (e != null){
            this.txtnuevapregunta1.setText(e.getPregunta());
            this.txtnuevopunteo.setText(e.getPunteo()+"");
            this.txtpreguntacorrecta.setText(e.getRespuestacorrecta());
            this.txtpreguntaincorrecta1.setText(e.getRespuestaincorrecta1());
            this.txtpreguntaincorrecta2.setText(e.getRespuestaincorrecta2());
            this.txtpreguntaincorrecta3.setText(e.getRespuestaincorrecta3());
            this.tiemposeleccionado.setText(e.getTiempolimite());

        }

    }

    @FXML
    public void modificarpre(ActionEvent actionEvent){

        pregunta p = (pregunta) this.tablapreguntas.getSelectionModel().getSelectedItem();
        if (p == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Para modificar necesitas seleccionar una pregunta ");
            alert.showAndWait();

        }else {

            try {
                 int idpreguntas= Integer.parseInt(tiemposeleccionado.getText());
                String pregunta = this.txtnuevapregunta1.getText();
                int punteo = Integer.parseInt(this.txtnuevopunteo.getText());
                String correcta = this.txtpreguntacorrecta.getText();
                String incorrecta1 = this.txtpreguntaincorrecta1.getText();
                String incorrecta2 = this.txtpreguntaincorrecta2.getText();
                String incorrecta3 = this.txtpreguntaincorrecta3.getText();
                String tiempo = this.tiemposeleccionado.getText();

                pregunta aux= new pregunta(idpreguntas,pregunta,tiempo,punteo,correcta,incorrecta1,incorrecta2,incorrecta3);


                if (!this.preguntas.contains(aux)){
                    p.setPregunta(aux.getPregunta());
                    p.setPunteo(aux.punteo);
                    p.setTiempolimite(aux.getTiempolimite());
                    p.setPincuestionario(aux.getPincuestionario());
                    p.setRespuestacorrecta(aux.getRespuestacorrecta());
                    p.setRespuestaincorrecta1(aux.getRespuestaincorrecta1());
                    p.setRespuestaincorrecta2(aux.getRespuestaincorrecta2());
                    p.setRespuestaincorrecta3(aux.getRespuestaincorrecta3());

                    this.tablapreguntas.refresh();
                }

            }catch (NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Formato incorrecto ");
                alert.showAndWait();


            }


        }




    }


@FXML
    public void eliminar (ActionEvent event){
        pregunta     p= (pregunta) this.tablapreguntas.getSelectionModel().getSelectedItem();

   if (p==null){
       Alert alert = new Alert(Alert.AlertType.ERROR);
       alert.setHeaderText(null);
       alert.setTitle("Error");
       alert.setContentText("Debes seleccionar una pregunta para eliminar");
       alert.showAndWait();


    }else {
       this.preguntas.remove(p);
       this.tablapreguntas.refresh();
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setHeaderText(null);
       alert.setTitle("Error");
       alert.setContentText("La pregunta Fue eliminada");
       alert.showAndWait();

   }
}
@FXML
    private  void salira(){

        Stage stage =(Stage) this.botonagregar.getScene().getWindow();
        stage.close();


    }


}




  









