package sport;

public class Cross implements Obstacle{
    private int distance;

    public Cross(int distance){
        this.distance = distance;
    }

    @Override
    public void overcomeIt(Sportsman sportsman){
        sportsman.tryRun(this.distance);
    }
}
