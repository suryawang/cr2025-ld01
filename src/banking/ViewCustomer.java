package banking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;

import banking.data.Database;

public class ViewCustomer extends JInternalFrame {

	private JPanel jpShow = new JPanel();

	private DefaultTableModel dtmCustomer;
	private JTable tbCustomer;
	private JScrollPane jspTable;

	private Database db;
	private String[][] rowData;

	ViewCustomer(Database db) {

		// super(Title, Resizable, Closable, Maximizable, Iconifiable)
		super("View All Account Holders", false, true, false, true);
		this.db = db;
		setSize(475, 280);

		jpShow.setLayout(null);

		populateArray();

		tbCustomer = makeTable();
		jspTable = new JScrollPane(tbCustomer);
		jspTable.setBounds(20, 20, 425, 200);

		// Adding the Table to Panel.
		jpShow.add(jspTable);

		// Adding Panel to Window.
		getContentPane().add(jpShow);

		// In the End Showing the New Account Window.
		setVisible(true);

	}

	// Function use to load all Records from File when Window Open.
	void populateArray() {
		db.read();
		if (db.length() == 0) {
			JOptionPane.showMessageDialog(null, "Records File is Empty.\nEnter Records to Display.",
					"BankSystem - EmptyFile", JOptionPane.PLAIN_MESSAGE);
		} else {
			rowData = new String[db.length()][4];
			for (int i = 0; i < db.length(); i++) {
				var rows = db.get(i);
				rowData[i][0] = rows.getNo();
				rowData[i][1] = rows.getName();
				rowData[i][2] = rows.getDate();
				rowData[i][3] = rows.getBalance() + "";
			}
		}
	}

	// Function to Create the Table and Add Data to Show.
	private JTable makeTable() {

		// String Type Array use to Give Table Column Names.
		String cols[] = { "Account No.", "Customer Name", "Opening Date", "Bank Balance" };

		dtmCustomer = new DefaultTableModel(rowData, cols);
		tbCustomer = new JTable(dtmCustomer) {
			public boolean isCellEditable(int iRow, int iCol) {
				return false; // Disable All Columns of Table.
			}
		};
		// Sizing the Columns of Table.
		(tbCustomer.getColumnModel().getColumn(0)).setPreferredWidth(180);
		(tbCustomer.getColumnModel().getColumn(1)).setPreferredWidth(275);
		(tbCustomer.getColumnModel().getColumn(2)).setPreferredWidth(275);
		(tbCustomer.getColumnModel().getColumn(3)).setPreferredWidth(200);
		tbCustomer.setRowHeight(20);
		tbCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return tbCustomer;

	}

}