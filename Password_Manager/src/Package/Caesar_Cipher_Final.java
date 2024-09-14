package Package;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;


//import Testing.Obfuscator_Reference;

@SuppressWarnings("unused")
public class Caesar_Cipher_Final {

	// Final Dont use it for non ascii characters !!

	// Dangerous side efffect my encryption is abnormally slow
	// 3 Options:
	// 1- Abondone my encryption and stick whit Aes
	// 2- Heavely optimize encryption from scratch and that enclude the shifting and
	// the ceasar cipher
	// 3- abondone all the elements and use the simple String shufle
	// methode!!!!!!!!!!!!!!!!!!!

	// Fatale Errore after importing csv firefox passwords and saving its impossible
	// Possible cause non ascii characters
	// (Confirmation aes256 not accepting certain non ascii characters !!!!)
	// !!!!!!!!!!!!!!!!!!
	// to load back
	// Probleme Identified Importing a unique character from csv file causes this
	// conflict

	// Fatale Erore : after debuging the source of the errore is the use of extended
	// ascii table non printable and control characters

	// Potential error in shufle methode avoid for now

	// 1 000 000 =1M words & 10 character passwords encryption and decryption in 2.8
	// seconds

	// 1 000 000 =1M characters enrypted whit aes in 1 Minute 8.3 Seconds

	static char[] Alphab = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	static char[] Rev_Alphab = { 'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j',
			'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a' };
	static char[] Cap_Alphab = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	static char[] Rev_Cap_Alphab = { 'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K',
			'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A' };

	static int[] Numerical = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int[] Rev_Numerical = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

//	private static char[] Alpha_Numeric = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
//			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
//			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4',
//			'5', '6', '7', '8', '9' };

	static char[] Symbole;
	static char[] Rev_Symbole;

//	{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' }
//	h e l  l  o  M  o  n  k  e
//	8 5 12 12 16 13 16 14 11 5
//	1 2 3  4  5  6  7  8  9  10
//	                      |
//
//	1{ '7', '1', '2', '3', '4', '5', '6',  '0', '8', '9' }
//
//	2{ '7', '4', '2', '3', '1', '5', '6',  '0', '8', '9' }
//
//	3{ '7', '2', '4', '3', '1', '5', '6',  '0', '8', '9' }
//
//	4{ '7', '3', '5', '1', '2', '4', '6',  '0', '8', '9' }
//	 
//	5{ '7', '3', '5', '1','4' , '2', '6',  '0', '8', '9' }
//
//	6{ '7', '3', '2' ,'1','4' , '5', '6',  '0', '8', '9' }
//
//	7{ '7', '3', '2' ,'1','4' , '6', '5',  '0', '8', '9' }
//
//	8{ '8', '3', '2' ,'0','4' , '6', '5',  '1', '7', '9' }
//
//	9{ '8', '3', '2' ,'0','4' , '6', '5',  '1', '7', '9' }
//
//
//
//	SHUFLE THE POSITION BY THE VALUE OF THE LETTER
//_________________________________________________________________________________________________________
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalTime Start_Time = LocalTime.now();
//		Aes_Test();
		Extended_Test();
		LocalTime End_Time = LocalTime.now();

		Duration duration = Duration.between(Start_Time, End_Time);

		System.err.println(duration);
	}

	public final static String Aes_Encryp(String Source, String Secret_Word) {
		// TODO Auto-generated method stub

		// String temp = Normal_Encryp(Source, Secret_Word);

		String temp = AES256.Aes256_Encrypt(Source, Secret_Word);

		return temp;

	}

	public final static String Aes_DeEncryp(String Source, String Secret_Word) {
		// TODO Auto-generated method stub

		String temp = AES256.Aes256_Decrypt(Source, Secret_Word);

		// temp = Normal_DeEncryp(temp, Secret_Word);

		return temp;

	}

	public final static String Normal_Encryp(String Source, String Secret_Word) {
		// TODO Auto-generated method stub

		// String Secret_Word = "HelloMonkey//3";

//		String Source = "0123456789Monkey is a common name that may refer to most mammals of the infraorder Simiiformes, "
//				+ "also known as the simians. Traditionally, all animals in the group now known as simians are"
//				+ " counted as monkeys except the apes, a grouping known as paraphyletic; however, in the broader"
//				+ " sense based on cladistics, apes (Hominoidea) are also included, making the terms monkeys and"
//				+ " simians synonyms in regards to their scope.[citation needed][3] ";

		Symbole = Generate_Symboles();
		// System.out.println(Symbole.length);

		// Shuflle_Num_Alpha_Symb(Secret_Word);

		char[] key = (Clean_Cipher_Key(Secret_Word));
		// System.out.println(key);

		char[] Chiper_Ref = (Creat_Cipher_Ref(key, Alphab));
		// System.out.println(Chiper_Ref);

		String Final = Apply_Alpha_Cipher(Source, Chiper_Ref);
		// System.out.println(Final);

		int[] num_key = Clean_Cipher_Numerical_Key(Secret_Word);
		// System.out.println(Arrays.toString(num_key));

		int[] num_ref = Creat_Cipher_Numerical_Ref(num_key, Numerical);
		// System.out.println(Arrays.toString(num_ref));

		String Final_Num = Apply_Numerical_Cipher(Final, num_ref);
		// System.out.println(Final_Num);

		int[] symbole_key = Clean_Cipher_Symbole_Key(Secret_Word);
		// System.out.println(Arrays.toString(symbole_key));

		char[] symbole_Ref = Creat_Cipher_Symbole_Ref(symbole_key, Symbole);
		// System.out.println(Arrays.toString(symbole_Ref));

		String Final_Sym = Apply_Symbole_Cipher(Final_Num, symbole_Ref);

		// Final_Sym = String_Shuflle(Final_Sym, Secret_Word);

		Final_Sym = String_Shuflle(Final_Sym, Secret_Word);

		return Final_Sym;

	}

	public final static String Normal_DeEncryp(String Source, String Secret_Word) {
		// TODO Auto-generated method stub

		// |||====================================Solving=====================================|||
		Symbole = Generate_Symboles();
		// System.out.println(Symbole.length);
		// Shuflle_Num_Alpha_Symb(Secret_Word);

		Source = String_UnShuflle(Source, Secret_Word);

		int[] symbole_key = Clean_Cipher_Symbole_Key(Secret_Word);

		char[] key = (Clean_Cipher_Key(Secret_Word));

		int[] num_key = Clean_Cipher_Numerical_Key(Secret_Word);

		// Source = String_UnShuflle(Source, Secret_Word);

		String Solved_Sym = Reverse_Symbole_Cipher(Source, symbole_key);
		// System.out.println(Solved_Sym);

		String Solved_Num = Reverse_Numerical_Cipher(Solved_Sym, num_key);
		// System.out.println(Solved_Num);

		String Solver = Reverse_Alpha_Cipher(Solved_Num, key);
		// System.out.println(Solver);

		return Solver;

	}

	// _________________________________________________________________________________________________________

	private static void Aes_Test() {
		System.out.println("Aes_Test");
		int errors = 0;

		int max = 1;

		String Test = "0123456789Monkey is a common name that may refer to most mammals of the infraorder Simiiformes, "
				+ "also known as the simians. Traditionally, all animals in the group now known as simians are"
				+ " counted as monkeys except the apes, a grouping known as paraphyletic; however, in the broader"
				+ " sense based on cladistics, apes (Hominoidea) are also included, making the terms monkeys and"
				+ " simians synonyms in regards to their scope.[citation needed][3] ";
		for (int i = 0; i < max; i++) {
			String Pass = "152" + "ya" + Generate_Password.RemoteGeneratePassword(100, 1, 1, 1, 1);

			System.out.println(i);
			// System.out.println(Test);

			String Holder = Aes_Encryp(Test, Pass);

			String Final = Aes_DeEncryp(Holder, Pass);

			if (Final.equals(Test)) {

			} else {
				errors++;

			}

		}
		if (errors != 0) {
			System.out.println("Alot Errors : " + errors + " Out of " + max);

		} else {

			System.out.println("No Errors");
		}

		System.out.println("End_______________________");
	}

	private final static void Combined_Types_Test() {

		String Secret_Word = "HelloMonkey//3";

		String test = "0123456789Monkey is a common name that may refer to most mammals of the infraorder Simiiformes, "
				+ "also known as the simians. Traditionally, all animals in the group now known as simians are"
				+ " counted as monkeys except the apes, a grouping known as paraphyletic; however, in the broader"
				+ " sense based on cladistics, apes (Hominoidea) are also included, making the terms monkeys and"
				+ " simians synonyms in regards to their scope.[citation needed][3] ";

		char[] key = (Clean_Cipher_Key(Secret_Word));
		// System.out.println(key);

		char[] Chiper_Ref = (Creat_Cipher_Ref(key, Alphab));
		// System.out.println(Chiper_Ref);

		String Final = Apply_Alpha_Cipher(test, Chiper_Ref);
		// System.out.println(Final);

		int[] num_key = Clean_Cipher_Numerical_Key(Secret_Word);
		// System.out.println(Arrays.toString(num_key));

		int[] num_ref = Creat_Cipher_Numerical_Ref(num_key, Numerical);
		// System.out.println(Arrays.toString(num_ref));

		String Final_Num = Apply_Numerical_Cipher(Final, num_ref);
		// System.out.println(Final_Num);

		Symbole = Generate_Symboles();
		// System.out.println(Symbole.length);

		int[] symbole_key = Clean_Cipher_Symbole_Key(Secret_Word);
		// System.out.println(Arrays.toString(symbole_key));

		char[] symbole_Ref = Creat_Cipher_Symbole_Ref(symbole_key, Symbole);
		// System.out.println(Arrays.toString(symbole_Ref));

		String Final_Sym = Apply_Symbole_Cipher(Final_Num, symbole_Ref);
		System.out.println(Final_Sym);

		// System.out.println(Final_Sym);

		// |||====================================Solving=====================================|||

		String Solved_Sym = Reverse_Symbole_Cipher(Final_Sym, symbole_key);
		// System.out.println(Solved_Sym);

		String Solved_Num = Reverse_Numerical_Cipher(Solved_Sym, num_key);
		// System.out.println(Solved_Num);

		String Solver = Reverse_Alpha_Cipher(Solved_Num, key);
		// System.out.println(Solver);

		if (Solver.equals(test)) {

			System.err.println("Identical !!");

		} else {

			System.out.println("________________________________________________");

			System.err.println("Errore");
		}

	}

	private final static void Extended_Test() {

		int num_err = 0;
		int max = 100;
		for (int i = 0; i < max; i++) {

			String Secret_Word = Generate_Password.RemoteGeneratePassword(1, 1, 1, 1, 0, 0, "") + "12345abcdsf";

			String test = Obfuscator_Reference.Remote_GenerateObfuscation1(10, 1);

			char[] key = (Clean_Cipher_Key(Secret_Word));
			// System.out.println(key);

			char[] Chiper_Ref = (Creat_Cipher_Ref(key, Alphab));
			// System.out.println(Chiper_Ref);

			String Final = Apply_Alpha_Cipher(test, Chiper_Ref);
			// System.out.println(Final);

			int[] num_key = Clean_Cipher_Numerical_Key(Secret_Word);
			// System.out.println(Arrays.toString(num_key));

			int[] num_ref = Creat_Cipher_Numerical_Ref(num_key, Numerical);
			// System.out.println(Arrays.toString(num_ref));

			String Final_Num = Apply_Numerical_Cipher(Final, num_ref);
			// System.out.println(Final_Num);

			Symbole = Generate_Symboles();
			// System.out.println(Symbole.length);

			int[] symbole_key = Clean_Cipher_Symbole_Key(Secret_Word);
			// System.out.println(Arrays.toString(symbole_key));

			char[] symbole_Ref = Creat_Cipher_Symbole_Ref(symbole_key, Symbole);
			// System.out.println(Arrays.toString(symbole_Ref));

			String Final_Sym = Apply_Symbole_Cipher(Final_Num, symbole_Ref);
			// System.out.println(Final_Sym);

			// System.out.println(Final_Sym);

			// |||====================================Solving=====================================|||

			String Solved_Sym = Reverse_Symbole_Cipher(Final_Sym, symbole_key);
			// System.out.println(Solved_Sym);

			String Solved_Num = Reverse_Numerical_Cipher(Solved_Sym, num_key);
			// System.out.println(Solved_Num);

			String Solver = Reverse_Alpha_Cipher(Solved_Num, key);
			// System.out.println(Solver);

			if (Solver.equals(test)) {

				// System.err.println("Identical !!");

				num_err++;
			} else {

				System.out.println("________________________________________________");
				System.err.println("Errore");
				System.out.println("________________________________________________");
				System.out.println(Final_Sym);
				System.out.println("================================================");
				System.out.println(Solver);

			}
		}

		System.out.println(num_err + " out of " + max);

	}

	private final static void All_Types_Test() {
		String Secret_Word = "HelloMonkey";

		String test = "0123456789Monkey is a common name that may refer to most mammals of the infraorder Simiiformes, "
				+ "also known as the simians. Traditionally, all animals in the group now known as simians are"
				+ " counted as monkeys except the apes, a grouping known as paraphyletic; however, in the broader"
				+ " sense based on cladistics, apes (Hominoidea) are also included, making the terms monkeys and"
				+ " simians synonyms in regards to their scope.[citation needed][3] ";

		char[] key = (Clean_Cipher_Key(Secret_Word));
		// System.out.println(key);

		char[] Chiper_Ref = (Creat_Cipher_Ref(key, Alphab));
		// System.out.println(Chiper_Ref);

		String Final = Apply_Alpha_Cipher(test, Chiper_Ref);
		// System.out.println(Final);

		String Solver = Reverse_Alpha_Cipher(Final, key);
		// System.out.println(Solver);

		if (Solver.equals(test)) {
			System.err.println("Alpha Identical !!");

		}

		// System.out.println(Generate_Symboles().length);

		int[] num_key = Clean_Cipher_Numerical_Key(Secret_Word);
		// System.out.println(Arrays.toString(num_key));

		int[] num_ref = Creat_Cipher_Numerical_Ref(num_key, Numerical);
		// System.out.println(Arrays.toString(num_ref));

		String Final_Num = Apply_Numerical_Cipher(test, num_ref);
		// System.out.println(Final_Num);

		String Solved_Num = Reverse_Numerical_Cipher(Final_Num, num_key);
		// System.out.println(Solved_Num);

		if (Solved_Num.equals(test)) {
			System.err.println("Num Identical !!");

		}

		Symbole = Generate_Symboles();
		// System.out.println(Symbole.length);
		int[] symbole_key = Clean_Cipher_Symbole_Key(Secret_Word);
		// System.out.println(Arrays.toString(symbole_key));

		char[] symbole_Ref = Creat_Cipher_Symbole_Ref(symbole_key, Symbole);
		// System.out.println(Arrays.toString(symbole_Ref));

		String Final_Sym = Apply_Symbole_Cipher(test, symbole_Ref);
		// System.out.println(Final_Sym);

		String Solved_Sym = Reverse_Symbole_Cipher(Final_Sym, symbole_key);
		// System.out.println(Solved_Sym);

		if (Solved_Sym.equals(test)) {
			System.err.println("Sym Identical !!");

		}
	}

	// _________________________________________________________________________________________________________
	// Dangerous full of errors dont use until fixed !!!!!!!!!!!!!!!!!!!!!!!!

	// Shufles References a to z and 0 to 9 and symboles

	private static void Shuflle_Num_Alpha_Symb(String Key) {

		// Numerical =Numerical_Capsule();
		// Symbole_Capsule_Char();

//		System.out.println(Arrays.toString(Char_Array_To_Ascii_Array(Char_Numerical)));
//		System.out.println(Arrays.toString(Char_Array_To_Int_Array(Char_Numerical)));
//		System.out.println(Arrays.toString(Int_Array_To_Char_Array(Numerical)));

		Numerical = Char_Array_To_Int_Array(Numerical_Capsule_Char(Int_Array_To_Char_Array(Numerical), Key));

		Alphab = Numerical_Capsule_Char(Alphab, Key);

		Symbole = Symbole_Capsule_Char(Symbole, Key);

	}

	private static void UnShuflle_Num_Alpha_Symb(String Key) {
		Numerical = Char_Array_To_Int_Array(Reverse_Numerical_Capsule_Char(Int_Array_To_Char_Array(Numerical), Key));

		Alphab = Reverse_Numerical_Capsule_Char(Alphab, Key);

		Symbole = Reverse_Symbole_Capsule_Char(Symbole, Key);
	}

	// _________________________________________________________________________________________________________

	private static String String_Shuflle(String Source, String Key) {

		Source = new String(Numerical_Capsule_Char(Source.toCharArray(), Key));

		return Source;
	}

	private static String String_UnShuflle(String Source, String Key) {

		Source = new String(Reverse_Numerical_Capsule_Char(Source.toCharArray(), Key));

		return Source;

	}

	// _________________________________________________________________________________________________________
	private final static char[] Clean_Cipher_Key(String Source) {

		// in this case we clean the password by removing every duplicate letters as in
		// hello = helo
		// any password biger than 26 get cut to it first 26 letters
		// and all caps letters are turned to lower case
		// example Hello123 => helo

		String Original = Source;
		Original = Original.toLowerCase();

		if (Original.length() > Alphab.length) {

			Original = Original.substring(0, Alphab.length);
		}

		// convert String to char[]
		char[] String_to_char = Retrieve_Alphabets(Original);

		// clear all the duplicates
		// example : he lo
		int ref = 0;

		for (int i = 0; i < String_to_char.length; i++) {
			int avoid = i;

			for (int t = 0; t < String_to_char.length; t++) {

				if (String_to_char[i] == String_to_char[t] && t != avoid && String_to_char[i] != ' ') {

					String_to_char[t] = ' ';
					ref++;

				}
			}
		}
		// Delete the created space
		// example : helo

		String Cleaned = "";
		char[] Finaltchar = new char[String_to_char.length - ref];

		int index = 0;
		for (int i = 0; i < String_to_char.length; i++) {

			if (String_to_char[i] != ' ') {
				Cleaned += String_to_char[i];
				Finaltchar[index] = String_to_char[i];
				index++;
			}
		}
		return Finaltchar;
	}

	private final static char[] Creat_Cipher_Ref(char[] key, char[] Ref) {

		// this is ower password "helo" in its cleaned form
		// we first start by removing every character in the password from the
		// alphabetic reference
		// abcdefghijklmnopqrstuvwxyz => abcdfgijkmnpqrstuvwxyz
		// the we move the password cleaned alphabets to the end of the alphabetic
		// reference
		// >abcdfgijkmnpqrstuvwxyzhelo wich is ower new alphabetic reference

		char[] alpha_Ref = Ref.clone();
		// example : hello

		// clear all the duplicates
		// example : he lo
		int ref = 0;
		for (int i = 0; i < key.length; i++) {

			for (int t = 0; t < alpha_Ref.length; t++) {

				if (key[i] == alpha_Ref[t]) {

					alpha_Ref[t] = ' ';
					ref++;

				}
			}
		}
		// Delete the created space
		// example : helo
		String Cleaned = "";
		char[] Finaltchar = new char[alpha_Ref.length - ref];

		int index = 0;
		for (int i = 0; i < alpha_Ref.length; i++) {

			if (alpha_Ref[i] != ' ') {
				Cleaned += alpha_Ref[i];
				Finaltchar[index] = alpha_Ref[i];
				index++;
			}
		}

		char[] Final = new char[alpha_Ref.length];

		for (int i = 0; i < Finaltchar.length; i++) {

			Final[i] = Finaltchar[i];
		}

		for (int i = 0; i < key.length; i++) {
			Final[i + Finaltchar.length] = key[i];
		}

		return Final;
	}

	private final static String Apply_Alpha_Cipher(String Source, char[] Cipher_Ref) {

		// so lets say this is ower reference alphabetical "abcdfgijkmnpqrstuvwxyzhelo"
		// now we start making all caps form of it to be able to handle upper case
		// characters
		// then we iterate throw every character of ower text
		// lets say ower text is "hello Monkey"
		// the first letter is h and h is the 7th letter of the alphabet
		// now if we go to the cipher alpha ref and we look for the 7th letter
		// it becomes j as in Cipher_Ref[7]=j meaning every h becomes a j

		char[] Cipher_Ref_Upper_case = new char[Cipher_Ref.length];

		// char fUpper = Character.toUpperCase(f);

		for (int i = 0; i < Cipher_Ref.length; i++) {

			Cipher_Ref_Upper_case[i] = Character.toUpperCase(Cipher_Ref[i]);
		}

		String Final = "";
		for (int i = 0; i < Source.length(); i++) {

			char temp_char = Source.charAt(i);

			if (Is_Alphabet(temp_char)) {

				if (Is_Alphabet_Lower(temp_char)) {
					int temp1 = Retrieve_Char_Index1(temp_char, Alphab);
					Final += Cipher_Ref[(int) temp1];

				} else if (Is_Alphabet_Upper(temp_char)) {
					int temp2 = Retrieve_Char_Index1(temp_char, Cap_Alphab);
					Final += Cipher_Ref_Upper_case[(int) temp2];

				} else {
					Final += temp_char;

				}

			} else {
				Final += temp_char;

			}

		}

		return Final;
	}

	private final static String Reverse_Alpha_Cipher(String Source, char[] key) {

		// we start by building the cipher reference from the cleaned password
		// so lets say this is ower reference alphabetical "abcdfgijkmnpqrstuvwxyzhelo"
		// now we start making all caps form of it to be able to handle upper case
		// characters
		// then we iterate throw every character of ower text
		// lets say ower text is "jfpps Qsrnfl"
		// the first letter is j and j is the 7th letter inside the cipher ref
		// abcdefghijklmnopqrstuvwxyz this is the alphabet the 7th letter in this is h
		// as in
		// meaning every j becomes h
		// meaning every f becomes e and so on

		char[] Cipher_Ref = Creat_Cipher_Ref(key, Alphab);

		char[] Cipher_Ref_Upper_case = new char[Cipher_Ref.length];

		// char fUpper = Character.toUpperCase(f);

		for (int i = 0; i < Cipher_Ref.length; i++) {

			Cipher_Ref_Upper_case[i] = Character.toUpperCase(Cipher_Ref[i]);
		}

		String Final = "";
		for (int i = 0; i < Source.length(); i++) {

			char temp_char = Source.charAt(i);

			Object[] temp1 = Retrieve_Char_Index(temp_char, Cipher_Ref);
			Object[] temp2 = Retrieve_Char_Index(temp_char, Cipher_Ref_Upper_case);

			if ((boolean) temp1[0]) {

				Final += Alphab[(int) temp1[1]];

			} else if ((boolean) temp2[0]) {

				Final += Cap_Alphab[(int) temp2[1]];

			} else {

				Final += temp_char;
			}

		}

		return Final;
	}

	// _________________________________________________________________________________________________________
	private final static int[] Clean_Cipher_Numerical_Key(String Key) {

		// I take the letters inside the password remove all other characters
		// then i put them to lower case,i then get the reference of eache letter
		// so basicly if the alphabetical order is a b c ... then a =1 b =2 ...
		// if the pass word countains a , b then this methode returns 1 , 2

		if (Key.length() > Numerical.length) {

			Key = Key.substring(0, Numerical.length);
		}

		String temp = "";

		Key = new String(Retrieve_Alphabets(Key));

		String Temp_Source = Key.toLowerCase();

		// String to char[]
		char[] Numerical_Key = Temp_Source.toCharArray();

		// int[] of alphabetic reference of the key
		int[] Final_Key = new int[Numerical_Key.length];
		for (int i = 0; i < Numerical_Key.length; i++) {

			Object[] temp1 = Retrieve_Char_Index(Numerical_Key[i], Alphab);

			if ((boolean) temp1[0]) {

				// Final_Key[i] = Alphab[(int) temp1[1]];
				Final_Key[i] = Clamp_Lopp((int) temp1[1], Numerical.length);

			}
		}

		return Final_Key;

	}

	private final static int[] Creat_Cipher_Numerical_Ref(int[] key, int[] Ref) {

		// by cleaning the password we creat a int array reference
		// that reference will be used to switch the position of the first element with
		// the next element wich index is the value of the first elemnt of int array
		// say key is [7, 4, 1, 1, 4] ref is number 0=>9
		// we start by switching 0 whit the seventh element wich is 6
		// then 1 by the second element wich is 3 ....

		int[] Num_Ref = Ref.clone();

		// example : 1 , 2 ,3
		// ===> : 2 , 1 ,3
		// ===> : 3 , 1 ,2
		// .....

		for (int i = 0; i < key.length; i++) {

			int First = Num_Ref[i];
			int Second = Num_Ref[key[i]];

			Num_Ref[key[i]] = First;
			Num_Ref[i] = Second;

		}

		return Num_Ref;

	}

	private final static String Apply_Numerical_Cipher(String Source, int[] Cipher_Ref) {

		// After creating the reference and cleaning the password
		// We Iterate throw the string to be shufled go throw each
		// if the character is a number then we use Retrieve_Char_Index check if number
		// exist in the Cipher Reference if it does we retrieve that numbers position
		// for example this is a cipher reference [7, 3, 4, 2, 1, 5, 6, 0, 8, 9]
		// and this is ower text "123" so the first number in the text is 1 and we use
		// that value in the cipher reference index so 1 is the index of the number 3
		// stored in the cipher reference as such ref[1]=3 therfore
		// every 1 becomes 3 | every 2 becomes 4 | every 3 becomes 2

		String Final = "";

		char[] Char_Numerical = Int_Array_To_Char_Array(Numerical);

		for (int i = 0; i < Source.length(); i++) {

			char temp_char = Source.charAt(i);

			if (Character.isDigit(temp_char)) {
				int temp1 = Retrieve_Char_Index1(temp_char, Char_Numerical);

				Final += Cipher_Ref[temp1];

			} else {
				Final += temp_char;

			}

		}

		return Final;
	}

	private final static String Reverse_Numerical_Cipher(String Source, int[] key) {

		// We receive the encrypted Text then we use the cleaned version of the pass
		// word call the Creat_Cipher_Numerical_Ref
		// to find the original reference used to shufle the text then we reverse
		// engeneer it
		// for example this is a cipher reference [7, 3, 4, 2, 1, 5, 6, 0, 8, 9]
		// and this is the numerical reference [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ];
		// and this is ower text "342" so we iterate throw the text and the first
		// number is 3 now 3 is stored in the cipher reference and it has a index of 1
		// as ref[1]=3 meaning we turn every 3 to 1
		// ref[2]=4 meaning we turn every 4 to 2
		// ref[3]=2 meaning we turn every 2 to 3

		int[] Cipher_Ref = Creat_Cipher_Numerical_Ref(key, Numerical);

		char[] Temp_Cipher_Ref = Int_Array_To_Char_Array(Cipher_Ref);

		char[] Char_Numerical = Int_Array_To_Char_Array(Numerical);

		String Final = "";
		for (int i = 0; i < Source.length(); i++) {

			char temp_char = Source.charAt(i);

			if (Character.isDigit(temp_char)) {
				int temp1 = Retrieve_Char_Index1(temp_char, Temp_Cipher_Ref);
				Final += Char_Numerical[temp1];

			} else {
				Final += temp_char;

			}

		}

		return Final;

	}

	// _________________________________________________________________________________________________________
	private final static int[] Clean_Cipher_Symbole_Key(String Key) {

		// I take the letters inside the password remove all other characters
		// then i put them to lower case,i then get the reference of eache letter
		// so basicly if the alphabetical order is a b c ... then a =1 b =2 ...
		// if the pass word countains a , b then this methode returns 97 , 98
		// normaly a = 1 but in this case we used the ascii table so a to z is 97 to 122

		if (Key.length() > Symbole.length) {

			Key = Key.substring(0, Symbole.length);
		}

		String temp = "";

		Key = new String(Retrieve_Alphabets(Key));

		String Temp_Source = Key.toLowerCase();

		// String to char[]
		char[] Numerical_Key = Temp_Source.toCharArray();

		// int[] of alphabetic reference of the key
		int[] Final_Key = new int[Numerical_Key.length];
		for (int i = 0; i < Numerical_Key.length; i++) {

			Object[] temp1 = Retrieve_Char_Index(Numerical_Key[i], Alphab);

			if ((boolean) temp1[0]) {

				// Final_Key[i] = Alphab[(int) temp1[1]];
				Final_Key[i] = Alphab[Clamp_Lopp((int) temp1[1], Alphab.length)];

			}
		}

		return Final_Key;

	}

	private final static char[] Creat_Cipher_Symbole_Ref(int[] key, char[] Ref) {

		// by cleaning the password we creat a int array reference
		// that reference will be used to switch the position of the first element with
		// the next element wich index is the value of the first elemnt of int array
		// say key is [104, 101, 108, 111] ref All the symboles
		// we start by switching the first symbole whit the 104th symbole then the
		// second element whit the 101th element
		// and so on

		int[] Temp_key = Match_Array_Size(key, Ref.length);
		char[] Num_Ref = Ref.clone();

		// example : 1 , 2 ,3
		// ===> : 2 , 1 ,3
		// ===> : 3 , 1 ,2
		// .....

		for (int i = 0; i < Temp_key.length; i++) {

			int index = Clamp_Lopp(Temp_key[i], Num_Ref.length);
			char First = Num_Ref[i];
			char Second = Num_Ref[index];

			Num_Ref[index] = First;
			Num_Ref[i] = Second;
		}

		return Num_Ref;

	}

	private final static String Apply_Symbole_Cipher(String Source, char[] Cipher_Ref) {

		// so lets say this is ower symbole reference ower "&*~#{[|`\^@]}}"
		// we iterate throw every symbole in ower text
		// lets say ower text is "&&&&&"
		// the first symbole is & and & is the 3th symbole
		// now if we go to the cipher alpha ref and we look for the 3th letter
		// it becomes ~ as in Cipher_Ref[3]=~ meaning every & becomes a ~

		char[] Cipher_Ref_Upper_case = new char[Cipher_Ref.length];

		// char fUpper = Character.toUpperCase(f);

		for (int i = 0; i < Cipher_Ref.length; i++) {

			Cipher_Ref_Upper_case[i] = Character.toUpperCase(Cipher_Ref[i]);
		}

		String Final = "";
		for (int i = 0; i < Source.length(); i++) {

			char temp_char = Source.charAt(i);

			Object[] temp1 = Retrieve_Char_Index(temp_char, Symbole);

			if ((boolean) temp1[0]) {

				Final += Cipher_Ref[(int) temp1[1]];

			} else {

				Final += temp_char;
			}

		}

		return Final;
	}

	private final static String Reverse_Symbole_Cipher(String Source, int[] key) {

		// so lets say this is ower symbole reference ower "&*~#{[|`\^@]}}"
		// we iterate throw every symbole in ower text
		// lets say ower text is "~~~~~"
		// the first symbole is ~ and ~ is the 3th symbole in ower reference
		// so if we go to ower symbole array and look for the 3rd element we find &
		// meaning every ~ becomes &

		char[] Cipher_Ref = Creat_Cipher_Symbole_Ref(key, Symbole);

		char[] Cipher_Ref_Upper_case = new char[Cipher_Ref.length];

		// char fUpper = Character.toUpperCase(f);

		for (int i = 0; i < Cipher_Ref.length; i++) {

			Cipher_Ref_Upper_case[i] = Character.toUpperCase(Cipher_Ref[i]);
		}

		String Final = "";
		for (int i = 0; i < Source.length(); i++) {

			char temp_char = Source.charAt(i);

			Object[] temp1 = Retrieve_Char_Index(temp_char, Cipher_Ref);

			if ((boolean) temp1[0]) {

				Final += Symbole[(int) temp1[1]];

			} else {

				Final += temp_char;
			}

		}

		return Final;
	}

	// _________________________________________________________________________________________________________

	// __Usinge Simple Shufle Methodes to specifique characters
	private final static char[] Numerical_Capsule_Char(char[] Source, String key) {
		char[] holder = null;

		if (Contains_Digits(key)) {

			int[] char_digits = Retrieve_Digits(key);

			if (char_digits.length != 0) {

				int sum = IntStream.of(char_digits).sum();
				if (sum > 0) {

					holder = Shifting_Cipher.Combine_Shift(Source, sum);
				}

			}
		}

		return holder;
	}

	private final static char[] Reverse_Numerical_Capsule_Char(char[] Source, String key) {

		char[] holder = null;

		if (Contains_Digits(key)) {

			int[] char_digits = Retrieve_Digits(key);

			if (char_digits.length != 0) {

				int sum = IntStream.of(char_digits).sum();
				if (sum > 0) {

					holder = Shifting_Cipher.Reverse_Combine_Shift(Source, sum);
				}

			}
		}

		return holder;

	}

	private final static char[] Symbole_Capsule_Char(char[] Source, String key) {
		if (Contains_Symboles(key)) {

			char[] char_digits = Retrieve_Symboles(key);

			int[] top = Char_Array_To_Ascii_Array(char_digits);

			int sum = 0;

			for (int i = 0; i < top.length; i++) {

				sum += top[i];
			}

			if (char_digits.length != 0) {

				Source = Shifting_Cipher.Combine_Shift(Source, sum);

			}
		}

		return Source;
	}

	private final static char[] Reverse_Symbole_Capsule_Char(char[] Source, String key) {
		if (Contains_Symboles(key)) {

			char[] char_digits = Retrieve_Symboles(key);

			int[] top = Char_Array_To_Ascii_Array(char_digits);

			int sum = 0;

			for (int i = 0; i < top.length; i++) {

				sum += top[i];
			}

			if (char_digits.length != 0) {

				Source = Shifting_Cipher.Reverse_Combine_Shift(Source, sum);

			}
		}

		return Source;

	}

	// _________________________________________________________________________________________________________

	private final static boolean Contains_Digits(String Source) {
		char[] Numerical_Key = Source.toCharArray();

		for (char c : Numerical_Key) {
			if (Character.isDigit(c)) {

				return true;

			}
		}

		return false;
	}

	private final static boolean Contains_Alphabets(String Source) {
		char[] Numerical_Key = Source.toCharArray();

		for (char c : Numerical_Key) {
			if (Character.isAlphabetic(c)) {

				return true;

			}
		}

		return false;
	}

	private final static boolean Contains_Symboles(String Source) {
		char[] Numerical_Key = Source.toCharArray();

		for (char c : Numerical_Key) {
			if (Character.isDigit(c) == false && Character.isAlphabetic(c) == false) {

				return true;

			}
		}

		return false;
	}

	// _________________________________________________________________________________________________________

	private static boolean Is_Digit(char c) {

		int a = (int) c;
		if ((a >= 48 && a <= 57)) {
			return true;
		} else {
			return false;
		}

	}

	private static boolean Is_Alphabet(char c) {
		int a = (int) c;
		if (((a >= 65 && a <= 90) || (a >= 97 && a <= 122))) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean Is_Alphabet_Upper(char c) {
		int a = (int) c;
		if (((a >= 65 && a <= 90))) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean Is_Alphabet_Lower(char c) {
		int a = (int) c;
		if ((a >= 97 && a <= 122)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean Is_Symbole(char c) {
		int a = (int) c;
		if ((a >= 48 && a <= 57) == false && (a >= 65 && a <= 90) == false && (a >= 97 && a <= 122) == false) {
			return true;
		} else {
			return false;
		}
	}
	// _________________________________________________________________________________________________________

	private final static int[] Retrieve_Digits(String Source) {

		Source = Source.replaceAll("[^0-9]", "");

		return Char_Array_To_Int_Array(Source.toCharArray());
	}

	private final static char[] Retrieve_Alphabets(String Source) {

		Source = Source.replaceAll("[^a-zA-Z]", "");

		if (Source.length() != 0) {

			return Source.toCharArray();
		} else {

			return null;
		}

	}

	private final static char[] Retrieve_Symboles(String Source) {

		Source = Source.replaceAll("[A-Za-z]", ""); // remove alpha
		Source = Source.replaceAll("[0-9]", "");// remove digits
		if (Source.length() != 0) {

			return Source.toCharArray();
		} else {
			return null;
		}

	}

	// _________________________________________________________________________________________________________

	// _________________________________________________________________________________________________________

	private final static int Clamp_Lopp(int Value, int Roof) {

		int temp;
		if (Value < 0) {
			temp = -Value / Roof;

			int holder = Roof * temp;

			if (-Value == Roof) {

				return Roof;
			}
			if (holder == 0) {

				return Roof + Value;
			}
			return -(Value + holder);

		} else {

			temp = Value / Roof;

			return Value - temp * Roof;
		}

	}

	private final static int Symetrical_Clamp_Lopp(int Value, int Roof) {

		int temp;
		if (Value < 0) {
			temp = -Value / Roof;

			int holder = Roof * temp;

			if (holder == 0) {

				return Roof + Value;
			}
			return -(Value + holder);

		} else {

			temp = Value / Roof;

			return (Value - temp * Roof);
		}

	}

	private final static int[] Match_Array_Size(int[] Array, int Size) {

		if (Array.length < Size) {

			int[] Temp = new int[Size];
			for (int i = 0; i < Array.length; i++) {

				Temp[i] = Array[i];
			}

			for (int i = Array.length - 1; i < Temp.length; i++) {

				Temp[i] = Array[Clamp_Lopp(i, Array.length)];
			}
			return Temp;
		}

		return null;

	}

	private final static boolean Contains_Char(char c, char[] array) {

		for (char x : array) {
			if (x == c) {
				return true;
			}
		}
		return false;
	}

	private final static Object[] Retrieve_Char_Index(char c, char[] array) {

		Object[] temp = new Object[2];

		for (int i = 0; i < array.length; i++) {

			if (c == array[i]) {

				temp[0] = true;
				temp[1] = i;
				return temp;
			}
		}
		temp[0] = false;
		return temp;
	}

	private final static int Retrieve_Char_Index1(char c, char[] array) {

		int temp = 0;
		for (int i = 0; i < array.length; i++) {

			if (c == array[i]) {

				return i;
			}
		}
		return temp;
	}
	// _________________________________________________________________________________________________________

	private final static char[] Generate_Symboles() {
		char[] Symboles = new char[256 - 10 - 26 - 26];
		int Increment = 0;
		for (int i = 0; i < 256; i++) {

			int a = i;
			char c = (char) a;

			// 48 decimal reference to 0 | 57 decimal reference 9
			// 65 decimal reference to A | 90 decimal reference Z
			// 97 decimal reference to a | 122 decimal reference z

			if ((a >= 48 && a <= 57) || ((a >= 65 && a <= 90) || (a >= 97 && a <= 122))) {

			} else {

//				System.out.println(c+" "+a);
//				System.out.println("Increment "+Increment);
				Symboles[Increment] = c;
				Increment++;
			}

		}

//		System.out.println("Increment"+Increment);
		if (Increment == 0) {
			return null;
		} else {

			return Symboles;
		}

	}

	private final static char[] Control_Generate_Symboles(int alp, int num, int sym, int ex) {

		// symetrical clamp dosent allow for value to equale the max therfore i had to
		// use 2
		alp = Symetrical_Clamp_Lopp(alp, 2);
		num = Symetrical_Clamp_Lopp(num, 2);
		sym = Symetrical_Clamp_Lopp(sym, 2);
		ex = Symetrical_Clamp_Lopp(ex, 2);

		System.out.println();
		if (alp == 1 || num == 1 || sym == 1) {

			int Size = 0;
			if (ex == 1) {
				Size = 256;
			} else if (ex == 0) {
				Size = 128;
			}

			if (Size != 0) {

				char[] Symboles = new char[Size];
				for (int i = 0; i < Size; i++) {

					int a = i;
					char c = (char) a;

					Symboles[i] = c;

				}

				if (Symboles.length != 0) {

					String test = new String(Symboles);

					test = test.replaceAll("\\p{Cntrl}", "");
					test = test.replaceAll("\\p{C}", "");
					test = test.replaceAll("[\\p{Cntrl}\\p{Cc}\\p{Cf}\\p{Co}\\p{Cn}\\p{Cs}]", "");

					if (alp == 0) {
						test = test.replaceAll("[A-Za-z]", ""); // remove alpha

					}
					if (num == 0) {
						test = test.replaceAll("[0-9]", "");// remove digits

					}
					if (sym == 0) {

						if (num == 1 && alp == 1) {

							test = test.replaceAll("[^a-zA-Z0-9]", "");// remove NON digits
						}
						if (alp == 1 && num == 0) {

							test = test.replaceAll("[^a-zA-Z]", "");

						}
						if (alp == 0 && num == 1) {

							test = test.replaceAll("[^0-9]", "");

						}

					}

					test = test.replaceAll("\\p{C}", "?");
					return test.toCharArray();
				}

			}
		}
		return null;

	}

	// _________________________________________________________________________________________________________

	private static int[] Char_Array_To_Int_Array(char[] Source) {

		int[] Holder = new int[Source.length];
		for (int i = 0; i < Holder.length; i++) {

			char c = Source[i];

			int a = Integer.parseInt(String.valueOf(c));
			Holder[i] = a;

		}

		return Holder;
	}

	private static int[] Char_Array_To_Ascii_Array(char[] Source) {

		int[] Holder = new int[Source.length];
		for (int i = 0; i < Holder.length; i++) {
			char c = Source[i];

			char c2 = Source[i];
			int b = c2;
			Holder[i] = b;

		}

		return Holder;
	}

	private static char[] Int_Array_To_Char_Array(int[] Source) {

		char[] Holder = new char[Source.length];
		for (int i = 0; i < Holder.length; i++) {

			int value_int = Source[i];
			char value_char = (char) (value_int + '0');

			Holder[i] = value_char;

		}

		return Holder;
	}
	// _________________________________________________________________________________________________________

	private static String Remove_Accented_Characters(String Source) {
		String word = Source;
//		System.out.println("Original word:" + word);

		String normalizedWord = Normalizer.normalize(word, Form.NFD);

//		System.out.println("After normalization:" + normalizedWord);

		String finalWord = normalizedWord.replaceAll("\\p{M}", "");

//		System.out.println("After replacing accents" + finalWord);

		return finalWord;
	}
}
