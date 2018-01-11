import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MovingObject extends Actor
{
    protected final int speed=40;
    protected final int top;
    protected int jump;
    
    
    public MovingObject(){
    this(6);
    }
    
    public MovingObject(int jump){
        top=jump;
    this.jump=jump;
    }
    
    protected abstract void move();
    
    
    public void turn(int degrees){
        setRotation(degrees);
    }
    
    
     /**
     *  Method eat and Method canSee.
     *  
     * @author Michael Kolling
     * @version 1.0
     */
     public void eat(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }
    
    protected boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }
    
  
    public void act() 
    {
        // Add your action code here.
    }    
    
    
}
