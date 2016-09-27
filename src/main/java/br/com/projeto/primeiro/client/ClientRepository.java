package br.com.projeto.primeiro.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

	public ClientEntity findByEmail(String email);

	public List<ClientEntity> findByEmailOrName(String email, String name);

}
