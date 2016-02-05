package prodotti;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.IOException;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class ProdottiGraficaTest {

	protected Shell shlSpesaGrafica;
	private Text Codice;
	private Text Descrizione;
	private Text Prezzo;
	private Table Table;
	private Text Giorno;
	private Text Mese;
	private Text Anno;
	private Text Materiale;
	private Text Totale;
	private int n = 0;
	private ListaSpesa ls[] = new ListaSpesa[10];

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ProdottiGraficaTest window = new ProdottiGraficaTest();
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
		shlSpesaGrafica.open();
		shlSpesaGrafica.layout();
		while (!shlSpesaGrafica.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSpesaGrafica = new Shell();
		shlSpesaGrafica.setSize(720, 400);
		shlSpesaGrafica.setText("Zhou S.P.A.");
		
		Label lblCodice = new Label(shlSpesaGrafica, SWT.NONE);
		lblCodice.setEnabled(false);
		lblCodice.setBounds(10, 50, 55, 15);
		lblCodice.setText("Codice");
		
		Label lblDescrizione = new Label(shlSpesaGrafica, SWT.NONE);
		lblDescrizione.setEnabled(false);
		lblDescrizione.setBounds(10, 80, 69, 15);
		lblDescrizione.setText("Descrizione");
		
		Label lblPrezzo = new Label(shlSpesaGrafica, SWT.NONE);
		lblPrezzo.setEnabled(false);
		lblPrezzo.setBounds(10, 110, 55, 15);
		lblPrezzo.setText("Prezzo");
		
		Codice = new Text(shlSpesaGrafica, SWT.BORDER);
		Codice.setEnabled(false);
		Codice.setBounds(85, 45, 83, 21);
		
		Descrizione = new Text(shlSpesaGrafica, SWT.BORDER);
		Descrizione.setEnabled(false);
		Descrizione.setBounds(85, 75, 83, 21);
		
		Prezzo = new Text(shlSpesaGrafica, SWT.BORDER);
		Prezzo.setEnabled(false);
		Prezzo.setBounds(85, 105, 83, 21);
		
		Giorno = new Text(shlSpesaGrafica, SWT.BORDER);
		Giorno.setEnabled(false);
		Giorno.setBounds(68, 140, 25, 21);
		
		Mese = new Text(shlSpesaGrafica, SWT.BORDER);
		Mese.setEnabled(false);
		Mese.setBounds(99, 140, 25, 21);
		
		Anno = new Text(shlSpesaGrafica, SWT.BORDER);
		Anno.setEnabled(false);
		Anno.setBounds(131, 140, 37, 21);
		
		Label lblScadenza = new Label(shlSpesaGrafica, SWT.NONE);
		lblScadenza.setEnabled(false);
		lblScadenza.setBounds(10, 145, 55, 15);
		lblScadenza.setText("Scadenza");
		
		Materiale = new Text(shlSpesaGrafica, SWT.BORDER);
		Materiale.setEnabled(false);
		Materiale.setBounds(92, 165, 76, 21);
		
		Label lblMateriale = new Label(shlSpesaGrafica, SWT.NONE);
		lblMateriale.setEnabled(false);
		lblMateriale.setBounds(10, 170, 55, 15);
		lblMateriale.setText("Materiale");
		
		Totale = new Text(shlSpesaGrafica, SWT.BORDER);
		Totale.setEnabled(false);
		Totale.setBounds(92, 195, 76, 21);
		
		Label lblTotale = new Label(shlSpesaGrafica, SWT.NONE);
		lblTotale.setEnabled(false);
		lblTotale.setBounds(10, 200, 55, 15);
		lblTotale.setText("Totale");
		
		Label label = new Label(shlSpesaGrafica, SWT.NONE);
		label.setEnabled(false);
		label.setBounds(80, 200, 10, 15);
		label.setText("\u20AC");
		
		Table = new Table(shlSpesaGrafica, SWT.BORDER);
		Table.setEnabled(false);
		Table.setBounds(195, 10, 475, 303);
		Table.setHeaderVisible(true);
		Table.setLinesVisible(true);
		
		TableColumn tblclmnProdotto = new TableColumn(Table, SWT.NONE);
		tblclmnProdotto.setResizable(false);
		tblclmnProdotto.setWidth(100);
		tblclmnProdotto.setText("Prodotto");
		
		TableColumn tblclmnCodice = new TableColumn(Table, SWT.NONE);
		tblclmnCodice.setResizable(false);
		tblclmnCodice.setWidth(50);
		tblclmnCodice.setText("Codice");
		
		TableColumn tblclmnDescrizione = new TableColumn(Table, SWT.NONE);
		tblclmnDescrizione.setResizable(false);
		tblclmnDescrizione.setWidth(100);
		tblclmnDescrizione.setText("Descrizione");
		
		TableColumn tblclmnPrezzo = new TableColumn(Table, SWT.NONE);
		tblclmnPrezzo.setResizable(false);
		tblclmnPrezzo.setWidth(50);
		tblclmnPrezzo.setText("Prezzo");
		
		TableColumn tblclmnScadenza = new TableColumn(Table, SWT.NONE);
		tblclmnScadenza.setResizable(false);
		tblclmnScadenza.setWidth(70);
		tblclmnScadenza.setText("Scadenza");
		
		TableColumn tblclmnMateriale = new TableColumn(Table, SWT.NONE);
		tblclmnMateriale.setResizable(false);
		tblclmnMateriale.setWidth(100);
		tblclmnMateriale.setText("Materiale");
		
		Combo Prodotto = new Combo(shlSpesaGrafica, SWT.NONE);
		Prodotto.setEnabled(false);
		Prodotto.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (Prodotto.getSelectionIndex() == 0) {
					// alimentare
					Materiale.setEnabled(false);
					lblMateriale.setEnabled(false);
					Giorno.setEnabled(true);
					Mese.setEnabled(true);
					Anno.setEnabled(true);
					lblScadenza.setEnabled(true);
				} else {
					// non alimentare
					Materiale.setEnabled(true);
					lblMateriale.setEnabled(true);
					Giorno.setEnabled(false);
					Mese.setEnabled(false);
					Anno.setEnabled(false);
					lblScadenza.setEnabled(false);
				}
			}
		});
		Prodotto.setItems(new String[] {"Alimentare", "Non Alimentare"});
		Prodotto.setBounds(10, 10, 158, 23);
		Prodotto.setText("Scegli il tipo di prodotto");
		
		Button btnAggiungiProdotto = new Button(shlSpesaGrafica, SWT.NONE);
		btnAggiungiProdotto.setEnabled(false);
		btnAggiungiProdotto.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if(Prodotto.getSelectionIndex() == 0) {
					String codice = Codice.getText();
					String descrizione = Descrizione.getText();
					float prezzo = Float.parseFloat(Prezzo.getText());
					int g = Integer.parseInt(Giorno.getText());
					int m = Integer.parseInt(Mese.getText());
					int a = Integer.parseInt(Anno.getText());
					Alimentare al = new Alimentare(codice, descrizione, prezzo, new Data(g, m, a));
					try {
						ls[n].aggiungiProdotto(al);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					TableItem item = new TableItem (Table, SWT.NONE);
					item.setText(0, "Alimentare");
					item.setText(1, al.getCodice());
					item.setText(2, al.getDescrizione());
					item.setText(3, Float.toString(al.getPrezzo()));
					item.setText(4, Integer.toString(g) + "/" + Integer.toString(m) + "/" + Integer.toString(a));
				} else {
					String codice = Codice.getText();
					String descrizione = Descrizione.getText();
					float prezzo = Float.parseFloat(Prezzo.getText());
					String materiale = Materiale.getText();
					NonAlimentare nal = new NonAlimentare(codice, descrizione, prezzo, materiale);
					try {
						ls[n].aggiungiProdotto(nal);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					TableItem item = new TableItem (Table, SWT.NONE);
					item.setText(0, "Non Alimentare");
					item.setText(1, nal.getCodice());
					item.setText(2, nal.getDescrizione());
					item.setText(3, Float.toString(nal.getPrezzo()));
					item.setText(5, nal.getMateriale());
				}
			}
		});
		btnAggiungiProdotto.setBounds(62, 250, 106, 25);
		btnAggiungiProdotto.setText("Aggiungi Prodotto");
		
		Button btnEliminaProdotto = new Button(shlSpesaGrafica, SWT.NONE);
		btnEliminaProdotto.setEnabled(false);
		btnEliminaProdotto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = Table.getSelectionIndex();
				if(index != -1) {
					Table.remove(index);
					ls[n].eliminaProdotto(index);
					Totale.setText(Double.toString(ls[n].totale));
				} else {
					MessageDialog.openError(shlSpesaGrafica, "Errore", "Nessun elemento selezionato!");
				}	
			}
		});
		btnEliminaProdotto.setBounds(62, 285, 106, 25);
		btnEliminaProdotto.setText("Elimina Prodotto");
		
		Button btnCalcolaTotale = new Button(shlSpesaGrafica, SWT.NONE);
		btnCalcolaTotale.setEnabled(false);
		btnCalcolaTotale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ls[n].calcolaSpesa();
				Totale.setText(Double.toString(ls[n].totale));
			}
		});
		btnCalcolaTotale.setBounds(62, 320, 106, 25);
		btnCalcolaTotale.setText("Calcola Totale");

		Button btnSalvaScontrino = new Button(shlSpesaGrafica, SWT.NONE);
		btnSalvaScontrino.setEnabled(false);
		btnSalvaScontrino.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					ls[n].salvaScontrini();
				} catch (IOException | FileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalvaScontrino.setBounds(440, 325, 106, 25);
		btnSalvaScontrino.setText("Salva Scontrino");
		
		Button btnCaricaScontrino = new Button(shlSpesaGrafica, SWT.NONE);
		btnCaricaScontrino.setEnabled(false);
		btnCaricaScontrino.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int nP = ls[n].numProdotti;
				try {
					ls[n].caricaScontrini();
					for(int i = nP; i < ls[n].numProdotti; i++) {
						if(ls[n].getLista()[i] instanceof Alimentare) {
							TableItem item = new TableItem (Table, SWT.NONE);
							item.setText(0, "Alimentare");
							item.setText(1, ls[n].getLista()[i].getCodice());
							item.setText(2, ls[n].getLista()[i].getDescrizione());
							item.setText(3, Float.toString(ls[n].getLista()[i].getPrezzo()));
							item.setText(4, Integer.toString(((Alimentare) ls[n].getLista()[i]).getGiorno()) + "/" + Integer.toString(((Alimentare) ls[n].getLista()[i]).getMese()) + "/" + Integer.toString(((Alimentare) ls[n].getLista()[i]).getAnno()));
						} else {
							TableItem item = new TableItem (Table, SWT.NONE);
							item.setText(0, "Non Alimentare");
							item.setText(1, ls[n].getLista()[i].getCodice());
							item.setText(2, ls[n].getLista()[i].getDescrizione());
							item.setText(3, Float.toString(ls[n].getLista()[i].getPrezzo()));
							item.setText(5, ((NonAlimentare) ls[n].getLista()[i]).getMateriale());
						}
					}
					nP += ls[n].numProdotti;
					ls[n].calcolaSpesa();
					Totale.setText(Double.toString(ls[n].totale));
					// li reinserisci tutti nella tabella
				} catch (IOException | FileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCaricaScontrino.setBounds(550, 325, 106, 25);
		btnCaricaScontrino.setText("Carica Scontrino");
		
		Button btnCreaScontrino = new Button(shlSpesaGrafica, SWT.NONE);
		btnCreaScontrino.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				MessageDialog dg = new MessageDialog(
						shlSpesaGrafica.getShell(),
						"Nuovo scontrino",
						null,
						"Hai la tessera fedeltà?",
						MessageDialog.QUESTION,
						new String[] {
								IDialogConstants.YES_LABEL,
								IDialogConstants.NO_LABEL},
						0
						);
				switch(dg.open()) {
				case 0: 
					//yes
					label.setEnabled(true);
					lblCodice.setEnabled(true);
					lblDescrizione.setEnabled(true);
					lblPrezzo.setEnabled(true);
					lblTotale.setEnabled(true);
					Codice.setEnabled(true);
					Descrizione.setEnabled(true);
					Prezzo.setEnabled(true);
					Totale.setEnabled(true);
					Table.setEnabled(true);
					Prodotto.setEnabled(true);
					btnAggiungiProdotto.setEnabled(true);
					btnEliminaProdotto.setEnabled(true);
					btnCalcolaTotale.setEnabled(true);
					btnSalvaScontrino.setEnabled(true);
					btnCaricaScontrino.setEnabled(true);
					if(n == 0) {
						ls[n] = new ListaSpesa(true);
					} else {
						ls[n++] = new ListaSpesa(true);
					}
					break;
				case 1:
					//no
					label.setEnabled(true);
					lblCodice.setEnabled(true);
					lblDescrizione.setEnabled(true);
					lblPrezzo.setEnabled(true);
					lblTotale.setEnabled(true);
					Codice.setEnabled(true);
					Descrizione.setEnabled(true);
					Prezzo.setEnabled(true);
					Totale.setEnabled(true);
					Table.setEnabled(true);
					Prodotto.setEnabled(true);
					btnAggiungiProdotto.setEnabled(true);
					btnEliminaProdotto.setEnabled(true);
					btnCalcolaTotale.setEnabled(true);
					btnSalvaScontrino.setEnabled(true);
					btnCaricaScontrino.setEnabled(true);
					if(n == 0) {
						ls[n] = new ListaSpesa(false);
					} else {
						ls[n++] = new ListaSpesa(false);
					}
					break;
				case 2:
					//cancel
					System.out.println("cancel");
					break;
				}
			}
		});
		btnCreaScontrino.setBounds(330, 325, 106, 25);
		btnCreaScontrino.setText("Crea Scontrino");
	}
}
