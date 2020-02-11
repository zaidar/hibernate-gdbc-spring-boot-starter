package com.newapp.newappart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newapp.newappart.model.Item;

@Repository
public interface ItemDAO extends JpaRepository<Item, Integer>{
	
	
}
