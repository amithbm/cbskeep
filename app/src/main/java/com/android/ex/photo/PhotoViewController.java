package com.android.ex.photo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.android.ex.photo.adapters.PhotoPagerAdapter;
import com.android.ex.photo.fragments.PhotoViewFragment;
import com.android.ex.photo.loaders.PhotoBitmapLoader;
import com.android.ex.photo.loaders.PhotoBitmapLoaderInterface.BitmapResult;
import com.android.ex.photo.loaders.PhotoPagerLoader;
import com.android.ex.photo.util.ImageUtils;
import com.android.ex.photo.util.ImageUtils.ImageSize;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PhotoViewController
  implements LoaderManager.LoaderCallbacks<Cursor>, ViewPager.OnPageChangeListener, ActionBarInterface.OnMenuVisibilityListener, PhotoViewCallbacks, PhotoViewPager.OnInterceptTouchListener
{
  public static int sMaxPhotoSize;
  public static int sMemoryClass;
  protected boolean mActionBarHiddenInitially;
  protected String mActionBarSubtitle;
  protected String mActionBarTitle;
  private final ActivityInterface mActivity;
  protected PhotoPagerAdapter mAdapter;
  protected int mAlbumCount = -1;
  protected int mAnimationStartHeight;
  protected int mAnimationStartWidth;
  protected int mAnimationStartX;
  protected int mAnimationStartY;
  protected View mBackground;
  protected BitmapCallback mBitmapCallback;
  private int mCurrentPhotoIndex;
  private String mCurrentPhotoUri;
  private final Set<PhotoViewCallbacks.CursorChangedListener> mCursorListeners = new HashSet();
  protected boolean mDisplayThumbsFullScreen;
  private boolean mEnterAnimationFinished;
  private long mEnterFullScreenDelayTime;
  private final Runnable mEnterFullScreenRunnable = new Runnable()
  {
    public void run()
    {
      setFullScreen(true, true);
    }
  };
  protected boolean mFullScreen;
  protected final Handler mHandler = new Handler();
  private String mInitialPhotoUri;
  private boolean mIsDestroyedCompat;
  protected boolean mIsEmpty;
  protected boolean mIsPaused = true;
  private boolean mKickLoader;
  private int mLastFlags;
  protected float mMaxInitialScale;
  private String mPhotosUri;
  private String[] mProjection;
  protected View mRootView;
  protected boolean mScaleAnimationEnabled;
  private final Map<Integer, PhotoViewCallbacks.OnScreenListener> mScreenListeners = new HashMap();
  private final View.OnSystemUiVisibilityChangeListener mSystemUiVisibilityChangeListener;
  protected ImageView mTemporaryImage;
  protected PhotoViewPager mViewPager;

  public PhotoViewController(ActivityInterface paramActivityInterface)
  {
    mActivity = paramActivityInterface;
    if (Build.VERSION.SDK_INT < 11)
    {
      mSystemUiVisibilityChangeListener = null;
      return;
    }
    mSystemUiVisibilityChangeListener = new View.OnSystemUiVisibilityChangeListener()
    {
      public void onSystemUiVisibilityChange(int paramAnonymousInt)
      {
        if ((Build.VERSION.SDK_INT >= 19) && (paramAnonymousInt == 0) && (mLastFlags == 3846))
          setFullScreen(false, true);
      }
    };
  }

  private int calculateTranslate(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    return paramInt1 - Math.round((paramInt3 - paramInt3 * paramFloat) / 2.0F) - Math.round((paramInt3 * paramFloat - paramInt2) / 2.0F);
  }

  private void cancelEnterFullScreenRunnable()
  {
    mHandler.removeCallbacks(mEnterFullScreenRunnable);
  }

  private static final String getInputOrEmpty(String paramString)
  {
    String str = paramString;
    if (paramString == null)
      str = "";
    return str;
  }

  private void initMaxPhotoSize()
  {
    DisplayMetrics localDisplayMetrics;
    ImageUtils.ImageSize localImageSize;
    if (sMaxPhotoSize == 0)
    {
      localDisplayMetrics = new DisplayMetrics();
      WindowManager localWindowManager = (WindowManager)mActivity.getContext().getSystemService("window");
      localImageSize = ImageUtils.sUseImageSize;
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
    switch (8.$SwitchMap$com$android$ex$photo$util$ImageUtils$ImageSize[localImageSize.ordinal()])
    {
    default:
      sMaxPhotoSize = Math.min(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels);
      return;
    case 1:
    }
    sMaxPhotoSize = Math.min(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels) * 800 / 1000;
  }

  private void initTemporaryImage(final Drawable paramDrawable)
  {
    if (mEnterAnimationFinished)
      return;
    mTemporaryImage.setImageDrawable(paramDrawable);
    if (paramDrawable != null)
    {
      if (mRootView.getMeasuredWidth() != 0)
        break label69;
      paramDrawable = mRootView;
      paramDrawable.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public void onGlobalLayout()
        {
          if (Build.VERSION.SDK_INT >= 16)
            paramDrawable.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          while (true)
          {
            PhotoViewController.this.runEnterAnimation();
            return;
            paramDrawable.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          }
        }
      });
    }
    while (true)
    {
      mActivity.getSupportLoaderManager().initLoader(100, null, this);
      return;
      label69: runEnterAnimation();
    }
  }

  private boolean isDestroyedCompat()
  {
    return mIsDestroyedCompat;
  }

  private boolean kitkatIsSecondaryUser()
  {
    if (Build.VERSION.SDK_INT != 19)
      throw new IllegalStateException("kitkatIsSecondary user is only callable on KitKat");
    return Process.myUid() > 100000;
  }

  private void notifyCursorListeners(Cursor paramCursor)
  {
    try
    {
      Iterator localIterator = mCursorListeners.iterator();
      while (localIterator.hasNext())
        ((PhotoViewCallbacks.CursorChangedListener)localIterator.next()).onCursorChanged(paramCursor);
    }
    finally
    {
    }
  }

  private void onExitAnimationComplete()
  {
    mActivity.finish();
    mActivity.overridePendingTransition(0, 0);
  }

  private void postEnterFullScreenRunnableWithDelay()
  {
    mHandler.postDelayed(mEnterFullScreenRunnable, mEnterFullScreenDelayTime);
  }

  private void runEnterAnimation()
  {
    int i = mRootView.getMeasuredWidth();
    int j = mRootView.getMeasuredHeight();
    mTemporaryImage.setVisibility(0);
    float f = Math.max(mAnimationStartWidth / i, mAnimationStartHeight / j);
    i = calculateTranslate(mAnimationStartX, mAnimationStartWidth, i, f);
    j = calculateTranslate(mAnimationStartY, mAnimationStartHeight, j, f);
    int k = Build.VERSION.SDK_INT;
    if (k >= 14)
    {
      mBackground.setAlpha(0.0F);
      mBackground.animate().alpha(1.0F).setDuration(250L).start();
      mBackground.setVisibility(0);
      mTemporaryImage.setScaleX(f);
      mTemporaryImage.setScaleY(f);
      mTemporaryImage.setTranslationX(i);
      mTemporaryImage.setTranslationY(j);
      localObject1 = new Runnable()
      {
        public void run()
        {
          onEnterAnimationComplete();
        }
      };
      localObject2 = mTemporaryImage.animate().scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setDuration(250L);
      if (k >= 16)
        ((ViewPropertyAnimator)localObject2).withEndAction((Runnable)localObject1);
      while (true)
      {
        ((ViewPropertyAnimator)localObject2).start();
        return;
        mHandler.postDelayed((Runnable)localObject1, 250L);
      }
    }
    Object localObject1 = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject1).setDuration(250L);
    mBackground.startAnimation((Animation)localObject1);
    mBackground.setVisibility(0);
    localObject1 = new TranslateAnimation(i, j, 0.0F, 0.0F);
    ((Animation)localObject1).setDuration(250L);
    Object localObject2 = new ScaleAnimation(f, f, 0.0F, 0.0F);
    ((Animation)localObject2).setDuration(250L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation((Animation)localObject1);
    localAnimationSet.addAnimation((Animation)localObject2);
    localAnimationSet.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        onEnterAnimationComplete();
      }

      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
      }
    });
    mTemporaryImage.startAnimation(localAnimationSet);
  }

  private void runExitAnimation()
  {
    mActivity.getIntent();
    int i = mRootView.getMeasuredWidth();
    int j = mRootView.getMeasuredHeight();
    float f = Math.max(mAnimationStartWidth / i, mAnimationStartHeight / j);
    i = calculateTranslate(mAnimationStartX, mAnimationStartWidth, i, f);
    j = calculateTranslate(mAnimationStartY, mAnimationStartHeight, j, f);
    int k = Build.VERSION.SDK_INT;
    if (k >= 14)
    {
      mBackground.animate().alpha(0.0F).setDuration(250L).start();
      mBackground.setVisibility(0);
      Runnable local5 = new Runnable()
      {
        public void run()
        {
          PhotoViewController.this.onExitAnimationComplete();
        }
      };
      if (mTemporaryImage.getVisibility() == 0)
      {
        localObject = mTemporaryImage.animate().scaleX(f).scaleY(f).translationX(i).translationY(j).setDuration(250L);
        if (!mInitialPhotoUri.equals(mCurrentPhotoUri))
          ((ViewPropertyAnimator)localObject).alpha(0.0F);
        if (k < 16)
          break label247;
        ((ViewPropertyAnimator)localObject).withEndAction(local5);
      }
      while (true)
      {
        ((ViewPropertyAnimator)localObject).start();
        return;
        localObject = mViewPager.animate().scaleX(f).scaleY(f).translationX(i).translationY(j).setDuration(250L);
        break;
        label247: mHandler.postDelayed(local5, 250L);
      }
    }
    Object localObject = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject).setDuration(250L);
    mBackground.startAnimation((Animation)localObject);
    mBackground.setVisibility(0);
    localObject = new ScaleAnimation(1.0F, 1.0F, f, f);
    ((Animation)localObject).setDuration(250L);
    ((Animation)localObject).setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        PhotoViewController.this.onExitAnimationComplete();
      }

      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
      }
    });
    if (mTemporaryImage.getVisibility() == 0)
    {
      mTemporaryImage.startAnimation((Animation)localObject);
      return;
    }
    mViewPager.startAnimation((Animation)localObject);
  }

  public void addCursorListener(PhotoViewCallbacks.CursorChangedListener paramCursorChangedListener)
  {
    try
    {
      mCursorListeners.add(paramCursorChangedListener);
      return;
    }
    finally
    {
      paramCursorChangedListener = finally;
    }
    throw paramCursorChangedListener;
  }

  public void addScreenListener(int paramInt, PhotoViewCallbacks.OnScreenListener paramOnScreenListener)
  {
    mScreenListeners.put(Integer.valueOf(paramInt), paramOnScreenListener);
  }

  public PhotoPagerAdapter createPhotoPagerAdapter(Context paramContext, FragmentManager paramFragmentManager, Cursor paramCursor, float paramFloat)
  {
    return new PhotoPagerAdapter(paramContext, paramFragmentManager, paramCursor, paramFloat, mDisplayThumbsFullScreen);
  }

  protected View findViewById(int paramInt)
  {
    return mActivity.findViewById(paramInt);
  }

  public PhotoPagerAdapter getAdapter()
  {
    return mAdapter;
  }

  public Cursor getCursorAtProperPosition()
  {
    if (mViewPager == null)
      return null;
    int i = mViewPager.getCurrentItem();
    Cursor localCursor = mAdapter.getCursor();
    if (localCursor == null)
      return null;
    localCursor.moveToPosition(i);
    return localCursor;
  }

  public View getRootView()
  {
    return mRootView;
  }

  public View.OnSystemUiVisibilityChangeListener getSystemUiVisibilityChangeListener()
  {
    return mSystemUiVisibilityChangeListener;
  }

  public void hideActionBar()
  {
    mActivity.getActionBarInterface().hide();
  }

  public boolean isEnterAnimationFinished()
  {
    return mEnterAnimationFinished;
  }

  public boolean isFragmentActive(Fragment paramFragment)
  {
    if ((mViewPager == null) || (mAdapter == null));
    while (mViewPager.getCurrentItem() != mAdapter.getItemPosition(paramFragment))
      return false;
    return true;
  }

  public boolean isFragmentFullScreen(Fragment paramFragment)
  {
    if ((mViewPager == null) || (mAdapter == null) || (mAdapter.getCount() == 0))
      return mFullScreen;
    return (mFullScreen) || (mViewPager.getCurrentItem() != mAdapter.getItemPosition(paramFragment));
  }

  public boolean isScaleAnimationEnabled()
  {
    return mScaleAnimationEnabled;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  public boolean onBackPressed()
  {
    if ((mFullScreen) && (!mActionBarHiddenInitially))
      toggleFullScreen();
    while (true)
    {
      return true;
      if (!mScaleAnimationEnabled)
        break;
      runExitAnimation();
    }
    return false;
  }

  public void onCreate(Bundle paramBundle)
  {
    initMaxPhotoSize();
    sMemoryClass = ((ActivityManager)mActivity.getApplicationContext().getSystemService("activity")).getMemoryClass();
    Object localObject = mActivity.getIntent();
    if (((Intent)localObject).hasExtra("photos_uri"))
      mPhotosUri = ((Intent)localObject).getStringExtra("photos_uri");
    if (((Intent)localObject).getBooleanExtra("scale_up_animation", false))
    {
      mScaleAnimationEnabled = true;
      mAnimationStartX = ((Intent)localObject).getIntExtra("start_x_extra", 0);
      mAnimationStartY = ((Intent)localObject).getIntExtra("start_y_extra", 0);
      mAnimationStartWidth = ((Intent)localObject).getIntExtra("start_width_extra", 0);
      mAnimationStartHeight = ((Intent)localObject).getIntExtra("start_height_extra", 0);
    }
    mActionBarHiddenInitially = ((Intent)localObject).getBooleanExtra("action_bar_hidden_initially", false);
    mDisplayThumbsFullScreen = ((Intent)localObject).getBooleanExtra("display_thumbs_fullscreen", false);
    if (((Intent)localObject).hasExtra("projection"))
    {
      mProjection = ((Intent)localObject).getStringArrayExtra("projection");
      mMaxInitialScale = ((Intent)localObject).getFloatExtra("max_scale", 1.0F);
      mCurrentPhotoUri = null;
      mCurrentPhotoIndex = -1;
      if (((Intent)localObject).hasExtra("photo_index"))
        mCurrentPhotoIndex = ((Intent)localObject).getIntExtra("photo_index", -1);
      if (((Intent)localObject).hasExtra("initial_photo_uri"))
      {
        mInitialPhotoUri = ((Intent)localObject).getStringExtra("initial_photo_uri");
        mCurrentPhotoUri = mInitialPhotoUri;
      }
      mIsEmpty = true;
      if (paramBundle == null)
        break label619;
      mInitialPhotoUri = paramBundle.getString("com.android.ex.PhotoViewFragment.INITIAL_URI");
      mCurrentPhotoUri = paramBundle.getString("com.android.ex.PhotoViewFragment.CURRENT_URI");
      mCurrentPhotoIndex = paramBundle.getInt("com.android.ex.PhotoViewFragment.CURRENT_INDEX");
      mFullScreen = paramBundle.getBoolean("com.android.ex.PhotoViewFragment.FULLSCREEN", false);
      mActionBarTitle = paramBundle.getString("com.android.ex.PhotoViewFragment.ACTIONBARTITLE");
      mActionBarSubtitle = paramBundle.getString("com.android.ex.PhotoViewFragment.ACTIONBARSUBTITLE");
      mEnterAnimationFinished = paramBundle.getBoolean("com.android.ex.PhotoViewFragment.SCALEANIMATIONFINISHED", false);
      label329: mActivity.setContentView(R.layout.photo_activity_view);
      mAdapter = createPhotoPagerAdapter(mActivity.getContext(), mActivity.getSupportFragmentManager(), null, mMaxInitialScale);
      paramBundle = mActivity.getResources();
      mRootView = findViewById(R.id.photo_activity_root_view);
      if (Build.VERSION.SDK_INT >= 11)
        mRootView.setOnSystemUiVisibilityChangeListener(getSystemUiVisibilityChangeListener());
      mBackground = findViewById(R.id.photo_activity_background);
      mTemporaryImage = ((ImageView)findViewById(R.id.photo_activity_temporary_image));
      mViewPager = ((PhotoViewPager)findViewById(R.id.photo_view_pager));
      mViewPager.setAdapter(mAdapter);
      mViewPager.setOnPageChangeListener(this);
      mViewPager.setOnInterceptTouchListener(this);
      mViewPager.setPageMargin(paramBundle.getDimensionPixelSize(R.dimen.photo_page_margin));
      mBitmapCallback = new BitmapCallback(null);
      if ((mScaleAnimationEnabled) && (!mEnterAnimationFinished))
        break label630;
      mActivity.getSupportLoaderManager().initLoader(100, null, this);
      mBackground.setVisibility(0);
    }
    while (true)
    {
      mEnterFullScreenDelayTime = paramBundle.getInteger(R.integer.reenter_fullscreen_delay_time_in_millis);
      paramBundle = mActivity.getActionBarInterface();
      if (paramBundle != null)
      {
        paramBundle.setDisplayHomeAsUpEnabled(true);
        paramBundle.addOnMenuVisibilityListener(this);
        paramBundle.setDisplayOptionsShowTitle();
        setActionBarTitles(paramBundle);
      }
      if (mScaleAnimationEnabled)
        break label680;
      setLightsOutMode(mFullScreen);
      return;
      mProjection = null;
      break;
      label619: mFullScreen = mActionBarHiddenInitially;
      break label329;
      label630: mViewPager.setVisibility(8);
      localObject = new Bundle();
      ((Bundle)localObject).putString("image_uri", mInitialPhotoUri);
      mActivity.getSupportLoaderManager().initLoader(2, (Bundle)localObject, mBitmapCallback);
    }
    label680: setLightsOutMode(false);
  }

  public Loader<PhotoBitmapLoaderInterface.BitmapResult> onCreateBitmapLoader(int paramInt, Bundle paramBundle, String paramString)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
    case 2:
    case 3:
    }
    return new PhotoBitmapLoader(mActivity.getContext(), paramString);
  }

  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 100)
      return new PhotoPagerLoader(mActivity.getContext(), Uri.parse(mPhotosUri), mProjection);
    return null;
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return true;
  }

  public void onCursorChanged(PhotoViewFragment paramPhotoViewFragment, Cursor paramCursor)
  {
  }

  public void onDestroy()
  {
    mIsDestroyedCompat = true;
  }

  public void onEnterAnimationComplete()
  {
    mEnterAnimationFinished = true;
    mViewPager.setVisibility(0);
    setLightsOutMode(mFullScreen);
  }

  public void onFragmentPhotoLoadComplete(PhotoViewFragment paramPhotoViewFragment, boolean paramBoolean)
  {
    if ((mTemporaryImage.getVisibility() != 8) && (TextUtils.equals(paramPhotoViewFragment.getPhotoUri(), mCurrentPhotoUri)))
    {
      if (!paramBoolean)
        break label61;
      mTemporaryImage.setVisibility(8);
      mViewPager.setVisibility(0);
    }
    while (true)
    {
      mActivity.getSupportLoaderManager().destroyLoader(2);
      return;
      label61: Log.w("PhotoViewController", "Failed to load fragment image");
      mTemporaryImage.setVisibility(8);
      mViewPager.setVisibility(0);
    }
  }

  public void onFragmentVisible(PhotoViewFragment paramPhotoViewFragment)
  {
  }

  public void onLoadFinished(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    if (paramLoader.getId() == 100)
    {
      if ((paramCursor != null) && (paramCursor.getCount() != 0))
        break label41;
      mIsEmpty = true;
      mAdapter.swapCursor(null);
    }
    while (true)
    {
      updateActionItems();
      return;
      label41: mAlbumCount = paramCursor.getCount();
      int i;
      int j;
      if (mCurrentPhotoUri != null)
      {
        i = 0;
        j = paramCursor.getColumnIndex("uri");
        if (Build.VERSION.SDK_INT < 11)
          break label187;
        paramLoader = Uri.parse(mCurrentPhotoUri).buildUpon().clearQuery().build();
        paramCursor.moveToPosition(-1);
      }
      while (true)
      {
        if (paramCursor.moveToNext())
        {
          localObject = paramCursor.getString(j);
          if (Build.VERSION.SDK_INT < 11)
            break label208;
        }
        label187: label208: for (Object localObject = Uri.parse((String)localObject).buildUpon().clearQuery().build(); ; localObject = Uri.parse((String)localObject).buildUpon().query(null).build())
        {
          if ((paramLoader == null) || (!paramLoader.equals(localObject)))
            break label228;
          mCurrentPhotoIndex = i;
          if (!mIsPaused)
            break label235;
          mKickLoader = true;
          mAdapter.swapCursor(null);
          return;
          paramLoader = Uri.parse(mCurrentPhotoUri).buildUpon().query(null).build();
          break;
        }
        label228: i += 1;
      }
      label235: boolean bool = mIsEmpty;
      mIsEmpty = false;
      mAdapter.swapCursor(paramCursor);
      if (mViewPager.getAdapter() == null)
        mViewPager.setAdapter(mAdapter);
      notifyCursorListeners(paramCursor);
      if (mCurrentPhotoIndex < 0)
        mCurrentPhotoIndex = 0;
      mViewPager.setCurrentItem(mCurrentPhotoIndex, false);
      if (bool)
        setViewActivated(mCurrentPhotoIndex);
    }
  }

  public void onLoaderReset(Loader<Cursor> paramLoader)
  {
    if (!isDestroyedCompat())
      mAdapter.swapCursor(null);
  }

  public void onMenuVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      cancelEnterFullScreenRunnable();
      return;
    }
    postEnterFullScreenRunnableWithDelay();
  }

  public void onNewPhotoLoaded(int paramInt)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
    }
    mActivity.finish();
    return true;
  }

  public void onPageScrollStateChanged(int paramInt)
  {
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat < 0.0001D)
    {
      PhotoViewCallbacks.OnScreenListener localOnScreenListener = (PhotoViewCallbacks.OnScreenListener)mScreenListeners.get(Integer.valueOf(paramInt1 - 1));
      if (localOnScreenListener != null)
        localOnScreenListener.onViewUpNext();
      localOnScreenListener = (PhotoViewCallbacks.OnScreenListener)mScreenListeners.get(Integer.valueOf(paramInt1 + 1));
      if (localOnScreenListener != null)
        localOnScreenListener.onViewUpNext();
    }
  }

  public void onPageSelected(int paramInt)
  {
    mCurrentPhotoIndex = paramInt;
    setViewActivated(paramInt);
  }

  public void onPause()
  {
    mIsPaused = true;
  }

  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    return true;
  }

  public void onResume()
  {
    setFullScreen(mFullScreen, false);
    mIsPaused = false;
    if (mKickLoader)
    {
      mKickLoader = false;
      mActivity.getSupportLoaderManager().initLoader(100, null, this);
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putString("com.android.ex.PhotoViewFragment.INITIAL_URI", mInitialPhotoUri);
    paramBundle.putString("com.android.ex.PhotoViewFragment.CURRENT_URI", mCurrentPhotoUri);
    paramBundle.putInt("com.android.ex.PhotoViewFragment.CURRENT_INDEX", mCurrentPhotoIndex);
    paramBundle.putBoolean("com.android.ex.PhotoViewFragment.FULLSCREEN", mFullScreen);
    paramBundle.putString("com.android.ex.PhotoViewFragment.ACTIONBARTITLE", mActionBarTitle);
    paramBundle.putString("com.android.ex.PhotoViewFragment.ACTIONBARSUBTITLE", mActionBarSubtitle);
    paramBundle.putBoolean("com.android.ex.PhotoViewFragment.SCALEANIMATIONFINISHED", mEnterAnimationFinished);
  }

  public void onStart()
  {
  }

  public void onStop()
  {
  }

  public PhotoViewPager.InterceptType onTouchIntercept(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Iterator localIterator = mScreenListeners.values().iterator();
    while (localIterator.hasNext())
    {
      PhotoViewCallbacks.OnScreenListener localOnScreenListener = (PhotoViewCallbacks.OnScreenListener)localIterator.next();
      boolean bool3 = bool2;
      if (!bool2)
        bool3 = localOnScreenListener.onInterceptMoveLeft(paramFloat1, paramFloat2);
      bool2 = bool3;
      if (!bool1)
      {
        bool1 = localOnScreenListener.onInterceptMoveRight(paramFloat1, paramFloat2);
        bool2 = bool3;
      }
    }
    if (bool2)
    {
      if (bool1)
        return PhotoViewPager.InterceptType.BOTH;
      return PhotoViewPager.InterceptType.LEFT;
    }
    if (bool1)
      return PhotoViewPager.InterceptType.RIGHT;
    return PhotoViewPager.InterceptType.NONE;
  }

  public void removeCursorListener(PhotoViewCallbacks.CursorChangedListener paramCursorChangedListener)
  {
    try
    {
      mCursorListeners.remove(paramCursorChangedListener);
      return;
    }
    finally
    {
      paramCursorChangedListener = finally;
    }
    throw paramCursorChangedListener;
  }

  public void removeScreenListener(int paramInt)
  {
    mScreenListeners.remove(Integer.valueOf(paramInt));
  }

  protected final void setActionBarTitles(ActionBarInterface paramActionBarInterface)
  {
    if (paramActionBarInterface == null)
      return;
    paramActionBarInterface.setTitle(getInputOrEmpty(mActionBarTitle));
    paramActionBarInterface.setSubtitle(getInputOrEmpty(mActionBarSubtitle));
  }

  protected void setFullScreen(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1 != mFullScreen)
    {
      i = 1;
      mFullScreen = paramBoolean1;
      if (!mFullScreen)
        break label88;
      setLightsOutMode(true);
      cancelEnterFullScreenRunnable();
    }
    while (true)
    {
      if (i == 0)
        return;
      Iterator localIterator = mScreenListeners.values().iterator();
      while (localIterator.hasNext())
        ((PhotoViewCallbacks.OnScreenListener)localIterator.next()).onFullScreenChanged(mFullScreen);
      i = 0;
      break;
      label88: setLightsOutMode(false);
      if (paramBoolean2)
        postEnterFullScreenRunnableWithDelay();
    }
  }

  public void setImmersiveMode(boolean paramBoolean)
  {
    int k = 0;
    int i = 0;
    int m = Build.VERSION.SDK_INT;
    int j;
    if (m < 16)
    {
      j = 1;
      if ((!paramBoolean) || ((isScaleAnimationEnabled()) && (!isEnterAnimationFinished())))
        break label142;
      if ((m <= 19) && ((m != 19) || (kitkatIsSecondaryUser())))
        break label104;
      i = 3846;
    }
    while (true)
    {
      k = i;
      if (j != 0)
      {
        hideActionBar();
        k = i;
      }
      if (m >= 11)
      {
        mLastFlags = k;
        getRootView().setSystemUiVisibility(k);
      }
      return;
      j = 0;
      break;
      label104: if (m >= 16)
        i = 1285;
      else if (m >= 14)
        i = 1;
      else if (m >= 11)
        i = 1;
    }
    label142: if (m >= 19)
      i = 1792;
    while (true)
    {
      k = i;
      if (j == 0)
        break;
      showActionBar();
      k = i;
      break;
      if (m >= 16)
      {
        i = 1280;
      }
      else if (m >= 14)
      {
        i = 0;
      }
      else
      {
        i = k;
        if (m >= 11)
          i = 0;
      }
    }
  }

  protected void setLightsOutMode(boolean paramBoolean)
  {
    setImmersiveMode(paramBoolean);
  }

  public void setViewActivated(int paramInt)
  {
    Object localObject = (PhotoViewCallbacks.OnScreenListener)mScreenListeners.get(Integer.valueOf(paramInt));
    if (localObject != null)
      ((PhotoViewCallbacks.OnScreenListener)localObject).onViewActivated();
    localObject = getCursorAtProperPosition();
    mCurrentPhotoIndex = paramInt;
    mCurrentPhotoUri = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("uri"));
    updateActionBar();
    cancelEnterFullScreenRunnable();
    postEnterFullScreenRunnableWithDelay();
  }

  public void showActionBar()
  {
    mActivity.getActionBarInterface().show();
  }

  public void toggleFullScreen()
  {
    if (!mFullScreen);
    for (boolean bool = true; ; bool = false)
    {
      setFullScreen(bool, true);
      return;
    }
  }

  public void updateActionBar()
  {
    int j = mViewPager.getCurrentItem() + 1;
    int i;
    if (mAlbumCount >= 0)
    {
      i = 1;
      Cursor localCursor = getCursorAtProperPosition();
      if (localCursor == null)
        break label86;
      mActionBarTitle = localCursor.getString(localCursor.getColumnIndex("_display_name"));
      label47: if ((!mIsEmpty) && (i != 0) && (j > 0))
        break label94;
    }
    label86: label94: for (mActionBarSubtitle = null; ; mActionBarSubtitle = mActivity.getResources().getString(R.string.photo_view_count, new Object[] { Integer.valueOf(j), Integer.valueOf(mAlbumCount) }))
    {
      setActionBarTitles(mActivity.getActionBarInterface());
      return;
      i = 0;
      break;
      mActionBarTitle = null;
      break label47;
    }
  }

  public void updateActionItems()
  {
  }

  public static abstract interface ActivityInterface
  {
    public abstract View findViewById(int paramInt);

    public abstract void finish();

    public abstract ActionBarInterface getActionBarInterface();

    public abstract Context getApplicationContext();

    public abstract Context getContext();

    public abstract PhotoViewController getController();

    public abstract Intent getIntent();

    public abstract Resources getResources();

    public abstract FragmentManager getSupportFragmentManager();

    public abstract LoaderManager getSupportLoaderManager();

    public abstract void overridePendingTransition(int paramInt1, int paramInt2);

    public abstract void setContentView(int paramInt);
  }

  private class BitmapCallback
    implements LoaderManager.LoaderCallbacks<PhotoBitmapLoaderInterface.BitmapResult>
  {
    private BitmapCallback()
    {
    }

    public Loader<PhotoBitmapLoaderInterface.BitmapResult> onCreateLoader(int paramInt, Bundle paramBundle)
    {
      String str = paramBundle.getString("image_uri");
      switch (paramInt)
      {
      default:
        return null;
      case 2:
        return onCreateBitmapLoader(2, paramBundle, str);
      case 1:
      }
      return onCreateBitmapLoader(1, paramBundle, str);
    }

    public void onLoadFinished(Loader<PhotoBitmapLoaderInterface.BitmapResult> paramLoader, PhotoBitmapLoaderInterface.BitmapResult paramBitmapResult)
    {
      paramBitmapResult = paramBitmapResult.getDrawable(mActivity.getResources());
      ActionBarInterface localActionBarInterface = mActivity.getActionBarInterface();
      switch (paramLoader.getId())
      {
      default:
        return;
      case 2:
        PhotoViewController.this.initTemporaryImage(paramBitmapResult);
        return;
      case 1:
      }
      if (paramBitmapResult == null)
      {
        localActionBarInterface.setLogo(null);
        return;
      }
      localActionBarInterface.setLogo(paramBitmapResult);
    }

    public void onLoaderReset(Loader<PhotoBitmapLoaderInterface.BitmapResult> paramLoader)
    {
    }
  }
}