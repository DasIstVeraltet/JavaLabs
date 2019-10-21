package com.company;

public class SinglePayment {
    private int key;//Key of the transaction
    private String countDst;//Destination count
    private String countSrc;//Destination count
    private int invoce;
    private boolean confermed;
    private boolean blocked;
    private short cntAttempts;

    SinglePayment() { }

    SinglePayment(int key, String countSrc, String countDst,int invoce)
    {
        this.countDst = countDst;
        this.countSrc = countSrc;
        this.invoce = invoce;
        this.key = key;
        this.confermed = false;
        this.blocked = false;
        this.cntAttempts = 3;
    }

    public int confirmPayment(int controlHash)
    {
        if(blocked)
            return -2;
        if(cntAttempts == 0)
            blocked = true;
        if(controlHash == getHashSum())
        {
            confermed = true;
            return invoce;
        }
        --cntAttempts;
        return -1;
    }

    public boolean isConfirmed()
    {
        return confermed;
    }

    private int getHashSum()
    {
        return key * invoce;
    }

    public String getCountDst()
    {
        return this.countDst;
    }

    public String getCountSrc()
    {
        return this.countSrc;
    }

    public void blockPayment()
    {
        blocked = true;
    }

    public int closePayment()
    {
        if(blocked || !confermed)
            return -1;
        return key;
    }

    public int getInvoceByKey(int key)
    {
        if(this.key == key)
            return invoce;
        return -1;
    }
}
