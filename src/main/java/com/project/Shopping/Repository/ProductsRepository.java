package com.project.Shopping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.Shopping.Model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

	List<Products> findByCategory(String category);
	 @Query(value = "select * from productdetails where productname like %?1%", nativeQuery = true)
	List<Products> findByProducts(String Productname);

	
}
