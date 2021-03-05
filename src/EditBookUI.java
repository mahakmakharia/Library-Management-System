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
public class EditBookUI extends JFrame {

    private JPanel contentPane;
    private JTextField BookID;
    private JTextField BookName;
    private JTextField Publisher;
    private JTextField AuthorName;
    private JTextField Copies;
    private JTextField CopiesIssued;
    private JTextField ISBNCode;
    private MainManager mainMgr;
    DisplayManager dMgr;

    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditBookUI frame = new EditBookUI(new BookManager());
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
    public EditBookUI(DisplayManager dMgr, MainManager mainMgr) {
        this.mainMgr = mainMgr;
        this.dMgr = dMgr;
        setTitle("Edit Book");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton SearchButton = new JButton("Edit Book");
        SearchButton.setBounds(50, 32, 95, 25);

        SearchButton.setForeground(Color.WHITE);
        SearchButton.setBackground(new Color(18, 97, 160));
        contentPane.add(SearchButton);
        
        JButton DeleteButton = new JButton("Delete Book");
        DeleteButton.setBounds(160, 32, 120, 25);

        DeleteButton.setForeground(Color.WHITE);
        DeleteButton.setBackground(new Color(18, 97, 160));
        contentPane.add(DeleteButton);
        
         DeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dMgr.displayDeleteBookUI();
            }
            });

        JLabel lblAuthor = new JLabel("Book Name:");
        lblAuthor.setBounds(61, 62, 69, 16);
        contentPane.add(lblAuthor);

        BookName = new JTextField();
        BookName.setBounds(245, 62, 116, 22);
        BookName.setColumns(10);
        contentPane.add(BookName);

        JLabel lblPublisher = new JLabel("Publisher");
        lblPublisher.setBounds(61, 89, 52, 16);
        contentPane.add(lblPublisher);

        Publisher = new JTextField();
        Publisher.setBounds(245, 89, 116, 22);
        Publisher.setColumns(10);
        contentPane.add(Publisher);

        JLabel lblNoOfCopies_1_1 = new JLabel("Author:");
        lblNoOfCopies_1_1.setBounds(61, 119, 179, 16);
        contentPane.add(lblNoOfCopies_1_1);

        AuthorName = new JTextField();
        AuthorName.setBounds(245, 116, 116, 22);
        AuthorName.setColumns(10);
        contentPane.add(AuthorName);

        JLabel lblNoOfCopies = new JLabel("No. of copies:");
        lblNoOfCopies.setBounds(61, 146, 79, 16);
        contentPane.add(lblNoOfCopies);

        Copies = new JTextField();
        Copies.setBounds(245, 143, 116, 22);
        Copies.setColumns(10);
        contentPane.add(Copies);

        JLabel lblNoOfCopies_1 = new JLabel("No. of copies issued:");
        lblNoOfCopies_1.setBounds(61, 173, 119, 16);
        contentPane.add(lblNoOfCopies_1);

        CopiesIssued = new JTextField();
        CopiesIssued.setBounds(245, 170, 116, 22);
        CopiesIssued.setColumns(10);
        contentPane.add(CopiesIssued);

        final JButton EditButton = new JButton("Update");
        EditButton.setBounds(145, 228, 85, 25);
        EditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Book book = new Book(BookName.getText(), AuthorName.getText(), Publisher.getText(), ISBNCode.getText(), Integer.parseInt(Copies.getText()),
                        Integer.parseInt(CopiesIssued.getText()), mainMgr.getBookId());
                boolean result = mainMgr.editBook(book);
                if (result) {
                    JOptionPane.showMessageDialog(null, "Succesfully Edited Details!");
                } else {
                    JOptionPane.showMessageDialog(null, "Try again!",
                            "Edit Book", JOptionPane.WARNING_MESSAGE);
                }
                dispose();
            }
        });
        
        EditButton.setEnabled(false);
        SearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Book book = mainMgr.getBook(mainMgr.getBookId());

                BookName.setText(book.getBookName());
                AuthorName.setText(book.getAuthor());
                Publisher.setText(book.getPublisher());
                Copies.setText(String.valueOf(book.getNoOfCopies()));
                CopiesIssued.setText(String.valueOf(book.getNoOfCopiesIssued()));
                ISBNCode.setText(book.getISBNCode());
                EditButton.setEnabled(true);

            }
        });
        EditButton.setBackground(new Color(18, 97, 160));
        EditButton.setForeground(Color.WHITE);
        contentPane.add(EditButton);

        JLabel lblNoOfCopies_1_2 = new JLabel("ISBN:");
        lblNoOfCopies_1_2.setBounds(61, 205, 119, 16);
        contentPane.add(lblNoOfCopies_1_2);

        ISBNCode = new JTextField();
        ISBNCode.setColumns(10);
        ISBNCode.setBounds(245, 202, 116, 22);
        contentPane.add(ISBNCode);
    }
}
