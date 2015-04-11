/*
 * their are alos enemies to the player that will keep on moving randomly for 
 * ( You are welcome to make them intelligent and give yourself a tough time ;) )
 * if the player touches them then player will die. When the die by the fire/explosion
 * they will also give a powerup but on random basis.
 */
package bomberman;

import java.awt.Image;
import bomberman.Types.Move;
import java.awt.Rectangle;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Enemy extends Moveable{

    boolean alive;
    int speed = 1;
    Move direction = randomDirection();
    Image img = Images.ENEMY;

    public Enemy(Position _position) {
        super(Types.BlockType.PLAYER, _position);
        alive = true;
    }

    public Image getImage() {
        return img;
    }
    
        public void setImage(Image im) {
        img = im;
    }

    public void move() {
        if(direction == Move.STOP) return;
        int r = 0 + (int) (Math.random() * ((25 - 0) + 1));
        //  if(r>24)
        //    direction  = randomDirection();

        if (MoveEvaluator.isValidMove(this, direction)) {
            switch (direction) {
                case UP:
                    this.setY(getY() - speed);
                    break;
                case DOWN:
                    this.setY(getY() + speed);
                    break;
                case LEFT:
                    this.setX(getX() - speed);
                    break;
                case RIGHT:
                    this.setX(getX() + speed);
                    break;
            }
        } else {
            direction = randomDirection();
        }
    }

    private Move randomDirection() {
        int r = 0 + (int) (Math.random() * ((3 - 0) + 1));
        if (r == 0) {
            return Move.UP;
        } else if (r == 1) {
            return Move.DOWN;
        } else if (r == 2) {
            return Move.LEFT;
        } else {
            return Move.RIGHT;
        }
    }

    public Rectangle getBounds(Move move) {
        Rectangle rect = null;
        switch (move) {
            case UP:
                rect = new Rectangle(getX(), getY() - speed, 37, 40);
                break;
            case DOWN:
                rect = new Rectangle(getX(), getY() + speed, 37, 40);
                break;
            case LEFT:
                rect = new Rectangle(getX() - speed, getY(), 37, 40);
                break;
            case RIGHT:
                rect = new Rectangle(getX() + speed, getY(), 37, 40);
                break;
            case STOP:
                rect = new Rectangle(getX(), getY(), 37, 40);
                break;
        }
        return rect;
    }

    public void die() {
        direction= Move.STOP;
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int c = 0; c < 5; c++) {
                    try {
                        setImage(Images.ENEMY_DEATH[c]);
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted");
                    }
                }
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {
            System.out.println("Enemy -> Die -> Join");
        }
        BomberMan.enemies.remove(this);
    }
}
