// 
// Decompiled by Procyon v0.5.36
// 

package ru.ifmo.se.pokemon;

public final class Effect
{
    private int[] mods;
    private int turns;
    private double effectChance;
    private double attackChance;
    private Status condition;
    
    public Effect() {
        this.mods = new int[Stat.values().length];
        this.turns = 0;
        this.effectChance = 1.0;
        this.attackChance = 1.0;
        this.condition = Status.NORMAL;
    }
    
    public final Effect turns(final int turns) {
        this.turns = turns;
        return this;
    }
    
    public final Effect chance(final double effectChance) {
        this.effectChance = effectChance;
        return this;
    }
    
    public final Effect attack(final double attackChance) {
        this.attackChance = attackChance;
        return this;
    }
    
    public final double attack() {
        return this.attackChance;
    }
    
    public final Effect condition(final Status condition) {
        this.condition = condition;
        return this;
    }
    
    public final void clear() {
        final Stat[] values = Stat.values();
        for (int length = values.length, i = 0; i < length; ++i) {
            this.mods[values[i].ordinal()] = 0;
        }
        this.condition = Status.NORMAL;
        this.turns = 0;
        this.effectChance = 1.0;
        this.attackChance = 1.0;
    }
    
    public final Status condition() {
        return this.condition;
    }
    
    public final int stat(final Stat stat) {
        return this.mods[stat.ordinal()];
    }
    
    public final Effect stat(final Stat stat, int n) {
        if (stat != Stat.HP) {
            if (n >= 0 & n > 6) {
                n = 6;
            }
            if (n < 0 & n < -6) {
                n = -6;
            }
        }
        this.mods[stat.ordinal()] = n;
        return this;
    }
    
    public final boolean success() {
        return this.effectChance > Math.random();
    }
    
    public final boolean immediate() {
        return this.turns == 0;
    }
    
    public final boolean turn() {
        final int turns = this.turns - 1;
        this.turns = turns;
        return turns == 0;
    }
    
    public static void burn(final Pokemon pokemon) {
        if (!pokemon.hasType(Type.FIRE)) {
            final Effect turns = new Effect().condition(Status.BURN).turns(-1);
            turns.stat(Stat.ATTACK, -2).stat(Stat.HP, (int)pokemon.getStat(Stat.HP) / 16);
            pokemon.setCondition(turns);
        }
    }
    
    public static void paralyze(final Pokemon pokemon) {
        if (!pokemon.hasType(Type.ELECTRIC)) {
            final Effect turns = new Effect().condition(Status.PARALYZE).attack(0.75).turns(-1);
            turns.stat(Stat.SPEED, -2);
            pokemon.setCondition(turns);
        }
    }
    
    public static void freeze(final Pokemon pokemon) {
        if (!pokemon.hasType(Type.ICE)) {
            pokemon.setCondition(new Effect().condition(Status.FREEZE).attack(0.0).turns(-1));
        }
    }
    
    public static void poison(final Pokemon pokemon) {
        if (!pokemon.hasType(Type.POISON) && !pokemon.hasType(Type.STEEL)) {
            final Effect turns = new Effect().condition(Status.POISON).turns(-1);
            turns.stat(Stat.HP, (int)pokemon.getStat(Stat.HP) / 8);
            pokemon.setCondition(turns);
        }
    }
    
    public static void sleep(final Pokemon pokemon) {
        pokemon.setCondition(new Effect().condition(Status.SLEEP).attack(0.0).turns((int)(Math.random() * 3.0 + 1.0)));
    }
    
    public static void flinch(final Pokemon pokemon) {
        pokemon.addEffect(new Effect().attack(0.0).turns((int)(Math.random() * 4.0 + 1.0)));
    }
    
    public static void confuse(final Pokemon pokemon) {
        pokemon.confuse();
    }
}
