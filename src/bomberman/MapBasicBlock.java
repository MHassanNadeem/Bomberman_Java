/*
 * This class is the basic bloack for all the elemnts of map we use this class in
 * order to keep all the different type of the objetc in the array of map in the Map class.
 * So every object that we have to put on the map must extend this class.
 
 */
package bomberman;
/*
 * importing the the enumeration "BlockType" from the class Types 
 * that is defined in the packege bomberman
 */

import bomberman.Types.*;
import java.awt.Image;
import javax.swing.ImageIcon;

public class MapBasicBlock {

    private BlockType blockType;
    private Position position;
    private Image image;

    public MapBasicBlock(BlockType _blockType, Position _position) {

        blockType = _blockType;
        position = _position;
        switch (_blockType) {
            case BREAKABLE:
                break;
            case UNBREKABLE:
                break;
            case EMPTY:
                break;
            case BOMB:
                image = Images.BOMB_BIG;
                break;
            case FIRE:
                image = Images.fireCenter;
                break;
            case PLAYER:
                image = new ImageIcon("images/bm.gif").getImage();
                break;
        }
    }

    /*
     * This function return the type of the Block on the map.
     */
    public BlockType getBlockType() {
        return blockType;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position newPosition) {
        position = newPosition;
    }

    //MY
    public Image getImage() {
        return image;
    }
    
    public int getX(){
        return this.getPosition().getxPos();
    }
    public int getY(){
        return this.getPosition().getyPos();
    }
    
    public void setImage(Image im){
        image = im;
    }
    
    
    
    
    
    
    ///bomb
        public void setX(int x){
        this.getPosition().setXPos(x);
    }
    public void setY(int y){
        this.getPosition().setYPos(y);
    }
}
