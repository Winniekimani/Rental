package com.winnie.app.bean;

import java.io.IOException;
import java.io.Serializable;

public interface MpesaBeanI extends Serializable {
    String authenticate() throws IOException;

    String STKPushSimulation(String amount, String phoneNumber) throws IOException;
}
