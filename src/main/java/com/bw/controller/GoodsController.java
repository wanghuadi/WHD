package com.bw.controller;

import java.util.List;

import com.bw.entity.Brand;
import com.bw.entity.Category;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.entity.Goods;
import com.bw.service.GoodsService;

@Controller
public class GoodsController {

	@Resource
	private GoodsService service;
	
	@RequestMapping("queryGoodsAll.do")
	public String queryGoodsAll(Model model){
		List<Goods> list = service.queryGoodsAll();
		model.addAttribute("list", list); 
		//  test  github

		System.out.println("vhjjj");



		System.out.println("afafasfsf");


		//wanghuadi   测试冲突
		System.out.println("华帝真帅");

		System.out.println("666");
//github.com/wanghuadi/WHD.git
		return "index";
	}
	
	
	@RequestMapping("queryCatAll.do")
	@ResponseBody
	public List<Category> queryCatAll(){
		 List<Category> list = service.queryCatAll();
		 return list;
	}
	
	@RequestMapping("queryBrandByCid.do")
	@ResponseBody
	public List<Brand> queryBrandByCid(Integer cid){
		 List<Brand> list = service.queryBrandByCid(cid);
		 return list;
	}
	
	
	@RequestMapping("addGoods.do")
	@ResponseBody
	public boolean addGoods(Goods goods){
		boolean flg = service.addGoods(goods);
		return flg;
	}
	
	
	
}
