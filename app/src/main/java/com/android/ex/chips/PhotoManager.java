package com.android.ex.chips;

public abstract interface PhotoManager
{
  public abstract void populatePhotoBytesAsync(RecipientEntry paramRecipientEntry, PhotoManagerCallback paramPhotoManagerCallback);

  public static abstract interface PhotoManagerCallback
  {
    public abstract void onPhotoBytesAsyncLoadFailed();

    public abstract void onPhotoBytesAsynchronouslyPopulated();

    public abstract void onPhotoBytesPopulated();
  }
}