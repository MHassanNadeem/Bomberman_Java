/**
 * This class will focus on the implementation of the whether the move picked by
 * a player is valid ( It must not contain any gui related component and nothing
 * of gui can be changed from here). you can define other methods to assist your
 * self and manage your code.
 *
 * You can make constructor of this class if you feel need for it.
 *
 */
package bomberman;

import bomberman.Types.*;
import java.awt.Rectangle;

public class MoveEvaluator {

    static int border;
    static int topBorder;
    static Moveable player;

    public static boolean isValidMove(Moveable _player, Move move) {
        player = _player;
        border = 5;
        topBorder = 20;
        int height = MapGui.panel.getHeight();
        int width = MapGui.panel.getWidth();

        int[][] map = BomberMan.intMap;

        int x = player.getX();
        int y = player.getY();
        int footX = x + Images.playerWidth;
        int footY = y + Images.playerHeight;

        if (move == Move.STOP) {
            return false;
        }



        if (player instanceof Enemy) {
            if (BomberMan.players.get(0).getBounds(Move.STOP).intersects(player.getBounds(move))) {
                System.out.println("DEAD");
                BomberMan.players.get(0).die();
            }
            for (Player i : BomberMan.players) {
                for (Bomb b : i.bombs) {
                    if (b.getBounds().intersects(player.getBounds(move))) {
                        return false;
                    }
                }
            }
        }

        if (player instanceof Player) {
            for (PowerUp power : PowerUp.allPowerUps) {
                if (player.getBounds(move).intersects(power.getBounds())) {
                    ((Player) player).pickPowerUp(power);
                }
            }



            for (Player i : BomberMan.players) {
                for (Bomb b : i.bombs) {
                    if (!b.justPlanted) {
                        if (b.getBounds().intersects(player.getBounds(move))) {
                            return false;
                        }
                    } else {
                        if (!b.getBounds().intersects(player.getBounds(move))) {
                            b.justPlanted = false;
                        }
                    }
                }
            }


        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 1 || map[i][j] == 2) {
                    switch (move) {
                        case UP:
                            if (player.getBounds(move).intersects(new Rectangle(j * 50, i * 50, 50, 50))) {
                                return false;
                            }
                            break;
                        case DOWN:
                            if (player.getBounds(move).intersects(new Rectangle(j * 50, i * 50, 50, 50))) {
                                return false;
                            }
                            break;
                        case RIGHT:
                            if (player.getBounds(move).intersects(new Rectangle(j * 50, i * 50, 50, 50))) {
                                return false;
                            }
                            break;
                        case LEFT:
                            if (player.getBounds(move).intersects(new Rectangle(j * 50, i * 50, 50, 50))) {
                                return false;
                            }
                            break;
                    }

                }
            }
        }
        return true;
    }

    static int getX(int i) {
        return (50 * i);
    }

    static int getY(int i) {
        return (50 * i);
    }

    static int getLeft(int j) {
        return (50 * j);
    }

    static int getRight(int j) {
        return ((50 * (j + 1)));
    }

    static int getTop(int i) {
        return (50 * (i));
    }

    static int getBottom(int i) {
        return (((i + 1) * 50));
    }

    static void correctY(int y) {
        player.setY((getBottom(y) + getBottom(y - 1) - Images.playerHeight) / 2);
    }

    static void correctX(int x) {
        player.setX((getLeft(x) + getLeft(x - 1) - Images.playerWidth) / 2);
    }

    static void correctX2(int x) {
        player.setX((getLeft(x) + getLeft(x + 1) - Images.playerWidth) / 2);
    }

    static public Rectangle getBounds(int i, int j) {
        return new Rectangle(getX(i), getY(j), 50, 50);
    }
}
