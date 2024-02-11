import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vacuum here.
 * 
 * @author Matt Hansen, Gavin Richardson
 * @version 2/11/2024
 */

public class Vacuum extends Actor {
    int dirtGone = 0;//unsure if necessary
    //coordinates for the dirt cleaned tracker
    static int dirtX = 450;
    static int dirtY = 300;
    //y location for all clean text
    static int endGameY = 350;
    int currentRoom;
    
    //number of rooms the robot has scanned
    private int roomsPassed = 0;
    private boolean verticalSpeedLimiter = true;
    
    //causes the pause after removing dirt or scanning a room
    private int actionCooldown = 0;

    /**
     * Empty constructor for class VacuumWorld. This is the default greenfoot will use.
     */
    public Vacuum(int room) {
        currentRoom = room;
    }

    public void addedToWorld(World world) {
        world.showText("Current Room: 1", dirtX, endGameY);
        world.showText("Dirt cleaned: 0", dirtX, dirtY);
    }
    
    /**
     * Act - do whatever the Vacuum wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(((MyWorld) getWorld()).getStarted())
            cleanDirtInRoom();
    }

    public void cleanDirtInRoom() {
        // Stop the vacuum if it's entered all rooms
        
        
        if (getWorld() != null) {
            MyWorld world = (MyWorld) getWorld();
            int dirtAmount = world.getDirt();//should the vacuum know this?
            
            //if done moving and no dirt, go to next room
            // Move towards the next room
            /*if (currentRoom == 0)
            {
                //currentRoom++;
            }*/

            // If no dirt in the current room, move to the next room
            //System.out.println("Current Room: " + currentRoom);
            //int nextRoom = (currentRoom+1) % 9;
            int[] nextRoomPos = world.getRoomPos(currentRoom); // Get the position of the next room

            // Adjust position to be in the middle of the room
            int nextX = nextRoomPos[0];// + 50;
            int nextY = nextRoomPos[1];// + 100;
            
            //System.out.println(nextX+" "+nextY);
            //System.out.println("Current Room: "+currentRoom);
            
            //if the vacuum needs to move, move
            if (getX() != nextX || getY() != nextY) {
                //System.out.println("Moving");
                //System.out.println("Offset: " + (getX()-nextX)+" "+(getY()-nextY));
                if (getX() < nextX) {
                    setLocation(getX() + 1, getY()); // Move right
                } else if (getX() > nextX) {
                    setLocation(getX() - 1, getY()); // Move left
                }
                //makes vertical movement go at half the speed, purely cosmetic for functionality
                verticalSpeedLimiter = !verticalSpeedLimiter;
                if(currentRoom==0 || verticalSpeedLimiter){
                    if (getY() < nextY) {
                        setLocation(getX(), getY() + 1); // Move down
                    } else if (getY() > nextY) {
                        setLocation(getX(), getY() - 1); // Move up
                    }
                }
                actionCooldown = 50;
            }
            //otherwise, check dirt, if no dirt, increment room count
            else {
                if(actionCooldown>0){
                    actionCooldown--;
                    return;
                }
                
                //System.out.println("No movement");
                if (world.getRoomAtIndex(currentRoom).hasDirt()) {
                    world.getRoomAtIndex(currentRoom).removeDirt();
                    dirtGone++;
                    getWorld().showText("Dirt cleaned: " + dirtGone, dirtX, dirtY);
                    //should the vacuum know this?
                    if (dirtGone == dirtAmount) {
                        getWorld().showText("Rooms are all clean!", dirtX, endGameY);
                        Greenfoot.stop();
                    }
                } else {
                    // If the vacuum is fully in the next room, update current room
                    currentRoom = (currentRoom+1)%9;
                    roomsPassed++;
                    
                    //placed here so that an incorrect final room isn't shown
                    if (roomsPassed >= ((MyWorld)this.getWorld()).getRoomCount()) {
                        //System.out.println("Done");
                        Greenfoot.stop();
                        return;
                    }
                    
                    getWorld().showText("Current Room: " + (currentRoom+1), dirtX, endGameY);
                    //System.out.println(roomsPassed);
                }
            }
        }
    }
}