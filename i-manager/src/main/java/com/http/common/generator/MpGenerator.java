package com.http.common.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MpGenerator {

	public static void main(String[] args) {
		
		AutoGenerator ag = new AutoGenerator();

		//全局配置
		GlobalConfig gc = new GlobalConfig();
		
		//点中src/main/java按下快捷键组合shift+alt+w选择system explorer,双击进入java文件夹，在地址栏复制路径粘贴到此处
		//把粘贴的地址中\全部换成//
		gc.setOutputDir("D://");
		gc.setFileOverride(true);// 是否覆盖文件
		gc.setActiveRecord(true);// 开启activeRecord 模式
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(true);// XML columList
		gc.setAuthor("GR·cheng");

		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		gc.setMapperName("%sDao");
		gc.setXmlName("%sMapper");
		gc.setServiceName("%sService");
		gc.setServiceImplName("%sServiceImpl");
		gc.setControllerName("%sController");
		
		ag.setGlobalConfig(gc);
		
		//数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUrl("jdbc:mysql://127.0.0.1:3306/i-mr?characterEncoding=utf8");
		dsc.setUsername("root");
		dsc.setPassword("");
		
		ag.setDataSource(dsc);
		
		//生成策略
		StrategyConfig sc = new StrategyConfig();
		sc.containsTablePrefix("");
		sc.setNaming(NamingStrategy.underline_to_camel);//表名生成策略
		
		ag.setStrategy(sc);
		
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.http");
		pc.setEntity("model");
		pc.setMapper("dao");
		pc.setXml("mapper");
		pc.setService("service");
		pc.setServiceImpl("service.serviceImpl");
		pc.setController("controller");
		
		ag.setPackageInfo(pc);
		
		ag.execute();
	}

}
