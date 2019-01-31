package com.tools.demo.generator.tool;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.JavaTypeResolverConfiguration;
import org.mybatis.generator.config.ModelType;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Generator2 {
	public Generator2(List<String> tableNames) throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		
		Configuration config = new Configuration();
		
		
		Context context = new Context(ModelType.getModelType("flat"));
		//基本配置
		context.setId("sacGenerator");
		context.setTargetRuntime("MyBatis3Simple");
		context.addProperty("javaFileEncoding", "UTF-8");
		context.addProperty("useMapperCommentGenerator", "false");
		
		//插件配置
		PluginConfiguration pluginConfiguration=new PluginConfiguration();
		pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
		pluginConfiguration.addProperty("mappers", "com.tools.demo.common.GlobleBaseMapper");//超级接口
		pluginConfiguration.addProperty("caseSensitive", "true");//区分大小写
		pluginConfiguration.addProperty("forceAnnotation", "true");//注释
		//pluginConfiguration.addProperty("lombok", "@Getter,@Setter,@ToString,@Accessors");lombok格式实体
		context.addPluginConfiguration(pluginConfiguration);
		
		//数据库配置(此数据源取项目数据源)
		JDBCConnectionConfiguration jdbc=new JDBCConnectionConfiguration();
		jdbc.setDriverClass("com.mysql.cj.jdbc.Driver");
		jdbc.setConnectionURL("jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC");
		jdbc.setUserId("root");
		jdbc.setPassword("123456");
		context.setJdbcConnectionConfiguration(jdbc);
		//全局生成附加东西的配置
		CommentGeneratorConfiguration commentGeneratorConfiguration=new CommentGeneratorConfiguration();
		commentGeneratorConfiguration.addProperty("suppressAllComments", "true");
		commentGeneratorConfiguration.addProperty("suppressDate", "true");
		context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);
		//自定义jdbc类型转换
		JavaTypeResolverConfiguration javaTypeResolverConfiguration=new JavaTypeResolverConfiguration();
		javaTypeResolverConfiguration.setConfigurationType("com.tools.demo.generator.tool.MyJavaTypeResolver");
		javaTypeResolverConfiguration.addProperty("forceBigDecimals", "false");
		context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);
		//生成model的规则
		JavaModelGeneratorConfiguration javaModelGeneratorConfiguration=new JavaModelGeneratorConfiguration();
		javaModelGeneratorConfiguration.setTargetProject("G:\\workspace2018\\demo\\src\\main\\java");
		javaModelGeneratorConfiguration.setTargetPackage("com.tools.demo.test.model");
		context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
		//mapper.xml的规则
		SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration=new SqlMapGeneratorConfiguration();
		sqlMapGeneratorConfiguration.setTargetProject("G:\\workspace2018\\demo\\src\\main\\java");
		sqlMapGeneratorConfiguration.setTargetPackage("com.tools.demo.test.dao.mapping");
		context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
		//dao规则
		JavaClientGeneratorConfiguration javaClientGeneratorConfiguration=new JavaClientGeneratorConfiguration();
		javaClientGeneratorConfiguration.setTargetProject("G:\\workspace2018\\demo\\src\\main\\java");
		javaClientGeneratorConfiguration.setTargetPackage("com.tools.demo.test.dao");
		javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
		context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
		//具体表格的配置
		List<TableConfiguration> list=new ArrayList<TableConfiguration>();
		for (String tableName : tableNames) {
			TableConfiguration tc=new TableConfiguration(context);
			tc.setTableName(tableName);
			tc.setSchema("zxd_test8");
			tc.addProperty("ignoreQualifiersAtRuntime", "true");
			//GeneratedKey generatedKey=new GeneratedKey("", "sql", false, "pre");
			//tc.setGeneratedKey(generatedKey);
			list.add(tc);
		}
		for (TableConfiguration tableConfiguration : list) {
			context.addTableConfiguration(tableConfiguration);
		}
		config.addContext(context);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		for (String warning : warnings) {
			System.out.println(warning);
		}
	}

	public static InputStream getResourceAsStream(String path) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
	}
}
