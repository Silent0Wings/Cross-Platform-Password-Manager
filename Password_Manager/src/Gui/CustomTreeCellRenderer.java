package Gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import Package.Node_File;
import Package.Node_Structure;
import Package.Settings;

@SuppressWarnings("serial")
public class CustomTreeCellRenderer extends DefaultTreeCellRenderer {

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		// TODO Auto-generated method stub

		DefaultMutableTreeNode Temp = (DefaultMutableTreeNode) value;
		Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

//		this.setBackgroundNonSelectionColor(Color.DARK_GRAY);
//		this.setBackgroundSelectionColor(Color.LIGHT_GRAY);

		Font Newtemp = new Font(Settings.Font_Name, getFont().getStyle(), Settings.Font_Size);

		setFont(Newtemp);
		if (Temp.getUserObject() instanceof Node_File) {

			Node_File temp_file = (Node_File) Temp.getUserObject();
			c = super.getTreeCellRendererComponent(tree, ((Node_File) (Temp.getUserObject())).getName(), sel, expanded,
					leaf, row, hasFocus);

			if (Settings.Use_ToolTip_Tree) {

				setToolTipText(Handle_ToolTip(temp_file));
			}

			setLeafIcon(Settings.Icon_Ref.Key_16);
			setClosedIcon(Settings.Icon_Ref.Key_16);
			setOpenIcon(Settings.Icon_Ref.Key_16);
			setIcon(Settings.Icon_Ref.Key_16);

			if (temp_file.getFavorite()) {
				setLeafIcon(Settings.Icon_Ref.Star_16);
				setClosedIcon(Settings.Icon_Ref.Star_16);
				setOpenIcon(Settings.Icon_Ref.Star_16);
				setIcon(Settings.Icon_Ref.Star_16);
				setForeground(Color.yellow);
			}

			if (temp_file.Is_Expired()) {

				setLeafIcon(Settings.Icon_Ref.Warning_16);
				setClosedIcon(Settings.Icon_Ref.Warning_16);
				setOpenIcon(Settings.Icon_Ref.Warning_16);
				setIcon(Settings.Icon_Ref.Warning_16);
				setForeground(Color.red);

			}

		} else if (Temp.getUserObject() instanceof Node_Structure) {

			if (Settings.Use_ToolTip_Tree) {
				Node_Structure temp_file = (Node_Structure) Temp.getUserObject();

				((JComponent) c).setToolTipText(

						"File Size : " + temp_file.Files_Size() + "\r\n" + "Folder Size : "
								+ (temp_file.Folder_Size() - 1) + "\r\n");

			}
			setLeafIcon(Settings.Icon_Ref.folder_16);
			setClosedIcon(Settings.Icon_Ref.folder_16);
			setOpenIcon(Settings.Icon_Ref.folder_16);

			c = super.getTreeCellRendererComponent(tree, ((Node_Structure) (Temp.getUserObject())).Get_Name(), sel,
					expanded, leaf, row, hasFocus);

		}
		// c.setForeground(Color.WHITE);
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
