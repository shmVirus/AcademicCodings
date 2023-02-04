public class Task__04__Geometry {
   public static void main(String[] args) {

      Circle circleObject = new Circle(1);
      System.out.println("A circle " + circleObject.toString());
      System.out.println("The color is " + circleObject.getColor());
      System.out.println("The radius is " + circleObject.getRadius());
      System.out.println("The area is " + circleObject.getArea());
      System.out.println("The diameter is " + circleObject.getDiameter()+"\n");

      Rectangle rectangleObject = new Rectangle(2, 4);
      System.out.println("A rectangle " + rectangleObject.toString());
      System.out.println("The area is " + rectangleObject.getArea());
      System.out.println("The perimeter is " + rectangleObject.getPerimeter());
   }
}

class GeometricObject {

   private String color = "white";
   private boolean filled = false;
   private java.util.Date dateCreated;

   public GeometricObject() {
      dateCreated = new java.util.Date();
   }

   public GeometricObject(String color, boolean filled) {
      //dateCreated = new java.util.Date();
      this.color = color;
      this.filled = filled;
   }

   public String getColor() {
      return color;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public boolean isFilled() {
      return filled;
   }

   public void setFilled(boolean filled) {
      this.filled = filled;
   }

   public java.util.Date getDateCreated() {
      return dateCreated;
   }

   @Override
   public String toString() {
      return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
   }
}

class Circle extends GeometricObject {
   private double radius;

   public Circle() {

   }

   public Circle(double radius) {
      this.radius = radius;
   }

   public Circle(double radius, String color, boolean filled) {
      this.radius = radius;
      setColor(color);
      setFilled(filled);
   }

   public double getRadius() {
      return radius;
   }

   public void setRadius(double radius) {
      this.radius = radius;
   }

   public double getArea() {
      return radius * radius * 3.14159;
   }

   public double getPerimeter() {
      return 2 * radius * 3.14159;
   }

   public double getDiameter() {
      return 2 * radius;
   }

   public void printCircle() {
      System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
   }
}

class Rectangle extends GeometricObject {
   private double width;
   private double height;

   public Rectangle() {

   }

   public Rectangle(double width, double height) {
      this.width = width;
      this.height = height;
   }

   public Rectangle(double width, double height, String color, boolean filled) {
      this.width = width;
      this.height = height;
      setColor(color);
      setFilled(filled);
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

   public void setHeight(double hight) {
      this.height = height;
   }

   public double getArea() {
      return width * height;
   }

   public double getPerimeter() {
      return 2 * (width + height);
   }
}