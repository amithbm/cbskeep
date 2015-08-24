package com.google.api.client.json;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface JsonPolymorphicTypeMap
{
  public abstract TypeDef[] typeDefinitions();

  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface TypeDef
  {
    public abstract String key();

    public abstract Class<?> ref();
  }
}