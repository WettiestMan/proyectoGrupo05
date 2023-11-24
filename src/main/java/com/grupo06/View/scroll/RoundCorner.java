package com.grupo06.View.scroll;

import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.List;

public class RoundCorner {
    
    public GeneralPath getRoundedGeneralPathFromPoints(List<Point2D> l, float arcSize) {
        GeneralPath path = new GeneralPath();
        Point2D startPoint = calculateArcPoint(l.get(1), l.get(0), arcSize);
        path.moveTo(startPoint.getX(), startPoint.getY());
        for (int index = 0; index < l.size(); index++) {
            Point2D p1 = l.get(index);
            Point2D p2 = l.get((index + 1) % l.size());
            Point2D p3 = l.get((index + 2) % l.size());
            Point2D mPoint = calculateArcPoint(p1, p2, arcSize);
            path.lineTo(mPoint.getX(), mPoint.getY());
            mPoint = calculateArcPoint(p3, p2, arcSize);
            path.curveTo(p2.getX(), p2.getY(), p2.getX(), p2.getY(), mPoint.getX(), mPoint.getY());
        }
        return path;
    }

    private Point2D calculateArcPoint(Point2D p1, Point2D p2, float arcSize) {
        
        double width = p1.getX()-p2.getX();
        double height = p1.getY()-p2.getY();
        
        double distance = Math.hypot(width , height);
        
        double per = arcSize / distance;
        
        double d_x = width * per;
        double d_y = height * per;
        
        return new Point.Double(p2.getX() + d_x, p2.getY() + d_y);
        
    }
}
