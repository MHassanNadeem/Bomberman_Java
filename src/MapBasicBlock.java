/*
 * This class is the basic bloack for all the elemnts of map we use this class in
 * order to keep all the different type of the objetc in the array of map in the Map class.
 * So every object that we have to put on the map must extend this class.
 
 */
package bomborman;
/*
 * importing the the enumeration "BlockType" from the class Types 
 * that is defined in the packege bomborman
 */
import bomborman.Types.BlockType;  
import java.awt.Image;




public class MapBasicBlock {
    
    private BlockType blockType;
    private Position position;
    private Image image;
    
    
    public MapBasicBlock( BlockType _blockType, Position _position, Image _image){
    
        blockType = _blockType;
        position = _position;
        image = _image;
    }
    
    
    
    /*
     * This function return the type of the Block on the map.
     */
    public BlockType getBlockType(){
        return blockType;
    }
    
    public Position getPosition(){
        return position;
    }
    
    public void setPosition(Position newPosition){
        
        position = newPosition;
    }
    
    public boolean isofType( BlockType _blockType ){
        
        if( blockType == _blockType ){
            return true;
        }else{
            return false;
        }
    }
}
