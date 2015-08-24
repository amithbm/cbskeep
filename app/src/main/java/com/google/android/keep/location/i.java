package com.google.android.keep.location;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.keep.util.e;
import com.google.common.collect.Lists;
import java.util.List;

public abstract class i<T extends b> extends DialogFragment
  implements TextWatcher, j.a<T>
{
  private int sC;
  private i<T>.c sD;
  private EditText sE;
  private ListView sF;
  private TextView sG;

  private void a(BaseAdapter paramBaseAdapter)
  {
    sF.setAdapter(paramBaseAdapter);
    sF.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        ((i.a)getTargetFragment()).a(getActivity(), i.a(i.this).getItem(paramAnonymousInt));
        e.B(i.b(i.this));
        dismiss();
      }
    });
    paramBaseAdapter = sE.getText().toString();
    if (!TextUtils.isEmpty(paramBaseAdapter))
      fR().t(paramBaseAdapter);
  }

  private void a(String paramString, int paramInt1, int paramInt2)
  {
    sE.setText(paramString);
    sE.setSelection(paramInt1, paramInt2);
  }

  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("subtitle", paramString2);
    localBundle.putInt("layoutId", paramInt1);
    localBundle.putInt("listLayoutId", paramInt2);
    localBundle.putString("initialFilter", paramString3);
    setArguments(localBundle);
  }

  public void afterTextChanged(Editable paramEditable)
  {
    fR().t(paramEditable.toString());
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  protected abstract j<T> fR();

  protected boolean fT()
  {
    return !TextUtils.isEmpty(sE.getText().toString());
  }

  public void g(List<T> paramList)
  {
    sD.h(paramList);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a(sD);
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    ((a)getTargetFragment()).bp();
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    Object localObject2 = getArguments();
    int j;
    int i;
    Object localObject3;
    if (paramBundle != null)
    {
      Object localObject1 = paramBundle.getString("initialFilter");
      j = paramBundle.getInt("initialFilterSelStart");
      i = paramBundle.getInt("initialFilterSelEnd");
      paramBundle = (Bundle)localObject1;
      int k = ((Bundle)localObject2).getInt("layoutId");
      sC = ((Bundle)localObject2).getInt("listLayoutId");
      localObject3 = getActivity();
      sD = new c((Context)localObject3);
      localObject1 = (LayoutInflater)((Context)localObject3).getSystemService("layout_inflater");
      View localView = ((LayoutInflater)localObject1).inflate(k, null);
      sE = ((EditText)localView.findViewById(2131493260));
      a(paramBundle, j, i);
      sF = ((ListView)localView.findViewById(2131493150));
      sG = ((TextView)localView.findViewById(2131493263));
      sE.addTextChangedListener(this);
      paramBundle = new AlertDialog.Builder((Context)localObject3).setView(localView);
      i = ((Bundle)localObject2).getInt("titleId", 0);
      localObject3 = ((Bundle)localObject2).getString("title");
      localObject2 = ((Bundle)localObject2).getString("subtitle");
      if (TextUtils.isEmpty((CharSequence)localObject3))
        break label318;
      localObject1 = ((LayoutInflater)localObject1).inflate(2130968762, null);
      ((TextView)((View)localObject1).findViewById(2131492986)).setText((CharSequence)localObject3);
      localObject3 = (TextView)((View)localObject1).findViewById(2131493375);
      if (TextUtils.isEmpty((CharSequence)localObject2))
        break label308;
      ((TextView)localObject3).setText((CharSequence)localObject2);
      label256: paramBundle.setCustomTitle((View)localObject1);
    }
    while (true)
    {
      paramBundle = paramBundle.create();
      paramBundle.getWindow().setSoftInputMode(4);
      return paramBundle;
      paramBundle = ((Bundle)localObject2).getString("initialFilter");
      j = 0;
      if (TextUtils.isEmpty(paramBundle));
      for (i = 0; ; i = paramBundle.length())
        break;
      label308: ((TextView)localObject3).setVisibility(8);
      break label256;
      label318: if (i != 0)
        paramBundle.setTitle(i);
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    String str;
    int j;
    if (sE == null)
    {
      str = "";
      j = 0;
    }
    for (int i = 0; ; i = sE.getSelectionEnd())
    {
      paramBundle.putString("initialFilter", str);
      paramBundle.putInt("initialFilterSelStart", j);
      paramBundle.putInt("initialFilterSelEnd", i);
      return;
      str = sE.getText().toString();
      j = sE.getSelectionStart();
    }
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void setTargetFragment(Fragment paramFragment, int paramInt)
  {
    super.setTargetFragment(paramFragment, paramInt);
    if (!(paramFragment instanceof a))
      throw new IllegalArgumentException("Calling fragment must implement OnSuggestionSetListener");
  }

  public static abstract interface a<T>
  {
    public abstract void a(Context paramContext, T paramT);

    public abstract void bp();
  }

  public static abstract interface b
  {
    public abstract String getText();

    public abstract String getTitle();
  }

  private class c extends ArrayAdapter<T>
  {
    c(Context arg2)
    {
      super(i.c(i.this), 16908310, Lists.newArrayList());
    }

    private void J(boolean paramBoolean)
    {
      if ((paramBoolean) || (fT()))
      {
        i.d(i.this).setVisibility(8);
        return;
      }
      i.d(i.this).setVisibility(0);
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      Object localObject = (i.b)getItem(paramInt);
      TextView localTextView = (TextView)paramView.findViewById(16908310);
      paramViewGroup = (TextView)paramView.findViewById(16908308);
      localTextView.setText(((i.b)localObject).getTitle());
      localObject = ((i.b)localObject).getText();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramViewGroup.setVisibility(8);
        return paramView;
      }
      paramViewGroup.setText((CharSequence)localObject);
      paramViewGroup.setVisibility(0);
      return paramView;
    }

    public void h(List<T> paramList)
    {
      clear();
      addAll(paramList);
      if ((paramList != null) && (paramList.size() > 0));
      for (boolean bool = true; ; bool = false)
      {
        J(bool);
        return;
      }
    }
  }
}