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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Manish
 */
public class ViewBooksUI extends JFrame {

    private JPanel contentPane;
    private String columnNames[] = {"Book ID", "Name of Book", "Author", "Publisher", "No. of Copies", "No. of Copies Issued"};
    private String[][] data = new String[100][6];
//    private ArrayList<Book> books;

    private JTable table;
    private JTextField textField;
    private DisplayManager dMgr;
    private MainManager mainMgr;

    public boolean updateData() {
    	ArrayList<Book> books=mainMgr.getAllBooks();
    	 data = new String[100][6];
         for (int i = 0; i < books.size(); i++) {
             Book b = books.get(i);
             data[i][0] = String.valueOf(b.getBookId());
             data[i][1] = b.getBookName();
             data[i][2] = b.getAuthor();
             data[i][3] = b.getPublisher();
             data[i][4] = String.valueOf(b.getNoOfCopies());
             data[i][5] = String.valueOf(b.getNoOfCopiesIssued());
             
         }
    	
    	return true;
    	
    }
    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewBooksUI frame = new ViewBooksUI(new DisplayManager(),new MainManager());
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
    public ViewBooksUI(final DisplayManager dMgr,final  MainManager mainMgr) {
        this.mainMgr = mainMgr;
        setTitle("View Books");
        this.dMgr = dMgr;
        ArrayList<Book> books = mainMgr.getAllBooks();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 59, 432, 194);
        contentPane.add(scrollPane);

        for (int i = 0; i < books.size(); i++) {

            Book b = books.get(i);
            data[i][0] = String.valueOf(b.getBookId());
            data[i][1] = b.getBookName();
            data[i][2] = b.getAuthor();
            data[i][3] = b.getPublisher();
            data[i][4] = String.valueOf(b.getNoOfCopies());
            data[i][5] = String.valueOf(b.getNoOfCopiesIssued());

        }
        table = new JTable(data, columnNames);
        
         final DefaultTableModel tableModel=
        new DefaultTableModel(
                data,
                columnNames
        ) {
            /**
             *
             */
            private static final long serialVersionUID = 1L;
            boolean[] columnEditables = new boolean[]{
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        };
        table.setModel(tableModel);
        JButton btnNewButton = new JButton("Search");
        btnNewButton.setBounds(124, 12, 97, 25);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int c = 0;
                String text = textField.getText();
                ArrayList<Book> books = mainMgr.searchBook(text);
                data = new String[100][6];
                for (int i = 0; i < books.size(); i++) {
                    Book b = books.get(i);
                    data[c][0] = String.valueOf(b.getBookId());
                    data[c][1] = b.getBookName();
                    data[c][2] = b.getAuthor();
                    data[c][3] = b.getPublisher();
                    data[c][4] = String.valueOf(b.getNoOfCopies());
                    data[c][5] = String.valueOf(b.getNoOfCopiesIssued());
                    c++;
                }
                tableModel.setDataVector(data, columnNames);


            }
        });

        tableModel.fireTableDataChanged();
        table.setFocusable(false);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) { 
                JTable target = (JTable) me.getSource();
                int row = target.getSelectedRow();
                int id = Integer.parseInt(table.getValueAt(row, 0).toString());
                System.out.println(id);
                mainMgr.setBookId(id);
                if (mainMgr.getUserType().equals("student")) {
                    dMgr.displayIssueBookUI();

            		tableModel.setDataVector(data, columnNames);
            		updateData();
                } else {
                    dMgr.displayEditBookUI();
                }
            }

        });
        

        textField = new JTextField();
        textField.setBounds(0, 13, 116, 22);
        contentPane.add(textField);
        textField.setColumns(10);
        btnNewButton.setBackground(new Color(18, 97, 160));
        contentPane.add(btnNewButton);
        
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		updateData();
        		tableModel.setDataVector(data, columnNames);
        	}
        });
        tableModel.fireTableDataChanged();

        scrollPane.setViewportView(table);
        btnRefresh.setForeground(Color.WHITE);
        btnRefresh.setBackground(new Color(18, 97, 160));
        btnRefresh.setBounds(323, 12, 97, 25);
        contentPane.add(btnRefresh);

    }
}
