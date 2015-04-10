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
package bomborman;

import java.awt.Image;





public class Bomb extends MapBasicBlock {
    
    public Bomb(Types.BlockType _blockType, Position _position, Image _image){
        
        super( _blockType,_position, _image);
    }
    
}
