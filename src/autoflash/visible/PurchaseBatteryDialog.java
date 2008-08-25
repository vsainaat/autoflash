package autoflash.visible;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import autoflash.rpc.ClientProxy;
import autoflash.rpc.slice.BatteryInfo;
import autoflash.rpc.slice.BatteryModel;
import autoflash.rpc.slice.DepotInfo;
import autoflash.rpc.slice.Point;

public class PurchaseBatteryDialog extends Dialog {
	private static autoflash.rpc.slice.ClientServicePrx service_ = ClientProxy.service();

	public PurchaseBatteryDialog(Shell parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}
	
	public void open() {
		final Shell dialog = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		dialog.setText("购买电池");
		dialog.setLayout(new GridLayout(2, false));

		String[] labTexts = {"型号名称", "电池容量", "最大充电次数", "最大生命周期", "生产商", "单价", "购买数量" };
		final Text[] texts = new Text[labTexts.length];
		for (int i = 0; i < texts.length; ++i) {
			Label label = new Label(dialog, SWT.NONE);
			label.setText(labTexts[i]);
			texts[i] = new Text(dialog, SWT.SINGLE | SWT.BORDER);
		}
		Button button = new Button(dialog, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
		button.setText("购买");

		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				try {
					BatteryModel bm = new BatteryModel();
					bm.capacity = Integer.parseInt(texts[1].getText());
					bm.factory = texts[4].getText();
					bm.maxChargeRounds = Integer.parseInt(texts[2].getText());
					bm.maxLifeTime = Integer.parseInt(texts[3].getText());
					bm.name = texts[0].getText();

					BatteryInfo b = new BatteryInfo();
					b.shippedDate = (int) (new Date().getTime() / 3600 / 24);
					b.model = bm;
					
					int num = Integer.parseInt(texts[6].getText());
					for (int i = 0; i < num; ++i)
						service_.purchase(b, Double.parseDouble(texts[5].getText()));

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
