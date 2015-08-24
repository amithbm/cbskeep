package com.google.android.gms.internal;

import java.io.IOException;

public class zzadw extends IOException
{
  public zzadw(String paramString)
  {
    super(paramString);
  }

  static zzadw zzHI()
  {
    return new zzadw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }

  static zzadw zzHJ()
  {
    return new zzadw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }

  static zzadw zzHK()
  {
    return new zzadw("CodedInputStream encountered a malformed varint.");
  }

  static zzadw zzHL()
  {
    return new zzadw("Protocol message contained an invalid tag (zero).");
  }

  static zzadw zzHM()
  {
    return new zzadw("Protocol message end-group tag did not match expected tag.");
  }

  static zzadw zzHN()
  {
    return new zzadw("Protocol message tag had invalid wire type.");
  }

  static zzadw zzHO()
  {
    return new zzadw("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
}