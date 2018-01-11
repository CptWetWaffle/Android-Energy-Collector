import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Label here.
 * 
 * @author (ynotplay) 
 * @version (0.0.1 prealfa)
 */
public class Label extends Actor
{
    private GreenfootImage background;

    /**
     * Act - do whatever the Label wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }

    Label(){
        this("");
    }

    Label(String s){
        background = new GreenfootImage(100,75);
        background.scale(40,40);
        background.setColor(Color.BLACK);
        background.drawString(s,2,20);
        setImage(background);

    }  
    
    public void setText(String s, Color c){
        background.clear();
        background.setColor(c);
        background.drawString(s,2,20);
        setImage(background);
    }
    
        public void setText(String s){
        background.clear();
        background.drawString(s,2,20);
        setImage(background);
    }
}
