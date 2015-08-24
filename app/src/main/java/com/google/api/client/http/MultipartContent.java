package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MultipartContent extends AbstractHttpContent
{
  private ArrayList<Part> parts = new ArrayList();

  public MultipartContent()
  {
    super(new HttpMediaType("multipart/related").setParameter("boundary", "__END_OF_PART__"));
  }

  public MultipartContent addPart(Part paramPart)
  {
    parts.add(Preconditions.checkNotNull(paramPart));
    return this;
  }

  public final String getBoundary()
  {
    return getMediaType().getParameter("boundary");
  }

  public boolean retrySupported()
  {
    Iterator localIterator = parts.iterator();
    while (localIterator.hasNext())
      if (!((Part)localIterator.next()).content.retrySupported())
        return false;
    return true;
  }

  public MultipartContent setContentParts(Collection<? extends HttpContent> paramCollection)
  {
    parts = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
      addPart(new Part((HttpContent)paramCollection.next()));
    return this;
  }

  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramOutputStream, getCharset());
    String str = getBoundary();
    Iterator localIterator = parts.iterator();
    if (localIterator.hasNext())
    {
      Part localPart = (Part)localIterator.next();
      HttpHeaders localHttpHeaders = new HttpHeaders().setAcceptEncoding(null);
      if (localPart.headers != null)
        localHttpHeaders.fromHttpHeaders(localPart.headers);
      localHttpHeaders.setContentEncoding(null).setUserAgent(null).setContentType(null).setContentLength(null).set("Content-Transfer-Encoding", null);
      Object localObject1 = localPart.content;
      Object localObject2 = null;
      long l;
      if (localObject1 != null)
      {
        localHttpHeaders.set("Content-Transfer-Encoding", Arrays.asList(new String[] { "binary" }));
        localHttpHeaders.setContentType(((HttpContent)localObject1).getType());
        localObject2 = localPart.encoding;
        if (localObject2 != null)
          break label266;
        l = ((HttpContent)localObject1).getLength();
      }
      while (true)
      {
        localObject2 = localObject1;
        if (l != -1L)
        {
          localHttpHeaders.setContentLength(Long.valueOf(l));
          localObject2 = localObject1;
        }
        localOutputStreamWriter.write("--");
        localOutputStreamWriter.write(str);
        localOutputStreamWriter.write("\r\n");
        HttpHeaders.serializeHeadersForMultipartRequests(localHttpHeaders, null, null, localOutputStreamWriter);
        if (localObject2 == null)
          break;
        localOutputStreamWriter.write("\r\n");
        localOutputStreamWriter.flush();
        ((StreamingContent)localObject2).writeTo(paramOutputStream);
        localOutputStreamWriter.write("\r\n");
        break;
        label266: localHttpHeaders.setContentEncoding(((HttpEncoding)localObject2).getName());
        localObject2 = new HttpEncodingStreamingContent((StreamingContent)localObject1, (HttpEncoding)localObject2);
        l = AbstractHttpContent.computeLength((HttpContent)localObject1);
        localObject1 = localObject2;
      }
    }
    localOutputStreamWriter.write("--");
    localOutputStreamWriter.write(str);
    localOutputStreamWriter.write("--");
    localOutputStreamWriter.write("\r\n");
    localOutputStreamWriter.flush();
  }

  public static final class Part
  {
    HttpContent content;
    HttpEncoding encoding;
    HttpHeaders headers;

    public Part()
    {
      this(null);
    }

    public Part(HttpContent paramHttpContent)
    {
      this(null, paramHttpContent);
    }

    public Part(HttpHeaders paramHttpHeaders, HttpContent paramHttpContent)
    {
      setHeaders(paramHttpHeaders);
      setContent(paramHttpContent);
    }

    public Part setContent(HttpContent paramHttpContent)
    {
      content = paramHttpContent;
      return this;
    }

    public Part setHeaders(HttpHeaders paramHttpHeaders)
    {
      headers = paramHttpHeaders;
      return this;
    }
  }
}