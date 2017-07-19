package com.lrest.server.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.lrest.server.services.SystemManager;

public class GuiceModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(SystemManager.class);
        System.out.println("GuiceModule binder ok" );
    }
}
