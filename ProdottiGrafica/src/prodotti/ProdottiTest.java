package prodotti;

public class ProdottiTest {
	public static void main(String[] args) {
		Prodotti p = new Prodotti("123","qwe",12);
		System.out.println(p);
		Prodotti p1 = new Prodotti("123","qwe",12);
		System.out.println(p.equals(p1));
		try {
			Prodotti p2 = (Prodotti) p1.clone();
			System.out.println(p2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Alimentare
		Alimentare a = new Alimentare("qwe", "banane", 100.0f, new Data(26,1,2016));
		System.out.println(a);
		a.applicaSconto();
		System.out.println(a);
		
		//Non Alimentare
		NonAlimentare na = new NonAlimentare("asd", "bicchiere", 100.0f, "vetro");
		System.out.println(na);
		na.applicaSconto();
		System.out.println(na);
	}
}
