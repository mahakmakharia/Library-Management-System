package javaapplication1;

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

/**
 *
 * @author Manish
 */
public class ViewRequestsUI extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JLabel lblNewLabel;

    private String columnNames[] = {"User ID", "Book Name", "Date", "Author"};
    private String[][] data = new String[100][5];
    private MainManager mainMgr;

    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewRequestsUI frame = new ViewRequestsUI(new BookRequestManager());
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
    public ViewRequestsUI(MainManager mainMgr) {
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

        ArrayList<BookRequest> requests = mainMgr.getBookRequests();

        for (int i = 0; i < requests.size(); i++) {
            BookRequest b = requests.get(i);
            System.out.println(b.getBookName());
            data[i][0] = String.valueOf(b.getUserId());
            data[i][1] = b.getRequestId();
            data[i][2] = b.getBookName();
            data[i][3] = b.getPublisher();
            data[i][4] = b.getAuthorName();

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
