package autoflash.visible;

import java.util.Date;
import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import autoflash.rpc.ClientProxy;
import autoflash.rpc.MockService;
import autoflash.rpc.slice.BatteryInfo;
import autoflash.rpc.slice.BatteryQueryCondition;
import autoflash.rpc.slice.OperationError;
import autoflash.rpc.slice.VehicleInfo;
import autoflash.rpc.slice.VehicleQueryCondition;

public class StationClient {
	static private autoflash.rpc.slice.ClientServicePrx service_ = ClientProxy.service();

	static String stationID;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);

		stationID = new StationClientLoginDialog(shell).open();
		if (stationID.equals("")) {
			MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR);
			mb.setText("错误");
			mb.setMessage("没有选择加能站");
			mb.open();
			shell.dispose();
		}

		shell.setText("加能站界面 " + stationID);
		GridLayout layout = new GridLayout(4, true);
		shell.setLayout(layout);

		Group g1 = new Group(shell, SWT.NONE);
		g1.setLayout(new RowLayout(SWT.VERTICAL));
		g1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 5));
		Button butOpen = new Button(g1, SWT.PUSH);
		butOpen.setText("开启");
		Button butClose = new Button(g1, SWT.PUSH);
		butClose.setText("关闭");

		Label labfill = new Label(shell, SWT.NONE);
		labfill.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 3, 1));

		Label lab1 = new Label(shell, SWT.NONE);
		lab1.setText("车辆ID");
		lab1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
		final Text t1 = new Text(shell, SWT.SINGLE|SWT.BORDER);
		t1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));

		Button butGen = new Button(shell, SWT.PUSH);
		butGen.setText("随机");
		butGen.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));

		Button butChange = new Button(shell, SWT.PUSH);
		butChange.setText("更换电池");
		butChange.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 2));

		final Text ts = new Text(shell, SWT.SINGLE | SWT.READ_ONLY);
		ts.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 2, 1));

		try {

			butOpen.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					ts.setText("加能站开放。");
					try {
						service_.openStation(stationID);
					} catch (OperationError e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			butClose.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					ts.setText("加能站关闭");
					try {
						service_.closeStation(stationID);
					} catch (OperationError e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			butGen.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					try {
						VehicleInfo[] vs = MockService.queryAllVehicles();
						if (vs.length == 0) {
							ts.setText("no");
							return;
						}
						Random rand = new Random();
						int i = rand.nextInt(vs.length);
						t1.setText(vs[i].ID);
					} catch (OperationError e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			butChange.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					try {
						BatteryQueryCondition c = MockService.makeQueryAllBatteryCondition();
						c.vehicleID = t1.getText();
						BatteryInfo[] bi = service_.queryBatteries(c);
						for (int i = 0; i < bi.length; ++i)
							service_.returnBattery(stationID, t1.getText(), bi[i].ID, 0);
						c.vehicleID = "";
						c.stationID = stationID;
						bi = service_.queryBatteries(c);
						if (bi.length == 0) {
							MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR);
							mb.setText("失败");
							mb.setMessage("没有可用的电池");
							mb.open();
						} else
							service_.rentBattery(stationID, t1.getText(), bi[0].ID, 100);
						t1.setText("");

					} catch (OperationError e1) {
						// TODO Auto-generated catch block
						if (t1.getText().equals("")) {
							MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR);
							mb.setText("失败");
							mb.setMessage("更换电池失败");
							mb.open();
						}
					}
				}
			});

			shell.pack();
			shell.open();

			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) { // process next message
					display.sleep(); // wait for next message
				}
			}

		} catch (SWTException e) {
			e.printStackTrace();
			System.out.println("Exit");
		} finally {
			display.dispose(); // must always clean up
			System.exit(1);
		}

	}

}
