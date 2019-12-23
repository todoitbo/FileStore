package service;

import dao.StoreDao;
import daoImpl.StoreDaoImpl;
import entity.Store;

public class StoreService
{
  StoreDao sd = new StoreDaoImpl();
  
  public void addFile(Store store)
  {
    this.sd.upDateCurSize(store);
  }
  
  public void deleFile(Store store)
  {
    this.sd.deleteFile(store);
  }
}
