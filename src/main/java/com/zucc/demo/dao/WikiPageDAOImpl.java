package com.zucc.demo.dao;

import com.zucc.demo.model.WikiPageVo;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxu on 7/2/17.
 */
@Repository
public class WikiPageDAOImpl implements WikiPageDAO {


    @Override
    public List<WikiPageVo> getAllPages() {
        List<WikiPageVo> pages = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement stmt = null;

            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM pages");
            while(rs.next()){
                String title = rs.getString("title") ;
                String url = rs.getString("url") ; // 此方法比较高效
                String abstracts = rs.getString("abstract") ; // 此方法比较高效
                WikiPageVo page = new WikiPageVo();
                page.setAbstracts(abstracts);
                page.setTitle(title);
                page.setUrl(url);
                pages.add(page);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pages;
    }

    private Connection getConnection(){
        try{
            //加载MySql的驱动类
            Class.forName("com.mysql.jdbc.Driver") ;
        }catch(ClassNotFoundException e){
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace() ;
        }
        //连接MySql数据库，用户名和密码都是root
        String url = "jdbc:mysql://localhost:3306/wikipedia" ;
        String username = "root" ;
        String password = "Qwer1234" ;
        try{
            Connection con =
                    DriverManager.getConnection(url , username , password ) ;
            return con;
        }catch(SQLException se){
            System.out.println("数据库连接失败！");
            se.printStackTrace() ;
        }
        return null;
    }
}
