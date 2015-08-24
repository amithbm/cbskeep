package com.google.api.services.notes.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

public final class Node extends GenericJson
{

  @Key
  private String baseVersion;

  @Key
  private Blob blob;

  @Key
  private Boolean checked;

  @Key
  private String color;

  @Key
  private List<ErrorStatus> errorStatus;

  @Key
  private String id;

  @Key
  private Boolean isArchived;

  @Key
  private List<LabelIds> labelIds;

  @Key
  private String lastModifierEmail;

  @Key
  private MergeConflict mergeConflict;

  @Key
  private NodeSettings nodeSettings;

  @Key
  private String parentId;

  @Key
  private String parentServerId;

  @Key
  private String realtimeDataServerVersion;

  @Key
  private List<RoleInfo> roleInfo;

  @Key
  private String serverId;

  @Key
  private List<ShareRequests> shareRequests;

  @Key
  private String shareState;

  @Key
  private String sharerEmail;

  @JsonString
  @Key
  private Long sortValue;

  @Key
  private String text;

  @Key
  private Timestamps timestamps;

  @Key
  private String title;

  @Key
  private String type;

  static
  {
    Data.nullOf(ErrorStatus.class);
    Data.nullOf(LabelIds.class);
    Data.nullOf(Reminders.class);
    Data.nullOf(RoleInfo.class);
    Data.nullOf(ShareRequests.class);
  }

  public Node clone()
  {
    return (Node)super.clone();
  }

  public String getBaseVersion()
  {
    return baseVersion;
  }

  public Blob getBlob()
  {
    return blob;
  }

  public Boolean getChecked()
  {
    return checked;
  }

  public String getColor()
  {
    return color;
  }

  public List<ErrorStatus> getErrorStatus()
  {
    return errorStatus;
  }

  public String getId()
  {
    return id;
  }

  public Boolean getIsArchived()
  {
    return isArchived;
  }

  public List<LabelIds> getLabelIds()
  {
    return labelIds;
  }

  public String getLastModifierEmail()
  {
    return lastModifierEmail;
  }

  public MergeConflict getMergeConflict()
  {
    return mergeConflict;
  }

  public NodeSettings getNodeSettings()
  {
    return nodeSettings;
  }

  public String getParentId()
  {
    return parentId;
  }

  public String getParentServerId()
  {
    return parentServerId;
  }

  public String getRealtimeDataServerVersion()
  {
    return realtimeDataServerVersion;
  }

  public List<RoleInfo> getRoleInfo()
  {
    return roleInfo;
  }

  public String getServerId()
  {
    return serverId;
  }

  public List<ShareRequests> getShareRequests()
  {
    return shareRequests;
  }

  public String getShareState()
  {
    return shareState;
  }

  public String getSharerEmail()
  {
    return sharerEmail;
  }

  public Long getSortValue()
  {
    return sortValue;
  }

  public String getText()
  {
    return text;
  }

  public Timestamps getTimestamps()
  {
    return timestamps;
  }

  public String getTitle()
  {
    return title;
  }

  public String getType()
  {
    return type;
  }

  public Node set(String paramString, Object paramObject)
  {
    return (Node)super.set(paramString, paramObject);
  }

  public Node setBaseVersion(String paramString)
  {
    baseVersion = paramString;
    return this;
  }

  public Node setBlob(Blob paramBlob)
  {
    blob = paramBlob;
    return this;
  }

  public Node setChecked(Boolean paramBoolean)
  {
    checked = paramBoolean;
    return this;
  }

  public Node setColor(String paramString)
  {
    color = paramString;
    return this;
  }

  public Node setErrorStatus(List<ErrorStatus> paramList)
  {
    errorStatus = paramList;
    return this;
  }

  public Node setId(String paramString)
  {
    id = paramString;
    return this;
  }

  public Node setIsArchived(Boolean paramBoolean)
  {
    isArchived = paramBoolean;
    return this;
  }

  public Node setLabelIds(List<LabelIds> paramList)
  {
    labelIds = paramList;
    return this;
  }

  public Node setLastModifierEmail(String paramString)
  {
    lastModifierEmail = paramString;
    return this;
  }

  public Node setMergeConflict(MergeConflict paramMergeConflict)
  {
    mergeConflict = paramMergeConflict;
    return this;
  }

  public Node setNodeSettings(NodeSettings paramNodeSettings)
  {
    nodeSettings = paramNodeSettings;
    return this;
  }

  public Node setParentId(String paramString)
  {
    parentId = paramString;
    return this;
  }

  public Node setParentServerId(String paramString)
  {
    parentServerId = paramString;
    return this;
  }

  public Node setRealtimeDataServerVersion(String paramString)
  {
    realtimeDataServerVersion = paramString;
    return this;
  }

  public Node setRoleInfo(List<RoleInfo> paramList)
  {
    roleInfo = paramList;
    return this;
  }

  public Node setServerId(String paramString)
  {
    serverId = paramString;
    return this;
  }

  public Node setShareRequests(List<ShareRequests> paramList)
  {
    shareRequests = paramList;
    return this;
  }

  public Node setShareState(String paramString)
  {
    shareState = paramString;
    return this;
  }

  public Node setSharerEmail(String paramString)
  {
    sharerEmail = paramString;
    return this;
  }

  public Node setSortValue(Long paramLong)
  {
    sortValue = paramLong;
    return this;
  }

  public Node setText(String paramString)
  {
    text = paramString;
    return this;
  }

  public Node setTimestamps(Timestamps paramTimestamps)
  {
    timestamps = paramTimestamps;
    return this;
  }

  public Node setTitle(String paramString)
  {
    title = paramString;
    return this;
  }

  public Node setType(String paramString)
  {
    type = paramString;
    return this;
  }

  public static final class ErrorStatus extends GenericJson
  {

    @Key
    private String code;

    @Key
    private List<String> emails;

    public ErrorStatus clone()
    {
      return (ErrorStatus)super.clone();
    }

    public String getCode()
    {
      return code;
    }

    public List<String> getEmails()
    {
      return emails;
    }

    public ErrorStatus set(String paramString, Object paramObject)
    {
      return (ErrorStatus)super.set(paramString, paramObject);
    }

    public ErrorStatus setCode(String paramString)
    {
      code = paramString;
      return this;
    }

    public ErrorStatus setEmails(List<String> paramList)
    {
      emails = paramList;
      return this;
    }
  }

  public static final class LabelIds extends GenericJson
  {

    @Key
    private DateTime deleted;

    @Key
    private String labelId;

    public LabelIds clone()
    {
      return (LabelIds)super.clone();
    }

    public DateTime getDeleted()
    {
      return deleted;
    }

    public String getLabelId()
    {
      return labelId;
    }

    public LabelIds set(String paramString, Object paramObject)
    {
      return (LabelIds)super.set(paramString, paramObject);
    }

    public LabelIds setDeleted(DateTime paramDateTime)
    {
      deleted = paramDateTime;
      return this;
    }

    public LabelIds setLabelId(String paramString)
    {
      labelId = paramString;
      return this;
    }
  }

  public static final class MergeConflict extends GenericJson
  {

    @Key
    private String token;

    public MergeConflict clone()
    {
      return (MergeConflict)super.clone();
    }

    public String getToken()
    {
      return token;
    }

    public MergeConflict set(String paramString, Object paramObject)
    {
      return (MergeConflict)super.set(paramString, paramObject);
    }

    public MergeConflict setToken(String paramString)
    {
      token = paramString;
      return this;
    }
  }

  public static final class NodeSettings extends GenericJson
  {

    @Key
    private String checkedListItemsPolicy;

    @Key
    private String graveyardState;

    @Key
    private String newListItemPlacement;

    public NodeSettings clone()
    {
      return (NodeSettings)super.clone();
    }

    public String getCheckedListItemsPolicy()
    {
      return checkedListItemsPolicy;
    }

    public String getGraveyardState()
    {
      return graveyardState;
    }

    public String getNewListItemPlacement()
    {
      return newListItemPlacement;
    }

    public NodeSettings set(String paramString, Object paramObject)
    {
      return (NodeSettings)super.set(paramString, paramObject);
    }

    public NodeSettings setCheckedListItemsPolicy(String paramString)
    {
      checkedListItemsPolicy = paramString;
      return this;
    }

    public NodeSettings setGraveyardState(String paramString)
    {
      graveyardState = paramString;
      return this;
    }

    public NodeSettings setNewListItemPlacement(String paramString)
    {
      newListItemPlacement = paramString;
      return this;
    }
  }

  public static final class Reminders extends GenericJson
  {

    @Key
    private String description;

    static
    {
      Data.nullOf(Locations.class);
    }

    public Reminders clone()
    {
      return (Reminders)super.clone();
    }

    public String getDescription()
    {
      return description;
    }

    public Reminders set(String paramString, Object paramObject)
    {
      return (Reminders)super.set(paramString, paramObject);
    }

    public static final class Locations extends GenericJson
    {
      public Locations clone()
      {
        return (Locations)super.clone();
      }

      public Locations set(String paramString, Object paramObject)
      {
        return (Locations)super.set(paramString, paramObject);
      }
    }
  }

  public static final class RoleInfo extends GenericJson
  {

    @Key
    private String email;

    @Key
    private String role;

    public RoleInfo clone()
    {
      return (RoleInfo)super.clone();
    }

    public String getEmail()
    {
      return email;
    }

    public String getRole()
    {
      return role;
    }

    public RoleInfo set(String paramString, Object paramObject)
    {
      return (RoleInfo)super.set(paramString, paramObject);
    }

    public RoleInfo setEmail(String paramString)
    {
      email = paramString;
      return this;
    }

    public RoleInfo setRole(String paramString)
    {
      role = paramString;
      return this;
    }
  }

  public static final class ShareRequests extends GenericJson
  {

    @Key
    private String email;

    @Key
    private String type;

    public ShareRequests clone()
    {
      return (ShareRequests)super.clone();
    }

    public String getEmail()
    {
      return email;
    }

    public String getType()
    {
      return type;
    }

    public ShareRequests set(String paramString, Object paramObject)
    {
      return (ShareRequests)super.set(paramString, paramObject);
    }

    public ShareRequests setEmail(String paramString)
    {
      email = paramString;
      return this;
    }

    public ShareRequests setType(String paramString)
    {
      type = paramString;
      return this;
    }
  }

  public static final class Timestamps extends GenericJson
  {

    @Key
    private DateTime created;

    @Key
    private DateTime deleted;

    @Key
    private DateTime recentSharedChangesSeen;

    @Key
    private DateTime shareRequestProcessed;

    @Key
    private DateTime trashed;

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

    public DateTime getRecentSharedChangesSeen()
    {
      return recentSharedChangesSeen;
    }

    public DateTime getShareRequestProcessed()
    {
      return shareRequestProcessed;
    }

    public DateTime getTrashed()
    {
      return trashed;
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

    public Timestamps setRecentSharedChangesSeen(DateTime paramDateTime)
    {
      recentSharedChangesSeen = paramDateTime;
      return this;
    }

    public Timestamps setTrashed(DateTime paramDateTime)
    {
      trashed = paramDateTime;
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