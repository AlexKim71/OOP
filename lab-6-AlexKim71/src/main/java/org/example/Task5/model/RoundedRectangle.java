package org.example.Task5.model;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedRectangle extends DrawShape {

    @Override
    public Shape getShape(Point startPoint, Point endPoint) {
        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);
        return new RoundRectangle2D.Double(
                Math.min(startPoint.x, endPoint.x),
                Math.min(startPoint.y, endPoint.y),
                width,
                height,
                20, 20 // радіус заокруглення
        );
    }
}