package com.pinyougou.manager.controller;

import java.util.List;

import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();
	}

	@RequestMapping("/findpage")
	public PageResult findpage(Integer page,Integer rows){
		return brandService.findpage(page,rows);
	}
	/**
	 * 增加
	 * @param brand
	 * @return
	 */
	public Result add(TbBrand brand){
		try{
			brandService.add(brand);
			return new Result(true,"添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	public void test(){

	}
}
