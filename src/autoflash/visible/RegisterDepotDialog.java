package autoflash.visible;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import autoflash.rpc.ClientProxy;
import autoflash.rpc.slice.Activity;
import autoflash.rpc.slice.OperationError;
import autoflash.rpc.slice.Point;
import autoflash.rpc.slice.DepotInfo;

public class RegisterDepotDialog extends Dialog {
	private static autoflash.rpc.slice.ClientServicePrx service_ = ClientProxy.service();

	public RegisterDepotDialog(Shell parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}

	public void open() {
		final Shell dialog = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		dialog.setText("注册充电站");
		dialog.setLayout(new GridLayout(2, false));

		String[] labTexts = { "经度位置", "纬度位置", "地址", "电池存储容量", "充电容量", "拥有者", "租金" };
		final Text[] texts = new Text[labTexts.length];
		for (int i = 0; i < texts.length; ++i) {
			Label label = new Label(dialog, SWT.NONE);
			label.setText(labTexts[i]);
			texts[i] = new Text(dialog, SWT.SINGLE | SWT.BORDER);
		}
		Button button = new Button(dialog, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
		button.setText("注册");

		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				try {
					DepotInfo info = new DepotInfo();
					info.position = new Point(Integer.parseInt(texts[0].getText()), Integer
							.parseInt(texts[1].getText()));
					info.address = texts[2].getText();
					info.storageCapacity = Integer.parseInt(texts[3].getText());
					info.chargeCapacity = Integer.parseInt(texts[4].getText());
					info.chargePrice = 10.0;
					info.owner = texts[5].getText();
					info.rentPrice = Integer.parseInt(texts[6].getText());
					info.ID = "unknown";
					service_.registerDepot(info);
					MessageBox mb = new MessageBox(dialog);
					mb.setText("完成");
					mb.setMessage("注册完成");
					mb.open();
				} catch (Exception ex) {
					MessageBox mb = new MessageBox(dialog, SWT.ICON_ERROR);
					mb.setText("失败");
					mb.setMessage("注册失败");
					mb.open();
				}
			}
		});
		dialog.pack();
		dialog.open();
		Display display = getParent().getDisplay();
		while (!dialog.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
	}

}
