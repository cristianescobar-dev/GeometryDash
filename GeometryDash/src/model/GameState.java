/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
public class GameState {
    private int  distance = 0;
    private int  attempts = 1;
    private boolean dead  = false;
    private int levelGoal = 5000;
    public void tick()           { if (!dead) distance++; }
    public void die()            { dead = true; attempts++; }
    public void restart()        { dead = false; distance = 0; }
    public boolean isDead()      { return dead; }
    public int getDistance()     { return distance; }
    public int getAttempts()     { return attempts; }
    public int getScrollSpeed()  { return 5 + distance / 400; }
    public int getProgress()     {return (int)((distance * 100.0) / levelGoal);
}
}