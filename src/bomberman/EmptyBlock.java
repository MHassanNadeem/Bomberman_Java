/*
 * This is for empty block of the map i-e the paths on the map will actually be
 * empty blocks.
 */
package bomberman;

import java.awt.Image;




public class EmptyBlock extends MapBasicBlock {
 
    public EmptyBlock(Types.BlockType _blockType, Position _position){
        
        super( _blockType,_position);
    }
}
