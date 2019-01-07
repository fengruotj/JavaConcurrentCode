package com.hust.edu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2019/1/7.
 */
public class SynchronizedContainer {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(list);

    }
}
