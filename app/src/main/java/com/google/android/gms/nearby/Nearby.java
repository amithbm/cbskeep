package com.google.android.gms.nearby;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqy;
import com.google.android.gms.nearby.bootstrap.zza;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesInternal;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.internal.zzg;
import com.google.android.gms.nearby.messages.internal.zzh;
import com.google.android.gms.nearby.sharing.Sharing;
import com.google.android.gms.nearby.sharing.internal.zzl;
import com.google.android.gms.nearby.sharing.internal.zzm;
import com.google.android.gms.nearby.sharing.zzd;

public final class Nearby
{
  public static final Api<Api.ApiOptions.NoOptions> CONNECTIONS_API = new Api("Nearby.CONNECTIONS_API", zzqy.CLIENT_BUILDER, zzqy.CLIENT_KEY, new Scope[0]);
  public static final Connections Connections = new zzqy();
  public static final Api<MessagesOptions> MESSAGES_API = new Api("Nearby.MESSAGES_API", zzg.CLIENT_BUILDER, zzg.CLIENT_KEY, new Scope[0]);
  public static final Messages Messages = new zzg();
  public static final MessagesInternal MessagesInternal = new zzh();
  public static final Api<Api.ApiOptions.NoOptions> SHARING_API = new Api("Nearby.SHARING_API", zzl.CLIENT_BUILDER, zzl.CLIENT_KEY, new Scope[0]);
  public static final Sharing Sharing = new zzl();
  public static final zzd zzbap = new zzm();
  public static final Api<Api.ApiOptions.NoOptions> zzbaq = new Api("Nearby.BOOTSTRAP_API", zzqq.CLIENT_BUILDER, zzqq.CLIENT_KEY, new Scope[0]);
  public static final zza zzbar = new zzqq();
}