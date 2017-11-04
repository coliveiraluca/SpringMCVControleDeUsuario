package br.ufpi.es.spring_mvc.data;

import java.util.List;

import br.ufpi.es.spring_mvc.model.*;

import java.util.LinkedList;

public class RepositoryListUsers implements IRepositoryUsers{
	List<User> usersList = new LinkedList<User>();

	public void autoPopulate() {
		User u1 = new User();
				u1.setId(1);
				u1.setName("Armando Soares Sousa");
				u1.setLogin("armando");
				u1.setPassword("armando");
				u1.setEmail("armando@ufpi.edu.br");

				User u2 = new User();
				u2.setId(2);
				u2.setName("Luca Carvalho de Oliveira");
				u2.setLogin("luca");
				u2.setPassword("luca");
				u2.setEmail("luca@ufpi.edu.br");

				User u3 = new User();
				u3.setId(3);
				u3.setName("Luiz Carlos Carvalho de Oliveira");
				u3.setLogin("luiz");
				u3.setPassword("luiz");
				u3.setEmail("luiz@ufpi.edu.br");

				User u4 = new User();
				u4.setId(4);
				u4.setName("Andrea Tupinamba");
				u4.setLogin("andrea");
				u4.setPassword("andrea");
				u4.setEmail("andrea@ufpi.edu.br");

				User u5 = new User();
				u5.setId(5);
				u5.setName("Isadora Tupinamba");
				u5.setLogin("isadora");
				u5.setPassword("isadora");
				u5.setEmail("isadora@ufpi.edu.br");

				this.usersList.add(u1);
				this.usersList.add(u2);
				this.usersList.add(u3);
				this.usersList.add(u4);
				this.usersList.add(u5);
	}


	public void insert(User u) {
		usersList.add(u);
	}

	public List<User> list() {
		return usersList;
	}

	public User search(String email, String password) {
		User user = null;
		for(User u:usersList) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				user = u;
				return user;
			}
		}
		return user;
	}
	public User searchEmail(String email) {
		User user = null;
		for(User u:usersList) {
			if(u.getEmail().equals(email)) {
				user = u;
				return user;
			}
		}
		return user;
	}

	public String stringUsersList() {
		String allUserNames = "";
		for(User u:usersList) {
			allUserNames += "|| " + u.getName() + "\n";
			System.out.println(u.getName());
		}
		return allUserNames;
	}

	public List<User> searchByContentAndType(String content, String type) {
		List<User> list = new LinkedList<User>();
		switch(type) {
		case "name":
			for (User u:usersList) {
				if (u.getName().equals(content)) {
					list.add(u);
				}
			}
			break;
		case "email":
			for(User u:usersList) {
				if (u.getEmail().equals(content)) {
					list.add(u);
				}
			}
			break;
		case "login":
			for(User u:usersList) {
				if(u.getLogin().equals(content)) {
					list.add(u);
				}
			}
			break;
		default:
			list = null;
			break;
		}
		return list;
	}

	public void delete(User u) {
		usersList.remove(u);
	}


}
