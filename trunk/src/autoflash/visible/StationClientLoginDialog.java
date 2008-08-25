package autoflash.visible;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import autoflash.rpc.ClientProxy;
import autoflash.rpc.MockService;
import autoflash.rpc.slice.OperationError;
import autoflash.rpc.slice.StationInfo;

public class StationClientLoginDialog extends Dialog {
	private static autoflash.rpc.slice.ClientServicePrx service_ = ClientProxy.service();
	
	private boolean selected = false;

	public StationClientLoginDialog(Shell parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}

	class ButtonSelection extends SelectionAdapter {
		public void widgetSelected(SelectionEvent event) {
			selected = true;
		}
	}

	public String open() {
		final Shell dialog = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		dialog.setText("Query Batteries");
		dialog.setLayout(new GridLayout(1, false));

		Label lab = new Label(dialog, SWT.NONE);
		lab.setText("请选择一个加能站");
		Combo combo = new Combo(dialog, SWT.BORDER);
		try {
			StationInfo[] ss;
			ss = MockService.queryAllStations();
			for (int i = 0; i < ss.length; ++i) {
				combo.add(ss[i].ID);
			}
			combo.select(0);
		} catch (OperationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Button button = new Button(dialog, SWT.PUSH);
		button.setText("进入");
		button.addSelectionListener(new ButtonSelection());

		dialog.pack();
		dialog.open();
		String result = "";
		Display display = getParent().getDisplay();
		while (!dialog.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
			if (selected) {
				result = combo.getText();
				dialog.dispose();
			}
		}

		return result;
	}
}
