import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * To start the vacuum
 * 
 * @author Matt Hansen, Justin Pawlowski
 * @version 2/11/2024
 */
public class StartButton extends Button
{
    // Set start to true, start the vacuum
     void onClick(){
        ((MyWorld)this.getWorld()).setStarted(true);
    }
}
