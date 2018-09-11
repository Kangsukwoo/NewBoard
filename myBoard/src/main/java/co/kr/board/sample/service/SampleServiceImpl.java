package co.kr.board.sample.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import co.kr.board.common.utils.FileUtils;
import co.kr.board.sample.dao.SampleDAO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

	Logger log = Logger.getLogger(this.getClass());

	// @Resource(name = "sampleDAO")
	@Autowired
	private SampleDAO sampleDAO;

	@Autowired
	private FileUtils fileUtils;

	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {

		return sampleDAO.selectBoardList(map);
	}

	@Override
	public void writeBoard(Map<String, Object> map, HttpServletRequest req) throws Exception {
		sampleDAO.writeBoard(map);

		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(map,req);
	     
	    for(int i=0; i<list.size();i++) {
	        sampleDAO.insertFile(list.get(i));
	    }
	}


	@Override
	public Map<String, Object> selectBoard(Map<String, Object> map) {
		sampleDAO.updateHitCount(map);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("map", sampleDAO.selectBoard(map));
		resultMap.put("list", sampleDAO.selectFileList(map));

		return resultMap;

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
