package org.dd.jtademo.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ComponentScan
public class DataSourceConfig {

	@Autowired
	private OrderDatasourceProperties orderDatasourceProperties;

	@Autowired
	private CustomerDatasourceProperties customerDatasourceProperties;

	@Bean(name = "customerDataSource", initMethod = "init", destroyMethod = "close")
	@Primary
	public DataSource customerDataSource() throws SQLException {
		MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
		mysqlXaDataSource.setUrl(customerDatasourceProperties.getUrl());
		mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
		mysqlXaDataSource.setPassword(customerDatasourceProperties.getPassword());
		mysqlXaDataSource.setUser(customerDatasourceProperties.getUsername());
		mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		xaDataSource.setXaDataSource(mysqlXaDataSource);
		xaDataSource.setUniqueResourceName("customerDS");

		xaDataSource.setMinPoolSize(customerDatasourceProperties.getMinPoolSize());
		xaDataSource.setMaxPoolSize(customerDatasourceProperties.getMaxPoolSize());
		xaDataSource.setMaxLifetime(customerDatasourceProperties.getMaxLifetime());
		xaDataSource.setBorrowConnectionTimeout(customerDatasourceProperties.getBorrowConnectionTimeout());
		xaDataSource.setLoginTimeout(customerDatasourceProperties.getLoginTimeout());
		xaDataSource.setMaintenanceInterval(customerDatasourceProperties.getMaintenanceInterval());
		xaDataSource.setMaxIdleTime(customerDatasourceProperties.getMaxIdleTime());
		xaDataSource.setTestQuery(customerDatasourceProperties.getTestQuery());
		return xaDataSource;
	}

	@Bean(name = "orderDataSource", initMethod = "init", destroyMethod = "close")
	public DataSource orderDataSource() throws SQLException {
		MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
		mysqlXaDataSource.setUrl(orderDatasourceProperties.getUrl());
		mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
		mysqlXaDataSource.setPassword(orderDatasourceProperties.getPassword());
		mysqlXaDataSource.setUser(orderDatasourceProperties.getUsername());
		mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		xaDataSource.setXaDataSource(mysqlXaDataSource);
		xaDataSource.setUniqueResourceName("orderDS");

		xaDataSource.setMinPoolSize(orderDatasourceProperties.getMinPoolSize());
		xaDataSource.setMaxPoolSize(orderDatasourceProperties.getMaxPoolSize());
		xaDataSource.setMaxLifetime(orderDatasourceProperties.getMaxLifetime());
		xaDataSource.setBorrowConnectionTimeout(orderDatasourceProperties.getBorrowConnectionTimeout());
		xaDataSource.setLoginTimeout(orderDatasourceProperties.getLoginTimeout());
		xaDataSource.setMaintenanceInterval(orderDatasourceProperties.getMaintenanceInterval());
		xaDataSource.setMaxIdleTime(orderDatasourceProperties.getMaxIdleTime());
		xaDataSource.setTestQuery(orderDatasourceProperties.getTestQuery());
		return xaDataSource;

	}
}
