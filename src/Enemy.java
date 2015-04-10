/*
 * their are alos enemies to the player that will keep on moving randomly for 
 * ( You are welcome to make them intelligent and give yourself a tough time ;) )
 * if the player touches them then player will die. When the die by the fire/explosion
 * they will also give a powerup but on random basis.
 */
package bomborman;

import java.awt.Image;
import bomborman.Types.Move;




public class Enemy extends MapBasicBlock{
    
    public Enemy(Types.BlockType _blockType, Position _position, Image _image){
        
        super( _blockType,_position, _image);
    }
    
}
