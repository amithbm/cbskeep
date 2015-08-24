package com.google.api.client.http;

import com.google.api.client.util.ArrayValueMap;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.GenericData.Flags;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Throwables;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpHeaders extends GenericData
{

  @Key("Accept-Encoding")
  private List<String> acceptEncoding = new ArrayList(Collections.singleton("gzip"));

  @Key("Authorization")
  private List<String> authorization;

  @Key("Content-Encoding")
  private List<String> contentEncoding;

  @Key("Content-Length")
  private List<Long> contentLength;

  @Key("Content-Range")
  private List<String> contentRange;

  @Key("Content-Type")
  private List<String> contentType;

  @Key("If-Match")
  private List<String> ifMatch;

  @Key("If-Modified-Since")
  private List<String> ifModifiedSince;

  @Key("If-None-Match")
  private List<String> ifNoneMatch;

  @Key("If-Range")
  private List<String> ifRange;

  @Key("If-Unmodified-Since")
  private List<String> ifUnmodifiedSince;

  @Key("Location")
  private List<String> location;

  @Key("Range")
  private List<String> range;

  @Key("User-Agent")
  private List<String> userAgent;

  public HttpHeaders()
  {
    super(EnumSet.of(GenericData.Flags.IGNORE_CASE));
  }

  private static void addHeader(Logger paramLogger, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, LowLevelHttpRequest paramLowLevelHttpRequest, String paramString, Object paramObject, Writer paramWriter)
    throws IOException
  {
    if ((paramObject == null) || (Data.isNull(paramObject)));
    String str;
    do
    {
      return;
      str = toStringValue(paramObject);
      paramObject = str;
      Object localObject;
      if (!"Authorization".equalsIgnoreCase(paramString))
      {
        localObject = paramObject;
        if (!"Cookie".equalsIgnoreCase(paramString));
      }
      else if (paramLogger != null)
      {
        localObject = paramObject;
        if (paramLogger.isLoggable(Level.ALL));
      }
      else
      {
        localObject = "<Not Logged>";
      }
      if (paramStringBuilder1 != null)
      {
        paramStringBuilder1.append(paramString).append(": ");
        paramStringBuilder1.append((String)localObject);
        paramStringBuilder1.append(StringUtils.LINE_SEPARATOR);
      }
      if (paramStringBuilder2 != null)
        paramStringBuilder2.append(" -H '").append(paramString).append(": ").append((String)localObject).append("'");
      if (paramLowLevelHttpRequest != null)
        paramLowLevelHttpRequest.addHeader(paramString, str);
    }
    while (paramWriter == null);
    paramWriter.write(paramString);
    paramWriter.write(": ");
    paramWriter.write(str);
    paramWriter.write("\r\n");
  }

  private <T> List<T> getAsList(T paramT)
  {
    if (paramT == null)
      return null;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramT);
    return localArrayList;
  }

  private <T> T getFirstHeaderValue(List<T> paramList)
  {
    if (paramList == null)
      return null;
    return paramList.get(0);
  }

  private static Object parseValue(Type paramType, List<Type> paramList, String paramString)
  {
    return Data.parsePrimitiveValue(Data.resolveWildcardTypeOrTypeVariable(paramList, paramType), paramString);
  }

  static void serializeHeaders(HttpHeaders paramHttpHeaders, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, Logger paramLogger, LowLevelHttpRequest paramLowLevelHttpRequest)
    throws IOException
  {
    serializeHeaders(paramHttpHeaders, paramStringBuilder1, paramStringBuilder2, paramLogger, paramLowLevelHttpRequest, null);
  }

  static void serializeHeaders(HttpHeaders paramHttpHeaders, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, Logger paramLogger, LowLevelHttpRequest paramLowLevelHttpRequest, Writer paramWriter)
    throws IOException
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramHttpHeaders.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject2 = (String)((Map.Entry)localObject1).getKey();
      Preconditions.checkArgument(localHashSet.add(localObject2), "multiple headers of the same name (headers are case insensitive): %s", new Object[] { localObject2 });
      Object localObject3 = ((Map.Entry)localObject1).getValue();
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        localObject2 = paramHttpHeaders.getClassInfo().getFieldInfo((String)localObject2);
        if (localObject2 != null)
          localObject1 = ((FieldInfo)localObject2).getName();
        localObject2 = localObject3.getClass();
        if (((localObject3 instanceof Iterable)) || (((Class)localObject2).isArray()))
        {
          localObject2 = Types.iterableOf(localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
            addHeader(paramLogger, paramStringBuilder1, paramStringBuilder2, paramLowLevelHttpRequest, (String)localObject1, ((Iterator)localObject2).next(), paramWriter);
        }
        else
        {
          addHeader(paramLogger, paramStringBuilder1, paramStringBuilder2, paramLowLevelHttpRequest, (String)localObject1, localObject3, paramWriter);
        }
      }
    }
    if (paramWriter != null)
      paramWriter.flush();
  }

  public static void serializeHeadersForMultipartRequests(HttpHeaders paramHttpHeaders, StringBuilder paramStringBuilder, Logger paramLogger, Writer paramWriter)
    throws IOException
  {
    serializeHeaders(paramHttpHeaders, paramStringBuilder, null, paramLogger, null, paramWriter);
  }

  private static String toStringValue(Object paramObject)
  {
    if ((paramObject instanceof Enum))
      return FieldInfo.of((Enum)paramObject).getName();
    return paramObject.toString();
  }

  public HttpHeaders clone()
  {
    return (HttpHeaders)super.clone();
  }

  public final void fromHttpHeaders(HttpHeaders paramHttpHeaders)
  {
    try
    {
      ParseHeaderState localParseHeaderState = new ParseHeaderState(this, null);
      serializeHeaders(paramHttpHeaders, null, null, null, new HeaderParsingFakeLevelHttpRequest(this, localParseHeaderState));
      localParseHeaderState.finish();
      return;
    }
    catch (IOException paramHttpHeaders)
    {
    }
    throw Throwables.propagate(paramHttpHeaders);
  }

  public final void fromHttpResponse(LowLevelHttpResponse paramLowLevelHttpResponse, StringBuilder paramStringBuilder)
    throws IOException
  {
    clear();
    paramStringBuilder = new ParseHeaderState(this, paramStringBuilder);
    int j = paramLowLevelHttpResponse.getHeaderCount();
    int i = 0;
    while (i < j)
    {
      parseHeader(paramLowLevelHttpResponse.getHeaderName(i), paramLowLevelHttpResponse.getHeaderValue(i), paramStringBuilder);
      i += 1;
    }
    paramStringBuilder.finish();
  }

  public final String getContentType()
  {
    return (String)getFirstHeaderValue(contentType);
  }

  public final String getLocation()
  {
    return (String)getFirstHeaderValue(location);
  }

  public final String getRange()
  {
    return (String)getFirstHeaderValue(range);
  }

  public final String getUserAgent()
  {
    return (String)getFirstHeaderValue(userAgent);
  }

  void parseHeader(String paramString1, String paramString2, ParseHeaderState paramParseHeaderState)
  {
    Object localObject1 = paramParseHeaderState.context;
    Object localObject2 = paramParseHeaderState.classInfo;
    ArrayValueMap localArrayValueMap = paramParseHeaderState.arrayValueMap;
    paramParseHeaderState = paramParseHeaderState.logger;
    if (paramParseHeaderState != null)
      paramParseHeaderState.append(paramString1 + ": " + paramString2).append(StringUtils.LINE_SEPARATOR);
    localObject2 = ((ClassInfo)localObject2).getFieldInfo(paramString1);
    if (localObject2 != null)
    {
      Type localType = Data.resolveWildcardTypeOrTypeVariable((List)localObject1, ((FieldInfo)localObject2).getGenericType());
      if (Types.isArray(localType))
      {
        paramString1 = Types.getRawArrayComponentType((List)localObject1, Types.getArrayComponentType(localType));
        localArrayValueMap.put(((FieldInfo)localObject2).getField(), paramString1, parseValue(paramString1, (List)localObject1, paramString2));
        return;
      }
      if (Types.isAssignableToOrFrom(Types.getRawArrayComponentType((List)localObject1, localType), Iterable.class))
      {
        paramParseHeaderState = (Collection)((FieldInfo)localObject2).getValue(this);
        paramString1 = paramParseHeaderState;
        if (paramParseHeaderState == null)
        {
          paramString1 = Data.newCollectionInstance(localType);
          ((FieldInfo)localObject2).setValue(this, paramString1);
        }
        if (localType == Object.class);
        for (paramParseHeaderState = null; ; paramParseHeaderState = Types.getIterableParameter(localType))
        {
          paramString1.add(parseValue(paramParseHeaderState, (List)localObject1, paramString2));
          return;
        }
      }
      ((FieldInfo)localObject2).setValue(this, parseValue(localType, (List)localObject1, paramString2));
      return;
    }
    localObject1 = (ArrayList)get(paramString1);
    paramParseHeaderState = (ParseHeaderState)localObject1;
    if (localObject1 == null)
    {
      paramParseHeaderState = new ArrayList();
      set(paramString1, paramParseHeaderState);
    }
    paramParseHeaderState.add(paramString2);
  }

  public HttpHeaders set(String paramString, Object paramObject)
  {
    return (HttpHeaders)super.set(paramString, paramObject);
  }

  public HttpHeaders setAcceptEncoding(String paramString)
  {
    acceptEncoding = getAsList(paramString);
    return this;
  }

  public HttpHeaders setAuthorization(String paramString)
  {
    return setAuthorization(getAsList(paramString));
  }

  public HttpHeaders setAuthorization(List<String> paramList)
  {
    authorization = paramList;
    return this;
  }

  public HttpHeaders setContentEncoding(String paramString)
  {
    contentEncoding = getAsList(paramString);
    return this;
  }

  public HttpHeaders setContentLength(Long paramLong)
  {
    contentLength = getAsList(paramLong);
    return this;
  }

  public HttpHeaders setContentRange(String paramString)
  {
    contentRange = getAsList(paramString);
    return this;
  }

  public HttpHeaders setContentType(String paramString)
  {
    contentType = getAsList(paramString);
    return this;
  }

  public HttpHeaders setIfMatch(String paramString)
  {
    ifMatch = getAsList(paramString);
    return this;
  }

  public HttpHeaders setIfModifiedSince(String paramString)
  {
    ifModifiedSince = getAsList(paramString);
    return this;
  }

  public HttpHeaders setIfNoneMatch(String paramString)
  {
    ifNoneMatch = getAsList(paramString);
    return this;
  }

  public HttpHeaders setIfRange(String paramString)
  {
    ifRange = getAsList(paramString);
    return this;
  }

  public HttpHeaders setIfUnmodifiedSince(String paramString)
  {
    ifUnmodifiedSince = getAsList(paramString);
    return this;
  }

  public HttpHeaders setUserAgent(String paramString)
  {
    userAgent = getAsList(paramString);
    return this;
  }

  private static class HeaderParsingFakeLevelHttpRequest extends LowLevelHttpRequest
  {
    private final HttpHeaders.ParseHeaderState state;
    private final HttpHeaders target;

    HeaderParsingFakeLevelHttpRequest(HttpHeaders paramHttpHeaders, HttpHeaders.ParseHeaderState paramParseHeaderState)
    {
      target = paramHttpHeaders;
      state = paramParseHeaderState;
    }

    public void addHeader(String paramString1, String paramString2)
    {
      target.parseHeader(paramString1, paramString2, state);
    }

    public LowLevelHttpResponse execute()
      throws IOException
    {
      throw new UnsupportedOperationException();
    }
  }

  private static final class ParseHeaderState
  {
    final ArrayValueMap arrayValueMap;
    final ClassInfo classInfo;
    final List<Type> context;
    final StringBuilder logger;

    public ParseHeaderState(HttpHeaders paramHttpHeaders, StringBuilder paramStringBuilder)
    {
      Class localClass = paramHttpHeaders.getClass();
      context = Arrays.asList(new Type[] { localClass });
      classInfo = ClassInfo.of(localClass, true);
      logger = paramStringBuilder;
      arrayValueMap = new ArrayValueMap(paramHttpHeaders);
    }

    void finish()
    {
      arrayValueMap.setValues();
    }
  }
}