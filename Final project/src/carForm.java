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

public class carForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField CarType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					carForm frame = new carForm();
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
	public carForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(163, 74, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		CarType = new JTextField();
		CarType.setBounds(163, 123, 86, 20);
		contentPane.add(CarType);
		CarType.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(163, 198, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					Connection connect= DbConnect.dbConnect();
					String query ="select * from Car where RegitrationNo=?;";
					int count=0;
					PreparedStatement pst= connect.prepareStatement(query);
					pst.setString(1, textField.getText());
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						count=count+1;
					}
					if(count==1) {
						 JOptionPane.showMessageDialog(null, "car is already registered");
						 }
					
					else {
//						rs.close();
//						pst.close();
						String query2 ="INSERT INTO Car VALUES(?,?,?)";
						PreparedStatement pst2= connect.prepareStatement(query2);
						pst2.setString(1, textField.getText());
						pst2.setString(2, CarType.getText());
						pst2.setString(3, new String("available"));						
						pst2.executeUpdate();
						 JOptionPane.showMessageDialog(null, "new car registered succesfuly");
						 
				
				pst2.close();
				}
					}
				 catch (Exception e1) {
					   JOptionPane.showMessageDialog(null, "enter valid characters");
					} 
			
			}
		});
	}

}
