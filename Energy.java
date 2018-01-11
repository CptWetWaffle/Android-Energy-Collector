import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Energy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Energy extends FallingObject
{
   protected final int top;
   protected int jump;
    
private GreenfootImage[] img;

   private int turn;
   

   public Energy () {
       this(10);
    }
    
      public Energy(int speed){
        super();
        this.top=speed;
        this.jump=speed;
         turn=1;
        img=new GreenfootImage[6];
        for(int i=0;i<6;i++){
           img[i] = new GreenfootImage("Chrome" + (i+1) + ".png");
        }
     }
 
  public void enterPortal(){
   if(canSee(Portal.class)){
       BWorld mundo = (BWorld) getWorld();
            mundo.removeEnergy(this);
            mundo.updateEnergy();
            getWorld().removeObject(this);
        }
   }
        
    public void animate(){
     if(jump>=0)
     jump--;
       
     if(jump==0){
                  switch(turn){
                         case 0: 
                                setImage(img[1]);
                                turn=2;
                                break;
                         case 1: 
                                setImage(img[2]);
                                turn=3;
                                break;
                         case 2: 
                                setImage(img[3]);
                                turn=4;
                                break;
                         case 3: 
                                setImage(img[4]);
                                turn=5;
                                break;
                         case 4: 
                                setImage(img[5]);
                                turn=6;
                                break;  
                         case 5: 
                                setImage(img[0]);
                                turn=1;
                                break;
            }
               jump=top;
                }
    }
    public void act() 
    {
        animate();
        super.move();
        enterPortal();
        super.gravity();
          
        // Add your action code here.
    }    
}
