package com.google.android.keep.model;

import com.google.android.keep.provider.i.g;
import java.util.LinkedHashMap;
import java.util.Map;

public class e
{
  private static final int[] uX = { 10724259, -10197916 };
  private static final int[] uY = { 14369847, -3662295 };
  private static final int[] uZ = { 16088064, -697856 };
  private static final int[] va = { 16036864, -26624 };
  private static final int[] vb = { 9159498, -16023485 };
  private static final int[] vc = { 31083, -16743846 };
  private static final int[] vd = { 4244735, -16611119 };
  private static final int[] ve = { 9479342, -8875618 };
  private static final Map<String, int[]> vf = new LinkedHashMap();

  static
  {
    vf.put(i.g.Co, uX);
    vf.put("RED", uY);
    vf.put("ORANGE", uZ);
    vf.put("YELLOW", va);
    vf.put("GREEN", vb);
    vf.put("TEAL", vc);
    vf.put("BLUE", vd);
    vf.put("GRAY", ve);
  }

  public static int[] H(String paramString)
  {
    return (int[])vf.get(paramString);
  }
}