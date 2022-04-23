package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequisicaoCadastroDto;
import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repository.CadastroRepository;

@Controller
public class CadastroController {

	@Autowired
	private CadastroRepository cadastroRepository;

	@GetMapping
	@RequestMapping("/cadastro")
	public String cadastro(RequisicaoCadastroDto requisicao) {
		return "usuario/form-login";
	}

	@PostMapping("cadastro/cadastrarUsuario")
	public String cadastrar(@Valid RequisicaoCadastroDto requisicao, BindingResult result) {

		if (result.hasErrors()) {
			return "usuario/form-login";
		}
		
		User user = requisicao.toUser();
		cadastroRepository.save(user);
		return "/login";
	}
}
