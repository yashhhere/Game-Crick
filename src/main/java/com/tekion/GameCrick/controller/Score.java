package com.tekion.GameCrick.controller;
import java.util.Random;
public class Score {
    public Random RANDOM = new Random(System.currentTimeMillis());
    public int nextSkewedBoundedDouble(int min, int max, int bias) {
        int range = max - min;
        int mid = (int)((min + range) / 2);
        int unitGaussian = (int)RANDOM.nextGaussian();
        int biasFactor = (int)Math.exp(bias);
        int retval = (int)(mid+(range*(biasFactor/(biasFactor+Math.exp(-unitGaussian))-0.5)));
        return retval;
    }
}
