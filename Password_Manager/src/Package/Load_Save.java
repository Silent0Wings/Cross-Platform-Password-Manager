package Package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.ProgressMonitor;

public class Load_Save {

	@SuppressWarnings("unused")
	private static ProgressMonitor monitor;

	// _____________________Favorite Paths____________________________________
	public static void Save_Favorite_DataBase(DefaultListModel<String> Data) {

		String File_Name = "Favorite_Paths.Fav";
		File theDir = new File(Generate_Folder());

		if (!theDir.exists()) {
			theDir.mkdirs();
			// System.out.println(theDir.toString());
		}
		// System.out.println(theDir + "\\" + File_Name);

		if (theDir.exists()) {

			File Final = new File(theDir + "\\" + File_Name);

			String Final_Data = "";

			for (int i = 0; i < Data.getSize(); i++) {
				Object o = Data.getElementAt(i);
				Final_Data += (String) o + "\r\n";
			}

			PrintWriter writer;
			try {

				// "C:\\Users\\asus\\Desktop\\filename.Enc"
				writer = new PrintWriter(Final, "UTF-8");
				writer.println(Final_Data);

				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.gc();

		}

	}

	public static DefaultListModel<String> Load_Favorite_DataBase() {

		String File_Name = "Favorite_Paths.Fav";

		File theDir = new File(Generate_Folder());
		if (!theDir.exists()) {

			return null;
		}
		// System.out.println(theDir + "\\" + File_Name);

		File Final = new File(theDir + "\\" + File_Name);
		if (Final.exists()) {

			// System.out.println(dir);

			String Raw = "";
			try {
				Raw = "";

				// Creating an object of BufferedReader class
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Final), "UTF-8"));

				// Declaring a string variable
				String st;
				// Condition holds true till
				// there is character in a string

				int index = 0;
				while ((st = br.readLine()) != null)

				{
					if (index == 0) {
						Raw += st;

					} else {
						Raw += "\r\n" + st;

					}
					index++;
				}

				br.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (Raw != "") {

				String lines[] = Raw.split("\\r?\\n");
				DefaultListModel<String> Temp = new DefaultListModel<String>();

				for (int i = 0; i < lines.length; i++) {
					Temp.addElement(lines[i]);
				}

				System.gc();

				Settings.Fav_List = Temp;
				return Temp;

			}
		} else {
			System.err.println("Path Does Not Exist");

		}
		return null;

	}

	// __________________________Theme & Font____________________

	public static void Save_Theme() {

//FlatLaf Light
//FlatLaf IntelliJ
//FlatLaf Dark
//FlatLaf Darcula

//		String className = UIManager.getSystemLookAndFeelClassName();
//        //System.out.println("className = " + className);
//        UIManager.setLookAndFeel(className);

		String File_Name = "Theme.thm";
		File theDir = new File(Generate_Folder());
		if (!theDir.exists()) {
			theDir.mkdirs();
			// System.out.println(theDir.toString());
		}
		// System.out.println(theDir + "\\" + File_Name);

		if (theDir.exists()) {

			File Final = new File(theDir + "\\" + File_Name);

			String theme_Font = Settings.Font_Name + "\r\n" + Settings.Font_Size + "\r\n" + Settings.Theme;
			PrintWriter writer;
			try {

				// "C:\\Users\\asus\\Desktop\\filename.Enc"
				writer = new PrintWriter(Final, "UTF-8");

				writer.println(theme_Font);

				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.gc();
		}

	}

	public static void Load_Theme() {

		String File_Name = "Theme.thm";
		File theDir = new File(Generate_Folder());

		if (!theDir.exists()) {

			return;
		}
		// System.out.println(theDir + "\\" + File_Name);
		File Final = new File(theDir + "\\" + File_Name);

		if (Final.exists()) {

			byte[] bytes;
			String Raw = "";
			try {
				bytes = Files.readAllBytes(Final.toPath());
				Raw = new String(bytes);

				String lines[] = Raw.split("\\r?\\n");
				if (lines.length == 3) {

					// _____________Font Name
					String Temp0 = lines[0];
					if (Temp0.length() > 0) {

						Settings.Font_Name = Temp0;
					}
					// _____________Font Size
					String Temp1 = lines[1];
					int tempfont = Integer.parseInt(Temp1);

					Settings.Font_Size = tempfont;

					// _____________Theme
					String Temp2 = lines[2];
					if (Temp2 != "") {

						Settings.Theme = Temp2;
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// __________________________Settings____________________________________________________________

	public static void Save_Settings() {

		String File_Name = "Settings.Set";
		File theDir = new File(Generate_Folder());

		if (!theDir.exists()) {
			theDir.mkdirs();
			// System.out.println(theDir.toString());
		}
		// System.out.println(theDir + "\\" + File_Name);

		if (theDir.exists()) {

			File Final_Path = new File(theDir + "\\" + File_Name);

			String Final = "";
			Final += "Expiration{" + Settings.Year + "|" + Settings.Month + "|" + Settings.Day + "}" + "\r\n";
			Final += "Auto_Save_Path{" + Settings.Auto_Save_Path + "}" + "\r\n";
			Final += "Auto_Load{" + Settings.Auto_Load + "}" + "\r\n";
			Final += "PasswordGen{" + Settings.Alphabetic + "," + Settings.AlphabeticUpper + "," + Settings.Numeric
					+ "," + Settings.Symbols + "," + Settings.Extended + "}" + "\r\n";
			Final += "UseToolTip{" + Settings.Use_ToolTip_Tree + "," + Settings.Use_ToolTip_Table + "\r\n";
			Final += "ToolTip{" + Settings.ToolTip_Name + "," + Settings.ToolTip_User_Name + ","
					+ Settings.ToolTip_Password + "," + Settings.ToolTip_Url + "," + Settings.ToolTip_Note + ","
					+ Settings.ToolTip_Created + "," + Settings.ToolTip_Modified + "," + Settings.ToolTip_Expired + "}"
					+ "\r\n";

			PrintWriter writer;
			try {

				// "C:\\Users\\asus\\Desktop\\filename.Enc"
				writer = new PrintWriter(Final_Path, "UTF-8");

				writer.println(Final);

				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.gc();
		}

	}

	public static void Load_Settings() {

		Object[][] test = new Object[3][3];

		String File_Name = "Settings.Set";
		File theDir = new File(Generate_Folder());

		if (!theDir.exists()) {

			return;
		}
		// System.out.println(theDir + "\\" + File_Name);

		File Final = new File(theDir + "\\" + File_Name);
		if (Final.exists()) {

			byte[] bytes;
			String Raw = "";
			try {
				bytes = Files.readAllBytes(Final.toPath());

				Raw = new String(bytes);

				Raw = Raw.replaceAll(" ", "");

				String lines[] = Raw.split("\\r?\\n");

				if (lines.length == 6) {

					// _____________Expiration
					String Temp0 = Find_Value("Expiration{", lines[0], '}', false);
					int[] help = new int[3];
					String[] ge = Temp0.split("\\|");

					help[0] = Integer.parseInt(ge[0]);
					help[1] = Integer.parseInt(ge[1]);
					help[2] = Integer.parseInt(ge[2]);
					// System.out.println(Arrays.toString(help));
					Settings.Year = help[0];
					Settings.Month = help[1];
					Settings.Day = help[2];

					test[0][0] = help;
					// _____________Auto Save
					String Temp1 = Find_Value("Auto_Save_Path{", lines[1], '}', false);
					boolean bol1 = Boolean.parseBoolean(Temp1);
					Settings.Auto_Save_Path = bol1;
					test[1][0] = bol1;
					// System.out.println(bol1);

					// _____________Auto Load
					String Temp2 = Find_Value("Auto_Load{", lines[2], '}', false);
					boolean bol2 = Boolean.parseBoolean(Temp2);
					test[2][0] = bol2;
					Settings.Auto_Load = bol2;
					// _____________Password gen
					String Temp3 = Find_Value("PasswordGen{", lines[3], '}', false);
					String Templines[] = Temp3.split(",");
					if (Templines.length == 5) {

						Settings.Alphabetic = Boolean.parseBoolean(Templines[0]);
						Settings.AlphabeticUpper = Boolean.parseBoolean(Templines[1]);
						Settings.Numeric = Boolean.parseBoolean(Templines[2]);
						Settings.Symbols = Boolean.parseBoolean(Templines[3]);
						Settings.Extended = Boolean.parseBoolean(Templines[4]);
					}
					// _____________Use Tool Tip__________
					String Temp4 = Find_Value("ToolTip{", lines[4], '}', false);
					String Temp_Use_Tool[] = Temp4.split(",");
					if (Temp_Use_Tool.length == 2) {
						Settings.Use_ToolTip_Tree = Boolean.parseBoolean(Temp_Use_Tool[0]);
						Settings.Use_ToolTip_Table = Boolean.parseBoolean(Temp_Use_Tool[1]);

					}

					// _____________Tool Tip__________
					String Temp5 = Find_Value("ToolTip{", lines[5], '}', false);
					String TempTipLines[] = Temp5.split(",");
					if (TempTipLines.length == 8) {
						Settings.ToolTip_Name = Boolean.parseBoolean(TempTipLines[0]);
						Settings.ToolTip_User_Name = Boolean.parseBoolean(TempTipLines[1]);
						Settings.ToolTip_Password = Boolean.parseBoolean(TempTipLines[2]);
						Settings.ToolTip_Url = Boolean.parseBoolean(TempTipLines[3]);
						Settings.ToolTip_Note = Boolean.parseBoolean(TempTipLines[4]);
						Settings.ToolTip_Created = Boolean.parseBoolean(TempTipLines[5]);
						Settings.ToolTip_Modified = Boolean.parseBoolean(TempTipLines[6]);
						Settings.ToolTip_Expired = Boolean.parseBoolean(TempTipLines[7]);
					}

				} else {
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println(e);
			}

		}

	}

	// __________________________Data____________________________________________________________

	public static void Save(String Path, Node_Container Container) {

		if (Path.endsWith(".Enc") == false) {
			Path += ".Enc";
		}

		if (Container != null && Path != null && Path != "" && Path.length() != 0) {

			String temptest = (Container.Compact());

			// System.out.println(temptest);

			temptest = Handle_Enc(temptest, Container.getMain_PassWord());

			PrintWriter writer;
			try {

				// "C:\\Users\\asus\\Desktop\\filename.Enc"
				writer = new PrintWriter(Path, "UTF-8");
				writer.println(temptest);
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.gc();
		}

	}

	public static void Load(String Path, Node_Container Container) {

		if (Container != null) {

			// File path is passed as parameter
			File file = new File(Path);

			// Note: Double backquote is to avoid compiler
			// interpret words
			// like \test as \t (ie. as a escape sequence)

			try (// Creating an object of BufferedReader class
					BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
				// Declaring a string variable
				String st;
				String Raw = "";
				// Condition holds true till
				// there is character in a string
				while ((st = br.readLine()) != null)

				{
					if (st.trim().length() > 0) {
						Raw += st;
					}

				}

				Raw = Handle_Dec(Raw, Container.getMain_PassWord());

				// System.out.println(Raw);

				// System.out.println(Raw);
				if (Raw != null && Raw.length() != 0 && Raw != "") {

					Process_Struct(Raw, Container);
				} else {
					Container = null;
					return;
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.gc();

			System.err.println("File Size   : " + Container.Root.Files_Size());
			System.err.println("Folder Size : " + Container.Root.Folder_Size());

		}

	}

	public static void SaveNo_Enc(String Path, Node_Container Container) {

		if (Path.endsWith(".Enc") == false) {
			Path += ".Enc";
		}

		if (Container != null && Path != null && Path != "" && Path.length() != 0) {

			String temptest = (Container.Compact());

			// System.out.println(temptest);

			// temptest = Handle_Enc(temptest, Container.getPassWord());

			PrintWriter writer;
			try {

				// "C:\\Users\\asus\\Desktop\\filename.Enc"
				writer = new PrintWriter(Path, "UTF-8");
				writer.println(temptest);
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.gc();
		}

	}

	public static void LoadNo_Enc(String Path, Node_Container Container) {

		if (Container != null) {

			// File path is passed as parameter
			File file = new File(Path);

			// Note: Double backquote is to avoid compiler
			// interpret words
			// like \test as \t (ie. as a escape sequence)

			try {
				try (// Creating an object of BufferedReader class
						BufferedReader br = new BufferedReader(
								new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
					// Declaring a string variable
					String st;
					String Raw = "";
					// Condition holds true till
					// there is character in a string
					while ((st = br.readLine()) != null)

					{
						if (st.trim().length() > 0) {
							Raw += st;
						}

					}

					// Raw = Handle_Dec(Raw, Container.getPassWord());

					// System.out.println(Raw);

					// System.out.println(Raw);
					Process_Struct(Raw, Container);
				}

				System.gc();

				System.err.println("File Size   : " + Container.Root.Files_Size());
				System.err.println("Folder Size : " + Container.Root.Folder_Size());

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	// ___________________________Processing_____________________________________________________

	private static void Process_Struct(String Raw, Node_Container Container) {
		// System.out.println(Raw);

		// System.out.println(Raw);
		// System.out.println(Raw);

		String Struct = Raw.substring(Raw.indexOf(Model.Start_Struct) + Model.Start_Struct.length(),
				Raw.indexOf(Model.End_Struct));

		String lines[] = Struct.split("\\r?\\n");
		// System.out.println("lines : " + lines.length);

		// System.out.println("|" + lines[0] + "|");
		// System.out.println(lines.length);

		Container.Build_Folders(lines);

		System.gc();
		Process_Raw_Data(Raw, Container);

	}

	private static void Process_Raw_Data(String Raw, Node_Container Container) {

		String Header = Raw.substring(Raw.indexOf(Model.Data_Header) + Model.Data_Header.length(),
				Raw.indexOf(Model.Data_Header_End));

		if (Header != "") {

			// System.out.println(Raw);
			int size = Integer.parseInt(Find_Value("Size", Header, ',', null));

			if (size != 0) {

				Settings.Set_Max(size);

				// System.out.println(i);
				// Progress Temp_Thread_Test = new Progress(size);
//				Temp_Thread_Test.start();
				String Data = Raw.substring(Raw.indexOf(Model.Start_Data) + Model.Start_Data.length(),
						Raw.indexOf(Model.End_Data));

				Node_File Holder[] = new Node_File[size];

				for (int i = 0; i < size; i++) {
					// Temp_Thread_Test.Update(i);

					Settings.Set_Value(i);
					// System.out.println(i);
					if (Data.contains(Model.Single_Data_Start) && Data.contains(Model.Single_Data_End)) {

						String Single_Data = Data.substring(
								Data.indexOf(Model.Single_Data_Start) + Model.Single_Data_Start.length(),
								Data.indexOf(Model.Single_Data_End));
						Data = Data.substring(0, Data.indexOf(Model.Single_Data_Start)) + Data.substring(
								Data.indexOf(Model.Single_Data_End) + Model.Single_Data_End.length(), Data.length());

						// System.out.println("==||" + i + "||");

						// //System.out.println("Struct"+Struct);
						// //System.out.println("Data { "+Data+"}");

						String Name = Extract("Name", Single_Data, Model.Custom_Start, Model.Custom_End);
						String Title = Extract("Title", Single_Data, Model.Custom_Start, Model.Custom_End);
						String User_Name = Extract("User_Name", Single_Data, Model.Custom_Start, Model.Custom_End);
						String OldPassword = Extract("OldPassword", Single_Data, Model.Custom_Start, Model.Custom_End);

						String Password = Extract("Password", Single_Data, Model.Custom_Start, Model.Custom_End);
						String Url = Extract("Url", Single_Data, Model.Custom_Start, Model.Custom_End);
						String KeyWord = Extract("KeyWord", Single_Data, Model.Custom_Start, Model.Custom_End);
						String Expiration = Extract("Expiration", Single_Data, Model.Custom_Start, Model.Custom_End);
						String Time_Created = Extract("Time_Created", Single_Data, Model.Custom_Start,
								Model.Custom_End);
						String Modified = Extract("Modified", Single_Data, Model.Custom_Start, Model.Custom_End);
						Boolean Favorite = Boolean
								.parseBoolean(Extract("Favorite", Single_Data, Model.Custom_Start, Model.Custom_End));
						String Note = Extract("Note", Single_Data, Model.Custom_Note_Start, Model.Custom_Note_End);
						String Link = Extract("Link", Single_Data, Model.Custom_Start, Model.Custom_End);
						// Link = Find_Value("Link" + Custom_Start, Data, ']', null);

						// Link = Link.substring(0, Link.indexOf(Custom_End));

//		//System.out.println("Name |" + Name + "|");
//		//System.out.println("Title |" + Title + "|");
//		//System.out.println("User_Name |" + User_Name + "|");
//		//System.out.println("OldPassword |" + OldPassword + "|");
//		//System.out.println("Url |" + Url + "|");
//		//System.out.println("KeyWord |" + KeyWord + "|");
//		//System.out.println("Expiration |" + Expiration + "|");
//		//System.out.println("Link |" + Link + "|");
						// System.out.println("Note |" + Note + "|");

						Map<String, String> OldPasswordMap = Process_Old_Password_To_Map(OldPassword);

						Node_File file = new Node_File(Name, Title, User_Name, Password, Url, Expiration, KeyWord, Note,
								Link, Time_Created, Modified, Favorite, OldPasswordMap);

						Holder[i] = file;

					}

					//// System.out.println(Container.Root.Files_Size());
//	for (int i = 0; i < Holder.length; i++) {
//		System.err.println(Holder[i].getName()+Holder[i].getLink()+Holder[i].getNote());
//	}

					// List<Node_File> tqsdq = Container.Root.Compact_Files();

//		for (int j = 0; j < tqsdq.size(); j++) {
//
//			//System.out.println(tqsdq.get(j).getName() + "||Link:" + tqsdq.get(j).getLink() + "||getPassword:"
//					+ tqsdq.get(j).getPassword());
//		}
				}
				Container.Build_Files(Holder);
			}
		}

	}
	// ______________________________________________________________________________________

	private static String Extract(String Pointer, String Source, String Start, String End) {

		if (Source.indexOf(Pointer + Start) != -1 && Source.length() > 0 && Source.length() > 0 && End.length() > 0) {

			String Test = Source.substring(Source.indexOf(Pointer + Start) + (Pointer + Start).length(),
					Source.length());

			String Temp = Test.substring(0, Test.indexOf(End));

			return Temp;
		} else {
			return "";
		}
	}

	private static Map<String, String> Process_Old_Password_To_Map(String Source) {

		if (Source.equals(null) == false && Source.equals("") == false && Source.length() != 0) {

			Map<String, String> Old_Password = new HashMap<>();

			if (Source.contains(Model.Custom_Pass_Start) && Source.contains(Model.Custom_Pass_End)) {

				String[] Spliter = null;

				if (Source.contains("\r\n")) {
					Spliter = Source.split("\r\n");

				} else {

					Spliter = new String[1];
					Spliter[0] = Source;

				}

				if (Spliter.length != 0) {

					for (int i = 0; i < Spliter.length; i++) {

						String The_Time = Spliter[i];

						if (The_Time.length() != 0 && The_Time != "") {
							int Index = The_Time.indexOf(Model.Custom_Pass_Start) + Model.Custom_Pass_Start.length();

							The_Time = The_Time.substring(Index, Spliter[i].length() - Model.Custom_Pass_End.length());

						}
						String The_Pass = Spliter[i];

						if (The_Pass.length() != 0 && The_Pass != "") {
							int Index = The_Pass.indexOf(Model.Custom_Pass_Start);

							The_Pass = The_Pass.substring(0, Index);

						}

						if (The_Pass != "" && The_Pass.length() != 0 && The_Time != "" && The_Time.length() != 0) {

							Old_Password.put(The_Time, The_Pass);
						}
					}

				}

			}

			if (Old_Password.size() != 0) {

				return Old_Password;

			}

		}

		return null;
	}

	private static String Find_Value(String Pointer, String Source, char Seperation, Boolean Debug) {

		if (Debug == null) {
			Debug = false;
		}

		int Start_Index = Source.indexOf(Pointer) + Pointer.length();

		if (Debug) {

			// System.out.println("index start : " + Start_Index);
			// System.out.println("Source length : " + Source.length());
		}

		String Holder = "";

		for (int i = Start_Index; i < Source.length(); i++) {

			if (Debug) {

				// System.out.println("i : " + i);
			}

			if (Source.charAt(i) != Seperation) {

				Holder += Source.charAt(i);

			} else {
				break;
			}

		}

		if (Debug) {

			// System.out.println("Holder : " + Holder);
		}

		return Holder;
	}
	// ______________________________________________________________________________________

	private static String Handle_Enc(String Source, String Password) {

		if (Source.length() != 0) {

			String Holder = Caesar_Cipher_Final.Aes_Encryp(Source, Password);
			return Holder;
		}

		return "";
	}

	private static String Handle_Dec(String Source, String Password) {

		if (Source.length() != 0) {

			String Holder = Caesar_Cipher_Final.Aes_DeEncryp(Source, Password);
			// System.out.println(Holder);
			return Holder;
		}

		return "";
	}
	// ______________________________________________________________________________________

	public static boolean isValidPath(String path) {

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

	// ______________________________________________________________________________________

	public static String Generate_Folder() {

		String FileFolder = System.getenv("APPDATA") + "\\" + "Harpocrates";

		String os = System.getProperty("os.name").toUpperCase();
		if (os.contains("WIN")) {
			FileFolder = System.getenv("APPDATA") + "\\" + "Harpocrates";
		}
		if (os.contains("MAC")) {
			FileFolder = System.getProperty("user.home") + "/Harpocrates/Application " + "Support" + "Launcher";
		}
		if (os.contains("NUX")) {
			FileFolder = System.getProperty("user.dir") + ".Harpocrates";
		}

		File directory = new File(FileFolder);

		if (directory.exists() == false) {
			directory.mkdir();
		}
		return directory.getAbsolutePath();
	}

	// ______________________________________________________________________________________

}
