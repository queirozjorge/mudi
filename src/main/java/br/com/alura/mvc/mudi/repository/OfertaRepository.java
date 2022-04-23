package br.com.alura.mvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.mvc.mudi.model.Oferta;

public interface OfertaRepository extends JpaRepository<Oferta, Long> {
	
}
