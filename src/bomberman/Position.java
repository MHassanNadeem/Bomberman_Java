/*
 * This class assist in handling with the positions of diffrent objects. 
 */
package bomberman;

import java.io.Serializable;




public class Position  implements Serializable {
    
    private int yPos, xPos;
    
    public Position(int _xPos, int _yPos){
        yPos = _yPos;
        xPos = _xPos;
    }
    
    public boolean equals(Position position){
    
        if( position.getxPos() == xPos && position.getyPos() == yPos){
            return true;
        }else{
            return false;
        }
    }
    
    public int getxPos(){ return xPos;}
    
    public int getyPos(){ return yPos;}
    
    public void setPosition(Position position){
    
            yPos = position.getyPos();
            xPos = position.getxPos();
    }
    
    public void setPosition(int _xPos, int _yPos){
    
            yPos = _yPos;
            xPos = _xPos;
    }
    
    public void setXPos(int x){
        xPos = x;
    }
    public void setYPos(int y){
        yPos= y;
    }
    
//    public int getXPosition(){
//        return xPos;
//    }
//    public int getYPosition(){
//        return yPos;
//    }
//    
}
