package br.com.projeto.primeiro.clienttype;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.projeto.primeiro.utils.BaseEntity;


@Entity
@Table(name = "tb_client_type")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class ClientTypeEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 201602010251L;

	@NotNull
	@Size(min = 4, max = 45)
	@Column(name = "description", length = 45, nullable = false)
	private String description;

	public ClientTypeEntity() {
	}

	public ClientTypeEntity(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
