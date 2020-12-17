// 
// Decompiled by Procyon v0.5.36
// 

package ru.ifmo.se.pokemon;

public abstract class Move
{
    protected Type type;
    protected double power;
    protected double accuracy;
    protected int priority;
    protected int hits;
    private static final Move noMove;
    private static final Move struggleMove;
    private static final Move confusionMove;
    
    public Move() {
        this(Type.NONE, 0.0, 1.0, 0, 1);
    }
    
    public Move(final Type type, final double n, final double n2) {
        this(type, n, n2, 0, 1);
    }
    
    public Move(final Type type, final double power, final double accuracy, final int priority, final int hits) {
        this.power = 0.0;
        this.accuracy = 1.0;
        this.priority = 0;
        this.hits = 1;
        this.type = type;
        this.accuracy = accuracy;
        this.power = power;
        this.priority = priority;
        this.hits = hits;
    }
    
    protected abstract void attack(final Pokemon p0, final Pokemon p1);
    
    protected boolean checkAccuracy(final Pokemon pokemon, final Pokemon pokemon2) {
        return this.accuracy * pokemon.getStat(Stat.ACCURACY) / pokemon2.getStat(Stat.EVASION) > Math.random();
    }
    
    public final int getPriority() {
        return this.priority;
    }
    
    protected String describe() {
        return Messages.get("attack");
    }
    
    protected void applyOppEffects(final Pokemon pokemon) {
    }
    
    protected void applySelfEffects(final Pokemon pokemon) {
    }
    
    public static final Move getNoMove() {
        return Move.noMove;
    }
    
    public static final Move getStruggleMove() {
        return Move.struggleMove;
    }
    
    public static final Move getConfusionMove() {
        return Move.confusionMove;
    }
    
    static {
        noMove = (Move)new Move.Move$1(Type.NONE, 0.0, 0.0, -100, 0);
        struggleMove = (Move)new Move.Move$2(Type.NONE, 50.0, 1.0);
        confusionMove = (Move)new Move.Move$3(Type.NONE, 40.0, 1.0);
    }
}