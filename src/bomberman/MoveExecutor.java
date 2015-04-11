/*
 * This class will execute the move on the map and change the data and gui 
 * accordingly.
 * 
 * make constructor of this class or other methods if you feel need for it.
 * don't forget dividing your code into classes and methods is good standard
 * practice in professional world.
 */
package bomberman;


import bomberman.Types.*;


public class MoveExecutor{
    
    
    public static void executeMove( Player player, Move move){
        int x = player.getPosition().getxPos();
        int y = player.getPosition().getyPos();

        switch(player.direction){
            case UP:
                y-=player.speed;
                break;
            case DOWN:
                y+=player.speed;
                break;
            case LEFT:
                x-=player.speed;
                break;
            case RIGHT:
                x+=player.speed;
                break;
        }
        //        switch(move){
//            case UP:
//                player.setdirectionUp();
//                y-=player.speed;
//                break;
//            case DOWN:
//                player.setdirectionDown();
//                y+=player.speed;
//                break;
//            case LEFT:
//                player.setdirectionLeft();
//             //   x-=player.speed;
//                x+=player.dx;
//                break;
//            case RIGHT:
//                player.setdirectionRight();
//                x+=player.speed;
//                break;
//        }
        x+=player.dx;
        y+=player.dy;
        player.setPosition(new Position(x, y));
    }
    
    
}
