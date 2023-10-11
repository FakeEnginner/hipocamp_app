package com.example.hipocamp_app.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PointF
import android.util.AttributeSet
import com.google.android.material.bottomnavigation.BottomNavigationView


class CurvedBottomNavigationView : BottomNavigationView {
    private var mNavigationBarWidth = 0
    private var mNavigationBarHeight = 0
    private val mPath = Path()
    private val mPaint = Paint()
    private val mFirstCurveStartPoint = PointF()
    private val mFirstCurveEndPoint = PointF()
    private val mFirstCurveControlPoint1 = PointF()
    private val mFirstCurveControlPoint2 = PointF()
    private val mSecondCurveStartPoint = PointF()
    private val mSecondCurveEndPoint = PointF()
    private val mSecondCurveControlPoint1 = PointF()
    private val mSecondCurveControlPoint2 = PointF()

    constructor(context: Context?) : super(context!!) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!, attrs, defStyleAttr
    ) {
        init()
    }

    private fun init() {
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.color = Color.BLUE
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        // Get width and height of navigation bar
        mNavigationBarWidth = width
        mNavigationBarHeight = height

        // Calculate points and control points for the curved shape
        mFirstCurveStartPoint[(mNavigationBarWidth / 2 - CURVE_CIRCLE_RADIUS * 2 - CURVE_CIRCLE_RADIUS / 3).toFloat()] =
            0f
        mFirstCurveEndPoint[(mNavigationBarWidth / 2).toFloat()] =
            (CURVE_CIRCLE_RADIUS + CURVE_CIRCLE_RADIUS / 4).toFloat()
        mFirstCurveControlPoint1[mFirstCurveStartPoint.x + CURVE_CIRCLE_RADIUS + CURVE_CIRCLE_RADIUS / 4] =
            mFirstCurveStartPoint.y
        mFirstCurveControlPoint2[mFirstCurveEndPoint.x - CURVE_CIRCLE_RADIUS * 2 + CURVE_CIRCLE_RADIUS] =
            mFirstCurveEndPoint.y
        mSecondCurveStartPoint[mFirstCurveEndPoint.x] = mFirstCurveEndPoint.y
        mSecondCurveEndPoint[(mNavigationBarWidth / 2 + CURVE_CIRCLE_RADIUS * 2 + CURVE_CIRCLE_RADIUS / 3).toFloat()] =
            0f
        mSecondCurveControlPoint1[mSecondCurveStartPoint.x + CURVE_CIRCLE_RADIUS * 2 - CURVE_CIRCLE_RADIUS] =
            mSecondCurveStartPoint.y
        mSecondCurveControlPoint2[mSecondCurveEndPoint.x - (CURVE_CIRCLE_RADIUS + CURVE_CIRCLE_RADIUS / 4)] =
            mSecondCurveEndPoint.y

        // Create the curved path
        mPath.reset()
        mPath.moveTo(0f, 0f)
        mPath.lineTo(mFirstCurveStartPoint.x, mFirstCurveStartPoint.y)
        mPath.cubicTo(
            mFirstCurveControlPoint1.x, mFirstCurveControlPoint1.y,
            mFirstCurveControlPoint2.x, mFirstCurveControlPoint2.y,
            mFirstCurveEndPoint.x, mFirstCurveEndPoint.y
        )
        mPath.cubicTo(
            mSecondCurveControlPoint1.x, mSecondCurveControlPoint1.y,
            mSecondCurveControlPoint2.x, mSecondCurveControlPoint2.y,
            mSecondCurveEndPoint.x, mSecondCurveEndPoint.y
        )
        mPath.lineTo(mNavigationBarWidth.toFloat(), 0f)
        mPath.lineTo(mNavigationBarWidth.toFloat(), mNavigationBarHeight.toFloat())
        mPath.lineTo(0f, mNavigationBarHeight.toFloat())
        mPath.close()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(mPath, mPaint)
    }

    companion object {
        private const val CURVE_CIRCLE_RADIUS = 100
    }
}
