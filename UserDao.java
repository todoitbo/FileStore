package dao;

import entity.Store;
import entity.User;

public abstract interface UserDao
{
  public abstract void addUser(User paramUser, Store paramStore);
  
  public abstract User getUser(User paramUser);
  
  public abstract boolean isExist(User paramUser);
  
  public abstract User getUserByStoreId(int paramInt);
}
