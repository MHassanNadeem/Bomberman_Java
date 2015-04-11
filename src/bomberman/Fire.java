/*
 * The fire caused by explosion of bomb it stays for some duration of time if 
 * player comes at the place where there is fire then the player will die.
 */
package bomberman;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Fire extends MapBasicBlock {

    static CopyOnWriteArrayList<Fire> fire = new CopyOnWriteArrayList<Fire>();
    static int delay = 300;
    Thread fireAnimation;
    int direction;

    public Fire(final Position _position, int dir) {
        super(Types.BlockType.FIRE, _position);
        direction = dir;

        switch (dir) {
            case 1:
                setImage(Images.fireCenter);
                break;
            case 2:
                setImage(Images.fireDown);
                break;
            case 3:
                setImage(Images.fireLeft);
                break;
            case 4:
                setImage(Images.fireRight);
                break;
            case 5:
                setImage(Images.fireUP);
                break;
        }
//        setImage(Images.fireCenter);
//        if(dir)
        fire.add(this);
        final Fire c = this;
        fireAnimation = new Thread(new Runnable() {
            public void run() {
                //  while (timer < explodeTimer) {
                try {
                    Thread.sleep(delay);
                    fire.remove(c);
                    breakBricks();
                    killEnemies();
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
                //    }
            }
        });
        fireAnimation.start();
    }

    public static void startFire(Position pos) {
        int x = round(pos.getxPos());
        int y = round(pos.getyPos());
        Fire f = new Fire(new Position(x, y), 1);
        //right = 4
        Position right = new Position(x + 50, y);
        if (BomberMan.map.brickAtPosition(right) == 0) {
            new Fire(right, 4);
        }
        //down = 2
        Position down = new Position(x, y + 50);
        if (BomberMan.map.brickAtPosition(down) == 0) {
            new Fire(down, 2);
        }
        Position left = new Position(x - 50, y);
        if (BomberMan.map.brickAtPosition(left) == 0) {
            new Fire(left, 3);
        }
        Position up = new Position(x, y - 50);
        if (BomberMan.map.brickAtPosition(up) == 0) {
            new Fire(up, 5);
        }
    }

    public void breakBricks() {
        if (direction != 1) {
            return;
        }
        int x = getX();
        int y = getY();
        Position down = new Position(x, y + 50);
        Position right = new Position(x + 50, y);
        Position left = new Position(x - 50, y);
        Position up = new Position(x, y - 50);
        BomberMan.map.breakBrickAtPosition(up);
        BomberMan.map.breakBrickAtPosition(down);
        BomberMan.map.breakBrickAtPosition(left);
        BomberMan.map.breakBrickAtPosition(right);
        System.out.println("Break Bricks Called");
//        
//        int x = this.getX();
//        int y = this.getY();
//        System.out.println("Break Bricks Called " + x + "  " + y);
//        for (int i = 0; i < 15; i++) {
//            for (int j = 0; j < 15; j++) {
//                if (BomberMan.intMap[i][j] == 2) {
//                    int diffX = x - j * 50;
//                    int diffY = y - i * 50;
//                    System.out.println("DX: " + diffX + " DY" + diffY);
//                    if (diffX > -200 && diffX < 200 && diffY > -200 && diffY < 200) {
//                        BomberMan.map.breakBrickAt(i, j);
//                    }
//                }
//            }
//        }
    }

    public void killEnemies() {
        if (direction != 1) {
            return;
        }
        ArrayList<Enemy> toBeDeleted = new ArrayList<>();
        int x = this.getX();
        int y = this.getY();

        for (Enemy enemy : BomberMan.enemies) {
            Rectangle enemyBounds = enemy.getBounds(enemy.direction);
            Rectangle t = new Rectangle(x + 50, y, 50, 50);
            if (t.intersects(enemyBounds)) {
                toBeDeleted.add(enemy);
            }
            t = new Rectangle(x - 50, y, 50, 50);
            if (t.intersects(enemyBounds)) {
                toBeDeleted.add(enemy);
            }
            t = new Rectangle(x, y + 50, 50, 50);
            if (t.intersects(enemyBounds)) {
                toBeDeleted.add(enemy);
            }
            t = new Rectangle(x, y - 50, 50, 50);
            if (t.intersects(enemyBounds)) {
                toBeDeleted.add(enemy);
            }
        }
        for (Player player : BomberMan.players) {
            Rectangle playerBounds = player.getBounds(player.direction);
            Rectangle t = new Rectangle(x + 50, y, 50, 50);
            if (t.intersects(playerBounds)) {
                player.die();
            }
            t = new Rectangle(x - 50, y, 50, 50);
            if (t.intersects(playerBounds)) {
                player.die();
            }
            t = new Rectangle(x, y + 50, 50, 50);
            if (t.intersects(playerBounds)) {
                player.die();
            }
            t = new Rectangle(x, y - 50, 50, 50);
            if (t.intersects(playerBounds)) {
                player.die();
            }
        }

        for (final Enemy i : toBeDeleted) {
//            Thread t = new Thread(new Runnable() {public void run() {i.die();}});
//            t.start();
            i.die();
        }
    }

    public static int round(int x) {
        for (int i = 0; i < 1000; i = i + 50) {
            if (x < i) {
                x = i - 50;
                break;
            }
        }
        return x;
    }
}
