/*
 * Power ups are kind of bonuses or upgrade that palyer gets randomly when a 
 * breakble block is exploded by the explosion of bomb. Threre are three 
 * different types of power one increase your speed, the second one increases the 
 * range of the explosion of the bomb installed by the player and the third one 
 * increases the numbers of bombs a player can place/installed simultaneously.
 * 
 * If you want you can make three diffrent classes for each of the powerup.
 */
package bomborman;

import java.awt.Image;
import bomborman.Types.*;





public class PowerUp extends MapBasicBlock{
    
    private PowerUps powerUp;
    
    public PowerUp( BlockType _blockType, Position _position, Image _image, PowerUps _powerUp){
        
        super( _blockType,_position, _image);
        
        powerUp = _powerUp;
    }
    
}
