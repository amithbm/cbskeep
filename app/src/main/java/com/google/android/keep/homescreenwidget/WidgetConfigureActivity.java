package com.google.android.keep.homescreenwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.activities.BrowseActivity;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.b;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.j;
import com.google.android.keep.provider.i.k;
import com.google.android.keep.util.A;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.h;
import com.google.android.keep.util.h.a;
import com.google.android.keep.util.o;
import java.util.List;

public class WidgetConfigureActivity extends b
  implements View.OnClickListener
{
  private boolean rA;
  private List<j> rB;
  private boolean rC;
  private int rv;

  private void a(int paramInt, String paramString)
  {
    A.b(this, rv, paramInt);
    A.a(this, rv, paramString);
    fF();
  }

  private static void a(View paramView, int paramInt, String paramString)
  {
    ((ImageView)paramView.findViewById(2131492985)).setImageResource(paramInt);
    ((TextView)paramView.findViewById(2131493145)).setText(paramString);
  }

  private void aI(int paramInt)
  {
    A.b(this, rv, paramInt);
    fF();
  }

  private static void b(View paramView, int paramInt1, int paramInt2)
  {
    ((ImageView)paramView.findViewById(2131492985)).setImageResource(paramInt1);
    ((TextView)paramView.findViewById(2131493145)).setText(paramInt2);
  }

  private void b(j paramj)
  {
    rC = true;
    ((Toolbar)findViewById(2131493059)).setTitle(2131231256);
    paramj = h.a(getContentResolver(), i.k.CONTENT_URI, Label.COLUMNS, "account_id=" + paramj.getId(), null, "name", new h.a()
    {
      public Label c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        return Label.m(paramAnonymousCursor);
      }
    });
    ListView localListView = (ListView)findViewById(2131493150);
    localListView.setAdapter(null);
    localListView.addHeaderView(fH());
    localListView.addHeaderView(fI());
    localListView.setAdapter(new a(this, paramj));
  }

  private void fF()
  {
    Intent localIntent = new Intent("com.google.android.keep.intent.action.WIDGET_CONFIGURED");
    localIntent.putExtra("appWidgetId", rv);
    sendBroadcast(localIntent);
    localIntent = new Intent();
    localIntent.putExtra("appWidgetId", rv);
    setResult(-1, localIntent);
    if (rA);
    for (int i = 2131231013; ; i = 2131231012)
    {
      a(2131230867, 2131230923, i, null);
      finish();
      return;
    }
  }

  private void fG()
  {
    rC = false;
    ((Toolbar)findViewById(2131493059)).setTitle(getString(2131231255));
    findViewById(2131493233).setOnClickListener(this);
    ((ListView)findViewById(2131493150)).setAdapter(new b(this, rB));
  }

  private View fH()
  {
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130968657, null);
    b(localView, 2130837684, 2131231257);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        WidgetConfigureActivity.a(WidgetConfigureActivity.this, 1);
      }
    });
    return localView;
  }

  private View fI()
  {
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130968657, null);
    b(localView, 2130837690, 2131231130);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        WidgetConfigureActivity.a(WidgetConfigureActivity.this, 2);
      }
    });
    return localView;
  }

  protected String S()
  {
    return getString(2131230843);
  }

  protected void a(j paramj)
  {
    if (paramj != null)
      A.a(this, rv, paramj);
    AppWidgetProviderInfo localAppWidgetProviderInfo = AppWidgetManager.getInstance(this).getAppWidgetInfo(rv);
    if ((((Boolean)Config.Pt.get()).booleanValue()) && ((localAppWidgetProviderInfo.resizeMode & 0x2) > 0))
    {
      b(paramj);
      return;
    }
    fF();
  }

  public void onClick(View paramView)
  {
    int i;
    if (paramView.getId() == 2131493233)
    {
      if (!rC)
        break label44;
      i = 2131230925;
      if (!rA)
        break label51;
    }
    label44: label51: for (int j = 2131231013; ; j = 2131231012)
    {
      a(2131230867, i, j, null);
      finish();
      return;
      i = 2131230924;
      break;
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setResult(0);
    if ((getIntent() == null) || (getIntent().getExtras() == null))
    {
      finish();
      return;
    }
    paramBundle = AppWidgetManager.getInstance(this);
    rv = getIntent().getExtras().getInt("appWidgetId", 0);
    rA = KeepApplication.a(paramBundle, rv);
    setContentView(2130968771);
  }

  protected void onStart()
  {
    super.onStart();
    rB = o.R(this);
    if ((rB == null) || (rB.size() == 0))
    {
      fF();
      startActivity(new Intent(this, BrowseActivity.class));
      return;
    }
    if (rB.size() == 1)
    {
      a((j)rB.get(0));
      return;
    }
    fG();
  }

  private class a extends ArrayAdapter<Label>
  {
    a(List<Label> arg2)
    {
      super(2130968657, 2131493145, localList);
    }

    public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      paramViewGroup = (Label)getItem(paramInt);
      WidgetConfigureActivity.b(paramView, 2130837730, paramViewGroup.getName());
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          WidgetConfigureActivity.a(WidgetConfigureActivity.this, 3, paramViewGroup.gu());
        }
      });
      return paramView;
    }
  }

  private class b extends ArrayAdapter<j>
  {
    b(List<j> arg2)
    {
      super(2130968770, 2131493145, localList);
    }

    public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      paramViewGroup = (j)getItem(paramInt);
      ((TextView)paramView.findViewById(2131493145)).setText(paramViewGroup.getName());
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a(paramViewGroup);
        }
      });
      return paramView;
    }
  }
}