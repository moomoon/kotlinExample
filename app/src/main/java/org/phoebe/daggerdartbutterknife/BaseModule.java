package org.phoebe.daggerdartbutterknife;

import android.app.Activity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Phoebe on 5/30/15.
 */
@Module
public class BaseModule {
    @Provides @Named("name0")
    public String provideName0(Activity activity){
        return activity.getClass().getCanonicalName();
    }
    @Provides @Named("name1")
    public String provideName1(){
        return "name12Test";

    }
    @Provides @Named("name2")
    public String provideName2(){
        return "name22Test";
    }

    @Provides
    public StringBuilder providerStringBuilder(){
        return new StringBuilder();
    }
}
