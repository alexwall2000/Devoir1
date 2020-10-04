public class PointCP4 {

    private char typeCoord;
    private double x;
    private double y;
    private double rho;
    private double theta;

    public PointCP4(char type, double xOrRho, double yOrTheta) {
        if (type != 'C' && type != 'P') {
            throw new IllegalArgumentException();
        }
        if(type == 'P') {
            rho = xOrRho;
            theta = yOrTheta;
            x = (Math.cos(Math.toRadians(theta)) * rho);
            y = (Math.sin(Math.toRadians(theta)) * rho);
        }else {
            x = xOrRho;
            y = yOrTheta;
            rho = (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
            theta = Math.toDegrees(Math.atan2(y, x));
        }
        typeCoord = type;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRho() {
        return rho;
    }

    public double getTheta() {
        return theta;
    }

    /**
     * Calculates the distance in between two points using the Pythagorean
     * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
     *
     * @param pointA The first point.
     * @param pointB The second point.
     * @return The distance between the two points.
     */
    public double getDistance(PointCP4 pointB) {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    /**
     * Rotates the specified point by the specified number of degrees.
     * Not required until E2.30
     *
     * @param point    The point to rotate
     * @param rotation The number of degrees to rotate the point.
     * @return The rotated image of the original point.
     */
    public PointCP4 rotatePoint(double rotation) {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP4('C',
                (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
                (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */
    public String toString()
    {
        return "Stored as " + (typeCoord == 'C'
                ? "Cartesian  (" + getX() + "," + getY() + ")"
                : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
    }

    public void convertStorageToCartesian() {
        typeCoord = 'C';	//Change coord type identifier
    }

    public void convertStorageToPolar() {
        typeCoord = 'P';	//Change coord type identifier
    }
}