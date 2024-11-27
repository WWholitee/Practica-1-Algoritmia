package practica1;

/**
 *
 * @author elena
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Practica1GUI extends JFrame {

    private ListaEstudiantes listaEstudiantes; // Lista enlazada de estudiantes
    private LlistaCurs listaCurso;

    public Practica1GUI() {

        listaEstudiantes = new ListaEstudiantes();
        listaCurso = new LlistaCurs();

        // Ventana principal
        setTitle("Gestió de les activitats d’un col.legi");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1));

        // Crear botones de menú
        JButton btnAlta = new JButton("Dar de alta un curso");
        JButton btnMatricularEstudiantes = new JButton("Matricular un estudiante en una asignatura");
        JButton btnBajaCurso = new JButton("Dar de baja un curso");
        JButton btnBajaAsignatura = new JButton("Dar de baja una asignatura");
        JButton btnImprimirCurso = new JButton("Imprimir asignaturas y estudiantes de un curso");
        JButton btnImprimirAsignatura = new JButton("Imprimir curso y estudiantes de una asignatura");
        JButton btnImprimirEstudiante = new JButton("Imprimir asignaturas y curso de un estudiante");
        JButton btnSalir = new JButton("Salir");

        // Agregar botones al JFrame
        add(btnAlta);
        add(btnMatricularEstudiantes);
        add(btnBajaCurso);
        add(btnBajaAsignatura);
        add(btnImprimirCurso);
        add(btnImprimirAsignatura);
        add(btnImprimirEstudiante);
        add(btnSalir);

        // Configurar acciones para los botones
        btnAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioAlta();
            }
        });

        btnMatricularEstudiantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioMatriculacion();
            }
        });

        btnBajaCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioBajaCurso();
            }
        });

        btnBajaAsignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioBajaAsignatura();
            }
        });

        btnImprimirCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImprimirCurso();
            }
        });

        btnImprimirAsignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImprimirAsignatura();
            }
        });

        btnImprimirEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImprimirEstudiante();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);

    }

    /**
     * Muestra el formulario para dar de alta un curso.
     */
    private void mostrarFormularioAlta() {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        // Campos de texto
        JTextField nombreCursoField = new JTextField(20);
        JTextField codigoCursoField = new JTextField(20);
        JTextField tipoCursoField = new JTextField(1);
        JTextField especialidadCursoField = new JTextField(20);

        panel.add(new JLabel("Nombre del curso:"));
        panel.add(nombreCursoField);
        panel.add(new JLabel("Código del curso:"));
        panel.add(codigoCursoField);
        panel.add(new JLabel("Tipo de curso (1: Bachillerato, 2: FP):"));
        panel.add(tipoCursoField);
        panel.add(new JLabel("Especialidad (si es FP) o curso (si es Bachillerato):"));
        panel.add(especialidadCursoField);

        // Mostrar el formulario para añadir un curso
        int option = JOptionPane.showConfirmDialog(this, panel, "Ingrese los detalles del curso", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String nombreCurso = nombreCursoField.getText().trim();
            String codigoCurso = codigoCursoField.getText().trim();
            int tipoCurso = Integer.parseInt(tipoCursoField.getText().trim());
            String especialidadCurso = especialidadCursoField.getText().trim();

            // Comprobar si ya existe un curso con el mismo código
            for (int i = 0; i < listaCurso.longitud(); i++) {
                Curso cursoExistente = listaCurso.getCurs(i);
                if (cursoExistente.getCodigo().equals(codigoCurso)) {
                    JOptionPane.showMessageDialog(this, "Ya existe un curso con ese código.");
                    return;
                }
            }

            // Crear el curso
            Curso nuevoCurso = null;
            if (tipoCurso == 1) {
                if (!especialidadCurso.equalsIgnoreCase("Primero") && !especialidadCurso.equalsIgnoreCase("Segundo")) {
                    JOptionPane.showMessageDialog(this, "Si es Bachillerato, la especialidad debe ser 'Primero' o 'Segundo'.");
                    return;
                }
                nuevoCurso = new Batxiller(nombreCurso, codigoCurso, especialidadCurso); // Bachillerato
            } else if (tipoCurso == 2) {
                if (!especialidadCurso.equalsIgnoreCase("Mecánica") && !especialidadCurso.equalsIgnoreCase("Electrónica") && !especialidadCurso.equalsIgnoreCase("Informática")) {
                    JOptionPane.showMessageDialog(this, "Si es FP, la especialidad debe ser 'Mecánica', 'Electrónica' o 'Informática'.");
                    return;
                }
                nuevoCurso = new FormacioProfessional(nombreCurso, codigoCurso, especialidadCurso); // FP
            } else {
                JOptionPane.showMessageDialog(this, "Tipo de curso no válido. Debe ser 1 (Bachillerato) o 2 (FP).");
                return;
            }

            // Preguntar cuántas asignaturas añadir
            String numAsignaturasStr = JOptionPane.showInputDialog(this, "¿Cuántas asignaturas quieres añadir?");
            int numAsignaturas = Integer.parseInt(numAsignaturasStr);

            for (int i = 0; i < numAsignaturas; i++) {
                // Panel para asignatura
                JPanel asignaturaPanel = new JPanel();
                asignaturaPanel.setLayout(new GridLayout(0, 2));

                JTextField nombreAsignaturaField = new JTextField(20);
                JTextField codigoAsignaturaField = new JTextField(20);
                JTextField creditosAsignaturaField = new JTextField(5);
                JTextField tipoAsignaturaField = new JTextField(1); // Para elegir T o P

                asignaturaPanel.add(new JLabel("Nombre de la asignatura:"));
                asignaturaPanel.add(nombreAsignaturaField);
                asignaturaPanel.add(new JLabel("Código de la asignatura:"));
                asignaturaPanel.add(codigoAsignaturaField);
                asignaturaPanel.add(new JLabel("Número de créditos:"));
                asignaturaPanel.add(creditosAsignaturaField);
                asignaturaPanel.add(new JLabel("Tipo de asignatura (T: Teórica, P: Práctica):"));
                asignaturaPanel.add(tipoAsignaturaField);

                int asignaturaOption = JOptionPane.showConfirmDialog(this, asignaturaPanel, "Ingrese los detalles de la asignatura", JOptionPane.OK_CANCEL_OPTION);

                if (asignaturaOption == JOptionPane.OK_OPTION) {
                    String nombreAsignatura = nombreAsignaturaField.getText().trim();
                    String codigoAsignatura = codigoAsignaturaField.getText().trim();
                    int creditosAsignatura = Integer.parseInt(creditosAsignaturaField.getText().trim());
                    String tipoAsignatura = tipoAsignaturaField.getText().trim().toUpperCase();

                    // Comprobar si el tipo es correcto
                    if (!tipoAsignatura.equals("T") && !tipoAsignatura.equals("P")) {
                        JOptionPane.showMessageDialog(this, "El tipo de asignatura debe ser 'T' (Teórica) o 'P' (Práctica).");
                        return;
                    }

                    // Comprobar si el código de la asignatura ya está en el curso
                    boolean codigoRepetido = false;
                    for (int j = 0; j < nuevoCurso.getLlistaAssignatura().longitud(); j++) {
                        Assignatura asignatura = nuevoCurso.getLlistaAssignatura().getObject(j);
                        if (asignatura.getIdentificador().equals(codigoAsignatura)) {
                            codigoRepetido = true;
                            break;
                        }
                    }

                    if (codigoRepetido) {
                        JOptionPane.showMessageDialog(this, "El código de la asignatura ya existe en este curso.");
                    } else {
                        // Crear la asignatura y añadirla al curso
                        Assignatura nuevaAsignatura = new AssignaturaOblig(nombreAsignatura, codigoAsignatura, creditosAsignatura, tipoAsignatura);
                        nuevoCurso.AddAssignatura(nuevaAsignatura); // Añadir asignatura al curso
                        nuevoCurso.Order(); // Ordenar las asignaturas
                    }
                }
            }

            // Mostrar la lista de asignaturas del curso
            JOptionPane.showMessageDialog(this, "Lista de asignaturas: " + nuevoCurso.StringAssignaturas());

            // Añadir el curso a la lista
            listaCurso.addObject(nuevoCurso);
        }
    }

    /**
     * Muestra el formulario para matricular un estudiante en una asignatura.
     */
    private void mostrarFormularioMatriculacion() {
        // Panel
        JPanel estudiantePanel = new JPanel();
        estudiantePanel.setLayout(new GridLayout(0, 2));

        JTextField nombreEstudianteField = new JTextField(20);
        JTextField dniEstudianteField = new JTextField(20);

        estudiantePanel.add(new JLabel("Nombre del estudiante:"));
        estudiantePanel.add(nombreEstudianteField);
        estudiantePanel.add(new JLabel("DNI del estudiante:"));
        estudiantePanel.add(dniEstudianteField);

        // Mostrar formulario
        int option = JOptionPane.showConfirmDialog(this, estudiantePanel, "Registrar Estudiante", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String nombreEstudiante = nombreEstudianteField.getText().trim();
            String dniEstudiante = dniEstudianteField.getText().trim();

            // Validar datos del estudiante
            if (nombreEstudiante.isEmpty() || dniEstudiante.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos del estudiante.");
                return;
            }

            // Comprobar si el estudiante ya existe en la lista
            Estudiantes estudianteExistente = null;
            for (int i = 0; i < listaEstudiantes.longitud(); i++) {
                Estudiantes estudiante = listaEstudiantes.getEstudiante(i);
                if (estudiante.getIdentificador().equals(dniEstudiante)) {
                    estudianteExistente = estudiante;
                    break;
                }
            }

            if (estudianteExistente == null) {
                // Si no existe, crear un nuevo estudiante
                estudianteExistente = new Estudiantes(nombreEstudiante, dniEstudiante);
                listaEstudiantes.addObject(estudianteExistente); // Añadir a la lista
                listaEstudiantes.Order(); // Ordenar los estudiantes
            }

            // Pedir el código del curso, nombre y código de la asignatura
            String codigoCurso = JOptionPane.showInputDialog(this, "Introduce el código del curso:");
            String nombreAsignatura = JOptionPane.showInputDialog(this, "Introduce el nombre de la asignatura:");
            String codigoAsignatura = JOptionPane.showInputDialog(this, "Introduce el código de la asignatura:");

            // Buscar el curso por código
            Curso cursoEncontrado = null;
            for (int i = 0; i < listaCurso.longitud(); i++) {
                Curso curso = listaCurso.getCurs(i);
                if (curso.getCodigo().equals(codigoCurso)) {
                    cursoEncontrado = curso;
                    break;
                }
            }

            if (cursoEncontrado == null) {
                JOptionPane.showMessageDialog(this, "Curso no encontrado.");
                return;
            }

            // Buscar la asignatura dentro del curso por código y nombre
            Assignatura asignaturaEncontrada = null;
            for (int i = 0; i < cursoEncontrado.getLlistaAssignatura().longitud(); i++) {
                Assignatura asignatura = cursoEncontrado.getLlistaAssignatura().getObject(i);
                if (asignatura.getIdentificador().equals(codigoAsignatura) && asignatura.getNombre_a().equals(nombreAsignatura)) {
                    asignaturaEncontrada = asignatura;
                    break;
                }
            }

            if (asignaturaEncontrada == null) {
                JOptionPane.showMessageDialog(this, "Asignatura no encontrada.");
                return;
            }

            // Matricular al estudiante en la asignatura
            estudianteExistente.matricularAsignatura(codigoAsignatura);

            // Mostrar mensaje de confirmación
            JOptionPane.showMessageDialog(this, "El estudiante " + estudianteExistente.getDescripcion() + " ha sido matriculado correctamente en la asignatura " + asignaturaEncontrada.getNombre_a() + ".");
        }
    }

    /**
     * Muestra el formulario para dar de baja un curso.
     */
    private void mostrarFormularioBajaCurso() {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JTextField nombreCursoField = new JTextField(20);
        panel.add(new JLabel("Introduce el nombre del curso a dar de baja:"));
        panel.add(nombreCursoField);

        // Mostrar el formulario
        int option = JOptionPane.showConfirmDialog(this, panel, "Dar de baja un curso", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String nombreCurso = nombreCursoField.getText().trim();

            if (nombreCurso.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre del curso.");
                return;
            }

            // Comprobar que la lista no esté vacía
            if (listaCurso.longitud() == 0) {
                JOptionPane.showMessageDialog(this, "No hay cursos disponibles.");
                return;
            }

            // Buscar el curso en la lista
            boolean encontrado = false;
            for (int i = 0; i < listaCurso.longitud(); i++) {
                Curso curso = listaCurso.getCurs(i);
                if (curso.getNombre().equalsIgnoreCase(nombreCurso)) {
                    encontrado = true;
                    // Eliminar el curso
                    listaCurso.EliminarElement(i);  // Eliminar el curso
                    JOptionPane.showMessageDialog(this, "Curso '" + nombreCurso + "' dado de baja correctamente.");
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "Curso no encontrado.");
            }
        }
    }

    /**
     * Método que elimina un curso de la lista.
     */
    private boolean eliminarCurso(String nombreCurso) {
        // Recorremos la lista de cursos usando longitud() para obtener la cantidad de cursos
        for (int i = 0; i < listaCurso.longitud(); i++) {
            // Obtenemos el curso en la posición 'i'
            Curso curso = listaCurso.getCurs(i);

            // Comprobamos si el nombre del curso coincide
            if (curso.getNombre().equalsIgnoreCase(nombreCurso)) {
                // Si encontramos el curso, lo eliminamos usando EliminarElement
                listaCurso.EliminarElement(i);
                return true;
            }
        }

        // Si no encontramos el curso
        return false;
    }

    private void mostrarFormularioBajaAsignatura() {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1)); // Disposición en tres filas

        JTextField nombreCursoField = new JTextField(20);
        JTextField nombreAsignaturaField = new JTextField(20);

        panel.add(new JLabel("Introduce el nombre del curso donde se encuentra la asignatura a dar de baja:"));
        panel.add(nombreCursoField);
        panel.add(new JLabel("Introduce el nombre de la asignatura a borrar:"));
        panel.add(nombreAsignaturaField);

        // Mostrar el formulario
        int option = JOptionPane.showConfirmDialog(this, panel, "Dar de baja una asignatura", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String cursoNombre = nombreCursoField.getText().trim();
            String asignaturaNombre = nombreAsignaturaField.getText().trim();

            if (cursoNombre.isEmpty() || asignaturaNombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa tanto el nombre del curso como de la asignatura.");
                return;
            }

            // Buscar el curso en la lista de cursos
            boolean cursoEncontrado = false;
            for (int i = 0; i < listaCurso.longitud(); i++) {
                Curso curso = listaCurso.getCurs(i);
                if (curso.getNombre().equalsIgnoreCase(cursoNombre)) {
                    cursoEncontrado = true;
                    // Buscar la asignatura dentro del curso y eliminarla
                    boolean asignaturaEliminada = false;
                    for (int j = 0; j < curso.getLlistaAssignatura().longitud(); j++) {
                        Assignatura asignatura = curso.getLlistaAssignatura().getObject(j);
                        if (asignatura.getNombre_a().equalsIgnoreCase(asignaturaNombre)) {
                            curso.getLlistaAssignatura().EliminarElement(j); // Eliminar asignatura
                            asignaturaEliminada = true;
                            break;
                        }
                    }

                    if (asignaturaEliminada) {
                        JOptionPane.showMessageDialog(this, "La asignatura '" + asignaturaNombre + "' ha sido eliminada del curso '" + cursoNombre + "'.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Asignatura no encontrada en el curso.");
                    }
                    break;
                }
            }

            if (!cursoEncontrado) {
                JOptionPane.showMessageDialog(this, "Curso no encontrado.");
            }
        }
    }

    private void ImprimirCurso() {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JTextField nombreCursoField = new JTextField(20);
        JTextField codigoCursoField = new JTextField(20);

        panel.add(new JLabel("Introduce el nombre del curso:"));
        panel.add(nombreCursoField);
        panel.add(new JLabel("Introduce el código del curso:"));
        panel.add(codigoCursoField);

        // Mostrar el formulario
        int option = JOptionPane.showConfirmDialog(this, panel, "Introduzca los datos del curso", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String nombreCurso = nombreCursoField.getText().trim();
            String codigoCurso = codigoCursoField.getText().trim();

            if (nombreCurso.isEmpty() || codigoCurso.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese tanto el nombre como el código del curso.");
                return;
            }

            // Buscar el curso en la lista
            boolean cursoEncontrado = false;
            for (int i = 0; i < listaCurso.longitud(); i++) {
                Curso curso = listaCurso.getCurs(i);

                // Comprobar si el curso coincide con el nombre y código
                if (curso.getNombre().equalsIgnoreCase(nombreCurso) && curso.getCodigo().equals(codigoCurso)) {
                    cursoEncontrado = true;

                    // Mostrar los detalles del curso
                    String cursoDetalles = "Curso: " + curso.getNombre() + " (" + curso.getCodigo() + ")";
                    StringBuilder detallesAsignaturas = new StringBuilder("Listado de Asignaturas del curso " + curso.getNombre() + " (" + curso.getCodigo() + "):\n");

                    // Imprimir las asignaturas y los estudiantes matriculados
                    for (int j = 0; j < curso.getLlistaAssignatura().longitud(); j++) {
                        Assignatura asignatura = curso.getLlistaAssignatura().getObject(j);
                        detallesAsignaturas.append(asignatura.toStringConDetalles()).append("\n");

                        // Mostrar los estudiantes matriculados en esta asignatura
                        ArrayList<String> estudiantesMatriculados = listaEstudiantes.BuscarAlumnes(asignatura.getIdentificador());

                        if (estudiantesMatriculados.isEmpty()) {
                            detallesAsignaturas.append("No hay estudiantes matriculados en esta asignatura.\n");
                        } else {
                            detallesAsignaturas.append("Estudiantes matriculados:\n");
                            for (String estudiante : estudiantesMatriculados) {
                                detallesAsignaturas.append(estudiante).append("\n");
                            }
                        }
                    }

                    // Mostrar los resultados en una ventana emergente
                    JOptionPane.showMessageDialog(this, cursoDetalles + "\n\n" + detallesAsignaturas.toString());
                    break;
                }
            }

            // Si no se encontró el curso
            if (!cursoEncontrado) {
                JOptionPane.showMessageDialog(this, "Curso no encontrado.");
            }
        }
    }

    private void ImprimirAsignatura() {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JTextField nombreAsignaturaField = new JTextField(20);
        JTextField codigoAsignaturaField = new JTextField(20);

        panel.add(new JLabel("Introduce el nombre de la asignatura:"));
        panel.add(nombreAsignaturaField);
        panel.add(new JLabel("Introduce el código de la asignatura:"));
        panel.add(codigoAsignaturaField);

        // Mostrar el formulario
        int option = JOptionPane.showConfirmDialog(this, panel, "Buscar Asignatura", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String nombreAsignatura = nombreAsignaturaField.getText().trim();
            String codigoAsignatura = codigoAsignaturaField.getText().trim();

            if (nombreAsignatura.isEmpty() || codigoAsignatura.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese tanto el nombre como el código de la asignatura.");
                return;
            }

            // Buscar la asignatura en todos los cursos de la lista
            boolean asignaturaEncontrada = false;
            for (int i = 0; i < listaCurso.longitud(); i++) {
                Curso curso = listaCurso.getCurs(i);
                if (curso.ExisteAssignatura(nombreAsignatura)) {
                    // Comprobar si el curso tiene una asignatura con el código proporcionado
                    Assignatura asignatura = curso.getAsignaturaPorCodigo(codigoAsignatura);

                    if (asignatura != null) {
                        asignaturaEncontrada = true;

                        // Mostrar los detalles del curso y la asignatura
                        String asignaturaDetalles = curso.toStringConDetalles(); // Detalles del curso
                        StringBuilder detallesEstudiantes = new StringBuilder("Estudiantes matriculados en esta asignatura:\n");

                        // Buscar los estudiantes matriculados en esta asignatura
                        ArrayList<String> estudiantesMatriculados = listaEstudiantes.BuscarAlumnes(codigoAsignatura);

                        if (estudiantesMatriculados.isEmpty()) {
                            detallesEstudiantes.append("No hay estudiantes matriculados en esta asignatura.\n");
                        } else {
                            detallesEstudiantes.append("Estudiantes matriculados:\n");
                            for (String estudiante : estudiantesMatriculados) {
                                detallesEstudiantes.append(estudiante).append("\n");
                            }
                        }

                        // Mostrar los resultados
                        JOptionPane.showMessageDialog(this, asignaturaDetalles + "\n\n" + detallesEstudiantes.toString());
                        break;
                    }
                }
            }

            if (!asignaturaEncontrada) {
                JOptionPane.showMessageDialog(this, "Asignatura no encontrada con el nombre y código proporcionado.");
            }
        }
    }

    private void ImprimirEstudiante() {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        JTextField nombreEstudianteField = new JTextField(20);
        panel.add(new JLabel("Introduce el nombre del estudiante:"));
        panel.add(nombreEstudianteField);

        // Mostrar el formulario 
        int option = JOptionPane.showConfirmDialog(this, panel, "Buscar Estudiante", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String nombreEstudiante = nombreEstudianteField.getText().trim();

            if (nombreEstudiante.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre del estudiante.");
                return;
            }

            // Buscar el estudiante en la lista de estudiantes
            boolean estudianteEncontrado = false;
            for (int i = 0; i < listaEstudiantes.longitud(); i++) {
                Estudiantes estudiante = listaEstudiantes.getEstudiante(i);

                // Comprobar si el nombre del estudiante coincide
                if (estudiante.getDescripcion().equalsIgnoreCase(nombreEstudiante)) {
                    estudianteEncontrado = true;

                    // Mostrar los detalles del estudiante
                    StringBuilder detallesEstudiante = new StringBuilder("Estudiante: " + estudiante.toString() + "\n");

                    // Mostrar las asignaturas matriculadas
                    detallesEstudiante.append("Asignaturas matriculadas:\n");
                    for (int j = 0; j < estudiante.getList().size(); j++) {
                        String codiAsignatura = estudiante.getAsignaturasMatriculadas(j);

                        // Buscar la asignatura en los cursos
                        for (int a = 0; a < listaCurso.longitud(); a++) {
                            Curso curso = listaCurso.getCurs(a);

                            for (int b = 0; b < curso.getLlistaAssignatura().longitud(); b++) {
                                Assignatura asignatura = curso.getLlistaAssignatura().getObject(b);

                                // Comparar el código de la asignatura
                                if (asignatura.compareCodi(codiAsignatura)) {
                                    // Mostrar los detalles del curso y asignatura
                                    detallesEstudiante.append(curso.toStringConDetalles()).append("\n");
                                    detallesEstudiante.append(asignatura.toStringConDetalles()).append("\n");
                                }
                            }
                        }
                    }

                    // Mostrar los resultados en una ventana emergente
                    JOptionPane.showMessageDialog(this, detallesEstudiante.toString());
                    break;
                }
            }

            if (!estudianteEncontrado) {
                // Si el estudiante no fue encontrado
                JOptionPane.showMessageDialog(this, "El estudiante no existe.");
            }
        }
    }

    public static void main(String[] args) {
        new Practica1GUI();
    }

}
