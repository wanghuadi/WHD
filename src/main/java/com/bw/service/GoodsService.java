package com.bw.service;

import java.util.List;

import com.bw.entity.Brand;
import com.bw.entity.Category;
import com.bw.entity.Goods;

public interface GoodsService {

	List<Goods> queryGoodsAll();

	List<Category> queryCatAll();

	List<Brand> queryBrandByCid(Integer cid);

	boolean addGoods(Goods goods);
}
