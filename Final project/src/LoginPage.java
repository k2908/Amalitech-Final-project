
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LoginPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	//ImageIcon LoginPage= new ImageIcon("ok-icon.png");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
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
		frame.setResizable(false);
		
		textField1 = new JTextField();
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
						rs.close();
						pst.close();
						 AdminPage2 ggg= new AdminPage2();
						ggg.setVisible(true);
					}
					else if (count>1) {
						 JOptionPane.showMessageDialog(null, "duplicate username and password");}
					
					else if (count==0){
						try {
							
							String query2 ="select * from user where UserName=? and password=?";
							PreparedStatement pst2= connect.prepareStatement(query2);
							pst2.setString(1, textField1.getText());
							
							pst2.setString(2,new String (passwordField.getPassword()));	
							ResultSet rs2=pst2.executeQuery();
							int count2=0;
							while(rs2.next()) {
								count2=count2+1;
							}
							if(count2==1) {
								 JOptionPane.showMessageDialog(null, "username and password is correct");
								frame.dispose();
								rs2.close();
								pst2.close();
								 UserPage ggg= new UserPage();
								ggg.setVisible(true);
							}
							else {
								JOptionPane.showMessageDialog(null, "username and password is not correct, try again");
								
							}
							
						}
						catch (Exception e1){
						 JOptionPane.showMessageDialog(null, "username and password is not correct, try again");
						}
				
				}
					}
				 catch (Exception e1) {
					   JOptionPane.showMessageDialog(null, "enter a valid character");
					} 
			
			}
		});
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('K');
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		JLabel lblNewLabel_3 = new JLabel("Welcome");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel_3.setBackground(SystemColor.inactiveCaption);
		
		JLabel lblNewLabel_4 = new JLabel("Enter a valid username and password to connect");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addGap(119))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
					.addGap(61))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
							.addGap(85)
							.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addGap(145))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(16)
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
									.addGap(1))
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
							.addGap(68)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
							.addGap(142))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField1)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(58))
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(passwordField)
							.addGap(35)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)))
					.addGap(32))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
