/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Scanner;

/**
 *
 * @author dialj
 */
public class Menu {

    public static String[][] tablero1;
    public static String[][] tablero2;
    public static Jugador[] jugadorUno;
    public static Jugador[] jugadorDos;
    private int contadorJugador;

    public Menu() {
        this.jugadorUno = new Jugador[100];
        this.jugadorDos = new Jugador[100];
        this.contadorJugador = 0;
    }

    public void menuPrincipal() {
        System.out.println("^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-");
        System.out.println("-^-^-^-^-^-^-^-^-^-^ BIENVENIDO A LA BATALLA NAVAL ^-^-^-^-^-^-^-^-^-^");
        System.out.println("1.Jugar.");
        System.out.println("2.Historial de partidas.");
        System.out.println("3.Mostrar puntuaciones más altas.");
        System.out.println("4.Mostrar jugadores con mayor cantidad de fallos.");
        System.out.println("5.Mostrar jugadores con mayor cantidad de aciertos.");
        System.out.println("6.Mostrar Top 3 de Jugadores que más han ganado.");
        System.out.println("7.Mostrar información de estudiante.");
        System.out.println("8.Salir");
        System.out.println("^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-");
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("Ingrese una opcion : ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    jugar();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    datos();
                    break;
                case 8:
                    salir();
                    break;
                default:
                    System.out.println("Opcion invalida, vuelva a intentarlo");
                    menuPrincipal();
            }

        } while (opcion >= 1 && opcion <= 8);
    }

    private void jugar() {

        Scanner entrada = new Scanner(System.in);
        int tamanioMatriz = 0;

        try {

            while ((tamanioMatriz < 10) || (tamanioMatriz > 25)) {
                System.out.println("Ingrese el tamaño del tablero(10 - 25) : ");
                tamanioMatriz = entrada.nextInt();
                if ((tamanioMatriz < 10) || (tamanioMatriz > 25)) {
                    System.out.println("Tamaño incorrecto, vuelva a ingresar el tamaño de la matriz \n");
                }
            }
            tablero1 = new String[tamanioMatriz][tamanioMatriz];
            tablero2 = new String[tamanioMatriz][tamanioMatriz];

        } catch (Exception w) {
            System.out.println("Opcion invalida, intentelo de nuevo...");
        }

        entrada.nextLine();
        System.out.println("Ingrese en nombre del Jugador 1 : ");
        String jugador1 = entrada.nextLine().trim();
        System.out.println("Ingrese en nombre del Jugador 2 : ");
        String jugador2 = entrada.nextLine().trim();

        jugadorUno[this.contadorJugador] = new Jugador(jugador1, 200, 0, 0, "");
        jugadorDos[this.contadorJugador] = new Jugador(jugador2, 200, 0, 0, "");

        dibujarMatriz(tablero1);
        asignarBarcos(tablero1, jugadorUno[this.contadorJugador]);
        asignarBarcos(tablero2, jugadorDos[this.contadorJugador]);
        this.contadorJugador++;
        
        System.out.println("fin");

    }

    private void asignarBarcos(String[][] tablero, Jugador jugador) {

        Scanner entrada = new Scanner(System.in);
        int barco = 1;
        boolean bandera = false;

        while (bandera == false) {
            if (barco == 1) {

                System.out.println("Jugador " + jugador.getNombre() + " coloque 1 barco de 4 casillas ");
                System.out.println("Ingrese la Letra de la fila inicial ");
                String x1 = entrada.nextLine();
                int xInicio = caracter(x1);
                System.out.println("Ingrese el numero de la columna inicial ");
                int yInicio = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Ingrese la letra de la fila final ");
                String x2 = entrada.nextLine();
                int xFinal = caracter(x2);
                System.out.println("Ingrese el numero de la columna final ");
                int yFinal = entrada.nextInt();
                entrada.nextLine();

                for (int i = xInicio; i <= xFinal; i++) {
                    for (int j = yInicio; j <= yFinal; j++) {
                        if (!tablero[i][j].equals("■")) {
                            tablero[i][j] = "■";
                        }
                    }
                }
                System.out.println("¡ Barco ubicado exitosamente !");
                ubicarBarco(tablero);
                barco++;

            } else if (barco == 2) {

                System.out.println("Jugador " + jugador.getNombre() + " coloque 2 barcos de 3 casillas ");
                System.out.println("Ingrese la Letra de la fila inicial ");
                String x1 = entrada.nextLine();
                int xInicio = caracter(x1);
                System.out.println("Ingrese el numero de la columna inicial ");
                int yInicio = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Ingrese la letra de la fila final ");
                String x2 = entrada.nextLine();
                int xFinal = caracter(x2);
                System.out.println("Ingrese el numero de la columna final ");
                int yFinal = entrada.nextInt();
                entrada.nextLine();
                int contador = 1;

                for (int i = xInicio; i <= xFinal; i++) {
                    for (int j = yInicio; j <= yFinal; j++) {
                        if (!tablero[i][j].equals("■")) {
                            tablero[i][j] = "■";
                            contador++;
                        } else {
                            System.out.println("ocupado, vuelva a intentarlo");
                            bandera = false;
                        }
                    }
                }
                System.out.println("¡ Barco ubicado exitosamente !");
                ubicarBarco(tablero);
                if (contador == 2) {
                    barco++;
                }
            } else if (barco == 3) {

                System.out.println("Jugador " + jugador.getNombre() + " coloque 3 barcos de 2 casillas ");
                System.out.println("Ingrese la Letra de la fila inicial ");
                String x1 = entrada.nextLine();
                int xInicio = caracter(x1);
                System.out.println("Ingrese el numero de la columna inicial ");
                int yInicio = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Ingrese la letra de la fila final ");
                String x2 = entrada.nextLine();
                int xFinal = caracter(x2);
                System.out.println("Ingrese el numero de la columna final ");
                int yFinal = entrada.nextInt();
                entrada.nextLine();
                int contador = 1;

                for (int i = xInicio; i <= xFinal; i++) {
                    for (int j = yInicio; j <= yFinal; j++) {
                        if (!tablero[i][j].equals("■")) {
                            tablero[i][j] = "■";
                            contador++;
                        } else {
                            System.out.println("ocupado, vuelva a intentarlo");
                            bandera = false;
                        }
                    }
                }
                System.out.println("¡ Barco ubicado exitosamente !");
                ubicarBarco(tablero);
                if (contador == 3) {
                    barco++;
                }

            } else if (barco == 4) {

                System.out.println("Jugador " + jugador.getNombre() + " coloque 4 barcos de 1 casillas ");
                System.out.println("Ingrese la Letra de la fila inicial ");
                String x1 = entrada.nextLine();
                int xInicio = caracter(x1);
                System.out.println("Ingrese el numero de la columna inicial ");
                int yInicio = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Ingrese la letra de la fila final ");
                String x2 = entrada.nextLine();
                int xFinal = caracter(x2);
                System.out.println("Ingrese el numero de la columna final ");
                int yFinal = entrada.nextInt();
                entrada.nextLine();
                int contador = 1;

                for (int i = xInicio; i <= xFinal; i++) {
                    for (int j = yInicio; j <= yFinal; j++) {
                        if (!tablero[i][j].equals("■")) {
                            tablero[i][j] = "■";
                            contador++;
                        } else {
                            System.out.println("ocupado, vuelva a intentarlo");
                            bandera = false;
                        }
                    }
                }
                System.out.println("¡ Barco ubicado exitosamente !");
                ubicarBarco(tablero);
                if (contador == 4) {
                    break;
                }
            }
        }
    }

    private void ubicarBarco(String[][] tablero) {

        System.out.print("  ");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((i + 1) + " ");
        }

        System.out.println(" ");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((char) (i + 65) + " ");
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }

    }

    private void dibujarMatriz(String[][] tablero) {

        System.out.print("  ");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((i + 1) + " ");
        }

        System.out.println(" ");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((char) (i + 65) + " ");
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = "-";
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }

    }

    private int caracter(String letra) {

        switch (letra.toUpperCase()) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 6;
            case "H":
                return 7;
            case "I":
                return 8;
            case "J":
                return 8;
            case "K":
                return 9;
            case "L":
                return 10;
            case "M":
                return 11;
            case "N":
                return 12;
            case "O":
                return 13;
            case "P":
                return 14;
            case "Q":
                return 15;
            case "R":
                return 16;
            case "S":
                return 17;
            case "T":
                return 18;
            case "U":
                return 19;
            case "V":
                return 20;
            case "W":
                return 21;
            case "X":
                return 22;
            case "Y":
                return 23;
            case "Z":
                return 24;
            default:
                System.out.println("Incorrecto, dato no existe...");
        }
        return 0;
    }

    private void datos() {
        System.out.println("Diego Alejandro Juarez Bran.");
        System.out.println("201700770.");
        System.out.println("IPC1-C.");
        System.out.println("Ing. Moises Velasquez.");
    }

    private void salir() {
        System.exit(0);
    }
}
