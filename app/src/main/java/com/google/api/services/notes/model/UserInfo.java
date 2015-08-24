package com.google.api.services.notes.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

public final class UserInfo extends GenericJson
{

  @Key
  private List<Labels> labels;

  static
  {
    Data.nullOf(Labels.class);
  }

  public UserInfo clone()
  {
    return (UserInfo)super.clone();
  }

  public List<Labels> getLabels()
  {
    return labels;
  }

  public UserInfo set(String paramString, Object paramObject)
  {
    return (UserInfo)super.set(paramString, paramObject);
  }

  public UserInfo setLabels(List<Labels> paramList)
  {
    labels = paramList;
    return this;
  }

  public static final class Labels extends GenericJson
  {

    @Key
    private DateTime lastMerged;

    @Key
    private String mainId;

    @Key
    private List<String> mergedIds;

    @Key
    private String name;

    @JsonString
    @Key
    private Long revision;

    @Key
    private Timestamps timestamps;

    public Labels clone()
    {
      return (Labels)super.clone();
    }

    public DateTime getLastMerged()
    {
      return lastMerged;
    }

    public String getMainId()
    {
      return mainId;
    }

    public List<String> getMergedIds()
    {
      return mergedIds;
    }

    public String getName()
    {
      return name;
    }

    public Long getRevision()
    {
      return revision;
    }

    public Timestamps getTimestamps()
    {
      return timestamps;
    }

    public Labels set(String paramString, Object paramObject)
    {
      return (Labels)super.set(paramString, paramObject);
    }

    public Labels setLastMerged(DateTime paramDateTime)
    {
      lastMerged = paramDateTime;
      return this;
    }

    public Labels setMainId(String paramString)
    {
      mainId = paramString;
      return this;
    }

    public Labels setMergedIds(List<String> paramList)
    {
      mergedIds = paramList;
      return this;
    }

    public Labels setName(String paramString)
    {
      name = paramString;
      return this;
    }

    public Labels setRevision(Long paramLong)
    {
      revision = paramLong;
      return this;
    }

    public Labels setTimestamps(Timestamps paramTimestamps)
    {
      timestamps = paramTimestamps;
      return this;
    }

    public static final class Timestamps extends GenericJson
    {

      @Key
      private DateTime created;

      @Key
      private DateTime deleted;

      @Key
      private DateTime updated;

      @Key
      private DateTime userEdited;

      public Timestamps clone()
      {
        return (Timestamps)super.clone();
      }

      public DateTime getCreated()
      {
        return created;
      }

      public DateTime getDeleted()
      {
        return deleted;
      }

      public DateTime getUpdated()
      {
        return updated;
      }

      public DateTime getUserEdited()
      {
        return userEdited;
      }

      public Timestamps set(String paramString, Object paramObject)
      {
        return (Timestamps)super.set(paramString, paramObject);
      }

      public Timestamps setCreated(DateTime paramDateTime)
      {
        created = paramDateTime;
        return this;
      }

      public Timestamps setDeleted(DateTime paramDateTime)
      {
        deleted = paramDateTime;
        return this;
      }

      public Timestamps setUpdated(DateTime paramDateTime)
      {
        updated = paramDateTime;
        return this;
      }

      public Timestamps setUserEdited(DateTime paramDateTime)
      {
        userEdited = paramDateTime;
        return this;
      }
    }
  }
}