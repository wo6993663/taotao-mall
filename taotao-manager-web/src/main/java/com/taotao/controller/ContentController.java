package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

/**
 * 内容管理Controller
 * <p>Title: ContentController</p>
 * <p>Description: </p>
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content) {
		TaotaoResult result = contentService.insertContent(content);
		return result;
	}
	@RequestMapping("/query/list")
	@ResponseBody
	public EUDataGridResult getItemList(long categoryId,Integer page, Integer rows) {
		EUDataGridResult result = contentService.getContentList(categoryId,page, rows);
		return result;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContent(long ids) {
		TaotaoResult result = contentService.deleteContent(ids);
		return result;
	}
}
