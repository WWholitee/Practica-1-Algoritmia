package alg_pract2;

import java.awt.*;
import javax.swing.*;

public class Tablero extends JPanel {

    private final int[][] tablero;
    private final int numeroSoluciones;
    private boolean inicializado = false;

    public Tablero(int[][] tablero, int numeroSoluciones) {
        this.tablero = tablero;
        this.numeroSoluciones = numeroSoluciones;

        // Configurar diseño
        if (tablero != null) {
            setLayout(new GridLayout(tablero.length, tablero.length));
            inicializarCasillas();
        } else {
            setLayout(new BorderLayout());
            mostrarSinSolucion();
        }
    }

    private void inicializarCasillas() {
        removeAll(); // Limpiar componentes previos
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                Casilla casilla;
                if (tablero[i][j] == 1) {
                    casilla = new Casilla("src/imagenes/queen.png");
                } else {
                    casilla = new Casilla("src/imagenes/none.png");
                }
                casilla.setBackground((i + j) % 2 == 0 ? new Color(227, 206, 167) : new Color(166, 126, 91));
                add(casilla);
            }
        }
        inicializado = true;
    }

    private void mostrarSinSolucion() {
        removeAll(); // Limpiar componentes previos
        JLabel etiqueta = new JLabel("No tiene solución", SwingConstants.CENTER);
        etiqueta.setFont(new Font("Arial", Font.ITALIC, 24));
        add(etiqueta, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Dibujar fondo
        if (!inicializado && tablero != null) {
            inicializarCasillas();
        }
    }
}
