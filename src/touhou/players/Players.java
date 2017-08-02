package touhou.players;

import tklibs.SpriteUtils;
import touhou.bases.Constraints;
import touhou.bases.Vector2D;
import touhou.inputs.InputManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Players {

    public int x;
    public int y;
    public Vector2D position;
    public BufferedImage image;
    public InputManager inputManager;
    private static final int SPEED_PLAYER = 5;
    public Constraints constraints;
    public ArrayList<PlayerSpell> playerSpells;

    public Players() {
        // ham khoi tao / constructor
        position = new Vector2D(192,600);
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
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

    private void castSpells() {
        if (inputManager.xPressed) {
            PlayerSpell newSpell = new PlayerSpell();
            playerSpells.add(newSpell);
        }
    }

    public void render (Graphics2D g2d){
        g2d.drawImage(image, (int) position.x, (int) position.y,null);
    }

}
