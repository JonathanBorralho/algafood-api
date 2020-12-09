package com.algaworks.algafood.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntityAuditable extends BaseEntity {

	@CreatedDate
	@Column(columnDefinition = "datetime")
	private LocalDateTime dataCriacao;

	@LastModifiedDate
	@Column(columnDefinition = "datetime")
	private LocalDateTime dataAtualizacao;

}
