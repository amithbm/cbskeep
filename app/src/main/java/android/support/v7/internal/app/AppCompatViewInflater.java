package android.support.v7.internal.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.util.ArrayMap;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.ContextThemeWrapper;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;

public class AppCompatViewInflater
{
  private static final Map<String, Constructor<? extends View>> sConstructorMap = new ArrayMap();
  static final Class<?>[] sConstructorSignature = { Context.class, AttributeSet.class };
  private final Object[] mConstructorArgs = new Object[2];

  private View createView(Context paramContext, String paramString1, String paramString2)
    throws ClassNotFoundException, InflateException
  {
    Constructor localConstructor = (Constructor)sConstructorMap.get(paramString1);
    Object localObject = localConstructor;
    if (localConstructor == null);
    try
    {
      localObject = paramContext.getClassLoader();
      if (paramString2 != null);
      for (paramContext = paramString2 + paramString1; ; paramContext = paramString1)
      {
        localObject = ((ClassLoader)localObject).loadClass(paramContext).asSubclass(View.class).getConstructor(sConstructorSignature);
        sConstructorMap.put(paramString1, localObject);
        ((Constructor)localObject).setAccessible(true);
        paramContext = (View)((Constructor)localObject).newInstance(mConstructorArgs);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
    }
    return null;
  }

  private View createViewFromTag(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    String str = paramString;
    if (paramString.equals("view"))
      str = paramAttributeSet.getAttributeValue(null, "class");
    try
    {
      mConstructorArgs[0] = paramContext;
      mConstructorArgs[1] = paramAttributeSet;
      if (-1 == str.indexOf('.'))
      {
        paramContext = createView(paramContext, str, "android.widget.");
        return paramContext;
      }
      paramContext = createView(paramContext, str, null);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      return null;
    }
    finally
    {
      mConstructorArgs[0] = null;
      mConstructorArgs[1] = null;
    }
    throw paramContext;
  }

  private static Context themifyContext(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.View, 0, 0);
    int i = 0;
    if (paramBoolean1)
      i = paramAttributeSet.getResourceId(R.styleable.View_android_theme, 0);
    int j = i;
    if (paramBoolean2)
    {
      j = i;
      if (i == 0)
      {
        i = paramAttributeSet.getResourceId(R.styleable.View_theme, 0);
        j = i;
        if (i != 0)
        {
          Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
          j = i;
        }
      }
    }
    paramAttributeSet.recycle();
    paramAttributeSet = paramContext;
    if (j != 0)
      if ((paramContext instanceof ContextThemeWrapper))
      {
        paramAttributeSet = paramContext;
        if (((ContextThemeWrapper)paramContext).getThemeResId() == j);
      }
      else
      {
        paramAttributeSet = new ContextThemeWrapper(paramContext, j);
      }
    return paramAttributeSet;
  }

  public final View createView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Context localContext = paramContext;
    if (paramBoolean1)
    {
      localContext = paramContext;
      if (paramView != null)
        localContext = paramView.getContext();
    }
    if (!paramBoolean2)
    {
      paramView = localContext;
      if (!paramBoolean3);
    }
    else
    {
      paramView = themifyContext(localContext, paramAttributeSet, paramBoolean2, paramBoolean3);
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 1666676343:
    case -339785223:
    case 1601505219:
    case 776382189:
    case -1455429095:
    case 1413872058:
    case -1346021293:
    case -1946472170:
    case 2001146706:
    case -938935918:
    }
    while (true)
      switch (i)
      {
      default:
        if (paramContext == paramView)
          break label478;
        return createViewFromTag(paramView, paramString, paramAttributeSet);
        if (paramString.equals("EditText"))
        {
          i = 0;
          continue;
          if (paramString.equals("Spinner"))
          {
            i = 1;
            continue;
            if (paramString.equals("CheckBox"))
            {
              i = 2;
              continue;
              if (paramString.equals("RadioButton"))
              {
                i = 3;
                continue;
                if (paramString.equals("CheckedTextView"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("AutoCompleteTextView"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("MultiAutoCompleteTextView"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("RatingBar"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("Button"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("TextView"))
                            i = 9;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      }
    return new AppCompatEditText(paramView, paramAttributeSet);
    return new AppCompatSpinner(paramView, paramAttributeSet);
    return new AppCompatCheckBox(paramView, paramAttributeSet);
    return new AppCompatRadioButton(paramView, paramAttributeSet);
    return new AppCompatCheckedTextView(paramView, paramAttributeSet);
    return new AppCompatAutoCompleteTextView(paramView, paramAttributeSet);
    return new AppCompatMultiAutoCompleteTextView(paramView, paramAttributeSet);
    return new AppCompatRatingBar(paramView, paramAttributeSet);
    return new AppCompatButton(paramView, paramAttributeSet);
    return new AppCompatTextView(paramView, paramAttributeSet);
    label478: return null;
  }
}