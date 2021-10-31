import javax.swing.*;
import java.util.*;
import java.awt.*;

class Main extends AnimatedGraphicsObject{
  // I found this give "nice" height and width
  // SRC: https://hexagoncalculator.apphb.com/
  public static final int MULTIPLIER = 4;
  public static final int SIDE_LENGTH = 17 * MULTIPLIER;
  public static final double SIDE_SIDE_LENGTH = 29.5 * MULTIPLIER;
  public static final int PERIMETER = 102 * MULTIPLIER;
  public static final int AREA = 750 * MULTIPLIER;
  public static final int VERTEX_VERTEX_LENGTH = 34 * MULTIPLIER;
  public static final int X_OFFSET = 15 * MULTIPLIER;
  public static final int Y_OFFSET = 8 * MULTIPLIER;
  protected Point center;

  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  /**
   * Given two points, returns the midpoint
   * 
   * @param p1 The first point of the line to calculate midpoint
   * @param p2 The second point of the line to calculate midpoint
   * @return the midpoint beween p1 and p2
   */
  private Point midPoint(Point p1, Point p2) {
    return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
  }

  /**
   * Adds points to p to create a hexagon in this shape
   * / \ 
   * | |
   * \ /
   */
  private void completeHex() {
    // Init points in array, so they can be used again
    pts[0] = new Point(center.x, center.y + SIDE_LENGTH);
    pts[1] = new Point(center.x + X_OFFSET, center.y + Y_OFFSET);
    pts[2] = new Point(center.x + X_OFFSET, center.y - Y_OFFSET);
    pts[3] = new Point(center.x, center.y - SIDE_LENGTH);
    pts[4] = new Point(center.x - X_OFFSET, center.y - Y_OFFSET);
    pts[5] = new Point(center.x - X_OFFSET, center.y + Y_OFFSET);

    p.addPoint(pts[0].x, pts[0].y);

    p.addPoint(pts[1].x, pts[1].y);

    p.addPoint(pts[2].x, pts[2].y);
    p.addPoint(pts[3].x, pts[3].y);

    p.addPoint(pts[4].x, pts[4].y);
    p.addPoint(pts[5].x, pts[5].y);
  }

  public HexTiles(JComponent container, Point center){
        super(container);
        this.container = container;
        p = new Polygon();
        this.center=center;

        //Outsource completing the polygon to make it a hexagon
        completeHex();
    }

     @Override
    public void paint(Graphics g){
        if(this == null){
            //do nothing
        }
        else{
            //Outline the polygon in black
            g.setColor(Color.BLACK);

            //Draw the polygon outline
            g.drawPolygon(p);
        }
    }
    @Override
    public void run(){

    }

}
