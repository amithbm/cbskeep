package android.support.v4.view;

import android.view.View;
import java.lang.reflect.Method;

class ViewCompatEclairMr1
{
  private static Method sChildrenDrawingOrderMethod;

  public static boolean isOpaque(View paramView)
  {
    return paramView.isOpaque();
  }

  // ERROR //
  public static void setChildrenDrawingOrderEnabled(android.view.ViewGroup paramViewGroup, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 26	android/support/v4/view/ViewCompatEclairMr1:sChildrenDrawingOrderMethod	Ljava/lang/reflect/Method;
    //   3: ifnonnull +30 -> 33
    //   6: ldc 28
    //   8: ldc 29
    //   10: iconst_1
    //   11: anewarray 31	java/lang/Class
    //   14: dup
    //   15: iconst_0
    //   16: getstatic 37	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   19: aastore
    //   20: invokevirtual 41	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   23: putstatic 26	android/support/v4/view/ViewCompatEclairMr1:sChildrenDrawingOrderMethod	Ljava/lang/reflect/Method;
    //   26: getstatic 26	android/support/v4/view/ViewCompatEclairMr1:sChildrenDrawingOrderMethod	Ljava/lang/reflect/Method;
    //   29: iconst_1
    //   30: invokevirtual 47	java/lang/reflect/Method:setAccessible	(Z)V
    //   33: getstatic 26	android/support/v4/view/ViewCompatEclairMr1:sChildrenDrawingOrderMethod	Ljava/lang/reflect/Method;
    //   36: aload_0
    //   37: iconst_1
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: iload_1
    //   44: invokestatic 51	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   47: aastore
    //   48: invokevirtual 55	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: return
    //   53: astore_2
    //   54: ldc 57
    //   56: ldc 59
    //   58: aload_2
    //   59: invokestatic 65	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   62: pop
    //   63: goto -37 -> 26
    //   66: astore_0
    //   67: ldc 57
    //   69: ldc 67
    //   71: aload_0
    //   72: invokestatic 65	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   75: pop
    //   76: return
    //   77: astore_0
    //   78: ldc 57
    //   80: ldc 67
    //   82: aload_0
    //   83: invokestatic 65	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   86: pop
    //   87: return
    //   88: astore_0
    //   89: ldc 57
    //   91: ldc 67
    //   93: aload_0
    //   94: invokestatic 65	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   97: pop
    //   98: return
    //
    // Exception table:
    //   from	to	target	type
    //   6	26	53	java/lang/NoSuchMethodException
    //   33	52	66	java/lang/IllegalAccessException
    //   33	52	77	java/lang/IllegalArgumentException
    //   33	52	88	java/lang/reflect/InvocationTargetException
  }
}