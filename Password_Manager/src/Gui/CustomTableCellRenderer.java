package Gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import Package.Node_File;
import Package.Node_Structure;
import Package.Settings;

@SuppressWarnings("serial")
public class CustomTableCellRenderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

//		if (isSelected) {
//
//			super.setForeground(Color.WHITE);
//			super.setBackground(Color.LIGHT_GRAY);
//
//		} else {
//			super.setForeground(Color.WHITE);
//			super.setBackground(Color.DARK_GRAY);
//		}

		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		// if this is removed the entire colum get the color changer ......
		c.setForeground(table.getForeground());
		if (value != null) {

			if (value instanceof Node_File) {
				Node_File temp_file = (Node_File) value;
				if (temp_file != null) {

					super.setText(temp_file.getName());
					setIcon(Settings.Icon_Ref.Key_16);

					if (temp_file.getFavorite()) {
						setIcon(Settings.Icon_Ref.Star_16);
						c.setForeground(Color.yellow);
					}

					if (temp_file.Is_Expired()) {
						setIcon(Settings.Icon_Ref.Warning_16);
						c.setForeground(Color.red);

					}

					if (Settings.Use_ToolTip_Table) {

						setToolTipText(Handle_ToolTip(temp_file));
					}

				}

			} else if (value instanceof Node_Structure) {
				Node_Structure temp_folder = (Node_Structure) value;

				if (Settings.Use_ToolTip_Tree) {

					((JComponent) c).setToolTipText("File Size : " + temp_folder.Files_Size() + "\r\n"
							+ "Folder Size : " + (temp_folder.Folder_Size() - 1) + "\r\n");
				}

				if (temp_folder != null) {

					setIcon(Settings.Icon_Ref.folder_16);
					super.setText(temp_folder.Get_Name());
				}

			}

		} else {
			setIcon(null);
			setText("");
		}

		// setBorder(BorderFactory.createLineBorder(Color.RED));

		setHorizontalAlignment(JLabel.CENTER);

		return c;
	}

	private String Handle_ToolTip(Node_File Source) {

		String Temp = "";

		if (Settings.ToolTip_Name && Source.getName() != "") {
			Temp += "Name : " + Source.getName() + "\r\n";
		}

		if (Settings.ToolTip_User_Name && Source.getUser_Name() != "") {
			Temp += "User Name : " + Source.getUser_Name() + "\r\n";
		}

		if (Settings.ToolTip_Password && Source.getPassword() != "") {
			Temp += "PasseWord : " + Source.getPassword() + "\r\n";
		}
		if (Settings.ToolTip_Url && Source.getUrl() != "") {
			Temp += "URL : " + Source.getUrl() + "\r\n";
		}
		if (Settings.ToolTip_Note && Source.getNote() != "") {
			Temp += "Note : " + Source.getNote() + "\r\n";
		}
		if (Settings.ToolTip_Created && Source.getTime_Created() != "") {
			Temp += "Time Created : " + Source.getTime_Created() + "\r\n";
		}
		if (Settings.ToolTip_Modified && Source.getModified() != "") {
			Temp += "Last Modified : " + Source.getModified() + "\r\n";
		}
		if (Settings.ToolTip_Expired && Source.getExpiration() != "") {
			Temp += "Expiration : " + Source.getExpiration() + "\r\n";
		}

		return Temp;
	}
}
