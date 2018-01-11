import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.*;
/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class FallingObject extends Actor
{

    protected final int aceleration=40;
    protected final int top;
    protected int jump;
    protected int fall;
    private int turn;
    private GreenfootImage[] ex;
    public FallingObject(){
    this(15);
    }
    
    public FallingObject(int aceleration){
    this.top=aceleration;
    this.jump=aceleration;
    fall = 0;
    turn = 1;
    ex = new GreenfootImage[24];
    for(int i = 0; i<24; i++)
        ex[i] = new GreenfootImage("ex" + (i+1) + ".png");
    }
    
     public void kill(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
        
    }  
    
    public void kill(int x,int y, Class clss)
    {   BWorld mundo= (BWorld)getWorld();
        Actor actor = getOneObjectAtOffset(x, y, clss);
        if(actor != null) {
           
                 getWorld().removeObject(actor);
            }
           
        
        
    }
    
    public void explode()
    {
        Greenfoot.playSound("bomb.wav");
          BWorld mundo=(BWorld) getWorld();
          setImage(ex[18]);
           Persona pepe = (Persona) getOneIntersectingObject(Persona.class);
        for (int j=-40;j<=40;j=j+40){
                    for (int i=-40;i<=40;i=i+40){
                         Portal p = (Portal) getOneObjectAtOffset(i,j,Portal.class);
                         Lock l = (Lock) getOneObjectAtOffset(i,j,Lock.class);
                         Wall w = (Wall) getOneObjectAtOffset(i,j,Wall.class);
                       
                         
                          if(w!=null){
                            if (w.isDestroyable())
                                kill(i,j,Actor.class);
                            }
                         else if (p==null &&l==null)
                            kill(i,j,Actor.class);
                       
                        }
                    }
               Greenfoot.delay(20);
               Greenfoot.delay(0);
               getWorld().removeObject(this);
               if (pepe!=null){
                             
                             mundo.setDead(true);
                             mundo.removeObject(pepe);
                               if(mundo.getLife() >=1)
                                mundo.setStage(mundo.getLevel());
                                else
                                mundo.setStage(0);
                        }
                
                
                   
                
    }
    
    
    public void move(){
        
        if(canSee(Persona.class))
        if (Greenfoot.isKeyDown("right")){
            setLocation(getX()+aceleration,getY());
            Actor wall = getOneObjectAtOffset(0,40 , Actor.class);
            if(wall ==null){
                setLocation(getX(),getY()+aceleration);
                fall++;
            }
            if (canSee(Wall.class)) {
                setLocation(getX()-aceleration,getY());
            }
        }else if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-aceleration,getY());
            Actor wall = getOneObjectAtOffset(0,40 , Actor.class);
            if(wall ==null){
                fall++;
                setLocation(getX(),getY()+aceleration);
            }
            if (canSee(Wall.class)) {
                setLocation(getX()+aceleration,getY());
            }
        }
    }     
    protected void gravity() {
        BWorld mundo= (BWorld) getWorld();

       if(jump>=0)
           jump--;
        if(jump==0){
           
            setLocation(getX(),getY()+aceleration);
                 fall++;       
            if (canSee(Wall.class)||canSee(Lock.class)||canSee(Key.class)||canSee(Energy.class)||canSee(Stone.class)) {
                setLocation(getX(),getY()-aceleration);
                fall=0;
            }
           
            if(canSee(MovingObject.class)){
                if(fall>1){
                    Greenfoot.delay(20);
                if(canSee(Persona.class)){
                    kill(MovingObject.class);
                    mundo.setDead(true);
                    explode();
                    if(mundo.getLife() >=1)
                    mundo.setStage(mundo.getLevel());
                    else
                    mundo.setStage(0);
                    
                }else{
                 kill(MovingObject.class);
                 explode();}
                 Greenfoot.delay(0);
            }
                else{
                setLocation(getX(),getY()-aceleration);
                fall=0;
            }
                    
                } 
                
                
        jump=top;
        }
    
    }
    
   


public boolean canSee(Class clss)
    {
            Actor actor = getOneObjectAtOffset(0, 0, clss);
            return actor != null;        

        }
public void animExplode(){
        
          for(int i=0;i<23;i++){
                for (int j=0;j<(2^15);j++){
                    if(j==0){
                        setImage(ex[i]);
                    }
                }
            }

    }
    
     public void act() 
    {
        
        move();
        gravity();
    } 
}