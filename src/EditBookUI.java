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
    public EditBookUI(final DisplayManager dMgr, final MainManager mainMgr) {
        this.mainMgr = mainMgr;
        this.dMgr = dMgr;

        final JButton EditButton = new JButton("Update");
        setTitle("Edit Book");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{61, 79, 95, 120, 0};
        gbl_contentPane.rowHeights = new int[]{32, 25, 22, 22, 22, 22, 22, 22, 25, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);
        
                JButton SearchButton = new JButton("Edit Book");
                
                        SearchButton.setForeground(Color.WHITE);
                        SearchButton.setBackground(new Color(18, 97, 160));
                        GridBagConstraints gbc_SearchButton = new GridBagConstraints();
                        gbc_SearchButton.anchor = GridBagConstraints.NORTH;
                        gbc_SearchButton.insets = new Insets(0, 0, 5, 5);
                        gbc_SearchButton.gridwidth = 2;
                        gbc_SearchButton.gridx = 1;
                        gbc_SearchButton.gridy = 1;
                        contentPane.add(SearchButton, gbc_SearchButton);
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
                                
                                JButton DeleteButton = new JButton("Delete Book");
                                
                                        DeleteButton.setForeground(Color.WHITE);
                                        DeleteButton.setBackground(new Color(18, 97, 160));
                                        GridBagConstraints gbc_DeleteButton = new GridBagConstraints();
                                        gbc_DeleteButton.anchor = GridBagConstraints.NORTH;
                                        gbc_DeleteButton.fill = GridBagConstraints.HORIZONTAL;
                                        gbc_DeleteButton.insets = new Insets(0, 0, 5, 0);
                                        gbc_DeleteButton.gridx = 3;
                                        gbc_DeleteButton.gridy = 1;
                                        contentPane.add(DeleteButton, gbc_DeleteButton);
                                        
                                         DeleteButton.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                dMgr.displayDeleteBookUI();

                                                dispose();
                                            }
                                            });
                        
                                JLabel lblAuthor = new JLabel("Book Name:");
                                GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
                                gbc_lblAuthor.anchor = GridBagConstraints.NORTHWEST;
                                gbc_lblAuthor.insets = new Insets(0, 0, 5, 5);
                                gbc_lblAuthor.gridx = 1;
                                gbc_lblAuthor.gridy = 2;
                                contentPane.add(lblAuthor, gbc_lblAuthor);
                
                        BookName = new JTextField();
                        BookName.setColumns(10);
                        GridBagConstraints gbc_BookName = new GridBagConstraints();
                        gbc_BookName.anchor = GridBagConstraints.NORTHWEST;
                        gbc_BookName.insets = new Insets(0, 0, 5, 0);
                        gbc_BookName.gridx = 3;
                        gbc_BookName.gridy = 2;
                        contentPane.add(BookName, gbc_BookName);
        
                JLabel lblPublisher = new JLabel("Publisher");
                GridBagConstraints gbc_lblPublisher = new GridBagConstraints();
                gbc_lblPublisher.anchor = GridBagConstraints.NORTHWEST;
                gbc_lblPublisher.insets = new Insets(0, 0, 5, 5);
                gbc_lblPublisher.gridx = 1;
                gbc_lblPublisher.gridy = 3;
                contentPane.add(lblPublisher, gbc_lblPublisher);
                        
                                Publisher = new JTextField();
                                Publisher.setColumns(10);
                                GridBagConstraints gbc_Publisher = new GridBagConstraints();
                                gbc_Publisher.anchor = GridBagConstraints.NORTHWEST;
                                gbc_Publisher.insets = new Insets(0, 0, 5, 0);
                                gbc_Publisher.gridx = 3;
                                gbc_Publisher.gridy = 3;
                                contentPane.add(Publisher, gbc_Publisher);
                
                        JLabel lblNoOfCopies_1_1 = new JLabel("Author:");
                        GridBagConstraints gbc_lblNoOfCopies_1_1 = new GridBagConstraints();
                        gbc_lblNoOfCopies_1_1.fill = GridBagConstraints.HORIZONTAL;
                        gbc_lblNoOfCopies_1_1.insets = new Insets(0, 0, 5, 5);
                        gbc_lblNoOfCopies_1_1.gridwidth = 2;
                        gbc_lblNoOfCopies_1_1.gridx = 1;
                        gbc_lblNoOfCopies_1_1.gridy = 4;
                        contentPane.add(lblNoOfCopies_1_1, gbc_lblNoOfCopies_1_1);
                                
                                        AuthorName = new JTextField();
                                        AuthorName.setColumns(10);
                                        GridBagConstraints gbc_AuthorName = new GridBagConstraints();
                                        gbc_AuthorName.anchor = GridBagConstraints.NORTHWEST;
                                        gbc_AuthorName.insets = new Insets(0, 0, 5, 0);
                                        gbc_AuthorName.gridx = 3;
                                        gbc_AuthorName.gridy = 4;
                                        contentPane.add(AuthorName, gbc_AuthorName);
                        
                                JLabel lblNoOfCopies = new JLabel("No. of copies:");
                                GridBagConstraints gbc_lblNoOfCopies = new GridBagConstraints();
                                gbc_lblNoOfCopies.anchor = GridBagConstraints.WEST;
                                gbc_lblNoOfCopies.insets = new Insets(0, 0, 5, 5);
                                gbc_lblNoOfCopies.gridx = 1;
                                gbc_lblNoOfCopies.gridy = 5;
                                contentPane.add(lblNoOfCopies, gbc_lblNoOfCopies);
                        
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
                        gbc_lblNoOfCopies_1.anchor = GridBagConstraints.WEST;
                        gbc_lblNoOfCopies_1.insets = new Insets(0, 0, 5, 5);
                        gbc_lblNoOfCopies_1.gridwidth = 2;
                        gbc_lblNoOfCopies_1.gridx = 1;
                        gbc_lblNoOfCopies_1.gridy = 6;
                        contentPane.add(lblNoOfCopies_1, gbc_lblNoOfCopies_1);
        
                CopiesIssued = new JTextField();
                CopiesIssued.setColumns(10);
                GridBagConstraints gbc_CopiesIssued = new GridBagConstraints();
                gbc_CopiesIssued.anchor = GridBagConstraints.NORTHWEST;
                gbc_CopiesIssued.insets = new Insets(0, 0, 5, 0);
                gbc_CopiesIssued.gridx = 3;
                gbc_CopiesIssued.gridy = 6;
                contentPane.add(CopiesIssued, gbc_CopiesIssued);
        
                JLabel lblNoOfCopies_1_2 = new JLabel("ISBN:");
                GridBagConstraints gbc_lblNoOfCopies_1_2 = new GridBagConstraints();
                gbc_lblNoOfCopies_1_2.fill = GridBagConstraints.HORIZONTAL;
                gbc_lblNoOfCopies_1_2.insets = new Insets(0, 0, 5, 5);
                gbc_lblNoOfCopies_1_2.gridwidth = 2;
                gbc_lblNoOfCopies_1_2.gridx = 1;
                gbc_lblNoOfCopies_1_2.gridy = 7;
                contentPane.add(lblNoOfCopies_1_2, gbc_lblNoOfCopies_1_2);
        
                ISBNCode = new JTextField();
                ISBNCode.setColumns(10);
                GridBagConstraints gbc_ISBNCode = new GridBagConstraints();
                gbc_ISBNCode.anchor = GridBagConstraints.NORTHWEST;
                gbc_ISBNCode.insets = new Insets(0, 0, 5, 0);
                gbc_ISBNCode.gridx = 3;
                gbc_ISBNCode.gridy = 7;
                contentPane.add(ISBNCode, gbc_ISBNCode);
        
                EditButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        Book book = new Book(BookName.getText(), AuthorName.getText(), Publisher.getText(), ISBNCode.getText(), Integer.parseInt(Copies.getText()),
                                Integer.parseInt(CopiesIssued.getText()), mainMgr.getBookId());
                        boolean result = mainMgr.editBook(book);
                        if (result) {
                            JOptionPane.showMessageDialog(null, "Succesfully Edited Details!");
//                    dMgr.updateAllBooks();


                        } else {
                            JOptionPane.showMessageDialog(null, "Try again!",
                                    "Edit Book", JOptionPane.WARNING_MESSAGE);
                        }
                        dispose();
                    }
                });
                
                EditButton.setEnabled(false);
                EditButton.setBackground(new Color(18, 97, 160));
                EditButton.setForeground(Color.WHITE);
                GridBagConstraints gbc_EditButton = new GridBagConstraints();
                gbc_EditButton.anchor = GridBagConstraints.NORTH;
                gbc_EditButton.fill = GridBagConstraints.HORIZONTAL;
                gbc_EditButton.insets = new Insets(0, 0, 0, 5);
                gbc_EditButton.gridx = 2;
                gbc_EditButton.gridy = 8;
                contentPane.add(EditButton, gbc_EditButton);
    }
}
