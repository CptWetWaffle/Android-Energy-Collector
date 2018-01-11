import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
private int type;
private GreenfootImage button;
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        press();

    } 
    
    public Button(){
        this(1);
    }
    public Button(int type){
        this.type=type;
        if(type==1){
            button = new GreenfootImage("NewGame.png");
        }else if(type == 0){
            button = new GreenfootImage("Instructions.png");
        }else if(type == 2){
            button = new GreenfootImage("SuicideButton.png");
        }
        setImage(button);
        
    }
    private void press(){
              BWorld m = (BWorld) getWorld();
        if(type ==1){
        if(Greenfoot.mousePressed(this)==true){
           button = new GreenfootImage("NewGame2.png");
           setImage(button);
        }
       }else if(type==0){
           if(Greenfoot.mousePressed(this)==true){
           button = new GreenfootImage("Instructions2.png");
           setImage(button);
        }
        }
        if (Greenfoot.mouseClicked(this)==true && type==1){
            
      
            m.setStage(1);
            Greenfoot.setWorld(m);
        }
        if(type == 2 & Greenfoot.mouseClicked(this)==true){
            m.getPersona().animExplosion();
            m.setDead(true);
            if(m.getLife() >=1)
            m.setStage(m.getLevel());
            else
            m.setStage(0);
        }
            Greenfoot.setWorld(m);
            }
                
            }
    

