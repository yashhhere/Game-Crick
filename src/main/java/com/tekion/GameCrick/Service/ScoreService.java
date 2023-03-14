package com.tekion.GameCrick.Service;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class ScoreService{
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
