package com.google.android.keep.model;

import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import com.google.android.keep.p;
import com.google.android.keep.provider.i.o;
import com.google.android.keep.q.b;
import com.google.android.keep.task.i;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class r extends f
  implements q.b
{
  private ArrayList<NoteError> mItems = Lists.newArrayList();

  public r(FragmentActivity paramFragmentActivity, p paramp)
  {
    super(paramFragmentActivity, paramp, BaseModel.LoaderCreation.uA);
  }

  public static String l(List<?> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
      return "";
    return TextUtils.join(",", paramList);
  }

  public boolean a(long paramLong, String paramString, Boolean paramBoolean)
  {
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
    {
      NoteError localNoteError = (NoteError)localIterator.next();
      if ((localNoteError.dP() == paramLong) && (TextUtils.equals(localNoteError.getCode(), paramString)) && (!localNoteError.iI()) && ((paramBoolean == null) || (paramBoolean.booleanValue() == localNoteError.iJ())))
        return true;
    }
    return false;
  }

  public boolean a(String paramString, Boolean paramBoolean)
  {
    return a(dP(), paramString, paramBoolean);
  }

  public void ao(String paramString)
  {
    Object localObject = mItems.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
      if (TextUtils.equals(((NoteError)((Iterator)localObject).next()).getCode(), paramString))
      {
        ((Iterator)localObject).remove();
        i = 1;
      }
    if (i != 0)
    {
      localObject = new i(getActivity());
      ((i)localObject).e(paramString, gA().getId());
      ((i)localObject).execute(new Void[0]);
    }
    b(ModelEventDispatcher.EventType.xo);
  }

  void gB()
  {
  }

  protected Loader<Cursor> gy()
  {
    long l = gA().getId();
    return new CursorLoader(getActivity(), i.o.CONTENT_URI, NoteError.COLUMNS, "account_id=?", new String[] { Long.valueOf(l).toString() }, null);
  }

  protected void gz()
  {
  }

  public boolean iK()
  {
    Iterator localIterator = mItems.iterator();
    while (localIterator.hasNext())
    {
      NoteError localNoteError = (NoteError)localIterator.next();
      if ((TextUtils.equals("WS", localNoteError.getCode())) && (!localNoteError.iI()))
        return true;
    }
    return false;
  }

  public boolean iL()
  {
    return a("AB", null);
  }

  protected void j(Cursor paramCursor)
  {
    ArrayList localArrayList = Lists.newArrayList();
    paramCursor.moveToPosition(-1);
    while (paramCursor.moveToNext())
      localArrayList.add(NoteError.r(paramCursor));
    if (isInitialized())
    {
      if (!mItems.equals(localArrayList))
      {
        mItems = localArrayList;
        b(ModelEventDispatcher.EventType.xo);
      }
      return;
    }
    mItems = localArrayList;
    b(ModelEventDispatcher.EventType.wF);
  }
}