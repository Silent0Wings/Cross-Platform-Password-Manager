package Package;

import java.util.Map;
import java.util.Map.Entry;

public class Model {

	// _____________________________________Built In Export_____________
	public static final String Data_Header = "[[[{{{||||//[Data_Header:";
	public static final String Data_Header_End = "]\\||||}}}]]]";

	public static final String Start_Struct = "[{{{//#\\_Start_Struct_//#\\(((";
	public static final String End_Struct = ")))//#\\_End_Struct_//#\\}}}]";

	public static final String Start_Data = "[{{{//#\\_Start_Data_//#\\(((";
	public static final String End_Data = ")))//#\\_End_Data_//#\\}}}]";

	public static final String Single_Data_Start = "[[##{|||";
	public static final String Single_Data_End = "|||}##]]";

	public static final String Custom_Start = "{//||| ";
	public static final String Custom_End = "|||\\}";

	public static final String Custom_Note_Start = "[#{_|_|_|_#[";
	public static final String Custom_Note_End = "]#_|_|_|_}#]";

	public static final String Custom_Pass_Start = "{//[{[{//[";
	public static final String Custom_Pass_End = "]\\}]}]\\}";

	public static final Map<String, Integer> Entire_Model = Map.ofEntries(Map.entry(Data_Header, 1),
			Map.entry(Data_Header_End, 2), Map.entry(Start_Struct, 3), Map.entry(End_Struct, 4),
			Map.entry(Start_Data, 5), Map.entry(End_Data, 6), Map.entry(Single_Data_Start, 7),
			Map.entry(Single_Data_End, 8), Map.entry(Custom_Start, 9), Map.entry(Custom_End, 10),
			Map.entry(Custom_Note_Start, 11), Map.entry(Custom_Note_End, 12), Map.entry(Custom_Pass_Start, 13),
			Map.entry(Custom_Pass_End, 14));

	public static String Integrity(String Source) {

		if (Source != null) {

			if (Source != "" && Source.length() > 0) {

				for (Entry<String, Integer> entry : Model.Entire_Model.entrySet()) {

					if (Source.contains(entry.getKey())) {

						for (int i = 0; i < 100; i++) {
							if (Source.contains(entry.getKey())) {
								Source = Source.replace(entry.getKey(), "");

							} else {
								break;
							}
						}
					}

				}
			}
		}
		return Source;

	}

	// _____________________________________Csv_____________

	public static final String Csv_Inside_Seperator = "|";

	public static final String Csv_Capsule_Inside = "\"";

}
// } public static final Map<String, String> Old_Password = Map.of(Data_Header,
// "1", Data_Header_End, "2", Start_Struct,"3", End_Struct, "4", Start_Data,
// "5", End_Data, "6", Single_Data_Start, "7", Single_Data_End,
// "8",Custom_Start, "9", Custom_End, "10", Custom_Note_Start, "11",
// Custom_Note_End, "12", Custom_Pass_Start, "13",Custom_Pass_End, "14");

/*
 


*/