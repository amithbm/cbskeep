package android.support.v7.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.view.CollapsibleActionView;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import java.lang.reflect.Method;

public class SearchView extends LinearLayoutCompat
  implements CollapsibleActionView
{
  static final AutoCompleteTextViewReflector HIDDEN_METHOD_INVOKER;
  private static final boolean IS_AT_LEAST_FROYO;
  private Bundle mAppSearchData;
  private boolean mClearingFocus;
  private final ImageView mCloseButton;
  private final ImageView mCollapsedIcon;
  private int mCollapsedImeOptions;
  private boolean mExpandedInActionView;
  private final ImageView mGoButton;
  private boolean mIconified;
  private boolean mIconifiedByDefault;
  private int mMaxWidth;
  private OnCloseListener mOnCloseListener;
  private OnQueryTextListener mOnQueryChangeListener;
  private View.OnClickListener mOnSearchClickListener;
  private Runnable mReleaseCursorRunnable;
  private final ImageView mSearchButton;
  private final View mSearchEditFrame;
  private final SearchAutoComplete mSearchSrcTextView;
  private SearchableInfo mSearchable;
  private Runnable mShowImeRunnable;
  private final View mSubmitArea;
  private boolean mSubmitButtonEnabled;
  private final Runnable mUpdateDrawableStateRunnable;
  private CharSequence mUserQuery;
  private final ImageView mVoiceButton;
  private boolean mVoiceButtonEnabled;

  static
  {
    if (Build.VERSION.SDK_INT >= 8);
    for (boolean bool = true; ; bool = false)
    {
      IS_AT_LEAST_FROYO = bool;
      HIDDEN_METHOD_INVOKER = new AutoCompleteTextViewReflector();
      return;
    }
  }

  private Intent createIntent(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    paramString1 = new Intent(paramString1);
    paramString1.addFlags(268435456);
    if (paramUri != null)
      paramString1.setData(paramUri);
    paramString1.putExtra("user_query", mUserQuery);
    if (paramString3 != null)
      paramString1.putExtra("query", paramString3);
    if (paramString2 != null)
      paramString1.putExtra("intent_extra_data_key", paramString2);
    if (mAppSearchData != null)
      paramString1.putExtra("app_data", mAppSearchData);
    if (paramInt != 0)
    {
      paramString1.putExtra("action_key", paramInt);
      paramString1.putExtra("action_msg", paramString4);
    }
    if (IS_AT_LEAST_FROYO)
      paramString1.setComponent(mSearchable.getSearchActivity());
    return paramString1;
  }

  private void dismissSuggestions()
  {
    mSearchSrcTextView.dismissDropDown();
  }

  private void forceSuggestionQuery()
  {
    HIDDEN_METHOD_INVOKER.doBeforeTextChanged(mSearchSrcTextView);
    HIDDEN_METHOD_INVOKER.doAfterTextChanged(mSearchSrcTextView);
  }

  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
  }

  static boolean isLandscapeMode(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
  }

  private boolean isSubmitAreaEnabled()
  {
    return ((mSubmitButtonEnabled) || (mVoiceButtonEnabled)) && (!isIconified());
  }

  private void launchQuerySearch(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = createIntent("android.intent.action.SEARCH", null, null, paramString2, paramInt, paramString1);
    getContext().startActivity(paramString1);
  }

  private void onCloseClicked()
  {
    if (TextUtils.isEmpty(mSearchSrcTextView.getText()))
    {
      if ((mIconifiedByDefault) && ((mOnCloseListener == null) || (!mOnCloseListener.onClose())))
      {
        clearFocus();
        updateViewsVisibility(true);
      }
      return;
    }
    mSearchSrcTextView.setText("");
    mSearchSrcTextView.requestFocus();
    setImeVisibility(true);
  }

  private void onSearchClicked()
  {
    updateViewsVisibility(false);
    mSearchSrcTextView.requestFocus();
    setImeVisibility(true);
    if (mOnSearchClickListener != null)
      mOnSearchClickListener.onClick(this);
  }

  private void onSubmitQuery()
  {
    Editable localEditable = mSearchSrcTextView.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0) && ((mOnQueryChangeListener == null) || (!mOnQueryChangeListener.onQueryTextSubmit(localEditable.toString()))))
    {
      if (mSearchable != null)
        launchQuerySearch(0, null, localEditable.toString());
      setImeVisibility(false);
      dismissSuggestions();
    }
  }

  private void postUpdateFocusedState()
  {
    post(mUpdateDrawableStateRunnable);
  }

  private void setImeVisibility(boolean paramBoolean)
  {
    if (paramBoolean)
      post(mShowImeRunnable);
    InputMethodManager localInputMethodManager;
    do
    {
      return;
      removeCallbacks(mShowImeRunnable);
      localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    }
    while (localInputMethodManager == null);
    localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
  }

  private void updateCloseButton()
  {
    int m = 1;
    int k = 0;
    int i;
    int j;
    label44: label56: Drawable localDrawable;
    if (!TextUtils.isEmpty(mSearchSrcTextView.getText()))
    {
      i = 1;
      j = m;
      if (i == 0)
      {
        if ((!mIconifiedByDefault) || (mExpandedInActionView))
          break label99;
        j = m;
      }
      localObject = mCloseButton;
      if (j == 0)
        break label104;
      j = k;
      ((ImageView)localObject).setVisibility(j);
      localDrawable = mCloseButton.getDrawable();
      if (localDrawable != null)
        if (i == 0)
          break label110;
    }
    label99: label104: label110: for (Object localObject = ENABLED_STATE_SET; ; localObject = EMPTY_STATE_SET)
    {
      localDrawable.setState((int[])localObject);
      return;
      i = 0;
      break;
      j = 0;
      break label44;
      j = 8;
      break label56;
    }
  }

  private void updateSubmitArea()
  {
    int j = 8;
    int i = j;
    if (isSubmitAreaEnabled())
      if (mGoButton.getVisibility() != 0)
      {
        i = j;
        if (mVoiceButton.getVisibility() != 0);
      }
      else
      {
        i = 0;
      }
    mSubmitArea.setVisibility(i);
  }

  private void updateSubmitButton(boolean paramBoolean)
  {
    int j = 8;
    int i = j;
    if (mSubmitButtonEnabled)
    {
      i = j;
      if (isSubmitAreaEnabled())
      {
        i = j;
        if (hasFocus())
          if (!paramBoolean)
          {
            i = j;
            if (mVoiceButtonEnabled);
          }
          else
          {
            i = 0;
          }
      }
    }
    mGoButton.setVisibility(i);
  }

  private void updateViewsVisibility(boolean paramBoolean)
  {
    boolean bool2 = true;
    int j = 8;
    mIconified = paramBoolean;
    int i;
    boolean bool1;
    if (paramBoolean)
    {
      i = 0;
      if (TextUtils.isEmpty(mSearchSrcTextView.getText()))
        break label115;
      bool1 = true;
      label33: mSearchButton.setVisibility(i);
      updateSubmitButton(bool1);
      Object localObject = mSearchEditFrame;
      if (!paramBoolean)
        break label121;
      i = 8;
      label60: ((View)localObject).setVisibility(i);
      localObject = mCollapsedIcon;
      if (!mIconifiedByDefault)
        break label126;
      i = j;
      label81: ((ImageView)localObject).setVisibility(i);
      updateCloseButton();
      if (bool1)
        break label131;
    }
    label131: for (paramBoolean = bool2; ; paramBoolean = false)
    {
      updateVoiceButton(paramBoolean);
      updateSubmitArea();
      return;
      i = 8;
      break;
      label115: bool1 = false;
      break label33;
      label121: i = 0;
      break label60;
      label126: i = 0;
      break label81;
    }
  }

  private void updateVoiceButton(boolean paramBoolean)
  {
    int j = 8;
    int i = j;
    if (mVoiceButtonEnabled)
    {
      i = j;
      if (!isIconified())
      {
        i = j;
        if (paramBoolean)
        {
          i = 0;
          mGoButton.setVisibility(8);
        }
      }
    }
    mVoiceButton.setVisibility(i);
  }

  public void clearFocus()
  {
    mClearingFocus = true;
    setImeVisibility(false);
    super.clearFocus();
    mSearchSrcTextView.clearFocus();
    mClearingFocus = false;
  }

  public boolean isIconified()
  {
    return mIconified;
  }

  public void onActionViewCollapsed()
  {
    setQuery("", false);
    clearFocus();
    updateViewsVisibility(true);
    mSearchSrcTextView.setImeOptions(mCollapsedImeOptions);
    mExpandedInActionView = false;
  }

  public void onActionViewExpanded()
  {
    if (mExpandedInActionView)
      return;
    mExpandedInActionView = true;
    mCollapsedImeOptions = mSearchSrcTextView.getImeOptions();
    mSearchSrcTextView.setImeOptions(mCollapsedImeOptions | 0x2000000);
    mSearchSrcTextView.setText("");
    setIconified(false);
  }

  protected void onDetachedFromWindow()
  {
    removeCallbacks(mUpdateDrawableStateRunnable);
    post(mReleaseCursorRunnable);
    super.onDetachedFromWindow();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (isIconified())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    switch (j)
    {
    default:
      paramInt1 = i;
    case -2147483648:
    case 1073741824:
      while (true)
      {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
        return;
        if (mMaxWidth > 0)
        {
          paramInt1 = Math.min(mMaxWidth, i);
        }
        else
        {
          paramInt1 = Math.min(getPreferredWidth(), i);
          continue;
          paramInt1 = i;
          if (mMaxWidth > 0)
            paramInt1 = Math.min(mMaxWidth, i);
        }
      }
    case 0:
    }
    if (mMaxWidth > 0);
    for (paramInt1 = mMaxWidth; ; paramInt1 = getPreferredWidth())
      break;
  }

  void onTextFocusChanged()
  {
    updateViewsVisibility(isIconified());
    postUpdateFocusedState();
    if (mSearchSrcTextView.hasFocus())
      forceSuggestionQuery();
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    postUpdateFocusedState();
  }

  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    boolean bool1;
    if (mClearingFocus)
      bool1 = false;
    boolean bool2;
    do
    {
      return bool1;
      if (!isFocusable())
        return false;
      if (isIconified())
        break;
      bool2 = mSearchSrcTextView.requestFocus(paramInt, paramRect);
      bool1 = bool2;
    }
    while (!bool2);
    updateViewsVisibility(false);
    return bool2;
    return super.requestFocus(paramInt, paramRect);
  }

  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      onCloseClicked();
      return;
    }
    onSearchClicked();
  }

  public void setQuery(CharSequence paramCharSequence, boolean paramBoolean)
  {
    mSearchSrcTextView.setText(paramCharSequence);
    if (paramCharSequence != null)
    {
      mSearchSrcTextView.setSelection(mSearchSrcTextView.length());
      mUserQuery = paramCharSequence;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramCharSequence)))
      onSubmitQuery();
  }

  private static class AutoCompleteTextViewReflector
  {
    private Method doAfterTextChanged;
    private Method doBeforeTextChanged;
    private Method ensureImeVisible;
    private Method showSoftInputUnchecked;

    AutoCompleteTextViewReflector()
    {
      try
      {
        doBeforeTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
        doBeforeTextChanged.setAccessible(true);
        try
        {
          label27: doAfterTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
          doAfterTextChanged.setAccessible(true);
          try
          {
            label50: ensureImeVisible = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
            ensureImeVisible.setAccessible(true);
            try
            {
              label79: showSoftInputUnchecked = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[] { Integer.TYPE, ResultReceiver.class });
              showSoftInputUnchecked.setAccessible(true);
              return;
            }
            catch (NoSuchMethodException localNoSuchMethodException1)
            {
            }
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            break label79;
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          break label50;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException4)
      {
        break label27;
      }
    }

    void doAfterTextChanged(AutoCompleteTextView paramAutoCompleteTextView)
    {
      if (doAfterTextChanged != null);
      try
      {
        doAfterTextChanged.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView)
      {
      }
    }

    void doBeforeTextChanged(AutoCompleteTextView paramAutoCompleteTextView)
    {
      if (doBeforeTextChanged != null);
      try
      {
        doBeforeTextChanged.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView)
      {
      }
    }

    void ensureImeVisible(AutoCompleteTextView paramAutoCompleteTextView, boolean paramBoolean)
    {
      if (ensureImeVisible != null);
      try
      {
        ensureImeVisible.invoke(paramAutoCompleteTextView, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      catch (Exception paramAutoCompleteTextView)
      {
      }
    }
  }

  public static abstract interface OnCloseListener
  {
    public abstract boolean onClose();
  }

  public static abstract interface OnQueryTextListener
  {
    public abstract boolean onQueryTextSubmit(String paramString);
  }

  public static class SearchAutoComplete extends AppCompatAutoCompleteTextView
  {
    private SearchView mSearchView;
    private int mThreshold = getThreshold();

    public SearchAutoComplete(Context paramContext)
    {
      this(paramContext, null);
    }

    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }

    public boolean enoughToFilter()
    {
      return (mThreshold <= 0) || (super.enoughToFilter());
    }

    protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      mSearchView.onTextFocusChanged();
    }

    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null)
            localDispatcherState.startTracking(paramKeyEvent, this);
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null)
            localDispatcherState.handleUpEvent(paramKeyEvent);
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            mSearchView.clearFocus();
            mSearchView.setImeVisibility(false);
            return true;
          }
        }
      }
      return super.onKeyPreIme(paramInt, paramKeyEvent);
    }

    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      if ((paramBoolean) && (mSearchView.hasFocus()) && (getVisibility() == 0))
      {
        ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this, 0);
        if (SearchView.isLandscapeMode(getContext()))
          SearchView.HIDDEN_METHOD_INVOKER.ensureImeVisible(this, true);
      }
    }

    public void performCompletion()
    {
    }

    protected void replaceText(CharSequence paramCharSequence)
    {
    }

    public void setThreshold(int paramInt)
    {
      super.setThreshold(paramInt);
      mThreshold = paramInt;
    }
  }
}