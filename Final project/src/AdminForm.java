import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
public class AdminForm extends JFrame {

	private JFrame frame;
	private JTextField Fname;
	private JTextField LName;
	private JTextField UserName;
	private JPasswordField passwordField;;
	
	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminForm frame = new AdminForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	public AdminForm() {
		Connection connect= null;
		connect=DbConnect.dbConnect();
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(378, 0, 46, 14);
		getContentPane().add(lblNewLabel);
		
		Fname = new JTextField();
		Fname.setBounds(164, 21, 86, 20);
		getContentPane().add(Fname);
		Fname.setColumns(10);
		
		LName = new JTextField();
		LName.setBounds(164, 62, 86, 20);
		getContentPane().add(LName);
		LName.setColumns(10);
		
		UserName = new JTextField();
		UserName.setBounds(164, 104, 86, 20);
		getContentPane().add(UserName);
		UserName.setColumns(10);
		
		
		
	
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					Connection connect= DbConnect.dbConnect();
					String query ="select * from Admin where UserName=?;";
					int count=0;
					PreparedStatement pst= connect.prepareStatement(query);
					pst.setString(1, UserName.getText());
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						count=count+1;
					}
					if(count==1) {
						 JOptionPane.showMessageDialog(null, "username is already in use choose a diferent one");
						 }
					
					else {
//						rs.close();
//						pst.close();
						String query2 ="INSERT INTO Admin VALUES(?,?,?,?,?)";
						PreparedStatement pst2= connect.prepareStatement(query2);
						pst2.setString(2, Fname.getText());
						pst2.setString(3, LName.getText());
						pst2.setString(4, UserName.getText());
						pst2.setString(5,new String(passwordField.getPassword()));
						
						pst2.executeUpdate();
						 JOptionPane.showMessageDialog(null, "new admin registered succesfuly");
						 
				
				pst2.close();
				}
					}
				 catch (Exception e1) {
					   JOptionPane.showMessageDialog(null, "enter valid characters");
					} 
			
			}
		});
		button.setBounds(161, 227, 89, 23);
		getContentPane().add(button);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 152, 86, 20);
		getContentPane().add(passwordField);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
