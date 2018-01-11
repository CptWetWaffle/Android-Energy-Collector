import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScrapWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrapWall extends Wall
{
    
   protected boolean isEdible(){
        return false;
    }
    
    protected  boolean isDestroyable(){
        return true;
    }
    
}
