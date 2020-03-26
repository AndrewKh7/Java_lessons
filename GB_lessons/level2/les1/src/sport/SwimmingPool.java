package sport;

public class SwimmingPool implements Obstacle{
    private int distance;

    public SwimmingPool(int distance){
        this.distance = distance;
    }

    @Override
    public void overcomeIt(Sportsman sportsman){
        sportsman.trySwim(this.distance);
    }

}
