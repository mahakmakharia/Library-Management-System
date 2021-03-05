package javaapplication1;

/**
 *
 * @author Manish
 */
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

public class AdminDashboardUI extends JFrame {

    private BookManager MGR;
    private JPanel contentPane;
    private DisplayManager dMgr;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    AdminDashboardUI frame = new AdminDashboardUI(new DisplayManager(), new BookManager());
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
    /**
     * Create the frame.
     */
    public AdminDashboardUI(DisplayManager dMgr) {
        this.dMgr = dMgr;
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("DASHBOARD");
        lblNewLabel.setBounds(5, 44, 422, 29);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        contentPane.add(lblNewLabel);

        JButton btnNewButton_2 = new JButton("Add Book");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dMgr.displayAddBookUI();
            }
        });
        btnNewButton_2.setBounds(80, 120, 200, 25);
        btnNewButton_2.setForeground(Color.WHITE);
        btnNewButton_2.setBackground(new Color(18, 97, 160));
        contentPane.add(btnNewButton_2);

//        JButton btnNewButton_2_1 = new JButton("Delete Books");
//        btnNewButton_2_1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                dMgr.displayDeleteBookUI();
//            }
//        });
//        btnNewButton_2_1.setBounds(243, 120, 184, 25);
//        btnNewButton_2_1.setForeground(Color.WHITE);
//        btnNewButton_2_1.setBackground(new Color(18, 97, 160));
//        contentPane.add(btnNewButton_2_1);

        JButton btnNewButton_2_2 = new JButton("View and Edit Books");
        btnNewButton_2_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dMgr.displayAllBooks();

            }
        });
        btnNewButton_2_2.setBounds(50, 150, 240, 25);
        btnNewButton_2_2.setForeground(Color.WHITE);
        btnNewButton_2_2.setBackground(new Color(18, 97, 160));
        contentPane.add(btnNewButton_2_2);

//        JButton btnNewButton_2_3 = new JButton("Edit Book");
//        btnNewButton_2_3.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                dMgr.displayEditBookUI();
//            }
//        });
//        btnNewButton_2_3.setBounds(243, 150, 184, 25);
//        btnNewButton_2_3.setForeground(Color.WHITE);
//        btnNewButton_2_3.setBackground(new Color(18, 97, 160));
//        contentPane.add(btnNewButton_2_3);

        JButton btnNewButton_2_5 = new JButton("View Requests");
        btnNewButton_2_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dMgr.displayBookRequests();
            }
        });
        btnNewButton_2_5.setBounds(243, 180, 160, 25);
        btnNewButton_2_5.setForeground(Color.WHITE);
        btnNewButton_2_5.setBackground(new Color(18, 97, 160));
        contentPane.add(btnNewButton_2_5);

        JButton btnNewButton_2_2_1 = new JButton("View Issued & Returned Books");
        btnNewButton_2_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dMgr.displayAllLoanedBooks();
            }
        });
        btnNewButton_2_2_1.setForeground(Color.WHITE);
        btnNewButton_2_2_1.setBackground(new Color(18, 97, 160));
        btnNewButton_2_2_1.setBounds(5, 180, 250, 25);
        contentPane.add(btnNewButton_2_2_1);
    }
}
