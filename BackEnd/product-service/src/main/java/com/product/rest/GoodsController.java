package com.product.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;

import com.product.domain.Goods;
import com.product.service.GoodsService;

@RestController
public class GoodsController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GoodsService goodsService;
	
	
	//@CrossOrigin(origins="http://localhost:8080")
	@CrossOrigin(origins="*")
	@RequestMapping(value="/product/", method = RequestMethod.GET)
	public ResponseEntity<List<Goods>> getLatestGoods()
	{
		
		final List<Goods> latestGoods = goodsService.findLatestGoods();
		
		logger.info("Get Product");
		if (latestGoods.isEmpty())
		{
			return new ResponseEntity<List<Goods>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity <List<Goods>>(latestGoods, HttpStatus.OK);
	}
	
	
	//@CrossOrigin(origins="http://localhost:8080")
	@CrossOrigin(origins="*")
	@RequestMapping(value="/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Goods>> getPreviousGoods(@PathVariable("id") int id)
	{
		final List<Goods> previousGoods = goodsService.findPreviousGoods(id);
		
		if (previousGoods.isEmpty())
		{
			return new ResponseEntity<List<Goods>>(HttpStatus.NOT_FOUND);
		}
		
		
		
		return new ResponseEntity<List<Goods>>(previousGoods, HttpStatus.OK);
		
		
	}
	
	//@CrossOrigin(origins="http://localhost:8080")
	//@CrossOrigin
	@CrossOrigin(origins="*")
	@RequestMapping(value= "/product", method = RequestMethod.POST,
					      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
								        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})//	@RequestMapping(value= "/product", method = RequestMethod.POST)
	public ResponseEntity <Void> createGoods(/*@RequestBody*/ final Goods goods,
			final UriComponentsBuilder ucBuilder){
		
		final Goods savedGoods = goodsService.saveGoods(goods);
		
		logger.info("input goods"+ savedGoods.getStore());
		logger.info("input goods"+ savedGoods.getProduct());
		logger.info("input goods"+ savedGoods.getHtpurchase());
		logger.info("input goods"+ savedGoods.getAmount());
		logger.info("input goods"+ savedGoods.getPrice());

		final HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(savedGoods.getId()).toUri());
		
		return new ResponseEntity<Void> (headers, HttpStatus.CREATED);
	}
	
	//@CrossOrigin(origins = "http://localhost:8080")
	@CrossOrigin(origins="*")
	@RequestMapping(value= "/product/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteGoods (@PathVariable("id") final int id)
	{
	
		Boolean deleteResult =  goodsService.deleteGoods(id);
		if(deleteResult ==null || !deleteResult)
		{
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Void> (HttpStatus.OK);
	}
	
}















