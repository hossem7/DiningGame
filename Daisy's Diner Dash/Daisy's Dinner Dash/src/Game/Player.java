
package Game;


import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

//This is our main Gameplay screen where the character is created and maps are implemented from another class
public class Player extends BasicGameState{
    
    final Image[] img = new Image[4];
    final Image[] img2 = new Image[4];
    public static Animation right, left;
    private Music music;
    private Sound sound;
    private Sound soundPick;
    private Shape player;
    private level1 level;
    private String p="";
    private float  x=0, y=0;
    private static final float G =0.32f,jS=-10,speed=3;
    private int t=3, z=0, count=0;
    boolean dir = true;
    boolean[]items = {false, false, false, false};
    int plateX=800, plateY=105;
    Image imgB,imgF,iCake;
    Rectangle rec1, rec2, rec3, rec4, rec5, rec6, rec7,lvlClear, caution, tableR;
    Rectangle r1[], r2[];
    int itemsCol1=0, itemsCol2=0, c=0;
    ArrayList<Integer> height = new ArrayList<>();
    Player(level1 Level){
        this.level = Level;
    }
    @Override
    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException{
        //Music for our game
        this.init(gc, sbg);
        music = new Music("music\\Game.wav");
        sound = new Sound("music\\Jump.wav");
        soundPick = new Sound("music\\ItemPick.wav");
        music.loop(1.0f,0.5f);
    }
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        
        if(Cselection.iCharacter==1)p="Player2";
        else p = "player";
        img[0]=new Image(p+"\\sprite_0.png");
        img[1]=new Image(p+"\\sprite_1.png");
        img[2]=new Image(p+"\\sprite_2.png");
        img[3]=new Image(p+"\\sprite_3.png");
        
        img2[0] = new Image(p+"\\sprite_4.png");
        img2[1] = new Image(p+"\\sprite_5.png");
        img2[2] = new Image(p+"\\sprite_6.png");
        img2[3] = new Image(p+"\\sprite_7.png");
        
        left = new Animation(img,200);
        right = new Animation(img2,200);
        player = new Rectangle(1145,585,35,100);
        
        imgB = new Image("images\\game.png");
        imgF = new Image("images\\WoodFloor.jpg");
        
        //initializing all the hit boxes
        lvlClear = new Rectangle(1240,-30,10,140);
        rec1 = new Rectangle(level.itemsX[0],level.itemsY[0],level.items[0].getWidth(), level.items[0].getHeight());
        rec2 = new Rectangle(level.itemsX[1],level.itemsY[1],level.items[1].getWidth()-8, level.items[1].getHeight());
        rec3 = new Rectangle(level.itemsX[2],level.itemsY[2],level.items[0].getWidth(), level.items[0].getHeight());
        rec4 = new Rectangle(level.itemsX[3],level.itemsY[3],level.items[1].getWidth()-8, level.items[1].getHeight());
        rec5 = new Rectangle(plateX,plateY,level.items[2].getWidth(), level.items[2].getHeight());
        rec6 = new Rectangle(level.itemsX[4], level.itemsY[4], level.items[0].getWidth(), level.items[0].getHeight());
        rec7 = new Rectangle(level.itemsX[5], level.itemsY[5], level.items[1].getWidth(), level.items[1].getHeight());
        caution = new Rectangle(180, -300, level.items[3].getWidth()-40, level.items[3].getHeight());//x-180, y-(-100)
    }
    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        imgB.draw(0,0,1280,720);//BackGround Image
        g.setColor(Color.yellow);
        g.texture(level.levelBase, imgF, true);
        g.setColor(Color.black);
        g.drawString("Time: " + Score.timer/1000, 500, 0);
        g.drawString("Items: " + Score.items, 500, 100);
        g.draw(level.levelBase);
        g.setColor(Color.transparent);
        g.draw(player);
        
        
            level.items[0].draw(level.itemsX[0],level.itemsY[0]);
            level.items[1].draw(level.itemsX[1],level.itemsY[1],40,70);
            level.items[0].draw(level.itemsX[2],level.itemsY[2]);
            level.items[1].draw(level.itemsX[3],level.itemsY[3],40,70);
            level.items[0].draw(level.itemsX[4],level.itemsY[4]);
            level.items[1].draw(level.itemsX[5],level.itemsY[5],40,70);
            level.items[2].draw(plateX, plateY);
            level.items[3].draw(caution.getX()-20,caution.getY());
            /*g.draw(rec1);
            g.draw(rec2);
            g.draw(rec3);
            g.draw(rec4);
            g.draw(rec5);
            g.draw(rec6);
            g.draw(rec7);
            //*/
            g.draw(caution);
            g.setColor(Color.red);
            g.draw(lvlClear);
            g.setColor(Color.transparent);
           // g.drawString("Mouse X - " + Mouse.getX() + "\nMouse Y - " + gc.getInput().getMouseY(), 500, 0);
           
        //These if statements contains the player animation on the screen
        if(t==0){
            left.draw(player.getX()-20,player.getY(),75,100);
        }
        else if(t==1){
            right.draw(player.getX()-20,player.getY(),75,100);
        }
        else if(t==2){
            img2[1].draw(player.getX()-20,player.getY(),75,100);
        }
        else if (t==3){
            img[1].draw(player.getX()-20,player.getY(),75,100);
        }
    }
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        Score.timer+=delta;//updtating score
        
        y += G;//adding the affect of gravity
        
	if(gc.getInput().isKeyDown(Input.KEY_UP)){//jump
            player.setY(player.getY()+0.5f);
            if(level.collidesWith(player)){
                y=jS;
            }
        }
        player.setY(player.getY()+y);
        if(level.collidesWith(player)){//collision with the map vertically
            player.setY(player.getY()-y);
            y=0;
        }
        if(gc.getInput().isKeyDown(Input.KEY_LEFT)){//moving left
            x=-speed;
            t=0;
            z=1;
            
        }
        else if (gc.getInput().isKeyDown(Input.KEY_RIGHT)){//moving right
            x=speed;
            t=1;
            z=2;
        }
        else{//no movement
            x=0;
            if(z==1)t=3;
            if(z==2)t=2;
        }
        
        player.setX(player.getX()+x);//changing the player's x
        if(level.collidesWith(player)){//collision with the map horizontally
            player.setX(player.getX()-x);
            x=0;
        }
        if(level.level==1){//plate movement
            if(dir){
                plateX-=2;
                rec5.setX(plateX);
                level.items[2].rotate(-2);
            }
            else{
                plateX+=2;
                rec5.setX(plateX);
                level.items[2].rotate(2);
            }
            if(plateX<450){//450
                dir=false;
            }
            if(plateX>885){//885
                dir=true;
            }
        }
        else{//plate movement level 2
            if(dir){
                plateX-=2;
                rec5.setX(plateX);
                level.items[2].rotate(-2);
            }
            else{
                plateX+=2;
                rec5.setX(plateX);
                level.items[2].rotate(2);
            }
            if(plateX<550){
                dir=false;
            }
            if(plateX>1000){
                dir=true;
            }
        }
        for(int c=0; c<=5; c++){//creating array for the hitboxes
            r1 = new Rectangle[]{rec1, rec2, rec3, rec4,rec6,rec7};
            if(player.intersects(r1[c])){
                level.itemsY[c]-=1000;
                r1[c].setY(r1[c].getY()-1000);
                soundPick.play(1f, 5f);
                itemsCol1++;
                Score.items++;
            }
        }
        if(player.intersects(rec5) || player.intersects(caution)){//hitting the plate or the caution sign resets the level
            Score.items-=itemsCol1;
            itemsCol1=0;
            for(int c=0; c<=5; c++){
                if(r1[c].getY()<0){
                    r1[c].setY(r1[c].getY()+1000);
                    level.itemsY[c]+=1000;
                }
            }
            if(level.level==1){
                sbg.enterState(5);
            }
            else{
                sbg.enterState(6);
            }
        }
        
        if(level.level==2 && c==0){//changing x and y coordinates for the items and obstacles
            c=1;
            level.itemsX[0]=881;
            level.itemsX[1]=35;
            level.itemsX[2]=620;
            level.itemsX[3]=1140;
            level.itemsX[4]=30;
            level.itemsX[5]=50;
            
            level.itemsY[0]=645;
            level.itemsY[1]=620;
            level.itemsY[2]=474;
            level.itemsY[3]=329;
            level.itemsY[4]=295;
            level.itemsY[5]=40;
            plateY-=20;
            rec5.setY(rec5.getY()-20);
            
            for(int c=0; c<=5; c++){
                r1[c].setX(level.itemsX[c]);
                r1[c].setY(level.itemsY[c]);
            }
            /*if(player.intersects(lvlClear) && level.level==2){
            sbg.enterState(7);
            }*/
        }
        if(level.level==2){//go to gameover screen
            caution.setX(805);
            caution.setY(434);
            if(player.intersects(lvlClear)){
                sbg.enterState(7);
            }
        }
        if(player.intersects(lvlClear) && level.level==1){//go to level 2
            sbg.enterState(6);
        }
       
        if(Score.timer/1000==60){//timer
            System.out.println("Working");
            sbg.enterState(7); 
        }
        
    }
    @Override
    public int getID() {
        return(level.level+4);
    }
}
