package com.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.product.domain.Goods;
import com.product.repository.GoodsRepository;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{

	

	//private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private GoodsRepository goodsRepository;

	@Override
	public List<Goods> findAll()
	{
		Iterable<Goods> allGoods = goodsRepository.findAll();
		List<Goods> allGoodsList = new ArrayList<>();
		allGoods.forEach(allGoodsList::add);
		
		return allGoodsList;		
	}
		
	@Override
	public List<Goods> findLatestGoods()
	{
		
		return goodsRepository.findLatestGoods(PageRequest.of(0, 20));
	}
	

	@Override
	public List<Goods> findPreviousGoods(int id)
	{
		return goodsRepository.findPreviousGoods(id, PageRequest.of(0, 20));
	}

	
	@Override
	public Goods saveGoods(final Goods goods)
	{
		Optional <Goods> maybeGoods = Optional.ofNullable(goods);
		
		return goodsRepository.save(maybeGoods.get());
		
		
	}
	@Override
	public Boolean deleteGoods(final int id)
	{
		final Goods deleteGoods = goodsRepository.findById(id).get();
		
		if(deleteGoods == null)
		{
			return false;
		}
		
		goodsRepository.delete(deleteGoods);
		return true;
	}
}























