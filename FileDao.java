package dao;

import entity.Store;
import java.util.List;

public abstract interface FileDao
{
  public abstract void addFile(int paramInt, String paramString1, java.util.Date paramDate, String paramString2);
  
  public abstract int isExist(Store paramStore, String paramString);
  
  public abstract void upDateFile(Store paramStore, String paramString, java.util.Date paramDate, int paramInt);
  
  public abstract List<String> getAllFiles(int paramInt);
  
  public abstract String getFilePath(String paramString, java.sql.Date paramDate, int paramInt);
  
  public abstract void deleteFile(String paramString, java.sql.Date paramDate, int paramInt);
}
