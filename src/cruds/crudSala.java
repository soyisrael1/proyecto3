package cruds;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Datas.DataSala;
import Entidades.Sala;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class crudSala {

	public JFrame frmCrudSala;
	private JTextField txtNumAsientos;
	private JTextField txtPantalla;
	private JTextField txtSonido;
	private JTextField txtNombre;
	private JTable tblSalas;
	private JScrollPane scrollPane;
	public ArrayList<Sala> listaSalas = new ArrayList<Sala>();
	public DefaultTableModel model= new DefaultTableModel();
	Sala x;
	ArrayList<Sala> lista;
	int fila = 0;
	int idSala = 0;
	private JLabel lblID;
	private JButton btnActualizar;
	
	public void actualizarTabla() {
		DataSala da = new DataSala();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		lista = da.SelectSala();
		for (Sala sala : lista) {
			Object o[] = new Object[5];
			o[0] = sala.getIdSala();
			o[1] = sala.getNumAsientos();
			o[2] = sala.getPantalla();
			o[3] = sala.getSonido();
			o[4] = sala.getNombre();
		
			
			model.addRow(o);

		}
		tblSalas.setModel(model);
	}
	/**
	 * Create the application.
	 */
	public crudSala() {
		initialize();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudSala = new JFrame();
		frmCrudSala.setBounds(100, 100, 704, 534);
		frmCrudSala.setLocationRelativeTo(null);
		frmCrudSala.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Num Asientos");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 39, 81, 31);
		frmCrudSala.getContentPane().add(lblNewLabel);
		
		txtNumAsientos = new JTextField();
		txtNumAsientos.setBounds(111, 45, 96, 19);
		frmCrudSala.getContentPane().add(txtNumAsientos);
		txtNumAsientos.setColumns(10);
		
		txtPantalla = new JTextField();
		txtPantalla.setColumns(10);
		txtPantalla.setBounds(111, 86, 96, 19);
		frmCrudSala.getContentPane().add(txtPantalla);
		
		JLabel lblPantalla = new JLabel("Pantalla");
		lblPantalla.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPantalla.setBounds(20, 80, 81, 31);
		frmCrudSala.getContentPane().add(lblPantalla);
		
		txtSonido = new JTextField();
		txtSonido.setColumns(10);
		txtSonido.setBounds(111, 121, 96, 19);
		frmCrudSala.getContentPane().add(txtSonido);
		
		JLabel lblSonido = new JLabel("Sonido");
		lblSonido.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSonido.setBounds(20, 115, 81, 31);
		frmCrudSala.getContentPane().add(lblSonido);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(111, 162, 96, 19);
		frmCrudSala.getContentPane().add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre.setBounds(20, 156, 81, 31);
		frmCrudSala.getContentPane().add(lblNombre);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(279, 39, 378, 436);
		frmCrudSala.getContentPane().add(scrollPane);
		
		tblSalas = new JTable();
		tblSalas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblSalas.getSelectedRow();
				x = lista.get(fila);
				lblID.setText("" + x.getIdSala());
				txtNumAsientos.setText(x.getNumAsientos());
				txtPantalla.setText(x.getPantalla());
				txtSonido.setText(x.getSonido());
				txtNombre.setText(x.getNombre());
			}
		});
		model.addColumn("ID COM");
		  model.addColumn("USUARIO");
		  model.addColumn("PUBLICACION");
		  model.addColumn("TEXTO");
		  model.addColumn("FECHA");
		scrollPane.setViewportView(tblSalas);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 10, 96, 25);
		frmCrudSala.getContentPane().add(lblNewLabel_1);
		
		lblID = new JLabel("0");
		lblID.setFont(new Font("Arial", Font.PLAIN, 15));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(111, 10, 96, 25);
		frmCrudSala.getContentPane().add(lblID);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Sala sala = new Sala();
				sala.setNumAsientos(txtNumAsientos.getText());
				sala.setPantalla(txtPantalla.getText());
				sala.setSonido(txtSonido.getText());
				sala.setNombre(txtNombre.getText());
				
				listaSalas.add(sala);
				actualizarTabla();
				limpiarFormulario();
				if (sala.insertarSala()) {
					JOptionPane.showMessageDialog(null, "Se inseto correctamente ");

				} else {
					JOptionPane.showMessageDialog(null, "ERRROR ");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "ERRROR ");
			}
			actualizarTabla();
			}
		});
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\Amgel\\Downloads\\descargar (1).png"));
		btnAgregar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		btnAgregar.setBounds(46, 209, 149, 125);
		frmCrudSala.getContentPane().add(btnAgregar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					x.setNumAsientos(txtNumAsientos.getText());
					x.setPantalla(txtPantalla.getText());
					x.setSonido(txtSonido.getText());
					x.setNombre(txtNombre.getText());
					
					if(x.actualizarSala()) {
						JOptionPane.showMessageDialog(null, "correcto");
						actualizarTabla();
						limpiarFormulario();
					}else {
						JOptionPane.showMessageDialog(null, "error");
					}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "error");
				}
			}
		});
		btnActualizar.setBounds(46, 344, 149, 125);
		frmCrudSala.getContentPane().add(btnActualizar);
	}
	public void limpiarFormulario() {
		
	}
}
