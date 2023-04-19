package Presentacion.Turno.VAltaTurno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

public class VAltaTurno extends JFrame implements IGUI {
    public VAltaTurno() {
        super("Crear Turno");
        this.setBounds(100, 100, 430, 330);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initGUI();
    }

    private void initGUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.setContentPane(mainPanel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel msgIntroIDCabecera = ComponentsBuilder.createLabel(
                "Introduzca la información del turno que desea crear", 1, 10, 80, 20, Color.BLACK);
        msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
        mainPanel.add(msgIntroIDCabecera);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

        JPanel panelNombre = new JPanel();
        mainPanel.add(panelNombre);

        JLabel labelNombre = ComponentsBuilder.createLabel("Nombre del turno: ", 10, 100, 80, 20, Color.BLACK);
        panelNombre.add(labelNombre);

        JTextField nombre = new JTextField();
        nombre.setPreferredSize(new Dimension(250, 30));
        nombre.setEditable(true);
        panelNombre.add(nombre);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel panelFecha = new JPanel();
        mainPanel.add(panelFecha);

        JLabel labelFecha = ComponentsBuilder.createLabel("Fecha del turno: ", 10, 100, 80, 20, Color.BLACK);
        panelFecha.add(labelFecha);

        JTextField fecha = new JTextField();
        fecha.setPreferredSize(new Dimension(250, 30));
        fecha.setEditable(true);
        panelFecha.add(fecha);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel panelHora = new JPanel();
        mainPanel.add(panelHora);

        JLabel labelHora = ComponentsBuilder.createLabel("Hora del turno: ", 10, 100, 80, 20, Color.BLACK);
        panelHora.add(labelHora);

        JTextField hora = new JTextField();
        hora.setPreferredSize(new Dimension(250, 30));
        hora.setEditable(true);
        panelHora.add(hora);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

        JPanel panelBotones = new JPanel();
        mainPanel.add(panelBotones);

        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(75, 50, 100, 100);
        botonAceptar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VAltaTurno.this.setVisible(false);

               // Controlador.obtenerInstancia().run(new Turno(nombre.getText(), fecha.getText(), hora.getText()), Evento.EAltaTurnoOK);

            }
        });
        
        //TODO
        panelBotones.add(botonAceptar);

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(200, 50, 100, 100);
        //INCOMPLATA 
        panelBotones.add(botonCancelar);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        this.setVisible(true);
        
    }


	@Override
	public void actualizar(Object object, Evento event) {
		// TODO Auto-generated method stub
		
	}
}