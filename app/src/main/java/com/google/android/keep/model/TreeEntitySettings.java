package com.google.android.keep.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.api.services.notes.model.Node.NodeSettings;

public class TreeEntitySettings
  implements Parcelable
{
  public static final TreeEntitySettings Aj = new TreeEntitySettings(false, false, false);
  public static final Parcelable.Creator<TreeEntitySettings> CREATOR = new Parcelable.Creator()
  {
    public TreeEntitySettings[] bp(int paramAnonymousInt)
    {
      return new TreeEntitySettings[paramAnonymousInt];
    }

    public TreeEntitySettings q(Parcel paramAnonymousParcel)
    {
      return new TreeEntitySettings(paramAnonymousParcel, null);
    }
  };
  private boolean Ah;
  private boolean Ai;
  private boolean ne;

  private TreeEntitySettings(Parcel paramParcel)
  {
    boolean[] arrayOfBoolean = new boolean[3];
    paramParcel.readBooleanArray(arrayOfBoolean);
    Ah = arrayOfBoolean[0];
    ne = arrayOfBoolean[1];
    Ai = arrayOfBoolean[2];
  }

  public TreeEntitySettings(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Ah = paramBoolean1;
    ne = paramBoolean2;
    Ai = paramBoolean3;
  }

  public static TreeEntitySettings a(Node.NodeSettings paramNodeSettings)
  {
    if (paramNodeSettings == null)
      return Aj;
    String str = paramNodeSettings.getCheckedListItemsPolicy();
    boolean bool1;
    boolean bool2;
    if ("DEFAULT".equalsIgnoreCase(str))
    {
      bool1 = true;
      str = paramNodeSettings.getGraveyardState();
      if (!"COLLAPSED".equalsIgnoreCase(str))
        break label114;
      bool2 = true;
      label44: paramNodeSettings = paramNodeSettings.getNewListItemPlacement();
      if (!"TOP".equalsIgnoreCase(paramNodeSettings))
        break label157;
    }
    for (boolean bool3 = true; ; bool3 = false)
    {
      return new TreeEntitySettings(bool1, bool2, bool3);
      if ("GRAVEYARD".equalsIgnoreCase(str))
      {
        bool1 = false;
        break;
      }
      throw new IllegalStateException("Unknown checkedListItemsPolicy " + str);
      label114: if ("EXPANDED".equalsIgnoreCase(str))
      {
        bool2 = false;
        break label44;
      }
      throw new IllegalStateException("Unknown graveyardState " + str);
      label157: if (!"BOTTOM".equalsIgnoreCase(paramNodeSettings))
        break label171;
    }
    label171: throw new IllegalStateException("Unknown newListItemPlacement " + paramNodeSettings);
  }

  public ContentValues b(ContentValues paramContentValues)
  {
    if (Ah)
    {
      str = "1";
      paramContentValues.put("is_graveyard_off", str);
      if (!ne)
        break label59;
      str = "1";
      label27: paramContentValues.put("is_graveyard_closed", str);
      if (!Ai)
        break label65;
    }
    label59: label65: for (String str = "1"; ; str = "0")
    {
      paramContentValues.put("is_new_list_item_from_top", str);
      return paramContentValues;
      str = "0";
      break;
      str = "0";
      break label27;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean ei()
  {
    return Ah;
  }

  public boolean ej()
  {
    return Ai;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null);
    do
    {
      return false;
      if (paramObject == this)
        return true;
    }
    while (!(paramObject instanceof TreeEntitySettings));
    paramObject = (TreeEntitySettings)paramObject;
    if ((paramObject.ei() == Ah) && (paramObject.jz() == ne) && (paramObject.ej() == Ai));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public Node.NodeSettings jA()
  {
    String str1;
    String str2;
    if (Ah)
    {
      str1 = "DEFAULT";
      if (!ne)
        break label56;
      str2 = "COLLAPSED";
      label20: if (!Ai)
        break label62;
    }
    label56: label62: for (String str3 = "TOP"; ; str3 = "BOTTOM")
    {
      return new Node.NodeSettings().setCheckedListItemsPolicy(str1).setGraveyardState(str2).setNewListItemPlacement(str3);
      str1 = "GRAVEYARD";
      break;
      str2 = "EXPANDED";
      break label20;
    }
  }

  public ContentValues jh()
  {
    return b(new ContentValues());
  }

  public boolean jz()
  {
    return ne;
  }

  public String toString()
  {
    return String.format("TreeEntitySettings { isGraveyardOff: %s isGraveyardClosed: %s, isNewListItemFromTop: %s}", new Object[] { Boolean.valueOf(Ah), Boolean.valueOf(ne), Boolean.valueOf(Ai) });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBooleanArray(new boolean[] { Ah, ne, Ai });
  }
}