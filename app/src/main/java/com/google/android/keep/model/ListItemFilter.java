package com.google.android.keep.model;

public class ListItemFilter
{
  public static final ListItemFilter vY = new ListItemFilter(FilterType.we);
  public static final ListItemFilter vZ = new ListItemFilter(FilterType.wc);
  public static final ListItemFilter wa = new ListItemFilter(FilterType.wd);
  private final FilterType vX;

  public ListItemFilter(FilterType paramFilterType)
  {
    vX = paramFilterType;
  }

  public boolean g(ListItem paramListItem)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    switch (1.wb[vX.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unknown filter type");
    case 2:
      bool1 = paramListItem.isChecked();
    case 1:
    case 3:
    }
    do
    {
      return bool1;
      bool1 = bool2;
    }
    while (!paramListItem.isChecked());
    return false;
  }

  public static enum FilterType
  {
  }
}