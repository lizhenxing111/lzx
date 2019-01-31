package com.tools.demo.generator.model;

/**  
* @Title 数据库中的序列
* @Description 
* @author LZX
* @date 2019年1月24日
*/  
public class Sequence {
	/**
	 * 序列名称
	 */
	private String SequenceName;
	/**
	 * 当前序列最后一个数值
	 */
	private String lastNumber;
	/**
	 * 序列的最小值
	 */
	private String minValue;
	/**
	 * 序列的最大值
	 */
	private String maxValue;
	public String getSequenceName() {
		return SequenceName;
	}
	public void setSequenceName(String sequenceName) {
		SequenceName = sequenceName;
	}
	public String getLastNumber() {
		return lastNumber;
	}
	public void setLastNumber(String lastNumber) {
		this.lastNumber = lastNumber;
	}
	public String getMinValue() {
		return minValue;
	}
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	public String getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	
}
