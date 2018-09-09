package co.kr.board.common.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.board.common.dao.CommonDAO;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	CommonDAO commomDAO;

	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) {
		
		return commomDAO.selectFileInfo(map);
	}

}
