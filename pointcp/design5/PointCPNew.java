import java.io.*;
import java.util.Random;
public class PointCPNew {
  public static void main(String[] args){
  long start = System.currentTimeMillis();
  char type;
  PointCP5 point;
  for (int i = 0; i<20000000; i++){
    int xOrRho = new Random().nextInt(360);
    int yOrTheta = new Random().nextInt(360);
    if (new Random().nextInt(1) == 1){
      point = new PointCP3('C', xOrRho, yOrTheta);
    }else{
      point = new PointCP2('P', xOrRho, yOrTheta);
    }


    point.getX();
    point.getY();
    point.getRho();
    point.getTheta();
    point.convertStorageToCartesian();
    point.convertStorageToPolar();
    point.getDistance(point);
    point.rotatePoint(new Random().nextInt(90));


  }
  System.out.println(System.currentTimeMillis() - start);
  }
}
