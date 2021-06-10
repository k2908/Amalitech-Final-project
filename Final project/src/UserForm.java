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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserForm frame = new UserForm();
					frame.setVisible(true);
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(207, 11, 46, 14);
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(187, 205, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
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
					}
				 catch (Exception e1) {
					   JOptionPane.showMessageDialog(null, "enter valid characters");
					} 
			
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 167, 86, 20);
		contentPane.add(passwordField);
	}

}
