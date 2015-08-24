package com.google.android.keep.browse;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.people.accountswitcherview.OwnersAvatarManager;
import com.google.android.keep.util.o;
import com.google.android.keep.util.p;
import com.google.android.keep.util.r;
import com.google.api.client.repackaged.com.google.common.base.Preconditions;

public class m extends DialogFragment
  implements View.OnClickListener, GoogleApiClient.ConnectionCallbacks
{
  private GoogleApiClient gh;
  private Button he;
  private Button iB;
  private b iC;
  private Spinner iD;

  private void a(b paramb)
  {
    boolean bool2 = true;
    iC = paramb;
    Button localButton = iB;
    if (paramb == null)
    {
      bool1 = true;
      localButton.setEnabled(bool1);
      localButton = he;
      if (paramb != null)
        break label49;
    }
    label49: for (boolean bool1 = bool2; ; bool1 = false)
    {
      localButton.setEnabled(bool1);
      return;
      bool1 = false;
      break;
    }
  }

  public void onClick(View paramView)
  {
    if (paramView == iB)
    {
      a(new b());
      iC.execute(new Void[0]);
      return;
    }
    dismiss();
  }

  public void onConnected(Bundle paramBundle)
  {
    ((a)iD.getAdapter()).notifyDataSetChanged();
  }

  public void onConnectionSuspended(int paramInt)
  {
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(getArguments().getString("server_node_id")));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      paramBundle = LayoutInflater.from(getActivity()).inflate(2130968628, null);
      gh = com.google.android.keep.util.j.M(getActivity()).addConnectionCallbacks(this).build();
      iB = ((Button)paramBundle.findViewById(2131493108));
      iB.setOnClickListener(this);
      he = ((Button)paramBundle.findViewById(2131493107));
      he.setOnClickListener(this);
      iD = ((Spinner)paramBundle.findViewById(2131493106));
      com.google.android.keep.model.j localj = o.O(getActivity());
      a locala = new a(getActivity(), new OwnersAvatarManager(getActivity(), gh));
      ((TextView)paramBundle.findViewById(2131493104)).setText(getString(2131231324, new Object[] { localj.getName() }));
      iD.setAdapter(locala);
      int i = locala.getPosition(localj);
      iD.setSelection(i);
      return new AlertDialog.Builder(getActivity()).setView(paramBundle).setCancelable(false).create();
    }
  }

  public void onPause()
  {
    super.onPause();
    if (iC != null)
    {
      iC.cancel(true);
      dismiss();
    }
  }

  public void onStart()
  {
    super.onStart();
    com.google.android.keep.util.j.d(gh);
  }

  public void onStop()
  {
    com.google.android.keep.util.j.e(gh);
    super.onStart();
  }

  private static class a extends ArrayAdapter<com.google.android.keep.model.j>
  {
    OwnersAvatarManager gi;
    LayoutInflater mInflater;

    a(Context paramContext, OwnersAvatarManager paramOwnersAvatarManager)
    {
      super(0, o.R(paramContext));
      mInflater = LayoutInflater.from(paramContext);
      gi = paramOwnersAvatarManager;
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getView(paramInt, paramView, paramViewGroup);
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      com.google.android.keep.model.j localj = (com.google.android.keep.model.j)getItem(paramInt);
      View localView = paramView;
      if (paramView == null)
        localView = mInflater.inflate(2130968627, paramViewGroup, false);
      ((TextView)localView.findViewById(2131493103)).setText(localj.getName());
      paramView = (ImageView)localView.findViewById(2131493102);
      gi.loadOwnerAvatar(paramView, localj.getName(), 1);
      return localView;
    }
  }

  private class b extends AsyncTask<Void, Void, Void>
  {
    private final com.google.android.keep.model.j fr = (com.google.android.keep.model.j)m.a(m.this).getSelectedItem();
    private final p iE = new p(getActivity());
    private final String iF = getArguments().getString("server_node_id");
    private volatile Exception iG;

    b()
    {
    }

    protected void a(Void paramVoid)
    {
      super.onPostExecute(paramVoid);
      m.a(m.this, null);
      if (iG != null)
      {
        Toast.makeText(getActivity(), 2131231328, 0).show();
        return;
      }
      dismiss();
    }

    protected Void doInBackground(Void[] paramArrayOfVoid)
    {
      try
      {
        iE.a(fr, iF);
        return null;
      }
      catch (Exception paramArrayOfVoid)
      {
        while (true)
        {
          r.e("RequestAccessDialog", "Failed to request access. " + paramArrayOfVoid.getMessage(), new Object[0]);
          iG = paramArrayOfVoid;
        }
      }
    }
  }
}