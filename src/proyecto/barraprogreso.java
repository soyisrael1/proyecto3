package proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

import java.awt.Toolkit;

import javax.swing.JProgressBar;

import javax.swing.JButton;

import java.awt.Font;

import java.awt.Color;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class barraprogreso {

	public JFrame frmBarraDeProgreso;

	private JProgressBar barraProgreso;

	String Correo = "";

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					barraprogreso window = new barraprogreso();

					window.frmBarraDeProgreso.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

	public barraprogreso() {

		initialize();
		start();

	}

	public void start() {

		Thread hilo = new Thread(new Runnable() {

			@Override

			public void run() {

				for (int i = 0; i <= 100; i++) {

					barraProgreso.setValue(i);

					try {

						Thread.sleep(10);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}

					if (i == 100) {

						cine cine = new cine();
						cine.frmLobby.setVisible(true);

						frmBarraDeProgreso.setVisible(false);

					}

				}

			}

		});

		hilo.start();

	}

	private void initialize() {

		frmBarraDeProgreso = new JFrame();
		frmBarraDeProgreso.setUndecorated(true);
		frmBarraDeProgreso.getContentPane().setBackground(Color.ORANGE);

		frmBarraDeProgreso
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Pictures\\GUAUAU.png"));

		frmBarraDeProgreso.setTitle("BARRA DE PROGRESO");

		frmBarraDeProgreso.setBounds(100, 100, 413, 66);

		frmBarraDeProgreso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frmBarraDeProgreso.getContentPane().setLayout(null);

		frmBarraDeProgreso.setLocationRelativeTo(null);

		barraProgreso = new JProgressBar();

		barraProgreso.setForeground(new Color(255, 0, 0));

		barraProgreso.setFont(new Font("Tahoma", Font.BOLD, 20));

		barraProgreso.setStringPainted(true);

		barraProgreso.setBounds(10, 10, 395, 47);

		frmBarraDeProgreso.getContentPane().add(barraProgreso);

	}
}
