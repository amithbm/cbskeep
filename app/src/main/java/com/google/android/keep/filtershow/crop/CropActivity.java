package com.google.android.keep.filtershow.crop;

import android.app.ActionBar;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.google.android.keep.h;
import com.google.android.keep.j;
import com.google.android.keep.util.e;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CropActivity extends FragmentActivity
{
  private c pO = null;
  private b pP = null;
  private int pQ = 0;
  private int pR = 0;
  private Bitmap pS = null;
  private RectF pT = null;
  private int pU = 0;
  private Uri pV = null;
  private CropView pW = null;
  private final View pX = null;
  private boolean pY = false;

  private void H(boolean paramBoolean)
  {
    if (pX != null)
      pX.setEnabled(paramBoolean);
  }

  protected static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if ((paramBitmap == null) || (paramBitmap.getWidth() == 0) || (paramBitmap.getHeight() == 0) || (paramInt < 16))
      throw new IllegalArgumentException("Bad argument to getDownsampledBitmap()");
    int j = 0;
    int i = d.a(paramBitmap);
    while (i > paramInt)
    {
      j += 1;
      i /= 4;
    }
    Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() >> j, paramBitmap.getHeight() >> j, true);
    if (localBitmap == null)
      paramBitmap = null;
    do
    {
      return paramBitmap;
      paramBitmap = localBitmap;
    }
    while (d.a(localBitmap) <= paramInt);
    return Bitmap.createScaledBitmap(localBitmap, localBitmap.getWidth() >> 1, localBitmap.getHeight() >> 1, true);
  }

  protected static Bitmap a(Bitmap paramBitmap, RectF paramRectF1, RectF paramRectF2)
  {
    paramRectF1 = d.a(paramRectF1, paramRectF2, new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight()));
    if (paramRectF1 == null)
      return null;
    paramRectF2 = new Rect();
    paramRectF1.roundOut(paramRectF2);
    return Bitmap.createBitmap(paramBitmap, paramRectF2.left, paramRectF2.top, paramRectF2.width(), paramRectF2.height());
  }

  private void a(int paramInt1, Bitmap paramBitmap, Uri paramUri1, Uri paramUri2, RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, String paramString, int paramInt2)
  {
    if ((paramRectF1 == null) || (paramRectF2 == null) || (paramBitmap == null) || (paramBitmap.getWidth() == 0) || (paramBitmap.getHeight() == 0) || (paramRectF1.width() == 0.0F) || (paramRectF1.height() == 0.0F) || (paramRectF2.width() == 0.0F) || (paramRectF2.height() == 0.0F));
    while ((paramInt1 & 0x6) == 0)
      return;
    findViewById(2131493136).setVisibility(0);
    new a(paramUri1, paramUri2, paramString, paramInt1, paramRectF1, paramRectF2, paramRectF3, paramInt2, pQ, pR).execute(new Bitmap[] { paramBitmap });
  }

  private void a(Bitmap paramBitmap, RectF paramRectF, int paramInt)
  {
    findViewById(2131493136).setVisibility(8);
    pS = paramBitmap;
    pT = paramRectF;
    pU = paramInt;
    if ((paramBitmap != null) && (paramBitmap.getWidth() != 0) && (paramBitmap.getHeight() != 0))
    {
      paramRectF = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
      pW.a(paramBitmap, paramRectF, paramRectF, paramInt);
      if (pO != null)
      {
        paramInt = pO.fr();
        int i = pO.fs();
        pQ = pO.fp();
        pR = pO.fq();
        if ((pQ > 0) && (pR > 0))
          pW.f(pQ, pR);
        if ((paramInt > 0) && (i > 0))
          pW.f(paramInt, i);
      }
      H(true);
      return;
    }
    Log.w("CropActivity", "could not load image for cropping");
    fm();
    setResult(0, new Intent());
    done();
  }

  private void a(boolean paramBoolean, Intent paramIntent)
  {
    findViewById(2131493136).setVisibility(8);
    if (paramBoolean)
      setResult(-1, paramIntent);
    while (true)
    {
      done();
      return;
      setResult(0, paramIntent);
    }
  }

  private void d(Uri paramUri)
  {
    if (paramUri != null)
    {
      H(false);
      findViewById(2131493136).setVisibility(0);
      pP = new b();
      pP.execute(new Uri[] { paramUri });
      return;
    }
    fm();
    done();
  }

  private void done()
  {
    finish();
  }

  private RectF e(RectF paramRectF)
  {
    RectF localRectF1 = pW.fB();
    RectF localRectF2 = pW.fC();
    if ((localRectF1 == null) || (localRectF2 == null))
    {
      Log.w("CropActivity", "could not get crop");
      return null;
    }
    return d.a(localRectF1, localRectF2, paramRectF);
  }

  protected static c f(Intent paramIntent)
  {
    boolean bool = true;
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      int i = paramIntent.getInt("outputX", 0);
      int j = paramIntent.getInt("outputY", 0);
      if ((paramIntent.getBoolean("scale", true)) && (paramIntent.getBoolean("scaleUpIfNeeded", false)));
      while (true)
      {
        return new c(i, j, bool, paramIntent.getInt("aspectX", 0), paramIntent.getInt("aspectY", 0), paramIntent.getBoolean("return-data", false), (Uri)paramIntent.getParcelable("output"), paramIntent.getString("outputFormat"), paramIntent.getBoolean("showWhenLocked", false), paramIntent.getFloat("spotlightX"), paramIntent.getFloat("spotlightY"));
        bool = false;
      }
    }
    return null;
  }

  private void fk()
  {
    Intent localIntent = new Intent();
    localIntent.setType("image/*");
    localIntent.setAction("android.intent.action.GET_CONTENT");
    startActivityForResult(Intent.createChooser(localIntent, getString(2131231322)), 8);
  }

  private int fl()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return Math.max(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels);
  }

  private void fm()
  {
    Toast.makeText(this, getString(2131231319), 0).show();
  }

  protected static Bitmap.CompressFormat q(String paramString)
  {
    if (paramString.equals("png"))
      return Bitmap.CompressFormat.PNG;
    return Bitmap.CompressFormat.JPEG;
  }

  protected static String r(String paramString)
  {
    if (paramString == null)
      paramString = "jpg";
    while (true)
    {
      paramString = paramString.toLowerCase();
      if ((!paramString.equals("png")) && (!paramString.equals("gif")))
        break;
      return "png";
    }
    return "jpg";
  }

  protected void fn()
  {
    if (pY)
      return;
    pY = true;
    H(false);
    RectF localRectF1 = null;
    Object localObject2 = null;
    int j = 0;
    int k = 0;
    int i = j;
    Object localObject1 = localRectF1;
    if (pS != null)
    {
      i = j;
      localObject1 = localRectF1;
      if (pO != null)
      {
        j = k;
        if (pO.fu() != null)
        {
          localObject1 = pO.fu();
          j = k;
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            j = 0x0 | 0x4;
            localObject2 = localObject1;
          }
        }
        i = j;
        localObject1 = localObject2;
        if (pO.ft())
        {
          i = j | 0x2;
          localObject1 = localObject2;
        }
      }
    }
    j = i;
    if (i == 0)
    {
      localObject2 = j.f(this, pV);
      j = i;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        j = i | 0x4;
        localObject1 = localObject2;
      }
    }
    if (((j & 0x6) != 0) && (pS != null))
    {
      localRectF1 = new RectF(0.0F, 0.0F, pS.getWidth(), pS.getHeight());
      RectF localRectF2 = e(localRectF1);
      Bitmap localBitmap = pS;
      Uri localUri = pV;
      RectF localRectF3 = pT;
      if (pO == null);
      for (localObject2 = null; ; localObject2 = pO.fv())
      {
        a(j, localBitmap, localUri, (Uri)localObject1, localRectF2, localRectF1, localRectF3, (String)localObject2, pU);
        return;
      }
    }
    setResult(0, new Intent());
    done();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 8)
    {
      if (paramInt2 == -1)
      {
        pV = paramIntent.getData();
        d(pV);
      }
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    pW.fE();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    setResult(0, new Intent());
    pO = f(paramBundle);
    if ((pO != null) && (pO.fw()))
      getWindow().addFlags(524288);
    setContentView(2130968644);
    pW = ((CropView)findViewById(2131493135));
    ActionBar localActionBar = getActionBar();
    if (localActionBar != null)
    {
      localActionBar.setDisplayOptions(16);
      localActionBar.setCustomView(2130968704);
      localActionBar.getCustomView().setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          fn();
        }
      });
    }
    if (paramBundle.getData() != null)
    {
      pV = paramBundle.getData();
      d(pV);
      return;
    }
    fk();
  }

  protected void onDestroy()
  {
    if (pP != null)
      pP.cancel(false);
    super.onDestroy();
  }

  private class a extends AsyncTask<Bitmap, Void, Boolean>
  {
    int mFlags = 0;
    InputStream qa = null;
    OutputStream qb = null;
    String qc = null;
    Uri qd = null;
    Uri qe = null;
    RectF qf = null;
    RectF qg = null;
    RectF qh = null;
    Intent qi = null;
    int qj = 0;

    static
    {
      if (!CropActivity.class.desiredAssertionStatus());
      for (boolean bool = true; ; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }

    public a(Uri paramUri1, Uri paramString, String paramInt1, int paramRectF1, RectF paramRectF2, RectF paramRectF3, RectF paramInt2, int paramInt3, int paramInt4, int arg11)
    {
      qc = paramInt1;
      qb = null;
      qd = paramString;
      qe = paramUri1;
      mFlags = paramRectF1;
      qf = paramRectF2;
      qg = paramRectF3;
      qh = paramInt2;
      qi = new Intent();
      int j = paramInt3;
      if (paramInt3 < 0)
        j = -paramInt3;
      qj = j;
      qj %= 360;
      qj = (qj / 90 * 90);
      CropActivity.a(CropActivity.this, paramInt4);
      int i;
      CropActivity.b(CropActivity.this, i);
      if ((paramRectF1 & 0x4) != 0)
      {
        if (qd != null)
          break label214;
        Log.w("CropActivity", "cannot write file, no output URI given");
      }
      while (true)
      {
        if ((paramRectF1 & 0x4) != 0)
          fo();
        return;
        try
        {
          label214: qb = getContentResolver().openOutputStream(qd);
        }
        catch (FileNotFoundException this$1)
        {
          Log.w("CropActivity", "cannot write file: " + qd.toString(), CropActivity.this);
        }
      }
    }

    private void fo()
    {
      if (qe == null)
      {
        Log.w("CropActivity", "cannot read original file, no input URI given");
        return;
      }
      e.e(qa);
      try
      {
        qa = getContentResolver().openInputStream(qe);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Log.w("CropActivity", "cannot read file: " + qe.toString(), localFileNotFoundException);
      }
    }

    protected Boolean a(Bitmap[] paramArrayOfBitmap)
    {
      int i = 0;
      paramArrayOfBitmap = paramArrayOfBitmap[0];
      Object localObject1;
      Object localObject3;
      if ((qf != null) && (qg != null) && (qh != null))
      {
        localObject1 = d.a(qf, qg, qh);
        localObject3 = new Matrix();
        ((Matrix)localObject3).setRotate(qj);
        ((Matrix)localObject3).mapRect((RectF)localObject1);
        if (localObject1 != null)
        {
          localObject3 = new Rect();
          ((RectF)localObject1).roundOut((Rect)localObject3);
          qi.putExtra("cropped-rect", (Parcelable)localObject3);
        }
      }
      int j = i;
      if ((mFlags & 0x2) != 0)
      {
        assert (paramArrayOfBitmap != null);
        localObject1 = CropActivity.a(paramArrayOfBitmap, qf, qg);
        paramArrayOfBitmap = (Bitmap[])localObject1;
        if (localObject1 != null)
          paramArrayOfBitmap = CropActivity.a((Bitmap)localObject1, 750000);
        if (paramArrayOfBitmap != null)
          break label230;
        Log.w("CropActivity", "could not downsample bitmap to return in data");
      }
      for (j = 1; ; j = i)
      {
        i = j;
        if ((mFlags & 0x4) == 0)
          break label800;
        i = j;
        if (qa == null)
          break label800;
        paramArrayOfBitmap = d.a(qf, qg, qh);
        if (paramArrayOfBitmap != null)
          break;
        Log.w("CropActivity", "cannot find crop for full size image");
        return Boolean.valueOf(false);
        label230: localObject1 = paramArrayOfBitmap;
        if (qj > 0)
        {
          localObject1 = new Matrix();
          ((Matrix)localObject1).setRotate(qj);
          localObject3 = Bitmap.createBitmap(paramArrayOfBitmap, 0, 0, paramArrayOfBitmap.getWidth(), paramArrayOfBitmap.getHeight(), (Matrix)localObject1, true);
          localObject1 = paramArrayOfBitmap;
          if (localObject3 != null)
            localObject1 = localObject3;
        }
        qi.putExtra("data", (Parcelable)localObject1);
      }
      Object localObject4 = new Rect();
      paramArrayOfBitmap.roundOut((Rect)localObject4);
      if ((((Rect)localObject4).width() <= 0) || (((Rect)localObject4).height() <= 0))
      {
        Log.w("CropActivity", "crop has bad values for full size image");
        return Boolean.valueOf(false);
      }
      paramArrayOfBitmap = null;
      try
      {
        localObject1 = BitmapRegionDecoder.newInstance(qa, true);
        paramArrayOfBitmap = (Bitmap[])localObject1;
        localObject1 = null;
        if (paramArrayOfBitmap != null)
        {
          localObject1 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject1).inMutable = true;
          localObject1 = paramArrayOfBitmap.decodeRegion((Rect)localObject4, (BitmapFactory.Options)localObject1);
          paramArrayOfBitmap.recycle();
        }
        paramArrayOfBitmap = (Bitmap[])localObject1;
        if (localObject1 == null)
        {
          fo();
          localObject3 = null;
          if (qa != null)
            localObject3 = BitmapFactory.decodeStream(qa);
          paramArrayOfBitmap = (Bitmap[])localObject1;
          if (localObject3 != null)
            paramArrayOfBitmap = Bitmap.createBitmap((Bitmap)localObject3, ((Rect)localObject4).left, ((Rect)localObject4).top, ((Rect)localObject4).width(), ((Rect)localObject4).height());
        }
        if (paramArrayOfBitmap == null)
        {
          Log.w("CropActivity", "cannot decode file: " + qe.toString());
          return Boolean.valueOf(false);
        }
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.w("CropActivity", "cannot open region decoder for file: " + qe.toString(), localIOException);
        if (CropActivity.b(CropActivity.this) <= 0)
          break label813;
      }
      Object localObject2;
      if (CropActivity.c(CropActivity.this) > 0)
      {
        localObject4 = new Matrix();
        localObject2 = new RectF(0.0F, 0.0F, paramArrayOfBitmap.getWidth(), paramArrayOfBitmap.getHeight());
        if (qj > 0)
        {
          ((Matrix)localObject4).setRotate(qj);
          ((Matrix)localObject4).mapRect((RectF)localObject2);
        }
        localObject3 = new RectF(0.0F, 0.0F, CropActivity.b(CropActivity.this), CropActivity.c(CropActivity.this));
        ((Matrix)localObject4).setRectToRect((RectF)localObject2, (RectF)localObject3, Matrix.ScaleToFit.FILL);
        ((Matrix)localObject4).preRotate(qj);
        localObject3 = Bitmap.createBitmap((int)((RectF)localObject3).width(), (int)((RectF)localObject3).height(), Bitmap.Config.ARGB_8888);
        localObject2 = paramArrayOfBitmap;
        if (localObject3 != null)
        {
          new Canvas((Bitmap)localObject3).drawBitmap(paramArrayOfBitmap, (Matrix)localObject4, new Paint());
          localObject2 = localObject3;
        }
        paramArrayOfBitmap = CropActivity.q(CropActivity.r(qc));
        if (mFlags != 4)
          break label893;
        if ((qb != null) && (((Bitmap)localObject2).compress(paramArrayOfBitmap, 90, qb)))
          break label876;
        Log.w("CropActivity", "failed to compress bitmap to file: " + qd.toString());
        i = 1;
        label800: if (i != 0)
          break label1055;
      }
      label1041: label1055: for (boolean bool = true; ; bool = false)
      {
        while (true)
        {
          return Boolean.valueOf(bool);
          label813: localObject2 = paramArrayOfBitmap;
          if (qj <= 0)
            break;
          localObject2 = new Matrix();
          ((Matrix)localObject2).setRotate(qj);
          localObject3 = Bitmap.createBitmap(paramArrayOfBitmap, 0, 0, paramArrayOfBitmap.getWidth(), paramArrayOfBitmap.getHeight(), (Matrix)localObject2, true);
          localObject2 = paramArrayOfBitmap;
          if (localObject3 == null)
            break;
          localObject2 = localObject3;
          break;
          label876: qi.setData(qd);
          i = j;
          break label800;
          label893: localObject3 = new ByteArrayOutputStream(2048);
          if (!((Bitmap)localObject2).compress(paramArrayOfBitmap, 90, (OutputStream)localObject3))
            break label1041;
          i = j;
          if ((mFlags & 0x4) == 0)
            break label800;
          if (qb == null)
          {
            Log.w("CropActivity", "failed to compress bitmap to file: " + qd.toString());
            i = 1;
            break label800;
          }
          try
          {
            qb.write(((ByteArrayOutputStream)localObject3).toByteArray());
            qi.setData(qd);
            i = j;
          }
          catch (IOException paramArrayOfBitmap)
          {
            Log.w("CropActivity", "failed to compress bitmap to file: " + qd.toString(), paramArrayOfBitmap);
            i = 1;
          }
        }
        break label800;
        Log.w("CropActivity", "cannot compress bitmap");
        i = 1;
        break label800;
      }
    }

    protected void a(Boolean paramBoolean)
    {
      e.a(qb);
      e.e(qa);
      CropActivity.a(CropActivity.this, paramBoolean.booleanValue(), qi);
    }
  }

  private class b extends AsyncTask<Uri, Void, Bitmap>
  {
    Context mContext = getApplicationContext();
    int mOrientation = 0;
    int qk = CropActivity.a(CropActivity.this);
    Rect ql = new Rect();

    public b()
    {
    }

    protected Bitmap a(Uri[] paramArrayOfUri)
    {
      paramArrayOfUri = paramArrayOfUri[0];
      Bitmap localBitmap = h.a(paramArrayOfUri, mContext, qk, ql, false);
      mOrientation = h.c(mContext, paramArrayOfUri);
      return localBitmap;
    }

    protected void onPostExecute(Bitmap paramBitmap)
    {
      CropActivity.a(CropActivity.this, paramBitmap, new RectF(ql), mOrientation);
    }
  }
}