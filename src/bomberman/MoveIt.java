/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import bomberman.Types.*;

/**
 *
 * @author Hassan
 */
public class MoveIt {

    public static void Move(Player player) {
        int x = player.getX();
        int y = player.getY();
//
//        switch (move) {
//            case UP:
//                player.dy = -player.speed;
//                break;
//            case DOWN:
//                player.dy = player.speed;
//                break;
//            case LEFT:
//                player.dx = -player.speed;
//                break;
//            case RIGHT:
//                player.dx = player.speed;
//                break;
//        }
        if(!player.isAlive()){
            return;
        }
        
        if (MoveEvaluator.isValidMove(player, player.direction)) {
            MoveExecutor.executeMove(player, player.direction);
        }
    }
}
