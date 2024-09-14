package Package;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.opencsv.CSVWriter;

public class Handle_Csv {

//	public static void main(String[] args) {
//		String test = "C:\\Users\\asus\\Data\\SAUVEGARD IMPORTANTE !!\\Firefox\\PasseWord\\09-05-2022.csv";
//
//		Node_Structure boum = new Node_Structure();
//		Handle_Firefox_Csv(test, boum);
//	}

	// ___________________________Import_______________________________________________________

	public static int countLinesOld(String filename) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}

	public static void Handle_Edge_Csv(String Path, Node_Structure Target_Folder) {

		String[] test = {};
		String[] test1 = {};
		Handle_Csv_Convert(Path, Target_Folder, test, test1, 1);
		// System.out.println("Files_Size : " + Target_Folder.Files_Size());
	}

	public static void Handle_Opera_Csv(String Path, Node_Structure Target_Folder) {

		String[] test = {};
		String[] test1 = {};
		Handle_Csv_Convert(Path, Target_Folder, test, test1, 1);
		// System.out.println("Files_Size : " + Target_Folder.Files_Size());
	}

	public static void Handle_Firefox_Csv(String Path, Node_Structure Target_Folder) {

		String[] test = { "\"\"", "\"" };
		String[] test1 = { " ", "" };
		Handle_Csv_Convert(Path, Target_Folder, test, test1, 0);
		// System.out.println("Files_Size : " + Target_Folder.Files_Size());

	}

	public static void Handle_Custom_Enc_Csv(String Path, Node_Structure Target_Folder) {

		String[] test = { "\"\"", "\"" };
		String[] test1 = { " ", "" };
		Handle_Csv_Custom_Convert(Path, Target_Folder, test, test1, 1);
		// System.out.println("Files_Size : " + Target_Folder.Files_Size());

	}

	public static void Handle_Chrome_Csv(String Path, Node_Structure Target_Folder) {
		String[] test = {};
		String[] test1 = {};
		Handle_Csv_Convert(Path, Target_Folder, test, test1, 1);
		// System.out.println("Files_Size : " + Target_Folder.Files_Size());

	}

	public static String Clean_Url(String test) {

		if (test != null && test.length() != 0) {

			test = test.replace("www.", "");
			test = test.replace("http://", "");
			test = test.replace("https://", "");
			test = test.replace("//", "");
			test = test.replace("/", "");
			test = test.replace(".com", "");
			test = test.replace(".co", "");
			test = test.replace(".fr", "");
			test = test.replace(".net", "");
			test = test.replace(".org", "");
			test = test.replace(".io", "");
			test = test.replace("login.", "");
			test = test.replace("signup.", "");
			test = test.replace(".", " ");

		}
		return test;

	}

	public static void Handle_Csv_Convert(String Path, Node_Structure Current_Structure, String[] Remove,
			String[] Replacement, int Offset) {
		String Header = "";
		String[] Header_Ref = null;
		String[][] Data = null;

		int Lenght = 0;
		int Number_Lines = 0;
		try {
			Number_Lines = countLinesOld(Path);

			// System.err.println(Number_Lines);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (Number_Lines > 0) {

			// parsing a CSV file into Scanner class constructor
			Scanner sc;
			try {
				sc = new Scanner(new File(Path));

				Header = sc.nextLine();

				Header = Clean_Csv(Remove, "", Header);
				Header = Model.Integrity(Header);
				Header = Header.replaceAll(" ", "");
				Header = Header.replace("\"", "");
				// System.out.println(Header);
				Header_Ref = Header.split(Pattern.quote(","));
				Lenght = Header_Ref.length;
//				//System.out.println("Lenght " + Lenght);
//				//System.out.println("Number_Lines " + Number_Lines);
//				//System.out.println(Arrays.toString(Header_Ref));
				if (Lenght <= 0) {
					sc.close();
				}
				int index = 0;

				Data = new String[Number_Lines - Offset][Header_Ref.length];
				System.err.println("Data Lenght " + Data.length);
				while (sc.hasNext()) // returns a boolean value
				{

					// System.out.println(index);
					String Temp = sc.nextLine();
					// System.out.println("Temp "+Temp);

					Temp = Clean_Csv(Remove, Replacement, Temp);

					String[] temp_Split = Temp.split(Pattern.quote(","));

					// System.out.println(Arrays.toString(temp_Split));
					// System.out.println("||Index : "+index);

					for (int i = 0; i < Lenght; i++) {
						// System.out.println("Index i : "+i);
						Data[index][i] = temp_Split[i];
					}
					// System.out.println(Arrays.toString(temp_Split));
					index++;

				}
				sc.close(); // closes the scanner
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println(Arrays.toString(Header_Ref));

			// System.out.println(Arrays.toString(Data[0]));

//			//System.out.println(Data[0][3].equals("QSDQSDQSDQSDQSDQSD"));
			// System.out.println("|" + Data[0][3] + "|");

			// System.out.println(Data.length);

			Node_File[] All_Files = new Node_File[Data.length];

			for (int i = 0; i < Data.length; i++) {

				Node_File Temp_file = new Node_File();
				All_Files[i] = Temp_file;
				for (int j = 0; j < Data[i].length; j++) {

					String Header_Type = Header_Ref[j];

					// Name,"Title","User_Name","Password","Url","KeyWord","Expiration","Modified","Time_Created","Note","Favorite","Old_Password"
					switch (Header_Type) {
					case "name":
					case "Name":
						Temp_file.setName(Data[i][j]);
						break;
					case "title":
					case "Title":
						Temp_file.setTitle(Data[i][j]);
						break;
					case "username":
					case "User_Name":
						Temp_file.setUser_Name(Data[i][j]);
						break;
					case "password":
					case "Password":
						Temp_file.setPassword(Data[i][j]);
						break;
					case "url":
					case "Url":
						Temp_file.setUrl(Data[i][j]);
						break;
					case "KeyWord":
					case "keyword":
						Temp_file.setKeyWord(Data[i][j]);
						break;
					case "Expiration":
					case "expiration":
						long num = Long.parseLong(Data[i][j]);
						LocalDateTime date = Instant.ofEpochMilli(num).atZone(ZoneId.systemDefault()).toLocalDateTime();
						Temp_file.setExpiration(date);
						break;
					case "timeCreated":
					case "Time_Created":
						long num1 = Long.parseLong(Data[i][j]);
						LocalDateTime date1 = Instant.ofEpochMilli(num1).atZone(ZoneId.systemDefault())
								.toLocalDateTime();
						Temp_file.setTime_Created(date1);
						break;
					case "timePasswordChanged":
					case "Modified":
						long num11 = Long.parseLong(Data[i][j]);
						LocalDateTime date11 = Instant.ofEpochMilli(num11).atZone(ZoneId.systemDefault())
								.toLocalDateTime();
						Temp_file.setModified(date11);
						break;
					case "Note":
						Temp_file.setNote(Data[i][j]);
						break;
					case "Favorite":
					case "favorite":
						Temp_file.setFavorite(Boolean.parseBoolean(Data[i][j]));
						break;
					case "Old_Password":
					case "old_password":

						if (Data[i][j] != null && Data[i][j].length() != 0 && Data[i][j] != "") {

							String OP_Temp = Data[i][j];
							if (OP_Temp.contains(Model.Csv_Inside_Seperator)) {

								String[] Op_Sep = OP_Temp.split(Model.Csv_Inside_Seperator);
								// System.err.println(Arrays.toString(Op_Sep));
								Temp_file.setOld_Password(Op_Sep);

							} else {

								Temp_file.setOld_Password(OP_Temp);
								// System.err.println(OP_Temp);

							}
						}
						break;
					}

					// no name selected then we generate a name
					if (Temp_file.getName() == null || Temp_file.getName() == "" || Temp_file.getName().length() == 0) {

						if (Temp_file.getUrl() == null || Temp_file.getUrl() == ""
								|| Temp_file.getUrl().length() == 0) {
							Temp_file.setName(LocalDateTime.now().toString());

						} else {

							Temp_file.setName(Clean_Url(Temp_file.getUrl()));
						}

					}

				}
			}

			// System.out.println(All_Files);
			// System.out.println("length" + All_Files.length);

			Handle_Files(All_Files, Current_Structure);

		}

	}

	public static void Handle_Csv_Custom_Convert(String Path, Node_Structure Current_Structure, String[] Remove,
			String[] Replacement, int Offset) {
		String Header = "";
		String[] Header_Ref = null;
		String[][] Data = null;

		int Lenght = 0;
		int Number_Lines = 0;
		try {
			Number_Lines = countLinesOld(Path);

			// System.err.println(Number_Lines);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (Number_Lines > 0) {

			// parsing a CSV file into Scanner class constructor
			Scanner sc;
			try {
				sc = new Scanner(new File(Path));

				Header = sc.nextLine();

				Header = Clean_Csv(Remove, "", Header);
				Header = Model.Integrity(Header);
				Header = Header.replaceAll(" ", "");
				Header = Header.replace("\"", "");

				// System.out.println(Header);
				Header_Ref = Header.split(Pattern.quote(","));
				Lenght = Header_Ref.length;
//				//System.out.println("Lenght " + Lenght);
//				//System.out.println("Number_Lines " + Number_Lines);
//				//System.out.println(Arrays.toString(Header_Ref));
				if (Lenght <= 0) {
					sc.close();
				}
				int index = 0;

				Data = new String[Number_Lines - Offset][Header_Ref.length];
				System.err.println("Data Lenght " + Data.length);
				while (sc.hasNext()) // returns a boolean value
				{

					// System.out.println(index);
					String Temp = sc.nextLine();
					// System.out.println("Temp "+Temp);

					Temp = Clean_Csv(Remove, Replacement, Temp);

					String[] temp_Split = Temp.split(Pattern.quote(","));

					// System.out.println(Arrays.toString(temp_Split));
					// System.out.println("||Index : "+index);

					for (int i = 0; i < Lenght; i++) {
						// System.out.println("Index i : "+i);
						Data[index][i] = temp_Split[i];
					}
					// System.out.println(Arrays.toString(temp_Split));
					index++;

				}
				sc.close(); // closes the scanner
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println(Arrays.toString(Header_Ref));

			// System.out.println(Arrays.toString(Data[0]));

//			//System.out.println(Data[0][3].equals("QSDQSDQSDQSDQSDQSD"));
			// System.out.println("|" + Data[0][3] + "|");
//			System.err.println("Header_Ref" + Header_Ref.length);
//
//			System.err.println("Data[0]" + Data[0].length);
//			System.err.println("Data[1]" + Data[1].length);

			// System.out.println(Data.length);

			if (Data[0].length != Header_Ref.length) {
				System.err.println("Fatal Header != to number of collums");

				return;
			}

			Node_File[] All_Files = new Node_File[Data.length];

			for (int i = 0; i < Data.length; i++) {

				Node_File Temp_file = new Node_File();
				All_Files[i] = Temp_file;
				for (int j = 0; j < Data[i].length; j++) {

					String Header_Type = Header_Ref[j];

					// Name,"Title","User_Name","Password","Url","KeyWord","Expiration","Modified","Time_Created","Note","Favorite","Old_Password"
					switch (Header_Type) {
					case "name":
					case "Name":
						Temp_file.setName(Data[i][j]);

						break;
					case "title":
					case "Title":
						Temp_file.setTitle(Data[i][j]);
						break;
					case "username":
					case "User_Name":
						Temp_file.setUser_Name(Data[i][j]);
						break;
					case "password":
					case "Password":
						Temp_file.setPassword(Data[i][j]);
						break;
					case "url":
					case "Url":
						Temp_file.setUrl(Data[i][j]);
						break;
					case "KeyWord":
					case "keyword":
						Temp_file.setKeyWord(Data[i][j]);
						break;
					case "Expiration":
					case "expiration":

						Temp_file.setExpiration(Data[i][j]);
						break;
					case "timeCreated":
					case "Time_Created":

						Temp_file.setTime_Created(Data[i][j]);
						break;
					case "timePasswordChanged":
					case "Modified":

						Temp_file.setModified(Data[i][j]);
						break;
					case "Note":
						Temp_file.setNote(Data[i][j]);
						break;
					case "Favorite":
					case "favorite":
						Temp_file.setFavorite(Boolean.parseBoolean(Data[i][j]));
						break;
					case "Old_Password":
					case "old_password":

						if (Data[i][j] != null && Data[i][j].length() != 0 && Data[i][j] != "") {

							String OP_Temp = Data[i][j];
							if (OP_Temp.contains(Model.Csv_Inside_Seperator)) {

								// System.out.println(OP_Temp);
								String[] Op_Sep = OP_Temp.split(Pattern.quote(Model.Csv_Inside_Seperator));
								// System.out.println(Model.Csv_Inside_Seperator);
								// System.out.println(Arrays.toString(Op_Sep));
								Temp_file.setOld_Password(Op_Sep);

							} else {

								Temp_file.setOld_Password(OP_Temp);
							}
						}
						break;

					}

					// no name selected then we generate a name
					if (Temp_file.getName() == null || Temp_file.getName() == "" || Temp_file.getName().length() == 0) {

						if (Temp_file.getUrl() == null || Temp_file.getUrl() == ""
								|| Temp_file.getUrl().length() == 0) {
							Temp_file.setName(LocalDateTime.now().toString() + i);

						} else {

							Temp_file.setName(Clean_Url(Temp_file.getUrl()));
						}

					}

				}

			}

			// System.out.println(All_Files);
			// System.out.println("length" + All_Files.length);

			Handle_Files(All_Files, Current_Structure);

		}

	}

	public static void Handle_Files(Node_File[] All_Files, Node_Structure Current_Structure) {

		for (int i = 0; i < All_Files.length; i++) {

			if (Current_Structure.File_Children.containsKey(All_Files[i].getName()) == false) {

				Current_Structure.Add_File(All_Files[i]);
			} else {

				All_Files[i].setName(All_Files[i].getName() + " " + i);
				Current_Structure.Add_File(All_Files[i]);
			}

		}

		Current_Structure.Establish_Link();

	}

	public static String Clean_Csv(String[] Remove, String[] Replacement, String Source) {

		if (Remove.length != 0 && Replacement.length != 0) {

			for (int i = 0; i < Remove.length; i++) {

				Source = Source.replaceAll(Remove[i], Replacement[i]);
			}
		}

		return Source;

	}

	public static String Clean_Csv(String[] Remove, String Replacement, String Source) {
		if (Remove.length != 0) {

			for (int i = 0; i < Remove.length; i++) {

				Source = Source.replaceAll(Remove[i], Replacement);
			}
		}

		return Source;
	}
	// ___________________________Import && Export Enc Csv__________________________

	public static void Export_Csv(Node_Structure The_Struct, String Path) {

		List<String[]> Final = CreateCsvFromArrays(The_Struct);

		// default all fields are enclosed in double quotes
		// default separator is a comma
		try (CSVWriter writer = new CSVWriter(new FileWriter(Path))) {
			writer.writeAll(Final);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static List<String[]> CreateCsvFromArrays(Node_Structure Struct) {

		List<String[]> Final = new ArrayList<>();
		;

		@SuppressWarnings("unused")
		String[] Lines = null;
		if (Struct != null) {

			String[] Header = new Node_File().Data_Header();
			Final.add(Header);

			if (Struct.Files_Size() != 0) {

				List<Node_File> Temp = Struct.Compact_Files();

				if (Temp.size() != 0) {
					Lines = new String[Temp.size()];
					for (int i = 0; i < Temp.size(); i++) {
						Final.add(Temp.get(i).Compact_Data_Array());
					}
				}
			}

		}

		return Final;
	}

	// ________________________________________________________________________________________

}