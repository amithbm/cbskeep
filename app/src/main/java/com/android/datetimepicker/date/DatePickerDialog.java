package com.android.datetimepicker.date;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.android.datetimepicker.R.id;
import com.android.datetimepicker.R.layout;
import com.android.datetimepicker.R.string;
import com.android.datetimepicker.Utils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class DatePickerDialog extends DialogFragment
  implements View.OnClickListener, DatePickerController
{
  private static SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("dd", Locale.getDefault());
  private static SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy", Locale.getDefault());
  private AccessibleDateAnimator mAnimator;
  private final Calendar mCalendar = Calendar.getInstance();
  private OnDateSetListener mCallBack;
  private int mCurrentView = -1;
  private TextView mDayOfWeekView;
  private String mDayPickerDescription;
  private DayPickerView mDayPickerView;
  private boolean mDelayAnimation = true;
  private Button mDoneButton;
  private HapticFeedbackController mHapticFeedbackController;
  private HashSet<OnDateChangedListener> mListeners = new HashSet();
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

  private void adjustDayInMonthIfNeeded(int paramInt1, int paramInt2)
  {
    int i = mCalendar.get(5);
    paramInt1 = Utils.getDaysInMonth(paramInt1, paramInt2);
    if (i > paramInt1)
      mCalendar.set(5, paramInt1);
  }

  public static DatePickerDialog newInstance(OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3)
  {
    DatePickerDialog localDatePickerDialog = new DatePickerDialog();
    localDatePickerDialog.initialize(paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    return localDatePickerDialog;
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
      ((OnDateChangedListener)localIterator.next()).onDateChanged();
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

  public void initialize(OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3)
  {
    mCallBack = paramOnDateSetListener;
    mCalendar.set(1, paramInt1);
    mCalendar.set(2, paramInt2);
    mCalendar.set(5, paramInt3);
  }

  public void onClick(View paramView)
  {
    tryVibrate();
    if (paramView.getId() == R.id.date_picker_year)
      setCurrentView(1);
    while (paramView.getId() != R.id.date_picker_month_and_day)
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
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.date_picker_dialog, null);
    mDayOfWeekView = ((TextView)paramLayoutInflater.findViewById(R.id.date_picker_header));
    mMonthAndDayView = ((LinearLayout)paramLayoutInflater.findViewById(R.id.date_picker_month_and_day));
    mMonthAndDayView.setOnClickListener(this);
    mSelectedMonthTextView = ((TextView)paramLayoutInflater.findViewById(R.id.date_picker_month));
    mSelectedDayTextView = ((TextView)paramLayoutInflater.findViewById(R.id.date_picker_day));
    mYearView = ((TextView)paramLayoutInflater.findViewById(R.id.date_picker_year));
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
    mDayPickerDescription = paramBundle.getString(R.string.day_picker_description);
    mSelectDay = paramBundle.getString(R.string.select_day);
    mYearPickerDescription = paramBundle.getString(R.string.year_picker_description);
    mSelectYear = paramBundle.getString(R.string.select_year);
    mAnimator = ((AccessibleDateAnimator)paramLayoutInflater.findViewById(R.id.animator));
    mAnimator.addView(mDayPickerView);
    mAnimator.addView(mYearPickerView);
    mAnimator.setDateMillis(mCalendar.getTimeInMillis());
    paramBundle = new AlphaAnimation(0.0F, 1.0F);
    paramBundle.setDuration(300L);
    mAnimator.setInAnimation(paramBundle);
    paramBundle = new AlphaAnimation(1.0F, 0.0F);
    paramBundle.setDuration(300L);
    mAnimator.setOutAnimation(paramBundle);
    mDoneButton = ((Button)paramLayoutInflater.findViewById(R.id.done));
    mDoneButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        tryVibrate();
        if (mCallBack != null)
          mCallBack.onDateSet(DatePickerDialog.this, mCalendar.get(1), mCalendar.get(2), mCalendar.get(5));
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

  public void registerOnDateChangedListener(OnDateChangedListener paramOnDateChangedListener)
  {
    mListeners.add(paramOnDateChangedListener);
  }

  public void setFirstDayOfWeek(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 7))
      throw new IllegalArgumentException("Value must be between Calendar.SUNDAY and Calendar.SATURDAY");
    mWeekStart = paramInt;
    if (mDayPickerView != null)
      mDayPickerView.onChange();
  }

  public void setMinDate(Calendar paramCalendar)
  {
    mMinDate = paramCalendar;
    if (mDayPickerView != null)
      mDayPickerView.onChange();
  }

  public void setOnDateSetListener(OnDateSetListener paramOnDateSetListener)
  {
    mCallBack = paramOnDateSetListener;
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

  public static abstract interface OnDateChangedListener
  {
    public abstract void onDateChanged();
  }

  public static abstract interface OnDateSetListener
  {
    public abstract void onDateSet(DatePickerDialog paramDatePickerDialog, int paramInt1, int paramInt2, int paramInt3);
  }
}