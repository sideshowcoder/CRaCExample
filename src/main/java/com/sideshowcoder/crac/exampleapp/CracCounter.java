package com.sideshowcoder.crac.exampleapp;

import org.crac.Core;
import org.crac.Resource;
import org.crac.Context;

public class CracCounter implements Resource {

    private long counter;

    public CracCounter() {
        Core.getGlobalContext().register(this);
    }

    public long getAndIncrement() {
        return counter++;
    }

    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) {
        counter = 0;
    }

    @Override
    public void afterRestore(Context<? extends Resource> context) {
        /* ... */
    }
}
