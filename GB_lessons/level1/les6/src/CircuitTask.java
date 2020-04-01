import java.util.Scanner;

public class CircuitTask {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите координаты x y, а также радиус для первого круга:");
        Circuit circuit1 = new Circuit(readDouble(), readDouble(), scanner.nextDouble());
        System.out.println("Введите коорординаты x y и радиус для второй окружности:");
        Point center2 = new Point(readDouble(),readDouble());
        Circuit circuit2 = new Circuit(center2, scanner.nextDouble());

        if( circuit1.area() == circuit2.area())
            System.out.println("Areas are equal ");
        else
            System.out.println("Area are not qeual");

        if ( distanse(circuit1.getCenter(), circuit2.getCenter()) < circuit1.getRad() + circuit2.getRad())
            System.out.println("circles intersect");
        else
            System.out.println("circles not intersect");
    }

    public static double distanse(Point point1, Point point2){
        return Math.sqrt(point1.x*point1.x + point2.y*point2.y);
    }

    public static double readDouble(){
        return scanner.nextDouble();
    }
}



class Point{
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Circuit {
    private Point center;
    private double rad;
    private double pi = 3.14;

    public Circuit(double center_x, double center_y, double rad){
        this.center = new Point(center_x, center_y);
        if (rad >= 0)
            this.rad = rad;
        else
            this.rad = 0;
    }
    public Circuit(Point center, double rad) {
        this.center = center;
        if (rad >= 0)
            this.rad = rad;
        else
            this.rad = 0;
    }
    public double area(){
        return this.pi * this.rad * this.rad;
    }

    public Point getCenter() {
        return center;
    }


    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRad(double rad) {
        if (rad >= 0)
            this.rad = rad;
        else
            this.rad = 0;
    }

    public double getRad() {
        return rad;
    }

    public double getPi() {
        return pi;
    }
}