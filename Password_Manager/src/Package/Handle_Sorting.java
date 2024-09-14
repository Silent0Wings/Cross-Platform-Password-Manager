package Package;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Handle_Sorting {

	
	// ______________________Sorting By Date Created_______________________________

	// Organise a array of file in a Ascending_Sorting by Date
	public static Node_File[] Ascending_File_Sorting_By_Date_Created(Node_File[] Source) {

		LocalDateTime Floor = LocalDateTime.MIN;

		int perm_ind = 0;

		for (int i = 0; i < Source.length; i++) {
			//System.out.println("i : " + i);
			//System.out.println();

			int trig = 0;
			LocalDateTime curr = LocalDateTime.MAX;
			for (int j = i; j < Source.length; j++) {
				if (Source[j].getDate_Created().compareTo(curr) <= 0
						&& Source[j].getDate_Created().compareTo(Floor) >= 0) {

					curr = Source[j].getDate_Created();
					perm_ind = j;
					trig++;
				}

			}

			if (trig != 0) {
				//System.out.println();

				Floor = Source[perm_ind].getDate_Created();
				Node_File Temp = Source[perm_ind];
				Source[perm_ind] = Source[i];
				Source[i] = Temp;

			}
		}

		return Source;
	}

	// Organise a array of file in a Descending Sorting by Date
	public static Node_File[] Descending_File_Sorting_By_Date_Created(Node_File[] Source) {

		Source = Ascending_File_Sorting_By_Date_Created(Source);
		List<Node_File> list = Arrays.asList(Source);
		Collections.reverse(list);

		Source = (Node_File[]) list.toArray();
		return Source;
	}

	// Organise a List of file in a Ascending_Sorting by Date return List
	public static List<Node_File> Ascending_File_Sorting_By_Date_Created(List<Node_File> Source) {

		LocalDateTime Floor = LocalDateTime.MIN;

		int perm_ind = 0;

		for (int i = 0; i < Source.size(); i++) {
			//System.out.println("i : " + i);
			//System.out.println();

			int trig = 0;
			LocalDateTime curr = LocalDateTime.MAX;
			for (int j = i; j < Source.size(); j++) {
				if (Source.get(j).getDate_Created().compareTo(curr) <= 0
						&& Source.get(j).getDate_Created().compareTo(Floor) >= 0) {

					curr = Source.get(j).getDate_Created();
					perm_ind = j;
					trig++;
				}

			}

			if (trig != 0) {
				//System.out.println();

				Floor = Source.get(perm_ind).getDate_Created();
				Node_File Temp = Source.get(perm_ind);
				Source.set(perm_ind, Source.get(i));
				Source.set(i, Temp);

			}
		}
//			System.err.println(Print_Date_Array(Source));

		return Source;
	}

	// Organise a List of file in a Descending Sorting by Date return List
	public static List<Node_File> Descending_File_Sorting_By_Date_Created(List<Node_File> Source) {

		Source = Ascending_File_Sorting_By_Date_Created(Source);
		Collections.reverse(Source);

		return Source;
	}
	// ______________________Sorting By Date Modified____________________________

	// Organise a array of file in a Ascending_Sorting by Date
	public static Node_File[] Ascending_File_Sorting_By_Date_Modified(Node_File[] Source) {

		LocalDateTime Floor = LocalDateTime.MIN;

		int perm_ind = 0;

		for (int i = 0; i < Source.length; i++) {
			//System.out.println("i : " + i);
			//System.out.println();

			int trig = 0;
			LocalDateTime curr = LocalDateTime.MAX;
			for (int j = i; j < Source.length; j++) {
				if (Source[j].getModified_Date().compareTo(curr) <= 0
						&& Source[j].getModified_Date().compareTo(Floor) >= 0) {

					curr = Source[j].getModified_Date();
					perm_ind = j;
					trig++;
				}

			}

			if (trig != 0) {
				//System.out.println();

				Floor = Source[perm_ind].getModified_Date();
				Node_File Temp = Source[perm_ind];
				Source[perm_ind] = Source[i];
				Source[i] = Temp;

			}
		}

		return Source;
	}

	// Organise a array of file in a Descending Sorting by Date
	public static Node_File[] Descending_File_Sorting_By_Date_Modified(Node_File[] Source) {

		Source = Ascending_File_Sorting_By_Date_Modified(Source);
		List<Node_File> list = Arrays.asList(Source);
		Collections.reverse(list);

		Source = (Node_File[]) list.toArray();
		return Source;
	}

	// Organise a List of file in a Ascending_Sorting by Date return List
	public static List<Node_File> Ascending_File_Sorting_By_Date_Modified(List<Node_File> Source) {

		LocalDateTime Floor = LocalDateTime.MIN;

		int perm_ind = 0;

		for (int i = 0; i < Source.size(); i++) {
			//System.out.println("i : " + i);
			//System.out.println();

			int trig = 0;
			LocalDateTime curr = LocalDateTime.MAX;
			for (int j = i; j < Source.size(); j++) {
				if (Source.get(j).getModified_Date().compareTo(curr) <= 0
						&& Source.get(j).getModified_Date().compareTo(Floor) >= 0) {

					curr = Source.get(j).getModified_Date();
					perm_ind = j;
					trig++;
				}

			}

			if (trig != 0) {
				//System.out.println();

				Floor = Source.get(perm_ind).getModified_Date();
				Node_File Temp = Source.get(perm_ind);
				Source.set(perm_ind, Source.get(i));
				Source.set(i, Temp);

			}
		}
//				System.err.println(Print_Date_Array(Source));

		return Source;
	}

	// Organise a List of file in a Descending Sorting by Date return List
	public static List<Node_File> Descending_File_Sorting_By_Date_Modified(List<Node_File> Source) {

		Source = Ascending_File_Sorting_By_Date_Modified(Source);
		Collections.reverse(Source);

		return Source;
	}

	// ______________________Sorting By Date Expiration_____________________________

	// Organise a array of file in a Ascending_Sorting by Date
	public static Node_File[] Ascending_File_Sorting_By_Date_Expiration(Node_File[] Source) {

		LocalDateTime Floor = LocalDateTime.MIN;

		int perm_ind = 0;

		for (int i = 0; i < Source.length; i++) {
			//System.out.println("i : " + i);
			//System.out.println();

			int trig = 0;
			LocalDateTime curr = LocalDateTime.MAX;
			for (int j = i; j < Source.length; j++) {
				if (Source[j].getExpiration_Date().compareTo(curr) <= 0
						&& Source[j].getExpiration_Date().compareTo(Floor) >= 0) {

					curr = Source[j].getExpiration_Date();
					perm_ind = j;
					trig++;
				}

			}

			if (trig != 0) {
				//System.out.println();

				Floor = Source[perm_ind].getExpiration_Date();
				Node_File Temp = Source[perm_ind];
				Source[perm_ind] = Source[i];
				Source[i] = Temp;

			}
		}

		return Source;
	}

	// Organise a array of file in a Descending Sorting by Date
	public static Node_File[] Descending_File_Sorting_By_Date_Expiration(Node_File[] Source) {

		Source = Ascending_File_Sorting_By_Date_Expiration(Source);
		List<Node_File> list = Arrays.asList(Source);
		Collections.reverse(list);

		Source = (Node_File[]) list.toArray();
		return Source;
	}

	// Organise a List of file in a Ascending_Sorting by Date return List
	public static List<Node_File> Ascending_File_Sorting_By_Date_Expiration(List<Node_File> Source) {

		LocalDateTime Floor = LocalDateTime.MIN;

		int perm_ind = 0;

		for (int i = 0; i < Source.size(); i++) {
			//System.out.println("i : " + i);
			//System.out.println();

			int trig = 0;
			LocalDateTime curr = LocalDateTime.MAX;
			for (int j = i; j < Source.size(); j++) {
				if (Source.get(j).getExpiration_Date().compareTo(curr) <= 0
						&& Source.get(j).getExpiration_Date().compareTo(Floor) >= 0) {

					curr = Source.get(j).getExpiration_Date();
					perm_ind = j;
					trig++;
				}

			}

			if (trig != 0) {
				//System.out.println();

				Floor = Source.get(perm_ind).getExpiration_Date();
				Node_File Temp = Source.get(perm_ind);
				Source.set(perm_ind, Source.get(i));
				Source.set(i, Temp);

			}
		}
//				System.err.println(Print_Date_Array(Source));

		return Source;
	}

	// Organise a List of file in a Descending Sorting by Date return List
	public static List<Node_File> Descending_File_Sorting_By_Date_Expiration(List<Node_File> Source) {

		Source = Ascending_File_Sorting_By_Date_Expiration(Source);
		Collections.reverse(Source);

		return Source;
	}

	// ______________________Sorting By Name________________________________________

	// Organise a array of file in a Ascending_Sorting by Name
	public static Node_File[] Ascending_Sorting_Name(Node_File[] Source) {
		long Min = (long) 0;
		long Max = (long) 144697;

		String Floor = Character.toString((char) Min);
		int perm_ind = 0;

		for (int i = 0; i < Source.length; i++) {
			//System.out.println("i : " + i);
			//System.out.println();

			int trig = 0;
			String curr = Character.toString((char) Max);

			for (int j = i; j < Source.length; j++) {

				if (Word_Compare(Source[j].getName(), curr) <= 0 && Word_Compare(Source[j].getName(), Floor) >= 0) {

					curr = Source[j].getName();
					perm_ind = j;
					trig++;
				}

			}

			if (trig != 0) {
				//System.out.println();

				//System.out.println(Print_Name_Array(Source));

				Floor = Source[perm_ind].getName();
				Node_File Temp = Source[perm_ind];
				Source[perm_ind] = Source[i];
				Source[i] = Temp;

			}
		}

//			System.err.println(Print_Date_Array(Source));

		return Source;
	}

	// Organise a array of file in a Descending Sorting by Name
	public static Node_File[] Descending_Sorting_Name(Node_File[] Source) {

		Source = Ascending_Sorting_Name(Source);
		List<Node_File> list = Arrays.asList(Source);
		Collections.reverse(list);

		Source = (Node_File[]) list.toArray();
		return Source;
	}

	// Organise a List of file in a Ascending_Sorting by Name return List
	public static List<Node_File> Ascending_File_Sorting_Name(List<Node_File> Source) {

		long Min = (long) 0;
		long Max = (long) 144697;

		String Floor = Character.toString((char) Min);
		int perm_ind = 0;

		for (int i = 0; i < Source.size(); i++) {
			//System.out.println("i : " + i);
			//System.out.println();

			int trig = 0;
			String curr = Character.toString((char) Max);

			for (int j = i; j < Source.size(); j++) {

				if (Word_Compare(Source.get(j).getName(), curr) <= 0
						&& Word_Compare(Source.get(j).getName(), Floor) >= 0) {

					curr = Source.get(j).getName();
					perm_ind = j;
					trig++;
				}

			}

			if (trig != 0) {
				//System.out.println();

				//System.out.println(Print_Name_Array(Source));

				Floor = Source.get(perm_ind).getName();
				Node_File Temp = Source.get(perm_ind);
				Source.set(perm_ind, Source.get(i));
				Source.set(i, Temp);

			}
		}

		return Source;

	}

	// Organise a List of file in a Descending Sorting by Date return List
	public static List<Node_File> Descending_File_Sorting_Name(List<Node_File> Source) {

		Source = Ascending_File_Sorting_Name(Source);
		Collections.reverse(Source);

		return Source;
	}

	// Organise a List of file in a Ascending_Sorting by Name return List
	public static List<Node_Structure> Ascending_Folder_Sorting_Name(List<Node_Structure> Source) {

		long Min = (long) 0;
		long Max = (long) 144697;

		String Floor = Character.toString((char) Min);
		int perm_ind = 0;

		for (int i = 0; i < Source.size(); i++) {
			//System.out.println("i : " + i);
			//System.out.println();

			int trig = 0;
			String curr = Character.toString((char) Max);

			for (int j = i; j < Source.size(); j++) {

				if (Word_Compare(Source.get(j).Get_Name(), curr) <= 0
						&& Word_Compare(Source.get(j).Get_Name(), Floor) >= 0) {

					curr = Source.get(j).Get_Name();
					perm_ind = j;
					trig++;
				}

			}

			if (trig != 0) {
				//System.out.println();

				//System.out.println(Print_Name_Array(Source));

				Floor = Source.get(perm_ind).Get_Name();
				Node_Structure Temp = Source.get(perm_ind);
				Source.set(perm_ind, Source.get(i));
				Source.set(i, Temp);

			}
		}

		return Source;

	}

	// Organise a List of file in a Descending Sorting by Date return List
	public static List<Node_Structure> Descending_Folder_Sorting_Name(List<Node_Structure> Source) {

		Source = Ascending_Folder_Sorting_Name(Source);
		Collections.reverse(Source);

		return Source;
	}

	// Compare 2 string character by character in alphabetical order
	public static int Word_Compare(String Word1, String Word2) {

		if (Word1 != null && Word2 != null) {

			if (Word1.length() != 0 && Word2.length() != 0) {

				Word1 = Word1.toLowerCase();
				Word2 = Word2.toLowerCase();

				if (Word1.equals(Word2)) {

					return 0;

				} else {

					char[] Word1_char = Word1.toCharArray();
					char[] Word2_char = Word2.toCharArray();

					int[] Word1_int = Char_Array_To_Ascii_Array(Word1_char);
					int[] Word2_int = Char_Array_To_Ascii_Array(Word2_char);

					int ref_w1 = 0;
					int ref_w2 = 0;

					int Size = 0;

					if (Word1.length() > Word2.length()) {
						Size = Word2.length();
					} else if (Word1.length() < Word2.length()) {
						Size = Word1.length();

					} else {
						Size = Word1.length();

					}

					if (Size != 0) {

						for (int i = 0; i < Size; i++) {

							if (Word2_int[i] < Word1_int[i]) {
								ref_w2++;
							} else if (Word1_int[i] < Word2_int[i]) {
								ref_w1++;
							}

							if (ref_w1 != ref_w2) {

								break;
							}

						}

						if (ref_w2 > ref_w1) {

							return 1;
						} else if (ref_w1 > ref_w2) {
							return -1;

						} else {

							if (Word1.length() > Word2.length()) {
								return 1;
							} else if (Word1.length() < Word2.length()) {
								return -1;

							} else {
								return 0;

							}

						}
					}

				}

			}
		}

		return 0;
	}

	// Convert a array of char to theyr ascii decimal value in a int array
	private static int[] Char_Array_To_Ascii_Array(char[] Source) {

		int[] Holder = new int[Source.length];
		for (int i = 0; i < Holder.length; i++) {

			char c2 = Source[i];
			int b = c2;
			Holder[i] = b;

		}

		return Holder;
	}

	// ___________________________________________________________________________

	
}
