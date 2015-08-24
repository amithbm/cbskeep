package com.android.ex.chips;

import android.net.Uri;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;

public class RecipientEntry
{
  private final long mContactId;
  private final long mDataId;
  private final String mDestination;
  private final String mDestinationLabel;
  private final int mDestinationType;
  private final Long mDirectoryId;
  private final String mDisplayName;
  private final int mEntryType;
  private final boolean mIsDivider;
  private boolean mIsFirstLevel;
  private boolean mIsValid;
  private final String mLookupKey;
  private byte[] mPhotoBytes;
  private final Uri mPhotoThumbnailUri;

  protected RecipientEntry(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, long paramLong1, Long paramLong, long paramLong2, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    mEntryType = paramInt1;
    mIsFirstLevel = paramBoolean1;
    mDisplayName = paramString1;
    mDestination = paramString2;
    mDestinationType = paramInt2;
    mDestinationLabel = paramString3;
    mContactId = paramLong1;
    mDirectoryId = paramLong;
    mDataId = paramLong2;
    mPhotoThumbnailUri = paramUri;
    mPhotoBytes = null;
    mIsDivider = false;
    mIsValid = paramBoolean2;
    mLookupKey = paramString4;
  }

  public static RecipientEntry constructFakeEntry(String paramString, boolean paramBoolean)
  {
    Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(paramString);
    if (arrayOfRfc822Token.length > 0)
      paramString = arrayOfRfc822Token[0].getAddress();
    while (true)
      return new RecipientEntry(0, paramString, paramString, -1, null, -1L, null, -1L, null, true, paramBoolean, null);
  }

  public static RecipientEntry constructFakePhoneEntry(String paramString, boolean paramBoolean)
  {
    return new RecipientEntry(0, paramString, paramString, -1, null, -1L, null, -1L, null, true, paramBoolean, null);
  }

  public static RecipientEntry constructGeneratedEntry(String paramString1, String paramString2, boolean paramBoolean)
  {
    return new RecipientEntry(0, paramString1, paramString2, -1, null, -2L, null, -2L, null, true, paramBoolean, null);
  }

  public static RecipientEntry constructSecondLevelEntry(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, Long paramLong, long paramLong2, String paramString4, boolean paramBoolean, String paramString5)
  {
    String str = pickDisplayName(paramInt1, paramString1, paramString2);
    if (paramString4 != null);
    for (paramString1 = Uri.parse(paramString4); ; paramString1 = null)
      return new RecipientEntry(0, str, paramString2, paramInt2, paramString3, paramLong1, paramLong, paramLong2, paramString1, false, paramBoolean, paramString5);
  }

  public static RecipientEntry constructTopLevelEntry(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, Long paramLong, long paramLong2, String paramString4, boolean paramBoolean, String paramString5)
  {
    String str = pickDisplayName(paramInt1, paramString1, paramString2);
    if (paramString4 != null);
    for (paramString1 = Uri.parse(paramString4); ; paramString1 = null)
      return new RecipientEntry(0, str, paramString2, paramInt2, paramString3, paramLong1, paramLong, paramLong2, paramString1, true, paramBoolean, paramString5);
  }

  public static boolean isCreatedRecipient(long paramLong)
  {
    return (paramLong == -1L) || (paramLong == -2L);
  }

  private static String pickDisplayName(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt > 20)
      return paramString1;
    return paramString2;
  }

  public long getContactId()
  {
    return mContactId;
  }

  public long getDataId()
  {
    return mDataId;
  }

  public String getDestination()
  {
    return mDestination;
  }

  public String getDestinationLabel()
  {
    return mDestinationLabel;
  }

  public int getDestinationType()
  {
    return mDestinationType;
  }

  public Long getDirectoryId()
  {
    return mDirectoryId;
  }

  public String getDisplayName()
  {
    return mDisplayName;
  }

  public int getEntryType()
  {
    return mEntryType;
  }

  public String getLookupKey()
  {
    return mLookupKey;
  }

  public byte[] getPhotoBytes()
  {
    try
    {
      byte[] arrayOfByte = mPhotoBytes;
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Uri getPhotoThumbnailUri()
  {
    return mPhotoThumbnailUri;
  }

  public boolean isFirstLevel()
  {
    return mIsFirstLevel;
  }

  public boolean isSelectable()
  {
    return mEntryType == 0;
  }

  public boolean isValid()
  {
    return mIsValid;
  }

  public void setPhotoBytes(byte[] paramArrayOfByte)
  {
    try
    {
      mPhotoBytes = paramArrayOfByte;
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
    }
    throw paramArrayOfByte;
  }

  public String toString()
  {
    return mDisplayName + " <" + mDestination + ">, isValid=" + mIsValid;
  }
}