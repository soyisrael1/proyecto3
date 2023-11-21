package crudVenta;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Datas.DataSala;
import Datas.DataTicket;
import Entidades.Pelicula;
import Entidades.Sala;
import Entidades.Ticket;

public class crudVentaVer {

	public JFrame frmCrudVentasVer;
	private JTable tblSalas;
	private JScrollPane scrollPane;
	public ArrayList<Ticket> listaTicket = new ArrayList<Ticket>();
	public DefaultTableModel model= new DefaultTableModel();
	Ticket x;
	ArrayList<Sala>listaSalas=null;
	 ArrayList<Pelicula>listaPeliculas=null;
	ArrayList<Ticket> lista;
	int fila = 0;
	int idSala = 0;
	private JButton btnPDF;
	
	public void actualizarTabla() {
		DataTicket da = new DataTicket();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		lista = da.SelectTicket();
		for (Ticket u : lista) {
			Object o[] = new Object[7];
			
		    o[0]=u.getIdTi();
		    o[1]=u.getIdSala();
		    o[2]=u.getIdPeli();
		    o[3]=u.getFecha();
		    o[4]=u.getCosto();
		    o[5]=u.getTipo();
		    o[6]=u.getCantidad();
		    
		
			
			model.addRow(o);

		}
		tblSalas.setModel(model);
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
	/**
	 * Create the application.
	 */
	public crudVentaVer() {
		initialize();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudVentasVer = new JFrame();
		frmCrudVentasVer.setTitle("                                                   Ver Ventas");
		frmCrudVentasVer.setBounds(100, 100, 589, 640);
		frmCrudVentasVer.setLocationRelativeTo(null);
		frmCrudVentasVer.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 555, 462);
		frmCrudVentasVer.getContentPane().add(scrollPane);
		
		tblSalas = new JTable();
		tblSalas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblSalas.getSelectedRow();
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
		scrollPane.setViewportView(tblSalas);
		
		btnPDF = new JButton("PDF");
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarPDF();
			}
		});
		btnPDF.setBounds(10, 482, 555, 100);
		frmCrudVentasVer.getContentPane().add(btnPDF);
	}
	public void limpiarFormulario() {
		
	}
	public void generarPDF() {
        try {
               FileOutputStream archivo;
              
               File file = new File("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project2\\src\\PDF\\PDF Ventas.pdf");
              
               archivo = new FileOutputStream(file);
               Document doc = new Document();
               PdfWriter.getInstance(doc, archivo);
               doc.open();
              Image img = Image.getInstance("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project2\\src\\Imagenes\\pdf}.jpeg");
//               Image img = Image.getInstance(getClass().getResource("/imagenes/logooxxo.png"));
               img.setAlignment(Element.ALIGN_CENTER);
               img.scaleToFit(30, 30);
               doc.add(img);
               Paragraph p = new Paragraph(10);
               Font negrita = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.BLACK);
               p.add(Chunk.NEWLINE);
               p.add("CONTROL DE VENTAS");
               p.add(Chunk.NEWLINE);
               p.add(Chunk.NEWLINE);
               p.setAlignment(Element.ALIGN_CENTER);
               doc.add(p);
               //Tabla de datos
               PdfPTable tabla = new PdfPTable(7);
               tabla.setWidthPercentage(100);
               PdfPCell c1 = new PdfPCell(new Phrase("ID TICKET", negrita));
               PdfPCell c2 = new PdfPCell(new Phrase("ID SALA", negrita));
               PdfPCell c3 = new PdfPCell(new Phrase("ID PELICULA", negrita));
               PdfPCell c4 = new PdfPCell(new Phrase("FECHA", negrita));
               PdfPCell c5 = new PdfPCell(new Phrase("COSTO", negrita));
               PdfPCell c6 = new PdfPCell(new Phrase("TIPO", negrita));
               PdfPCell c7 = new PdfPCell(new Phrase("CANTIDAD", negrita));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               c2.setHorizontalAlignment(Element.ALIGN_CENTER);
               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
               c4.setHorizontalAlignment(Element.ALIGN_CENTER);
               c5.setHorizontalAlignment(Element.ALIGN_CENTER);
               c6.setHorizontalAlignment(Element.ALIGN_CENTER);
               c7.setHorizontalAlignment(Element.ALIGN_CENTER);
               c1.setBackgroundColor(BaseColor.BLUE);
               c2.setBackgroundColor(BaseColor.BLUE);
               c3.setBackgroundColor(BaseColor.BLUE);
               c4.setBackgroundColor(BaseColor.BLUE);
               c5.setBackgroundColor(BaseColor.BLUE);
               c6.setBackgroundColor(BaseColor.BLUE);
               c7.setBackgroundColor(BaseColor.BLUE);
               tabla.addCell(c1);
               tabla.addCell(c2);
               tabla.addCell(c3);
               tabla.addCell(c4);
               tabla.addCell(c5);
               tabla.addCell(c6);
               tabla.addCell(c7);
               //Agregar los registros
               DataTicket dc=new DataTicket();
               listaTicket=dc.SelectTicket();
               for (Ticket c : listaTicket) {
                   tabla.addCell("" +c.getIdTi());
                   tabla.addCell("" + c.getIdSala());
                   tabla.addCell("" + c.getIdPeli());
                   tabla.addCell("" + c.getFecha());
                   tabla.addCell("" + c.getCosto());
                   tabla.addCell("" + c.getTipo());
                   tabla.addCell("" + c.getCantidad());
                                  
               }
               doc.add(tabla);
               Paragraph p1 = new Paragraph(10);
               p1.add(Chunk.NEWLINE);
               p1.add("NÚMERO DE VENTAS: " + listaTicket.size());
               p1.add(Chunk.NEWLINE);
               p1.add(Chunk.NEWLINE);
               p1.setAlignment(Element.ALIGN_RIGHT);
               doc.add(p1);
               doc.close();
               archivo.close();
               Desktop.getDesktop().open(file);
           } catch (FileNotFoundException ex) {
           } catch (DocumentException ex) {
           } catch (IOException ex) {
               JOptionPane.showMessageDialog(frmCrudVentasVer, "" + ex.getMessage());
               //Logger.getLogger(todosPDF.class.getName()).log(Level.SEVERE, null, ex);
           }
   }
}
