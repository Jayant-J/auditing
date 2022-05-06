package com.rakuten.auditing.service;

import com.rakuten.auditing.audit.entity.EntityAudits;
import com.rakuten.auditing.audit.repository.AuditRepository;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Aspect
public class AuditService {

    private AuditRepository auditRepository;

    //*return type, package, class, method
    @Pointcut(value = "execution(* com.rakuten.auditing.demo.repository.*.save(..) )")
    public void auditingPointCut() {

    }

    @Around("auditingPointCut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
//        String methodName = pjp.getSignature().getName();
//        String className = pjp.getTarget().getClass().toString();
//        Object object = pjp.getArgs();
//        init
        Object object = pjp.proceed();
        EntityAudits audits = new EntityAudits();
        audits.setId(UUID.randomUUID().toString());
        audits.setChanges(object.toString());
        auditRepository.save(audits);
        return object;
    }

//    public <T> void save(T object) {
//        EntityAudits audits = new EntityAudits();
//        audits.setId(UUID.randomUUID().toString());
//        audits.setChanges(object.toString());
//        auditRepository.save(audits);
//    }
}
