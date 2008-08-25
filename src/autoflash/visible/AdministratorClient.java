package autoflash.visible;

import java.awt.Color;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import sun.reflect.generics.visitor.Reifier;

import autoflash.mock.MockEnvironment;
import autoflash.rpc.ClientProxy;
import autoflash.rpc.MockService;
import autoflash.rpc.slice.Activity;
import autoflash.rpc.slice.ActivityType;
import autoflash.rpc.slice.DepotInfo;
import autoflash.rpc.slice.OperationError;
import autoflash.rpc.slice.StationInfo;

public class AdministratorClient {
	Display display_ = new Display();

	Shell shell_ = new Shell(display_);

	String queryResult_ = "";

	Text text_;

	final Canvas canvas_ = new Canvas(shell_, SWT.NONE);

	ConcurrentLinkedQueue<Activity> queue = new ConcurrentLinkedQueue<Activity>();

	private static autoflash.rpc.slice.ClientServicePrx service_ = ClientProxy.service();

	String activeStationOrDepot_ = "";

	// 此线程不断查询最新的动态并保存查询结果以供显示
	class QueryDeamon extends Thread {
		public void run() {
			long t = 0;
			System.out.println("Deamon started");
			while (true) {
				Activity[] as = service_.queryActivities(t, Long.MAX_VALUE);
				if (as.length > 0) t = as[as.length - 1].time + 1;
				for (int i = 0; i < as.length; ++i) {
					queue.add(as[i]);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("Stop");
					break;
				}
				System.out.println("query " + t);
			}
		}
	}

	void addCanvas() {
		canvas_.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 2));
		canvas_.setSize(200, 100);
		canvas_.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = event.gc;
				Rectangle rect = canvas_.getClientArea();
				gc.setBackground(display_.getSystemColor(SWT.COLOR_WHITE));
				gc.fillRectangle(0, 0, rect.width, rect.height);
				double sx = (double) rect.width / 2200;
				double sy = (double) rect.height / 2200;
				try {
					StationInfo[] ss = MockService.queryAllStations();
					for (int i = 0; i < ss.length; ++i) {
						int x = (int) ((ss[i].position.longitude + 1000) * sx);
						int y = (int) ((ss[i].position.latitude + 1000) * sy);
						if (ss[i].ID.equals(activeStationOrDepot_)) {
							gc.setBackground(display_.getSystemColor(SWT.COLOR_RED));
							gc.fillRectangle(x, y, 8, 8);
							gc.setBackground(display_.getSystemColor(SWT.COLOR_GRAY));
							gc.drawText(ss[i].ID, x, y + 8);
						} else {
							gc.setBackground(display_.getSystemColor(SWT.COLOR_DARK_BLUE));
							gc.fillRectangle(x, y, 5, 5);
							gc.setBackground(display_.getSystemColor(SWT.COLOR_GRAY));
							gc.drawText(ss[i].ID, x, y + 5);
						}
					}
					DepotInfo[] ds = MockService.queryAllDepots();
					for (int i = 0; i < ds.length; ++i) {
						int x = (int) ((ds[i].position.longitude + 1000) * sx);
						int y = (int) ((ds[i].position.latitude + 1000) * sy);
						if (ds[i].ID.equals(activeStationOrDepot_)) gc.setBackground(display_
								.getSystemColor(SWT.COLOR_RED));
						else gc.setBackground(display_.getSystemColor(SWT.COLOR_DARK_BLUE));
						gc.fillOval(x, y, 8, 8);
						gc.setBackground(display_.getSystemColor(SWT.COLOR_GRAY));
						gc.drawText(ds[i].ID, x, y + 8);
					}

					System.out.println(ss.length);
				} catch (OperationError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

	void addText() {
		text_ = new Text(shell_, SWT.READ_ONLY | SWT.MULTI | SWT.V_SCROLL | SWT.BORDER);
		text_.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 2));
		text_.setText(this.queryResult_);

	}

	void addMenu() {
		Menu menubar = new Menu(shell_, SWT.BAR);
		shell_.setMenuBar(menubar);

		MenuItem sysItem = new MenuItem(menubar, SWT.CASCADE);
		Menu sysMenu = new Menu(shell_, SWT.DROP_DOWN);
		sysItem.setText("系统");
		sysItem.setMenu(sysMenu);
		MenuItem exitItem = new MenuItem(sysMenu, SWT.PUSH);
		exitItem.setText("退出");

		Menu manageMenu = new Menu(shell_, SWT.DROP_DOWN);
		MenuItem manageItem = new MenuItem(menubar, SWT.CASCADE);
		manageItem.setMenu(manageMenu);
		manageItem.setText("管理");
		MenuItem queryItem = new MenuItem(manageMenu, SWT.CASCADE);
		queryItem.setText("查询");
		MenuItem setItem = new MenuItem(manageMenu, SWT.PUSH);
		setItem.setText("设置");
		MenuItem historyItem = new MenuItem(manageMenu, SWT.PUSH);
		historyItem.setText("历史");
		MenuItem registerStationItem = new MenuItem(manageMenu, SWT.PUSH);
		registerStationItem.setText("注册加能站");
		MenuItem registerDepotItem = new MenuItem(manageMenu, SWT.PUSH);
		registerDepotItem.setText("注册充电站");
		MenuItem purchaseBatteryItem = new MenuItem(manageMenu, SWT.PUSH);
		purchaseBatteryItem.setText("购买电池");

		Menu queryMenu = new Menu(shell_, SWT.DROP_DOWN);
		queryItem.setMenu(queryMenu);
		MenuItem stationQueryItem = new MenuItem(queryMenu, SWT.PUSH);
		stationQueryItem.setText("查询加能站");
		MenuItem depotQueryItem = new MenuItem(queryMenu, SWT.PUSH);
		depotQueryItem.setText("查询充电站");
		MenuItem batteryQueryItem = new MenuItem(queryMenu, SWT.PUSH);
		batteryQueryItem.setText("查询电池");
		MenuItem vehicleQueryItem = new MenuItem(queryMenu, SWT.PUSH);
		vehicleQueryItem.setText("查询车辆");

		MenuItem mockItem = new MenuItem(menubar, SWT.CASCADE);
		Menu mockMenu = new Menu(shell_, SWT.DROP_DOWN);
		mockItem.setMenu(mockMenu);
		mockItem.setText("模拟");
		MenuItem startMockItem = new MenuItem(mockMenu, SWT.PUSH);
		startMockItem.setText("启动模拟环境");
		

		exitItem.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				display_.close();
			}
		});

		setItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				System.out.println(new SetDialog(shell_).open());
			}

		});

		batteryQueryItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new QueryBatteryDialog(shell_).open();
			}
		});
		
		stationQueryItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new QueryStationDialog(shell_).open();
			}
		});

		depotQueryItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new QueryDepotDialog(shell_).open();
			}
		});

		vehicleQueryItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new QueryVehicleDialog(shell_).open();
			}
		});

		historyItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new HistoryDialog(shell_).open();
			}
		});
		
		registerStationItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new RegisterStationDialog(shell_).open();
			}
		});

		registerDepotItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new RegisterDepotDialog(shell_).open();
			}
		});

		purchaseBatteryItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new PurchaseBatteryDialog(shell_).open();
			}
		});

		startMockItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				try {
					new MockEnvironment().mock();
				} catch (OperationError e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	void display() {
		shell_.setText("管理员界面");
		GridLayout layout = new GridLayout(4, true);
		shell_.setLayout(layout);

		addMenu();
		addCanvas();
		addText();

		new QueryDeamon().start();

		// shell.pack();
		// shell.setSize(400, 400);
		shell_.open();
		while (!shell_.isDisposed()) {
			if (!display_.readAndDispatch()) { // process next message
				display_.sleep(); // wait for next message
			}
			if (!queue.isEmpty()) {
				String s = "";
				Activity a;
				while ((a = queue.poll()) != null) {
					s += new Date(a.time) + ", ";
					switch (a.type.value()) {
					case ActivityType._Charge:
						s += "在充电站" + a.stationOrDepotID + "给电池" + a.batteryID +"充电，耗费" + (-a.price);
						break;
					case ActivityType._CloseDepot:
					case ActivityType._CloseStation:
						s += "关闭 " + a.stationOrDepotID;
						break;
					case ActivityType._Discard:
						s += "在" + a.stationOrDepotID + "废弃电池" + a.batteryID;
						break;
					case ActivityType._MoveFromDepot:
					case ActivityType._MoveFromStation:
						s += "从" + a.stationOrDepotID + "运出电池" + a.batteryID;
						break;
					case ActivityType._MoveToDepot:
					case ActivityType._MoveToStation:
						s += "运送电池" + a.batteryID + "到" + a.stationOrDepotID;
						break;
					case ActivityType._OpenDepot:
					case ActivityType._OpenStation:
						s += "开启" + a.stationOrDepotID;
						break;
					case ActivityType._Purchase:
						s += "购买" + a.batteryID;
						break;
					case ActivityType._Register:
						s += "注册" + a.stationOrDepotID + a.batteryID + a.vehicleID;
						break;
					case ActivityType._Rent:
						s += "车辆" + a.vehicleID + "从加能站"  + a.stationOrDepotID + "租赁电池" + a.batteryID + ",收取" + a.price;
						break;
					case ActivityType._Return:
						s += "车辆" + a.vehicleID + "归还电池" + a.batteryID + "到加能站" + a.stationOrDepotID+",退款" + (-a.price);
					default:
						s += a.type;
					}
					s += "\n";
					activeStationOrDepot_ = a.stationOrDepotID;
				}
				text_.append(s);
				canvas_.redraw();
			}
		}
		display_.dispose(); // must always clean up
		System.exit(0);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AdministratorClient().display();
	}

}
