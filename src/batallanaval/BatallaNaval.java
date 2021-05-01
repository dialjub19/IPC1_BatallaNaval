/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batallanaval;

import Clases.Menu;
import java.util.Scanner;

/**
 *
 * @author dialj
 */
public class BatallaNaval {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] nu = {1, 4, 2, 6, 8, 5, 3};

        for (int i = 0; i < nu.length - 1; i++) {
            for (int j = 0; j < nu.length - 1; j++) {
                if (nu[j] < nu[j + 1]) {
                    int aux = nu[j];
                    nu[j] = nu[j + 1];
                    nu[j + 1] = aux;
                }
            }
        }

        for (int i = 0; i < nu.length ; i++) {
            System.out.print(nu[i]);
            if (i < 3) {
                System.out.print("*" + nu[i]);
            }

        }

        // Menu miMenu = new Menu();
        //miMenu.menuPrincipal();
        /*String[][] matriz = new String[10][10];
        Scanner entrada = new Scanner(System.in);
        String blue="\033[34m";

        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + " ");
        }

        System.out.println(" ");
        for (int i = 0; i < 10; i++) {
            System.out.print((char) (i + 65) + " ");
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = "-";
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("posicion Inicial FILA: ");
        int x1 = entrada.nextInt();
        System.out.println("posicion Inicial COLUMNA: ");
        int y1 = entrada.nextInt();
        System.out.println("posicion Final FILA: ");
        int x2 = entrada.nextInt();
        System.out.println("posicion Final COLUMNA: ");
        int y2 = entrada.nextInt();

        int iteradorI = x1;
        int iteradorJ = y1;
        while (iteradorJ <= y2) {

            matriz[x1][y1] = "0";
            if (x2 == iteradorI) {
                matriz[x2][iteradorJ] = "0";
                iteradorJ++;
            }
            System.out.println(iteradorJ);

        }

        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + " ");
        }

        System.out.println(" ");
        for (int i = 0; i < 10; i++) {
            System.out.print((char) (i + 65) + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }*/
    }

}
