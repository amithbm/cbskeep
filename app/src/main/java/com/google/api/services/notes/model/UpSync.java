package com.google.api.services.notes.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

public final class UpSync extends GenericJson
{

  @Key
  private DateTime clientTimestamp;

  @Key
  private List<Node> nodes;

  @Key
  private RequestHeader requestHeader;

  @Key
  private SharedNoteInvite sharedNoteInvite;

  @Key
  private String targetVersion;

  @Key
  private UserInfo userInfo;

  static
  {
    Data.nullOf(Node.class);
  }

  public UpSync clone()
  {
    return (UpSync)super.clone();
  }

  public List<Node> getNodes()
  {
    return nodes;
  }

  public String getTargetVersion()
  {
    return targetVersion;
  }

  public UpSync set(String paramString, Object paramObject)
  {
    return (UpSync)super.set(paramString, paramObject);
  }

  public UpSync setClientTimestamp(DateTime paramDateTime)
  {
    clientTimestamp = paramDateTime;
    return this;
  }

  public UpSync setNodes(List<Node> paramList)
  {
    nodes = paramList;
    return this;
  }

  public UpSync setRequestHeader(RequestHeader paramRequestHeader)
  {
    requestHeader = paramRequestHeader;
    return this;
  }

  public UpSync setSharedNoteInvite(SharedNoteInvite paramSharedNoteInvite)
  {
    sharedNoteInvite = paramSharedNoteInvite;
    return this;
  }

  public UpSync setTargetVersion(String paramString)
  {
    targetVersion = paramString;
    return this;
  }

  public UpSync setUserInfo(UserInfo paramUserInfo)
  {
    userInfo = paramUserInfo;
    return this;
  }

  public static final class RequestHeader extends GenericJson
  {

    @Key
    private List<Capabilities> capabilities;

    @Key
    private String clientLocale;

    @Key
    private String clientPlatform;

    @Key
    private String clientSessionId;

    @Key
    private ClientVersion clientVersion;

    static
    {
      Data.nullOf(Capabilities.class);
    }

    public RequestHeader clone()
    {
      return (RequestHeader)super.clone();
    }

    public RequestHeader set(String paramString, Object paramObject)
    {
      return (RequestHeader)super.set(paramString, paramObject);
    }

    public RequestHeader setCapabilities(List<Capabilities> paramList)
    {
      capabilities = paramList;
      return this;
    }

    public RequestHeader setClientLocale(String paramString)
    {
      clientLocale = paramString;
      return this;
    }

    public RequestHeader setClientPlatform(String paramString)
    {
      clientPlatform = paramString;
      return this;
    }

    public RequestHeader setClientSessionId(String paramString)
    {
      clientSessionId = paramString;
      return this;
    }

    public RequestHeader setClientVersion(ClientVersion paramClientVersion)
    {
      clientVersion = paramClientVersion;
      return this;
    }

    public static final class Capabilities extends GenericJson
    {

      @Key
      private String type;

      public Capabilities clone()
      {
        return (Capabilities)super.clone();
      }

      public Capabilities set(String paramString, Object paramObject)
      {
        return (Capabilities)super.set(paramString, paramObject);
      }

      public Capabilities setType(String paramString)
      {
        type = paramString;
        return this;
      }
    }

    public static final class ClientVersion extends GenericJson
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

      public ClientVersion clone()
      {
        return (ClientVersion)super.clone();
      }

      public ClientVersion set(String paramString, Object paramObject)
      {
        return (ClientVersion)super.set(paramString, paramObject);
      }

      public ClientVersion setBuild(Integer paramInteger)
      {
        build = paramInteger;
        return this;
      }

      public ClientVersion setMajor(Integer paramInteger)
      {
        major = paramInteger;
        return this;
      }

      public ClientVersion setMinor(Integer paramInteger)
      {
        minor = paramInteger;
        return this;
      }

      public ClientVersion setRevision(Long paramLong)
      {
        revision = paramLong;
        return this;
      }
    }
  }

  public static final class SharedNoteInvite extends GenericJson
  {

    @Key
    private String inviteToken;

    @Key
    private String nodeId;

    public SharedNoteInvite clone()
    {
      return (SharedNoteInvite)super.clone();
    }

    public SharedNoteInvite set(String paramString, Object paramObject)
    {
      return (SharedNoteInvite)super.set(paramString, paramObject);
    }

    public SharedNoteInvite setInviteToken(String paramString)
    {
      inviteToken = paramString;
      return this;
    }

    public SharedNoteInvite setNodeId(String paramString)
    {
      nodeId = paramString;
      return this;
    }
  }
}