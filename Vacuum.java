import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vacuum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vacuum extends Actor
{
    int dirtGone = 0;
    int dirtX = 350;
    int dirtY = 400;
    int endGameY = 100;
    int dirtAmount = ((MyWorld)getWorld()).getDirt();
    /**
     * Act - do whatever the Vacuum wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    public void lookOut()
    {
        /*
         * touching verifiers, what happens when dirt hits the vacuum
         */
        if(isTouching(Dirt.class))
        {
          removeTouching(Dirt.class);
          dirtGone = dirtGone + 1;
          getWorld().showText("Dirt cleaned: " + dirtGone, dirtX, dirtY);
          int toFinish = dirtAmount;
          if(dirtGone == dirtAmount)
          {
              getWorld().showText("Rooms are all clean!",dirtX,endGameY);
              Greenfoot.stop();
          }
        }
    }
}
