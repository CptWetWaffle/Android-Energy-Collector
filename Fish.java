import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fish extends Enemy
       
{
    
   
    public Fish(int vel){
        super(vel);
        
    }

    protected void move(){
        BWorld mundo= (BWorld) getWorld();
        BoogeyHammer hammer=mundo.getHammer();
        
        if(jump>=0)
            jump--;
        
        if(jump == 0){
            y=x=0;
            if(!mundo.isDead()){
                Persona persona = mundo.getPersona();
               if(persona.getX()-getX()==0)
                   if (persona.getY()-getY()>0){
                        y=speed;
                        super.direction="down";
                    }else if (persona.getY()-getY()<0){
                        y=-speed;
                        super.direction="up";
                    }
               if (persona.getX()-getX()<0){
                    x=-speed;
                    super.direction="left";
                }else if (persona.getX()-getX()>0){
                    x=speed;
                   super.direction="right";
                }
                    
               setLocation(getX()+x,getY()+y);                 
            }   
            jump=top;
        } 
    }
   
    protected void animate(){
        GreenfootImage aux=new GreenfootImage("Shark.png");
        
         setImage(aux);
         turn(0);
    if(direction.equals("left"))
        aux.mirrorHorizontally();
        else if (direction.equals("down"))
        turn(90);
        else if (direction.equals("up"))
        turn(-90);
        else if (direction.equals("right")){
        turn(0);
        }
     
    }
    

}
