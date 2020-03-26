package sport;

public class Human implements Sportsman{

    private boolean active = true;
    private int maxRunDistance;
    private int maxSwimDistance;
    private int maxJumpHeight;
    private String name;

    public Human( int maxRunDistance, int maxSwimDistance, int maxJumpHeight, String name) {
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.name = name;
    }

    @Override
    public void tryJump(int height){
        if(height < this.maxJumpHeight)
            System.out.println(this.name + " справился с прыжком через препятствие!");
        else {
            System.out.println(this.name + " не справился с прыжком через препятствие! ");
            this.active = false;
        }
    }

    @Override
    public void tryRun(int distance){
        if(distance < this.maxRunDistance)
            System.out.println(this.name + " справился с забегом!");
        else {
            System.out.println(this.name + " не справился с забегом! ");
            this.active = false;
        }
    }

    @Override
    public void trySwim(int distance) {
        if(distance < this.maxSwimDistance)
            System.out.println(this.name + " справился с заплывом!");
        else{
            System.out.println(this.name + " не справился с заплывом! ");
            this.active = false;
        }
    }

    @Override
    public boolean isActive(){
        return this.active;
    }

    @Override
    public void info(){
        if(this.active)
            System.out.println(this.name + " преодолел все препятствия!");
        else
            System.out.println(this.name + " сошел с дистанции");
    }
}
