package com.google.api.client.http;

import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;

public final class HttpRequest
{

  @Deprecated
  private BackOffPolicy backOffPolicy;
  private int connectTimeout = 20000;
  private HttpContent content;
  private int contentLoggingLimit = 16384;
  private boolean curlLoggingEnabled = true;
  private HttpEncoding encoding;
  private HttpExecuteInterceptor executeInterceptor;
  private boolean followRedirects = true;
  private HttpHeaders headers = new HttpHeaders();
  private HttpIOExceptionHandler ioExceptionHandler;
  private boolean loggingEnabled = true;
  private int numRetries = 10;
  private ObjectParser objectParser;
  private int readTimeout = 20000;
  private String requestMethod;
  private HttpHeaders responseHeaders = new HttpHeaders();
  private HttpResponseInterceptor responseInterceptor;

  @Deprecated
  private boolean retryOnExecuteIOException = false;
  private Sleeper sleeper = Sleeper.DEFAULT;
  private boolean suppressUserAgentSuffix;
  private boolean throwExceptionOnExecuteError = true;
  private final HttpTransport transport;
  private HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler;
  private GenericUrl url;

  HttpRequest(HttpTransport paramHttpTransport, String paramString)
  {
    transport = paramHttpTransport;
    setRequestMethod(paramString);
  }

  // ERROR //
  public HttpResponse execute()
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/google/api/client/http/HttpRequest:numRetries	I
    //   4: iflt +840 -> 844
    //   7: iconst_1
    //   8: istore 4
    //   10: iload 4
    //   12: invokestatic 100	com/google/api/client/util/Preconditions:checkArgument	(Z)V
    //   15: aload_0
    //   16: getfield 58	com/google/api/client/http/HttpRequest:numRetries	I
    //   19: istore_1
    //   20: aload_0
    //   21: getfield 102	com/google/api/client/http/HttpRequest:backOffPolicy	Lcom/google/api/client/http/BackOffPolicy;
    //   24: ifnull +12 -> 36
    //   27: aload_0
    //   28: getfield 102	com/google/api/client/http/HttpRequest:backOffPolicy	Lcom/google/api/client/http/BackOffPolicy;
    //   31: invokeinterface 107 1 0
    //   36: aconst_null
    //   37: astore 11
    //   39: aload_0
    //   40: getfield 109	com/google/api/client/http/HttpRequest:requestMethod	Ljava/lang/String;
    //   43: invokestatic 113	com/google/api/client/util/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: pop
    //   47: aload_0
    //   48: getfield 115	com/google/api/client/http/HttpRequest:url	Lcom/google/api/client/http/GenericUrl;
    //   51: invokestatic 113	com/google/api/client/util/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload 11
    //   57: ifnull +8 -> 65
    //   60: aload 11
    //   62: invokevirtual 120	com/google/api/client/http/HttpResponse:ignore	()V
    //   65: aconst_null
    //   66: astore 13
    //   68: aconst_null
    //   69: astore 14
    //   71: aload_0
    //   72: getfield 122	com/google/api/client/http/HttpRequest:executeInterceptor	Lcom/google/api/client/http/HttpExecuteInterceptor;
    //   75: ifnull +13 -> 88
    //   78: aload_0
    //   79: getfield 122	com/google/api/client/http/HttpRequest:executeInterceptor	Lcom/google/api/client/http/HttpExecuteInterceptor;
    //   82: aload_0
    //   83: invokeinterface 128 2 0
    //   88: aload_0
    //   89: getfield 115	com/google/api/client/http/HttpRequest:url	Lcom/google/api/client/http/GenericUrl;
    //   92: invokevirtual 134	com/google/api/client/http/GenericUrl:build	()Ljava/lang/String;
    //   95: astore 16
    //   97: aload_0
    //   98: getfield 83	com/google/api/client/http/HttpRequest:transport	Lcom/google/api/client/http/HttpTransport;
    //   101: aload_0
    //   102: getfield 109	com/google/api/client/http/HttpRequest:requestMethod	Ljava/lang/String;
    //   105: aload 16
    //   107: invokevirtual 140	com/google/api/client/http/HttpTransport:buildRequest	(Ljava/lang/String;Ljava/lang/String;)Lcom/google/api/client/http/LowLevelHttpRequest;
    //   110: astore 17
    //   112: getstatic 144	com/google/api/client/http/HttpTransport:LOGGER	Ljava/util/logging/Logger;
    //   115: astore 15
    //   117: aload_0
    //   118: getfield 62	com/google/api/client/http/HttpRequest:loggingEnabled	Z
    //   121: ifeq +729 -> 850
    //   124: aload 15
    //   126: getstatic 150	java/util/logging/Level:CONFIG	Ljava/util/logging/Level;
    //   129: invokevirtual 156	java/util/logging/Logger:isLoggable	(Ljava/util/logging/Level;)Z
    //   132: ifeq +718 -> 850
    //   135: iconst_1
    //   136: istore_2
    //   137: aconst_null
    //   138: astore 11
    //   140: aconst_null
    //   141: astore 9
    //   143: aload 9
    //   145: astore 10
    //   147: iload_2
    //   148: ifeq +121 -> 269
    //   151: new 158	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   158: astore 12
    //   160: aload 12
    //   162: ldc 161
    //   164: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: getstatic 170	com/google/api/client/util/StringUtils:LINE_SEPARATOR	Ljava/lang/String;
    //   170: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 12
    //   176: aload_0
    //   177: getfield 109	com/google/api/client/http/HttpRequest:requestMethod	Ljava/lang/String;
    //   180: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: bipush 32
    //   185: invokevirtual 173	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   188: aload 16
    //   190: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: getstatic 170	com/google/api/client/util/StringUtils:LINE_SEPARATOR	Ljava/lang/String;
    //   196: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 9
    //   202: astore 10
    //   204: aload 12
    //   206: astore 11
    //   208: aload_0
    //   209: getfield 64	com/google/api/client/http/HttpRequest:curlLoggingEnabled	Z
    //   212: ifeq +57 -> 269
    //   215: new 158	java/lang/StringBuilder
    //   218: dup
    //   219: ldc 175
    //   221: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   224: astore 9
    //   226: aload 9
    //   228: astore 10
    //   230: aload 12
    //   232: astore 11
    //   234: aload_0
    //   235: getfield 109	com/google/api/client/http/HttpRequest:requestMethod	Ljava/lang/String;
    //   238: ldc 180
    //   240: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   243: ifne +26 -> 269
    //   246: aload 9
    //   248: ldc 188
    //   250: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_0
    //   254: getfield 109	com/google/api/client/http/HttpRequest:requestMethod	Ljava/lang/String;
    //   257: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 12
    //   263: astore 11
    //   265: aload 9
    //   267: astore 10
    //   269: aload_0
    //   270: getfield 54	com/google/api/client/http/HttpRequest:headers	Lcom/google/api/client/http/HttpHeaders;
    //   273: invokevirtual 191	com/google/api/client/http/HttpHeaders:getUserAgent	()Ljava/lang/String;
    //   276: astore 9
    //   278: aload_0
    //   279: getfield 193	com/google/api/client/http/HttpRequest:suppressUserAgentSuffix	Z
    //   282: ifne +18 -> 300
    //   285: aload 9
    //   287: ifnonnull +568 -> 855
    //   290: aload_0
    //   291: getfield 54	com/google/api/client/http/HttpRequest:headers	Lcom/google/api/client/http/HttpHeaders;
    //   294: ldc 195
    //   296: invokevirtual 199	com/google/api/client/http/HttpHeaders:setUserAgent	(Ljava/lang/String;)Lcom/google/api/client/http/HttpHeaders;
    //   299: pop
    //   300: aload_0
    //   301: getfield 54	com/google/api/client/http/HttpRequest:headers	Lcom/google/api/client/http/HttpHeaders;
    //   304: aload 11
    //   306: aload 10
    //   308: aload 15
    //   310: aload 17
    //   312: invokestatic 203	com/google/api/client/http/HttpHeaders:serializeHeaders	(Lcom/google/api/client/http/HttpHeaders;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/util/logging/Logger;Lcom/google/api/client/http/LowLevelHttpRequest;)V
    //   315: aload_0
    //   316: getfield 193	com/google/api/client/http/HttpRequest:suppressUserAgentSuffix	Z
    //   319: ifne +13 -> 332
    //   322: aload_0
    //   323: getfield 54	com/google/api/client/http/HttpRequest:headers	Lcom/google/api/client/http/HttpHeaders;
    //   326: aload 9
    //   328: invokevirtual 199	com/google/api/client/http/HttpHeaders:setUserAgent	(Ljava/lang/String;)Lcom/google/api/client/http/HttpHeaders;
    //   331: pop
    //   332: aload_0
    //   333: getfield 205	com/google/api/client/http/HttpRequest:content	Lcom/google/api/client/http/HttpContent;
    //   336: astore 12
    //   338: aload 12
    //   340: ifnull +15 -> 355
    //   343: aload_0
    //   344: getfield 205	com/google/api/client/http/HttpRequest:content	Lcom/google/api/client/http/HttpContent;
    //   347: invokeinterface 211 1 0
    //   352: ifeq +540 -> 892
    //   355: iconst_1
    //   356: istore_3
    //   357: aload 12
    //   359: astore 9
    //   361: aload 12
    //   363: ifnull +225 -> 588
    //   366: aload_0
    //   367: getfield 205	com/google/api/client/http/HttpRequest:content	Lcom/google/api/client/http/HttpContent;
    //   370: invokeinterface 214 1 0
    //   375: astore 18
    //   377: aload 12
    //   379: astore 9
    //   381: iload_2
    //   382: ifeq +24 -> 406
    //   385: new 216	com/google/api/client/util/LoggingStreamingContent
    //   388: dup
    //   389: aload 12
    //   391: getstatic 144	com/google/api/client/http/HttpTransport:LOGGER	Ljava/util/logging/Logger;
    //   394: getstatic 150	java/util/logging/Level:CONFIG	Ljava/util/logging/Level;
    //   397: aload_0
    //   398: getfield 60	com/google/api/client/http/HttpRequest:contentLoggingLimit	I
    //   401: invokespecial 219	com/google/api/client/util/LoggingStreamingContent:<init>	(Lcom/google/api/client/util/StreamingContent;Ljava/util/logging/Logger;Ljava/util/logging/Level;I)V
    //   404: astore 9
    //   406: aload_0
    //   407: getfield 221	com/google/api/client/http/HttpRequest:encoding	Lcom/google/api/client/http/HttpEncoding;
    //   410: ifnonnull +487 -> 897
    //   413: aconst_null
    //   414: astore 12
    //   416: aload_0
    //   417: getfield 205	com/google/api/client/http/HttpRequest:content	Lcom/google/api/client/http/HttpContent;
    //   420: invokeinterface 225 1 0
    //   425: lstore 7
    //   427: iload_2
    //   428: ifeq +119 -> 547
    //   431: aload 18
    //   433: ifnull +75 -> 508
    //   436: new 158	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   443: ldc 227
    //   445: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 18
    //   450: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: astore 19
    //   458: aload 11
    //   460: aload 19
    //   462: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: getstatic 170	com/google/api/client/util/StringUtils:LINE_SEPARATOR	Ljava/lang/String;
    //   468: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 10
    //   474: ifnull +34 -> 508
    //   477: aload 10
    //   479: new 158	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   486: ldc 232
    //   488: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload 19
    //   493: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: ldc 234
    //   498: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: lload 7
    //   510: lconst_0
    //   511: lcmp
    //   512: iflt +35 -> 547
    //   515: aload 11
    //   517: new 158	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   524: ldc 236
    //   526: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: lload 7
    //   531: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   534: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: getstatic 170	com/google/api/client/util/StringUtils:LINE_SEPARATOR	Ljava/lang/String;
    //   543: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload 10
    //   549: ifnull +11 -> 560
    //   552: aload 10
    //   554: ldc 241
    //   556: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload 17
    //   562: aload 18
    //   564: invokevirtual 246	com/google/api/client/http/LowLevelHttpRequest:setContentType	(Ljava/lang/String;)V
    //   567: aload 17
    //   569: aload 12
    //   571: invokevirtual 249	com/google/api/client/http/LowLevelHttpRequest:setContentEncoding	(Ljava/lang/String;)V
    //   574: aload 17
    //   576: lload 7
    //   578: invokevirtual 253	com/google/api/client/http/LowLevelHttpRequest:setContentLength	(J)V
    //   581: aload 17
    //   583: aload 9
    //   585: invokevirtual 257	com/google/api/client/http/LowLevelHttpRequest:setStreamingContent	(Lcom/google/api/client/util/StreamingContent;)V
    //   588: iload_2
    //   589: ifeq +75 -> 664
    //   592: aload 15
    //   594: aload 11
    //   596: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokevirtual 260	java/util/logging/Logger:config	(Ljava/lang/String;)V
    //   602: aload 10
    //   604: ifnull +60 -> 664
    //   607: aload 10
    //   609: ldc_w 262
    //   612: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload 10
    //   618: aload 16
    //   620: ldc 234
    //   622: ldc_w 264
    //   625: invokevirtual 268	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   628: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 10
    //   634: ldc 234
    //   636: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 9
    //   642: ifnull +12 -> 654
    //   645: aload 10
    //   647: ldc_w 270
    //   650: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: aload 15
    //   656: aload 10
    //   658: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokevirtual 260	java/util/logging/Logger:config	(Ljava/lang/String;)V
    //   664: iload_3
    //   665: ifeq +280 -> 945
    //   668: iload_1
    //   669: ifle +276 -> 945
    //   672: iconst_1
    //   673: istore 6
    //   675: aload 17
    //   677: aload_0
    //   678: getfield 66	com/google/api/client/http/HttpRequest:connectTimeout	I
    //   681: aload_0
    //   682: getfield 68	com/google/api/client/http/HttpRequest:readTimeout	I
    //   685: invokevirtual 274	com/google/api/client/http/LowLevelHttpRequest:setTimeout	(II)V
    //   688: aload 17
    //   690: invokevirtual 277	com/google/api/client/http/LowLevelHttpRequest:execute	()Lcom/google/api/client/http/LowLevelHttpResponse;
    //   693: astore 10
    //   695: new 117	com/google/api/client/http/HttpResponse
    //   698: dup
    //   699: aload_0
    //   700: aload 10
    //   702: invokespecial 280	com/google/api/client/http/HttpResponse:<init>	(Lcom/google/api/client/http/HttpRequest;Lcom/google/api/client/http/LowLevelHttpResponse;)V
    //   705: astore 9
    //   707: iconst_1
    //   708: ifne +11 -> 719
    //   711: aload 10
    //   713: invokevirtual 286	com/google/api/client/http/LowLevelHttpResponse:getContent	()Ljava/io/InputStream;
    //   716: invokevirtual 291	java/io/InputStream:close	()V
    //   719: aload 14
    //   721: astore 10
    //   723: aload 9
    //   725: ifnull +387 -> 1112
    //   728: aload 9
    //   730: invokevirtual 294	com/google/api/client/http/HttpResponse:isSuccessStatusCode	()Z
    //   733: ifne +379 -> 1112
    //   736: iconst_0
    //   737: istore 4
    //   739: aload_0
    //   740: getfield 296	com/google/api/client/http/HttpRequest:unsuccessfulResponseHandler	Lcom/google/api/client/http/HttpUnsuccessfulResponseHandler;
    //   743: ifnull +19 -> 762
    //   746: aload_0
    //   747: getfield 296	com/google/api/client/http/HttpRequest:unsuccessfulResponseHandler	Lcom/google/api/client/http/HttpUnsuccessfulResponseHandler;
    //   750: aload_0
    //   751: aload 9
    //   753: iload 6
    //   755: invokeinterface 302 4 0
    //   760: istore 4
    //   762: iload 4
    //   764: istore 5
    //   766: iload 4
    //   768: ifne +23 -> 791
    //   771: aload_0
    //   772: aload 9
    //   774: invokevirtual 306	com/google/api/client/http/HttpResponse:getStatusCode	()I
    //   777: aload 9
    //   779: invokevirtual 310	com/google/api/client/http/HttpResponse:getHeaders	()Lcom/google/api/client/http/HttpHeaders;
    //   782: invokevirtual 314	com/google/api/client/http/HttpRequest:handleRedirect	(ILcom/google/api/client/http/HttpHeaders;)Z
    //   785: ifeq +245 -> 1030
    //   788: iconst_1
    //   789: istore 5
    //   791: iload 6
    //   793: iload 5
    //   795: iand
    //   796: istore_3
    //   797: iload_3
    //   798: istore_2
    //   799: iload_3
    //   800: ifeq +10 -> 810
    //   803: aload 9
    //   805: invokevirtual 120	com/google/api/client/http/HttpResponse:ignore	()V
    //   808: iload_3
    //   809: istore_2
    //   810: iload_1
    //   811: iconst_1
    //   812: isub
    //   813: istore_1
    //   814: aload 9
    //   816: ifnull +12 -> 828
    //   819: iconst_1
    //   820: ifne +8 -> 828
    //   823: aload 9
    //   825: invokevirtual 317	com/google/api/client/http/HttpResponse:disconnect	()V
    //   828: aload 9
    //   830: astore 11
    //   832: iload_2
    //   833: ifne -778 -> 55
    //   836: aload 9
    //   838: ifnonnull +313 -> 1151
    //   841: aload 10
    //   843: athrow
    //   844: iconst_0
    //   845: istore 4
    //   847: goto -837 -> 10
    //   850: iconst_0
    //   851: istore_2
    //   852: goto -715 -> 137
    //   855: aload_0
    //   856: getfield 54	com/google/api/client/http/HttpRequest:headers	Lcom/google/api/client/http/HttpHeaders;
    //   859: new 158	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   866: aload 9
    //   868: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: ldc_w 319
    //   874: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: ldc 195
    //   879: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   885: invokevirtual 199	com/google/api/client/http/HttpHeaders:setUserAgent	(Ljava/lang/String;)Lcom/google/api/client/http/HttpHeaders;
    //   888: pop
    //   889: goto -589 -> 300
    //   892: iconst_0
    //   893: istore_3
    //   894: goto -537 -> 357
    //   897: aload_0
    //   898: getfield 221	com/google/api/client/http/HttpRequest:encoding	Lcom/google/api/client/http/HttpEncoding;
    //   901: invokeinterface 324 1 0
    //   906: astore 12
    //   908: new 326	com/google/api/client/http/HttpEncodingStreamingContent
    //   911: dup
    //   912: aload 9
    //   914: aload_0
    //   915: getfield 221	com/google/api/client/http/HttpRequest:encoding	Lcom/google/api/client/http/HttpEncoding;
    //   918: invokespecial 329	com/google/api/client/http/HttpEncodingStreamingContent:<init>	(Lcom/google/api/client/util/StreamingContent;Lcom/google/api/client/http/HttpEncoding;)V
    //   921: astore 9
    //   923: iload_3
    //   924: ifeq +13 -> 937
    //   927: aload 9
    //   929: invokestatic 335	com/google/api/client/util/IOUtils:computeLength	(Lcom/google/api/client/util/StreamingContent;)J
    //   932: lstore 7
    //   934: goto -507 -> 427
    //   937: ldc2_w 336
    //   940: lstore 7
    //   942: goto -8 -> 934
    //   945: iconst_0
    //   946: istore 6
    //   948: goto -273 -> 675
    //   951: astore 9
    //   953: iconst_0
    //   954: ifne +11 -> 965
    //   957: aload 10
    //   959: invokevirtual 286	com/google/api/client/http/LowLevelHttpResponse:getContent	()Ljava/io/InputStream;
    //   962: invokevirtual 291	java/io/InputStream:close	()V
    //   965: aload 9
    //   967: athrow
    //   968: astore 10
    //   970: aload 13
    //   972: astore 9
    //   974: aload_0
    //   975: getfield 74	com/google/api/client/http/HttpRequest:retryOnExecuteIOException	Z
    //   978: ifne +28 -> 1006
    //   981: aload_0
    //   982: getfield 339	com/google/api/client/http/HttpRequest:ioExceptionHandler	Lcom/google/api/client/http/HttpIOExceptionHandler;
    //   985: ifnull +18 -> 1003
    //   988: aload_0
    //   989: getfield 339	com/google/api/client/http/HttpRequest:ioExceptionHandler	Lcom/google/api/client/http/HttpIOExceptionHandler;
    //   992: aload_0
    //   993: iload 6
    //   995: invokeinterface 345 3 0
    //   1000: ifne +6 -> 1006
    //   1003: aload 10
    //   1005: athrow
    //   1006: aload 10
    //   1008: astore 11
    //   1010: aload 15
    //   1012: getstatic 348	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
    //   1015: ldc_w 350
    //   1018: aload 10
    //   1020: invokevirtual 354	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1023: aload 11
    //   1025: astore 10
    //   1027: goto -304 -> 723
    //   1030: iload 4
    //   1032: istore 5
    //   1034: iload 6
    //   1036: ifeq -245 -> 791
    //   1039: iload 4
    //   1041: istore 5
    //   1043: aload_0
    //   1044: getfield 102	com/google/api/client/http/HttpRequest:backOffPolicy	Lcom/google/api/client/http/BackOffPolicy;
    //   1047: ifnull -256 -> 791
    //   1050: iload 4
    //   1052: istore 5
    //   1054: aload_0
    //   1055: getfield 102	com/google/api/client/http/HttpRequest:backOffPolicy	Lcom/google/api/client/http/BackOffPolicy;
    //   1058: aload 9
    //   1060: invokevirtual 306	com/google/api/client/http/HttpResponse:getStatusCode	()I
    //   1063: invokeinterface 358 2 0
    //   1068: ifeq -277 -> 791
    //   1071: aload_0
    //   1072: getfield 102	com/google/api/client/http/HttpRequest:backOffPolicy	Lcom/google/api/client/http/BackOffPolicy;
    //   1075: invokeinterface 361 1 0
    //   1080: lstore 7
    //   1082: iload 4
    //   1084: istore 5
    //   1086: lload 7
    //   1088: ldc2_w 336
    //   1091: lcmp
    //   1092: ifeq -301 -> 791
    //   1095: aload_0
    //   1096: getfield 81	com/google/api/client/http/HttpRequest:sleeper	Lcom/google/api/client/util/Sleeper;
    //   1099: lload 7
    //   1101: invokeinterface 364 3 0
    //   1106: iconst_1
    //   1107: istore 5
    //   1109: goto -318 -> 791
    //   1112: aload 9
    //   1114: ifnonnull +13 -> 1127
    //   1117: iconst_1
    //   1118: istore_2
    //   1119: iload 6
    //   1121: iload_2
    //   1122: iand
    //   1123: istore_2
    //   1124: goto -314 -> 810
    //   1127: iconst_0
    //   1128: istore_2
    //   1129: goto -10 -> 1119
    //   1132: astore 10
    //   1134: aload 9
    //   1136: ifnull +12 -> 1148
    //   1139: iconst_0
    //   1140: ifne +8 -> 1148
    //   1143: aload 9
    //   1145: invokevirtual 317	com/google/api/client/http/HttpResponse:disconnect	()V
    //   1148: aload 10
    //   1150: athrow
    //   1151: aload_0
    //   1152: getfield 366	com/google/api/client/http/HttpRequest:responseInterceptor	Lcom/google/api/client/http/HttpResponseInterceptor;
    //   1155: ifnull +14 -> 1169
    //   1158: aload_0
    //   1159: getfield 366	com/google/api/client/http/HttpRequest:responseInterceptor	Lcom/google/api/client/http/HttpResponseInterceptor;
    //   1162: aload 9
    //   1164: invokeinterface 372 2 0
    //   1169: aload_0
    //   1170: getfield 72	com/google/api/client/http/HttpRequest:throwExceptionOnExecuteError	Z
    //   1173: ifeq +31 -> 1204
    //   1176: aload 9
    //   1178: invokevirtual 294	com/google/api/client/http/HttpResponse:isSuccessStatusCode	()Z
    //   1181: ifne +23 -> 1204
    //   1184: new 374	com/google/api/client/http/HttpResponseException
    //   1187: dup
    //   1188: aload 9
    //   1190: invokespecial 376	com/google/api/client/http/HttpResponseException:<init>	(Lcom/google/api/client/http/HttpResponse;)V
    //   1193: athrow
    //   1194: astore 10
    //   1196: aload 9
    //   1198: invokevirtual 317	com/google/api/client/http/HttpResponse:disconnect	()V
    //   1201: aload 10
    //   1203: athrow
    //   1204: aload 9
    //   1206: areturn
    //   1207: astore 11
    //   1209: goto -103 -> 1106
    //   1212: astore 10
    //   1214: goto -240 -> 974
    //
    // Exception table:
    //   from	to	target	type
    //   695	707	951	finally
    //   688	695	968	java/io/IOException
    //   957	965	968	java/io/IOException
    //   965	968	968	java/io/IOException
    //   728	736	1132	finally
    //   739	762	1132	finally
    //   771	788	1132	finally
    //   803	808	1132	finally
    //   1043	1050	1132	finally
    //   1054	1082	1132	finally
    //   1095	1106	1132	finally
    //   1184	1194	1194	finally
    //   1095	1106	1207	java/lang/InterruptedException
    //   711	719	1212	java/io/IOException
  }

  public HttpContent getContent()
  {
    return content;
  }

  public int getContentLoggingLimit()
  {
    return contentLoggingLimit;
  }

  public boolean getFollowRedirects()
  {
    return followRedirects;
  }

  public HttpHeaders getHeaders()
  {
    return headers;
  }

  public HttpIOExceptionHandler getIOExceptionHandler()
  {
    return ioExceptionHandler;
  }

  public int getNumberOfRetries()
  {
    return numRetries;
  }

  public final ObjectParser getParser()
  {
    return objectParser;
  }

  public String getRequestMethod()
  {
    return requestMethod;
  }

  public HttpHeaders getResponseHeaders()
  {
    return responseHeaders;
  }

  public HttpResponseInterceptor getResponseInterceptor()
  {
    return responseInterceptor;
  }

  public boolean getThrowExceptionOnExecuteError()
  {
    return throwExceptionOnExecuteError;
  }

  public HttpTransport getTransport()
  {
    return transport;
  }

  public HttpUnsuccessfulResponseHandler getUnsuccessfulResponseHandler()
  {
    return unsuccessfulResponseHandler;
  }

  public GenericUrl getUrl()
  {
    return url;
  }

  public boolean handleRedirect(int paramInt, HttpHeaders paramHttpHeaders)
  {
    paramHttpHeaders = paramHttpHeaders.getLocation();
    if ((getFollowRedirects()) && (HttpStatusCodes.isRedirect(paramInt)) && (paramHttpHeaders != null))
    {
      setUrl(new GenericUrl(url.toURL(paramHttpHeaders)));
      if (paramInt == 303)
        setRequestMethod("GET");
      headers.setAuthorization((String)null);
      headers.setIfMatch((String)null);
      headers.setIfNoneMatch((String)null);
      headers.setIfModifiedSince((String)null);
      headers.setIfUnmodifiedSince((String)null);
      headers.setIfRange((String)null);
      return true;
    }
    return false;
  }

  public boolean isLoggingEnabled()
  {
    return loggingEnabled;
  }

  @Deprecated
  public HttpRequest setBackOffPolicy(BackOffPolicy paramBackOffPolicy)
  {
    backOffPolicy = paramBackOffPolicy;
    return this;
  }

  public HttpRequest setConnectTimeout(int paramInt)
  {
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      connectTimeout = paramInt;
      return this;
    }
  }

  public HttpRequest setContent(HttpContent paramHttpContent)
  {
    content = paramHttpContent;
    return this;
  }

  public HttpRequest setEncoding(HttpEncoding paramHttpEncoding)
  {
    encoding = paramHttpEncoding;
    return this;
  }

  public HttpRequest setIOExceptionHandler(HttpIOExceptionHandler paramHttpIOExceptionHandler)
  {
    ioExceptionHandler = paramHttpIOExceptionHandler;
    return this;
  }

  public HttpRequest setInterceptor(HttpExecuteInterceptor paramHttpExecuteInterceptor)
  {
    executeInterceptor = paramHttpExecuteInterceptor;
    return this;
  }

  public HttpRequest setNumberOfRetries(int paramInt)
  {
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      numRetries = paramInt;
      return this;
    }
  }

  public HttpRequest setParser(ObjectParser paramObjectParser)
  {
    objectParser = paramObjectParser;
    return this;
  }

  public HttpRequest setReadTimeout(int paramInt)
  {
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      readTimeout = paramInt;
      return this;
    }
  }

  public HttpRequest setRequestMethod(String paramString)
  {
    if ((paramString == null) || (HttpMediaType.matchesToken(paramString)));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      requestMethod = paramString;
      return this;
    }
  }

  public HttpRequest setResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor)
  {
    responseInterceptor = paramHttpResponseInterceptor;
    return this;
  }

  public HttpRequest setThrowExceptionOnExecuteError(boolean paramBoolean)
  {
    throwExceptionOnExecuteError = paramBoolean;
    return this;
  }

  public HttpRequest setUnsuccessfulResponseHandler(HttpUnsuccessfulResponseHandler paramHttpUnsuccessfulResponseHandler)
  {
    unsuccessfulResponseHandler = paramHttpUnsuccessfulResponseHandler;
    return this;
  }

  public HttpRequest setUrl(GenericUrl paramGenericUrl)
  {
    url = ((GenericUrl)Preconditions.checkNotNull(paramGenericUrl));
    return this;
  }
}