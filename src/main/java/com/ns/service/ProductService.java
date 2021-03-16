package com.ns.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ns.entity.Product;
import com.ns.repo.ProductRepo;

@Service
@Transactional
public class ProductService 
{
	@Autowired
	private ProductRepo repo;
	
	public List<Product> listAll(String keyword)
	{
		if(keyword!= null)
		{
			return repo.search(keyword);
		}
		return repo.findAll();
	}
	
	public void save(Product product)
	{
		repo.save(product);
	}
	
	public Product getProduct(long id)
	{
		return repo.findById(id).get();	
	}
	
	public void delete(long id)
	{
		 repo.deleteById(id);
	}
	
}
