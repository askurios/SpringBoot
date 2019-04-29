package com.sample.multipart.demo;

import java.util.Random;

public class RandomUtil {
    public static int getResult(){
        Random random = new Random();
//        int randomResult = random.nextInt(5) * -10;
        int ranNum = random.nextInt(100);
        int randomResult = 0;
        if (ranNum >= 95){
            randomResult = -10;
        }
//        else {
//            randomResult = ranNum/2 *-10;
//        }
        return randomResult;
    }
}
