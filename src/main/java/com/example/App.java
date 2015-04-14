package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;

/**
 * CommandLineRunnerはコマンドラインで値を取得する場合に使う。
 * 
 * @author nagase
 *
 */
@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {
	// @Autowired
	// CustomerService customerService;
	//@Autowired
	//NamedParameterJdbcTemplate jdbcTemplate; // H2
												// データベース用のDatasourceが生成される。URLの指定などがない場合は、インメモリの組み込みデータベースが作成される
	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public void run(String...strings) throws Exception{
		
		Customer created = customerRepository.save(new Customer(null, "yoshi001","Nagase"));
		System.out.println(created+"is created★");
		//DBにある内容を全て表示
		customerRepository.findAll().forEach(System.out::println);
		
		
//		String sql = "SELECT id, first_name, last_name from customers where id = :id";
//		SqlParameterSource param = new MapSqlParameterSource()
//		.addValue("id", 60);
//		
//		Customer result = jdbcTemplate.queryForObject(sql, 
//				param, (rs,rowNum)->{
//					System.out.println("AAA");
//					return new Customer(rs.getInt("id"),			
//				rs.getString("first_name"), rs.getString("last_name"));
//				}
//			);
//		
//		String sql2 = "select count(*) from customers";
//		@SuppressWarnings("deprecation")
//		int count = jdbcTemplate.queryForInt(sql2, param);
//		System.out.println("data count is " +count);
//				new RowMapper<Customer>() {
//		@Override
//		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
//			return new Customer(rs.getInt("id"),  rs.getString("first_name"), rs.getString("last_name"));
//		}
//		});
		
		//Integer result = jdbcTemplate.queryForObject(sql, param, Integer.class); //クエリの実行結果をオブジェクトに変換して取得。返り値が一件でない場合は、Exception が返される
		
		//System.out.println("result ="+result);
		
//		customerService.save(new Customer(1,"nobita","nobi"));
//		customerService.save(new Customer(2,"hiroko","hiro"));
//		customerService.save(new Customer(3,"yoshi","naga"));
//		
//		//データ表示
//		customerService.findAll().forEach(System.out::println);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
