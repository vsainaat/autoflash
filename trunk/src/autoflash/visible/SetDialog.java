package autoflash.visible;

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
import autoflash.rpc.slice.OperationError;

public class SetDialog extends Dialog {
	SetDialog(Shell shell) {
		super(shell);
	}
	private static autoflash.rpc.slice.ClientServicePrx service_ = ClientProxy.service();
	
	public String open() {
		final Shell dialog = new Shell(getParent(), SWT.DIALOG_TRIM|SWT.APPLICATION_MODAL);

		dialog.setText("设置");
		
		dialog.setLayout(new GridLayout(2, false));
		Label label1 = new Label(dialog, SWT.FILL);
		label1.setText("设置加能价格");
		final Text text1 = new Text(dialog, SWT.SINGLE);
		Label label2 = new Label(dialog, SWT.FILL);
		label2.setText("设置充电价格");
		final Text text2 = new Text(dialog, SWT.SINGLE);
		Button button = new Button(dialog, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
		button.setText("Set");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				try {
					double p1 = Double.parseDouble(text1.getText());
					double p2 = Double.parseDouble(text2.getText());
					service_.setUnitPrice(p1);
					service_.setUnitChargePrice(p2);
					MessageBox mb = new MessageBox(dialog);
					mb.setText("设置");
					mb.setMessage("设置完成");
					mb.open();
				} catch (NumberFormatException ex) {
					MessageBox mb = new MessageBox(dialog, SWT.ICON_ERROR);
					mb.setText("设置");
					mb.setMessage("设置失败：错误的数据格式");
					mb.open();
				} catch (OperationError ex) {
					MessageBox mb = new MessageBox(dialog, SWT.ICON_ERROR);
					mb.setText("设置");
					mb.setMessage("设置失败：设置服务器数据失败");
					mb.open();
				}
				
			}
		});
		
		dialog.pack();
		dialog.open();
        Display display = getParent().getDisplay( ); 
        while (!dialog.isDisposed( )) 
        { if (!display.readAndDispatch( )) display.sleep( ); 
        } 

		return "OK";
	}

}
