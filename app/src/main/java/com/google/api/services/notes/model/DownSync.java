package com.google.api.services.notes.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class DownSync extends GenericJson
{

  @Key
  private String fromVersion;

  @Key
  private List<Node> nodes;

  @Key
  private ResponseHeader responseHeader;

  @Key
  private String toVersion;

  @Key
  private Boolean truncated;

  @Key
  private UserInfo userInfo;

  static
  {
    Data.nullOf(Node.class);
  }

  public DownSync clone()
  {
    return (DownSync)super.clone();
  }

  public String getFromVersion()
  {
    return fromVersion;
  }

  public List<Node> getNodes()
  {
    return nodes;
  }

  public ResponseHeader getResponseHeader()
  {
    return responseHeader;
  }

  public String getToVersion()
  {
    return toVersion;
  }

  public Boolean getTruncated()
  {
    return truncated;
  }

  public UserInfo getUserInfo()
  {
    return userInfo;
  }

  public DownSync set(String paramString, Object paramObject)
  {
    return (DownSync)super.set(paramString, paramObject);
  }

  public DownSync setNodes(List<Node> paramList)
  {
    nodes = paramList;
    return this;
  }

  public DownSync setToVersion(String paramString)
  {
    toVersion = paramString;
    return this;
  }

  public DownSync setUserInfo(UserInfo paramUserInfo)
  {
    userInfo = paramUserInfo;
    return this;
  }

  public static final class ResponseHeader extends GenericJson
  {

    @Key
    private LatestClientVersion latestClientVersion;

    @Key
    private String updateState;

    public ResponseHeader clone()
    {
      return (ResponseHeader)super.clone();
    }

    public LatestClientVersion getLatestClientVersion()
    {
      return latestClientVersion;
    }

    public String getUpdateState()
    {
      return updateState;
    }

    public ResponseHeader set(String paramString, Object paramObject)
    {
      return (ResponseHeader)super.set(paramString, paramObject);
    }

    public static final class LatestClientVersion extends GenericJson
    {

      @Key
      private Integer build;

      @Key
      private Integer major;

      @Key
      private Integer minor;

      @JsonString
      @Key
      private Long revision;

      public LatestClientVersion clone()
      {
        return (LatestClientVersion)super.clone();
      }

      public Integer getBuild()
      {
        return build;
      }

      public Integer getMajor()
      {
        return major;
      }

      public Integer getMinor()
      {
        return minor;
      }

      public Long getRevision()
      {
        return revision;
      }

      public LatestClientVersion set(String paramString, Object paramObject)
      {
        return (LatestClientVersion)super.set(paramString, paramObject);
      }
    }
  }
}