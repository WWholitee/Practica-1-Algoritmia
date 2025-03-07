package alg_pract2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * @author ellen
 */
public class Alg_Pract2 extends JFrame implements ActionListener {

    private Tablero tablero[];
    private int numSoluciones;
    private JButton btn_anterior;
    private JButton btn_siguiente;
    private JPanel contenedor;
    private JPanel jPanel1;
    private JLabel lbl_numSoluciones; // Etiqueta para el número total de soluciones
    private int cont = 0;
    private boolean finIncio;
    private int tamTablero;

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alg_Pract2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Alg_Pract2();
        });
    }

    public Alg_Pract2() {
        switch (seleccionarPrograma()) {
            case "Opción 1":
                VentanaReina grf = new VentanaReina();
                lecturaDatosIniciales();
                grf.inicializa(tamTablero);
                break;
            case "Opción 2":
                NqueensAllSolutions();
                break;
            default:
                throw new AssertionError();
        }
    }

    private void NqueensAllSolutions() {
        this.finIncio = false;
        while (!finIncio) {
            lecturaDatosIniciales();
        }
        getAllTableros();

        setTitle("PRACTICA 2 - BACKTRACKING");
        initComponents();

        // Inicializar la etiqueta para mostrar el número de soluciones
        lbl_numSoluciones = new JLabel("Número total de soluciones: " + this.numSoluciones);
        lbl_numSoluciones.setFont(new Font("Tahoma", Font.BOLD, 14));
        jPanel1.add(lbl_numSoluciones, BorderLayout.NORTH); // Agregar la etiqueta al panel
        jPanel1.validate();

        this.setLocationRelativeTo(null);
        btn_anterior.addActionListener(this);
        btn_siguiente.addActionListener(this);
        contenedor.add(tablero[0]);
        deshabilitarBoton();
        setVisible(true);
    }

    private String seleccionarPrograma() {
        Object seleccion = JOptionPane.showInputDialog(
                this,
                "Opción 1: Problema 3\nOpción 2: Problema 4",
                "Seleccione opcion",
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Opción 1", "Opción 2"},
                "opcion 1");
        System.out.println("El usuario ha elegido " + seleccion);
        return (String) seleccion;
    }

    private void lecturaDatosIniciales() {
        String[] datosVentana = {"Tamaño del tablero: "};
        try {
            datosVentana = new lecturaDatos(this, datosVentana, "Escriba un tamaño para el tablero", true).getDatosTexto();
            if (!datosVentana[0].isEmpty()) {
                tamTablero = Integer.parseInt(datosVentana[0]);
                if (tamTablero == 2 || tamTablero == 3) {
                    JOptionPane.showMessageDialog(this, "Para el tamaño " + tamTablero + " no existe solución posible.");
                    return;
                }
            } else {
                tamTablero = 4;
            }
            this.finIncio = true;
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private void getAllTableros() {
        NQueens2 q = new NQueens2(tamTablero);
        q.inicio();
        this.numSoluciones = q.getAccount();
        this.tablero = new Tablero[this.numSoluciones];
        ArrayList aux = q.getSoluciones();
        int n = q.getN();
        int indice = 0;
        int[][] tableroaux = null;
        boolean inicio = true;
        int fila = 0, columna = 0;
        for (int i = 0; i < aux.size(); i++) {
            if (i % (n * n) == 0) {
                if (!inicio && indice <= q.getAccount()) {
                    this.tablero[indice++] = new Tablero(tableroaux, q.getAccount());
                }
                if (tableroaux != null) {
                    inicio = true;
                }
                tableroaux = new int[n][n];
                fila = 0;
                columna = 0;
            }
            if (i % n == 0) {
                columna = 0;
                if (!inicio) {
                    fila++;
                }
                inicio = false;
            }
            tableroaux[fila][columna++] = (int) aux.get(i);
        }
        this.tablero[indice] = new Tablero(tableroaux, q.getAccount());
    }

    private void deshabilitarBoton() {
        if (tablero[0].isVisible()) {
            btn_siguiente.setEnabled(true);
            btn_anterior.setEnabled(false);
        } else if (tablero[tablero.length - 1].isVisible()) {
            btn_anterior.setEnabled(true);
            btn_siguiente.setEnabled(false);
        } else {
            btn_anterior.setEnabled(true);
            btn_siguiente.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        contenedor = new JPanel();
        jPanel1 = new JPanel();
        btn_anterior = new JButton();
        btn_siguiente = new JButton();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(744, 523));
        contenedor.setLayout(new BorderLayout());
        btn_anterior.setFont(new Font("Tahoma", 1, 14));
        btn_anterior.setIcon(new ImageIcon(getClass().getResource("/imagenes/previous.png")));
        btn_anterior.setText("Anterior");
        jPanel1.add(btn_anterior);
        btn_siguiente.setFont(new Font("Tahoma", 1, 14));
        btn_siguiente.setIcon(new ImageIcon(getClass().getResource("/imagenes/next.png")));
        btn_siguiente.setText("Siguiente");
        btn_siguiente.setHorizontalTextPosition(SwingConstants.LEFT);
        jPanel1.add(btn_siguiente);
        contenedor.add(jPanel1, BorderLayout.SOUTH);
        getContentPane().add(contenedor, BorderLayout.CENTER);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evt = ae.getSource();
        if (evt.equals(btn_anterior)) {
            cont--;
            contenedor.add(tablero[cont]);
            tablero[cont].setVisible(true);
            for (int i = 0; i < tablero.length; i++) {
                if (i != cont) {
                    tablero[i].setVisible(false);
                }
            }
            contenedor.validate();
            deshabilitarBoton();

        } else if (evt.equals(btn_siguiente)) {
            cont++;
            contenedor.add(tablero[cont]);
            tablero[cont].setVisible(true);
            for (int i = 0; i < tablero.length; i++) {
                if (i != cont) {
                    tablero[i].setVisible(false);
                }
            }
            contenedor.validate();
            deshabilitarBoton();
        }
        contenedor.repaint();
    }
}
