package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class ByteArrayContent extends AbstractInputStreamContent
{
  private final byte[] byteArray;
  private final int length;
  private final int offset;

  public ByteArrayContent(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramString);
    byteArray = ((byte[])Preconditions.checkNotNull(paramArrayOfByte));
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 + paramInt2 <= paramArrayOfByte.length));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "offset %s, length %s, array length %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) });
      offset = paramInt1;
      length = paramInt2;
      return;
    }
  }

  public InputStream getInputStream()
  {
    return new ByteArrayInputStream(byteArray, offset, length);
  }

  public long getLength()
  {
    return length;
  }

  public boolean retrySupported()
  {
    return true;
  }

  public ByteArrayContent setCloseInputStream(boolean paramBoolean)
  {
    return (ByteArrayContent)super.setCloseInputStream(paramBoolean);
  }

  public ByteArrayContent setType(String paramString)
  {
    return (ByteArrayContent)super.setType(paramString);
  }
}