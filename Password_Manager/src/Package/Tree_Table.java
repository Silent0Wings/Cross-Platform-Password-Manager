package Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import Gui.CustomTableCellRenderer;
import Package.Settings.Sort_Type;

@SuppressWarnings("unused")
public class Tree_Table {

	// errore cant update boxes from table builder !!!!!
	// Possible raisons calling the build table methode from the tree listener
	// trigers a loop
	// wher triggering the tree calls the table builder and update box trigers sort
	// and typ box listeners wher thoses 2 actions listener trigger tree build and
	// it keeps going !

	/// Solution !!
	// Calling update inside thoses action listeners dosent cause a nesting
	// meaning calling update that trigers a change dosent affect a action listener
	/// who is still on .

	public JTree Tree;
	public JTable Table;
	public Node_Container Current_Countainer;

	public Node_Structure Operation_Folder;

	public JComboBox<String> Sorting_Box;
	public JComboBox<String> Type_Box;

	public Tree_Table() {

		Tree = new JTree(new DefaultMutableTreeNode());
		Table = new JTable(new DefaultTableModel(7, 7));
		Table.setDefaultEditor(Object.class, null);

	}

	// _________________________Builds___________________________________________

	public void Handle_Tree_Table(Node_Structure Curr) {

		if (Current_Countainer != null) {
			// Update_Boxes();

			Clear();
			switch (Settings.type) {
			case Default:
				Tree.setModel(new DefaultTreeModel(Tree_Builder()));
				Table.setModel(Construct_Table(Curr));
				break;
			case Favorite:
				if (Current_Countainer.Root.Favorite_Files_Size() != 0) {

					List<Node_File> Fav_List = Current_Countainer.Root.Compact_Favorite_Files();
					Tree.setModel(new DefaultTreeModel(Main_Tree_Builder(Fav_List)));
					Table.setModel(Main_Construct_Table(Fav_List));
				} else {
					Settings.type = Sort_Type.Default;
					Handle_Tree_Table(Curr);

				}
				break;
			case Search:

				if (Settings.Search_Input != null && Settings.Search_Input != "" && Settings.Search_Input.length() != 0
						&& Current_Countainer.Root.Size_Of_Occurence(Settings.Search_Input) != 0) {
					List<Node_File> Search_List = Current_Countainer.Root.Compact_Search_Files(Settings.Search_Input);
					Tree.setModel(new DefaultTreeModel(Main_Tree_Builder(Search_List)));
					Table.setModel(Main_Construct_Table(Search_List));

				} else {

					Settings.type = Sort_Type.Default;
					Handle_Tree_Table(Curr);

				}
				break;
			case Expired:
				if (Current_Countainer.Root.Expired_Files_Size() != 0) {
					List<Node_File> Search_List = Current_Countainer.Root.Compact_Expired_Files();

					Tree.setModel(new DefaultTreeModel(Main_Tree_Builder(Search_List)));
					Table.setModel(Main_Construct_Table(Search_List));
				} else {
					Settings.type = Sort_Type.Default;
					Handle_Tree_Table(Curr);
				}

				break;
			case Strong:
				if (Current_Countainer.Root.Strong_Files_Size() != 0) {
					List<Node_File> Strong_List = Current_Countainer.Root.Compact_Strong_Files();

					Tree.setModel(new DefaultTreeModel(Main_Tree_Builder(Strong_List)));
					Table.setModel(Main_Construct_Table(Strong_List));
				} else {
					Settings.type = Sort_Type.Default;
					Handle_Tree_Table(Curr);
				}

				break;
			case Weak:
				if (Current_Countainer.Root.Weak_Files_Size() != 0) {
					List<Node_File> Weak_List = Current_Countainer.Root.Compact_Weak_Files();

					Tree.setModel(new DefaultTreeModel(Main_Tree_Builder(Weak_List)));
					Table.setModel(Main_Construct_Table(Weak_List));
				} else {
					Settings.type = Sort_Type.Default;
					Handle_Tree_Table(Curr);
				}

				break;

			default:
				// code block
			}
			// Update_Boxes();
			Refresh();
			Table.setShowGrid(true);

		}

	}

	public void Handle_Tree_Builder() {

		if (Current_Countainer != null) {
			// Update_Boxes();

			Clear_Tree();
			switch (Settings.type) {
			case Default:
				Tree.setModel(new DefaultTreeModel(Tree_Builder()));
				break;
			case Favorite:
				if (Current_Countainer.Root.Favorite_Files_Size() != 0) {

					List<Node_File> Fav_List = Current_Countainer.Root.Compact_Favorite_Files();
					Tree.setModel(new DefaultTreeModel(Main_Tree_Builder(Fav_List)));
				} else {
					Settings.type = Sort_Type.Default;
					Handle_Tree_Builder();

				}
				break;
			case Search:

				if (Settings.Search_Input != "" && Settings.Search_Input.length() != 0
						&& Current_Countainer.Root.Size_Of_Occurence(Settings.Search_Input) != 0) {
					List<Node_File> Search_List = Current_Countainer.Root.Compact_Search_Files(Settings.Search_Input);

					Tree.setModel(new DefaultTreeModel(Main_Tree_Builder(Search_List)));
				} else {

					Settings.type = Sort_Type.Default;
					Handle_Tree_Builder();

				}
				break;
			case Expired:
				if (Current_Countainer.Root.Expired_Files_Size() != 0) {
					List<Node_File> Search_List = Current_Countainer.Root.Compact_Expired_Files();

					Tree.setModel(new DefaultTreeModel(Main_Tree_Builder(Search_List)));
				} else {
					Settings.type = Sort_Type.Default;
					Handle_Tree_Builder();
				}

				break;
			case Strong:
				if (Current_Countainer.Root.Strong_Files_Size() != 0) {
					List<Node_File> Strong_List = Current_Countainer.Root.Compact_Strong_Files();

					Tree.setModel(new DefaultTreeModel(Main_Tree_Builder(Strong_List)));
				} else {
					Settings.type = Sort_Type.Default;
					Handle_Tree_Builder();
				}

				break;
			case Weak:
				if (Current_Countainer.Root.Weak_Files_Size() != 0) {
					List<Node_File> Weak_List = Current_Countainer.Root.Compact_Weak_Files();

					Tree.setModel(new DefaultTreeModel(Main_Tree_Builder(Weak_List)));
				} else {
					Settings.type = Sort_Type.Default;
					Handle_Tree_Builder();
				}

				break;

			default:
				// code block
			}
			// Update_Boxes();
			Refresh_Tree();
		}

	}

	public void Handle_Table_Builder(Node_Structure Curr) {

		if (Current_Countainer != null) {
			// Update_Boxes();

			Clear_Table();
			switch (Settings.type) {
			case Default:
				Table.setModel(Construct_Table(Curr));
				break;
			case Favorite:
				if (Current_Countainer.Root.Favorite_Files_Size() != 0) {

					List<Node_File> Fav_List = Current_Countainer.Root.Compact_Favorite_Files();
					Table.setModel(Main_Construct_Table(Fav_List));
				} else {
					Settings.type = Sort_Type.Default;
					Handle_Table_Builder(Curr);

				}
				break;
			case Search:

				if (Settings.Search_Input != "" && Settings.Search_Input.length() != 0
						&& Current_Countainer.Root.Size_Of_Occurence(Settings.Search_Input) != 0) {
					List<Node_File> Search_List = Current_Countainer.Root.Compact_Search_Files(Settings.Search_Input);

					Table.setModel(Main_Construct_Table(Search_List));
				} else {

					Settings.type = Sort_Type.Default;
					Handle_Table_Builder(Curr);

				}
				break;
			case Expired:
				if (Current_Countainer.Root.Expired_Files_Size() != 0) {
					List<Node_File> Search_List = Current_Countainer.Root.Compact_Expired_Files();

					Table.setModel(Main_Construct_Table(Search_List));
				} else {
					Settings.type = Sort_Type.Default;
					Handle_Table_Builder(Curr);
				}

				break;
			case Strong:
				if (Current_Countainer.Root.Strong_Files_Size() != 0) {
					List<Node_File> Strong_List = Current_Countainer.Root.Compact_Strong_Files();

					Table.setModel(Main_Construct_Table(Strong_List));
				} else {
					Settings.type = Sort_Type.Default;
					Handle_Table_Builder(Curr);
				}

				break;
			case Weak:
				if (Current_Countainer.Root.Weak_Files_Size() != 0) {
					List<Node_File> Weak_List = Current_Countainer.Root.Compact_Weak_Files();

					Table.setModel(Main_Construct_Table(Weak_List));
				} else {
					Settings.type = Sort_Type.Default;
					Handle_Table_Builder(Curr);
				}

				break;

			default:
				// code block
			}
			Refresh_Table();
			// Update_Boxes();
		}
	}

	// ___________________________Tree_______________________________________________

	private DefaultMutableTreeNode Tree_Builder() {

		if (Current_Countainer != null) {
			Current_Countainer.Root.Establish_Link();

			// Favorite_Construct_Table

			switch (Settings.sort) {
			case Default:
				// code block

				return Current_Countainer.Root.Construct_Jtree_Main();
			case Name:
				// code block
				return Current_Countainer.Root.Construct_Jtree_Main();

			case Date_Modified:
				// code block
				return Current_Countainer.Root.Construct_Jtree_Main();

			case Date_Created:
				// code block
				return Current_Countainer.Root.Construct_Jtree_Main();

			case Date_Expired:
				// code block
				return Current_Countainer.Root.Construct_Jtree_Main();

			default:
				// code block
			}

		}

		return null;

	}

	private DefaultMutableTreeNode Main_Tree_Builder(List<Node_File> Source_List) {

		if (Source_List.size() != 0) {

			switch (Settings.sort) {
			case Default:
				break;
			case Name:
				if (Settings.Sort_Order == 0) {

					Source_List = Handle_Sorting.Ascending_File_Sorting_Name(Source_List);
				} else {
					Source_List = Handle_Sorting.Descending_File_Sorting_Name(Source_List);
				}
				break;
			case Date_Modified:
				if (Settings.Sort_Order == 0) {

					Source_List = Handle_Sorting.Ascending_File_Sorting_By_Date_Modified(Source_List);
				} else {
					Source_List = Handle_Sorting.Descending_File_Sorting_By_Date_Modified(Source_List);
				}
				break;
			case Date_Created:
				if (Settings.Sort_Order == 0) {

					Source_List = Handle_Sorting.Ascending_File_Sorting_By_Date_Created(Source_List);
				} else {
					Source_List = Handle_Sorting.Descending_File_Sorting_By_Date_Created(Source_List);
				}
				break;
			case Date_Expired:
				if (Settings.Sort_Order == 0) {

					Source_List = Handle_Sorting.Ascending_File_Sorting_By_Date_Expiration(Source_List);
				} else {
					Source_List = Handle_Sorting.Descending_File_Sorting_By_Date_Expiration(Source_List);
				}
				break;
			default:
				// code block
			}

			if (Source_List != null) {

				if (Source_List.size() > 0) {
					Operation_Folder = new Node_Structure(Settings.type.name() + " Root:");
					Operation_Folder.Creat_Visual_Components();

					Operation_Folder.Visual_Node = new DefaultMutableTreeNode(Settings.type.name() + " Root:");
					Operation_Folder.Visual_Node.setUserObject(new Node_Structure(Settings.type.name() + " Root:"));
					for (int i = 0; i < Source_List.size(); i++) {

						Operation_Folder.Visual_Node.add(Source_List.get(i).Visual_Node);
						Operation_Folder.File_Children.put(Source_List.get(i).getName(), Source_List.get(i));
					}

					return Operation_Folder.Visual_Node;
				}
			}
		}
		return null;

	}

	// _______________________________Table___________________________________________

	private DefaultTableModel Construct_Table(Node_Structure Temp_Node) {

		if (Current_Countainer == null) {
			return null;
		}

		if (Table != null) {

			if (Temp_Node == null) {
				if (Current_Countainer != null) {

					Temp_Node = Current_Countainer.Root;

				} else {
					return null;
				}
			}

			int size = Temp_Node.Children.size() + Temp_Node.File_Children.size();
			//System.out.println("size 0 : " + size);

			if (size != 0) {

				if (size % 2 == 0) {
					// even
				} else {
					// odd
					size++;
				}

				int column;
				int rows;

				int tWidth = Table.getWidth();
				int tHeight = (Table.getHeight());

				if (tWidth == 0 || tHeight == 0) {
					return new DefaultTableModel();
				}

				//System.out.println("w" + tWidth + "H" + tHeight);

				int temp = tWidth / 100;

				//System.out.println("temp : " + temp);
				//System.out.println("size 1 : " + size);

				if (size <= temp) {

					//System.out.println("qsduqysduh");
					column = temp;
					rows = 1;

				} else {

					if (size % temp == 0) {
						rows = size / temp;

					} else {
						rows = size / temp + 1;

					}
					column = temp;
				}

				Object[] Temp_Data = new Object[size];

				int test_index = 0;

				List<Node_Structure> Folder_List = new ArrayList<>();
				List<Node_File> File_List = new ArrayList<>();

				for (String Temp : Temp_Node.Children.keySet()) {

					Folder_List.add(Temp_Node.Children.get(Temp));

				}
				for (String Temp : Temp_Node.File_Children.keySet()) {

					File_List.add(Temp_Node.File_Children.get(Temp));

				}

				switch (Settings.sort) {
				case Default:
					break;
				case Name:
					if (Settings.Sort_Order == 0) {

						Folder_List = Handle_Sorting.Ascending_Folder_Sorting_Name(Folder_List);
						File_List = Handle_Sorting.Ascending_File_Sorting_Name(File_List);
					} else {
						Folder_List = Handle_Sorting.Descending_Folder_Sorting_Name(Folder_List);
						File_List = Handle_Sorting.Descending_File_Sorting_Name(File_List);
					}
					break;
				case Date_Modified:
					if (Settings.Sort_Order == 0) {

						File_List = Handle_Sorting.Ascending_File_Sorting_By_Date_Modified(File_List);
					} else {
						File_List = Handle_Sorting.Descending_File_Sorting_By_Date_Modified(File_List);
					}
					break;
				case Date_Created:
					if (Settings.Sort_Order == 0) {

						File_List = Handle_Sorting.Ascending_File_Sorting_By_Date_Created(File_List);
					} else {
						File_List = Handle_Sorting.Descending_File_Sorting_By_Date_Created(File_List);
					}
					break;
				case Date_Expired:
					if (Settings.Sort_Order == 0) {

						File_List = Handle_Sorting.Ascending_File_Sorting_By_Date_Expiration(File_List);
					} else {
						File_List = Handle_Sorting.Descending_File_Sorting_By_Date_Expiration(File_List);
					}
					break;
				default:
					// code block
				}

				for (int i = 0; i < Folder_List.size(); i++) {

					Temp_Data[i] = Folder_List.get(i);
					test_index++;

				}

				for (int i = 0; i < File_List.size(); i++) {

					Temp_Data[test_index] = File_List.get(i);
					test_index++;

				}

				// System.err.println(Folder_List);
				//System.out.println(Arrays.toString(Temp_Data));
				//System.out.println("Rows " + rows + " Columns " + column);
				//System.out.println("Total Cells : " + rows * (column));

				Object[][] rowData;
				String[] columnNames = null;
				columnNames = new String[column];
				for (int i = 0; i < column; i++) {
					columnNames[i] = i + "";
				}

				//System.out.println(Arrays.toString(columnNames));

				Set<String> keys = Temp_Node.Children.keySet();
				String arr[] = new String[keys.size()];
				arr = keys.toArray(arr);

				rowData = new Object[rows][column];

				int Index = 0;
				for (int i = 0; i < rows; i++) {

					for (int z = 0; z < column; z++) {

						if (Index >= Temp_Data.length) {

							rowData[i][z] = null;
						} else {
							rowData[i][z] = Temp_Data[Index];

						}

						Index++;
					}

				}

				DefaultTableModel model = new DefaultTableModel(rowData, columnNames);

				//System.out.println("c" + model.getColumnCount() + "r" + model.getRowCount());

				return model;
			} else {

				DefaultTableModel model = new DefaultTableModel(0, 0);

				//System.out.println("c" + model.getColumnCount() + "r" + model.getRowCount());

				return model;
			}
		}

		return null;

	}

	private DefaultTableModel Main_Construct_Table(List<Node_File> File_List) {

		if (Table != null) {

			switch (Settings.sort) {
			case Default:
				break;
			case Name:
				if (Settings.Sort_Order == 0) {

					File_List = Handle_Sorting.Ascending_File_Sorting_Name(File_List);
				} else {
					File_List = Handle_Sorting.Descending_File_Sorting_Name(File_List);
				}
				break;
			case Date_Modified:
				if (Settings.Sort_Order == 0) {

					File_List = Handle_Sorting.Ascending_File_Sorting_By_Date_Modified(File_List);
				} else {
					File_List = Handle_Sorting.Descending_File_Sorting_By_Date_Modified(File_List);
				}
				break;
			case Date_Created:
				if (Settings.Sort_Order == 0) {

					File_List = Handle_Sorting.Ascending_File_Sorting_By_Date_Created(File_List);
				} else {
					File_List = Handle_Sorting.Descending_File_Sorting_By_Date_Created(File_List);
				}
				break;
			case Date_Expired:
				if (Settings.Sort_Order == 0) {

					File_List = Handle_Sorting.Ascending_File_Sorting_By_Date_Expiration(File_List);
				} else {
					File_List = Handle_Sorting.Descending_File_Sorting_By_Date_Expiration(File_List);
				}
				break;
			default:
				// code block
			}

			int size = File_List.size();
			//System.out.println("size 0 : " + size);

			if (size != 0) {

				if (size % 2 == 0) {
					// even
				} else {
					// odd
					size++;
				}

				int column;
				int rows;

				int tWidth = Table.getWidth();
				int tHeight = Table.getHeight();
				if (tWidth == 0 || tHeight == 0) {
					return new DefaultTableModel();
				}
				//System.out.println("w" + tWidth + "H" + tHeight);

				int temp = tWidth / 100;

				//System.out.println("temp : " + temp);
				//System.out.println("size 1 : " + size);

				if (size <= temp) {

					//System.out.println("qsduqysduh");
					column = temp;
					rows = 1;

				} else {

					if (size % temp == 0) {
						rows = size / temp;

					} else {
						rows = size / temp + 1;

					}
					column = temp;
				}

				Object[] Temp_Data = new Object[size];

				Temp_Data = File_List.toArray();

				// System.err.println(Folder_List);
				//System.out.println(Arrays.toString(Temp_Data));
				//System.out.println("Rows " + rows + " Columns " + column);
				//System.out.println("Total Cells : " + rows * (column));

				Object[][] rowData;
				String[] columnNames = null;
				columnNames = new String[column];
				for (int i = 0; i < column; i++) {
					columnNames[i] = i + "";
				}

				//System.out.println(Arrays.toString(columnNames));

				rowData = new Object[rows][column];

				int Index = 0;
				for (int i = 0; i < rows; i++) {

					for (int z = 0; z < column; z++) {

						if (Index >= Temp_Data.length) {

							rowData[i][z] = null;
						} else {
							rowData[i][z] = Temp_Data[Index];

						}

						Index++;
					}

				}

				DefaultTableModel model = new DefaultTableModel(rowData, columnNames);

				//System.out.println("c" + model.getColumnCount() + "r" + model.getRowCount());

				return model;
			} else {

				DefaultTableModel model = new DefaultTableModel(0, 0);

				//System.out.println("c" + model.getColumnCount() + "r" + model.getRowCount());

				return model;
			}
		}
		return null;

	}

	// Dont Use (Not implemented correctly)
	private DefaultTableModel Table_Whit_collomns(List<Node_File> File_List) {

		if (Table != null) {

			switch (Settings.sort) {
			case Default:
				break;
			case Name:
				if (Settings.Sort_Order == 0) {

					File_List = Handle_Sorting.Ascending_File_Sorting_Name(File_List);
				} else {
					File_List = Handle_Sorting.Descending_File_Sorting_Name(File_List);
				}
				break;
			case Date_Modified:
				if (Settings.Sort_Order == 0) {

					File_List = Handle_Sorting.Ascending_File_Sorting_By_Date_Modified(File_List);
				} else {
					File_List = Handle_Sorting.Descending_File_Sorting_By_Date_Modified(File_List);
				}
				break;
			case Date_Created:
				if (Settings.Sort_Order == 0) {

					File_List = Handle_Sorting.Ascending_File_Sorting_By_Date_Created(File_List);
				} else {
					File_List = Handle_Sorting.Descending_File_Sorting_By_Date_Created(File_List);
				}
				break;
			case Date_Expired:
				if (Settings.Sort_Order == 0) {

					File_List = Handle_Sorting.Ascending_File_Sorting_By_Date_Expiration(File_List);
				} else {
					File_List = Handle_Sorting.Descending_File_Sorting_By_Date_Expiration(File_List);
				}
				break;
			default:
				// code block
			}

			int size = File_List.size();
			//System.out.println("size 0 : " + size);

			if (size != 0) {

				int column = 4;
				int rows = File_List.size();

				Object[] Temp_Data = new Object[size];

				Temp_Data = File_List.toArray();

				// System.err.println(Folder_List);
				//System.out.println(Arrays.toString(Temp_Data));
				//System.out.println("Rows " + rows + " Columns " + column);
				//System.out.println("Total Cells : " + rows * (column));

				Object[][] rowData;
				String[] columnNames = null;
				columnNames = new String[column];
				for (int i = 0; i < column; i++) {
					columnNames[i] = i + "";
				}

				//System.out.println(Arrays.toString(columnNames));

				rowData = new Object[rows][column];

				int Index = 0;

				for (int i = 0; i < rows; i++) {

					rowData[i][0] = Temp_Data[Index];
					rowData[i][1] = ((Node_File) Temp_Data[Index]).getTime_Created();
					rowData[i][2] = ((Node_File) Temp_Data[Index]).getTitle();
					rowData[i][3] = ((Node_File) Temp_Data[Index]).getPassword();

					Index++;

				}

//				for (int i = 0; i < rows; i++) {
//
//					for (int z = 0; z < column; z++) {
//
//						if (Index >= Temp_Data.length) {
//
//							rowData[i][z] = null;
//						} else {
//							rowData[i][z] = Temp_Data[Index];
//
//						}
//
//						Index++;
//					}
//
//				}
				DefaultTableModel model = new DefaultTableModel(rowData, columnNames);

				//System.out.println("c" + model.getColumnCount() + "r" + model.getRowCount());

				return model;
			} else {

				DefaultTableModel model = new DefaultTableModel(0, 0);

				//System.out.println("c" + model.getColumnCount() + "r" + model.getRowCount());

				return model;
			}
		}
		return null;

	}

	// _________________________Operations_______________________________________

	public void Clear() {

		Operation_Folder = null;

		Clear_Tree();
		Clear_Table();
	}

	public void Clear_Tree() {

		DefaultTreeModel model = (DefaultTreeModel) Tree.getModel();
		if (model != null) {

			DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
			if (root != null) {

				if (root.getChildCount() != 0) {

					root.removeAllChildren();
				}
			}
			Tree.removeAll();
			model.setRoot(null);
			Tree.setModel(null);
			model.reload();
		}
	}

	public void Clear_Table() {

		DefaultTableModel model = (DefaultTableModel) Table.getModel();

		if (model != null) {

			model.getDataVector().removeAllElements();
			Table.removeAll();
			model.fireTableDataChanged();
		}

	}

	public void Refresh() {
		Refresh_Tree();
		Refresh_Table();
	}

	public void Refresh_Tree() {
		// update Tree
		DefaultTreeModel model = (DefaultTreeModel) Tree.getModel();
		if (model != null) {
			Update_Jtable_Cell_Rendrer();
			model.reload();
		}

	}

	public void Refresh_Table() {
		Table.setDefaultEditor(Object.class, null);
		DefaultTableModel model = (DefaultTableModel) Table.getModel();
		if (model != null) {

			model.fireTableDataChanged();
			Tree.repaint();
			Update_Jtable_Cell_Rendrer();
		}
	}

	public void Rebuild_Table(Node_Structure temp) {

		if (temp != null) {

			// Update Table
			Clear_Table();
			Table.setModel(Construct_Table(temp));
			Table.setDefaultEditor(Object.class, null);

			Update_Jtable_Cell_Rendrer();
		}

	}

	public void Update_Jtable_Cell_Rendrer() {

		for (int i = 0; i < Table.getColumnCount(); i++) {

			Table.getColumnModel().getColumn(i).setCellRenderer(new CustomTableCellRenderer());
		}
		Table.setRowHeight(100);
		Table.repaint();
		Table.revalidate();
	}

	public void Update_Boxes() {
		if (Type_Box != null) {

			switch (Settings.type) {
			case Default:
				Type_Box.setSelectedItem(Settings.Sort_Type.Default.name());
				break;
			case Expired:
				Type_Box.setSelectedItem(Settings.Sort_Type.Expired.name());

				break;
			case Favorite:
				Type_Box.setSelectedItem(Settings.Sort_Type.Favorite.name());

				break;
			case Search:
				Type_Box.setSelectedItem(Settings.Sort_Type.Search.name());

				break;
			case Strong:
				Type_Box.setSelectedItem(Settings.Sort_Type.Strong.name());

				break;
			case Weak:
				Type_Box.setSelectedItem(Settings.Sort_Type.Weak.name());

				break;
			default:
				// code block
			}
		}
		if (Sorting_Box != null) {

			switch (Settings.sort) {
			case Default:
				Sorting_Box.setSelectedItem(Settings.Sort.Default.name());
				break;
			case Date_Modified:
				Sorting_Box.setSelectedItem(Settings.Sort.Date_Modified.name());

				break;
			case Name:
				Sorting_Box.setSelectedItem(Settings.Sort.Name.name());

				break;

			default:
				// code block
			}
		}
	}
	// __________________________________________________________________________
}
