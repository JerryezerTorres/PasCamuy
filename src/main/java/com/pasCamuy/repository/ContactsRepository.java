package com.pasCamuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasCamuy.model.Contacts;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Integer> {

}
