package fr.obs.view;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Classe qui nous permet d'ajouter des tooltip sur des items de JComboBox
 * @see http://stackoverflow.com/questions/480261/java-swing-mouseover-text-on-jcombobox-items
 *
 */
public class ComboboxToolTipRenderer extends DefaultListCellRenderer {
	ArrayList<String> tooltips;

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

		JComponent comp = (JComponent) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

		if (-1 < index && null != value && null != tooltips) {
			list.setToolTipText(tooltips.get(index));
		}
		
		return comp;
	}

	
	public void setTooltips(ArrayList tooltips) {
		this.tooltips = tooltips;
	}
}
