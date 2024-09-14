package Gui;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.border.Border;

import Package.Settings;

public class Custom_Default_List_Cell_Renderer extends DefaultListCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		setComponentOrientation(list.getComponentOrientation());

		Color bg = null;
		Color fg = null;

		JList.DropLocation dropLocation = list.getDropLocation();
		if (dropLocation != null && !dropLocation.isInsert() && dropLocation.getIndex() == index) {

			// bg = DefaultLookup.getColor(this, ui, "List.dropCellBackground");
			// fg = DefaultLookup.getColor(this, ui, "List.dropCellForeground");

			isSelected = true;
		}

		if (isSelected) {
			setBackground(bg == null ? list.getSelectionBackground() : bg);
			setForeground(fg == null ? list.getSelectionForeground() : fg);
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}

		if (value instanceof Icon) {
			setIcon((Icon) value);
			setText("");
		} else {
			setIcon(null);
			setText((value == null) ? "" : value.toString());
		}

		setEnabled(list.isEnabled());
		setFont(list.getFont());

		Border border = null;
		if (cellHasFocus) {
			if (isSelected) {
				// border = DefaultLookup.getBorder(this, ui,
				// "List.focusSelectedCellHighlightBorder");
			}
			if (border == null) {
				// border = DefaultLookup.getBorder(this, ui, "List.focusCellHighlightBorder");
			}
		} else {
			// border = getNoFocusBorder();
		}
		setBorder(border);

		if (isValidPath(value.toString()) == false) {
			setForeground(Color.red);
			setIcon(Settings.Icon_Ref.Warning_16);
			setToolTipText("File is : Missing, Deleted, Renamed, Or Moved .");

		} else {
			setToolTipText("File is Detected .");

		}

		return this;
	}

	private static boolean isValidPath(String path) {

		boolean exists;

		try {
			Paths.get(path);
			File temp = Paths.get(path).toFile();

			exists = temp.exists();

		} catch (InvalidPathException | NullPointerException ex) {
			return false;
		}

		if (path.endsWith(".Enc") && exists == true) {

			return true;

		} else {

			return false;

		}
	}

}
