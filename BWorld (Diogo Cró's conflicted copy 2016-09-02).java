import greenfoot.*;
import java.lang.*;
import java.util.*;
import java.awt.Color;
/**
 * Write a description of class BWorld here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BWorld extends World {
    private Persona persona;
    private int stage, life, time, i,deadEnergy, level, score;
    private GreenfootImage background;
    private BoogeyHammer hammer;
    private boolean dead;
    private Label en, tim,sc;
    private ArrayList<Energy> energy;
    private final int top;
    private int jump;
    private Portal p;
    private boolean begin;

    /**
     * Constructor for objects of class BWorld.
     * 
     */
    public BWorld() {
        
        super(760, 560, 1);
        begin=false;
        energy = new ArrayList<Energy>();
        deadEnergy = 0;
        time = -1;
        score = 0;
        stage0();
        top = jump = 50;
    }
    
    public void act(){
        verifyTime();
        if(!begin){
       // Greenfoot.playSound("NyanCat.mp3");
        begin=true;
    }
//         updateEnergy();
    }
    
    public Portal getPortal(){
        return p;
    }
    
    public void verifyTime(){
         if (time !=-1){
            if ( jump > 0)
                jump--;
            else if(jump==0){
                time--;
                if(time>=6)
                tim.setText(""+time);
                else
                tim.setText(""+time,Color.RED);
                jump = top;
                if (time == 0){
                    persona.animExplosion();
                    setDead(true);
                    if(getLife() >=1)
                        setStage(getLevel());
                    else
                        setStage(0);
                }
            }
        }
    }

    private void decreaseLife() {
        life--;
    }

    public void setDead(boolean i) {
        dead = i;
        if (i == true)
            decreaseLife();
    }

    public boolean isDead() {
        return dead;
    }

    private void drawWall(int x, int y, int width, int height, int type) {
        Wall w;
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                switch (type)
                {
                   case 1:
                         w = new SteelWall();
                         break;
                   case 2:
                         w = new ScrapWall();
                         break;
                    case 3:
                         w = new DiskWall();
                         break;
                    
                   default:
                         w = new SteelWall();
                         break;
                }
               
                addObject(w, x + (i * 40), y + (j * 40));
            }
        }
    }

    private void drawBorder() {
        drawWall(20, 540, 19, 1, 1);
        drawWall(20, 100, 19, 1, 1);
        drawWall(740, 140, 1, 10, 1);
        drawWall(20, 140, 1, 10, 1);
    }
    
    public int getLevel(){
        return level;
    }
    
    public void updateEnergy(){
        removeObjects(getObjectsAt(410, 45, Label.class));
        en = new Label(deadEnergy + "/" + i);
        addObject(en, 410, 45);
    }
    
    public void setStage(int stage) {
        this.stage = stage;
        if (life != 3)
                Greenfoot.delay(50);         
        energy.clear();
        if(!isDead() && time!=-1)
            score += time;
        removeObjects(getObjects(Actor.class));
        setDead(false);
        deadEnergy = 0;
        
        i=0;
        
        switch (stage) {
        case 4:
        level = 0;
        score = 0;
        time = 0;
        stage0();
       
        break;
        
        case 3:
            level = 3;
            stage3();
            break;
        case 2:
            level = 2;
            stage2();
            
            break;
        case 1:
            level = 1;
            stage1();
            break;
        case 0:
            level = 0;
            score = 0;
            time = 0;
            background = new GreenfootImage("GameOver.png");
            setBackground(background);
            Greenfoot.delay(50);
            stage0();
            break;
        }
    }

    public int getLife() {
        return life;
    }

    public Persona getPersona() {
        return persona;
    }
    
    public void removeEnergy(Energy e){
        energy.remove(e);
        deadEnergy++;
    }
    
    public boolean existEnergy(){
        return !energy.isEmpty();
    }
    
    
    
    private void drawScoreBoard() {
        Button k;
        k = new Button(2);
        addObject(k, 731, 42);
        Label label;
        label = new Label("0"+level);
        addObject(label, 120, 45);
        sc = new Label("" + score);
        addObject(sc, 262, 45);
        updateEnergy();
        label = new Label("" + life);
        addObject(label, 680, 45);
        tim = new Label("" + time);
        addObject(tim, 540, 45);
    }

    public BoogeyHammer getHammer() {
        return hammer;
    }

    private void stage0() {
        Greenfoot.delay(0);
        background = new GreenfootImage("Home.png");
        setBackground(background);
        dead = false;
        Button b;
        b = new Button();
        addObject(b, 487, 400);
        b = new Button(0);
        addObject(b, 500, 475);
        life = 3;
        score = 0;
    }

    private void stage1() {
        Greenfoot.delay(0);
        background = new GreenfootImage("Background.png");
        time = 20;
        setBackground(background);
        drawBorder();
        drawWall(60, 300, 8, 1, 1);
        drawWall(340, 340, 1, 3, 1);
        drawWall(420, 420, 8, 1, 1);
        drawWall(60, 340, 7, 5, 2);
        drawWall(340, 460, 10, 2, 2);
        drawWall(60, 140, 16, 2, 3);
        drawWall(460, 220, 6, 5, 3);
       MovingObject a;
        a = new Fish(20);
        addObject(a,420,220);
        p = new Portal();
        addObject(p, 380, 420);
        persona = new Persona();
        addObject(persona, 100, 260);
        FallingObject f;
        f = new Energy();
        energy.add((Energy)f);
         i=0;
         for(Energy e:energy)
            i++;
        addObject(f, 180, 260);
        drawScoreBoard();
    }
    
    private void stage2(){
        Greenfoot.delay(0);
        drawBorder();
        time = 40;
        persona = new Persona();
        addObject(persona, 60, 300);
        FallingObject f;
        f = new Energy();
        addObject(f, 300,140);
        FallingObject fa;
        fa = new Stone();
        addObject(fa, 220,140);
         fa = new Stone();
        addObject(fa, 180,140);
         fa = new Stone();
        addObject(fa, 140,140);
        energy.add((Energy)f);
         i=0;
         for(Energy e:energy)
            i++;
        
        drawWall(60, 340, 7, 1, 1);
        drawWall(340,340,1,4,1);
        drawWall(380,460,1,1,1);
        drawWall(420,340,1,4,1);
        drawWall(460, 340, 6, 1, 1);
        drawWall(60,180,8,3,3);
        drawWall(460, 380, 7, 4, 2);
        drawWall(60, 380, 7, 4, 2);
        drawWall(340,500,3,1,2);
        BoogeyHammer a;
        a = new BoogeyHammer(25,"left");
        addObject(a,700,140);
        p = new Portal();
        addObject(p,700, 340);
        Lock l;
        l = new Lock();
        addObject(l, 700, 300);
        Key k;
        k = new Key();
        addObject(k, 60, 140);
        drawScoreBoard();
       
    }
    
    private void stage3(){
        Greenfoot.delay(0);
        drawBorder();
        time = 40;
        persona = new Persona();
        addObject(persona, 60, 300);
        MovingObject a;
        a = new BoogeyHammer(20,"up");
        addObject(a,300,500);
        FallingObject f;
        f = new Energy();
        energy.add((Energy)f);
        addObject(f, 620, 300);
        f = new Energy();
        energy.add((Energy)f);
        addObject(f, 620, 140);
        drawWall(60, 340, 6, 1, 1);
        drawWall(260, 380, 1, 4, 1);
        drawWall(60,140,6,4,2);
        drawWall(340,140,1,10,2);
        drawWall(420, 340, 7, 1,1);
        drawWall(500, 380, 6, 4,1);
        drawWall(420, 180, 7, 2,3);
        Explosive s;
        s = new Explosive();
        addObject(s, 180, 300);
        Portal p;
        p = new Portal();
        addObject(p,700,340);
          i=0;
         for(Energy e:energy)
            i++;
         drawScoreBoard();
    }
    
}
