import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExplodableObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class ExplodableObject extends Actor
{
    private ExplodeState currentExplodeState;
    private GreenfootImage[] explodingImage;
    private int imageIndex;
    
    public ExplodableObject()
    {
        currentExplodeState = ExplodeState.NOT_EXPLODED;
        explodingImage = new GreenfootImage[16];
        for(int index = 0; index < explodingImage.length; index++){
            explodingImage[index] = new GreenfootImage("explode"+index+".png");
        }
        imageIndex = 0;
    }
    
    public void explode(){
        currentExplodeState = ExplodeState.EXPLODING;
        imageIndex = 0;
    }
    
    /**
     * Act - do whatever the ExplodableObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    
        if (currentExplodeState == ExplodeState.EXPLODING){
            setImage(explodingImage[imageIndex]);
            imageIndex++;
            if (imageIndex >= explodingImage.length){
                currentExplodeState = ExplodeState.EXPLODED;
                World myWorld = getWorld();
                myWorld.removeObject(this);
            }
        }
    }
}
