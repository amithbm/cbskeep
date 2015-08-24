package com.google.android.keep.navigation;

import android.content.ContentUris;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.keep.g;
import com.google.android.keep.model.BaseReminder;
import com.google.android.keep.model.ColorMap;
import com.google.android.keep.model.ColorMap.ColorPair;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.TreeEntitySettings;
import com.google.android.keep.provider.i.v;
import com.google.api.client.util.Lists;
import java.util.ArrayList;

public class EditorNavigationRequest extends NavigationRequest
{
  public static Parcelable.Creator<EditorNavigationRequest> CREATOR = new Parcelable.Creator()
  {
    public EditorNavigationRequest[] bs(int paramAnonymousInt)
    {
      return new EditorNavigationRequest[paramAnonymousInt];
    }

    public EditorNavigationRequest t(Parcel paramAnonymousParcel)
    {
      return new EditorNavigationRequest(paramAnonymousParcel, null);
    }
  };
  private String AA;
  private int AB;
  private final BaseReminder AC;
  private final g AD;
  private final boolean AE;
  private ArrayList<Uri> AF;
  private Uri AG;
  private Uri AH;
  private final String dz;
  private final String ja;
  private final String mAccountName;
  private Bitmap mBitmap;
  private final String rt;
  private String sv;
  private long uy;
  private final boolean xN;
  private final TreeEntity.TreeEntityType yn = TreeEntity.TreeEntityType.values()[paramParcel.readInt()];
  private final ColorMap.ColorPair yo;
  private final TreeEntitySettings yp;

  private EditorNavigationRequest(Parcel paramParcel)
  {
    super(NavigationManager.NavigationMode.values()[paramParcel.readInt()]);
    AB = paramParcel.readInt();
    uy = paramParcel.readLong();
    AA = paramParcel.readString();
    yo = ((ColorMap.ColorPair)paramParcel.readParcelable(ColorMap.ColorPair.class.getClassLoader()));
    AC = ((BaseReminder)paramParcel.readParcelable(BaseReminder.class.getClassLoader()));
    yp = ((TreeEntitySettings)paramParcel.readParcelable(TreeEntitySettings.class.getClassLoader()));
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      xN = bool1;
      AD = null;
      dz = paramParcel.readString();
      mAccountName = paramParcel.readString();
      if (paramParcel.readByte() != 1)
        break label223;
    }
    label223: for (boolean bool1 = bool2; ; bool1 = false)
    {
      AE = bool1;
      rt = paramParcel.readString();
      AF = paramParcel.readArrayList(Uri.class.getClassLoader());
      AG = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      AH = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      ja = paramParcel.readString();
      sv = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }

  private EditorNavigationRequest(a parama)
  {
  }

  public void I(long paramLong)
  {
    uy = paramLong;
    k(NavigationManager.NavigationMode.AS);
  }

  public void as(String paramString)
  {
    AA = paramString;
  }

  public long dP()
  {
    return uy;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean eY()
  {
    return AE;
  }

  public void g(Uri paramUri)
  {
    AH = paramUri;
  }

  public Bitmap getBitmap()
  {
    return mBitmap;
  }

  public Intent getIntent()
  {
    Intent localIntent = new Intent();
    if (NavigationManager.NavigationMode.AS == AW)
    {
      localIntent.setData(ContentUris.withAppendedId(i.v.CONTENT_URI, uy));
      localIntent.putExtra("com.google.android.keep.intent.extra.TREE_ENTITY_SETTINGS", yp);
      localIntent.putExtra("com.google.android.keep.intent.extra.HAS_CONFLICT", xN);
    }
    while (true)
    {
      if ((AD != null) && (AB == 0))
        AD.d(localIntent);
      localIntent.putExtra("color", yo);
      localIntent.putExtra("com.google.android.keep.intent.action.PROPOSED_EMAIL_TO_ADD", dz);
      return localIntent;
      if (NavigationManager.NavigationMode.AT != AW)
        break;
      localIntent.setType("text/plain");
      localIntent.putExtra("launchImmediately", AB);
      if (!TextUtils.isEmpty(mAccountName))
        localIntent.putExtra("authAccount", mAccountName);
      localIntent.putExtra("treeEntityType", TreeEntity.TreeEntityType.e(yn));
      localIntent.putExtra("reminder", AC);
      localIntent.putExtra("com.google.android.keep.intent.action.PROPOSED_EMAIL_TO_ADD", dz);
    }
    throw new IllegalStateException("Invalid navigation mode for editor: " + AW);
  }

  public String getText()
  {
    return sv;
  }

  public String getTitle()
  {
    return ja;
  }

  public void h(Uri paramUri)
  {
    AF.add(paramUri);
  }

  public void i(Uri paramUri)
  {
    AG = paramUri;
  }

  public TreeEntitySettings iA()
  {
    return yp;
  }

  public String iN()
  {
    return rt;
  }

  public boolean in()
  {
    return xN;
  }

  public ColorMap.ColorPair iz()
  {
    return yo;
  }

  public boolean jJ()
  {
    return AW == NavigationManager.NavigationMode.AT;
  }

  public g jK()
  {
    return AD;
  }

  public String jL()
  {
    return AA;
  }

  public TreeEntity.TreeEntityType jM()
  {
    return yn;
  }

  public BaseReminder jN()
  {
    return AC;
  }

  public int jO()
  {
    return AB;
  }

  public ArrayList<Uri> jP()
  {
    return AF;
  }

  public Uri jQ()
  {
    return AG;
  }

  public Uri jR()
  {
    return AH;
  }

  public String jS()
  {
    return dz;
  }

  public void jT()
  {
    AB = 0;
  }

  public void setText(String paramString)
  {
    sv = paramString;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("EditorNavigationRequest { type: ").append(yn).append(", ").append("mode: ").append(ka()).append(", ").append("treeEntityId: ").append(uy).append(", ").append("treeEntityUuid: ").append(AA).append(", ").append("launchMode: ").append(AB).append(", ").append("settings: ").append(yp).append(", ").append("hasConflict: ").append(xN).append(", ").append("color: ").append(yo.getKey()).append("proposedEmailToAdd: ");
    if (dz == null);
    for (String str = "null"; ; str = dz)
      return str + "accountName: " + mAccountName + "isNewNote: " + AE + "labelUuid: " + rt + "audioBlobUri: " + AG + "photoUri: " + AH + "title: " + ja + "text: " + sv + " }";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(ka().ordinal());
    paramParcel.writeInt(yn.ordinal());
    paramParcel.writeInt(AB);
    paramParcel.writeLong(uy);
    paramParcel.writeString(AA);
    paramParcel.writeParcelable(yo, 0);
    paramParcel.writeParcelable(AC, paramInt);
    paramParcel.writeParcelable(yp, paramInt);
    if (xN)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(dz);
      paramParcel.writeString(mAccountName);
      if (!AE)
        break label177;
    }
    label177: for (paramInt = i; ; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(rt);
      paramParcel.writeList(AF);
      paramParcel.writeParcelable(AG, 0);
      paramParcel.writeParcelable(AH, 0);
      paramParcel.writeString(ja);
      paramParcel.writeString(sv);
      return;
      paramInt = 0;
      break;
    }
  }

  public static class a
  {
    private int AB = 0;
    private g AD;
    private boolean AE = false;
    private ArrayList<Uri> AF = Lists.newArrayList();
    private Uri AG = null;
    private Uri AH = null;
    private BaseReminder AI;
    private String dz;
    private String ja;
    private String mAccountName;
    private Bitmap mBitmap = null;
    private String rt;
    private String sv;
    private boolean xN = false;
    private Long yj;
    private TreeEntity.TreeEntityType yn = TreeEntity.TreeEntityType.zO;
    private ColorMap.ColorPair yo = ColorMap.gO();
    private TreeEntitySettings yp;

    public a a(g paramg)
    {
      AD = paramg;
      return this;
    }

    public a ag(boolean paramBoolean)
    {
      xN = paramBoolean;
      return this;
    }

    public a ah(boolean paramBoolean)
    {
      AE = paramBoolean;
      return this;
    }

    public a at(String paramString)
    {
      dz = paramString;
      return this;
    }

    public a au(String paramString)
    {
      rt = paramString;
      return this;
    }

    public a av(String paramString)
    {
      ja = paramString;
      return this;
    }

    public a aw(String paramString)
    {
      sv = paramString;
      return this;
    }

    public a b(BaseReminder paramBaseReminder)
    {
      AI = paramBaseReminder;
      return this;
    }

    public a bt(int paramInt)
    {
      AB = paramInt;
      return this;
    }

    public a c(ColorMap.ColorPair paramColorPair)
    {
      yo = paramColorPair;
      return this;
    }

    public a d(Bitmap paramBitmap)
    {
      mBitmap = paramBitmap;
      return this;
    }

    public a e(TreeEntitySettings paramTreeEntitySettings)
    {
      yp = paramTreeEntitySettings;
      return this;
    }

    public a g(Long paramLong)
    {
      yj = paramLong;
      return this;
    }

    public a h(TreeEntity.TreeEntityType paramTreeEntityType)
    {
      yn = paramTreeEntityType;
      return this;
    }

    public a j(Uri paramUri)
    {
      if (paramUri != null)
        AF.add(paramUri);
      return this;
    }

    public EditorNavigationRequest jU()
    {
      return new EditorNavigationRequest(this, null);
    }

    public a k(Uri paramUri)
    {
      AG = paramUri;
      return this;
    }
  }
}