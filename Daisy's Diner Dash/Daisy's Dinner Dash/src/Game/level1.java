/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

//This class contains both the levels. We used polygonPoints to implement our map. All the x and y coordinate fot the items are initiazed here
public class level1 {
    public Shape levelBase;
    Image[] items = new Image[4];
    Image[] items2 = new Image[4];
    Image table;
    float[] polygonPoints;
    static int [] itemsX, itemsY, itemsX2, itemsY2;
    int level;
    public level1(int Level) throws SlickException{
        this.level=Level;
        if(level==1){
            this.polygonPoints = new float[]
                                {0,-100,
				 30,-100,
                                 30,105,
                                 300,105,
                                 300,135,
                                 30,135,
                                 30,360,
                                 360,360,
                                 360,315,
                                 400,315,
                                 400,360,
                                 800,360,
                                 800,390,
                                 30,390,
                                 30,630,
                                 130,630,
                                 130,690,
				 1248,690,
				 1248,580,
				 250,580,
				 250,550,
                                 800,550,
                                 800,520,
                                 920,520,
                                 920,470,
                                 970,470,
                                 970,520,
				 1248,520,
                                 1248,390,
                                 1100,390,
                                 1100,360,
                                 1248,360,
                                 1248,200,
                                 475,200,
                                 475,170,
                                 950,170,
                                 950,110,
                                 1248,110,
				 1248,-100,
				 1278,-100,
				 1278,720,
				 0,720};
        }
        else if(level==2){
            this.polygonPoints=new float[]
            {
            0,-100,
            30,-100,
            30,110,
            260,110,
            260,140,
            30,140,
            30,340,
            250,340,
            250,380,
            30,380,
            30,690,
            250,690,
            250,590,
            300,590,
            300,690,
            970,690,
            970,570,
            550,570,
            550,500,
            400,500,
            400,450,
            600,450,
            600,520,
            1020,520,
            1020,600,
            1100,600,
            1100,690,
            1248,690,
            1248,440,
            1100,440,
            1100,400,
            1248,400,
            1248,200,
            650,200,
            650,250,
            400,250,
            400,210,
            600,210,
            600,150,
            1248,150,
            1248,-100,
            1278,-100,
            1278,720,
            0,720,
            };
        }
        this.levelBase = new Polygon(polygonPoints);
        items[0] = new Image("items\\burger.png");//burger
        items[1] = new Image("items\\coke.png");//coke
        items[2] = new Image("items\\plate.png");//plate
        items[3] = new Image("items\\sign.png");//sign
        
        table = new Image("items\\table.png");
        
        itemsX = new int[]{881, 35, 1130, 1140, 170, 50};
        itemsY = new int[]{645, 560, 476, 290, 315, 30};
        
        
        /*itemsX2 = new int[]{1145,700,950,35,780};
        itemsY2 = new int[]{350,460,645,645,420};*/
    }
   
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
    }
    public boolean collidesWith( Shape s ){
	return levelBase.intersects(s) /*|| platform.intersects(s)*/;
    }
    
}
