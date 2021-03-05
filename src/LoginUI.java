package javaapplication1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Osama
 */
public class LoginUI extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private String userType;
    private DisplayManager dMgr;
    private MainManager mainMgr;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    LoginUI frame = new LoginUI(new DisplayManager(), new LoginManager(), new BookManager());
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
    public LoginUI(final DisplayManager dMgr, final MainManager mainMgr) {
        setTitle("Login");
        this.dMgr = dMgr;
        this.mainMgr = mainMgr;
        userType = "student";

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("UserId");
        lblNewLabel.setBounds(91, 63, 92, 16);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(188, 60, 116, 22);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setBounds(166, 144, 92, 25);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(new Color(18, 97, 160));

        JCheckBox chckbxNewCheckBox = new JCheckBox("admin");
        chckbxNewCheckBox.setBounds(188, 114, 116, 25);
        chckbxNewCheckBox.setBackground(Color.WHITE);

        chckbxNewCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                userType = e.getStateChange() == 1 ? "admin" : "student";
            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String userId = new String(textField.getText()), password = new String(passwordField.getPassword());
                String result = null;

                if ("".equals(userId) && "".equals(password)) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields!",
                            "Login", JOptionPane.WARNING_MESSAGE);

                } else {
                    result = mainMgr.verifyUser(Integer.parseInt(userId), password, userType);
                    if (result != null) {
                        mainMgr.setCurrentUserId(Integer.parseInt(userId));
                        mainMgr.setUserType(userType);
                        JOptionPane.showMessageDialog(null, "Succesfully Logged in!");

                        if (userType.equals("admin")) {
                            dMgr.displayAdminUI();
                        } else {
                            dMgr.displayStudentUI();
                        }
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Credentials!",
                                "Login", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        JLabel lblNewLabel_1 = new JLabel("Password");
        lblNewLabel_1.setBounds(91, 90, 63, 16);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblNewLabel_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(188, 87, 116, 22);
        contentPane.add(passwordField);
        contentPane.add(chckbxNewCheckBox);
        contentPane.add(btnNewButton);
    }
}
