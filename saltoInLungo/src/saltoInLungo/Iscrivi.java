package saltoInLungo;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Iscrivi {

	protected Shell shell;
	private Text Nome;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Iscrivi window = new Iscrivi();
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
		shell.setSize(450, 300);
		shell.setText("Iscriviti");
		
		Nome = new Text(shell, SWT.BORDER);
		Nome.setBounds(197, 73, 157, 21);
		
		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setBounds(95, 76, 55, 15);
		lblNome.setText("Nome:");
		
		Button btnMandaIscrizione = new Button(shell, SWT.NONE);
		btnMandaIscrizione.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (Nome.getText().equals("")) {
					MessageDialog.openError(shell, "Errore", "Nome vuoto.");
				} else {
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter("Iscritti.txt", true));
						writer.append(Nome.getText() + "\n");
						writer.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnMandaIscrizione.setBounds(95, 112, 125, 25);
		btnMandaIscrizione.setText("Manda Iscrizione");

	}
}
