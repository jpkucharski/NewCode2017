package com.jpk.producer;

import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Random;

import com.jpk.processing.Receiver;


public class ProducerThread
    implements Runnable
{
    private static final String TIMESTAMP_FORMAT = "yyyyMMdd'T'HH:mm:ss.SSS'Z'";
    private static final int MAX = 500;
    private static final int MIN = 200;
    private String message;
    SimpleDateFormat format;


    public ProducerThread()
    {
        format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
    }

    public void run()
    {
        System.out.println( "thread is running" );
        Receiver rec = new Receiver();
        for (int i =0 ; i<2 ; i++)
//        while( true )
        {
            try
            {
                Thread.sleep( new Random().nextInt( (MAX - MIN) + 1 ) + MIN);
                
//                System.out.println( createMessage() );
//                rec.receive( "A MZ89 5678 50 20150305T10:04:56.012Z" );
                String message = createMessage();
                System.out.println( "message was created: " + message );
                new Receiver().receive( message );
//               
            }
            catch( InterruptedException e )
            {
                e.printStackTrace();
            }
        }
        System.out.println("From QUEUE -> "+ rec.getInstructionQueue().size());
    }

    private String createMessage()
    {
        // pater -> InstructionMessage A MZ89 5678 50 20150305T10:04:56.012Z
        
        String timeStamp = new SimpleDateFormat( TIMESTAMP_FORMAT ).format( System.currentTimeMillis() );
        // String timeStamp = new SimpleDateFormat( TIMESTAMP_FORMAT ).format( new Timestamp(System.currentTimeMillis()) );
        // String timeStamp = new SimpleDateFormat( TIMESTAMP_FORMAT ).format( Calendar.getInstance().getTime() );
      
        message =   generateRandomLether()+" MZ89 5678 50 " + timeStamp;

        return message;
    }
    private char generateRandomLether(){
        Random r = new Random();
        char lether = (char) (r.nextInt(4) + 'A');
        return lether;
    }
}
