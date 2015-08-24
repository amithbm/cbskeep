package com.google.android.keep.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.common.http.UrlRules;
import com.google.android.common.http.UrlRules.Rule;
import com.google.android.gms.common.api.Releasable;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.editor.a;
import com.google.android.keep.provider.b;
import com.google.android.keep.provider.g;
import com.google.android.keep.toasts.ToastListener.e;
import com.google.android.keep.toasts.ToastsFragment;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private static final Object Op = new Object();
  private static long Oq = -1L;

  public static boolean A(View paramView)
  {
    if (paramView == null)
      return false;
    new Handler().post(new Runnable()
    {
      public void run()
      {
        if (val$view.getContext() == null);
        InputMethodManager localInputMethodManager;
        do
        {
          return;
          if (!val$view.hasFocus())
            val$view.requestFocus();
          localInputMethodManager = (InputMethodManager)val$view.getContext().getSystemService("input_method");
        }
        while ((localInputMethodManager == null) || (localInputMethodManager.showSoftInput(val$view, 1)));
        Log.e("Keep", "Failed to show soft input method.");
      }
    });
    return true;
  }

  public static boolean B(View paramView)
  {
    if ((paramView == null) || (paramView.getContext() == null))
      return false;
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    paramView.clearFocus();
    return true;
  }

  public static boolean C(View paramView)
  {
    if ((paramView == null) || (paramView.getContext() == null) || (TextUtils.isEmpty(paramView.getContentDescription())))
      return false;
    int[] arrayOfInt = new int[2];
    Rect localRect = new Rect();
    paramView.getLocationOnScreen(arrayOfInt);
    paramView.getWindowVisibleDisplayFrame(localRect);
    Context localContext = paramView.getContext();
    int j = paramView.getWidth();
    int i = paramView.getHeight();
    j = arrayOfInt[0] - j / 2;
    paramView = Toast.makeText(localContext, paramView.getContentDescription(), 0);
    if (arrayOfInt[1] < localRect.height() / 3)
      paramView.setGravity(51, j, i);
    while (true)
    {
      paramView.show();
      return true;
      int k = localContext.getResources().getDimensionPixelOffset(2131427568);
      paramView.setGravity(51, j, arrayOfInt[1] - k - i);
    }
  }

  public static long[] G(List<Long> paramList)
  {
    int j = paramList.size();
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
      i += 1;
    }
    return arrayOfLong;
  }

  public static double a(double paramDouble)
  {
    return paramDouble / 1000.0D;
  }

  public static Object a(ContentValues paramContentValues, Object paramObject, String paramString)
  {
    if (paramObject == null)
    {
      paramContentValues.putNull(paramString);
      return paramObject;
    }
    if ((paramObject instanceof Integer))
    {
      paramContentValues.put(paramString, (Integer)paramObject);
      return paramObject;
    }
    if ((paramObject instanceof String))
    {
      paramContentValues.put(paramString, (String)paramObject);
      return paramObject;
    }
    if ((paramObject instanceof Long))
    {
      paramContentValues.put(paramString, (Long)paramObject);
      return paramObject;
    }
    if ((paramObject instanceof Boolean))
    {
      paramContentValues.put(paramString, (Boolean)paramObject);
      return paramObject;
    }
    if ((paramObject instanceof Byte))
    {
      paramContentValues.put(paramString, (Byte)paramObject);
      return paramObject;
    }
    if ((paramObject instanceof byte[]))
    {
      paramContentValues.put(paramString, (byte[])paramObject);
      return paramObject;
    }
    if ((paramObject instanceof Double))
    {
      paramContentValues.put(paramString, (Double)paramObject);
      return paramObject;
    }
    if ((paramObject instanceof Float))
    {
      paramContentValues.put(paramString, (Float)paramObject);
      return paramObject;
    }
    if ((paramObject instanceof Short))
    {
      paramContentValues.put(paramString, (Short)paramObject);
      return paramObject;
    }
    Log.e("Keep", "Unexpected type for key " + paramString + ", type " + paramObject.getClass().toString());
    return paramObject;
  }

  public static <T> T a(FragmentActivity paramFragmentActivity, int paramInt)
  {
    return paramFragmentActivity.getSupportFragmentManager().findFragmentById(paramInt);
  }

  public static <T> T a(FragmentActivity paramFragmentActivity, String paramString)
  {
    return paramFragmentActivity.getSupportFragmentManager().findFragmentByTag(paramString);
  }

  public static String a(CharSequence paramCharSequence, long[] paramArrayOfLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 1;
    int k = paramArrayOfLong.length;
    int i = 0;
    if (i < k)
    {
      long l = paramArrayOfLong[i];
      if (j != 0)
        j = 0;
      while (true)
      {
        localStringBuilder.append(l);
        i += 1;
        break;
        localStringBuilder.append(paramCharSequence);
      }
    }
    return localStringBuilder.toString();
  }

  @TargetApi(21)
  public static void a(Activity paramActivity, int paramInt)
  {
    if (KeepApplication.ap())
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null)
        paramActivity.setStatusBarColor(paramInt);
    }
  }

  public static void a(ContentValues paramContentValues, long paramLong)
  {
    KeepTime localKeepTime = new KeepTime(paramLong);
    paramContentValues.put("julian_day", Integer.valueOf(localKeepTime.jm()));
    paramContentValues.put("time_of_day", Long.valueOf(localKeepTime.oq()));
  }

  public static void a(Menu paramMenu)
  {
    int i = 0;
    while (i < paramMenu.size())
    {
      paramMenu.getItem(i).setVisible(false);
      i += 1;
    }
  }

  public static void a(Menu paramMenu, int[] paramArrayOfInt)
  {
    a(paramMenu);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = paramMenu.findItem(paramArrayOfInt[i]);
      if (localMenuItem != null)
        localMenuItem.setVisible(true);
      i += 1;
    }
  }

  @SuppressLint({"NewApi"})
  public static void a(ImageView paramImageView, float paramFloat)
  {
    if (paramImageView == null)
      return;
    int i = (int)(255.0F * paramFloat);
    if (KeepApplication.ak())
    {
      paramImageView.setImageAlpha(i);
      return;
    }
    paramImageView.setAlpha(i);
  }

  private static void a(Toast paramToast, Context paramContext)
  {
    paramToast.setGravity(80, 0, paramContext.getResources().getDimensionPixelSize(2131427567));
    paramToast.show();
  }

  public static void a(Releasable paramReleasable)
  {
    if (paramReleasable != null)
      paramReleasable.release();
  }

  public static void a(OutputStream paramOutputStream)
  {
    b(paramOutputStream);
  }

  public static boolean a(Activity paramActivity)
  {
    paramActivity = ((ConnectivityManager)paramActivity.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramActivity != null) && (paramActivity.isConnected());
  }

  public static String[] a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length == 0))
      return paramArrayOfString2;
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
      return paramArrayOfString1;
    String[] arrayOfString = new String[paramArrayOfString1.length + paramArrayOfString2.length];
    System.arraycopy(paramArrayOfString1, 0, arrayOfString, 0, paramArrayOfString1.length);
    System.arraycopy(paramArrayOfString2, 0, arrayOfString, paramArrayOfString1.length, paramArrayOfString2.length);
    return arrayOfString;
  }

  public static double b(double paramDouble)
  {
    return paramDouble / 1609.3399999999999D;
  }

  public static final String b(Context paramContext, String paramString, int paramInt)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
      str = null;
    do
    {
      return str;
      str = paramString;
    }
    while (paramString.length() <= paramInt);
    paramContext = paramContext.getString(2131230839);
    return paramString.substring(0, paramInt - paramContext.length()) + paramContext;
  }

  public static void b(Context paramContext, int paramInt)
  {
    if (paramContext == null)
      return;
    g(paramContext, paramContext.getResources().getString(paramInt));
  }

  private static void b(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.w("Keep", "Close failed ", paramCloseable);
    }
  }

  public static String bv(String paramString)
  {
    String str = paramString;
    if (paramString == null)
      str = "";
    return str;
  }

  public static void c(Context paramContext, int paramInt)
  {
    if (paramContext == null)
      return;
    h(paramContext, paramContext.getResources().getString(paramInt));
  }

  public static long currentTimeMillis()
  {
    synchronized (Op)
    {
      long l = System.currentTimeMillis();
      if (Oq < l)
      {
        Oq = l;
        l = Oq;
        return l;
      }
      Oq += 1L;
    }
  }

  public static int d(Integer paramInteger)
  {
    if (paramInteger == null)
      return 0;
    return paramInteger.intValue();
  }

  public static Typeface d(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842903 });
    paramAttributeSet = null;
    paramContext = paramAttributeSet;
    if (localTypedArray != null)
    {
      paramContext = paramAttributeSet;
      if (localTypedArray.length() > 0)
      {
        paramContext = paramAttributeSet;
        if (localTypedArray.getInt(0, 0) == 1)
          paramContext = KeepApplication.aa();
      }
    }
    if (localTypedArray != null)
      localTypedArray.recycle();
    paramAttributeSet = paramContext;
    if (paramContext == null)
      paramAttributeSet = KeepApplication.Z();
    return paramAttributeSet;
  }

  public static String e(ContentResolver paramContentResolver, Uri paramUri)
  {
    Object localObject = paramContentResolver.getType(paramUri);
    if (!TextUtils.isEmpty((CharSequence)localObject))
      return localObject;
    localObject = g.b(paramContentResolver, paramUri);
    if ((localObject != null) && (((BitmapFactory.Options)localObject).outMimeType != null))
      return ((BitmapFactory.Options)localObject).outMimeType;
    return b.a(paramContentResolver, paramUri);
  }

  public static void e(InputStream paramInputStream)
  {
    b(paramInputStream);
  }

  public static List<Long> f(long[] paramArrayOfLong)
  {
    int j = paramArrayOfLong.length;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    return localArrayList;
  }

  public static void g(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (!(paramContext instanceof FragmentActivity)))
      return;
    ToastsFragment localToastsFragment = (ToastsFragment)a((FragmentActivity)paramContext, 2131493048);
    if (localToastsFragment != null)
    {
      localToastsFragment.a(new ToastListener.e(paramString));
      return;
    }
    a(Toast.makeText(paramContext, paramString, 0), paramContext);
  }

  public static int getFirstDayOfWeek()
  {
    int i = Calendar.getInstance().getFirstDayOfWeek();
    if (i == 7)
      return 6;
    if (i == 2)
      return 1;
    return 0;
  }

  public static <E> ArrayList<E> h(E paramE)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramE);
    return localArrayList;
  }

  public static void h(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (!(paramContext instanceof FragmentActivity)))
      return;
    ToastsFragment localToastsFragment = (ToastsFragment)a((FragmentActivity)paramContext, 2131493048);
    if (localToastsFragment != null)
    {
      localToastsFragment.a(paramString, null, null);
      return;
    }
    a(Toast.makeText(paramContext, paramString, 0), paramContext);
  }

  public static boolean isFragmentActive(Fragment paramFragment)
  {
    boolean bool3 = false;
    if ((paramFragment instanceof a));
    for (boolean bool1 = ((a)paramFragment).dj(); ; bool1 = false)
    {
      boolean bool2 = bool3;
      if (paramFragment.isVisible())
      {
        bool2 = bool3;
        if (!bool1)
          bool2 = true;
      }
      return bool2;
    }
  }

  public static JSONObject k(Context paramContext, Uri paramUri)
  {
    try
    {
      paramContext = new JSONObject(new String(l(paramContext, paramUri)));
      return paramContext;
    }
    catch (IOException paramContext)
    {
      Log.e("Keep", "Failed to execute Json request", paramContext);
      return null;
    }
    catch (JSONException paramContext)
    {
      while (true)
        Log.e("Keep", "Failed to execute Json request", paramContext);
    }
  }

  private static byte[] l(Context paramContext, Uri paramUri)
    throws IOException
  {
    paramUri = paramUri.toString();
    Object localObject = UrlRules.getRules(paramContext.getContentResolver()).matchRule(paramUri);
    paramContext = ((UrlRules.Rule)localObject).apply(paramUri);
    if (paramContext == null)
      throw new IOException("Blocked by rule: " + localObject);
    if (!paramContext.equals(paramUri));
    while (true)
    {
      paramContext = new URL(paramContext).openStream();
      paramUri = new ByteArrayOutputStream();
      try
      {
        localObject = new byte[1000];
        while (true)
        {
          int i = paramContext.read((byte[])localObject);
          if (i <= 0)
          {
            paramContext.close();
            return paramUri.toByteArray();
            paramContext = paramUri;
            break;
          }
          paramUri.write((byte[])localObject, 0, i);
        }
      }
      finally
      {
        paramContext.close();
      }
    }
    throw paramUri;
  }

  public static void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (KeepApplication.af())
    {
      paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}