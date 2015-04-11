/*
 * 
 * This class will holde all the information of the map and will have approperiate
 * methods to perform diffrent tasks on map.
 */
package bomberman;

import java.io.Serializable;
import javax.swing.JLabel;

public class Map implements Serializable{

    public int[][] intMap;
    private int rows, cols;
    public JLabel[][] map;
    private Position[][] position;
    int size;

    public Map(int[][] intMap, int _size) {
        this.intMap = intMap;
        size = _size;
        map = new JLabel[size][size];
        position = new Position[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                position[i][j] = new Position(j * 50, i * 50);
                switch (intMap[i][j]) {
                    case (0):
                        map[i][j] = new JLabel(Images.pathIcon);
                        break;
                    case (1):
                        map[i][j] = new JLabel(Images.unBreakableIcon);
                        break;
                    case (2):
                        map[i][j] = new JLabel(Images.breakableIcon);
                        break;
                }
            }
        }
    }

    public void breakBrickAt(final int i, final int j) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                int timer = 0;
                for (int c = 0; c < 8; c++) {
                    try {
                        map[i][j].setIcon(Images.breakableIconRed[c]);
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted");
                    }
                    timer++;
                }
                map[i][j].setIcon(Images.pathIcon);
                bonus(new Position(j*50,i*50));
            }
        });
        t.start();
        intMap[i][j] = 0;
        map[i][j].setIcon(Images.pathIcon);
//        bonus(new Position(j*50,i*50));
    }

    public JLabel getLabel(int i, int j) {
        return map[i][j];
    }
    //Returns coordinates of Bricks

    public int getX(int i, int j) {
        return (position[i][j].getxPos());
    }

    public int getY(int i, int j) {
        return (position[i][j].getyPos());
    }

    public int brickAtPosition(Position pos) {
        int x = pos.getxPos();
        int y = pos.getyPos();
        x= round(x);
        y=round(y);
        System.out.println("Rounderd off: " + x + " " + y);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (position[i][j].getxPos() == x && position[i][j].getyPos() == y) {
                    return intMap[i][j];
                }
            }
        }
        return 99;
    }
    public void breakBrickAtPosition(Position pos){
        int x = pos.getxPos();
        int y = pos.getyPos();
        x= round(x);
        y=round(y);
        System.out.println("Rounderd off: " + x + " " + y);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (position[i][j].getxPos() == x && position[i][j].getyPos() == y) {
                    if(intMap[i][j]==2){
                    breakBrickAt(i,j);
                    return;
                    }
                    else{
                        System.out.println("ERROR!. Brick not breackable");
                    }
                }
            }
        }
    }

    public int round(int x) {
        for (int i = 0; i < 1000; i = i + 50) {
            if (x < i) {
                x = i - 50;
                break;
            }
        }
        return x;
    }

    private void bonus(Position pos) {
        //Random Number Between 0 and 10
        int r = 0 + (int) (Math.random() * ((10 - 0) + 1));
        if(r>3){
            //Generate Number 1,2,3
            int p = 1 + (int) (Math.random() * ((3 - 1) + 1));
            switch(p){
                case 1:
                    new PowerUp(pos, Types.PowerUps.SPEED_UP);
                    break;
                case 2:
                   // new PowerUp(pos, Types.PowerUps.RANGE_UP);
                    break;
                case 3:
                    new PowerUp(pos, Types.PowerUps.BOMBS_UP);
                    break;
            }
        }
    }
}
