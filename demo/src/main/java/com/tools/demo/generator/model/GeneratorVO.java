package com.tools.demo.generator.model;

import java.util.List;

/**  
* @Title 生成代码实体类
* @Description 
* @author LZX
* @date 2019年1月23日
*/  
public class GeneratorVO {

	/**
	 * 生成位置(项目路径)
	 */
	private String projectPath;
	/**
	 * 实体生成包
	 */
	private String modelPackage;
	/**
	 * dao生成包
	 */
	private String daoPackage;
	/**
	 * mapper.xml生成包
	 */
	private String xmlPackage;
	
	/**
	 * 表名集合
	 */
	private List<String> tableNames;
	
	public List<String> getTableNames() {
		return tableNames;
	}
	public void setTableNames(List<String> tableNames) {
		this.tableNames = tableNames;
	}
	public String getProjectPath() {
		return projectPath;
	}
	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}
	public String getModelPackage() {
		return modelPackage;
	}
	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}
	public String getDaoPackage() {
		return daoPackage;
	}
	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}
	public String getXmlPackage() {
		return xmlPackage;
	}
	public void setXmlPackage(String xmlPackage) {
		this.xmlPackage = xmlPackage;
	}
	
}
