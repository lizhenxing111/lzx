package com.tools.demo.generator.tool;

import java.sql.Types;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**  
* @Title 自定义jdbc转换
* @Description 像数据库类型NUMBER>18生成的BigDecimal可以自定义为Long,VARCHAR2定义为String
* @author LZX
* @date 2019年1月22日
*/  
public class MyJavaTypeResolver extends JavaTypeResolverDefaultImpl{

	public MyJavaTypeResolver() {
		super.typeMap.put(Types.DECIMAL, new JdbcTypeInformation("DECIMAL", //$NON-NLS-1$
                new FullyQualifiedJavaType(Long.class.getName())));
		super.typeMap.put(Types.OTHER, new JdbcTypeInformation("OTHER", //$NON-NLS-1$
                new FullyQualifiedJavaType(String.class.getName())));
	}
}
