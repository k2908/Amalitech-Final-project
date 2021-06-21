import java.awt.BorderLayout;
import java.awt.EventQueue;

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

import javax.swing.border.EmptyBorder;

public class UserForm extends JFrame {

	private JPanel contentPane;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField Username;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserForm frame = new UserForm();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Connection connect= null;
		connect=DbConnect.dbConnect();
		
		JLabel lblNewLabel = new JLabel("Welcome, Fill the form to register a new user");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(41, 0, 338, 25);
		contentPane.add(lblNewLabel);
		
		Fname = new JTextField();
		Fname.setBounds(190, 36, 86, 20);
		contentPane.add(Fname);
		Fname.setColumns(10);
		
		Lname = new JTextField();
		Lname.setBounds(190, 73, 86, 20);
		contentPane.add(Lname);
		Lname.setColumns(10);
		
		Username = new JTextField();
		Username.setBounds(190, 118, 86, 20);
		contentPane.add(Username);
		Username.setColumns(10);
		
		JButton btnNewButton = new JButton("New user");
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton.setBounds(187, 205, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					if(Fname.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "enter a proper first name");
					} else {
						if(Lname.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "enter a proper last name");
						} else {
							if(Username.getText().isEmpty()){							
								JOptionPane.showMessageDialog(null, "enter a proper username");
							} else {
								if(passwordField.getPassword().length==0){
							
								JOptionPane.showMessageDialog(null, "password cannot be empty");
							} else {
					
					Connection connect= DbConnect.dbConnect();
					String query ="select * from User where UserName=?;";
					int count=0;
					PreparedStatement pst= connect.prepareStatement(query);
					pst.setString(1, Username.getText());
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
						String query2 ="INSERT INTO User VALUES(?,?,?,?,?)";
						PreparedStatement pst2= connect.prepareStatement(query2);
						pst2.setString(2, Fname.getText());
						pst2.setString(3, Lname.getText());
						pst2.setString(4, Username.getText());
						pst2.setString(5,new String(passwordField.getPassword()));
						
						pst2.executeUpdate();
						 JOptionPane.showMessageDialog(null, "new user registered succesfuly");
						 
				
				pst2.close();
				}
					}}}}}
				 catch (Exception e1) {
					   JOptionPane.showMessageDialog(null, "enter valid characters");
					} 
			
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 167, 86, 20);
		contentPane.add(passwordField);
		
		lblNewLabel_1 = new JLabel("First name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(51, 42, 90, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Last name");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(51, 76, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_3.setBounds(51, 121, 90, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_4.setBounds(51, 173, 90, 14);
		contentPane.add(lblNewLabel_4);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if (DbConnect.g==1)
				{	UserPage ggg= new UserPage();
				ggg.setVisible(true);}
				else if (DbConnect.g==2)
				{	AdminPage2 ggg= new AdminPage2();
				ggg.setVisible(true);}
				
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnBack.setBounds(311, 166, 89, 23);
		contentPane.add(btnBack);
	}

}
