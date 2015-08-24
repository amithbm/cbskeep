package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceRequest;
import com.google.android.gms.location.places.UserDataType;
import com.google.android.gms.location.places.personalized.PlaceAlias;
import com.google.android.gms.location.places.personalized.zzc;
import com.google.android.gms.location.places.zzb;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.zze;
import java.util.List;

public abstract interface zzf extends IInterface
{
  public abstract void zza(AddPlaceRequest paramAddPlaceRequest, PlacesParams paramPlacesParams, zzh paramzzh)
    throws RemoteException;

  public abstract void zza(NearbyAlertRequest paramNearbyAlertRequest, PlacesParams paramPlacesParams, PendingIntent paramPendingIntent)
    throws RemoteException;

  public abstract void zza(PlaceReport paramPlaceReport, PlacesParams paramPlacesParams)
    throws RemoteException;

  public abstract void zza(PlaceRequest paramPlaceRequest, PlacesParams paramPlacesParams, PendingIntent paramPendingIntent)
    throws RemoteException;

  public abstract void zza(UserDataType paramUserDataType, LatLngBounds paramLatLngBounds, List<String> paramList, PlacesParams paramPlacesParams, zzh paramzzh)
    throws RemoteException;

  public abstract void zza(PlacesParams paramPlacesParams, PendingIntent paramPendingIntent)
    throws RemoteException;

  public abstract void zza(PlaceAlias paramPlaceAlias, String paramString1, String paramString2, PlacesParams paramPlacesParams, zzh paramzzh)
    throws RemoteException;

  public abstract void zza(LatLng paramLatLng, PlaceFilter paramPlaceFilter, PlacesParams paramPlacesParams, zzh paramzzh)
    throws RemoteException;

  public abstract void zza(LatLngBounds paramLatLngBounds, int paramInt, String paramString, PlaceFilter paramPlaceFilter, PlacesParams paramPlacesParams, zzh paramzzh)
    throws RemoteException;

  public abstract void zza(String paramString, int paramInt1, int paramInt2, int paramInt3, PlacesParams paramPlacesParams, zzg paramzzg)
    throws RemoteException;

  public abstract void zza(String paramString, int paramInt, PlacesParams paramPlacesParams, zzh paramzzh)
    throws RemoteException;

  public abstract void zza(String paramString, PlacesParams paramPlacesParams, zzg paramzzg)
    throws RemoteException;

  public abstract void zza(String paramString, PlacesParams paramPlacesParams, zzh paramzzh)
    throws RemoteException;

  public abstract void zza(String paramString, LatLngBounds paramLatLngBounds, AutocompleteFilter paramAutocompleteFilter, PlacesParams paramPlacesParams, zzh paramzzh)
    throws RemoteException;

  public abstract void zza(List<String> paramList, PlacesParams paramPlacesParams, zzh paramzzh)
    throws RemoteException;

  public abstract void zzb(PlaceFilter paramPlaceFilter, PlacesParams paramPlacesParams, zzh paramzzh)
    throws RemoteException;

  public abstract void zzb(PlacesParams paramPlacesParams, PendingIntent paramPendingIntent)
    throws RemoteException;

  public abstract void zzb(String paramString, PlacesParams paramPlacesParams, zzh paramzzh)
    throws RemoteException;

  public abstract void zzb(List<String> paramList, PlacesParams paramPlacesParams, zzh paramzzh)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzf
  {
    public static zzf zzee(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
      if ((localIInterface != null) && ((localIInterface instanceof zzf)))
        return (zzf)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject6 = null;
      Object localObject3 = null;
      Object localObject1 = null;
      Object localObject7 = null;
      Object localObject8 = null;
      Object localObject9 = null;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject10 = null;
      Object localObject11 = null;
      Object localObject12 = null;
      Object localObject2 = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.location.places.internal.IGooglePlacesService");
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = LatLngBounds.CREATOR.zziZ(paramParcel1);
          paramInt1 = paramParcel1.readInt();
          localObject3 = paramParcel1.readString();
          if (paramParcel1.readInt() == 0)
            break label316;
        }
        for (localObject1 = PlaceFilter.CREATOR.zziu(paramParcel1); ; localObject1 = null)
        {
          if (paramParcel1.readInt() != 0)
            localObject2 = PlacesParams.CREATOR.zziF(paramParcel1);
          zza(paramParcel2, paramInt1, (String)localObject3, (PlaceFilter)localObject1, (PlacesParams)localObject2, zzh.zza.zzeg(paramParcel1.readStrongBinder()));
          return true;
          paramParcel2 = null;
          break;
        }
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        localObject1 = paramParcel1.readString();
        paramParcel2 = localObject6;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = PlacesParams.CREATOR.zziF(paramParcel1);
        zza((String)localObject1, paramParcel2, zzh.zza.zzeg(paramParcel1.readStrongBinder()));
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = LatLng.CREATOR.zzja(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label448;
        }
        for (localObject1 = PlaceFilter.CREATOR.zziu(paramParcel1); ; localObject1 = null)
        {
          localObject2 = localObject3;
          if (paramParcel1.readInt() != 0)
            localObject2 = PlacesParams.CREATOR.zziF(paramParcel1);
          zza(paramParcel2, (PlaceFilter)localObject1, (PlacesParams)localObject2, zzh.zza.zzeg(paramParcel1.readStrongBinder()));
          return true;
          paramParcel2 = null;
          break;
        }
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramParcel1.readInt() != 0);
        for (paramParcel2 = PlaceFilter.CREATOR.zziu(paramParcel1); ; paramParcel2 = null)
        {
          if (paramParcel1.readInt() != 0)
            localObject1 = PlacesParams.CREATOR.zziF(paramParcel1);
          zzb(paramParcel2, (PlacesParams)localObject1, zzh.zza.zzeg(paramParcel1.readStrongBinder()));
          return true;
        }
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        localObject1 = paramParcel1.readString();
        paramParcel2 = localObject7;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = PlacesParams.CREATOR.zziF(paramParcel1);
        zzb((String)localObject1, paramParcel2, zzh.zza.zzeg(paramParcel1.readStrongBinder()));
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        localObject1 = paramParcel1.createStringArrayList();
        paramParcel2 = localObject8;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = PlacesParams.CREATOR.zziF(paramParcel1);
        zza((List)localObject1, paramParcel2, zzh.zza.zzeg(paramParcel1.readStrongBinder()));
        return true;
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        localObject1 = paramParcel1.createStringArrayList();
        paramParcel2 = localObject9;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = PlacesParams.CREATOR.zziF(paramParcel1);
        zzb((List)localObject1, paramParcel2, zzh.zza.zzeg(paramParcel1.readStrongBinder()));
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = UserDataType.CREATOR.zziz(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label734;
          localObject1 = LatLngBounds.CREATOR.zziZ(paramParcel1);
          localObject3 = paramParcel1.createStringArrayList();
          if (paramParcel1.readInt() == 0)
            break label740;
        }
        for (localObject2 = PlacesParams.CREATOR.zziF(paramParcel1); ; localObject2 = null)
        {
          zza(paramParcel2, (LatLngBounds)localObject1, (List)localObject3, (PlacesParams)localObject2, zzh.zza.zzeg(paramParcel1.readStrongBinder()));
          return true;
          paramParcel2 = null;
          break;
          localObject1 = null;
          break label687;
        }
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = (PlaceRequest)PlaceRequest.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label823;
          localObject1 = PlacesParams.CREATOR.zziF(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label829;
        }
        for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza(paramParcel2, (PlacesParams)localObject1, paramParcel1);
          return true;
          paramParcel2 = null;
          break;
          localObject1 = null;
          break label788;
        }
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = PlacesParams.CREATOR.zziF(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label888;
        }
        for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza(paramParcel2, paramParcel1);
          return true;
          paramParcel2 = null;
          break;
        }
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = NearbyAlertRequest.CREATOR.zzit(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label965;
          localObject1 = PlacesParams.CREATOR.zziF(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label971;
        }
        for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza(paramParcel2, (PlacesParams)localObject1, paramParcel1);
          return true;
          paramParcel2 = null;
          break;
          localObject1 = null;
          break label930;
        }
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = PlacesParams.CREATOR.zziF(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label1030;
        }
        for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zzb(paramParcel2, paramParcel1);
          return true;
          paramParcel2 = null;
          break;
        }
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        localObject3 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = LatLngBounds.CREATOR.zziZ(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label1119;
          localObject1 = AutocompleteFilter.CREATOR.zzir(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label1125;
        }
        for (localObject2 = PlacesParams.CREATOR.zziF(paramParcel1); ; localObject2 = null)
        {
          zza((String)localObject3, paramParcel2, (AutocompleteFilter)localObject1, (PlacesParams)localObject2, zzh.zza.zzeg(paramParcel1.readStrongBinder()));
          return true;
          paramParcel2 = null;
          break;
          localObject1 = null;
          break label1078;
        }
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramParcel1.readInt() != 0);
        for (paramParcel2 = (AddPlaceRequest)AddPlaceRequest.CREATOR.createFromParcel(paramParcel1); ; paramParcel2 = null)
        {
          localObject1 = localObject4;
          if (paramParcel1.readInt() != 0)
            localObject1 = PlacesParams.CREATOR.zziF(paramParcel1);
          zza(paramParcel2, (PlacesParams)localObject1, zzh.zza.zzeg(paramParcel1.readStrongBinder()));
          return true;
        }
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramParcel1.readInt() != 0);
        for (paramParcel2 = (PlaceReport)PlaceReport.CREATOR.createFromParcel(paramParcel1); ; paramParcel2 = null)
        {
          localObject1 = localObject5;
          if (paramParcel1.readInt() != 0)
            localObject1 = PlacesParams.CREATOR.zziF(paramParcel1);
          zza(paramParcel2, (PlacesParams)localObject1);
          return true;
        }
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = PlaceAlias.CREATOR.zziJ(paramParcel1);
          localObject2 = paramParcel1.readString();
          localObject3 = paramParcel1.readString();
          if (paramParcel1.readInt() == 0)
            break label1332;
        }
        for (localObject1 = PlacesParams.CREATOR.zziF(paramParcel1); ; localObject1 = null)
        {
          zza(paramParcel2, (String)localObject2, (String)localObject3, (PlacesParams)localObject1, zzh.zza.zzeg(paramParcel1.readStrongBinder()));
          return true;
          paramParcel2 = null;
          break;
        }
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        localObject1 = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        paramParcel2 = localObject10;
        if (paramParcel1.readInt() != 0)
          paramParcel2 = PlacesParams.CREATOR.zziF(paramParcel1);
        zza((String)localObject1, paramInt1, paramParcel2, zzh.zza.zzeg(paramParcel1.readStrongBinder()));
        return true;
      case 19:
        label316: label448: label734: label740: label888: paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        label687: label823: label829: label965: label971: label1119: label1125: localObject1 = paramParcel1.readString();
        label788: label930: label1078: paramParcel2 = localObject11;
        label1030: label1332: if (paramParcel1.readInt() != 0)
          paramParcel2 = PlacesParams.CREATOR.zziF(paramParcel1);
        zza((String)localObject1, paramParcel2, zzg.zza.zzef(paramParcel1.readStrongBinder()));
        return true;
      case 20:
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
      localObject1 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      int i = paramParcel1.readInt();
      paramParcel2 = localObject12;
      if (paramParcel1.readInt() != 0)
        paramParcel2 = PlacesParams.CREATOR.zziF(paramParcel1);
      zza((String)localObject1, paramInt1, paramInt2, i, paramParcel2, zzg.zza.zzef(paramParcel1.readStrongBinder()));
      return true;
    }

    private static class zza
      implements zzf
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

      public void zza(AddPlaceRequest paramAddPlaceRequest, PlacesParams paramPlacesParams, zzh paramzzh)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (paramAddPlaceRequest != null)
            {
              localParcel.writeInt(1);
              paramAddPlaceRequest.writeToParcel(localParcel, 0);
              if (paramPlacesParams != null)
              {
                localParcel.writeInt(1);
                paramPlacesParams.writeToParcel(localParcel, 0);
                paramAddPlaceRequest = localObject;
                if (paramzzh != null)
                  paramAddPlaceRequest = paramzzh.asBinder();
                localParcel.writeStrongBinder(paramAddPlaceRequest);
                zznF.transact(14, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
        }
      }

      public void zza(NearbyAlertRequest paramNearbyAlertRequest, PlacesParams paramPlacesParams, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (paramNearbyAlertRequest != null)
            {
              localParcel.writeInt(1);
              paramNearbyAlertRequest.writeToParcel(localParcel, 0);
              if (paramPlacesParams != null)
              {
                localParcel.writeInt(1);
                paramPlacesParams.writeToParcel(localParcel, 0);
                if (paramPendingIntent == null)
                  break label111;
                localParcel.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel, 0);
                zznF.transact(11, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
          continue;
          label111: localParcel.writeInt(0);
        }
      }

      public void zza(PlaceReport paramPlaceReport, PlacesParams paramPlacesParams)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (paramPlaceReport != null)
            {
              localParcel.writeInt(1);
              paramPlaceReport.writeToParcel(localParcel, 0);
              if (paramPlacesParams != null)
              {
                localParcel.writeInt(1);
                paramPlacesParams.writeToParcel(localParcel, 0);
                zznF.transact(15, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
        }
      }

      public void zza(PlaceRequest paramPlaceRequest, PlacesParams paramPlacesParams, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (paramPlaceRequest != null)
            {
              localParcel.writeInt(1);
              paramPlaceRequest.writeToParcel(localParcel, 0);
              if (paramPlacesParams != null)
              {
                localParcel.writeInt(1);
                paramPlacesParams.writeToParcel(localParcel, 0);
                if (paramPendingIntent == null)
                  break label111;
                localParcel.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel, 0);
                zznF.transact(9, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
          continue;
          label111: localParcel.writeInt(0);
        }
      }

      public void zza(UserDataType paramUserDataType, LatLngBounds paramLatLngBounds, List<String> paramList, PlacesParams paramPlacesParams, zzh paramzzh)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (paramUserDataType != null)
            {
              localParcel.writeInt(1);
              paramUserDataType.writeToParcel(localParcel, 0);
              if (paramLatLngBounds != null)
              {
                localParcel.writeInt(1);
                paramLatLngBounds.writeToParcel(localParcel, 0);
                localParcel.writeStringList(paramList);
                if (paramPlacesParams == null)
                  break label144;
                localParcel.writeInt(1);
                paramPlacesParams.writeToParcel(localParcel, 0);
                paramUserDataType = localObject;
                if (paramzzh != null)
                  paramUserDataType = paramzzh.asBinder();
                localParcel.writeStrongBinder(paramUserDataType);
                zznF.transact(8, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
          continue;
          label144: localParcel.writeInt(0);
        }
      }

      public void zza(PlacesParams paramPlacesParams, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (paramPlacesParams != null)
            {
              localParcel.writeInt(1);
              paramPlacesParams.writeToParcel(localParcel, 0);
              if (paramPendingIntent != null)
              {
                localParcel.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel, 0);
                zznF.transact(10, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
        }
      }

      public void zza(PlaceAlias paramPlaceAlias, String paramString1, String paramString2, PlacesParams paramPlacesParams, zzh paramzzh)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (paramPlaceAlias != null)
            {
              localParcel.writeInt(1);
              paramPlaceAlias.writeToParcel(localParcel, 0);
              localParcel.writeString(paramString1);
              localParcel.writeString(paramString2);
              if (paramPlacesParams != null)
              {
                localParcel.writeInt(1);
                paramPlacesParams.writeToParcel(localParcel, 0);
                paramPlaceAlias = localObject;
                if (paramzzh != null)
                  paramPlaceAlias = paramzzh.asBinder();
                localParcel.writeStrongBinder(paramPlaceAlias);
                zznF.transact(16, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
        }
      }

      public void zza(LatLng paramLatLng, PlaceFilter paramPlaceFilter, PlacesParams paramPlacesParams, zzh paramzzh)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (paramLatLng != null)
            {
              localParcel.writeInt(1);
              paramLatLng.writeToParcel(localParcel, 0);
              if (paramPlaceFilter != null)
              {
                localParcel.writeInt(1);
                paramPlaceFilter.writeToParcel(localParcel, 0);
                if (paramPlacesParams == null)
                  break label135;
                localParcel.writeInt(1);
                paramPlacesParams.writeToParcel(localParcel, 0);
                paramLatLng = localObject;
                if (paramzzh != null)
                  paramLatLng = paramzzh.asBinder();
                localParcel.writeStrongBinder(paramLatLng);
                zznF.transact(4, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
          continue;
          label135: localParcel.writeInt(0);
        }
      }

      public void zza(LatLngBounds paramLatLngBounds, int paramInt, String paramString, PlaceFilter paramPlaceFilter, PlacesParams paramPlacesParams, zzh paramzzh)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (paramLatLngBounds != null)
            {
              localParcel.writeInt(1);
              paramLatLngBounds.writeToParcel(localParcel, 0);
              localParcel.writeInt(paramInt);
              localParcel.writeString(paramString);
              if (paramPlaceFilter != null)
              {
                localParcel.writeInt(1);
                paramPlaceFilter.writeToParcel(localParcel, 0);
                if (paramPlacesParams == null)
                  break label151;
                localParcel.writeInt(1);
                paramPlacesParams.writeToParcel(localParcel, 0);
                paramLatLngBounds = localObject;
                if (paramzzh != null)
                  paramLatLngBounds = paramzzh.asBinder();
                localParcel.writeStrongBinder(paramLatLngBounds);
                zznF.transact(2, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
          continue;
          label151: localParcel.writeInt(0);
        }
      }

      public void zza(String paramString, int paramInt1, int paramInt2, int paramInt3, PlacesParams paramPlacesParams, zzg paramzzg)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
          localParcel.writeString(paramString);
          localParcel.writeInt(paramInt1);
          localParcel.writeInt(paramInt2);
          localParcel.writeInt(paramInt3);
          if (paramPlacesParams != null)
          {
            localParcel.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            paramString = localObject;
            if (paramzzg != null)
              paramString = paramzzg.asBinder();
            localParcel.writeStrongBinder(paramString);
            zznF.transact(20, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramString;
      }

      public void zza(String paramString, int paramInt, PlacesParams paramPlacesParams, zzh paramzzh)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
          localParcel.writeString(paramString);
          localParcel.writeInt(paramInt);
          if (paramPlacesParams != null)
          {
            localParcel.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            paramString = localObject;
            if (paramzzh != null)
              paramString = paramzzh.asBinder();
            localParcel.writeStrongBinder(paramString);
            zznF.transact(18, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramString;
      }

      public void zza(String paramString, PlacesParams paramPlacesParams, zzg paramzzg)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
          localParcel.writeString(paramString);
          if (paramPlacesParams != null)
          {
            localParcel.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            paramString = localObject;
            if (paramzzg != null)
              paramString = paramzzg.asBinder();
            localParcel.writeStrongBinder(paramString);
            zznF.transact(19, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramString;
      }

      public void zza(String paramString, PlacesParams paramPlacesParams, zzh paramzzh)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
          localParcel.writeString(paramString);
          if (paramPlacesParams != null)
          {
            localParcel.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            paramString = localObject;
            if (paramzzh != null)
              paramString = paramzzh.asBinder();
            localParcel.writeStrongBinder(paramString);
            zznF.transact(3, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramString;
      }

      public void zza(String paramString, LatLngBounds paramLatLngBounds, AutocompleteFilter paramAutocompleteFilter, PlacesParams paramPlacesParams, zzh paramzzh)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            localParcel.writeString(paramString);
            if (paramLatLngBounds != null)
            {
              localParcel.writeInt(1);
              paramLatLngBounds.writeToParcel(localParcel, 0);
              if (paramAutocompleteFilter != null)
              {
                localParcel.writeInt(1);
                paramAutocompleteFilter.writeToParcel(localParcel, 0);
                if (paramPlacesParams == null)
                  break label144;
                localParcel.writeInt(1);
                paramPlacesParams.writeToParcel(localParcel, 0);
                paramString = localObject;
                if (paramzzh != null)
                  paramString = paramzzh.asBinder();
                localParcel.writeStrongBinder(paramString);
                zznF.transact(13, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
          continue;
          label144: localParcel.writeInt(0);
        }
      }

      public void zza(List<String> paramList, PlacesParams paramPlacesParams, zzh paramzzh)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
          localParcel.writeStringList(paramList);
          if (paramPlacesParams != null)
          {
            localParcel.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            paramList = localObject;
            if (paramzzh != null)
              paramList = paramzzh.asBinder();
            localParcel.writeStrongBinder(paramList);
            zznF.transact(7, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramList;
      }

      public void zzb(PlaceFilter paramPlaceFilter, PlacesParams paramPlacesParams, zzh paramzzh)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (paramPlaceFilter != null)
            {
              localParcel.writeInt(1);
              paramPlaceFilter.writeToParcel(localParcel, 0);
              if (paramPlacesParams != null)
              {
                localParcel.writeInt(1);
                paramPlacesParams.writeToParcel(localParcel, 0);
                paramPlaceFilter = localObject;
                if (paramzzh != null)
                  paramPlaceFilter = paramzzh.asBinder();
                localParcel.writeStrongBinder(paramPlaceFilter);
                zznF.transact(5, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
        }
      }

      public void zzb(PlacesParams paramPlacesParams, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (paramPlacesParams != null)
            {
              localParcel.writeInt(1);
              paramPlacesParams.writeToParcel(localParcel, 0);
              if (paramPendingIntent != null)
              {
                localParcel.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel, 0);
                zznF.transact(12, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
        }
      }

      public void zzb(String paramString, PlacesParams paramPlacesParams, zzh paramzzh)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
          localParcel.writeString(paramString);
          if (paramPlacesParams != null)
          {
            localParcel.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            paramString = localObject;
            if (paramzzh != null)
              paramString = paramzzh.asBinder();
            localParcel.writeStrongBinder(paramString);
            zznF.transact(6, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramString;
      }

      public void zzb(List<String> paramList, PlacesParams paramPlacesParams, zzh paramzzh)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
          localParcel.writeStringList(paramList);
          if (paramPlacesParams != null)
          {
            localParcel.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            paramList = localObject;
            if (paramzzh != null)
              paramList = paramzzh.asBinder();
            localParcel.writeStrongBinder(paramList);
            zznF.transact(17, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramList;
      }
    }
  }
}