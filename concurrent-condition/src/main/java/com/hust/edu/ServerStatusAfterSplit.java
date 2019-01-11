package com.hust.edu;

import java.util.HashSet;
import java.util.Set;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2019/1/11.
 * 锁分解技术
 */
public class ServerStatusAfterSplit {
    public final Set<String> users;
    public final Set<String> queries;

    public ServerStatusAfterSplit() {
        users = new HashSet<String>();
        queries = new HashSet<String>();
    }

    public void addUser(String u) {
        synchronized (users) {
            users.add(u);
        }
    }

    public void addQuery(String q) {
        synchronized (queries) {
            queries.add(q);
        }
    }
}
