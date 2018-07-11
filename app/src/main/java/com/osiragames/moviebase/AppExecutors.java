package com.osiragames.moviebase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by ABHI on 7/10/2018.
 */

public class AppExecutors {

    private static final Object LOCK = new Object();
    private static AppExecutors sinstance;
    private final Executor diskIo;

    private AppExecutors(Executor diskIo) {
        this.diskIo = diskIo;
    }

   public static AppExecutors getSinstance(){
        if(sinstance== null){
            synchronized (LOCK){
                sinstance = new AppExecutors(Executors.newSingleThreadExecutor());
            }
        }

        return sinstance;
   }

   public Executor diskIO(){return diskIo;}

}
