package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.bean.Product;
@Repository						// dao layer specific annotation 
public class ProductDao {

	@Autowired
	DataSource ds;
//	
//	public int storeProduct(Product product) {
//		try {
//		Connection con = ds.getConnection();
//	PreparedStatement pstmt = con.prepareStatement("insert into product values(?,?,?)");
//	pstmt.setInt(1, product.getPid());
//	pstmt.setString(2, product.getPname());
//	pstmt.setFloat(3, product.getPrice());
//	return pstmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println(e);
//			return 0;
//		}
//	}
//	public int updateProduct(Product product) {
//		try {
//			Connection con = ds.getConnection();
//	PreparedStatement pstmt = con.prepareStatement("update product set price = ? where pid=?");
//	pstmt.setFloat(1, product.getPrice());
//	pstmt.setInt(2, product.getPid());
//	return pstmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println(e);
//			return 0;
//		}
//	}
//	public int deleteProduct(int pid) {
//		try {
//			Connection con = ds.getConnection();
//	PreparedStatement pstmt = con.prepareStatement("delete from product where pid = ?");
//	pstmt.setInt(1, pid);
//	return pstmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println(e);
//			return 0;
//		}
//	}
//	
	
//	public List<Product> retrieveAllProducts() {
//		List<Product> listOfProducts = new ArrayList<Product>();
//		try {
//			Connection con = ds.getConnection();
//		Statement stmt = con.createStatement();
//		ResultSet rs = stmt.executeQuery("select * from product");
//		while(rs.next()) {
//			//System.out.println("display data from dao layer");
//			//System.out.println("pid is "+rs.getInt(1)+" pname "+rs.getString(2)+" price "+rs.getFloat(3));
//			Product p = new Product();
//			p.setPid(rs.getInt(1));
//			p.setPname(rs.getString(2));
//			p.setPrice(rs.getFloat(3));
//			listOfProducts.add(p);
//		}
//		return listOfProducts;
//			} catch (Exception e) {
//				System.err.println(e);
//			}
//		return null;
//	}
//	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int storeProduct(Product product) {
	try {
	return jdbcTemplate.update("insert into product values(?,?,?)", product.getPid(),product.getPname(),product.getPrice());
	} catch (Exception e) {
		System.err.println(e);
		return 0;
	}
	}
	
	public int deleteProduct(int pid) {
		try {
			return jdbcTemplate.update("delete from product where pid=?", pid);			
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public int updateProduct(Product product) {
		try {
			return jdbcTemplate.update("update product set price=? where pid=?", product.getPrice(),product.getPid());
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public List<Map<String, Object>> retrieveAllProductsAsListOfMap() {
		try {
			return jdbcTemplate.queryForList("select * from product");
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
	
	public List<Product> retrieveAllProductAsList() {
		try {
		//return jdbcTemplate.query("select * from product",new MyResultSetExtracter());
			return jdbcTemplate.query("select * from Product", new MyRowMapper());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}

class MyResultSetExtracter implements ResultSetExtractor<Product>{
	@Override
	public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
}
// global while loop 
class MyRowMapper implements RowMapper<Product>{
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product p = new Product();
		p.setPid(rs.getInt(1));
		p.setPname(rs.getString(2));
		p.setPrice(rs.getFloat(3));
		return p;
	}
}