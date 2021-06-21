import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class UserPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage frame = new UserPage();
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
	public UserPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Create new tasks");
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaskForm ggg= new TaskForm();
				ggg.setVisible(true);
				dispose();
				DbConnect.g=1;
			}
		});
		btnNewButton.setBounds(31, 110, 152, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show acive tasks");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowTasks ggg= new ShowTasks();
				ggg.setVisible(true);
				dispose();
				DbConnect.g=1;
			}
		});
		btnNewButton_1.setBounds(222, 110, 146, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Welcome ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(131, 26, 159, 42);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Show completed tasks");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompletedTasks ggg= new CompletedTasks();
				ggg.setVisible(true);
				dispose();
				DbConnect.g=1;
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_2.setBounds(116, 170, 174, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Log out");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnNewButton_3) {
				dispose();
				LoginPage ggg= new LoginPage();
				LoginPage.main(null);
				}
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton_3.setBounds(160, 227, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
