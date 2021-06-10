	import java.sql.*;
	import javax.swing.*;

public class DbConnect {

	
		Connection conn=null;
		public static Connection dbConnect() {
			
			try {
				Class.forName("org.sqlite.JDBC");
				Connection conn= DriverManager.getConnection("jdbc:sqlite:C:\\Users\\jdalm\\git\\repository2\\Final project\\Database\\Emsdb.sqlite");
				JOptionPane.showMessageDialog(null, "connection succ");
				return conn;
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
				return null;
			}
			
			
			
		}

	}



