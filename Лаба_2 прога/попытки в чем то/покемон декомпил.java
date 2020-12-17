// 
// Decompiled by Procyon v0.5.36
// 

package ru.ifmo.se.pokemon;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Pokemon
{
    private String name;
    private List<Type> types;
    private List<Move> moves;
    private Move preparedMove;
    private Effect stage;
    private Effect condition;
    private List<Effect> effects;
    private int confusion;
    private int level;
    private double[] base;
    
    public Pokemon(final String name, final int level) {
        this.types = new LinkedList<Type>();
        this.moves = new LinkedList<Move>();
        this.stage = new Effect();
        this.condition = new Effect();
        this.effects = new LinkedList<Effect>();
        this.level = 1;
        this.base = new double[Stat.values().length];
        this.types.add(Type.NONE);
        this.moves.add(Move.getStruggleMove());
        this.name = name;
        this.setLevel(level);
    }
    
    public Pokemon() {
        this(Messages.get("noname"), 1);
    }
    
    public final void setStats(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        this.base[Stat.HP.ordinal()] = n;
        this.base[Stat.ATTACK.ordinal()] = n2;
        this.base[Stat.DEFENSE.ordinal()] = n3;
        this.base[Stat.SPECIAL_ATTACK.ordinal()] = n4;
        this.base[Stat.SPECIAL_DEFENSE.ordinal()] = n5;
        this.base[Stat.SPEED.ordinal()] = n6;
    }
    
    public final void setLevel(int level) {
        if (level < 1) {
            level = 1;
        }
        if (level > 100) {
            level = 100;
        }
        this.level = level;
    }
    
    public final double getStat(final Stat stat) {
        final double n = 15.0;
        final double a = 0.0;
        final double n2 = this.base[stat.ordinal()];
        double a2 = this.stage.stat(stat) + (this.condition.success() ? this.condition.stat(stat) : 0.0);
        for (final Effect effect : this.effects) {
            a2 += (effect.success() ? effect.stat(stat) : 0.0);
        }
        if (Math.abs(a2) > 6.0) {
            a2 = ((a2 > 0.0) ? 6.0 : -6.0);
        }
        final double n3 = stat.isHidden() ? 0.0 : ((stat == Stat.HP) ? (this.level + 10.0) : 5.0);
        final double n4 = stat.isHidden() ? 3.0 : 2.0;
        final double n5 = n2 * ((stat == Stat.HP) ? 1.0 : ((a2 > 0.0) ? ((n4 + a2) / n4) : (n4 / (n4 + a2))));
        return (stat.isHidden() ? n5 : ((n5 * 2.0 + n + Math.sqrt(a) / 4.0) * this.level / 100.0)) + n3;
    }
    
    public final boolean hasType(final Type type) {
        final Iterator<Type> iterator = this.types.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == type) {
                return true;
            }
        }
        return false;
    }
    
    public final void addEffect(final Effect condition) {
        if (condition.condition() == Status.NORMAL) {
            this.effects.add(condition);
        }
        else {
            this.setCondition(condition);
        }
    }
    
    public final void setCondition(final Effect condition) {
        if (condition.success() && this.condition.condition() != condition.condition()) {
            this.condition = condition;
            String str = "";
            switch (Pokemon.Pokemon$1.$SwitchMap$ru$ifmo$se$pokemon$Status[condition.condition().ordinal()]) {
                case 1: {
                    str = Messages.get("burn");
                    break;
                }
                case 2: {
                    str = Messages.get("freeze");
                    break;
                }
                case 3: {
                    str = Messages.get("paralyze");
                    break;
                }
                case 4: {
                    str = Messages.get("poison");
                    break;
                }
                case 5: {
                    str = Messages.get("sleep");
                    break;
                }
            }
            System.out.println(this + " " + str);
        }
    }
    
    public final Status getCondition() {
        return this.condition.condition();
    }
    
    public final void confuse() {
        this.confusion = (int)(Math.random() * 4.0 + 1.0);
    }
    
    public final void restore() {
        this.base[Stat.ACCURACY.ordinal()] = 1.0;
        this.base[Stat.EVASION.ordinal()] = 1.0;
        this.condition.clear();
        this.stage.clear();
        this.effects.clear();
    }
    
    public final double getHP() {
        return this.getStat(Stat.HP) - this.stage.stat(Stat.HP);
    }
    
    public final void setMod(final Stat stat, final int a) {
        if (a != 0) {
            int a2 = a + this.stage.stat(stat);
            String str;
            if (stat == Stat.HP) {
                str = Messages.get((a > 0) ? "minusHP" : "plusHP") + " " + Math.abs(a);
            }
            else {
                if (Math.abs(a2) > 6) {
                    a2 = ((a2 > 0) ? 6 : -6);
                }
                str = Messages.get((a < 0) ? "minusStat" : "plusStat");
            }
            this.stage.stat(stat, a2);
            System.out.println(this + " " + str + " " + Messages.get(stat.toString()) + ".");
        }
    }
    
    public final Type[] getTypes() {
        return this.types.toArray(new Type[0]);
    }
    
    public final int getLevel() {
        return this.level;
    }
    
    private double getAttackChance() {
        double n = this.stage.attack() * this.condition.attack();
        final Iterator<Effect> iterator = this.effects.iterator();
        while (iterator.hasNext()) {
            n *= iterator.next().attack();
        }
        return n;
    }
    
    public final void prepareMove() {
        if (this.getAttackChance() > Math.random()) {
            if (this.moves.size() == 0) {
                this.preparedMove = Move.getStruggleMove();
            }
            else if (this.confusion > 0 && Math.random() < 0.33) {
                this.preparedMove = Move.getConfusionMove();
                --this.confusion;
            }
            else {
                this.preparedMove = this.moves.get((int)Math.floor(Math.random() * this.moves.size()));
            }
        }
        else {
            this.preparedMove = Move.getNoMove();
        }
    }
    
    public final boolean isAlive() {
        return this.getStat(Stat.HP) > this.stage.stat(Stat.HP);
    }
    
    public final boolean attack(final Pokemon pokemon) {
        try {
            Thread.sleep(1000L);
        }
        catch (InterruptedException ex) {}
        this.preparedMove.attack(this, pokemon);
        if (this.isAlive() && pokemon.isAlive()) {
            System.out.println();
            return false;
        }
        if (!this.isAlive() && !pokemon.isAlive()) {
            System.out.println(Messages.get("bothFaint"));
        }
        else {
            System.out.println((this.isAlive() ? pokemon : this) + " " + Messages.get("faint"));
        }
        return true;
    }
    
    public final void turn() {
        this.setMod(Stat.HP, this.condition.stat(Stat.HP));
        if (this.condition.turn()) {
            this.condition.clear();
        }
        if (this.condition.condition() == Status.FREEZE && Math.random() < 0.2) {
            this.condition.clear();
            System.out.println(this + " " + Messages.get("thawn"));
        }
        for (final Effect effect : this.effects) {
            this.setMod(Stat.HP, effect.stat(Stat.HP));
            if (effect.turn()) {
                effect.clear();
            }
        }
    }
    
    protected final void setType(final Type... array) {
        this.types.clear();
        if (array == null) {
            this.types.add(Type.NONE);
        }
        else {
            for (int length = array.length, i = 0; i < length; ++i) {
                this.types.add(array[i]);
                if (this.types.size() >= 2) {
                    break;
                }
            }
        }
    }
    
    protected final void addType(final Type type) {
        if (this.types.size() < 2 && !this.types.contains(type)) {
            this.types.add(type);
        }
    }
    
    protected final void setMove(final Move... array) {
        this.moves.clear();
        if (array == null) {
            this.moves.add(Move.getStruggleMove());
        }
        else {
            for (int length = array.length, i = 0; i < length; ++i) {
                this.moves.add(array[i]);
                if (this.moves.size() >= 4) {
                    break;
                }
            }
        }
    }
    
    protected final void addMove(final Move move) {
        this.moves.add(move);
        while (this.moves.size() > 4) {
            this.moves.remove(0);
        }
    }
    
    protected final Move getPreparedMove() {
        return this.preparedMove;
    }
    
    @Override
    public final String toString() {
        return (this.getClass().isAnonymousClass() ? Messages.get("poke") : this.getClass().getSimpleName()) + " " + this.name;
    }
}
