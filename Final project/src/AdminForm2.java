import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AdminForm2 extends JFrame {

	private JPanel contentPane;
	private JTextField FName;
	private JTextField LName;
	private JTextField UserName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminForm2 frame = new AdminForm2();
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
	public AdminForm2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		FName = new JTextField();
		FName.setBounds(165, 45, 207, 20);
		contentPane.add(FName);
		FName.setColumns(10);
		
		LName = new JTextField();
		LName.setBounds(165, 84, 207, 20);
		contentPane.add(LName);
		LName.setColumns(10);
		
		UserName = new JTextField();
		UserName.setBounds(165, 126, 207, 20);
		contentPane.add(UserName);
		UserName.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(FName.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "enter a proper first name");
					} else {
						if(LName.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "enter a proper last name");
						} else {
							if(UserName.getText().isEmpty()){
								JOptionPane.showMessageDialog(null, "enter a proper username");
							} else {
								if(passwordField.getPassword().length==0){
							
								JOptionPane.showMessageDialog(null, "password cannot be empty");
							} else {
						
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
						pst2.setString(2, FName.getText());
						pst2.setString(3, LName.getText());
						pst2.setString(4, UserName.getText());
						pst2.setString(5,new String(passwordField.getPassword()));						
						pst2.executeUpdate();
						 JOptionPane.showMessageDialog(null, "new admin registered succesfuly");
						 
						 
				dispose();
				AdminPage2 ggg= new AdminPage2();
				ggg.setVisible(true);
				pst2.close();
				}
					}}}}}
				 catch (Exception e1) {
					   JOptionPane.showMessageDialog(null, "enter valid characters");
					} 
			
			}
		});
			
		
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton.setBounds(165, 224, 207, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("welcome , fill the form to register a new administrator");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 11, 332, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Firtst name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(40, 48, 85, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last name");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(40, 87, 85, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_3.setBounds(40, 129, 85, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("password");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_4.setBounds(40, 172, 85, 14);
		contentPane.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(165, 169, 207, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
					AdminPage2 ggg= new AdminPage2();
				ggg.setVisible(true);
					
					
				
			}
		});
		btnNewButton_1.setBounds(36, 224, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
