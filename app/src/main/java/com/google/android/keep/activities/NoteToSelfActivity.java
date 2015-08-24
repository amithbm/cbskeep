package com.google.android.keep.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.keep.b;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.j;
import com.google.android.keep.model.m;
import com.google.android.keep.provider.KeepProvider;
import com.google.android.keep.task.TaskHelper.ErrorCode;
import com.google.android.keep.task.TaskHelper.a;
import com.google.android.keep.task.TreeEntityTask;
import com.google.android.keep.task.TreeEntityTask.a;
import com.google.android.keep.util.e;
import com.google.android.keep.util.o;

public class NoteToSelfActivity extends b
{
  private final TaskHelper.a<Long> du = new TaskHelper.a()
  {
    public void a(TaskHelper.ErrorCode paramAnonymousErrorCode)
    {
      if (!isFinishing())
        e.b(NoteToSelfActivity.this, 2131231249);
    }

    public void a(Long paramAnonymousLong)
    {
      if (!isFinishing())
        e.b(NoteToSelfActivity.this, 2131231248);
    }
  };

  protected String S()
  {
    return getString(2131230845);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = o.O(this);
    if (paramBundle == null)
    {
      e.b(this, 2131231258);
      finish();
      return;
    }
    paramBundle = new TreeEntityTask.a(this).o(Long.valueOf(paramBundle.getId())).i(TreeEntity.TreeEntityType.zO).a(new m(getIntent().getStringExtra("android.intent.extra.TEXT"), false, KeepProvider.kw())).a(du);
    Uri localUri = (Uri)getIntent().getParcelableExtra("android.intent.extra.STREAM");
    if (localUri != null)
      paramBundle.v(localUri);
    paramBundle.lG().execute(new Void[0]);
    finish();
  }
}