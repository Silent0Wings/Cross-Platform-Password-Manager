package Gui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import Package.Edit_Password_Jdialog;
import Package.Generate_Password;
import Package.Handle_Printing;
import Package.Node_File;
import Package.Stats;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class View_Password_Jdialog extends JDialog {

	// Old Password already store the date of creation of that pass word you just
	// need to figure out a way to display it

	private final JPanel contentPanel = new JPanel();
	private JTextField Title_TextField;
	private JTextField User_TextField;
	private JTextField Expiration_TextField;
	private JTextField Key_Word_TextField;
	private JTextField URL_TextField;
	private JTextArea Note_TextField;
	private JPasswordField passwordField;
	private JComboBox<String> OldPasswordBox;
	private DefaultBoundedRangeModel Rangemodel;
	public Stats Current_Stats;

	private JRadioButton FavoriteRadioButton;
	private boolean Show_Password;
	private JTextField Time_ModifiedTextField;
	private JTextField Time_Created_TextField;

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
	public View_Password_Jdialog(Node_File Main_File) {
		setType(Type.UTILITY);
		setTitle("Edit PassWord");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 700, 845);
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
			panel.setBounds(10, 11, 666, 735);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JButton ClipBoardBtn = new JButton("");
				ClipBoardBtn.setToolTipText("Copy Password");
				Icon ClipIcon = new ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/clipboard-4x.png"));
				ClipBoardBtn.setIcon(ClipIcon);
				ClipBoardBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				ClipBoardBtn.setBounds(580, 159, 43, 34);
				panel.add(ClipBoardBtn);
			}
			{
				JLabel Title_Label = new JLabel("Titre : ");
				Title_Label.setBackground(UIManager.getColor("Label.background"));
				Title_Label.setForeground(UIManager.getColor("Label.foreground"));
				Title_Label.setBounds(10, 69, 114, 34);
				panel.add(Title_Label);
			}
			{
				Title_TextField = new JTextField();
				Title_TextField.setEditable(false);
				Title_TextField.setForeground(UIManager.getColor("TextField.foreground"));
				Title_TextField.setColumns(10);
				Title_TextField.setBackground(UIManager.getColor("TextField.background"));
				Title_TextField.setBounds(134, 69, 489, 34);
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
				User_TextField.setEditable(false);
				User_TextField.setForeground(UIManager.getColor("TextField.foreground"));
				User_TextField.setColumns(10);
				User_TextField.setBackground(UIManager.getColor("TextField.background"));
				User_TextField.setBounds(134, 114, 489, 34);
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
				Expiration_TextField = new JTextField();
				Expiration_TextField.setEditable(false);
				Expiration_TextField.setForeground(UIManager.getColor("TextField.foreground"));
				Expiration_TextField.setColumns(10);
				Expiration_TextField.setBackground(UIManager.getColor("TextField.background"));
				Expiration_TextField.setBounds(134, 335, 489, 34);
				panel.add(Expiration_TextField);
			}
			{
				Key_Word_TextField = new JTextField();
				Key_Word_TextField.setEditable(false);
				Key_Word_TextField.setForeground(UIManager.getColor("TextField.foreground"));
				Key_Word_TextField.setColumns(10);
				Key_Word_TextField.setBackground(UIManager.getColor("TextField.background"));
				Key_Word_TextField.setBounds(134, 290, 489, 34);
				panel.add(Key_Word_TextField);
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
				URL_TextField.setEditable(false);
				URL_TextField.setForeground(UIManager.getColor("TextField.foreground"));
				URL_TextField.setColumns(10);
				URL_TextField.setBackground(UIManager.getColor("TextField.background"));
				URL_TextField.setBounds(134, 245, 489, 34);
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
				btnNewButton_1.setBounds(622, 159, 43, 34);
				panel.add(btnNewButton_1);
			}
			{
				passwordField = new JPasswordField();
				passwordField.setEditable(false);
				passwordField.enableInputMethods(true);
				passwordField.setForeground(UIManager.getColor("TextField.foreground"));
				passwordField.setBackground(UIManager.getColor("TextField.background"));
				passwordField.setBounds(134, 159, 489, 34);
				passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));

				panel.add(passwordField);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(135, 425, 488, 299);
				panel.add(scrollPane);

				Note_TextField = new JTextArea();
				Note_TextField.setEditable(false);
				scrollPane.setViewportView(Note_TextField);
				Note_TextField.setBackground(UIManager.getColor("TextField.background"));
				Note_TextField.setForeground(UIManager.getColor("TextField.foreground"));
			}

			JLabel Password_Label = new JLabel("Old Passwords");
			Password_Label.setForeground(UIManager.getColor("Label.foreground"));
			Password_Label.setBackground(UIManager.getColor("Label.background"));
			Password_Label.setBounds(10, 200, 114, 34);
			panel.add(Password_Label);

			FavoriteRadioButton = new JRadioButton("Favorite");
			FavoriteRadioButton.setEnabled(false);
			FavoriteRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			FavoriteRadioButton.setBounds(10, 7, 114, 55);
			panel.add(FavoriteRadioButton);

			OldPasswordBox = new JComboBox<String>();
			OldPasswordBox.setForeground(UIManager.getColor("TextField.foreground"));
			OldPasswordBox.setBackground(UIManager.getColor("TextField.background"));
			OldPasswordBox.setBounds(134, 204, 489, 34);
			panel.add(OldPasswordBox);
			// Icon OldPassicon = new
			// ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/arrow-thick-top-4x.png"));

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

			Open_Browser_Btn.setBounds(622, 245, 43, 34);
			Icon Open_Browser = new ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/browser-4x.png"));
			Open_Browser_Btn.setIcon(Open_Browser);
			panel.add(Open_Browser_Btn);
			{
				Rangemodel = new DefaultBoundedRangeModel();
				Rangemodel.setMaximum(100);
				Rangemodel.setMinimum(0);
				Rangemodel.setValue(0);
				JProgressBar progressBar = new JProgressBar(Rangemodel);
				progressBar.setToolTipText("Password Strength");
				progressBar.setForeground(UIManager.getColor("ProgressBar.foreground"));
				progressBar.setBackground(UIManager.getColor("ProgressBar.background"));
				progressBar.setBounds(134, 193, 489, 9);
				panel.add(progressBar);
			}

			Time_ModifiedTextField = new JTextField();
			Time_ModifiedTextField.setForeground(UIManager.getColor("TextField.foreground"));
			Time_ModifiedTextField.setBackground(UIManager.getColor("TextField.background"));
			Time_ModifiedTextField.setEditable(false);
			Time_ModifiedTextField.setColumns(10);
			Time_ModifiedTextField.setBounds(443, 380, 180, 34);
			panel.add(Time_ModifiedTextField);

			JLabel Time_Modified_Jlabel = new JLabel("Last Time Modified:");
			Time_Modified_Jlabel.setBackground(UIManager.getColor("Label.background"));
			Time_Modified_Jlabel.setForeground(UIManager.getColor("Label.foreground"));
			Time_Modified_Jlabel.setBounds(319, 380, 114, 34);
			panel.add(Time_Modified_Jlabel);

			Time_Created_TextField = new JTextField();
			Time_Created_TextField.setForeground(UIManager.getColor("TextField.foreground"));
			Time_Created_TextField.setBackground(UIManager.getColor("TextField.background"));
			Time_Created_TextField.setEditable(false);
			Time_Created_TextField.setColumns(10);
			Time_Created_TextField.setBounds(134, 380, 180, 34);
			panel.add(Time_Created_TextField);

			JLabel Time_Created_Jlabel = new JLabel("Time created :");
			Time_Created_Jlabel.setBackground(UIManager.getColor("Label.background"));
			Time_Created_Jlabel.setForeground(UIManager.getColor("Label.foreground"));
			Time_Created_Jlabel.setBounds(10, 380, 114, 34);
			panel.add(Time_Created_Jlabel);
			{
				JButton Print_Btn = new JButton("Print");
				Print_Btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Handle_Printing.printComponent(contentPanel);
					}
				});
				Print_Btn.setBounds(567, 7, 89, 23);
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

						setVisible(false);
						dispose();
					}
				});

				okButton.setActionCommand("OK");
				Icon homeico = new ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/circle-check-4x.png"));
				okButton.setIcon(homeico);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
			}

			Load_Data(Main_File);
		}

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
			if (Main_File.getModified() != null) {

				Time_ModifiedTextField.setText(Main_File.getModified());
			}
			if (Main_File.getNote() != null) {

				Note_TextField.setText(Main_File.getNote());
			}
			if (Main_File.getTime_Created() != null) {

				Time_Created_TextField.setText(Main_File.getTime_Created());
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
}
