package Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unused")

public class Shifting_Cipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] temp = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		char[] temp1 = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		Loop_Combine_Shift();

	}

	// _________________________________________________________________________________________________
	private static final void Loop_Combine_Shift() {

		// System.out.println("Loop_Combine_Shift");
		int errors = 0;

		int max = 9999;
		int min = 1;
		int range = max - min + 1;

		for (int i = 0; i < 9999; i++) {

			int rand = (int) (Math.random() * range) + min;
			int Offset = i;
			int ran3d = (int) (Math.random() * range) + min;
			char[] temp = Generate_Symboles(ran3d);
			char[] temp1 = Combine_Shift(temp, Offset);

			char[] temp2 = Reverse_Combine_Shift(temp1, Offset);

			if (Arrays.equals(temp2, temp)) {

			} else {
				errors++;
			}

		}
		if (errors != 0) {
			// System.out.println("Alot Errors : " + errors + "Out of " + max);

		} else {

			System.out.println("No Errors");
		}

		// System.out.println("End_______________________");

	}

	private static final void Single_Combine_Shift() {

		char[] temp = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int Offset = 44;

		char[] temp1 = Combine_Shift(temp, Offset);

		char[] temp2 = Reverse_Combine_Shift(temp1, Offset);

		// System.out.println(temp2);
		// System.out.println(temp3);

		if (Arrays.equals(temp2, temp)) {

			// System.out.println("No Errors");
		} else {
			// System.out.println("Alot Errors");
			// System.out.println(Arrays.toString(temp));
			// System.out.println(Arrays.toString(temp2));

		}

		// System.out.println("End_______________________");

	}

	// _________________________________________________________________________________________________
	private static final void Loop_Smooth_Shift() {
		// System.out.println("Loop_Smooth_Shift");
		int errors = 0;

		int max = 9999;
		int min = 1;
		int range = max - min + 1;

		for (int i = 0; i < 9999; i++) {
			int ran3d = (int) (Math.random() * range) + min;

			char[] temp = Generate_Symboles(ran3d);

			int rand = (int) (Math.random() * range) + min;

			int ran2d = (int) (Math.random() * range) + min;

			int Offset = ran2d;

			char[] temp1 = Smooth_Shift(temp, Offset);

			char[] temp2 = Reverse_Smooth_Shift(temp1, Offset);

			if (Arrays.equals(temp2, temp)) {

			} else {
				errors++;
				// System.out.println(Offset);
			}

		}
		if (errors != 0) {
			// System.out.println("Alot Errors : " + errors + "Out of " + max);

		} else {

			// System.out.println("No Errors");
		}

		// System.out.println("End_______________________");
	}

	private static final void Single_Smooth_Shift() {

		char[] temp = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int Offset = 44;

		char[] temp1 = Smooth_Shift(temp, Offset);

		char[] temp2 = Reverse_Smooth_Shift(temp1, Offset);

		if (Arrays.equals(temp2, temp)) {

			// System.out.println("No Errors");
		} else {
			// System.out.println("Alot Errors");
			// System.out.println(Arrays.toString(temp));
			// System.out.println(Arrays.toString(temp2));

		}

		// System.out.println("End_______________________");
	}

	// _________________________________________________________________________________________________
	private static final void Loop_Slide_Shift_Test() {
		// System.out.println(Arrays.toString(Generate_Symboles()));
		// System.out.println("Loop_Slide_Shift_Test");
		int errors = 0;
		int max = 10000;
		int min = 1;
		int range = max - min + 1;

		for (int i = 0; i < 9999; i++) {

			int rand = (int) (Math.random() * range) + min;
			int ran3d = (int) (Math.random() * range) + min;
			char[] temp = Generate_Symboles(ran3d);
			int Offset = i;

			char[] temp2 = Slide_Shift(temp, Offset);

			char[] temp3 = Reverse_Slide_Shift(temp2, Offset);

			if (Arrays.equals(temp3, temp)) {

			} else {
				errors++;
			}

		}
		if (errors != 0) {
			// System.out.println("Alot Errors : " + errors + " Out of " + max);

		} else {

			// System.out.println("No Errors");
		}

		// System.out.println("End_______________________");
	}

	private static final void Single_Slide_Shift_Test() {
		// System.out.println(Arrays.toString(Generate_Symboles()));

		char[] temp = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' }; // char[] temp1 = Shift_Diagonaly(temp, 100);
		// System.out.println("Diagonaly : " + Arrays.toString(temp1));

		int Offset = 44;

		char[] temp1 = Slide_Shift(temp, Offset);
		// System.out.println("Mirror_Shift : " + Arrays.toString(temp2));

		char[] temp2 = Reverse_Slide_Shift(temp1, Offset);
		// System.out.println("Reverse_Mirror_Shift : " + Arrays.toString(temp3));
		// System.out.println(Symetrical_Clamp_Lopp(temp.length*Offset, temp.length));

		// System.out.println(temp2);
		// System.out.println(temp3);

		if (Arrays.equals(temp2, temp)) {

			// System.out.println("No Errors");
		} else {
			// System.out.println("Alot Errors");
			// System.out.println(Arrays.toString(temp));
			// System.out.println(Arrays.toString(temp2));

		}

		// System.out.println("End_______________________");
	}

	// _________________________________________________________________________________________________
	private static final void Loop_Linear_Shift() {
		// System.out.println("Loop_Linear_Shift");

		int max = 10000;
		int errors = 0;
		int min = 1;
		int range = max - min + 1;

		for (int i = 0; i < 9999; i++) {

			int rand = (int) (Math.random() * range) + min;
			int ran3d = (int) (Math.random() * range) + min;
			char[] temp = Generate_Symboles(ran3d);
			int Offset = i;

			char[] temp2 = Linear_Shift(temp, Offset);

			char[] temp3 = Reverse_Linear_Shift(temp2, Offset);
			if (Arrays.equals(temp3, temp)) {

			} else {
				errors++;
			}

		}
		if (errors != 0) {
			// System.out.println("Alot Errors : " + errors + " Out of " + max);

		} else {

			// System.out.println("No Errors");
		}

		// System.out.println("End_______________________");
	}

	private static final void Single_Linear_Shift() {
		char[] temp = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		// char[] temp1 = Shift_Diagonaly(temp, 100);
		// System.out.println("Diagonaly : " + Arrays.toString(temp1));

		int Offset = 44;

		char[] temp1 = Linear_Shift(temp, Offset);
		// System.out.println("Mirror_Shift : " + Arrays.toString(temp2));

		char[] temp2 = Reverse_Linear_Shift(temp1, Offset);
		// System.out.println("Reverse_Mirror_Shift : " + Arrays.toString(temp3));
		// System.out.println(Symetrical_Clamp_Lopp(temp.length*Offset, temp.length));

		// System.out.println(temp2);
		// System.out.println(temp3);

		if (Arrays.equals(temp2, temp)) {

			// System.out.println("No Errors");
		} else {
			// System.out.println("Alot Errors");
			// System.out.println(Arrays.toString(temp));
			// System.out.println(Arrays.toString(temp2));

		}

		// System.out.println("End_______________________");
	}

	// _________________________________________________________________________________________________
	public static final char[] Combine_Shift(char[] source, int Offset) {

		char[] Holder = source.clone();
		Holder = Linear_Shift(Holder, Offset);
		Holder = Slide_Shift(Holder, Offset);
		Holder = Smooth_Shift(Holder, Offset);
		Holder = Grow_Shift(Holder, Offset);

		return Holder;
	}

	public static final char[] Reverse_Combine_Shift(char[] source, int Offset) {

		char[] Holder = source.clone();
		Holder = Reverse_Grow_Shift(Holder, Offset);
		Holder = Reverse_Smooth_Shift(Holder, Offset);
		Holder = Reverse_Slide_Shift(Holder, Offset);
		Holder = Reverse_Linear_Shift(Holder, Offset);

		return Holder;

	}

	// _________________________________________________________________________________________________
	private static final char[] Grow_Shift(char[] source, int Offset) {

		Offset = Symetrical_Clamp_Lopp(Offset, source.length);
		char[] Holder = source.clone();

		int Temp_Offset = Symetrical_Clamp_Lopp(Offset, Holder.length);
//		// System.out.println("Temp_Offset " + Temp_Offset);

		for (int i = 0; i < Offset; i++) {

			if (Temp_Offset == 0) {
				break;
			}

			int Index = Symetrical_Clamp_Lopp(i, Holder.length);
//
//			// System.out.println("ShifIndex" + ShifIndex);
//			// System.out.println("Index" + Index);
			char first = Holder[Index];
			char second = Holder[Temp_Offset];

			Holder[Temp_Offset] = first;
			Holder[Index] = second;

			// System.out.println(Arrays.toString(source));

//			if (i == Offset - 1) {
//				// System.out.println(ShifIndex);
//			}

		}

		return (Holder);
	}

	private static final char[] Reverse_Grow_Shift(char[] source, int Offset) {
		Offset = Symetrical_Clamp_Lopp(Offset, source.length);

		char[] Holder = source.clone();

		int Increment = Symetrical_Clamp_Lopp(Offset, Holder.length) - 1;
//		// System.out.println(Increment);

		int Temp_Offset = Symetrical_Clamp_Lopp(Offset, Holder.length);

//		// System.out.println("=="+Arrays.toString(Holder));

		for (int i = 0; i < Offset; i++) {

//			// System.out.println("Temp_Offset " + Temp_Offset);
			if (Temp_Offset == 0) {
				break;
			}

			int Index = Symetrical_Clamp_Lopp(Increment, Holder.length);

//			// System.out.println("Index " + Index);
//			// System.out.println("ShifIndex " + ShifIndex);

			char first = Holder[Index];
			char second = Holder[Temp_Offset];

			Holder[Temp_Offset] = first;
			Holder[Index] = second;
			Increment--;
//			// System.out.println("=="+Arrays.toString(Holder));

		}

		return (Holder);
	}

	// _________________________________________________________________________________________________
	private static final char[] Slide_Shift(char[] Source, int Offset) {
		// we shift a character at a certain position by the offset and
		// we drive i forward untile we reach the end if the offset surpasse the array
		// size we just restart from 0 and keep counting
		// 123 +1
		// 213 +1
		// 231 +1
		// 132 +1
		//
		// 132 -1
		// 231 -1
		// 213 -1
		// 123 -1
		// ____________________

		Offset = Symetrical_Clamp_Lopp(Offset, Source.length);

		char[] holder = Source.clone();
		int Index = 0;

		for (int i = 0; i < holder.length; i++) {

			int ShifIndex = Symetrical_Clamp_Lopp((Index + Offset), holder.length);

			char first = holder[Index];
			char second = holder[ShifIndex];

			holder[ShifIndex] = first;
			holder[Index] = second;

			Index += Offset;

			Index = Symetrical_Clamp_Lopp(Index, holder.length);

		}

		return holder;
	}

	private static final char[] Reverse_Slide_Shift(char[] Source, int Offset) {

		// we need to calculate the end position of the encrypting methode wich is the
		// number
		// of characters to iterate throw multiplied by the amount of offset.

		// we shift a character at a certain position by the offset and
		// we drive i backward untile we reach the start if the offset surpasse the
		// array
		// size we just restart from the end and keep counting

		Offset = Symetrical_Clamp_Lopp(Offset, Source.length);
		char[] holder = Source.clone();
		int Index = Symetrical_Clamp_Lopp(holder.length * Offset, holder.length);

		for (int i = 0; i < holder.length; i++) {

			int ShifIndex = Symetrical_Clamp_Lopp((Index - Offset), holder.length);

			char first = holder[Index];
			char second = holder[ShifIndex];

			holder[ShifIndex] = first;
			holder[Index] = second;

			Index -= Offset;

			Index = Symetrical_Clamp_Lopp(Index, holder.length);

		}

		return holder;
	}

	// _________________________________________________________________________________________________
	private static final char[] Linear_Shift(char[] Source, int Offset) {

		// Shift all elements by the same offset value
		Offset = Symetrical_Clamp_Lopp(Offset, Source.length);

		char[] holder = new char[Source.length];

		for (int i = 0; i < Source.length; i++) {
			int ShifIndex = Symetrical_Clamp_Lopp((i + Offset), holder.length);

			holder[ShifIndex] = Source[i];

		}

		return holder;

	}

	private static final char[] Reverse_Linear_Shift(char[] Source, int Offset) {
		// Shift all elements by the same offset value in the negative direction

		Offset = Symetrical_Clamp_Lopp(Offset, Source.length);

		char[] holder = new char[Source.length];

		for (int i = 0; i < Source.length; i++) {
			int ShifIndex = Symetrical_Clamp_Lopp((i - Offset), holder.length);

			holder[ShifIndex] = Source[i];

		}

		return holder;

	}

	// _________________________________________________________________________________________________
	private static final char[] Smooth_Shift(char[] Source, int Offset) {

//		[1, 2, 3, 4, 5, 6] ==>0 ==>3
//		[4, 2, 3, 1, 5, 6] ==>1 ==>3
//		[4, 1, 3, 2, 5, 6] ==>2 ==>3
//		[4, 1, 2, 3, 5, 6] 

//		[1, 2, 3, 4, 5, 6] ==>3 ==>2
//		[4, 2, 3, 1, 5, 6] ==>3 ==>1
//		[4, 1, 3, 2, 5, 6] ==>3 ==>0
//		[4, 1, 2, 3, 5, 6]
		Offset = Symetrical_Clamp_Lopp(Offset, Source.length);

		int Temp_Offset = Offset;

		char[] holder = Source.clone();
		// int Index = Symetrical_Clamp_Lopp(Source.length * Offset, Source.length);

		for (int i = 0; i < Offset; i++) {

			int Index = Symetrical_Clamp_Lopp(i, holder.length);

			// System.out.println("Index : "+Index);
			int ShifIndex = Symetrical_Clamp_Lopp((Index + Temp_Offset), holder.length);
			// System.out.println("ShifIndex : "+ShifIndex);

			char first = holder[Index];
			char second = holder[ShifIndex];

			holder[ShifIndex] = first;
			holder[Index] = second;

			Temp_Offset--;

		}

		return holder;

	}

	private static final char[] Reverse_Smooth_Shift(char[] Source, int Offset) {

//		[1, 2, 3, 4, 5, 6] ==>0 ==>3
//		[4, 2, 3, 1, 5, 6] ==>1 ==>3
//		[4, 1, 3, 2, 5, 6] ==>2 ==>3
//		[4, 1, 2, 3, 5, 6] 

//		[1, 2, 3, 4, 5, 6] ==>3 ==>2
//		[4, 2, 3, 1, 5, 6] ==>3 ==>1
//		[4, 1, 3, 2, 5, 6] ==>3 ==>0
//		[4, 1, 2, 3, 5, 6]
		Offset = Symetrical_Clamp_Lopp(Offset, Source.length);

		char[] holder = Source.clone();
		// int Index = Symetrical_Clamp_Lopp(Source.length * Offset, Source.length);
		int Increment = Symetrical_Clamp_Lopp(Offset, holder.length) - 1;

		for (int i = 1; i <= Offset; i++) {

			int Index = Symetrical_Clamp_Lopp(Increment, holder.length);
			int ShifIndex = Symetrical_Clamp_Lopp((Index + i), holder.length);

			char first = holder[Index];
			char second = holder[ShifIndex];

			holder[ShifIndex] = first;
			holder[Index] = second;

			Increment--;

		}

		return holder;

	}

	// _________________________________________________________________________________________________
	private static final char[] Generate_Symboles() {
		char[] Symboles = new char[65536];
		int size = 0;
		for (int i = 0; i < 65536; i++) {

			int a = i;
			char c = (char) a;

			if (Character.isAlphabetic(c) || Character.isDigit(c)) {

			} else {

				Symboles[size] = c;
				size++;
			}

		}
		if (size == 0) {
			return null;
		} else {
			return Symboles;
		}

	}

	private static final char[] Generate_Symboles(int rand) {
		char[] Symboles = new char[rand];
		int size = 0;
		for (int i = 0; i < rand; i++) {

			int a = i;
			char c = (char) a;

			if (Character.isAlphabetic(c) || Character.isDigit(c)) {

			} else {

				Symboles[size] = c;
				size++;
			}

		}
		if (size == 0) {
			return null;
		} else {
			return Symboles;
		}

	}

	// _________________________________________________________________________________________________
	private final static int Clamp_Lopp(int Value, int Roof) {

		int temp;
		if (Value < 0) {

			Value = -Value;
		}

		temp = Value / Roof;

		return Value - temp * Roof;

	}

	private final static int Symetrical_Clamp_Lopp(int Value, int Roof) {

		// Loop the start of a loop to its and making it possible to
		// iterate 100 times throw a array of a size of 2
		// ( value 30 Max 30 final value 0 )
		// ( value -1 Max 30 final value 29 )

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

	// _________________________________________________________________________________________________

	private static char[] Reverse_Char_Array(char[] Source) {

		char[] Final = new char[Source.length];

		int index = 0;
		for (int i = Source.length - 1; i >= 0; i--) {

			Final[index] = Source[i];
			index++;
		}

		return Final;

	}

	private static int Increment_Sum(int Value) {
		int sum = 0;

		for (int i = Value; i > 0; i--) {

			sum += i;
		}

		return sum;

	}
}
