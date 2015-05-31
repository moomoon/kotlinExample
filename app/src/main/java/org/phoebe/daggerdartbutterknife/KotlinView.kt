package org.phoebe.daggerdartbutterknife

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Checkable
import android.widget.Toast
import kotlin.properties.Delegates

/**
 * Created by Phoebe on 5/31/15.
 */
public class KotlinView @jvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs), Checkable {
    private var mWidth : Float = 0F
    private var mHeight : Float = 0F
    private val pt by Delegates.lazy { Paint() }
    private var isChecked = false
    private val gestureDetector by Delegates.lazy { SingleTapUpDetector(context){toggle()}}
    override fun dispatchTouchEvent(event : MotionEvent) : Boolean{
        gestureDetector.onTouchEvent(event)
        return true;
    }

    override fun onDraw(canvas: Canvas) {
        super<View>.onDraw(canvas)
        pt.setColor(if(isChecked) 0xFFFF0000L.toInt()  else 0xFF00FF00L.toInt());
        canvas.drawRect(0f, 0f, mWidth, mHeight, pt)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super<View>.onMeasure(widthMeasureSpec, heightMeasureSpec)
        this.mWidth = View.MeasureSpec.getSize(widthMeasureSpec).toFloat()
        this.mHeight = View.MeasureSpec.getSize(heightMeasureSpec).toFloat()
        setOnClickListener { Toast.makeText(　, "test", Toast.LENGTH_SHORT).show() }
    }

    override fun isChecked(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun toggle() {
        isChecked = !isChecked;
        invalidate();
    }

    override fun setChecked(checked: Boolean) {
        throw UnsupportedOperationException()
    }
}
