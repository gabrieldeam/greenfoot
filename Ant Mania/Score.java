import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    int score = 0;
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setImage(new GreenfootImage("Score: " + score, 30, Color.BLACK, Color.LIGHT_GRAY));
    }
    public void addScore() {
        score = score+15;
    }
    public void GameOver() {
        setLocation(300,240);
    }
}
