/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services.question;

import com.dht.pojo.Category;
import com.dht.pojo.Level;
import com.dht.pojo.Question;
import com.dht.pojo.QuestionQueryBuilder;
import com.dht.utils.MyConnSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionServices extends QuestionServiceBase{
    private QuestionQueryBuilder query;

    public QuestionServices() {
    }

    public QuestionServices(QuestionQueryBuilder query) {
        this.query = query;
    }

   
    
    

    @Override
    public List<Question> getQuestions() throws SQLException {
//        Connection conn = MyConnSingleton.getInstance().connect();
//       
//        String sql = "SELECT * FROM question WHERE 1=1"; // ORDER BY id DESC
//        
//        
//        List<Object> params = new ArrayList<>();
//        if (kw != null && !kw.isEmpty()) {
//            sql += " content like concat('%', ?, '%')";
//            params.add(kw);
//        }
//        
//        if (cate != null) {
//            sql += " AND category_id = ?";
//            params.add(cate.getId());
//        }
//        
//        if (lvl != null) {
//            sql += " AND level_id = ?";
//            params.add(lvl.getId());
//        }
        
        PreparedStatement stm = this.getQuery().build();
//        for (int i = 0; i < params.size(); i++)
//            stm.setObject(i + 1, params.get(i));
        
        ResultSet rs = stm.executeQuery();

        List<Question> questions = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String content = rs.getString("content");

            questions.add(new Question.Builder().setId(id).setContent(content).build());
        }

        return questions;
    }

    /**
     * @return the query
     */
    public QuestionQueryBuilder getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(QuestionQueryBuilder query) {
        this.query = query;
    }

    /**
     * @return the query
     */
   
}
