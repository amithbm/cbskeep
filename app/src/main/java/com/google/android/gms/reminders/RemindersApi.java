package com.google.android.gms.reminders;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.reminders.model.Recurrence;
import com.google.android.gms.reminders.model.ReminderEventBuffer;
import com.google.android.gms.reminders.model.RemindersBuffer;
import com.google.android.gms.reminders.model.SnoozePresetChangedEventBuffer;
import com.google.android.gms.reminders.model.Task;
import com.google.android.gms.reminders.model.TaskId;

public abstract interface RemindersApi
{
  public abstract PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, RemindersChangeListener paramRemindersChangeListener);

  public abstract PendingResult<Status> changeRecurrence(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2, Recurrence paramRecurrence, Task paramTask, UpdateRecurrenceOptions paramUpdateRecurrenceOptions);

  public abstract PendingResult<Status> createRecurrence(GoogleApiClient paramGoogleApiClient, String paramString, Recurrence paramRecurrence, Task paramTask);

  public abstract PendingResult<Status> createReminder(GoogleApiClient paramGoogleApiClient, Task paramTask);

  public abstract PendingResult<Status> createReminder(GoogleApiClient paramGoogleApiClient, Task paramTask, CreateReminderOptions paramCreateReminderOptions);

  public abstract PendingResult<Status> deleteRecurrence(GoogleApiClient paramGoogleApiClient, String paramString, UpdateRecurrenceOptions paramUpdateRecurrenceOptions);

  public abstract PendingResult<Status> deleteReminder(GoogleApiClient paramGoogleApiClient, TaskId paramTaskId);

  public abstract PendingResult<LoadRemindersResult> loadReminders(GoogleApiClient paramGoogleApiClient, LoadRemindersOptions paramLoadRemindersOptions);

  public abstract PendingResult<Status> makeRecurrenceSingleInstance(GoogleApiClient paramGoogleApiClient, String paramString, Task paramTask, UpdateRecurrenceOptions paramUpdateRecurrenceOptions);

  public abstract PendingResult<Status> makeTaskRecurring(GoogleApiClient paramGoogleApiClient, TaskId paramTaskId, String paramString, Recurrence paramRecurrence, Task paramTask);

  public abstract PendingResult<Status> updateRecurrence(GoogleApiClient paramGoogleApiClient, String paramString, Task paramTask, UpdateRecurrenceOptions paramUpdateRecurrenceOptions);

  public abstract PendingResult<Status> updateReminder(GoogleApiClient paramGoogleApiClient, Task paramTask);

  public static abstract interface LoadRemindersResult extends Result
  {
    public abstract RemindersBuffer getRemindersBuffer();
  }

  public static abstract interface ReminderCreatedListener
  {
    public abstract void onReminderCreated(String paramString1, String paramString2);
  }

  public static abstract interface RemindersChangeListener
  {
    public abstract void onRemindersChanged(ReminderEventBuffer paramReminderEventBuffer);

    public abstract void onSnoozePresetChanged(SnoozePresetChangedEventBuffer paramSnoozePresetChangedEventBuffer);
  }
}