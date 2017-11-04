package br.ufpi.es.spring_mvc.controller;

import br.ufpi.es.spring_mvc.model.User;

import java.util.List;

import br.ufpi.es.spring_mvc.data.*;

public class UsersController {
	IRepositoryUsers repository;

	public usersController(IRepositoryUsers type){
		this.repository = type;
	}

	public List<User> getUsers(){
		return repository.list();
	}


	public User search(String login, String password){
		return repository.search(login, password);
	}


	public User searchEmail(String email){
		return repository.searchEmail(email);
	}


	public List<User> searchByContentAndType(String content, String type){
		return repository.searchByContentAndType(content, type);
	}


	public void insert(User u) {
		this.repository.insert(u);
	}


	public void delete(User u) {
		this.repository.delete(u);
	}

	public String allUserNames() {
		return repository.stringUsersList();
	}
}
