package com.example.hello.repo;

import com.example.hello.model.MessageHello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<MessageHello, Long> {

}
