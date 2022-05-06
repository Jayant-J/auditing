package com.rakuten.auditing.audit.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENTITY_AUDITS")
@Data
@NoArgsConstructor
public class EntityAudits extends Auditable<String> {

    @Id
    String id;

    String changes;
}
