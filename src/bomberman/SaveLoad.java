/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Hassan
 */
public class SaveLoad extends JPanel {

    public SaveLoad() {
        JButton pause = new JButton("Pause");
        JButton resume = new JButton("resume");
        JButton save = new JButton("Save Game");
        JButton load = new JButton("Load Game");

        load.setFocusable(false);
        save.setFocusable(false);
        pause.setFocusable(false);
        resume.setFocusable(false);

        pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game Paused");
                BomberMan.frame.stopTimers();
            }
        });

        resume.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game Resumed");
                BomberMan.frame.startTimers();
            }
        });
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BomberMan.saveGame();
                System.out.println("Game Saved");
            }
        });
        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BomberMan.loadGame();
                System.out.println("Game Loaded");
            }
        });


        this.add(save);
        this.add(load);
        this.add(pause);
        this.add(resume);
    }
}
