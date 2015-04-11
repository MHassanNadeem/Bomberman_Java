/*
 * this the player class, it will maintain the data of player and have 
 * approperiate methods.
 * 
 */
package bomberman;

import java.awt.Image;
import bomberman.Types.Move;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Player extends Moveable {

    Move direction = Move.STOP;
    int fireRange = 2;
    int speed = 2;
    int totalBombs = 1;
    ArrayList<Bomb> bombs = new ArrayList<Bomb>();
    int dx = 0;
    int dy = 0;
    Image[] UP_IMAGES = Images.UP_IMAGES;
    Image[] DOWN_IMAGES = Images.DOWN_IMAGES;
    Image[] LEFT_IMAGES = Images.LEFT_IMAGES;
    Image[] RIGHT_IMAGES = Images.RIGHT_IMAGES;
    Image[] DIE = Images.DIE;
    int state = 0;
    int state2 = 0;
    private boolean alive;
    private int playerID;

    public Player(Position _position) {

        super(Types.BlockType.PLAYER, _position);
        alive = true;
    }

    public void setdirectionRight() {
        direction = Move.RIGHT;
    }

    public void setdirectionLeft() {
        direction = Move.LEFT;
    }

    public void setdirectionUp() {
        this.setImage(UP_IMAGES[0]);
    }

    public void setdirectionDown() {
        this.setImage(DOWN_IMAGES[0]);
    }

    public void cycle() {
        if (!alive) {
            return;
        }
        switch (direction) {
            case RIGHT:
                cycleRight();
                break;
            case LEFT:
                cycleLeft();
                break;
            case UP:
                cycleUp();
                break;
            case DOWN:
                cycleDown();
                break;
            case STOP:
                //    setStopImage();
                break;
        }
    }

    private void cycleRight() {
        switch (state) {
            case 0:
                this.setImage(RIGHT_IMAGES[1]);
                state = 1;
                break;
            case 1:
                this.setImage(RIGHT_IMAGES[2]);
                state = 2;
                break;
            case 2:
                this.setImage(RIGHT_IMAGES[3]);
                state = 3;
                break;
            case 3:
                this.setImage(RIGHT_IMAGES[4]);
                state = 4;
                break;
            case 4:
                this.setImage(RIGHT_IMAGES[0]);
                state = 0;
                break;
        }
    }

    private void cycleLeft() {
        switch (state) {
            case 0:
                this.setImage(LEFT_IMAGES[1]);
                state = 1;
                break;
            case 1:
                this.setImage(LEFT_IMAGES[2]);
                state = 2;
                break;
            case 2:
                this.setImage(LEFT_IMAGES[3]);
                state = 3;
                break;
            case 3:
                this.setImage(LEFT_IMAGES[4]);
                state = 4;
                break;
            case 4:
                this.setImage(LEFT_IMAGES[0]);
                state = 0;
                break;
        }
    }

    private void cycleUp() {
        switch (state) {
            case 0:
                this.setImage(UP_IMAGES[1]);
                state = 1;
                break;
            case 1:
                this.setImage(UP_IMAGES[2]);
                state = 2;
                break;
            case 2:
                this.setImage(UP_IMAGES[3]);
                state = 3;
                break;
            case 3:
                this.setImage(UP_IMAGES[4]);
                state = 4;
                break;
            case 4:
                this.setImage(UP_IMAGES[0]);
                state = 0;
                break;
        }
    }

    private void cycleDown() {
        switch (state) {
            case 0:
                this.setImage(DOWN_IMAGES[1]);
                state = 1;
                break;
            case 1:
                this.setImage(DOWN_IMAGES[2]);
                state = 2;
                break;
            case 2:
                this.setImage(DOWN_IMAGES[3]);
                state = 3;
                break;
            case 3:
                this.setImage(DOWN_IMAGES[4]);
                state = 4;
                break;
            case 4:
                this.setImage(DOWN_IMAGES[0]);
                state = 0;
                break;
        }
    }

    public void Stop() {
        if (!alive) {
            return;
        }
        switch (direction) {
            case RIGHT:
                this.setImage(RIGHT_IMAGES[0]);
                break;
            case LEFT:
                this.setImage(LEFT_IMAGES[0]);
                break;
            case UP:
                this.setImage(UP_IMAGES[0]);
                break;
            case DOWN:
                this.setImage(DOWN_IMAGES[0]);
                break;
        }
        direction = Move.STOP;
    }

    public Rectangle getBounds(Move move) {
        Rectangle rect = new Rectangle(getX(), getY() + Images.playerHeight - 30, Images.playerWidth, 30);;
        switch (move) {
            case UP:
                rect = new Rectangle(getX(), getY() + Images.playerHeight - 30 - speed, Images.playerWidth, 30);
                break;
            case DOWN:
                rect = new Rectangle(getX(), getY() + Images.playerHeight - 30 + speed, Images.playerWidth, 30);
                break;
            case LEFT:
                rect = new Rectangle(getX() - speed, getY() + Images.playerHeight - 30, Images.playerWidth, 30);
                break;
            case RIGHT:
                rect = new Rectangle(getX() + speed, getY() + Images.playerHeight - 30, Images.playerWidth, 30);
                break;
        }
        return rect;
    }

    public void die() {
        if (alive) {
            alive = false;
            // BomberMan.players.remove(dx);
            Thread animateDeathofPlayer = new Thread(new Runnable() {
                public void run() {
                    for (int c = 0; c < 6; c++) {
                        try {
                            setImage(Images.DIE[c]);
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            System.out.println("interrupted");
                        }
                    }
                }
            });
            animateDeathofPlayer.start();
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void cDeath() {
        switch (state2) {
            case 0:
                this.setImage(DIE[1]);
                state2 = 1;
                break;
            case 1:
                this.setImage(DIE[2]);
                state2 = 2;
                break;
            case 2:
                this.setImage(DIE[3]);
                state2 = 3;
                break;
            case 3:
                this.setImage(DIE[4]);
                state2 = 4;
                break;
            case 4:
                this.setImage(DIE[5]);
                //   state = 0;
                break;
        }
    }

    public void plantBomb() {
        int x = getX() + 15;
        int y = getY();
        for (int i = 0; i < 1000; i = i + 50) {
            if (x < i) {
                x = i - 50;
                break;
            }
        }
        for (int i = 0; i < 1000; i = i + 50) {
            if (y < i) {
                y = i;
                break;
            }
        }

        if (totalBombs > bombs.size()) {
            Position pos = new Position(x, y);
            Bomb bomb = new Bomb(pos);
            bombs.add(bomb);
            Bomb.allBombs.add(bomb);
        }
    }

    public void pickPowerUp(final PowerUp power) {
        switch (power.getPowerType()) {
            case BOMBS_UP:
                totalBombs++;
                break;
            case RANGE_UP:
                break;
            case SPEED_UP:
                speed++;
                break;
        }
        PowerUp.allPowerUps.remove(power);
        Thread powerTimer = new Thread(new Runnable() {
            public void run() {
                    try {
                        Thread.sleep(power.powerUpTime);
                        stopPowerUp(power);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted");
                    }
                }
        });
        powerTimer.start();
        
    }
    
    public void stopPowerUp(PowerUp power){
        switch (power.getPowerType()) {
            case BOMBS_UP:
                totalBombs--;
                break;
            case RANGE_UP:
                break;
            case SPEED_UP:
                speed--;
                break;
        }
    }
}
