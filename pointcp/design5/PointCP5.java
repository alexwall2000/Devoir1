public abstract class PointCP5{
	
	
	//*Instance variables
	/**
	* Contains C(artesian) or P(olar) to identify the type of
	* coordinates that are being dealt with.
	*/

	protected final char typeCoord;

  /**
   * Contains the current value of x or rho depending on the Coordinates type
   */
	protected final double xOrRho;
   
   /**
   * Contains the current value of y or theta depending on the Coordinates type
   */
	protected final double yOrTheta;
   
	public PointCP5(char typeCoord, double xOrRho, double yOrTheta){
	    if(typeCoord != 'C' && typeCoord != 'P'){
			throw new IllegalArgumentException();
		}
		this.typeCoord = typeCoord;
		this.xOrRho = xOrRho;
		this.yOrTheta = yOrTheta;

	}

	
	
	// Instance methods
	
	public abstract double getX();
	
	public abstract double getY();
	
	public abstract double getRho();
	
	public abstract double getTheta();
	
  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */

	public abstract void convertStorageToPolar();
	
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
	
	public abstract void convertStorageToCartesian();


	public abstract String toString();
}