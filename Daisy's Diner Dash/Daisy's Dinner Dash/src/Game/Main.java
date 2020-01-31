
package Game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author mhossein3138
 */
public class Main extends StateBasedGame{
    public static void main(String[] args) throws SlickException{
        AppGameContainer app = new AppGameContainer(new Main("Daisy's Diner Dash"));//Initializing game screen
        app.setDisplayMode(1280,720, false);//setting display sizes
        app.setTargetFrameRate(100);//max/targeted fps - 100
        app.start();//starting the app
    }

    public Main(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        addState(new Start(0));//sSart screen
        addState(new Menu(1));//Menu screen
        addState(new Training(2));//How to Play screen
        addState(new HighScores(3));//HighScores Screen
        addState(new Cselection(4));//Character Selection Screen
        addState(new Player(new level1(1)));// level 1
        addState(new Player(new level1(2)));// level 2
        addState(new GameOver(7));// gameover screen with name input
    }
}
