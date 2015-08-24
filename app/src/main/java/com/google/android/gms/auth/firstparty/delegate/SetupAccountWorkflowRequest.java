package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import java.util.List;

public class SetupAccountWorkflowRequest
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public String accountName;
  public final String accountType;
  public List<String> allowedDomains;
  public AccountAuthenticatorResponse amResponse;
  public final AppDescription callingAppDescription;
  public boolean isCreditCardAllowed;
  public boolean isMultiUser;
  public boolean isSetupWizard;
  public Bundle options;
  public String purchaserGaiaEmail;
  public String purchaserName;
  public boolean suppressD2d;
  public boolean useImmersiveMode;
  public final int version;

  public SetupAccountWorkflowRequest(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList, Bundle paramBundle, AppDescription paramAppDescription, boolean paramBoolean3, String paramString1, AccountAuthenticatorResponse paramAccountAuthenticatorResponse, boolean paramBoolean4, boolean paramBoolean5, String paramString2, String paramString3, String paramString4)
  {
    version = paramInt;
    isMultiUser = paramBoolean1;
    isSetupWizard = paramBoolean2;
    allowedDomains = paramList;
    options = paramBundle;
    callingAppDescription = ((AppDescription)zzv.zzz(paramAppDescription));
    isCreditCardAllowed = paramBoolean3;
    accountType = paramString1;
    amResponse = paramAccountAuthenticatorResponse;
    suppressD2d = paramBoolean4;
    useImmersiveMode = paramBoolean5;
    purchaserGaiaEmail = paramString2;
    purchaserName = paramString3;
    accountName = paramString4;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}