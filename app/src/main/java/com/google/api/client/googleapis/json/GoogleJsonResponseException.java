package com.google.api.client.googleapis.json;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseException.Builder;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Strings;
import java.io.IOException;

public class GoogleJsonResponseException extends HttpResponseException
{
  private static final long serialVersionUID = 409811126989994864L;
  private final transient GoogleJsonError details;

  GoogleJsonResponseException(HttpResponseException.Builder paramBuilder, GoogleJsonError paramGoogleJsonError)
  {
    super(paramBuilder);
    details = paramGoogleJsonError;
  }

  public static GoogleJsonResponseException from(JsonFactory paramJsonFactory, HttpResponse paramHttpResponse)
  {
    HttpResponseException.Builder localBuilder = new HttpResponseException.Builder(paramHttpResponse.getStatusCode(), paramHttpResponse.getStatusMessage(), paramHttpResponse.getHeaders());
    Preconditions.checkNotNull(paramJsonFactory);
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject12 = null;
    Object localObject13 = null;
    Object localObject10 = null;
    Object localObject9 = null;
    Object localObject8 = null;
    Object localObject11 = null;
    Object localObject6 = localObject8;
    Object localObject2 = localObject3;
    try
    {
      if (!paramHttpResponse.isSuccessStatusCode())
      {
        localObject6 = localObject8;
        localObject2 = localObject3;
        if (HttpMediaType.equalsIgnoreParameters(Json.MEDIA_TYPE, paramHttpResponse.getContentType()))
        {
          localObject6 = localObject8;
          localObject2 = localObject3;
          localObject4 = paramHttpResponse.getContent();
          if (localObject4 != null)
          {
            localObject7 = null;
            localObject5 = null;
            localObject1 = localObject12;
            localObject3 = localObject13;
          }
        }
      }
    }
    catch (IOException paramJsonFactory)
    {
      while (true)
      {
        Object localObject7;
        try
        {
          JsonParser localJsonParser = paramJsonFactory.createJsonParser(paramHttpResponse.getContent());
          localObject1 = localObject12;
          localObject5 = localJsonParser;
          localObject3 = localObject13;
          localObject7 = localJsonParser;
          paramJsonFactory = localJsonParser.getCurrentToken();
          localObject1 = paramJsonFactory;
          if (paramJsonFactory == null)
          {
            localObject1 = localObject12;
            localObject5 = localJsonParser;
            localObject3 = localObject13;
            localObject7 = localJsonParser;
            paramJsonFactory = localJsonParser.nextToken();
            localObject1 = paramJsonFactory;
          }
          Object localObject4 = localObject11;
          paramJsonFactory = localObject10;
          if (localObject1 != null)
          {
            localObject1 = localObject12;
            localObject5 = localJsonParser;
            localObject3 = localObject13;
            localObject7 = localJsonParser;
            localJsonParser.skipToKey("error");
            localObject4 = localObject11;
            paramJsonFactory = localObject10;
            localObject1 = localObject12;
            localObject5 = localJsonParser;
            localObject3 = localObject13;
            localObject7 = localJsonParser;
            if (localJsonParser.getCurrentToken() != JsonToken.END_OBJECT)
            {
              localObject1 = localObject12;
              localObject5 = localJsonParser;
              localObject3 = localObject13;
              localObject7 = localJsonParser;
              paramJsonFactory = (GoogleJsonError)localJsonParser.parseAndClose(GoogleJsonError.class);
              localObject1 = paramJsonFactory;
              localObject5 = localJsonParser;
              localObject3 = paramJsonFactory;
              localObject7 = localJsonParser;
              localObject4 = paramJsonFactory.toPrettyString();
            }
          }
          if (localJsonParser == null)
          {
            localObject6 = localObject4;
            localObject2 = paramJsonFactory;
            paramHttpResponse.ignore();
            localObject2 = paramJsonFactory;
            localObject3 = localObject4;
            paramJsonFactory = HttpResponseException.computeMessageBuffer(paramHttpResponse);
            if (!Strings.isNullOrEmpty((String)localObject3))
            {
              paramJsonFactory.append(StringUtils.LINE_SEPARATOR).append((String)localObject3);
              localBuilder.setContent((String)localObject3);
            }
            localBuilder.setMessage(paramJsonFactory.toString());
            return new GoogleJsonResponseException(localBuilder, (GoogleJsonError)localObject2);
          }
          localObject3 = localObject4;
          localObject2 = paramJsonFactory;
          if (paramJsonFactory != null)
            continue;
          localObject6 = localObject4;
          localObject2 = paramJsonFactory;
          localJsonParser.close();
          localObject3 = localObject4;
          localObject2 = paramJsonFactory;
          continue;
          paramJsonFactory = paramJsonFactory;
          paramJsonFactory.printStackTrace();
          localObject3 = localObject6;
          continue;
        }
        catch (IOException paramJsonFactory)
        {
          Object localObject5;
          localObject3 = localObject1;
          localObject7 = localObject5;
          paramJsonFactory.printStackTrace();
          if (localObject5 == null)
          {
            localObject6 = localObject8;
            localObject2 = localObject1;
            paramHttpResponse.ignore();
            localObject3 = localObject9;
            localObject2 = localObject1;
            continue;
          }
          localObject3 = localObject9;
          localObject2 = localObject1;
          if (localObject1 != null)
            continue;
          localObject6 = localObject8;
          localObject2 = localObject1;
          localObject5.close();
          localObject3 = localObject9;
          localObject2 = localObject1;
          continue;
        }
        finally
        {
          if (localObject7 != null)
            break label495;
        }
        localObject6 = localObject8;
        localObject2 = localObject3;
        paramHttpResponse.ignore();
        while (true)
        {
          localObject6 = localObject8;
          localObject2 = localObject3;
          throw paramJsonFactory;
          label495: if (localObject3 == null)
          {
            localObject6 = localObject8;
            localObject2 = localObject3;
            localObject7.close();
          }
        }
        localObject6 = localObject8;
        localObject2 = localObject3;
        localObject3 = paramHttpResponse.parseAsString();
        localObject2 = localObject1;
      }
    }
  }
}