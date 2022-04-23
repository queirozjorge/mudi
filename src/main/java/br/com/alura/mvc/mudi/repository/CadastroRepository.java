package br.com.alura.mvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.mvc.mudi.model.User;

public interface CadastroRepository extends JpaRepository<User, String> {

}
