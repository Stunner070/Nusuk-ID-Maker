package main;

import com.google.inject.Binder;
import com.google.inject.Module;
import Controllers.MainCtrl;
import com.google.inject.Scopes;

public class MyModule implements Module {

    /**
     *
     * @param binder binder
     */
    @Override
    public void configure(Binder binder) {
        binder.bind(MainCtrl.class).in(Scopes.SINGLETON);
    }

}
