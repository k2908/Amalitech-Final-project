import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

//import net.proteanit.sql.DbUtils;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ShowTasks extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowTasks frame = new ShowTasks();
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
	public ShowTasks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 30, 589, 290);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Show active tasks");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection connect= DbConnect.dbConnect();
				String query ="select * from Task where Status=?;";
				int count=0;
				PreparedStatement pst= connect.prepareStatement(query);
				
					pst.setString(1,new String ("in progress"));
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
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(251, 0, 172, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Mark task as complete");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(713, 5, 174, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(766, 117, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Complete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date dt=java.util.Calendar.getInstance().getTime();
					Connection connect= DbConnect.dbConnect();
					String query1 ="select car from Task where id=?;";
					String query2="select Emt1 from Task where id=?;";
					String query3 ="select Emt2 from Task where id=?;";
					String query4 ="UPDATE Emt SET Status =?  WHERE id=?";
					String query5 ="UPDATE Emt SET Status =?  WHERE id=?";
					String query6 ="UPDATE car SET Status =?  WHERE RegitrationNo=?";
					String query7 ="UPDATE Task SET Status =?  WHERE id=?";
					String query8 ="UPDATE Task SET EndTime=?  WHERE id=?";
					int count=0;
					PreparedStatement pst1= connect.prepareStatement(query1);
					PreparedStatement pst2 = connect.prepareStatement(query2);
					PreparedStatement pst3 = connect.prepareStatement(query3);
					PreparedStatement pst4 = connect.prepareStatement(query4);
					PreparedStatement pst5 = connect.prepareStatement(query5);
					PreparedStatement pst6 = connect.prepareStatement(query6);
					PreparedStatement pst7 = connect.prepareStatement(query7);
					PreparedStatement pst8 = connect.prepareStatement(query8);
					pst8.setString(1, dt.toString());
				
					
//					System.out.println(rs);
//					
//					System.out.println(rs2);
//					System.out.println(rs3);
					
					pst1.setObject(1, textField.getText());
					pst2.setObject(1, textField.getText());
					pst3.setObject(1, textField.getText());
					pst7.setObject(2, textField.getText());
					pst4.setString(1, new String("available"));
					ResultSet rs=pst1.executeQuery();
					ResultSet rs2=pst2.executeQuery();
					ResultSet rs3=pst3.executeQuery();
					pst4.setObject(2,rs2);
					pst5.setString(1, new String("available"));
					pst5.setObject(2,rs3);
					pst6.setString(1, new String("available"));
					pst6.setObject(2,rs);
					pst7.setString(1, new String("completed"));
					pst7.setObject(2, textField.getText());
					pst8.setString(1, dt.toString());
					pst8.setObject(2, textField.getText());
//					pst3.setString(1, new String("not available"));
//					pst4.setString(1, new String("not available"));
//						pst.setString(1,new String ("in progress"));
//						ResultSet rs=pst.executeQuery();
//				table.setModel(DbUtils.resultSetToTableModel(rs));
//						while(rs.next()) {
//							count=count+1;}

					
				
					pst4.executeUpdate();
					pst5.executeUpdate();
					pst6.executeUpdate();
					pst7.executeUpdate();
					pst8.executeUpdate();
					System.out.println(pst1);
					System.out.println(pst2);
					System.out.println(pst3);
					System.out.println(pst4);
					System.out.println(pst5);
					System.out.println(pst6);
					System.out.println(pst7);
					
					
					pst1.close();
					pst2.close();
					pst3.close();
					pst4.close();
					pst5.close();
					pst6.close();
					pst7.close();
				} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_1.setBounds(763, 211, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Task Id");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(763, 75, 89, 14);
		contentPane.add(lblNewLabel_1);
	}
}
