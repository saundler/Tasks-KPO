/**
 * Задание 1: Объявите классы Circle и Square – наследников базового (Point).
 * Реализуйте readonly свойство, вычисляющее площадь каждой фигуры, а также функцию display()
 * для вывода информации о фигуре на экран.
 *
 * (3 балла)
 */
public class ClassTasks {

    static class Point {
        final double X;
        final double Y;
        final double area = 0.0;

        public Point(double X, double Y) {
            this.X = X;
            this.Y = Y;
        }

        void display() {
            String message = String.format("S = %1$f, X = %2$f, Y = %3$f", area, X, Y);
            System.out.println(message);
        }
    }

    static class Circle extends Point {
        final double radius;
        private final double area;

        public Circle(double X, double Y, double radius) {
            super(X, Y);
            this.radius = radius;
            area = Math.PI * radius * radius;
        }
        public double getArea() {
            return area;
        }
        @Override
        void display() {
            String message = String.format("S = %1$f, X = %2$f, Y = %3$f, Radius = %4$f", area, X, Y, radius);
            System.out.println(message);
        }
    }

    static class Square extends Point {
        final double side;
        private final double area;

        public Square(double X, double Y, double side) {
            super(X, Y);
            this.side = side;
            area = side * side;
        }
        public double getArea() {
            return area;
        }
        @Override
        void display() {
            String message = String.format("S = %1$f, X = %2$f, Y = %3$f, Side = %4$f", area, X, Y, side);
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
         Point p = new Point(34, 56);
         Circle c = new Circle(46, 34, 7);
         Square s = new Square(46, 34, 8);
         p.display();
         c.display();
         s.display();
    }
}
