package com.google.android.keep.browse;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import com.google.android.common.base.Preconditions;
import com.google.android.keep.activities.BrowseActivity;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.editor.d;
import com.google.android.keep.editor.e.a;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.TreeEntity;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.j;
import com.google.android.keep.navigation.BrowseNavigationRequest;
import com.google.android.keep.navigation.EditorNavigationRequest;
import com.google.android.keep.navigation.EditorNavigationRequest.a;
import com.google.android.keep.navigation.NavigationManager;
import com.google.android.keep.navigation.NavigationManager.NavigationMode;
import com.google.android.keep.navigation.NavigationRequest;
import com.google.android.keep.p.a;
import com.google.android.keep.provider.KeepProvider;
import com.google.android.keep.provider.KeepPublicProvider;
import com.google.android.keep.provider.i.j;
import com.google.android.keep.q.d;
import com.google.android.keep.task.TaskHelper;
import com.google.android.keep.task.TaskHelper.ErrorCode;
import com.google.android.keep.task.TaskHelper.a;
import com.google.android.keep.task.TreeEntityTask;
import com.google.android.keep.task.TreeEntityTask.a;
import com.google.android.keep.toasts.ToastListener;
import com.google.android.keep.toasts.ToastListener.g;
import com.google.android.keep.toasts.ToastsFragment;
import com.google.android.keep.ui.b.a;
import com.google.android.keep.ui.p;
import com.google.android.keep.util.o;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class a
  implements q.d, com.google.android.keep.r
{
  private static final String TAG = a.class.getSimpleName();
  private NavigationManager cQ;
  private BrowseActivity dX;
  private EditorNavigationRequest dY;
  private BrowseNavigationRequest dZ;
  private View ea;
  private boolean eb;
  private boolean ec;
  private boolean ed;
  private Label ee = null;
  private Uri ef;
  private FragmentManager mFragmentManager;
  private Handler mHandler = new Handler();

  public a(BrowseActivity paramBrowseActivity, NavigationManager paramNavigationManager)
  {
    dX = paramBrowseActivity;
    cQ = paramNavigationManager;
    mFragmentManager = paramBrowseActivity.getSupportFragmentManager();
    ec = dX.getResources().getBoolean(2131623944);
    dX.fM().b(this);
  }

  @TargetApi(16)
  private Intent a(Uri paramUri)
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    if (KeepApplication.ae())
    {
      localIntent.putExtra("output", paramUri);
      localIntent.setClipData(ClipData.newRawUri("keep:camera_uri_label", paramUri));
    }
    while (true)
    {
      localIntent.addFlags(3);
      return localIntent;
      localIntent.putExtra("output", KeepPublicProvider.r(paramUri));
    }
  }

  private void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    try
    {
      dX.startActivityForResult(paramIntent, paramInt1);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      com.google.android.keep.util.r.e(TAG, "No activity found for " + paramIntent, new Object[0]);
      new b.a(dX, 1).bO(paramInt2).bR(1).show();
    }
  }

  private void a(Fragment paramFragment, int paramInt, String paramString, boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction = mFragmentManager.beginTransaction();
    if (paramBoolean)
    {
      if (!ec)
        break label70;
      localFragmentTransaction.setCustomAnimations(2131034124, 2131034125, 2131034124, 2131034125);
    }
    while (true)
    {
      localFragmentTransaction.replace(paramInt, paramFragment, paramString);
      localFragmentTransaction.addToBackStack(paramString);
      localFragmentTransaction.commitAllowingStateLoss();
      mFragmentManager.executePendingTransactions();
      aI();
      return;
      label70: localFragmentTransaction.setCustomAnimations(2131034127, 2131034126, 2131034127, 2131034126);
    }
  }

  private void a(EditorNavigationRequest paramEditorNavigationRequest)
  {
    dY = paramEditorNavigationRequest;
  }

  private void a(final TreeEntityTask paramTreeEntityTask)
  {
    dX.fM().b(new p.a()
    {
      public void a(com.google.android.keep.r paramAnonymousr)
      {
        if ((paramAnonymousr instanceof e.a))
          ((e.a)paramAnonymousr).b(paramTreeEntityTask);
      }
    });
  }

  private void aH()
  {
    if (ea == null)
      ea = dX.findViewById(2131493042);
  }

  private int aJ()
  {
    Resources localResources;
    if (dZ.ka() == NavigationManager.NavigationMode.AM)
    {
      i = 1;
      localResources = dX.getResources();
      if (i == 0)
        break label42;
    }
    label42: for (int i = 2131296400; ; i = 2131296401)
    {
      return localResources.getColor(i);
      i = 0;
      break;
    }
  }

  private boolean aO()
  {
    com.google.android.keep.sharing.e locale = aR();
    return (locale != null) && (!locale.isRemoving()) && (locale.isResumed());
  }

  private boolean aP()
  {
    p localp = aS();
    return (localp != null) && (!localp.isRemoving()) && (localp.isResumed());
  }

  private com.google.android.keep.sharing.e aR()
  {
    Fragment localFragment = mFragmentManager.findFragmentByTag("share_fragment");
    if (localFragment != null)
      return (com.google.android.keep.sharing.e)localFragment;
    return null;
  }

  private p aS()
  {
    Fragment localFragment = mFragmentManager.findFragmentByTag("label_management_fragment");
    if (localFragment != null)
      return (p)localFragment;
    return null;
  }

  private void ba()
  {
    mFragmentManager.popBackStackImmediate();
    aI();
  }

  private boolean bb()
  {
    cQ.jZ().by();
    b(new EditorNavigationRequest.a().jU());
    return true;
  }

  private boolean bc()
  {
    return false;
  }

  private boolean bd()
  {
    return false;
  }

  private void c(final EditorNavigationRequest paramEditorNavigationRequest)
  {
    paramEditorNavigationRequest.as(KeepProvider.kw());
    j localj = o.O(dX);
    a locala = new a(paramEditorNavigationRequest);
    paramEditorNavigationRequest = TreeEntityTask.a(dX, localj, paramEditorNavigationRequest, locala).lG();
    mHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        paramEditorNavigationRequest.execute(new Void[0]);
      }
    }
    , 100L);
    a(paramEditorNavigationRequest);
  }

  private boolean d(EditorNavigationRequest paramEditorNavigationRequest)
  {
    switch (paramEditorNavigationRequest.jO())
    {
    default:
      return false;
    case 1:
      ef = t(10);
      return true;
    case 3:
      u(11);
      return true;
    case 2:
    }
    be();
    return true;
  }

  public String L()
  {
    if (aQ())
    {
      BrowseActivity localBrowseActivity = dX;
      if (dY.jM() == TreeEntity.TreeEntityType.zO);
      for (int i = 2131231032; ; i = 2131231033)
        return localBrowseActivity.getString(i);
    }
    return dX.getString(2131231031);
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    EditorNavigationRequest localEditorNavigationRequest = aM();
    switch (paramInt1)
    {
    case 7:
    case 8:
    case 9:
    default:
    case 10:
    case 11:
    case 6:
    }
    do
    {
      do
      {
        do
          return;
        while (paramInt2 != -1);
        localEditorNavigationRequest.g(ef);
        b(localEditorNavigationRequest);
        return;
      }
      while (paramInt2 != -1);
      localEditorNavigationRequest.h(paramIntent.getData());
      b(localEditorNavigationRequest);
      return;
      if (paramInt2 == -1)
      {
        localEditorNavigationRequest.i(paramIntent.getData());
        paramIntent = paramIntent.getStringArrayListExtra("android.speech.extra.RESULTS");
        if (paramIntent.size() > 0);
        for (paramIntent = (String)paramIntent.get(0); ; paramIntent = null)
        {
          localEditorNavigationRequest.setText(paramIntent);
          b(localEditorNavigationRequest);
          return;
        }
      }
    }
    while (paramInt2 == 0);
    com.google.android.keep.util.e.b(dX, 2131231261);
  }

  public void a(long paramLong, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramLong == -1L)
      return;
    a(com.google.android.keep.sharing.e.a(paramLong, paramBoolean1, paramString), 2131493044, "share_fragment", paramBoolean2);
  }

  public void a(Label paramLabel)
  {
    ee = paramLabel;
  }

  public void a(final j paramj, final List<? extends TreeEntity> paramList)
  {
    b(new Runnable()
    {
      public void run()
      {
        TaskHelper.d(a.b(a.this), paramj, paramList);
      }
    });
  }

  public void a(BrowseNavigationRequest paramBrowseNavigationRequest)
  {
    dZ = paramBrowseNavigationRequest;
  }

  public void a(EditorNavigationRequest paramEditorNavigationRequest, int paramInt)
  {
    if (paramEditorNavigationRequest == null)
      return;
    aZ();
    aX();
    if (paramEditorNavigationRequest.jJ())
    {
      if (d(paramEditorNavigationRequest))
      {
        paramEditorNavigationRequest.jT();
        a(paramEditorNavigationRequest);
        return;
      }
      c(paramEditorNavigationRequest);
    }
    ((ToastsFragment)com.google.android.keep.util.e.a(dX, 2131493048)).lM();
    a(paramEditorNavigationRequest);
    cQ.a(dX, paramEditorNavigationRequest);
    paramEditorNavigationRequest = cQ.jZ().getView();
    com.google.android.keep.util.a.g(paramEditorNavigationRequest, 4);
    com.google.android.keep.util.a.a(paramEditorNavigationRequest, dX.getString(paramInt));
  }

  public void a(List<Long> paramList)
  {
    b(new Runnable()
    {
      public void run()
      {
        ei.a(ej);
      }
    });
  }

  public void a(final List<Long> paramList, final Account paramAccount)
  {
    b(new Runnable()
    {
      public void run()
      {
        TaskHelper.a(a.b(a.this), paramList, paramAccount);
      }
    });
  }

  public void a(List<? extends TreeEntity> paramList, boolean paramBoolean)
  {
    b(new Runnable()
    {
      public void run()
      {
        ei.a(ek);
      }
    });
  }

  public boolean a(Runnable paramRunnable)
  {
    d locald = cQ.jY();
    if (locald != null)
    {
      ((d)locald).c(paramRunnable);
      return true;
    }
    return false;
  }

  public void aF()
  {
    aH();
    ea.setVisibility(0);
  }

  public void aG()
  {
    aH();
    ea.setVisibility(8);
  }

  public void aI()
  {
    if ((aS() != null) && (!aS().isRemoving()))
      if (ec)
        dX.q(aJ());
    Object localObject;
    do
    {
      return;
      localObject = aS();
      dX.q(((p)localObject).getStatusBarColor());
      return;
      if (aQ())
      {
        localObject = cQ.jY();
        if (ec)
        {
          dX.q(aJ());
          return;
        }
        int i = ((d)localObject).getStatusBarColor();
        if (aO())
          i = aR().getStatusBarColor();
        dX.q(i);
        return;
      }
      localObject = cQ.jZ();
    }
    while ((localObject == null) || (!((c)localObject).isResumed()));
    ((c)localObject).bF();
  }

  public boolean aK()
  {
    return eb;
  }

  public BrowseNavigationRequest aL()
  {
    return dZ;
  }

  public EditorNavigationRequest aM()
  {
    return dY;
  }

  public boolean aN()
  {
    return ec;
  }

  public boolean aQ()
  {
    d locald = cQ.jY();
    return (locald != null) && (!locald.isRemoving()) && (locald.isResumed());
  }

  public void aT()
  {
    c localc = cQ.jZ();
    if (localc != null)
      localc.bt();
  }

  public void aU()
  {
    ((ToastsFragment)com.google.android.keep.util.e.a(dX, 2131493048)).lM();
    aZ();
    a(null);
    ed = true;
  }

  public Label aV()
  {
    return ee;
  }

  public void aW()
  {
    aZ();
    a(null);
    ed = true;
  }

  public boolean aX()
  {
    boolean bool = false;
    a(null);
    aY();
    aZ();
    if (cQ.jY() != null)
    {
      ba();
      com.google.android.keep.util.a.g(cQ.jZ().getView(), 0);
      bool = true;
    }
    return bool;
  }

  public boolean aY()
  {
    if (aR() != null)
    {
      ba();
      return true;
    }
    return false;
  }

  public boolean aZ()
  {
    boolean bool = false;
    if (aS() != null)
    {
      ba();
      if ((ec) && (!aQ()))
        aG();
      com.google.android.keep.util.a.g(cQ.jZ().getView(), 0);
      bool = true;
    }
    return bool;
  }

  public void b(EditorNavigationRequest paramEditorNavigationRequest)
  {
    a(paramEditorNavigationRequest, 2131231121);
  }

  public boolean b(Runnable paramRunnable)
  {
    d locald = cQ.jY();
    if (locald != null)
    {
      ((d)locald).d(paramRunnable);
      return true;
    }
    return false;
  }

  public void be()
  {
    final Intent localIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    localIntent.putExtra("android.speech.extra.GET_AUDIO", true);
    localIntent.putExtra("android.speech.extra.GET_AUDIO_FORMAT", "audio/AMR");
    if (aK())
    {
      mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          a.a(a.this, localIntent, 6, 2131231261);
        }
      }
      , 500L);
      return;
    }
    a(localIntent, 6, 2131231261);
  }

  public void c(long[] paramArrayOfLong)
  {
    if ((aP()) && ((aS() instanceof com.google.android.keep.ui.r)));
    do
    {
      return;
      a(com.google.android.keep.ui.r.e(paramArrayOfLong), 2131493045, "label_management_fragment", true);
    }
    while ((!ec) || (aQ()));
    aF();
  }

  public void d(Bundle paramBundle)
  {
    dY = ((EditorNavigationRequest)paramBundle.getParcelable("key_current_editor_navigation_request"));
    ef = ((Uri)paramBundle.getParcelable("key_new_image_uri"));
  }

  public void d(boolean paramBoolean)
  {
    eb = paramBoolean;
  }

  public void e(Bundle paramBundle)
  {
    paramBundle.putParcelable("key_current_editor_navigation_request", dY);
    paramBundle.putParcelable("key_new_image_uri", ef);
  }

  public void e(NavigationManager.NavigationMode paramNavigationMode)
  {
    if (ed)
    {
      f(paramNavigationMode);
      ed = false;
    }
  }

  public void e(boolean paramBoolean)
  {
    if ((aP()) && ((aS() instanceof com.google.android.keep.ui.m)))
      return;
    a(com.google.android.keep.ui.m.aF(paramBoolean), 2131493045, "label_management_fragment", true);
    if ((ec) && (!aQ()))
      aF();
    com.google.android.keep.util.a.g(cQ.jZ().getView(), 4);
  }

  public void f(NavigationManager.NavigationMode paramNavigationMode)
  {
    if (paramNavigationMode == NavigationManager.NavigationMode.AL)
      return;
    dX.c(paramNavigationMode);
    if ((paramNavigationMode == NavigationManager.NavigationMode.AO) && (ee != null))
    {
      cQ.a(dX, NavigationRequest.c(paramNavigationMode, ee));
      return;
    }
    cQ.a(dX, NavigationRequest.l(paramNavigationMode));
  }

  public boolean onBackPressed()
  {
    if (aY());
    c localc;
    do
    {
      do
      {
        do
          return true;
        while (aZ());
        if (!a(null))
          break;
      }
      while (dX.getSupportFragmentManager().findFragmentByTag("browse_fragment") != null);
      dX.finish();
      return true;
      if (aL().ka() == NavigationManager.NavigationMode.AO)
      {
        f(NavigationManager.NavigationMode.AM);
        return true;
      }
      localc = cQ.jZ();
    }
    while ((localc != null) && (localc.onBackPressed()));
    return dX.getSupportFragmentManager().popBackStackImmediate();
  }

  public void onDrawerOpened()
  {
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default:
    case 42:
    case 32:
    case 67:
    }
    do
    {
      do
      {
        do
          return false;
        while (!paramKeyEvent.isCtrlPressed());
        return bb();
      }
      while (!paramKeyEvent.isCtrlPressed());
      return bc();
    }
    while (!paramKeyEvent.isCtrlPressed());
    return bd();
  }

  public Uri t(final int paramInt)
  {
    Object localObject = o.O(dX);
    long l = System.currentTimeMillis();
    File localFile = com.google.android.keep.provider.e.b(dX, ((j)localObject).getId(), l);
    localObject = a(i.j.a(((j)localObject).getId(), l));
    if (aK())
    {
      ((Intent)localObject).setAction("android.media.action.IMAGE_CAPTURE_SECURE");
      mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          a.a(a.this, ep, paramInt, 2131231259);
        }
      }
      , 500L);
    }
    while (true)
    {
      return Uri.fromFile(localFile);
      a((Intent)localObject, paramInt, 2131231259);
    }
  }

  public void u(int paramInt)
  {
    if (aK())
      throw new UnsupportedOperationException("Gallery not supported for lockscreen widget");
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    localIntent.addFlags(524288);
    localIntent.setType("image/*");
    a(localIntent, paramInt, 2131231260);
  }

  private class a
    implements TaskHelper.a<Long>
  {
    private final EditorNavigationRequest es;

    a(EditorNavigationRequest arg2)
    {
      Object localObject;
      es = localObject;
    }

    public void a(TaskHelper.ErrorCode paramErrorCode)
    {
      Toast.makeText(a.b(a.this), 2131231249, 1).show();
    }

    public void a(Long paramLong)
    {
      if (paramLong != null);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool);
        es.I(paramLong.longValue());
        d locald = a.a(a.this).jY();
        if ((locald != null) && (TextUtils.equals(locald.bo(), es.jL())))
          locald.h(paramLong.longValue());
        return;
      }
    }
  }
}