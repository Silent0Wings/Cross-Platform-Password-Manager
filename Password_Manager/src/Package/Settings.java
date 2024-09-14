package Package;

import javax.swing.DefaultListModel;
import javax.swing.JProgressBar;

public class Settings {

	public static enum Sort_Type {
		Default, Favorite, Search, Expired, Weak, Strong
	}

	public static enum Sort {
		Default, Name, Date_Modified, Date_Created, Date_Expired
	}

	public static enum Search {
		Name, User_Name, PassWord, OldPassWord, Url, KeyWord, Note
	}

	public static Sort_Type type = Sort_Type.Default;
	public static Sort sort = Sort.Default;
	public static Search search = Search.Name;

	public static DefaultListModel<String> Fav_List;

	public static String Theme = "Light";
	public static String Font_Name = "Tahoma";
	public static String Exluding = "";

	public static String Search_Input = "";

	
	public static Icon_Resources Icon_Ref = new Icon_Resources();

	public static int Sort_Order = 0;

	public static int Font_Size = 11;

	public static JProgressBar MainprogressBar = null;
//	Settings.MainprogressBar.setMaximum(size);
//	Settings.MainprogressBar.setValue(i);
//	Settings.MainprogressBar.update(Settings.MainprogressBar.getGraphics());

	public static void Set_Value(int value) {

		value++;
		if (MainprogressBar != null) {

			MainprogressBar.setVisible(true);
			MainprogressBar.validate();
			MainprogressBar.repaint();
			MainprogressBar.setValue(value);
			MainprogressBar.update(Settings.MainprogressBar.getGraphics());

			if (value >= MainprogressBar.getMaximum() - 5) {
				MainprogressBar.setVisible(false);

			}
		}
	}

	public static void Set_Max(int size) {
		if (MainprogressBar != null) {

			MainprogressBar.setVisible(true);
			MainprogressBar.validate();
			MainprogressBar.repaint();

			MainprogressBar.setMaximum(size);
		}

	}

	public static void Set_Indeterminate(Boolean value) {
		if (MainprogressBar != null) {

			MainprogressBar.setIndeterminate(value);

		}

	}

	public static boolean Ignore_Case;

	public static boolean Auto_Load, Auto_Save_Path;
	public static boolean Locked;
	public static int Year = 1, Month = 0, Day = 34;

	public static boolean Alphabetic, AlphabeticUpper, Numeric, Symbols, Extended;

	public static boolean Use_ToolTip_Table, Use_ToolTip_Tree;

	public static boolean ToolTip_Name, ToolTip_User_Name = true, ToolTip_Password, ToolTip_Url, ToolTip_Note,
			ToolTip_Created, ToolTip_Modified, ToolTip_Expired;

}
