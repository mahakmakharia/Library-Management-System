package javaapplication1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Manish
 */
public class AddBookUI extends JFrame {

    private JPanel contentPane;
    private JTextField BookName;
    private JTextField AuthorName;
    private JTextField Publisher;
    private JTextField BookID;
    private JTextField CopiesIssued;
    private JTextField Copies;
    private JLabel lblNoOfCopies_1_2;
    private JTextField ISBNCode;
    private DisplayManager dMgr;
    private MainManager mainMgr;

    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddBookUI frame = new AddBookUI(new DisplayManager(), new BookManager());
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
    public AddBookUI(DisplayManager dMgr, final MainManager mainMgr) {
        this.mainMgr = mainMgr;
        this.dMgr = dMgr;
        setTitle("Add Book");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{51, 74, 85, 116, 0};
        gbl_contentPane.rowHeights = new int[]{22, 22, 22, 22, 22, 22, 22, 25, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JLabel lblNewLabel = new JLabel("Book Name:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        BookName = new JTextField();
        GridBagConstraints gbc_BookName = new GridBagConstraints();
        gbc_BookName.anchor = GridBagConstraints.NORTHWEST;
        gbc_BookName.insets = new Insets(0, 0, 5, 0);
        gbc_BookName.gridx = 3;
        gbc_BookName.gridy = 0;
        contentPane.add(BookName, gbc_BookName);
        BookName.setColumns(10);

        JLabel lblAuthor = new JLabel("Author");
        GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
        gbc_lblAuthor.anchor = GridBagConstraints.NORTHWEST;
        gbc_lblAuthor.insets = new Insets(0, 0, 5, 5);
        gbc_lblAuthor.gridx = 1;
        gbc_lblAuthor.gridy = 1;
        contentPane.add(lblAuthor, gbc_lblAuthor);

        AuthorName = new JTextField();
        AuthorName.setColumns(10);
        GridBagConstraints gbc_AuthorName = new GridBagConstraints();
        gbc_AuthorName.anchor = GridBagConstraints.NORTHWEST;
        gbc_AuthorName.insets = new Insets(0, 0, 5, 0);
        gbc_AuthorName.gridx = 3;
        gbc_AuthorName.gridy = 1;
        contentPane.add(AuthorName, gbc_AuthorName);

        JLabel lblPublisher = new JLabel("Publisher");
        GridBagConstraints gbc_lblPublisher = new GridBagConstraints();
        gbc_lblPublisher.anchor = GridBagConstraints.NORTHWEST;
        gbc_lblPublisher.insets = new Insets(0, 0, 5, 5);
        gbc_lblPublisher.gridx = 1;
        gbc_lblPublisher.gridy = 2;
        contentPane.add(lblPublisher, gbc_lblPublisher);

        Publisher = new JTextField();
        Publisher.setColumns(10);
        GridBagConstraints gbc_Publisher = new GridBagConstraints();
        gbc_Publisher.anchor = GridBagConstraints.NORTHWEST;
        gbc_Publisher.insets = new Insets(0, 0, 5, 0);
        gbc_Publisher.gridx = 3;
        gbc_Publisher.gridy = 2;
        contentPane.add(Publisher, gbc_Publisher);

        JLabel lblNoOfCopies_1_1 = new JLabel("Book ID:");
        GridBagConstraints gbc_lblNoOfCopies_1_1 = new GridBagConstraints();
        gbc_lblNoOfCopies_1_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNoOfCopies_1_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNoOfCopies_1_1.gridwidth = 2;
        gbc_lblNoOfCopies_1_1.gridx = 1;
        gbc_lblNoOfCopies_1_1.gridy = 3;
        contentPane.add(lblNoOfCopies_1_1, gbc_lblNoOfCopies_1_1);

        BookID = new JTextField();
        BookID.setColumns(10);
        GridBagConstraints gbc_BookID = new GridBagConstraints();
        gbc_BookID.anchor = GridBagConstraints.NORTHWEST;
        gbc_BookID.insets = new Insets(0, 0, 5, 0);
        gbc_BookID.gridx = 3;
        gbc_BookID.gridy = 3;
        contentPane.add(BookID, gbc_BookID);

        lblNoOfCopies_1_2 = new JLabel("ISBN:");
        GridBagConstraints gbc_lblNoOfCopies_1_2 = new GridBagConstraints();
        gbc_lblNoOfCopies_1_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNoOfCopies_1_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNoOfCopies_1_2.gridwidth = 2;
        gbc_lblNoOfCopies_1_2.gridx = 1;
        gbc_lblNoOfCopies_1_2.gridy = 4;
        contentPane.add(lblNoOfCopies_1_2, gbc_lblNoOfCopies_1_2);

        ISBNCode = new JTextField();
        ISBNCode.setColumns(10);
        GridBagConstraints gbc_ISBNCode = new GridBagConstraints();
        gbc_ISBNCode.anchor = GridBagConstraints.NORTHWEST;
        gbc_ISBNCode.insets = new Insets(0, 0, 5, 0);
        gbc_ISBNCode.gridx = 3;
        gbc_ISBNCode.gridy = 4;
        contentPane.add(ISBNCode, gbc_ISBNCode);

        JLabel Jlbl = new JLabel("No. of copies");
        GridBagConstraints gbc_Jlbl = new GridBagConstraints();
        gbc_Jlbl.anchor = GridBagConstraints.WEST;
        gbc_Jlbl.insets = new Insets(0, 0, 5, 5);
        gbc_Jlbl.gridx = 1;
        gbc_Jlbl.gridy = 5;
        contentPane.add(Jlbl, gbc_Jlbl);

        Copies = new JTextField();
        Copies.setColumns(10);
        GridBagConstraints gbc_Copies = new GridBagConstraints();
        gbc_Copies.anchor = GridBagConstraints.NORTHWEST;
        gbc_Copies.insets = new Insets(0, 0, 5, 0);
        gbc_Copies.gridx = 3;
        gbc_Copies.gridy = 5;
        contentPane.add(Copies, gbc_Copies);

        JLabel lblNoOfCopies_1 = new JLabel("No. of copies issued:");
        GridBagConstraints gbc_lblNoOfCopies_1 = new GridBagConstraints();
        gbc_lblNoOfCopies_1.anchor = GridBagConstraints.NORTHWEST;
        gbc_lblNoOfCopies_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNoOfCopies_1.gridwidth = 2;
        gbc_lblNoOfCopies_1.gridx = 1;
        gbc_lblNoOfCopies_1.gridy = 6;
        contentPane.add(lblNoOfCopies_1, gbc_lblNoOfCopies_1);

        JButton btnNewButton = new JButton("Add Book");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Book book = new Book(BookName.getText(), AuthorName.getText(), Publisher.getText(), ISBNCode.getText(), Integer.parseInt(Copies.getText()),
                        Integer.parseInt(CopiesIssued.getText()), Integer.parseInt(BookID.getText()));

                if (BookName.getText() != null && AuthorName.getText() != null && Publisher.getText() != null
                        && ISBNCode.getText() != null && Copies.getText() != null && CopiesIssued.getText() != null && BookID.getText() != null) {
                    if (mainMgr.addBook(book)) {
                        JOptionPane.showMessageDialog(null, "Succesfully Added new Book!");
                        dispose();
                    }
                    JOptionPane.showMessageDialog(null, "Couldn't add book!",
                            "Login", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields!",
                            "Login", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        CopiesIssued = new JTextField();
        CopiesIssued.setColumns(10);
        GridBagConstraints gbc_CopiesIssued = new GridBagConstraints();
        gbc_CopiesIssued.anchor = GridBagConstraints.NORTHWEST;
        gbc_CopiesIssued.insets = new Insets(0, 0, 5, 0);
        gbc_CopiesIssued.gridx = 3;
        gbc_CopiesIssued.gridy = 6;
        contentPane.add(CopiesIssued, gbc_CopiesIssued);
        btnNewButton.setBackground(new Color(18, 97, 160));
        btnNewButton.setForeground(Color.WHITE);
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 2;
        gbc_btnNewButton.gridy = 7;
        contentPane.add(btnNewButton, gbc_btnNewButton);
    }
}
