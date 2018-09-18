package co.kr.board.sample.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.kr.board.common.common.CommandMap;
import co.kr.board.sample.service.SampleService;

@Controller
public class SampleController {

	Logger log = Logger.getLogger(this.getClass());

	// @Resource(name = "sampleService")
	@Autowired
	SampleService sampleService;

	@RequestMapping(value = "/testInterceptor")
	public ModelAndView testInterceptor(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("");
		log.debug("���ͼ��� �׽�Ʈ");

		return mv;
	}

	// list
	@RequestMapping(value = "/sample/openBoardList")
	public ModelAndView boardList(Map<String, Object> commandMap) {
		ModelAndView mv = new ModelAndView("/boardList");
		List<Map<String, Object>> list = sampleService.selectBoardList(commandMap);
		mv.addObject("list", list);

		return mv;

	}

	// �۾���������
	@RequestMapping(value = "/sample/openBoardWrite")
	public ModelAndView openBoardWrite(CommandMap commandMap) {
		ModelAndView mv = new ModelAndView("/boardWrite");
		return mv;
	}

	// �۾���
	@RequestMapping(value = "/sample/writeBoard")
	public ModelAndView writeBoard(CommandMap commandMap, HttpServletRequest req) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList");
		sampleService.writeBoard(commandMap.getMap(), req);
		return mv;
	}

	// �󼼺���
	@RequestMapping(value = "/sample/openBoardDetail")
	public ModelAndView openBoardDetail(CommandMap commandMap) {
		ModelAndView mv = new ModelAndView("/boardDetail");
		Map<String, Object> map = sampleService.selectBoard(commandMap.getMap());
		mv.addObject("map", map.get("map"));	//map = �Խñ� ������ ���
		mv.addObject("list", map.get("list"));		//list = ���������� ���
		mv.addObject("comment", map.get("comment"));	//�������
		return mv;
	}

	// ����
	@RequestMapping(value = "/sample/openBoardModify")
	public ModelAndView openBoardModify(CommandMap commandMap) {
		ModelAndView mv = new ModelAndView("/boardModify");
		Map<String, Object> map = sampleService.selectBoard(commandMap.getMap());
		mv.addObject("map", map.get("map"));
		return mv;
	}

	// ���� ����
	@RequestMapping(value = "/sample/modifyBoard" )
	public ModelAndView modifyBoard(CommandMap commandMap) {
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList");
		sampleService.modifyBoard(commandMap.getMap());
		mv.addObject("IDX", commandMap.get("IDX"));
		return mv;
	}

	// ����
	@RequestMapping(value = "/sample/deleteBoard")
	public ModelAndView deleteBoard(CommandMap commandMap) {
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList");
		sampleService.deleteBoard(commandMap.getMap());
		return mv;
	}
	
	//����ۼ�
		@RequestMapping(value = "/sample/writeComment")
		public ModelAndView writeComment(CommandMap commandMap) {
			ModelAndView mv = new ModelAndView("redirect:/sample/openBoardDetail");
			sampleService.writeComment(commandMap.getMap());		
			mv.addObject("IDX", commandMap.get("IDX"));
			return mv;
		}
		
		//��ۻ���
		@RequestMapping(value = "/sample/deleteComment")
		public ModelAndView deleteComment(CommandMap commandMap) {
			ModelAndView mv = new ModelAndView("redirect:/sample/openBoardDetail");
			sampleService.deleteComment(commandMap.getMap());		
			mv.addObject("IDX", commandMap.get("IDX"));
			return mv;
		}
		
		//��ۼ���
		@RequestMapping(value = "/sample/updateComment")
		public ModelAndView updateComment(CommandMap commandMap) {
			ModelAndView mv = new ModelAndView("redirect:/sample/openBoardDetail");
			sampleService.updateComment(commandMap.getMap());		
			mv.addObject("IDX", commandMap.get("IDX"));
			return mv;
		}

	@RequestMapping(value = "/sample/testMapArgumentResolver")
	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("");

		if (commandMap.isEmpty() == false) {
			Iterator<Entry<String, Object>> iterator = commandMap.getMap().entrySet().iterator();
			Entry<String, Object> entry = null;
			while (iterator.hasNext()) {
				entry = iterator.next();
				log.debug("key : " + entry.getKey() + ", value : " + entry.getValue());
			}
		}
		return mv;
	}

}
