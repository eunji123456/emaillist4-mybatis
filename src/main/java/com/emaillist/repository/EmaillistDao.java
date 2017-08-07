package com.emaillist.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emaillist.vo.EmaillistVo;

@Repository
public class EmaillistDao {

	@Autowired
	private SqlSession sqlSession;
	
	//전체 리스트 불러오는 dao 문
	public List<EmaillistVo> getList() {

		return sqlSession.selectList("emaillist.getList2");
		
	}

	public int insert(EmaillistVo emaillistVo) {

		return sqlSession.insert("emaillist.insert", emaillistVo);
	}
	
	public EmaillistVo getByNo(int no) {
		
		return sqlSession.selectOne("emaillist.getByNo", no);

	}

	public List<EmaillistVo> getListByMap(Map<String,Object> map){
		
		return sqlSession.selectList("emaillist.getListByMap",map);

	} 
	
}
