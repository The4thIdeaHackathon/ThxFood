package com.product.service;

import java.util.List;

import com.product.domain.Goods;

public interface GoodsService {

	
	List<Goods> findLatestGoods();
	List<Goods> findPreviousGoods(int id);
	List<Goods> findAll();
	
	Goods saveGoods(Goods goods);
	
	Boolean deleteGoods(int id);
	
	//List<Bread> findLatestBread();
//	List<Bread> findPreviousBread(int id);

//	List<Pizza> findLatestPizza();
//	List<Pizza> findPreviousPizza(int id);
	
}
