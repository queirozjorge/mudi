package br.com.alura.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCrypt;

import br.com.alura.mvc.mudi.model.User;

public class RequisicaoCadastroDto {

	@NotBlank(message = "O campo usuário é obrigatório!")
	private String username;

	@NotBlank(message = "O campo senha é obrigatório!")
	@Size(min = 4, max = 6, message = "Senha deve conter entre 4 e 6 caracteres!")
	private String password;

	@NotBlank(message = "O campo confirmar senha é obrigatório!")
	private String passwordConfirm;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public User toUser() {
		User user = new User();
		user.setUsername(this.username);
		user.setEnabled(true);
		String hashPassword = BCrypt.hashpw(this.password, BCrypt.gensalt());
		user.setPassword(hashPassword);
		return user;
	}
}
