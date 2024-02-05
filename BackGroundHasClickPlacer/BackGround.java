import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Project 1: Create a game where an actor has to go around collecting a 
 * certain amount of fish and balloons while avoiding bombs
 * 
 * @author Bennett Stice 
 * @version 10/28/2022
 */
public class BackGround extends World
{

    /** This initializes some variables for text location and size of the world.
     */
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public static int PIXEL = 1;
    public static int TEXTXLOC=WIDTH/2;
    public static int TEXTYLOC=HEIGHT/2;
    /**
     * This creates a world called BackGround that sets the size and shows the starting text. 
     * It also starts the game when s is pressed.
     */
    public BackGround()
    {    
    
        super(WIDTH, HEIGHT, PIXEL); 
        showText("Collect Fish and Balloons while avoiding the bombs.\n Press s to start the game.",TEXTXLOC,TEXTYLOC);
        act();
        
    }
    /**
     * This adds in the actors of the game when s is pressed.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("s"))
        {
            prepare();
        }
        if(Greenfoot.mouseClicked(this))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null)
            {
                int xLoc=mouse.getX();
                int yLoc=mouse.getY();
                RedBalloon RedBalloon = new RedBalloon();
                addObject (RedBalloon,xLoc, yLoc);
            }
        }
    }
    /**
     * This deletes the starting text.
     */
    public void deleteText()
    {
        showText("",TEXTXLOC,TEXTYLOC);
    }
    /**
     * This runs the methods listed below to add in a specified amount of actors.
     */
    public void prepare()
    {
        addBalloons();
        addFish();
        addBombs();
        addTux();
        deleteText();
    }
    /**
     * The following 4 methods add in the actors in random locations using for loops.
     */
    public void addBalloons()
    {
        for (int i=1;i<=70;i++)
        {
            int xLoc = Greenfoot.getRandomNumber(getWidth()-1);
            int yLoc = Greenfoot.getRandomNumber (getHeight()-1);
            RedBalloon RedBalloon = new RedBalloon();
            addObject (RedBalloon,xLoc, yLoc);
            
        }
    }
    public void addFish()
    {
        for (int i=1;i<=25;i++)
        {
            int xLoc = Greenfoot.getRandomNumber(getWidth()-1);
            int yLoc = Greenfoot.getRandomNumber (getHeight()-1);
            Fish Fish = new Fish();
            addObject (Fish,xLoc, yLoc);
        }
    }
    public void addBombs()
    {//bombs not on top of starting tux but still on those widths and heights
        for (int i=1;i<=25;i++)
        {
            int xLoc = Greenfoot.getRandomNumber(getWidth()-100);
            int yLoc = Greenfoot.getRandomNumber (getHeight()-100);
            Bomb Bomb = new Bomb();
            addObject (Bomb,xLoc, yLoc);
        }
    }
    public void addTux()
    {
        int xLoc = getWidth()-50;
        int yLoc = getHeight()-50;
        Tux Tux = new Tux();
        addObject (Tux,xLoc, yLoc);
    }
}
