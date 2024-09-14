package Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class Node_Structure {

	private String Name;
	private String Link;
	private Node_Structure Parent;
	public boolean Virtual;
	public DefaultMutableTreeNode Visual_Node;

	private final Boolean Is_Root;

	public Map<String, Node_Structure> Children = new HashMap<>();
	public Map<String, Node_File> File_Children = new HashMap<>();

	// _____________________Creat Node Structure_______________________//

	// Creating a empty Node Structure
	public Node_Structure() {
		Is_Root = false;
		Creat_Visual_Components();

	}

	// Creating a empty Node Structure whit a Name
	public Node_Structure(String New_Name) {
		Is_Root = false;
		New_Name = Model.Integrity(New_Name);

		Name = New_Name;
		Creat_Visual_Components();

	}

	// Creating a Root Node Structure
	public Node_Structure(Boolean root) {
		Is_Root = true;
		Name = "Root";
		Link = "Root/";
		Parent = null;
		Visual_Node = new DefaultMutableTreeNode(this);
		Visual_Node.setUserObject(this);

	}

	// _____________________Adding Children to this structure_________________//

	// Add a Copy of a structure whit a new name
	public Node_Structure Add_New_Child(String New_Name, Node_Structure Copy) {

		New_Name = Model.Integrity(New_Name);
		if (Copy != null) {
			if (Children.containsKey(New_Name)) {

				return null;
			} else {
				Node_Structure New_Child = new Node_Structure();
				New_Child.Parent = this;
				New_Child.Set_Name(New_Name);
				New_Child.Link = Link + New_Name + "/";
				New_Child.Visual_Node = new DefaultMutableTreeNode(New_Name);
				New_Child.Visual_Node.setUserObject(New_Child);

				Children.put(Copy.Get_Name(), New_Child);

				return New_Child;

			}
		} else {

			return null;
		}

	}

	// Add a Copy of a structure whit the Same name
	public Node_Structure Add_New_Child(Node_Structure Target) {
		if (Children.containsKey(Model.Integrity(Target.Get_Name()))) {

			return null;
		} else {

			Node_Structure New_Child = new Node_Structure();

			Children.put(Model.Integrity(Model.Integrity(Target.Get_Name())), New_Child);
			New_Child.Parent = this;
			New_Child.Link = Link + Model.Integrity(Model.Integrity(Target.Get_Name())) + "/";
			if (New_Child.Visual_Node == null) {
				New_Child.Creat_Visual_Components();
			}

			return New_Child;
		}

	}

	// Add a New structure whit a new name
	public Node_Structure Add_New_Child(String New_Name) {

		New_Name = Model.Integrity(New_Name);
		Node_Structure New_Child = new Node_Structure();
		if (Children.containsKey(New_Name)) {

			return null;
		} else {

			New_Child.Set_Name(New_Name);
			New_Child.Link = Link + New_Name + "/";
			New_Child.Parent = this;
			if (New_Child.Visual_Node == null) {
				New_Child.Creat_Visual_Components();
			}
			Children.put(New_Name, New_Child);

			return New_Child;
		}

	}

	// Add a Structure to this one
	public void Add_Child(Node_Structure Target) {
		if (Children.containsKey(Target.Get_Name())) {

		} else {

			Children.put(Model.Integrity(Target.Get_Name()), Target);
			Target.Parent = this;

			Target.Link = Link + Model.Integrity(Target.Get_Name()) + "/";

			Target.Creat_Visual_Components();
		}

	}

	// Add a new file whit a new name
	public Node_File Add_File(String New_Name) {
		New_Name = Model.Integrity(New_Name);
		if (File_Children.containsKey(New_Name) == false) {

			Node_File New_File = new Node_File(New_Name, this);

			File_Children.put(New_Name, New_File);
			return New_File;

		} else {
			return null;

		}

	}

	// Add a file Directly to the list of file children
	public void Add_File(Node_File New_File) {

		if (File_Children.containsKey(New_File.getName()) == false) {

			File_Children.put(New_File.getName(), New_File);
			New_File.Set_Parent(this);

		} else {
		}

	}

	// Add DefaultMutableTreeNode and set the userobject
	public void Creat_Visual_Components() {

		this.Visual_Node = new DefaultMutableTreeNode(Model.Integrity(this.Get_Name()));
		this.Visual_Node.setUserObject(this);
		this.Visual_Node.setAllowsChildren(true);
	}

	// _____________________Getters and Setters_________________________________//

	public String Get_Link() {

		return Link;
	}

	public String Get_Name() {

		return Model.Integrity(Name);
	}

	public void Set_Name(String New_Name) {
		Name = Model.Integrity(New_Name);
	}

	// Getter for Parent
	public Node_Structure Get_Parent() {

		return Parent;
	}

	/*
	 * Set a new Parent to this folder (Only changes parent and link no affect to
	 * the children or to the references of other parents Possibility of double
	 * parenting so be carfule )
	 */
	public void Set_Parent(Node_Structure New_Parent) {
		Parent = New_Parent;
		Link = Parent.Link + Name + "/";

	}

	// return if this is a root
	public boolean Is_Root_() {

		return Is_Root;
	}

	// _____________________Operations________________________________________________//

	/*
	 * Joins all the contetnt of a node into another so its more like joining than
	 * combining
	 */
	public void Combine_Node(Node_Structure Box, Node_Structure Cat) {

		for (String Temp : Cat.Children.keySet()) {
			if (Box.Children.containsKey(Temp)) {

			} else {

				Box.Children.put(Temp, Cat.Children.get(Temp));

				if (Box.Children.containsKey(Temp)) {
					Box.Children.remove(Temp);
				}

			}

		}

	}

	/*
	 * Rename Node allows to change the Name of this node but it only affect this
	 * node and its first parent the entire node tree needs to be updated and
	 * reconstructed after renaming a node
	 * 
	 */
	public void Rename_Node(String New_Name) {

		New_Name = Model.Integrity(New_Name);
		if (New_Name.length() != 0 && New_Name != null) {

			if (Children.containsKey(New_Name)) {

			} else {
				if (Parent != null) {

					Parent.Children.remove(Name);
					Parent.Children.put(New_Name, this);

					Name = New_Name;
					Link = Parent.Link + New_Name + "/";

					this.Establish_Link();

				} else {

				}
			}
		}

	}

	/*
	 * Creat a exact copy of this node structure so it includes setting parent link
	 * name and files but it dose not include the children
	 */
	public Node_Structure Node_Copy(Node_Structure Box, Node_Structure The_Parent) {

		Node_Structure New_Node = new Node_Structure();

		New_Node.Set_Name(Box.Get_Name() + "_Copy");
		if (Box.Get_Name() == "Root") {
			New_Node.Set_Name("_Copy_Of_Root");

		}
		if (The_Parent != null) {

			New_Node.Link = The_Parent.Link + New_Node.Get_Name() + "/";

		}
		New_Node.Parent = The_Parent;

		if (Box.File_Children.size() != 0) {

			New_Node.File_Children = Duplicate_File_Data(Box.File_Children, The_Parent);

		}
		if (New_Node.Visual_Node == null) {

			New_Node.Creat_Visual_Components();
		}

		return New_Node;
	}

	// Move this node into the specified folder
	public void Move(Node_Structure Target) {

		// cleaning current parrent information

		if (this.Parent.Children.size() != 0) {
			this.Parent.Children.remove(Name);

		}
		// Assigne new parrent
		this.Parent = Target;

		this.Parent.Children.put(Name, this);

	}

	// Check if the target node is whitin the children of this node
	public Node_Structure Is_Child(Node_Structure Target) {

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				if (entry.getValue() == Target) {

					return entry.getValue();
				} else {

					return entry.getValue().Is_Child(Target);
				}

			}

		}

		return null;

	}

	// Check if a node is a parent of this node in the hearchy
	public Node_Structure Is_Parent(Node_Structure Target) {

		if (Parent != null && Parent.Children.containsKey(this.Get_Name())) {

			if (Target == Parent) {

				// Yes
				return Parent;

			} else {

				return Recursive_Is_Parent(Parent, Target);
			}
		}
		return null;

	}

	// Recursive Check if a node is a parent of this node in the hearchy (Dont
	// Remove !!!)
	public Node_Structure Recursive_Is_Parent(Node_Structure Next_Parent, Node_Structure Target) {
		if (Next_Parent != null && Next_Parent.Children.containsKey(Next_Parent.Get_Name())) {

			if (Target == Next_Parent.Parent) {

				// Yes
				return Next_Parent.Parent;

			} else {

				return Recursive_Is_Parent(Next_Parent.Parent, Target);
			}
		}
		return null;
	}

	// ____________________________________________________________________________//

	// Update all expiration
	public void Update_Expiration() {

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				entry.getValue().Update_Expiration();
			}
		}

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				entry.getValue().setExpiration_();
			}
		}

	}

	// Update all Modified
	public void Update_Modification() {

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				entry.getValue().Update_Modification();
			}
		}

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				entry.getValue().setModified();
			}
		}

	}

	// Update all Time Created
	public void Update_Time_Created() {

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				entry.getValue().Update_Time_Created();
			}
		}

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				entry.getValue().setTime_Created();
			}
		}

	}

	// Update all Time Created
	public void Update_Favorite(boolean FavMode) {

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				entry.getValue().Update_Favorite(FavMode);
			}
		}

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				entry.getValue().setFavorite(FavMode);
				;
			}
		}

	}

	// Update all PassWord
	public void Update_PassWord(boolean FavMode) {

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				entry.getValue().Update_PassWord(FavMode);
			}
		}

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				entry.getValue().setPassword(Generate_Password.RemoteGeneratePassword(8, 1, 1, 1, 1, 0));
				;
			}
		}

	}

	// __________________ Duplicate Folder and Files _____________________________//

	// Duplicate will creat a copy of a folder and every child folder and file in
	// the hearchy
	public Node_Structure Duplicate_Folder(String New_Name) {

		Node_Structure Base_Node = Node_Copy(this, null);

//		Base_Node.Get_Name() = New_Name;

		if (Children.size() != 0) {

			Set<String> keys = Children.keySet();
			String arr[] = new String[keys.size()];
			arr = keys.toArray(arr);

			for (int i = 0; i < arr.length; i++) {

				Node_Structure Temp_Node = Node_Copy(Children.get(arr[i]), Base_Node);

				if (Children.containsKey(arr[i])) {

					Base_Node.Children.put(Temp_Node.Get_Name(),
							Duplicate_Folder_Data(Temp_Node, Children.get(arr[i])));

				}

			}

		}

		return Base_Node;

	}

	// the recursive Function for duplicate folder
	private Node_Structure Duplicate_Folder_Data(Node_Structure Receiver, Node_Structure Target) {

		if (Receiver != null && Target != null) {

			if (Target.Children.size() != 0) {

				Set<String> keys = Target.Children.keySet();
				String arr[] = new String[keys.size()];
				arr = keys.toArray(arr);

				for (int i = 0; i < arr.length; i++) {

					if (Receiver.Children.containsKey(arr[i])) {

					} else {

						Node_Structure Temp_Node = Node_Copy(Target.Children.get(arr[i]), Receiver);

						if (Receiver.Children.containsKey(Temp_Node.Get_Name()) == false) {
							// very stupid Mistake
							// !!!!!!!!!!!!!!!
							// (must add ==false)

							Receiver.Children.put(Temp_Node.Get_Name(),
									Duplicate_Folder_Data(Temp_Node, Target.Children.get(arr[i])));
						}

					}

				}

			}
		}

		return Receiver;

	}

	// duplicate all the files in this folder
	public Map<String, Node_File> Duplicate_File_Data(Map<String, Node_File> Target, Node_Structure The_Parent) {

		if (Target.size() != 0) {
			Map<String, Node_File> New_Node = new HashMap<>();

			for (Entry<String, Node_File> entry : Target.entrySet()) {
				New_Node.put(entry.getKey(), new Node_File(entry.getValue()));

				New_Node.get(entry.getKey()).Set_Parent(The_Parent);
			}

			return New_Node;
		} else {

			return null;

		}
	}

	// ____________________________ Delete ___________________________________

	// delete this folder and every folder under it
	public void Delete_Folder() {

		if (Children.size() != 0) {

			Set<String> keys = Children.keySet();
			String arr[] = new String[keys.size()];
			arr = keys.toArray(arr);

			for (int i = 0; i < arr.length; i++) {

				if (Children.containsKey(arr[i])) {
					Children.get(arr[i]).Delete_Folder();
					Children.remove(arr[i]);

				}

			}

		}

		if (Is_Root_() == false) {

			if (this.Parent.Is_Root_() == false) {

				if (this.Parent.Children.containsKey(Get_Name())) {

					this.Parent.Children.remove(Get_Name());
				}

			}
		}

		Delete_File_Data();
		System.gc();
		if (this.Is_Root == false) {

			this.Clear();
		}

	}

	/*
	 * remove all the data references from this folder and the reference from its
	 * parent
	 */
	public void Clear() {

		if (this.Is_Root_() == false) {

			Link = null;

			if (Parent != null) {

				if (Parent.Children.containsKey(Name)) {

					Parent.Children.remove(Name);
				}

				if (Parent.Is_Root == false) {

					Visual_Node.removeFromParent();
				}
			}

			if (Visual_Node != null) {

				Visual_Node.setUserObject(null);
			}
			Visual_Node = null;
			Children.clear();
			Name = null;
			Parent = null;

		}

	}

	// delete all the files inside this folder
	public void Delete_File_Data() {

		if (File_Children.size() != 0) {

			Set<String> keys = File_Children.keySet();

			String arr[] = new String[keys.size()];
			arr = keys.toArray(arr);
			if (arr.length != 0) {

				for (int i = 0; i < arr.length; i++) {

					if (File_Children.containsKey(arr[i])) {
						Node_File Child = File_Children.get(arr[i]);

						Child.Delete_File();

					}

				}
			}

			File_Children.clear();
		}
	}
// ________________________________ Print ___________________________________

	// print the entire node tree under this folder in a string by name and reltaive
	// relation
	public String Print() {

		String Temp = Name;

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				Temp += "\n\r" + entry.getValue().Get_Name();

				Temp += Recursive_Print(entry.getValue(), "   ");

			}

		}

		return Temp;

	}

	// recursive for the methode print
	private String Recursive_Print(Node_Structure Child, String Temp) {

		String Test = "";

		if (Child.Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Child.Children.entrySet()) {
				Test = "\n\r" + Temp + entry.getValue().Get_Name() + Recursive_Print(entry.getValue(), Temp + "   ");

			}

		}

		return Test;

	}

	// print the entire node under this folder by link
	public String Compact_Print() {

		String Temp = Link;

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				Temp += "\n\r" + entry.getValue().Link;

				Temp += Recursive_Compact__Print(entry.getValue());

			}

		}

		return Temp;

	}

	// recursive methode for compact print Dont Remove This !!!!!
	private String Recursive_Compact__Print(Node_Structure Child) {

		String Test = "";

		if (Child.Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Child.Children.entrySet()) {
				Test = "\n\r" + entry.getValue().Link + Recursive_Compact__Print(entry.getValue());

			}

		}

		return Test;

	}

	// ______________________ Compact_Folders ___________________________________

	// collect all the folders under this folder in a array
	public Node_Structure[] Compact_Folders_Array() {

		List<Node_Structure> Temp = Compact_Folders();

		Node_Structure[] Final_Temp = new Node_Structure[Temp.size()];
		Final_Temp = Temp.toArray(Final_Temp);

		return Final_Temp;

	}

	// collect all the folders under this folder in a List
	public List<Node_Structure> Compact_Folders() {

		List<Node_Structure> Temp = new ArrayList<Node_Structure>();

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				List<Node_Structure> test = entry.getValue().Recursive_Compact_Folders();

				if (test.size() != 0) {

				} else {
					Temp.addAll(test);

				}

			}

		}

		return Temp;

	}

	// recursive methode for Compact_Folders
	private List<Node_Structure> Recursive_Compact_Folders() {

		List<Node_Structure> Temp = new ArrayList<Node_Structure>();

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				List<Node_Structure> test = entry.getValue().Recursive_Compact_Folders();

				if (test.size() != 0) {

				} else {
					Temp.addAll(test);

				}

			}

		}

		return Temp;

	}
	// ______________________ Compact_Files ________________________________________

	// collect all the files under this folder in a array
	public Node_File[] Compact_Files_Array() {

		List<Node_File> Temp = Compact_Files();

		Node_File[] Final_Temp = new Node_File[Temp.size()];
		Final_Temp = Temp.toArray(Final_Temp);

		return Final_Temp;

	}

	// collect all the files under this folder in a List
	public List<Node_File> Compact_Files() {

		List<Node_File> Temp = new ArrayList<Node_File>();

		if (File_Children.size() != 0) {

			Temp.addAll(new ArrayList<>(File_Children.values()));

		}

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				List<Node_File> test = entry.getValue().Compact_Files();

				if (test.size() != 0) {
					Temp.addAll(test);

				}

			}

		}

		return Temp;
	}
	// ______________________ Password Strength ___________________________________

	// collect all the files whit very strong passwords under this folder in a List
	public List<Node_File> Compact_Very_Strong_Files() {

		List<Node_File> Temp = new ArrayList<Node_File>();

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				if (Generate_Password.Password_strength(entry.getValue().getPassword()) > 70) {
					Temp.add(entry.getValue());

				}

			}
		}

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				List<Node_File> test = entry.getValue().Compact_Very_Strong_Files();

				if (test.size() != 0) {
					Temp.addAll(test);

				} else {

				}

			}

		}

		return Temp;
	}

	// collect all the files whit strong passwords under this folder in a List
	public List<Node_File> Compact_Strong_Files() {

		List<Node_File> Temp = new ArrayList<Node_File>();

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				if (Generate_Password.Password_strength(entry.getValue().getPassword()) > 50) {
					Temp.add(entry.getValue());

				}

			}
		}

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				List<Node_File> test = entry.getValue().Compact_Strong_Files();

				if (test.size() != 0) {
					Temp.addAll(test);

				} else {

				}

			}

		}

		return Temp;
	}

	// collect all the files whit weak passwords under this folder in a List
	public List<Node_File> Compact_Weak_Files() {

		List<Node_File> Temp = new ArrayList<Node_File>();

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				if (Generate_Password.Password_strength(entry.getValue().getPassword()) <= 30) {
					Temp.add(entry.getValue());

				}

			}
		}

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				List<Node_File> test = entry.getValue().Compact_Weak_Files();

				if (test.size() != 0) {
					Temp.addAll(test);

				} else {

				}

			}

		}

		return Temp;
	}

	// ______________________ Favorite ___________________________________________

	// collect all the favorite files under this folder in a List In Ascending Order
	public List<Node_File> Compact_Favorite_Files_Ascending_Order() {

		List<Node_File> Temp = Compact_Favorite_Files();
		Temp = Handle_Sorting.Ascending_File_Sorting_By_Date_Created(Temp);

		return Temp;
	}

	// collect all the favorite files under this folder in a List In Descending
	// Order
	public List<Node_File> Compact_Favorite_Files_Descending_Order() {

		List<Node_File> Temp = Compact_Favorite_Files();

		Temp = Handle_Sorting.Descending_File_Sorting_By_Date_Created(Temp);

		return Temp;
	}

	// collect all the favorite files under this folder in a List
	public List<Node_File> Compact_Favorite_Files() {

		List<Node_File> Temp = new ArrayList<Node_File>();

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				if (entry.getValue().getFavorite()) {
					Temp.add(entry.getValue());

				}

			}
		}

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				List<Node_File> test = entry.getValue().Compact_Favorite_Files();

				if (test.size() != 0) {
					Temp.addAll(test);

				} else {

				}

			}

		}

		return Temp;
	}

	// ______________________ search ____________________________________________

	// collect all the files That Countains a certain name
	public List<Node_File> Compact_Search_Files(String Target) {

		if (Target.length() != 0) {

			List<Node_File> Temp = new ArrayList<Node_File>();

			if (File_Children.size() != 0) {

				for (Entry<String, Node_File> entry : File_Children.entrySet()) {

					if (Settings.Ignore_Case) {

						switch (Settings.search) {
						case Name:
							if (entry.getValue().getName().toLowerCase().contains(Target.toLowerCase())) {
								Temp.add(entry.getValue());

							}
							break;
						case User_Name:
							if (entry.getValue().getUser_Name().toLowerCase().contains(Target.toLowerCase())) {
								Temp.add(entry.getValue());

							}
							break;
						case PassWord:
							if (entry.getValue().getPassword().toLowerCase().contains(Target.toLowerCase())) {
								Temp.add(entry.getValue());

							}
							break;
						case OldPassWord:
							if (entry.getValue().getCompactOld_Password(" ", "").toLowerCase()
									.contains(Target.toLowerCase())) {
								Temp.add(entry.getValue());

							}
							break;
						case Url:
							if (entry.getValue().getUrl().toLowerCase().contains(Target.toLowerCase())) {
								Temp.add(entry.getValue());

							}
							break;
						case KeyWord:
							if (entry.getValue().getKeyWord().toLowerCase().contains(Target.toLowerCase())) {
								Temp.add(entry.getValue());

							}
							break;
						case Note:
							if (entry.getValue().getNote().toLowerCase().contains(Target.toLowerCase())) {
								Temp.add(entry.getValue());

							}
							break;
						default:
							// code block
						}

					} else {
						switch (Settings.search) {
						case Name:
							if (entry.getValue().getName().contains(Target)) {
								Temp.add(entry.getValue());

							}
							break;
						case User_Name:
							if (entry.getValue().getUser_Name().contains(Target)) {
								Temp.add(entry.getValue());

							}
							break;
						case PassWord:
							if (entry.getValue().getPassword().contains(Target)) {
								Temp.add(entry.getValue());

							}
							break;
						case OldPassWord:
							if (entry.getValue().getCompactOld_Password(" ", "").contains(Target)) {
								Temp.add(entry.getValue());

							}
							break;
						case Url:
							if (entry.getValue().getUrl().contains(Target)) {
								Temp.add(entry.getValue());

							}
							break;
						case KeyWord:
							if (entry.getValue().getKeyWord().contains(Target)) {
								Temp.add(entry.getValue());

							}
							break;
						case Note:
							if (entry.getValue().getNote().contains(Target)) {
								Temp.add(entry.getValue());

							}
							break;
						default:
							// code block
						}
					}

				}

			}

			if (Children.size() != 0) {

				for (Entry<String, Node_Structure> entry : Children.entrySet()) {

					List<Node_File> test = entry.getValue().Compact_Search_Files(Target);

					if (test.size() != 0) {
						Temp.addAll(test);

					} else {

					}

				}

			}

			return Temp;
		}
		return null;

	}

	// collect all the files That Countains a certain name
	public List<Node_File> Compact_search_Favorite_Files(String Target) {

		List<Node_File> Temp = new ArrayList<Node_File>();

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				if (entry.getValue().getName().contains(Target) && entry.getValue().getFavorite()) {
					Temp.add(entry.getValue());

				}

			}

		}

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				List<Node_File> test = entry.getValue().Compact_Search_Files(Target);

				if (test.size() != 0) {
					Temp.addAll(test);

				} else {

				}

			}

		}

		return Temp;

	}

	// ______________________ Expired ___________________________________________

	// collect all the files That Countains a certain name
	public List<Node_File> Compact_Expired_Files() {

		List<Node_File> Temp = new ArrayList<Node_File>();

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				if (entry.getValue().Is_Expired()) {
					Temp.add(entry.getValue());

				}

			}

		}

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				List<Node_File> test = entry.getValue().Compact_Expired_Files();

				if (test != null) {

					if (test.size() != 0) {
						Temp.addAll(test);

					} else {

					}
				}

			}

		}

		if (Temp.size() != 0) {
			return Temp;

		} else {
			return null;
		}

	}

	// ______________________ Tree && Table____________________________________

	// Link all the visual componenet starting from the end and climbing back up
	// for creating a Jtree

	public DefaultMutableTreeNode Construct_Jtree_Main() {

		if (Children.size() != 0) {

			List<Node_Structure> Temp_Folder_Children = new ArrayList<Node_Structure>();

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				if (Visual_Node == null) {
					Creat_Visual_Components();
				}
				if (entry.getValue().Visual_Node == null) {
					entry.getValue().Creat_Visual_Components();
				}
				Temp_Folder_Children.add(entry.getValue());

				Recursive_Construct_Jtree_Main(entry.getValue());

			}

			switch (Settings.sort) {

			case Default:

				break;
			case Name:

				if (Settings.Sort_Order == 0) {
					Temp_Folder_Children = Handle_Sorting.Ascending_Folder_Sorting_Name(Temp_Folder_Children);

				} else {
					Temp_Folder_Children = Handle_Sorting.Descending_Folder_Sorting_Name(Temp_Folder_Children);

				}

				break;

			default:
				// code block
			}

			if (Temp_Folder_Children.size() == Children.size()) {

				for (int i = 0; i < Temp_Folder_Children.size(); i++) {
					Visual_Node.add(Temp_Folder_Children.get(i).Visual_Node);

				}

			} else {
				for (Map.Entry<String, Node_Structure> entry : Children.entrySet()) {

					Visual_Node.add(entry.getValue().Visual_Node);
				}

			}

		}

		if (File_Children.size() != 0) {

			List<Node_File> Temp_File_Children = new ArrayList<Node_File>();
			for (Map.Entry<String, Node_File> entry : File_Children.entrySet()) {

				if (entry.getValue().Visual_Node == null) {
					entry.getValue().Creat_Visual_Components();
				}
				if (entry.getValue().Visual_Node == null) {
					entry.getValue().Creat_Visual_Components();
				}

				Temp_File_Children.add(entry.getValue());
				// Visual_Node.add(entry.getValue().Visual_Node);

			}

			// SORTING EXAMPLE

			switch (Settings.sort) {

			case Default:

				break;
			case Name:

				if (Settings.Sort_Order == 0) {
					Temp_File_Children = Handle_Sorting.Ascending_File_Sorting_Name(Temp_File_Children);

				} else {
					Temp_File_Children = Handle_Sorting.Descending_File_Sorting_Name(Temp_File_Children);

				}

				break;
			case Date_Modified:
				if (Settings.Sort_Order == 0) {
					Temp_File_Children = Handle_Sorting.Ascending_File_Sorting_By_Date_Modified(Temp_File_Children);

				} else {
					Temp_File_Children = Handle_Sorting.Descending_File_Sorting_By_Date_Modified(Temp_File_Children);

				}
				break;
			case Date_Created:
				if (Settings.Sort_Order == 0) {
					Temp_File_Children = Handle_Sorting.Ascending_File_Sorting_By_Date_Created(Temp_File_Children);

				} else {
					Temp_File_Children = Handle_Sorting.Descending_File_Sorting_By_Date_Created(Temp_File_Children);

				}
				break;
			case Date_Expired:
				if (Settings.Sort_Order == 0) {
					Temp_File_Children = Handle_Sorting.Ascending_File_Sorting_By_Date_Expiration(Temp_File_Children);

				} else {
					Temp_File_Children = Handle_Sorting.Descending_File_Sorting_By_Date_Expiration(Temp_File_Children);

				}
				break;
			default:
				// code block
			}

			if (Temp_File_Children.size() == File_Children.size()) {

				for (int i = 0; i < Temp_File_Children.size(); i++) {
					Visual_Node.add(Temp_File_Children.get(i).Visual_Node);

				}

			} else {
				for (Map.Entry<String, Node_File> entry : File_Children.entrySet()) {

					Visual_Node.add(entry.getValue().Visual_Node);
				}
			}
		}
		return Visual_Node;
	}

	// Recursive methode for Construct_Jtree
	private void Recursive_Construct_Jtree_Main(Node_Structure Child) {

		if (Child.Children.size() != 0) {

			List<Node_Structure> Temp_Folder_Children = new ArrayList<Node_Structure>();

			for (Entry<String, Node_Structure> entry : Child.Children.entrySet()) {

				if (Child.Visual_Node == null) {
					Child.Creat_Visual_Components();
				}
				if (entry.getValue().Visual_Node == null) {
					entry.getValue().Creat_Visual_Components();
				}
				Temp_Folder_Children.add(entry.getValue());

				Recursive_Construct_Jtree_Main(entry.getValue());

			}

			switch (Settings.sort) {

			case Default:

				break;
			case Name:

				if (Settings.Sort_Order == 0) {
					Temp_Folder_Children = Handle_Sorting.Ascending_Folder_Sorting_Name(Temp_Folder_Children);

				} else {
					Temp_Folder_Children = Handle_Sorting.Descending_Folder_Sorting_Name(Temp_Folder_Children);

				}

				break;

			default:
				// code block
			}

			if (Temp_Folder_Children.size() == Child.Children.size()) {

				for (int i = 0; i < Temp_Folder_Children.size(); i++) {
					Child.Visual_Node.add(Temp_Folder_Children.get(i).Visual_Node);

				}

			} else {
				for (Map.Entry<String, Node_Structure> entry : Child.Children.entrySet()) {

					Child.Visual_Node.add(entry.getValue().Visual_Node);
				}

			}

		}

		if (Child.File_Children.size() != 0) {

			List<Node_File> Temp_File_Children = new ArrayList<Node_File>();
			for (Map.Entry<String, Node_File> entry : Child.File_Children.entrySet()) {

				if (entry.getValue().Visual_Node == null) {
					entry.getValue().Creat_Visual_Components();
				}
				if (entry.getValue().Visual_Node == null) {
					entry.getValue().Creat_Visual_Components();
				}

				Temp_File_Children.add(entry.getValue());
				// Visual_Node.add(entry.getValue().Visual_Node);

			}

			switch (Settings.sort) {

			case Default:

				break;
			case Name:

				if (Settings.Sort_Order == 0) {
					Temp_File_Children = Handle_Sorting.Ascending_File_Sorting_Name(Temp_File_Children);

				} else {
					Temp_File_Children = Handle_Sorting.Descending_File_Sorting_Name(Temp_File_Children);

				}

				break;
			case Date_Modified:
				if (Settings.Sort_Order == 0) {
					Temp_File_Children = Handle_Sorting.Ascending_File_Sorting_By_Date_Modified(Temp_File_Children);

				} else {
					Temp_File_Children = Handle_Sorting.Descending_File_Sorting_By_Date_Modified(Temp_File_Children);

				}
				break;
			case Date_Created:
				if (Settings.Sort_Order == 0) {
					Temp_File_Children = Handle_Sorting.Ascending_File_Sorting_By_Date_Created(Temp_File_Children);

				} else {
					Temp_File_Children = Handle_Sorting.Descending_File_Sorting_By_Date_Created(Temp_File_Children);

				}
				break;
			case Date_Expired:
				if (Settings.Sort_Order == 0) {
					Temp_File_Children = Handle_Sorting.Ascending_File_Sorting_By_Date_Expiration(Temp_File_Children);

				} else {
					Temp_File_Children = Handle_Sorting.Descending_File_Sorting_By_Date_Expiration(Temp_File_Children);

				}
				break;
			default:
				// code block
			}

			if (Temp_File_Children.size() == Child.File_Children.size()) {

				for (int i = 0; i < Temp_File_Children.size(); i++) {
					Child.Visual_Node.add(Temp_File_Children.get(i).Visual_Node);

				}

			} else {
				for (Map.Entry<String, Node_File> entry : Child.File_Children.entrySet()) {

					Child.Visual_Node.add(entry.getValue().Visual_Node);
				}
			}
		}

	}

	// Construct Table visual Elements
	@SuppressWarnings("unused")
	public DefaultTableModel Construct_Table(JTable Table) {

		if (this != null && Table != null) {

			int size = this.Children.size() + this.File_Children.size();
			// System.out.println("size 0 : " + size);

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

				// System.out.println("w" + tWidth + "H" + tHeight);

				int temp = tWidth / 100;

				// System.out.println("temp : " + temp);
				// System.out.println("size 1 : " + size);

				if (size <= temp) {

					// System.out.println("qsduqysduh");
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

				for (String Temp : this.Children.keySet()) {

					Temp_Data[test_index] = this.Children.get(Temp);
					test_index++;
				}

				for (String Temp : this.File_Children.keySet()) {

					Temp_Data[test_index] = this.File_Children.get(Temp);

					test_index++;

				}

				// System.out.println("Rows " + rows + " Columns " + column);
				// System.out.println("Total Cells : " + rows * (column));

				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				Object[][] rowData;
				String[] columnNames = null;
				columnNames = new String[column];
				for (int i = 0; i < column; i++) {
					columnNames[i] = i + "";
				}

				// System.out.println(Arrays.toString(columnNames));

				Set<String> keys = this.Children.keySet();
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

				// System.out.println("c" + model.getColumnCount() + "r" + model.getRowCount());

				return model;
			} else {

				DefaultTableModel model = new DefaultTableModel(0, 0);

				// System.out.println("c" + model.getColumnCount() + "r" + model.getRowCount());

				return model;
			}
		}

		return null;

	}

	@SuppressWarnings("unused")
	private DefaultTableModel Favorite_Construct_Table(JTable Table, List<Node_File> Fav_List) {

		int size = Fav_List.size();
		// System.out.println("size 0 : " + size);

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

			// System.out.println("w" + tWidth + "H" + tHeight);

			int temp = tWidth / 100;

			// System.out.println("temp : " + temp);
			// System.out.println("size 1 : " + size);

			if (size <= temp) {

				// System.out.println("qsduqysduh");
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

			for (int i = 0; i < Fav_List.size(); i++) {

				Temp_Data[i] = Fav_List.get(i);

			}

			// System.out.println("Rows " + rows + " Columns " + column);
			// System.out.println("Total Cells : " + rows * (column));

			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			Object[][] rowData;
			String[] columnNames = null;
			columnNames = new String[column];
			for (int i = 0; i < column; i++) {
				columnNames[i] = i + "";
			}

			// System.out.println(Arrays.toString(columnNames));

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

			// System.out.println("c" + model.getColumnCount() + "r" + model.getRowCount());

			return model;
		} else {

			DefaultTableModel model = new DefaultTableModel(0, 0);

			// System.out.println("c" + model.getColumnCount() + "r" + model.getRowCount());

			return model;
		}

	}

	// ______________________ Traversal ________________________________________

	// Traverse the node tree based on a link example /c:/users/yahya/desktop
	public Node_Structure Recursice_Traverse(Object[] Path, int Index) {

		if (Children.containsKey(Path[Index] + "")) {

			if (Index < Path.length - 1) {
				Node_Structure Temp = this.Children.get(Path[Index].toString()).Recursice_Traverse(Path, Index + 1);

				return Temp;
			} else if (Index == Path.length - 1) {
				Node_Structure Temp = this.Children.get(Path[Index].toString());

				return Temp;
			} else {
				return this;
			}
		} else {

			if (Path[Index].toString().contains(".pss")) {

				return this;

			} else {

				return this;

			}

		}

	}

	// Traverse the node tree based on a link example /c:/users/yahya/desktop
	// but if a folder dosent exist then its build
	public Node_Structure Recursice_Traverse_And_Build(String[] Path, int Index) {

		if (Children.containsKey(Path[Index])) {

			if (Index < Path.length - 1) {
				Node_Structure Temp = this.Children.get(Path[Index]).Recursice_Traverse_And_Build(Path, Index + 1);

				return Temp;
			} else if (Index == Path.length - 1) {
				Node_Structure Temp = this.Children.get(Path[Index]);

				return Temp;
			} else {
				return this;
			}
		} else {

			if (Index < Path.length - 1) {
				@SuppressWarnings("unused")
				Node_Structure New_Temp = this.Add_New_Child(Path[Index]);

				Node_Structure Temp = this.Children.get(Path[Index]).Recursice_Traverse_And_Build(Path, Index + 1);

				return Temp;
			} else if (Index == Path.length - 1) {
				@SuppressWarnings("unused")
				Node_Structure New_Temp = this.Add_New_Child(Path[Index]);

				Node_Structure Temp = this.Children.get(Path[Index]);

				return Temp;
			} else {
				return null;
			}

		}

	}
	// ______________________ Sizes __________________________________________

	// recursive Return the number of folders under this node
	public int Folder_Size() {
		int TempSize = 1;

		for (Entry<String, Node_Structure> entry : Children.entrySet()) {

			TempSize += entry.getValue().Folder_Size();

		}

		return TempSize;

	}

	// recursive Return the number of files under this node
	public int Files_Size() {

		int Temp = 0;

		Temp += File_Children.size();

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				Temp += entry.getValue().Files_Size();

			}

		}

		return Temp;

	}

	// recursive Get The Number of favorite files under this folder
	public int Favorite_Files_Size() {

		int Temp = 0;

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				if (entry.getValue().getFavorite()) {
					Temp++;

				}

			}

		}

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				int test = entry.getValue().Favorite_Files_Size();

				if (test != 0) {
					Temp += test;

				} else {

				}

			}

		}

		return Temp;

	}

	// recursive Get The Number of Expired files under this folder
	public int Expired_Files_Size() {

		int Temp = 0;

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				if (entry.getValue().Is_Expired()) {
					Temp++;

				}

			}

		}

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				int test = entry.getValue().Expired_Files_Size();

				if (test != 0) {
					Temp += test;

				} else {

				}

			}

		}

		return Temp;
	}

	// recursive Get The Number of files whit a specific word in theyre name under
	// this folder
	public int Size_Of_Occurence(String Target) {

		int Temp = 0;

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				if (Settings.Ignore_Case) {

					switch (Settings.search) {
					case Name:
						if (entry.getValue().getName().toLowerCase().contains(Target.toLowerCase())) {
							Temp++;

						}
						break;
					case User_Name:
						if (entry.getValue().getUser_Name().toLowerCase().contains(Target.toLowerCase())) {
							Temp++;

						}
						break;
					case PassWord:
						if (entry.getValue().getPassword().toLowerCase().contains(Target.toLowerCase())) {
							Temp++;

						}
						break;
					case OldPassWord:
						if (entry.getValue().getCompactOld_Password(" ", "").toLowerCase()
								.contains(Target.toLowerCase())) {
							Temp++;

						}
						break;
					case Url:
						if (entry.getValue().getUrl().toLowerCase().contains(Target.toLowerCase())) {
							Temp++;

						}
						break;
					case KeyWord:
						if (entry.getValue().getKeyWord().toLowerCase().contains(Target.toLowerCase())) {
							Temp++;

						}
						break;
					case Note:
						if (entry.getValue().getNote().toLowerCase().contains(Target.toLowerCase())) {
							Temp++;

						}
						break;
					default:
						// code block
					}

				} else {
					switch (Settings.search) {
					case Name:
						if (entry.getValue().getName().contains(Target)) {
							Temp++;

						}
						break;
					case User_Name:
						if (entry.getValue().getUser_Name().contains(Target)) {
							Temp++;

						}
						break;
					case PassWord:
						if (entry.getValue().getPassword().contains(Target)) {
							Temp++;

						}
						break;
					case OldPassWord:
						if (entry.getValue().getCompactOld_Password(" ", "").contains(Target)) {
							Temp++;

						}
						break;
					case Url:
						if (entry.getValue().getUrl().contains(Target)) {
							Temp++;

						}
						break;
					case KeyWord:
						if (entry.getValue().getKeyWord().contains(Target)) {
							Temp++;

						}
						break;
					case Note:
						if (entry.getValue().getNote().contains(Target)) {
							Temp++;

						}
						break;
					default:
						// code block
					}
				}

			}

		}

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				int test = entry.getValue().Size_Of_Occurence(Target);

				if (test != 0) {
					Temp += test;

				} else {

				}

			}

		}

		return Temp;
	}

	// recursive Get The Number of files whit a very strong password under this
	// folder
	public int Very_Strong_Files_Size() {

		int Temp = 0;

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				if (Generate_Password.Password_strength(entry.getValue().getPassword()) > 70) {
					Temp++;

				}

			}

		}

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				int test = entry.getValue().Very_Strong_Files_Size();

				if (test != 0) {
					Temp += test;

				} else {

				}

			}

		}

		return Temp;

	}

	// recursive Get The Number of files whit a strong password under this folder
	public int Strong_Files_Size() {

		int Temp = 0;

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				if (Generate_Password.Password_strength(entry.getValue().getPassword()) > 50) {
					Temp++;

				}

			}

		}

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				int test = entry.getValue().Strong_Files_Size();

				if (test != 0) {
					Temp += test;

				} else {

				}

			}

		}

		return Temp;

	}

	// recursive Get The Number of files whit a weak password under this folder
	public int Weak_Files_Size() {

		int Temp = 0;

		if (File_Children.size() != 0) {

			for (Entry<String, Node_File> entry : File_Children.entrySet()) {

				if (Generate_Password.Password_strength(entry.getValue().getPassword()) <= 30) {
					Temp++;

				}

			}

		}

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				int test = entry.getValue().Weak_Files_Size();

				if (test != 0) {
					Temp += test;

				} else {

				}

			}

		}

		return Temp;

	}

	// ______________________Corrections____________________________________________

	// Update the link of all the tree node based on the relation of parent child
	public void Establish_Link() {

		if (Children.size() != 0) {

			for (Entry<String, Node_Structure> entry : Children.entrySet()) {

				entry.getValue().Parent = this;
				entry.getValue().Link = Link + entry.getKey() + "/";
				entry.getValue().Establish_Link();

			}

		}
		if (File_Children.size() != 0) {
			for (Entry<String, Node_File> entry : File_Children.entrySet()) {
				entry.getValue().Set_Parent(this);
				entry.getValue().setLink(Link + entry.getKey());

			}
		}

	}

}