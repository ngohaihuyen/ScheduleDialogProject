package com.example.projectexample.triangle;

public class CalculateManager {
    private float ab, bc, ca;
    private PointItem aPoint, bPoint, cPoint;

    public CalculateManager() {
    }

    public void setAPoint(PointItem aPoint) {
        this.aPoint = aPoint;
    }

    public void setBPoint(PointItem bPoint) {
        this.bPoint = bPoint;
    }

    public void setCPoint(PointItem cPoint) {
        this.cPoint = cPoint;
    }

    public void calculateAllLines(){
        ab = calculateLineRange(aPoint, bPoint);
        bc = calculateLineRange(bPoint, cPoint);
        ca = calculateLineRange(cPoint, aPoint);
    }

    public float calculateArea() {
        float s = (ab + bc + ca) / 2;
        float area = (float) Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));
        return area;
    }

    public float calculatePerimeter() {
        float perimeter = ab + bc + ca;
        return perimeter;
    }

    private float calculateLineRange(PointItem from, PointItem to) {
        float deltaX = to.getX() - from.getX();
        float deltaY = to.getY() - from.getY();

        float lineRange = (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return lineRange;
    }
}