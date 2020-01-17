public class CatMainClass {
    public static void main(String[] args){
        Cat[] cats = new Cat[100];
        Palet palet = new Palet(1000);
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Bars", 10, 150);
        }

        for (Cat cat: cats) {

            System.out.print(palet.getFood() + " ");
            if ( !cat.getSatiety() && !cat.eat(palet)  )  //Если кот голодный и ему не удалось поесть
                palet.setFood(1000); //положить новой еды
            System.out.println(cat.getSatiety());

        }
    }
}


class Cat{
    String name;
    private int age;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int age, int appetite) {
        this.age = age>=0 ? age: 0;
        this.appetite =  appetite > 0 ? appetite : 1;
        this.name = name;
    }

    public boolean getSatiety(){
        return this.satiety;
    }

    public boolean eat( Palet palet){
        if (palet.decreaseFood( this.appetite) ){
            this.appetite = 0;
            this.satiety = true;
            return true;
        }else{
            this.satiety = false;
            return false;
        }
    }
}

class Palet{
    private int food;
    public Palet(int food){
        this.food = food >= 0 ? food : 0;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food >= 0 ? food : 0;
    }

    public boolean decreaseFood(int requested_food){
        if ( requested_food <= this.food) {
            this.food -= requested_food;
            return true;
        }else {
            return false;
        }
    }
}


