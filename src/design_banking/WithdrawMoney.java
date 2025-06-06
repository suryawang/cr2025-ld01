package design_banking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import design_banking.model.Customer;
import design_banking.repo.CustomerRepository;

import java.io.*;

public class WithdrawMoney extends JInternalFrame implements ActionListener {

	private JPanel jpWith = new JPanel();
	private JLabel lbNo, lbName, lbDate, lbWithdraw;
	private JTextField txtNo, txtName, txtWithdraw;
	private JComboBox cboMonth, cboDay, cboYear;
	private JButton btnSave, btnCancel;

	private CustomerRepository repo = CustomerRepository.getInstance();
	private Customer curr = null;

	WithdrawMoney() {

		// super(Title, Resizable, Closable, Maximizable, Iconifiable)
		super("Withdraw Money", false, true, false, true);
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
		handleFocusChange();
		txtNo.setBounds(105, 20, 205, 25);

		txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setBounds(105, 55, 205, 25);
		txtWithdraw = new JTextField();
		txtWithdraw.setHorizontalAlignment(JTextField.RIGHT);
		txtWithdraw.setBounds(105, 125, 205, 25);

		handleEvent();

		generateDate();

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

		getContentPane().add(jpWith);

		setVisible(true);
	}

	private void handleFocusChange() {
		txtNo.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}

			public void focusLost(FocusEvent fe) {
				if (!txtNo.getText().equals("")) findRec();
			}
		});
	}

	private void handleEvent() {
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
	}

	private void generateDate() {
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
				int withdraw = Integer.parseInt(txtWithdraw.getText());
				if (curr.getBalance() == 0) {
					JOptionPane.showMessageDialog(this, txtName.getText() + " doesn't have any Amount in Balance.",
							"BankSystem - EmptyAccount", JOptionPane.PLAIN_MESSAGE);
					txtClear();
				} else if (withdraw > curr.getBalance()) {
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

	private void findRec() {
		curr = repo.find(txtNo.getText());
		if (curr != null)
			showRec();
		else {
			String str = txtNo.getText();
			txtClear();
			JOptionPane.showMessageDialog(this, "Account No. " + str + " doesn't Exist.", "BankSystem - WrongNo",
					JOptionPane.PLAIN_MESSAGE);
		}

	}
	private void showRec() {
		txtNo.setText(curr.getId());
		txtName.setText(curr.getName());
	}

	private void txtClear() {
		txtNo.setText("");
		txtName.setText("");
		txtWithdraw.setText("");
		txtNo.requestFocus();
	}

	private void editRec() {
		try {
			int withdraw = Integer.parseInt(txtWithdraw.getText());
			repo.change(curr,
					new Customer(curr.getId(), curr.getName(), "" + cboMonth.getSelectedItem(),
							Integer.parseInt("" + cboDay.getSelectedItem()),
							Integer.parseInt("" + cboYear.getSelectedItem()), curr.getBalance() - withdraw));

			JOptionPane.showMessageDialog(this, "The File is Updated Successfully", "BankSystem - Record Saved",
					JOptionPane.PLAIN_MESSAGE);
			txtClear();
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(this, "There are Some Problem with File", "BankSystem - Problem",
					JOptionPane.PLAIN_MESSAGE);
		}

	}
}