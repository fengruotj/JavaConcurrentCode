package com.hust.edu.taxi.open;

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

    private void setLocation(Point location){
        boolean readchedDestination=false;

        synchronized (this){
            this.location=location;
            if(location.equals(destination)){
                readchedDestination=true;
            }
        }

        if (readchedDestination)
            dispatcher.notifyAvaiable(this);
    }
}
