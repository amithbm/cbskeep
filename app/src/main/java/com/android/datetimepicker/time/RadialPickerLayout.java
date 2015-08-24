package com.android.datetimepicker.time;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.android.datetimepicker.HapticFeedbackController;
import com.android.datetimepicker.R.color;
import java.util.List;

public class RadialPickerLayout extends FrameLayout
  implements View.OnTouchListener
{
  private final int TAP_TIMEOUT;
  private final int TOUCH_SLOP;
  private AccessibilityManager mAccessibilityManager;
  private AmPmCirclesView mAmPmCirclesView;
  private CircleView mCircleView;
  private int mCurrentHoursOfDay;
  private int mCurrentItemShowing;
  private int mCurrentMinutes;
  private boolean mDoingMove;
  private boolean mDoingTouch;
  private int mDownDegrees;
  private float mDownX;
  private float mDownY;
  private View mGrayBox;
  private Handler mHandler = new Handler();
  private HapticFeedbackController mHapticFeedbackController;
  private boolean mHideAmPm;
  private RadialSelectorView mHourRadialSelectorView;
  private RadialTextsView mHourRadialTextsView;
  private boolean mInputEnabled;
  private boolean mIs24HourMode;
  private int mIsTouchingAmOrPm = -1;
  private int mLastValueSelected;
  private OnValueSelectedListener mListener;
  private RadialSelectorView mMinuteRadialSelectorView;
  private RadialTextsView mMinuteRadialTextsView;
  private int[] mSnapPrefer30sMap;
  private boolean mTimeInitialized;
  private AnimatorSet mTransition;

  public RadialPickerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnTouchListener(this);
    TOUCH_SLOP = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    mDoingMove = false;
    mCircleView = new CircleView(paramContext);
    addView(mCircleView);
    mAmPmCirclesView = new AmPmCirclesView(paramContext);
    addView(mAmPmCirclesView);
    mHourRadialTextsView = new RadialTextsView(paramContext);
    addView(mHourRadialTextsView);
    mMinuteRadialTextsView = new RadialTextsView(paramContext);
    addView(mMinuteRadialTextsView);
    mHourRadialSelectorView = new RadialSelectorView(paramContext);
    addView(mHourRadialSelectorView);
    mMinuteRadialSelectorView = new RadialSelectorView(paramContext);
    addView(mMinuteRadialSelectorView);
    preparePrefer30sMap();
    mLastValueSelected = -1;
    mInputEnabled = true;
    mGrayBox = new View(paramContext);
    mGrayBox.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    mGrayBox.setBackgroundColor(getResources().getColor(R.color.transparent_black));
    mGrayBox.setVisibility(4);
    addView(mGrayBox);
    mAccessibilityManager = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
    mTimeInitialized = false;
  }

  private int getCurrentlyShowingValue()
  {
    int i = getCurrentItemShowing();
    if (i == 0)
      return mCurrentHoursOfDay;
    if (i == 1)
      return mCurrentMinutes;
    return -1;
  }

  private int getDegreesFromCoords(float paramFloat1, float paramFloat2, boolean paramBoolean, Boolean[] paramArrayOfBoolean)
  {
    int i = getCurrentItemShowing();
    if (i == 0)
      return mHourRadialSelectorView.getDegreesFromCoords(paramFloat1, paramFloat2, paramBoolean, paramArrayOfBoolean);
    if (i == 1)
      return mMinuteRadialSelectorView.getDegreesFromCoords(paramFloat1, paramFloat2, paramBoolean, paramArrayOfBoolean);
    return -1;
  }

  private boolean isHourInnerCircle(int paramInt)
  {
    return (mIs24HourMode) && (paramInt <= 12) && (paramInt != 0);
  }

  private void preparePrefer30sMap()
  {
    mSnapPrefer30sMap = new int[361];
    int k = 0;
    int i = 1;
    int m = 8;
    int j = 0;
    if (j < 361)
    {
      mSnapPrefer30sMap[j] = k;
      if (i == m)
      {
        k += 6;
        if (k == 360)
        {
          i = 7;
          label54: int n = 1;
          m = i;
          i = n;
        }
      }
      while (true)
      {
        j += 1;
        break;
        if (k % 30 == 0)
        {
          i = 14;
          break label54;
        }
        i = 4;
        break label54;
        i += 1;
      }
    }
  }

  private int reselectSelector(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = -1;
    if (paramInt == -1)
      return i;
    int k = getCurrentItemShowing();
    label30: label42: RadialSelectorView localRadialSelectorView;
    int j;
    if ((!paramBoolean2) && (k == 1))
    {
      i = 1;
      if (i == 0)
        break label151;
      i = snapPrefer30s(paramInt);
      if (k != 0)
        break label161;
      localRadialSelectorView = mHourRadialSelectorView;
      j = 30;
      label57: localRadialSelectorView.setSelection(i, paramBoolean1, paramBoolean3);
      localRadialSelectorView.invalidate();
      if (k != 0)
        break label212;
      if (!mIs24HourMode)
        break label197;
      if ((i != 0) || (!paramBoolean1))
        break label174;
      paramInt = 360;
    }
    while (true)
    {
      j = paramInt / j;
      i = j;
      if (k != 0)
        break;
      i = j;
      if (!mIs24HourMode)
        break;
      i = j;
      if (paramBoolean1)
        break;
      i = j;
      if (paramInt == 0)
        break;
      return j + 12;
      i = 0;
      break label30;
      label151: i = snapOnly30s(paramInt, 0);
      break label42;
      label161: localRadialSelectorView = mMinuteRadialSelectorView;
      j = 6;
      break label57;
      label174: paramInt = i;
      if (i == 360)
      {
        paramInt = i;
        if (!paramBoolean1)
        {
          paramInt = 0;
          continue;
          label197: paramInt = i;
          if (i == 0)
          {
            paramInt = 360;
            continue;
            label212: paramInt = i;
            if (i == 360)
            {
              paramInt = i;
              if (k == 1)
                paramInt = 0;
            }
          }
        }
      }
    }
  }

  private void setItem(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      setValueForItem(0, paramInt2);
      mHourRadialSelectorView.setSelection(paramInt2 % 12 * 30, isHourInnerCircle(paramInt2), false);
      mHourRadialSelectorView.invalidate();
    }
    while (paramInt1 != 1)
      return;
    setValueForItem(1, paramInt2);
    mMinuteRadialSelectorView.setSelection(paramInt2 * 6, false, false);
    mMinuteRadialSelectorView.invalidate();
  }

  private void setValueForItem(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
      mCurrentHoursOfDay = paramInt2;
    do
    {
      do
      {
        return;
        if (paramInt1 == 1)
        {
          mCurrentMinutes = paramInt2;
          return;
        }
      }
      while (paramInt1 != 2);
      if (paramInt2 == 0)
      {
        mCurrentHoursOfDay %= 12;
        return;
      }
    }
    while (paramInt2 != 1);
    mCurrentHoursOfDay = (mCurrentHoursOfDay % 12 + 12);
  }

  private static int snapOnly30s(int paramInt1, int paramInt2)
  {
    int i = paramInt1 / 30 * 30;
    int j = i + 30;
    if (paramInt2 == 1)
      return j;
    if (paramInt2 == -1)
    {
      paramInt2 = i;
      if (paramInt1 == i)
        paramInt2 = i - 30;
      return paramInt2;
    }
    if (paramInt1 - i < j - paramInt1)
      return i;
    return j;
  }

  private int snapPrefer30s(int paramInt)
  {
    if (mSnapPrefer30sMap == null)
      return -1;
    return mSnapPrefer30sMap[paramInt];
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.getText().clear();
      Object localObject = new Time();
      ((Time)localObject).hour = getHours();
      ((Time)localObject).minute = getMinutes();
      long l = ((Time)localObject).normalize(true);
      int i = 1;
      if (mIs24HourMode)
        i = 0x1 | 0x80;
      localObject = DateUtils.formatDateTime(getContext(), l, i);
      paramAccessibilityEvent.getText().add(localObject);
      return true;
    }
    return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }

  public int getCurrentItemShowing()
  {
    if ((mCurrentItemShowing != 0) && (mCurrentItemShowing != 1))
    {
      Log.e("RadialPickerLayout", "Current item showing was unfortunately set to " + mCurrentItemShowing);
      return -1;
    }
    return mCurrentItemShowing;
  }

  public int getHours()
  {
    return mCurrentHoursOfDay;
  }

  public int getIsCurrentlyAmOrPm()
  {
    if (mCurrentHoursOfDay < 12)
      return 0;
    if (mCurrentHoursOfDay < 24)
      return 1;
    return -1;
  }

  public int getMinutes()
  {
    return mCurrentMinutes;
  }

  public void initialize(Context paramContext, HapticFeedbackController paramHapticFeedbackController, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (mTimeInitialized)
    {
      Log.e("RadialPickerLayout", "Time has already been initialized.");
      return;
    }
    mHapticFeedbackController = paramHapticFeedbackController;
    mIs24HourMode = paramBoolean;
    boolean bool;
    int i;
    label88: Resources localResources;
    String[] arrayOfString2;
    String[] arrayOfString1;
    String[] arrayOfString3;
    if (mAccessibilityManager.isTouchExplorationEnabled())
    {
      bool = true;
      mHideAmPm = bool;
      mCircleView.initialize(paramContext, mHideAmPm);
      mCircleView.invalidate();
      if (!mHideAmPm)
      {
        paramHapticFeedbackController = mAmPmCirclesView;
        if (paramInt1 >= 12)
          break label445;
        i = 0;
        paramHapticFeedbackController.initialize(paramContext, i);
        mAmPmCirclesView.invalidate();
      }
      localResources = paramContext.getResources();
      localObject = new int[12];
      Object tmp116_114 = localObject;
      tmp116_114[0] = 12;
      Object tmp121_116 = tmp116_114;
      tmp121_116[1] = 1;
      Object tmp125_121 = tmp121_116;
      tmp125_121[2] = 2;
      Object tmp129_125 = tmp125_121;
      tmp129_125[3] = 3;
      Object tmp133_129 = tmp129_125;
      tmp133_129[4] = 4;
      Object tmp137_133 = tmp133_129;
      tmp137_133[5] = 5;
      Object tmp141_137 = tmp137_133;
      tmp141_137[6] = 6;
      Object tmp147_141 = tmp141_137;
      tmp147_141[7] = 7;
      Object tmp153_147 = tmp147_141;
      tmp153_147[8] = 8;
      Object tmp159_153 = tmp153_147;
      tmp159_153[9] = 9;
      Object tmp165_159 = tmp159_153;
      tmp165_159[10] = 10;
      Object tmp171_165 = tmp165_159;
      tmp171_165[11] = 11;
      tmp171_165;
      arrayOfString2 = new String[12];
      arrayOfString1 = new String[12];
      arrayOfString3 = new String[12];
      i = 0;
      label202: if (i >= 12)
        break label476;
      if (!paramBoolean)
        break label451;
    }
    label445: label451: for (paramHapticFeedbackController = String.format("%02d", new Object[] { Integer.valueOf(new int[] { 0, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 }[i]) }); ; paramHapticFeedbackController = String.format("%d", new Object[] { Integer.valueOf(localObject[i]) }))
    {
      arrayOfString2[i] = paramHapticFeedbackController;
      arrayOfString1[i] = String.format("%d", new Object[] { Integer.valueOf(localObject[i]) });
      arrayOfString3[i] = String.format("%02d", new Object[] { Integer.valueOf(new int[] { 0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55 }[i]) });
      i += 1;
      break label202;
      bool = mIs24HourMode;
      break;
      i = 1;
      break label88;
    }
    label476: Object localObject = mHourRadialTextsView;
    if (paramBoolean);
    for (paramHapticFeedbackController = arrayOfString1; ; paramHapticFeedbackController = null)
    {
      ((RadialTextsView)localObject).initialize(localResources, arrayOfString2, paramHapticFeedbackController, mHideAmPm, true);
      mHourRadialTextsView.invalidate();
      mMinuteRadialTextsView.initialize(localResources, arrayOfString3, null, mHideAmPm, false);
      mMinuteRadialTextsView.invalidate();
      setValueForItem(0, paramInt1);
      setValueForItem(1, paramInt2);
      mHourRadialSelectorView.initialize(paramContext, mHideAmPm, paramBoolean, true, paramInt1 % 12 * 30, isHourInnerCircle(paramInt1));
      mMinuteRadialSelectorView.initialize(paramContext, mHideAmPm, false, false, paramInt2 * 6, false);
      mTimeInitialized = true;
      return;
    }
  }

  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.addAction(4096);
    paramAccessibilityNodeInfo.addAction(8192);
  }

  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    i = Math.min(i, j);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i, paramInt1), View.MeasureSpec.makeMeasureSpec(i, paramInt2));
  }

  public boolean onTouch(final View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramView = new Boolean[1];
    paramView[0] = Boolean.valueOf(false);
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
    case 1:
    }
    label168: int i;
    while (true)
    {
      return false;
      if (!mInputEnabled)
        return true;
      mDownX = f1;
      mDownY = f2;
      mLastValueSelected = -1;
      mDoingMove = false;
      mDoingTouch = true;
      if (!mHideAmPm)
      {
        mIsTouchingAmOrPm = mAmPmCirclesView.getIsTouchingAmOrPm(f1, f2);
        if ((mIsTouchingAmOrPm != 0) && (mIsTouchingAmOrPm != 1))
          break label168;
        mHapticFeedbackController.tryVibrate();
        mDownDegrees = -1;
        mHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            mAmPmCirclesView.setAmOrPmPressed(mIsTouchingAmOrPm);
            mAmPmCirclesView.invalidate();
          }
        }
        , TAP_TIMEOUT);
      }
      while (true)
      {
        return true;
        mIsTouchingAmOrPm = -1;
        break;
        mDownDegrees = getDegreesFromCoords(f1, f2, mAccessibilityManager.isTouchExplorationEnabled(), paramView);
        if (mDownDegrees != -1)
        {
          mHapticFeedbackController.tryVibrate();
          mHandler.postDelayed(new Runnable()
          {
            public void run()
            {
              RadialPickerLayout.access$202(RadialPickerLayout.this, true);
              int i = RadialPickerLayout.this.reselectSelector(mDownDegrees, paramView[0].booleanValue(), false, true);
              RadialPickerLayout.access$502(RadialPickerLayout.this, i);
              mListener.onValueSelected(getCurrentItemShowing(), i, false);
            }
          }
          , TAP_TIMEOUT);
        }
      }
      if (!mInputEnabled)
      {
        Log.e("RadialPickerLayout", "Input was disabled, but received ACTION_MOVE.");
        return true;
      }
      float f3 = Math.abs(f2 - mDownY);
      float f4 = Math.abs(f1 - mDownX);
      if ((mDoingMove) || (f4 > TOUCH_SLOP) || (f3 > TOUCH_SLOP))
        if ((mIsTouchingAmOrPm == 0) || (mIsTouchingAmOrPm == 1))
        {
          mHandler.removeCallbacksAndMessages(null);
          if (mAmPmCirclesView.getIsTouchingAmOrPm(f1, f2) != mIsTouchingAmOrPm)
          {
            mAmPmCirclesView.setAmOrPmPressed(-1);
            mAmPmCirclesView.invalidate();
            mIsTouchingAmOrPm = -1;
          }
        }
        else if (mDownDegrees != -1)
        {
          mDoingMove = true;
          mHandler.removeCallbacksAndMessages(null);
          i = getDegreesFromCoords(f1, f2, true, paramView);
          if (i != -1)
          {
            i = reselectSelector(i, paramView[0].booleanValue(), false, true);
            if (i != mLastValueSelected)
            {
              mHapticFeedbackController.tryVibrate();
              mLastValueSelected = i;
              mListener.onValueSelected(getCurrentItemShowing(), i, false);
            }
          }
          return true;
          if (!mInputEnabled)
          {
            Log.d("RadialPickerLayout", "Input was disabled, but received ACTION_UP.");
            mListener.onValueSelected(3, 1, false);
            return true;
          }
          mHandler.removeCallbacksAndMessages(null);
          mDoingTouch = false;
          if ((mIsTouchingAmOrPm != 0) && (mIsTouchingAmOrPm != 1))
            break;
          i = mAmPmCirclesView.getIsTouchingAmOrPm(f1, f2);
          mAmPmCirclesView.setAmOrPmPressed(-1);
          mAmPmCirclesView.invalidate();
          if (i == mIsTouchingAmOrPm)
          {
            mAmPmCirclesView.setAmOrPm(i);
            if (getIsCurrentlyAmOrPm() != i)
            {
              mListener.onValueSelected(2, mIsTouchingAmOrPm, false);
              setValueForItem(2, i);
            }
          }
          mIsTouchingAmOrPm = -1;
        }
    }
    boolean bool1;
    int j;
    int k;
    if (mDownDegrees != -1)
    {
      i = getDegreesFromCoords(f1, f2, mDoingMove, paramView);
      if (i != -1)
      {
        boolean bool2 = paramView[0].booleanValue();
        if (mDoingMove)
          break label733;
        bool1 = true;
        j = reselectSelector(i, bool2, bool1, false);
        i = j;
        if (getCurrentItemShowing() == 0)
        {
          i = j;
          if (!mIs24HourMode)
          {
            k = getIsCurrentlyAmOrPm();
            if ((k != 0) || (j != 12))
              break label739;
            i = 0;
          }
        }
      }
    }
    while (true)
    {
      setValueForItem(getCurrentItemShowing(), i);
      mListener.onValueSelected(getCurrentItemShowing(), i, true);
      mDoingMove = false;
      return true;
      label733: bool1 = false;
      break;
      label739: i = j;
      if (k == 1)
      {
        i = j;
        if (j != 12)
          i = j + 12;
      }
    }
  }

  @SuppressLint({"NewApi"})
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramInt, paramBundle))
      return true;
    int i = 0;
    int k;
    int m;
    int j;
    if (paramInt == 4096)
    {
      i = 1;
      if (i == 0)
        break label179;
      k = getCurrentlyShowingValue();
      paramInt = 0;
      m = getCurrentItemShowing();
      if (m != 0)
        break label129;
      paramInt = 30;
      j = k % 12;
      label55: k = snapOnly30s(j * paramInt, i) / paramInt;
      i = 0;
      if (m != 0)
        break label157;
      if (!mIs24HourMode)
        break label149;
      paramInt = 23;
      label84: if (k <= paramInt)
        break label163;
      j = i;
    }
    while (true)
    {
      setItem(m, j);
      mListener.onValueSelected(m, j, false);
      return true;
      if (paramInt != 8192)
        break;
      i = -1;
      break;
      label129: j = k;
      if (m != 1)
        break label55;
      paramInt = 6;
      j = k;
      break label55;
      label149: paramInt = 12;
      i = 1;
      break label84;
      label157: paramInt = 55;
      break label84;
      label163: j = k;
      if (k < i)
        j = paramInt;
    }
    label179: return false;
  }

  public void setAmOrPm(int paramInt)
  {
    mAmPmCirclesView.setAmOrPm(paramInt);
    mAmPmCirclesView.invalidate();
    setValueForItem(2, paramInt);
  }

  public void setCurrentItemShowing(int paramInt, boolean paramBoolean)
  {
    int j = 255;
    if ((paramInt != 0) && (paramInt != 1))
    {
      Log.e("RadialPickerLayout", "TimePicker does not support view at index " + paramInt);
      return;
    }
    int i = getCurrentItemShowing();
    mCurrentItemShowing = paramInt;
    if ((paramBoolean) && (paramInt != i))
    {
      ObjectAnimator[] arrayOfObjectAnimator = new ObjectAnimator[4];
      if (paramInt == 1)
      {
        arrayOfObjectAnimator[0] = mHourRadialTextsView.getDisappearAnimator();
        arrayOfObjectAnimator[1] = mHourRadialSelectorView.getDisappearAnimator();
        arrayOfObjectAnimator[2] = mMinuteRadialTextsView.getReappearAnimator();
        arrayOfObjectAnimator[3] = mMinuteRadialSelectorView.getReappearAnimator();
      }
      while (true)
      {
        if ((mTransition != null) && (mTransition.isRunning()))
          mTransition.end();
        mTransition = new AnimatorSet();
        mTransition.playTogether(arrayOfObjectAnimator);
        mTransition.start();
        return;
        if (paramInt == 0)
        {
          arrayOfObjectAnimator[0] = mHourRadialTextsView.getReappearAnimator();
          arrayOfObjectAnimator[1] = mHourRadialSelectorView.getReappearAnimator();
          arrayOfObjectAnimator[2] = mMinuteRadialTextsView.getDisappearAnimator();
          arrayOfObjectAnimator[3] = mMinuteRadialSelectorView.getDisappearAnimator();
        }
      }
    }
    if (paramInt == 0)
    {
      i = 255;
      if (paramInt != 1)
        break label277;
    }
    label277: for (paramInt = j; ; paramInt = 0)
    {
      mHourRadialTextsView.setAlpha(i);
      mHourRadialSelectorView.setAlpha(i);
      mMinuteRadialTextsView.setAlpha(paramInt);
      mMinuteRadialSelectorView.setAlpha(paramInt);
      return;
      i = 0;
      break;
    }
  }

  public void setOnValueSelectedListener(OnValueSelectedListener paramOnValueSelectedListener)
  {
    mListener = paramOnValueSelectedListener;
  }

  public void setTime(int paramInt1, int paramInt2)
  {
    setItem(0, paramInt1);
    setItem(1, paramInt2);
  }

  public boolean trySettingInputEnabled(boolean paramBoolean)
  {
    int i = 0;
    if ((mDoingTouch) && (!paramBoolean))
      return false;
    mInputEnabled = paramBoolean;
    View localView = mGrayBox;
    if (paramBoolean)
      i = 4;
    localView.setVisibility(i);
    return true;
  }

  public static abstract interface OnValueSelectedListener
  {
    public abstract void onValueSelected(int paramInt1, int paramInt2, boolean paramBoolean);
  }
}