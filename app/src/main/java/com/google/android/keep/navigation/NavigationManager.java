package com.google.android.keep.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.google.android.keep.browse.c;
import com.google.android.keep.editor.b;
import com.google.android.keep.editor.d;

public class NavigationManager
{
  private NavigationRequest AK;
  private final FragmentManager mFragmentManager;

  public NavigationManager(FragmentManager paramFragmentManager)
  {
    mFragmentManager = paramFragmentManager;
  }

  private void a(FragmentTransaction paramFragmentTransaction, BrowseNavigationRequest paramBrowseNavigationRequest)
  {
    if ((paramBrowseNavigationRequest.ka() == NavigationMode.AN) || (paramBrowseNavigationRequest.ka() == NavigationMode.AO))
      paramFragmentTransaction.setCustomAnimations(2131034124, 2131034125, 2131034124, 2131034125);
    paramFragmentTransaction.replace(2131493039, c.b(paramBrowseNavigationRequest), "browse_fragment");
  }

  private void a(FragmentTransaction paramFragmentTransaction, EditorNavigationRequest paramEditorNavigationRequest)
  {
    if (paramEditorNavigationRequest.in())
      paramFragmentTransaction.replace(2131493046, b.e(paramEditorNavigationRequest), "conflict_resolution_fragment");
    while (true)
    {
      paramFragmentTransaction.addToBackStack("editor_fragment");
      return;
      d locald = d.f(paramEditorNavigationRequest);
      if (paramEditorNavigationRequest.jK() == null)
        paramFragmentTransaction.setCustomAnimations(2131034127, 2131034126, 2131034127, 2131034126);
      paramFragmentTransaction.replace(2131493043, locald, "editor_fragment");
    }
  }

  public static void j(NavigationMode paramNavigationMode)
  {
    if ((paramNavigationMode == NavigationMode.AM) || (paramNavigationMode == NavigationMode.AN) || (paramNavigationMode == NavigationMode.AP) || (paramNavigationMode == NavigationMode.AR) || (paramNavigationMode == NavigationMode.AT) || (paramNavigationMode == NavigationMode.AS) || (paramNavigationMode == NavigationMode.AQ) || (paramNavigationMode == NavigationMode.AO))
      return;
    throw new IllegalStateException("Invalid mode " + paramNavigationMode);
  }

  public void a(Activity paramActivity, NavigationRequest paramNavigationRequest)
  {
    if ((paramNavigationRequest == null) || (paramActivity == null))
      throw new IllegalArgumentException("Can't have null NavigationRequest or activity");
    if (paramActivity.isFinishing())
      return;
    paramActivity = mFragmentManager.beginTransaction();
    AK = paramNavigationRequest;
    paramNavigationRequest = AK.ka();
    switch (1.cP[paramNavigationRequest.ordinal()])
    {
    default:
      throw new IllegalStateException("Invalid mode " + paramNavigationRequest);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
      if (!(AK instanceof BrowseNavigationRequest))
        throw new IllegalArgumentException("For navigation to browse, given request is not BrowseNavigationRequest: " + AK);
      a(paramActivity, (BrowseNavigationRequest)AK);
    case 6:
    case 7:
    case 8:
    }
    while (!paramActivity.isEmpty())
    {
      paramActivity.commitAllowingStateLoss();
      mFragmentManager.executePendingTransactions();
      return;
      if (!(AK instanceof LabelNavigationRequest))
        throw new IllegalArgumentException("Must navigate to label view via a LabelNavigationRequest" + AK);
      a(paramActivity, (LabelNavigationRequest)AK);
      continue;
      if (!(AK instanceof EditorNavigationRequest))
        throw new IllegalArgumentException("For navigation to editor, given request is not EditorNavigationRequest: " + AK);
      a(paramActivity, (EditorNavigationRequest)AK);
    }
  }

  public void d(Bundle paramBundle)
  {
    AK = ((NavigationRequest)paramBundle.getParcelable("Keep_CurrentRequest"));
  }

  public void e(Bundle paramBundle)
  {
    paramBundle.putParcelable("Keep_CurrentRequest", AK);
  }

  public d jY()
  {
    return (d)mFragmentManager.findFragmentByTag("editor_fragment");
  }

  public c jZ()
  {
    return (c)mFragmentManager.findFragmentByTag("browse_fragment");
  }

  public static enum NavigationMode
  {
  }
}