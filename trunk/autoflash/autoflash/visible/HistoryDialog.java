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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import autoflash.rpc.ClientProxy;
import autoflash.rpc.MockService;
import autoflash.rpc.slice.Activity;
import autoflash.rpc.slice.OperationError;
import autoflash.rpc.slice.VehicleInfo;
import autoflash.rpc.slice.VehicleQueryCondition;

public class HistoryDialog extends Dialog {
	private static autoflash.rpc.slice.ClientServicePrx service_ = ClientProxy.service();

	public HistoryDialog(Shell parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}
	public void open() {
		final Shell dialog = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		dialog.setText("查询历史记录");
		dialog.setLayout(new GridLayout(2, false));

		GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		String[] labTexts = { "起始时间", "结束时间"};
		final Text[] texts = new Text[labTexts.length];
		for (int i = 0; i < texts.length; ++i) {
			Label label = new Label(dialog, SWT.NONE);
			label.setText(labTexts[i]);
			texts[i] = new Text(dialog, SWT.SINGLE | SWT.BORDER);
			texts[i].setLayoutData(gd);
		}

		Button button = new Button(dialog, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
		button.setText("查询");

		final Table table = new Table(dialog, SWT.SINGLE | SWT.BORDER);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 5));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		final TableColumn tc = new TableColumn(table, SWT.LEFT);
		final TableColumn tc0 = new TableColumn(table, SWT.LEFT);
		final TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		final TableColumn tc2 = new TableColumn(table, SWT.LEFT);
		final TableColumn tc3 = new TableColumn(table, SWT.LEFT);
		final TableColumn tc4 = new TableColumn(table, SWT.LEFT);
		final TableColumn tc5 = new TableColumn(table, SWT.LEFT);
		tc.setText("序号");
		tc0.setText("时间");
		tc1.setText("事件");
		tc2.setText("涉及地点");
		tc3.setText("涉及车辆");
		tc4.setText("涉及电池");
		tc5.setText("收益");

		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				Activity[] as = service_.queryActivities(0, new Date().getTime());
				table.removeAll();
				for (int i = 0; i < as.length; ++i) {
					TableItem it = new TableItem(table, SWT.NONE);
					it.setText(0, "" + i);
					it.setText(1, new Date(as[i].time).toString());
					it.setText(2, as[i].type.toString());
					it.setText(3, as[i].stationOrDepotID);
					it.setText(4, as[i].vehicleID);
					it.setText(5, as[i].batteryID);
					it.setText(6, ""+as[i].price);
				}
				for (int i = 0; i < table.getColumnCount(); ++i)
					table.getColumn(i).pack();
			}
		});

		dialog.setSize(300, 400);
		dialog.open();
		Display display = getParent().getDisplay();
		while (!dialog.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
	}
}
