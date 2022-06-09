package com.serviceimpl;

import com.service.CallCountService;
import org.springframework.stereotype.Service;

@Service
public class CallCountServiceImpl implements CallCountService {
    private int sum=0;
    private boolean taken=false;
    public synchronized void add(){
        while (taken) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        taken = true;
        notifyAll();
        this.sum++;
    }
    public synchronized int getNum(){
        while (!taken) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        taken = false;
        notifyAll();
        return this.sum;
    }
}