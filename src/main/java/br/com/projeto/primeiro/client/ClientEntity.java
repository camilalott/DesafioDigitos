package br.com.projeto.primeiro.client;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.projeto.primeiro.clienttype.ClientTypeEntity;
import br.com.projeto.primeiro.utils.BaseEntity;

/* BaseEntity<Long> - Portanto a chave primaria da tabela é do tipo long.
 * Tipo da chave primaria da tabela define o tipo da chave primaria da entidade.
 * @Table - Utilizado quando o nome da chave primaria for diferente de ID, como o nome é pk_id
 */

@Entity
@Table(name = "tb_client")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class ClientEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 201602010251L;

	//	@NotNull
	//	@Size(min = 4, max = 255)
	@Column(name = "name", length = 255, nullable = false)
	private String name;

	//	@Email
	@Column(name = "phone", length = 20)
	private String phone;

	//	@Email
	@Column(name = "email", length = 255)
	private String email;

	//	@NotNull
	@ManyToOne
	@JoinColumn(name = "client_type_id", nullable = false)
	private ClientTypeEntity clientType;

	public ClientEntity() {
	}

	public ClientEntity(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ClientTypeEntity getClientType() {
		return clientType;
	}

	public void setClientType(ClientTypeEntity clientType) {
		this.clientType = clientType;
	}
}
