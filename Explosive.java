import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Eplosive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosive extends FallingObject
{
   
    

    protected void gravity() {
        BWorld mundo= (BWorld) getWorld();
    
           if(jump>=0)
               jump--;
            if(jump==0){
               
                setLocation(getX(),getY()+aceleration);
                     fall++;       
  
                if(canSee(Actor.class)){
                    if(fall>1){
                        setLocation(getX(),getY()-aceleration);
                                                
                        if(canSee(Persona.class)){
                        kill(Persona.class);
                        mundo.setDead(true);
                        explode();
                        if(mundo.getLife() >=1)
                        mundo.setStage(mundo.getLevel());
                        else
                        mundo.setStage(0);
                        }else
                         explode();
                    }
                        else{
                        setLocation(getX(),getY()-aceleration);
                        fall=0;
               
                        
               } 
            }   
                    
            jump=top;
        
        }
    
    }
}
