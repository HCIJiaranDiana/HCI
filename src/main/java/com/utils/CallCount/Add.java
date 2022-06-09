package com.utils.CallCount;

import com.service.CallCountService;

public class Add implements Runnable{
    private CallCountService callCountService;
    public Add(CallCountService callCountService){this.callCountService=callCountService;}
    public void run(){
        callCountService.add();
    }
}
