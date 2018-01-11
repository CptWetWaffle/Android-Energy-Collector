  import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public final class Persona extends MovingObject
{
    private GreenfootImage ex;
   private GreenfootImage img1;
   private GreenfootImage img2;
    public Persona(){
        super();
        img1= new GreenfootImage("android.png");
        img2= new GreenfootImage("android1.png");
        ex = new GreenfootImage("exp18.png");
        
    }
   
    private void edibleWall(){
    Wall eatWall= (Wall) getOneIntersectingObject(Wall.class);
                if (eatWall !=null)
                if (eatWall.isEdible())
                    getWorld().removeObject(eatWall);
    }
    
    public void animExplosion(){
        setImage(ex);
        Greenfoot.playSound("bomb.wav");
        Greenfoot.delay(20);
        Greenfoot.delay(0);
        getWorld().removeObject(this);

    }
   
    protected void move(){
        if(jump>=0)
            jump--;
        if(jump==0){
            
            if(Greenfoot.isKeyDown("up")){
                setLocation(getX(),getY()-speed);
                edibleWall();
                
                if (canSee(Wall.class) || canSee(Lock.class) || canSee(FallingObject.class)|| canSee(Portal.class)){
                    setLocation(getX(),getY()+speed);
               
                }
            }else if(Greenfoot.isKeyDown("down")){
                setLocation(getX(),getY()+speed);
                edibleWall();
                 BWorld m = (BWorld) getWorld();
                 if ((canSee(Portal.class) && !m.getPortal().canPass()) || canSee(Wall.class) || canSee(Lock.class) || canSee(FallingObject.class)){
                     setLocation(getX(),getY()-speed);
                }
            }else if(Greenfoot.isKeyDown("right")){
                setLocation(getX()+speed,getY());
                edibleWall();
                Actor wall = getOneObjectAtOffset(40,0 , Actor.class);
                if ((wall!=null && canSee(FallingObject.class)) || canSee(Lock.class) ||canSee(Wall.class)|| canSee(Portal.class)){
                    setLocation(getX()-speed,getY());
                }
            }else if(Greenfoot.isKeyDown("left")){
                setLocation(getX()-speed,getY());
                edibleWall();
                Actor wall = getOneObjectAtOffset(-40,0 , Actor.class);
                if ((wall!=null && canSee(FallingObject.class)) || canSee(Lock.class) ||canSee(Wall.class)|| canSee(Portal.class)){
                    setLocation(getX()+speed,getY());
                }
                
            }
            jump=top;
        }
    }
    
    /**
     * Act - do whatever the persona wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void animate(){
       int turning=4;
       turn(0);
         setImage(img1);
       if(Greenfoot.isKeyDown("left")){
          
            turn(-turning);
        }else if (Greenfoot.isKeyDown("right")){
            turn(turning);
        }else if (Greenfoot.isKeyDown("down"))
            setImage(img2);
       
       
    }
    public void act() 
    {
       
        move();
        animate();
        
    }    
}
