package Package;

import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("unused")
public class Node_Container {

	public Model Current_Model = new Model();

	public Node_Structure Root;

	public String Main_Name;

	private boolean Is_Valide;

	private String Main_PassWord;

//	public void setPassWord(String New_Pass) {
//		Main_PassWord = Model.Integrity(New_Pass);
//
//	}

	public String getMain_PassWord() {
		return Model.Integrity(Main_PassWord);
	}

	public void setMain_PassWord(String main_PassWord) {
		Main_PassWord = Model.Integrity(main_PassWord);
		;
	}

	public boolean is_Valide() {
		return Is_Valide;

	}

	// ________________________________________________________________________________

	public void Creat_Root() {

		Root = new Node_Structure(true);
		Root.Rename_Node("Root");

	}

	public Node_Container(String New_PassWord) {

		Main_PassWord = New_PassWord;

		Creat_Root();
	}
	// ________________________________________________________________________________

	// traverse the folders
	public Node_Structure Traverse(Object[] Path) {

		if (Path.length != 0) {

			return Root.Recursice_Traverse(Path, 1);

		} else {

			return null;
		}

	}
	// ________________________________________________________________________________

	// Build The Entire Folder Structures based on link
	public void Build_Folders(String[] Links) {

		if (Links.length != 0) {

			Is_Valide = true;

			// Remove the last / element
			for (int i = 0; i < Links.length; i++) {
				if (Links[i].length() != 0) {
					if ((Links[i].charAt(Links[i].length() - 1)) == '/') {

						Links[i] = Links[i].substring(0, Links[i].length() - 1);

						Links[i] = Links[i].replaceAll("(\\r|\\n)", "");
					}

				}
			}

			for (int i = 0; i < Links.length; i++) {

				if (Links[i].length() != 0) {

					String[] Split_Link = Links[i].split("/", -1);

					if (Split_Link.length != 0) {

						if (Split_Link.length == 1 && Split_Link[0].equals("Root")
								|| Split_Link.length == 1 && Split_Link[0].equals("")) {

						} else {

							if (Split_Link[0].equals("Root")) {

								Root.Recursice_Traverse_And_Build(Split_Link, 1);

							} else {

								System.err.println("Critical !!!!" + Split_Link[0]);
							}
						}

					}

				}

			}

		}

	}

	// Build The Entire File Structures based on link
	public void Build_Files(Node_File[] Files) {
		// TODO Auto-generated method stub

		for (int i = 0; i < Files.length; i++) {

			if (Files[i] != null && Files[i].getLink() != "" && Files[i].getLink() != null) {

				String[] Split_Link = Files[i].getLink().split("/", -1);

				Node_Structure temp = Traverse(Split_Link);

				if (temp != null) {
					temp.Add_File(Files[i]);
				}

			}
		}
	}
	// ________________________________________________________________________________

	// Compact the entire database folders and files
	public String Compact() {

		if (Root != null) {

			String Temp;

			// List<Node_Structure> Stru = Root.Compact_Folders();

			Node_File[] NewFiles = Root.Compact_Files_Array();

			// Files info
			Temp = Model.Data_Header + "Size" + Root.Files_Size() + Model.Data_Header_End + "\r\n";

			// Structure building
			Temp += Model.Start_Struct + "\r\n" + Root.Compact_Print() + "\r\n" + Model.End_Struct;

			Temp += "\r\n" + Model.Start_Data + "\r\n";

			if (NewFiles != null && NewFiles.length != 0) {
				Settings.Set_Max(NewFiles.length);

				for (int i = 0; i < NewFiles.length; i++) {
					String Data_Temp = "";
					Settings.Set_Value(i);

					// // System.out.println("==||" + i + "||");

					Data_Temp += "\r\n" + Model.Single_Data_Start + "\r\n";

					Data_Temp += "\r\n" + "Link" + Model.Custom_Start + NewFiles[i].getLink() + Model.Custom_End;

					Data_Temp += "\r\n" + "Name" + Model.Custom_Start + NewFiles[i].getName() + Model.Custom_End;

					Data_Temp += "\r\n" + "Title" + Model.Custom_Start + NewFiles[i].getTitle() + Model.Custom_End;

					Data_Temp += "\r\n" + "User_Name" + Model.Custom_Start + NewFiles[i].getUser_Name()
							+ Model.Custom_End;

					Data_Temp += "\r\n" + "Password" + Model.Custom_Start + NewFiles[i].getPassword()
							+ Model.Custom_End;

					// Data_Temp += "\r\n" + "OldPassword" + Custom_Start + Fi[i].Old_Password +
					// Custom_End;

					Data_Temp += "\r\n" + "Url" + Model.Custom_Start + NewFiles[i].getUrl() + Model.Custom_End;

					Data_Temp += "\r\n" + "KeyWord" + Model.Custom_Start + NewFiles[i].getKeyWord() + Model.Custom_End;

					Data_Temp += "\r\n" + "Expiration" + Model.Custom_Start + NewFiles[i].getExpiration()
							+ Model.Custom_End;

					Data_Temp += "\r\n" + "Time_Created" + Model.Custom_Start + NewFiles[i].getTime_Created()
							+ Model.Custom_End;

					Data_Temp += "\r\n" + "Modified" + Model.Custom_Start + NewFiles[i].getModified()
							+ Model.Custom_End;

					Data_Temp += "\r\n" + "Favorite" + Model.Custom_Start + NewFiles[i].getFavorite()
							+ Model.Custom_End;

					Data_Temp += "\r\n" + "OldPassword" + Model.Custom_Start
							+ NewFiles[i].getCompactOld_Password(Model.Custom_Pass_Start, Model.Custom_Pass_End)
							+ Model.Custom_End;

					Data_Temp += "\r\n" + "Note" + Model.Custom_Note_Start + NewFiles[i].getNote()
							+ Model.Custom_Note_End;

					Data_Temp += "\r\n" + Model.Single_Data_End;

					Temp += Data_Temp;
				}
			}

			Temp += "\r\n" + Model.End_Data;

			if (Temp.length() != 0 && Temp != "") {

				return Temp;
			}
		}

		return null;
	}

	// ________________________________________________________________________________

}
