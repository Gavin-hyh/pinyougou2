package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;

	@Transactional
	@Override
	public List<TbBrand> findAll() {
		//return null;
		return brandMapper.selectByExample(null);
	}

	@Override
	public PageResult findpage(int PageNum, int pageSize) {
		PageHelper.startPage(PageNum,pageSize);
		Page<TbBrand> brandpage =(Page<TbBrand>) brandMapper.selectByExample(null);
		return new PageResult(brandpage.getTotal(),brandpage.getResult());
	}

	@Override
	public void add(TbBrand brand) {
		brandMapper.insert(brand);
	}

}
