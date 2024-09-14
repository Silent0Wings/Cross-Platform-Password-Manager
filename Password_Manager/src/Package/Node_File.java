package Package;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.tree.DefaultMutableTreeNode;

public class Node_File {

	private String Name = "";

	private String Title = "";

	private String User_Name = "";

	private String Password = "";

	private String Url = "";

	private String KeyWord = "";

	private String Expiration = "";

	private String Modified = "";

	private String Time_Created = "";

	private String Note = "";

	private String Link = "";

	private Node_Structure Parent;

	public DefaultMutableTreeNode Visual_Node;

	private boolean Favorite;

	public Map<String, String> Old_Password = new HashMap<>();

	// ____________________________Getter Setter___________________________________

	public String getName() {
		return Model.Integrity(Name);
	}

	public void setName(String name) {
		name = Model.Integrity(name);

		Name = name;

	}

	public String getTitle() {
		return Model.Integrity(Title);
	}

	public void setTitle(String title) {
		Title = Model.Integrity(title);
	}

	public String getUser_Name() {
		return Model.Integrity(User_Name);
	}

	public void setUser_Name(String user_Name) {
		User_Name = Model.Integrity(user_Name);

	}

	public String getPassword() {
		return Model.Integrity(Password);
	}

	public void setPassword(String password) {
		Password = Model.Integrity(password);
		if (Old_Password.containsKey(Password) == false) {

			LocalDateTime currentDateTime = LocalDateTime.now();

			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

			Old_Password.put(Password, Model.Integrity(currentDateTime.format(formatter)));
		}
	}

	public String getUrl() {
		return Model.Integrity(Url);
	}

	public void setUrl(String url) {
		Url = Model.Integrity(url);
	}

	public String getKeyWord() {
		return Model.Integrity(KeyWord);
	}

	public void setKeyWord(String keyWord) {
		KeyWord = Model.Integrity(keyWord);
	}

	public String getExpiration() {

		if (Expiration == null || Expiration == "" || Expiration.length() == 0) {

			setExpiration();
			return Model.Integrity(Expiration);

		}

		return Model.Integrity(Expiration);
	}

	public LocalDateTime getExpiration_Date() {

		try {

			if (Expiration != null) {

				if (Expiration != "" && Expiration.length() > 0) {

					// date in String
					String dateString = Expiration;
					// Build formatter
					DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

					// Parse String to LocalDateTime
					//System.out.println(dateString);
					LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);

					//System.out.println("LocalDateTime : " + dateTime.format(formatter));
					return dateTime;

				}
			}

		} catch (Exception e) {
			// TODO: handle exception

		}
		return setExpiration();
	}

	public void setExpiration(String expiration) {
		Expiration = Model.Integrity(expiration);
	}

	public void setExpiration(LocalDateTime New_Expiration) {

		if (New_Expiration != null) {

			// Get current date time
			LocalDateTime currentDateTime = New_Expiration;
			// Inbuilt format
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

			// Custom format if needed
			// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd
			// HH:mm:ss");

			// Format LocalDateTime
			Expiration = currentDateTime.format(formatter);
			//System.out.println(Time_Created);
			// Verify
			//System.out.println("Formatted LocalDateTime : " + formattedDateTime);

		}

	}

	public void setExpiration(int Years, int Months, int Days) {

		if (Years >= 0 && Months >= 0 && Days >= 0) {

			// Add time
			LocalDateTime Tew = setTime_Created().plusDays(Days);
			Tew = Tew.plusMonths(Months);
			Tew = Tew.plusYears(Years);
			// Convert to string and formate
			setExpiration(Tew);

		} else {
			setExpiration(LocalDateTime.now());

		}

	}

	public void setExpiration_() {

		if (Settings.Year >= 0 && Settings.Month >= 0 && Settings.Day >= 0) {

			// Add time
			LocalDateTime Tew = setTime_Created().plusDays(Settings.Day);
			Tew = Tew.plusMonths(Settings.Month);
			Tew = Tew.plusYears(Settings.Year);
			// Convert to string and formate
			setExpiration(Tew);

		} else {
			setExpiration(LocalDateTime.now());

		}

	}

	public LocalDateTime setExpiration() {

		LocalDateTime Tew = setTime_Created().plusDays(Settings.Day);
		Tew = Tew.plusMonths(Settings.Month);
		Tew = Tew.plusYears(Settings.Year);
		// Convert to string and formate
		setExpiration(Tew);

		return Tew;

	}

	public String getNote() {
		return Model.Integrity(Note);
	}

	public void setNote(String note) {
		Note = Model.Integrity(note);
	}

	public String getLink() {
		return Model.Integrity(Link);
	}

	public void setLink(String link) {
		Link = Model.Integrity(link);
	}

	public LocalDateTime getDate_Created() {
		if (Time_Created != "" && Time_Created.length() > 0) {

			// date in String
			String dateString = Time_Created;
			// Build formatter
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

			// Parse String to LocalDateTime
			//System.out.println(dateString);
			LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);

			//System.out.println("LocalDateTime : " + dateTime.format(formatter));
			return dateTime;

		}

		return null;
	}

	public String getTime_Created() {

		if (Time_Created == null || Time_Created == "" || Time_Created.length() == 0) {

			setTime_Created();
			return Model.Integrity(Time_Created);

		}

		return Model.Integrity(Time_Created);
	}

	public void setTime_Created(String New_Time_Created) {
		Time_Created = Model.Integrity(New_Time_Created);
	}

	public void setTime_Created(LocalDateTime New_Time_Created) {

		if (New_Time_Created != null) {

			// Get current date time
			LocalDateTime currentDateTime = New_Time_Created;
			// Inbuilt format
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

			// Custom format if needed
			// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd
			// HH:mm:ss");

			// Format LocalDateTime
			Time_Created = currentDateTime.format(formatter);
			//System.out.println(Time_Created);
			// Verify
			//System.out.println("Formatted LocalDateTime : " + formattedDateTime);

		}

	}

	public LocalDateTime setTime_Created() {
		try {

			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
			Time_Created = currentDateTime.format(formatter);

			setModified();
			return currentDateTime;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getModified() {

		if (Modified == null || Modified == "" || Modified.length() == 0) {

			setModified();

		}

		return Model.Integrity(Modified);
	}

	public LocalDateTime getModified_Date() {
		if (Modified != "" && Modified.length() > 0) {

			// date in String
			String dateString = Modified;
			// Build formatter
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

			// Parse String to LocalDateTime
			//System.out.println(dateString);
			LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);

			//System.out.println("LocalDateTime : " + dateTime.format(formatter));
			return dateTime;

		}

		return null;
	}

	public void setModified(String modified) {

		Modified = Model.Integrity(modified);
	}

	public void setModified(LocalDateTime New_Modified) {
		if (New_Modified != null) {

			LocalDateTime currentDateTime = New_Modified;
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
			Modified = currentDateTime.format(formatter);

		} else {
			setModified();
		}
	}

	public void setModified() {

		try {

			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
			Modified = currentDateTime.format(formatter);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Map<String, String> getOld_Password() {

		Map<String, String> temp = new HashMap<>();
		for (Map.Entry<String, String> entry : Old_Password.entrySet()) {

			temp.put(Model.Integrity(entry.getKey()), Model.Integrity(entry.getValue()));
		}
		return temp;
	}

	public String getCompactOld_Password(String TimeStart, String TimeEnd) {

		String Compacted = "";
		if (Old_Password.size() != 0) {

			int i = 0;

			for (Map.Entry<String, String> entry : Old_Password.entrySet()) {

				if (Old_Password.size() == 1) {
					Compacted += Model.Integrity(entry.getValue()) + TimeStart + Model.Integrity(entry.getKey())
							+ TimeEnd;

				} else {

					if (i != Old_Password.size() - 1) {

						Compacted += Model.Integrity(entry.getValue()) + TimeStart + Model.Integrity(entry.getKey())
								+ TimeEnd + "\r\n";
					} else {

						Compacted += Model.Integrity(entry.getValue()) + TimeStart + Model.Integrity(entry.getKey())
								+ TimeEnd;

					}

					i++;
				}

			}

		}

		// System.err.println("Compacted " + Compacted);
		return Compacted;
	}

	public String[] getCompactOld_Password_No_Time() {

		if (Old_Password != null) {

			if (Old_Password.size() > 0) {

				String[] keys = new String[Old_Password.size()];
				// Object[] values = new Object[Old_Password.size()];
				int index = 0;
				for (Entry<String, String> mapEntry : Old_Password.entrySet()) {
					keys[index] = mapEntry.getKey();
					index++;
				}

				return keys;

			}

		}

		return null;
	}

	public String getCompactOld_Password(String Seperator) {

		String Final = "";

		String[] objectArray = getCompactOld_Password_No_Time();
		if (objectArray != null && objectArray.length != 0) {

			for (int i = 0; i < objectArray.length; i++) {
				if (i == objectArray.length - 1) {
					Final += objectArray[i];

				} else {
					Final += objectArray[i] + Seperator;
				}

			}

		}

		return Final;

	}

	public void setOld_Password(Map<String, String> New) {

		if (New != null) {
			if (New.size() != 0) {

				Map<String, String> temp = new HashMap<>();
				for (Map.Entry<String, String> entry : New.entrySet()) {

					temp.put(Model.Integrity(entry.getKey()), Model.Integrity(entry.getValue()));
				}

				Old_Password = temp;
			}
		}

	}

	public void setOld_Password(String[] Source) {

		if (Source != null) {
			if (Source.length != 0) {

				for (int i = 0; i < Source.length; i++) {

					LocalDateTime currentDateTime = LocalDateTime.now();

					DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

					Old_Password.put(Source[i], Model.Integrity(currentDateTime.format(formatter)));
				}
			}
		}

	}

	public void setOld_Password(String Source) {

		if (Source != null) {
			if (Source.length() != 0) {

				for (int i = 0; i < Source.length(); i++) {

					LocalDateTime currentDateTime = LocalDateTime.now();

					DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

					Old_Password.put(Source, Model.Integrity(currentDateTime.format(formatter)));
				}
			}
		}

	}

	public boolean getFavorite() {
		return Favorite;
	}

	public String getFavorite_String() {
		return String.valueOf(getFavorite());
	}

	public void setFavorite(boolean favorite) {
		Favorite = favorite;
	}

	public Node_Structure Get_Parent() {

		return Parent;
	}

	public void Set_Parent(Node_Structure New_Parent) {
		if (New_Parent != null) {

			Parent = New_Parent;
			Link = New_Parent.Get_Link();
		}
	}

	public boolean Is_Expired() {

		if (getExpiration_Date() != null) {

			if (getExpiration_Date().isBefore(LocalDateTime.now())) {

				return true;

			} else {

				return false;

			}
		}
		return false;

	}

	// Add DefaultMutableTreeNode and set the userobject
	public void Creat_Visual_Components() {
		this.Visual_Node = new DefaultMutableTreeNode(Model.Integrity(this.Name));
		this.Visual_Node.setUserObject(this);
		this.Visual_Node.setAllowsChildren(false);

	}
	// _________________________________________________________________________________________________

	// Creat a node file whit just the visual components
	public Node_File() {

		Visual_Node = new DefaultMutableTreeNode(this);
		Visual_Node.setUserObject(this);
		Visual_Node.setAllowsChildren(false);

		setTime_Created();
		setExpiration();
		setModified();
	}

	public Node_File(Node_File Target_) {

		setName(Target_.getName());

		setTitle(Target_.getTitle());

		setUser_Name(Target_.getUser_Name());

		setPassword(Target_.getPassword());

		setUrl(Target_.getUrl());

		setKeyWord(Target_.getKeyWord());

		setExpiration(Target_.getExpiration());

		setTime_Created(Target_.getTime_Created());

		setModified(Target_.getModified_Date());

		setNote(Target_.getNote());

		setLink(Target_.getLink());

		Set_Parent(Target_.Get_Parent());

		setFavorite(Target_.getFavorite());

		setOld_Password(Target_.getOld_Password());

		Visual_Node = new DefaultMutableTreeNode(this);
		Visual_Node.setUserObject(this);
		Visual_Node.setAllowsChildren(false);

	}

	// Creat a node file whit just the name the url tge username and password
	public Node_File(String New_Name, String New_Url, String New_UserName, String New_PassWord) {

		setName(New_Name);
		setUrl(New_Url);
		setUser_Name(New_UserName);
		setPassword(New_PassWord);
		setTime_Created();
		setExpiration();

		Visual_Node = new DefaultMutableTreeNode(Model.Integrity(New_Name));
		Visual_Node.setUserObject(this);
		Visual_Node.setAllowsChildren(false);

	}

	// Creat a node file whit just the name and the parent
	public Node_File(String New_Name, Node_Structure New_Parent) {

		setName(New_Name);
		setTime_Created();
		setExpiration();

		Visual_Node = new DefaultMutableTreeNode(Model.Integrity(New_Name));
		Visual_Node.setUserObject(this);
		Visual_Node.setAllowsChildren(false);

	}

	// Creat a node file whit the title username password url expiration keyword and
	// note
	public Node_File(String New_Title, String New_User_Name, String New_Password, String New_Url, String New_Expiration,
			String New_KeyWord, String New_Note) {

		setName(New_Title);
		setUrl(New_Url);
		setUser_Name(New_User_Name);
		setPassword(New_Password);
		setTitle(New_Title);
		setKeyWord(New_KeyWord);
		setNote(New_Note);
		setExpiration(New_Expiration);
		setTime_Created();

		Visual_Node = new DefaultMutableTreeNode(Model.Integrity(New_Title));
		Visual_Node.setUserObject(this);
		Visual_Node.setAllowsChildren(false);

	}

	// Creat a node file whit the title username password url expiration keyword and
	// note
	public Node_File(String New_Title, String New_User_Name, String New_Password, String New_Url, String New_KeyWord,
			String New_Note, int Years, int Months, int Days) {

		setName(New_Title);
		setTitle(New_Title);
		setUrl(New_Url);
		setUser_Name(New_User_Name);
		setPassword(New_Password);
		setTitle(New_Title);
		setKeyWord(New_KeyWord);
		setNote(New_Note);
		setExpiration(Years, Months, Days);

		Visual_Node = new DefaultMutableTreeNode(Model.Integrity(New_Title));
		Visual_Node.setUserObject(this);
		Visual_Node.setAllowsChildren(false);

	}

	// Creat a node file whit the name title username password url expiration
	// keyword and note
	public Node_File(String New_Name, String New_Title, String New_User_Name, String New_Password, String New_Url,
			String New_Expiration, String New_KeyWord, String New_Note) {

		setName(New_Name);
		setTitle(New_Title);
		setUrl(New_Url);
		setUser_Name(New_User_Name);
		setPassword(New_Password);
		setTitle(New_Title);
		setKeyWord(New_KeyWord);
		setNote(New_Note);
		setExpiration(New_Expiration);
		setTime_Created();

		Visual_Node = new DefaultMutableTreeNode(Model.Integrity(New_Title));
		Visual_Node.setUserObject(this);
		Visual_Node.setAllowsChildren(false);
	}

	// Creat a node file whit the name title username password url expiration
	// keyword and note and link
	public Node_File(String New_Name, String New_Title, String New_User_Name, String New_Password, String New_Url,
			String New_Expiration, String New_KeyWord, String New_Note, String New_Link) {

		setName(New_Name);
		setTitle(New_Title);
		setUser_Name(New_User_Name);
		setPassword(New_Password);
		setUrl(New_Url);
		setKeyWord(New_KeyWord);
		setNote(New_Note);
		setLink(New_Link);
		setExpiration(New_Expiration);
		setTime_Created();

		Visual_Node = new DefaultMutableTreeNode(Model.Integrity(New_Name));
		Visual_Node.setUserObject(this);
		Visual_Node.setAllowsChildren(false);
	}

	// Creat a node file whit the name title username password url expiration
	// keyword and note and link
	public Node_File(String New_Name, String New_Title, String New_User_Name, String New_Password, String New_Url,
			String New_Expiration, String New_KeyWord, String New_Note, String New_Link, String New_Time_Created,
			boolean New_Favorite) {

		setName(New_Name);
		setTitle(New_Title);
		setUser_Name(New_User_Name);
		setPassword(New_Password);
		setUrl(New_Url);
		setKeyWord(New_KeyWord);
		setNote(New_Note);
		setLink(New_Link);
		setFavorite(New_Favorite);
		setExpiration(New_Expiration);
		setTime_Created(New_Time_Created);

		Visual_Node = new DefaultMutableTreeNode(Model.Integrity(New_Name));
		Visual_Node.setUserObject(this);
		Visual_Node.setAllowsChildren(false);

	}

	// Creat a node file whit the name title username password url expiration
	// keyword and note and link and Old Passwords
	public Node_File(String New_Name, String New_Title, String New_User_Name, String New_Password, String New_Url,
			String New_Expiration, String New_KeyWord, String New_Note, String New_Link, String New_Time_Created,
			boolean New_Favorite, Map<String, String> Imported_Old_Pass) {

		setName(New_Name);
		setTitle(New_Title);
		setUser_Name(New_User_Name);
		setPassword(New_Password);
		setUrl(New_Url);
		setKeyWord(New_KeyWord);
		setNote(New_Note);
		setLink(New_Link);
		setFavorite(New_Favorite);
		setExpiration(New_Expiration);
		setTime_Created(New_Time_Created);
		setOld_Password(Imported_Old_Pass);

		Visual_Node = new DefaultMutableTreeNode(Model.Integrity(New_Name));
		Visual_Node.setUserObject(this);
		Visual_Node.setAllowsChildren(false);

	}

	// Creat a node file whit the name title username password url expiration time
	// created and last modified
	// keyword and note and link and Old Passwords
	public Node_File(String New_Name, String New_Title, String New_User_Name, String New_Password, String New_Url,
			String New_Expiration, String New_KeyWord, String New_Note, String New_Link, String New_Time_Created,
			String New_Modified, boolean New_Favorite, Map<String, String> Imported_Old_Pass) {

		setName(New_Name);
		setTitle(New_Title);
		setUser_Name(New_User_Name);
		setPassword(New_Password);
		setUrl(New_Url);
		setKeyWord(New_KeyWord);
		setExpiration(New_Expiration);
		setNote(New_Note);
		setLink(New_Link);
		setTime_Created(New_Time_Created);
		setModified(New_Modified);
		setFavorite(New_Favorite);
		setOld_Password(Imported_Old_Pass);

		Visual_Node = new DefaultMutableTreeNode(Model.Integrity(New_Name));
		Visual_Node.setUserObject(this);
		Visual_Node.setAllowsChildren(false);

	}

	// Creat a node file whit the name title username password url expiration
	// keyword and note and link and parent
	public Node_File(String New_Title, String New_User_Name, String New_Password, String New_Url, String New_Expiration,
			String New_KeyWord, String New_Note, Node_Structure New_Parent) {

		setTitle(New_Title);
		setUser_Name(New_User_Name);
		setPassword(New_Password);
		setUrl(New_Url);
		setKeyWord(New_KeyWord);
		setExpiration(New_Expiration);
		setTime_Created();
		setNote(New_Note);

		Visual_Node = new DefaultMutableTreeNode(Model.Integrity(New_Title));
		Visual_Node.setUserObject(this);
		Visual_Node.setAllowsChildren(false);
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

			if (Parent != null) {

				if (Parent.File_Children.containsKey(New_Name) == false) {

					Parent.File_Children.remove(Name);
					Parent.File_Children.put(New_Name, this);

					Name = New_Name;
					Link = Parent.Get_Link() + New_Name + "/";
				}

			} else {

			}

		}

	}

	// Handle deleting the data inside
	public void Delete_File() {

		Visual_Node.removeFromParent();

		Visual_Node.setUserObject(null);
		Visual_Node = null;
		if (Parent != null) {

			if (Parent.File_Children.size() != 0) {

				if (Parent.File_Children.containsKey(Name)) {

					Parent.File_Children.remove(Name);
				}
			}
		}
		Parent = null;
		Name = null;
		Title = null;
		User_Name = null;
		Password = null;
		Url = null;
		KeyWord = null;
		Expiration = null;
		Note = null;
		System.gc();

	}

	// Compact or Retrieve all the data inside in a String []
	public String Compact_Data(String Seperator) {

		String[] Holder = Compact_Data_Array();

		String Final = "";

		if (Seperator != "" && Holder != null && Holder.length > 0) {

			if (Holder.length != 1) {

				for (int i = 0; i < Holder.length; i++) {

					if (i == Holder.length - 1) {

						Final += Model.Csv_Capsule_Inside + Holder[i] + Model.Csv_Capsule_Inside + Seperator;
					} else {
						Final += Model.Csv_Capsule_Inside + Holder[i] + Model.Csv_Capsule_Inside;

					}
				}
			} else {

				Final += Model.Csv_Capsule_Inside + Holder[0] + Model.Csv_Capsule_Inside;

			}
		}

		return Final;
	}

	// Compact or Retrieve all the data inside in a String []
	public String[] Compact_Data_Array() {

		String[] Holder = { getName(), getTitle(), getUser_Name(), getPassword(), getUrl(), getKeyWord(),
				getExpiration(), getModified(), getTime_Created(), getNote(), getFavorite_String(),
				getCompactOld_Password(Model.Csv_Inside_Seperator) };

		return Holder;
	}

	// Compact Headers for CSv
	public String[] Data_Header() {
		String[] Holder = { "Name", "Title", "User_Name", "Password", "Url", "KeyWord", "Expiration", "Modified",
				"Time_Created", "Note", "Favorite", "Old_Password" };

		return Holder;

	}

}
