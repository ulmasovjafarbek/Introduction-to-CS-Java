/**PROBLEM DESCRIPTION: Write a program that prints out the multiple properties of the two rectangles in the following format for Rectangles A and B at coordinates {1, 2, 3, 4} and {5, -2, 4, 1}:
 *      A : Rectangle 3.0x4.0 centered at (1.0, 2.0).   perimeter = 14.0, area = 12.0
        B : Rectangle 4.0x1.0 centered at (5.0, -2.0).   perimeter = 10.0, area = 4.0
        A contains B: false
        B contains A: false
        A intersects B: false
        B intersects A: false
 * 
 */
public class Rectangle
{

    private final double x, y;    // center of rectangle
    private final double width;   // width of rectangle
    private final double height;  // height of rectangle
    
    public Rectangle(double x2, double y2, double w, double h) {
         x = x2;
         y = y2;
         width = w;
         height = h;
    }
    public double area() {
	    return width*height;
    }
    public double perimeter() {
	    return (2 * width) + (2 * height);
    }
    public boolean intersects(Rectangle b) {
        double l1x = x - (width/2);
        double l1y = y + (height/2);
        double r1x = x + (width/2);
        double r1y = y - (height/2);
        double l2x = b.x - (b.width/2);
        double l2y = b.y + (b.height/2);
        double r2x = b.x + (b.width/2);
        double r2y = b.y - (b.height/2);
        if (l1x >= r2x || l2x >= r1x) {
            return false; }
        if (l1y <= r2y || l2y <= r1y) {
            return false; }
        return true;
    }

    public boolean contains(Rectangle b) {
	    double l1x = x - (width/2);
	    double l1y = y + (height/2);
	    double r1x = x + (width/2);
	    double r1y = y - (height/2);
	    double l2x = b.x - (b.width/2);
	    double l2y = b.y + (b.height/2);
	    double r2x = b.x + (b.width/2);
	    double r2y = b.y - (b.height/2);

	    if (l2x >= l1x && l2y <= l1y && r2x <= r1x && r2y >= r1y) return true;
	    return false;
    }
    public String toString() {
        return "Rectangle "+ width + "x"+ height + " centered at (" + x + ", " + y + ").";
    }
        
    public String infoString() {
        return "   perimeter = " + perimeter() + ", area = " + area();
    }

    public static Rectangle CreateRectangleFromStdin(){
        double x = StdIn.readDouble();
        double y = StdIn.readDouble();
        double w = StdIn.readDouble();
        double h = StdIn.readDouble();
        return new Rectangle(x,y,w,h);
    }
    
    public static void main(String[] args)
    {
        Rectangle A =  CreateRectangleFromStdin();
        Rectangle B =  CreateRectangleFromStdin();
        System.out.println("A : " + A + A.infoString());
        System.out.println("B : " + B + B.infoString());
        
        System.out.println("A contains B: " + A.contains(B));
        System.out.println("B contains A: " + B.contains(A));
        
        System.out.println("A intersects B: " + A.intersects(B));
        System.out.println("B intersects A: " + B.intersects(A));
    }
}
