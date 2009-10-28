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
import autoflash.rpc.slice.DepotInfo;
import autoflash.rpc.slice.DepotQueryCondition;
import autoflash.rpc.slice.OpenStatus;
import autoflash.rpc.slice.OperationError;
import autoflash.rpc.slice.Point;
import autoflash.rpc.slice.StationInfo;
import autoflash.rpc.slice.StationQueryCondition;

public class QueryDepotDialog extends Dialog {
	private static autoflash.rpc.slice.ClientServicePrx service_ = ClientProxy.service();

	public QueryDepotDialog(Shell parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}
	
	public void open() {
		final Shell dialog = new Shell(getParent(), SWT.DIALOG_TRIM|SWT.APPLICATION_MODAL);
		dialog.setText("查询充电站");
		dialog.setLayout(new GridLayout(2, false));
		
		GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		String[] labTexts = {"充电站ID","最小左边界","最大右边界","最小上边界", "最大下边界", "最小存储容量", "最大存储容量", "最小充电容量", "最大充电容量", "所有者"};
		String[] textTexts = {"", "-9999", "9999", "-9999", "9999", "-1", "99999999", "-1", "99999999", ""};
		final Text[] texts = new Text[10];
		for (int i = 0; i < 10; ++i) {
			Label label = new Label(dialog, SWT.NONE);
			label.setText(labTexts[i]);
			texts[i] = new Text(dialog, SWT.SINGLE|SWT.BORDER);
			texts[i].setText(textTexts[i]);
			texts[i].setLayoutData(gd);
		}
		Label labStatus = new Label(dialog, SWT.NONE);
		labStatus.setText("当前状态");
		final Combo comboOpen = new Combo(dialog, SWT.READ_ONLY|SWT.DROP_DOWN);
		comboOpen.setItems(new String[]{"Open", "Closed", "OpenOrClosed"});
		comboOpen.select(0);
		comboOpen.setLayoutData(gd);
		
		Button button = new Button(dialog, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
		button.setText("查询");
		
		final Table table = new Table(dialog, SWT.SINGLE|SWT.BORDER);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 5));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		final TableColumn tc = new TableColumn(table, SWT.LEFT);
		final TableColumn tc0 = new TableColumn(table, SWT.LEFT);
		final TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		final TableColumn tc2 = new TableColumn(table, SWT.LEFT);
		final TableColumn tc3 = new TableColumn(table, SWT.LEFT);
		tc.setText("序号");
		tc0.setText("充电站ID");
		tc1.setText("位置");
		tc2.setText("容量");
		tc3.setText("拥有者");

		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event) {
				DepotQueryCondition c = new DepotQueryCondition();
				c.depotID = texts[0].getText();
				int left = Integer.parseInt(texts[1].getText());
				int right = Integer.parseInt(texts[2].getText());
				int top = Integer.parseInt(texts[3].getText());
				int bottom = Integer.parseInt(texts[4].getText());
				c.region = new Area(new Point(left, top), right-left, bottom-top);
				c.owner = texts[9].getText();
				c.maxStorageCapacity = Integer.parseInt(texts[6].getText());
				c.minStorageCapacity = Integer.parseInt(texts[5].getText());
				c.minChargeCapacity = Integer.parseInt(texts[7].getText());
				c.maxChargeCapacity = Integer.parseInt(texts[8].getText());
				c.status = OpenStatus.convert(comboOpen.getSelectionIndex());
				try {
					DepotInfo[] ss = service_.queryDepots(c);
					table.removeAll();
					for (int i = 0; i < ss.length; ++i) {
						TableItem it = new TableItem(table, SWT.NONE);
						it.setText(0, ""+i);
						it.setText(1, ss[i].ID);
						it.setText(2, ss[i].position.longitude + "," + ss[i].position.latitude);
						it.setText(3, ""+ss[i].storageCapacity);
						it.setText(4, ss[i].owner);
					}
					for (int i = 0;i < table.getColumnCount(); ++i)
						table.getColumn(i).pack();

				} catch (OperationError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
		dialog.setSize(300, 400);
		dialog.open();
        Display display = getParent().getDisplay( ); 
        while (!dialog.isDisposed( )) {
        	if (!display.readAndDispatch( )) display.sleep( ); 
        } 
	}

}
