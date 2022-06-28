package com.prova.leonardojunior.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.prova.leonardojunior.model.Auditing;

@Repository
public interface AuditingRepository extends MongoRepository<Auditing, String> {

}
