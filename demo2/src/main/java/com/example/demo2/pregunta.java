package com.example.demo2;

/**
 * <h3></h3>
 *
 * @descripción
 * @autor carlos ramirez
 **/
public class pregunta {

    int pincuestionario;
    String pregunta;
    String Tiempolimite;
    int punteo;

    String respuestacorrecta;
    String respuestaincorrecta1;
    String respuestaincorrecta2;
    String respuestaincorrecta3;

    public pregunta(int pincuestionario, String pregunta, String tiempo, int punteo, String respuestacorrecta, String respuestaincorrecta1, String respuestaincorrecta2, String respuestaincorrecta3) {
        this.pincuestionario= pincuestionario;
        this.pregunta = pregunta;
        this.Tiempolimite = tiempo;
        this.punteo = punteo;
        this.respuestacorrecta = respuestacorrecta;
        this.respuestaincorrecta1= respuestaincorrecta1;
        this.respuestaincorrecta2 = respuestaincorrecta2;
        this.respuestaincorrecta3 = respuestaincorrecta3;

    }

    public int getPincuestionario() {
        return pincuestionario;
    }

    public void setPincuestionario(int pincuestionario) {
        this.pincuestionario = pincuestionario;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getTiempolimite() {
        return Tiempolimite;
    }

    public void setTiempolimite(String tiempolimite) {
        Tiempolimite = tiempolimite;
    }

    public int getPunteo() {
        return punteo;
    }

    public void setPunteo(int punteo) {
        this.punteo = punteo;
    }

    public String getRespuestacorrecta() {
        return respuestacorrecta;
    }

    public void setRespuestacorrecta(String respuestacorrecta) {
        this.respuestacorrecta = respuestacorrecta;
    }

    public String getRespuestaincorrecta1() {
        return respuestaincorrecta1;
    }

    public void setRespuestaincorrecta1(String respuestaincorrecta1) {
        this.respuestaincorrecta1 = respuestaincorrecta1;
    }

    public String getRespuestaincorrecta2() {
        return respuestaincorrecta2;
    }

    public void setRespuestaincorrecta2(String respuestaincorrecta2) {
        this.respuestaincorrecta2 = respuestaincorrecta2;
    }

    public String getRespuestaincorrecta3() {
        return respuestaincorrecta3;
    }

    public void setRespuestaincorrecta3(String respuestaincorrecta3) {
        this.respuestaincorrecta3 = respuestaincorrecta3;
    }
}
