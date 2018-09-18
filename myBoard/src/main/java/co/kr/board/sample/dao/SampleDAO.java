package co.kr.board.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import co.kr.board.common.dao.AbstractDAO;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {

		return (List<Map<String, Object>>) selectList("selectBoardList", map);
	}

	public void writeBoard(Map<String, Object> map) {
		insert("writeBoard", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> selectBoard(Map<String, Object> map) {
		return (Map<String, Object>) selectOne("selectBoard", map);
	}

	public void updateHitCount(Map<String, Object> map) {
		update("updateHitCount", map);
	}

	public void modifyBoard(Map<String, Object> map) {
		update("modifyBoard", map);
	}

	public void deleteBoard(Map<String, Object> map) {
		update("deleteBoard", map);

	}

	public void insertFile(Map<String, Object> map) {
		insert("insertFile", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) {
		return (List<Map<String, Object>>) selectList("selectFileList", map);

	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectCommentList(Map<String, Object> map) {
		return selectList("selectCommentList", map);
	}
	
	public void insertComment(Map<String, Object> map) {
		insert("insertCommet", map);
	}
	
	public void deleteComment(Map<String, Object> map) {
		delete("deleteComment", map);
	}
	
	public void updateComment(Map<String, Object> map) {
		update("updateComment", map);
	}

}
