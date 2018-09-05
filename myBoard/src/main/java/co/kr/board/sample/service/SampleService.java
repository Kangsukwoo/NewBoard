package co.kr.board.sample.service;

import java.util.List;
import java.util.Map;

public interface SampleService {

	List<Map<String, Object>> selectBoardList(Map<String, Object> map);

	void writeBoard(Map<String, Object> map);

	Map<String, Object> selectBoard(Map<String, Object> map);

	void modifyBoard(Map<String, Object> map);

	void deleteBoard(Map<String, Object> map);

}
