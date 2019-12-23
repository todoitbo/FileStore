package service;

import dao.FileDao;
import daoImpl.FileDaoImpl;
import entity.Store;
import java.util.List;

public class FileService
{
  FileDao fd = new FileDaoImpl();
  
  public void addFile(int id, String path, java.util.Date date, String name)
  {
    this.fd.addFile(id, path, date, name);
  }
  
  public int isExist(Store store, String path)
  {
    return this.fd.isExist(store, path);
  }
  
  public void upDateFile(Store store, String path, java.util.Date date, int fileId)
  {
    this.fd.upDateFile(store, path, date, fileId);
  }
  
  public List<String> getAllFiles(int storeId)
  {
    return this.fd.getAllFiles(storeId);
  }
  
  public String getFilePath(String name, java.sql.Date date, int storeId)
  {
    return this.fd.getFilePath(name, date, storeId);
  }
  
  public void deleteFile(String name, java.sql.Date date, int storeId)
  {
    this.fd.deleteFile(name, date, storeId);
  }
}
