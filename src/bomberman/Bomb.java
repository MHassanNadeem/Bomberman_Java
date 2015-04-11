/*
 * This class will contain the implementation of bomb, you have to keep in mind
 * the following points.
 * 1- there is a time duration between the bomb is placed and it explodes
 * 2- if an other bomb is in the range of the bomb that has just exploded
 *    then the other one will also explode.
 * 3- the range of bomb can change depending upon the powerup of the player.
 * 4- You have to extend this assignment for multiplayer afterwards so you do 
 *    have a system to identify that who installed this bomb but for this part 
 *    you may leave this implemntation 
 */
package bomberman;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.sound.sampled.*;

public class Bomb extends MapBasicBlock implements Runnable {

    boolean justPlanted = true;
    static CopyOnWriteArrayList<Bomb> allBombs = new CopyOnWriteArrayList<Bomb>();
    static int size = Images.BOMBSIZE;
    static int pulsateDelay = 200;
    static int explodeTimer = 10;
//    static int explodeDelay = 500;
    Thread pulsate;
    Thread explode;

    public Bomb(Position _position) {

        super(Types.BlockType.BOMB, _position);
        pulsate = new Thread(new Runnable() {
            public void run() {
                int timer = 0;
                while (timer < explodeTimer) {
                    try {
                        Thread.sleep(pulsateDelay);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted");
                    }
                    timer++;
                    pulsate();
                }
//                Sounds.getInstance().Explosion();
                explode();
            }
        });
        pulsate.start();
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), size, size);
    }

    @Override
    public void run() {
        System.out.println("BOMB THREAD STARTED");
    }

    public void explode() {

        BomberMan.players.get(0).bombs.remove(0);
        startFire();
    }

    public void pulsate() {
        if (getImage().equals(Images.BOMB_BIG)) {
            setX(getX() + 5);
            setY(getY() + 5);
            setImage(Images.BOMB_SMALL);
        } else {
            setX(getX() - 5);
            setY(getY() - 5);
            setImage(Images.BOMB_BIG);
        }
    }

    public void startFire() {
        // new Fire(getPosition());
        Fire.startFire(getPosition());
    }
}
