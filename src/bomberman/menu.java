/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Hassan
 */
public class menu {

    JFrame frame;
    ImageIcon ii = new ImageIcon("images/bm.gif");
    Image bman = ii.getImage();

    public menu() {
        frame = new JFrame("Bomber Man");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JPanel glass = (JPanel) frame.getGlassPane();

        glass.setVisible(true);
        panel.add(new JLabel(new ImageIcon("images/menu.jpg")));

        JButton b1 = new JButton("Start Game");
        JButton b2 = new JButton("High Scores");
        JButton b3 = new JButton("Exit");

        glass.add(b1);
        glass.add(b2);
        glass.add(b3);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Starting Game");
                startGame();
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("High Scores");
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                System.out.println("Exit");
            }
        });


        frame.add(panel);

        frame.setVisible(true);
    }

    public void startGame() {
Object[] options = {"Single Player",
                    "Two Player"};
int n = JOptionPane.showOptionDialog(frame,
    "How many players?",
    "A Silly Question",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[1]);
//        frame.dispose();
        //MapGui gameInstance = new MapGui("Bomberman by Hassan");
    }
}
