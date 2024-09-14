package Package;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Edit_Password_Jdialog extends JDialog {

	// Old Password already store the date of creation of that pass word you just
	// need to figure out a way to display it

	private final JPanel contentPanel = new JPanel();
	private JTextField Title_TextField;
	private JTextField User_TextField;
	private JTextField URL_TextField;
	private JTextArea Note_TextField;
	private JTextField Expiration_TextField;
	private JPasswordField passwordField;
	private JRadioButton FavoriteRadioButton;
	private JComboBox<String> OldPasswordBox;
	private DefaultBoundedRangeModel Rangemodel;

	private final JPopupMenu Generate_menu = new JPopupMenu("Password_menu");

	public Stats Current_Stats;
	private boolean Show_Password = false;;
	private JTextField Time_Created_TextField;
	private JTextField Key_Word_TextField;
	private JTextField Time_ModifiedTextField;
//	public static void main(String[] args) {
//		try {
//			Password_Gui dialog = new Password_Gui();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public Edit_Password_Jdialog(Node_File Main_File) {
		setAlwaysOnTop(true);
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Edit PassWord");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 741, 845);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("menu"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setForeground(UIManager.getColor("Panel.foreground"));
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, UIManager.getColor("menuPressedItemB"), null));
			panel.setBackground(UIManager.getColor("Panel.background"));
			panel.setBounds(10, 11, 712, 735);
			contentPanel.add(panel);
			panel.setLayout(null);

			JButton ClipBoardBtn = new JButton("");
			ClipBoardBtn.setToolTipText("Copy Password");
			Icon ClipIcon = new ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/clipboard-4x.png"));
			ClipBoardBtn.setIcon(ClipIcon);
			ClipBoardBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					StringSelection stringSelection = new StringSelection(new String(passwordField.getPassword()));
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(stringSelection, null);

				}
			});
			ClipBoardBtn.setBounds(585, 159, 43, 34);
			panel.add(ClipBoardBtn);
			{
				JLabel Title_Label = new JLabel("Titre : ");
				Title_Label.setBackground(UIManager.getColor("Label.background"));
				Title_Label.setForeground(UIManager.getColor("Label.foreground"));
				Title_Label.setBounds(10, 69, 114, 34);
				panel.add(Title_Label);
			}
			{
				Title_TextField = new JTextField();
				Title_TextField.setForeground(UIManager.getColor("TextField.foreground"));
				Title_TextField.setColumns(10);
				Title_TextField.setBackground(UIManager.getColor("TextField.background"));
				Title_TextField.setBounds(103, 69, 489, 34);
				panel.add(Title_TextField);
			}
			{
				JLabel User_Label = new JLabel("Nom d'utilisateur :");
				User_Label.setBackground(UIManager.getColor("Label.background"));
				User_Label.setForeground(UIManager.getColor("Label.foreground"));
				User_Label.setBounds(10, 114, 114, 34);
				panel.add(User_Label);
			}
			{
				User_TextField = new JTextField();
				User_TextField.setForeground(UIManager.getColor("TextField.foreground"));
				User_TextField.setColumns(10);
				User_TextField.setBackground(UIManager.getColor("TextField.background"));
				User_TextField.setBounds(103, 114, 489, 34);
				panel.add(User_TextField);
			}
			{
				JLabel Password_Label = new JLabel("Mot de passe :");
				Password_Label.setBackground(UIManager.getColor("Label.background"));
				Password_Label.setForeground(UIManager.getColor("Label.foreground"));
				Password_Label.setBounds(10, 159, 114, 34);
				panel.add(Password_Label);
			}
			{
				JLabel Expire_Label = new JLabel("Expire le : ");
				Expire_Label.setBackground(UIManager.getColor("Label.background"));
				Expire_Label.setForeground(UIManager.getColor("Label.foreground"));
				Expire_Label.setBounds(10, 335, 114, 34);
				panel.add(Expire_Label);
			}
			{
				JLabel KeyWord_Label = new JLabel("Mot Cl\u00E9 :");
				KeyWord_Label.setBackground(UIManager.getColor("Label.background"));
				KeyWord_Label.setForeground(UIManager.getColor("Label.foreground"));
				KeyWord_Label.setBounds(10, 290, 114, 34);
				panel.add(KeyWord_Label);
			}
			{
				JLabel URL_Label = new JLabel("URL :");
				URL_Label.setBackground(UIManager.getColor("Label.background"));
				URL_Label.setForeground(UIManager.getColor("Label.foreground"));
				URL_Label.setBounds(10, 245, 114, 34);
				panel.add(URL_Label);
			}
			{

				URL_TextField = new JTextField();
				URL_TextField.setForeground(UIManager.getColor("TextField.foreground"));
				URL_TextField.setColumns(10);
				URL_TextField.setBackground(UIManager.getColor("TextField.background"));
				URL_TextField.setBounds(103, 245, 489, 34);
				panel.add(URL_TextField);
			}
			{
				JLabel Note_Label = new JLabel("Note :");
				Note_Label.setBackground(UIManager.getColor("Label.background"));
				Note_Label.setForeground(UIManager.getColor("Label.foreground"));
				Note_Label.setBounds(10, 425, 114, 34);
				panel.add(Note_Label);
			}
			{
				JButton btnNewButton_1 = new JButton("");
				btnNewButton_1.setToolTipText("View Password");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (Show_Password) {
							passwordField.setEchoChar('\u25cf');
							Show_Password = !Show_Password;
						} else {
							passwordField.setEchoChar((char) 0); // By this line of code. We will actually see the
							Show_Password = !Show_Password;
						}
					}
				});

				btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				Icon Toggle_Viewicon = new ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/eye-4x.png"));
				btnNewButton_1.setIcon(Toggle_Viewicon);
				btnNewButton_1.setBounds(627, 159, 43, 34);
				panel.add(btnNewButton_1);
			}
			{
				passwordField = new JPasswordField();
				passwordField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {

						Rangemodel
								.setValue(Generate_Password.Password_strength(new String(passwordField.getPassword())));

					}
				});
				passwordField.enableInputMethods(true);
				passwordField.setForeground(UIManager.getColor("TextField.foreground"));
				passwordField.setBackground(UIManager.getColor("TextField.background"));
				passwordField.setBounds(103, 159, 489, 34);
				passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));

				panel.add(passwordField);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(104, 425, 488, 299);
				panel.add(scrollPane);

				Note_TextField = new JTextArea();
				scrollPane.setViewportView(Note_TextField);
				Note_TextField.setBackground(UIManager.getColor("TextField.background"));
				Note_TextField.setForeground(UIManager.getColor("TextField.foreground"));
			}

			JLabel Expire_Label = new JLabel("Time created :");
			Expire_Label.setForeground(UIManager.getColor("Label.foreground"));
			Expire_Label.setBackground(UIManager.getColor("Label.background"));
			Expire_Label.setBounds(10, 380, 114, 34);
			panel.add(Expire_Label);

			Time_Created_TextField = new JTextField();
			Time_Created_TextField.setEditable(false);
			Time_Created_TextField.setColumns(10);
			Time_Created_TextField.setForeground(UIManager.getColor("TextField.foreground"));
			Time_Created_TextField.setBackground(UIManager.getColor("TextField.background"));
			Time_Created_TextField.setBounds(103, 380, 180, 34);
			panel.add(Time_Created_TextField);

			JLabel Password_Label = new JLabel("Old Passwords");
			Password_Label.setForeground(UIManager.getColor("Label.foreground"));
			Password_Label.setBackground(UIManager.getColor("Label.background"));
			Password_Label.setBounds(10, 200, 114, 34);
			panel.add(Password_Label);

			FavoriteRadioButton = new JRadioButton("Favorite");
			FavoriteRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// System.out.println(FavoriteRadioButton.isSelected());
				}
			});
			FavoriteRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			FavoriteRadioButton.setBounds(10, 7, 114, 55);
			panel.add(FavoriteRadioButton);

			JButton btnNewButton = new JButton("");
			btnNewButton.setToolTipText("Replace Password");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					OldPasswordBox.getSelectedItem();

					if (OldPasswordBox != null) {

						if (OldPasswordBox.getSelectedItem() != null) {

							if (OldPasswordBox.getSelectedItem().toString() != "") {

								passwordField.setText(OldPasswordBox.getSelectedItem().toString());
							}

						}
					}

				}
			});
			btnNewButton.setBounds(590, 200, 43, 34);
			Icon OldPassicon = new ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/arrow-thick-top-4x.png"));
			btnNewButton.setIcon(OldPassicon);
			panel.add(btnNewButton);

			JButton Open_Browser_Btn = new JButton("");
			Open_Browser_Btn.setToolTipText("Open Link");
			Open_Browser_Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String Temp = URL_TextField.getText().toLowerCase();
					System.err.print(Temp);

					if (Temp != ""
							&& (Temp.contains("www.") || Temp.contains("http://") || Temp.contains("https://"))) {

						System.err.print("Yaasssssssssss");
						try {

							Desktop.getDesktop().browse(new URI(Temp));

						} catch (IOException | URISyntaxException e1) {
							e1.printStackTrace();
						}

					}

				}
			});

			Open_Browser_Btn.setBounds(590, 245, 43, 34);
			Icon Open_Browser = new ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/browser-4x.png"));
			Open_Browser_Btn.setIcon(Open_Browser);
			panel.add(Open_Browser_Btn);

			Key_Word_TextField = new JTextField();
			Key_Word_TextField.setForeground(UIManager.getColor("TextField.foreground"));
			Key_Word_TextField.setColumns(10);
			Key_Word_TextField.setBackground(UIManager.getColor("TextField.background"));
			Key_Word_TextField.setBounds(103, 290, 489, 34);
			panel.add(Key_Word_TextField);
			{
				Expiration_TextField = new JTextField();
				Expiration_TextField.setForeground(UIManager.getColor("TextField.foreground"));
				Expiration_TextField.setBackground(UIManager.getColor("TextField.background"));
				Expiration_TextField.setColumns(10);
				Expiration_TextField.setBounds(103, 335, 489, 34);
				panel.add(Expiration_TextField);
			}

			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.setToolTipText("Generate Password");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Generate_menu.show(btnNewButton_1, 0, 0);

				}
			});
			Icon Key_Icon = new ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/key-3x.png"));
			btnNewButton_1.setIcon(Key_Icon);
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton_1.setBounds(669, 159, 43, 34);
			panel.add(btnNewButton_1);

			OldPasswordBox = new JComboBox<String>();
			OldPasswordBox.setForeground(UIManager.getColor("TextField.foreground"));
			OldPasswordBox.setBackground(UIManager.getColor("TextField.background"));
			OldPasswordBox.setBounds(103, 204, 489, 34);
			panel.add(OldPasswordBox);
			{
				Rangemodel = new DefaultBoundedRangeModel();
				Rangemodel.setMaximum(100);
				Rangemodel.setMinimum(0);
				Rangemodel.setValue(0);
				JProgressBar progressBar = new JProgressBar(Rangemodel);
				progressBar.setToolTipText("Password Strength");
				progressBar.setForeground(UIManager.getColor("ProgressBar.foreground"));
				progressBar.setBackground(UIManager.getColor("ProgressBar.background"));
				progressBar.setBounds(103, 194, 489, 9);
				panel.add(progressBar);
			}
			{
				Time_ModifiedTextField = new JTextField();
				Time_ModifiedTextField.setForeground(UIManager.getColor("TextField.foreground"));
				Time_ModifiedTextField.setBackground(UIManager.getColor("TextField.background"));
				Time_ModifiedTextField.setEditable(false);
				Time_ModifiedTextField.setColumns(10);
				Time_ModifiedTextField.setBounds(412, 380, 180, 34);
				panel.add(Time_ModifiedTextField);
			}
			{
				JLabel Modified_Label = new JLabel("Last Time Modified:");
				Modified_Label.setForeground(UIManager.getColor("Label.foreground"));
				Modified_Label.setBackground(UIManager.getColor("Label.background"));
				Modified_Label.setBounds(288, 380, 114, 34);
				panel.add(Modified_Label);
			}
			{
				JButton Print_Btn = new JButton("Print");
				Print_Btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Handle_Printing.printComponent(contentPanel);
					}
				});
				Print_Btn.setBounds(613, 7, 89, 23);
				panel.add(Print_Btn);
			}

			// rdbtnNewRadioButton.setIcon(Favicon);
//			rdbtnNewRadioButton.setDisabledIcon(Faviconclosed);

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (Data_Integrity.Main_Corupted(contentPanel)) {

							Data_Integrity.Main_Handler(contentPanel);
						}

						if (Data_Integrity.Main_Corupted(contentPanel) == false) {

							Data_Return(Main_File);

							setVisible(false);
							dispose();
						}
					}
				});

				okButton.setActionCommand("OK");
				Icon homeico = new ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/circle-check-4x.png"));
				okButton.setIcon(homeico);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						setVisible(false);
						dispose();

					}
				});
				cancelButton.setActionCommand("Cancel");
				Icon Cancelico = new ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/circle-x-4x.png"));
				cancelButton.setIcon(Cancelico);
				buttonPane.add(cancelButton);
			}

			Load_Data(Main_File);
		}
		Font_Handler.changeFont(contentPanel);
		Font_Handler.changeFont_Size(contentPanel);
		GenerateJPopupMenu();
		this.setModal(true);
		this.setVisible(true);
	}

	public void Load_Data(Node_File Main_File) {

		if (Main_File != null) {
			System.err.println("Load_Data");

			if (Main_File.getName() != null) {

				Title_TextField.setText(Main_File.getName());
			}
			if (Main_File.getUser_Name() != null) {

				User_TextField.setText(Main_File.getUser_Name());
			}
			if (Main_File.getPassword() != null) {

				passwordField.setText(Main_File.getPassword());
				Rangemodel.setValue(Generate_Password.Password_strength(new String(passwordField.getPassword())));

			}
			if (Main_File.getUrl() != null) {

				URL_TextField.setText(Main_File.getUrl());
			}
			if (Main_File.getKeyWord() != null) {

				Key_Word_TextField.setText(Main_File.getKeyWord());
			}
			if (Main_File.getExpiration() != null) {

				Expiration_TextField.setText(Main_File.getExpiration());
			}
			if (Main_File.getTime_Created() != null) {

				Time_Created_TextField.setText(Main_File.getTime_Created());
			}
			if (Main_File.getNote() != null) {

				Note_TextField.setText(Main_File.getNote());
			}
			if (Main_File.getTime_Created() != null) {

				Time_Created_TextField.setText(Main_File.getTime_Created());
			}
			if (Main_File.getModified() != null) {

				Time_ModifiedTextField.setText(Main_File.getModified());
			}
			FavoriteRadioButton.setSelected(Main_File.getFavorite());

			Map<String, String> Old_Password = Main_File.getOld_Password();

			if (Old_Password.size() != 0) {

				for (Entry<String, String> entry : Old_Password.entrySet()) {

					OldPasswordBox.addItem(entry.getKey());

				}
			}

		}

	}

	public void Data_Return(Node_File Main_File) {

		if (String.valueOf(passwordField.getPassword()) != null
				&& String.valueOf(passwordField.getPassword()) != "" & passwordField.getPassword().length != 0) {

			if (Title_TextField.getText().equals(Main_File.getName())) {

			} else if (Main_File.Get_Parent().File_Children.containsKey(Title_TextField.getText())) {

				return;
			}

			/// Error Main
			// Main_File.getName() or any of the others return null value
			// Therfore a check if every value is null is necessary before any operation

			if (Title_TextField.getText().length() != 0 && Title_TextField.getText() != "") {

				boolean Tempi = false;
				;

				// Name

				if (Main_File.getName().equals(Title_TextField.getText())) {
					// In case of a new Name

				} else if (Main_File.Get_Parent().File_Children.containsKey(Title_TextField.getText()) == false) {
					// In case of the same name (didnt change the name of the file)

					Main_File.Rename_Node(Title_TextField.getText());

					Tempi = true;
				}

				// User Name
				if (Main_File.getUser_Name() == null) {
					Main_File.setUser_Name(User_TextField.getText());
					Tempi = true;
				} else if (Main_File.getUser_Name().equals(User_TextField.getText()) == false) {

					Main_File.setUser_Name(User_TextField.getText());
					Tempi = true;

				}

				// Password
				if (Main_File.getPassword() == null) {
					Main_File.setPassword(String.valueOf(passwordField.getPassword()));
					Tempi = true;
				} else if (Main_File.getPassword().equals(String.valueOf(passwordField.getPassword())) == false) {

					Main_File.setPassword(String.valueOf(passwordField.getPassword()));
					Tempi = true;

				}

				// Url
				if (Main_File.getUrl() == null) {
					Main_File.setUrl(URL_TextField.getText());
					Tempi = true;
				} else if (Main_File.getUrl().equals(URL_TextField.getText()) == false) {

					Main_File.setUrl(URL_TextField.getText());
					Tempi = true;

				}

				// Expiration

				if (Main_File.getExpiration() == null) {
					Main_File.setExpiration(Expiration_TextField.getText());
					Tempi = true;
				} else if (Main_File.getExpiration().equals(Expiration_TextField.getText()) == false) {

					Main_File.setExpiration(Expiration_TextField.getText());
					Tempi = true;

				}

				// Last Modified

				if (Main_File.getModified() == null) {
					Main_File.setModified(Time_ModifiedTextField.getText());
					Tempi = true;
				} else if (Main_File.getModified().equals(Time_ModifiedTextField.getText()) == false) {

					Main_File.setModified(Time_ModifiedTextField.getText());
					Tempi = true;

				}

				// KeyWord
				if (Main_File.getKeyWord() == null) {
					Main_File.setKeyWord(Key_Word_TextField.getText());
					Tempi = true;
				} else if (Main_File.getKeyWord().equals(Key_Word_TextField.getText()) == false) {

					Main_File.setKeyWord(Key_Word_TextField.getText());
					Tempi = true;

				}

				// Note
				if (Main_File.getNote() == null) {
					Main_File.setNote(Note_TextField.getText());
					Tempi = true;
				} else if (Main_File.getNote().equals(Note_TextField.getText()) == false) {

					Main_File.setNote(Note_TextField.getText());
					Tempi = true;

				}

//				// Time Created
//				if (Main_File.getTime_Created() == null) {
//					Main_File.setTime_Created(Time_Created_TextField.getText());
//					Tempi = true;
//				} else if (Main_File.getTime_Created().equals(Time_Created_TextField.getText()) == false) {
//
//					Main_File.setTime_Created(Time_Created_TextField.getText());
//					Tempi = true;
//
//				}

				// Favorite
				if (Main_File.getFavorite() != FavoriteRadioButton.isSelected()) {

					Main_File.setFavorite(FavoriteRadioButton.isSelected());

					// System.out.println(Main_File.getFavorite());
					Tempi = true;

				}

				if (Tempi) {
					Main_File.setModified();
					if (Current_Stats != null) {

						Current_Stats.Modified_Passwords++;
					}
				}

			}

		}

	}

	public void GenerateJPopupMenu() {

		Generate_menu.setBounds(0, 0, 75, 174);
		Font_Handler.changeFont(Generate_menu);
		Font_Handler.changeFont_Size(Generate_menu);

		JRadioButton AlphaRadioButton = new JRadioButton("Use Alphabets LowerCase : ");
		AlphaRadioButton.setToolTipText("a .... z");
		AlphaRadioButton.setBounds(279, 25, 75, 23);
		AlphaRadioButton.setSelected(Settings.Alphabetic);
		Generate_menu.add(AlphaRadioButton);

		JRadioButton AlphaUpperRadioButton = new JRadioButton("Use Alphabets UpperCase : ");
		AlphaUpperRadioButton.setToolTipText("A .... Z ");
		AlphaUpperRadioButton.setBounds(279, 25, 75, 23);
		AlphaUpperRadioButton.setSelected(Settings.AlphabeticUpper);
		Generate_menu.add(AlphaUpperRadioButton);

		JRadioButton NumbRadioButton = new JRadioButton("Use Numbers : ");
		NumbRadioButton.setToolTipText("0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9");
		NumbRadioButton.setBounds(279, 25, 75, 23);
		NumbRadioButton.setSelected(Settings.Numeric);
		Generate_menu.add(NumbRadioButton);

		JRadioButton SymbRadioButton = new JRadioButton("Use Symbols : ");
		SymbRadioButton.setToolTipText("Symbols :\r\n(&\u00E9\"'(-)=~#{[|`\\^@]}*)");
		SymbRadioButton.setBounds(279, 25, 75, 23);
		SymbRadioButton.setSelected(Settings.Symbols);
		Generate_menu.add(SymbRadioButton);

		JRadioButton UnSymbRadioButton = new JRadioButton("Use unique Symbols : ");
		UnSymbRadioButton.setToolTipText("Extended Symbols : \r\n(Extended Ascii Table)\r\n(\u00A9,\u00B6,\u00A5...)");
		UnSymbRadioButton.setBounds(279, 25, 75, 23);
		UnSymbRadioButton.setSelected(Settings.Extended);
		Generate_menu.add(UnSymbRadioButton);

		JLabel lblNewLabel_2 = new JLabel("Excluded");
		lblNewLabel_2.setBounds(12, 309, 49, 14);
		Generate_menu.add(lblNewLabel_2);

		JTextField ExcludedField = new JTextField();
		ExcludedField.setBounds(12, 326, 172, 20);
		ExcludedField.setColumns(10);
		ExcludedField.setText(Settings.Exluding);
		Generate_menu.add(ExcludedField);

		JSeparator separator = new JSeparator();
		separator.setBounds(237, 40, 75, 11);
		Generate_menu.add(separator);

		JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setBounds(170, 29, 75, 29);
		Generate_menu.add(lblNewLabel);

		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				float Slide_Value = slider.getValue();
				lblNewLabel.setText(Slide_Value + "");
			}
		});
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMaximum(256);
		slider.setMinimum(0);
		slider.setBounds(191, 11, 75, 19);
		slider.setValue(0);
		Generate_menu.add(slider);

		JSeparator separator1 = new JSeparator();
		separator.setBounds(237, 40, 75, 11);
		Generate_menu.add(separator1);

		JCheckBox Use_Words_CheckBox = new JCheckBox("Use Words");
		Use_Words_CheckBox.setBounds(543, 191, 172, 23);
		Generate_menu.add(Use_Words_CheckBox);

		JButton Generate_Button = new JButton("Generate Password");
		Generate_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (AlphaRadioButton.isSelected() || AlphaUpperRadioButton.isSelected() || NumbRadioButton.isSelected()
						|| SymbRadioButton.isSelected() || Use_Words_CheckBox.isSelected() && slider.getValue() != 0) {

					if (Use_Words_CheckBox.isSelected()) {

						String Holder = Generate_Password.Generate_Phrase(slider.getValue());

						passwordField.setText(Holder);

						Rangemodel
								.setValue(Generate_Password.Password_strength(new String(passwordField.getPassword())));

					} else {

						int alp = AlphaRadioButton.isSelected() ? 1 : 0;
						int alpupper = AlphaUpperRadioButton.isSelected() ? 1 : 0;
						int num = NumbRadioButton.isSelected() ? 1 : 0;
						int sym = SymbRadioButton.isSelected() ? 1 : 0;
						int ex = UnSymbRadioButton.isSelected() ? 1 : 0;

						String Holder = Generate_Password.RemoteGeneratePassword(slider.getValue(), alp, alpupper, num,
								sym, ex, ExcludedField.getText().toString());

						if (Holder.length() != 0 && Holder != "") {

							passwordField.setText(Holder);

							Rangemodel.setValue(
									Generate_Password.Password_strength(new String(passwordField.getPassword())));

						}
					}

				}

			}
		});
		Generate_Button.setBounds(275, 25, 75, 23);
		Generate_menu.add(Generate_Button);

	}

}
