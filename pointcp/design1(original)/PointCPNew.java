import java.io.*;
import java.util.Random;
public class PointCPNew {
  public static void main(String[] args){
  long start = System.currentTimeMillis();
  char type;
  for (int i = 0; i<20000000; i++){
    int xOrRho = new Random().nextInt(360);
    int yOrTheta = new Random().nextInt(360);
    if (new Random().nextInt(1) == 1){
      type = 'P';
    }else{
      type = 'C';
    }
    PointCP point = new PointCP(type, xOrRho, yOrTheta);

    point.getX();
    point.getY();
    point.getRho();
    point.getTheta();
    point.convertStorageToPolar();
    point.convertStorageToCartesian();
    point.getDistance(point);
    point.rotatePoint(new Random().nextInt(90));


  }
  System.out.println(System.currentTimeMillis() - start);
  }
}
