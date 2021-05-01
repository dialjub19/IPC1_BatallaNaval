/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author dialj
 */
public class Jugador {

    private String nombre;
    private int vida;
    private int acierto;
    private int fallo;
    private String estado;
    private int tamanioMatriz;

    public Jugador(String nombre, int vida, int acierto, int fallo, String estado, int tamanioMatriz) {
        this.nombre = nombre;
        this.vida = vida;
        this.acierto = acierto;
        this.fallo = fallo;
        this.estado = estado;
        this.tamanioMatriz = tamanioMatriz;
    }

    public Jugador() {
        setNombre("");
        setVida(200);
        setAcierto(0);
        setFallo(0);
        setEstado("");
        setTamanioMatriz(0);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return the acierto
     */
    public int getAcierto() {
        return acierto;
    }

    /**
     * @param acierto the acierto to set
     */
    public void setAcierto(int acierto) {
        this.acierto = acierto;
    }

    /**
     * @return the fallo
     */
    public int getFallo() {
        return fallo;
    }

    /**
     * @param fallo the fallo to set
     */
    public void setFallo(int fallo) {
        this.fallo = fallo;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the tamanioMatriz
     */
    public int getTamanioMatriz() {
        return tamanioMatriz;
    }

    /**
     * @param tamanioMatriz the tamanioMatriz to set
     */
    public void setTamanioMatriz(int tamanioMatriz) {
        this.tamanioMatriz = tamanioMatriz;
    }

}
