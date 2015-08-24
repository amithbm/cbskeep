package com.google.android.keep.browse;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewStub;
import com.google.android.keep.model.Label;
import com.google.android.keep.ui.LabelLayout;
import com.google.android.keep.ui.c;
import java.util.ArrayList;

public class i extends n
{
  public static o[] hl = { j.hm };
  private Label ee;

  public i(Context paramContext, com.google.android.keep.p paramp, Label paramLabel, Cursor paramCursor, p paramp1, c paramc)
  {
    super(paramContext, paramp, paramCursor, paramp1, paramc, hl);
    ee = paramLabel;
  }

  protected void a(View paramView, ArrayList<Label> paramArrayList)
  {
    LabelLayout localLabelLayout2 = (LabelLayout)paramView.findViewById(2131493098);
    LabelLayout localLabelLayout1 = localLabelLayout2;
    if (localLabelLayout2 == null)
      localLabelLayout1 = (LabelLayout)((ViewStub)paramView.findViewById(2131493097)).inflate();
    paramArrayList.remove(ee);
    localLabelLayout1.d(paramArrayList);
  }
}