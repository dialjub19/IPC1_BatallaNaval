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
public class Tablero {
    
    
    private int tamanio;
    private String figura;

    public Tablero(int tamanio, String figura) {
        this.tamanio = tamanio;
        this.figura = figura;
    }

    public void dibujarTablero(String[][] tablero1) {

        System.out.print("  ");
        for (int i = 0; i < tablero1.length; i++) {
            System.out.print((i + 1) + " ");
        }

        System.out.println(" ");
        for (int i = 0; i < tablero1.length; i++) {
            System.out.print((char) (i + 65) + " ");
            for (int j = 0; j < tablero1.length; j++) {
                tablero1[i][j] = "-";
                System.out.print(tablero1[i][j] + " ");
            }
            System.out.println();
        }

    }
    
    
    /**
     * @return the tamanio
     */
    public int getTamanio() {
        return tamanio;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    /**
     * @return the figura
     */
    public String getFigura() {
        return figura;
    }

    /**
     * @param figura the figura to set
     */
    public void setFigura(String figura) {
        this.figura = figura;
    }
    
    
    
    
}
