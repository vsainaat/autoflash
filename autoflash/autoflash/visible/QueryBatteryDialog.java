package autoflash.visible;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
import autoflash.rpc.MockService;
import autoflash.rpc.slice.BatteryInfo;
import autoflash.rpc.slice.BatteryQueryCondition;
import autoflash.rpc.slice.BatteryState;
import autoflash.rpc.slice.OperationError;

public class QueryBatteryDialog extends Dialog {
	private static autoflash.rpc.slice.ClientServicePrx service_ = ClientProxy.service();

	public QueryBatteryDialog(Shell parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}
	
	public void open() {
		final Shell dialog = new Shell(getParent(), SWT.DIALOG_TRIM|SWT.APPLICATION_MODAL);
		dialog.setText("查询电池");
		dialog.setLayout(new GridLayout(2, false));
		
		Label labelID = new Label(dialog, SWT.NONE);
		labelID.setText("电池ID");
		final Text textID = new Text(dialog, SWT.SINGLE);
		Label labelModel = new Label(dialog, SWT.NONE);
		labelModel.setText("型号名称");
		final Text textModel = new Text(dialog, SWT.SINGLE);
		Label labelState = new Label(dialog, SWT.NONE);
		labelState.setText("当前状态");
		final Combo comboState = new Combo(dialog, SWT.READ_ONLY|SWT.DROP_DOWN);
		comboState.setItems(new String[]{"Arbitrary", "Empty", "Charging", "Charged", "Onboard", "Discarded"});
		comboState.setText("Arbitrary");
		Label labelStationID = new Label(dialog, SWT.NONE);
		labelStationID.setText("位于加能站");
		final Text textStationID = new Text(dialog, SWT.SINGLE);
		Label labelDepotID = new Label(dialog, SWT.NONE);
		labelDepotID.setText("位于充电站");
		final Text textDepotID = new Text(dialog, SWT.SINGLE);
		Label labelVehicleID = new Label(dialog, SWT.NONE);
		labelVehicleID.setText("位于车辆");
		final Text textVehicleID = new Text(dialog, SWT.SINGLE);
					
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
		tc0.setText("电池ID");
		tc1.setText("型号");
		tc2.setText("充电次数");
		tc3.setText("购买日期");
		
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event) {
				BatteryQueryCondition c = MockService.makeQueryAllBatteryCondition();
				if (textID.getText() != "")
					c.batteryID = textID.getText();
				c.model.name = textModel.getText();
				c.state = BatteryState.convert(comboState.getText());
				c.stationID = textStationID.getText();
				c.depotID = textDepotID.getText();
				c.vehicleID = textVehicleID.getText();
				try {
					BatteryInfo[] bs = service_.queryBatteries(c);
					table.clearAll();
					for (int i = 0; i < bs.length; ++i) {
						TableItem it = new TableItem(table, SWT.NONE);
						it.setText(0, ""+i);
						it.setText(1, bs[i].ID);
						it.setText(2, bs[i].model.name);
						it.setText(3, ""+bs[i].chargeRounds);
						it.setText(4, DateFormat.getDateInstance().format(new Date((long)(bs[i].shippedDate)*3600*24)));
					}
					for (int i = 0;i < table.getColumnCount(); ++i)
						table.getColumn(i).pack();

				} catch (OperationError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
			
		//dialog.pack();
		dialog.setSize(300, 400);
		dialog.open();
        Display display = getParent().getDisplay( ); 
        while (!dialog.isDisposed( )) {
        	if (!display.readAndDispatch( )) display.sleep( ); 
        } 
	}

}
