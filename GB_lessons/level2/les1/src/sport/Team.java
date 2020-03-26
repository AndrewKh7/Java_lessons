package sport;

public class Team {
    private Sportsman[] teammates;
    private String teamName;

    public Team(String name, Sportsman sportsman1, Sportsman sportsman2, Sportsman sportsman3, Sportsman sportsman4){
        this.teamName = name;
        this.teammates = new Sportsman[4];
        this.teammates[0] = sportsman1;
        this.teammates[1] = sportsman2;
        this.teammates[2] = sportsman3;
        this.teammates[3] = sportsman4;
    }

    public void successfulSportsmansInfo(){
        for(Sportsman sp: this.teammates){
            if(sp.isActive())
                sp.info();
        }
    }

    public Sportsman[] getTeammates() {
        return teammates;
    }

    public void teamSportsmanInfo(){
        for (Sportsman sp: this.teammates){
            sp.info();
        }
    }
}
