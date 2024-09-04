package com.mosef.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.mosef.beans.Describ;
import com.mosef.beans.Image;
import com.mosef.beans.Login;
import com.mosef.beans.Service;
import com.mosef.beans.User;

public interface UserDaoInterface {
  void saveUser(User user);
  User findLogin(Login log);
  List<User> findUsers();
  void deleteUser(int id);
  void updateUser(int id);
  
  void saveService(Service service, InputStream stream);
  void saveImage(int id, InputStream stream);
  void saveDescrib(int id, Describ describ);
  
  List<Service> findService();
  List<Image> findImageByIdService(int id);
  Describ findDescribByIdService(int id);
  List<Service> findServiceById(int id) throws IOException;
  List<Service> findServiceByIdfournisseur(int id) throws IOException;
  
  int serviceLastId(int id); 
  void deleteService(int id);
}
