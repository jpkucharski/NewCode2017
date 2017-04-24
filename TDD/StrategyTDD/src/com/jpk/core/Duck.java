package com.jpk.core;


import com.jpk.flying.FlyingBychavior;

public class Duck
{

    
    
    private FlyingBychavior flyingBychavior;
    
    public Duck(){}
    
    
    public Duck( FlyingBychavior flyingBychavior )
    {
        this.flyingBychavior= flyingBychavior;

    }

    public void doFlying()
    {
       
       this.flyingBychavior.fly();
        
    }






  
    
   
    
    
       

    
    

}
