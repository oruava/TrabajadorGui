package org.example.Gui;
import org.example.Datos.Datos;
import org.example.Modelo.Trabajador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormularioDatos extends JFrame {

    private JTextField nombreTextField, apellidoTextField, rutTextField, isapreTextField, afpTextField, buscarRutTextField;

    public FormularioDatos() {
        // Configuración del JFrame
        setTitle("Formulario Datos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));


        JLabel nombreLabel = new JLabel("  Nombre:");
        nombreTextField = new JTextField();

        JLabel apellidoLabel = new JLabel("  Apellido:");
        apellidoTextField = new JTextField();

        JLabel rutLabel = new JLabel("  RUT:");
        rutTextField = new JTextField();

        JLabel isapreLabel = new JLabel("  ISAPRE:");
        isapreTextField = new JTextField();

        JLabel afpLabel = new JLabel("  AFP:");
        afpTextField = new JTextField();


        JLabel buscarRutLabel = new JLabel("  Buscar por RUT:");
        buscarRutTextField = new JTextField();
        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Datos.buscarTrabajadorPorRut(buscarRutTextField.getText());

            }
        });

        JButton guardarButton = new JButton("Guardar Datos");

        panel.add(nombreLabel);
        panel.add(nombreTextField);
        panel.add(apellidoLabel);
        panel.add(apellidoTextField);
        panel.add(rutLabel);
        panel.add(rutTextField);
        panel.add(isapreLabel);
        panel.add(isapreTextField);
        panel.add(afpLabel);
        panel.add(afpTextField);
        panel.add(buscarRutLabel);
        panel.add(buscarRutTextField);
        panel.add(buscarButton);
        panel.add(guardarButton);


        add(panel);

        setVisible(true);


        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Trabajador trabajador = new Trabajador();

                String nombre = nombreTextField.getText();
                trabajador.setNombre(nombre);

                String apellido = apellidoTextField.getText();
                trabajador.setApellido(apellido);

                String rut = rutTextField.getText();
                trabajador.setRut(rut);

                String isapre = isapreTextField.getText();
                trabajador.setIsapre(isapre);

                String afp = afpTextField.getText();
                trabajador.setAfp(afp);
                Datos.guardarDatosEnCSV(trabajador);
                nombreTextField.setText("");
                apellidoTextField.setText("");
                rutTextField.setText("");
                isapreTextField.setText("");
                afpTextField.setText("");
            }
        });
    }
}




