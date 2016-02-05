package prodotti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class ListaSpesa implements Serializable{
	Prodotti[] lista;
	int numProdotti = 0;
	final int maxProdotti = 100;
	boolean tessera;
	double totale = 0;

	public ListaSpesa(boolean tessera) {
		lista = new Prodotti[100];
		this.tessera = tessera;
	}

	public void aggiungiProdotto(Prodotti p) throws Exception {
		if(numProdotti < maxProdotti) {
			if(tessera) {
				p.applicaSconto();
			}
			lista[numProdotti++] = p;
		} else {
			throw exception("La lista � piena!");
		}

	}

	private Exception exception(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void calcolaSpesa() {

		this.totale = 0;
		for(int i = 0; i < numProdotti; i++) {
			this.totale = this.totale + lista[i].getPrezzo();
		}

	}

	public void eliminaProdotto(int pos) {

		for(int i = pos; i < numProdotti; i++) {
			lista[i] = lista[i++];
		}
		numProdotti--;
		totale = totale - lista[pos].getPrezzo();

	}

	public void salvaScontrini() throws java.io.IOException, FileException {
		TextFile out = new TextFile("scontrino.txt", 'W');
		int tempg, tempm, tempa;
		String temps;

		for(int i = 0; i < numProdotti; i++) {
			if(lista[i] != null) {
				if(lista[i] instanceof Alimentare) {
					String line = Integer.toString(i);
					line += ";Alimentare";
					line += ";" + lista[i].getCodice();
					line += ";" + lista[i].getDescrizione();
					line += ";" + lista[i].getPrezzo();
					line += ";" + ((Alimentare) lista[i]).getGiorno();
					line += ";" + ((Alimentare) lista[i]).getMese();
					line += ";" + ((Alimentare) lista[i]).getAnno();
					out.toFile(line);
				} else {
					String line = Integer.toString(i);
					line += ";Non Alimentare";
					line += ";" + lista[i].getCodice();
					line += ";" + lista[i].getDescrizione();
					line += ";" + lista[i].getPrezzo();
					line += ";" + ((NonAlimentare) lista[i]).getMateriale();
					out.toFile(line);
				}

			}
		}
		out.closeFile();
	}

	public void caricaScontrini() throws java.io.IOException, FileException {
		TextFile in = new TextFile("scontrino.txt", 'R');
		int posizione;
		String linea, prodotto, codice, descrizione, materiale;
		String [] elementi;
		int g = 0, m = 0, a = 0;
		float prezzo;

		try {
			while(true) {
				linea = in.fromFile();
				elementi = linea.split(";");
				prodotto = elementi[1];
				if(prodotto.equals("Alimentare")) {
					codice = elementi[2];
					descrizione = elementi[3];
					prezzo = Float.parseFloat(elementi[4]);
					g = Integer.valueOf(elementi[5]).intValue();
					m = Integer.valueOf(elementi[6]).intValue();
					a = Integer.valueOf(elementi[7]).intValue();
					Alimentare al = new Alimentare(codice, descrizione, prezzo, new Data(g, m, a));
					lista[numProdotti++] = al;
				} else {
					codice = elementi[2];
					descrizione = elementi[3];
					prezzo = Float.parseFloat(elementi[4]);
					materiale = elementi[5];
					NonAlimentare nal = new NonAlimentare(codice, descrizione, prezzo, materiale);
					lista[numProdotti++] = nal;
				}

			}
		} catch(FileException exception) {
		}
	}

	public void salvaScontriniBin() {
		ObjectOutputStream stream;
		try {
			stream = new ObjectOutputStream(new FileOutputStream("scontrino.bin"));
			stream.writeObject(lista);
			stream.writeInt(numProdotti);
			stream.writeBoolean(tessera);
			stream.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Impossibile salvare!");
		}
	}

	public void caricaScontriniBin() throws java.io.IOException {
		ObjectInputStream stream;
		try {
			stream = new ObjectInputStream(new FileInputStream("scontrino.bin"));
			this.lista = (Prodotti[]) stream.readObject();
			this.numProdotti = stream.readInt();
			this.tessera = stream.readBoolean();
			stream.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Impossibile caricare!");
		}
	}

	public Prodotti[] getLista() {
		return lista;
	}
	
	@Override
	public String toString() {
		String s = "";

		for(int i = 0; i < numProdotti; i++) {
			if(lista[i] instanceof Alimentare) {
				s = s + ("Alimentare [codice= " + lista[i].getCodice()+ ", descrizione=" + lista[i].getDescrizione() + ", prezzo=" + lista[i].getPrezzo() + ", scadenza=" + ((Alimentare) lista[i]).getScadenza() + "]\n");
			} else {
				s = s + ("Non Alimentare [codice= " + lista[i].getCodice()+ ", descrizione=" + lista[i].getDescrizione() + ", prezzo=" + lista[i].getPrezzo() + ", materiale=" + ((NonAlimentare) lista[i]).getMateriale() + "]\n");
			}
		}
		s = s + "Totale= " + totale + "\n";

		return s;
	}

}
