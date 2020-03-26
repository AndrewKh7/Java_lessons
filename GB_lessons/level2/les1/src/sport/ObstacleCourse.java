package sport;

public class ObstacleCourse {
    Obstacle[] obstacles;

    public ObstacleCourse(Obstacle ...obstacles){
        this.obstacles = new Obstacle[obstacles.length];
        System.arraycopy(obstacles, 0, this.obstacles, 0, obstacles.length);
    }

    public void start(Team team){
        for (Sportsman sp: team.getTeammates()){
            for (Obstacle ob: this.obstacles){
                ob.overcomeIt(sp);
            }
        }
    }
}
