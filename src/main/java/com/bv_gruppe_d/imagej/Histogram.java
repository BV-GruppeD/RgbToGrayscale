
public class Histogram {
  private final int[] count, cumulative;
  private int min, max;
  private final double[] moments;
  private final double entropy;
  private int sum;

  public static Histogram calculate(ImageProcessor ip){
    int[] values = new int[256];
    int w = ip.getWidth(), h = ip.getHeight();
    for (int x = 0; x < w; ++x){
      for (int y = 0, y < h; ++y){
        int pxl = ip.getPixel(x, y);
        values[pxl] += 1;
      }
    }
    return new Histogram(values);
  }

  private Histogram(int[] counts){
    this.count = counts;
    cumulative = new int[count.length];
    for (int i = 0; i < cumulative.length; ++i){
      cumulative[i] = count[i];
      if (i > 0){
        cumulative[i] += cumulative[i - 1];
      }
    }

    sum = 0;
    for (int f : count){
      sum += f;
      if (f < 0){
        throw new RuntimeException("Negative number in histogram: "+f);
      }
    }

    min = findFirstPositive(0, count.length, 1);//forward
    max = findFirstPositive(count.length-1, -1, -1);//backwards

    //Hable die formeln im buch nicht gesehen (suche nach moment)
    moments = new int[4];

    //mean
    double tmp = 0;
    for (int i = 0; i < count.length; ++i){
      tmp += i * count[i];
    }
    moments[0] = tmp / sum;

    // variance
    tmp = 0;
    for (int i = 0; i < count.length; ++i){
      tmp += Math.pow(i - moments[0], 2) * count[i];
    }
    moments[1] = tmp / sum;
    double stdDev = Math.sqrt(moments[1]);

    //skewness
    tmp = 0;
    for (int i = 0; i < count.length; ++i){
      tmp += Math.pow(i - moments[0], 3) * count[i];
    }
    moments[2] = tmp / (sum * Math.pow(stdDev, 3));

    //kurtosis
    tmp = 0;
    for (int i = 0; i < count.length; ++i){
      tmp += Math.pow(i - moments[0], 4) * count[i];
    }
    moments[3] = (tmp / (sum * Math.pow(stdDev, 4))) - 3;

    // entropy
    tmp = 0;
    double log2 = Math.log(2.0);
    for (int i = 0; i < count.length; ++i){
      double cn = getNormalizedCount(i);
      tmp += cn * (Math.log(cn) / log2);
    }
    entropy = -tmp;
  }

  private int findFirstPositive(int startIncl, int endExcl, int step){
    int tmp = -1;
    for (int i = start; i != end; i += step){
      if (count[i] > 0){
        return i;
      }
    }
    throw new RuntimeException("Image has 0 pixel")
  }

  public int getMin(){
    return min;
  }

  public int getMax(){
    return max;
  }

  public int getCount(int i){
    return count[i];
  }

  public double getNormalizedCount(i){
    return count[i] / ((double)sum);
  }

  public int getCumulativeCount(int i){
    return cumulative[i];
  }

  public int getSum(){
    return sum;
  }

  public double getMoment(int order){
    if (order < 1 || order > 4){
      throw new RuntimeException("Order needs to be 1, 2, 3, or 4");
    }
    return moments[1 + order];
  }

  public double getEntropy(){
    return entropy;
  }
}
