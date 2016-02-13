package saltoInLungo;

import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class SaltoInLungo {

	protected Shell shell;
	int salti = 0, s1 = 0, s2 = 0, s3 = 0;
	String nome = "";

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
		btnRegistra.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (Nome.getText().equals("")) {
					MessageDialog.openError(shell, "Error", "Nome vuoto.");
				} else {
					nome = Nome.getText();
					if (salti == 0) {
						if (Misura.getText().equals("")) {
							MessageDialog.openError(shell, "Error", "Misura primo salto vuota.");
						} else {
							s1 = Integer.parseInt(Misura.getText());
							Misura.setText("");
							salti++;
						}
					} else if (salti == 1) {
						if (Misura.getText().equals("")) {
							MessageDialog.openError(shell, "Error", "Misura secondo salto vuota.");
						} else {
							s2 = Integer.parseInt(Misura.getText());
							Misura.setText("");
							salti++;
						}
					} else if (salti == 2) {
						if (Misura.getText().equals("")) {
							MessageDialog.openError(shell, "Error", "Misura terzo salto vuota.");
						} else {
							s3 = Integer.parseInt(Misura.getText());
							Misura.setText("");
							salti = 0;
							Atleta a = new Atleta(nome, s1, s2, s3);
							try {
								a.Registra();
							} catch (IOException | FileException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}

			}
		});
		btnRegistra.setBounds(20, 51, 75, 25);
		btnRegistra.setText("Registra");
	}

}
