package Gui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.UIManager;
import com.toedter.components.JSpinField;

import Package.Edit_Password_Jdialog;
import Package.Font_Handler;
import Package.Generate_Password;
import Package.Node_File;
import Package.Settings;

import javax.swing.JProgressBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SuppressWarnings("serial")
public class New_Password_Jdialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField Title_TextField;
	private JTextField User_TextField;
	private JTextField Key_Word_TextField;
	private JTextField URL_TextField;
	private JTextArea Note_TextField;
	private JPasswordField passwordField;

	private DefaultBoundedRangeModel Rangemodel;
	private final JPopupMenu Generate_menu = new JPopupMenu("Password_menu");

	public Node_File temp;

	private boolean Show_Password = false;;

	public interface Jdialog_Answer {

		void GetResponse(Node_File Temp_File);

	}

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
	public New_Password_Jdialog(Jdialog_Answer TheJdialog_Answer) {
		setAlwaysOnTop(true);
		setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 741, 686);

		// setBounds(100, 100, 771, 686);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(UIManager.getColor("Menu.foreground"));
		contentPanel.setBackground(UIManager.getColor("Menu.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 717, 605);
		panel.setForeground(UIManager.getColor("Panel.foreground"));
		panel.setBackground(UIManager.getColor("Panel.background"));
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel Title_Label = new JLabel("Titre : ");
		Title_Label.setBounds(10, 11, 114, 34);
		Title_Label.setBackground(UIManager.getColor("Label.background"));
		Title_Label.setForeground(UIManager.getColor("Label.foreground"));
		panel.add(Title_Label);

		Title_TextField = new JTextField();
		Title_TextField.setBounds(104, 11, 489, 34);
		Title_TextField.setForeground(UIManager.getColor("TextField.foreground"));
		Title_TextField.setColumns(10);
		Title_TextField.setBackground(UIManager.getColor("TextField.background"));
		panel.add(Title_TextField);

		JLabel User_Label = new JLabel("Nom d'utilisateur :");
		User_Label.setBounds(10, 56, 114, 34);
		User_Label.setBackground(UIManager.getColor("Label.background"));
		User_Label.setForeground(UIManager.getColor("Label.foreground"));
		panel.add(User_Label);

		User_TextField = new JTextField();
		User_TextField.setBounds(104, 56, 489, 34);
		User_TextField.setForeground(UIManager.getColor("TextField.foreground"));
		User_TextField.setColumns(10);
		User_TextField.setBackground(UIManager.getColor("TextField.background"));
		panel.add(User_TextField);

		JLabel Password_Label = new JLabel("Mot de passe :");
		Password_Label.setBounds(10, 101, 114, 34);
		Password_Label.setBackground(UIManager.getColor("Label.background"));
		Password_Label.setForeground(UIManager.getColor("Label.foreground"));
		panel.add(Password_Label);

		JLabel Expire_Label = new JLabel("Expire le : ");
		Expire_Label.setBounds(10, 236, 114, 34);
		Expire_Label.setBackground(UIManager.getColor("Label.background"));
		Expire_Label.setForeground(UIManager.getColor("Label.foreground"));
		panel.add(Expire_Label);

		Key_Word_TextField = new JTextField();
		Key_Word_TextField.setBounds(104, 191, 489, 34);
		Key_Word_TextField.setForeground(UIManager.getColor("TextField.foreground"));
		Key_Word_TextField.setColumns(10);
		Key_Word_TextField.setBackground(UIManager.getColor("TextField.background"));
		panel.add(Key_Word_TextField);

		JLabel KeyWord_Label = new JLabel("Mot Cl\u00E9 :");
		KeyWord_Label.setBounds(10, 191, 114, 34);
		KeyWord_Label.setBackground(UIManager.getColor("Label.background"));
		KeyWord_Label.setForeground(UIManager.getColor("Label.foreground"));
		panel.add(KeyWord_Label);

		JLabel URL_Label = new JLabel("URL :");
		URL_Label.setBounds(10, 146, 114, 34);
		URL_Label.setBackground(UIManager.getColor("Label.background"));
		URL_Label.setForeground(UIManager.getColor("Label.foreground"));
		panel.add(URL_Label);

		URL_TextField = new JTextField();
		URL_TextField.setBounds(104, 146, 489, 34);
		URL_TextField.setForeground(UIManager.getColor("TextField.foreground"));
		URL_TextField.setColumns(10);
		URL_TextField.setBackground(UIManager.getColor("TextField.background"));
		panel.add(URL_TextField);

		JLabel Note_Label = new JLabel("Note :");
		Note_Label.setBounds(10, 289, 114, 34);
		Note_Label.setBackground(UIManager.getColor("Label.background"));
		Note_Label.setForeground(UIManager.getColor("Label.foreground"));
		panel.add(Note_Label);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton_1.setBounds(630, 101, 43, 35);
		Icon Toggle_Viewicon = new ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/eye-4x.png"));
		btnNewButton_1.setIcon(Toggle_Viewicon);
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
		panel.add(btnNewButton_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(104, 101, 489, 34);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Rangemodel.setValue(Generate_Password.Password_strength(new String(passwordField.getPassword())));

			}
		});
		passwordField.enableInputMethods(true);
		passwordField.setForeground(UIManager.getColor("TextField.foreground"));
		passwordField.setBackground(UIManager.getColor("TextField.background"));
		passwordField.setEchoChar((char) 0);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(passwordField);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(105, 281, 488, 299);
		panel.add(scrollPane);

		Note_TextField = new JTextArea();
		scrollPane.setViewportView(Note_TextField);
		Note_TextField.setBackground(UIManager.getColor("TextField.background"));
		Note_TextField.setForeground(UIManager.getColor("TextField.foreground"));

		JLabel lblNewLabel_2 = new JLabel("Year");
		lblNewLabel_2.setForeground(UIManager.getColor("Label.foreground"));
		lblNewLabel_2.setBounds(114, 250, 49, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Month");
		lblNewLabel_2_1.setForeground(UIManager.getColor("Label.foreground"));
		lblNewLabel_2_1.setBounds(221, 250, 49, 14);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Days");
		lblNewLabel_2_1_1.setForeground(UIManager.getColor("Label.foreground"));
		lblNewLabel_2_1_1.setBounds(316, 250, 49, 14);
		panel.add(lblNewLabel_2_1_1);

		JSpinField Year_spinField = new JSpinField();
		Year_spinField.setBounds(162, 250, 49, 20);
		Year_spinField.setBackground(UIManager.getColor("Spinner.background"));
		Year_spinField.setForeground(UIManager.getColor("Spinner.foreground"));
		Year_spinField.getSpinner().setBackground(UIManager.getColor("TextField.background"));
		Year_spinField.getSpinner().setForeground(UIManager.getColor("TextField.foreground"));
		Year_spinField.setValue(Settings.Year);
		Year_spinField.setMinimum(0);
		panel.add(Year_spinField);

		JSpinField Month_spinField = new JSpinField();
		Month_spinField.setBounds(257, 250, 49, 20);

		Month_spinField.setBackground(UIManager.getColor("Spinner.background"));
		Month_spinField.setForeground(UIManager.getColor("Spinner.foreground"));
		Month_spinField.getSpinner().setBackground(UIManager.getColor("TextField.background"));
		Month_spinField.getSpinner().setForeground(UIManager.getColor("TextField.foreground"));
		Month_spinField.setValue(Settings.Month);
		Month_spinField.setMinimum(0);
		panel.add(Month_spinField);

		JSpinField Days_spinField = new JSpinField();
		Days_spinField.setBounds(361, 250, 49, 20);
		Days_spinField.setBackground(UIManager.getColor("Spinner.background"));
		Days_spinField.setForeground(UIManager.getColor("Spinner.foreground"));
		Days_spinField.getSpinner().setBackground(UIManager.getColor("TextField.background"));
		Days_spinField.getSpinner().setForeground(UIManager.getColor("TextField.foreground"));
		Days_spinField.setValue(Settings.Day);
		Days_spinField.setMinimum(0);
		Days_spinField.getValue();
		panel.add(Days_spinField);

		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_11.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton_11.setBounds(672, 101, 43, 34);
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Generate_menu.show(btnNewButton_11, 0, 0);

			}
		});
		Icon Key_Icon = new ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/key-3x.png"));
		btnNewButton_11.setIcon(Key_Icon);
		btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnNewButton_11);

		Rangemodel = new DefaultBoundedRangeModel();
		Rangemodel.setMaximum(100);
		Rangemodel.setMinimum(0);
		Rangemodel.setValue(0);

		JProgressBar progressBar = new JProgressBar(Rangemodel);
		progressBar.setBounds(104, 136, 489, 9);
		panel.add(progressBar);

		JButton ClipBoardBtn = new JButton("");
		ClipBoardBtn.setBackground(UIManager.getColor("Button.background"));
		ClipBoardBtn.setForeground(UIManager.getColor("Button.foreground"));
		ClipBoardBtn.setBounds(591, 101, 43, 34);
		ClipBoardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StringSelection stringSelection = new StringSelection(new String(passwordField.getPassword()));
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);

			}
		});
		Icon ClipIcon = new ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/clipboard-4x.png"));
		ClipBoardBtn.setIcon(ClipIcon);
		ClipBoardBtn.setToolTipText("Copy Password");
		panel.add(ClipBoardBtn);

		JButton Open_Browser_Btn = new JButton("");
		Open_Browser_Btn.setBackground(UIManager.getColor("Button.background"));
		Open_Browser_Btn.setForeground(UIManager.getColor("Button.foreground"));
		Open_Browser_Btn.setBounds(591, 146, 43, 34);
		Open_Browser_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Temp = URL_TextField.getText().toLowerCase();
				System.err.print(Temp);

				if (Temp != "" && (Temp.contains("www.") || Temp.contains("http://") || Temp.contains("https://"))) {

					System.err.print("Yaasssssssssss");
					try {

						Desktop.getDesktop().browse(new URI(Temp));

					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}

				}

			}
		});
		Icon Open_Browser = new ImageIcon(Edit_Password_Jdialog.class.getResource("/Icons/browser-4x.png"));
		Open_Browser_Btn.setIcon(Open_Browser);
		Open_Browser_Btn.setToolTipText("Open Link");
		panel.add(Open_Browser_Btn);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				temp = Data_Return(Year_spinField.getValue(), Month_spinField.getValue(), Days_spinField.getValue());

				TheJdialog_Answer.GetResponse(temp);
				setVisible(false);
				dispose();
			}
		});

		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TheJdialog_Answer.GetResponse(null);

				setVisible(false);
				dispose();

			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		GenerateJPopupMenu();
		Font_Handler.changeFont(contentPanel);
		Font_Handler.changeFont_Size(contentPanel);

		this.setModal(true);
		this.setVisible(true);
	}

	public Node_File Data_Return(int Year, int Month, int Days) {

		if (String.valueOf(passwordField.getPassword()) != null
				&& String.valueOf(passwordField.getPassword()) != "" & passwordField.getPassword().length != 0) {

			if (Title_TextField.getText().length() != 0) {

				Node_File test = new Node_File(Title_TextField.getText(), User_TextField.getText(),
						String.valueOf(passwordField.getPassword()), URL_TextField.getText(),
						Key_Word_TextField.getText(), Note_TextField.getText(), Year, Month, Days);

				return test;

			}

		}
		return null;

	}

	public void GenerateJPopupMenu() {

		Generate_menu.setBounds(0, 0, 75, 174);

		JRadioButton AlphaRadioButton = new JRadioButton("Use Alphabets : ");
		AlphaRadioButton.setToolTipText("a .... z & A .... Z ");
		AlphaRadioButton.setBounds(279, 25, 75, 23);
		Generate_menu.add(AlphaRadioButton);

		JRadioButton NumbRadioButton = new JRadioButton("Use Numbers : ");
		NumbRadioButton.setToolTipText("0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9");
		NumbRadioButton.setBounds(279, 25, 75, 23);
		Generate_menu.add(NumbRadioButton);

		JRadioButton SymbRadioButton = new JRadioButton("Use Symbols : ");
		SymbRadioButton.setToolTipText("Symbols :\r\n(&\u00E9\"'(-)=~#{[|`\\^@]}*)");
		SymbRadioButton.setBounds(279, 25, 75, 23);
		Generate_menu.add(SymbRadioButton);

		JRadioButton UnSymbRadioButton = new JRadioButton("Use unique Symbols : ");
		UnSymbRadioButton.setToolTipText("Extended Symbols : \r\n(Extended Ascii Table)\r\n(\u00A9,\u00B6,\u00A5...)");
		UnSymbRadioButton.setBounds(279, 25, 75, 23);
		Generate_menu.add(UnSymbRadioButton);

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
		slider.setMaximum(256);
		slider.setMinimum(0);
		slider.setBounds(191, 11, 75, 19);
		slider.setValue(0);
		Generate_menu.add(slider);

		JButton Generate_Button = new JButton("Generate Password");
		Generate_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (AlphaRadioButton.isSelected() || NumbRadioButton.isSelected() || SymbRadioButton.isSelected()) {

					int alp = AlphaRadioButton.isSelected() ? 1 : 0;
					int num = NumbRadioButton.isSelected() ? 1 : 0;
					int sym = SymbRadioButton.isSelected() ? 1 : 0;
					int ex = UnSymbRadioButton.isSelected() ? 1 : 0;

					if (slider.getValue() != 0) {

						String Holder = Generate_Password.RemoteGeneratePassword(slider.getValue(), alp, num, sym, ex);

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
