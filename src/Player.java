/*
 * this the player class, it will maintain the data of player and have 
 * approperiate methods.
 * 
 */
package bomborman;

import java.awt.Image;
import bomborman.Types.*;


public class Player extends MapBasicBlock {
    
    private boolean alive;
    private int playerID;
    
    public Player(Types.BlockType _blockType, Position _position, Image _image){
        
        super( _blockType,_position, _image);
        alive = true;
    }
    
}
