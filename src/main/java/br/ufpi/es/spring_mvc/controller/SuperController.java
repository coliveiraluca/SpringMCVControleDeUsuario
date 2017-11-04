package br.ufpi.es.spring_mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufpi.es.spring_mvc.model.User;
import br.ufpi.es.spring_mvc.controller.UsersController;
import br.ufpi.es.spring_mvc.data.*;

@Controller
public class SuperController {
	private RepositoryListUsers repository;
	private UsersController controller;

	public SuperController(){
		repository = new RepositoryListUsers();
        repository.populateUsers();
        controller = new UsersController(repository);
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String processarLogin(User user, HttpSession session, Model model){

		String email;
		String password;

		email = user.getEmail();
		password = user.getPassword();

		User userDAO = controller.search(email, password);

		if (userDAO != null){
			session.setAttribute("UsuarioAtivo", email);
			model.addAttribute("mensagem", "Bemvindo " + email);

			return "mainPage";
		}else{
			model.addAttribute("mensagem", "Usuario nao encontrado");
			return "loginForm";
		}
	}

	@RequestMapping(value="/deleteGivenUser", method=RequestMethod.POST)
	public String deleteGivenUser(User user, HttpSession session, Model model){

		String name;
		String password;

		name = user.getName();
		password = user.getPassword();

		controller.remove(user);
		User userDAO = controller.search(name, password);

		//TODO
	}

	@RequestMapping(value="/loginForm")
	public String loadFormLogin(){
		return "loginForm";
	}

	@RequestMapping(value="/addUser")
	public String loadNewUserForm(){
		return "addUser";
	}

	@RequestMapping(value="/addNewUser", method=RequestMethod.POST)
	public String addNewUser(User user, HttpSession session, Model model){

	    String email;

		email = user.getEmail();
		if(controller.searchEmail(email) == null) {
			controller.insert(user);
			return "mainPage";
		}
		else{
			model.addAttribute("mensagem", "Email ja cadastrado");
			return "loginForm";
		}
	}

	@RequestMapping(value="/searchUsersForm", method=RequestMethod.POST)
	public String searchByEmail(User user, HttpSession session, Model model){
			String email;

		email = user.getEmail();
		User userDAO = controller.searchEmail(email);
		if (userDAO == null){
			model.addAttribute("mensagem", "Usuario nao encontrado");
			return "searchUser";
		}else{
			model.addAttribute("mensagem", "Nome: " + userDAO.getName() + "|| Email: " + userDAO.getEmail() + "|| Login: " + userDAO.getLogin());
			return "searchUser";
		}
	}

	@RequestMapping(value="/listUsers", method=RequestMethod.GET)
	public String listOfUsers(User user, HttpSession session, Model model){

		String allUserNames = controller.allUserNames();
	    String email;

		email = user.getEmail();

		model.addAttribute("mensagem", "Usuarios: " + allUserNames);

		return "listUsers";
	}

	@RequestMapping(value="/searchUsers")
	public String loadSearchUserForm(){
		return "searchUser";
	}



	@RequestMapping(value="/deleteUser")
	public String loadDeleteUserForm(){
		return "deleteUser";
	}



	@RequestMapping(value="/logout")
	public String processarLogout(HttpSession session) {
		String userName;

		userName = session.getAttribute("UsuarioAtivo").toString();
		session.invalidate();
		System.out.println("Usuario " + userName + " saiu!");
		return "loginForm";
	}
}
