package sport;

public class Wall implements Obstacle{
    private int  height;

    public Wall(int height){
        this.height = height;
    }

    @Override
    public void overcomeIt(Sportsman sportsman){
        sportsman.tryJump(this.height);
    }
}
