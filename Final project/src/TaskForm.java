import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.util.Calendar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
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
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskForm frame = new TaskForm();
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
	public TaskForm() {
		getCar();
		getEmt();
		Object[]array1=cars.toArray(new String[cars.size()]);
		Object[]array2=emt.toArray(new String[emt.size()]);
		Object[]array3=emt.toArray(new String[emt.size()]);
	//	JComboBox(cars<?>) comboBox = new JComboBox<cars>();
		//comboBox.setModel(new DefaultComboBoxModel<cars>(cars.toArray(new cars[0])));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 745);
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
		JTextArea textArea = new JTextArea();
		textArea.setBounds(351, 182, 208, 43);
		contentPane.add(textArea);
		
		comboBox.setBounds(351, 59, 208, 24);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(array2);
		comboBox_1.setBounds(351, 94, 208, 24);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(array3);
		comboBox_2.setBounds(351, 141, 208, 24);
		contentPane.add(comboBox_2);
		
		JButton btnNewButton = new JButton("Create a new task");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox_1.getSelectedItem()==comboBox_2.getSelectedItem()) {
					 JOptionPane.showMessageDialog(null, "same Emt cannot be assigned twice");
				}
				else {
				try {
					String jake=textArea.getText();
					Date dt=java.util.Calendar.getInstance().getTime();
					Connection connect= DbConnect.dbConnect();
						String query2 ="INSERT INTO Task VALUES(?,?,?,?,?,?,?,?)";
						String query3 ="UPDATE Emt SET Status =?  WHERE id=?";
						String query4 ="UPDATE Emt SET Status =?  WHERE id=?";
						String query5 ="UPDATE car SET Status =?  WHERE regitrationNo=?";
						
						PreparedStatement pst2 = connect.prepareStatement(query2);
						PreparedStatement pst3 = connect.prepareStatement(query3);
						PreparedStatement pst4 = connect.prepareStatement(query4);
						PreparedStatement pst5 = connect.prepareStatement(query5);
						pst2.setString(2, new String("in progress"));
						pst3.setString(1, new String("not available"));
						pst4.setString(1, new String("not available"));
						pst2.setString(8, jake);
						pst2.setString(3, dt.toString());
						
						Object value=comboBox.getSelectedItem();
						Object value1= comboBox_1.getSelectedItem();
						Object value2=comboBox_2.getSelectedItem();
						pst2.setObject(5, value);
						pst2.setObject(6, value1);	
						pst2.setObject(7, value2);
						pst3.setObject(2, value1);
						pst4.setObject(2, value2);	
						pst5.setObject(2, value);
						pst5.setString(1,new String("not available"));
						pst2.executeUpdate();
						pst3.executeUpdate();
						pst4.executeUpdate();
						pst5.executeUpdate();
						System.out.println("send message to concerned Emts");
						 JOptionPane.showMessageDialog(null, "new task registered succesfuly");
						
				
				pst2.close();
				pst3.close();
				pst4.close();
				pst5.close();
			dispose();
				if (DbConnect.g==1)
				{	UserPage ggg= new UserPage();
				ggg.setVisible(true);}
				else if (DbConnect.g==2)
				{	AdminPage2 ggg= new AdminPage2();
				ggg.setVisible(true);}
				}
					
				 catch (Exception e1) {
					   JOptionPane.showMessageDialog(null, "enter valid characters");
					} }
			
			}
		});
		btnNewButton.setBounds(351, 257, 208, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Welcome, Fill the form to create a new task");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(327, 11, 273, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Available cars");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(161, 69, 92, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("First Emt");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(161, 106, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Second Emt");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_3.setBounds(161, 141, 92, 14);
		contentPane.add(lblNewLabel_3);
		
//		JTextArea textArea = new JTextArea();
//		textArea.setBounds(148, 184, 208, 43);
//		contentPane.add(textArea);
//		String jake=textArea.getText();
		JLabel lblNewLabel_4 = new JLabel("Task details");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_4.setBounds(161, 198, 92, 14);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(484, 291, 439, 318);
		contentPane.add(scrollPane_3);
		
		table = new JTable();
		scrollPane_3.setViewportView(table);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 291, 441, 318);
		contentPane.add(scrollPane_2);
		
		table_1 = new JTable();
		scrollPane_2.setViewportView(table_1);
		
		JButton btnNewButton_1 = new JButton("Emt's");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try {
				Connection connect= DbConnect.dbConnect();
				String query ="select * from Emt where Status=?;";
				int count=0;
				PreparedStatement pst= connect.prepareStatement(query);
				
					pst.setString(1,new String ("available"));
					ResultSet rs=pst.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
					while(rs.next()) {
						count=count+1;}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
			
		});
		
		btnNewButton_1.setBounds(214, 620, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cars");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connect= DbConnect.dbConnect();
					String query ="select * from Car where Status=?;";
					int count=0;
					PreparedStatement pst= connect.prepareStatement(query);
					
						pst.setString(1,new String ("available"));
						ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
						while(rs.next()) {
							count=count+1;}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					}
				
			});
			
		btnNewButton_2.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_2.setBounds(681, 620, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Back");
		btnNewButton_1_1.addActionListener(new ActionListener() {
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
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_1_1.setBounds(423, 620, 89, 23);
		contentPane.add(btnNewButton_1_1);
	}
}
