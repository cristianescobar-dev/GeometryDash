/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyHandler extends KeyAdapter {
    private GameController ctrl;
    public KeyHandler(GameController ctrl) { this.ctrl = ctrl; }
    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        if (k == KeyEvent.VK_SPACE || k == KeyEvent.VK_UP) ctrl.jump();
        if (k == KeyEvent.VK_R) ctrl.restart();
    }
}
