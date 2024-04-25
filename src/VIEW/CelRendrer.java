package VIEW;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class CelRendrer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		Component com= super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		PanelIcone panel=new PanelIcone();
		return panel;
	}
}
