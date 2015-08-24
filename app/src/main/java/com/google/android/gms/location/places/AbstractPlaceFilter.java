package com.google.android.gms.location.places;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractPlaceFilter
{
  static <E> List<E> zzl(Collection<E> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()))
      return Collections.emptyList();
    return new ArrayList(paramCollection);
  }

  static <E> Set<E> zzr(List<E> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
      return Collections.emptySet();
    return Collections.unmodifiableSet(new HashSet(paramList));
  }
}