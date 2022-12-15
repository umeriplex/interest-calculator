package com.example.bank;

import java.util.ArrayList;

class BankAcc{
    int accBL, accNO, accBLY;
    public static int year;
    double instPerYear;
    int annInterestRate = 3;
    int totalE = 0;
    ArrayList<Integer> accBLList;

    public BankAcc(int accBL, int accNO, int annInterest) {
        this.accBL = accBL;
        this.accNO = accNO;
        annInterestRate = annInterest;
        accBLY = accBL;
    }

    public void computeInterest(int y){
        accBLList = new ArrayList<>();
        year = y;
        instPerYear = (accBL/100)*annInterestRate;
        for (int i = 1; i <= y; i++){
            accBLY +=  instPerYear;
            accBLList.add(i-1,accBLY);
            totalE+=instPerYear;
        }
    }

}

