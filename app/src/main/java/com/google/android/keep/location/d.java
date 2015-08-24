package com.google.android.keep.location;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.keep.util.o;
import java.util.List;

public class d extends i<g>
  implements LocationAliasManager.a
{
  private GoogleApiClient gh;
  private h sr;
  private LocationAliasManager ss;

  public static d a(Fragment paramFragment, String paramString1, String paramString2)
  {
    d locald = new d();
    locald.a(paramString1, paramString2, 2130968720, 2130968721, paramString1);
    locald.setTargetFragment(paramFragment, 0);
    return locald;
  }

  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (!TextUtils.isEmpty(paramEditable))
    {
      fR().t(paramEditable);
      return;
    }
    ss.fQ();
  }

  public void f(List<g> paramList)
  {
    sr.h(paramList);
  }

  protected j<g> fR()
  {
    return sr;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = getActivity();
    c localc = new c();
    gh = com.google.android.keep.util.j.k(localFragmentActivity, o.O(localFragmentActivity).getName()).addConnectionCallbacks(localc).addOnConnectionFailedListener(localc).build();
    com.google.android.keep.util.j.d(gh);
    sr = new h(this, localFragmentActivity, gh);
    ss = new LocationAliasManager(localFragmentActivity, getLoaderManager(), gh);
    ss.a(this);
    if (!fT())
      ss.fQ();
    super.onActivityCreated(paramBundle);
  }

  public void onDestroy()
  {
    super.onDestroy();
    com.google.android.keep.util.j.e(gh);
  }
}