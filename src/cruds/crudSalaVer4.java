package cruds;

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
import Entidades.Sala;
import javax.swing.ImageIcon;

public class crudSalaVer4 {

	public JFrame frmCrudSalaVer;
	private JTable tblSalas;
	private JScrollPane scrollPane;
	public ArrayList<Sala> listaSalas = new ArrayList<Sala>();
	public DefaultTableModel model= new DefaultTableModel();
	Sala x;
	ArrayList<Sala> lista;
	int fila = 0;
	int idSala = 0;
	private JButton btnPDF;
	
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
	public crudSalaVer4() {
		initialize();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudSalaVer = new JFrame();
		frmCrudSalaVer.setTitle("                                                   Ver Salas");
		frmCrudSalaVer.setBounds(100, 100, 589, 640);
		frmCrudSalaVer.setLocationRelativeTo(null);
		frmCrudSalaVer.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 555, 462);
		frmCrudSalaVer.getContentPane().add(scrollPane);
		
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
		
		btnPDF = new JButton("PDF");
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarPDF();
			}
		});
		btnPDF.setBounds(10, 482, 555, 100);
		frmCrudSalaVer.getContentPane().add(btnPDF);
	}
	public void limpiarFormulario() {
		
	}
	public void generarPDF() {
        try {
               FileOutputStream archivo;
              
               File file = new File("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project2\\src\\PDF\\PDF Salas.pdf");
              
               archivo = new FileOutputStream(file);
               Document doc = new Document();
               PdfWriter.getInstance(doc, archivo);
               doc.open();
              Image img = Image.getInstance("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project2\\src\\Imagenes\\pdf}.jpeg");
//               Image img = Image.getInstance(getClass().getResource("/imagenes/logooxxo.png"));
               img.setAlignment(Element.ALIGN_CENTER);
               img.scaleToFit(50, 50);
               doc.add(img);
               Paragraph p = new Paragraph(10);
               Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
               p.add(Chunk.NEWLINE);
               p.add("CONTROL DE CELULARES");
               p.add(Chunk.NEWLINE);
               p.add(Chunk.NEWLINE);
               p.setAlignment(Element.ALIGN_CENTER);
               doc.add(p);
               //Tabla de datos
               PdfPTable tabla = new PdfPTable(5);
               tabla.setWidthPercentage(100);
               PdfPCell c1 = new PdfPCell(new Phrase("ID SALA", negrita));
               PdfPCell c2 = new PdfPCell(new Phrase("NUM ASIENTOS", negrita));
               PdfPCell c3 = new PdfPCell(new Phrase("PANTALLA", negrita));
               PdfPCell c4 = new PdfPCell(new Phrase("SONIDO", negrita));
               PdfPCell c5 = new PdfPCell(new Phrase("NOMBRE", negrita));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
               c4.setHorizontalAlignment(Element.ALIGN_CENTER);
               c5.setHorizontalAlignment(Element.ALIGN_CENTER);
               c1.setBackgroundColor(BaseColor.PINK);
               c2.setBackgroundColor(BaseColor.BLUE);
               c3.setBackgroundColor(BaseColor.ORANGE);
               c4.setBackgroundColor(BaseColor.GREEN);
               c5.setBackgroundColor(BaseColor.RED);
               tabla.addCell(c1);
               tabla.addCell(c2);
               tabla.addCell(c3);
               tabla.addCell(c4);
               tabla.addCell(c5);
               //Agregar los registros
               DataSala dc=new DataSala();
               listaSalas=dc.SelectSala();
               for (Sala c : listaSalas) {
                   tabla.addCell("" +c.getIdSala());
                   tabla.addCell("" + c.getNumAsientos());
                   tabla.addCell("" + c.getPantalla());
                   tabla.addCell("" + c.getSonido());
                   tabla.addCell("" + c.getNombre());
               }
               doc.add(tabla);
               Paragraph p1 = new Paragraph(10);
               p1.add(Chunk.NEWLINE);
               p1.add("NÚMERO DE SALAS: " + listaSalas.size());
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
               JOptionPane.showMessageDialog(frmCrudSalaVer, "" + ex.getMessage());
               //Logger.getLogger(todosPDF.class.getName()).log(Level.SEVERE, null, ex);
           }
   }
}
