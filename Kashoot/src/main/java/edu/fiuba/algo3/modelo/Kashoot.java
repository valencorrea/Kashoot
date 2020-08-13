package edu.fiuba.algo3.modelo;

//import edu.fiuba.algo3.resources.*;
import edu.fiuba.algo3.modelo.modalidades.*;
import edu.fiuba.algo3.modelo.formatos.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.util.*;


public class Kashoot  {

    private int tamanio = 20;
    ModeloObservable modelo;
    private ArrayList<PreguntasYOpciones> preguntasYOpciones;

    public Kashoot(ArrayList<PreguntasYOpciones> unasPreguntasYOpciones){
        //NOS FALTA RECIBIR TMB LOS JUGADORES
        this.preguntasYOpciones = unasPreguntasYOpciones;
    }
    public VBox mostrarPregunta(){

        Opcion opcionCorrecta = new Opcion("holis soy correcta");
        Opcion opcionIncorrecta = new Opcion("yo soy incorrecta :c");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()),"una pregunta????????",respuestaCorrecta);

        var label = new Label(unaPregunta.getContenido());

        Button button = new Button();
        button.setText(opcionCorrecta.getContenido());
        button.setPrefSize(300, 100);

        Button button2 = new Button();
        button2.setText(opcionIncorrecta.getContenido());
        button2.setPrefSize(300, 100);

        StackPane layout = new StackPane();

        layout.getChildren().add(button);
        layout.getChildren().add(button2);

        HBox hbox = new HBox(button, button2);
        hbox.setSpacing(200);
        hbox.setAlignment(Pos.CENTER);

        VBox contenedorPrincipal = new VBox(label, hbox, new Label());
        contenedorPrincipal.setSpacing(100);
        contenedorPrincipal.setPadding(new Insets(20));

        return contenedorPrincipal;
    }
/*
    public void iniciar(){
        this.preguntasYOpciones = this.leerArchivo("archivo.txt");
    }

    private ArrayList<PreguntasYOpciones> leerArchivo(String nombreArchivo){
        ArrayList<PreguntasYOpciones> preguntasYOpciones = new ArrayList<PreguntasYOpciones>();
        Scanner input = new Scanner(new File(nombreArchivo));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
        }
        return preguntasYOpciones;
    }
*/
    private void inicializarModelo() {

        modelo = new ModeloObservable();
    }

    public ArrayList<Opcion> getOpciones() {// antes llamar a getpregunta
        PreguntasYOpciones preguntaYOpciones = this.preguntasYOpciones.get(preguntasYOpciones.size()-1);
        ArrayList<Opcion> opciones = preguntaYOpciones.getOpciones();
        this.preguntasYOpciones.remove(preguntasYOpciones.size()-1);
        return opciones;
    }

    public Pregunta getPregunta() {
        PreguntasYOpciones preguntaYOpciones = this.preguntasYOpciones.get(preguntasYOpciones.size()-1);
        Pregunta pregunta = preguntaYOpciones.getPregunta();
        return pregunta;
    }
}
