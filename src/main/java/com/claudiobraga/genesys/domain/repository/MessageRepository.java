package com.claudiobraga.genesys.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claudiobraga.genesys.domain.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

}
