import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lizard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public final class BoogeyHammer extends Enemy
{   private GreenfootImage[] img;
 
   
    public  BoogeyHammer(){
        super();  
        img=new GreenfootImage[4];
        for(int i=0;i<4;i++){
           img[i] = new GreenfootImage("hammer" + (i+1) + ".png");
        }

    }
   
    public BoogeyHammer(int jump,String dir){
        super(jump,dir);
        img=new GreenfootImage[4];
        for(int i=0;i<4;i++){
            img[i] = new GreenfootImage("hammer" + (i+1) + ".png");
        }
    
    }
   
    protected void animate(){
        GreenfootImage image=getImage();
        y=x=0;
        //############################### Ecolher imagem ################################################
        if(jump%10==0){
                           
            if(direction.equals("left")){
                if(image==img[2]){
                    image=img[3];
                  }
                else{
                  image=img[2];       
                }
            }else{
                if(image==img[0]){
                    image=img[1];
                  }
                else{
                   image=img[0];       
                }
            }
        }
        
        setImage(image);
         //############################### Ecolher posição ################################################
        if(direction.equals("down")){
            y=speed;
            turn(90);                   
        }else if (direction.equals("up")){
            y=-speed;
            turn(-90);
        }else if (direction.equals("left")){
            turn(0);
            x=-speed;
        }else if(direction.equals("right")){
            x=speed;
            turn(0);
        }
    }
    
 
    //################################################# MOVE #########################################################33
     protected void move(){
        if(jump>=0)
            jump--;
        if(jump == 0){
        
            setLocation(getX()+x,getY()+y);
            jump=top;
            } 
    }

  
}
