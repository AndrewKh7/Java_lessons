package sport;

public class Main {
    public static void main(String[] args) {
        ObstacleCourse course = new ObstacleCourse(new Wall(1), new Wall(2),
                new SwimmingPool(500), new Cross(4000),new SwimmingPool(200), new Wall(3));

        Team team = new Team("BestTeam",
                new Human(6000,600,4,"Josh"),
                new Human(4500,100,5,"Bob"),
                new Human(4000,500,3,"Jon"),
                new Human(3000,150,2,"LOX")
                );

        course.start(team);
        System.out.println("---------------------------------------------------");
        team.successfulSportsmansInfo();
        System.out.println("---------------------------------------------------");
        team.teamSportsmanInfo();

    }
}
