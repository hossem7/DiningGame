/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

//This is the Highscores screen where we show The names of the players with theit scores
public class HighScores extends BasicGameState{
    static String[] Names = new String[10];
    static int[] Scores = new int[10];
    static int x=0,y=0;
    public HighScores(int i) {
        Larp();
        Quarp();
    }

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("Top 10 Employees", 567, 70);
        for(int c=0;c<10;c++){
            g.setColor(Color.yellow);
            g.drawString(Names[c]+" "+Scores[c], 570, ((c*50) + 130));    
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)){
            sbg.enterState(1, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
        }
    }
    
    public static void Larp(){//reading the Names file and storing it
        String Line;
        try{
            BufferedReader read = new BufferedReader(new FileReader("Names.txt"));
            while((Line = read.readLine())!=null){
               Names[x]=Line;
               x++;
            }
            read.close();
        }
        catch(IOException e){
            System.out.println("Error: " + e);
        }
    }
     public static void Quarp(){//reading the highscoress file and storing it
        String Line;
        try{
            BufferedReader read = new BufferedReader(new FileReader("HighScores.txt"));
            while((Line = read.readLine())!=null){
               Scores[y]=Integer.parseInt(Line);
               y++;
            }
            read.close();
        }
        catch(IOException e){
            System.out.println("Error: " + e);
        }
    }
    
}
