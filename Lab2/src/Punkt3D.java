public class Punkt3D extends Punkt2D {
    private double x,y,z;
    public Punkt3D(double x, double y, double z) {
        super(x, y);
        this.z=z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = x;
    }

    public double distance(Punkt3D point){
        return Math.sqrt((point.getX()*point.getX())+(point.getY()*point.getY())+(point.getZ()*point.getY()));
    }
}