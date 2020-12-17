import ru.ifmo.se.pokemon.*;
import java.lang.Math;

	// PhyicalMove

class Facade extends PhysicalMove{
    protected Facade(){
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage){
        Status defCon = def.getCondition();
        if (defCon.equals(Status.BURN) || defCon.equals(Status.POISON) || defCon.equals(Status.PARALYZE)) {
            def.setMod(Stat.HP, (int) Math.round(damage) * 2);
        }
    }

	@Override
	protected String describe() {
		return "physical attack: Facade";
	}
}

class Nuzzle extends PhysicalMove{
	protected Nuzzle() {
		super(Type.ELECTRIC, 20.0, 100.0);
	}

	@Override
	protected void applyOppDamage(Pokemon def, double damage) {
		def.setMod(Stat.HP, (int) Math.round(damage));
	}

	@Override
	protected void applyOppEffects(Pokemon def) {
		Effect.paralyze(def);
	}
	
	@Override
	protected String describe() {
		return "physical attack: Nuzzle";
	}
}

class Low_Sweep extends PhysicalMove{
	protected Low_Sweep() {
		super(Type.FIGHTING, 65.0, 100.0);
	}

	@Override
	protected void applyOppDamage(Pokemon def, double damage) {
		def.setMod(Stat.HP, (int) Math.round(damage));
	}

	@Override
	protected void applyOppEffects(Pokemon def) {
		def.setMod(Stat.SPEED, -1);
	}
	
	@Override
	protected String describe() {
		return "physical attack: Low Sweeeeeep";
	}
}

class Rock_Tomb extends PhysicalMove{
	protected Rock_Tomb() {
		super(Type.ROCK, 60.0, 95.0);
	}

	@Override
	protected void applyOppDamage(Pokemon def, double damage) {
		def.setMod(Stat.HP, (int) Math.round(damage));
	}

	@Override
	protected void applyOppEffects(Pokemon def) {
		def.setMod(Stat.SPEED, -1);
	}
	
	@Override
	protected String describe() {
		return "physical attack: Rock_Tomb";
	}
}

class Wake_Up_Slap extends PhysicalMove{
    protected Wake_Up_Slap(){
        super(Type.FIGHTING, 70, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage){
        Status defCon = def.getCondition();
        if (defCon.equals(Status.SLEEP)) {
        	def.setMod(Stat.HP, (int) Math.round(damage) * 2);
        	def.setCondition(new Effect());
        }
        else def.setMod(Stat.HP, (int) Math.round(damage));
    }

    @Override
	protected String describe() {
		return "physical attack: Wake Up SLAP";
	}
}

class Double_Slap extends PhysicalMove{
    protected Double_Slap(){
        super(Type.NORMAL, 15, 85);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage){
        def.setMod(Stat.HP, (int) Math.round(damage));
        if (Math.random() < 0.375) {
        	def.setMod(Stat.HP, (int) Math.round(2 * damage));
        	if (Math.random() < 0.375) {
        		def.setMod(Stat.HP, (int) Math.round(3 * damage));
        		if (Math.random() < 0.125) {
        			def.setMod(Stat.HP, (int) Math.round(4 * damage));
        			if (Math.random() < 0.125) {
        				def.setMod(Stat.HP, (int) Math.round(5 * damage));
        			}
        		}
        	}	
        }
    }

    @Override
	protected String describe() {
		return "physical attack: Double SLAP";
	}
}

	// SpecialMove

class Shock_Wave extends SpecialMove{
	protected Shock_Wave() {
		super(Type.ELECTRIC, 60, 0);
	}

	@Override
	protected void applyOppDamage(Pokemon def, double damage) {
		def.setMod(Stat.HP, (int) Math.round(damage));
	}

	@Override
	protected boolean checkAccuracy(Pokemon att, Pokemon def) {
		return true;
	}
	
	@Override
	protected String describe() {
		return "special attack: Shock Wave";
	}
}

class Thunderbolt extends SpecialMove{
	protected Thunderbolt() {
		super(Type.ELECTRIC, 90.0, 100.0);
	}

	@Override
	protected void applyOppDamage(Pokemon def, double damage) {
		def.setMod(Stat.HP, (int) Math.round(damage));
	}

	@Override
	protected void applyOppEffects(Pokemon def) {
		if (Math.random() <= 0.1) { Effect.paralyze(def); }
	}
	
	@Override
	protected String describe() {
		return "special attack: Thunderbolt";
	}
}

	// StatusMove

class Confide extends StatusMove {
    protected Confide(){
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.SPECIAL_ATTACK, -1);
    }
}

class Eerie_Impulse extends StatusMove {
    protected Eerie_Impulse(){
        super(Type.ELECTRIC, 0, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.SPECIAL_ATTACK, -2);
    }
}

class Rest extends StatusMove {
    protected Rest(){
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
	protected boolean checkAccuracy(Pokemon att, Pokemon def) {
		return true;
	}

    @Override
    protected void applySelfEffects(Pokemon p){
   		p.setMod(Stat.HP, (int) (p.getHP() - p.getStat(Stat.HP)));
        p.setCondition(new Effect().condition(Status.SLEEP).attack(0.0).turns(3));
    }
}






// Для Андрея атака 
// она физикал мув или спешиал мув? или статус мув? ОН БОТАЕТ)))) ПОЛИНА ПРИВЕТТИК

// class FireBlutzzzz extends PhysicalMove{
//     protected FireBlutzzzz(){
//         super(Type.FIRE, 120, 100);
        
//     }

//     @Override
//     protected void applyOppDamage(Pokemon def, double damage){
//         Status defCon = def.getCondition();
//         if (defCon.equals(Status.FREEZE){ def.setCondition(new Effect().condition(Status.NORMAL).turns(0)); }
//         if (Math.random() <= 0.1){ 
//         	def.setCondition(new Effect().condition(Status.BURN).turns(3));
//         	def.setMod(Stat.HP, (int) Math.round(damage));
//         }
//         else {
//         	def.setMod(Stat.HP, (int) Math.round(damage));
//         }
//     }

//     @Override
// 	protected void applyOppEffects(Pokemon def) {
// 		if (Math.random() <= 0.1){
// 			def.setMod(Stat.HP, (int) Math.round(damage) / 3);
// 		}
// 	}

// 	@Override
// 	protected String describe() {
// 		return "physical attack: произошла атака огненный блитцкрЫг";
// 	}
// }