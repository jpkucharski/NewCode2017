package com.jpk.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.jpk.processing.Receiver;
import com.jpk.producer.ProducerThread;


public class Main
{

    public static void main( String[] args )
    {
        ExecutorService executor = Executors.newFixedThreadPool( 3 );
        
        
        executor.submit( new ProducerThread() );
        executor.shutdown();
        try
        {
            executor.awaitTermination( 1, TimeUnit.HOURS );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
       
    }

}
