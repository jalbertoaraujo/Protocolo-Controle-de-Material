package br.com.protocolo.uteis;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorirTabelaHistorico extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * @Override public Component getTableCellRendererComponent(JTable table,
	 * Object value, boolean isSelected, boolean hasFocus, int row, int column)
	 * { JLabel label = (JLabel) super.getTableCellRendererComponent(table,
	 * value, isSelected, hasFocus, row, column); Color c = Color.WHITE; Object
	 * text = table.getValueAt(row, 3); if (text != null &&
	 * "VERMELHO".equals(text.toString())) c = Color.RED;
	 * label.setBackground(c); return label; }
	 */

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component renderer = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
				column);

		if (isSelected) {
			// define cor e fonte caso a linha esteja selecionada
			setBackground(table.getSelectionBackground());
			setForeground(Color.WHITE);
		} else {// caso não esteja selecionado...
			setForeground(Color.BLACK); // Volta para cor fonte default
			// define cor zebrada da tabela
			if (row % 2 == 0) { // pinta a linha de branco quando a linha for
								// par
				setBackground(Color.WHITE);
			} else { // pinta a linha de cinza quando for impar
				setBackground(new Color(235, 235, 235));
			}			
		}
		return renderer;
	}
}
