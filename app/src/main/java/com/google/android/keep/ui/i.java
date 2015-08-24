package com.google.android.keep.ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.datetimepicker.HapticFeedbackController;
import com.android.datetimepicker.Utils;
import com.android.datetimepicker.date.AccessibleDateAnimator;
import com.android.datetimepicker.date.DatePickerController;
import com.android.datetimepicker.date.DatePickerDialog.OnDateChangedListener;
import com.android.datetimepicker.date.DayPickerView;
import com.android.datetimepicker.date.MonthAdapter.CalendarDay;
import com.android.datetimepicker.date.SimpleDayPickerView;
import com.android.datetimepicker.date.YearPickerView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class i extends DialogFragment
  implements View.OnClickListener, DatePickerController
{
  private static SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("dd", Locale.getDefault());
  private static SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy", Locale.getDefault());
  private a Jy;
  private AccessibleDateAnimator mAnimator;
  private final Calendar mCalendar = Calendar.getInstance();
  private int mCurrentView = -1;
  private TextView mDayOfWeekView;
  private String mDayPickerDescription;
  private DayPickerView mDayPickerView;
  private boolean mDelayAnimation = true;
  private Button mDoneButton;
  private HapticFeedbackController mHapticFeedbackController;
  private HashSet<DatePickerDialog.OnDateChangedListener> mListeners = new HashSet();
  private Calendar mMaxDate;
  private int mMaxYear = 2100;
  private Calendar mMinDate;
  private int mMinYear = 1900;
  private LinearLayout mMonthAndDayView;
  private String mSelectDay;
  private String mSelectYear;
  private TextView mSelectedDayTextView;
  private TextView mSelectedMonthTextView;
  private int mWeekStart = mCalendar.getFirstDayOfWeek();
  private String mYearPickerDescription;
  private YearPickerView mYearPickerView;
  private TextView mYearView;

  public i()
  {
    setMinDate(Calendar.getInstance());
  }

  public static i a(a parama, int paramInt1, int paramInt2, int paramInt3)
  {
    i locali = new i();
    locali.b(parama, paramInt1, paramInt2, paramInt3);
    return locali;
  }

  private void adjustDayInMonthIfNeeded(int paramInt1, int paramInt2)
  {
    int i = mCalendar.get(5);
    paramInt1 = Utils.getDaysInMonth(paramInt1, paramInt2);
    if (i > paramInt1)
      mCalendar.set(5, paramInt1);
  }

  private void setCurrentView(int paramInt)
  {
    long l = mCalendar.getTimeInMillis();
    switch (paramInt)
    {
    default:
      return;
    case 0:
      localObject = Utils.getPulseAnimator(mMonthAndDayView, 0.9F, 1.05F);
      if (mDelayAnimation)
      {
        ((ObjectAnimator)localObject).setStartDelay(500L);
        mDelayAnimation = false;
      }
      mDayPickerView.onDateChanged();
      if (mCurrentView != paramInt)
      {
        mMonthAndDayView.setSelected(true);
        mYearView.setSelected(false);
        mAnimator.setDisplayedChild(0);
        mCurrentView = paramInt;
      }
      ((ObjectAnimator)localObject).start();
      localObject = DateUtils.formatDateTime(getActivity(), l, 16);
      mAnimator.setContentDescription(mDayPickerDescription + ": " + (String)localObject);
      Utils.tryAccessibilityAnnounce(mAnimator, mSelectDay);
      return;
    case 1:
    }
    Object localObject = Utils.getPulseAnimator(mYearView, 0.85F, 1.1F);
    if (mDelayAnimation)
    {
      ((ObjectAnimator)localObject).setStartDelay(500L);
      mDelayAnimation = false;
    }
    mYearPickerView.onDateChanged();
    if (mCurrentView != paramInt)
    {
      mMonthAndDayView.setSelected(false);
      mYearView.setSelected(true);
      mAnimator.setDisplayedChild(1);
      mCurrentView = paramInt;
    }
    ((ObjectAnimator)localObject).start();
    localObject = YEAR_FORMAT.format(Long.valueOf(l));
    mAnimator.setContentDescription(mYearPickerDescription + ": " + localObject);
    Utils.tryAccessibilityAnnounce(mAnimator, mSelectYear);
  }

  private void updateDisplay(boolean paramBoolean)
  {
    if (mDayOfWeekView != null)
      mDayOfWeekView.setText(mCalendar.getDisplayName(7, 2, Locale.getDefault()).toUpperCase(Locale.getDefault()));
    mSelectedMonthTextView.setText(mCalendar.getDisplayName(2, 1, Locale.getDefault()).toUpperCase(Locale.getDefault()));
    mSelectedDayTextView.setText(DAY_FORMAT.format(mCalendar.getTime()));
    mYearView.setText(YEAR_FORMAT.format(mCalendar.getTime()));
    long l = mCalendar.getTimeInMillis();
    mAnimator.setDateMillis(l);
    String str = DateUtils.formatDateTime(getActivity(), l, 24);
    mMonthAndDayView.setContentDescription(str);
    if (paramBoolean)
    {
      str = DateUtils.formatDateTime(getActivity(), l, 20);
      Utils.tryAccessibilityAnnounce(mAnimator, str);
    }
  }

  private void updatePickers()
  {
    Iterator localIterator = mListeners.iterator();
    while (localIterator.hasNext())
      ((DatePickerDialog.OnDateChangedListener)localIterator.next()).onDateChanged();
  }

  public void a(a parama)
  {
    Jy = parama;
  }

  public void b(a parama, int paramInt1, int paramInt2, int paramInt3)
  {
    Jy = parama;
    mCalendar.set(1, paramInt1);
    mCalendar.set(2, paramInt2);
    mCalendar.set(5, paramInt3);
  }

  public int getFirstDayOfWeek()
  {
    return mWeekStart;
  }

  public Calendar getMaxDate()
  {
    return mMaxDate;
  }

  public int getMaxYear()
  {
    return mMaxYear;
  }

  public Calendar getMinDate()
  {
    return mMinDate;
  }

  public int getMinYear()
  {
    return mMinYear;
  }

  public MonthAdapter.CalendarDay getSelectedDay()
  {
    return new MonthAdapter.CalendarDay(mCalendar);
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    Jy.bQ();
  }

  public void onClick(View paramView)
  {
    tryVibrate();
    if (paramView.getId() == 2131493143)
      setCurrentView(1);
    while (paramView.getId() != 2131493140)
      return;
    setCurrentView(0);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getActivity().getWindow().setSoftInputMode(3);
    if (paramBundle != null)
    {
      mCalendar.set(1, paramBundle.getInt("year"));
      mCalendar.set(2, paramBundle.getInt("month"));
      mCalendar.set(5, paramBundle.getInt("day"));
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Log.d("DatePickerDialog", "onCreateView: ");
    getDialog().getWindow().requestFeature(1);
    paramLayoutInflater = paramLayoutInflater.inflate(2130968645, null);
    mDayOfWeekView = ((TextView)paramLayoutInflater.findViewById(2131493138));
    mMonthAndDayView = ((LinearLayout)paramLayoutInflater.findViewById(2131493140));
    mMonthAndDayView.setOnClickListener(this);
    mSelectedMonthTextView = ((TextView)paramLayoutInflater.findViewById(2131493141));
    mSelectedDayTextView = ((TextView)paramLayoutInflater.findViewById(2131493142));
    mYearView = ((TextView)paramLayoutInflater.findViewById(2131493143));
    mYearView.setOnClickListener(this);
    int j = -1;
    int k = 0;
    int i = 0;
    if (paramBundle != null)
    {
      mWeekStart = paramBundle.getInt("week_start");
      mMinYear = paramBundle.getInt("year_start");
      mMaxYear = paramBundle.getInt("year_end");
      i = paramBundle.getInt("current_view");
      j = paramBundle.getInt("list_position");
      k = paramBundle.getInt("list_position_offset");
    }
    paramViewGroup = getActivity();
    mDayPickerView = new SimpleDayPickerView(paramViewGroup, this);
    mYearPickerView = new YearPickerView(paramViewGroup, this);
    paramBundle = getResources();
    mDayPickerDescription = paramBundle.getString(2131230822);
    mSelectDay = paramBundle.getString(2131230824);
    mYearPickerDescription = paramBundle.getString(2131230823);
    mSelectYear = paramBundle.getString(2131230825);
    mAnimator = ((AccessibleDateAnimator)paramLayoutInflater.findViewById(2131493144));
    mAnimator.addView(mDayPickerView);
    mAnimator.addView(mYearPickerView);
    mAnimator.setDateMillis(mCalendar.getTimeInMillis());
    paramBundle = new AlphaAnimation(0.0F, 1.0F);
    paramBundle.setDuration(300L);
    mAnimator.setInAnimation(paramBundle);
    paramBundle = new AlphaAnimation(1.0F, 0.0F);
    paramBundle.setDuration(300L);
    mAnimator.setOutAnimation(paramBundle);
    mDoneButton = ((Button)paramLayoutInflater.findViewById(2131493137));
    mDoneButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        tryVibrate();
        if (i.a(i.this) != null)
          i.a(i.this).b(i.b(i.this).get(1), i.b(i.this).get(2), i.b(i.this).get(5));
        dismiss();
      }
    });
    updateDisplay(false);
    setCurrentView(i);
    if (j != -1)
    {
      if (i != 0)
        break label444;
      mDayPickerView.postSetSelection(j);
    }
    while (true)
    {
      mHapticFeedbackController = new HapticFeedbackController(paramViewGroup);
      return paramLayoutInflater;
      label444: if (i == 1)
        mYearPickerView.postSetSelectionFromTop(j, k);
    }
  }

  public void onDayOfMonthSelected(int paramInt1, int paramInt2, int paramInt3)
  {
    mCalendar.set(1, paramInt1);
    mCalendar.set(2, paramInt2);
    mCalendar.set(5, paramInt3);
    updatePickers();
    updateDisplay(true);
  }

  public void onPause()
  {
    super.onPause();
    mHapticFeedbackController.stop();
  }

  public void onResume()
  {
    super.onResume();
    mHapticFeedbackController.start();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("year", mCalendar.get(1));
    paramBundle.putInt("month", mCalendar.get(2));
    paramBundle.putInt("day", mCalendar.get(5));
    paramBundle.putInt("week_start", mWeekStart);
    paramBundle.putInt("year_start", mMinYear);
    paramBundle.putInt("year_end", mMaxYear);
    paramBundle.putInt("current_view", mCurrentView);
    int i = -1;
    if (mCurrentView == 0)
      i = mDayPickerView.getMostVisiblePosition();
    while (true)
    {
      paramBundle.putInt("list_position", i);
      return;
      if (mCurrentView == 1)
      {
        i = mYearPickerView.getFirstVisiblePosition();
        paramBundle.putInt("list_position_offset", mYearPickerView.getFirstPositionOffset());
      }
    }
  }

  public void onYearSelected(int paramInt)
  {
    adjustDayInMonthIfNeeded(mCalendar.get(2), paramInt);
    mCalendar.set(1, paramInt);
    updatePickers();
    setCurrentView(0);
    updateDisplay(true);
  }

  public void registerOnDateChangedListener(DatePickerDialog.OnDateChangedListener paramOnDateChangedListener)
  {
    mListeners.add(paramOnDateChangedListener);
  }

  public void setMinDate(Calendar paramCalendar)
  {
    mMinDate = paramCalendar;
    if (mDayPickerView != null)
      mDayPickerView.onChange();
  }

  public void setYearRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramInt1)
      throw new IllegalArgumentException("Year end must be larger than year start");
    mMinYear = paramInt1;
    mMaxYear = paramInt2;
    if (mDayPickerView != null)
      mDayPickerView.onChange();
  }

  public void tryVibrate()
  {
    mHapticFeedbackController.tryVibrate();
  }

  public static abstract interface a
  {
    public abstract void b(int paramInt1, int paramInt2, int paramInt3);

    public abstract void bQ();
  }
}