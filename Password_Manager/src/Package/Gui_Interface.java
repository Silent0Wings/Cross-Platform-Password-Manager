package Package;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.IntelliJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCobalt2IJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatHiberbeeDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMonocaiIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedDarkContrastIJTheme;

import Gui.CustomTreeCellRenderer;
import Gui.Custom_Data_Base_Creation_Jdialog;
import Gui.Custom_Default_List_Cell_Renderer;
import Gui.Custom_Login_Jdialog;
import Gui.Data_Base_Creation_Jdialog;
import Gui.Login_Jdialog;
import Gui.New_Password_Jdialog;
import Gui.PassWord_Data_Base_Creation_Jdialog;
import Gui.View_Password_Jdialog;
import Gui.Custom_Data_Base_Creation_Jdialog.Custom_Jdialog_Data_Base;
import Gui.Custom_Login_Jdialog.Custom_Jdialog_Login;
import Gui.Data_Base_Creation_Jdialog.Jdialog_Data_Base;
import Gui.Login_Jdialog.Jdialog_Login;
import Gui.New_Password_Jdialog.Jdialog_Answer;
import Package.Settings.Search;
import Package.Settings.Sort;
import Package.Settings.Sort_Type;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;
import javax.swing.ButtonGroup;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollBar;
import javax.swing.BoundedRangeModel;
import javax.swing.SpringLayout;
import java.awt.SystemColor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

///To DO 

// Major erros when using alpha shufle !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//Critical Error Avoid Encrypting then using aes256 most come first then encrypt ||| Not sure anymore turns out the error was caused by importing a unique character from a csv file

@SuppressWarnings("unused")
public class Gui_Interface {

	private JFrame frmHarpocrates;

	private JTextField Link_TextField;
	private JTextField Data_Name_textfield;
	private JTextField Terminal_Input;

	private JSpinner Year_spinField;
	private JSpinner Month_spinField;
	private JSpinner Days_spinField;
	private JCheckBox Auto_Save_Path_CheckBox;
	private JCheckBox Auto_Load_File_CheckBox;
	private JScrollPane Table_Scroll;

	private JRadioButton Ascending_Order_JradioBtn;
	private JRadioButton Descending_Order_JradioBtn;
	private final ButtonGroup SortButtonGroup = new ButtonGroup();
	private final ButtonGroup SearchButtonGroup = new ButtonGroup();

	final JPopupMenu Folder_menu = new JPopupMenu("Folder Menu");
	final JPopupMenu File_menu = new JPopupMenu("File Menu");

	private JList<String> Favorit_Location_List;
	private DefaultListModel<String> Favorit_Location_List_Model;
	private final JPopupMenu Search_Option_Menu = new JPopupMenu("Search Option");
	public JComboBox<String> Sorting_Box;
	public JComboBox<String> Type_Box;

	// _________________Used For Copy & Paste_____________________________________

	private Node_Structure Copied_Folder;
	private Node_File Copied_File;

	// _________________Used For Selection________________________________________

	private Node_Container Imported_Container;
	private Node_Container Exported_Container;
	private Node_Structure Current_Selection;
	private Node_File Current_Selection_file;
	private Tree_Table Current_Tree_Table;
	private static Icon_Resources Icon_Ref;
	private Stats Current_Stats;
	private File Current_File;
	private String New_PassWord = "";

	private boolean Search_Mode = false;

	// ___________________________________________________________________________________

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					UIManager.setLookAndFeel(new FlatDarculaLaf());
//					UIManager.setLookAndFeel(new FlatIntelliJLaf());
//					UIManager.setLookAndFeel(new FlatDarkLaf());

					Icon_Ref = new Icon_Resources();

					Load_Save.Load_Theme();
					Load_Save.Load_Settings();

					GetLookFeel(Settings.Theme);

					Gui_Interface window = new Gui_Interface();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private Gui_Interface() {
		Current_Stats = new Stats();
		Current_Tree_Table = new Tree_Table();
		initialize();

		if (Auto_Load_File_CheckBox.isSelected()) {

			if (Favorit_Location_List_Model.getSize() > 0) {

				if (frmHarpocrates != null) {
					Auto_Load();

					Font_Handler.changeFont(frmHarpocrates);
					System.out.println(Settings.Font_Size);
					Font_Handler.changeFont_Size(frmHarpocrates);
				}
			}
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHarpocrates = new JFrame();
		frmHarpocrates.setResizable(false);
		frmHarpocrates.setFont(new Font("Arial", Font.BOLD, 25));
		frmHarpocrates.setTitle("Harpocrates");
		frmHarpocrates.getContentPane().setBackground(UIManager.getColor("window"));
		frmHarpocrates.setBounds(100, 100, 938, 650);
		frmHarpocrates.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image HarpocratesIco = Toolkit.getDefaultToolkit()
				.getImage(Gui_Interface.class.getResource("/Icons/Harpocrates 1.png"));
		frmHarpocrates.setIconImage(HarpocratesIco);
		frmHarpocrates.getContentPane().setLayout(null);
		frmHarpocrates.requestFocusInWindow();

		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(0, 576, 924, 15);
		progressBar_1.setForeground(UIManager.getColor("ProgressBar.foreground"));
		progressBar_1.setBackground(UIManager.getColor("ProgressBar.background"));
		progressBar_1.setStringPainted(true);
		frmHarpocrates.getContentPane().add(progressBar_1);
		progressBar_1.setVisible(false);
		Settings.MainprogressBar = progressBar_1;

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(10, 24, 904, 557);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmHarpocrates.getContentPane().add(tabbedPane);

		JPanel Explorer_Panel = new JPanel();
		Explorer_Panel.setForeground(UIManager.getColor("Panel.foreground"));

		tabbedPane.addTab("Explorer", Settings.Icon_Ref.Home_32, Explorer_Panel, null);
		Explorer_Panel.setBackground(UIManager.getColor("Panel.background"));
		Explorer_Panel.setLayout(null);

		Table_Scroll = new JScrollPane();
		Table_Scroll.setBounds(400, 34, 377, 473);
		Explorer_Panel.add(Table_Scroll);

		Table_Scroll.setViewportView(Current_Tree_Table.Table);

		Current_Tree_Table.Table.setBorder(null);
		// Current_Tree_Table.Table.setBorder(BorderFactory.createEmptyBorder());
//		Current_Tree_Table.Table.setShowGrid(true);
//		Current_Tree_Table.Table.setGridColor(Color.red);

		Current_Tree_Table.Table.setFillsViewportHeight(true);
		Current_Tree_Table.Table.setForeground(UIManager.getColor("TextArea.foreground"));
		Current_Tree_Table.Table.setBackground(UIManager.getColor("TextArea.background"));
		Current_Tree_Table.Table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (Current_Tree_Table.Table.getRowCount() + Current_Tree_Table.Table.getColumnCount() != 0) {

					if (Current_Tree_Table.Table.getSelectedColumn() != -1
							&& Current_Tree_Table.Table.getSelectedRow() != -1) {

						Object temptemp = Current_Tree_Table.Table.getModel().getValueAt(
								Current_Tree_Table.Table.getSelectedRow(),
								Current_Tree_Table.Table.getSelectedColumn());

						if (temptemp != null) {

							if (Settings.Locked) {

								if (temptemp instanceof Node_File) {

									Node_File temp = (Node_File) Current_Tree_Table.Table.getModel().getValueAt(
											Current_Tree_Table.Table.getSelectedRow(),
											Current_Tree_Table.Table.getSelectedColumn());
									if (temp != null) {

										Current_Selection_file = temp;
										Current_Selection = null;

										Link_TextField.setText("Favorite Root/" + temp.getName());

									}

								}

							} else {

								if (temptemp instanceof Node_Structure) {
									Node_Structure temp = (Node_Structure) Current_Tree_Table.Table.getModel()
											.getValueAt(Current_Tree_Table.Table.getSelectedRow(),
													Current_Tree_Table.Table.getSelectedColumn());
									if (temp != null) {

										Current_Selection = temp;
										Current_Selection_file = null;

										// System.err.println(Current_Selection.Get_Name());
										Link_TextField.setText(temp.Get_Link());
									}

								} else if (temptemp instanceof Node_File) {

									Node_File temp = (Node_File) Current_Tree_Table.Table.getModel().getValueAt(
											Current_Tree_Table.Table.getSelectedRow(),
											Current_Tree_Table.Table.getSelectedColumn());
									if (temp != null) {

										Current_Selection = null;
										Current_Selection_file = temp;

										// System.err.println(Current_Selection_file.getName());
										Link_TextField.setText(
												Current_Selection_file.Get_Parent().Get_Link() + temp.getName());

									}

								}

							}

						}

					}

				}

			}
		});
		Current_Tree_Table.Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Current_Tree_Table.Table.setCellSelectionEnabled(true);
		Current_Tree_Table.Table.setTableHeader(null);
		// Current_Tree_Table.Table.getTableHeader().setReorderingAllowed(false);

		JScrollPane Tree_Scroll = new JScrollPane();
		Tree_Scroll.setBounds(10, 34, 377, 473);
		Explorer_Panel.add(Tree_Scroll);

		Current_Tree_Table.Tree.setBorder(null);
		ToolTipManager.sharedInstance().registerComponent(Current_Tree_Table.Tree);
		Current_Tree_Table.Tree.setModel(new DefaultTreeModel(null));
		Current_Tree_Table.Tree.setShowsRootHandles(true);
		Current_Tree_Table.Tree.setForeground(UIManager.getColor("Tree.foreground"));
		Current_Tree_Table.Tree.setBackground(UIManager.getColor("Tree.background"));
		Current_Tree_Table.Tree.setScrollsOnExpand(true);
		Current_Tree_Table.Tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		Current_Tree_Table.Tree.setCellRenderer(new CustomTreeCellRenderer());
		Current_Tree_Table.Tree.addTreeSelectionListener(new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent e) {

				TreePath te = e.getNewLeadSelectionPath();

				if (Settings.Locked) {

					if (te != null) {

						Object[] dd = te.getPath();

						DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getNewLeadSelectionPath()
								.getLastPathComponent();

						if (node != null) {

							if (node.getUserObject() instanceof Node_File) {

								Node_File The_Node_File = (Node_File) node.getUserObject();

								if (The_Node_File != null) {

									Current_Selection_file = The_Node_File;
									Current_Selection = null;

									Link_TextField.setText("Favorite Root/" + The_Node_File.getName());
								}

							}
						}

					}

				} else {

					if (te != null) {

						Object[] dd = te.getPath();

						DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getNewLeadSelectionPath()
								.getLastPathComponent();

						if (node != null) {

							if (node.getUserObject() instanceof Node_File) {
								// system.out.println(Arrays.toString(dd));

								// System.err.println("Test : " + node.getUserObject());

								// Node_Structure Temp = New_Countainer.Traverse(dd);

								Node_File The_Node_File = (Node_File) node.getUserObject();

								if (The_Node_File != null) {

									Current_Selection = null;
									Current_Selection_file = The_Node_File;

									// System.err.println(The_Node_File);

									// system.out.println("Name : " + The_Node_File.getName());

									// system.out.println("Key() : " + dd[dd.length - 1]);

									Link_TextField
											.setText(The_Node_File.Get_Parent().Get_Link() + The_Node_File.getName());

								}

							} else if (node.getUserObject() instanceof Node_Structure) {
								// system.out.println(Arrays.toString(dd));

								Node_Structure Temp = (Node_Structure) node.getUserObject();// New_Countainer.Traverse(dd);
								if (Temp != null) {
									Current_Selection = Temp;
									Current_Selection_file = null;
									// system.out.println("ans " + Temp.Get_Name() + " ");
									Link_TextField.setText(Temp.Get_Link());

								}

							}
						}

					}
				}

				Current_Tree_Table.Handle_Table_Builder(Current_Selection);

			}
		});
		Tree_Scroll.setViewportView(Current_Tree_Table.Tree);

		Link_TextField = new JTextField();
		Link_TextField.setBounds(10, 514, 767, 30);
		Link_TextField.setEditable(false);
		Link_TextField.setForeground(UIManager.getColor("TextArea.foreground"));
		Link_TextField.setBackground(UIManager.getColor("TextArea.background"));
		Explorer_Panel.add(Link_TextField);
		Link_TextField.setColumns(10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(787, 1, 2, 544);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		Explorer_Panel.add(separator_2);

		Ascending_Order_JradioBtn = new JRadioButton("Ascending");
		Ascending_Order_JradioBtn.setBounds(10, 1, 92, 30);
		Ascending_Order_JradioBtn.setBackground(UIManager.getColor("RadioButton.background"));
		Ascending_Order_JradioBtn.setForeground(UIManager.getColor("RadioButton.foreground"));
		Ascending_Order_JradioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Current_Tree_Table != null) {

					Settings.Sort_Order = 0;
					Current_Tree_Table.Handle_Tree_Table(Current_Selection);
				}
			}
		});
		Ascending_Order_JradioBtn.setSelected(true);
		SortButtonGroup.add(Ascending_Order_JradioBtn);
		Ascending_Order_JradioBtn.setToolTipText("ascending order.");
		Explorer_Panel.add(Ascending_Order_JradioBtn);

		Descending_Order_JradioBtn = new JRadioButton("Descending");
		Descending_Order_JradioBtn.setBounds(108, 1, 104, 30);
		Descending_Order_JradioBtn.setBackground(UIManager.getColor("RadioButton.background"));
		Descending_Order_JradioBtn.setForeground(UIManager.getColor("RadioButton.foreground"));
		Descending_Order_JradioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Current_Tree_Table != null) {

					Settings.Sort_Order = 1;
					Current_Tree_Table.Handle_Tree_Table(Current_Selection);
				}
			}
		});
		SortButtonGroup.add(Descending_Order_JradioBtn);
		Descending_Order_JradioBtn.setToolTipText("descending order.");
		Explorer_Panel.add(Descending_Order_JradioBtn);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(395, 34, 9, 473);
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		Explorer_Panel.add(separator_2_1);

		JTextField Search_Jtext = new JTextField();
		Search_Jtext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Settings.Search_Input = Search_Jtext.getText();
			}
		});
		Search_Jtext.setBounds(592, 1, 96, 30);

		Explorer_Panel.add(Search_Jtext);
		Search_Jtext.setColumns(10);

		JButton Search_Btn = new JButton("Search");
		Search_Btn.setBounds(688, 1, 89, 30);
		Search_Btn.setBackground(UIManager.getColor("Button.background"));
		Search_Btn.setForeground(UIManager.getColor("Button.foreground"));
		Search_Btn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Search_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Current_Tree_Table != null && Search_Jtext.getText().length() != 0) {

					Type_Box.setSelectedItem("Search");
					Current_Tree_Table.Handle_Tree_Table(Current_Selection);
				}
			}
		});
		Explorer_Panel.add(Search_Btn);

		Sorting_Box = new JComboBox<String>();
		Sorting_Box.setBounds(218, 1, 134, 30);
		Sorting_Box.setForeground(UIManager.getColor("ComboBox.foreground"));
		Sorting_Box.setBackground(UIManager.getColor("ComboBox.background"));
		Sorting_Box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Current_Tree_Table != null) {

					Settings.sort = Sort.valueOf(Sorting_Box.getSelectedItem().toString());
					Current_Tree_Table.Handle_Tree_Table(Current_Selection);
					Current_Tree_Table.Update_Boxes();
				}

			}
		});

		// Build Array from enum
		Sort[] courses_Sort = Sort.values();
		String[] Sorting_Box_Array = new String[courses_Sort.length];
		for (int i = 0; i < courses_Sort.length; i++) {
			Sorting_Box_Array[i] = courses_Sort[i].name();
		}
		Sorting_Box.setModel(new DefaultComboBoxModel<String>(Sorting_Box_Array));
		Explorer_Panel.add(Sorting_Box);

		Type_Box = new JComboBox<String>();
		Type_Box.setBounds(355, 1, 117, 30);
		Type_Box.setForeground(UIManager.getColor("ComboBox.foreground"));
		Type_Box.setBackground(UIManager.getColor("ComboBox.background"));
		Type_Box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Current_Tree_Table != null) {

					Settings.type = Sort_Type.valueOf(Type_Box.getSelectedItem().toString());
					Current_Tree_Table.Handle_Tree_Table(Current_Selection);
					Current_Tree_Table.Update_Boxes();
					if (Settings.type == Settings.Sort_Type.Default) {
						Settings.Locked = false;
					} else {
						Settings.Locked = true;

					}

				}

			}
		});

		// Build Array from enum
		Sort_Type[] courses_Type = Sort_Type.values();
		String[] Type_Box_Array = new String[courses_Type.length];
		for (int i = 0; i < courses_Type.length; i++) {
			Type_Box_Array[i] = courses_Type[i].name();
		}
		Type_Box.setModel(new DefaultComboBoxModel<String>(Type_Box_Array));
		Explorer_Panel.add(Type_Box);

		Current_Tree_Table.Type_Box = Type_Box;
		Current_Tree_Table.Sorting_Box = Sorting_Box;

		JButton Search_Options_Btn = new JButton("Options");
		Search_Options_Btn.setBounds(490, 1, 104, 30);
		Search_Options_Btn.setBackground(UIManager.getColor("Button.background"));
		Search_Options_Btn.setForeground(UIManager.getColor("Button.foreground"));
		Search_Options_Btn.setToolTipText("Search Options");
		Search_Options_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Search_Option_Menu.show(Search_Options_Btn, 0, 0);

			}
		});
		Explorer_Panel.add(Search_Options_Btn);

		if (Load_Save.Load_Favorite_DataBase() == null) {
			Favorit_Location_List_Model = new DefaultListModel<String>();

		} else {
			Favorit_Location_List_Model = Load_Save.Load_Favorite_DataBase();

		}

		JPanel Terminal_Panel = new JPanel();
		Terminal_Panel.setForeground(UIManager.getColor("Panel.foreground"));
		Terminal_Panel.setBackground(UIManager.getColor("Panel.background"));

		JPanel Password_Panel = new JPanel();
		Password_Panel.setBackground(UIManager.getColor("Panel.background"));
		Password_Panel.setForeground(UIManager.getColor("Panel.foreground"));
		tabbedPane.addTab("Generator", Icon_Ref.Key_32, Password_Panel, null);
		Password_Panel.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("0");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(365, 160, 49, 30);
		Password_Panel.add(lblNewLabel_5);

		JCheckBox Alpha_CheckBox_1 = new JCheckBox("Alphabetic LowerCase :");
		Alpha_CheckBox_1.setBounds(6, 187, 172, 30);
		Alpha_CheckBox_1.setBackground(UIManager.getColor("CheckBox.background"));
		Alpha_CheckBox_1.setForeground(UIManager.getColor("CheckBox.foreground"));
		Alpha_CheckBox_1.setToolTipText("Latin alphabet:\r\nletters from a to z\r\nand A to Z .");
		Alpha_CheckBox_1.setSelected(true);
		Password_Panel.add(Alpha_CheckBox_1);

		JCheckBox Alpha_CheckBox_1_1 = new JCheckBox("Alphabetic Upper Case");
		Alpha_CheckBox_1_1.setToolTipText("Latin alphabet:\r\nletters from a to z\r\nand A to Z .");
		Alpha_CheckBox_1_1.setSelected(true);
		Alpha_CheckBox_1_1.setForeground(UIManager.getColor("CheckBox.foreground"));
		Alpha_CheckBox_1_1.setBackground(UIManager.getColor("CheckBox.background"));
		Alpha_CheckBox_1_1.setBounds(6, 220, 172, 30);
		Password_Panel.add(Alpha_CheckBox_1_1);

		JCheckBox Num_CheckBox_1 = new JCheckBox("Numerical");
		Num_CheckBox_1.setBounds(6, 253, 172, 30);
		Num_CheckBox_1.setBackground(UIManager.getColor("CheckBox.background"));
		Num_CheckBox_1.setForeground(UIManager.getColor("CheckBox.foreground"));
		Num_CheckBox_1.setToolTipText("Numbers :\r\nfrom 0 to 9 .");
		Num_CheckBox_1.setSelected(false);
		Password_Panel.add(Num_CheckBox_1);

		JCheckBox Sym_CheckBox_1 = new JCheckBox("Symbols");
		Sym_CheckBox_1.setBounds(6, 286, 172, 30);
		Sym_CheckBox_1.setBackground(UIManager.getColor("CheckBox.background"));
		Sym_CheckBox_1.setForeground(UIManager.getColor("CheckBox.foreground"));
		Sym_CheckBox_1.setToolTipText("Symbols :\r\n(&\u00E9\"'(-)=~#{[|`\\^@]}*)");
		Sym_CheckBox_1.setSelected(false);
		Password_Panel.add(Sym_CheckBox_1);

		JCheckBox Exten_CheckBox_1 = new JCheckBox("Extended Symbols");
		Exten_CheckBox_1.setBounds(6, 319, 172, 30);
		Exten_CheckBox_1.setBackground(UIManager.getColor("CheckBox.background"));
		Exten_CheckBox_1.setForeground(UIManager.getColor("CheckBox.foreground"));
		Exten_CheckBox_1.setToolTipText("Extended Symbols : \r\n(Extended Ascii Table)\r\n(\u00A9,\u00B6,\u00A5...)");
		Exten_CheckBox_1.setSelected(false);
		Password_Panel.add(Exten_CheckBox_1);

		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				lblNewLabel_5.setText(slider.getValue() + "");
			}
		});
		slider.setBounds(6, 155, 773, 19);
		slider.setBackground(UIManager.getColor("Slider.background"));
		slider.setForeground(UIManager.getColor("Slider.foreground"));
		slider.setValue(10);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMaximum(256);
		slider.setMinimum(1);
		Password_Panel.add(slider);

		JLabel lblNewLabel_2 = new JLabel("Excluded");
		lblNewLabel_2.setForeground(UIManager.getColor("Label.foreground"));
		lblNewLabel_2.setBackground(UIManager.getColor("Label.background"));
		lblNewLabel_2.setBounds(6, 356, 89, 23);
		Password_Panel.add(lblNewLabel_2);

		JTextField textField_1 = new JTextField();
		textField_1.setBackground(UIManager.getColor("TextField.background"));
		textField_1.setForeground(UIManager.getColor("TextField.foreground"));
		textField_1.setBounds(6, 380, 172, 30);
		textField_1.setColumns(10);
		Password_Panel.add(textField_1);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 76, 769, 30);
		progressBar.setForeground(UIManager.getColor("ProgressBar.foreground"));
		progressBar.setBackground(UIManager.getColor("ProgressBar.background"));
		progressBar.setStringPainted(true);
		Password_Panel.add(progressBar);

		JTextField textField = new JTextField();
		textField.setBounds(10, 105, 769, 39);
		textField.setForeground(UIManager.getColor("TextField.foreground"));
		textField.setBackground(UIManager.getColor("TextField.background"));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (textField.getText().length() > 0 && textField.getText() != "" && textField.getText() != null) {

					String temp = textField.getText();

					progressBar.setValue(Generate_Password.Password_strength(temp));
					progressBar.setString(Generate_Password.Password_Strength(temp));

					temp = null;
				}
			}
		});
		Password_Panel.add(textField);
		textField.setColumns(10);

		JCheckBox Use_Words_CheckBox = new JCheckBox("Use Words");
		Use_Words_CheckBox.setToolTipText("Use 274 926 Words");
		Use_Words_CheckBox.setBounds(543, 191, 172, 23);
		Password_Panel.add(Use_Words_CheckBox);

		JButton btnNewButton = new JButton("Generate");
		btnNewButton.setBounds(347, 187, 89, 30);
		btnNewButton.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Use_Words_CheckBox.isSelected()) {
					String temp = Generate_Password.Generate_Phrase(slider.getValue());
					textField.setText(temp);

					progressBar.setValue(Generate_Password.Password_strength(temp));
					progressBar.setString(Generate_Password.Password_Strength(temp));

					temp = null;
				} else {
					String temp = Generate_Password.RemoteGeneratePassword(slider.getValue(),
							Alpha_CheckBox_1.isSelected() ? 1 : 0, Alpha_CheckBox_1_1.isSelected() ? 1 : 0,
							Num_CheckBox_1.isSelected() ? 1 : 0, Sym_CheckBox_1.isSelected() ? 1 : 0,
							Exten_CheckBox_1.isSelected() ? 1 : 0, textField_1.getText().toString());
					textField.setText(temp);

					progressBar.setValue(Generate_Password.Password_strength(temp));
					progressBar.setString(Generate_Password.Password_Strength(temp));

					temp = null;
				}

			}
		});
		Password_Panel.add(btnNewButton);

		tabbedPane.addTab("Terminal", Settings.Icon_Ref.Code_32, Terminal_Panel, null);

		Terminal_Input = new JTextField();
		Terminal_Input.setBounds(10, 489, 569, 48);
		Terminal_Input.setForeground(UIManager.getColor("TextField.foreground"));
		Terminal_Input.setBackground(UIManager.getColor("TextField.background"));
		Terminal_Input.setColumns(10);

		JScrollPane Console_Scroll = new JScrollPane();
		Console_Scroll.setBounds(10, 11, 569, 472);

		Terminal_Panel.setLayout(null);

		JTextArea Console_TextArea = new JTextArea();
		Console_TextArea.setForeground(UIManager.getColor("TextArea.foreground"));
		Console_TextArea.setBackground(UIManager.getColor("TextArea.background"));
		Console_TextArea.setEditable(false);
		Console_Scroll.setViewportView(Console_TextArea);
		Terminal_Panel.add(Console_Scroll);
		Terminal_Panel.add(Terminal_Input);

		JButton Console_Clear_Btn = new JButton("Clear");
		Console_Clear_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Console_TextArea.setText("");
			}
		});
		Console_Clear_Btn.setBounds(585, 11, 85, 46);
		Console_Clear_Btn.setForeground(UIManager.getColor("Button.foreground"));
		Console_Clear_Btn.setBackground(UIManager.getColor("Button.background"));
		Terminal_Panel.add(Console_Clear_Btn);

		JButton Console_Ok_Btn = new JButton("Ok");
		Console_Ok_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Console_TextArea.setText(Console_TextArea.getText() + "\r\n"
						+ Handle_Terminal.Handler(Terminal_Input.getText(), Current_Tree_Table.Current_Countainer));

				Current_Tree_Table.Handle_Tree_Table(Current_Selection);

			}
		});
		Console_Ok_Btn.setBounds(585, 489, 73, 48);
		Console_Ok_Btn.setForeground(UIManager.getColor("Button.foreground"));
		Console_Ok_Btn.setBackground(UIManager.getColor("Button.background"));
		Terminal_Panel.add(Console_Ok_Btn);

		JPanel Settings_Panel = new JPanel();
		Settings_Panel.setForeground(UIManager.getColor("Panel.foreground"));
		Settings_Panel.setBackground(UIManager.getColor("Panel.background"));

		tabbedPane.addTab("Settings", Settings.Icon_Ref.Cog_32, Settings_Panel, null);
		Settings_Panel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Excluded Chracters");
		lblNewLabel_4.setBounds(188, 261, 99, 21);
		Settings_Panel.add(lblNewLabel_4);

		JLabel Fav_Path_Label = new JLabel("Favorit DataBase Path :");
		Fav_Path_Label.setToolTipText("Saved File Paths");
		Fav_Path_Label.setBounds(10, 11, 159, 14);
		Fav_Path_Label.setBackground(UIManager.getColor("Label.background"));
		Fav_Path_Label.setForeground(UIManager.getColor("Label.foreground"));
		Settings_Panel.add(Fav_Path_Label);

		JScrollPane Favorit_Location_scrollPane = new JScrollPane();
		Favorit_Location_scrollPane.setBounds(171, 11, 274, 89);
		Settings_Panel.add(Favorit_Location_scrollPane);

		Favorit_Location_List = new JList<String>(Favorit_Location_List_Model);
		ToolTipManager.sharedInstance().registerComponent(Favorit_Location_List);
		Favorit_Location_List.setCellRenderer(new Custom_Default_List_Cell_Renderer());
		Favorit_Location_List.setForeground(UIManager.getColor("List.foreground"));
		Favorit_Location_List.setBackground(UIManager.getColor("List.background"));

		Favorit_Location_scrollPane.setViewportView(Favorit_Location_List);

		JButton Fav_Path_Move_Up_Btn = new JButton("Up");
		Fav_Path_Move_Up_Btn.setBounds(448, 11, 89, 23);
		Fav_Path_Move_Up_Btn.setBackground(UIManager.getColor("Button.background"));
		Fav_Path_Move_Up_Btn.setForeground(UIManager.getColor("Button.foreground"));
		Fav_Path_Move_Up_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selected_Index = Favorit_Location_List.getSelectedIndex();
				if (selected_Index > 0) {

					String o = Favorit_Location_List_Model.getElementAt(selected_Index);
					Favorit_Location_List_Model.remove(selected_Index);
					Favorit_Location_List_Model.add(selected_Index - 1, o);
					Favorit_Location_List.setSelectedIndex(selected_Index - 1);

					Load_Save.Save_Favorite_DataBase(Favorit_Location_List_Model);
				}

			}
		});
		Settings_Panel.add(Fav_Path_Move_Up_Btn);

		JButton Fav_Path_Move_Down_Btn = new JButton("Down");
		Fav_Path_Move_Down_Btn.setBounds(448, 34, 89, 23);
		Fav_Path_Move_Down_Btn.setBackground(UIManager.getColor("Button.background"));
		Fav_Path_Move_Down_Btn.setForeground(UIManager.getColor("Button.foreground"));
		Fav_Path_Move_Down_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selected_Index = Favorit_Location_List.getSelectedIndex();
				// system.out.println(selected_Index);

				if (selected_Index >= 0 && selected_Index + 1 <= Favorit_Location_List_Model.getSize() - 1) {

					String o = Favorit_Location_List_Model.getElementAt(selected_Index);
					Favorit_Location_List_Model.remove(selected_Index);

					Favorit_Location_List_Model.add(selected_Index + 1, o);
					// system.out.println("hella " + selected_Index);

					Favorit_Location_List.setSelectedIndex(selected_Index + 1);

					Load_Save.Save_Favorite_DataBase(Favorit_Location_List_Model);

				}

			}
		});
		Settings_Panel.add(Fav_Path_Move_Down_Btn);

		JButton Fav_Path_New_Btn = new JButton("New");
		Fav_Path_New_Btn.setBounds(448, 57, 89, 23);
		Fav_Path_New_Btn.setBackground(UIManager.getColor("Button.background"));
		Fav_Path_New_Btn.setForeground(UIManager.getColor("Button.foreground"));
		Fav_Path_New_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				File temp_file = File_Choser_File();

				if (temp_file != null && isValidPath(temp_file.getAbsoluteFile().toString())) {

					int ref = 0;
					for (int i = 0; i < Favorit_Location_List_Model.getSize(); i++) {
						Object o = Favorit_Location_List_Model.getElementAt(i);
						if (o.toString().equals(temp_file.getAbsolutePath())) {
							ref++;
						}
					}

					if (ref == 0) {
						Favorit_Location_List_Model.addElement(temp_file.getAbsolutePath());
						Load_Save.Save_Favorite_DataBase(Favorit_Location_List_Model);
						Favorit_Location_List.setModel(Favorit_Location_List_Model);

						Favorit_Location_List.setSelectedIndex(Favorit_Location_List_Model.getSize() - 1);
						// Favorit_Location_List.setSelectedValue(temp_file.getAbsolutePath(), true);

					}
				}

			}
		});
		Settings_Panel.add(Fav_Path_New_Btn);

		JButton Fav_Path_Delete_Btn = new JButton("Delete");
		Fav_Path_Delete_Btn.setBounds(448, 79, 89, 23);
		Fav_Path_Delete_Btn.setBackground(UIManager.getColor("Button.background"));
		Fav_Path_Delete_Btn.setForeground(UIManager.getColor("Button.foreground"));
		Fav_Path_Delete_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int Selected_Index = Favorit_Location_List.getSelectedIndex();
				if (Selected_Index != -1) {

					// system.out.println(Selected_Index);
					Favorit_Location_List_Model.remove(Selected_Index);
					Favorit_Location_List.setModel(Favorit_Location_List_Model);

					Load_Save.Save_Favorite_DataBase(Favorit_Location_List_Model);

					if (Favorit_Location_List_Model.getSize() != 0) {

						if (Selected_Index - 1 < 0) {
							Favorit_Location_List.setSelectedIndex(0);

						} else {

							Favorit_Location_List.setSelectedIndex(Selected_Index - 1);
						}
					}

				}

			}
		});
		Settings_Panel.add(Fav_Path_Delete_Btn);

		JLabel Expiration_Jlabel = new JLabel("Set Expiration Date :");
		Expiration_Jlabel.setToolTipText("Expiry date automatically set on password from time of creation");
		Expiration_Jlabel.setBounds(10, 111, 141, 14);
		Expiration_Jlabel.setBackground(UIManager.getColor("Label.background"));
		Expiration_Jlabel.setForeground(UIManager.getColor("Label.foreground"));
		Settings_Panel.add(Expiration_Jlabel);

		JLabel Year_Label = new JLabel("Year");

		Year_Label.setBounds(30, 128, 50, 30);
		Year_Label.setBackground(UIManager.getColor("Label.background"));
		Year_Label.setForeground(UIManager.getColor("Label.foreground"));
		Settings_Panel.add(Year_Label);

		JLabel Month_Label = new JLabel("Month");
		Month_Label.setBounds(139, 128, 49, 30);
		Month_Label.setBackground(UIManager.getColor("Label.background"));
		Month_Label.setForeground(UIManager.getColor("Label.foreground"));
		Settings_Panel.add(Month_Label);

		JLabel Day_Label = new JLabel("Days");
		Day_Label.setBounds(267, 128, 49, 30);
		Day_Label.setBackground(UIManager.getColor("Label.background"));
		Day_Label.setForeground(UIManager.getColor("Label.foreground"));
		Settings_Panel.add(Day_Label);

		SpinnerModel sm = new SpinnerNumberModel(0, 0, 100000, 1);
		JSpinner spinner = new JSpinner(sm);
		JSpinner Year_spinField = new JSpinner(sm);
		Year_spinField.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// handle click
				Settings.Year = (int) Year_spinField.getValue();

			}
		});
		Year_spinField.setBounds(60, 128, 69, 30);
		Year_spinField.setBackground(UIManager.getColor("Spinner.background"));
		Year_spinField.setForeground(UIManager.getColor("Spinner.foreground"));
		Settings_Panel.add(Year_spinField);
		Year_spinField.setValue(Settings.Year);

		SpinnerModel sm1 = new SpinnerNumberModel(0, 0, 100000, 1);
		JSpinner Month_spinField = new JSpinner(sm1);
		Month_spinField.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// handle click
				Settings.Month = (int) Month_spinField.getValue();

			}
		});
		Month_spinField.setBounds(188, 128, 69, 30);
		Settings_Panel.add(Month_spinField);
		Month_spinField.setValue(Settings.Month);

		SpinnerModel sm2 = new SpinnerNumberModel(0, 0, 100000, 1);
		JSpinner Days_spinField = new JSpinner(sm2);
		Days_spinField.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// handle click
				Settings.Day = (int) Days_spinField.getValue();
			}
		});
		Days_spinField.setBounds(316, 128, 69, 30);
		Settings_Panel.add(Days_spinField);
		Days_spinField.setValue(Settings.Day);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 106, 774, 14);
		Settings_Panel.add(separator_3);

		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(10, 176, 774, 2);
		Settings_Panel.add(separator_3_1);

		Auto_Save_Path_CheckBox = new JCheckBox("Auto Save Favorite Path");
		Auto_Save_Path_CheckBox.setToolTipText("Automatically Save files at program start");
		Auto_Save_Path_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Auto_Save_Path = Auto_Save_Path_CheckBox.isSelected();

			}
		});
		Auto_Save_Path_CheckBox.setBounds(10, 175, 172, 23);
		Auto_Save_Path_CheckBox.setBackground(UIManager.getColor("CheckBox.background"));
		Auto_Save_Path_CheckBox.setForeground(UIManager.getColor("CheckBox.foreground"));
		Settings_Panel.add(Auto_Save_Path_CheckBox);
		Auto_Save_Path_CheckBox.setSelected(Settings.Auto_Save_Path);

		Auto_Load_File_CheckBox = new JCheckBox("Auto Load File");
		Auto_Load_File_CheckBox.setToolTipText("Automatically load files at program start");
		Auto_Load_File_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Auto_Load = Auto_Load_File_CheckBox.isSelected();
			}
		});
		Auto_Load_File_CheckBox.setBounds(10, 201, 159, 23);
		Auto_Load_File_CheckBox.setBackground(UIManager.getColor("CheckBox.background"));
		Auto_Load_File_CheckBox.setForeground(UIManager.getColor("CheckBox.foreground"));
		Settings_Panel.add(Auto_Load_File_CheckBox);
		Auto_Load_File_CheckBox.setSelected(Settings.Auto_Load);

		JSeparator separator_3_1_1 = new JSeparator();
		separator_3_1_1.setBounds(10, 241, 774, 3);
		Settings_Panel.add(separator_3_1_1);

		JLabel PassWord_Generator_Jlabel = new JLabel("PassWord Generator");
		PassWord_Generator_Jlabel.setToolTipText("Settings fro PassWord Generator");
		PassWord_Generator_Jlabel.setBounds(10, 243, 141, 14);
		PassWord_Generator_Jlabel.setBackground(UIManager.getColor("Label.background"));
		PassWord_Generator_Jlabel.setForeground(UIManager.getColor("Label.foreground"));
		Settings_Panel.add(PassWord_Generator_Jlabel);

		JCheckBox Alpha_CheckBox = new JCheckBox("Alphabetic Lower Case");
		Alpha_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Settings.Alphabetic = Alpha_CheckBox.isSelected();
			}
		});
		Alpha_CheckBox.setBounds(10, 260, 172, 23);
		Alpha_CheckBox.setBackground(UIManager.getColor("CheckBox.background"));
		Alpha_CheckBox.setForeground(UIManager.getColor("CheckBox.foreground"));
		Alpha_CheckBox.setToolTipText("Latin alphabet:\r\nletters from a to z\r\nand A to Z .");
		Settings_Panel.add(Alpha_CheckBox);
		Alpha_CheckBox.setSelected(Settings.Alphabetic);

		JCheckBox Alpha_CheckBox_2 = new JCheckBox("Alphabetic Upper Case");
		Alpha_CheckBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.AlphabeticUpper = Alpha_CheckBox_2.isSelected();

			}
		});
		Alpha_CheckBox_2.setToolTipText("Latin alphabet:\r\nletters from a to z\r\nand A to Z .");
		Alpha_CheckBox_2.setSelected(false);
		Alpha_CheckBox_2.setForeground(UIManager.getColor("CheckBox.foreground"));
		Alpha_CheckBox_2.setBackground(UIManager.getColor("CheckBox.background"));
		Alpha_CheckBox_2.setBounds(10, 287, 172, 23);
		Settings_Panel.add(Alpha_CheckBox_2);
		Alpha_CheckBox_2.setSelected(Settings.AlphabeticUpper);

		JCheckBox Num_CheckBox = new JCheckBox("Numerical");
		Num_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Numeric = Num_CheckBox.isSelected();

			}
		});
		Num_CheckBox.setBounds(10, 313, 172, 23);
		Num_CheckBox.setBackground(UIManager.getColor("CheckBox.background"));
		Num_CheckBox.setForeground(UIManager.getColor("CheckBox.foreground"));
		Num_CheckBox.setToolTipText("Numbers :\r\nfrom 0 to 9 .");
		Settings_Panel.add(Num_CheckBox);
		Num_CheckBox.setSelected(Settings.Numeric);

		JCheckBox Sym_CheckBox = new JCheckBox("Symbols");
		Sym_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Symbols = Sym_CheckBox.isSelected();

			}
		});
		Sym_CheckBox.setBounds(10, 339, 172, 23);
		Sym_CheckBox.setBackground(UIManager.getColor("CheckBox.background"));
		Sym_CheckBox.setForeground(UIManager.getColor("CheckBox.foreground"));
		Sym_CheckBox.setToolTipText("Symbols :\r\n(&\u00E9\"'(-)=~#{[|`\\^@]}*)");
		Settings_Panel.add(Sym_CheckBox);
		Sym_CheckBox.setSelected(Settings.Symbols);

		JCheckBox Exten_CheckBox = new JCheckBox("Extended Symbols");
		Exten_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Extended = Exten_CheckBox.isSelected();

			}
		});
		Exten_CheckBox.setBounds(10, 365, 172, 23);
		Exten_CheckBox.setBackground(UIManager.getColor("CheckBox.background"));
		Exten_CheckBox.setForeground(UIManager.getColor("CheckBox.foreground"));
		Exten_CheckBox.setToolTipText("Extended Symbols : \r\n(Extended Ascii Table)\r\n(\u00A9,\u00B6,\u00A5...)");
		Settings_Panel.add(Exten_CheckBox);
		Exten_CheckBox.setSelected(Settings.Extended);

		JSeparator separator_3_1_1_1 = new JSeparator();
		separator_3_1_1_1.setBounds(10, 395, 774, 3);
		Settings_Panel.add(separator_3_1_1_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Name");
		chckbxNewCheckBox.setBackground(UIManager.getColor("CheckBox.background"));
		chckbxNewCheckBox.setForeground(UIManager.getColor("CheckBox.foreground"));
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Settings.ToolTip_Name = chckbxNewCheckBox.isSelected();
			}
		});
		chckbxNewCheckBox.setBounds(10, 436, 99, 23);
		Settings_Panel.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setSelected(Settings.ToolTip_Name);

		JLabel lblNewLabel_3 = new JLabel("Tool Tip Display");
		lblNewLabel_3.setToolTipText("Tool Tip For Tree and Table");
		lblNewLabel_3.setBounds(10, 395, 123, 14);
		Settings_Panel.add(lblNewLabel_3);

		JCheckBox chckbxUserName = new JCheckBox("User Name");
		chckbxUserName.setBackground(UIManager.getColor("CheckBox.background"));
		chckbxUserName.setForeground(UIManager.getColor("CheckBox.foreground"));
		chckbxUserName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.ToolTip_User_Name = chckbxUserName.isSelected();

			}
		});
		chckbxUserName.setBounds(10, 462, 99, 23);
		Settings_Panel.add(chckbxUserName);
		chckbxUserName.setSelected(Settings.ToolTip_User_Name);

		JLabel Warning_Icon_Jlabel = new JLabel("");
		Warning_Icon_Jlabel.setHorizontalAlignment(SwingConstants.CENTER);
		Warning_Icon_Jlabel.setToolTipText("Will Display Password");
		Warning_Icon_Jlabel.setIcon(Icon_Ref.Warning_24);
		Warning_Icon_Jlabel.setBounds(85, 485, 44, 30);
		Settings_Panel.add(Warning_Icon_Jlabel);

		JCheckBox chckbxPassword = new JCheckBox("Password");
		chckbxPassword.setBackground(UIManager.getColor("CheckBox.background"));
		chckbxPassword.setForeground(UIManager.getColor("CheckBox.foreground"));
		chckbxPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.ToolTip_Password = chckbxPassword.isSelected();

			}
		});
		chckbxPassword.setBounds(10, 492, 99, 23);
		Settings_Panel.add(chckbxPassword);
		chckbxPassword.setSelected(Settings.ToolTip_Password);

		JCheckBox chckbxUrl = new JCheckBox("URL");
		chckbxUrl.setBackground(UIManager.getColor("CheckBox.background"));
		chckbxUrl.setForeground(UIManager.getColor("CheckBox.foreground"));
		chckbxUrl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.ToolTip_Url = chckbxUrl.isSelected();

			}
		});
		chckbxUrl.setBounds(10, 518, 99, 23);
		Settings_Panel.add(chckbxUrl);
		chckbxUrl.setSelected(Settings.ToolTip_Url);

		JCheckBox chckbxNote = new JCheckBox("Note");
		chckbxNote.setBackground(UIManager.getColor("CheckBox.background"));
		chckbxNote.setForeground(UIManager.getColor("CheckBox.foreground"));
		chckbxNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.ToolTip_Note = chckbxNote.isSelected();

			}
		});
		chckbxNote.setBounds(138, 436, 99, 23);
		Settings_Panel.add(chckbxNote);
		chckbxNote.setSelected(Settings.ToolTip_Note);

		JCheckBox chckbxTimeCreated = new JCheckBox("Time Created");
		chckbxTimeCreated.setBackground(UIManager.getColor("CheckBox.background"));
		chckbxTimeCreated.setForeground(UIManager.getColor("CheckBox.foreground"));
		chckbxTimeCreated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.ToolTip_Created = chckbxTimeCreated.isSelected();

			}
		});
		chckbxTimeCreated.setBounds(138, 462, 99, 23);
		Settings_Panel.add(chckbxTimeCreated);
		chckbxTimeCreated.setSelected(Settings.ToolTip_Created);

		JCheckBox chckbxTimeModified = new JCheckBox("Time Modified");
		chckbxTimeModified.setBackground(UIManager.getColor("CheckBox.background"));
		chckbxTimeModified.setForeground(UIManager.getColor("CheckBox.foreground"));
		chckbxTimeModified.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.ToolTip_Modified = chckbxTimeModified.isSelected();

			}
		});
		chckbxTimeModified.setBounds(138, 492, 99, 23);
		Settings_Panel.add(chckbxTimeModified);
		chckbxTimeModified.setSelected(Settings.ToolTip_Modified);

		JCheckBox chckbxExpiration = new JCheckBox("Expiration");
		chckbxExpiration.setBackground(UIManager.getColor("CheckBox.background"));
		chckbxExpiration.setForeground(UIManager.getColor("CheckBox.foreground"));
		chckbxExpiration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Settings.ToolTip_Expired = chckbxExpiration.isSelected();

			}
		});
		chckbxExpiration.setBounds(138, 518, 99, 23);
		Settings_Panel.add(chckbxExpiration);
		chckbxExpiration.setSelected(Settings.ToolTip_Expired);

		JTextField Exluding_textField = new JTextField();
		Exluding_textField.setForeground(UIManager.getColor("TextField.foreground"));
		Exluding_textField.setBackground(UIManager.getColor("TextField.background"));
		Exluding_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Settings.Exluding = Exluding_textField.getText();

			}
		});
		Exluding_textField.setBounds(290, 261, 123, 30);
		Settings_Panel.add(Exluding_textField);
		Exluding_textField.setColumns(10);

		JRadioButton ToolTip_Tree = new JRadioButton("Use ToolTip For Tree");
		ToolTip_Tree.setForeground(UIManager.getColor("RadioButton.foreground"));
		ToolTip_Tree.setBackground(UIManager.getColor("RadioButton.background"));
		ToolTip_Tree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Settings.Use_ToolTip_Tree = ToolTip_Tree.isSelected();
				if (Settings.Locked == false) {

					Current_Tree_Table.Handle_Tree_Table(Current_Selection);

				}
			}
		});
		ToolTip_Tree.setBounds(10, 412, 172, 23);
		Settings_Panel.add(ToolTip_Tree);
		ToolTip_Tree.setSelected(Settings.Use_ToolTip_Tree);

		JRadioButton ToolTip_Table = new JRadioButton("Use ToolTip For Table");
		ToolTip_Table.setForeground(UIManager.getColor("RadioButton.foreground"));
		ToolTip_Table.setBackground(UIManager.getColor("RadioButton.background"));
		ToolTip_Table.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Use_ToolTip_Table = ToolTip_Table.isSelected();
				if (Settings.Locked == false) {

					Current_Tree_Table.Handle_Tree_Table(Current_Selection);

				}

			}
		});
		ToolTip_Table.setBounds(189, 410, 172, 23);
		Settings_Panel.add(ToolTip_Table);
		ToolTip_Table.setSelected(Settings.Use_ToolTip_Table);

		JButton Fav_Path_Open_Btn = new JButton("Open");

		Fav_Path_Open_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Favorit_Location_List != null && Favorit_Location_List.isSelectionEmpty() == false) {

					String Temp = Favorit_Location_List.getSelectedValue();

					if (Temp != null && Temp.length() > 0 && Temp != "" && Temp.endsWith(".Enc")) {
						File Temp_Path = new File(Temp);

						if (Temp_Path != null && Temp_Path.exists()
								&& isValidPath(Temp_Path.getAbsoluteFile().toString())) {

							System.err.println("Load Data : ");

							// system.out.println("Path received : " + Temp_Path);

							Login_Jdialog(Temp_Path.getName());

							if (Current_Tree_Table.Current_Countainer != null) {

								// system.out.println("===========================================================");
								Load_Save.Load(Temp_Path.getAbsolutePath(), Current_Tree_Table.Current_Countainer);

								Current_Tree_Table.Handle_Tree_Table(Current_Selection);
								Current_Tree_Table.Tree.setVisible(true);

								Current_Stats.Initiale_File_Size = Current_Tree_Table.Current_Countainer.Root
										.Files_Size();
								Current_File = Temp_Path;

								Data_Name_textfield.setText(Temp_Path.getName());
							} else {

							}
						}
					}

					System.gc();

				}

			}
		});
		Fav_Path_Open_Btn.setForeground(UIManager.getColor("Button.foreground"));
		Fav_Path_Open_Btn.setBackground(UIManager.getColor("Button.background"));
		Fav_Path_Open_Btn.setBounds(537, 11, 89, 23);
		Settings_Panel.add(Fav_Path_Open_Btn);
//
//		JPanel Key_Word_Panel = new JPanel();
//		tabbedPane.addTab("Tags", Icon_Ref.Tags_32, Key_Word_Panel, null);

		Data_Name_textfield = new JTextField();
		Data_Name_textfield.setBounds(10, 0, 904, 22);
		Data_Name_textfield.setEnabled(false);
		frmHarpocrates.getContentPane().add(Data_Name_textfield);
		Data_Name_textfield.setHorizontalAlignment(SwingConstants.CENTER);
		Data_Name_textfield.setFont(new Font("Arial", Font.BOLD, 40));
		Data_Name_textfield.setEditable(false);
		Data_Name_textfield.setForeground(UIManager.getColor("TextField.foreground"));
		Data_Name_textfield.setColumns(10);
		Data_Name_textfield.setBackground(UIManager.getColor("TextField.background"));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(UIManager.getColor("Menu.foreground"));
		menuBar.setBackground(UIManager.getColor("Menu.background"));
		frmHarpocrates.setJMenuBar(menuBar);

		JMenu FileMenu = new JMenu("File");
		FileMenu.setMnemonic(KeyEvent.VK_F);

		FileMenu.setBackground(UIManager.getColor("MenuItem.background"));
		FileMenu.setForeground(UIManager.getColor("MenuItem.foreground"));
		menuBar.add(FileMenu);

		JMenuItem OpenMenuItem = new JMenuItem("Open");
		KeyStroke controlO = KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK);
		OpenMenuItem.setAccelerator(controlO);
		OpenMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.err.println("Load Data : ");

				// system.out.println("Modified_Folders : " + Current_Stats.Modified_Folders);
				// system.out.println("Modified_Passwords : " +
				// Current_Stats.Modified_Passwords);
				// system.out.println("Created_Folders : " + Current_Stats.Created_Folders);
				// system.out.println("Created_Passwords : " + Current_Stats.Created_Passwords);
				// system.out.println("Deleted_Folders : " + Current_Stats.Deleted_Folders);
				// system.out.println("Deleted_Passwords : " + Current_Stats.Deleted_Passwords);

				File Temp_Path = File_Choser();
				if (Temp_Path != null) {

					if (isValidPath(Temp_Path.getAbsolutePath().toString())) {

						Add_To_Fav_Path(Temp_Path);

						// system.out.println("Path received : " + Temp_Path);

						Login_Jdialog(Temp_Path.getName());

						if (Current_Tree_Table.Current_Countainer != null) {

							// system.out.println("===========================================================");
							Load_Save.Load(Temp_Path.getAbsolutePath(), Current_Tree_Table.Current_Countainer);

							if (Current_Tree_Table.Current_Countainer.is_Valide()) {
								System.out.println(9999999);
								Current_Tree_Table.Handle_Tree_Table(Current_Selection);
								Current_Tree_Table.Tree.setVisible(true);

								Current_Stats.Initiale_File_Size = Current_Tree_Table.Current_Countainer.Root
										.Files_Size();

								Data_Name_textfield.setText(Temp_Path.getName());
								Current_File = Temp_Path;

							} else {
								Current_Tree_Table.Current_Countainer = null;
							}
						} else {

						}
					}
				}

				System.gc();

			}
		});
		FileMenu.add(OpenMenuItem);

		JMenuItem SaveMenuItem = new JMenuItem("Save");
		KeyStroke controlS = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK);
		SaveMenuItem.setAccelerator(controlS);
		SaveMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("Start");
				if (Current_Tree_Table.Current_Countainer != null && Current_File != null) {

					System.err.println("Save Data : ");

					int result = Save_Jdialog();
					if (result == JOptionPane.YES_OPTION) {
						Load_Save.Save(Current_File.getAbsolutePath(), Current_Tree_Table.Current_Countainer);
						Load_Save.Save_Settings();

					} else if (result == JOptionPane.NO_OPTION) {

					} else {

					}
				}

			}
		});

		JMenuItem NewMenuItem = new JMenuItem("New File");
		KeyStroke controlN = KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK);
		NewMenuItem.setAccelerator(controlN);
		NewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Current_Tree_Table.Current_Countainer == null) {

				} else {

					int result = JOptionPane.showConfirmDialog(frmHarpocrates,
							"Do you want to abandon the current save ?", "New File", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {

					} else if (result == JOptionPane.NO_OPTION) {

						return;
					} else {
						return;

					}

				}

				Current_Tree_Table.Current_Countainer = null;

				New_Data_Base_Jdialog();

				if (Current_Tree_Table.Current_Countainer == null) {
					System.err.println("NUll !!!!");

				} else {

					// system.out.println(Current_Tree_Table.Current_Countainer.Main_Name);

					// Current_Tree_Table.Current_Countainer = new Node_Container("Yahya123");

					Current_Tree_Table.Handle_Tree_Table(Current_Selection);
					Current_Tree_Table.Tree.setVisible(true);

					Current_Stats.Initiale_File_Size = Current_Tree_Table.Current_Countainer.Root.Files_Size();

					Data_Name_textfield.setText(Current_Tree_Table.Current_Countainer.Main_Name);
				}
				System.gc();

			}
		});
		FileMenu.add(NewMenuItem);
		FileMenu.add(SaveMenuItem);

		JMenuItem SaveAsMenuItem = new JMenuItem("Save As ...");
		SaveAsMenuItem.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		SaveAsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Current_Tree_Table.Current_Countainer != null) {

					File temp = File_Choser_File();

					if (temp != null && isValidPath(temp.getAbsoluteFile().toString())) {

						String path = temp.getAbsolutePath();
						String filename = temp.getName();

						if (path != null && path.length() != 0 && filename != null && filename.length() != 0) {

							if (Current_Tree_Table.Current_Countainer != null) {

								Add_To_Fav_Path(temp);

								Load_Save.Save(path, Current_Tree_Table.Current_Countainer);
								Data_Name_textfield.setText(filename);

							}

						}
					}
				}

			}
		});
		FileMenu.add(SaveAsMenuItem);

		JMenuItem mntmSaveAsnew = new JMenuItem("Save As (New PassWord)");
		mntmSaveAsnew.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));

		mntmSaveAsnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Current_Tree_Table.Current_Countainer != null) {

					File temp = File_Choser_File();

					if (temp != null && isValidPath(temp.getAbsoluteFile().toString())) {

						String path = temp.getAbsolutePath();
						String filename = temp.getName();

						if (path != null && path.length() != 0 && filename != null && filename.length() != 0) {

							if (Current_Tree_Table.Current_Countainer != null) {

								Add_To_Fav_Path(temp);

								PassLogin_Jdialog(Data_Name_textfield.getText());

								Load_Save.Save(path, Current_Tree_Table.Current_Countainer);
								Data_Name_textfield.setText(filename);

							}

						}
					}
				}

			}
		});
		FileMenu.add(mntmSaveAsnew);

		JMenuItem AbandonMenuItem = new JMenuItem("Abandon File");
		AbandonMenuItem.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		AbandonMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Current_Tree_Table.Current_Countainer != null) {

					int result = Abondone_Jdialog();
					if (result == JOptionPane.YES_OPTION) {

					} else if (result == JOptionPane.NO_OPTION) {

						return;
					}

					Current_Tree_Table.Current_Countainer = null;
				}
				Current_Tree_Table.Clear_Tree();
				Current_Tree_Table.Clear_Table();
				Current_Selection = null;
				Current_Selection_file = null;
				Current_File = null;
				Current_Stats = null;
				Copied_File = null;
				Copied_Folder = null;
				System.gc();

			}
		});

		// KeyStroke controlX = KeyStroke.getKeyStroke(KeyEvent.VK_X,
		// InputEvent.CTRL_DOWN_MASK);
		// AbandonMenuItem.setAccelerator(controlX);
		FileMenu.add(AbandonMenuItem);

		JMenu ToolMenu = new JMenu("Tools");
		ToolMenu.setBackground(UIManager.getColor("MenuItem.background"));
		ToolMenu.setForeground(UIManager.getColor("MenuItem.foreground"));
		menuBar.add(ToolMenu);

		JMenu ImportCsvMenu = new JMenu("Import Csv");
		ToolMenu.add(ImportCsvMenu);

		JMenuItem mntmImportFirefoxCsv = new JMenuItem("Import FireFox CSV");
		mntmImportFirefoxCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Settings.Locked == false) {

					if (Current_Selection != null) {

						File temp_File = File_ChoserCSV(mntmImportFirefoxCsv.getText());

						if (temp_File != null) {

							Handle_Csv.Handle_Firefox_Csv(temp_File.getAbsolutePath(), Current_Selection);

							Current_Selection.Establish_Link();

							Current_Tree_Table.Handle_Tree_Table(Current_Selection);
							Current_Tree_Table.Tree.setVisible(true);

						}

					}

				}
			}
		});
		ImportCsvMenu.add(mntmImportFirefoxCsv);

		JMenuItem mntmChrome = new JMenuItem("Import Chrome CSV");
		mntmChrome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Settings.Locked == false) {

					if (Current_Selection != null) {

						File temp_File = File_ChoserCSV(mntmChrome.getText());

						if (temp_File != null) {

							Handle_Csv.Handle_Chrome_Csv(temp_File.getAbsolutePath(), Current_Selection);

							Current_Selection.Establish_Link();

							Current_Tree_Table.Handle_Tree_Table(Current_Selection);
							Current_Tree_Table.Tree.setVisible(true);

						}

					}

				}
			}
		});
		ImportCsvMenu.add(mntmChrome);

		JMenuItem mntmEdge = new JMenuItem("Import Edge CSV");
		mntmEdge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Settings.Locked == false) {

					if (Current_Selection != null) {

						File temp_File = File_ChoserCSV(mntmEdge.getText());

						if (temp_File != null) {

							Handle_Csv.Handle_Edge_Csv(temp_File.getAbsolutePath(), Current_Selection);

							Current_Selection.Establish_Link();

							Current_Tree_Table.Handle_Tree_Table(Current_Selection);
							Current_Tree_Table.Tree.setVisible(true);

						}

					}
				}
			}
		});
		ImportCsvMenu.add(mntmEdge);

		JMenuItem mntmOpera = new JMenuItem("Import Opera CSV");
		mntmOpera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Settings.Locked == false) {
					if (Current_Selection != null) {

						File temp_File = File_ChoserCSV(mntmOpera.getText());

						if (temp_File != null) {

							Handle_Csv.Handle_Opera_Csv(temp_File.getAbsolutePath(), Current_Selection);

							Current_Selection.Establish_Link();

							Current_Tree_Table.Handle_Tree_Table(Current_Selection);
							Current_Tree_Table.Tree.setVisible(true);

						}

					}
				}

			}
		});
		ImportCsvMenu.add(mntmOpera);

		JMenuItem mntmImportEncCsv = new JMenuItem("Import Enc CSV");
		mntmImportEncCsv.createToolTip();
		mntmImportEncCsv.setToolTipText("Import Csv Files Generated by this Programe");
		mntmImportEncCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Settings.Locked == false) {
					if (Current_Selection != null) {

						File temp_File = File_ChoserCSV(mntmOpera.getText());

						if (temp_File != null) {

							Handle_Csv.Handle_Custom_Enc_Csv(temp_File.getAbsolutePath(), Current_Selection);

							Current_Selection.Establish_Link();

							Current_Tree_Table.Handle_Tree_Table(Current_Selection);
							Current_Tree_Table.Tree.setVisible(true);

						}

					}
				}

			}
		});
		ImportCsvMenu.add(mntmImportEncCsv);

		JMenuItem mntmRebuild = new JMenuItem("Rebuild");
		mntmRebuild.createToolTip();
		mntmRebuild.setToolTipText("Rebuild Tree & Table .");
		mntmRebuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Settings.Locked == false) {

					Current_Tree_Table.Handle_Tree_Table(Current_Selection);

				}

			}
		});

		JMenuItem mntmImportEnc = new JMenuItem("Import Enc");
		mntmImportEnc.createToolTip();
		mntmImportEnc.setToolTipText("Import a file Root into the current save");
		mntmImportEnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Settings.Locked == false) {
					System.err.println("Load Imported Data : ");
					if (Current_Tree_Table.Current_Countainer != null) {

						File Temp_Path = File_Choser();
						if (Temp_Path != null) {

							if (isValidPath(Temp_Path.getAbsolutePath().toString())) {

								Add_To_Fav_Path(Temp_Path);

								Current_File = Temp_Path;

								// system.out.println("Path received : " + Temp_Path);

								Custom_Login_Jdialog(Temp_Path.getName());

								if (Imported_Container != null) {

									// system.out.println("===========================================================");
									Load_Save.Load(Temp_Path.getAbsolutePath(), Imported_Container);

									Current_Tree_Table.Current_Countainer.Root.Add_Child(Imported_Container.Root
											.Duplicate_Folder("Imported Root" + LocalDateTime.now().toString()));
									Imported_Container = null;
									Current_Tree_Table.Current_Countainer.Root.Establish_Link();
									Current_Tree_Table.Handle_Tree_Table(Current_Selection);

								} else {

								}
							}
						}
						System.gc();

					}
				}
			}
		});

		JMenuItem mntmExportCsv = new JMenuItem("Export Csv");
		mntmExportCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Settings.Locked == false) {
					if (Current_Tree_Table.Current_Countainer != null) {

						if (Current_Selection != null) {

							File temp = File_ChoserCSV("CSV file Path");

							if (temp != null) {

								String path = temp.getAbsolutePath();
								String filename = temp.getName();

								if (path.endsWith(".csv")) {

								} else {

									if (path.endsWith("\\") == false) {

										path += ".csv";
									}
								}

								Handle_Csv.Export_Csv(Current_Selection, path);
							}
						}

						System.gc();
					}
				} else {
					if (Current_Tree_Table.Current_Countainer != null) {

						if (Current_Tree_Table.Operation_Folder != null) {

							File temp = File_ChoserCSV("CSV file Path");

							if (temp != null) {

								String path = temp.getAbsolutePath();
								String filename = temp.getName();

								if (path.endsWith(".csv")) {

								} else {

									if (path.endsWith("\\") == false) {

										path += ".csv";
									}
								}

								if (Current_Tree_Table.Operation_Folder != null) {
									Handle_Csv.Export_Csv(Current_Tree_Table.Operation_Folder, path);

								} else if (Current_Tree_Table.Operation_Folder != null) {

									Handle_Csv.Export_Csv(Current_Tree_Table.Operation_Folder, path);
								}
							}
						}

						System.gc();
					}
				}

			}
		});
		mntmExportCsv.setToolTipText("Export The Current Folder as CSV .(Experimental)");
		ToolMenu.add(mntmExportCsv);

		JSeparator separator_1 = new JSeparator();
		ToolMenu.add(separator_1);
		ToolMenu.add(mntmImportEnc);

		JMenuItem mntmExportSelected = new JMenuItem("Export Enc");
		mntmExportSelected.createToolTip();
		mntmExportSelected.setToolTipText("Export The Current Folder .");
		mntmExportSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Settings.Locked == false) {
					if (Current_Tree_Table.Current_Countainer != null) {

						if (Current_Selection != null) {

							File temp = File_Choser_File();

							if (temp != null && isValidPath(temp.getAbsoluteFile().toString())) {

								String path = temp.getAbsolutePath();
								String filename = temp.getName();

								filename = filename.replaceAll(".Enc", "");

								if (path != null && path.length() != 0 && filename != null && filename.length() != 0) {

									Custom_New_Data_Base_Jdialog(filename);

									if (Exported_Container != null) {

										Exported_Container.Root.Add_Child(
												Current_Selection.Duplicate_Folder(Current_Selection.Get_Name()));
										Exported_Container.Root.Establish_Link();
										Add_To_Fav_Path(temp);

										Load_Save.Save(path, Exported_Container);
										Exported_Container = null;

									}

								}
							}
						}
					}
					System.gc();
				} else {

					if (Current_Tree_Table.Current_Countainer != null) {

						File temp = File_Choser_File();

						if (temp != null && isValidPath(temp.getAbsoluteFile().toString())) {

							String path = temp.getAbsolutePath();
							String filename = temp.getName();

							filename = filename.replaceAll(".Enc", "");

							if (path != null && path.length() != 0 && filename != null && filename.length() != 0) {

								Custom_New_Data_Base_Jdialog(filename);

								if (Exported_Container != null) {

									if (Current_Tree_Table.Operation_Folder != null
											|| Current_Tree_Table.Operation_Folder != null) {

										if (Current_Tree_Table.Operation_Folder != null) {

											Exported_Container.Root.Add_Child(Current_Tree_Table.Operation_Folder
													.Duplicate_Folder(Current_Tree_Table.Operation_Folder.Get_Name()));
										} else if (Current_Tree_Table.Operation_Folder != null) {

											Exported_Container.Root.Add_Child(Current_Tree_Table.Operation_Folder
													.Duplicate_Folder(Current_Tree_Table.Operation_Folder.Get_Name()));
										}

										Exported_Container.Root.Establish_Link();
										Add_To_Fav_Path(temp);

										Load_Save.Save(path, Exported_Container);

									}
								}

							}
						}
					}

				}

			}
		});
		ToolMenu.add(mntmExportSelected);

		JSeparator separator_1_1 = new JSeparator();
		ToolMenu.add(separator_1_1);
		ToolMenu.add(mntmRebuild);

		JSeparator separator_1_1_1 = new JSeparator();
		ToolMenu.add(separator_1_1_1);

		JMenuItem mntmChangePassword = new JMenuItem("Change PassWord");
		mntmChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Current_Tree_Table.Current_Countainer != null) {

					PassLogin_Jdialog(Data_Name_textfield.getText());
				}

			}
		});
		mntmChangePassword.setToolTipText("Rebuild Tree & Table .");
		ToolMenu.add(mntmChangePassword);

		JMenu ThemeFontMenu = new JMenu("theme & font");
		ThemeFontMenu.setBackground(UIManager.getColor("MenuItem.background"));
		ThemeFontMenu.setForeground(UIManager.getColor("MenuItem.foreground"));
		menuBar.add(ThemeFontMenu);

		JMenu MenuTheme = new JMenu("Theme");
		ThemeFontMenu.add(MenuTheme);

		JMenuItem MenuItemThemeLight = new JMenuItem("Light");
		MenuItemThemeLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Settings.Theme = MenuItemThemeLight.getText();
				Load_Save.Save_Theme();
			}
		});
		MenuTheme.add(MenuItemThemeLight);

		JMenuItem MenuItemThemeDark = new JMenuItem("Dark");
		MenuItemThemeDark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Settings.Theme = MenuItemThemeDark.getText();
				Load_Save.Save_Theme();
			}
		});
		MenuTheme.add(MenuItemThemeDark);

		JMenuItem MenuItemThemeDarcula = new JMenuItem("Darcula");
		MenuItemThemeDarcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Settings.Theme = MenuItemThemeDarcula.getText();
				Load_Save.Save_Theme();
			}
		});
		MenuTheme.add(MenuItemThemeDarcula);

		JMenuItem MenuItemThemeDeepOcean = new JMenuItem("DeepOcean");
		MenuItemThemeDeepOcean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Settings.Theme = MenuItemThemeDeepOcean.getText();
				Load_Save.Save_Theme();
			}
		});
		MenuTheme.add(MenuItemThemeDeepOcean);

		JMenuItem MenuItemThemeCarbon = new JMenuItem("Carbon");
		MenuItemThemeCarbon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Theme = MenuItemThemeCarbon.getText();
				Load_Save.Save_Theme();

			}
		});
		MenuTheme.add(MenuItemThemeCarbon);

		JMenuItem MenuItemThemeCyan = new JMenuItem("Cyan");
		MenuItemThemeCyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Theme = MenuItemThemeCyan.getText();
				Load_Save.Save_Theme();
			}
		});

		MenuTheme.add(MenuItemThemeCyan);

		JMenuItem MenuItemThemeMidnightBlue = new JMenuItem("Midnight Blue");
		MenuItemThemeMidnightBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Settings.Theme = MenuItemThemeMidnightBlue.getText();
				Load_Save.Save_Theme();
			}
		});
		MenuTheme.add(MenuItemThemeMidnightBlue);

		JMenuItem MenuItemThemeHiberbeeDrak = new JMenuItem("HiberbeeDark");
		MenuItemThemeHiberbeeDrak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Theme = MenuItemThemeHiberbeeDrak.getText();
				Load_Save.Save_Theme();
			}
		});
		MenuTheme.add(MenuItemThemeHiberbeeDrak);

		JMenuItem MenuItemThemeMonocai = new JMenuItem("Monocai");
		MenuItemThemeMonocai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Theme = MenuItemThemeMonocai.getText();
				Load_Save.Save_Theme();
			}
		});
		MenuTheme.add(MenuItemThemeMonocai);

		JMenuItem MenuItemThemeSolorizedDark = new JMenuItem("SolarizedDark");
		MenuItemThemeSolorizedDark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Theme = MenuItemThemeSolorizedDark.getText();
				Load_Save.Save_Theme();
			}
		});
		MenuTheme.add(MenuItemThemeSolorizedDark);

		JMenuItem MenuItemThemeSolorizedLight = new JMenuItem("SolarizedLight");
		MenuItemThemeSolorizedLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Theme = MenuItemThemeSolorizedLight.getText();
				Load_Save.Save_Theme();
			}
		});
		MenuTheme.add(MenuItemThemeSolorizedLight);

		JMenuItem MenuItemThemeDarkPurple = new JMenuItem("DarkPurple");
		MenuItemThemeDarkPurple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Theme = MenuItemThemeDarkPurple.getText();
				Load_Save.Save_Theme();
			}
		});
		MenuTheme.add(MenuItemThemeDarkPurple);

		JMenuItem MenuItemThemeCobalt = new JMenuItem("Cobalt");
		MenuItemThemeCobalt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Theme = MenuItemThemeCobalt.getText();
				Load_Save.Save_Theme();
			}
		});
		MenuTheme.add(MenuItemThemeCobalt);

		JMenuItem MenuItemThemeArc = new JMenuItem("Arc");
		MenuItemThemeArc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Theme = MenuItemThemeArc.getText();
				Load_Save.Save_Theme();
			}
		});
		MenuTheme.add(MenuItemThemeArc);

		JMenuItem MenuItemThemeArcOrange = new JMenuItem("Arc Orange");
		MenuItemThemeArcOrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.Theme = MenuItemThemeArcOrange.getText();
				Load_Save.Save_Theme();
			}
		});
		MenuTheme.add(MenuItemThemeArcOrange);

		JSeparator separator = new JSeparator();
		ThemeFontMenu.add(separator);

		JMenu SettingsMenu = new JMenu("Settings");
		SettingsMenu.setBackground(UIManager.getColor("MenuItem.background"));
		SettingsMenu.setForeground(UIManager.getColor("MenuItem.foreground"));
		menuBar.add(SettingsMenu);

		JMenuItem mntmSaveSettings = new JMenuItem("Save Settings");
		mntmSaveSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Load_Save.Save_Favorite_DataBase(Favorit_Location_List_Model);
				Load_Save.Save_Theme();
				Load_Save.Save_Settings();

			}
		});
		SettingsMenu.add(mntmSaveSettings);

		JMenu HelpMenu = new JMenu("Help");
		HelpMenu.setBackground(UIManager.getColor("MenuItem.background"));
		HelpMenu.setForeground(UIManager.getColor("MenuItem.foreground"));
		menuBar.add(HelpMenu);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(frmHarpocrates, "",
						"Harpocrates Copyright � 2022 Yahya Belgharbi", JOptionPane.CLOSED_OPTION,
						JOptionPane.CLOSED_OPTION, Settings.Icon_Ref.Harpocrates_Render1);

			}
		});
		HelpMenu.add(mntmAbout);

		JMenuItem mntmGuide = new JMenuItem("Guide");
		HelpMenu.add(mntmGuide);

		JSlider Font_slider = new JSlider();
		Font_slider.setForeground(UIManager.getColor("Separator.foreground"));
		Font_slider.setBackground(UIManager.getColor("Slider.background"));
		Font_slider.setValue(11);
		Font_slider.setMaximum(15);
		Font_slider.setValue(Settings.Font_Size);
		Font_slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				float Slide_Value = Font_slider.getValue();

//				System.out.println(Slide_Value);
				Settings.Font_Size = (int) Slide_Value;

				Font_Handler.changeFont(frmHarpocrates);
				Font_Handler.changeFont_Size(frmHarpocrates);

//				Font_Handler.changeFont(Current_Tree_Table.Tree);
//				Font_Handler.changeFont_Size(Current_Tree_Table.Tree);

				Current_Tree_Table.Tree.setFont(
						new Font(Settings.Font_Name, Current_Tree_Table.Tree.getFont().getStyle(), Settings.Font_Size));

				Current_Tree_Table.Tree.repaint();

			}
		});
		Font_slider.setMinimum(5);
		ThemeFontMenu.add(Font_slider);

		JMenu mnFont = new JMenu("Font");
		ThemeFontMenu.add(mnFont);

		JPanel panel = new JPanel();
		mnFont.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		Build_Font_Btn(panel);
		Font_Handler.changeFont(menuBar);
		FolderJPopupMenu();
		Search_Menu();

		frmHarpocrates.setVisible(true);

	}

	// ___________________________________________________________________________________

	public void Search_Menu() {

		Search_Option_Menu.setBounds(0, 0, 75, 174);

		JCheckBox NameCheckBox = new JCheckBox("Name");
		NameCheckBox.setToolTipText("Search Name.");
		NameCheckBox.setBounds(10, 260, 172, 23);
		NameCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.search = Search.Name;
			}
		});
		Search_Option_Menu.add(NameCheckBox);
		SearchButtonGroup.add(NameCheckBox);

		JCheckBox User_Name_CheckBox = new JCheckBox("User Name");
		User_Name_CheckBox.setToolTipText("Search User Name.");
		User_Name_CheckBox.setBounds(10, 260, 172, 23);
		User_Name_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.search = Search.User_Name;

			}
		});
		Search_Option_Menu.add(User_Name_CheckBox);
		SearchButtonGroup.add(User_Name_CheckBox);

		JCheckBox PassCheckBox = new JCheckBox("Passwords");
		PassCheckBox.setToolTipText("Search Passwords.");
		PassCheckBox.setBounds(10, 260, 172, 23);
		PassCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.search = Search.PassWord;

			}
		});
		Search_Option_Menu.add(PassCheckBox);
		SearchButtonGroup.add(PassCheckBox);

		JCheckBox OldPassCheckBox = new JCheckBox("Old Passwords");
		OldPassCheckBox.setToolTipText("Search Old Passwords.");
		OldPassCheckBox.setBounds(10, 260, 172, 23);
		OldPassCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.search = Search.OldPassWord;

			}
		});
		Search_Option_Menu.add(OldPassCheckBox);
		SearchButtonGroup.add(OldPassCheckBox);

		JCheckBox UrlCheckBox = new JCheckBox("Url ");
		UrlCheckBox.setToolTipText("Search Url.");
		UrlCheckBox.setBounds(10, 260, 172, 23);
		UrlCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.search = Search.Url;

			}
		});
		Search_Option_Menu.add(UrlCheckBox);
		SearchButtonGroup.add(UrlCheckBox);

		JCheckBox KeyWordCheckBox = new JCheckBox(" KeyWord ");
		KeyWordCheckBox.setToolTipText("Search  KeyWord.");
		KeyWordCheckBox.setBounds(10, 260, 172, 23);
		KeyWordCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.search = Search.KeyWord;

			}
		});
		Search_Option_Menu.add(KeyWordCheckBox);
		SearchButtonGroup.add(KeyWordCheckBox);

		JCheckBox NoteCheckBox = new JCheckBox(" Note ");
		NoteCheckBox.setToolTipText("Search  Note.");
		NoteCheckBox.setBounds(10, 260, 172, 23);
		NoteCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.search = Search.Note;

			}
		});
		Search_Option_Menu.add(NoteCheckBox);
		SearchButtonGroup.add(NoteCheckBox);

		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(10, 176, 774, 14);
		Search_Option_Menu.add(separator_3_1);

		JRadioButton Ignore_Case_JRBtn = new JRadioButton("Ignore Case");
		Ignore_Case_JRBtn.setBounds(10, 1, 92, 30);
		Ignore_Case_JRBtn.setBackground(UIManager.getColor("RadioButton.background"));
		Ignore_Case_JRBtn.setForeground(UIManager.getColor("RadioButton.foreground"));
		Ignore_Case_JRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Settings.Ignore_Case = Ignore_Case_JRBtn.isSelected();

			}
		});
		Search_Option_Menu.add(Ignore_Case_JRBtn);

		NameCheckBox.setSelected(true);
		Font_Handler.changeFont(Search_Option_Menu);
		Font_Handler.changeFont_Size(Search_Option_Menu);
	}

	public void FolderJPopupMenu() {

		JMenuItem Foldercopy = new JMenuItem("Copy Folder");
		KeyStroke controlC = KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK);
		Foldercopy.setAccelerator(controlC);
		Foldercopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if (Current_Selection != null) {

						Node_Structure new_copy = Current_Selection.Duplicate_Folder(Current_Selection.Get_Name());
						Copied_Folder = new_copy;
						Copied_File = null;
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.err.println(e2);
				}

			}
		});

		JMenuItem Folderpaste = new JMenuItem("Paste");
		KeyStroke controlV = KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK);
		Folderpaste.setAccelerator(controlV);
		Folderpaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Settings.Locked == false) {

					if (Copied_File != null || Copied_Folder != null) {

						if (Current_Selection != null) {// if either is selected and thers a result do this

							int ref = 0;
							if (Copied_File == null && Copied_Folder != null) {

								Node_Structure new_copy = Copied_Folder.Duplicate_Folder(Copied_Folder.Get_Name());
								Copied_Folder = null;

								if (new_copy != null) {

									if (Current_Selection.Children.containsKey(new_copy.Get_Name()) == false) {

										Current_Selection.Add_Child(new_copy);

										ref++;
									}

								}

							} else if (Copied_File != null && Copied_Folder == null) {
								// system.out.println("Paste File");

								Node_File new_copy = new Node_File(Copied_File);
								Copied_File = null;

								if (new_copy != null) {

									// system.out.println("Pasted in " + temp.Get_Name());
									if (Current_Selection.File_Children.containsKey(new_copy.getName()) == false) {

										Current_Selection.Add_File(new_copy);
										ref++;
									}

								}

							}
//						 else if (Copied_File != null && Copied_Folder != null) {
//							Node_Structure new_copy = Copied_Folder.Duplicate_Folder(Copied_Folder.Get_Name());
//							if (new_copy != null) {
//
//								temp.Add_Child(new_copy);
//
//							}
//
//						}
							if (ref > 0) {

								Current_Tree_Table.Current_Countainer.Root.Establish_Link();
								Current_Tree_Table.Handle_Tree_Table(Current_Selection);

							}

						}
					}
				}
			}
		});

		JMenuItem FolderNew_File = new JMenuItem("New File");
		KeyStroke controlN = KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK);
		FolderNew_File.setAccelerator(controlN);
		FolderNew_File.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Settings.Locked == false) {

					try {

						if (Current_Selection != null) {
							New_Pass_Jdialog();

						}
					} catch (Exception e2) {
						// TODO: handle exception
						System.err.println(e2);
					}
				}

			}
		});
		JMenuItem FolderDelete = new JMenuItem("Delete Folder");
		KeyStroke controlX = KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK);
		FolderDelete.setAccelerator(controlX);
		FolderDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Settings.Locked == false) {

					try {

						if (Current_Selection != null) {

							String Temtemp = "Are You Sure You Want To Delete This Folder :"
									+ Current_Selection.Get_Name() + "\r\n" + " Contains : "
									+ (Current_Selection.Folder_Size() - 1) + " Folders And "
									+ Current_Selection.Files_Size() + " Files .";

							int result = JOptionPane.showConfirmDialog(frmHarpocrates, Temtemp, "Delete Folder",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.YES_OPTION) {

								Current_Selection.Delete_Folder();

								Current_Tree_Table.Current_Countainer.Root.Establish_Link();

								Current_Tree_Table.Clear();
								Current_Tree_Table.Handle_Tree_Table(Current_Selection);

							} else if (result == JOptionPane.NO_OPTION) {

							}

						}
					} catch (Exception e2) {
						// TODO: handle exception
						System.err.println(e2);
					}

				}
			}
		});
		JMenuItem FolderRefresh = new JMenuItem("Refresh");
		KeyStroke controlR = KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK);
		FolderRefresh.setAccelerator(controlR);
		FolderRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Settings.Locked == false) {

					Current_Tree_Table.Handle_Tree_Table(Current_Selection);
					// Update Table
				}

			}
		});

		// Creat Folder
		JMenu New_Folder = new JMenu("New Folder");
		JTextField New_FolderJText = new JTextField();
		New_Folder.add(New_FolderJText);
		JButton New_Folder_Btn = new JButton("Creat Folder");
		New_Folder_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Current_Selection != null && Settings.Locked == false) {

					if (New_FolderJText.getText() != "" && New_FolderJText.getText().toString().length() != 0) {

						if (Current_Selection.Children.containsKey(New_FolderJText.getText()) == false) {

							Node_Structure New = Current_Selection.Add_New_Child(New_FolderJText.getText());

							Current_Selection.Visual_Node.add(New.Visual_Node);

							Current_Tree_Table.Clear();
							Current_Tree_Table.Handle_Tree_Table(Current_Selection);

							Current_Stats.Created_Folders++;

						}

					}

				}

			}
		});
		New_Folder.add(New_Folder_Btn);
		Folder_menu.add(New_Folder);

		// Rename Folder
		JMenu Rename_Folder = new JMenu("Rename Folder");
		JTextField Rename_FolderJText = new JTextField();
		Rename_Folder.add(Rename_FolderJText);
		JButton Rename_Folder_Btn = new JButton("Rename Folder");
		Rename_Folder_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Current_Selection != null && Settings.Locked == false) {

					if (Rename_FolderJText.getText() != "" && Rename_FolderJText.getText().toString().length() != 0) {

						if (Current_Selection.Get_Parent().Children
								.containsKey(Rename_FolderJText.getText()) == false) {

							Current_Selection.Rename_Node(Rename_FolderJText.getText());

							Current_Tree_Table.Refresh();

							Current_Stats.Modified_Folders++;

						}

					}

				}

			}
		});
		Rename_Folder.add(Rename_Folder_Btn);
		Folder_menu.add(Rename_Folder);

		Folder_menu.add(Foldercopy);
		Folder_menu.add(Folderpaste);
		// Folder_menu.add(FolderNew_Folder);
		Folder_menu.add(FolderNew_File);
		Folder_menu.add(FolderDelete);
		Folder_menu.add(FolderRefresh);

		JMenuItem Filecopy = new JMenuItem("Copy file");
		Filecopy.setAccelerator(controlC);
		Filecopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// system.out.println("Copy file");

				try {

					if (Current_Selection_file != null) {
						Node_File new_copy = new Node_File(Current_Selection_file);

						Copied_File = new_copy;
						Copied_Folder = null;
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.err.println(e2);
				}

			}
		});
		JMenuItem FileDelete = new JMenuItem("File Delete");
		FileDelete.setAccelerator(controlX);
		FileDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if (Current_Selection_file != null) {

						String Temtemp = "Are You Sure You Want To Delete This PassWord :"
								+ Current_Selection_file.getName() + "\r\n" + " Made : "
								+ Current_Selection_file.getTime_Created() + " for : " + Current_Selection_file.getUrl()
								+ " .";

						int result = JOptionPane.showConfirmDialog(frmHarpocrates, Temtemp, "File Delete",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (result == JOptionPane.YES_OPTION) {

							Current_Selection_file.Delete_File();
							Current_Tree_Table.Current_Countainer.Root.Establish_Link();
							if (Settings.Locked) {

								if (Settings.Locked) {
									Current_Tree_Table.Clear();

									List<Node_File> Fav_List = Current_Tree_Table.Current_Countainer.Root
											.Compact_Favorite_Files();

									if (Fav_List.size() != 0) {

										// Load favorite into tree
										Current_Tree_Table.Handle_Tree_Table(Current_Selection);

										// Load favorite into table
										Current_Tree_Table.Clear();
										Current_Tree_Table.Handle_Tree_Table(Current_Selection);

										Current_Tree_Table.Table.setDefaultEditor(Object.class, null);

										// Disable Components

									}

								}

							} else {
								Current_Tree_Table.Clear();
								Current_Tree_Table.Handle_Tree_Table(Current_Selection);

							}

						} else if (result == JOptionPane.NO_OPTION) {

						}

					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.err.println(e2);
				}

			}
		});

		JMenuItem FileEdit = new JMenuItem("File Edit");
		KeyStroke controlE = KeyStroke.getKeyStroke("E");
		FileEdit.setAccelerator(controlE);
		FileEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if (Current_Selection_file != null) {

						Edit_Pass_Jdialog(Current_Selection_file);

					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.err.println(e2);
				}

			}
		});

		JMenuItem FileView = new JMenuItem("File View");
		KeyStroke controlView = KeyStroke.getKeyStroke("V");
		FileView.setAccelerator(controlView);
		FileView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if (Current_Selection_file != null) {

						View_Pass_Jdialog(Current_Selection_file);

					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.err.println(e2);
				}
			}
		});
		JMenuItem FileRefresh = new JMenuItem("Refresh");
		FileRefresh.setAccelerator(controlR);
		FileRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Settings.Locked == false) {

					Current_Tree_Table.Handle_Tree_Table(Current_Selection);

				}

			}
		});

		File_menu.add(Filecopy);
		File_menu.add(FileDelete);
		File_menu.add(FileEdit);
		File_menu.add(FileView);
		File_menu.add(FileRefresh);

		MouseAdapter TreeLi = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// right mouse click event

				if (Current_Tree_Table.Current_Countainer != null) {

					if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {

						TreePath selPath = Current_Tree_Table.Tree.getPathForLocation(e.getX(), e.getY());
						int selRow = Current_Tree_Table.Tree.getRowForLocation(e.getX(), e.getY());
						Current_Tree_Table.Tree.setSelectionPath(selPath);
						if (selRow > -1) {
							Current_Tree_Table.Tree.setSelectionRow(selRow);

							DefaultMutableTreeNode node = (DefaultMutableTreeNode) Current_Tree_Table.Tree
									.getLastSelectedPathComponent();
							Object temp = node.getUserObject();
							if (temp != null) {

								if (temp instanceof Node_File) {

									File_menu.show(Current_Tree_Table.Tree, e.getX(), e.getY());
									// system.out.println("Is _file");

								} else if (temp instanceof Node_Structure) {
									Folder_menu.show(Current_Tree_Table.Tree, e.getX(), e.getY());
									// system.out.println("Is _Folder");

								} else if (temp instanceof String) {

									System.err.println("Is_String");
								}
							}

						}

					}
				}
			}
		};

		MouseAdapter TableLi = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (Current_Tree_Table.Current_Countainer != null) {

					// right mouse click event
					if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {

						Folder_menu.show(Current_Tree_Table.Table, e.getX(), e.getY());

						int r = Current_Tree_Table.Table.rowAtPoint(e.getPoint());
						int c = Current_Tree_Table.Table.columnAtPoint(e.getPoint());

						if ((r >= 0 && r < Current_Tree_Table.Table.getRowCount())
								&& ((c >= 0 && c < Current_Tree_Table.Table.getColumnCount()))) {

							// system.out.println(r + "" + c);
							Current_Tree_Table.Table.setRowSelectionInterval(r, r);
							Current_Tree_Table.Table.setColumnSelectionInterval(c, c);

							Object temptemp = Current_Tree_Table.Table.getModel().getValueAt(
									Current_Tree_Table.Table.getSelectedRow(),
									Current_Tree_Table.Table.getSelectedColumn());

							if (temptemp instanceof Node_File) {
								File_menu.show(Current_Tree_Table.Table, e.getX(), e.getY());
								// system.out.println("Is _file");

							} else if (temptemp instanceof Node_Structure) {
								Folder_menu.show(Current_Tree_Table.Table, e.getX(), e.getY());
								// system.out.println("Is _Folder");

							}

						} else {
							Current_Tree_Table.Table.clearSelection();
							// system.out.println("No");

						}

						int rowindex = Current_Tree_Table.Table.getSelectedRow();
						if (rowindex < 0)
							return;
						if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {

							// system.out.println("Yess table selected meneu");

						}

					}
				}
			}
		};

		Current_Tree_Table.Tree.addMouseListener(TreeLi);
		Current_Tree_Table.Table.addMouseListener(TableLi);

	}

	// ____________________Jdialog________________________________________________________

	private int Abondone_Jdialog() {

		String Temtemp = "- Modified_Folders : " + Current_Stats.Modified_Folders + "\r\n" + "- Modified_Passwords : "
				+ Current_Stats.Modified_Passwords + "\r\n" + "- Created_Folders : " + Current_Stats.Created_Folders
				+ "\r\n" + "- Created_Passwords : " + Current_Stats.Created_Passwords + "\r\n" + "- Deleted_Folders : "
				+ Current_Stats.Deleted_Folders + "\r\n" + "- Deleted_Passwords : " + Current_Stats.Deleted_Passwords
				+ "\r\n" + "\r\n" + "- Final Password Number : "
				+ Current_Tree_Table.Current_Countainer.Root.Files_Size() + "\r\n" + "- Initiale_File_Size"
				+ Current_Stats.Initiale_File_Size + "\r\n" + "Do You Want To Abandon The Current Data ?";

		int result = JOptionPane.showConfirmDialog(frmHarpocrates, Temtemp, "Abandon File", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);

		return result;
	}

	private int Save_Jdialog() {

		String Temtemp = "- Modified_Folders : " + Current_Stats.Modified_Folders + "\r\n" + "- Modified_Passwords : "
				+ Current_Stats.Modified_Passwords + "\r\n" + "- Created_Folders : " + Current_Stats.Created_Folders
				+ "\r\n" + "- Created_Passwords : " + Current_Stats.Created_Passwords + "\r\n" + "- Deleted_Folders : "
				+ Current_Stats.Deleted_Folders + "\r\n" + "- Deleted_Passwords : " + Current_Stats.Deleted_Passwords
				+ "\r\n" + "\r\n" + "- Final Password Number : "
				+ Current_Tree_Table.Current_Countainer.Root.Files_Size() + "\r\n" + "- Initiale_File_Size"
				+ Current_Stats.Initiale_File_Size + "\r\n" + "Do You Want To Overwrite The Original Save ?";

		int result = JOptionPane.showConfirmDialog(frmHarpocrates, Temtemp, "Save File", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);

		return result;
	}

	private void New_Pass_Jdialog() {

		try {

			Jdialog_Answer_Imp imp = new Jdialog_Answer_Imp();
			imp.Target_Folder = Current_Selection;
			New_Password_Jdialog question = new New_Password_Jdialog(imp);
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e);
		}

	}

	private void Edit_Pass_Jdialog(Node_File Temp) {

		try {

			Edit_Password_Jdialog question = new Edit_Password_Jdialog(Temp);

			question.Current_Stats = Current_Stats;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	private void View_Pass_Jdialog(Node_File Temp) {

		try {

			View_Password_Jdialog question = new View_Password_Jdialog(Temp);

			question.Current_Stats = Current_Stats;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	private void New_Data_Base_Jdialog() {

		try {

			Jdialog_Data_Base_Imp imp = new Jdialog_Data_Base_Imp();
			Data_Base_Creation_Jdialog question = new Data_Base_Creation_Jdialog(imp);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	private void Custom_New_Data_Base_Jdialog(String Name) {

		try {

			Custom_Jdialog_Data_Base_Imp imp = new Custom_Jdialog_Data_Base_Imp();
			Custom_Data_Base_Creation_Jdialog question = new Custom_Data_Base_Creation_Jdialog(imp, Name);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	private void Login_Jdialog(String A_Name) {

		try {

			Jdialog_Login_Imp imp = new Jdialog_Login_Imp();
			Login_Jdialog question = new Login_Jdialog(imp, A_Name);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	private void Custom_Login_Jdialog(String A_Name) {

		try {

			Custom_Jdialog_Login_Imp imp = new Custom_Jdialog_Login_Imp();
			Custom_Login_Jdialog question = new Custom_Login_Jdialog(imp, A_Name);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	private void PassLogin_Jdialog(String A_Name) {

		try {

			PassWord_Data_Base_Creation_Jdialog question = new PassWord_Data_Base_Creation_Jdialog(
					Current_Tree_Table.Current_Countainer, A_Name);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

// ____________________File Choser_______________________________________________________

	private File File_ChoserCSV(String Title) {

		FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma Separated Values", "CSV");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter);
		fileChooser.setDialogTitle(Title);

		int returnValue = fileChooser.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			// system.out.println(selectedFile.getAbsolutePath());

			return selectedFile;
		} else {

			return null;

		}
	}

	private File File_Choser() {

		FileNameExtensionFilter filter = new FileNameExtensionFilter("Encrypted File", "Enc");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter);

		int returnValue = fileChooser.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			// system.out.println(selectedFile.getAbsolutePath());

			return selectedFile;
		} else {

			return null;

		}
	}

	private File File_Choser_File() {

		FileNameExtensionFilter filter = new FileNameExtensionFilter("Encrypted File", "Enc");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(filter);

		int returnValue = fileChooser.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			// system.out.println(selectedFile.getAbsolutePath());

			String path = fileChooser.getSelectedFile().getAbsolutePath();
			String filename = fileChooser.getSelectedFile().getName();

			if (path.length() == 0 && filename.length() == 0) {

				return File_Choser_File();
			}

			if (fileChooser.getSelectedFile().getAbsolutePath().length() != 0
					&& fileChooser.getSelectedFile().getAbsolutePath().endsWith(".Enc")) {

				return fileChooser.getSelectedFile();
			} else if (fileChooser.getSelectedFile().getAbsolutePath().length() != 0) {
				return new File(fileChooser.getSelectedFile().getAbsoluteFile() + ".Enc");
			}

		} else if (returnValue == JFileChooser.CANCEL_OPTION) {

			return null;

		} else {

			return null;
		}
		return null;

	}

	// _________________Operations______________________________________________________

	private void Auto_Load() {

		try {

			System.err.println("Auto Load Data : ");

			// system.out.println("===========================================================");

			if (Load_Save.isValidPath(Favorit_Location_List_Model.getElementAt(0))) {

				Path a_path = Paths.get(Favorit_Location_List_Model.getElementAt(0));

				Login_Jdialog(a_path.getFileName().toString());

				if (Current_Tree_Table.Current_Countainer != null) {

					Load_Save.Load(Favorit_Location_List_Model.getElementAt(0), Current_Tree_Table.Current_Countainer);

					if (Current_Tree_Table.Current_Countainer.is_Valide()) {

						Current_Stats.Initiale_File_Size = Current_Tree_Table.Current_Countainer.Root.Files_Size();

						Data_Name_textfield.setText(
								Paths.get(Favorit_Location_List_Model.getElementAt(0)).getFileName().toString());

						Data_Name_textfield.setText(a_path.getFileName().toString());

						Current_File = a_path.toFile();
						Current_Tree_Table.Handle_Tree_Table(Current_Tree_Table.Current_Countainer.Root);

						Favorit_Location_List.setSelectedIndex(0);

					}

				}
			}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e);
		}

	}

	private static boolean isValidPath(String path) {
		try {
			Paths.get(path);
		} catch (InvalidPathException | NullPointerException ex) {
			return false;
		}

		if (path.endsWith(".Enc")) {

			return true;

		} else {

			return false;

		}
	}

	private static FlatLaf GetLookFeel(String Temp) {

		if (Temp != "") {

			try {

				FlatLaf test = null;
				switch (Temp) {
				case "Light":
					// code block
					test = new FlatLightLaf();
					UIManager.setLookAndFeel(new FlatLightLaf());

					break;
				case "IntelliJ":
					// code block
					test = new FlatIntelliJLaf();
					UIManager.setLookAndFeel(new FlatIntelliJLaf());

					break;
				case "Dark":
					// code block
					test = new FlatDarkLaf();
					UIManager.setLookAndFeel(new FlatDarkLaf());

					break;
				case "Darcula":
					// code block
					UIManager.setLookAndFeel(new FlatDarculaLaf());

					break;
				case "DeepOcean":
					// code block

					UIManager.setLookAndFeel(new FlatMaterialDeepOceanIJTheme());

					break;
				case "Carbon":
					// code block
					UIManager.setLookAndFeel(new FlatCarbonIJTheme());

					break;
				case "Cyan":
					// code block
					UIManager.setLookAndFeel(new FlatCyanLightIJTheme());

					break;
				case "Midnight Blue":
					// code block
					UIManager.setLookAndFeel(new FlatGradiantoMidnightBlueIJTheme());

					break;
				case "HiberbeeDark":
					// code block
					UIManager.setLookAndFeel(new FlatHiberbeeDarkIJTheme());

					break;
				case "Monocai":
					// code block
					UIManager.setLookAndFeel(new FlatMonocaiIJTheme());

					break;
				case "SolarizedDark":
					// code block
					UIManager.setLookAndFeel(new FlatSolarizedDarkIJTheme());

					break;
				case "SolarizedLight":
					// code block
					UIManager.setLookAndFeel(new FlatSolarizedLightIJTheme());

					break;
				case "DarkPurple":
					// code block
					UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme());

					break;

				case "Cobalt":
					// code block
					UIManager.setLookAndFeel(new FlatCobalt2IJTheme());

					break;
				case "Arc":
					// code block
					UIManager.setLookAndFeel(new FlatArcIJTheme());

					break;

				case "Arc Orange":
					// code block
					UIManager.setLookAndFeel(new FlatArcOrangeIJTheme());

					break;

				default:
					// code block
					UIManager.setLookAndFeel(test);

					break;

				}

			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return null;
	}

	// ______________________Font Builder____________________________________

	public void Build_Font_Btn(JPanel Target) {

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		Font[] allFonts = ge.getAllFonts();
		Map<String, Font> TEST = new HashMap<>();
		for (int i = 0; i < allFonts.length; i++) {
			if (allFonts[i].isPlain() && allFonts[i].isBold() == false && allFonts[i].isItalic() == false) {

				String Name = allFonts[i].getFontName(Locale.US);
				if (Name.contains("Bold") == false && Name.contains("bold") == false && Name.contains("Italic") == false
						&& Name.contains("italic") == false) {

					TEST.put(allFonts[i].getFontName(Locale.US), allFonts[i]);
				}
			}

		}
		Font[] Final = new Font[TEST.size()];

		int inc = 0;
		for (java.util.Map.Entry<String, Font> entry : TEST.entrySet()) {
			Final[inc] = entry.getValue();

			inc++;
		}

		for (Font font : Final) {

			JButton test = new JButton(font.getFontName(Locale.US));
			test.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Settings.Font_Name = test.getText();
					Font_Handler.changeFont(frmHarpocrates);

				}
			});
			Target.add(test);

		}

	}

	// ________________________________________________________________________________

	private void Add_To_Fav_Path(File Path) {

		if (Auto_Save_Path_CheckBox.isSelected()) {

			// ADD this File Path to Favorite Path List
			if (Favorit_Location_List_Model.getSize() == 0) {
				Favorit_Location_List_Model.addElement(Path.getAbsolutePath().toString());
				Favorit_Location_List.setModel(Favorit_Location_List_Model);

			} else {

				int ref = 0;
				for (int i = 0; i < Favorit_Location_List_Model.getSize(); i++) {
					Object o = Favorit_Location_List_Model.getElementAt(i);
					if (o.toString().equals(Path.getAbsolutePath().toString())) {
						ref++;
					}
				}

				if (ref == 0) {
					Favorit_Location_List_Model.addElement(Path.getAbsolutePath().toString());
					Load_Save.Save_Favorite_DataBase(Favorit_Location_List_Model);
					Favorit_Location_List.setModel(Favorit_Location_List_Model);

				}
			}
		}

	}

	// Avoided (complexity raisons)
	// __________________Multiple selection from tree________________________

//	System.out.println(Current_Tree_Table.Tree.getSelectionCount());
//	Current_Tree_Table.Tree.getSelectionPaths();
//
//	for (int i = 0; i < Current_Tree_Table.Tree.getSelectionPaths().length; i++) {
//		DefaultMutableTreeNode node = (DefaultMutableTreeNode) Current_Tree_Table.Tree
//				.getSelectionPaths()[i].getLastPathComponent();
//
//		if (node.getUserObject() instanceof Node_File) {
//
//			Node_File temp = (Node_File) node.getUserObject();
//
//			System.out.println(temp.getName());
//
//		} else if (node.getUserObject() instanceof Node_Structure) {
//
//			Node_Structure temp = (Node_Structure) node.getUserObject();
//
//			System.out.println(temp.Get_Name());
//
//		}
//	}
	// ________________________________________________________________________________
	// ________________________________________________________________________________
	// ________________________________________________________________________________

	// Tutorial Source https://www.youtube.com/watch?v=HEyrMXEmqdI
	// alternative is to erase this class and the one inside password gui
	// And replace the argument whit a node structure when jdialog is done it will
	// creat a node file parente
	// it to the sent argument and i have to do is refresh

	// ____________________Interface allow safe return of data from Jdialog________

	private class Jdialog_Answer_Imp implements Jdialog_Answer {

		Node_Structure Target_Folder;

		@Override
		public void GetResponse(Node_File Temp_File) {

			// system.out.println(1);
			if (Current_Selection != null) {
				// system.out.println(2);

				if (Temp_File != null) {
					// system.out.println(3);

					Current_Selection_file = Temp_File;

					Target_Folder.Add_File(Temp_File);
					Target_Folder.Visual_Node.add(Current_Selection_file.Visual_Node);
//					System.err.println(Current_Selection_file);
//
//					System.err.println(Temp_File);
//					System.err.println(Temp_File.getName());
//					System.err.println(Temp_File.Get_Parent().Get_Name());
//
//					System.err.println(Target_Folder.File_Children.get(Temp_File.getName()));
//
//					System.err.println(Target_Folder.File_Children.keySet());
//					System.err.println(Target_Folder.File_Children.values());

					Current_Tree_Table.Handle_Tree_Table(Current_Selection);

					Current_Stats.Created_Passwords++;
				}
			}
		}

	}

	private class Jdialog_Data_Base_Imp implements Jdialog_Data_Base {

		@Override
		public void GetResponse(Node_Container Temp_File) {

			if (Temp_File != null) {

				Current_Tree_Table.Current_Countainer = Temp_File;

				Current_Tree_Table.Handle_Tree_Table(Current_Selection);

				Current_Stats = new Stats();
			}

		}

	}

	private class Custom_Jdialog_Data_Base_Imp implements Custom_Jdialog_Data_Base {

		@Override
		public void GetResponse(Node_Container Temp_File) {

			Exported_Container = null;
			if (Temp_File != null) {

				Exported_Container = Temp_File;
			}

		}

	}

	private class Jdialog_Login_Imp implements Jdialog_Login {

		@Override
		public void GetResponse(String Temp_File) {

			if (Temp_File != null && Temp_File.length() != 0 && Current_Tree_Table != null) {

				Current_Tree_Table.Current_Countainer = new Node_Container(Temp_File);

			}

		}

	}

	private class Custom_Jdialog_Login_Imp implements Custom_Jdialog_Login {

		@Override
		public void GetResponse(String Temp_File) {
			Imported_Container = null;
			if (Temp_File != null && Temp_File.length() != 0) {

				Imported_Container = new Node_Container(Temp_File);

			}

		}

	}
}
