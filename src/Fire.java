/*
 * The fire caused by explosion of bomb it stays for some duration of time if 
 * player comes at the place where there is fire then the player will die.
 */
package bomborman;

import java.awt.Image;




public class Fire extends MapBasicBlock{
    
    public Fire(Types.BlockType _blockType, Position _position, Image _image){
        
        super( _blockType,_position, _image);
    }
}
