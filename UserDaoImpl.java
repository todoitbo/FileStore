package daoImpl;

import dao.UserDao;
import entity.User;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.JdbcUtilsProperties;

public class UserDaoImpl
  implements UserDao
{
  /* Error */
  public void addUser(User user, entity.Store store)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: ldc 18
    //   7: astore 5
    //   9: invokestatic 20	utils/JdbcUtilsProperties:getConnection	()Ljava/sql/Connection;
    //   12: astore_3
    //   13: aload_3
    //   14: aload 5
    //   16: invokeinterface 26 2 0
    //   21: astore 4
    //   23: aload 4
    //   25: iconst_1
    //   26: aload_1
    //   27: invokevirtual 32	entity/User:getUserName	()Ljava/lang/String;
    //   30: invokeinterface 38 3 0
    //   35: aload 4
    //   37: iconst_2
    //   38: aload_1
    //   39: invokevirtual 44	entity/User:getPassword	()Ljava/lang/String;
    //   42: invokeinterface 38 3 0
    //   47: aload 4
    //   49: iconst_3
    //   50: aload_2
    //   51: invokevirtual 47	entity/Store:getStoreId	()I
    //   54: invokeinterface 53 3 0
    //   59: aload 4
    //   61: invokeinterface 57 1 0
    //   66: istore 6
    //   68: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   71: new 66	java/lang/StringBuilder
    //   74: dup
    //   75: ldc 68
    //   77: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: iload 6
    //   82: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokevirtual 80	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   91: goto +31 -> 122
    //   94: astore 6
    //   96: aload 6
    //   98: invokevirtual 85	java/sql/SQLException:printStackTrace	()V
    //   101: new 90	java/lang/RuntimeException
    //   104: dup
    //   105: ldc 92
    //   107: invokespecial 94	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   110: athrow
    //   111: astore 7
    //   113: aload_3
    //   114: aload 4
    //   116: invokestatic 95	utils/JdbcUtilsProperties:close	(Ljava/sql/Connection;Ljava/sql/Statement;)V
    //   119: aload 7
    //   121: athrow
    //   122: aload_3
    //   123: aload 4
    //   125: invokestatic 95	utils/JdbcUtilsProperties:close	(Ljava/sql/Connection;Ljava/sql/Statement;)V
    //   128: return
    // Line number table:
    //   Java source line #20	-> byte code offset #0
    //   Java source line #21	-> byte code offset #2
    //   Java source line #22	-> byte code offset #5
    //   Java source line #23	-> byte code offset #9
    //   Java source line #25	-> byte code offset #13
    //   Java source line #26	-> byte code offset #23
    //   Java source line #27	-> byte code offset #35
    //   Java source line #28	-> byte code offset #47
    //   Java source line #29	-> byte code offset #59
    //   Java source line #30	-> byte code offset #68
    //   Java source line #31	-> byte code offset #94
    //   Java source line #32	-> byte code offset #96
    //   Java source line #33	-> byte code offset #101
    //   Java source line #34	-> byte code offset #111
    //   Java source line #35	-> byte code offset #113
    //   Java source line #36	-> byte code offset #119
    //   Java source line #35	-> byte code offset #122
    //   Java source line #37	-> byte code offset #128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	UserDaoImpl
    //   0	129	1	user	User
    //   0	129	2	store	entity.Store
    //   1	122	3	con	Connection
    //   3	121	4	pst	java.sql.PreparedStatement
    //   7	8	5	sql	String
    //   66	15	6	result	int
    //   94	3	6	e	SQLException
    //   111	9	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	91	94	java/sql/SQLException
    //   13	111	111	finally
  }
  
  /* Error */
  public User getUser(User user)
  {
    // Byte code:
    //   0: new 33	entity/User
    //   3: dup
    //   4: invokespecial 120	entity/User:<init>	()V
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore 5
    //   16: new 66	java/lang/StringBuilder
    //   19: dup
    //   20: ldc 121
    //   22: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: aload_1
    //   26: invokevirtual 32	entity/User:getUserName	()Ljava/lang/String;
    //   29: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 126
    //   34: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 44	entity/User:getPassword	()Ljava/lang/String;
    //   41: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc -128
    //   46: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 6
    //   54: invokestatic 20	utils/JdbcUtilsProperties:getConnection	()Ljava/sql/Connection;
    //   57: astore_3
    //   58: aload_3
    //   59: invokeinterface 130 1 0
    //   64: astore 4
    //   66: aload 4
    //   68: aload 6
    //   70: invokeinterface 134 2 0
    //   75: astore 5
    //   77: aload 5
    //   79: invokeinterface 140 1 0
    //   84: ifeq +78 -> 162
    //   87: aload_2
    //   88: aload 5
    //   90: ldc -110
    //   92: invokeinterface 148 2 0
    //   97: invokevirtual 152	entity/User:setUserId	(I)V
    //   100: aload_2
    //   101: aload_1
    //   102: invokevirtual 32	entity/User:getUserName	()Ljava/lang/String;
    //   105: invokevirtual 156	entity/User:setUserName	(Ljava/lang/String;)V
    //   108: aload_2
    //   109: aload_1
    //   110: invokevirtual 44	entity/User:getPassword	()Ljava/lang/String;
    //   113: invokevirtual 159	entity/User:setPassword	(Ljava/lang/String;)V
    //   116: aload_2
    //   117: aload 5
    //   119: ldc -94
    //   121: invokeinterface 148 2 0
    //   126: invokevirtual 164	entity/User:setStoreId	(I)V
    //   129: goto +33 -> 162
    //   132: astore 7
    //   134: aload 7
    //   136: invokevirtual 85	java/sql/SQLException:printStackTrace	()V
    //   139: new 90	java/lang/RuntimeException
    //   142: dup
    //   143: ldc -89
    //   145: invokespecial 94	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   148: athrow
    //   149: astore 8
    //   151: aload_3
    //   152: aload 4
    //   154: aload 5
    //   156: invokestatic 169	utils/JdbcUtilsProperties:close	(Ljava/sql/Connection;Ljava/sql/Statement;Ljava/sql/ResultSet;)V
    //   159: aload 8
    //   161: athrow
    //   162: aload_3
    //   163: aload 4
    //   165: aload 5
    //   167: invokestatic 169	utils/JdbcUtilsProperties:close	(Ljava/sql/Connection;Ljava/sql/Statement;Ljava/sql/ResultSet;)V
    //   170: aload_2
    //   171: areturn
    // Line number table:
    //   Java source line #41	-> byte code offset #0
    //   Java source line #42	-> byte code offset #8
    //   Java source line #43	-> byte code offset #10
    //   Java source line #44	-> byte code offset #13
    //   Java source line #45	-> byte code offset #16
    //   Java source line #46	-> byte code offset #32
    //   Java source line #45	-> byte code offset #49
    //   Java source line #47	-> byte code offset #54
    //   Java source line #49	-> byte code offset #58
    //   Java source line #50	-> byte code offset #66
    //   Java source line #51	-> byte code offset #77
    //   Java source line #52	-> byte code offset #87
    //   Java source line #53	-> byte code offset #100
    //   Java source line #54	-> byte code offset #108
    //   Java source line #55	-> byte code offset #116
    //   Java source line #57	-> byte code offset #132
    //   Java source line #58	-> byte code offset #134
    //   Java source line #59	-> byte code offset #139
    //   Java source line #60	-> byte code offset #149
    //   Java source line #61	-> byte code offset #151
    //   Java source line #62	-> byte code offset #159
    //   Java source line #61	-> byte code offset #162
    //   Java source line #63	-> byte code offset #170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	UserDaoImpl
    //   0	172	1	user	User
    //   7	164	2	userTemp	User
    //   9	154	3	con	Connection
    //   11	153	4	statement	Statement
    //   14	152	5	rs	ResultSet
    //   52	17	6	sql	String
    //   132	3	7	e	SQLException
    //   149	11	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   58	129	132	java/sql/SQLException
    //   58	149	149	finally
  }
  
  public boolean isExist(User user)
  {
    Connection con = null;
    Statement statement = null;
    ResultSet rs = null;
    String sql = "SELECT * FROM user WHERE username = '" + user.getUserName() + "'";
    con = JdbcUtilsProperties.getConnection();
    try
    {
      statement = con.createStatement();
      rs = statement.executeQuery(sql);
      if (rs.next()) {
        return true;
      }
      System.out.println("没有找到用户:" + user.getUserName());
      return false;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("用户---->查询数据失败");
    }
    finally
    {
      JdbcUtilsProperties.close(con, statement, rs);
    }
  }
  
  /* Error */
  public User getUserByStoreId(int id)
  {
    // Byte code:
    //   0: new 33	entity/User
    //   3: dup
    //   4: invokespecial 120	entity/User:<init>	()V
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore 5
    //   16: new 66	java/lang/StringBuilder
    //   19: dup
    //   20: ldc -73
    //   22: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: iload_1
    //   26: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc -128
    //   31: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore 6
    //   39: invokestatic 20	utils/JdbcUtilsProperties:getConnection	()Ljava/sql/Connection;
    //   42: astore_3
    //   43: aload_3
    //   44: invokeinterface 130 1 0
    //   49: astore 4
    //   51: aload 4
    //   53: aload 6
    //   55: invokeinterface 134 2 0
    //   60: astore 5
    //   62: aload 5
    //   64: invokeinterface 140 1 0
    //   69: ifeq +88 -> 157
    //   72: aload_2
    //   73: aload 5
    //   75: ldc -110
    //   77: invokeinterface 148 2 0
    //   82: invokevirtual 152	entity/User:setUserId	(I)V
    //   85: aload_2
    //   86: aload 5
    //   88: ldc -71
    //   90: invokeinterface 187 2 0
    //   95: invokevirtual 156	entity/User:setUserName	(Ljava/lang/String;)V
    //   98: aload_2
    //   99: aload 5
    //   101: ldc -65
    //   103: invokeinterface 187 2 0
    //   108: invokevirtual 159	entity/User:setPassword	(Ljava/lang/String;)V
    //   111: aload_2
    //   112: aload 5
    //   114: ldc -94
    //   116: invokeinterface 148 2 0
    //   121: invokevirtual 164	entity/User:setStoreId	(I)V
    //   124: goto +33 -> 157
    //   127: astore 7
    //   129: aload 7
    //   131: invokevirtual 85	java/sql/SQLException:printStackTrace	()V
    //   134: new 90	java/lang/RuntimeException
    //   137: dup
    //   138: ldc -89
    //   140: invokespecial 94	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   143: athrow
    //   144: astore 8
    //   146: aload_3
    //   147: aload 4
    //   149: aload 5
    //   151: invokestatic 169	utils/JdbcUtilsProperties:close	(Ljava/sql/Connection;Ljava/sql/Statement;Ljava/sql/ResultSet;)V
    //   154: aload 8
    //   156: athrow
    //   157: aload_3
    //   158: aload 4
    //   160: aload 5
    //   162: invokestatic 169	utils/JdbcUtilsProperties:close	(Ljava/sql/Connection;Ljava/sql/Statement;Ljava/sql/ResultSet;)V
    //   165: aload_2
    //   166: areturn
    // Line number table:
    //   Java source line #92	-> byte code offset #0
    //   Java source line #93	-> byte code offset #8
    //   Java source line #94	-> byte code offset #10
    //   Java source line #95	-> byte code offset #13
    //   Java source line #96	-> byte code offset #16
    //   Java source line #97	-> byte code offset #39
    //   Java source line #99	-> byte code offset #43
    //   Java source line #100	-> byte code offset #51
    //   Java source line #101	-> byte code offset #62
    //   Java source line #102	-> byte code offset #72
    //   Java source line #103	-> byte code offset #85
    //   Java source line #104	-> byte code offset #98
    //   Java source line #105	-> byte code offset #111
    //   Java source line #107	-> byte code offset #127
    //   Java source line #108	-> byte code offset #129
    //   Java source line #109	-> byte code offset #134
    //   Java source line #110	-> byte code offset #144
    //   Java source line #111	-> byte code offset #146
    //   Java source line #112	-> byte code offset #154
    //   Java source line #111	-> byte code offset #157
    //   Java source line #113	-> byte code offset #165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	UserDaoImpl
    //   0	167	1	id	int
    //   7	159	2	userTemp	User
    //   9	149	3	con	Connection
    //   11	148	4	statement	Statement
    //   14	147	5	rs	ResultSet
    //   37	17	6	sql	String
    //   127	3	7	e	SQLException
    //   144	11	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	124	127	java/sql/SQLException
    //   43	144	144	finally
  }
}
