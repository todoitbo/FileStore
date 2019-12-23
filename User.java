package entity;

public class User
{
  private int userId;
  private String userName;
  private String password;
  private int storeId;
  
  public User() {}
  
  public User(String userName, String password)
  {
    this.userName = userName;
    this.password = password;
  }
  
  public User(int userId, String userName, String password, int storeId)
  {
    this.userId = userId;
    this.userName = userName;
    this.password = password;
    this.storeId = storeId;
  }
  
  public int getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(int userId)
  {
    this.userId = userId;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public int getStoreId()
  {
    return this.storeId;
  }
  
  public void setStoreId(int storeId)
  {
    this.storeId = storeId;
  }
  
  public String toString()
  {
    return 
      "User [userId=" + this.userId + ", userName=" + this.userName + ", password=" + this.password + ", storeId=" + this.storeId + "]";
  }
}
