/*
 * Power ups are kind of bonuses or upgrade that palyer gets randomly when a 
 * breakble block is exploded by the explosion of bomb. Threre are three 
 * different types of power one increase your speed, the second one increases the 
 * range of the explosion of the bomb installed by the player and the third one 
 * increases the numbers of bombs a player can place/installed simultaneously.
 * 
 * If you want you can make three diffrent classes for each of the powerup.
 */
package bomberman;

import java.awt.Image;
import bomberman.Types.*;
import java.awt.Rectangle;
import java.util.concurrent.CopyOnWriteArrayList;





public class PowerUp extends MapBasicBlock{
    static CopyOnWriteArrayList<PowerUp> allPowerUps = new CopyOnWriteArrayList<PowerUp>();
    static final int powerUpTime = 10000;//10 Seconds
   
    private PowerUps powerUp;
    
    public PowerUp(Position _position, PowerUps _powerUp){
        
        super( BlockType.BOMB,_position);
        powerUp = _powerUp;
        switch(_powerUp){
            case BOMBS_UP:
                this.setImage(Images.bonusBomb);
                break;
            case RANGE_UP:
                this.setImage(Images.bonusFire);
                break;
            case SPEED_UP:
                this.setImage(Images.bonusSpeed);
                break;
        }
        allPowerUps.add(this);
    }
    
    public Rectangle getBounds(){
        return new Rectangle(getX(),getY(),50,50);
    }
    public PowerUps getPowerType(){
        return powerUp;
    }
    
}
