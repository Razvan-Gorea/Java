interface Order {
     public boolean lessThan(Order other);
}

interface Comparable extends Order{
     public int compareTo(Comparable other);
}

public class Point implements Comparable, Order {
    private double x, y;

    public Point(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public boolean lessThan(Order other) {
        Point otherPoint = (Point) other;
        
        if (this.equals(otherPoint)) return false;
        return x <= otherPoint.x && y <= otherPoint.y;
    }

    public int compareTo(Object other) {
        Point otherPoint = (Point) other;
        
        if (this.equals(otherPoint)) return 0;
        if (this.lessThan(otherPoint)) return -1;
        else return 1;
    }

    public boolean equals(Point other){
        Point otherPoint = (Point) other;
        if (x == otherPoint.x && y == otherPoint.y){
            return true;
        } else {
            return false;   
         }
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

     public static void main(String[] args) {
         Comparable P1 = new Point(0, 0);
         Comparable P2 = new Point(1, 1);
         Comparable P3 = new Point(0, 1);

         System.out.println("P1 less than P2: " + P1.compareTo(P2)); // -1
         System.out.println("P1 less than P3: " + P1.compareTo(P3)); // -1
         System.out.println("P2 less than P3: " + P2.compareTo(P3)); // 1
         System.out.println("P3 less than P3: " + P3.compareTo(P3)); // 0
     }
}