package com.rakuten.auditing.audit.repository;

import com.rakuten.auditing.audit.entity.EntityAudits;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends CrudRepository<EntityAudits, String> {
}
