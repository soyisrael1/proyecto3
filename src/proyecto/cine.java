package proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.border.LineBorder;

import crudPelicula.crudPelicula;
import crudPelicula.crudPeliculaEliminar;
import crudPelicula.crudPeliculaVer;
import crudVenta.crudVenta;
import crudVenta.crudVentaEliminar;
import crudVenta.crudVentaVer;
import cruds.crudSala;
import cruds.crudSalaEliminar;
import cruds.crudSalaVer4;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;

public class cine {

	JFrame frmLobby;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cine window = new cine();
					window.frmLobby.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public cine() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLobby = new JFrame();
		frmLobby.getContentPane().setBackground(new Color(0, 0, 0));
		frmLobby.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\travi\\Downloads\\PROYECTVIC\\8.png"));
		frmLobby.setTitle("Lobby");
		
		frmLobby.setBounds(100, 100, 762, 472);
		frmLobby.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLobby.setLocationRelativeTo(null);
		frmLobby.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 55, 54);
		frmLobby.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 153), 3));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Amgel\\Downloads\\8.png"));
		lblNewLabel_1.setBounds(0, 0, 671, 54);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 153), 3));
		panel_1.setBackground(new Color(0, 0, 0,80));
		panel_1.setBounds(56, 0, 690, 54);
		frmLobby.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" No solo vendemos boleto vendemos una experiencia inolvidable");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(152, 5, 386, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_5_1 = new JLabel(" TICKET RAPTOR");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(0, 0, 125, 19);
		panel_1.add(lblNewLabel_5_1);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setForeground(new Color(255, 255, 255));
		menuBar_1.setBackground(new Color(255, 51, 0));
		menuBar_1.setBounds(0, 30, 690, 22);
		panel_1.add(menuBar_1);
		
		JMenu mnNewMenu_1 = new JMenu("PELICULAS");
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("VER");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudPeliculaVer pelicula = new crudPeliculaVer();
				pelicula.frmCrudPeliculaVer.setVisible(true);
			}
		});
		mntmNewMenuItem_4.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_4.setBackground(new Color(255, 51, 0));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("AÑADIR");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudPelicula pelicula = new crudPelicula();
				pelicula.frmCrudPelicula.setVisible(true);
			}
		});
		mntmNewMenuItem_6.setBackground(Color.RED);
		mntmNewMenuItem_6.setForeground(Color.WHITE);
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("ELIMINAR");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudPeliculaEliminar pelicula = new crudPeliculaEliminar();
				pelicula.frmCrudPeliculaEliminar.setVisible(true);
			}
		});
		mntmNewMenuItem_7.setBackground(Color.RED);
		mntmNewMenuItem_7.setForeground(Color.WHITE);
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu = new JMenu("VENTA");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar_1.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("VER");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudVentaVer venta = new crudVentaVer();
				venta.frmCrudVentasVer.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("AÑADIR");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudVenta venta = new crudVenta();
				venta.frmCrudVenta.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("ELIMINAR");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			crudVentaEliminar venta = new crudVentaEliminar();
			venta.frmCrudVentaEliminar.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("SALA");
		mnNewMenu_3.setBackground(new Color(255, 255, 255));
		mnNewMenu_3.setForeground(new Color(255, 255, 255));
		menuBar_1.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("AÑADIR/ACTUALIZAR SALA ");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudSala sala = new crudSala();
				sala.frmCrudSala.setVisible(true);
			}
		});
		mntmNewMenuItem_5.setBackground(Color.RED);
		mntmNewMenuItem_5.setForeground(Color.WHITE);
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("ELIMINAR SALA");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudSalaEliminar sala = new crudSalaEliminar();
				sala.frmCrudSalaEliminar.setVisible(true);
			}
		});
		mntmNewMenuItem_8.setBackground(Color.RED);
		mntmNewMenuItem_8.setForeground(Color.WHITE);
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("VER SALA");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudSalaVer4 sala = new crudSalaVer4();
				sala.frmCrudSalaVer.setVisible(true);
			}
		});
		mntmNewMenuItem_9.setBackground(Color.RED);
		mntmNewMenuItem_9.setForeground(Color.WHITE);
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Amgel\\Downloads\\rojo4.png"));
		lblNewLabel_6.setBounds(0, 0, 746, 433);
		frmLobby.getContentPane().add(lblNewLabel_6);
	}
}
