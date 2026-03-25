/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.awt.*;
import javax.swing.JPanel;
import controller.GameController;
import model.*;

public class LevelPanel extends JPanel {
    private GameController ctrl;
    public LevelPanel(GameController ctrl) {
        this.ctrl = ctrl;
        setPreferredSize(new Dimension(800, 480));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // Fondo degradado
        GradientPaint gp = new GradientPaint(0,0,new Color(10,10,60),0,getHeight(),new Color(30,30,100));
        g2.setPaint(gp); g2.fillRect(0,0,getWidth(),getHeight());
        // Suelo
        int groundY = Player.GROUND_Y + Player.SIZE;
        g.setColor(new Color(50, 160, 50));
        g.fillRect(0, groundY, getWidth(), getHeight() - groundY);
        g.setColor(new Color(30,100,30));
        g.fillRect(0, groundY, getWidth(), 4);
        // Obstáculos
        for (Obstacle o : ctrl.getLevel().getObstacles()) {
            if (o.getType() == Obstacle.Type.SPIKE) {

            g.setColor(new Color(220, 50, 50));
            int[] xs = { o.getX(), o.getX()+Obstacle.SIZE/2, o.getX()+Obstacle.SIZE };
            int[] ys = { o.getY()+Obstacle.SIZE, o.getY(), o.getY()+Obstacle.SIZE };
            g.fillPolygon(xs, ys, 3);

        } 
        else if (o.getType() == Obstacle.Type.PLATFORM) {

            g.setColor(new Color(120,120,120));
            g.fillRect(o.getX(), o.getY(), Obstacle.SIZE * 2, 20);

        } 
        else {

            g.setColor(new Color(180, 100, 40));
            g.fillRect(o.getX(), o.getY(), Obstacle.SIZE, Obstacle.SIZE);
            g.setColor(new Color(140,70,20));
            g.drawRect(o.getX(), o.getY(), Obstacle.SIZE, Obstacle.SIZE);

        }
            
            
        }
        // Cubo del jugador con rotación
        Player p = ctrl.getPlayer();
        g2.setColor(new Color(255, 140, 0));
        g2.translate(p.getX() + Player.SIZE/2, p.getY() + Player.SIZE/2);
        g2.rotate(Math.toRadians(p.getRotation()));
        g2.fillRect(-Player.SIZE/2, -Player.SIZE/2, Player.SIZE, Player.SIZE);
        g2.setColor(Color.WHITE);
        g2.drawRect(-Player.SIZE/2, -Player.SIZE/2, Player.SIZE, Player.SIZE);
        g2.rotate(-Math.toRadians(p.getRotation()));
        g2.translate(-(p.getX() + Player.SIZE/2), -(p.getY() + Player.SIZE/2));
        // HUD
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Intentos: " + ctrl.getState().getAttempts(), 14, 24);
        g.drawString("R = Reiniciar", 14, 44);
        g.drawString("Progreso: " + ctrl.getState().getProgress() + "%", 14, 64);
        if (ctrl.getState().isDead()) {
            g.setColor(new Color(0,0,0,140));
            g.fillRect(0,0,getWidth(),getHeight());
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.BOLD,30));
            g.drawString("Presiona R para reintentar", 180, 240);
        }
    }
}