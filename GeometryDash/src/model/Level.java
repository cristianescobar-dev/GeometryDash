/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author moise
 */
import java.util.ArrayList;
import java.util.Random;

public class Level {
    private ArrayList<Obstacle> obstacles = new ArrayList<>();
    private Random rng      = new Random();
    private int    nextSpawn = 340; // posición X del próximo obstáculo

    public Level() {}

    /** Desplaza todos los obstáculos y genera nuevos según sea necesario. */
    public void scroll(int speed) {
        for (Obstacle o : obstacles) o.scroll(speed);
        obstacles.removeIf(Obstacle::outOfScreen);
        // Generar nuevo obstáculo cuando el frente queda despejado
        boolean needNew = obstacles.isEmpty() ||
            obstacles.get(obstacles.size()-1).getX() < nextSpawn;
        if (needNew) {
            int r = rng.nextInt(3);
                Obstacle.Type t;

                if (r == 0) t = Obstacle.Type.SPIKE;
                else if (r == 1) t = Obstacle.Type.BLOCK;
                else t = Obstacle.Type.PLATFORM; // gap aleatorio
                obstacles.add(new Obstacle(820, t));
            }
    }

    public void reset() {
        obstacles.clear();
        nextSpawn = 340;
    }

    public ArrayList<Obstacle> getObstacles() { return obstacles; }
}
