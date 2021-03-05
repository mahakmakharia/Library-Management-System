package javaapplication1;

/**
 *
 * @author Manish
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BookLoanUI extends JFrame {

    private JPanel contentPane;
    private String columnNames[] = {"User ID", "Book ID", "Request ID", "Date of Issue", "Date of Return"};
    private String[][] data = new String[100][5];

    private MainManager mainMgr;

    private JTable table;
    private JLabel lblNewLabel;

    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookLoanUI frame = new BookLoanUI(new MainManager());
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
    public BookLoanUI(MainManager mainMgr) {
        this.mainMgr = mainMgr;
        setTitle("Books Issued and Returned");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{432, 0};
        gbl_contentPane.rowHeights = new int[]{33, 194, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        lblNewLabel = new JLabel("Books Issued & Returned");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblNewLabel.setForeground(Color.BLACK);
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 1;
        contentPane.add(scrollPane, gbc_scrollPane);

        ArrayList<BookLoanStatus> loans = mainMgr.getBooksLoaned();

        for (int i = 0; i < loans.size(); i++) {
            BookLoanStatus b = loans.get(i);

            data[i][0] = String.valueOf(b.getUserId());
            data[i][1] = String.valueOf(b.getBookId());
            data[i][2] = String.valueOf(b.getIssueId());
            data[i][3] = b.getIssueDate();
            data[i][4] = b.getReturnDate();

        }
        table = new JTable(data, columnNames);
        table.setModel(new DefaultTableModel(
                data,
                columnNames
        ) {
            /**
             *
             */
            private static final long serialVersionUID = 1L;
            boolean[] columnEditables = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });

        scrollPane.setViewportView(table);

    }
}
