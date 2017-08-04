package touhou.players;

import tklibs.SpriteUtils;
import touhou.bases.Vector2D;
import java.awt.*;
import java.awt.image.BufferedImage;



public class PlayerSpell {

    public Vector2D position1;
    public BufferedImage image1;

    public Vector2D position2;
    public BufferedImage image2;

    public Vector2D position3;
    public BufferedImage image3;
    private static final int SPEED_SPELLS = 25;


    public PlayerSpell(int x, int y){
        position1 = new Vector2D(x, y);
        position2 = new Vector2D(x - 5, y);
        position3 = new Vector2D(x + 5, y);
        image1 = SpriteUtils.loadImage("assets/images/player-spells/a/1.png");
        image2 = SpriteUtils.loadImage("assets/images/player-spells/a/0.png");
        image3 = SpriteUtils.loadImage("assets/images/player-spells/a/2.png");
    }

    public void render(Graphics2D g2d){
        g2d.drawImage(image1, (int) position1.x, (int) position1.y,null);
        position1.y -= SPEED_SPELLS;
        g2d.drawImage(image2, (int) position2.x , (int) position2.y, null);
        position2.x -= 8;
        position2.y -= SPEED_SPELLS;
        if (position3.x < 365) {
            g2d.drawImage(image3, (int) position3.x, (int) position3.y, null);
            position3.x += 8;
            position3.y -= SPEED_SPELLS;
        }
    }

}
