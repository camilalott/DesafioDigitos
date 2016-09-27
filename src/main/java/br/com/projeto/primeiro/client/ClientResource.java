package br.com.projeto.primeiro.client;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.primeiro.clienttype.ClientTypeRepository;

@RestController
@RequestMapping("/clients")
public class ClientResource {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ClientTypeRepository clientTypeRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClientEntity> getClientEntity(@PathVariable Long id) {

		ClientEntity clientEntity = clientRepository.findOne(id);

		if (clientEntity == null) {
			throw new EntityNotFoundException("Cliente não encontrado.");
		}

		return new ResponseEntity<ClientEntity>(clientEntity, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<ClientEntity>> findAll() {

		List<ClientEntity> clientEntity = clientRepository.findAll();

		return new ResponseEntity<List<ClientEntity>>(clientEntity, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ClientEntity> createNewClientEntity(@RequestBody ClientEntity clientEntity) {

		ClientEntity saved = clientRepository.save(clientEntity);

		return new ResponseEntity<ClientEntity>(saved, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ClientEntity> updateClientEntity(@PathVariable Long id, @RequestBody ClientEntity clientEntity) {

		ClientEntity oldClientEntity = clientRepository.findOne(id);

		if (oldClientEntity == null) {
			throw new EntityNotFoundException("Cliente nao encontrado.");
		}

		ClientEntity updated = clientRepository.save(clientEntity);

		return new ResponseEntity<ClientEntity>(updated, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteClientEntity(@PathVariable Long id) {

			clientRepository.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}

