/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;
import java.awt.Font;
import java.io.InputStream;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.util.ResourceLoader;

//This is the Menu screen where the user has either the option of playing the game, chacking the HighScores, checking the How to Play screen, or just ending the program
public class Menu extends BasicGameState{
    private Music music;
    private Sound sound;
    Image img;
    Image img2;
    Image img3;
    int x=1;
    TrueTypeFont font;
    public Menu(int i) throws SlickException {
        //Images for our menu initialized
        this.img = new Image("images\\menu.png");
        this.img2 = new Image("images\\border.png");
        this.img3 = new Image("images\\dart.png");
    }

    @Override
    public int getID() {
        return 1;
    }
    @Override
    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        this.init(gc, sbg);
        //Music for menu screen
        music = new Music("music\\Menu.wav");
        sound = new Sound("music\\Click.wav");
        music.loop(1.0f,0.5f);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        //loading an .oft file for a different font for the menu
        try {
		InputStream inputStream	= ResourceLoader.getResourceAsStream("myFont.otf");
		Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
		awtFont2 = awtFont2.deriveFont(36f); // set font size
		font= new TrueTypeFont(awtFont2, false);
 
	} catch (Exception e) {
		e.printStackTrace();
	}	
    }
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        //Drawing All the texts, buttons(basically rectangles), effects,  and background
        img.draw(0,0,1280,720);
        img2.draw(488,235,300,250);
        font.drawString(590, 260, "Play Now",Color.black);
        font.drawString(587, 310, "HighScores",Color.black);
        font.drawString(578, 360, "How to Play",Color.black);
        font.drawString(615, 407, "Quit",Color.black);
        g.setColor(Color.black);
        
        //g.drawString("Mouse X - " + Mouse.getX() + "\nMouse Y - " + Mouse.getY(), 500, 0);
        
        //if and else if statements below are highlighting key areas in the menu screen (Basically showing a rectangle, changing colour of the text, and pointing an arrow)
        //We also added sound effects with it
        if(Mouse.getX()>=583 && Mouse.getX()<=685 && Mouse.getY()>=420 && Mouse.getY()<=460){ //700/420
            if(x==1)sound.play();
            font.drawString(590, 260, "Play Now", Color.red);
            img3.draw(690, 273,60,20);
            img3.getFlippedCopy(true, false).draw(528,273,60,20);
            x=0;
        }
        else if(Mouse.getX()>=580 && Mouse.getX()<=690 && Mouse.getY()>=370 && Mouse.getY()<=410){
            if(x==1)sound.play();
            font.drawString(587, 310,"HighScores", Color.red);
            img3.draw(690, 323,60,20);
            img3.getFlippedCopy(true, false).draw(525,323,60,20);
            x=0;
        }
        else if(Mouse.getX()>=577 && Mouse.getX()<=695 && Mouse.getY()>=320 && Mouse.getY()<=360){
            if(x==1)sound.play();
            font.drawString(578, 360, "How to Play", Color.red);
            img3.draw(696, 374,60,20);
            img3.getFlippedCopy(true, false).draw(515,374,60,20);
            x=0;
        }
        else if(Mouse.getX()>=614 && Mouse.getX()<=656 && Mouse.getY()>=270 && Mouse.getY()<=310){
            if(x==1)sound.play();
            font.drawString(615, 407, "Quit", Color.red);
            img3.draw(665,420,60,20);
            img3.getFlippedCopy(true, false).draw(543,420,60,20);
            x=0;
        }
        else x=1;
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        //This update method is just inputs from the mouse to move on to a different screen
        if(Mouse.getX()>=583 && Mouse.getX()<=685 && Mouse.getY()>=420 && Mouse.getY()<=460){
            if(gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
                sbg.enterState(4, new FadeOutTransition(), new FadeInTransition());
            }
        }
        if(Mouse.getX()>=577 && Mouse.getX()<=695 && Mouse.getY()>=320 && Mouse.getY()<=360){
            if(gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
                sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
            }
        }
        if(Mouse.getX()>=580 && Mouse.getX()<=690 && Mouse.getY()>=370 && Mouse.getY()<=410){
            if(gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
                sbg.enterState(3, new FadeOutTransition(), new FadeInTransition());
            }
        }
        if(Mouse.getX()>=614 && Mouse.getX()<=656 && Mouse.getY()>=270 && Mouse.getY()<=310){
            if(gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
                gc.exit();
            }
        }
    }
}