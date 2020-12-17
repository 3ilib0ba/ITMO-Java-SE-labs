import ru.ifmo.se.pokemon.*;

public class Politoed extends Poliwhirl{
	public Politoed(String name, int level){
        super(name, level);
        setStats(90, 75, 75, 90, 100, 70);
        setType(Type.WATER);
        setMove(new Rest(), new Facade(), 
        	new Wake_Up_Slap(), new Double_Slap());
    }
}
