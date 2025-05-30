package banking.custom;

import javax.swing.JTextField;

public class DetailFrame extends CustomFrame {
	protected JTextField txtDate, txtBal;

	public DetailFrame(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
		super(title, resizable, closable, maximizable, iconifiable);
	}

	@Override
	public void showRec(int intRec) {
		super.showRec(intRec);
		var records = db.get(intRec);
		txtDate.setText(records.getDate());
		txtBal.setText(records.getBalance() + "");
	}

	@Override
	public void txtClear() {
		super.txtClear();
		txtDate.setText("");
		txtBal.setText("");
	}

}
