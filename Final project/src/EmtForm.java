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

public class EmtForm extends JFrame {

	private JPanel contentPane;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField Expertise;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmtForm frame = new EmtForm();
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(164, 227, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
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
				 catch (Exception e1) {
					   JOptionPane.showMessageDialog(null, "enter valid characters");
					} 
			
			}
		});
		
		Expertise = new JTextField();
		Expertise.setBounds(164, 147, 86, 20);
		contentPane.add(Expertise);
		Expertise.setColumns(10);
	}

}
