

public class PointCP2
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
  private double rho;
  
  /**
   * Contains the current value of THETA 
   */
  private double theta;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCP2(char type, double xorRho, double yorTheta)
  {
    if(type != 'C' && type != 'P'){
      throw new IllegalArgumentException();
    }
	else if(type == 'P'){
		rho = xorRho;
		theta = yorTheta;
		typeCoord = 'P';
	}
	else if(type == 'C'){
		rho = Math.sqrt(Math.pow(xorRho, 2) + Math.pow(yorTheta, 2));
		theta = Math.toDegrees(Math.atan2(yorTheta, xorRho));
		typeCoord = 'C';
	}
	

  }
	
  
  //Instance methods **************************************************
 
 
  public double getX()
  {  
    return (Math.cos(Math.toRadians(theta)) * rho);
  }
  
  public double getY()
  {  
    return (Math.sin(Math.toRadians(theta)) * rho);
  }
  
  public double getrho()
  {
    return rho;
  }
  
  public double getTheta()
  {
    return theta; 
  }
  
	
  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToPolar()
  {
	typeCoord = 'P';
  }
	
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public void convertStorageToCartesian()
  {
    typeCoord = 'C';	
  }

  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP2 pointB)
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
  public PointCP2 rotatePoint(double rotation)
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
	if (typeCoord == 'P'){
		return "Polar coordinates are" + "[" + getrho() + "," + getTheta() + "]";
	}
	else{
		return "Cartesian coordinates are" + "[" + getX() + "," + getY() + "]";
	}
  }
}
