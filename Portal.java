import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Actor
{
private boolean pass;
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        passLevel();     
    }
    
    public Portal(){
        pass = false;
    }
    
    private void passLevel(){
            pass = true;
            BWorld mundo = (BWorld) getWorld();
            if(!mundo.existEnergy()){
             Persona actor =(Persona) getOneObjectAtOffset(0, 0, Persona.class);
                if(actor != null) {
                    getWorld().removeObject(actor);
                    mundo.setStage(mundo.getLevel()+1);
                }
            }
    }
    
    public boolean canPass(){
        return pass;
    }
    
}
