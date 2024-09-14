package Package;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Obfuscator_Reference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalTime Start_Time = LocalTime.now();

		char[] Temp = Remove_Control_Char(Generate_Symboles());

		// System.out.println(new String(Temp));
		LocalTime End_Time = LocalTime.now();

		Duration duration = Duration.between(Start_Time, End_Time);
		// System.out.println(Temp.length);

		// The numbers is limitless the length limite is 1024
		String[] newtemp = GenerateObfuscation(500, 80, Temp);
		// System.out.println(Arrays.toString(newtemp));

		String Final = String_Array_To_String(newtemp);
		String utf8EncodedString = new String(Final.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
		System.out.println(utf8EncodedString);
		System.out.println(Temp.length);

		System.err.println(duration);
		// ðŸ˜�
		Save(utf8EncodedString);

	}

	public final static char[] Generate_Symboles() {
		char[] Symboles = new char[65000];
		for (int i = 0; i < 65000; i++) {

			int a = i;
			char c = (char) a;

			Symboles[i] = c;

		}
		if (Symboles.length == 0) {
			return null;
		} else {
			return Symboles;
		}

	}

	public static String[] GenerateObfuscation(int Number, int Lenght, char[] charref) {
		if (Number > 0 && Lenght > 0) {
			Map<String, Integer> New = new HashMap<>();

			String[] Holder = new String[Number];

			String temp = "";
			while (New.size() < Number) {
				for (int j = 0; j < Lenght; j++) {

					temp += charref[Randome(charref.length)];
				}

				if (New.containsKey(temp) == false) {
					// System.out.println(temp);
					New.put(temp, 0);
					temp = "";
				}

			}

			if (New.size() > 0) {
				int Index = 0;
				for (Map.Entry<String, Integer> entry : New.entrySet()) {
					Holder[Index] = entry.getKey();
					Index++;
				}

				return Holder;
			}

		}
		return null;
	}

	public static String GenerateObfuscation1(int Number, int Lenght, char[] charref) {

		String[] test = GenerateObfuscation(Number, Lenght, charref);

		return String_Array_To_String(test);
	}

	public static String[] Remote_GenerateObfuscation(int Number, int Lenght) {
		char[] Temp = Remove_Control_Char(Generate_Symboles());
		String[] newtemp = GenerateObfuscation(Number, Lenght, Temp);
		return newtemp;

	}

	public static String Remote_GenerateObfuscation1(int Number, int Lenght) {
		char[] Temp = Remove_Control_Char(Generate_Symboles());
		String[] newtemp = GenerateObfuscation(Number, Lenght, Temp);
		return String_Array_To_String(newtemp);

	}

	public static char[] Remove_Control_Char(char[] Input) {

		String temp = new String(Input);
		// System.out.println(temp.length());
		temp = temp.replaceAll("\\p{Cntrl}", "");
		temp = temp.replaceAll("\\p{C}", "");
		temp = temp.replaceAll("[\\p{Cntrl}\\p{Cc}\\p{Cf}\\p{Co}\\p{Cn}\\p{Cs}]", "");

		// System.out.println(temp.length());

		return temp.toCharArray();
	}

	public static int Randome(int max) {

		int min = 0;
		int range = (max - 1) - min + 1;

		int rand = (int) (Math.random() * range) + min;

		return rand;

	}

	public static String String_Array_To_String(String[] Input) {

		String Holder = "";
		for (int i = 0; i < Input.length; i++) {

			if (i == 0) {
				Holder = Input[i];

			} else {

				Holder += "\r\n" + Input[i];
			}

		}

		return Holder;
	}

	public static void Save(CharSequence Input) {
		Path _Path = Paths.get(System.getProperty("user.dir") + "\\OBF.txt");

		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(_Path.toAbsolutePath().toString()),
				StandardCharsets.UTF_8)) {

			// do stuff
			writer.append(Input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		PrintWriter writer;
//		try {
//
//			// "C:\\Users\\asus\\Desktop\\filename.Enc"
//			writer = new PrintWriter(dir.toAbsolutePath().toString(), "UTF-8");
//
//			writer.print(Input+"î˜�î¾Žï’¤î—º");
//
//			writer.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		System.gc();
	}

}
