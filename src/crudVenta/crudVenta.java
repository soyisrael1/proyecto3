package crudVenta;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Datas.DataPelicula;
import Datas.DataSala;
import Datas.DataTicket;
import Entidades.Pelicula;
import Entidades.Sala;
import Entidades.Ticket;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class crudVenta {

	public JFrame frmCrudVenta;
	ArrayList<Ticket> listaTickets=null;
	 ArrayList<Sala>listaSalas=null;
	 ArrayList<Pelicula>listaPeliculas=null;
	 DefaultTableModel model=new DefaultTableModel();
	 DefaultComboBoxModel modelCombo=null;
	 DefaultComboBoxModel modelCombo2=null;
	 DataTicket dc=new DataTicket();
	 Ticket p=null;
	 int fila=0;
	 private JComboBox cmbSala;
	 private JComboBox cmbPelicula;
	 private JTable tblVentas;
	 private JSpinner spnAsientos;
	 private JRadioButton radVip;
	 private JRadioButton radNormal;
	 int costo=0;
	 int numAsientos;
	 private JLabel lblCosto;
	 private JScrollPane scrollPane;
	 private JLabel lblID;
	 String tipo="";
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crudVenta window = new crudVenta();
					window.frmCrudVenta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	  
	public crudVenta() {
		initialize();
		DataSala du=new DataSala();
		  listaSalas=du.SelectSala();
		  Object nombresSalas[]=new Object[listaSalas.size()];
		  for (int i = 0; i <listaSalas.size(); i++) {
		   nombresSalas[i]=listaSalas.get(i).getNombre();
		  }
		  modelCombo=new DefaultComboBoxModel(nombresSalas);
		  cmbSala.setModel(modelCombo);
		  
		  DataPelicula dp = new DataPelicula();
		  listaPeliculas = dp.SelectPelicula();
		  Object nombresPeli[] = new Object[listaPeliculas.size()];
		 for (int i = 0; i< listaPeliculas.size();i++) {
			 nombresPeli[i]=listaPeliculas.get(i).getNombre();
		 }
		 modelCombo = new DefaultComboBoxModel(nombresPeli);
		 cmbPelicula.setModel(modelCombo);
		 
		 
		
		 
		 actualizarTabla();
		
		  
		 }
	 public int seleccionarUsuario(Ticket p) {
		   int pos =0;
		   for (Sala u : listaSalas) {
		   if (u.getIdSala() == p.getIdPeli()) {
		    pos++;
		   }
		  }
		  return pos;
		   
		  }
	 public String getPelicula(int idPeli) {
		  String peli = "";
		  for (Pelicula u: listaPeliculas) {
		   if(u.getIdPeli()== idPeli){
		    System.out.println("id user:"+u.getIdPeli());
		    peli = u.getNombre();
		   }
		  }
		  return peli;
		  
		 }	
		 public String getSala(int idSala) {
		  String sala = null;
		  for (Sala u: listaSalas) {
		   if(u.getIdSala()== idSala){
		    sala = u.getNombre();
		    
		   }
		  }
		  return sala;
		 }
	 public void actualizarTabla() {
		  while (model.getRowCount()>0) { 
		   model.removeRow(0);
		   }
		   listaTickets = dc.SelectTicket();
		   for (Ticket u : listaTickets) {
		    Object o[]=new Object[7];
		    o[0]=u.getIdTi();
		    o[1]=getSala(u.getIdSala());
		    o[2]=getPelicula(u.getIdPeli());
		    o[3]=u.getFecha();
		    o[4]=u.getCosto();
		    o[5]=u.getTipo();
		    o[6]=u.getCantidad();
		    
		    model.addRow(o);
		   }
		   tblVentas.setModel(model);
		 }
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudVenta = new JFrame();
		frmCrudVenta.setBounds(100, 100, 846, 645);
		
		frmCrudVenta.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sala");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 55, 108, 36);
		frmCrudVenta.getContentPane().add(lblNewLabel);
		
		cmbSala = new JComboBox();
		cmbSala.setBounds(128, 63, 127, 21);
		frmCrudVenta.getContentPane().add(cmbSala);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 108, 35);
		frmCrudVenta.getContentPane().add(lblNewLabel_1);
		
		lblID = new JLabel("0");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(128, 10, 108, 35);
		frmCrudVenta.getContentPane().add(lblID);
		
		JLabel lblNewLabel_2 = new JLabel("Pelicula");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 101, 108, 36);
		frmCrudVenta.getContentPane().add(lblNewLabel_2);
		
		cmbPelicula = new JComboBox();
		cmbPelicula.setBounds(128, 109, 127, 21);
		frmCrudVenta.getContentPane().add(cmbPelicula);
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(radVip);
		grupo.add(radNormal);

		
		 scrollPane = new JScrollPane();
		 scrollPane.setBounds(309, 10, 513, 588);
		 frmCrudVenta.getContentPane().add(scrollPane);
		 
		 tblVentas = new JTable();
		 tblVentas.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		fila = tblVentas.getSelectedRow();
		        p = listaTickets.get(fila);
		        lblID.setText("" + p.getIdTi());
		        cmbSala.setSelectedIndex(seleccionarUsuario(p));
		        cmbPelicula.setSelectedIndex(seleccionarUsuario(p));
		        spnAsientos.setValue(p.getCantidad());
		        lblCosto.setText(""+p.getCosto()+"$");
		        System.out.println("Cantidad: " + p.getCantidad());
		        tipo = p.getTipo();
		        if ("vip".equals(tipo)) {
		            radVip.setSelected(true);
		        } else if ("normal".equals(tipo)) {
		            radNormal.setSelected(true);
		        }

		 	}
		 });
		 model.addColumn("ID TI");
		  model.addColumn("ID SALA");
		  model.addColumn("ID PELICULA");
		  model.addColumn("FEHCA");
		  model.addColumn("COSTO");
		  model.addColumn("TIPO");
		  model.addColumn("CANTIDAD ASIENTOS");
		  tblVentas.setModel(model);
		 scrollPane.setViewportView(tblVentas);
		 
		 spnAsientos = new JSpinner();
		 spnAsientos.addChangeListener(new ChangeListener() {
		 	public void stateChanged(ChangeEvent e) {
		 		calcularCosto();
		 	}
		 });
		 spnAsientos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 spnAsientos.setBounds(128, 152, 127, 36);
		 frmCrudVenta.getContentPane().add(spnAsientos);
		 
		 JLabel lblNewLabel_3 = new JLabel("Num Asientos");
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 lblNewLabel_3.setBounds(10, 151, 108, 37);
		 frmCrudVenta.getContentPane().add(lblNewLabel_3);
		 
		 JLabel lblNewLabel_4 = new JLabel("Tipo de Asiento");
		 lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 lblNewLabel_4.setBounds(60, 198, 176, 57);
		 frmCrudVenta.getContentPane().add(lblNewLabel_4);
		 
		 radVip = new JRadioButton("Vip");
		 radVip.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		calcularCosto();
		 		tipo="vip";
		 	}
		 });
		 radVip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 radVip.setHorizontalAlignment(SwingConstants.CENTER);
		 radVip.setBounds(70, 261, 148, 40);
		 frmCrudVenta.getContentPane().add(radVip);
		 
		 radNormal = new JRadioButton("Normal");
		 radNormal.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		calcularCosto();
		 		tipo="normal";
		 	}
		 });
		 radNormal.setHorizontalAlignment(SwingConstants.CENTER);
		 radNormal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 radNormal.setBounds(70, 322, 148, 46);
		 frmCrudVenta.getContentPane().add(radNormal);
		 
		 JButton btnAgregar = new JButton("Agregar");
		 btnAgregar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		 try {
				     Ticket p= new Ticket();
				     p.setIdSala(listaSalas.get(cmbSala.getSelectedIndex()).getIdSala());
				     p.setIdPelicula(listaPeliculas.get(cmbPelicula.getSelectedIndex()).getIdPeli());
				     p.setCosto(costo);
				     p.setTipo(tipo);
				     p.setCantidad(numAsientos);
				     if(p.insertarTicket()) {
				      JOptionPane.showConfirmDialog(null, "se inserto correctamente");
				      actualizarTabla();
				      
				     }else {
				      JOptionPane.showConfirmDialog(null, "ERROR");
				     }
				    } catch (Exception e2) {
				     JOptionPane.showConfirmDialog(null, "ERROR");
				    }
		 	}
		 });
		 btnAgregar.setBounds(25, 427, 122, 171);
		 frmCrudVenta.getContentPane().add(btnAgregar);
		 
		 JButton btnActualizar = new JButton("Actualizar");
		 btnActualizar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
		 			p.setIdSala(listaSalas.get(cmbSala.getSelectedIndex()).getIdSala());
				     p.setIdPelicula(listaPeliculas.get(cmbPelicula.getSelectedIndex()).getIdPeli());
				     p.setCosto(costo);
				     p.setTipo(tipo);
				     p.setCantidad(numAsientos);
				     if(p.actualizarTicket()) {
		 		      JOptionPane.showConfirmDialog(null, "se inserto correctamente");
		 		     actualizarTabla();
		 		  
		 		     }else {
		 		      JOptionPane.showConfirmDialog(null, "ERROR");
		 		     }
		 		    } catch (Exception e2) {
		 		     JOptionPane.showConfirmDialog(null, "ERROR");
		 		    }
		 		    
		 	}
		 });
		 btnActualizar.setBounds(157, 427, 142, 171);
		 frmCrudVenta.getContentPane().add(btnActualizar);
		 
		 lblCosto = new JLabel("0$");
		 lblCosto.setHorizontalAlignment(SwingConstants.CENTER);
		 lblCosto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		 lblCosto.setBounds(70, 377, 148, 40);
		 frmCrudVenta.getContentPane().add(lblCosto);
		
	}
	public void calcularCosto() {
		numAsientos=(int) spnAsientos.getValue();
		if(radVip.isSelected()) {
			costo=numAsientos*100;
			lblCosto.setText(""+costo+"$");
		}
		if(radNormal.isSelected()){
			costo=numAsientos*75;
			lblCosto.setText(""+costo+"$");
		}
	}
	public void limpiar() {
		
	}
}
