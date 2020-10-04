

public class PointCP2 extends PointCP5
{
  //Instance variables ************************************************
  /**
   * Contains C(artesian) or P(olar) to identify the type of
   * coordinates that are being dealt with.
   */
  private char typeCoord;

  /**
   * Contains the current value of rho
   */
  private double xOrRho;

  /**
   * Contains the current value of THETA
   */
  private double yOrTheta;


  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCP2(char typeCoord, double xOrRho, double yOrTheta)
  {
    super(typeCoord, xOrRho, yOrTheta);

  if (typeCoord == 'P'){
    this.typeCoord = 'P';
    this.xOrRho = xOrRho;
    this.yOrTheta = yOrTheta;
  }else{
    double temp = Math.cos(Math.toRadians(yOrTheta)) * xOrRho;
    this.yOrTheta = (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
    this.xOrRho = temp;
    this.typeCoord = 'P';
  }


	}





  //Instance methods **************************************************


  public double getX()
  {
    return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
  }

  public double getY()
  {
    return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
  }

  public double getRho()
  {
    return xOrRho;
  }

  public double getTheta()
  {
    return yOrTheta;
  }


  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToPolar()
  {
  }

  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public void convertStorageToCartesian()
  {
  }

  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP5 pointB)
  {
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
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP5 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();

    return new PointCP2('C',
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
		return "Polar coordinates are stored as" + "[" + getRho() + "," + getTheta() + "]";

  }
}
