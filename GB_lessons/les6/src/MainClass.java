import javax.sound.midi.Soundbank;
import java.awt.geom.Arc2D;
import java.util.Random;

public class MainClass {
    public static void main(String[] args){
       Cat[] cats = new Cat[10];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat();
            System.out.println("CAT - " + i);
            System.out.println(cats[i].getInfo());
            cats[i].jump(2);
            cats[i].run(200);
            cats[i].swim(10);
        }

        System.out.println("-----------------------------------------");
       Dog[] dogs = new Dog[5];
        for (int i = 0; i < dogs.length; i++) {
            dogs[i] = new Dog();
            System.out.println("DOG - " + i);
            System.out.println(dogs[i].getInfo());
            dogs[i].jump(0.5f);
            dogs[i].run(500);
            dogs[i].swim(10);
        }
    }
}

abstract class Animal{
    static Random rand = new Random();

    abstract void run(float distance);
    abstract void swim(float distance);
    abstract void jump(float height);
    abstract String getInfo();

    void printResultAction(String action, boolean res){
        System.out.println("рузельтат: " + action + ": " + res);
    }

    void tryAction(float param, float max_val){
        if (param <= max_val)
            printResultAction("run", true);
        else
            printResultAction("run", false);
    }
}

class Cat extends Animal{
    private float run_distance;
    private float jump_height;

    Cat(){
        this.jump_height = 2 + 2*(rand.nextInt(40) - 20)/100;
        this.run_distance = 200 + 200*(rand.nextInt(40)-20)/100 ;
    }
    @Override
    void run(float distance) {
        super.tryAction(distance, this.run_distance);
    }

    @Override
    void swim(float distance) {
        System.out.println("I can't !");
    }

    @Override
    void jump(float height) {
        super.tryAction(height, this.jump_height);
    }

    @Override
    String getInfo() {
        StringBuffer strbuf = new StringBuffer();
        return strbuf.append("jump: ").append(this.jump_height).append(" run: ").append(this.run_distance).toString();
    }
}

class Dog extends Animal{
    private float run_distance;
    private float swim_distance;
    private float jump_height;

    Dog(){
        this.jump_height = 0.5f + 0.5f * (rand.nextInt(40) - 20)/100;
        this.run_distance = 500 + 500 *  (rand.nextInt(40) - 20)/100;
        this.swim_distance =  10 + 10 *  (rand.nextInt(40) - 20)/100;
    }

    @Override
    void run(float distance) {
        super.tryAction(distance, this.run_distance);
    }

    @Override
    void swim(float distance) {
       super.tryAction(distance, this.swim_distance);
    }

    @Override
    void jump(float height) {
        super.tryAction(height, this.swim_distance);
    }

    @Override
    String getInfo() {
        StringBuffer strbuf = new StringBuffer();
        return strbuf.append("jump: ").append(this.jump_height).append(" run: ").append(this.run_distance).append(" swim:").append(this.swim_distance).toString();
    }
}