import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (my name) 
 * @version (a version number or a date)
 */
 public abstract class Enemy extends MovingObject
{

    protected int x,y;
    protected String direction;
    
    public Enemy(){
        super();
        y=x=speed;
        direction="left";
       
    }
    
    public Enemy(int salto){
        super(salto);
        y=x=speed;
        direction="left";
      
    }
    
    public Enemy(int salto, String dir){
        super(salto);
        y=x=speed;
        direction=dir;
    
    }
    
    protected abstract void animate();

    protected boolean canMove(){
       
        if (canSee(Enemy.class)|| canSee(Wall.class)||canSee(Lock.class)||canSee(Key.class)||canSee(FallingObject.class)||canSee(Portal.class)){
           
            setLocation(getX()-x,getY()-y);
            
            if(direction.equals("down")){
                direction="left";
            }else if (direction.equals("up")){
                direction="right";
            }else if (direction.equals("left")){
                direction="up";
            }else if(direction.equals("right")){
                direction="down";
            }
            return false;
        }
        return true;
        
    }
    
    protected void eat(){
        
        if(super.canSee(Persona.class)){
            BWorld mundo= (BWorld) getWorld();
            setLocation(getX()-x,getY()-y);
            mundo.getPersona().animExplosion();
            super.eat(Persona.class);

            mundo.setDead(true);
            if(mundo.getLife() >=1)
            mundo.setStage(mundo.getLevel());
            else
            mundo.setStage(0);
        }
    
    }
    
   
   
   // private void animate(){}
    public void act() 
    {
        animate();
        move();
        canMove();
        eat();
        
    }  
    
}

 