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
       Dog[] dogs = new Dog[10];
        for (int i = 0; i < dogs.length; i++) {
            dogs[i] = new Dog();
            System.out.println("DOG - " + i);
            System.out.println(dogs[i].getInfo());
            dogs[i].jump(0.5f);
            dogs[i].run(500);
            dogs[i].swim(10);
        }
        System.out.println("_________________________________________\n");
        System.out.println((dogs.length + cats.length) + " sports animals are ready, another 100500 is on the way!");
    }
}

abstract class SportAnimal{
    static Random rand = new Random();
    protected float run_distance;
    protected float swim_distance;
    protected float jump_height;

    public SportAnimal(float run_distance, float swim_distance, float jump_height) {
        this.run_distance = run_distance + run_distance * (rand.nextInt(40) - 20)/100;
        this.swim_distance = swim_distance + swim_distance * (rand.nextInt(40) - 20)/100;
        this.jump_height = jump_height + jump_height * (rand.nextInt(40) - 20)/100;
    }

    void run(float distance) {
        if (distance <= this.run_distance)
            printResultAction("run", true);
        else
            printResultAction("run", false);
    }

    void swim(float distance) {
        if (distance <= this.swim_distance)
            printResultAction("swim", true);
        else
            printResultAction("swim", false);

    }

    void jump(float height) {
        if (height <= this.jump_height)
            printResultAction("swim", true);
        else
            printResultAction("swim", false);

    }

    abstract String getInfo();

    void printResultAction(String action, boolean res){
        System.out.println("рузельтат: " + action + ": " + res);
    }

}


class Cat extends SportAnimal{

    Cat(){
        super(200,0,2);
    }

    @Override
    void swim(float distance) {
        System.out.println("I cant't ");
    }

    @Override
    String getInfo() {
        StringBuffer strbuf = new StringBuffer();
        return strbuf.append("jump: ").append(this.jump_height).append(" run: ").append(this.run_distance).toString();
    }
}

class Dog extends SportAnimal{

    Dog(){
        super(500,10,0.5f);
    }

    @Override
    String getInfo() {
        StringBuffer strbuf = new StringBuffer();
        return strbuf.append("jump: ").append(this.jump_height).append(" run: ").append(this.run_distance).append(" swim:").append(this.swim_distance).toString();
    }
}