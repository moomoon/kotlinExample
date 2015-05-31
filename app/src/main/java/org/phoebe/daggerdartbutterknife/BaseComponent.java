package org.phoebe.daggerdartbutterknife;

import android.app.Activity;

import dagger.Component;

/**
 * Created by Phoebe on 5/30/15.
 */
@Component(modules = {BaseModule.class,ActivityModule.class})
public interface BaseComponent {
    void inject(MainActivity activity);
}
