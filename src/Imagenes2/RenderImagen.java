package Imagenes2;

import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTable;

public class RenderImagen extends DefaultTableCellRenderer{
	
	public Component getTableCellRenderComponent JTable tblPeliculas,Object value,boolean isSelected,boolean hasFocus,int row,int column{
		if(value instanceof JLabel) {
		JLabel lbl=(JLabel) value;
		return lbl;
		}
		return super.getTableCellRendererComponent(tblPeliculas, value, isSelected, hasFocus, row, column);
		}
	

}
