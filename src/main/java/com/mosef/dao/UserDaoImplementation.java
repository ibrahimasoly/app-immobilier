package com.mosef.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mosef.beans.Describ;
import com.mosef.beans.Image;
import com.mosef.beans.Login;
import com.mosef.beans.Service;
import com.mosef.beans.User;


public class UserDaoImplementation implements UserDaoInterface {
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	PreparedStatement preState;
	@Override
	public void saveUser(User user) {
		 connection = null;
		 statement = null;
		 resultSet = null;
		 preState = null;
		try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	          
	        } catch (Exception ex) {
	            // handle the error
	        }
		
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			preState = connection.prepareStatement("insert into users(Nom, Prenom, Telephone, Email, Pasword) "
					+ "values(?,?,?,?,?);");
			preState.setString(1, user.getName());
			preState.setString(2, user.getLastname());
			preState.setString(3, user.getTel());
			preState.setString(4, user.getEmail());
			preState.setString(5, user.getPass());
			preState.execute();
			System.out.println("User saving");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			       
	}

	@Override
	public User findLogin(Login log) {
		connection = null;
		 statement = null;
		 resultSet = null;
		 preState = null;
		 
		 User user = new User();
		 
		try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	 
	        } catch (Exception ex) {
	            // handle the error
	        }
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			statement = connection.createStatement();
			preState = connection.prepareStatement("SELECT idUsers, Nom, Prenom, Telephone, Email, Pasword from users "
					+ "where Nom = ? and Pasword = ? ;");
			preState.setString(1, log.getLogin());
			preState.setString(2, log.getPass());
			resultSet = preState.executeQuery();
			
			if(resultSet.next()) {
				int id = resultSet.getInt("idUsers");
				String nom = resultSet.getString("Nom");
				String prenom = resultSet.getString("Prenom");
				String tel = resultSet.getString("Telephone");
				String mail = resultSet.getString("Email");
				String pass = resultSet.getString("Pasword");
				user = new User(id,nom,prenom,tel,mail,pass);
			}else {
				return null;
			}
          
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> findUsers() {
		 connection = null;
		 statement = null;
		 resultSet = null;
		 preState = null;
		 
		 List<User> users = new ArrayList<User>();
		 User user = new User();
		 
		try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	      
	        } catch (Exception ex) {
	            // handle the error
	        }
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			statement = connection.createStatement();
			preState = connection.prepareStatement("SELECT idUsers, Nom, Prenom, Telephone, Email, Pasword from users;");
			resultSet = preState.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("idUsers");
				String nom = resultSet.getString("Nom");
				String prenom = resultSet.getString("Prenom");
				String tel = resultSet.getString("Telephone");
				String mail = resultSet.getString("Email");
				String pass = resultSet.getString("Pasword");
				user = new User(id,nom,prenom,tel,mail,pass);
				
				users.add(user);
			}
         		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
		connection = null;
		 statement = null;
		 resultSet = null;
		 preState = null;
		 
		 try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	         
	        } catch (Exception ex) {
	            // handle the error
	        }
		 
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			preState = connection.prepareStatement("Delete  from users where idUsers=? ;");
			preState.setInt(1, id);
			preState.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUser(int id) {
		connection = null;
		 statement = null;
		 resultSet = null;
		 preState = null;
		 
		 try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        
	        } catch (Exception ex) {
	            // handle the error
	        }
		 
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			preState = connection.prepareStatement("update users set where idUsers=? ;");
			preState.setInt(1, id);
			preState.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void saveService(Service service, InputStream input) {
		connection = null;
		 statement = null;
		 resultSet = null;
		 preState = null;
		 
		 try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        
	        } catch (Exception ex) {
	            // handle the error
	        }
		 
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			preState = connection.prepareStatement("insert into service(region, localisation, prix, categorie, id_fournisseur, img) "
					+ "values(?,?,?,?,?,?);");
			preState.setString(1, service.getRegion());
			preState.setString(2, service.getLocalisation());
			preState.setDouble(3, service.getPrix());
			preState.setString(4, service.getCategorie());
			preState.setInt(5, service.getId_f());
			preState.setBinaryStream(6, input);
			int r = preState.executeUpdate();
			System.out.println("Resultat :"+r);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void saveImage(int id, InputStream stream) {
		connection = null;
		 statement = null;
		 resultSet = null;
		 preState = null;
		 
		 try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        
	        } catch (Exception ex) {
	            // handle the error
	        }
		 
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			preState = connection.prepareStatement("insert into image(idservice, data)"
					+ "values(?,?);");
			preState.setInt(1, id);
			preState.setBinaryStream(2, stream);
			int r = preState.executeUpdate();
			System.out.println("Resultat :"+r);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void saveDescrib(int idi, Describ describ) {
		connection = null;
		 statement = null;
		 resultSet = null;
		 preState = null;
		 
		 try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        
	        } catch (Exception ex) {
	            // handle the error
	        }
		 
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			preState = connection.prepareStatement("insert into describ(idservice, surface, chambre, salon, douche,cuisine,etage,describ) "
					+ "values(?,?,?,?,?,?,?,?);");
			preState.setInt(1, idi);
			preState.setString(2, describ.getSurface());
			preState.setInt(3, describ.getChambre());
			preState.setInt(4, describ.getSalon());
			preState.setInt(5, describ.getDouche());
			preState.setInt(6, describ.getCuisine());
			preState.setInt(7, describ.getEtage());
			preState.setString(8, describ.getDescrib());
			preState.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Service> findService() {
		connection = null;
		 statement = null;
		 resultSet = null;
		 preState = null;
		 
		 List<Service> services = new ArrayList<Service>();
		 
		 try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        
	        } catch (Exception ex) {
	            // handle the error
	        }
		 
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			preState = connection.prepareStatement("SELECT id,region,localisation,prix,categorie,img from service order by id desc;");
			resultSet = preState.executeQuery();
			
			while(resultSet.next()) {
				int idi = resultSet.getInt("id");
				String region = resultSet.getString("region");
				String local = resultSet.getString("localisation");
				Double prix = resultSet.getDouble("prix");
				String cat = resultSet.getString("categorie");
				InputStream input = resultSet.getBinaryStream("img");
				byte[] img = new byte[input.available()];
				input.read(img);
				Service service = new Service(idi, region, local, prix, cat, img);
				
				services.add(service);
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return services;
	}

	@Override
	public List<Image> findImageByIdService(int id) {
		connection = null;
		 statement = null;
		 resultSet = null;
		 preState = null;
		 
         List<Image> images = new ArrayList<Image>();
		 
		 try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        
	        } catch (Exception ex) {
	            // handle the error
	        }
		 
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			preState = connection.prepareStatement("SELECT idservice, data from image where idservice = ?;");
			preState.setInt(1, id);
			resultSet = preState.executeQuery();
			
			while(resultSet.next()) {
				int idi  = resultSet.getInt("idservice");
				InputStream input = resultSet.getBinaryStream("data");
				byte[] img = new byte[input.available()];
				input.read(img);
				
			   Image image = new Image(idi, img);
			   images.add(image);
			}
			
		 } catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 
		  return images;
	}

	@Override
	public Describ findDescribByIdService(int id) {
		connection = null;
		 statement = null;
		 resultSet = null;
		 preState = null;
		 
		 Describ describ = new Describ();
		 try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        
	        } catch (Exception ex) {
	            // handle the error
	        }
		 
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			preState = connection.prepareStatement("SELECT idservice, surface, chambre, salon, douche, cuisine, etage, describ from describ where idservice = ?;");
			preState.setInt(1, id);
			resultSet = preState.executeQuery();
			if(resultSet.next()) {
				describ = new Describ(resultSet.getInt("idservice"), resultSet.getString("surface"), 
						resultSet.getInt("chambre"), resultSet.getInt("salon"), resultSet.getInt("douche"), 
						resultSet.getInt("cuisine"), resultSet.getInt("etage"), resultSet.getString("describ"));
			}
			
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		return describ;
	}

	@Override
	public int serviceLastId(int id) {
		connection = null;
		 int rst = 0;
		 resultSet = null;
		 preState = null;
		
		 try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        
	        } catch (Exception ex) {
	            // handle the error
	        }
		 
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			preState = connection.prepareStatement("SELECT * from service");
			resultSet = preState.executeQuery();
			
			while(resultSet.next()) {
			rst++;			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return rst++;
		
	}

	@Override
	public void deleteService(int id) {
		connection = null;
		 resultSet = null;
		 preState = null;
		
		 try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        
	        } catch (Exception ex) {
	            // handle the error
	        }
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			preState = connection.prepareStatement("delete from service where id = ?");
			preState.setInt(1, id);
			int rowsAffected = preState.executeUpdate();
			if (rowsAffected > 0) {
		        System.out.println(rowsAffected + " ligne(s) supprimée(s) avec succès.");
		    } else {
		        System.out.println("Aucune ligne supprimée.");
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	@Override
	public List<Service> findServiceById(int id) throws IOException {
		connection = null;
		 statement = null;
		 resultSet = null;
		 preState = null;
		 
		 List<Service> services = new ArrayList<Service>();
		 
		 try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        
	        } catch (Exception ex) {
	            // handle the error
	        }
		 
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			preState = connection.prepareStatement("SELECT id,region,localisation,prix,categorie,img from service where id= ?;");
			preState.setInt(1, id);
			resultSet = preState.executeQuery();
			
			while(resultSet.next()) {
				int idi = resultSet.getInt("id");
				String region = resultSet.getString("region");
				String local = resultSet.getString("localisation");
				Double prix = resultSet.getDouble("prix");
				String cat = resultSet.getString("categorie");
				InputStream input = resultSet.getBinaryStream("img");
				byte[] img = new byte[input.available()];
				input.read(img);
				Service service = new Service(idi, region, local, prix, cat, img);
				
				services.add(service);
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return services;
	}

	@Override
	public List<Service> findServiceByIdfournisseur(int id) throws IOException {
		connection = null;
		 statement = null;
		 resultSet = null;
		 preState = null;
		 
		 List<Service> services = new ArrayList<Service>();
		 
		 try {
			   
	          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        
	        } catch (Exception ex) {
	            // handle the error
	        }
		 
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root&password=root");
			preState = connection.prepareStatement("SELECT id,region,localisation,prix,categorie,img from service where id_fournisseur= ?;");
			preState.setInt(1, id);
			resultSet = preState.executeQuery();
			
			while(resultSet.next()) {
				int idi = resultSet.getInt("id");
				String region = resultSet.getString("region");
				String local = resultSet.getString("localisation");
				Double prix = resultSet.getDouble("prix");
				String cat = resultSet.getString("categorie");
				InputStream input = resultSet.getBinaryStream("img");
				byte[] img = new byte[input.available()];
				input.read(img);
				Service service = new Service(idi, region, local, prix, cat, img);
				
				services.add(service);
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return services;
	}

}
