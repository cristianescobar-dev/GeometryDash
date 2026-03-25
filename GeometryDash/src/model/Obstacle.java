/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author moise
 */
public class Obstacle {
    public enum Type { SPIKE, BLOCK, PLATFORM }
    public static final int SIZE = 38;
    private int  x, y;
    private Type type;

    public Obstacle(int x, Type type) {
    this.x = x;
    this.type = type;

    if(type == Type.PLATFORM){
        int minHeight = 5;   // altura mínima
        int maxHeight = 40;  // altura máxima
        int randomHeight = minHeight + (int)(Math.random() * (maxHeight - minHeight));

        this.y = Player.GROUND_Y - randomHeight;
    }else{
        this.y = Player.GROUND_Y + Player.SIZE - SIZE;
    }
}
    public void scroll(int speed) { x -= speed; }
    public boolean outOfScreen()  { return x + SIZE < 0; }

    public boolean collidesWith(Player p) {
        int margin = 6; // margen de tolerancia para hacerlo justo
        return x + margin < p.getX() + Player.SIZE - margin &&
               x + SIZE  - margin > p.getX() + margin &&
               y + margin < p.getY() + Player.SIZE - margin &&
               y + SIZE   - margin > p.getY() + margin;
    }
    public int  getX()   { return x; }
    public int  getY()   { return y; }
    public Type getType(){ return type; }
}
