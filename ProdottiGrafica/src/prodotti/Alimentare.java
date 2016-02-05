package prodotti;

public class Alimentare extends Prodotti {

	Data scadenza;
	
	public Alimentare(String codice, String descrizione, float prezzo, Data scadenza) {
		super(codice, descrizione, prezzo); // Chiama il costruttore della classe estesa
		this.scadenza = scadenza; // Imposta il nuovo attributo della classe Alimentare
	}

	/**
	 * Imposta la scadenza
	 * @param scadenza
	 */
	public void setScadenza(Data scadenza) {
		this.scadenza = scadenza;
	}
	
	public Data getScadenza() {
		return scadenza;
	}
	
	public int getAnno() {
		return scadenza.getAnno();
	}
	
	public int getMese() {
		return scadenza.getMese();
	}
	
	public int getGiorno() {
		return scadenza.getGiorno();
	}
	
	@Override
	public void applicaSconto() {
		// TODO Auto-generated method stub
		if (scadenza.getDifference(new Data())<10) {
			prezzo = prezzo * 0.8f;
		} else {
			super.applicaSconto();
		}
	}

	@Override
	public String toString() {
		return "Alimentare [codice=" + codice + ", descrizione=" + descrizione + ", prezzo=" + prezzo + ", scadenza=" + scadenza + "]";
	}
	
}
