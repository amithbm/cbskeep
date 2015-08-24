package com.google.android.gms.reminders;

public class CreateReminderOptions
{
  private final CreateReminderOptionsInternal zzblx;
  private final RemindersApi.ReminderCreatedListener zzbly;

  private CreateReminderOptions(RemindersApi.ReminderCreatedListener paramReminderCreatedListener, String paramString1, String paramString2, boolean paramBoolean)
  {
    zzbly = paramReminderCreatedListener;
    zzblx = new CreateReminderOptionsInternal(paramString1, paramString2, paramBoolean);
  }

  public CreateReminderOptionsInternal getInternalOptions()
  {
    return zzblx;
  }

  public RemindersApi.ReminderCreatedListener getListener()
  {
    return zzbly;
  }

  public static class Builder
  {
    private String zzblA;
    private boolean zzblB;
    private RemindersApi.ReminderCreatedListener zzbly;
    private String zzblz;

    public CreateReminderOptions build()
    {
      return new CreateReminderOptions(zzbly, zzblz, zzblA, zzblB, null);
    }

    public Builder setFetchTaskAssistance(boolean paramBoolean)
    {
      zzblB = paramBoolean;
      return this;
    }
  }
}