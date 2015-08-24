package com.google.android.keep.ui;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

public class s extends DialogFragment
  implements DatePickerDialog.OnDateSetListener
{
  private i.a Lw;

  public static s c(i.a parama, int paramInt1, int paramInt2, int paramInt3)
  {
    s locals = new s();
    locals.b(parama);
    parama = new Bundle();
    parama.putInt("year", paramInt1);
    parama.putInt("month", paramInt2);
    parama.putInt("day", paramInt3);
    locals.setArguments(parama);
    return locals;
  }

  public void b(i.a parama)
  {
    Lw = parama;
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getArguments();
    int i = paramBundle.getInt("year");
    int j = paramBundle.getInt("month");
    int k = paramBundle.getInt("day");
    paramBundle = new DatePickerDialog(getActivity(), this, i, j, k);
    paramBundle.getDatePicker().setMinDate(System.currentTimeMillis());
    return paramBundle;
  }

  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if (Lw != null)
      Lw.b(paramInt1, paramInt2, paramInt3);
  }
}