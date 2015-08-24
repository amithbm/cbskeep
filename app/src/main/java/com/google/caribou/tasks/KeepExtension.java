package com.google.caribou.tasks;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

public final class KeepExtension extends ExtendableMessageNano<KeepExtension>
{
  public String clientNoteId;
  public String noteOwnerObfuscatedGaiaId;
  public int reminderVersion;
  public String serverNoteId;

  public KeepExtension()
  {
    clear();
  }

  public KeepExtension clear()
  {
    reminderVersion = 0;
    clientNoteId = "";
    serverNoteId = "";
    noteOwnerObfuscatedGaiaId = "";
    unknownFieldData = null;
    cachedSize = -1;
    return this;
  }

  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (reminderVersion != 0)
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, reminderVersion);
    j = i;
    if (!clientNoteId.equals(""))
      j = i + CodedOutputByteBufferNano.computeStringSize(2, clientNoteId);
    i = j;
    if (!serverNoteId.equals(""))
      i = j + CodedOutputByteBufferNano.computeStringSize(3, serverNoteId);
    j = i;
    if (!noteOwnerObfuscatedGaiaId.equals(""))
      j = i + CodedOutputByteBufferNano.computeStringSize(4, noteOwnerObfuscatedGaiaId);
    return j;
  }

  public KeepExtension mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
    throws IOException
  {
    while (true)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default:
        if (storeUnknownField(paramCodedInputByteBufferNano, i))
          continue;
      case 0:
        return this;
      case 8:
        i = paramCodedInputByteBufferNano.readInt32();
        switch (i)
        {
        default:
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        }
        reminderVersion = i;
        break;
      case 18:
        clientNoteId = paramCodedInputByteBufferNano.readString();
        break;
      case 26:
        serverNoteId = paramCodedInputByteBufferNano.readString();
        break;
      case 34:
      }
      noteOwnerObfuscatedGaiaId = paramCodedInputByteBufferNano.readString();
    }
  }

  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
    throws IOException
  {
    if (reminderVersion != 0)
      paramCodedOutputByteBufferNano.writeInt32(1, reminderVersion);
    if (!clientNoteId.equals(""))
      paramCodedOutputByteBufferNano.writeString(2, clientNoteId);
    if (!serverNoteId.equals(""))
      paramCodedOutputByteBufferNano.writeString(3, serverNoteId);
    if (!noteOwnerObfuscatedGaiaId.equals(""))
      paramCodedOutputByteBufferNano.writeString(4, noteOwnerObfuscatedGaiaId);
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}