package crudVenta;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Datas.DataSala;
import Datas.DataTicket;
import Entidades.Sala;
import Entidades.Ticket;

public class crudVentaEliminar {

	public JFrame frmCrudVentaEliminar;
	private JTable tblVenta;
	private JScrollPane scrollPane;
	public ArrayList<Ticket> listaTickets = new ArrayList<Ticket>();
	public DefaultTableModel model= new DefaultTableModel();
	Ticket x;
	ArrayList<Ticket> lista;
	int fila = 0;
	int idTi = 0;
	private JButton btnEliminar;

	 public void actualizarTabla() {
		 DataTicket da = new DataTicket();
		 
		  while (model.getRowCount()>0) { 
		   model.removeRow(0);
		   }
		   lista = da.SelectTicket();
		   for (Ticket u : lista) {
		    Object o[]=new Object[7];
		    o[0]=u.getIdTi();
		    o[1]=u.getIdSala();
		    o[2]=u.getIdPeli();
		    o[3]=u.getFecha();
		    o[4]=u.getCosto();
		    o[5]=u.getTipo();
		    o[6]=u.getCantidad();
		    
		    model.addRow(o);
		   }
		   tblVenta.setModel(model);
		 }
	
	/**
	 * Create the application.
	 */
	public crudVentaEliminar() {
		initialize();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudVentaEliminar = new JFrame();
		frmCrudVentaEliminar.setTitle("EliminarVenta");
		frmCrudVentaEliminar.setBounds(100, 100, 842, 284);
		frmCrudVentaEliminar.setLocationRelativeTo(null);
		frmCrudVentaEliminar.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 531, 203);
		frmCrudVentaEliminar.getContentPane().add(scrollPane);
		
		tblVenta = new JTable();
		tblVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblVenta.getSelectedRow();
				x = lista.get(fila);
				
			}
		});
		 model.addColumn("ID TI");
		  model.addColumn("ID SALA");
		  model.addColumn("ID PELICULA");
		  model.addColumn("FEHCA");
		  model.addColumn("COSTO");
		  model.addColumn("TIPO");
		  model.addColumn("CANTIDAD ASIENTOS");
		scrollPane.setViewportView(tblVenta);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int op = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar?", "Eliminar",
						JOptionPane.YES_NO_OPTION);
				System.out.print(op);
				if (op == 0) {

					if (x.EliminarTicket()) {
						JOptionPane.showMessageDialog(null, "se elimino correctamente");
						actualizarTabla();
					} else {
						JOptionPane.showMessageDialog(null, "Error");
					}
				}
			}
		});
		btnEliminar.setBounds(551, 10, 267, 203);
		frmCrudVentaEliminar.getContentPane().add(btnEliminar);
	}
	public void limpiarFormulario() {
		
	}
}
