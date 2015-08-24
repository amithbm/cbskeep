package com.android.recurrencepicker;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.Log;
import android.util.TimeFormatException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TableLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.android.calendarcommon2.EventRecurrence;
import com.android.datetimepicker.date.DatePickerDialog;
import com.android.datetimepicker.date.DatePickerDialog.OnDateSetListener;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class RecurrencePickerDialog extends DialogFragment
  implements View.OnClickListener, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, DatePickerDialog.OnDateSetListener
{
  public static final String TAG = RecurrencePickerDialog.class.getSimpleName();
  private static final int[] mFreqModelToEventRecurrence = { 4, 5, 6, 7 };
  private final int[] TIME_DAY_TO_CALENDAR_DAY = { 1, 2, 3, 4, 5, 6, 7 };
  private DatePickerDialog mDatePickerDialog;
  private Button mDone;
  private EditText mEndCount;
  private String mEndCountLabel;
  private String mEndDateLabel;
  private TextView mEndDateTextView;
  private String mEndNeverStr;
  private Spinner mEndSpinner;
  private EndSpinnerAdapter mEndSpinnerAdapter;
  private ArrayList<CharSequence> mEndSpinnerArray = new ArrayList(3);
  private Spinner mFreqSpinner;
  private boolean mHidePostEndCount;
  private EditText mInterval;
  private TextView mIntervalPostText;
  private TextView mIntervalPreText;
  private int mIntervalResId = -1;
  private boolean mIsWeeklyOnly = false;
  private LinearLayout mMainLayout;
  private RecurrenceModel mModel = new RecurrenceModel();
  private LinearLayout mMonthGroup;
  private String mMonthRepeatByDayOfWeekStr;
  private String[][] mMonthRepeatByDayOfWeekStrs;
  private RadioGroup mMonthRepeatByRadioGroup;
  private int mNumDaysInMonth;
  private TextView mPostEndCount;
  private EventRecurrence mRecurrence = new EventRecurrence();
  private OnRecurrenceSetListener mRecurrenceSetListener;
  private RadioButton mRepeatMonthlyByLastDayOfMonth;
  private RadioButton mRepeatMonthlyByNthDayOfMonth;
  private RadioButton mRepeatMonthlyByNthDayOfWeek;
  private Switch mRepeatSwitch;
  private TextView mRepeatText;
  private Resources mResources;
  private Time mTime = new Time();
  private View mView;
  private ToggleButton[] mWeekByDayButtons = new ToggleButton[7];
  private LinearLayout mWeekGroup;
  private LinearLayout mWeekGroup2;

  public static boolean canHandleRecurrenceRule(EventRecurrence paramEventRecurrence)
  {
    switch (freq)
    {
    default:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    int j;
    do
    {
      do
        return false;
      while ((count > 0) && (!TextUtils.isEmpty(until)));
      j = 0;
      int i = 0;
      while (i < bydayCount)
      {
        int k = j;
        if (isSupportedMonthlyByNthDayOfWeek(bydayNum[i]))
          k = j + 1;
        i += 1;
        j = k;
      }
    }
    while ((j > 1) || ((j > 0) && (freq != 6)) || (bymonthdayCount > 1) || ((freq == 6) && ((bydayCount > 1) || ((bydayCount > 0) && (bymonthdayCount > 0)))));
    return true;
  }

  private static void copyEventRecurrenceToModel(EventRecurrence paramEventRecurrence, RecurrenceModel paramRecurrenceModel)
  {
    switch (freq)
    {
    default:
      throw new IllegalStateException("freq=" + freq);
    case 4:
      paramRecurrenceModel.freq = 0;
    case 6:
    case 7:
    case 5:
    }
    while (true)
    {
      if (interval > 0)
        paramRecurrenceModel.interval = interval;
      paramRecurrenceModel.endCount = count;
      if (paramRecurrenceModel.endCount > 0)
        paramRecurrenceModel.end = 2;
      if (!TextUtils.isEmpty(until))
      {
        if (paramRecurrenceModel.endDate == null)
          paramRecurrenceModel.endDate = new Time();
        try
        {
          paramRecurrenceModel.endDate.parse(until);
          if ((paramRecurrenceModel.end == 2) && (paramRecurrenceModel.endDate != null))
          {
            throw new IllegalStateException("freq=" + freq);
            paramRecurrenceModel.freq = 2;
            continue;
            paramRecurrenceModel.freq = 3;
            continue;
            paramRecurrenceModel.freq = 1;
          }
        }
        catch (TimeFormatException localTimeFormatException)
        {
          while (true)
            paramRecurrenceModel.endDate = null;
          paramRecurrenceModel.end = 1;
        }
      }
    }
    Arrays.fill(paramRecurrenceModel.weeklyByDayOfWeek, false);
    if (bydayCount > 0)
    {
      int j = 0;
      int i = 0;
      while (i < bydayCount)
      {
        int m = EventRecurrence.day2TimeDay(byday[i]);
        paramRecurrenceModel.weeklyByDayOfWeek[m] = true;
        int k = j;
        if (paramRecurrenceModel.freq == 2)
        {
          k = j;
          if (isSupportedMonthlyByNthDayOfWeek(bydayNum[i]))
          {
            paramRecurrenceModel.monthlyByDayOfWeek = m;
            paramRecurrenceModel.monthlyByNthDayOfWeek = bydayNum[i];
            paramRecurrenceModel.monthlyRepeat = 1;
            k = j + 1;
          }
        }
        i += 1;
        j = k;
      }
      if (paramRecurrenceModel.freq == 2)
      {
        if (bydayCount != 1)
          throw new IllegalStateException("Can handle only 1 byDayOfWeek in monthly");
        if (j != 1)
          throw new IllegalStateException("Didn't specify which nth day of week to repeat for a monthly");
      }
    }
    if (paramRecurrenceModel.freq == 2)
    {
      if (bymonthdayCount != 1)
        break label432;
      if (paramRecurrenceModel.monthlyRepeat == 1)
        throw new IllegalStateException("Can handle only by monthday or by nth day of week, not both");
      paramRecurrenceModel.monthlyByMonthDay = bymonthday[0];
      paramRecurrenceModel.monthlyRepeat = 0;
    }
    label432: 
    while (bymonthCount <= 1)
      return;
    throw new IllegalStateException("Can handle only one bymonthday");
  }

  private static void copyModelToEventRecurrence(RecurrenceModel paramRecurrenceModel, EventRecurrence paramEventRecurrence)
  {
    if (recurrenceState == 0)
      throw new IllegalStateException("There's no recurrence");
    paramEventRecurrence.freq = mFreqModelToEventRecurrence[freq];
    if (interval <= 1)
    {
      paramEventRecurrence.interval = 0;
      switch (end)
      {
      default:
        paramEventRecurrence.count = 0;
        paramEventRecurrence.until = null;
        label78: paramEventRecurrence.bydayCount = 0;
        paramEventRecurrence.bymonthdayCount = 0;
        switch (freq)
        {
        default:
        case 2:
        case 1:
        }
        break;
      case 1:
      case 2:
      }
    }
    while (true)
    {
      if (canHandleRecurrenceRule(paramEventRecurrence))
        return;
      throw new IllegalStateException("UI generated recurrence that it can't handle. ER:" + paramEventRecurrence.toString() + " Model: " + paramRecurrenceModel.toString());
      paramEventRecurrence.interval = interval;
      break;
      if (endDate != null)
      {
        endDate.switchTimezone("UTC");
        endDate.normalize(false);
        paramEventRecurrence.until = endDate.format2445();
        paramEventRecurrence.count = 0;
        break label78;
      }
      throw new IllegalStateException("end = END_BY_DATE but endDate is null");
      paramEventRecurrence.count = endCount;
      paramEventRecurrence.until = null;
      if (paramEventRecurrence.count > 0)
        break label78;
      throw new IllegalStateException("count is " + paramEventRecurrence.count);
      if (monthlyRepeat == 0)
      {
        if ((monthlyByMonthDay > 0) || (monthlyByMonthDay == -1))
        {
          if ((paramEventRecurrence.bymonthday == null) || (paramEventRecurrence.bymonthdayCount < 1))
            paramEventRecurrence.bymonthday = new int[1];
          paramEventRecurrence.bymonthday[0] = monthlyByMonthDay;
          paramEventRecurrence.bymonthdayCount = 1;
        }
      }
      else if (monthlyRepeat == 1)
      {
        if (!isSupportedMonthlyByNthDayOfWeek(monthlyByNthDayOfWeek))
          throw new IllegalStateException("month repeat by nth week but n is " + monthlyByNthDayOfWeek);
        if ((paramEventRecurrence.bydayCount < 1) || (paramEventRecurrence.byday == null) || (paramEventRecurrence.bydayNum == null))
        {
          paramEventRecurrence.byday = new int[1];
          paramEventRecurrence.bydayNum = new int[1];
        }
        paramEventRecurrence.bydayCount = 1;
        paramEventRecurrence.byday[0] = EventRecurrence.timeDay2Day(monthlyByDayOfWeek);
        paramEventRecurrence.bydayNum[0] = monthlyByNthDayOfWeek;
        continue;
        int i = 0;
        int j = 0;
        int k;
        while (j < 7)
        {
          k = i;
          if (weeklyByDayOfWeek[j] != 0)
            k = i + 1;
          j += 1;
          i = k;
        }
        if ((paramEventRecurrence.bydayCount < i) || (paramEventRecurrence.byday == null) || (paramEventRecurrence.bydayNum == null))
        {
          paramEventRecurrence.byday = new int[i];
          paramEventRecurrence.bydayNum = new int[i];
        }
        paramEventRecurrence.bydayCount = i;
        j = 6;
        while (j >= 0)
        {
          k = i;
          if (weeklyByDayOfWeek[j] != 0)
          {
            int[] arrayOfInt = paramEventRecurrence.bydayNum;
            k = i - 1;
            arrayOfInt[k] = 0;
            paramEventRecurrence.byday[k] = EventRecurrence.timeDay2Day(j);
          }
          j -= 1;
          i = k;
        }
      }
    }
  }

  private void initMonthlyOnWeekDay()
  {
    mModel.monthlyByNthDayOfWeek = ((mTime.monthDay + 6) / 7);
    if (mTime.monthDay + 7 > mNumDaysInMonth)
      mModel.monthlyByNthDayOfWeek = -1;
    mModel.monthlyByDayOfWeek = mTime.weekDay;
  }

  private void initUi(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: invokevirtual 362	com/android/recurrencepicker/RecurrencePickerDialog:getResources	()Landroid/content/res/Resources;
    //   5: putfield 156	com/android/recurrencepicker/RecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   8: aload_0
    //   9: aload_1
    //   10: getstatic 367	com/android/recurrencepicker/R$layout:recurrencepicker	I
    //   13: aload_2
    //   14: iconst_1
    //   15: invokevirtual 373	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   18: putfield 375	com/android/recurrencepicker/RecurrencePickerDialog:mView	Landroid/view/View;
    //   21: aload_0
    //   22: invokespecial 378	com/android/recurrencepicker/RecurrencePickerDialog:initializeViews	()V
    //   25: aload_0
    //   26: getfield 145	com/android/recurrencepicker/RecurrencePickerDialog:mIsWeeklyOnly	Z
    //   29: ifeq +7 -> 36
    //   32: aload_0
    //   33: invokespecial 381	com/android/recurrencepicker/RecurrencePickerDialog:showWeeklyOnlyUi	()V
    //   36: aload_0
    //   37: getfield 383	com/android/recurrencepicker/RecurrencePickerDialog:mRepeatSwitch	Landroid/widget/Switch;
    //   40: astore_1
    //   41: aload_0
    //   42: getfield 128	com/android/recurrencepicker/RecurrencePickerDialog:mModel	Lcom/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel;
    //   45: getfield 316	com/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel:recurrenceState	I
    //   48: iconst_1
    //   49: if_icmpne +560 -> 609
    //   52: iconst_1
    //   53: istore 8
    //   55: aload_1
    //   56: iload 8
    //   58: invokevirtual 389	android/widget/Switch:setChecked	(Z)V
    //   61: aload_0
    //   62: getfield 383	com/android/recurrencepicker/RecurrencePickerDialog:mRepeatSwitch	Landroid/widget/Switch;
    //   65: new 16	com/android/recurrencepicker/RecurrencePickerDialog$1
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 391	com/android/recurrencepicker/RecurrencePickerDialog$1:<init>	(Lcom/android/recurrencepicker/RecurrencePickerDialog;)V
    //   73: invokevirtual 395	android/widget/Switch:setOnCheckedChangeListener	(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    //   76: aload_0
    //   77: getfield 397	com/android/recurrencepicker/RecurrencePickerDialog:mFreqSpinner	Landroid/widget/Spinner;
    //   80: aload_0
    //   81: invokevirtual 403	android/widget/Spinner:setOnItemSelectedListener	(Landroid/widget/AdapterView$OnItemSelectedListener;)V
    //   84: aload_0
    //   85: invokevirtual 407	com/android/recurrencepicker/RecurrencePickerDialog:getActivity	()Landroid/app/Activity;
    //   88: getstatic 412	com/android/recurrencepicker/R$array:recurrence_freq	I
    //   91: getstatic 415	com/android/recurrencepicker/R$layout:recurrencepicker_freq_item	I
    //   94: invokestatic 421	android/widget/ArrayAdapter:createFromResource	(Landroid/content/Context;II)Landroid/widget/ArrayAdapter;
    //   97: astore_1
    //   98: aload_1
    //   99: getstatic 415	com/android/recurrencepicker/R$layout:recurrencepicker_freq_item	I
    //   102: invokevirtual 424	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   105: aload_0
    //   106: getfield 397	com/android/recurrencepicker/RecurrencePickerDialog:mFreqSpinner	Landroid/widget/Spinner;
    //   109: aload_1
    //   110: invokevirtual 428	android/widget/Spinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   113: aload_0
    //   114: getfield 178	com/android/recurrencepicker/RecurrencePickerDialog:mInterval	Landroid/widget/EditText;
    //   117: new 18	com/android/recurrencepicker/RecurrencePickerDialog$2
    //   120: dup
    //   121: aload_0
    //   122: iconst_1
    //   123: iconst_1
    //   124: bipush 99
    //   126: invokespecial 431	com/android/recurrencepicker/RecurrencePickerDialog$2:<init>	(Lcom/android/recurrencepicker/RecurrencePickerDialog;III)V
    //   129: invokevirtual 437	android/widget/EditText:addTextChangedListener	(Landroid/text/TextWatcher;)V
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 156	com/android/recurrencepicker/RecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   137: getstatic 442	com/android/recurrencepicker/R$string:recurrence_end_continously	I
    //   140: invokevirtual 448	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   143: putfield 450	com/android/recurrencepicker/RecurrencePickerDialog:mEndNeverStr	Ljava/lang/String;
    //   146: aload_0
    //   147: aload_0
    //   148: getfield 156	com/android/recurrencepicker/RecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   151: getstatic 453	com/android/recurrencepicker/R$string:recurrence_end_date_label	I
    //   154: invokevirtual 448	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   157: putfield 196	com/android/recurrencepicker/RecurrencePickerDialog:mEndDateLabel	Ljava/lang/String;
    //   160: aload_0
    //   161: aload_0
    //   162: getfield 156	com/android/recurrencepicker/RecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   165: getstatic 456	com/android/recurrencepicker/R$string:recurrence_end_count_label	I
    //   168: invokevirtual 448	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   171: putfield 160	com/android/recurrencepicker/RecurrencePickerDialog:mEndCountLabel	Ljava/lang/String;
    //   174: aload_0
    //   175: getfield 139	com/android/recurrencepicker/RecurrencePickerDialog:mEndSpinnerArray	Ljava/util/ArrayList;
    //   178: aload_0
    //   179: getfield 450	com/android/recurrencepicker/RecurrencePickerDialog:mEndNeverStr	Ljava/lang/String;
    //   182: invokevirtual 460	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   185: pop
    //   186: aload_0
    //   187: getfield 139	com/android/recurrencepicker/RecurrencePickerDialog:mEndSpinnerArray	Ljava/util/ArrayList;
    //   190: aload_0
    //   191: getfield 196	com/android/recurrencepicker/RecurrencePickerDialog:mEndDateLabel	Ljava/lang/String;
    //   194: invokevirtual 460	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   197: pop
    //   198: aload_0
    //   199: getfield 139	com/android/recurrencepicker/RecurrencePickerDialog:mEndSpinnerArray	Ljava/util/ArrayList;
    //   202: aload_0
    //   203: getfield 160	com/android/recurrencepicker/RecurrencePickerDialog:mEndCountLabel	Ljava/lang/String;
    //   206: invokevirtual 460	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   209: pop
    //   210: aload_0
    //   211: getfield 193	com/android/recurrencepicker/RecurrencePickerDialog:mEndSpinner	Landroid/widget/Spinner;
    //   214: aload_0
    //   215: invokevirtual 403	android/widget/Spinner:setOnItemSelectedListener	(Landroid/widget/AdapterView$OnItemSelectedListener;)V
    //   218: aload_0
    //   219: new 22	com/android/recurrencepicker/RecurrencePickerDialog$EndSpinnerAdapter
    //   222: dup
    //   223: aload_0
    //   224: aload_0
    //   225: invokevirtual 407	com/android/recurrencepicker/RecurrencePickerDialog:getActivity	()Landroid/app/Activity;
    //   228: aload_0
    //   229: getfield 139	com/android/recurrencepicker/RecurrencePickerDialog:mEndSpinnerArray	Ljava/util/ArrayList;
    //   232: getstatic 415	com/android/recurrencepicker/R$layout:recurrencepicker_freq_item	I
    //   235: getstatic 463	com/android/recurrencepicker/R$layout:recurrencepicker_end_text	I
    //   238: invokespecial 466	com/android/recurrencepicker/RecurrencePickerDialog$EndSpinnerAdapter:<init>	(Lcom/android/recurrencepicker/RecurrencePickerDialog;Landroid/content/Context;Ljava/util/ArrayList;II)V
    //   241: putfield 468	com/android/recurrencepicker/RecurrencePickerDialog:mEndSpinnerAdapter	Lcom/android/recurrencepicker/RecurrencePickerDialog$EndSpinnerAdapter;
    //   244: aload_0
    //   245: getfield 468	com/android/recurrencepicker/RecurrencePickerDialog:mEndSpinnerAdapter	Lcom/android/recurrencepicker/RecurrencePickerDialog$EndSpinnerAdapter;
    //   248: getstatic 415	com/android/recurrencepicker/R$layout:recurrencepicker_freq_item	I
    //   251: invokevirtual 469	com/android/recurrencepicker/RecurrencePickerDialog$EndSpinnerAdapter:setDropDownViewResource	(I)V
    //   254: aload_0
    //   255: getfield 193	com/android/recurrencepicker/RecurrencePickerDialog:mEndSpinner	Landroid/widget/Spinner;
    //   258: aload_0
    //   259: getfield 468	com/android/recurrencepicker/RecurrencePickerDialog:mEndSpinnerAdapter	Lcom/android/recurrencepicker/RecurrencePickerDialog$EndSpinnerAdapter;
    //   262: invokevirtual 428	android/widget/Spinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   265: aload_0
    //   266: getfield 189	com/android/recurrencepicker/RecurrencePickerDialog:mEndCount	Landroid/widget/EditText;
    //   269: new 20	com/android/recurrencepicker/RecurrencePickerDialog$3
    //   272: dup
    //   273: aload_0
    //   274: iconst_1
    //   275: iconst_5
    //   276: sipush 730
    //   279: invokespecial 470	com/android/recurrencepicker/RecurrencePickerDialog$3:<init>	(Lcom/android/recurrencepicker/RecurrencePickerDialog;III)V
    //   282: invokevirtual 437	android/widget/EditText:addTextChangedListener	(Landroid/text/TextWatcher;)V
    //   285: aload_0
    //   286: getfield 472	com/android/recurrencepicker/RecurrencePickerDialog:mEndDateTextView	Landroid/widget/TextView;
    //   289: aload_0
    //   290: invokevirtual 478	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   293: aload_0
    //   294: getfield 128	com/android/recurrencepicker/RecurrencePickerDialog:mModel	Lcom/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel;
    //   297: getfield 264	com/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel:endDate	Landroid/text/format/Time;
    //   300: ifnonnull +72 -> 372
    //   303: aload_0
    //   304: getfield 128	com/android/recurrencepicker/RecurrencePickerDialog:mModel	Lcom/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel;
    //   307: new 122	android/text/format/Time
    //   310: dup
    //   311: aload_0
    //   312: getfield 125	com/android/recurrencepicker/RecurrencePickerDialog:mTime	Landroid/text/format/Time;
    //   315: invokespecial 481	android/text/format/Time:<init>	(Landroid/text/format/Time;)V
    //   318: putfield 264	com/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel:endDate	Landroid/text/format/Time;
    //   321: aload_0
    //   322: getfield 128	com/android/recurrencepicker/RecurrencePickerDialog:mModel	Lcom/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel;
    //   325: getfield 251	com/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel:freq	I
    //   328: tableswitch	default:+32 -> 360, 0:+287->615, 1:+287->615, 2:+308->636, 3:+329->657
    //   361: getfield 128	com/android/recurrencepicker/RecurrencePickerDialog:mModel	Lcom/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel;
    //   364: getfield 264	com/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel:endDate	Landroid/text/format/Time;
    //   367: iconst_0
    //   368: invokevirtual 335	android/text/format/Time:normalize	(Z)J
    //   371: pop2
    //   372: new 483	java/text/DateFormatSymbols
    //   375: dup
    //   376: invokespecial 484	java/text/DateFormatSymbols:<init>	()V
    //   379: invokevirtual 488	java/text/DateFormatSymbols:getWeekdays	()[Ljava/lang/String;
    //   382: pop
    //   383: aload_0
    //   384: bipush 7
    //   386: anewarray 490	[Ljava/lang/String;
    //   389: putfield 492	com/android/recurrencepicker/RecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   392: aload_0
    //   393: getfield 492	com/android/recurrencepicker/RecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   396: iconst_0
    //   397: aload_0
    //   398: getfield 156	com/android/recurrencepicker/RecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   401: getstatic 495	com/android/recurrencepicker/R$array:repeat_by_nth_sun	I
    //   404: invokevirtual 499	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   407: aastore
    //   408: aload_0
    //   409: getfield 492	com/android/recurrencepicker/RecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   412: iconst_1
    //   413: aload_0
    //   414: getfield 156	com/android/recurrencepicker/RecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   417: getstatic 502	com/android/recurrencepicker/R$array:repeat_by_nth_mon	I
    //   420: invokevirtual 499	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   423: aastore
    //   424: aload_0
    //   425: getfield 492	com/android/recurrencepicker/RecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   428: iconst_2
    //   429: aload_0
    //   430: getfield 156	com/android/recurrencepicker/RecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   433: getstatic 505	com/android/recurrencepicker/R$array:repeat_by_nth_tues	I
    //   436: invokevirtual 499	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   439: aastore
    //   440: aload_0
    //   441: getfield 492	com/android/recurrencepicker/RecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   444: iconst_3
    //   445: aload_0
    //   446: getfield 156	com/android/recurrencepicker/RecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   449: getstatic 508	com/android/recurrencepicker/R$array:repeat_by_nth_wed	I
    //   452: invokevirtual 499	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   455: aastore
    //   456: aload_0
    //   457: getfield 492	com/android/recurrencepicker/RecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   460: iconst_4
    //   461: aload_0
    //   462: getfield 156	com/android/recurrencepicker/RecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   465: getstatic 511	com/android/recurrencepicker/R$array:repeat_by_nth_thurs	I
    //   468: invokevirtual 499	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   471: aastore
    //   472: aload_0
    //   473: getfield 492	com/android/recurrencepicker/RecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   476: iconst_5
    //   477: aload_0
    //   478: getfield 156	com/android/recurrencepicker/RecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   481: getstatic 514	com/android/recurrencepicker/R$array:repeat_by_nth_fri	I
    //   484: invokevirtual 499	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   487: aastore
    //   488: aload_0
    //   489: getfield 492	com/android/recurrencepicker/RecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   492: bipush 6
    //   494: aload_0
    //   495: getfield 156	com/android/recurrencepicker/RecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   498: getstatic 517	com/android/recurrencepicker/R$array:repeat_by_nth_sat	I
    //   501: invokevirtual 499	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   504: aastore
    //   505: aload_0
    //   506: invokevirtual 407	com/android/recurrencepicker/RecurrencePickerDialog:getActivity	()Landroid/app/Activity;
    //   509: invokestatic 523	com/android/recurrencepicker/Utils:getFirstDayOfWeek	(Landroid/content/Context;)I
    //   512: istore_3
    //   513: new 483	java/text/DateFormatSymbols
    //   516: dup
    //   517: invokespecial 484	java/text/DateFormatSymbols:<init>	()V
    //   520: invokevirtual 526	java/text/DateFormatSymbols:getShortWeekdays	()[Ljava/lang/String;
    //   523: astore_1
    //   524: aload_0
    //   525: getfield 156	com/android/recurrencepicker/RecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   528: invokevirtual 530	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   531: getfield 535	android/content/res/Configuration:screenWidthDp	I
    //   534: sipush 450
    //   537: if_icmple +141 -> 678
    //   540: bipush 7
    //   542: istore 5
    //   544: iconst_0
    //   545: istore 4
    //   547: aload_0
    //   548: getfield 537	com/android/recurrencepicker/RecurrencePickerDialog:mWeekGroup2	Landroid/widget/LinearLayout;
    //   551: bipush 8
    //   553: invokevirtual 542	android/widget/LinearLayout:setVisibility	(I)V
    //   556: aload_0
    //   557: getfield 537	com/android/recurrencepicker/RecurrencePickerDialog:mWeekGroup2	Landroid/widget/LinearLayout;
    //   560: iconst_3
    //   561: invokevirtual 546	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   564: bipush 8
    //   566: invokevirtual 549	android/view/View:setVisibility	(I)V
    //   569: iconst_0
    //   570: istore 6
    //   572: iload 6
    //   574: bipush 7
    //   576: if_icmpge +213 -> 789
    //   579: iload 6
    //   581: iload 5
    //   583: if_icmplt +124 -> 707
    //   586: aload_0
    //   587: getfield 551	com/android/recurrencepicker/RecurrencePickerDialog:mWeekGroup	Landroid/widget/LinearLayout;
    //   590: iload 6
    //   592: invokevirtual 546	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   595: bipush 8
    //   597: invokevirtual 549	android/view/View:setVisibility	(I)V
    //   600: iload 6
    //   602: iconst_1
    //   603: iadd
    //   604: istore 6
    //   606: goto -34 -> 572
    //   609: iconst_0
    //   610: istore 8
    //   612: goto -557 -> 55
    //   615: aload_0
    //   616: getfield 128	com/android/recurrencepicker/RecurrencePickerDialog:mModel	Lcom/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel;
    //   619: getfield 264	com/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel:endDate	Landroid/text/format/Time;
    //   622: astore_1
    //   623: aload_1
    //   624: aload_1
    //   625: getfield 554	android/text/format/Time:month	I
    //   628: iconst_1
    //   629: iadd
    //   630: putfield 554	android/text/format/Time:month	I
    //   633: goto -273 -> 360
    //   636: aload_0
    //   637: getfield 128	com/android/recurrencepicker/RecurrencePickerDialog:mModel	Lcom/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel;
    //   640: getfield 264	com/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel:endDate	Landroid/text/format/Time;
    //   643: astore_1
    //   644: aload_1
    //   645: aload_1
    //   646: getfield 554	android/text/format/Time:month	I
    //   649: iconst_3
    //   650: iadd
    //   651: putfield 554	android/text/format/Time:month	I
    //   654: goto -294 -> 360
    //   657: aload_0
    //   658: getfield 128	com/android/recurrencepicker/RecurrencePickerDialog:mModel	Lcom/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel;
    //   661: getfield 264	com/android/recurrencepicker/RecurrencePickerDialog$RecurrenceModel:endDate	Landroid/text/format/Time;
    //   664: astore_1
    //   665: aload_1
    //   666: aload_1
    //   667: getfield 557	android/text/format/Time:year	I
    //   670: iconst_3
    //   671: iadd
    //   672: putfield 557	android/text/format/Time:year	I
    //   675: goto -315 -> 360
    //   678: iconst_4
    //   679: istore 5
    //   681: iconst_3
    //   682: istore 4
    //   684: aload_0
    //   685: getfield 537	com/android/recurrencepicker/RecurrencePickerDialog:mWeekGroup2	Landroid/widget/LinearLayout;
    //   688: iconst_0
    //   689: invokevirtual 542	android/widget/LinearLayout:setVisibility	(I)V
    //   692: aload_0
    //   693: getfield 537	com/android/recurrencepicker/RecurrencePickerDialog:mWeekGroup2	Landroid/widget/LinearLayout;
    //   696: iconst_3
    //   697: invokevirtual 546	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   700: iconst_4
    //   701: invokevirtual 549	android/view/View:setVisibility	(I)V
    //   704: goto -135 -> 569
    //   707: aload_0
    //   708: getfield 143	com/android/recurrencepicker/RecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   711: iload_3
    //   712: aload_0
    //   713: getfield 551	com/android/recurrencepicker/RecurrencePickerDialog:mWeekGroup	Landroid/widget/LinearLayout;
    //   716: iload 6
    //   718: invokevirtual 546	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   721: checkcast 141	android/widget/ToggleButton
    //   724: aastore
    //   725: aload_0
    //   726: getfield 143	com/android/recurrencepicker/RecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   729: iload_3
    //   730: aaload
    //   731: aload_1
    //   732: aload_0
    //   733: getfield 130	com/android/recurrencepicker/RecurrencePickerDialog:TIME_DAY_TO_CALENDAR_DAY	[I
    //   736: iload_3
    //   737: iaload
    //   738: aaload
    //   739: invokevirtual 561	android/widget/ToggleButton:setTextOff	(Ljava/lang/CharSequence;)V
    //   742: aload_0
    //   743: getfield 143	com/android/recurrencepicker/RecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   746: iload_3
    //   747: aaload
    //   748: aload_1
    //   749: aload_0
    //   750: getfield 130	com/android/recurrencepicker/RecurrencePickerDialog:TIME_DAY_TO_CALENDAR_DAY	[I
    //   753: iload_3
    //   754: iaload
    //   755: aaload
    //   756: invokevirtual 564	android/widget/ToggleButton:setTextOn	(Ljava/lang/CharSequence;)V
    //   759: aload_0
    //   760: getfield 143	com/android/recurrencepicker/RecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   763: iload_3
    //   764: aaload
    //   765: aload_0
    //   766: invokevirtual 565	android/widget/ToggleButton:setOnCheckedChangeListener	(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    //   769: iload_3
    //   770: iconst_1
    //   771: iadd
    //   772: istore 7
    //   774: iload 7
    //   776: istore_3
    //   777: iload 7
    //   779: bipush 7
    //   781: if_icmplt -181 -> 600
    //   784: iconst_0
    //   785: istore_3
    //   786: goto -186 -> 600
    //   789: iconst_0
    //   790: istore 5
    //   792: iload 5
    //   794: iconst_3
    //   795: if_icmpge +115 -> 910
    //   798: iload 5
    //   800: iload 4
    //   802: if_icmplt +26 -> 828
    //   805: aload_0
    //   806: getfield 537	com/android/recurrencepicker/RecurrencePickerDialog:mWeekGroup2	Landroid/widget/LinearLayout;
    //   809: iload 5
    //   811: invokevirtual 546	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   814: bipush 8
    //   816: invokevirtual 549	android/view/View:setVisibility	(I)V
    //   819: iload 5
    //   821: iconst_1
    //   822: iadd
    //   823: istore 5
    //   825: goto -33 -> 792
    //   828: aload_0
    //   829: getfield 143	com/android/recurrencepicker/RecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   832: iload_3
    //   833: aload_0
    //   834: getfield 537	com/android/recurrencepicker/RecurrencePickerDialog:mWeekGroup2	Landroid/widget/LinearLayout;
    //   837: iload 5
    //   839: invokevirtual 546	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   842: checkcast 141	android/widget/ToggleButton
    //   845: aastore
    //   846: aload_0
    //   847: getfield 143	com/android/recurrencepicker/RecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   850: iload_3
    //   851: aaload
    //   852: aload_1
    //   853: aload_0
    //   854: getfield 130	com/android/recurrencepicker/RecurrencePickerDialog:TIME_DAY_TO_CALENDAR_DAY	[I
    //   857: iload_3
    //   858: iaload
    //   859: aaload
    //   860: invokevirtual 561	android/widget/ToggleButton:setTextOff	(Ljava/lang/CharSequence;)V
    //   863: aload_0
    //   864: getfield 143	com/android/recurrencepicker/RecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   867: iload_3
    //   868: aaload
    //   869: aload_1
    //   870: aload_0
    //   871: getfield 130	com/android/recurrencepicker/RecurrencePickerDialog:TIME_DAY_TO_CALENDAR_DAY	[I
    //   874: iload_3
    //   875: iaload
    //   876: aaload
    //   877: invokevirtual 564	android/widget/ToggleButton:setTextOn	(Ljava/lang/CharSequence;)V
    //   880: aload_0
    //   881: getfield 143	com/android/recurrencepicker/RecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   884: iload_3
    //   885: aaload
    //   886: aload_0
    //   887: invokevirtual 565	android/widget/ToggleButton:setOnCheckedChangeListener	(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    //   890: iload_3
    //   891: iconst_1
    //   892: iadd
    //   893: istore 6
    //   895: iload 6
    //   897: istore_3
    //   898: iload 6
    //   900: bipush 7
    //   902: if_icmplt -83 -> 819
    //   905: iconst_0
    //   906: istore_3
    //   907: goto -88 -> 819
    //   910: aload_0
    //   911: getfield 567	com/android/recurrencepicker/RecurrencePickerDialog:mMonthRepeatByRadioGroup	Landroid/widget/RadioGroup;
    //   914: aload_0
    //   915: invokevirtual 572	android/widget/RadioGroup:setOnCheckedChangeListener	(Landroid/widget/RadioGroup$OnCheckedChangeListener;)V
    //   918: aload_0
    //   919: getfield 125	com/android/recurrencepicker/RecurrencePickerDialog:mTime	Landroid/text/format/Time;
    //   922: getfield 351	android/text/format/Time:monthDay	I
    //   925: aload_0
    //   926: getfield 353	com/android/recurrencepicker/RecurrencePickerDialog:mNumDaysInMonth	I
    //   929: if_icmpeq +12 -> 941
    //   932: aload_0
    //   933: getfield 574	com/android/recurrencepicker/RecurrencePickerDialog:mRepeatMonthlyByLastDayOfMonth	Landroid/widget/RadioButton;
    //   936: bipush 8
    //   938: invokevirtual 577	android/widget/RadioButton:setVisibility	(I)V
    //   941: aload_0
    //   942: getfield 579	com/android/recurrencepicker/RecurrencePickerDialog:mDone	Landroid/widget/Button;
    //   945: aload_0
    //   946: invokevirtual 582	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   949: aload_0
    //   950: invokespecial 172	com/android/recurrencepicker/RecurrencePickerDialog:togglePickerOptions	()V
    //   953: aload_0
    //   954: invokevirtual 585	com/android/recurrencepicker/RecurrencePickerDialog:updateDialog	()V
    //   957: return
  }

  private void initializeViews()
  {
    mMainLayout = ((LinearLayout)mView.findViewById(R.id.mainLayout));
    mRepeatText = ((TextView)mView.findViewById(R.id.repeatText));
    mRepeatSwitch = ((Switch)mView.findViewById(R.id.repeat_switch));
    mFreqSpinner = ((Spinner)mView.findViewById(R.id.freqSpinner));
    mInterval = ((EditText)mView.findViewById(R.id.interval));
    mIntervalPreText = ((TextView)mView.findViewById(R.id.intervalPreText));
    mIntervalPostText = ((TextView)mView.findViewById(R.id.intervalPostText));
    mEndSpinner = ((Spinner)mView.findViewById(R.id.endSpinner));
    mEndCount = ((EditText)mView.findViewById(R.id.endCount));
    mPostEndCount = ((TextView)mView.findViewById(R.id.postEndCount));
    mEndDateTextView = ((TextView)mView.findViewById(R.id.endDate));
    mWeekGroup = ((LinearLayout)mView.findViewById(R.id.weekGroup));
    mWeekGroup2 = ((LinearLayout)mView.findViewById(R.id.weekGroup2));
    mMonthGroup = ((LinearLayout)mView.findViewById(R.id.monthGroup));
    mMonthRepeatByRadioGroup = ((RadioGroup)mView.findViewById(R.id.monthGroup));
    mRepeatMonthlyByNthDayOfWeek = ((RadioButton)mView.findViewById(R.id.repeatMonthlyByNthDayOfTheWeek));
    mRepeatMonthlyByNthDayOfMonth = ((RadioButton)mView.findViewById(R.id.repeatMonthlyByNthDayOfMonth));
    mRepeatMonthlyByLastDayOfMonth = ((RadioButton)mView.findViewById(R.id.repeatMonthlyByLastDayOfMonth));
    mDone = ((Button)mView.findViewById(R.id.done));
  }

  public static boolean isSupportedMonthlyByNthDayOfWeek(int paramInt)
  {
    return ((paramInt > 0) && (paramInt <= 5)) || (paramInt == -1);
  }

  private void showWeeklyOnlyUi()
  {
    mRepeatText.setVisibility(0);
    mMainLayout.getLayoutParams().height = -2;
    mFreqSpinner.setVisibility(8);
    mInterval.setVisibility(8);
    mIntervalPreText.setVisibility(8);
    mIntervalPostText.setVisibility(8);
    mEndSpinner.setVisibility(8);
    mEndCount.setVisibility(8);
    mPostEndCount.setVisibility(8);
    mEndDateTextView.setVisibility(8);
    mMonthGroup.setVisibility(8);
    mMonthRepeatByRadioGroup.setVisibility(8);
    mRepeatMonthlyByNthDayOfWeek.setVisibility(8);
    mRepeatMonthlyByNthDayOfMonth.setVisibility(8);
    mRepeatMonthlyByLastDayOfMonth.setVisibility(8);
  }

  private void togglePickerOptions()
  {
    if (mModel.recurrenceState == 0)
    {
      mFreqSpinner.setEnabled(false);
      mEndSpinner.setEnabled(false);
      mIntervalPreText.setEnabled(false);
      mInterval.setEnabled(false);
      mIntervalPostText.setEnabled(false);
      mMonthRepeatByRadioGroup.setEnabled(false);
      mEndCount.setEnabled(false);
      mPostEndCount.setEnabled(false);
      mEndDateTextView.setEnabled(false);
      mRepeatMonthlyByNthDayOfWeek.setEnabled(false);
      mRepeatMonthlyByNthDayOfMonth.setEnabled(false);
      mRepeatMonthlyByLastDayOfMonth.setEnabled(false);
      arrayOfToggleButton = mWeekByDayButtons;
      j = arrayOfToggleButton.length;
      i = 0;
      while (i < j)
      {
        arrayOfToggleButton[i].setEnabled(false);
        i += 1;
      }
    }
    mView.findViewById(R.id.options).setEnabled(true);
    mFreqSpinner.setEnabled(true);
    mEndSpinner.setEnabled(true);
    mIntervalPreText.setEnabled(true);
    mInterval.setEnabled(true);
    mIntervalPostText.setEnabled(true);
    mMonthRepeatByRadioGroup.setEnabled(true);
    mEndCount.setEnabled(true);
    mPostEndCount.setEnabled(true);
    mEndDateTextView.setEnabled(true);
    mRepeatMonthlyByNthDayOfWeek.setEnabled(true);
    mRepeatMonthlyByNthDayOfMonth.setEnabled(true);
    mRepeatMonthlyByLastDayOfMonth.setEnabled(true);
    ToggleButton[] arrayOfToggleButton = mWeekByDayButtons;
    int j = arrayOfToggleButton.length;
    int i = 0;
    while (i < j)
    {
      arrayOfToggleButton[i].setEnabled(true);
      i += 1;
    }
    updateDoneButtonState();
  }

  private void updateDoneButtonState()
  {
    if (mModel.recurrenceState == 0)
    {
      mDone.setEnabled(true);
      return;
    }
    if (mInterval.getText().toString().length() == 0)
    {
      mDone.setEnabled(false);
      return;
    }
    if ((mEndCount.getVisibility() == 0) && (mEndCount.getText().toString().length() == 0))
    {
      mDone.setEnabled(false);
      return;
    }
    if (mModel.freq == 1)
    {
      ToggleButton[] arrayOfToggleButton = mWeekByDayButtons;
      int j = arrayOfToggleButton.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfToggleButton[i].isChecked())
        {
          mDone.setEnabled(true);
          return;
        }
        i += 1;
      }
      mDone.setEnabled(false);
      return;
    }
    mDone.setEnabled(true);
  }

  private void updateEndCountText()
  {
    String str = mResources.getQuantityString(R.plurals.recurrence_end_count, mModel.endCount);
    int i = str.indexOf("%d");
    if (i != -1)
    {
      if (i == 0)
        Log.e(TAG, "No text to put in to recurrence's end spinner.");
    }
    else
      return;
    int j = "%d".length();
    mPostEndCount.setText(str.substring(i + j, str.length()).trim());
  }

  private void updateIntervalText()
  {
    if (mIntervalResId == -1);
    String str;
    int i;
    do
    {
      return;
      str = mResources.getQuantityString(mIntervalResId, mModel.interval);
      i = str.indexOf("%d");
    }
    while (i == -1);
    int j = "%d".length();
    mIntervalPostText.setText(str.substring(i + j, str.length()).trim());
    mIntervalPreText.setText(str.substring(0, i).trim());
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    mDatePickerDialog = ((DatePickerDialog)getFragmentManager().findFragmentByTag("tag_date_picker_frag"));
    if (mDatePickerDialog != null)
      mDatePickerDialog.setOnDateSetListener(this);
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = -1;
    int i = 0;
    while (i < 7)
    {
      int k = j;
      if (j == -1)
      {
        k = j;
        if (paramCompoundButton == mWeekByDayButtons[i])
        {
          k = i;
          mModel.weeklyByDayOfWeek[i] = paramBoolean;
        }
      }
      i += 1;
      j = k;
    }
    updateDialog();
  }

  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt == R.id.repeatMonthlyByNthDayOfMonth)
    {
      mModel.monthlyRepeat = 0;
      mModel.monthlyByMonthDay = mTime.monthDay;
    }
    while (true)
    {
      updateDialog();
      return;
      if (paramInt == R.id.repeatMonthlyByLastDayOfMonth)
      {
        mModel.monthlyRepeat = 0;
        mModel.monthlyByMonthDay = -1;
      }
      else if (paramInt == R.id.repeatMonthlyByNthDayOfTheWeek)
      {
        mModel.monthlyRepeat = 1;
      }
    }
  }

  public void onClick(View paramView)
  {
    if (mEndDateTextView == paramView)
    {
      if (mDatePickerDialog != null)
        mDatePickerDialog.dismiss();
      mDatePickerDialog = DatePickerDialog.newInstance(this, mModel.endDate.year, mModel.endDate.month, mModel.endDate.monthDay);
      mDatePickerDialog.setFirstDayOfWeek(Utils.getFirstDayOfWeekAsCalendar(getActivity()));
      mDatePickerDialog.setYearRange(1970, 2036);
      paramView = Calendar.getInstance();
      paramView.set(mTime.year, mTime.month, mTime.monthDay);
      mDatePickerDialog.setMinDate(paramView);
      mDatePickerDialog.show(getFragmentManager(), "tag_date_picker_frag");
    }
    while (mDone != paramView)
      return;
    if (mModel.recurrenceState == 0);
    for (paramView = null; ; paramView = mRecurrence.toString())
    {
      mRecurrenceSetListener.onRecurrenceSet(paramView);
      dismiss();
      return;
      copyModelToEventRecurrence(mModel, mRecurrence);
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    mRecurrence.wkst = EventRecurrence.timeDay2Day(Utils.getFirstDayOfWeek(getActivity()));
    getDialog().getWindow().requestFeature(1);
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    if (paramBundle != null)
    {
      localObject = (RecurrenceModel)paramBundle.get("bundle_model");
      if (localObject != null)
        mModel = ((RecurrenceModel)localObject);
      bool1 = paramBundle.getBoolean("bundle_end_count_has_focus");
      mIsWeeklyOnly = paramBundle.getBoolean("weekly_only_view");
    }
    while (true)
    {
      initUi(paramLayoutInflater, paramViewGroup);
      if (bool1)
        mEndCount.requestFocus();
      return mView;
      paramBundle = getArguments();
      if (paramBundle != null)
      {
        mTime.set(paramBundle.getLong("bundle_event_start_time"));
        localObject = paramBundle.getString("bundle_event_time_zone");
        if (!TextUtils.isEmpty((CharSequence)localObject))
          mTime.timezone = ((String)localObject);
        mTime.normalize(false);
        localObject = Calendar.getInstance();
        ((Calendar)localObject).set(1, mTime.year);
        ((Calendar)localObject).set(2, mTime.month);
        mNumDaysInMonth = ((Calendar)localObject).getActualMaximum(5);
        mModel.weeklyByDayOfWeek[mTime.weekDay] = true;
        paramBundle = paramBundle.getString("bundle_event_rrule");
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramBundle))
        {
          mModel.recurrenceState = 1;
          mRecurrence.parse(paramBundle);
          copyEventRecurrenceToModel(mRecurrence, mModel);
          if (mRecurrence.bydayCount == 0)
          {
            mModel.weeklyByDayOfWeek[mTime.weekDay] = true;
            bool1 = bool2;
          }
          else
          {
            bool1 = bool2;
            if (mRecurrence.bydayCount == 1)
            {
              bool1 = bool2;
              if (mRecurrence.freq == 6)
              {
                initMonthlyOnWeekDay();
                bool1 = bool2;
              }
            }
          }
        }
      }
      else
      {
        mTime.setToNow();
        bool1 = bool2;
      }
    }
  }

  public void onDateSet(DatePickerDialog paramDatePickerDialog, int paramInt1, int paramInt2, int paramInt3)
  {
    if (mModel.endDate == null)
    {
      mModel.endDate = new Time(mTime.timezone);
      paramDatePickerDialog = mModel.endDate;
      Time localTime = mModel.endDate;
      mModel.endDate.second = 0;
      localTime.minute = 0;
      paramDatePickerDialog.hour = 0;
    }
    mModel.endDate.year = paramInt1;
    mModel.endDate.month = paramInt2;
    mModel.endDate.monthDay = paramInt3;
    mModel.endDate.normalize(false);
    updateDialog();
  }

  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    if (paramAdapterView == mFreqSpinner)
      mModel.freq = paramInt;
    while (paramAdapterView != mEndSpinner)
    {
      updateDialog();
      return;
    }
    switch (paramInt)
    {
    default:
      label60: paramAdapterView = mEndCount;
      if (mModel.end == 2)
      {
        paramInt = 0;
        label78: paramAdapterView.setVisibility(paramInt);
        paramAdapterView = mEndDateTextView;
        if (mModel.end != 1)
          break label228;
        paramInt = 0;
        label101: paramAdapterView.setVisibility(paramInt);
        paramAdapterView = mPostEndCount;
        if ((mModel.end != 2) || (mHidePostEndCount))
          break label234;
      }
      break;
    case 0:
    case 1:
    case 2:
    }
    label228: label234: for (paramInt = i; ; paramInt = 8)
    {
      paramAdapterView.setVisibility(paramInt);
      break;
      mModel.end = 0;
      break label60;
      mModel.end = 1;
      break label60;
      mModel.end = 2;
      if (mModel.endCount <= 1)
        mModel.endCount = 1;
      while (true)
      {
        updateEndCountText();
        break;
        if (mModel.endCount > 730)
          mModel.endCount = 730;
      }
      paramInt = 8;
      break label78;
      paramInt = 8;
      break label101;
    }
  }

  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("bundle_model", mModel);
    if (mEndCount.hasFocus())
      paramBundle.putBoolean("bundle_end_count_has_focus", true);
    if (mIsWeeklyOnly)
      paramBundle.putBoolean("weekly_only_view", true);
  }

  public void updateDialog()
  {
    int j = 8;
    Object localObject = Integer.toString(mModel.interval);
    if (!((String)localObject).equals(mInterval.getText().toString()))
      mInterval.setText((CharSequence)localObject);
    mFreqSpinner.setSelection(mModel.freq);
    localObject = mWeekGroup;
    int i;
    if (mModel.freq == 1)
    {
      i = 0;
      ((LinearLayout)localObject).setVisibility(i);
      localObject = mWeekGroup2;
      if (mModel.freq != 1)
        break label230;
      i = 0;
      label94: ((LinearLayout)localObject).setVisibility(i);
      localObject = mMonthGroup;
      i = j;
      if (mModel.freq == 2)
        i = 0;
      ((LinearLayout)localObject).setVisibility(i);
      switch (mModel.freq)
      {
      default:
        label160: updateIntervalText();
        updateDoneButtonState();
        mEndSpinner.setSelection(mModel.end);
        if (mModel.end == 1)
        {
          localObject = DateUtils.formatDateTime(getActivity(), mModel.endDate.toMillis(false), 131072);
          mEndDateTextView.setText((CharSequence)localObject);
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    label230: 
    do
    {
      do
      {
        return;
        i = 8;
        break;
        i = 8;
        break label94;
        mIntervalResId = R.plurals.recurrence_interval_daily;
        break label160;
        mIntervalResId = R.plurals.recurrence_interval_weekly;
        i = 0;
        while (i < 7)
        {
          mWeekByDayButtons[i].setChecked(mModel.weeklyByDayOfWeek[i]);
          i += 1;
        }
        mIntervalResId = R.plurals.recurrence_interval_monthly;
        if (mModel.monthlyRepeat == 0)
          if (mModel.monthlyByMonthDay == -1)
          {
            mMonthRepeatByRadioGroup.check(R.id.repeatMonthlyByLastDayOfMonth);
            if (mMonthRepeatByDayOfWeekStr != null)
              break label160;
            if (mModel.monthlyByNthDayOfWeek == 0)
              initMonthlyOnWeekDay();
            localObject = mMonthRepeatByDayOfWeekStrs[mModel.monthlyByDayOfWeek];
            if (mModel.monthlyByNthDayOfWeek >= 0)
              break label430;
          }
        for (i = 5; ; i = mModel.monthlyByNthDayOfWeek)
        {
          mMonthRepeatByDayOfWeekStr = localObject[(i - 1)];
          mRepeatMonthlyByNthDayOfWeek.setText(mMonthRepeatByDayOfWeekStr);
          break;
          mMonthRepeatByRadioGroup.check(R.id.repeatMonthlyByNthDayOfMonth);
          break label324;
          if (mModel.monthlyRepeat != 1)
            break label324;
          mMonthRepeatByRadioGroup.check(R.id.repeatMonthlyByNthDayOfTheWeek);
          break label324;
        }
        mIntervalResId = R.plurals.recurrence_interval_yearly;
        break label160;
      }
      while (mModel.end != 2);
      localObject = Integer.toString(mModel.endCount);
    }
    while (((String)localObject).equals(mEndCount.getText().toString()));
    label324: mEndCount.setText((CharSequence)localObject);
    label430:
  }

  private class EndSpinnerAdapter extends ArrayAdapter<CharSequence>
  {
    final String END_COUNT_MARKER = "%d";
    final String END_DATE_MARKER = "%s";
    private String mEndDateString;
    private LayoutInflater mInflater;
    private int mItemResourceId;
    private ArrayList<CharSequence> mStrings;
    private int mTextResourceId;
    private boolean mUseFormStrings;

    public EndSpinnerAdapter(ArrayList<CharSequence> paramInt1, int paramInt2, int arg4)
    {
      super(i, paramInt2);
      mInflater = ((LayoutInflater)paramInt1.getSystemService("layout_inflater"));
      mItemResourceId = i;
      int j;
      mTextResourceId = j;
      mStrings = paramInt2;
      mEndDateString = getResources().getString(R.string.recurrence_end_date);
      if (mEndDateString.indexOf("%s") <= 0)
        mUseFormStrings = true;
      while (true)
      {
        if (mUseFormStrings)
          mEndSpinner.setLayoutParams(new TableLayout.LayoutParams(0, -2, 1.0F));
        return;
        if (getResources().getQuantityString(R.plurals.recurrence_end_count, 1).indexOf("%d") <= 0)
          mUseFormStrings = true;
      }
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
        paramView = mInflater.inflate(mItemResourceId, paramViewGroup, false);
      while (true)
      {
        ((TextView)paramView.findViewById(R.id.spinner_item)).setText((CharSequence)mStrings.get(paramInt));
        return paramView;
      }
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      TextView localTextView;
      if (paramView == null)
      {
        paramView = mInflater.inflate(mTextResourceId, paramViewGroup, false);
        localTextView = (TextView)paramView.findViewById(R.id.spinner_item);
        switch (paramInt)
        {
        default:
          paramViewGroup = null;
        case 0:
        case 1:
        case 2:
        }
      }
      String str;
      int i;
      do
      {
        do
        {
          return paramViewGroup;
          break;
          localTextView.setText((CharSequence)mStrings.get(0));
          return paramView;
          paramInt = mEndDateString.indexOf("%s");
          paramViewGroup = paramView;
        }
        while (paramInt == -1);
        if ((mUseFormStrings) || (paramInt == 0))
        {
          localTextView.setText(mEndDateLabel);
          return paramView;
        }
        localTextView.setText(mEndDateString.substring(0, paramInt).trim());
        return paramView;
        str = mResources.getQuantityString(R.plurals.recurrence_end_count, mModel.endCount);
        i = str.indexOf("%d");
        paramViewGroup = paramView;
      }
      while (i == -1);
      if ((mUseFormStrings) || (i == 0))
      {
        localTextView.setText(mEndCountLabel);
        mPostEndCount.setVisibility(8);
        RecurrencePickerDialog.access$1302(RecurrencePickerDialog.this, true);
        return paramView;
      }
      paramInt = "%d".length();
      mPostEndCount.setText(str.substring(i + paramInt, str.length()).trim());
      if (mModel.end == 2)
        mPostEndCount.setVisibility(0);
      paramInt = i;
      if (str.charAt(i - 1) == ' ')
        paramInt = i - 1;
      localTextView.setText(str.substring(0, paramInt).trim());
      return paramView;
    }
  }

  public static abstract interface OnRecurrenceSetListener
  {
    public abstract void onRecurrenceSet(String paramString);
  }

  private static class RecurrenceModel
    implements Parcelable
  {
    public static final Parcelable.Creator<RecurrenceModel> CREATOR = new Parcelable.Creator()
    {
      public RecurrencePickerDialog.RecurrenceModel createFromParcel(Parcel paramAnonymousParcel)
      {
        RecurrencePickerDialog.RecurrenceModel localRecurrenceModel = new RecurrencePickerDialog.RecurrenceModel();
        localRecurrenceModel.freq = paramAnonymousParcel.readInt();
        localRecurrenceModel.interval = paramAnonymousParcel.readInt();
        localRecurrenceModel.end = paramAnonymousParcel.readInt();
        localRecurrenceModel.endDate.year = paramAnonymousParcel.readInt();
        localRecurrenceModel.endDate.month = paramAnonymousParcel.readInt();
        localRecurrenceModel.endDate.monthDay = paramAnonymousParcel.readInt();
        localRecurrenceModel.endCount = paramAnonymousParcel.readInt();
        localRecurrenceModel.weeklyByDayOfWeek = new boolean[7];
        paramAnonymousParcel.readBooleanArray(localRecurrenceModel.weeklyByDayOfWeek);
        localRecurrenceModel.monthlyRepeat = paramAnonymousParcel.readInt();
        localRecurrenceModel.monthlyByMonthDay = paramAnonymousParcel.readInt();
        localRecurrenceModel.monthlyByDayOfWeek = paramAnonymousParcel.readInt();
        localRecurrenceModel.monthlyByNthDayOfWeek = paramAnonymousParcel.readInt();
        localRecurrenceModel.recurrenceState = paramAnonymousParcel.readInt();
        return localRecurrenceModel;
      }

      public RecurrencePickerDialog.RecurrenceModel[] newArray(int paramAnonymousInt)
      {
        return new RecurrencePickerDialog.RecurrenceModel[paramAnonymousInt];
      }
    };
    int end;
    int endCount = 5;
    Time endDate;
    int freq = 1;
    int interval = 1;
    int monthlyByDayOfWeek;
    int monthlyByMonthDay;
    int monthlyByNthDayOfWeek;
    int monthlyRepeat;
    int recurrenceState;
    boolean[] weeklyByDayOfWeek = new boolean[7];

    public int describeContents()
    {
      return 0;
    }

    public String toString()
    {
      return "Model [freq=" + freq + ", interval=" + interval + ", end=" + end + ", endDate=" + endDate + ", endCount=" + endCount + ", weeklyByDayOfWeek=" + Arrays.toString(weeklyByDayOfWeek) + ", monthlyRepeat=" + monthlyRepeat + ", monthlyByMonthDay=" + monthlyByMonthDay + ", monthlyByDayOfWeek=" + monthlyByDayOfWeek + ", monthlyByNthDayOfWeek=" + monthlyByNthDayOfWeek + "]";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(freq);
      paramParcel.writeInt(interval);
      paramParcel.writeInt(end);
      paramParcel.writeInt(endDate.year);
      paramParcel.writeInt(endDate.month);
      paramParcel.writeInt(endDate.monthDay);
      paramParcel.writeInt(endCount);
      paramParcel.writeBooleanArray(weeklyByDayOfWeek);
      paramParcel.writeInt(monthlyRepeat);
      paramParcel.writeInt(monthlyByMonthDay);
      paramParcel.writeInt(monthlyByDayOfWeek);
      paramParcel.writeInt(monthlyByNthDayOfWeek);
      paramParcel.writeInt(recurrenceState);
    }
  }

  class minMaxTextWatcher
    implements TextWatcher
  {
    private int mDefault;
    private int mMax;
    private int mMin;

    public minMaxTextWatcher(int paramInt1, int paramInt2, int arg4)
    {
      mMin = paramInt1;
      int i;
      mMax = i;
      mDefault = paramInt2;
    }

    public void afterTextChanged(Editable paramEditable)
    {
      int j = 0;
      try
      {
        i = Integer.parseInt(paramEditable.toString());
        if (i < mMin)
        {
          k = mMin;
          j = 1;
          if (j != 0)
          {
            paramEditable.clear();
            paramEditable.append(Integer.toString(k));
          }
          RecurrencePickerDialog.this.updateDoneButtonState();
          onChange(k);
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
        {
          int i = mDefault;
          continue;
          int k = i;
          if (i > mMax)
          {
            j = 1;
            k = mMax;
          }
        }
      }
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
    }

    void onChange(int paramInt)
    {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
    }
  }
}