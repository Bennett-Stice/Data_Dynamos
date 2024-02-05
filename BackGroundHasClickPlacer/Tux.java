import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is Tux.
 * Tux says HI.
 * Tux likes to eat fish and pop balloons.
 * 
 * @author Bennett Stice 
 * @version 10/28/2022
 */
public class Tux extends Actor
{
    /**
     * This initializes some variables and creates a set location for the text showing totals
     */
    int balloonsPopped=0;
    int fishesCaught=0;
    int textXLoc= 400;
    int textYLoc= 300;
    /**
     * This gives Tux the ability to move and checks if it's touching another actor and either adds that to a total or ends the game.
     */
    public void act()
    {
        // Add your action code here.
        checkKeyPress();
        lookOut();
    }
    /**
     * This checks which key is pressed and moves Tux accordingly.
     */
    public void checkKeyPress()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-1);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+1);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-1,getY());
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+1,getY());
        }
    }
    /**
     * This is constantly checking for if Tux is touching something. If he is, then it does some set actions. 
     */
    public void lookOut()
    {   /**
        *This tells if Tux is touching a balloon.
        */
        if (isTouching(RedBalloon.class))
        {
            int toWin=50;// sets the value of balloons popped needed to win
            removeTouching(RedBalloon.class); // This removes the balloon tux touches
            Greenfoot.playSound("Pop.wav"); //This plays a sound when it is popped.
            balloonsPopped++; //This increases the count of balloons popped
            getWorld().showText("Balloons Popped : "+balloonsPopped+
                "\nFish Caught : "+fishesCaught,textXLoc,textYLoc); // Shows a text showing the number of balloons popped and fish caught.
            if (balloonsPopped==toWin)
            {
                Greenfoot.playSound("fanfare.wav"); // This plays a sound when a certain number of balloons have been popped.
                getWorld().showText("You Win!",textXLoc,textYLoc); // This tells the user they have won.
                Greenfoot.stop(); //This stops the game.
            }
        }
        /**
        *This tells if Tux is touching a fish.
        */
        if (isTouching(Fish.class))
        {
            int toWin=10;// sets the value of fish caught needed to win.
            removeTouching(Fish.class);// This removes the fish tux touches.
            Greenfoot.playSound("FishOn.wav");//This plays a sound when it is caught.
            fishesCaught++;//This increases the count of fish caught.
            getWorld().showText("Balloons Popped : "+balloonsPopped+
                "\nFish Caught : "+fishesCaught,textXLoc,textYLoc);// Shows a text showing the number of balloons popped and fish caught.
            if (fishesCaught==toWin)
            {
                Greenfoot.playSound("fanfare.wav");// This plays a sound when a certain number of fish have been caught.
                getWorld().showText("You Win!",textXLoc,textYLoc);// This tells the user they have won.
                Greenfoot.stop();//This stops the game.
            }
        }
        /**
        *This tells if Tux is touching a bomb.
        */
        if (isTouching(Bomb.class))
        {
            removeTouching(Bomb.class);// This removes the bomb tux touches.
            Greenfoot.playSound("au.wav");//This plays a sound when tux touches the bomb.
            getWorld().showText("Game over, so sorry.",textXLoc,textYLoc);// This tells the user they have lost.
            Greenfoot.stop();//This stops the game.
        }
    }
}
