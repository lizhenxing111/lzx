package com.tools.demo.generator.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tools.demo.generator.dao.TableMapper;
import com.tools.demo.generator.model.DataBaseTable;
import com.tools.demo.generator.model.GeneratorVO;
import com.tools.demo.generator.tool.Generator2;


@RestController
@RequestMapping("/generator")
public class TableGeneraterController {

	@Autowired
	private TableMapper tableMapper;
	
	@RequestMapping("/table")
	@ResponseBody
	public HashMap<String, Object> getDataTable(@RequestParam(value="tableName",required=false) String tableName) throws IOException{
		HashMap<String, Object> resultMap=new HashMap<String, Object>();
		List<String> dataTable = tableMapper.getDataTable(tableName);
		resultMap.put("data", dataTable);
		return resultMap;
	}
	@RequestMapping("/tableCol")
	@ResponseBody
	public HashMap<String, Object> tableCol(@RequestParam String tableName){
		HashMap<String, Object> resultMap=new HashMap<String, Object>();
		List<DataBaseTable> list = tableMapper.getDataTableColum(tableName);
		resultMap.put("tableColum", list);
		return resultMap;
	}
	@RequestMapping("/startGenerator")
	@ResponseBody
	public HashMap<String, Object> startGenerator(GeneratorVO generatorVO){
		HashMap<String, Object> resultMap=new HashMap<String, Object>();
		try {
			new Generator2(generatorVO.getTableNames());
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "no");
			resultMap.put("msg", e.getMessage());
			return resultMap;
		}
		resultMap.put("result", "yes");
		return resultMap;
	}

}
