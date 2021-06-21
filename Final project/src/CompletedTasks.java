import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CompletedTasks extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompletedTasks frame = new CompletedTasks();
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
	public CompletedTasks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("View Completed Tasks");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection connect= DbConnect.dbConnect();
				String query ="select * from Task where Status=?;";
				int count=0;
				PreparedStatement pst= connect.prepareStatement(query);
				
					pst.setString(1,new String ("completed"));
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
		btnNewButton.setBounds(183, 20, 295, 23);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 54, 579, 307);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_1.setBounds(631, 204, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
