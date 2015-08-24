package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.signin.IdProvider;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.common.internal.zzv;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class zzkk extends zzkj
{
  public static final List<String> zzRM = Arrays.asList(new String[] { "email" });
  private Class<?> zzRN;
  private Class<?> zzRO;
  private Object zzRP;
  private Object zzRQ;

  public zzkk(Activity paramActivity, List<String> paramList)
  {
    super(paramActivity, zzRM, paramList);
  }

  private void zzlg()
    throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    if (zzRQ != null)
    {
      Class.forName("com.facebook.login.LoginManager").getDeclaredMethod("logInWithReadPermissions", new Class[] { Activity.class, Collection.class }).invoke(zzRQ, new Object[] { zzRJ, new ArrayList(zzld()) });
      return;
    }
    Class localClass1 = Class.forName("com.facebook.Session$OpenRequest");
    Object localObject1 = localClass1.getConstructor(new Class[] { Activity.class }).newInstance(new Object[] { zzRJ });
    localClass1.getDeclaredMethod("setPermissions", new Class[] { List.class }).invoke(localObject1, new Object[] { new ArrayList(zzld()) });
    localClass1.getDeclaredMethod("setRequestCode", new Class[] { Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(64206) });
    Class localClass2 = Class.forName("com.facebook.Session");
    localClass1.getDeclaredMethod("setCallback", new Class[] { Class.forName("com.facebook.Session$StatusCallback") }).invoke(localObject1, new Object[] { zzli() });
    Object localObject2 = localClass2.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { zzRJ });
    localClass2.getDeclaredMethod("setActiveSession", new Class[] { localClass2 }).invoke(null, new Object[] { localObject2 });
    localClass2.getDeclaredMethod("openForRead", new Class[] { localClass1 }).invoke(localObject2, new Object[] { localObject1 });
  }

  private Object zzlh()
    throws ClassNotFoundException
  {
    Class localClass = Class.forName("com.facebook.FacebookCallback");
    ClassLoader localClassLoader = localClass.getClassLoader();
    InvocationHandler local1 = new InvocationHandler()
    {
      public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        throws Throwable
      {
        paramAnonymousObject = Class.forName("com.facebook.login.LoginResult");
        Class localClass = Class.forName("com.facebook.FacebookException");
        Class[] arrayOfClass = paramAnonymousMethod.getParameterTypes();
        if ((paramAnonymousMethod.getName().equals("onSuccess")) && (arrayOfClass.length == 1) && (paramAnonymousArrayOfObject[0].getClass() == paramAnonymousObject))
        {
          paramAnonymousObject = paramAnonymousObject.getDeclaredMethod("getAccessToken", new Class[0]).invoke(paramAnonymousArrayOfObject[0], new Object[0]);
          paramAnonymousObject = (String)Class.forName("com.facebook.AccessToken").getMethod("getToken", new Class[0]).invoke(paramAnonymousObject, new Object[0]);
          zzkk.zzb(zzkk.this).zzk(zzkk.zza(zzkk.this, IdpTokenType.zzRv, paramAnonymousObject, zzkk.zza(zzkk.this)));
        }
        while (true)
        {
          return null;
          if ((paramAnonymousMethod.getName().equals("onCancel")) && (arrayOfClass.length == 0))
          {
            zzkk.zzc(zzkk.this).zzla();
          }
          else
          {
            if ((!paramAnonymousMethod.getName().equals("onError")) || (arrayOfClass.length != 1) || (arrayOfClass[0] != localClass))
              break;
            Log.e("AuthSignInClient", "facebook login error!", (Exception)paramAnonymousArrayOfObject[0]);
            zzkk.zzd(zzkk.this).zza((Exception)paramAnonymousArrayOfObject[0]);
          }
        }
        throw new ExceptionInInitializerError("Method not supported!");
      }
    };
    return Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, local1);
  }

  private Object zzli()
    throws ClassNotFoundException
  {
    Object localObject = Class.forName("com.facebook.Session");
    Class localClass = Class.forName("com.facebook.Session$StatusCallback");
    ClassLoader localClassLoader = localClass.getClassLoader();
    localObject = new InvocationHandler()
    {
      public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        throws Throwable
      {
        paramAnonymousObject = Class.forName("com.facebook.SessionState");
        Class[] arrayOfClass = paramAnonymousMethod.getParameterTypes();
        if ((!paramAnonymousMethod.getName().equals("call")) || (arrayOfClass.length != 3) || (arrayOfClass[0] != zzRS) || (arrayOfClass[1] != paramAnonymousObject) || (arrayOfClass[2] != Exception.class))
          throw new ExceptionInInitializerError("Method not supported!");
        if (((Boolean)zzRS.getDeclaredMethod("isOpened", new Class[0]).invoke(paramAnonymousArrayOfObject[0], new Object[0])).booleanValue())
        {
          paramAnonymousObject = (String)zzRS.getDeclaredMethod("getAccessToken", new Class[0]).invoke(paramAnonymousArrayOfObject[0], new Object[0]);
          zzkk.zzf(zzkk.this).zzk(zzkk.zzb(zzkk.this, IdpTokenType.zzRv, paramAnonymousObject, zzkk.zze(zzkk.this)));
        }
        return null;
      }
    };
    return Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, (InvocationHandler)localObject);
  }

  public IdProvider getIdProvider()
  {
    return IdProvider.FACEBOOK;
  }

  public void zza(zzki.zza paramzza)
  {
    zzb(null, null, (zzki.zza)zzv.zzz(paramzza));
    try
    {
      zzlg();
      return;
    }
    catch (ClassNotFoundException paramzza)
    {
      throw new RuntimeException(paramzza);
    }
    catch (NoSuchMethodException paramzza)
    {
      break label19;
    }
    catch (IllegalAccessException paramzza)
    {
      break label19;
    }
    catch (InvocationTargetException paramzza)
    {
      break label19;
    }
    catch (InstantiationException paramzza)
    {
      label19: break label19;
    }
  }

  public void zza(String paramString, zzki.zza paramzza)
  {
    zzb((String)zzv.zzz(paramString), null, (zzki.zza)zzv.zzz(paramzza));
    try
    {
      zzlg();
      return;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new RuntimeException(paramString);
    }
    catch (NoSuchMethodException paramString)
    {
      break label25;
    }
    catch (IllegalAccessException paramString)
    {
      break label25;
    }
    catch (InvocationTargetException paramString)
    {
      break label25;
    }
    catch (InstantiationException paramString)
    {
      label25: break label25;
    }
  }

  public void zza(String paramString1, String paramString2, zzki.zza paramzza)
  {
    zzb((String)zzv.zzz(paramString1), (String)zzv.zzz(paramString2), (zzki.zza)zzv.zzz(paramzza));
    try
    {
      zzlg();
      return;
    }
    catch (ClassNotFoundException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
    catch (NoSuchMethodException paramString1)
    {
      break label31;
    }
    catch (IllegalAccessException paramString1)
    {
      break label31;
    }
    catch (InvocationTargetException paramString1)
    {
      break label31;
    }
    catch (InstantiationException paramString1)
    {
      label31: break label31;
    }
  }

  public boolean zza(int paramInt1, int paramInt2, Intent paramIntent, zzki.zza paramzza)
  {
    zzb(paramzza);
    if ((paramInt1 != 64206) && (zzRN == null))
      return false;
    if ((zzRN != null) && (zzRO != null) && (zzRP != null));
    try
    {
      if (!((Boolean)zzRN.getDeclaredMethod("isFacebookRequestCode", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(paramInt1) })).booleanValue())
        return false;
      bool = ((Boolean)zzRO.getDeclaredMethod("onActivityResult", new Class[] { Integer.TYPE, Integer.TYPE, Intent.class }).invoke(zzRP, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent })).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException paramIntent)
    {
      boolean bool;
      throw new RuntimeException(paramIntent);
      try
      {
        Object localObject = Class.forName("com.facebook.Session");
        paramzza = ((Class)localObject).getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
        localObject = ((Class)localObject).getDeclaredMethod("onActivityResult", new Class[] { Activity.class, Integer.TYPE, Integer.TYPE, Intent.class });
        if (paramzza == null)
          return false;
        bool = ((Boolean)((Method)localObject).invoke(paramzza, new Object[] { zzRJ, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent })).booleanValue();
        return bool;
      }
      catch (NoSuchMethodException paramIntent)
      {
        throw new RuntimeException(paramIntent);
      }
      catch (ClassNotFoundException paramIntent)
      {
        break label285;
      }
      catch (IllegalAccessException paramIntent)
      {
        break label285;
      }
      catch (InvocationTargetException paramIntent)
      {
        break label285;
      }
    }
    catch (IllegalAccessException paramIntent)
    {
      label285: break label158;
    }
    catch (InvocationTargetException paramIntent)
    {
      label158: break label158;
    }
  }

  // ERROR //
  public void zzaa(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 231
    //   3: invokestatic 81	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   6: putfield 209	com/google/android/gms/internal/zzkk:zzRN	Ljava/lang/Class;
    //   9: aload_0
    //   10: getfield 209	com/google/android/gms/internal/zzkk:zzRN	Ljava/lang/Class;
    //   13: ldc 233
    //   15: iconst_2
    //   16: anewarray 77	java/lang/Class
    //   19: dup
    //   20: iconst_0
    //   21: ldc 152
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: getstatic 135	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   29: aastore
    //   30: invokevirtual 91	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   33: aconst_null
    //   34: iconst_2
    //   35: anewarray 93	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_1
    //   41: invokevirtual 237	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: ldc 136
    //   49: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aastore
    //   53: invokevirtual 112	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: aload_0
    //   58: ldc 239
    //   60: invokestatic 81	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   63: ldc 241
    //   65: iconst_0
    //   66: anewarray 77	java/lang/Class
    //   69: invokevirtual 91	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   72: aconst_null
    //   73: iconst_0
    //   74: anewarray 93	java/lang/Object
    //   77: invokevirtual 112	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   80: putfield 213	com/google/android/gms/internal/zzkk:zzRP	Ljava/lang/Object;
    //   83: ldc 75
    //   85: invokestatic 81	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   88: astore_1
    //   89: aload_0
    //   90: aload_1
    //   91: ldc 243
    //   93: iconst_0
    //   94: anewarray 77	java/lang/Class
    //   97: invokevirtual 91	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   100: aconst_null
    //   101: iconst_0
    //   102: anewarray 93	java/lang/Object
    //   105: invokevirtual 112	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   108: putfield 73	com/google/android/gms/internal/zzkk:zzRQ	Ljava/lang/Object;
    //   111: aload_0
    //   112: ldc 245
    //   114: invokestatic 81	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   117: putfield 211	com/google/android/gms/internal/zzkk:zzRO	Ljava/lang/Class;
    //   120: ldc 160
    //   122: invokestatic 81	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   125: astore_2
    //   126: aload_1
    //   127: ldc 247
    //   129: iconst_2
    //   130: anewarray 77	java/lang/Class
    //   133: dup
    //   134: iconst_0
    //   135: aload_0
    //   136: getfield 211	com/google/android/gms/internal/zzkk:zzRO	Ljava/lang/Class;
    //   139: aastore
    //   140: dup
    //   141: iconst_1
    //   142: aload_2
    //   143: aastore
    //   144: invokevirtual 91	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   147: aload_0
    //   148: getfield 73	com/google/android/gms/internal/zzkk:zzRQ	Ljava/lang/Object;
    //   151: iconst_2
    //   152: anewarray 93	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload_0
    //   158: getfield 213	com/google/android/gms/internal/zzkk:zzRP	Ljava/lang/Object;
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: aload_0
    //   165: invokespecial 249	com/google/android/gms/internal/zzkk:zzlh	()Ljava/lang/Object;
    //   168: aastore
    //   169: invokevirtual 112	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   172: pop
    //   173: return
    //   174: astore_1
    //   175: ldc 142
    //   177: invokestatic 81	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   180: pop
    //   181: return
    //   182: astore_1
    //   183: new 200	java/lang/RuntimeException
    //   186: dup
    //   187: ldc 251
    //   189: invokespecial 254	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   192: athrow
    //   193: astore_1
    //   194: new 200	java/lang/RuntimeException
    //   197: dup
    //   198: aload_1
    //   199: invokespecial 203	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   202: athrow
    //   203: astore_1
    //   204: goto -10 -> 194
    //   207: astore_1
    //   208: goto -14 -> 194
    //   211: astore_1
    //   212: goto -18 -> 194
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	174	java/lang/ClassNotFoundException
    //   175	181	182	java/lang/ClassNotFoundException
    //   9	173	193	java/lang/NoSuchMethodException
    //   9	173	203	java/lang/ClassNotFoundException
    //   9	173	207	java/lang/IllegalAccessException
    //   9	173	211	java/lang/reflect/InvocationTargetException
  }
}