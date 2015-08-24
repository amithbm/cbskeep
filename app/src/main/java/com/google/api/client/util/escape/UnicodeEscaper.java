package com.google.api.client.util.escape;

public abstract class UnicodeEscaper extends Escaper
{
  protected static int codePointAt(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      int j = paramInt1 + 1;
      int i = paramCharSequence.charAt(paramInt1);
      if ((i < 55296) || (i > 57343))
        return i;
      if (i <= 56319)
      {
        if (j == paramInt2)
          return -i;
        char c = paramCharSequence.charAt(j);
        if (Character.isLowSurrogate(c))
          return Character.toCodePoint(i, c);
        throw new IllegalArgumentException("Expected low surrogate but got char '" + c + "' with value " + c + " at index " + j);
      }
      throw new IllegalArgumentException("Unexpected low surrogate character '" + i + "' with value " + i + " at index " + (j - 1));
    }
    throw new IndexOutOfBoundsException("Index exceeds specified range");
  }

  private static char[] growBuffer(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    if (paramInt1 > 0)
      System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramInt1);
    return arrayOfChar;
  }

  protected abstract char[] escape(int paramInt);

  protected final String escapeSlow(String paramString, int paramInt)
  {
    int i1 = paramString.length();
    Object localObject1 = Platform.charBufferFromThreadLocal();
    int i = 0;
    int j = 0;
    int k = paramInt;
    paramInt = i;
    if (k < i1)
    {
      i = codePointAt(paramString, k, i1);
      if (i < 0)
        throw new IllegalArgumentException("Trailing high surrogate at end of input");
      char[] arrayOfChar = escape(i);
      if (Character.isSupplementaryCodePoint(i));
      for (i = 2; ; i = 1)
      {
        int n = k + i;
        localObject2 = localObject1;
        int m = paramInt;
        i = j;
        if (arrayOfChar != null)
        {
          m = k - j;
          i = paramInt + m + arrayOfChar.length;
          localObject2 = localObject1;
          if (localObject1.length < i)
            localObject2 = growBuffer((char[])localObject1, paramInt, i + i1 - k + 32);
          i = paramInt;
          if (m > 0)
          {
            paramString.getChars(j, k, (char[])localObject2, paramInt);
            i = paramInt + m;
          }
          paramInt = i;
          if (arrayOfChar.length > 0)
          {
            System.arraycopy(arrayOfChar, 0, localObject2, i, arrayOfChar.length);
            paramInt = i + arrayOfChar.length;
          }
          i = n;
          m = paramInt;
        }
        k = nextEscapeIndex(paramString, n, i1);
        localObject1 = localObject2;
        paramInt = m;
        j = i;
        break;
      }
    }
    k = i1 - j;
    Object localObject2 = localObject1;
    i = paramInt;
    if (k > 0)
    {
      i = paramInt + k;
      localObject2 = localObject1;
      if (localObject1.length < i)
        localObject2 = growBuffer((char[])localObject1, paramInt, i);
      paramString.getChars(j, i1, (char[])localObject2, paramInt);
    }
    return new String((char[])localObject2, 0, i);
  }

  protected abstract int nextEscapeIndex(CharSequence paramCharSequence, int paramInt1, int paramInt2);
}