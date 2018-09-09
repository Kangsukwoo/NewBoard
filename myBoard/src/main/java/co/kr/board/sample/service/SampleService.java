package co.kr.board.sample.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface SampleService {

	List<Map<String, Object>> selectBoardList(Map<String, Object> map);

<<<<<<< HEAD
	void writeBoard(Map<String, Object> map, HttpServletRequest req) throws Exception;
=======
	void writeBoard(Map<String, Object> map);
>>>>>>> a05ce23ba92f07d61f47e559fc40e72713a91e26

	Map<String, Object> selectBoard(Map<String, Object> map);

	void modifyBoard(Map<String, Object> map);

	void deleteBoard(Map<String, Object> map);

}
