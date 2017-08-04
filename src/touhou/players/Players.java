package touhou.players;

import tklibs.SpriteUtils;
import touhou.bases.Constraints;
import touhou.bases.Vector2D;
import touhou.inputs.InputManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Players {

    public Vector2D position;
    public BufferedImage image;
    public BufferedImage reimage;

    public InputManager inputManager;
    private static final int SPEED_PLAYER = 5;
    public Constraints constraints;
    public ArrayList<PlayerSpell> playerSpells;
    public int countSpells = 400;
    private int wait = 0;


    public Players() {
        // ham khoi tao / constructor
        position = new Vector2D(192,630);
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        reimage = SpriteUtils.loadImage("assets/images/player-spells/Reload.png");
    }

    public void run(){
        if (inputManager.rightPressed) {
            position.addUp(SPEED_PLAYER,0);
        }

        if (inputManager.leftPressed) {
            position.addUp(-SPEED_PLAYER,0);
        }

        if (inputManager.downPressed) {
            position.addUp(0,SPEED_PLAYER);
        }

        if (inputManager.upPressed) {
            position.addUp(0,-SPEED_PLAYER);
        }
        if (constraints != null) {
            constraints.make(position);
        }

        castSpells();
    }

    private void reload(){
        if (wait > 2000) {
            countSpells = 400;
            wait = 0;
        }
        else wait += 17;
    }

    private void castSpells() {
        if ((inputManager.xPressed)&&(countSpells>0)) {
            PlayerSpell newSpell = new PlayerSpell((int) position.x + 3, (int) position.y - 18);
            playerSpells.add(newSpell);
            countSpells--;
        }
        else {
            reload();
        }
    }


    public void render (Graphics2D g2d){
        g2d.drawImage(image, (int) position.x, (int) position.y,null);
        if (countSpells == 0) g2d.drawImage(reimage, 450,300,null);
    }

}
