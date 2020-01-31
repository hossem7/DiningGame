/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Font;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

//This is the start screen, where the user hits enter to move on to the next screen
public class Start extends BasicGameState{
    private Music music;
    private Sound sound;
    
    Image img;
    TrueTypeFont font;//we are using a different font rather than the default font in slick
    public Start(int i) throws SlickException {
        this.img = new Image("images\\Start.png");//initializing the background
        
    }
    @Override
    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.init(gc, sbg);//calling the init method
        //Music for our games initialized below
        music = new Music("music\\Start.wav");
        music.loop();
        sound = new Sound("music\\DoorChime.wav");
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       Font awt = new Font("Times New Roman", Font.BOLD, 48);//Times new Roman font
       font = new TrueTypeFont(awt, false);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        //Drawing the Scteen with images and text
        img.draw(0,0,1280,720);
        font.drawString(410, 300, "Press Enter to Start!!!", Color.black);
       // g.drawString("Mouse X - " + Mouse.getX() + "\nMouse Y - " + Mouse.getY(), 500, 0);
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
            sbg.enterState(1, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
            music.fade(2500, 0, true);
            sound.play();
        }
    }
    
}
