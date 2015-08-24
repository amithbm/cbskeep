package com.google.android.gms.people.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.ICancelToken.zza;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.people.identity.internal.AccountToken;
import com.google.android.gms.people.identity.internal.ParcelableGetOptions;
import com.google.android.gms.people.identity.internal.ParcelableListOptions;
import com.google.android.gms.people.identity.internal.zzh;
import com.google.android.gms.people.model.AvatarReference;
import com.google.android.gms.people.model.zzb;
import java.util.ArrayList;
import java.util.List;

public abstract interface zzg extends IInterface
{
  public abstract boolean isSyncToContactsEnabled()
    throws RemoteException;

  public abstract Bundle zzN(String paramString1, String paramString2)
    throws RemoteException;

  public abstract Bundle zzO(String paramString1, String paramString2)
    throws RemoteException;

  public abstract Bundle zza(zzf paramzzf, boolean paramBoolean, String paramString1, String paramString2, int paramInt)
    throws RemoteException;

  public abstract Bundle zza(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
    throws RemoteException;

  public abstract Bundle zza(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;

  public abstract ICancelToken zza(zzf paramzzf, DataHolder paramDataHolder, int paramInt1, int paramInt2, long paramLong)
    throws RemoteException;

  public abstract ICancelToken zza(zzf paramzzf, AccountToken paramAccountToken, ParcelableListOptions paramParcelableListOptions)
    throws RemoteException;

  public abstract ICancelToken zza(zzf paramzzf, AvatarReference paramAvatarReference, ParcelableLoadImageOptions paramParcelableLoadImageOptions)
    throws RemoteException;

  public abstract ICancelToken zza(zzf paramzzf, String paramString, int paramInt)
    throws RemoteException;

  public abstract ICancelToken zza(zzf paramzzf, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, long paramLong, boolean paramBoolean)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, Bundle paramBundle)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, AccountToken paramAccountToken, List<String> paramList, ParcelableGetOptions paramParcelableGetOptions)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString, int paramInt1, int paramInt2)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, int paramInt)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, Uri paramUri)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, Uri paramUri, boolean paramBoolean)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString4)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, String paramString4, boolean paramBoolean2)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, String paramString4, boolean paramBoolean2, int paramInt4, int paramInt5)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, String paramString4)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, List<String> paramList)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, List<String> paramList, int paramInt, boolean paramBoolean, long paramLong)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, List<String> paramList, int paramInt1, boolean paramBoolean, long paramLong, String paramString4, int paramInt2)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, List<String> paramList, int paramInt1, boolean paramBoolean, long paramLong, String paramString4, int paramInt2, int paramInt3)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, List<String> paramList, int paramInt1, boolean paramBoolean, long paramLong, String paramString4, int paramInt2, int paramInt3, int paramInt4)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, List<String> paramList1, List<String> paramList2)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, List<String> paramList1, List<String> paramList2, FavaDiagnosticsEntity paramFavaDiagnosticsEntity)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, String paramString, boolean paramBoolean, String[] paramArrayOfString)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    throws RemoteException;

  public abstract void zza(zzf paramzzf, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt)
    throws RemoteException;

  public abstract void zzag(boolean paramBoolean)
    throws RemoteException;

  public abstract Bundle zzb(String paramString1, String paramString2, long paramLong)
    throws RemoteException;

  public abstract ICancelToken zzb(zzf paramzzf, long paramLong, boolean paramBoolean)
    throws RemoteException;

  public abstract ICancelToken zzb(zzf paramzzf, String paramString)
    throws RemoteException;

  public abstract ICancelToken zzb(zzf paramzzf, String paramString, int paramInt1, int paramInt2)
    throws RemoteException;

  public abstract ICancelToken zzb(zzf paramzzf, String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws RemoteException;

  public abstract void zzb(zzf paramzzf, Bundle paramBundle)
    throws RemoteException;

  public abstract void zzb(zzf paramzzf, String paramString1, String paramString2)
    throws RemoteException;

  public abstract void zzb(zzf paramzzf, String paramString1, String paramString2, int paramInt)
    throws RemoteException;

  public abstract void zzb(zzf paramzzf, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
    throws RemoteException;

  public abstract void zzb(zzf paramzzf, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws RemoteException;

  public abstract ICancelToken zzc(zzf paramzzf, String paramString1, String paramString2, int paramInt)
    throws RemoteException;

  public abstract void zzc(zzf paramzzf, String paramString1, String paramString2)
    throws RemoteException;

  public abstract Bundle zzl(Uri paramUri)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzg
  {
    public static zzg zzfA(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.people.internal.IPeopleService");
      if ((localIInterface != null) && ((localIInterface instanceof zzg)))
        return (zzg)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject1;
      boolean bool1;
      boolean bool2;
      label559: label634: Object localObject3;
      String str;
      Object localObject4;
      long l;
      label1054: int i;
      label1410: label1671: label2828: label4112: label4117: switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.people.internal.IPeopleService");
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0)
        {
          bool1 = true;
          if (paramParcel1.readInt() == 0)
            break label559;
        }
        for (bool2 = true; ; bool2 = false)
        {
          zza((zzf)localObject1, bool1, bool2, paramParcel1.readString(), paramParcel1.readString());
          paramParcel2.writeNoException();
          return true;
          bool1 = false;
          break;
        }
      case 305:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0)
        {
          bool1 = true;
          if (paramParcel1.readInt() == 0)
            break label634;
        }
        for (bool2 = true; ; bool2 = false)
        {
          zza((zzf)localObject1, bool1, bool2, paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
          bool1 = false;
          break;
        }
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zza(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        localObject4 = paramParcel1.createStringArrayList();
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0);
        for (bool1 = true; ; bool1 = false)
        {
          zza((zzf)localObject1, (String)localObject2, (String)localObject3, str, (List)localObject4, paramInt1, bool1, paramParcel1.readLong());
          paramParcel2.writeNoException();
          return true;
        }
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zza(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        l = paramParcel1.readLong();
        if (paramParcel1.readInt() != 0);
        for (bool1 = true; ; bool1 = false)
        {
          zza((zzf)localObject1, l, bool1);
          paramParcel2.writeNoException();
          return true;
        }
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (bool1 = true; ; bool1 = false)
        {
          zza((zzf)localObject1, (String)localObject2, (String)localObject3, str, bool1);
          paramParcel2.writeNoException();
          return true;
        }
      case 603:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (bool1 = true; ; bool1 = false)
        {
          zzb((zzf)localObject1, (String)localObject2, (String)localObject3, str, bool1);
          paramParcel2.writeNoException();
          return true;
        }
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = zzl(paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null)
            break label1054;
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel1 = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (bool1 = true; ; bool1 = false)
        {
          zza((zzf)localObject1, (String)localObject2, (String)localObject3, str, bool1, paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
      case 201:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (bool1 = true; ; bool1 = false)
        {
          zza((zzf)localObject1, (String)localObject2, (String)localObject3, str, bool1, paramParcel1.readInt(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
      case 202:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0);
        for (bool1 = true; ; bool1 = false)
        {
          zza((zzf)localObject1, (String)localObject2, (String)localObject3, str, paramInt1, bool1, paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
          paramParcel2.writeNoException();
          return true;
        }
      case 203:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0)
        {
          bool1 = true;
          paramInt2 = paramParcel1.readInt();
          i = paramParcel1.readInt();
          localObject4 = paramParcel1.readString();
          if (paramParcel1.readInt() == 0)
            break label1410;
        }
        for (bool2 = true; ; bool2 = false)
        {
          zza((zzf)localObject1, (String)localObject2, (String)localObject3, str, paramInt1, bool1, paramInt2, i, (String)localObject4, bool2);
          paramParcel2.writeNoException();
          return true;
          bool1 = false;
          break;
        }
      case 402:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0)
        {
          bool1 = true;
          paramInt2 = paramParcel1.readInt();
          i = paramParcel1.readInt();
          localObject4 = paramParcel1.readString();
          if (paramParcel1.readInt() == 0)
            break label1535;
        }
        for (bool2 = true; ; bool2 = false)
        {
          zza((zzf)localObject1, (String)localObject2, (String)localObject3, str, paramInt1, bool1, paramInt2, i, (String)localObject4, bool2, paramParcel1.readInt(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
          bool1 = false;
          break;
        }
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (bool1 = true; ; bool1 = false)
        {
          zza((zzf)localObject1, (String)localObject2, bool1, paramParcel1.createStringArray());
          paramParcel2.writeNoException();
          return true;
        }
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0)
        {
          bool1 = true;
          paramParcel1 = zza((zzf)localObject1, bool1, paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          if (paramParcel1 == null)
            break label1671;
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          bool1 = false;
          break;
          paramParcel2.writeInt(0);
        }
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        paramParcel1 = zzN(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza((zzf)localObject1, (String)localObject2, (String)localObject3, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zza(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArrayList(), paramParcel1.createStringArrayList());
        paramParcel2.writeNoException();
        return true;
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        if (paramParcel1.readInt() != 0);
        for (bool1 = true; ; bool1 = false)
        {
          zzag(bool1);
          paramParcel2.writeNoException();
          return true;
        }
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        bool1 = isSyncToContactsEnabled();
        paramParcel2.writeNoException();
        if (bool1);
        for (paramInt1 = 1; ; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        paramParcel1 = zzO(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject2 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label2040;
        }
        for (bool1 = true; ; bool1 = false)
        {
          zza((zzf)localObject2, (String)localObject3, str, (Uri)localObject1, bool1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 19:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        localObject4 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (bool1 = true; ; bool1 = false)
        {
          zza((zzf)localObject1, (String)localObject2, (String)localObject3, str, paramInt1, (String)localObject4, bool1);
          paramParcel2.writeNoException();
          return true;
        }
      case 20:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        paramParcel1 = zzb(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 21:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        localObject4 = paramParcel1.createStringArrayList();
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0);
        for (bool1 = true; ; bool1 = false)
        {
          zza((zzf)localObject1, (String)localObject2, (String)localObject3, str, (List)localObject4, paramInt1, bool1, paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
      case 401:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        localObject4 = paramParcel1.createStringArrayList();
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0);
        for (bool1 = true; ; bool1 = false)
        {
          zza((zzf)localObject1, (String)localObject2, (String)localObject3, str, (List)localObject4, paramInt1, bool1, paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
      case 404:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        localObject4 = paramParcel1.createStringArrayList();
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0);
        for (bool1 = true; ; bool1 = false)
        {
          zza((zzf)localObject1, (String)localObject2, (String)localObject3, str, (List)localObject4, paramInt1, bool1, paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
      case 22:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zzb(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 23:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        localObject4 = paramParcel1.createStringArrayList();
        ArrayList localArrayList = paramParcel1.createStringArrayList();
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = FavaDiagnosticsEntity.CREATOR.zzcU(paramParcel1); ; paramParcel1 = null)
        {
          zza((zzf)localObject1, (String)localObject2, (String)localObject3, str, (List)localObject4, localArrayList, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 24:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zza(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 25:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zza(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 403:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zza(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 26:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = paramParcel1.readString();
        localObject2 = paramParcel1.readString();
        l = paramParcel1.readLong();
        if (paramParcel1.readInt() != 0)
        {
          bool1 = true;
          paramParcel1 = zza((String)localObject1, (String)localObject2, l, bool1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null)
            break label2776;
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          bool1 = false;
          break;
          paramParcel2.writeInt(0);
        }
      case 205:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = paramParcel1.readString();
        localObject2 = paramParcel1.readString();
        l = paramParcel1.readLong();
        if (paramParcel1.readInt() != 0)
        {
          bool1 = true;
          if (paramParcel1.readInt() == 0)
            break label2870;
          bool2 = true;
          paramParcel1 = zza((String)localObject1, (String)localObject2, l, bool1, bool2);
          paramParcel2.writeNoException();
          if (paramParcel1 == null)
            break label2876;
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          bool1 = false;
          break;
          bool2 = false;
          break label2828;
          paramParcel2.writeInt(0);
        }
      case 101:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zzb(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 102:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zzc(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 27:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zza(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 701:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        str = paramParcel1.readString();
        localObject4 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (bool1 = true; ; bool1 = false)
        {
          zza((zzf)localObject1, (String)localObject2, (String)localObject3, str, (String)localObject4, bool1);
          paramParcel2.writeNoException();
          return true;
        }
      case 28:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zza(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArrayList());
        paramParcel2.writeNoException();
        return true;
      case 29:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zza(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 204:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zza(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 301:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zzb(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 302:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza((zzf)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 303:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        zza(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 304:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zzb((zzf)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 501:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject2 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = AccountToken.CREATOR.zzjS(paramParcel1);
          localObject3 = paramParcel1.createStringArrayList();
          if (paramParcel1.readInt() == 0)
            break label3438;
        }
        for (paramParcel1 = ParcelableGetOptions.CREATOR.zzjT(paramParcel1); ; paramParcel1 = null)
        {
          zza((zzf)localObject2, (AccountToken)localObject1, (List)localObject3, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 502:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        paramParcel1 = zzb(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null);
        for (paramParcel1 = paramParcel1.asBinder(); ; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
        }
      case 503:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        l = paramParcel1.readLong();
        if (paramParcel1.readInt() != 0)
        {
          bool1 = true;
          paramParcel1 = zzb((zzf)localObject1, l, bool1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null)
            break label3570;
        }
        for (paramParcel1 = paramParcel1.asBinder(); ; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
          bool1 = false;
          break;
        }
      case 504:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        paramParcel1 = zzb(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null);
        for (paramParcel1 = paramParcel1.asBinder(); ; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
        }
      case 505:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        paramParcel1 = zzb(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null);
        for (paramParcel1 = paramParcel1.asBinder(); ; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
        }
      case 506:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        paramParcel1 = zzc(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null);
        for (paramParcel1 = paramParcel1.asBinder(); ; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
        }
      case 507:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject1 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          bool1 = true;
          str = paramParcel1.readString();
          localObject4 = paramParcel1.readString();
          paramInt1 = paramParcel1.readInt();
          paramInt2 = paramParcel1.readInt();
          i = paramParcel1.readInt();
          if (paramParcel1.readInt() == 0)
            break label3870;
          bool2 = true;
          paramParcel1 = zza((zzf)localObject1, (String)localObject2, (String)localObject3, bool1, str, (String)localObject4, paramInt1, paramInt2, i, bool2);
          paramParcel2.writeNoException();
          if (paramParcel1 == null)
            break label3876;
        }
        for (paramParcel1 = paramParcel1.asBinder(); ; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
          bool1 = false;
          break;
          bool2 = false;
          break label3818;
        }
      case 508:
        paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        localObject2 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = AvatarReference.CREATOR.zzjX(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label3965;
          paramParcel1 = ParcelableLoadImageOptions.CREATOR.zzjV(paramParcel1);
          paramParcel1 = zza((zzf)localObject2, (AvatarReference)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null)
            break label3970;
        }
        for (paramParcel1 = paramParcel1.asBinder(); ; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
          localObject1 = null;
          break;
          paramParcel1 = null;
          break label3927;
        }
      case 509:
        label3870: label3876: label3927: paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        paramParcel1 = zza(zzf.zza.zzfz(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null);
        for (paramParcel1 = paramParcel1.asBinder(); ; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
        }
      case 601:
        label1535: paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
        label2040: label3965: localObject2 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
        label2776: label3438: label3570: if (paramParcel1.readInt() != 0)
        {
          localObject1 = AccountToken.CREATOR.zzjS(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label4112;
          paramParcel1 = ParcelableListOptions.CREATOR.zzjU(paramParcel1);
          paramParcel1 = zza((zzf)localObject2, (AccountToken)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null)
            break label4117;
        }
        label2870: label2876: label3818: label4074: for (paramParcel1 = paramParcel1.asBinder(); ; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
          localObject1 = null;
          break;
          paramParcel1 = null;
          break label4074;
        }
      case 602:
      }
      label3970: paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      Object localObject2 = zzf.zza.zzfz(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = DataHolder.CREATOR.zzcH(paramParcel1);
        paramParcel1 = zza((zzf)localObject2, (DataHolder)localObject1, paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        if (paramParcel1 == null)
          break label4202;
      }
      label4202: for (paramParcel1 = paramParcel1.asBinder(); ; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
        localObject1 = null;
        break;
      }
    }

    private static class zza
      implements zzg
    {
      private IBinder zznF;

      zza(IBinder paramIBinder)
      {
        zznF = paramIBinder;
      }

      public IBinder asBinder()
      {
        return zznF;
      }

      public boolean isSyncToContactsEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          zznF.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0)
            bool = true;
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Bundle zzN(String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          zznF.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramString1 = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return paramString1;
          }
          paramString1 = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Bundle zzO(String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          zznF.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramString1 = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return paramString1;
          }
          paramString1 = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Bundle zza(zzf paramzzf, boolean paramBoolean, String paramString1, String paramString2, int paramInt)
        throws RemoteException
      {
        Object localObject = null;
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeInt(paramInt);
            zznF.transact(11, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramzzf = localObject;
            if (localParcel2.readInt() != 0)
              paramzzf = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return paramzzf;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public Bundle zza(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeLong(paramLong);
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          zznF.transact(26, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0);
          for (paramString1 = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2); ; paramString1 = null)
            return paramString1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString1;
      }

      public Bundle zza(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        int j = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeLong(paramLong);
          int i;
          if (paramBoolean1)
          {
            i = 1;
            localParcel1.writeInt(i);
            if (!paramBoolean2)
              break label132;
            i = j;
            label62: localParcel1.writeInt(i);
            zznF.transact(205, localParcel1, localParcel2, 0);
            localParcel2.readException();
            if (localParcel2.readInt() == 0)
              break label138;
          }
          label132: label138: for (paramString1 = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2); ; paramString1 = null)
          {
            return paramString1;
            i = 0;
            break;
            i = 0;
            break label62;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString1;
      }

      public ICancelToken zza(zzf paramzzf, DataHolder paramDataHolder, int paramInt1, int paramInt2, long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null)
          {
            paramzzf = paramzzf.asBinder();
            localParcel1.writeStrongBinder(paramzzf);
            if (paramDataHolder == null)
              break label120;
            localParcel1.writeInt(1);
            paramDataHolder.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeLong(paramLong);
            zznF.transact(602, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramzzf = ICancelToken.zza.zzbW(localParcel2.readStrongBinder());
            return paramzzf;
            paramzzf = null;
            break;
            label120: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public ICancelToken zza(zzf paramzzf, AccountToken paramAccountToken, ParcelableListOptions paramParcelableListOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
            if (paramzzf != null)
            {
              paramzzf = paramzzf.asBinder();
              localParcel1.writeStrongBinder(paramzzf);
              if (paramAccountToken != null)
              {
                localParcel1.writeInt(1);
                paramAccountToken.writeToParcel(localParcel1, 0);
                if (paramParcelableListOptions == null)
                  break label139;
                localParcel1.writeInt(1);
                paramParcelableListOptions.writeToParcel(localParcel1, 0);
                zznF.transact(601, localParcel1, localParcel2, 0);
                localParcel2.readException();
                paramzzf = ICancelToken.zza.zzbW(localParcel2.readStrongBinder());
                return paramzzf;
              }
            }
            else
            {
              paramzzf = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label139: localParcel1.writeInt(0);
        }
      }

      public ICancelToken zza(zzf paramzzf, AvatarReference paramAvatarReference, ParcelableLoadImageOptions paramParcelableLoadImageOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
            if (paramzzf != null)
            {
              paramzzf = paramzzf.asBinder();
              localParcel1.writeStrongBinder(paramzzf);
              if (paramAvatarReference != null)
              {
                localParcel1.writeInt(1);
                paramAvatarReference.writeToParcel(localParcel1, 0);
                if (paramParcelableLoadImageOptions == null)
                  break label139;
                localParcel1.writeInt(1);
                paramParcelableLoadImageOptions.writeToParcel(localParcel1, 0);
                zznF.transact(508, localParcel1, localParcel2, 0);
                localParcel2.readException();
                paramzzf = ICancelToken.zza.zzbW(localParcel2.readStrongBinder());
                return paramzzf;
              }
            }
            else
            {
              paramzzf = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label139: localParcel1.writeInt(0);
        }
      }

      public ICancelToken zza(zzf paramzzf, String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString);
            localParcel1.writeInt(paramInt);
            zznF.transact(509, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramzzf = ICancelToken.zza.zzbW(localParcel2.readStrongBinder());
            return paramzzf;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public ICancelToken zza(zzf paramzzf, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
        throws RemoteException
      {
        int j = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          int i;
          if (paramzzf != null)
          {
            paramzzf = paramzzf.asBinder();
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (!paramBoolean1)
              break label164;
            i = 1;
            label57: localParcel1.writeInt(i);
            localParcel1.writeString(paramString3);
            localParcel1.writeString(paramString4);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeInt(paramInt3);
            if (!paramBoolean2)
              break label170;
          }
          label164: label170: for (paramInt1 = j; ; paramInt1 = 0)
          {
            localParcel1.writeInt(paramInt1);
            zznF.transact(507, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramzzf = ICancelToken.zza.zzbW(localParcel2.readStrongBinder());
            return paramzzf;
            paramzzf = null;
            break;
            i = 0;
            break label57;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, long paramLong, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeLong(paramLong);
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            zznF.transact(6, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null)
          {
            paramzzf = paramzzf.asBinder();
            localParcel1.writeStrongBinder(paramzzf);
            if (paramBundle == null)
              break label83;
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(302, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzf = null;
            break;
            label83: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, AccountToken paramAccountToken, List<String> paramList, ParcelableGetOptions paramParcelableGetOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
            if (paramzzf != null)
            {
              paramzzf = paramzzf.asBinder();
              localParcel1.writeStrongBinder(paramzzf);
              if (paramAccountToken != null)
              {
                localParcel1.writeInt(1);
                paramAccountToken.writeToParcel(localParcel1, 0);
                localParcel1.writeStringList(paramList);
                if (paramParcelableGetOptions == null)
                  break label137;
                localParcel1.writeInt(1);
                paramParcelableGetOptions.writeToParcel(localParcel1, 0);
                zznF.transact(501, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              paramzzf = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label137: localParcel1.writeInt(0);
        }
      }

      public void zza(zzf paramzzf, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString);
            zznF.transact(24, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            zznF.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            zznF.transact(25, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeInt(paramInt);
            zznF.transact(403, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            zznF.transact(29, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, Uri paramUri)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null)
          {
            paramzzf = paramzzf.asBinder();
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramUri == null)
              break label103;
            localParcel1.writeInt(1);
            paramUri.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(13, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzf = null;
            break;
            label103: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, Uri paramUri, boolean paramBoolean)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
            if (paramzzf != null)
            {
              paramzzf = paramzzf.asBinder();
              localParcel1.writeStrongBinder(paramzzf);
              localParcel1.writeString(paramString1);
              localParcel1.writeString(paramString2);
              if (paramUri != null)
              {
                localParcel1.writeInt(1);
                paramUri.writeToParcel(localParcel1, 0);
                break label144;
                localParcel1.writeInt(i);
                zznF.transact(18, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              paramzzf = null;
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label144: 
          while (!paramBoolean)
          {
            i = 0;
            break;
          }
        }
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            zznF.transact(204, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeInt(paramInt);
            localParcel1.writeString(paramString4);
            zznF.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeInt(paramInt);
            localParcel1.writeString(paramString4);
            paramInt = i;
            if (paramBoolean)
              paramInt = 1;
            localParcel1.writeInt(paramInt);
            zznF.transact(19, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString4)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeInt(paramInt1);
            paramInt1 = i;
            if (paramBoolean)
              paramInt1 = 1;
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeInt(paramInt3);
            localParcel1.writeString(paramString4);
            zznF.transact(202, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, String paramString4, boolean paramBoolean2)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null)
          {
            paramzzf = paramzzf.asBinder();
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeInt(paramInt1);
            if (!paramBoolean1)
              break label154;
            paramInt1 = 1;
            label71: localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeInt(paramInt3);
            localParcel1.writeString(paramString4);
            if (!paramBoolean2)
              break label160;
          }
          label154: label160: for (paramInt1 = i; ; paramInt1 = 0)
          {
            localParcel1.writeInt(paramInt1);
            zznF.transact(203, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzf = null;
            break;
            paramInt1 = 0;
            break label71;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, String paramString4, boolean paramBoolean2, int paramInt4, int paramInt5)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null)
          {
            paramzzf = paramzzf.asBinder();
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeInt(paramInt1);
            if (!paramBoolean1)
              break label164;
            paramInt1 = 1;
            label68: localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeInt(paramInt3);
            localParcel1.writeString(paramString4);
            if (!paramBoolean2)
              break label170;
          }
          label164: label170: for (paramInt1 = 1; ; paramInt1 = 0)
          {
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt4);
            localParcel1.writeInt(paramInt5);
            zznF.transact(402, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzf = null;
            break;
            paramInt1 = 0;
            break label68;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, String paramString4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeString(paramString4);
            zznF.transact(27, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeString(paramString4);
            localParcel1.writeInt(paramInt);
            localParcel1.writeString(paramString5);
            zznF.transact(303, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeString(paramString4);
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            zznF.transact(701, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, List<String> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeStringList(paramList);
            zznF.transact(28, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, List<String> paramList, int paramInt, boolean paramBoolean, long paramLong)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeStringList(paramList);
            localParcel1.writeInt(paramInt);
            paramInt = i;
            if (paramBoolean)
              paramInt = 1;
            localParcel1.writeInt(paramInt);
            localParcel1.writeLong(paramLong);
            zznF.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, List<String> paramList, int paramInt1, boolean paramBoolean, long paramLong, String paramString4, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null)
          {
            paramzzf = paramzzf.asBinder();
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeStringList(paramList);
            localParcel1.writeInt(paramInt1);
            if (!paramBoolean)
              break label141;
          }
          label141: for (paramInt1 = 1; ; paramInt1 = 0)
          {
            localParcel1.writeInt(paramInt1);
            localParcel1.writeLong(paramLong);
            localParcel1.writeString(paramString4);
            localParcel1.writeInt(paramInt2);
            zznF.transact(21, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzf = null;
            break;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, List<String> paramList, int paramInt1, boolean paramBoolean, long paramLong, String paramString4, int paramInt2, int paramInt3)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null)
          {
            paramzzf = paramzzf.asBinder();
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeStringList(paramList);
            localParcel1.writeInt(paramInt1);
            if (!paramBoolean)
              break label149;
          }
          label149: for (paramInt1 = 1; ; paramInt1 = 0)
          {
            localParcel1.writeInt(paramInt1);
            localParcel1.writeLong(paramLong);
            localParcel1.writeString(paramString4);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeInt(paramInt3);
            zznF.transact(401, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzf = null;
            break;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, List<String> paramList, int paramInt1, boolean paramBoolean, long paramLong, String paramString4, int paramInt2, int paramInt3, int paramInt4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null)
          {
            paramzzf = paramzzf.asBinder();
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeStringList(paramList);
            localParcel1.writeInt(paramInt1);
            if (!paramBoolean)
              break label156;
          }
          label156: for (paramInt1 = 1; ; paramInt1 = 0)
          {
            localParcel1.writeInt(paramInt1);
            localParcel1.writeLong(paramLong);
            localParcel1.writeString(paramString4);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeInt(paramInt3);
            localParcel1.writeInt(paramInt4);
            zznF.transact(404, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzf = null;
            break;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, List<String> paramList1, List<String> paramList2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeStringList(paramList1);
            localParcel1.writeStringList(paramList2);
            zznF.transact(14, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, List<String> paramList1, List<String> paramList2, FavaDiagnosticsEntity paramFavaDiagnosticsEntity)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null)
          {
            paramzzf = paramzzf.asBinder();
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeStringList(paramList1);
            localParcel1.writeStringList(paramList2);
            if (paramFavaDiagnosticsEntity == null)
              break label124;
            localParcel1.writeInt(1);
            paramFavaDiagnosticsEntity.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(23, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzf = null;
            break;
            label124: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            zznF.transact(7, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            localParcel1.writeInt(paramInt);
            zznF.transact(9, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            zznF.transact(201, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, String paramString, boolean paramBoolean, String[] paramArrayOfString)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString);
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            localParcel1.writeStringArray(paramArrayOfString);
            zznF.transact(10, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
        throws RemoteException
      {
        int j = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null)
          {
            paramzzf = paramzzf.asBinder();
            localParcel1.writeStrongBinder(paramzzf);
            if (!paramBoolean1)
              break label117;
            i = 1;
            label44: localParcel1.writeInt(i);
            if (!paramBoolean2)
              break label123;
          }
          label117: label123: for (int i = j; ; i = 0)
          {
            localParcel1.writeInt(i);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            zznF.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzf = null;
            break;
            i = 0;
            break label44;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zza(zzf paramzzf, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt)
        throws RemoteException
      {
        int j = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null)
          {
            paramzzf = paramzzf.asBinder();
            localParcel1.writeStrongBinder(paramzzf);
            if (!paramBoolean1)
              break label126;
            i = 1;
            label44: localParcel1.writeInt(i);
            if (!paramBoolean2)
              break label132;
          }
          label132: for (int i = j; ; i = 0)
          {
            localParcel1.writeInt(i);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeInt(paramInt);
            zznF.transact(305, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzf = null;
            break;
            label126: i = 0;
            break label44;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zzag(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          zznF.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Bundle zzb(String paramString1, String paramString2, long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeLong(paramLong);
          zznF.transact(20, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramString1 = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return paramString1;
          }
          paramString1 = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public ICancelToken zzb(zzf paramzzf, long paramLong, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeLong(paramLong);
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            zznF.transact(503, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramzzf = ICancelToken.zza.zzbW(localParcel2.readStrongBinder());
            return paramzzf;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public ICancelToken zzb(zzf paramzzf, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString);
            zznF.transact(504, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramzzf = ICancelToken.zza.zzbW(localParcel2.readStrongBinder());
            return paramzzf;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public ICancelToken zzb(zzf paramzzf, String paramString, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            zznF.transact(502, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramzzf = ICancelToken.zza.zzbW(localParcel2.readStrongBinder());
            return paramzzf;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public ICancelToken zzb(zzf paramzzf, String paramString1, String paramString2, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            zznF.transact(505, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramzzf = ICancelToken.zza.zzbW(localParcel2.readStrongBinder());
            return paramzzf;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zzb(zzf paramzzf, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null)
          {
            paramzzf = paramzzf.asBinder();
            localParcel1.writeStrongBinder(paramzzf);
            if (paramBundle == null)
              break label83;
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            zznF.transact(304, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzf = null;
            break;
            label83: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zzb(zzf paramzzf, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            zznF.transact(101, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zzb(zzf paramzzf, String paramString1, String paramString2, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeInt(paramInt);
            zznF.transact(301, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zzb(zzf paramzzf, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeInt(paramInt);
            localParcel1.writeString(paramString4);
            zznF.transact(22, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zzb(zzf paramzzf, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            zznF.transact(603, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public ICancelToken zzc(zzf paramzzf, String paramString1, String paramString2, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeInt(paramInt);
            zznF.transact(506, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramzzf = ICancelToken.zza.zzbW(localParcel2.readStrongBinder());
            return paramzzf;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public void zzc(zzf paramzzf, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
          if (paramzzf != null);
          for (paramzzf = paramzzf.asBinder(); ; paramzzf = null)
          {
            localParcel1.writeStrongBinder(paramzzf);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            zznF.transact(102, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzf;
      }

      public Bundle zzl(Uri paramUri)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
            if (paramUri != null)
            {
              localParcel1.writeInt(1);
              paramUri.writeToParcel(localParcel1, 0);
              zznF.transact(8, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramUri = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramUri;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          paramUri = null;
        }
      }
    }
  }
}