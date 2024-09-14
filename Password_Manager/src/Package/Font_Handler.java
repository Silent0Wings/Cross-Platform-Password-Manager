package Package;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Font_Handler {

	public static void changeFont_Size(Component component) {

		Font temp = component.getFont();
		Font Newtemp = new Font(temp.getFontName(), temp.getStyle(), Settings.Font_Size);
		component.setFont(Newtemp);

//		System.err.println(Settings.Font_Size + " and " + component.getFont().getSize());
//		//System.out.println(component.getFont().deriveFont(Settings.Font_Size).getSize());

		// System.out.println(component.getFont().getSize());
		if (component instanceof Container) {
			for (Component child : ((Container) component).getComponents()) {
				changeFont_Size(child);
			}
		}

		if (component instanceof JMenuBar) {
			JMenuBar menubar1 = (JMenuBar) component;
			for (Component child : menubar1.getComponents()) {
				changeFont(child);
			}

			for (int i = 0; i < menubar1.getMenuCount(); i++) {
				JMenu menu1 = menubar1.getMenu(i);

				if (menu1 != null) {

					for (int j = 0; j < menu1.getMenuComponentCount(); j++) {
						Component comp = menu1.getMenuComponent(j);

						changeFont_Size(comp);

					}
				}
			}

		}
		if (component instanceof JMenu) {
			JMenu Temp = (JMenu) component;
			for (Component child : Temp.getComponents()) {
				changeFont(child);
			}

			for (int i = 0; i < Temp.getItemCount(); i++) {
				JMenuItem menu1 = Temp.getItem(i);
				if (menu1 != null) {
					changeFont_Size(menu1);

				}
			}

		}
	}

	public static void changeFont(Component component) {

		Font temp = component.getFont();
		Font Newtemp = new Font(Settings.Font_Name, temp.getStyle(), Settings.Font_Size);
		component.setFont(Newtemp);

		if (component instanceof Container) {
			for (Component child : ((Container) component).getComponents()) {
				changeFont(child);
			}
		}
		if (component instanceof JMenuBar) {
			JMenuBar menubar1 = (JMenuBar) component;
			for (Component child : menubar1.getComponents()) {
				changeFont(child);
			}

			for (int i = 0; i < menubar1.getMenuCount(); i++) {
				JMenu menu1 = menubar1.getMenu(i);

				if (menu1 != null) {

					for (int j = 0; j < menu1.getMenuComponentCount(); j++) {
						Component comp = menu1.getMenuComponent(j);

						changeFont(comp);

					}
				}
			}

		}
		if (component instanceof JMenu) {
			JMenu Temp = (JMenu) component;
			for (Component child : Temp.getComponents()) {
				changeFont(child);
			}

			for (int i = 0; i < Temp.getItemCount(); i++) {
				JMenuItem menu1 = Temp.getItem(i);
				if (menu1 != null) {
					changeFont(menu1);

				}
			}

		}

	}

}
