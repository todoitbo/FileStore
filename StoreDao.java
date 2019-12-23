package dao;

import entity.Store;
import entity.User;

public abstract interface StoreDao
{
  public abstract void addStore(User paramUser);
  
  public abstract Store getStore(User paramUser);
  
  public abstract void upDateCurSize(Store paramStore);
  
  public abstract void deleteFile(Store paramStore);
}
