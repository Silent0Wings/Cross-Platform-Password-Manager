package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Package.Font_Handler;
import Package.Gui_Interface;
import Package.Node_Container;
import Package.Stats;

import javax.swing.JProgressBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;

public class Data_Base_Creation_Jdialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Min_Letters = 5;
	private int Min_Numbers = 2;
	private int Min_Symboles = 1;
	private int Password_Strength = 41;
	private final JPanel contentPanel = new JPanel();
	private JTextField Name_Field;
	private JPasswordField passwordField;
	public Stats Current_Stats;
	private DefaultBoundedRangeModel model;
	private boolean Show_Password;
	private JLabel Pass_Strenght_Label;

	private JLabel Numbers_Label;
	private JLabel Letters_Label;
	private JLabel Symboles_Label;

	private JLabel Strength_Label;
	private JLabel lblPasswordRefused;

	public interface Jdialog_Data_Base {

		void GetResponse(Node_Container Temp_Node_Container);

	}

	/**
	 * Create the dialog.
	 */
	public Data_Base_Creation_Jdialog(Jdialog_Data_Base This_Jdialog_Data_Base) {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("New File");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 699, 364);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		contentPanel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setForeground(UIManager.getColor("Panel.foreground"));
			panel.setBackground(UIManager.getColor("Panel.background"));
			panel.setBounds(10, 11, 727, 283);
			contentPanel.add(panel);
			panel.setLayout(null);

			Strength_Label = new JLabel("0");
			Strength_Label.setBackground(UIManager.getColor("List.background"));
			Strength_Label.setForeground(UIManager.getColor("Label.foreground"));
			Strength_Label.setBounds(69, 128, 179, 34);
			panel.add(Strength_Label);
			{
				JLabel Title_Label = new JLabel("Name :");
				Title_Label.setForeground(UIManager.getColor("Label.foreground"));
				Title_Label.setBounds(10, 11, 73, 34);
				panel.add(Title_Label);

				model = new DefaultBoundedRangeModel();
				model.setMaximum(100);
				model.setMinimum(0);
				JProgressBar progressBar = new JProgressBar(model);
				progressBar.setForeground(UIManager.getColor("ProgressBar.foreground"));
				progressBar.setBackground(UIManager.getColor("ProgressBar.background"));
				progressBar.setToolTipText("");
				progressBar.setBounds(93, 128, 489, 34);
				panel.add(progressBar);
				model.setValue(0);

			}
			{
				Name_Field = new JTextField();
				Name_Field.requestFocus();
				Name_Field.setHorizontalAlignment(SwingConstants.LEFT);
				Name_Field.setForeground(UIManager.getColor("TextField.foreground"));
				Name_Field.setColumns(10);
				Name_Field.setBackground(UIManager.getColor("TextField.background"));
				Name_Field.setBounds(93, 11, 489, 34);
				panel.add(Name_Field);
			}
			{
				JLabel Password_Label = new JLabel("PassWord :");
				Password_Label.setForeground(UIManager.getColor("Label.foreground"));
				Password_Label.setBounds(10, 69, 73, 34);
				panel.add(Password_Label);
			}
			{
				JButton btnNewButton_1 = new JButton("");
				btnNewButton_1.setForeground(UIManager.getColor("Button.foreground"));
				btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
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
				Icon Toggle_View_Icon = new ImageIcon(Gui_Interface.class.getResource("/Icons/eye-3x.png"));
				btnNewButton_1.setIcon(Toggle_View_Icon);
				btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnNewButton_1.setBounds(582, 69, 48, 34);
				panel.add(btnNewButton_1);
			}
			{

				passwordField = new JPasswordField();
				passwordField.setEchoChar('\u25cf');
				passwordField.setHorizontalAlignment(SwingConstants.LEFT);
				passwordField.enableInputMethods(true);
				passwordField.addKeyListener(new KeyAdapter() {

					@Override
					public void keyReleased(KeyEvent e) {

						String Value = new String(passwordField.getPassword());

						// System.out.println(Arrays.toString(passwordField.getPassword()));

						// Value = Value.replaceAll("[^\\p{ASCII}]", "");

						// this line says replace all characters that are not whiting 0 to 255 in hex is
						// 00 => FF
						int temp = passwordField.getCaretPosition();

						Value = Value.replaceAll("[^\\x00-\\xFF]", "");

						passwordField.setText(Value);
						passwordField.setCaretPosition(temp);

						Password_Strength();

					}

				});
				passwordField.setForeground(UIManager.getColor("TextField.foreground"));
				passwordField.setBackground(UIManager.getColor("TextField.background"));
				passwordField.setBounds(93, 69, 489, 34);
				passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));

				panel.add(passwordField);
			}

			JLabel lblNewLabel = new JLabel("Please Enter A Password Whit 8 letters 3 numbers and 3 symboles");
			lblNewLabel.setForeground(UIManager.getColor("Label.foreground"));
			lblNewLabel.setBounds(93, 173, 355, 34);
			panel.add(lblNewLabel);
			{
				Pass_Strenght_Label = new JLabel("Very Weak");
				Pass_Strenght_Label.setForeground(UIManager.getColor("Label.foreground"));
				Pass_Strenght_Label.setBounds(592, 128, 89, 34);
				panel.add(Pass_Strenght_Label);
			}

			JPanel panel_1 = new JPanel();
			panel_1.setBackground(UIManager.getColor("Button.background"));
			panel_1.setBounds(507, 184, 156, 88);
			panel.add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel_1 = new JLabel("Letters     :");
			lblNewLabel_1.setForeground(UIManager.getColor("Label.foreground"));
			lblNewLabel_1.setBounds(10, 11, 79, 22);
			panel_1.add(lblNewLabel_1);

			JLabel lblNewLabel_1_1 = new JLabel("Numbers  :");
			lblNewLabel_1_1.setForeground(UIManager.getColor("Label.foreground"));
			lblNewLabel_1_1.setBounds(10, 33, 79, 22);
			panel_1.add(lblNewLabel_1_1);

			JLabel lblNewLabel_1_1_1 = new JLabel("Symboles :");
			lblNewLabel_1_1_1.setForeground(UIManager.getColor("Label.foreground"));
			lblNewLabel_1_1_1.setBounds(10, 55, 79, 22);
			panel_1.add(lblNewLabel_1_1_1);

			Numbers_Label = new JLabel("0");
			Numbers_Label.setForeground(UIManager.getColor("Label.foreground"));
			Numbers_Label.setBounds(117, 33, 33, 22);
			panel_1.add(Numbers_Label);

			Letters_Label = new JLabel("0");
			Letters_Label.setForeground(UIManager.getColor("Label.foreground"));
			Letters_Label.setBounds(117, 11, 33, 22);
			panel_1.add(Letters_Label);

			Symboles_Label = new JLabel("0");
			Symboles_Label.setForeground(UIManager.getColor("Label.foreground"));
			Symboles_Label.setBounds(117, 55, 33, 22);
			panel_1.add(Symboles_Label);

			lblPasswordRefused = new JLabel("Password Refused");
			lblPasswordRefused.setForeground(UIManager.getColor("Label.foreground"));
			lblPasswordRefused.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblPasswordRefused.setBounds(93, 209, 355, 34);
			panel.add(lblPasswordRefused);

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Construct(This_Jdialog_Data_Base);

					}
				});

				okButton.setActionCommand("OK");
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
				buttonPane.add(cancelButton);
			}

			// Load_Data(Main_File);
		}
		Font_Handler.changeFont(contentPanel);
		Font_Handler.changeFont_Size(contentPanel);
		this.setModal(true);
		this.setVisible(true);
	}

	private void Construct(Jdialog_Data_Base This_Jdialog_Data_Base) {

		String Value = new String(passwordField.getPassword());

		int Strength = Password_Strength();

		char[] Digi = Retrieve_Digits(Value);
		char[] Alpha = Retrieve_Alphabets(Value);
		char[] Symb = Retrieve_Symboles(Value);

		if (Digi.length >= Min_Numbers && Symb.length >= Min_Symboles && Alpha.length >= Min_Letters
				&& Strength >= Password_Strength && Name_Field.getText() != "" && Name_Field.getText().length() != 0) {

			Value = Value.replaceAll("[^\\x00-\\xFF]", "");

			Node_Container This_Node_Container = new Node_Container(Value);

			This_Node_Container.Main_Name = Name_Field.getText();
			This_Jdialog_Data_Base.GetResponse(This_Node_Container);

			setVisible(false);
			dispose();

		} else {

			if (Alpha.length < Min_Letters) {

			}

			if (Digi.length < Min_Numbers) {

			}

			if (Symb.length < Min_Symboles) {

			}
		}

	}

	private final static char[] Retrieve_Digits(String Source) {

		Source = Source.replaceAll("[^0-9.]", "");

		if (Source.length() == 0) {
			return new char[0];

		} else {

			return Source.toCharArray();
		}
	}

	private final static char[] Retrieve_Alphabets(String Source) {

		Source = Source.replaceAll("[^a-zA-Z]", "");

		if (Source.length() != 0) {

			return Source.toCharArray();
		} else {

			return new char[0];
		}

	}

	private final static char[] Retrieve_Symboles(String Source) {

		Source = Source.replaceAll("[A-Za-z0-9]", "");

		if (Source.length() != 0) {

			return Source.toCharArray();
		} else {
			return new char[0];
		}

	}

	private int Password_Strength() {

		String Value = new String(passwordField.getPassword());

		char[] Alpha = Retrieve_Alphabets(Value);
		char[] Digi = Retrieve_Digits(Value);
		char[] Symb = Retrieve_Symboles(Value);

		Letters_Label.setText(Alpha.length + "");
		Numbers_Label.setText(Digi.length + "");
		Symboles_Label.setText(Symb.length + "");

		if (Alpha.length < Min_Letters) {
			Letters_Label.setForeground(Color.red);
		} else {
			Letters_Label.setForeground(Color.GREEN);

		}

		if (Digi.length < Min_Numbers) {
			Numbers_Label.setForeground(Color.red);
		} else {
			Numbers_Label.setForeground(Color.GREEN);

		}

		if (Symb.length < Min_Symboles) {
			Symboles_Label.setForeground(Color.red);
		} else {
			Symboles_Label.setForeground(Color.GREEN);

		}

		if (Digi.length >= Min_Numbers && Symb.length >= Min_Symboles && Alpha.length >= Min_Letters) {

			lblPasswordRefused.setText("Password Accepted");
		} else {
			lblPasswordRefused.setText("Password Refused");

		}

		float Max = 6;

		// System.out.println(Arrays.toString(Symb));
		// float Perc = ((Alpha.length + Digi.length * 2 + Symb.length * 3) / (float)
		// Max) * 100;

		// System.out.println(Alpha.length + " " + Digi.length + " " + Symb.length);

		float Perc = (((Alpha.length * 2 + Digi.length * 4 + Symb.length * 6) / (float) (2 + 4 + 6)) / Max) * 100;

		model.setValue((int) Perc);

		Strength_Label.setText(model.getValue() + "");

		if (Perc <= 16) {
			Pass_Strenght_Label.setText("Very Weak");

		} else if (Perc <= 30) {

			Pass_Strenght_Label.setText("Weak");
		} else if (Perc <= 50) {

			Pass_Strenght_Label.setText("Normal");
		} else if (Perc < 70 && Perc > 51) {

			Pass_Strenght_Label.setText("Strong");
		} else if (Perc > 90) {

			Pass_Strenght_Label.setText("Very Strong");
		}

		// System.out.println(Perc);

		return (int) Perc;
	}

}
