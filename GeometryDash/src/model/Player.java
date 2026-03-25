/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
public class Player {
    public static final int FIXED_X  = 130;
    public static final int SIZE     = 38;
    public static final int GROUND_Y = 390;
    private static final double GRAVITY    = 0.75;
    private static final double JUMP_FORCE = -13.5;

    private double y        = GROUND_Y;
    private double velY     = 0;
    private boolean ground  = true;
    private int jumpCount = 0;
    private static final int MAX_JUMPS = 2;
    private int     rotation = 0;

    /** Aplica gravedad y actualiza posición cada tick. */
    public void update() {
        velY += GRAVITY;
        y    += velY;
        if (y >= GROUND_Y) {
        y = GROUND_Y;
        velY = 0;
        ground = true;
        jumpCount = 0;
        }
        
        if (!ground) {
            rotation = (rotation + 5) % 360;
        }
    }

    /** Hace saltar al cubo si está en el suelo. */
    public void jump() {
    if (jumpCount < MAX_JUMPS) {
        velY = JUMP_FORCE;
        ground = false;
        jumpCount++;
        }
    }

    /** Reinicia al jugador a su posición inicial. */
    public void reset() {
        y = GROUND_Y; velY = 0; ground = true; rotation = 0;
    }

    public int    getX()        { return FIXED_X; }
    public int    getY()        { return (int) y; }
    public int    getRotation() { return rotation; }
    public boolean isOnGround() { return ground; }
}