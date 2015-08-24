package com.google.android.keep.ui;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;

public class t extends DialogFragment
  implements TimePickerDialog.OnTimeSetListener
{
  private k.a Lx;

  public static t c(k.a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    t localt = new t();
    localt.b(parama);
    parama = new Bundle();
    parama.putInt("hour", paramInt1);
    parama.putInt("minute", paramInt2);
    parama.putBoolean("24hour", paramBoolean);
    localt.setArguments(parama);
    return localt;
  }

  public void b(k.a parama)
  {
    Lx = parama;
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getArguments();
    int i = paramBundle.getInt("hour");
    int j = paramBundle.getInt("minute");
    boolean bool = paramBundle.getBoolean("24hour");
    return new TimePickerDialog(getActivity(), this, i, j, bool);
  }

  public void onTimeSet(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    if (Lx != null)
      Lx.h(paramInt1, paramInt2);
  }
}