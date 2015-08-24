package com.google.android.keep.editor;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.google.android.customzoomanimation.BitmapStorageInterface;
import com.google.android.customzoomanimation.ZoomingViewHelper;
import com.google.android.customzoomanimation.ZoomingViewHelper.ZoomingViewListener;
import com.google.android.keep.browse.d;
import com.google.android.keep.model.p;

public abstract class a extends p
  implements BitmapStorageInterface, ZoomingViewHelper.ZoomingViewListener
{
  protected static int kC;
  protected com.google.android.keep.activities.a kD;
  protected ZoomingViewHelper kE;
  protected View kF;
  private boolean kG = false;
  private boolean kH = false;
  private boolean mIsClosing = false;

  public abstract View df();

  protected boolean dg()
  {
    return kG;
  }

  protected void dh()
  {
    if (kE != null)
      kE.resetAnimationProperties();
  }

  protected void di()
  {
    mIsClosing = true;
    if ((kE != null) && (!kE.isFinished()))
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          if (!a.a(a.this))
            kE.finish();
        }
      }
      , kC);
  }

  public boolean dj()
  {
    return mIsClosing;
  }

  public void freeBitmap()
  {
    d.freeBitmap();
  }

  protected void g(Bundle paramBundle)
  {
    kE = new ZoomingViewHelper(paramBundle, (ImageView)kD.findViewById(2131493047), df(), kD, this);
    kE.setWidthScaleFactor(getResources().getInteger(2131361817));
    kE.setListener(this);
    kE.openView();
  }

  public Bitmap getBitmap()
  {
    return d.bW();
  }

  public Rect getBitmapDrawingRect()
  {
    return d.bX();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    kD = ((com.google.android.keep.activities.a)getActivity());
    kC = kD.getResources().getInteger(2131361823);
  }

  public void onCloseComplete()
  {
    mIsClosing = false;
  }

  public void onOpenComplete()
  {
    kG = true;
  }

  public void onPause()
  {
    if (kE != null)
      kE.onPause();
    kH = true;
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    kH = false;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (kE != null)
      kE.onSaveInstanceState(paramBundle);
    super.onSaveInstanceState(paramBundle);
  }
}