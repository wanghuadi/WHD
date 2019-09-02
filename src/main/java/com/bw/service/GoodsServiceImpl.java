package com.bw.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.entity.Brand;
import com.bw.entity.Category;
import com.bw.entity.Goods;
import com.bw.mapper.GoodsDao;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Resource
	private GoodsDao dao;
	
	public List<Goods> queryGoodsAll() {
		return dao.queryGoodsAll();
	}

	public List<Category> queryCatAll() {
		return dao.queryCatAll();
	}

	public List<Brand> queryBrandByCid(Integer cid) {
		return dao.queryBrandByCid(cid);
	}

	public boolean addGoods(Goods goods) {
		
		Integer num = dao.addGoods(goods);
		
		return num>0?true:false;
	}

}
