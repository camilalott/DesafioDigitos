package br.com.projeto.primeiro.clienttype;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.primeiro.clienttype.ClientTypeRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/client-types")
public class ClientTypeResource {

	@Autowired
	private ClientTypeRepository clientTypeRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClientTypeEntity> getClientTypeEntity(@PathVariable Long id) {

		ClientTypeEntity clientTypeEntity = clientTypeRepository.findOne(id);

		if (clientTypeEntity == null) {
			throw new EntityNotFoundException("Cliente não encontrado.");
		}

		return new ResponseEntity<ClientTypeEntity>(clientTypeEntity, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<ClientTypeEntity>> findAll() {

		List<ClientTypeEntity> clientTypeEntity = clientTypeRepository.findAll();

		return new ResponseEntity<List<ClientTypeEntity>>(clientTypeEntity, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ClientTypeEntity> createNewClientTypeEntity(@RequestBody ClientTypeEntity clientTypeEntity) {

		ClientTypeEntity saved = clientTypeRepository.save(clientTypeEntity);

		return new ResponseEntity<ClientTypeEntity>(saved, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ClientTypeEntity> updateClientTypeEntity(@PathVariable Long id, @RequestBody ClientTypeEntity clientTypeEntity) {

		ClientTypeEntity oldClientTypeEntity = clientTypeRepository.findOne(id);

		if (oldClientTypeEntity == null) {
			throw new EntityNotFoundException("Cliente nao encontrado.");
		}

		ClientTypeEntity updated = clientTypeRepository.save(clientTypeEntity);

		return new ResponseEntity<ClientTypeEntity>(updated, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteClientTypeEntity(@PathVariable Long id) {

			clientTypeRepository.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}

