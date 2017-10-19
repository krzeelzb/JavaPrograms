public class Punkt2D {
    private double x,y;

    public Punkt2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Punkt2D point){
        return Math.sqrt((point.getX()*point.getX())+(point.getY()*point.getY()));
    }
}
