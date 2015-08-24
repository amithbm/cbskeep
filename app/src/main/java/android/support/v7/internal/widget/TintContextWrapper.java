package android.support.v7.internal.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;

public class TintContextWrapper extends ContextWrapper
{
  private Resources mResources;

  private TintContextWrapper(Context paramContext)
  {
    super(paramContext);
  }

  public static Context wrap(Context paramContext)
  {
    Object localObject = paramContext;
    if (!(paramContext instanceof TintContextWrapper))
      localObject = new TintContextWrapper(paramContext);
    return localObject;
  }

  public Resources getResources()
  {
    if (mResources == null)
      mResources = new TintResources(super.getResources(), TintManager.get(this));
    return mResources;
  }

  static class TintResources extends ResourcesWrapper
  {
    private final TintManager mTintManager;

    public TintResources(Resources paramResources, TintManager paramTintManager)
    {
      super();
      mTintManager = paramTintManager;
    }

    public Drawable getDrawable(int paramInt)
      throws Resources.NotFoundException
    {
      Drawable localDrawable = super.getDrawable(paramInt);
      if (localDrawable != null)
        mTintManager.tintDrawableUsingColorFilter(paramInt, localDrawable);
      return localDrawable;
    }
  }
}