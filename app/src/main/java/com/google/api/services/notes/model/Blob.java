package com.google.api.services.notes.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class Blob extends GenericJson
{

  @Key("byte_size")
  private Integer byteSize;

  @Key("extracted_text")
  private String extractedText;

  @Key("extraction_status")
  private String extractionStatus;

  @Key
  private Integer height;

  @Key
  private Integer length;

  @Key("media_id")
  private String mediaId;

  @Key
  private String mimetype;

  @Key
  private String type;

  @Key
  private Integer width;

  public Blob clone()
  {
    return (Blob)super.clone();
  }

  public Integer getByteSize()
  {
    return byteSize;
  }

  public String getExtractedText()
  {
    return extractedText;
  }

  public String getExtractionStatus()
  {
    return extractionStatus;
  }

  public Integer getHeight()
  {
    return height;
  }

  public Integer getLength()
  {
    return length;
  }

  public String getMediaId()
  {
    return mediaId;
  }

  public String getMimetype()
  {
    return mimetype;
  }

  public String getType()
  {
    return type;
  }

  public Integer getWidth()
  {
    return width;
  }

  public Blob set(String paramString, Object paramObject)
  {
    return (Blob)super.set(paramString, paramObject);
  }

  public Blob setByteSize(Integer paramInteger)
  {
    byteSize = paramInteger;
    return this;
  }

  public Blob setExtractedText(String paramString)
  {
    extractedText = paramString;
    return this;
  }

  public Blob setExtractionStatus(String paramString)
  {
    extractionStatus = paramString;
    return this;
  }

  public Blob setHeight(Integer paramInteger)
  {
    height = paramInteger;
    return this;
  }

  public Blob setLength(Integer paramInteger)
  {
    length = paramInteger;
    return this;
  }

  public Blob setMediaId(String paramString)
  {
    mediaId = paramString;
    return this;
  }

  public Blob setMimetype(String paramString)
  {
    mimetype = paramString;
    return this;
  }

  public Blob setType(String paramString)
  {
    type = paramString;
    return this;
  }

  public Blob setWidth(Integer paramInteger)
  {
    width = paramInteger;
    return this;
  }
}