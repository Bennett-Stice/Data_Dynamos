import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Gavin Richardson, Matthew Hansen
 * @version 2/7/2024
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    final private static int WIDTH = 600;
    final private static int HEIGHT = 400;
    //Pixel size
    final private static int PIXEL = 1;
    
    //Menu horizontal start position
    final private static int MENU_X = 400;
    
    //grid size
    final private int gridRows;
    final private int gridCols;
    
    //grid top left cell coords
    final private int gridXStart;
    final private int gridYStart;
    
    //spacing between top left corners of rooms
    final private int spacingX;
    final private int spacingY;

    private int dirtAmount = 0;
    
    private boolean started = false; // Variable to track if the game has started
    
    /**
     * Empty constructor for class VacuumWorld. This is the default greenfoot will use.
     */
    public MyWorld()
    {    
        this(3,3, 100, 100, 100, 100);
    }
    
    /**
     * Constructor for different grid sizes for objects of class VacuumWorld.
     * @param rows number of rows of rooms
     * @param cols number of columns of rooms
     * @param x_spacing horizontal spacing of rooms
     * @param y_spacing vertical spacing of rooms
     * @param grid_start_x x coordinate of the top left corner of the top left room
     * @param grid_start_y y coordinate of the top left corner of the top left room
     */
    public MyWorld(int rows, int cols, int x_spacing, int y_spacing, int grid_start_x, int grid_start_y) {
        super(WIDTH, HEIGHT, PIXEL);
        
        gridRows = rows;
        gridCols = cols;
        
        gridXStart = grid_start_x;
        gridYStart = grid_start_y;
        
        spacingX = x_spacing;
        spacingY = y_spacing;

        for(int r = 0; r<gridRows; r++){
            for(int c = 0; c<gridRows; c++){
                addObject(new Room(), gridXStart+(r*spacingX), gridYStart+(c*spacingY));
            }
        }
        
        addObject(new Button(), MENU_X+50, 100); 
        showText("Start", MENU_X+50, 100);
        addObject(new Button(), MENU_X+50, 200);
        showText("Randomize Dirt", MENU_X+50, 200);
        
        addVacuum();
        
        //calls the prepare method
    }
    
    /**
     * Gets room position for the specified room number (starting at index 0)
     * @param roomNum Room number, starting from top left
     * @return An array of the x and y position of the room's top left corner
     */
    public int[] getRoomPos(int roomNum){
        return new int[] {gridXStart + (roomNum%gridRows)*spacingX, gridYStart + (roomNum/gridCols)*spacingY};
    }
    
    /**
     * Gets room position for the specified room number (starting at index 0)
     * @param roomRow Room's row in the grid
     * @param roomCol Room's column in the grid
     * @return An array of the x and y position of the room's top left corner
     */
    public int[] getRoomPos(int roomRow, int roomCol){
        return new int[] {gridXStart + roomRow*spacingX, gridYStart + roomCol*spacingY};
    }
    
    /**
     * Gets room count
     * @return Number of rooms in the grid
     */
    public int getRoomCount(){
        return gridRows*gridCols;
    }
    
    public void act()
    {
        /*if (!started) {
            // If the game has not started yet, check for clicks on any button
            if (Greenfoot.mouseClicked(null)) {
                Actor clickedActor = Greenfoot.getMouseInfo().getActor();
                if (clickedActor instanceof Button) {
                    // If any button is clicked, start the game
                    addVacuum();
                    started = true;
                }
            }
        } else {
            // If the game has started, call the act method of Vacuum
            getObjects(Vacuum.class).forEach(Vacuum::act);
        }*/
        /*
         * code given to spawn everything
         */

        /*if(Greenfoot.mouseClicked(this))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null)
            {
                int xLoc=mouse.getX();
                int yLoc=mouse.getY();
                Dirt dirty = new Dirt();
                addObject (dirty,xLoc, yLoc);
                dirtAmount = dirtAmount +1;
            }
        }
        
        //ONCE START BUTTON IS CODED, VACUUM NEEDS TO BE ADDED*/

    }
    public int getDirt()
    {
        return dirtAmount;
    }
    /*private void addDirt()
    {
        //creates the balloons object and spawns it in randomly
        Dirt dirt = new Dirt();
        addObject(dirt, Greenfoot.getRandomNumber(699)+1, Greenfoot.getRandomNumber(499)+1);
    }*/
    private void addVacuum()
    {
        //creates the tux object and spawns him at his constant spawn point
        Vacuum vacuum = new Vacuum();
        addObject(vacuum, gridXStart-50, gridYStart-50);
    }
}
