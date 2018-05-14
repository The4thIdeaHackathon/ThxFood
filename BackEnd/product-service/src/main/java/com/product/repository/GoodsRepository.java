package com.product.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.product.domain.Goods;

public interface GoodsRepository extends CrudRepository<Goods, Integer>{

	
	@Query("SELECT g FROM Goods g ORDER BY id DESC")
	List<Goods> findLatestGoods(Pageable pageable);
	
	@Query("SELECT g FROM Goods g WHERE g.id < :id ORDER BY g.id DESC")
	List<Goods> findPreviousGoods(@Param("id") int id, Pageable pageable);
	
	

}
