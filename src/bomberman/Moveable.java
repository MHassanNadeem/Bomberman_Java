/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import bomberman.Types.*;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Hassan
 */
public class Moveable extends MapBasicBlock {

    //   Move face;
    public Moveable(Types.BlockType _blockType, Position _position) {
        super(_blockType, _position);
        //     face = null;
    }



    public void setX(int x) {
        this.getPosition().setXPos(x);
    }

    public void setY(int y) {
        this.getPosition().setYPos(y);
    }

    public Rectangle getBounds(Move move) {
        return null;
    }
}
