import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int spiderX;
    int spiderY;
    int Speedtimer = Greenfoot.getRandomNumber(1000) + 200;
    int Shieldtimer = Greenfoot.getRandomNumber(1000) + 500;
    int everySnake = 5;
    /**
     * Constructor for objects of class MyWorld.
     * 
      */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        getBackground().setColor(Color.LIGHT_GRAY);
        getBackground().fill();
        Ant ant = new Ant();
        addObject(ant,getWidth()/2,getHeight()/2);
        Food food = new Food();
        addObject(food,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        Score score = new Score();
        addObject(score,70,20);
        Life life = new Life();
        addObject(life,70,50);
    }
    public void addSpider() {
        everySnake--;
        if (Greenfoot.getRandomNumber(2) == 1) {
            spiderX = 0;
            spiderY = Greenfoot.getRandomNumber(400);
        }
        else {
            spiderX = Greenfoot.getRandomNumber(600);
            spiderY = 0;
        }
        Spider spider = new Spider();
        addObject(new Spider(),spiderX,spiderY);
        if (everySnake<1) {
            Snake snake = new Snake();
            addObject(new Snake(),Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
            everySnake = 5;
        }
    }
    public void GameOver() {
        GameOver gameover = new GameOver();
        addObject(gameover,getWidth()/2,getHeight()/2);
    }
    public void act() {
        Speed speed = new Speed();
        Shield shield = new Shield();
        Speedtimer--;
        Shieldtimer--;
        if (Speedtimer<1) {
            addObject(new Speed(),Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
            Speedtimer = Greenfoot.getRandomNumber(1000) + 200;
        }
        if (Shieldtimer<1) {
            addObject(new Shield(),Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
            Shieldtimer = Greenfoot.getRandomNumber(1000) + 200;
        }
    }
}
