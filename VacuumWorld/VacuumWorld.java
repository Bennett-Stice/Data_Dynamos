import greenfoot.*;

/**
 * World for vacuum, contains logic for creating the grid and conrtols.
 * 
 * @author Matthew Hansen
 * @version 2/4/2024
 */
public class VacuumWorld extends World {
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
    /**
     * Empty constructor for objects of class VacuumWorld.
     * 
     */
    public VacuumWorld() {
        super(WIDTH, HEIGHT, PIXEL);
        
        gridRows = 3;
        gridCols = 3;
        
        gridXStart = 100;
        gridYStart = 100;
        
        spacingX = 100;
        spacingY = 100;
        
        for(int r = 0; r<gridRows; r++){
            for(int c = 0; c<gridRows; c++){
                addObject(new Room(), gridXStart+(r*spacingX), gridYStart+(c*spacingY));
            }
        }
        
        addObject(new Button(), MENU_X+50, 100); 
        showText("Start", MENU_X+50, 100);
        addObject(new Button(), MENU_X+50, 200);
        showText("Randomize Dirt", MENU_X+50, 200);
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
    public VacuumWorld(int rows, int cols, int x_spacing, int y_spacing, int grid_start_x, int grid_start_y) {
        super(WIDTH, HEIGHT, PIXEL);
        
        gridRows = rows;
        gridCols = cols;
        
        gridXStart = 100;
        gridYStart = 100;
        
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
}







