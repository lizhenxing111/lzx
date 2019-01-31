package com.tools.demo.generator.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tools.demo.generator.model.DataBaseTable;

public interface TableMapper {

	public List<String> getDataTable(@Param("tableName") String tableName);
	
	public List<DataBaseTable> getDataTableColum(String tableName);
}
