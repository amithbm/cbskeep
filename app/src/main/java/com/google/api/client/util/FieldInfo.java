package com.google.api.client.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

public class FieldInfo
{
  private static final Map<Field, FieldInfo> CACHE = new WeakHashMap();
  private final Field field;
  private final boolean isPrimitive;
  private final String name;

  FieldInfo(Field paramField, String paramString)
  {
    field = paramField;
    if (paramString == null);
    for (paramField = null; ; paramField = paramString.intern())
    {
      name = paramField;
      isPrimitive = Data.isPrimitive(getType());
      return;
    }
  }

  public static Object getFieldValue(Field paramField, Object paramObject)
  {
    try
    {
      paramField = paramField.get(paramObject);
      return paramField;
    }
    catch (IllegalAccessException paramField)
    {
    }
    throw new IllegalArgumentException(paramField);
  }

  public static FieldInfo of(Enum<?> paramEnum)
  {
    boolean bool = true;
    try
    {
      FieldInfo localFieldInfo = of(paramEnum.getClass().getField(paramEnum.name()));
      if (localFieldInfo != null);
      while (true)
      {
        Preconditions.checkArgument(bool, "enum constant missing @Value or @NullValue annotation: %s", new Object[] { paramEnum });
        return localFieldInfo;
        bool = false;
      }
    }
    catch (NoSuchFieldException paramEnum)
    {
    }
    throw new RuntimeException(paramEnum);
  }

  public static FieldInfo of(Field paramField)
  {
    if (paramField == null)
      return null;
    label149: 
    while (true)
    {
      Object localObject1;
      synchronized (CACHE)
      {
        Object localObject2 = (FieldInfo)CACHE.get(paramField);
        boolean bool = paramField.isEnumConstant();
        localObject1 = localObject2;
        if (localObject2 == null)
          if (!bool)
          {
            localObject1 = localObject2;
            if (Modifier.isStatic(paramField.getModifiers()));
          }
          else
          {
            if (!bool)
              break label149;
            localObject1 = (Value)paramField.getAnnotation(Value.class);
            if (localObject1 == null)
              break label127;
            localObject1 = ((Value)localObject1).value();
            localObject2 = localObject1;
            if ("##default".equals(localObject1))
              localObject2 = paramField.getName();
            localObject1 = new FieldInfo(paramField, (String)localObject2);
            CACHE.put(paramField, localObject1);
          }
        return localObject1;
      }
      label127: if ((NullValue)paramField.getAnnotation(NullValue.class) != null)
      {
        localObject1 = null;
      }
      else
      {
        return null;
        localObject1 = (Key)paramField.getAnnotation(Key.class);
        if (localObject1 == null)
          return null;
        localObject1 = ((Key)localObject1).value();
        paramField.setAccessible(true);
      }
    }
  }

  public static void setFieldValue(Field paramField, Object paramObject1, Object paramObject2)
  {
    if (Modifier.isFinal(paramField.getModifiers()))
    {
      Object localObject = getFieldValue(paramField, paramObject1);
      if (paramObject2 == null)
      {
        if (localObject == null);
      }
      else
        while (!paramObject2.equals(localObject))
          throw new IllegalArgumentException("expected final value <" + localObject + "> but was <" + paramObject2 + "> on " + paramField.getName() + " field in " + paramObject1.getClass().getName());
      return;
    }
    try
    {
      paramField.set(paramObject1, paramObject2);
      return;
    }
    catch (SecurityException paramField)
    {
      throw new IllegalArgumentException(paramField);
    }
    catch (IllegalAccessException paramField)
    {
    }
    throw new IllegalArgumentException(paramField);
  }

  public <T extends Enum<T>> T enumValue()
  {
    return Enum.valueOf(field.getDeclaringClass(), field.getName());
  }

  public Field getField()
  {
    return field;
  }

  public Type getGenericType()
  {
    return field.getGenericType();
  }

  public String getName()
  {
    return name;
  }

  public Class<?> getType()
  {
    return field.getType();
  }

  public Object getValue(Object paramObject)
  {
    return getFieldValue(field, paramObject);
  }

  public boolean isFinal()
  {
    return Modifier.isFinal(field.getModifiers());
  }

  public boolean isPrimitive()
  {
    return isPrimitive;
  }

  public void setValue(Object paramObject1, Object paramObject2)
  {
    setFieldValue(field, paramObject1, paramObject2);
  }
}