package banking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import banking.custom.CustomFrame;
import banking.data.Database;
import banking.model.Customer;

import java.io.*;

public class WithdrawMoney extends CustomFrame implements ActionListener {

	private JPanel jpWith = new JPanel();
	private JLabel lbNo, lbName, lbDate, lbWithdraw;
	private JTextField txtWithdraw;
	private JComboBox cboMonth, cboDay, cboYear;
	private JButton btnSave, btnCancel;

	private int recCount = 0;
	private int curr;
	private int withdraw;

	WithdrawMoney(Database db) {

		// super(Title, Resizable, Closable, Maximizable, Iconifiable)
		super("Withdraw Money", false, true, false, true);
		this.db = db;
		setSize(335, 235);

		jpWith.setLayout(null);

		lbNo = new JLabel("Account No:");
		lbNo.setForeground(Color.black);
		lbNo.setBounds(15, 20, 80, 25);
		lbName = new JLabel("Person Name:");
		lbName.setForeground(Color.black);
		lbName.setBounds(15, 55, 80, 25);
		lbDate = new JLabel("With. Date:");
		lbDate.setForeground(Color.black);
		lbDate.setBounds(15, 90, 80, 25);
		lbWithdraw = new JLabel("With. Amount:");
		lbWithdraw.setForeground(Color.black);
		lbWithdraw.setBounds(15, 125, 80, 25);

		txtNo = new JTextField();
		txtNo.setHorizontalAlignment(JTextField.RIGHT);
		// Checking the Accunt No. Provided By User on Lost Focus of the TextBox.
		txtNo.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}

			public void focusLost(FocusEvent fe) {
				if (txtNo.getText().equals("")) {
				} else {
					populateArray(); // Load All Existing Records in Memory.
					findRec(); // Finding if Account No. Already Exist or Not.
				}
			}
		});
		txtNo.setBounds(105, 20, 205, 25);

		txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setBounds(105, 55, 205, 25);
		txtWithdraw = new JTextField();
		txtWithdraw.setHorizontalAlignment(JTextField.RIGHT);
		txtWithdraw.setBounds(105, 125, 205, 25);

		// Restricting The User Input to only Numerics in Numeric TextBoxes.
		txtNo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)))) {
					getToolkit().beep();
					ke.consume();
				}
			}
		});
		txtWithdraw.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)))) {
					getToolkit().beep();
					ke.consume();
				}
			}
		});

		// Creating Date Option.
		String Months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		cboMonth = new JComboBox(Months);
		cboDay = new JComboBox();
		cboYear = new JComboBox();
		for (int i = 1; i <= 31; i++) {
			String days = "" + i;
			cboDay.addItem(days);
		}
		for (int i = 2000; i <= 2015; i++) {
			String years = "" + i;
			cboYear.addItem(years);
		}

		// Aligning The Date Option Controls.
		cboMonth.setBounds(105, 90, 92, 25);
		cboDay.setBounds(202, 90, 43, 25);
		cboYear.setBounds(250, 90, 60, 25);

		// Aligning The Buttons.
		btnSave = new JButton("Save");
		btnSave.setBounds(20, 165, 120, 25);
		btnSave.addActionListener(this);
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(185, 165, 120, 25);
		btnCancel.addActionListener(this);

		// Adding the All the Controls to Panel.
		jpWith.add(lbNo);
		jpWith.add(txtNo);
		jpWith.add(lbName);
		jpWith.add(txtName);
		jpWith.add(lbDate);
		jpWith.add(cboMonth);
		jpWith.add(cboDay);
		jpWith.add(cboYear);
		jpWith.add(lbWithdraw);
		jpWith.add(txtWithdraw);
		jpWith.add(btnSave);
		jpWith.add(btnCancel);

		// Adding Panel to Window.
		getContentPane().add(jpWith);

		populateArray(); // Load All Existing Records in Memory.

		// In the End Showing the New Account Window.
		setVisible(true);

	}

	// Function use By Buttons of Window to Perform Action as User Click Them.
	public void actionPerformed(ActionEvent ae) {

		Object obj = ae.getSource();

		if (obj == btnSave) {
			if (txtNo.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please! Provide Id of Customer.", "BankSystem - EmptyField",
						JOptionPane.PLAIN_MESSAGE);
				txtNo.requestFocus();
			} else if (txtWithdraw.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please! Provide Withdraw Amount.", "BankSystem - EmptyField",
						JOptionPane.PLAIN_MESSAGE);
				txtWithdraw.requestFocus();
			} else {
				withdraw = Integer.parseInt(txtWithdraw.getText());
				if (curr == 0) {
					JOptionPane.showMessageDialog(this, txtName.getText() + " doesn't have any Amount in Balance.",
							"BankSystem - EmptyAccount", JOptionPane.PLAIN_MESSAGE);
					txtClear();
				} else if (withdraw > curr) {
					JOptionPane.showMessageDialog(this, "Withdraw Amount can't greater than Actual Balance.",
							"BankSystem - Large Amount", JOptionPane.PLAIN_MESSAGE);
					txtWithdraw.setText("");
					txtWithdraw.requestFocus();
				} else {
					editRec(); // Update the Contents of Array.
				}
			}
		}
		if (obj == btnCancel) {
			txtClear();
			setVisible(false);
			dispose();
		}

	}

	@Override
	public void showRec(int intRec) {
		super.showRec(intRec);
		var records = db.get(intRec);
		curr = records.getBalance();
		recCount = intRec;
	}

	@Override
	public void txtClear() {
		super.txtClear();
		txtWithdraw.setText("");
	}

	// Function use to Edit an Element's Value of the Array.
	public void editRec() {
		try {
			db.set(recCount,
					new Customer(txtNo.getText(), txtName.getText(), "" + cboMonth.getSelectedItem(),
							Integer.parseInt("" + cboDay.getSelectedItem()),
							Integer.parseInt("" + cboYear.getSelectedItem()), (curr - withdraw)));
			JOptionPane.showMessageDialog(this, "The File is Updated Successfully", "BankSystem - Record Saved",
					JOptionPane.PLAIN_MESSAGE);
			txtClear();
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(this, "There are Some Problem with File", "BankSystem - Problem",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	@Override
	public void btnEnable() {
		super.btnEnable();
		cboMonth.setEnabled(false);
		cboDay.setEnabled(false);
		cboYear.setEnabled(false);
		txtWithdraw.setEnabled(false);
		btnSave.setEnabled(false);
	}
}