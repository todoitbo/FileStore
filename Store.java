package entity;

import java.util.List;

public class Store
{
  private int storeId;
  private int maxSize;
  private int curSize;
  private String userName;
  private List<String> filesPath;
  
  public Store() {}
  
  public Store(int maxSize, int curSize, String userName)
  {
    this.maxSize = maxSize;
    this.curSize = curSize;
    this.userName = userName;
  }
  
  public Store(int storeId, int maxSize, int curSize, String userName)
  {
    this.storeId = storeId;
    this.maxSize = maxSize;
    this.curSize = curSize;
    this.userName = userName;
  }
  
  public Store(int storeId, int maxSize, int curSize, String userName, List<String> filesPath)
  {
    this.storeId = storeId;
    this.maxSize = maxSize;
    this.curSize = curSize;
    this.userName = userName;
    this.filesPath = filesPath;
  }
  
  public int getStoreId()
  {
    return this.storeId;
  }
  
  public void setStoreId(int storeId)
  {
    this.storeId = storeId;
  }
  
  public int getMaxSize()
  {
    return this.maxSize;
  }
  
  public void setMaxSize(int maxSize)
  {
    this.maxSize = maxSize;
  }
  
  public int getCurSize()
  {
    return this.curSize;
  }
  
  public void setCurSize(int curSize)
  {
    this.curSize = curSize;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public List<String> getFilesPath()
  {
    return this.filesPath;
  }
  
  public void setFilesPath(List<String> filesPath)
  {
    this.filesPath = filesPath;
  }
  
  public String toString()
  {
    return 
    
      "Store [storeId=" + this.storeId + ", maxSize=" + this.maxSize + ", curSize=" + this.curSize + ", userName=" + this.userName + ", filesPath=" + this.filesPath + "]";
  }
}
