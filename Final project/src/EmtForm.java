import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class EmtForm extends JFrame {

	private JPanel contentPane;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField Expertise;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmtForm frame = new EmtForm();
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
	public EmtForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Fname = new JTextField();
		Fname.setBounds(164, 50, 86, 20);
		contentPane.add(Fname);
		Fname.setColumns(10);
		
		Lname = new JTextField();
		Lname.setBounds(164, 100, 86, 20);
		contentPane.add(Lname);
		Lname.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton.setBounds(164, 227, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					if(Fname.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "enter a proper first name");
					} 
					else {
						if(Lname.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "enter a proper last name");
						} else {
					Connection connect= DbConnect.dbConnect();
					
//						rs.close();
//						pst.close();
						String query2 ="INSERT INTO Emt VALUES(?,?,?,?,?)";
						PreparedStatement pst2= connect.prepareStatement(query2);
						pst2.setString(2, Fname.getText());
						pst2.setString(3, Lname.getText());
						pst2.setString(4, new String("available"));
						pst2.setString(5,Expertise.getText());
						
						pst2.executeUpdate();
						 JOptionPane.showMessageDialog(null, "new Emt registered succesfuly");
						 
				
				pst2.close();
				
					}
					}
	
				}
				 catch (Exception e1) {
					   JOptionPane.showMessageDialog(null, "enter valid characters");
					} 
			
			}
		});
		
		Expertise = new JTextField();
		Expertise.setBounds(164, 147, 86, 20);
		contentPane.add(Expertise);
		Expertise.setColumns(10);
		
		lblNewLabel = new JLabel("Welcome, Fill the form to register a new Emt");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(59, 0, 296, 39);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(42, 53, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(42, 103, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Expertise");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_3.setBounds(42, 153, 71, 14);
		contentPane.add(lblNewLabel_3);
		
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
		btnBack.setBounds(308, 146, 89, 23);
		contentPane.add(btnBack);
	}

}
