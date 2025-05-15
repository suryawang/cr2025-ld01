package design_banking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import design_banking.model.Customer;
import design_banking.repo.CustomerRepository;

public class ViewCustomer extends JInternalFrame {

	private JPanel jpShow = new JPanel();

	private DefaultTableModel dtmCustomer;
	private JTable tbCustomer;
	private JScrollPane jspTable;

	private CustomerRepository repo = CustomerRepository.getInstance();

	ViewCustomer() {

		// super(Title, Resizable, Closable, Maximizable, Iconifiable)
		super("View All Account Holders", false, true, false, true);
		setSize(475, 280);

		jpShow.setLayout(null);

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
	// Function to Create the Table and Add Data to Show.
	private JTable makeTable() {
		Vector<String> cols = new Vector<>(
				Arrays.asList("Account No.", "Customer Name", "Opening Date", "Bank Balance"));
		Vector<Vector<Object>> db = new Vector<>();
		for (var d : repo.getData())
			db.add(new Vector<>(Arrays.asList(d.getId(), d.getName(), d.getDate(), d.getBalance() + "")));
		dtmCustomer = new DefaultTableModel(db, cols);

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