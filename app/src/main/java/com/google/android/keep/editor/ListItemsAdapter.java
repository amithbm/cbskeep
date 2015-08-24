package com.google.android.keep.editor;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.model.ColorMap.ColorPair;
import com.google.android.keep.model.ListItem;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.ModelEventDispatcher.b;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.TreeEntityModel;
import com.google.android.keep.model.TreeEntitySettings;
import com.google.android.keep.model.n;
import com.google.android.keep.model.o;
import com.google.android.keep.model.s;
import com.google.android.keep.p;
import com.google.android.keep.toasts.ToastListener;
import com.google.android.keep.toasts.ToastListener.c;
import com.google.android.keep.toasts.ToastsFragment;
import com.google.android.keep.ui.EditorRecyclerView;
import com.google.android.keep.ui.EditorRecyclerView.b;
import com.google.android.keep.ui.GraveyardHeaderView;
import com.google.android.keep.ui.GraveyardHeaderView.a;
import com.google.android.keep.ui.ListItemEditText;
import com.google.android.keep.ui.ListItemEditText.a;
import com.google.android.keep.ui.d;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.D;
import com.google.android.keep.util.c;
import com.google.android.keep.util.e;
import com.google.api.client.util.Lists;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public class ListItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements ModelEventDispatcher.b, EditorRecyclerView.b
{
  private final o fg;
  private final s hb;
  private final TreeEntityModel kJ;
  private final n la;
  private ListItemFocusState mA = new ListItemFocusState();
  private FragmentActivity mActivity;
  private ArrayList<Object> mB = Lists.newArrayList();
  private a mC = new a(null);
  private f mD = new f(null);
  private boolean mE;
  private boolean mF;
  private View.OnClickListener mG = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (ListItemsAdapter.a(ListItemsAdapter.this).ir() == TreeEntity.TreeEntityType.zO)
        return;
      ListItemsAdapter.a(ListItemsAdapter.this, true);
      paramAnonymousView = new ListItem(ListItemsAdapter.a(ListItemsAdapter.this).dP());
      ListItemsAdapter.a(ListItemsAdapter.this, paramAnonymousView.gu(), 0, 0, true);
      int i = ListItemsAdapter.c(ListItemsAdapter.this).indexOf(ListItemsAdapter.b(ListItemsAdapter.this));
      if (i == 0)
        ListItemsAdapter.d(ListItemsAdapter.this).a(paramAnonymousView, null, ar(1));
      while (true)
      {
        ListItemsAdapter.e(ListItemsAdapter.this).n(2131230876, 2131231015);
        return;
        ListItemsAdapter.d(ListItemsAdapter.this).a(paramAnonymousView, ar(i - 1), null);
      }
    }
  };
  private ItemTouchHelper mH;
  private final Handler mHandler = new Handler();
  private ListItem mI;
  private final LayoutInflater mInflater;
  private View mJ;
  private ViewGroup mParent;
  private g mz;

  public ListItemsAdapter(FragmentActivity paramFragmentActivity, p paramp)
  {
    mActivity = paramFragmentActivity;
    fg = new o(paramFragmentActivity, this, paramp);
    mInflater = LayoutInflater.from(paramFragmentActivity);
    kJ = ((TreeEntityModel)fg.e(TreeEntityModel.class));
    la = ((n)fg.e(n.class));
    hb = ((s)Binder.a(mActivity, s.class));
  }

  private void C(boolean paramBoolean)
  {
    mA.clear();
    if (mParent == null);
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = mParent.getFocusedChild();
      }
      while ((localObject == null) || (((View)localObject).getId() != 2131493178));
      localObject = (ListItemEditText)((View)localObject).findViewById(2131493075);
    }
    while (!(((ListItemEditText)localObject).getTag() instanceof String));
    a((String)((ListItemEditText)localObject).getTag(), ((ListItemEditText)localObject).getSelectionStart(), ((ListItemEditText)localObject).getSelectionEnd(), paramBoolean);
  }

  private GraveyardHeaderView a(ViewGroup paramViewGroup)
  {
    paramViewGroup = (GraveyardHeaderView)mInflater.inflate(2130968673, paramViewGroup, false);
    paramViewGroup.a(new GraveyardHeaderView.a()
    {
      private void D(boolean paramAnonymousBoolean)
      {
        TreeEntitySettings localTreeEntitySettings = ListItemsAdapter.a(ListItemsAdapter.this).iA();
        boolean bool1 = localTreeEntitySettings.ei();
        boolean bool2 = localTreeEntitySettings.ej();
        ListItemsAdapter.a(ListItemsAdapter.this).a(new TreeEntitySettings(bool1, paramAnonymousBoolean, bool2));
      }

      public void a(GraveyardHeaderView paramAnonymousGraveyardHeaderView)
      {
        D(true);
      }

      public void b(GraveyardHeaderView paramAnonymousGraveyardHeaderView)
      {
        D(false);
      }
    });
    return paramViewGroup;
  }

  private void a(ListItem paramListItem, String paramString)
  {
    paramListItem.Y(paramString);
  }

  private void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    mA.clear();
    mA.p(paramString).ai(paramInt1).aj(paramInt2).w(paramBoolean);
  }

  private boolean a(ListItem paramListItem)
  {
    return (!ei()) && (paramListItem.isChecked());
  }

  private ListItem aq(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= mB.size()))
      return null;
    Object localObject = mB.get(paramInt);
    if ((localObject instanceof ListItem))
      return (ListItem)localObject;
    return null;
  }

  private boolean b(ListItem paramListItem)
  {
    boolean bool = true;
    if (ej())
      return la.hA().gT() == paramListItem;
    ListItem localListItem;
    if (ei())
    {
      localListItem = (ListItem)la.gF();
      if (localListItem != paramListItem)
        break label66;
    }
    while (true)
    {
      return bool;
      localListItem = la.hA().gU();
      break;
      label66: bool = false;
    }
  }

  private void clearFocus()
  {
    if (mParent.hasFocus())
      e.B(mParent);
    mA.clear();
  }

  private void eg()
  {
    if (!kJ.iP())
    {
      if (!mB.isEmpty())
      {
        mB.clear();
        notifyDataSetChanged();
      }
      return;
    }
    mB.clear();
    TreeEntitySettings localTreeEntitySettings = kJ.iA();
    int i;
    int j;
    if ((ef()) && (localTreeEntitySettings.ej()) && (!mE))
    {
      i = 1;
      if ((!ef()) || (localTreeEntitySettings.ej()) || (mE))
        break label183;
      j = 1;
      label93: if (i != 0)
        mB.add(mC);
      if ((!localTreeEntitySettings.ei()) && (la.hB().size() != 0))
        break label188;
      mB.addAll(la.hC());
      if (j != 0)
        mB.add(mC);
    }
    while (true)
    {
      c.a("ListItemsAdapter", "Finished Extracting Contents", mB);
      notifyDataSetChanged();
      return;
      i = 0;
      break;
      label183: j = 0;
      break label93;
      label188: if (localTreeEntitySettings.jz())
      {
        mB.addAll(la.hA());
        if (j != 0)
          mB.add(mC);
        mB.add(mD.E(false));
      }
      else
      {
        mB.addAll(la.hA());
        if (j != 0)
          mB.add(mC);
        mB.add(mD.E(true));
        mB.addAll(la.hB());
      }
    }
  }

  private boolean eh()
  {
    TreeEntitySettings localTreeEntitySettings = kJ.iA();
    return (!localTreeEntitySettings.jz()) && (!localTreeEntitySettings.ei());
  }

  private boolean ej()
  {
    return kJ.iA().ej();
  }

  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (!(paramViewHolder instanceof h))
      return;
    mI = ((h)paramViewHolder).dX();
    mJ = paramViewHolder.itemView;
    mJ.setBackgroundColor(kJ.iz().getValue());
  }

  protected void a(ItemTouchHelper paramItemTouchHelper)
  {
    mH = paramItemTouchHelper;
  }

  public void a(g paramg)
  {
    mz = paramg;
  }

  public void a(ModelEventDispatcher.a parama)
  {
    Object localObject2 = null;
    if (!fg.ih());
    do
    {
      do
      {
        return;
        if ((mParent instanceof RecyclerView))
        {
          RecyclerView localRecyclerView = (RecyclerView)mParent;
          if (!parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wO }))
            break;
          localObject1 = new DefaultItemAnimator();
          localRecyclerView.setItemAnimator((RecyclerView.ItemAnimator)localObject1);
        }
      }
      while ((parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wN })) && (!la.gC()));
      if (!parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wK }))
        mE = false;
      eg();
    }
    while ((!parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wK })) || (la.gC()) || (mz == null));
    Object localObject1 = mz;
    if (mParent == null);
    for (parama = localObject2; ; parama = mParent.getFocusedChild())
    {
      ((g)localObject1).n(parama);
      return;
      localObject1 = null;
      break;
    }
  }

  public boolean an(int paramInt)
  {
    int j = mB.indexOf(mC);
    if ((j != -1) && (ej()));
    for (int i = 1; paramInt < i; i = 0)
      return false;
    if ((j != -1) && (!ej()))
    {
      i = j - 1;
      label54: if (paramInt <= i)
        return true;
    }
    else
    {
      i = mB.indexOf(mD);
      if (i == -1)
        break label85;
      i -= 1;
    }
    while (true)
    {
      break label54;
      break;
      label85: i = mB.size() - 1;
    }
  }

  public ListItem ar(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < mB.size()) && ((mB.get(paramInt) instanceof ListItem)))
      return (ListItem)mB.get(paramInt);
    return null;
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return ImmutableList.of(ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wL, ModelEventDispatcher.EventType.wK, ModelEventDispatcher.EventType.wM, ModelEventDispatcher.EventType.wN, ModelEventDispatcher.EventType.wO, ModelEventDispatcher.EventType.wP, ModelEventDispatcher.EventType.wQ, ModelEventDispatcher.EventType.xh, ModelEventDispatcher.EventType.xi, ModelEventDispatcher.EventType.xn, ModelEventDispatcher.EventType.wG, new ModelEventDispatcher.EventType[0]);
  }

  public void c(ListItem paramListItem)
  {
    if (paramListItem == null)
      return;
    a(paramListItem.gu(), 0, 0, true);
  }

  public void dS()
  {
    if (mI != null)
    {
      int i = mB.indexOf(mI);
      final ListItem localListItem1 = mI;
      final ListItem localListItem2 = ar(i - 1);
      final ListItem localListItem3 = ar(i + 1);
      mHandler.post(new Runnable()
      {
        public void run()
        {
          ListItemsAdapter.d(ListItemsAdapter.this).b(localListItem1, localListItem2, localListItem3);
        }
      });
      mI = null;
    }
    if (mJ != null)
    {
      mJ.setBackgroundColor(0);
      mJ = null;
    }
  }

  public boolean ef()
  {
    return (!kJ.jx()) && (la.size() + 1 < Config.nC());
  }

  public boolean ei()
  {
    return kJ.iA().ei();
  }

  protected void ek()
  {
    if ((mParent == null) || (!(mParent instanceof EditorRecyclerView)));
    while (true)
    {
      return;
      EditorRecyclerView localEditorRecyclerView = (EditorRecyclerView)mParent;
      int i = 0;
      while (i < localEditorRecyclerView.getChildCount())
      {
        Object localObject = localEditorRecyclerView.getChildViewHolder(localEditorRecyclerView.getChildAt(i));
        if ((localObject instanceof h))
        {
          localObject = (h)localObject;
          if (TextUtils.equals(((h)localObject).mt.gu(), mA.mT))
          {
            ((h)localObject).a(mA.selectionStart, mA.selectionEnd, mA.kY);
            mA.clear();
            return;
          }
        }
        i += 1;
      }
    }
  }

  public int getItemCount()
  {
    return mB.size();
  }

  public long getItemId(int paramInt)
  {
    int i = getItemViewType(paramInt);
    switch (i)
    {
    default:
      throw new IllegalStateException("Unknown view type: " + i);
    case 0:
    case 3:
      return ((ListItem)mB.get(paramInt)).gu().hashCode();
    case 1:
      return -101L;
    case 2:
    }
    return -100L;
  }

  public int getItemViewType(int paramInt)
  {
    Object localObject = mB.get(paramInt);
    if ((localObject instanceof f))
      return 1;
    if ((localObject instanceof a))
      return 2;
    if ((localObject instanceof ListItem))
    {
      TreeEntitySettings localTreeEntitySettings = kJ.iA();
      localObject = (ListItem)localObject;
      if ((localTreeEntitySettings.ei()) || (!((ListItem)localObject).isChecked()))
        return 0;
      return 3;
    }
    throw new IllegalStateException("Unknown item type at position: " + paramInt);
  }

  protected void h(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getParcelable("ListItemsAdapter_key_focus_state") != null))
      mA = ((ListItemFocusState)paramBundle.getParcelable("ListItemsAdapter_key_focus_state"));
  }

  public void l(int paramInt1, int paramInt2)
  {
    if (c.a(mB, mB.get(paramInt1), paramInt2))
      notifyItemMoved(paramInt1, paramInt2);
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    boolean bool = true;
    D.bO("ListItemsAdapter_onBindViewHolder");
    int i = getItemViewType(paramInt);
    if (i == 1)
    {
      paramViewHolder = (GraveyardHeaderView)((e)paramViewHolder).itemView;
      paramViewHolder.setExpanded(mD.el());
      paramViewHolder.B(kJ.jx());
    }
    while (true)
    {
      D.ot();
      return;
      if ((i == 0) || (i == 3))
      {
        ListItem localListItem = (ListItem)mB.get(paramInt);
        h localh = (h)paramViewHolder;
        if (i == 0)
        {
          label89: localh.ec();
          localh.a(localListItem, paramInt, bool);
          if ((!mF) || (localListItem.hq() == null))
            break label237;
          bool = localListItem.ht();
          label126: localh.setChecked(bool);
          if ((!mF) || (localListItem.hq() == null))
            break label247;
        }
        label237: label247: for (paramViewHolder = localListItem.hs(); ; paramViewHolder = localListItem.getText())
        {
          localh.setText(paramViewHolder);
          localh.B(kJ.jx());
          localh.eb();
          if (!TextUtils.equals(localListItem.gu(), mA.mT))
            break;
          localh.b(mA.selectionStart, mA.selectionEnd, mA.kY);
          mA.clear();
          break;
          bool = false;
          break label89;
          bool = localListItem.isChecked();
          break label126;
        }
      }
      if (i == 2)
        ((b)paramViewHolder).B(kJ.jx());
    }
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    D.bO("ListItemsAdapter_onCreateViewHolder");
    mParent = paramViewGroup;
    switch (paramInt)
    {
    default:
      throw new IllegalStateException("Unknown view type: " + paramInt);
    case 0:
    case 3:
      paramViewGroup = new h(mInflater.inflate(2130968676, paramViewGroup, false));
      paramViewGroup.a(new h(paramViewGroup));
      paramViewGroup.dY().setFilters(new InputFilter[] { new d(mActivity) });
      paramViewGroup.a(new j(paramViewGroup));
      paramViewGroup.a(new c(paramViewGroup));
      paramViewGroup.a(new d(paramViewGroup));
      paramViewGroup.a(new i(paramViewGroup));
    case 1:
    case 2:
    }
    while (true)
    {
      D.ot();
      return paramViewGroup;
      paramViewGroup = new e(a(paramViewGroup));
      continue;
      paramViewGroup = new b(mInflater.inflate(2130968665, paramViewGroup, false), mG);
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    C(true);
    if (mA.isValid())
      paramBundle.putParcelable("ListItemsAdapter_key_focus_state", mA);
  }

  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof h))
    {
      h localh = (h)paramViewHolder;
      localh.ea();
      localh.ec();
    }
    super.onViewRecycled(paramViewHolder);
  }

  public void x(boolean paramBoolean)
  {
    mF = paramBoolean;
  }

  public static class ListItemFocusState extends EditTextFocusState
  {
    public static final Parcelable.Creator<EditTextFocusState> CREATOR = new Parcelable.Creator()
    {
      public ListItemsAdapter.ListItemFocusState[] as(int paramAnonymousInt)
      {
        return new ListItemsAdapter.ListItemFocusState[paramAnonymousInt];
      }

      public ListItemsAdapter.ListItemFocusState c(Parcel paramAnonymousParcel)
      {
        return new ListItemsAdapter.ListItemFocusState(paramAnonymousParcel, null);
      }
    };
    String mT;

    public ListItemFocusState()
    {
    }

    private ListItemFocusState(Parcel paramParcel)
    {
      super();
      mT = paramParcel.readString();
    }

    public void clear()
    {
      mT = null;
      super.clear();
    }

    ListItemFocusState p(String paramString)
    {
      mT = paramString;
      return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(mT);
    }
  }

  private static class a
  {
    public String toString()
    {
      return "AddItemData";
    }
  }

  public static class b extends RecyclerView.ViewHolder
  {
    public b(View paramView, View.OnClickListener paramOnClickListener)
    {
      super();
      paramView.setOnClickListener(paramOnClickListener);
    }

    public void B(boolean paramBoolean)
    {
      View localView = itemView;
      if (!paramBoolean);
      for (paramBoolean = true; ; paramBoolean = false)
      {
        localView.setEnabled(paramBoolean);
        return;
      }
    }
  }

  private class c
    implements CompoundButton.OnCheckedChangeListener
  {
    h mO;

    public c(h arg2)
    {
      Object localObject;
      mO = localObject;
    }

    public void onCheckedChanged(CompoundButton paramCompoundButton, final boolean paramBoolean)
    {
      final ListItem localListItem = mO.mt;
      if (TextUtils.equals(localListItem.gu(), (String)paramCompoundButton.getTag()))
      {
        paramCompoundButton = mO.dY();
        if ((!ListItemsAdapter.g(ListItemsAdapter.this)) || (!paramCompoundButton.hasFocus()))
          break label87;
        ListItemsAdapter.h(ListItemsAdapter.this);
      }
      while (true)
      {
        paramCompoundButton.setChecked(paramBoolean);
        ListItemsAdapter.i(ListItemsAdapter.this).postDelayed(new Runnable()
        {
          public void run()
          {
            localListItem.R(paramBoolean);
          }
        }
        , 100L);
        return;
        label87: ListItemsAdapter.b(ListItemsAdapter.this, true);
      }
    }
  }

  private class d
    implements View.OnClickListener
  {
    h mO;

    public d(h arg2)
    {
      Object localObject;
      mO = localObject;
    }

    public void onClick(View paramView)
    {
      paramView = mO.dX();
      int i = mO.dZ();
      Object localObject = ListItemsAdapter.a(ListItemsAdapter.this, i + 1);
      if (localObject == null)
        if (i > 0)
        {
          localObject = ListItemsAdapter.c(ListItemsAdapter.this).get(i - 1);
          if ((localObject instanceof ListItem))
            ListItemsAdapter.a(ListItemsAdapter.this, ((ListItem)localObject).gu(), 0, 0, false);
        }
      while (true)
      {
        localObject = new ToastListener.c(ListItemsAdapter.f(ListItemsAdapter.this), paramView);
        ListItemsAdapter.d(ListItemsAdapter.this).m(paramView);
        ((ToastsFragment)e.a(ListItemsAdapter.f(ListItemsAdapter.this), 2131493048)).a((ToastListener)localObject);
        return;
        ListItemsAdapter.a(ListItemsAdapter.this, ((ListItem)localObject).gu(), 0, 0, false);
      }
    }
  }

  public static class e extends RecyclerView.ViewHolder
  {
    public e(View paramView)
    {
      super();
    }
  }

  private static class f
  {
    private boolean mS = true;

    public f E(boolean paramBoolean)
    {
      mS = paramBoolean;
      return this;
    }

    public boolean el()
    {
      return mS;
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("GraveyardHeader ");
      if (mS);
      for (String str = "v"; ; str = "^")
        return str;
    }
  }

  public static abstract interface g
  {
    public abstract void n(View paramView);
  }

  private class h
    implements TextWatcher
  {
    private h mU;

    public h(h arg2)
    {
      Object localObject;
      mU = localObject;
    }

    public void afterTextChanged(Editable paramEditable)
    {
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      ListItem localListItem = mU.dX();
      ListItemsAdapter.a(ListItemsAdapter.this, localListItem, mU.getText());
      if ((paramCharSequence.length() > 0) && (ListItemsAdapter.j(ListItemsAdapter.this)) && (ListItemsAdapter.b(ListItemsAdapter.this, localListItem)))
      {
        ListItemsAdapter.a(ListItemsAdapter.this, localListItem.gu(), paramCharSequence.length(), paramCharSequence.length(), false);
        ListItemsAdapter.a(ListItemsAdapter.this, false);
        if (ListItemsAdapter.k(ListItemsAdapter.this))
        {
          paramInt1 = 0;
          ListItemsAdapter.c(ListItemsAdapter.this).add(paramInt1, ListItemsAdapter.b(ListItemsAdapter.this));
          notifyDataSetChanged();
        }
      }
      else
      {
        return;
      }
      if (ei());
      for (paramInt1 = ListItemsAdapter.d(ListItemsAdapter.this).hC().size(); ; paramInt1 = ListItemsAdapter.d(ListItemsAdapter.this).hA().size())
        break;
    }
  }

  class i
    implements View.OnTouchListener
  {
    h mU;

    public i(h arg2)
    {
      Object localObject;
      mU = localObject;
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        ListItemsAdapter.h(ListItemsAdapter.this);
        if (ListItemsAdapter.l(ListItemsAdapter.this) != null)
          ListItemsAdapter.l(ListItemsAdapter.this).startDrag(mU);
        paramView.performHapticFeedback(0);
      }
      return false;
    }
  }

  private class j
    implements ListItemEditText.a
  {
    h mO;

    public j(h arg2)
    {
      Object localObject;
      mO = localObject;
    }

    public void b(String paramString, int paramInt)
    {
      if (!ef())
      {
        e.b(ListItemsAdapter.f(ListItemsAdapter.this), 2131231199);
        return;
      }
      String str = mO.getText();
      paramString = str.substring(0, paramInt);
      str = str.substring(paramInt);
      mO.setText(paramString);
      paramString = new ListItem(ListItemsAdapter.a(ListItemsAdapter.this).dP()).X(str).R(ListItemsAdapter.a(ListItemsAdapter.this, mO.mt));
      paramInt = mO.dZ();
      ListItemsAdapter.d(ListItemsAdapter.this).a(paramString, ar(paramInt), ar(paramInt + 1));
      ListItemsAdapter.a(ListItemsAdapter.this, paramString.gu(), 0, 0, true);
    }

    public void em()
    {
      int i = mO.dZ();
      ListItem localListItem1 = ListItemsAdapter.a(ListItemsAdapter.this, i - 1);
      if (localListItem1 == null)
      {
        if (mO.getText().isEmpty())
        {
          localListItem1 = ListItemsAdapter.a(ListItemsAdapter.this, mO.dZ() + 1);
          if (localListItem1 != null)
          {
            ListItemsAdapter.a(ListItemsAdapter.this, localListItem1.gu(), 0, 0, true);
            ListItemsAdapter.d(ListItemsAdapter.this).aK(0);
          }
        }
        return;
      }
      ListItem localListItem2 = mO.dX();
      String str1 = localListItem2.getText();
      String str2 = localListItem1.getText();
      i = str2.length();
      ListItemsAdapter.a(ListItemsAdapter.this, localListItem1.gu(), i, i, true);
      localListItem1.ic();
      localListItem1.X(str2 + str1);
      localListItem1.id();
      ListItemsAdapter.d(ListItemsAdapter.this).ic();
      ListItemsAdapter.d(ListItemsAdapter.this).m(localListItem2);
      ListItemsAdapter.d(ListItemsAdapter.this).id();
      ListItemsAdapter.d(ListItemsAdapter.this).b(ModelEventDispatcher.EventType.wP);
    }
  }
}