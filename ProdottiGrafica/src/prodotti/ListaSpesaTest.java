package prodotti;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.IOException;
import java.util.Arrays;

public class ListaSpesaTest implements Serializable{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);

		String dati;
		String datiTastiera;
		char s = ' ';
		int c = 0;
		int n = 0;
		String codice = "";
		String descrizione = "";
		float prezzo = 0;
		String materiale = "";
		int g = 0, m = 0, a = 0;
		int totale = 0;
		int  pos = 0;

		ListaSpesa ls[] = new ListaSpesa[10];

		do {
			System.out.println("Premi 1 per creare uno scontrino.");
			System.out.println("Premi 2 per aggiungere un prodotto.");
			System.out.println("Premi 3 per calcolare il totale.");
			System.out.println("Premi 4 per eliminare un prodotto.");
			System.out.println("Premi 5 per visualizzare i scontrini.");
			System.out.println("Premi 6 per salvare i scontrini.");
			System.out.println("Premi 7 per caricare i scontrini.");
			System.out.println("Premi 8 per salvare i scontrini in binario.");
			System.out.println("Premi 9 per caricare i scontrini in binario.");
			System.out.println("Premi q per uscire.");
			System.out.print("Scegli cosa fare: ");

			try {
				datiTastiera = tastiera.readLine();
				s = datiTastiera.charAt(0);
			} catch(IOException e) {
				e.printStackTrace();
				continue;
			}

			switch(s) {
			case '1':
				do {
					c = 0;
					System.out.println("Premi 1 se hai la tessera.");
					System.out.println("Premi 2 se non hai la tessera.");
					System.out.print("Tessera fedeltà: ");

					try {
						datiTastiera = tastiera.readLine();
						c = Integer.valueOf(datiTastiera).intValue();
					} catch(Exception e) {
						System.out.println("Errore tastiera!");
						c = 0;
					}
				} while(c == 0);

				if(n == 0) {
					if(c == 1) {
						ls[n] = new ListaSpesa(true);
					} else {
						ls[n] = new ListaSpesa(false);
					}
				} else {
					if(c == 1) {
						ls[n++] = new ListaSpesa(true);
					} else {
						ls[n++] = new ListaSpesa(false);
					}
				}

				break;

			case '2':
				do {
					c = 0;
					System.out.println("Premi 1 se alimentare.");
					System.out.println("Premi 2 se non alimentare.");
					System.out.print("Inserisci prodotto: ");

					try {
						datiTastiera = tastiera.readLine();
						c = Integer.valueOf(datiTastiera).intValue();
					} catch(Exception e) {
						System.out.println("Errore tastiera!");
						c = 0;
					}
				} while(c == 0);

				if(c == 1) {
					System.out.print("Inserisci il codice dell'alimentare: ");
					try {
						codice = tastiera.readLine();
					} catch(IOException e) {
						e.printStackTrace();
					}

					System.out.print("Inserisci la descrizione dell'alimentare: ");
					try {
						descrizione = tastiera.readLine();
					} catch(IOException e) {
						e.printStackTrace();
					}

					System.out.print("Inserisci il prezzo dell'alimentare: ");
					try {
						datiTastiera = tastiera.readLine();
						prezzo = Float.parseFloat(datiTastiera);
					} catch (IOException e) {
						e.printStackTrace();
					}

					do {
						g = 0;
						System.out.println("Inserisci la data di scadenza dell'alimentare: ");
						System.out.print("Giorno: ");
						try {
							datiTastiera = tastiera.readLine();
							g = Integer.valueOf(datiTastiera).intValue();
						} catch(Exception e) {
							System.out.println("Errore tastiera!");
							g = 0;
						}
					} while(g == 0);

					do {
						m  = 0;
						System.out.print("Mese: ");
						try {
							datiTastiera = tastiera.readLine();
							m = Integer.valueOf(datiTastiera).intValue();
						} catch(Exception e) {
							System.out.println("Errore tastiera!");
							m = 0;
						}
					} while(m == 0);

					do {
						a = 0;
						System.out.print("Anno: ");
						try {
							datiTastiera = tastiera.readLine();
							a = Integer.valueOf(datiTastiera).intValue();
						} catch(Exception e) {
							System.out.println("Errore tastiera!");
							a = 0;
						}
					} while(a == 0);

					Alimentare al = new Alimentare(codice, descrizione, prezzo, new Data(g, m, a));
					ls[n].aggiungiProdotto(al);
				} else {
					System.out.print("Inserisci il codice del non alimentare: ");
					try {
						codice = tastiera.readLine();
					} catch(IOException e) {
						e.printStackTrace();
					}

					System.out.print("Inserisci la descrizione del non alimentare: ");
					try {
						descrizione = tastiera.readLine();
					} catch(IOException e) {
						e.printStackTrace();
					}

					System.out.print("Inserisci il prezzo del non alimentare: ");
					try {
						datiTastiera = tastiera.readLine();
						prezzo = Float.parseFloat(datiTastiera);
					} catch(IOException e) {
						e.printStackTrace();
					}

					System.out.print("Inserisci il materiale del non alimentare: ");
					try {
						materiale = tastiera.readLine();
					} catch(IOException e) {
						e.printStackTrace();
					}

					NonAlimentare nal = new NonAlimentare(codice, descrizione, prezzo, materiale);
					ls[n].aggiungiProdotto(nal);
				}

				break;

			case'3':
				ls[n].calcolaSpesa();
				break;

			case '4':
				do {
					pos  = 0;
					System.out.print("Inserisci il numero del prodotto da eliminare: ");
					try {
						datiTastiera = tastiera.readLine();
						pos = Integer.valueOf(datiTastiera).intValue();
					} catch(Exception e) {
						System.out.println("Errore tastiera!");
						pos = 0;
					}
				} while(pos == 0);
				ls[n].eliminaProdotto(pos);
				break;

			case '5':
				for(int i = 0; i <= n; i++) {
					System.out.println(ls[i]);
				}
				break;

			case '6':
				ls[n].salvaScontrini();
				break;

			case '7':
				ls[n].caricaScontrini();
				break;

			case '8':
				ls[n].salvaScontriniBin();
				break;

			case '9':
				ls[n].caricaScontriniBin();
				break;

			case 'q':
			case 'Q':
				System.out.println("Grazie e arrivederci.");
				break;

			default:
				System.out.println("Scelta non valida, prego riprovare!");
				break;
			}

		} while (s != 'q' && s != 'Q');

		/*Alimentare a = new Alimentare("qwe", "banane", 100.0f, new Data(26,1,2016));
		NonAlimentare na = new NonAlimentare("asd", "bicchiere", 100.0f, "vetro");

		ls.aggiungiProdotto(a);
		ls.aggiungiProdotto(na);
		ls.calcolaSpesa();
		System.out.println(ls);*/
	}

}
