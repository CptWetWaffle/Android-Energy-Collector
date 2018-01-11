import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DiskWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiskWall extends Wall
{
  protected  boolean isEdible(){
        return true;
    }
      protected boolean isDestroyable(){
        return true;
    }
  
}
