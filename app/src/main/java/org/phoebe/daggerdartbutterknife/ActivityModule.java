package org.phoebe.daggerdartbutterknife;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Phoebe on 5/30/15.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides public Activity provideActivtiy(){
        return activity;
    }
}
