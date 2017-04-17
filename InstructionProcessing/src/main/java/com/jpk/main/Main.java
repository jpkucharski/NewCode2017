package com.jpk.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

import com.jpk.processing.Receiver;
import com.jpk.producer.ProducerThread;


public class Main
{

    public static void main( String[] args )
    {
        
        Receiver rec = new Receiver();
        rec.receive( "A MZ89 5678 50 20150305T10:04:56.012Z" );
        
        
//        ExecutorService executor = Executors.newFixedThreadPool( 3 );
//        
//        
//        executor.submit( new ProducerThread() );
//        executor.shutdown();
//        try
//        {
//            executor.awaitTermination( 1, TimeUnit.HOURS );
//        }
//        catch( InterruptedException e )
//        {
//            e.printStackTrace();
//        }
       
    }

}
