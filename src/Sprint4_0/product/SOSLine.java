package Sprint4_0.product;
import java.awt.Color;

/* 
import java.awt.Color;

public class SOSLine {
    private final Color lineColor;
    private final Coordinate startCoordinate, endCoordinate;

    public SOSLine(Color lineColor, Coordinate startCoordinate, Coordinate endCoordinate) {
        this.lineColor = lineColor;
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
    }

    public Color getLineColor() {
        return lineColor; }

    public Coordinate getStartCoordinate() {
        return startCoordinate; }

    public Coordinate getEndCoordinate() {
        return endCoordinate; }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LineSegment [lineColor=");
        builder.append(lineColor);
        builder.append(", startCoordinate=");
        builder.append(startCoordinate.toString());
        builder.append(", endCoordinate=");
        builder.append(endCoordinate.toString());
        builder.append("]");
        return builder.toString();
    }*/
    public class SOSLine {
    private final Color lineColor;
    private final Coordinate startCoordinate, endCoordinate;

    public SOSLine(Color lineColor, Coordinate startCoordinate, Coordinate endCoordinate) {
        this.lineColor = lineColor;
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public Coordinate getStartCoordinate() {
        return startCoordinate;
    }

    public Coordinate getEndCoordinate() {
        return endCoordinate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LineSegment [lineColor=");
        builder.append(lineColor);
        builder.append(", startCoordinate=");
        builder.append(startCoordinate.toString());
        builder.append(", endCoordinate=");
        builder.append(endCoordinate.toString());
        builder.append("]");
        return builder.toString();
    }
}
