package banking.custom;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import banking.data.Database;

public class CustomFrame extends JInternalFrame {
	protected JTextField txtNo, txtName;
	protected Database db;

	public CustomFrame(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
		super(title, resizable, closable, maximizable, iconifiable);
	}
	public void populateArray() {
		db.read();
		if (db.length() == 0) {
			JOptionPane.showMessageDialog(null, "Records File is Empty.\nEnter Records First to Display.",
					"BankSystem - EmptyFile", JOptionPane.PLAIN_MESSAGE);
			btnEnable();
		}
	}

	public void findRec() {
		int fi = db.findByNo(txtNo.getText());
		if (fi > -1)
			showRec(fi);
		else {
			String str = txtNo.getText();
			txtClear();
			JOptionPane.showMessageDialog(this, "Account No. " + str + " doesn't Exist.", "BankSystem - WrongNo",
					JOptionPane.PLAIN_MESSAGE);
		}

	}

	public void showRec(int intRec) {
		var records = db.get(intRec);
		txtNo.setText(records.getNo());
		txtName.setText(records.getName());
	}

	public void txtClear() {
		txtNo.setText("");
		txtName.setText("");
		txtNo.requestFocus();
	}
	public void btnEnable() {
		txtNo.setEnabled(false);
	}
}
