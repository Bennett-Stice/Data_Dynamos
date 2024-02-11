import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class RandomizerButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomizerButton extends Button
{
     void onClick(){
         List<Room> roomList = getWorld().getObjects(Room.class);
         for (Room room : roomList){
             int num = Greenfoot.getRandomNumber(2);
             if (num == 0){
                 room.toggleDirt();
             }
         }
    }
}
