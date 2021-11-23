import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Actor
{
    int life = 3;
    /**
     * Act - do whatever the Life wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(new GreenfootImage("Life: " + life, 30, Color.BLACK, Color.LIGHT_GRAY));
    }
    public void deleteLife() {
        life = life-1;
    }
}
