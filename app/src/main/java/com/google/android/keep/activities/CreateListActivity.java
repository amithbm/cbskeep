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
import com.google.android.keep.task.TaskHelper;
import com.google.android.keep.task.TaskHelper.ErrorCode;
import com.google.android.keep.task.TaskHelper.a;
import com.google.android.keep.task.TreeEntityTask;
import com.google.android.keep.task.TreeEntityTask.a;
import com.google.android.keep.util.e;
import com.google.android.keep.util.o;
import com.google.android.keep.util.r;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;

public class CreateListActivity extends b
{
  private final String cT = "note_UUID";
  private long cU;
  private GoogleApiClient cV;
  private Action cW;
  private final TaskHelper.a<Long> cX = new TaskHelper.a()
  {
    public void a(TaskHelper.ErrorCode paramAnonymousErrorCode)
    {
      if (!isFinishing())
        e.b(CreateListActivity.this, 2131231249);
    }

    public void a(Long paramAnonymousLong)
    {
      if (!isFinishing())
        e.b(CreateListActivity.this, 2131231248);
      while ((CreateListActivity.a(CreateListActivity.this) == null) || (CreateListActivity.b(CreateListActivity.this) == null))
        return;
      CreateListActivity.a(CreateListActivity.this).connect();
      AppIndex.AppIndexApi.end(CreateListActivity.a(CreateListActivity.this), CreateListActivity.b(CreateListActivity.this)).setResultCallback(new ResultCallback()
      {
        public void a(Status paramAnonymous2Status)
        {
          CreateListActivity.a(CreateListActivity.this).disconnect();
          CreateListActivity.a(CreateListActivity.this, null);
          if (!paramAnonymous2Status.isSuccess())
            r.d("Keep", "Failed to send completion status to GmsCore.", new Object[0]);
        }
      });
    }
  };
  private final TaskHelper.a<String> cY = new TaskHelper.a()
  {
    public void a(TaskHelper.ErrorCode paramAnonymousErrorCode)
    {
      if (!isFinishing())
        e.b(CreateListActivity.this, 2131231249);
    }

    public void c(String paramAnonymousString)
    {
      if (!isFinishing())
      {
        e.b(CreateListActivity.this, 2131231248);
        return;
      }
      r.d("Keep", "UUID callback result from CheckItemListTask:" + paramAnonymousString, new Object[0]);
      if (TextUtils.isEmpty(paramAnonymousString))
        CreateListActivity.a(CreateListActivity.this, paramAnonymousString, 0);
      while (true)
      {
        finish();
        return;
        CreateListActivity.a(CreateListActivity.this, paramAnonymousString, 3);
      }
    }
  };
  private String mAccountName;

  private List<m> T()
  {
    String[] arrayOfString = getIntent().getStringArrayExtra("com.google.android.gms.actions.EXTRA_ITEM_NAMES");
    ArrayList localArrayList = new ArrayList();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (!Strings.isNullOrEmpty(str))
          localArrayList.add(new m(str, false));
        i += 1;
      }
    }
    return localArrayList;
  }

  private void a(TreeEntityTask.a parama)
  {
    String str1 = getIntent().getStringExtra("noteUuid");
    String str2 = getIntent().getStringExtra("com.google.android.gms.actions.EXTRA_LIST_NAME");
    String str3 = getIntent().getAction();
    if ("com.google.android.gms.actions.CREATE_ITEM_LIST".equals(str3))
    {
      parama.a(cX);
      a(parama, str1, 0);
    }
    do
    {
      do
      {
        return;
        if ("com.google.android.gms.actions.APPEND_ITEM_LIST".equals(str3))
        {
          if ((TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
          {
            TaskHelper.a(this, cU, str2, cY);
            return;
          }
          parama.a(cX);
          a(parama, str1, 3);
          return;
        }
        if (!"com.google.android.gms.actions.UPDATE_ITEM_LIST".equals(str3))
          break;
      }
      while (TextUtils.isEmpty(str1));
      parama.a(cX);
      a(parama, str1, 2);
      return;
    }
    while ((!"com.google.android.gms.actions.DELETE_ITEM_LIST".equals(str3)) || (TextUtils.isEmpty(str1)));
    parama.bf(str1).bL(1).lG().execute(new Void[0]);
  }

  private void a(TreeEntityTask.a parama, String paramString, int paramInt)
  {
    String str2 = getIntent().getStringExtra("com.google.android.gms.actions.EXTRA_LIST_NAME");
    List localList = T();
    int i = 0;
    String str1 = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str1 = KeepProvider.kw();
      i = 1;
    }
    String str3 = getIntent().getStringExtra("com.google.android.gms.action.EXTRA_COMPLETION_TOKEN");
    StringBuilder localStringBuilder = new StringBuilder().append("android-app://com.google.android.keep/http/keep.google.com/#note/").append(str1);
    if (i != 0);
    for (paramString = "&new=true"; ; paramString = "")
    {
      paramString = Uri.parse(paramString);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)))
      {
        cV = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        paramString = new Thing.Builder().setName("note_UUID").setUrl(paramString).build();
        cW = new Action.Builder("http://schema.org/CreateAction").setAccountName(mAccountName).setContextOnly(true).setActionStatus("http://schema.org/CompletedActionStatus").setObject(paramString).put("completionToken", str3).build();
      }
      if ((!TextUtils.isEmpty(str2)) || (!localList.isEmpty()))
        break;
      return;
    }
    if (!TextUtils.isEmpty(str1))
      parama.bf(str1);
    if (!TextUtils.isEmpty(str2))
      parama.bg(str2);
    r.a("Keep", "Handle " + paramInt + " action with Note UUID:" + str1, new Object[0]);
    parama.bL(paramInt).o(Long.valueOf(cU)).i(TreeEntity.TreeEntityType.zP).b((m[])localList.toArray(new m[localList.size()])).lG().execute(new Void[0]);
  }

  private void a(String paramString, int paramInt)
  {
    a(new TreeEntityTask.a(this), paramString, paramInt);
  }

  protected String S()
  {
    return getString(2131230846);
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
    cU = paramBundle.getId();
    a(new TreeEntityTask.a(this).o(Long.valueOf(cU)).i(TreeEntity.TreeEntityType.zP));
    finish();
  }
}