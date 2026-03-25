/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package geometrydash;
import javax.swing.*;
import view.GamePanel;
public class GeometryDash {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Geometry Dash - POO");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            GamePanel gp = new GamePanel();
            frame.add(gp);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
            gp.requestFocusInWindow();
        });
    }
}
