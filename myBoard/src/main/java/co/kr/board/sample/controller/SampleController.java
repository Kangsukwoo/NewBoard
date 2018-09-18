package co.kr.board.sample.controller;

//배포 경로 : /var/lib/tomcat8/webapps

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
		log.debug("인터셉터 테스트");

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

	// 글쓰기페이지
	@RequestMapping(value = "/sample/openBoardWrite")
	public ModelAndView openBoardWrite(CommandMap commandMap) {
		ModelAndView mv = new ModelAndView("/boardWrite");
		return mv;
	}

	// 글쓰기
	@RequestMapping(value = "/sample/writeBoard")
	public ModelAndView writeBoard(CommandMap commandMap, HttpServletRequest req) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList");
		sampleService.writeBoard(commandMap.getMap(), req);
		return mv;
	}

	// 상세보기
	@RequestMapping(value = "/sample/openBoardDetail")
	public ModelAndView openBoardDetail(CommandMap commandMap) {
		ModelAndView mv = new ModelAndView("/boardDetail");
		Map<String, Object> map = sampleService.selectBoard(commandMap.getMap());
		mv.addObject("map", map.get("map"));	//map = 게시글 정보가 담김
		mv.addObject("list", map.get("list"));		//list = 파일정보가 담김
		mv.addObject("comment", map.get("comment"));	//댓글정보
		return mv;
	}

	// 수정
	@RequestMapping(value = "/sample/openBoardModify")
	public ModelAndView openBoardModify(CommandMap commandMap) {
		ModelAndView mv = new ModelAndView("/boardModify");
		Map<String, Object> map = sampleService.selectBoard(commandMap.getMap());
		mv.addObject("map", map.get("map"));
		return mv;
	}

	// 수정 실행
	@RequestMapping(value = "/sample/modifyBoard" )
	public ModelAndView modifyBoard(CommandMap commandMap) {
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList");
		sampleService.modifyBoard(commandMap.getMap());
		mv.addObject("IDX", commandMap.get("IDX"));
		return mv;
	}

	// 삭제
	@RequestMapping(value = "/sample/deleteBoard")
	public ModelAndView deleteBoard(CommandMap commandMap) {
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList");
		sampleService.deleteBoard(commandMap.getMap());
		return mv;
	}
	
	//댓글작성
		@RequestMapping(value = "/sample/writeComment")
		public ModelAndView writeComment(CommandMap commandMap) {
			ModelAndView mv = new ModelAndView("redirect:/sample/openBoardDetail");
			sampleService.writeComment(commandMap.getMap());		
			mv.addObject("IDX", commandMap.get("IDX"));
			return mv;
		}
		
		//댓글삭제
		@RequestMapping(value = "/sample/deleteComment")
		public ModelAndView deleteComment(CommandMap commandMap) {
			ModelAndView mv = new ModelAndView("redirect:/sample/openBoardDetail");
			sampleService.deleteComment(commandMap.getMap());		
			mv.addObject("IDX", commandMap.get("IDX"));
			return mv;
		}
		
		//댓글수정
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
