import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.util.Calendar;
public class TaskForm extends JFrame {
	
	ArrayList cars = new ArrayList(1);
	ArrayList emt = new ArrayList(1);
	
	
	
public void getCar() {
	
	try {
		Connection connect= DbConnect.dbConnect();
//		String query ="select * from car";
//		PreparedStatement pst= connect.prepareStatement(query);
//		//pst.setString(1, new String("available"));
//		System.out.println(pst);
		Statement statement = connect.createStatement();
		 
		ResultSet results = statement.executeQuery("select RegitrationNo from car WHERE Status='available';");
		//ResultSet rs=pst.executeQuery();
		while(results.next()) {
			
			cars.add(results.getString(1));
			
			
			
			
		}
		}
//		if(count==1) {
//			 JOptionPane.showMessageDialog(null, "username is already in use choose a diferent one");
//			 }
		
		//else {
//			rs.close();
//			pst.close();
//			String query2 ="INSERT INTO Admin VALUES(?,?,?,?,?)";
//			PreparedStatement pst2= connect.prepareStatement(query2);
//			pst2.setString(2, Fname.getText());
//			pst2.setString(3, LName.getText());
//			pst2.setString(4, UserName.getText());
//			pst2.setString(5,new String(passwordField.getPassword()));
//			
//			pst2.executeUpdate();
//			 JOptionPane.showMessageDialog(null, "new admin registered succesfuly");
//			 
//	
//	pst2.close();
//	}
		//}
	 catch (Exception e1) {
		   JOptionPane.showMessageDialog(null, "enter valid characters");
		} }
	public void getEmt() {
		
		try {
			Connection connect= DbConnect.dbConnect();
//			String query ="select * from car";
//			PreparedStatement pst= connect.prepareStatement(query);
//			//pst.setString(1, new String("available"));
//			System.out.println(pst);
			Statement statement = connect.createStatement();
			 
			ResultSet results = statement.executeQuery("select id from Emt WHERE Status='available';");
			//ResultSet rs=pst.executeQuery();
			while(results.next()) {
				
				emt.add(results.getString(1));
				
				
				
				
			}
			}
//			if(count==1) {
//				 JOptionPane.showMessageDialog(null, "username is already in use choose a diferent one");
//				 }
			
			//else {
//				rs.close();
//				pst.close();
//				String query2 ="INSERT INTO Admin VALUES(?,?,?,?,?)";
//				PreparedStatement pst2= connect.prepareStatement(query2);
//				pst2.setString(2, Fname.getText());
//				pst2.setString(3, LName.getText());
//				pst2.setString(4, UserName.getText());
//				pst2.setString(5,new String(passwordField.getPassword()));
//				
//				pst2.executeUpdate();
//				 JOptionPane.showMessageDialog(null, "new admin registered succesfuly");
//				 
	//	
//		pst2.close();
//		}
			//}
		 catch (Exception e1) {
			   JOptionPane.showMessageDialog(null, "enter valid characters");
			} 

	
	
	
}
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskForm frame = new TaskForm();
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
	public TaskForm() {
		getCar();
		getEmt();
		Object[]array1=cars.toArray(new String[cars.size()]);
		Object[]array2=emt.toArray(new String[emt.size()]);
		Object[]array3=emt.toArray(new String[emt.size()]);
	//	JComboBox(cars<?>) comboBox = new JComboBox<cars>();
		//comboBox.setModel(new DefaultComboBoxModel<cars>(cars.toArray(new cars[0])));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(array1);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				 comboBox = (JComboBox)e.getSource();
//			        String petName = (String)cb.getSelectedItem();
//			        updateLabel(petName);
			}
		});
		comboBox.setBounds(148, 71, 159, 24);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(array2);
		comboBox_1.setBounds(148, 120, 140, 24);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(array3);
		comboBox_2.setBounds(148, 165, 140, 24);
		contentPane.add(comboBox_2);
		
		JButton btnNewButton = new JButton("Create a new task");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					
					Date dt=java.util.Calendar.getInstance().getTime();
					Connection connect= DbConnect.dbConnect();
						String query2 ="INSERT INTO Task VALUES(?,?,?,?,?,?,?)";
						PreparedStatement pst2 = connect.prepareStatement(query2);
						pst2.setString(2, new String("in progress"));
						System.out.println();
						pst2.setString(3, dt.toString());
						System.out.println(dt.toString());
						Object value=comboBox.getSelectedItem();
						Object value1= comboBox_1.getSelectedItem();
						Object value2=comboBox_2.getSelectedItem();
						pst2.setObject(5, value);
						pst2.setObject(6, value1);	
						pst2.setObject(7, value2);
						System.out.println(value);
						System.out.println(value1);
						System.out.println(pst2);
						pst2.executeUpdate();	
						 JOptionPane.showMessageDialog(null, "new task registered succesfuly");
						
				
				pst2.close();
				}
					
				 catch (Exception e1) {
					   JOptionPane.showMessageDialog(null, "enter valid characters");
					} 
			
			}
		});
		btnNewButton.setBounds(122, 213, 89, 23);
		contentPane.add(btnNewButton);
	}
}
