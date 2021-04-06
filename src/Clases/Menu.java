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
        int opcion = 0;
        do {
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
        System.out.println("¡ Asignacion de Barcos exitosa !");
        //asignarBarcos(tablero2, jugadorDos[this.contadorJugador]);
        this.contadorJugador++;

        System.out.println("fin");

    }

    private void asignarBarcos(String[][] tablero, Jugador jugador) {

        Scanner entrada = new Scanner(System.in);
        int barco = 1;
        int numeroBarco = 1;
        boolean bandera = false;

        while (bandera == false) {
            if (barco == 1) {

                System.out.println("\nJugador " + jugador.getNombre() + " coloque 1 barco de 4 casillas ");
                System.out.println("Ingrese la Letra de la fila inicial ");
                String x1 = entrada.nextLine();
                int xInicio = caracter(x1);
                System.out.println("Ingrese el numero de la columna inicial ");
                int y1 = entrada.nextInt();
                int yInicio = numero(y1);
                entrada.nextLine();
                System.out.println("Ingrese la letra de la fila final ");
                String x2 = entrada.nextLine();
                int xFinal = caracter(x2);
                System.out.println("Ingrese el numero de la columna final ");
                int y2 = entrada.nextInt();
                int yFinal = numero(y2);
                entrada.nextLine();
                int numeroCasilla = 0;

                for (int i = xInicio; i <= xFinal; i++) {
                    for (int j = yInicio; j <= yFinal; j++) {
                        numeroCasilla++;
                        if (numeroCasilla <= 4) {
                            tablero[i][j] = "■";
                        } else {
                            System.out.println("¡ Barco excedio el tamaño, vuelva a ingresar las coordenadas !");
                            break;
                        }
                    }
                }

                if (numeroCasilla == 4) {
                    ubicarBarco(tablero);
                    System.out.println("\n¡ Barco ubicado exitosamente !");
                    barco++;
                } else {
                    bandera = false;
                    limpiarTablero(xInicio, xFinal, yInicio, yFinal, tablero);
                }

            } else if (barco == 2) {

                System.out.println("\nJugador " + jugador.getNombre() + " coloque 2 barcos de 3 casillas ");
                System.out.println("Ingrese la Letra de la fila inicial ");
                String x1 = entrada.nextLine();
                int xInicio = caracter(x1);
                System.out.println("Ingrese el numero de la columna inicial ");
                int y1 = entrada.nextInt();
                int yInicio = numero(y1);
                entrada.nextLine();
                System.out.println("Ingrese la letra de la fila final ");
                String x2 = entrada.nextLine();
                int xFinal = caracter(x2);
                System.out.println("Ingrese el numero de la columna final ");
                int y2 = entrada.nextInt();
                int yFinal = numero(y2);
                entrada.nextLine();
                int numeroCasilla = 0;

                for (int i = xInicio; i <= xFinal; i++) {
                    for (int j = yInicio; j <= yFinal; j++) {
                        numeroCasilla++;
                        if (numeroCasilla <= 3) {
                            if (!tablero[i][j].equals("■")) {
                                tablero[i][j] = "■";
                            } else {
                                System.out.println("¡ Casilla ocupada, vuelva a intentarlo !");
                                break;
                            }
                        } else {
                            System.out.println("¡ Barco excedio el tamaño, vuelva a ingresar las coordenadas !");
                            break;
                        }

                    }
                }
                numeroBarco++;

                if (numeroCasilla == 3) {
                    ubicarBarco(tablero);
                    System.out.println("\n¡ Barco ubicado exitosamente !");
                    if (numeroBarco == 3) {
                        barco++;
                    }
                } else {
                    numeroBarco--;
                    bandera = false;
                    limpiarTablero(xInicio, xFinal, yInicio, yFinal, tablero);
                }

            } else if (barco == 3) {

                System.out.println("\nJugador " + jugador.getNombre() + " coloque 3 barcos de 2 casillas ");
                System.out.println("Ingrese la Letra de la fila inicial ");
                String x1 = entrada.nextLine();
                int xInicio = caracter(x1);
                System.out.println("Ingrese el numero de la columna inicial ");
                int y1 = entrada.nextInt();
                int yInicio = numero(y1);
                entrada.nextLine();
                System.out.println("Ingrese la letra de la fila final ");
                String x2 = entrada.nextLine();
                int xFinal = caracter(x2);
                System.out.println("Ingrese el numero de la columna final ");
                int y2 = entrada.nextInt();
                int yFinal = numero(y2);
                entrada.nextLine();
                int numeroCasilla = 0;

                for (int i = xInicio; i <= xFinal; i++) {
                    for (int j = yInicio; j <= yFinal; j++) {
                        numeroCasilla++;
                        if (numeroCasilla <= 2) {
                            if (!tablero[i][j].equals("■")) {
                                tablero[i][j] = "■";
                            } else {
                                System.out.println("¡ Casilla ocupada, vuelva a intentarlo !");
                                break;
                            }
                        } else {
                            System.out.println("¡ Barco excedio el tamaño, vuelva a ingresar las coordenadas !");
                            break;
                        }
                    }
                }
                numeroBarco++;

                if (numeroCasilla == 2) {
                    ubicarBarco(tablero);
                    System.out.println("\n¡ Barco ubicado exitosamente !");
                    if (numeroBarco == 6) {
                        barco++;
                    }
                } else {
                    numeroBarco--;
                    bandera = false;
                    limpiarTablero(xInicio, xFinal, yInicio, yFinal, tablero);
                }

            } else if (barco == 4) {

                System.out.println("\nJugador " + jugador.getNombre() + " coloque 4 barcos de 1 casillas ");
                System.out.println("Ingrese la Letra de la fila  ");
                String x1 = entrada.nextLine();
                int xInicio = caracter(x1);
                System.out.println("Ingrese el numero de la columna  ");
                int y1 = entrada.nextInt();
                int yInicio = numero(y1);
                entrada.nextLine();
                int numeroCasilla = 0;

                for (int i = xInicio; i <= xInicio; i++) {
                    for (int j = yInicio; j <= yInicio; j++) {
                        numeroCasilla++;
                        if (numeroCasilla == 1) {
                            if (!tablero[i][j].equals("■")) {
                                tablero[i][j] = "■";
                            } else {
                                System.out.println("¡ Casilla ocupada, vuelva a intentarlo !");
                                break;
                            }
                        } else {
                            System.out.println("¡ Barco excedio el tamaño, vuelva a ingresar las coordenadas !");
                            break;
                        }
                    }
                }
                numeroBarco++;

                if (numeroCasilla == 1) {
                    ubicarBarco(tablero);
                    System.out.println("\n¡ Barco ubicado exitosamente !");
                    if (numeroBarco == 10) {
                        bandera = true;
                    }
                } else {
                    numeroBarco--;
                    bandera = false;
                    limpiarTablero(xInicio, xInicio, yInicio, yInicio, tablero);
                }
            }
        }
    }

    private int validarNumero() {

        Scanner entrada = new Scanner(System.in);

        int dato = entrada.nextInt();
        while (dato < 0 || dato > 26) {
            dato = entrada.nextInt();
        }
        return dato;
    }

    private void limpiarTablero(int xInicio, int xFinal, int yInicio, int yFinal, String[][] tablero) {

        for (int i = xInicio; i <= xFinal; i++) {
            for (int j = yInicio; j <= yFinal; j++) {
                tablero[i][j] = "-";
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
                return 9;
            case "K":
                return 10;
            case "L":
                return 11;
            case "M":
                return 12;
            case "N":
                return 13;
            case "O":
                return 14;
            case "P":
                return 15;
            case "Q":
                return 16;
            case "R":
                return 17;
            case "S":
                return 18;
            case "T":
                return 19;
            case "U":
                return 20;
            case "V":
                return 21;
            case "W":
                return 22;
            case "X":
                return 23;
            case "Y":
                return 24;
            case "Z":
                return 25;
            default:
                System.out.println("Incorrecto, dato no existe...");
        }
        return 0;
    }

    private int numero(int numero) {

        switch (numero) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 9;
            case 11:
                return 10;
            case 12:
                return 11;
            case 13:
                return 12;
            case 14:
                return 13;
            case 15:
                return 14;
            case 16:
                return 15;
            case 17:
                return 16;
            case 18:
                return 17;
            case 19:
                return 18;
            case 20:
                return 19;
            case 21:
                return 20;
            case 22:
                return 21;
            case 23:
                return 22;
            case 24:
                return 23;
            case 25:
                return 24;
            case 26:
                return 25;
            default:
                System.out.println("Incorrecto, dato no existe...");
        }
        return 0;
    }

    private void datos() {
        System.out.println("\nDiego Alejandro Juarez Bran.");
        System.out.println("201700770.");
        System.out.println("IPC1-C.");
        System.out.println("Ing. Moises Velasquez.\n");
    }

    private void salir() {
        System.out.println("Gracias por jugar Batalla Naval, hasta pronto.....");
        System.exit(0);
    }

}
