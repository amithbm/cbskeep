package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.FacebookSignInConfig;
import com.google.android.gms.auth.api.signin.IdProvider;
import com.google.android.gms.auth.api.signin.SignInInfo;
import com.google.android.gms.internal.zzki;
import com.google.android.gms.internal.zzki.zza;
import com.google.android.gms.internal.zzkk;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class SignInHubActivity extends Activity
{
  private zzk zzRC;
  private zzg zzRD;
  private Configuration zzRE;
  private String zzRF;

  private void zzd(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("errorCode", paramInt);
    localIntent.putExtra("errorMessage", paramString);
    setResult(0, localIntent);
    finish();
  }

  private void zzj(Intent paramIntent)
  {
    paramIntent.setPackage("com.google.android.gms");
    paramIntent.putExtra("config", zzRE);
    paramIntent.putExtra("signInInfo", zzRC.zzlb());
    startActivityForResult(paramIntent, 40961);
  }

  private zzki.zza zzkZ()
  {
    return new zzki.zza()
    {
      public void zza(Exception paramAnonymousException)
      {
        if ((paramAnonymousException == null) || (paramAnonymousException.getMessage() == null));
        for (paramAnonymousException = ""; ; paramAnonymousException = " " + paramAnonymousException.getMessage())
        {
          SignInHubActivity.zza(SignInHubActivity.this, 4, "Idp signin failed!" + paramAnonymousException);
          return;
        }
      }

      public void zzk(Intent paramAnonymousIntent)
      {
        if (paramAnonymousIntent != null)
        {
          SignInHubActivity.zza(SignInHubActivity.this, paramAnonymousIntent);
          return;
        }
        SignInHubActivity.zza(SignInHubActivity.this, 4, "Idp signin failed!");
      }

      public void zzla()
      {
        setResult(0);
        finish();
      }
    };
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    setResult(0);
    Object localObject1;
    if (paramInt1 == 40961)
      if (paramInt2 == -1)
      {
        localObject1 = (SignInInfo)paramIntent.getParcelableExtra("signInInfo");
        if (localObject1 != null)
        {
          zzRC.zza((SignInInfo)localObject1);
          setResult(-1, paramIntent);
          finish();
        }
      }
    do
    {
      return;
      zzd(2, "SignInInfo is null.");
      return;
      if (paramIntent == null)
      {
        finish();
        return;
      }
      localObject1 = paramIntent.getStringExtra("email");
      IdProvider localIdProvider = IdProvider.fromProviderId(paramIntent.getStringExtra("idProvider"));
      if (localIdProvider == null)
      {
        setResult(paramInt2, paramIntent);
        finish();
        return;
      }
      zzRF = paramIntent.getStringExtra("pendingToken");
      if ((IdProvider.FACEBOOK.equals(localIdProvider)) && (zzRE.zzkW() != null))
      {
        localObject2 = zzRE.zzkW().getCustomFacebookSignInActivityIntent();
        if (localObject2 != null)
        {
          startActivityForResult((Intent)localObject2, 45057);
          return;
        }
      }
      Object localObject2 = zzRD.zza(localIdProvider);
      if (localObject2 == null)
      {
        paramIntent = localIdProvider.getDisplayName(this);
        zzd(1, paramIntent + " is not supported. Please check your configuration");
        return;
      }
      paramInt1 = paramIntent.getIntExtra("userProfile", -1);
      if (paramInt1 == 0)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          ((zzki)localObject2).zza(zzkZ());
          return;
        }
        ((zzki)localObject2).zza((String)localObject1, zzkZ());
        return;
      }
      if ((paramInt1 == 1) && (!TextUtils.isEmpty(zzRF)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        ((zzki)localObject2).zza((String)localObject1, zzRF, zzkZ());
        return;
      }
      zzd(2, "Internal error!");
      return;
      if (paramInt1 == 45057)
      {
        if (paramInt2 == 0)
        {
          setResult(0, paramIntent);
          finish();
          return;
        }
        localObject1 = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        ((Intent)localObject1).putExtra("idpTokenType", IdpTokenType.zzRv);
        ((Intent)localObject1).putExtra("idpToken", paramIntent.getStringExtra("idpToken"));
        ((Intent)localObject1).putExtra("pendingToken", zzRF);
        ((Intent)localObject1).putExtra("idProvider", IdProvider.FACEBOOK.getProviderId());
        zzj((Intent)localObject1);
        return;
      }
      localObject1 = zzRD.zzkY().iterator();
      while ((((Iterator)localObject1).hasNext()) && (!((zzki)((Iterator)localObject1).next()).zza(paramInt1, paramInt2, paramIntent, zzkZ())));
    }
    while (paramInt2 != 0);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    zzRC = new zzk(getApplicationContext());
    zzRE = ((Configuration)getIntent().getParcelableExtra("config"));
    if (zzRE == null)
      throw new RuntimeException("No configuration found!");
    LinkedList localLinkedList = new LinkedList();
    HashMap localHashMap = new HashMap();
    zzd.zza(zzRE, localLinkedList, localHashMap);
    zzRD = new zzg(this, localLinkedList, localHashMap);
    if (zzRE.zzkW() != null)
      ((zzkk)zzRD.zza(IdProvider.FACEBOOK)).zzaa(this);
    if (paramBundle == null)
    {
      zzj(new Intent("com.google.android.gms.auth.LOGIN_PICKER"));
      return;
    }
    zzRF = paramBundle.getString("pendingToken");
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("pendingToken", zzRF);
  }
}