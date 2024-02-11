import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vacuum here.
 * 
 * @author Matt Hansen, Gavin
 * @version 2/11/2024
 */

public class Vacuum extends Actor {
    int dirtGone = 0;//unsure if necessary
    //coordinates for the dirt cleaned tracker
    int dirtX = 450;
    int dirtY = 300;
    //y location for all clean text
    int endGameY = 350;
    int currentRoom = -1;

    /**
     * Empty constructor for class VacuumWorld. This is the default greenfoot will use.
     */
    public Vacuum() {
        
    }

    public void addedToWorld(World world) {
        
    }
    
    /**
     * Act - do whatever the Vacuum wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        cleanDirtInRoom();
    }

    public void cleanDirtInRoom() {
    if (getWorld() != null) {
        MyWorld world = (MyWorld) getWorld();
        int dirtAmount = world.getDirt();

        if (isTouching(Dirt.class)) {
            removeTouching(Dirt.class);
            dirtGone++;
            getWorld().showText("Dirt cleaned: " + dirtGone, dirtX, dirtY);

            if (dirtGone == dirtAmount) {
                getWorld().showText("Rooms are all clean!", dirtX, endGameY);
                Greenfoot.stop();
            }
        } else {
            // If no dirt in the current room, move to the next room
            int[] nextRoomPos = world.getRoomPos(currentRoom + 1); // Get the position of the next room

            // Adjust position to be in the middle of the room
            int nextX = nextRoomPos[0] + 50;
            int nextY = nextRoomPos[1] + 100;
            
            // Move towards the next room
            if (currentRoom == 0)
            {
                nextX = nextRoomPos[0] + 25;
                currentRoom++;
            }
            
            /*
            if (getX() != nextX || getY() != nextY) {
                if (getX() < nextX) {
                    setLocation(getX() + 1, getY()); // Move right
                } else if (getX() > nextX) {
                    setLocation(getX() - 1, getY()); // Move left
                } else if (getY() < nextY) {
                    setLocation(getX(), getY() + 1); // Move down
                } else if (getY() > nextY) {
                    setLocation(getX(), getY() - 1); // Move up
                }
            } else {
                // If the vacuum is fully in the next room, update current room
                currentRoom++;
                getWorld().showText("Current Room: " + currentRoom, dirtX, endGameY);

                // Stop the vacuum if it's entered all rooms
                if (currentRoom == 9) {
                    Greenfoot.stop();
                }
            }*/
        }
    }
    }
}