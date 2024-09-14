package Package;

import java.util.Map;
import java.util.Map.Entry;

public class Handle_Terminal {

	public static final String Option_Starter = "{";
	public static final String Option_End = "}";

	public static final Map<String, String> Commands1 = Map.ofEntries(Map.entry("Delete", ""));

	public static final Map<String, String> Commands = Map.ofEntries(Map.entry("Update All Expiration", ""),
			Map.entry("Update All Modification", ""), Map.entry("Update All Time Created", ""),
			Map.entry("Remove All Favorite", ""), Map.entry("Make All Favorite", ""), Map.entry("Help", ""));

	public static boolean Command_Valide(String Source) {

		boolean Validate = false;

		for (Entry<String, String> entry : Commands.entrySet()) {

			if (entry.getKey().toLowerCase().contains(Source.toLowerCase())) {
				Validate = true;
			}

		}

		return Validate;
	}

	public static String Handler(String Source, Node_Container Container) {

		String Temp = "";
		if (Container != null) {

			switch (Source) {
			case "Update All Expiration":
				// code block
				Container.Root.Update_Expiration();

				Temp = "All Expiration Updated";
				break;
			case "Update All Modification":
				// code block
				Container.Root.Update_Modification();
				Temp = "Update All Modification";

				break;
			case "Update All Time Created":
				// code block
				Container.Root.Update_Modification();
				Temp = "Update All Time Created";

				break;
			case "Remove All Favorite":
				// code block
				Container.Root.Update_Favorite(false);
				Temp = "Change all to normal ";

				break;
			case "Make All Favorite":
				// code block
				Container.Root.Update_Favorite(true);
				Temp = "Change all to favorite ";

				break;
			case "Generate New PassWord for All":
				// code block
				Container.Root.Update_PassWord(true);
				Temp = "PassWord Generated";

				break;
			case "Fix Links":
				// code block
				Container.Root.Establish_Link();
				Temp = "Links Established";

				break;
			case "Delete All":
				// code block
				Container.Root.Delete_Folder();

				Temp = "All Files Deleted";

				break;
			case "Clear Ram":
				// code block
				System.gc();

				Temp = "Garbage Collector";

				break;
			case "Help":
				// code block

				Temp += "Update All Expiration" + "\r\n";
				Temp += "Update All Modification" + "\r\n";
				Temp += "Update All Time Created" + "\r\n";
				Temp += "Remove All Favorite" + "\r\n";
				Temp += "Make All Favorite" + "\r\n";
				Temp += "Generate New PassWord for All" + "\r\n";
				Temp += "Delete All" + "\r\n";
				Temp += "Fix Links" + "\r\n";
				Temp += "Clear Ram" + "\r\n";
				Temp += "Help";

				break;
			default:
				// code block
			}
		}
		return Temp;

	}

}
