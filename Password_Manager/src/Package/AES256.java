package Package;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

public class AES256 {

	public static String Aes256_Encrypt(String strToEncrypt, String SECRET_KEY) {
		try {
			byte[] iv = Byte_From_Key(SECRET_KEY.toCharArray());
			IvParameterSpec ivspec = new IvParameterSpec(iv);

			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SECRET_KEY.getBytes(), 65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());

			JOptionPane.showConfirmDialog(null, "Error while encrypting: " + e.toString(), "Errore",
					JOptionPane.CLOSED_OPTION, JOptionPane.CLOSED_OPTION, null);
		}
		return null;
	}

	public static String Aes256_Decrypt(String strToDecrypt, String SECRET_KEY) {
		try {
			byte[] iv = Byte_From_Key(SECRET_KEY.toCharArray());
			IvParameterSpec ivspec = new IvParameterSpec(iv);

			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SECRET_KEY.getBytes(), 65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
			JOptionPane.showConfirmDialog(null, "Wrong PassWord", "Errore", JOptionPane.CLOSED_OPTION,
					JOptionPane.CLOSED_OPTION, null);
		}
		return null;
	}

	private static byte[] Byte_From_Key(char[] Source) {

		if (Source != null) {

			if (Source.length != 0) {

				int[] temp = Char_Array_To_Ascii_Array(Source);

				if (temp != null && temp.length != 0) {

					byte[] iv = new byte[16];

					int Size = Source.length;

					for (int i = 0; i < iv.length; i++) {

						byte b = 0;

						if (i < Size - 1) {
							iv[i] = (byte) temp[i];
						} else {
							iv[i] = b;

						}

					}
					return iv;

				}
			}

		}
		return null;

	}

	private static int[] Char_Array_To_Ascii_Array(char[] Source) {

		if (Source != null && Source.length != 0) {

			int[] Holder = new int[Source.length];
			for (int i = 0; i < Holder.length; i++) {

				char c2 = Source[i];
				int b = c2;
				Holder[i] = b;

			}

			return Holder;
		}

		return null;
	}

}