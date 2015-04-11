/*
 * This is for unbreakable block of the map. This kind of block cannot be broken 
 * by any kind of explosion. 
 */
package bomberman;

import java.awt.Image;




public class UnbreakableBlock extends MapBasicBlock {
    
    public UnbreakableBlock(Types.BlockType _blockType, Position _position){
        
        super( _blockType,_position);
    }
}
