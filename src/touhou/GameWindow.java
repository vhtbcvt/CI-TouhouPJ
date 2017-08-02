package touhou;

import tklibs.SpriteUtils;
import touhou.bases.Constraints;
import touhou.players.PlayerSpell;
import touhou.players.Players;
import touhou.inputs.InputManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by huynq on 7/29/17.
 */
public class GameWindow extends Frame {

    private long lastTimeUpdate;
    private long currentTime;
    private Graphics2D windowGraphics;

    private BufferedImage backbufferImage;
    private Graphics2D backbufferGraphics;

    private BufferedImage background;
    private BufferedImage spells;

    private int backgroundY = 768-3109;

    Players player = new Players();
    ArrayList<PlayerSpell> playerSpells = new ArrayList<>();
    InputManager inputManager = new InputManager();

    public GameWindow() {
        background = SpriteUtils.loadImage("assets/images/background/0.png");
        spells = SpriteUtils.loadImage("assets/images/player-spells/a/0.png");
        player.inputManager = this.inputManager;
        player.constraints = new Constraints(0, 768, 0, 370);
        player.playerSpells = this.playerSpells();
        setupGameLoop();
        setupWindow();
    }


    private void setupGameLoop() {
        lastTimeUpdate = -1;
    }

    private void setupWindow() {
        this.setSize(384, 768);

        this.setTitle("Touhou - Remade by QHuyDTVT");
        this.setVisible(true);

        this.backbufferImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.backbufferGraphics = (Graphics2D) this.backbufferImage.getGraphics();

        this.windowGraphics = (Graphics2D) this.getGraphics();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                inputManager.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                inputManager.keyReleased(e);
            }
        });
    }

    public void loop() {
        while(true) {
            if (lastTimeUpdate == -1) {
                lastTimeUpdate = System.currentTimeMillis();
            }
            currentTime = System.currentTimeMillis();
            if (currentTime - lastTimeUpdate > 17) {
                run();
                render();
                lastTimeUpdate = currentTime;
            }
        }
    }

    private void run() {
        player.run();
    }

    private void render() {
        backbufferGraphics.setColor(Color.black);
        backbufferGraphics.fillRect(0, 0, 384, 768);
        backbufferGraphics.drawImage(background, 0, backgroundY, null);
        backgroundY += 1;
        player.render(backbufferGraphics);

        for (PlayerSpell playerSpell: playerSpells){
            //playerSpell.render(...);
        }

        windowGraphics.drawImage(backbufferImage, 0, 0, null);
    }
}
