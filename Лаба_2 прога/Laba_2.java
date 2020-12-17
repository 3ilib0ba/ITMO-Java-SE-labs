import ru.ifmo.se.pokemon.*;

public class Laba_2{
	public static void main(String[] args) {
		System.out.println("Start All");
		
		Emolga p1 = new Emolga("my Emo", 10);
		// Heliolisk p4 = new Heliolisk("my lisk", 10);
		// Helioptile p5 = new Helioptile("my Ptile", 10);
		// Poliwag p2 = new Poliwag("my Poliwag", 10);
		// Poliwhirl p3 = new Poliwhirl("my Poliwhirl", 10);
		// Politoed p6 = new Politoed("my Politoed 1", 10);

		Battle b = new Battle();
		b.addAlly(p1);
		// b.addAlly(p2);
		// b.addAlly(p3);
		// b.addFoe(p4);
		// b.addFoe(p5);
		b.addFoe(p1);
		b.go();


	}
}