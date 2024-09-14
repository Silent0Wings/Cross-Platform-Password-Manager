package Package;

import java.awt.Component;
import java.awt.Container;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Data_Integrity {

	public static void Main_Handler(JFrame Source) {

		Handler(Source);
	}

	public static void Main_Handler(JPanel Source) {

		Handler(Source);
	}

	public static void Handler(Component component) {

		if (component != null) {

			if (component instanceof JTextField) {

				JTextField temp = (JTextField) component;

				// using for-each loop for iteration over Map.entrySet()
				if (temp != null) {

					temp.setText(Model.Integrity(temp.getText()));

				}
			}

			if (component instanceof JTextArea) {

				JTextArea temp = (JTextArea) component;

				// using for-each loop for iteration over Map.entrySet()
				if (temp != null) {

					temp.setText(Model.Integrity(temp.getText()));

				}
			}

			if (component instanceof JPasswordField) {

				JPasswordField temp = (JPasswordField) component;

				// using for-each loop for iteration over Map.entrySet()
				if (temp != null) {

					temp.setText(Model.Integrity(new String(temp.getPassword())));

				}
			}

//		System.err.println(Settings.Font_Size + " and " + component.getFont().getSize());
//		System.out.println(component.getFont().deriveFont(Settings.Font_Size).getSize());

			// System.out.println(component.getFont().getSize());
			if (component instanceof Container) {
				for (Component child : ((Container) component).getComponents()) {
					Handler(child);
				}
			}
		}
	}

	public static boolean Main_Corupted(JFrame Source) {

		int test = Corupted(Source);

		if (test == 0) {
			return false;

		} else {
			return true;

		}
	}

	public static boolean Main_Corupted(JPanel Source) {

		int test = Corupted(Source);

		if (test == 0) {
			return false;

		} else {
			return true;

		}
	}

	public static int Corupted(Component component) {

		int test = 0;
		if (component != null) {

			if (component instanceof JTextField) {

				JTextField temp = (JTextField) component;

				// using for-each loop for iteration over Map.entrySet()
				if (temp != null) {

					for (Entry<String, Integer> entry : Model.Entire_Model.entrySet()) {

						if (temp.getText().contains(entry.getKey())) {
							test++;
						}

					}
				}
			}

			if (component instanceof JTextArea) {

				JTextArea temp = (JTextArea) component;

				// using for-each loop for iteration over Map.entrySet()
				if (temp != null) {

					for (Entry<String, Integer> entry : Model.Entire_Model.entrySet()) {

						if (temp.getText().contains(entry.getKey())) {
							test++;
						}

					}
				}
			}

			if (component instanceof JPasswordField) {

				JPasswordField temp = (JPasswordField) component;

				// using for-each loop for iteration over Map.entrySet()
				if (temp != null) {

					for (Entry<String, Integer> entry : Model.Entire_Model.entrySet()) {

						if (new String(temp.getPassword()).contains(entry.getKey())) {
							test++;
						}

					}
				}
			}

//		System.err.println(Settings.Font_Size + " and " + component.getFont().getSize());
//		System.out.println(component.getFont().deriveFont(Settings.Font_Size).getSize());

			// System.out.println(component.getFont().getSize());
			if (component instanceof Container) {
				for (Component child : ((Container) component).getComponents()) {
					test += Corupted(child);
				}
			}
		}
		return test;
	}

}
