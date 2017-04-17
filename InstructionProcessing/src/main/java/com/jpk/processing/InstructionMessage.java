package com.jpk.processing;

import java.sql.Timestamp;


public class InstructionMessage
{
    // <InstructionType> <ProductCode> <Quantity> <UOM> <Timestamp>
    private String instructionType, productCode;
    private int quantity, uom;
    private Timestamp timestamp;


    public InstructionMessage( String instructionType, String productCode, int quantit, int uom, Timestamp timestamp )
    {
        this.instructionType = instructionType;
        this.productCode = productCode;
        this.quantity = quantit;
        this.uom = uom;
        this.timestamp = timestamp;
    }


    public String getInstructionType()
    {
        return instructionType;
    }


    public String getProductCode()
    {
        return productCode;
    }


    public int getUom()
    {
        return uom;
    }


    public int getQuantity()
    {
        return quantity;
    }


    public Timestamp getTimestamp()
    {
        return timestamp;
    }
}
