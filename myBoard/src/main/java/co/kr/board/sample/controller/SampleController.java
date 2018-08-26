package co.kr.board.sample.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

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
	
	//@Resource(name = "sampleService")
	@Autowired
	SampleService sampleService;
    
    @RequestMapping(value="/testInterceptor")
    public ModelAndView testInterceptor(Map<String, Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("");
        log.debug("인터셉터 테스트");
         
        return mv;
    }
    
    @RequestMapping(value = "/sample/openBoardList")
    public ModelAndView boardList(Map<String, Object> commandMap) {
    	ModelAndView mv = new ModelAndView("/boardList");
    	List<Map<String, Object>> list = sampleService.selectBoardList(commandMap);
    	mv.addObject("list", list);
    	
    	return mv;
    	
    }
    
    @RequestMapping(value="/sample/testMapArgumentResolver")
    public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("");
         
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        return mv;
    }


}
