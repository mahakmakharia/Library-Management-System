package javaapplication1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

/**
 *
 * @author Manish
 */

public class StudentDashboardUI extends JFrame {

	private JPanel contentPane;
        private DisplayManager dMgr;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StudentDashboardUI frame = new StudentDashboardUI(new BookManager(),123);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public StudentDashboardUI(final DisplayManager dMgr) {
                this.dMgr = dMgr;
		setTitle("Student Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
//		JButton btnNewButton_2_2_1 = new JButton("Issue Books");
//		btnNewButton_2_2_1.setBounds(217, 107, 195, 25);
//		btnNewButton_2_2_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//                          dMgr.displayIssueBookUI();
//			}
//		});
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DASHBOARD");
		lblNewLabel.setBounds(5, 49, 410, 29);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2_2 = new JButton("View and Loan Books");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dMgr.displayAllBooks();
			}
		});
		btnNewButton_2_2.setBounds(115, 110, 195, 25);
		btnNewButton_2_2.setForeground(Color.WHITE);
		btnNewButton_2_2.setBackground(new Color(18, 97, 160));
		contentPane.add(btnNewButton_2_2);
//		btnNewButton_2_2_1.setForeground(Color.WHITE);
//		btnNewButton_2_2_1.setBackground(new Color(18, 97, 160));
//		contentPane.add(btnNewButton_2_2_1);
		
//		JButton btnNewButton_2_2_2 = new JButton("Return Book");
//                btnNewButton_2_2_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dMgr.displayReturnBookUI();
//			}
//		});
//		btnNewButton_2_2_2.setBounds(12, 137, 195, 25);
//		btnNewButton_2_2_2.setForeground(Color.WHITE);
//		btnNewButton_2_2_2.setBackground(new Color(18, 97, 160));
//		contentPane.add(btnNewButton_2_2_2);
		
		JButton btnNewButton_2_2_3 = new JButton("Request Books");
		btnNewButton_2_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dMgr.displayRequestBookUI();
			}
		});
		btnNewButton_2_2_3.setBounds(115, 148, 195, 25);
		btnNewButton_2_2_3.setForeground(Color.WHITE);
		btnNewButton_2_2_3.setBackground(new Color(18, 97, 160));
		contentPane.add(btnNewButton_2_2_3);
	}
}
