package com.newapp.newappart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newapp.newappart.dao.ItemDAO;
import com.newapp.newappart.model.Item;

@RestController
@RequestMapping("/api")
public class ItemController {
	
	@Autowired
	ItemDAO itemDAO;
	
	@GetMapping("/employee")
	public List<Item> get(){
		return itemDAO.findAll();
	}
	
	@PostMapping("/employee")
	public Item save(@RequestBody Item itemObj) {
		return itemDAO.save(itemObj);
	}
	
	@GetMapping("/employee/{id}")
	public Item get(@PathVariable int id) {
		Optional<Item> item = itemDAO.findById(id);
		if(item.isPresent()) {
			return item.get();
		}else {
			throw new RuntimeException("Employee not found for the id "+id);
		}
	}
	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		Optional<Item> item = itemDAO.findById(id);
		if(item.isPresent()) {
			itemDAO.delete(item.get());
			return "Employee is deleted with id "+id;
		}else {
			throw new RuntimeException("Employee not found for the id "+id);
		}
	}
	
	@PutMapping("/employee")
	public Item update(@RequestBody Item itemObj) {
		return itemDAO.save(itemObj);
	}
	
}
