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

    // Variables locales
    public static String[][] tablero1;
    public static String[][] tablero2;
    public static Jugador[] jugadorUno;
    public static Jugador[] jugadorDos;
    private int contadorJugador;
    private final String formatear = "\033[37m";
    private final String azul = "\033[34m";
    private final String rojo = "\033[31m";

    // Metodo constructor.
    public Menu() {
        this.jugadorUno = new Jugador[100];
        this.jugadorDos = new Jugador[100];
        this.contadorJugador = 0;
    }

    
    // Metodo con el cual se empieza la ejecucion del programa, este contiene el menu principal y dependiendo la opcion nos llevara a una accion determinada.
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
                    historialPartida();
                    break;
                case 3:
                    puntuacionAlta();
                    break;
                case 4:
                    mayorFallo();
                    break;
                case 5:
                    mayorAcierto();
                    break;
                case 6:
                    puntuacionAlta();
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

    
    /* Metodo que por medio del metodo burbuja ordena de forma ascendente y por medio de la puntuacion mas alta a los jugadores de cada
    partida jugada para posteriomente mostrar a los mejores 3 jugadores.
   */
    private void puntuacionAlta() {

        System.out.println("-.-.-.-.-.-.-.-..- REPORTE DE PUNTUACION MAS ALTA -.-.-.-.-.-.-.-..-");
        if (jugadorUno[0] == null && jugadorDos[0] == null) {
            System.out.println(" ¡ AUN NO HAY PARTIDAS JUGADAS !\n");
        } else {
            for (int i = 0; i < this.contadorJugador; i++) {
                for (int j = 0; j < this.contadorJugador; j++) {
                    if (jugadorUno[j].getVida() < jugadorUno[j + 1].getVida()) {
                        int aux = jugadorUno[j].getVida();
                        jugadorUno[j].setVida(jugadorUno[j + 1].getVida());
                        jugadorUno[j + 1].setVida(aux);
                    }

                    if (jugadorDos[j].getVida() < jugadorDos[j + 1].getVida()) {
                        int aux = jugadorDos[j].getVida();
                        jugadorDos[j].setVida(jugadorDos[j + 1].getVida());
                        jugadorDos[j + 1].setVida(aux);
                    }

                }
            }

            System.out.println("\n-.-.-.-.-.-.-.-..- MEJORES 3 JUGADORES -.-.-.-.-.-.-.-..-");
            for (int i = 0; i < this.contadorJugador; i++) {
                if (i < 3 && (jugadorUno[i].getEstado().equals("Ganador") || jugadorDos[i].getEstado().equals("Ganador"))) {
                    if (jugadorUno[i].getEstado().equals("Ganador")) {
                        System.out.println("Nombre : " + jugadorUno[i].getNombre());
                        System.out.println("Puntos : " + jugadorUno[i].getVida());
                    } else {
                        System.out.println("Nombre : " + jugadorDos[i].getNombre());
                        System.out.println("Puntos : " + jugadorDos[i].getVida());

                    }
                }
            }
        }
    }

    
    /* Metodo que por medio del metodo burbuja ordena de forma ascendente y por medio del numero de fallos a los jugadores de cada
    partida jugada para posteriomente mostrar a los primero 3 jugadores con mayores numero de fallos en cada partida.
   */
    private void mayorFallo() {

        System.out.println("-.-.-.-.-.-.-.-..- REPORTE DE MAYOR CANTIDAD DE FALLOS -.-.-.-.-.-.-.-..-");
        if (jugadorUno[0] == null && jugadorDos[0] == null) {
            System.out.println(" ¡ AUN NO HAY PARTIDAS JUGADAS !\n");
        } else {
            for (int i = 0; i < this.contadorJugador; i++) {
                for (int j = 0; j < this.contadorJugador; j++) {
                    if (jugadorUno[j].getFallo() < jugadorUno[j + 1].getFallo()) {
                        int aux = jugadorUno[j].getFallo();
                        jugadorUno[j].setFallo(jugadorUno[j + 1].getFallo());
                        jugadorUno[j + 1].setFallo(aux);
                    }

                    if (jugadorDos[j].getFallo() < jugadorDos[j + 1].getFallo()) {
                        int aux = jugadorDos[j].getFallo();
                        jugadorDos[j].setFallo(jugadorDos[j + 1].getFallo());
                        jugadorDos[j + 1].setFallo(aux);
                    }

                }
            }

            System.out.println("\n-.-.-.-.-.-.-.-..- FALLO DE LOS 3 JUGADORES -.-.-.-.-.-.-.-..-");
            for (int i = 0; i < this.contadorJugador; i++) {
                if (i < 3 && (jugadorUno[i].getEstado().equals("Perdedor") || jugadorDos[i].getEstado().equals("Perdedor"))) {
                    if (jugadorUno[i].getEstado().equals("Perdedor")) {
                        System.out.println("Nombre : " + jugadorUno[i].getNombre());
                        System.out.println("Puntos : " + jugadorUno[i].getFallo());
                    } else {
                        System.out.println("Nombre : " + jugadorDos[i].getNombre());
                        System.out.println("Puntos : " + jugadorDos[i].getFallo());

                    }
                }
            }
        }
    }

    /* Metodo que por medio del metodo burbuja ordena de forma ascendente y por medio del numero de aciertos a los jugadores de cada
    partida jugada para posteriomente mostrar a los primero 3 jugadores con mayores aciertos en cada partida.
   */
    private void mayorAcierto() {

        System.out.println("-.-.-.-.-.-.-.-..- REPORTE DE MAYOR CANTIDAD DE ACIERTOS -.-.-.-.-.-.-.-..-");
        if (jugadorUno[0] == null && jugadorDos[0] == null) {
            System.out.println(" ¡ AUN NO HAY PARTIDAS JUGADAS !\n");
        } else {
            for (int i = 0; i < this.contadorJugador; i++) {
                for (int j = 0; j < this.contadorJugador; j++) {
                    if (jugadorUno[j].getAcierto() < jugadorUno[j + 1].getAcierto()) {
                        int aux = jugadorUno[j].getAcierto();
                        jugadorUno[j].setAcierto(jugadorUno[j + 1].getAcierto());
                        jugadorUno[j + 1].setAcierto(aux);
                    }

                    if (jugadorDos[j].getAcierto() < jugadorDos[j + 1].getAcierto()) {
                        int aux = jugadorDos[j].getAcierto();
                        jugadorDos[j].setAcierto(jugadorDos[j + 1].getAcierto());
                        jugadorDos[j + 1].setAcierto(aux);
                    }

                }
            }

            System.out.println("\n-.-.-.-.-.-.-.-..- ACIERTO DE LOS 3 JUGADORES -.-.-.-.-.-.-.-..-");
            for (int i = 0; i < this.contadorJugador; i++) {
                if (i < 3 && (jugadorUno[i].getEstado().equals("Ganador") || jugadorDos[i].getEstado().equals("Ganador"))) {
                    if (jugadorUno[i].getEstado().equals("Ganador")) {
                        System.out.println("Nombre : " + jugadorUno[i].getNombre());
                        System.out.println("Puntos : " + jugadorUno[i].getAcierto());
                    } else {
                        System.out.println("Nombre : " + jugadorDos[i].getNombre());
                        System.out.println("Puntos : " + jugadorDos[i].getAcierto());

                    }
                }
            }
        }
    }

    // Metodo utilizado para mostrar el historial de partidas que se realizaron durante la ejecucion del programa.
    private void historialPartida() {

        System.out.println("----------------------- HISTORIAL DE PARTIDAS REALIZADAS -----------------------");
        if (jugadorUno[0] == null && jugadorDos[0] == null) {
            System.out.println("¡ AUN NO HAY PARTIDAS JUGADAS !\n");
        } else {
            for (int i = 0; i < this.contadorJugador; i++) {
                System.out.println("Partida #" + (i + 1));
                System.out.println("Tamaño del Tablero : " + jugadorUno[i].getTamanioMatriz());
                System.out.println("-.-.-.-.-.-.-. Jugador #1 -.-.-.-.-.-.-.");
                System.out.println("Nombre : " + jugadorUno[i].getNombre());
                System.out.println("Puntos : " + jugadorUno[i].getVida());
                System.out.println("Aciertos : " + jugadorUno[i].getAcierto());
                System.out.println("Fallos : " + jugadorUno[i].getFallo());
                System.out.println(" " + jugadorUno[i].getEstado());
                System.out.println("-.-.-.-.-.-.-. Jugador #2 -.-.-.-.-.-.-.");
                System.out.println("Nombre : " + jugadorDos[i].getNombre());
                System.out.println("Puntos : " + jugadorDos[i].getVida());
                System.out.println("Aciertos : " + jugadorDos[i].getAcierto());
                System.out.println("Fallos : " + jugadorDos[i].getFallo());
                System.out.println(" " + jugadorDos[i].getEstado());
            }
        }
    }

    /* Metodo en el cual al iniciar el juego se solicita el tamaño del trablero asi como los nombre de cada jugador que ira a participar 
    en la batalla, posteriormente se asignaran los barcos y por el ultimo aleatoreamente se eligira al jugado el cual atacara primero.
     */
    private void jugar() {

        Scanner entrada = new Scanner(System.in);
        int numeroAleatorio = (int) (Math.random() * (2));
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
        System.out.println("Ingrese en nombre del Jugador 2 : \n");
        String jugador2 = entrada.nextLine().trim();

        jugadorUno[this.contadorJugador] = new Jugador(jugador1, 200, 0, 0, "", tamanioMatriz);
        jugadorDos[this.contadorJugador] = new Jugador(jugador2, 200, 0, 0, "", tamanioMatriz);

        dibujarMatriz(tablero1);
        asignarBarcos(tablero1, jugadorUno[this.contadorJugador]);
        System.out.println("\n ¡ Asignacion de Barcos exitosa !");
        dibujarMatriz(tablero2);
        asignarBarcos(tablero2, jugadorDos[this.contadorJugador]);
        System.out.println("\n ¡ Asignacion de Barcos exitosa !");

        Jugador uno = jugadorUno[this.contadorJugador];
        Jugador dos = jugadorDos[this.contadorJugador];

        this.contadorJugador++;

        if (numeroAleatorio == 1) {
            batallaNaval(uno, dos, tamanioMatriz, tablero1, tablero2);
        } else {
            batallaNaval(dos, uno, tamanioMatriz, tablero2, tablero1);
        }

    }

    /* Metodo utilizado para implementar toda la logica al asignar los barcos en el tablero, se lleva un contador de casillas el cual se aumenta
    cada vez que un barco es asignado exitosamente en caso contrario solo se pide de nuevo las coordenadas hasta que sean correctas, tenemos un contador 
    barco el cual nos sirve para llevar un control de que tamaño de barco es el que debemos ubicar y por ultimo todo esta dentro de un bucle while 
    el cual se ejecutara hasta que se ubique el ultimo barco.
   */
    private void asignarBarcos(String[][] tablero, Jugador jugador) {

        Scanner entrada = new Scanner(System.in);
        int barco = 1;
        int numeroBarco = 1;
        boolean bandera = false;

        while (bandera == false) {
            if (barco == 1) {

                System.out.println("------------------- ASIGNACION DE BARCOS --------------------------");
                System.out.println("\nJugador " + jugador.getNombre() + " coloque 1 barco de 4 casillas ");
                System.out.println("Ingrese la Letra de la fila inicial ");
                String x1 = entrada.nextLine().trim();
                int xInicio = caracter(x1);
                System.out.println("Ingrese el numero de la columna inicial ");
                int y1 = entrada.nextInt();
                int yInicio = numero(y1);
                entrada.nextLine();
                System.out.println("Ingrese la letra de la fila final ");
                String x2 = entrada.nextLine().trim();
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
                String x1 = entrada.nextLine().trim();
                int xInicio = caracter(x1);
                System.out.println("Ingrese el numero de la columna inicial ");
                int y1 = entrada.nextInt();
                int yInicio = numero(y1);
                entrada.nextLine();
                System.out.println("Ingrese la letra de la fila final ");
                String x2 = entrada.nextLine().trim();
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
                String x1 = entrada.nextLine().trim();
                int xInicio = caracter(x1);
                System.out.println("Ingrese el numero de la columna inicial ");
                int y1 = entrada.nextInt();
                int yInicio = numero(y1);
                entrada.nextLine();
                System.out.println("Ingrese la letra de la fila final ");
                String x2 = entrada.nextLine().trim();
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
                String x1 = entrada.nextLine().trim();
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

    /* Metodo que contiene toda la logica del programa, en esta parte del codigo el jugador podra realizar los ataques al jugador
    contrario, se implemento un contador para saber cuando unos de los dos jugadores destruyo todos los barcos del jugador contrario,
    se utilizaron 2 tableros auxiliares los cuales su funcion es solo reflejar por medio de una "X" o "O" si el disparo fue acertado o si fallo respectivamente,
    asi mismo se tienen varios contadores para los aciertos, fallos y la vida de cada jugador esto nos ayudara para los reportes que se solicitan.
    */
    private void batallaNaval(Jugador uno, Jugador dos, int tamanioMatriz, String[][] tablero1, String[][] tablero2) {

        Scanner entrada = new Scanner(System.in);
        String[][] aux1 = new String[tamanioMatriz][tamanioMatriz];
        String[][] aux2 = new String[tamanioMatriz][tamanioMatriz];
        boolean fin = true;
        int contadorFalloUno = 0;
        int contadorAciertoUno = 0;
        int barcoDestruidoUno = 20;
        int contadorFalloDos = 0;
        int contadorAciertoDos = 0;
        int barcoDestruidoDos = 20;
        int vidaUno = uno.getVida();
        int vidaDos = dos.getVida();

        while (fin == true) {

            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°BATALLA NAVAL INICIADA°°°°°°°°°°°°°°°°°°°°°°°°°°°°\n");
            System.out.println("Jugador 1 " + uno.getNombre());
            System.out.println("Puntos : " + uno.getVida());
            System.out.println("Aciertos : " + uno.getAcierto());
            System.out.println("Fallos : " + uno.getFallo());
            ubicarBarco(tablero1);
            dibujarMatriz(aux2);

            System.out.println("Jugador " + uno.getNombre() + " ingrese la fila a atacar");
            String x1 = entrada.nextLine();
            int xInicio = caracter(x1);
            System.out.println("Jugador " + uno.getNombre() + " ingrese la columna a atacar");
            int y1 = entrada.nextInt();
            int yInicio = numero(y1);
            entrada.nextLine();

            for (int i = xInicio; i <= xInicio; i++) {
                for (int j = yInicio; j <= yInicio; j++) {
                    if (tablero2[i][j].equals("■")) {
                        aux2[i][j] = azul + "X";
                        System.out.println(formatear + " ");
                        System.out.println("¡ Ataque Realizado exitosamente !");
                        vidaUno = vidaUno + 50;
                        uno.setVida(vidaUno);
                        contadorAciertoUno++;
                        uno.setAcierto(contadorAciertoUno);
                        barcoDestruidoUno--;
                    } else {
                        aux2[i][j] = rojo + "O";
                        System.out.println(formatear + " ");
                        System.out.println("¡ Ataque no fue exitoso, vuelva a intentarlo !");
                        vidaUno = vidaUno - 5;
                        uno.setVida(vidaUno);
                        contadorFalloUno++;
                        uno.setFallo(contadorFalloUno);
                    }
                }
            }

            if (barcoDestruidoUno == 0) {
                System.out.println("¡ Felicidades " + uno.getNombre() + " a ganado la batalla naval !\n");
                uno.setEstado("Ganador");
                fin = false;
                break;
            }

        }

    }

    // Metodo utilizado para limpiar el tablero cuando se envie una coordenada mala o bien este ocupada esta casilla.
    private void limpiarTablero(int xInicio, int xFinal, int yInicio, int yFinal, String[][] tablero) {

        for (int i = xInicio; i <= xFinal; i++) {
            for (int j = yInicio; j <= yFinal; j++) {
                tablero[i][j] = "-";
            }
        }

    }

    // Metodo que solo ubica los barcos que el usuario ingresa.
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

    // Metodo que dibuja la matriz al inicio del juego y tambien cuando estamos batallando.
    private void dibujarMatriz(String[][] tablero) {

        System.out.print("  ");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((i + 1) + " ");
        }

        System.out.println(" ");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((char) (i + 65) + " ");
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == null) {
                    tablero[i][j] = "-";
                    System.out.print(tablero[i][j] + " ");

                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

    // Metodo utilizado para ubicar las columnas, dependiendo de la letra que se ingrese se retornara la columna en numero.
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

    // Metodo utilizado para ubicar las filas en el tablero, enviando un numero y retornando otro.
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
    
    // Metodo que muestra los datos del estudiante.
    private void datos() {
        System.out.println("\nDiego Alejandro Juarez Bran.");
        System.out.println("201700770.");
        System.out.println("IPC1-C.");
        System.out.println("Ing. Moises Velasquez.\n");
    }

    // Metodo para terminar la ejecucion del programa.
    private void salir() {
        System.out.println("Gracias por jugar Batalla Naval, hasta pronto.....");
        System.exit(0);
    }

}
