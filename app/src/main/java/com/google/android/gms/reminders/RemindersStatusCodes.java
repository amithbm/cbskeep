package com.google.android.gms.reminders;

import com.google.android.gms.common.api.CommonStatusCodes;

public class RemindersStatusCodes extends CommonStatusCodes
{
  public static String getStatusCodeString(int paramInt)
  {
    switch (paramInt)
    {
    case 6006:
    case 6007:
    default:
      return CommonStatusCodes.getStatusCodeString(paramInt);
    case 6000:
      return "ACCOUNT_NOT_FOUND";
    case 6001:
      return "Create Reminder Failed. Possible Reason:\n 1. Reminder with the same id exists already\n";
    case 6002:
      return "Update Reminder Failed. Possible Reason:\n 1. Reminder not found\n 2. Cannot update master using updateReminder\n";
    case 6003:
      return "Delete Reminder Failed. Possible Reason:\n 1. Reminder not found\n 2. Could not delete master by DeleteReminder API\n";
    case 6004:
      return "Create Recurrence Failed. Possible Reason:\n 1. The reminder with the same recurrence id exists\n";
    case 6005:
      return "Update Recurrence Failed. Possible Reason:\n 1. Could not update instances after master. Use ChangeRecurrence instead\n";
    case 6008:
      return "Make Task Recurring Failed. Possible Reason:\n 1. Reminder does not exits\n 2. The reminder is already a recurring reminder\n 3. The recurrence series with the same recurrence id exists\n";
    case 6009:
      return "Make Recurrence Single Instance Failed. Possible Reason:\n 1. Reminder with the same id exists already\n";
    case 6010:
    }
    return "Bump Reminder Failed. Possible Reason:\n 1. Reminder not found\n";
  }
}