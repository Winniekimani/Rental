package com.winnie.utility;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@BillNo
public class BillNoGenerator implements TransactIonNoGenerator{

    public String generate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");

        return "BNG" + dateFormat.format(new Date()) + "-" + ThreadLocalRandom.current().nextInt(1000, 2000 + 1);
    }
}

