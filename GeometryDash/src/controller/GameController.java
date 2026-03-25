/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import javax.swing.Timer;
import model.*;
import view.GamePanel;

public class GameController {
    private Player    player;
    private Level     level;
    private GameState state;
    private GamePanel panel;
    private Timer     timer;

    public GameController(GamePanel panel) {
        this.panel  = panel;
        this.state  = new GameState();
        this.player = new Player();
        this.level  = new Level();
        timer = new Timer(16, e -> tick());
        timer.start();
    }

    private void tick() {
        if (state.isDead()) return;
        state.tick();
        player.update();
        level.scroll(state.getScrollSpeed());

        for (Obstacle o : level.getObstacles()) {
        if (o.collidesWith(player)) {
            state.die();
            player.reset();
            level.reset();
            break;
           }
        }

        panel.repaint();
    }

    public void jump()    { player.jump(); }
    public void restart() { state.restart(); player.reset(); level.reset(); }
    public Player    getPlayer() { return player; }
    public Level     getLevel()  { return level; }
    public GameState getState() {return state; }

}
