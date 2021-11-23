interface IShape2D {
    String getStyle();
    double area();
    String showDim();
}

abstract class Shape2D implements IShape2D {
    private double width;
    private double height;
    private String name;
    private double k;
    private double density;

    public Shape2D(String name, double height, double width, double k, double density) {
        this.height = height;
        this.width = width;
        this.name = name;
        this.k = k;
        this.density = density;
    }
    public Shape2D() {
        this.height = 1;
        this.width = 1;
        this.name = "Unnamed";
        this.k = 1;
        this.density = 1;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getDensity() {
        return density;
    }
    public void setDensity(double density) {
        this.density = density;
    }
    public double getK() {
        return k;
    }
    public void setK(double k) {
        this.k = k;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    abstract public double area();
    abstract public double getVolume();
    abstract public double getWeight();
    public void showData(){
        System.out.println("Имя: " + name + showDim() + " Плотность: " + density + " Коэффициент: " + getK());
    };
    @Override
    public String showDim() {
        {
            return " Ширина: " + width + " Высота: " + height;
        }
    }
    public void showCalculations(){
        System.out.println(" Объем: " + getVolume() + " Вес: " + getWeight());
    }
    public String compare() {
        if (height!=width) return "Ширина и высота не равны!"; else return "Ширина и высота равны!";
    }


}

class Triangle extends Shape2D {
    public Triangle(String name, double height, double width, double k, double density) {
        super(name, height, width, k, density);
    }
    public Triangle() {
        super();
    }

    @Override
    public String getStyle() {
        return getWidth()==getHeight()?"Равнобедренный треугольник":"Неравнобедренный треугольник";
    }
    @Override
    public double area() {
        return 0.5*getHeight()*getWidth();
    }
    public double getVolume(){
        return getWidth()*getHeight()*getK();
    }
    public double getWeight() {
        return getDensity()*getVolume();
    }


}


class Rectangle extends Shape2D {
    public Rectangle(String name, double height, double width, double k, double density) {
        super(name, height, width, k, density);
    }
    public Rectangle() {
        super();
    }

    @Override
    public String getStyle() {
        return getWidth()==getHeight()?"Квадрат":"Прямоугольник";
    }
    @Override
    public double area() {
        return getHeight()*getWidth();
    }
    public double getVolume(){
        return getWidth()*getHeight()*getK();
    }
    public double getWeight() {
        return getDensity()*getVolume();
    }


}


public class Khannanova {
    static void showShapesData(Shape2D Shape2D){
        System.out.println("Объект: " + Shape2D.getStyle() +
                "\n Габариты: \n" + Shape2D.showDim() +
                "\n Площадь: " + Shape2D.area());
    }
    public static void main(String[] args){
        Shape2D rect = new Rectangle();
        showShapesData(rect);
        rect.setName("rect");
        rect.setHeight(6.);
        rect.setWidth(3.);
        rect.setDensity(3.9);
        rect.setK(1.15);
        showShapesData(rect);
        rect.showData();
        rect.showCalculations();

        Shape2D tri = new Triangle("triangle", 10., 7., 1.05, 1.5);
        showShapesData(tri);
        tri.showData();
        tri.showCalculations();
    }
}