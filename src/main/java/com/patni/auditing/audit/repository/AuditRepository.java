package com.patni.auditing.audit.repository;

import com.patni.auditing.audit.entity.EntityAudits;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends CrudRepository<EntityAudits, String> {
}
