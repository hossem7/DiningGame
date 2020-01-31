/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;
import static Game.HighScores.Names;
import static Game.HighScores.Scores;
import static Game.level1.itemsX;
import static Game.level1.itemsY;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

//This is the game over screen, where the user enters their name and it will show their score below it
public class GameOver  extends BasicGameState {
    static int z =2,Four=0;
    static String Name="";
    
    public GameOver(int i) {
            
    }

    @Override
    public int getID() {
        
    
        return 7;

    }
    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.init(gc, sbg);
        int z =2,Four=0;
        String Name="";
        Check();
    }
   
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
      
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    g.drawString("Enter your name, up to four letters", 567, 70);
        for(int c=0;c<10;c++){
            g.setColor(Color.yellow);
            g.drawString(Names[c]+" "+Scores[c], 570, ((c*50) + 130));    
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        //Lets you type in 4 characters to make a string
        if(gc.getInput().isKeyPressed(Input.KEY_A)){
            Name=Name+"A";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_B)){
            Name=Name+"B";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_C)){
            Name=Name+"C";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_D)){
            Name=Name+"D";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_E)){
            Name=Name+"E";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_F)){
            Name=Name+"F";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_G)){
            Name=Name+"G";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_H)){
            Name=Name+"H";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_I)){
            Name=Name+"I";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_J)){
            Name=Name+"J";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_K)){
            Name=Name+"K";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_L)){
            Name=Name+"L";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_M)){
            Name=Name+"M";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_N)){
            Name=Name+"N";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_O)){
            Name=Name+"O";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_P)){
            Name=Name+"P";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_Q)){
            Name=Name+"Q";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_R)){
            Name=Name+"R";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_S)){
            Name=Name+"S";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_T)){
            Name=Name+"T";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_U)){
            Name=Name+"U";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_V)){
            Name=Name+"V";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_W)){
            Name=Name+"W";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_X)){
            Name=Name+"X";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_Y)){
            Name=Name+"Y";
            Four++;
        }
        if(gc.getInput().isKeyPressed(Input.KEY_Z)){
            Name=Name+"Z";
            Four++;
        }
        //When you type four times it stops you from making a sting longer than 4 chars
        if(Four==4){
            Check();
            Score.timer=0;
            Score.items=0;
            sbg.enterState(1, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
        }
        
    }
    public static void Check(){
    //checks to see if your score can make it, it dose this by comparing your score to the txt files score
     System.out.println("Check");
    for(int c=0;c<10;c++){
        if(Score.items>=Scores[c]){
            Scores[c]=Score.items;
            Names[c]=Name;
            Four=0;
            Name="";
            itemsX = new int[]{881, 35, 1130, 1140, 170, 50};
            itemsY = new int[]{645, 560, 476, 290, 315, 30};
            try {
                SaveFile();
                SaveFile1();
            } catch (IOException ex) {
                Logger.getLogger(GameOver.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
        }
        else Four=4;
    
    }
    }
    public static void SaveFile()throws IOException{
        BufferedWriter bwWrote = new BufferedWriter(new FileWriter("HighScores.txt"));
        for(int c=0;c<10;c++){
                bwWrote.write(Integer.toString(Scores[c]));
                bwWrote.newLine();
            }
        bwWrote.close();
        System.out.println("File Saved");
    }
     public static void SaveFile1()throws IOException{
        BufferedWriter bwWrote = new BufferedWriter(new FileWriter("Names.txt"));
        for(int c=0;c<10;c++){
                bwWrote.write(Names[c]);
                bwWrote.newLine();
            }
        bwWrote.close();
        System.out.println("File Saved");
    }  

    
}
