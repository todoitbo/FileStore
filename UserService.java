package service;

import dao.StoreDao;
import dao.UserDao;
import daoImpl.StoreDaoImpl;
import daoImpl.UserDaoImpl;
import entity.Store;
import entity.User;

public class UserService
{
  StoreDao sd = new StoreDaoImpl();
  UserDao ud = new UserDaoImpl();
  
  public void register(User user)
  {
    this.sd.addStore(user);
    Store store = this.sd.getStore(user);
    this.ud.addUser(user, store);
  }
  
  public User login(User user)
  {
    return this.ud.getUser(user);
  }
  
  public boolean isExist(User user)
  {
    return this.ud.isExist(user);
  }
  
  public Store getStore(User user)
  {
    return this.sd.getStore(user);
  }
  
  public User getUserByStoreId(int id)
  {
    return this.ud.getUserByStoreId(id);
  }
}
