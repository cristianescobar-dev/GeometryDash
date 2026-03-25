/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.awt.*;
import javax.swing.*;
import controller.GameController;
import controller.KeyHandler;

public class GamePanel extends JPanel {
    private GameController ctrl;
    private LevelPanel     levelPanel;
    public GamePanel() {
        setLayout(new BorderLayout());
        ctrl = new GameController(this);
        levelPanel = new LevelPanel(ctrl);
        add(levelPanel, BorderLayout.CENTER);
        addKeyListener(new KeyHandler(ctrl));
        setFocusable(true);
    }
    @Override
    public void repaint() {
        super.repaint();
        if (levelPanel != null) levelPanel.repaint();
    }
}
