package com.google.android.keep;

import java.lang.reflect.Method;

public final class v
{
  private static Method sg;

  // ERROR //
  public static void a(android.support.v4.app.FragmentManager paramFragmentManager)
  {
    // Byte code:
    //   0: getstatic 16	com/google/android/keep/v:sg	Ljava/lang/reflect/Method;
    //   3: ifnonnull +19 -> 22
    //   6: aload_0
    //   7: invokevirtual 20	java/lang/Object:getClass	()Ljava/lang/Class;
    //   10: ldc 22
    //   12: iconst_0
    //   13: anewarray 24	java/lang/Class
    //   16: invokevirtual 28	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   19: putstatic 16	com/google/android/keep/v:sg	Ljava/lang/reflect/Method;
    //   22: getstatic 16	com/google/android/keep/v:sg	Ljava/lang/reflect/Method;
    //   25: aload_0
    //   26: iconst_0
    //   27: anewarray 4	java/lang/Object
    //   30: invokevirtual 34	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   33: pop
    //   34: return
    //   35: astore_1
    //   36: invokestatic 38	com/google/android/keep/v:fP	()V
    //   39: goto -17 -> 22
    //   42: astore_0
    //   43: invokestatic 38	com/google/android/keep/v:fP	()V
    //   46: return
    //   47: astore_0
    //   48: invokestatic 38	com/google/android/keep/v:fP	()V
    //   51: return
    //
    // Exception table:
    //   from	to	target	type
    //   6	22	35	java/lang/NoSuchMethodException
    //   22	34	42	java/lang/IllegalAccessException
    //   22	34	47	java/lang/reflect/InvocationTargetException
  }

  private static void fP()
  {
    throw new IllegalStateException("Could not access method FragmentManager#noteStateNotSaved");
  }
}