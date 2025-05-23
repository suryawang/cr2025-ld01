package banking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import banking.custom.DetailFrame;
import banking.data.Database;

import java.io.*;

public class FindName extends DetailFrame implements ActionListener {

	private JPanel jpFind = new JPanel();
	private JLabel lbNo, lbName, lbDate, lbBal;
	private JButton btnFind, btnCancel;

	FindName (Database db) {

		//super(Title, Resizable, Closable, Maximizable, Iconifiable)
		super ("Search Customer [By Name]", false, true, false, true);
		this.db = db;
		setSize (350, 235);

		jpFind.setLayout (null);

		lbNo = new JLabel ("Account No:");
		lbNo.setForeground (Color.black);
		lbNo.setBounds (15, 20, 80, 25);
	        lbName = new JLabel ("Person Name:");
		lbName.setForeground (Color.black);
	        lbName.setBounds (15, 55, 80, 25);
		lbDate = new JLabel ("Last Transaction:");
		lbDate.setForeground (Color.black);
		lbDate.setBounds (15, 90, 100, 25);
		lbBal = new JLabel ("Balance:");
		lbBal.setForeground (Color.black);
		lbBal.setBounds (15, 125, 80, 25);

		txtNo = new JTextField ();
		txtNo.setHorizontalAlignment (JTextField.RIGHT);
		txtNo.setEnabled (false);
		txtNo.setBounds (125, 20, 200, 25);
		txtName = new JTextField ();
		txtName.setBounds (125, 55, 200, 25);
		txtDate = new JTextField ();
		txtDate.setEnabled (false);
		txtDate.setBounds (125, 90, 200, 25);
		txtBal = new JTextField ();
		txtBal.setHorizontalAlignment (JTextField.RIGHT);
		txtBal.setEnabled (false);
		txtBal.setBounds (125, 125, 200, 25);

		//Aligning The Buttons.
		btnFind = new JButton ("Search");
		btnFind.setBounds (20, 165, 120, 25);
		btnFind.addActionListener (this);
		btnCancel = new JButton ("Cancel");
		btnCancel.setBounds (200, 165, 120, 25);
		btnCancel.addActionListener (this);

		//Adding the All the Controls to Panel.
		jpFind.add (lbNo);
		jpFind.add (txtNo);
		jpFind.add (lbName);
		jpFind.add (txtName);
		jpFind.add (lbDate);
		jpFind.add (txtDate);
		jpFind.add (lbBal);
		jpFind.add (txtBal);
		jpFind.add (btnFind);
		jpFind.add (btnCancel);

		//Adding Panel to Window.
		getContentPane().add (jpFind);

		populateArray ();	//Load All Existing Records in Memory.

		//In the End Showing the New Account Window.
		setVisible (true);

	}

	//Function use By Buttons of Window to Perform Action as User Click Them.
	public void actionPerformed (ActionEvent ae) {

		Object obj = ae.getSource();

		if (obj == btnFind) {
			if (txtName.getText().equals ("")) {
				JOptionPane.showMessageDialog (this, "Please! Provide Name of Customer to Search.",
							"BankSystem - EmptyField", JOptionPane.PLAIN_MESSAGE);
				txtName.requestFocus();
			}
			else {
				populateArray ();	//Load All Existing Records in Memory.
				findRec ();		//Finding if Account No. Exist or Not.
			}
		}
		if (obj == btnCancel) {
			txtClear ();
			setVisible (false);
			dispose();
		}

	}

	@Override
	public void findRec () {
		int fi = db.findByName(txtName.getText());
		if (fi > -1)
			showRec(fi);
		else {
			JOptionPane.showMessageDialog (this, "Customer " + txtName.getText () + " doesn't Exist.",
					"BankSystem - WrongNo", JOptionPane.PLAIN_MESSAGE);
			txtClear();
		}
	}
	@Override
	public void btnEnable() {
		super.btnEnable();
		btnFind.setEnabled(false);
	}
}	