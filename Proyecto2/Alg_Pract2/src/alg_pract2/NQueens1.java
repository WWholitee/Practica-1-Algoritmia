package alg_pract2;

import javax.swing.JOptionPane;

public class NQueens1 {

    private int tamTablero;
    private int fReina = 0;
    private int cReina = 0;
    private boolean[][] solucion;
    private boolean resultat = false;
    private int numeroSoluciones = 0; // Variable para contar las soluciones encontradas

    public NQueens1(int dimension, int fila, int columna) {
        this.tamTablero = dimension;
        this.fReina = fila;
        this.cReina = columna;
    }

    public boolean[][] buscarSolucion() {
        Tauler tauler = new Tauler(tamTablero);
        tauler.setCasilla(this.fReina, this.cReina);
        numeroSoluciones = 0; // Reiniciamos el contador al buscar soluciones
        if (!resolucion(tauler, 0)) {
            System.out.println("No se ha encontrado ninguna solucion");
            JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna solucion");
        }
        return solucion;
    }

    public boolean resolucion(Tauler tauler, int columna) {
        if (columna == cReina) {
            columna++;
        }

        for (int i = 0; i < tamTablero; i++) {
            if (esSegura(tauler, i, columna)) {
                tauler.setCasilla(i, columna);
                if (columna < tamTablero - 1) {
                    if (columna + 1 == cReina && cReina < tamTablero - 1) {
                        resolucion(tauler, columna + 2);
                    } else {
                        resolucion(tauler, columna + 1);
                    }
                } else {
                    // Se ha encontrado una solución
                    numeroSoluciones++;
                    if (solucion == null) {
                        solucion = tauler.getMatriz();
                    }
                }
                tauler.vaciarCasilla(i, columna); // Backtracking
            }
        }
        return numeroSoluciones > 0;
    }

    private boolean esSegura(Tauler tauler, int fila, int columna) {
        int i, j;
        // Comprobar a la izquierda de la fila
        for (i = 0; i < columna; i++) {
            if (tauler.getCasella(fila, i)) {
                return false;
            }
        }
        // Comprobar a la derecha de la fila
        for (i = columna; i < tamTablero; i++) {
            if (tauler.getCasella(fila, i)) {
                return false;
            }
        }

        // Comprobar arriba de la casilla
        for (i = 0; i < fila; i++) {
            if (tauler.getCasella(i, columna)) {
                return false;
            }
        }
        // Comprobar abajo de la casilla
        for (i = fila; i < tamTablero; i++) {
            if (tauler.getCasella(i, columna)) {
                return false;
            }
        }

        // Comprobar diagonal superior izquierda
        for (i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
            if (tauler.getCasella(i, j)) {
                return false;
            }
        }
        // Comprobar diagonal inferior izquierda
        for (i = fila, j = columna; j >= 0 && i < tamTablero; i++, j--) {
            if (tauler.getCasella(i, j)) {
                return false;
            }
        }

        // Comprobar diagonal superior derecha
        for (i = fila, j = columna; i >= 0 && j < tamTablero; i--, j++) {
            if (tauler.getCasella(i, j)) {
                return false;
            }
        }
        // Comprobar diagonal inferior derecha
        for (i = fila, j = columna; j < tamTablero && i < tamTablero; i++, j++) {
            if (tauler.getCasella(i, j)) {
                return false;
            }
        }
        return true;
    }

    // Método para obtener el número total de soluciones
    public int getNumeroSoluciones() {
        return numeroSoluciones;
    }
}
