package org.phoebe.daggerdartbutterknife

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent

/**
 * Created by Phoebe on 5/31/15.
 */
    public fun SingleTapUpDetector(context : Context, listener : () -> Unit) : GestureDetector{
        return GestureDetector(context, object : GestureDetector.SimpleOnGestureListener(){
            override fun onSingleTapUp(event : MotionEvent) : Boolean{
                listener.invoke();
                return true;
            }
        })
    }