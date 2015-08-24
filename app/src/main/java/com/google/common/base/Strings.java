package com.google.common.base;

public final class Strings
{
  public static boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }

  static boolean validSurrogatePairAt(CharSequence paramCharSequence, int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= paramCharSequence.length() - 2) && (Character.isHighSurrogate(paramCharSequence.charAt(paramInt))) && (Character.isLowSurrogate(paramCharSequence.charAt(paramInt + 1)));
  }
}