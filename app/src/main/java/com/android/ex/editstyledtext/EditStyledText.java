package com.android.ex.editstyledtext;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.NoCopySpan.Concrete;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EditStyledText extends EditText
{
  private static final NoCopySpan.Concrete SELECTING = new NoCopySpan.Concrete();
  private static CharSequence STR_CLEARSTYLES;
  private static CharSequence STR_HORIZONTALLINE;
  private static CharSequence STR_PASTE;
  private Drawable mDefaultBackground;
  private ArrayList<EditStyledTextNotifier> mESTNotifiers;
  private InputConnection mInputConnection;
  private EditorManager mManager;

  private void notifyStateChanged(int paramInt1, int paramInt2)
  {
    if (mESTNotifiers != null)
    {
      Iterator localIterator = mESTNotifiers.iterator();
      while (localIterator.hasNext())
        ((EditStyledTextNotifier)localIterator.next()).onStateChanged(paramInt1, paramInt2);
    }
  }

  private void onRefreshStyles()
  {
    mManager.onRefreshStyles();
  }

  private void sendOnTouchEvent(MotionEvent paramMotionEvent)
  {
    if (mESTNotifiers != null)
    {
      Iterator localIterator = mESTNotifiers.iterator();
      while (localIterator.hasNext())
        ((EditStyledTextNotifier)localIterator.next()).sendOnTouchEvent(paramMotionEvent);
    }
  }

  private static void stopSelecting(View paramView, Spannable paramSpannable)
  {
    paramSpannable.removeSpan(SELECTING);
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (mManager != null)
      mManager.onRefreshStyles();
  }

  public int getBackgroundColor()
  {
    return mManager.getBackgroundColor();
  }

  public int getForegroundColor(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > getText().length()));
    ForegroundColorSpan[] arrayOfForegroundColorSpan;
    do
    {
      return -16777216;
      arrayOfForegroundColorSpan = (ForegroundColorSpan[])getText().getSpans(paramInt, paramInt, ForegroundColorSpan.class);
    }
    while (arrayOfForegroundColorSpan.length <= 0);
    return arrayOfForegroundColorSpan[0].getForegroundColor();
  }

  public int getSelectState()
  {
    return mManager.getSelectState();
  }

  public boolean isButtonsFocused()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (mESTNotifiers != null)
    {
      Iterator localIterator = mESTNotifiers.iterator();
      while (true)
      {
        bool2 = bool1;
        if (!localIterator.hasNext())
          break;
        bool1 |= ((EditStyledTextNotifier)localIterator.next()).isButtonsFocused();
      }
    }
    return bool2;
  }

  public boolean isEditting()
  {
    return mManager.isEditting();
  }

  public boolean isSoftKeyBlocked()
  {
    return mManager.isSoftKeyBlocked();
  }

  public boolean isStyledText()
  {
    return mManager.isStyledText();
  }

  public void onClearStyles()
  {
    mManager.onClearStyles();
  }

  protected void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    super.onCreateContextMenu(paramContextMenu);
    MenuHandler localMenuHandler = new MenuHandler(null);
    if (STR_HORIZONTALLINE != null)
      paramContextMenu.add(0, 16776961, 0, STR_HORIZONTALLINE).setOnMenuItemClickListener(localMenuHandler);
    if ((isStyledText()) && (STR_CLEARSTYLES != null))
      paramContextMenu.add(0, 16776962, 0, STR_CLEARSTYLES).setOnMenuItemClickListener(localMenuHandler);
    if (mManager.canPaste())
      paramContextMenu.add(0, 16908322, 0, STR_PASTE).setOnMenuItemClickListener(localMenuHandler).setAlphabeticShortcut('v');
  }

  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    mInputConnection = new StyledTextInputConnection(super.onCreateInputConnection(paramEditorInfo), this);
    return mInputConnection;
  }

  public void onEndEdit()
  {
    mManager.onAction(21);
  }

  public void onFixSelectedItem()
  {
    mManager.onFixSelectedItem();
  }

  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (paramBoolean)
      onStartEdit();
    while (isButtonsFocused())
      return;
    onEndEdit();
  }

  public void onInsertHorizontalLine()
  {
    mManager.onAction(12);
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedStyledTextState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedStyledTextState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setBackgroundColor(paramParcelable.mBackgroundColor);
  }

  public Parcelable onSaveInstanceState()
  {
    SavedStyledTextState localSavedStyledTextState = new SavedStyledTextState(super.onSaveInstanceState());
    localSavedStyledTextState.mBackgroundColor = mManager.getBackgroundColor();
    return localSavedStyledTextState;
  }

  public void onStartCopy()
  {
    mManager.onAction(1);
  }

  public void onStartCut()
  {
    mManager.onAction(7);
  }

  public void onStartEdit()
  {
    mManager.onAction(20);
  }

  public void onStartPaste()
  {
    mManager.onAction(2);
  }

  public void onStartSelect()
  {
    mManager.onStartSelect(true);
  }

  public void onStartSelectAll()
  {
    mManager.onStartSelectAll(true);
  }

  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (mManager != null)
    {
      mManager.updateSpanNextToCursor(getText(), paramInt1, paramInt2, paramInt3);
      mManager.updateSpanPreviousFromCursor(getText(), paramInt1, paramInt2, paramInt3);
      if (paramInt3 <= paramInt2)
        break label92;
      mManager.setTextComposingMask(paramInt1, paramInt1 + paramInt3);
      if (mManager.isWaitInput())
      {
        if (paramInt3 <= paramInt2)
          break label108;
        mManager.onCursorMoved();
        onFixSelectedItem();
      }
    }
    while (true)
    {
      super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      return;
      label92: if (paramInt2 >= paramInt3)
        break;
      mManager.unsetTextComposingMask();
      break;
      label108: if (paramInt3 < paramInt2)
        mManager.onAction(22);
    }
  }

  public boolean onTextContextMenuItem(int paramInt)
  {
    int i;
    if (getSelectionStart() != getSelectionEnd())
      i = 1;
    switch (paramInt)
    {
    default:
    case 16908319:
    case 16908328:
    case 16908329:
      while (true)
      {
        return super.onTextContextMenuItem(paramInt);
        i = 0;
        break;
        onStartSelectAll();
        return true;
        onStartSelect();
        mManager.blockSoftKey();
        continue;
        onFixSelectedItem();
      }
    case 16908322:
      onStartPaste();
      return true;
    case 16908321:
      if (i != 0)
      {
        onStartCopy();
        return true;
      }
      mManager.onStartSelectAll(false);
      onStartCopy();
      return true;
    case 16908320:
      if (i != 0)
      {
        onStartCut();
        return true;
      }
      mManager.onStartSelectAll(false);
      onStartCut();
      return true;
    case 16776961:
      onInsertHorizontalLine();
      return true;
    case 16776962:
      onClearStyles();
      return true;
    case 16776963:
      onStartEdit();
      return true;
    case 16776964:
    }
    onEndEdit();
    return true;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    int j;
    boolean bool1;
    if (paramMotionEvent.getAction() == 1)
    {
      cancelLongPress();
      boolean bool2 = isEditting();
      if (!bool2)
        onStartEdit();
      i = Selection.getSelectionStart(getText());
      j = Selection.getSelectionEnd(getText());
      bool1 = super.onTouchEvent(paramMotionEvent);
      if ((isFocused()) && (getSelectState() == 0))
      {
        if (bool2)
          mManager.showSoftKey(Selection.getSelectionStart(getText()), Selection.getSelectionEnd(getText()));
      }
      else
      {
        mManager.onCursorMoved();
        mManager.unsetTextComposingMask();
      }
    }
    while (true)
    {
      sendOnTouchEvent(paramMotionEvent);
      return bool1;
      mManager.showSoftKey(i, j);
      break;
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
  }

  public void setBackgroundColor(int paramInt)
  {
    if (paramInt != 16777215)
      super.setBackgroundColor(paramInt);
    while (true)
    {
      mManager.setBackgroundColor(paramInt);
      onRefreshStyles();
      return;
      setBackgroundDrawable(mDefaultBackground);
    }
  }

  public class EditModeActions
  {
    private HashMap<Integer, EditModeActionBase> mActionMap;
    private EditStyledText.EditorManager mManager;
    private int mMode;

    private EditModeActionBase getAction(int paramInt)
    {
      if (mActionMap.containsKey(Integer.valueOf(paramInt)))
        return (EditModeActionBase)mActionMap.get(Integer.valueOf(paramInt));
      return null;
    }

    public boolean doNext(int paramInt)
    {
      Log.d("EditModeActions", "--- do the next action: " + paramInt + "," + mManager.getSelectState());
      EditModeActionBase localEditModeActionBase = getAction(paramInt);
      if (localEditModeActionBase == null)
      {
        Log.e("EditModeActions", "--- invalid action error.");
        return false;
      }
      switch (mManager.getSelectState())
      {
      default:
        return false;
      case 0:
        return localEditModeActionBase.doNotSelected();
      case 1:
        return localEditModeActionBase.doStartPosIsSelected();
      case 2:
        return localEditModeActionBase.doEndPosIsSelected();
      case 3:
      }
      if (mManager.isWaitInput())
        return localEditModeActionBase.doSelectionIsFixedAndWaitingInput();
      return localEditModeActionBase.doSelectionIsFixed();
    }

    public void onAction(int paramInt)
    {
      onAction(paramInt, null);
    }

    public void onAction(int paramInt, Object[] paramArrayOfObject)
    {
      getAction(paramInt).addParams(paramArrayOfObject);
      mMode = paramInt;
      doNext(paramInt);
    }

    public void onSelectAction()
    {
      doNext(5);
    }

    public class EditModeActionBase
    {
      private Object[] mParams;

      protected void addParams(Object[] paramArrayOfObject)
      {
        mParams = paramArrayOfObject;
      }

      protected boolean doEndPosIsSelected()
      {
        return doStartPosIsSelected();
      }

      protected boolean doNotSelected()
      {
        return false;
      }

      protected boolean doSelectionIsFixed()
      {
        return doEndPosIsSelected();
      }

      protected boolean doSelectionIsFixedAndWaitingInput()
      {
        return doEndPosIsSelected();
      }

      protected boolean doStartPosIsSelected()
      {
        return doNotSelected();
      }
    }
  }

  public static abstract interface EditStyledTextNotifier
  {
    public abstract boolean isButtonsFocused();

    public abstract void onStateChanged(int paramInt1, int paramInt2);

    public abstract boolean sendOnTouchEvent(MotionEvent paramMotionEvent);
  }

  public static class EditStyledTextSpans
  {
    public static class HorizontalLineDrawable extends ShapeDrawable
    {
      private static boolean DBG_HL = false;
      private Spannable mSpannable;
      private int mWidth;

      private EditStyledText.EditStyledTextSpans.HorizontalLineSpan getParentSpan()
      {
        Object localObject = mSpannable;
        localObject = (EditStyledText.EditStyledTextSpans.HorizontalLineSpan[])((Spannable)localObject).getSpans(0, ((Spannable)localObject).length(), EditStyledText.EditStyledTextSpans.HorizontalLineSpan.class);
        if (localObject.length > 0)
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            EditStyledText.EditStyledTextSpans.HorizontalLineSpan localHorizontalLineSpan = localObject[i];
            if (localHorizontalLineSpan.getDrawable() == this)
              return localHorizontalLineSpan;
            i += 1;
          }
        }
        Log.e("EditStyledTextSpan", "---renewBounds: Couldn't find");
        return null;
      }

      private void renewColor()
      {
        Object localObject = getParentSpan();
        Spannable localSpannable = mSpannable;
        localObject = (ForegroundColorSpan[])localSpannable.getSpans(localSpannable.getSpanStart(localObject), localSpannable.getSpanEnd(localObject), ForegroundColorSpan.class);
        if (DBG_HL)
          Log.d("EditStyledTextSpan", "--- renewColor:" + localObject.length);
        if (localObject.length > 0)
          renewColor(localObject[(localObject.length - 1)].getForegroundColor());
      }

      private void renewColor(int paramInt)
      {
        if (DBG_HL)
          Log.d("EditStyledTextSpan", "--- renewColor:" + paramInt);
        getPaint().setColor(paramInt);
      }

      public void draw(Canvas paramCanvas)
      {
        renewColor();
        paramCanvas.drawRect(new Rect(0, 9, mWidth, 11), getPaint());
      }

      public void renewBounds(int paramInt)
      {
        if (DBG_HL)
          Log.d("EditStyledTextSpan", "--- renewBounds:" + paramInt);
        int i = paramInt;
        if (paramInt > 20)
          i = paramInt - 20;
        mWidth = i;
        setBounds(0, 0, i, 20);
      }
    }

    public static class HorizontalLineSpan extends DynamicDrawableSpan
    {
      EditStyledText.EditStyledTextSpans.HorizontalLineDrawable mDrawable;

      public Drawable getDrawable()
      {
        return mDrawable;
      }

      public void resetWidth(int paramInt)
      {
        mDrawable.renewBounds(paramInt);
      }
    }

    public static class MarqueeSpan extends CharacterStyle
    {
      private int mMarqueeColor;
      private int mType;

      private int getMarqueeColor(int paramInt1, int paramInt2)
      {
        int m = Color.alpha(paramInt2);
        int j = Color.red(paramInt2);
        int k = Color.green(paramInt2);
        int n = Color.blue(paramInt2);
        int i = m;
        if (m == 0)
          i = 128;
        switch (paramInt1)
        {
        default:
          Log.e("EditStyledText", "--- getMarqueeColor: got illigal marquee ID.");
        case 2:
          return 16777215;
        case 0:
          if (j > 128)
          {
            paramInt2 = j / 2;
            paramInt1 = k;
          }
          break;
        case 1:
        }
        while (true)
        {
          return Color.argb(i, paramInt2, paramInt1, n);
          paramInt2 = (255 - j) / 2;
          paramInt1 = k;
          continue;
          if (k > 128)
          {
            paramInt1 = k / 2;
            paramInt2 = j;
          }
          else
          {
            paramInt1 = (255 - k) / 2;
            paramInt2 = j;
          }
        }
      }

      public void resetColor(int paramInt)
      {
        mMarqueeColor = getMarqueeColor(mType, paramInt);
      }

      public void updateDrawState(TextPaint paramTextPaint)
      {
        paramTextPaint.bgColor = mMarqueeColor;
      }
    }

    public static class RescalableImageSpan extends ImageSpan
    {
      private final int MAXWIDTH;
      Uri mContentUri;
      private Context mContext;
      private Drawable mDrawable;
      public int mIntrinsicHeight;
      public int mIntrinsicWidth;

      private void rescaleBigImage(Drawable paramDrawable)
      {
        Log.d("EditStyledTextSpan", "--- rescaleBigImage:");
        if (MAXWIDTH < 0)
          return;
        int m = paramDrawable.getIntrinsicWidth();
        int k = paramDrawable.getIntrinsicHeight();
        Log.d("EditStyledTextSpan", "--- rescaleBigImage:" + m + "," + k + "," + MAXWIDTH);
        int j = k;
        int i = m;
        if (m > MAXWIDTH)
        {
          i = MAXWIDTH;
          j = MAXWIDTH * k / i;
        }
        paramDrawable.setBounds(0, 0, i, j);
      }

      public Drawable getDrawable()
      {
        if (mDrawable != null)
          return mDrawable;
        if (mContentUri != null)
          System.gc();
        while (true)
        {
          try
          {
            InputStream localInputStream = mContext.getContentResolver().openInputStream(mContentUri);
            Object localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
            BitmapFactory.decodeStream(localInputStream, null, (BitmapFactory.Options)localObject);
            localInputStream.close();
            localInputStream = mContext.getContentResolver().openInputStream(mContentUri);
            int j = ((BitmapFactory.Options)localObject).outWidth;
            int i = ((BitmapFactory.Options)localObject).outHeight;
            mIntrinsicWidth = j;
            mIntrinsicHeight = i;
            if (((BitmapFactory.Options)localObject).outWidth > MAXWIDTH)
            {
              j = MAXWIDTH;
              i = MAXWIDTH * i / ((BitmapFactory.Options)localObject).outWidth;
              localObject = BitmapFactory.decodeStream(localInputStream, new Rect(0, 0, j, i), null);
              mDrawable = new BitmapDrawable(mContext.getResources(), (Bitmap)localObject);
              mDrawable.setBounds(0, 0, j, i);
              localInputStream.close();
              return mDrawable;
            }
            localObject = BitmapFactory.decodeStream(localInputStream);
            continue;
          }
          catch (Exception localException)
          {
            Log.e("EditStyledTextSpan", "Failed to loaded content " + mContentUri, localException);
            return null;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            Log.e("EditStyledTextSpan", "OutOfMemoryError");
            return null;
          }
          mDrawable = super.getDrawable();
          rescaleBigImage(mDrawable);
          mIntrinsicWidth = mDrawable.getIntrinsicWidth();
          mIntrinsicHeight = mDrawable.getIntrinsicHeight();
        }
      }
    }
  }

  private class EditorManager
  {
    private EditStyledText.EditModeActions mActions;
    private int mBackgroundColor;
    private int mColorWaitInput;
    private BackgroundColorSpan mComposingTextMask;
    private SpannableStringBuilder mCopyBuffer;
    private int mCurEnd;
    private int mCurStart;
    private EditStyledText mEST;
    private boolean mEditFlag;
    private boolean mKeepNonLineSpan;
    private int mMode;
    private int mSizeWaitInput;
    private EditStyledText.SoftKeyReceiver mSkr;
    private boolean mSoftKeyBlockFlag;
    private int mState;
    private boolean mTextIsFinishedFlag;
    private boolean mWaitInputFlag;

    private void endEdit()
    {
      Log.d("EditStyledText.EditorManager", "--- handleCancel");
      mMode = 0;
      mState = 0;
      mEditFlag = false;
      mColorWaitInput = 16777215;
      mSizeWaitInput = 0;
      mWaitInputFlag = false;
      mSoftKeyBlockFlag = false;
      mKeepNonLineSpan = false;
      mTextIsFinishedFlag = false;
      unsetSelect();
      mEST.setOnClickListener(null);
      unblockSoftKey();
    }

    private int findLineEnd(Editable paramEditable, int paramInt)
    {
      int i = paramInt;
      while (true)
      {
        int j = i;
        if (i < paramEditable.length())
        {
          if (paramEditable.charAt(i) == '\n')
            j = i + 1;
        }
        else
        {
          Log.d("EditStyledText.EditorManager", "--- findLineEnd:" + paramInt + "," + paramEditable.length() + "," + j);
          return j;
        }
        i += 1;
      }
    }

    private int findLineStart(Editable paramEditable, int paramInt)
    {
      int i = paramInt;
      while (true)
      {
        if ((i <= 0) || (paramEditable.charAt(i - 1) == '\n'))
        {
          Log.d("EditStyledText.EditorManager", "--- findLineStart:" + paramInt + "," + paramEditable.length() + "," + i);
          return i;
        }
        i -= 1;
      }
    }

    private void fixSelectionAndDoNextAction()
    {
      Log.d("EditStyledText.EditorManager", "--- handleComplete:" + mCurStart + "," + mCurEnd);
      if (!mEditFlag)
        return;
      if (mCurStart == mCurEnd)
      {
        Log.d("EditStyledText.EditorManager", "--- cancel handle complete:" + mCurStart);
        resetEdit();
        return;
      }
      if (mState == 2)
        mState = 3;
      mActions.doNext(mMode);
      EditStyledText.stopSelecting(mEST, mEST.getText());
    }

    private void handleSelectAll()
    {
      if (!mEditFlag)
        return;
      mActions.onAction(11);
    }

    private SpannableStringBuilder removeImageChar(SpannableStringBuilder paramSpannableStringBuilder)
    {
      paramSpannableStringBuilder = new SpannableStringBuilder(paramSpannableStringBuilder);
      DynamicDrawableSpan[] arrayOfDynamicDrawableSpan = (DynamicDrawableSpan[])paramSpannableStringBuilder.getSpans(0, paramSpannableStringBuilder.length(), DynamicDrawableSpan.class);
      int j = arrayOfDynamicDrawableSpan.length;
      int i = 0;
      while (i < j)
      {
        DynamicDrawableSpan localDynamicDrawableSpan = arrayOfDynamicDrawableSpan[i];
        if (((localDynamicDrawableSpan instanceof EditStyledText.EditStyledTextSpans.HorizontalLineSpan)) || ((localDynamicDrawableSpan instanceof EditStyledText.EditStyledTextSpans.RescalableImageSpan)))
          paramSpannableStringBuilder.replace(paramSpannableStringBuilder.getSpanStart(localDynamicDrawableSpan), paramSpannableStringBuilder.getSpanEnd(localDynamicDrawableSpan), "");
        i += 1;
      }
      return paramSpannableStringBuilder;
    }

    private void resetEdit()
    {
      endEdit();
      mEditFlag = true;
      mEST.notifyStateChanged(mMode, mState);
    }

    private void unsetSelect()
    {
      Log.d("EditStyledText.EditorManager", "--- offSelect");
      EditStyledText.stopSelecting(mEST, mEST.getText());
      int i = mEST.getSelectionStart();
      mEST.setSelection(i, i);
      mState = 0;
    }

    public void blockSoftKey()
    {
      Log.d("EditStyledText.EditorManager", "--- blockSoftKey:");
      hideSoftKey();
      mSoftKeyBlockFlag = true;
    }

    public boolean canPaste()
    {
      return (mCopyBuffer != null) && (mCopyBuffer.length() > 0) && (removeImageChar(mCopyBuffer).length() == 0);
    }

    public int getBackgroundColor()
    {
      return mBackgroundColor;
    }

    public int getSelectState()
    {
      return mState;
    }

    public void hideSoftKey()
    {
      Log.d("EditStyledText.EditorManager", "--- hidesoftkey");
      if (!mEST.isFocused())
        return;
      mSkr.mNewStart = Selection.getSelectionStart(mEST.getText());
      mSkr.mNewEnd = Selection.getSelectionEnd(mEST.getText());
      ((InputMethodManager)mEST.getContext().getSystemService("input_method")).hideSoftInputFromWindow(mEST.getWindowToken(), 0, mSkr);
    }

    public boolean isEditting()
    {
      return mEditFlag;
    }

    public boolean isSoftKeyBlocked()
    {
      return mSoftKeyBlockFlag;
    }

    public boolean isStyledText()
    {
      Editable localEditable = mEST.getText();
      int i = localEditable.length();
      return (((ParagraphStyle[])localEditable.getSpans(0, i, ParagraphStyle.class)).length > 0) || (((QuoteSpan[])localEditable.getSpans(0, i, QuoteSpan.class)).length > 0) || (((CharacterStyle[])localEditable.getSpans(0, i, CharacterStyle.class)).length > 0) || (mBackgroundColor != 16777215);
    }

    public boolean isWaitInput()
    {
      return mWaitInputFlag;
    }

    public void onAction(int paramInt)
    {
      onAction(paramInt, true);
    }

    public void onAction(int paramInt, boolean paramBoolean)
    {
      mActions.onAction(paramInt);
      if (paramBoolean)
        mEST.notifyStateChanged(mMode, mState);
    }

    public void onClearStyles()
    {
      mActions.onAction(14);
    }

    public void onCursorMoved()
    {
      Log.d("EditStyledText.EditorManager", "--- onClickView");
      if ((mState == 1) || (mState == 2))
      {
        mActions.onSelectAction();
        mEST.notifyStateChanged(mMode, mState);
      }
    }

    public void onFixSelectedItem()
    {
      Log.d("EditStyledText.EditorManager", "--- onFixSelectedItem");
      fixSelectionAndDoNextAction();
      mEST.notifyStateChanged(mMode, mState);
    }

    public void onRefreshStyles()
    {
      Log.d("EditStyledText.EditorManager", "--- onRefreshStyles");
      Editable localEditable = mEST.getText();
      int j = localEditable.length();
      int k = mEST.getWidth();
      EditStyledText.EditStyledTextSpans.HorizontalLineSpan[] arrayOfHorizontalLineSpan = (EditStyledText.EditStyledTextSpans.HorizontalLineSpan[])localEditable.getSpans(0, j, EditStyledText.EditStyledTextSpans.HorizontalLineSpan.class);
      int m = arrayOfHorizontalLineSpan.length;
      int i = 0;
      while (i < m)
      {
        arrayOfHorizontalLineSpan[i].resetWidth(k);
        i += 1;
      }
      EditStyledText.EditStyledTextSpans.MarqueeSpan[] arrayOfMarqueeSpan = (EditStyledText.EditStyledTextSpans.MarqueeSpan[])localEditable.getSpans(0, j, EditStyledText.EditStyledTextSpans.MarqueeSpan.class);
      j = arrayOfMarqueeSpan.length;
      i = 0;
      while (i < j)
      {
        arrayOfMarqueeSpan[i].resetColor(mEST.getBackgroundColor());
        i += 1;
      }
      if (arrayOfHorizontalLineSpan.length > 0)
        localEditable.replace(0, 1, "" + localEditable.charAt(0));
    }

    public void onStartSelect(boolean paramBoolean)
    {
      Log.d("EditStyledText.EditorManager", "--- onClickSelect");
      mMode = 5;
      if (mState == 0)
        mActions.onSelectAction();
      while (true)
      {
        if (paramBoolean)
          mEST.notifyStateChanged(mMode, mState);
        return;
        unsetSelect();
        mActions.onSelectAction();
      }
    }

    public void onStartSelectAll(boolean paramBoolean)
    {
      Log.d("EditStyledText.EditorManager", "--- onClickSelectAll");
      handleSelectAll();
      if (paramBoolean)
        mEST.notifyStateChanged(mMode, mState);
    }

    public void setBackgroundColor(int paramInt)
    {
      mBackgroundColor = paramInt;
    }

    public void setTextComposingMask(int paramInt1, int paramInt2)
    {
      Log.d("EditStyledText", "--- setTextComposingMask:" + paramInt1 + "," + paramInt2);
      int i = Math.min(paramInt1, paramInt2);
      paramInt2 = Math.max(paramInt1, paramInt2);
      if ((isWaitInput()) && (mColorWaitInput != 16777215));
      for (paramInt1 = mColorWaitInput; ; paramInt1 = mEST.getForegroundColor(i))
      {
        int j = mEST.getBackgroundColor();
        Log.d("EditStyledText", "--- fg:" + Integer.toHexString(paramInt1) + ",bg:" + Integer.toHexString(j) + "," + isWaitInput() + "," + "," + mMode);
        if (paramInt1 == j)
        {
          paramInt1 = 0x80000000 | (0xFF000000 | j) ^ 0xFFFFFFFF;
          if ((mComposingTextMask == null) || (mComposingTextMask.getBackgroundColor() != paramInt1))
            mComposingTextMask = new BackgroundColorSpan(paramInt1);
          mEST.getText().setSpan(mComposingTextMask, i, paramInt2, 33);
        }
        return;
      }
    }

    public void showSoftKey(int paramInt1, int paramInt2)
    {
      Log.d("EditStyledText.EditorManager", "--- showsoftkey");
      if ((!mEST.isFocused()) || (isSoftKeyBlocked()));
      do
      {
        return;
        mSkr.mNewStart = Selection.getSelectionStart(mEST.getText());
        mSkr.mNewEnd = Selection.getSelectionEnd(mEST.getText());
      }
      while ((!((InputMethodManager)this$0.getContext().getSystemService("input_method")).showSoftInput(mEST, 0, mSkr)) || (mSkr == null));
      Selection.setSelection(this$0.getText(), paramInt1, paramInt2);
    }

    public void unblockSoftKey()
    {
      Log.d("EditStyledText.EditorManager", "--- unblockSoftKey:");
      mSoftKeyBlockFlag = false;
    }

    public void unsetTextComposingMask()
    {
      Log.d("EditStyledText", "--- unsetTextComposingMask");
      if (mComposingTextMask != null)
      {
        mEST.getText().removeSpan(mComposingTextMask);
        mComposingTextMask = null;
      }
    }

    public void updateSpanNextToCursor(Editable paramEditable, int paramInt1, int paramInt2, int paramInt3)
    {
      Log.d("EditStyledText.EditorManager", "updateSpanNext:" + paramInt1 + "," + paramInt2 + "," + paramInt3);
      int k = paramInt1 + paramInt3;
      int j = Math.min(paramInt1, k);
      paramInt1 = Math.max(paramInt1, k);
      Object[] arrayOfObject = paramEditable.getSpans(paramInt1, paramInt1, Object.class);
      int m = arrayOfObject.length;
      paramInt1 = 0;
      if (paramInt1 < m)
      {
        Object localObject = arrayOfObject[paramInt1];
        int n;
        int i1;
        if (((localObject instanceof EditStyledText.EditStyledTextSpans.MarqueeSpan)) || ((localObject instanceof AlignmentSpan)))
        {
          n = paramEditable.getSpanStart(localObject);
          i1 = paramEditable.getSpanEnd(localObject);
          Log.d("EditStyledText.EditorManager", "spantype:" + localObject.getClass() + "," + i1);
          int i = j;
          if (((localObject instanceof EditStyledText.EditStyledTextSpans.MarqueeSpan)) || ((localObject instanceof AlignmentSpan)))
            i = findLineStart(mEST.getText(), j);
          if ((i < n) && (paramInt2 > paramInt3))
            paramEditable.removeSpan(localObject);
        }
        while (true)
        {
          paramInt1 += 1;
          break;
          if (n > j)
          {
            paramEditable.setSpan(localObject, j, i1, 33);
            continue;
            if (((localObject instanceof EditStyledText.EditStyledTextSpans.HorizontalLineSpan)) && (paramEditable.getSpanStart(localObject) == k) && (k > 0) && (mEST.getText().charAt(k - 1) != '\n'))
            {
              mEST.getText().insert(k, "\n");
              mEST.setSelection(k);
            }
          }
        }
      }
    }

    public void updateSpanPreviousFromCursor(Editable paramEditable, int paramInt1, int paramInt2, int paramInt3)
    {
      Log.d("EditStyledText.EditorManager", "updateSpanPrevious:" + paramInt1 + "," + paramInt2 + "," + paramInt3);
      int m = paramInt1 + paramInt3;
      int i = Math.min(paramInt1, m);
      int j = Math.max(paramInt1, m);
      Object[] arrayOfObject = paramEditable.getSpans(i, i, Object.class);
      int n = arrayOfObject.length;
      i = 0;
      if (i < n)
      {
        Object localObject = arrayOfObject[i];
        int k;
        if (((localObject instanceof ForegroundColorSpan)) || ((localObject instanceof AbsoluteSizeSpan)) || ((localObject instanceof EditStyledText.EditStyledTextSpans.MarqueeSpan)) || ((localObject instanceof AlignmentSpan)))
        {
          int i1 = paramEditable.getSpanStart(localObject);
          k = paramEditable.getSpanEnd(localObject);
          Log.d("EditStyledText.EditorManager", "spantype:" + localObject.getClass() + "," + i1);
          paramInt1 = j;
          if (((localObject instanceof EditStyledText.EditStyledTextSpans.MarqueeSpan)) || ((localObject instanceof AlignmentSpan)))
          {
            paramInt1 = findLineEnd(mEST.getText(), j);
            label228: if (k < paramInt1)
            {
              Log.d("EditStyledText.EditorManager", "updateSpanPrevious: extend span");
              paramEditable.setSpan(localObject, i1, paramInt1, 33);
            }
          }
        }
        while (true)
        {
          i += 1;
          break;
          if (!mKeepNonLineSpan)
            break label228;
          paramInt1 = k;
          break label228;
          if ((localObject instanceof EditStyledText.EditStyledTextSpans.HorizontalLineSpan))
          {
            paramInt1 = paramEditable.getSpanStart(localObject);
            k = paramEditable.getSpanEnd(localObject);
            if (paramInt2 > paramInt3)
            {
              paramEditable.replace(paramInt1, k, "");
              paramEditable.removeSpan(localObject);
            }
            else if ((k == m) && (m < paramEditable.length()) && (mEST.getText().charAt(m) != '\n'))
            {
              mEST.getText().insert(m, "\n");
            }
          }
        }
      }
    }
  }

  private class MenuHandler
    implements MenuItem.OnMenuItemClickListener
  {
    private MenuHandler()
    {
    }

    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return onTextContextMenuItem(paramMenuItem.getItemId());
    }
  }

  public static class SavedStyledTextState extends View.BaseSavedState
  {
    public int mBackgroundColor;

    SavedStyledTextState(Parcelable paramParcelable)
    {
      super();
    }

    public String toString()
    {
      return "EditStyledText.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " bgcolor=" + mBackgroundColor + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(mBackgroundColor);
    }
  }

  private static class SoftKeyReceiver extends ResultReceiver
  {
    EditStyledText mEST;
    int mNewEnd;
    int mNewStart;

    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      if (paramInt != 2)
        Selection.setSelection(mEST.getText(), mNewStart, mNewEnd);
    }
  }

  public static class StyledTextInputConnection extends InputConnectionWrapper
  {
    EditStyledText mEST;

    public StyledTextInputConnection(InputConnection paramInputConnection, EditStyledText paramEditStyledText)
    {
      super(true);
      mEST = paramEditStyledText;
    }

    public boolean commitText(CharSequence paramCharSequence, int paramInt)
    {
      Log.d("EditStyledText", "--- commitText:");
      mEST.mManager.unsetTextComposingMask();
      return super.commitText(paramCharSequence, paramInt);
    }

    public boolean finishComposingText()
    {
      Log.d("EditStyledText", "--- finishcomposing:");
      if ((!mEST.isSoftKeyBlocked()) && (!mEST.isButtonsFocused()) && (!mEST.isEditting()))
        mEST.onEndEdit();
      return super.finishComposingText();
    }
  }
}