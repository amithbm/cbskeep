package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzlk;

public final class zzc
{
  public static zzlk<Boolean> zzanT = zzlk.zzi("gms:common:stats:debug", false);
  public static zzlk<Integer> zzanU = zzlk.zza("gms:common:stats:max_num_of_events", Integer.valueOf(100));

  public static final class zza
  {
    public static zzlk<Integer> zzanV = zzlk.zza("gms:common:stats:connections:level", Integer.valueOf(zzd.zzaob));
    public static zzlk<String> zzanW = zzlk.zzz("gms:common:stats:connections:ignored_calling_processes", "");
    public static zzlk<String> zzanX = zzlk.zzz("gms:common:stats:connections:ignored_calling_services", "");
    public static zzlk<String> zzanY = zzlk.zzz("gms:common:stats:connections:ignored_target_processes", "");
    public static zzlk<String> zzanZ = zzlk.zzz("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
    public static zzlk<Long> zzaoa = zzlk.zza("gms:common:stats:connections:time_out_duration", Long.valueOf(600000L));
  }
}