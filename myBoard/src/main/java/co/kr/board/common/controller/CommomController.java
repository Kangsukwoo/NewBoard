package co.kr.board.common.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.board.common.common.CommandMap;
import co.kr.board.common.service.CommonService;

@Controller
public class CommomController {
	
	@Autowired
    private CommonService commonService;
     
    @RequestMapping(value="/common/downloadFile")
    public void downloadFile(CommandMap commandMap, HttpServletResponse response) throws Exception{
        Map<String,Object> map = commonService.selectFileInfo(commandMap.getMap());
        String original_File_Name = (String)map.get("ORIGINAL_FILE_NAME");
        String stored_File_Name = (String)map.get("STORED_FILE_NAME");
         
        byte[] fileByte = FileUtils.readFileToByteArray(new File("/var/newBoard/upload/"+stored_File_Name));
         
        response.setContentType("application/octet-stream");
        response.setContentLength(fileByte.length);
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(original_File_Name,"UTF-8")+"\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.getOutputStream().write(fileByte);
          
        response.getOutputStream().flush();
        response.getOutputStream().close();
 
    }
	
}
