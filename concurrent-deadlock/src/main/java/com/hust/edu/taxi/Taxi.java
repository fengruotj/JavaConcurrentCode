package com.hust.edu.taxi;

/**
 * locate com.hust.edu.taxi
 * Created by MasterTj on 2019/1/10.
 */
public class Taxi {
    private final Dispatcher dispatcher;

    private Point location;

    private Point destination;

    public Taxi(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public synchronized Point getLocation(){
        return location;
    }

    private synchronized void setLocation(Point location){
        this.location=location;
        if(location.equals(destination)){
            dispatcher.notifyAvaiable(this);
        }
    }
}
