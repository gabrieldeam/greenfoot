import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ant extends Actor
{
    int Speedtimer = 240;
    int Shieldtimer = 240;
    int speed = 3;
    boolean shieldOn = false;
    /**
     * Act - do whatever the Ant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("D")) {
            setLocation(getX()+speed,getY());
            setRotation(0);
        }
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("A")) {
            setLocation(getX()+speed*-1,getY());
            setRotation(180);
        }
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("W")) {
            setLocation(getX(),getY()+speed*-1);
            setRotation(-90);
        }
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("S")) {
            setLocation(getX(),getY()+speed);
            setRotation(90);
        }
        if (isTouching(Food.class)) {
            getWorld().getObjects(Food.class).get(0).eatFood();
            ((MyWorld)getWorld()).addSpider();
            getWorld().getObjects(Score.class).get(0).addScore();
        }
        if (isTouching(Speed.class)) {
            removeTouching(Speed.class);
            Speedtimer=180;
            speed = 4;
        }
        if (isTouching(Shield.class)) {
            removeTouching(Shield.class);
            Shieldtimer=180;
            shieldOn = true;
        }
        if (isTouching(Spider.class) || isTouching(Snake.class)) {
            if (shieldOn == false) {
                ((MyWorld)getWorld()).GameOver();
                getWorld().getObjects(Score.class).get(0).GameOver();
                Greenfoot.stop();
            }
        }
        if (speed==4) {
            Speedtimer--;
            if (Speedtimer<1) {
                speed=3;
            }
        }
        if (shieldOn==true) {
            Shieldtimer--;
            if (Shieldtimer<1) {
                shieldOn = false;
            }
        }
    }
}
