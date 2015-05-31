package org.phoebe.daggerdartbutterknife;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;
import com.f2prateek.dart.Optional;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.internal.ListenerMethod;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.test)
    TextView test;
    @Optional
    @InjectExtra("count")

    int count = 0;

    @Optional
    @InjectExtra("name")
    String name;

    @Inject @Named("name0")
    String name0;
    @Inject @Named("name1")
    String name1;
    @Inject @Named("name2")
    String name2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        Dart.inject(this);


//        BaseComponent component =Dagger2Helper.buildComponent(BaseComponent.class, new BaseModule(), new ActivityModule(this));
//        component.inject(this);
        DaggerBaseComponent.builder().activityModule(new ActivityModule(this)).build().inject(this);
        //Bus bus = new Bus();
        test.setText("" + count + " " + name + " name0 = " + name0 + " name1 = " + name1 + " name2 = " + name2);
    }

    @Produce
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
