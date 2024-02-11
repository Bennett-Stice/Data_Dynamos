import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Room extends Actor
{
    private boolean hasDirt = false;
    private Dirt thisRoomsDirt;
    /**
     * Act - do whatever the Room wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            toggleDirt();
        }
    }
    
    
    public void addDirt(){
        if(!hasDirt){
            int xLoc=this.getX();
            int yLoc=this.getY();
            thisRoomsDirt = new Dirt();
            getWorld().addObject (thisRoomsDirt,xLoc, yLoc);
            hasDirt = true;
        }
    }
    
    public void removeDirt(){
        if(hasDirt){
            getWorld().removeObject(thisRoomsDirt);
            hasDirt = false;
        }
    }
    
    public void toggleDirt(){
        if(hasDirt)
            removeDirt();
        else
            addDirt();
    }
    
    public boolean hasDirt(){
        return hasDirt;
    }
}
