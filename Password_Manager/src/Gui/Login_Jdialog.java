package Gui;

import java.awt.BorderLayout;
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
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Package.Font_Handler;
import Package.Gui_Interface;
import Package.Stats;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Login_Jdialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	public Stats Current_Stats;
	private DefaultBoundedRangeModel model;
	private boolean Show_Password;

	public interface Jdialog_Login {

		void GetResponse(String Temp_Node_Container);

	}

	/**
	 * Create the dialog.
	 */
	public Login_Jdialog(Jdialog_Login This_Jdialog_Login, String A_Name) {
		setAlwaysOnTop(true);
		setTitle("Login");
		setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 696, 222);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Panel.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(UIManager.getColor("menu"));
			panel.setBounds(10, 11, 662, 112);
			contentPanel.add(panel);
			panel.setLayout(null);
			{

				model = new DefaultBoundedRangeModel();
				model.setMaximum(100);
				model.setMinimum(0);
				model.setValue(0);

			}
			{
				JLabel Password_Label = new JLabel("Mot de passe :");
				Password_Label.setForeground(UIManager.getColor("Label.foreground"));
				Password_Label.setBounds(5, 54, 102, 34);
				panel.add(Password_Label);
			}
			{
				JButton Toggle_View = new JButton("");
				Toggle_View.setForeground(UIManager.getColor("Button.foreground"));
				Toggle_View.setBackground(UIManager.getColor("Button.background"));
				Toggle_View.addActionListener(new ActionListener() {
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

				Toggle_View.setFont(new Font("Tahoma", Font.PLAIN, 15));
				Icon Toggle_View_Icon = new ImageIcon(Gui_Interface.class.getResource("/Icons/eye-3x.png"));
				Toggle_View.setIcon(Toggle_View_Icon);
				Toggle_View.setBounds(604, 54, 48, 34);
				panel.add(Toggle_View);
			}
			{

				passwordField = new JPasswordField();
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

					}

				});
				passwordField.setForeground(UIManager.getColor("PasswordField.foreground"));
				passwordField.setBackground(UIManager.getColor("PasswordField.background"));
				passwordField.setBounds(105, 54, 500, 34);
				passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));

				panel.add(passwordField);
			}

			JLabel lblName = new JLabel(A_Name);
			lblName.setForeground(UIManager.getColor("Label.foreground"));
			lblName.setBounds(0, 0, 662, 34);
			panel.add(lblName);
			lblName.setFont(new Font("Tahoma", Font.BOLD, 20));

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (passwordField.getPassword().length >= 8) {

							This_Jdialog_Login.GetResponse(new String(passwordField.getPassword()));

							setVisible(false);
							dispose();
						}

					}
				});

				okButton.setActionCommand("OK");
				Icon homeico = new ImageIcon(Gui_Interface.class.getResource("/Icons/account-login-4x.png"));
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
				Icon Deleico = new ImageIcon(Gui_Interface.class.getResource("/Icons/circle-x-4x.png"));
				cancelButton.setIcon(Deleico);
				buttonPane.add(cancelButton);
			}

			// Font Resize

			// Load_Data(Main_File);
		}
		Font_Handler.changeFont(contentPanel);
		Font_Handler.changeFont_Size(contentPanel);
		this.setModal(true);
		this.setVisible(true);
	}

}
