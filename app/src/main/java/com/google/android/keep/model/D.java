package com.google.android.keep.model;

import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.Loader;
import com.google.android.keep.db.DbOperation;
import com.google.android.keep.p;
import com.google.android.keep.provider.i.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class D extends b<VoiceBlob>
{
  public D(FragmentActivity paramFragmentActivity, p paramp)
  {
    super(paramFragmentActivity, paramp, BaseModel.LoaderCreation.uB);
  }

  protected Loader<Cursor> gy()
  {
    return VoiceBlob.a(getActivity(), dP());
  }

  public void j(List<DbOperation> paramList)
  {
    if (dP() == -1L);
    while (true)
    {
      return;
      Iterator localIterator = mItems.iterator();
      VoiceBlob localVoiceBlob;
      while (localIterator.hasNext())
      {
        localVoiceBlob = (VoiceBlob)localIterator.next();
        if (localVoiceBlob.gv())
          paramList.add(DbOperation.cY().b(i.e.CONTENT_URI).a(localVoiceBlob.b(Long.valueOf(dP()))));
      }
      localIterator = gG().iterator();
      while (localIterator.hasNext())
      {
        localVoiceBlob = (VoiceBlob)localIterator.next();
        paramList.add(DbOperation.cZ().b(i.e.Ce).a("_id = " + localVoiceBlob.getId(), null).a("is_deleted", Integer.valueOf(-1)));
      }
    }
  }

  VoiceBlob y(Cursor paramCursor)
  {
    return new VoiceBlob(paramCursor);
  }
}