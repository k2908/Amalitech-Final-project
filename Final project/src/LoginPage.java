
import java.sql.*;
import java.util.Arrays;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class LoginPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	ImageIcon LoginPage= new ImageIcon("ok-icon.png");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connect= null;
	private JTextField textField1;
	private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
		connect=DbConnect.dbConnect();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame =  new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField1 = new JTextField();
		textField1.setBounds(203, 97, 86, 20);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query ="select * from admin where UserName=? and password=?";
					PreparedStatement pst= connect.prepareStatement(query);
					pst.setString(1, textField1.getText());
					pst.setString(2,new String (passwordField.getPassword()));	
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()) {
						count=count+1;
					}
					if(count==1) {
						 JOptionPane.showMessageDialog(null, "username and password is correct");
						frame.dispose();
						 AdminPage2 ggg= new AdminPage2();
						ggg.setVisible(true);
					}
					else if (count>1) {
						 JOptionPane.showMessageDialog(null, "duplicate username and password");}
					else {
						 JOptionPane.showMessageDialog(null, "username and password is not correct, try again");
						 }
				rs.close();
				pst.close();
				}
				 catch (Exception e1) {
					   JOptionPane.showMessageDialog(null, "enter a character");
					} 
			
			}
		});
		btnNewButton.setBounds(203, 206, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(55, 99, 79, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(55, 157, 79, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('K');
		passwordField.setBounds(206, 151, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("");
		//Image img = new ImageIcon(this.getClass().getResource("/LoginPage-icon.png")).getImage();
		
		lblNewLabel_2.setIcon((LoginPage));
		lblNewLabel_2.setBounds(39, 133, 96, 96);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel_3.setBackground(SystemColor.inactiveCaption);
		lblNewLabel_3.setBounds(141, 22, 220, 32);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Enter a valid username and password to connect");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_4.setBounds(72, 60, 326, 20);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
