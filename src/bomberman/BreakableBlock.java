/*
 * This is for breakable block of the map. This lock can be exploded by the 
 * explosion of bomb and it may contain the powerup that can be used once 
 * it's exploded. 
 */
package bomberman;

import java.awt.Image;



public class BreakableBlock extends MapBasicBlock {
    
    public BreakableBlock(Types.BlockType _blockType, Position _position){
        
        super( _blockType,_position);
    }
    
}
