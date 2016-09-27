package br.com.projeto.primeiro.clienttype;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientTypeRepository extends JpaRepository<ClientTypeEntity, Long> {

	public ClientTypeEntity findByDescription(String description);


}
