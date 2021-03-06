 import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AdminPage2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage2 frame = new AdminPage2();
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
	public AdminPage2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 228, 225));
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 AdminForm2 ggg= new AdminForm2();
					ggg.setVisible(true);
					DbConnect.g=2;
					dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.setBounds(40, 38, 164, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add user");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 UserForm ggg= new UserForm();
					ggg.setVisible(true);
					DbConnect.g=2;
					dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1.setBackground(new Color(135, 206, 235));
		btnNewButton_1.setForeground(new Color(0, 128, 128));
		btnNewButton_1.setBounds(245, 38, 164, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add Car");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 carForm ggg= new carForm();
					ggg.setVisible(true);
					DbConnect.g=2;;
					dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_2.setForeground(new Color(0, 128, 128));
		btnNewButton_2.setBackground(new Color(135, 206, 235));
		btnNewButton_2.setBounds(40, 144, 164, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add Emt");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 EmtForm ggg= new EmtForm();
					ggg.setVisible(true);
					DbConnect.g=2;
					dispose();}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_3.setForeground(new Color(0, 128, 128));
		btnNewButton_3.setBackground(new Color(135, 206, 235));
		btnNewButton_3.setBounds(245, 194, 164, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(172, 11, 89, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnCreateNewTask = new JButton("Log out");
		btnCreateNewTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginPage ggg= new LoginPage();
				LoginPage.main(null);
			}
		});
		btnCreateNewTask.setForeground(new Color(0, 128, 128));
		btnCreateNewTask.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnCreateNewTask.setBackground(new Color(135, 206, 235));
		btnCreateNewTask.setBounds(40, 89, 164, 23);
		contentPane.add(btnCreateNewTask);
		
		JButton btnNewButton_1_1 = new JButton("Show Completed tasks");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompletedTasks ggg= new CompletedTasks();
				ggg.setVisible(true);
				DbConnect.g=2;
				dispose();
			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 128, 128));
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_1.setBackground(new Color(135, 206, 235));
		btnNewButton_1_1.setBounds(245, 89, 164, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Show Active tasks");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowTasks ggg= new ShowTasks();
				ggg.setVisible(true);
				DbConnect.g=2;
				dispose();
			}
		});
		btnNewButton_1_1_1.setForeground(new Color(0, 128, 128));
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_1_1.setBackground(new Color(135, 206, 235));
		btnNewButton_1_1_1.setBounds(245, 144, 164, 23);
		contentPane.add(btnNewButton_1_1_1);
	}

}
