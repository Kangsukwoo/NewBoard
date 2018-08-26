package co.kr.board.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import co.kr.board.common.dao.AbstractDAO;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO{
	
@SuppressWarnings("unchecked")
public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		
		return (List<Map<String,Object>>)selectList("selectBoardList", map);
	}

}
