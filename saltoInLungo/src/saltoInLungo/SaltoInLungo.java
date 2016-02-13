package saltoInLungo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class SaltoInLungo {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SaltoInLungo window = new SaltoInLungo();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage("Green_Fire.jpg"));
		shell.setSize(600, 400);
		shell.setText("Salto in lungo");

		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setBounds(20, 15, 37, 15);
		lblNome.setText("Nome");

		Text Nome = new Text(shell, SWT.BORDER);
		Nome.setBounds(60, 10, 80, 21);

		Label lblMisura = new Label(shell, SWT.NONE);
		lblMisura.setBounds(160, 15, 38, 15);
		lblMisura.setText("Misura");

		Text Misura = new Text(shell, SWT.BORDER);
		Misura.setBounds(205, 10, 80, 21);

		Button btnRegistra = new Button(shell, SWT.NONE);
		btnRegistra.setBounds(20, 51, 75, 25);
		btnRegistra.setText("Registra");
	}

}
