package co.kr.board.sample.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.board.sample.dao.SampleDAO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

	// @Resource(name = "sampleDAO")
	@Autowired
	private SampleDAO sampleDAO;

	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {

		return sampleDAO.selectBoardList(map);
	}

	@Override
	public void writeBoard(Map<String, Object> map) {
		sampleDAO.writeBoard(map);
	}

	@Override
	public Map<String, Object> selectBoard(Map<String, Object> map) {
		sampleDAO.updateHitCount(map);
		return sampleDAO.selectBoard(map);
	}

	@Override
	public void modifyBoard(Map<String, Object> map) {
		sampleDAO.modifyBoard(map);

	}

	@Override
	public void deleteBoard(Map<String, Object> map) {
		sampleDAO.deleteBoard(map);

	}

}
