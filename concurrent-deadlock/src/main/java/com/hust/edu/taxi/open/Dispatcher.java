package com.hust.edu.taxi.open;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * locate com.hust.edu.taxi
 * Created by MasterTj on 2019/1/10.
 */
public class Dispatcher {
    private final Set<Taxi> taxis;
    private final Set<Taxi> availableTaxis;

    public Dispatcher() {
        taxis=new HashSet<>();
        availableTaxis=new HashSet<>();
    }

    public synchronized void notifyAvaiable(Taxi taxi){
        availableTaxis.add(taxi);
    }

    public List<Point> getImage(){
        List<Point> list=new ArrayList<>();
        Set<Taxi> copy=new HashSet<>();

        synchronized (this){
            copy.addAll(taxis);
        }

        for (Taxi taxi : copy) {
            list.add(taxi.getLocation());
        }
        return list;
    }
}
