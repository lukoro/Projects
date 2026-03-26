package com.example.project;

import org.springframework.stereotype.Service;

@Service
public class SuperCounterServiceImpl implements CounterService {

    private Integer counter = 1;

    @Override
    public void add(){
        this.counter =  this.counter * 2;
    }

    @Override
    public Integer getCounter() {
        return counter;
    }

    @Override
    public void setCounter(Integer counter) {
        this.counter = counter;
    }
}
