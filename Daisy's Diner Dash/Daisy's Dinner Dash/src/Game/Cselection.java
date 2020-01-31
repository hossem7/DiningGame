package Game;

import java.awt.Font;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

//This is the screen where the user is given of either chosing Daisy or James Wrong as character for the game
class Cselection extends BasicGameState {
    Image img;
    Image img2;
    final Image[] Daisy1 = new Image[4];
    final Image[] NotDaisy1 = new Image[4];
    private Animation Daisy, NotDaisy;
    public static int iCharacter=0;
    TrueTypeFont font, font2;
    int count=0;
    Rectangle r, r2;
    public Cselection(int i) throws SlickException {
        //image arrays to make animations
        this.img = new Image("images\\menu.png");
        this.img2 = new Image("images\\border.png");
        Daisy1[0] = new Image("player\\sprite_4.png");
        Daisy1[1] = new Image("player\\sprite_5.png");
        Daisy1[2] = new Image("player\\sprite_6.png");
        Daisy1[3] = new Image("player\\sprite_7.png");
        Daisy = new Animation(Daisy1,200);
        NotDaisy1[0] = new Image("Player2\\sprite_4.png");
        NotDaisy1[1] = new Image("Player2\\sprite_5.png");
        NotDaisy1[2] = new Image("Player2\\sprite_6.png");
        NotDaisy1[3] = new Image("Player2\\sprite_7.png");
        NotDaisy = new Animation(NotDaisy1,200);
        
        r=new Rectangle(700,235,300,250);
        r2=new Rectangle(250,235,300,250);
    }

    @Override
    public int getID() {
        return 4;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
       //Changes font 
       Font awt = new Font("Times New Roman", Font.BOLD, 48);
       font = new TrueTypeFont(awt, false);
       Font awt2 = new Font("Arial", Font.BOLD, 24);
       font2 = new TrueTypeFont(awt2,false);
       
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        //img.draw(0,0,1280,720);
        font.drawString(430, 50, "Choose a Character");
        img2.draw(250,235,300,250);
        img2.draw(700,235,300,250);
        //ifMouse dose no hover over the two choices still images are shown
        if(count==0){
            Daisy1[0].draw(330, 270);
            NotDaisy1[0].draw(780, 260);
        }
        //count is used to tell if your mose is hovering over one of the two character choices, if you hover over one a animation of the character plays untill you move the mouse off
        else if(count==1){
            Daisy.draw(330,270);
            g.draw(r2);
            font2.drawString(320,500,"James Wrong");
            NotDaisy1[0].draw(780, 260);
        }
        else if(count==2){
            NotDaisy.draw(780,260);
            g.draw(r);
            font2.drawString(825, 500, "Daisy");
            Daisy1[0].draw(330, 270);
        }
        
        
        g.setColor(Color.yellow);
       // g.drawString("Mouse X - " + Mouse.getX() + "\nMouse Y - " + gc.getInput().getMouseY(), 500, 0);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        //Where count is changed, if it hover over one of the choices it is one or two, else it is zero
        if(Mouse.getX()>701 && Mouse.getX()<1001 && gc.getInput().getMouseY()>235 && gc.getInput().getMouseY()<485){
            count=2;
            if(gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
            iCharacter=1;
            sbg.enterState(5, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
            }
        }
        
        else if(Mouse.getX()>250 && Mouse.getX()<550 && gc.getInput().getMouseY()>235 && gc.getInput().getMouseY()<485){
            count=1;
            if(gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
            iCharacter=2;
            sbg.enterState(5, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
            }
        }
        else count=0;
    }
    
}