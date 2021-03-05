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
    public AdminDashboardUI(final DisplayManager dMgr) {
        this.dMgr = dMgr;
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{207, 211, 0};
        gbl_contentPane.rowHeights = new int[]{49, 29, 39, 25, 25, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JButton btnNewButton_2_2 = new JButton("View and Edit Books");
        btnNewButton_2_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dMgr.displayAllBooks();

            }
        });

        JLabel lblNewLabel = new JLabel("DASHBOARD");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
        gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridwidth = 2;
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 1;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        JButton btnNewButton_2 = new JButton("Add Book");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dMgr.displayAddBookUI();
            }
        });
        btnNewButton_2.setForeground(Color.WHITE);
        btnNewButton_2.setBackground(new Color(18, 97, 160));
        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.anchor = GridBagConstraints.NORTH;
        gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_2.gridx = 0;
        gbc_btnNewButton_2.gridy = 3;
        contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
        btnNewButton_2_2.setForeground(Color.WHITE);
        btnNewButton_2_2.setBackground(new Color(18, 97, 160));
        GridBagConstraints gbc_btnNewButton_2_2 = new GridBagConstraints();
        gbc_btnNewButton_2_2.anchor = GridBagConstraints.NORTH;
        gbc_btnNewButton_2_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_2_2.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_2_2.gridx = 1;
        gbc_btnNewButton_2_2.gridy = 3;
        contentPane.add(btnNewButton_2_2, gbc_btnNewButton_2_2);

        JButton btnNewButton_2_5 = new JButton("View Requests");
        btnNewButton_2_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dMgr.displayBookRequests();
            }
        });

        JButton btnNewButton_2_2_1 = new JButton("View Issued & Returned Books");
        btnNewButton_2_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dMgr.displayAllLoanedBooks();
            }
        });
        btnNewButton_2_2_1.setForeground(Color.WHITE);
        btnNewButton_2_2_1.setBackground(new Color(18, 97, 160));
        GridBagConstraints gbc_btnNewButton_2_2_1 = new GridBagConstraints();
        gbc_btnNewButton_2_2_1.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnNewButton_2_2_1.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton_2_2_1.gridx = 0;
        gbc_btnNewButton_2_2_1.gridy = 4;
        contentPane.add(btnNewButton_2_2_1, gbc_btnNewButton_2_2_1);
        btnNewButton_2_5.setForeground(Color.WHITE);
        btnNewButton_2_5.setBackground(new Color(18, 97, 160));
        GridBagConstraints gbc_btnNewButton_2_5 = new GridBagConstraints();
        gbc_btnNewButton_2_5.anchor = GridBagConstraints.NORTH;
        gbc_btnNewButton_2_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_2_5.gridx = 1;
        gbc_btnNewButton_2_5.gridy = 4;
        contentPane.add(btnNewButton_2_5, gbc_btnNewButton_2_5);
    }
}
