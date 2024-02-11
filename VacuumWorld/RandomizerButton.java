import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Randomizes which rooms are dirty
 * 
 * @author Matt Hansen, Justin Pawlowski
 * @version 2/11/2024
 */
public class RandomizerButton extends Button
{
     void onClick(){
         // List of the rooms in the world
         List<Room> roomList = getWorld().getObjects(Room.class);
         // 50% chance that a room has dirt
         for (Room room : roomList){
             int num = Greenfoot.getRandomNumber(2);
             if (num == 0){
                 room.toggleDirt();
             }
         }
    }
}
