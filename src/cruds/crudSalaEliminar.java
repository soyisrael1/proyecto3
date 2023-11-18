package cruds;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Datas.DataSala;
import Entidades.Sala;

public class crudSalaEliminar {

	public JFrame frmCrudSalaEliminar;
	private JTable tblSalas;
	private JScrollPane scrollPane;
	public ArrayList<Sala> listaSalas = new ArrayList<Sala>();
	public DefaultTableModel model= new DefaultTableModel();
	Sala x;
	ArrayList<Sala> lista;
	int fila = 0;
	int idSala = 0;
	private JButton btnEliminar;
	
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
	public crudSalaEliminar() {
		initialize();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudSalaEliminar = new JFrame();
		frmCrudSalaEliminar.setTitle("EliminarSala");
		frmCrudSalaEliminar.setBounds(100, 100, 842, 284);
		frmCrudSalaEliminar.setLocationRelativeTo(null);
		frmCrudSalaEliminar.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 531, 203);
		frmCrudSalaEliminar.getContentPane().add(scrollPane);
		
		tblSalas = new JTable();
		tblSalas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblSalas.getSelectedRow();
				x = lista.get(fila);
				
			}
		});
		model.addColumn("ID COM");
		  model.addColumn("USUARIO");
		  model.addColumn("PUBLICACION");
		  model.addColumn("TEXTO");
		  model.addColumn("FECHA");
		scrollPane.setViewportView(tblSalas);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int op = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar?", "Eliminar",
						JOptionPane.YES_NO_OPTION);
				System.out.print(op);
				if (op == 0) {

					if (x.EliminarSala()) {
						JOptionPane.showMessageDialog(null, "se elimino correctamente");
						actualizarTabla();
					} else {
						JOptionPane.showMessageDialog(null, "Error");
					}
				}
			}
		});
		btnEliminar.setBounds(551, 10, 267, 203);
		frmCrudSalaEliminar.getContentPane().add(btnEliminar);
	}
	public void limpiarFormulario() {
		
	}
}
