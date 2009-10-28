package autoflash.visible;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import autoflash.rpc.ClientProxy;
import autoflash.rpc.slice.Area;
import autoflash.rpc.slice.OpenStatus;
import autoflash.rpc.slice.OperationError;
import autoflash.rpc.slice.Point;
import autoflash.rpc.slice.StationInfo;
import autoflash.rpc.slice.StationQueryCondition;
import autoflash.rpc.slice.VehicleInfo;
import autoflash.rpc.slice.VehicleQueryCondition;

public class QueryVehicleDialog extends Dialog {
	private static autoflash.rpc.slice.ClientServicePrx service_ = ClientProxy.service();

	public QueryVehicleDialog(Shell parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}

	public void open() {
		final Shell dialog = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		dialog.setText("查询车辆");
		dialog.setLayout(new GridLayout(2, false));

		GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		String[] labTexts = { "车辆ID", "型号名称", "所有者", "租赁电池数", "租赁电池"};
		final Text[] texts = new Text[labTexts.length];
		for (int i = 0; i < texts.length; ++i) {
			Label label = new Label(dialog, SWT.NONE);
			label.setText(labTexts[i]);
			texts[i] = new Text(dialog, SWT.SINGLE | SWT.BORDER);
			texts[i].setLayoutData(gd);
		}
		texts[3].setText("-1");

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
		tc.setText("序号");
		tc0.setText("车辆ID");
		tc1.setText("车牌号");
		tc2.setText("型号名称");
		tc3.setText("拥有者");

		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				VehicleQueryCondition c = new VehicleQueryCondition();
				c.vehicleID = texts[0].getText();
				c.model = texts[1].getText();
				c.owner = texts[2].getText();
				c.batteryNum = Integer.parseInt(texts[3].getText());
				c.batteryID = texts[4].getText();
				try {
					VehicleInfo[] vs = service_.queryVehicles(c);
					table.removeAll();
					for (int i = 0; i < vs.length; ++i) {
						TableItem it = new TableItem(table, SWT.NONE);
						it.setText(0, "" + i);
						it.setText(1, vs[i].ID);
						it.setText(2, vs[i].license);
						it.setText(3, vs[i].model);
						it.setText(4, vs[i].owner);
					}
					for (int i = 0; i < table.getColumnCount(); ++i)
						table.getColumn(i).pack();

				} catch (OperationError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
