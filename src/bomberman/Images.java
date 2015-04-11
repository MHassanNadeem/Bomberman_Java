/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Hassan
 */
public class Images {
//Constants

    static int brickSize = 50;
    static int playerHeight = 64;
    static int playerWidth = 32;
    static int BOMBSIZE = 40;
    //Player
    static Image[] UP_IMAGES = {new ImageIcon("images/BomberMan/01.gif").getImage(),
        new ImageIcon("images/BomberMan/02.gif").getImage(),
        new ImageIcon("images/BomberMan/03.gif").getImage(),
        new ImageIcon("images/BomberMan/04.gif").getImage(),
        new ImageIcon("images/BomberMan/05.gif").getImage()};
    static Image[] DOWN_IMAGES = {new ImageIcon("images/BomberMan/11.gif").getImage(),
        new ImageIcon("images/BomberMan/12.gif").getImage(),
        new ImageIcon("images/BomberMan/13.gif").getImage(),
        new ImageIcon("images/BomberMan/14.gif").getImage(),
        new ImageIcon("images/BomberMan/15.gif").getImage()};
    static Image[] LEFT_IMAGES = {new ImageIcon("images/BomberMan/21.gif").getImage(),
        new ImageIcon("images/BomberMan/22.gif").getImage(),
        new ImageIcon("images/BomberMan/23.gif").getImage(),
        new ImageIcon("images/BomberMan/24.gif").getImage(),
        new ImageIcon("images/BomberMan/25.gif").getImage()};
    static Image[] RIGHT_IMAGES = {new ImageIcon("images/BomberMan/31.gif").getImage(),
        new ImageIcon("images/BomberMan/32.gif").getImage(),
        new ImageIcon("images/BomberMan/33.gif").getImage(),
        new ImageIcon("images/BomberMan/34.gif").getImage(),
        new ImageIcon("images/BomberMan/35.gif").getImage()};
    static Image[] DIE = {new ImageIcon("images/BomberMan/41.gif").getImage(),
        new ImageIcon("images/BomberMan/42.gif").getImage(),
        new ImageIcon("images/BomberMan/43.gif").getImage(),
        new ImageIcon("images/BomberMan/44.gif").getImage(),
        new ImageIcon("images/BomberMan/45.gif").getImage(),
        new ImageIcon("images/BomberMan/46.gif").getImage()};
    //Bricks
    static ImageIcon unBreakableIcon =
            getScaledImageIcon(new ImageIcon("images/Bricks/unBreakable.gif"), brickSize, brickSize);
    static ImageIcon breakableIcon =
            getScaledImageIcon(new ImageIcon("images/Bricks/breakable.jpg"), brickSize, brickSize);
    static ImageIcon[] breakableIconRed = {
        getScaledImageIcon(new ImageIcon("images/Bricks/break/11.gif"), brickSize, brickSize),
        getScaledImageIcon(new ImageIcon("images/Bricks/break/12.gif"), brickSize, brickSize),
        getScaledImageIcon(new ImageIcon("images/Bricks/break/13.gif"), brickSize, brickSize),
        getScaledImageIcon(new ImageIcon("images/Bricks/break/14.gif"), brickSize, brickSize),
        getScaledImageIcon(new ImageIcon("images/Bricks/break/15.gif"), brickSize, brickSize),
        getScaledImageIcon(new ImageIcon("images/Bricks/break/16.gif"), brickSize, brickSize),
        getScaledImageIcon(new ImageIcon("images/Bricks/break/17.gif"), brickSize, brickSize),
        getScaledImageIcon(new ImageIcon("images/Bricks/break/18.gif"), brickSize, brickSize)
    };
    static ImageIcon pathIcon =
            getScaledImageIcon(new ImageIcon("images/Bricks/path.gif"), brickSize, brickSize);
    static Image ENEMY = new ImageIcon("images/Enemy/0.png").getImage();
    static Image[] ENEMY_DEATH = {
        new ImageIcon("images/Enemy/1.png").getImage(),
        new ImageIcon("images/Enemy/2.png").getImage(),
        new ImageIcon("images/Enemy/3.png").getImage(),
        new ImageIcon("images/Enemy/4.png").getImage(),
        new ImageIcon("images/Enemy/5.png").getImage()
    };
    static Image BOMB_BIG = new ImageIcon("images/Bombs/1.png").getImage();
    static Image BOMB_SMALL = new ImageIcon("images/Bombs/2.png").getImage();
    
    
    static Image fireCenter = new ImageIcon("images/Fire/C5.gif").getImage();
    static Image fireUP = new ImageIcon("images/Fire/N5.gif").getImage();
    static Image fireDown = new ImageIcon("images/Fire/S5.gif").getImage();
    static Image fireRight = new ImageIcon("images/Fire/E5.gif").getImage();
    static Image fireLeft = new ImageIcon("images/Fire/W5.gif").getImage();

    //BONUS/////////////////////////////////////////////
    static Image bonusSpeed = getScaledImage(new ImageIcon("images/Bonus/speed.png").getImage(),50,50);
    static Image bonusBomb = getScaledImage(new ImageIcon("images/Bonus/bomb.png").getImage(),50,50);
    static Image bonusFire = getScaledImage(new ImageIcon("images/Bonus/fire.png").getImage(),50,50);
    /////////////////////////////////////////////
    private static ImageIcon getScaledImageIcon(ImageIcon srcIcon, int w, int h) {
        Image srcImg = srcIcon.getImage();

        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return new ImageIcon(resizedImg);
    }

    private static Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
}

/*
    static Image[] UP_IMAGES = {getScaledImage(new ImageIcon("images/BomberMan/01.gif").getImage(),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/02.gif").getImage(),characterSize,characterSize),characterSize,characterSize),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/03.gif").getImage(),characterSize,characterSize),characterSize,characterSize),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/04.gif").getImage(),characterSize,characterSize),characterSize,characterSize),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/05.gif").getImage(),characterSize,characterSize)};
    static Image[] DOWN_IMAGES = {getScaledImage(new ImageIcon("images/BomberMan/11.gif").getImage(),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/12.gif").getImage(),characterSize,characterSize),characterSize,characterSize),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/13.gif").getImage(),characterSize,characterSize),characterSize,characterSize),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/14.gif").getImage(),characterSize,characterSize),characterSize,characterSize),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/15.gif").getImage(),characterSize,characterSize)};
    static Image[] LEFT_IMAGES = {getScaledImage(new ImageIcon("images/BomberMan/21.gif").getImage(),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/22.gif").getImage(),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/23.gif").getImage(),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/24.gif").getImage(),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/25.gif").getImage(),characterSize,characterSize)};
    static Image[] RIGHT_IMAGES = {getScaledImage(new ImageIcon("images/BomberMan/31.gif").getImage(),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/32.gif").getImage(),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/33.gif").getImage(),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/34.gif").getImage(),characterSize,characterSize),
        getScaledImage(new ImageIcon("images/BomberMan/35.gif").getImage(),characterSize,characterSize)};
*/