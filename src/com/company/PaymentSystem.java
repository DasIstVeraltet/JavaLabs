package com.company;

import java.util.ArrayList;

public abstract class PaymentSystem {
    ArrayList<SinglePayment> waitForConfirm;
    ArrayList<SinglePayment> finishedTransaction;

    public PaymentSystem(){
        waitForConfirm = new ArrayList<SinglePayment>();
        finishedTransaction = new ArrayList<SinglePayment>();
    }

    public ArrayList<SinglePayment> getReportByUserId(int uId) {
        ArrayList<SinglePayment> out = new ArrayList<SinglePayment>();
        for(int i = 0; i < finishedTransaction.size(); i++)
            if(finishedTransaction.get(i).getInvoceByKey(uId) != -1)
                out.add(finishedTransaction.get(i));
        return out;
    }

    public boolean confirmNext(int controlHash)
    {
        return true;
    }

    private boolean sendResponceToBank()
    {
        return true;
    }



}
