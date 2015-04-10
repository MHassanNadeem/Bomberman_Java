/*
 * This class contains the definition of diffrent types of objects that you will need in making this game
 * You can also difine some other types if you feel a need for it just create a public enumeration in
 * the calss "Types" and import "bomborman.Types.BlockType" where do you want to use these types.
 */
package bomborman;


public class Types {
   

    
    //Each basic block element of the ap will be one of the given type
    public enum BlockType{
        BREAKABLE, 
        UNBREKABLE,
        EMPTY,
        BOMB,
        FIRE,
        POWER_UP,
        PLAYER,
        ENEMY 
    };
    
    
    //these are the diffrent types of power ups
    public enum PowerUps{
        
        SPEED_UP,               //when player take this power its speed increases
        RANGE_UP,               //by taking this power the range of explosion fire is increased
        BOMBS_UP                //This power up increase the number of bombs that a player can place simultaneously
    };
    
    public enum Move{
        
        UP,
        LEFT,
        RIGHT,
        DOWN,
        PLACE_BOMB
    };
}
