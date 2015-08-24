package com.google.android.keep.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.Action.Builder;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.Thing.Builder;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
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
import com.google.android.keep.util.r;

public class VoiceActionActivity extends b
{
  private GoogleApiClient cV = null;
  private Action cW = null;
  private final TaskHelper.a<Long> du = new TaskHelper.a()
  {
    public void a(TaskHelper.ErrorCode paramAnonymousErrorCode)
    {
      if (!isFinishing())
        e.b(VoiceActionActivity.this, 2131231249);
    }

    public void a(Long paramAnonymousLong)
    {
      if (!isFinishing())
        e.b(VoiceActionActivity.this, 2131231248);
      while ((VoiceActionActivity.a(VoiceActionActivity.this) == null) || (VoiceActionActivity.b(VoiceActionActivity.this) == null))
        return;
      VoiceActionActivity.a(VoiceActionActivity.this).connect();
      AppIndex.AppIndexApi.end(VoiceActionActivity.a(VoiceActionActivity.this), VoiceActionActivity.b(VoiceActionActivity.this)).setResultCallback(new ResultCallback()
      {
        public void a(Status paramAnonymous2Status)
        {
          VoiceActionActivity.a(VoiceActionActivity.this).disconnect();
          VoiceActionActivity.a(VoiceActionActivity.this, null);
          if (!paramAnonymous2Status.isSuccess())
            r.d("Keep", "Failed to send completion status to GmsCore.", new Object[0]);
        }
      });
    }
  };
  private String mAccountName;

  private void a(TreeEntityTask.a parama)
  {
    String str2 = getIntent().getAction();
    int i = -1;
    switch (str2.hashCode())
    {
    default:
      switch (i)
      {
      default:
        r.d("Keep", "Unkown action: " + str2, new Object[0]);
      case 0:
      case 1:
      case 2:
      }
      break;
    case -473495140:
    case -1101743539:
    case -553367057:
    }
    label196: 
    do
    {
      return;
      if (!str2.equals("com.google.android.gms.actions.CREATE_NOTE"))
        break;
      i = 0;
      break;
      if (!str2.equals("com.google.android.gms.actions.DELETE_NOTE"))
        break;
      i = 1;
      break;
      if (!str2.equals("com.google.android.gms.actions.UPDATE_NOTE"))
        break;
      i = 2;
      break;
      parama.bL(0);
      localObject = getIntent().getStringExtra("android.intent.extra.TEXT");
      if (TextUtils.isEmpty((CharSequence)localObject))
        break label370;
      parama.a(new m((String)localObject, false, KeepProvider.kw()));
      localObject = (Uri)getIntent().getParcelableExtra("android.intent.extra.STREAM");
      if (localObject != null)
        parama.v((Uri)localObject);
      str1 = getIntent().getStringExtra("noteUuid");
      localObject = str1;
      if (!TextUtils.isEmpty(str1))
        break label258;
    }
    while (!str2.equals("com.google.android.gms.actions.CREATE_NOTE"));
    Object localObject = KeepProvider.kw();
    label258: parama.bf((String)localObject);
    r.a("Keep", "Handle " + str2 + " action with Note UUID:" + (String)localObject, new Object[0]);
    String str1 = getIntent().getStringExtra("com.google.android.gms.action.EXTRA_COMPLETION_TOKEN");
    if (str2.equals("com.google.android.gms.actions.CREATE_NOTE"))
    {
      if (TextUtils.isEmpty(str1))
        break label411;
      a(str1, (String)localObject);
    }
    while (true)
    {
      parama.lG().execute(new Void[0]);
      return;
      parama.bL(1);
      break;
      parama.bL(2);
      break;
      label370: if (str2.equals("com.google.android.gms.actions.DELETE_NOTE"))
        break label196;
      r.d("Keep", "No text or text is empty when processing " + str2, new Object[0]);
      return;
      label411: r.d("Keep", "No completion token with ACTION_CREATE_NOTE.", new Object[0]);
    }
  }

  private void a(String paramString1, String paramString2)
  {
    cV = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    paramString2 = Uri.parse("android-app://com.google.android.keep/http/keep.google.com/#note/" + paramString2);
    paramString2 = new Thing.Builder().setName("NOTE_UUID").setUrl(paramString2).build();
    cW = new Action.Builder("http://schema.org/CreateAction").setAccountName(mAccountName).setContextOnly(true).setActionStatus("http://schema.org/CompletedActionStatus").setObject(paramString2).put("completionToken", paramString1).build();
  }

  protected String S()
  {
    return getString(2131230844);
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
    mAccountName = paramBundle.getName();
    a(new TreeEntityTask.a(this).i(TreeEntity.TreeEntityType.zO).o(Long.valueOf(paramBundle.getId())).a(du));
    finish();
  }
}