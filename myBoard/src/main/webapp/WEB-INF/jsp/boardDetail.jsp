<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>상세보기</title>
<%@ include file="/WEB-INF/include/header.jsp"%>
</head>
<body>
	<table class="board_view">
		<caption>상세보기</caption>
		<colgroup>
			<col width="15%">
			<col width="35%">
			<col width="15%">
			<col width="*">
		</colgroup>

		<tbody>
			<tr>
				<th>제목</th>
				<td>${map.TITLE}</td>
				<th>조회수</th>
				<td>${map.HIT_CNT }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${map.CREA_ID }</td>
				<th>작성시간</th>
				<td>${map.CREA_DTM }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">${map.CONTENTS }</td>
			</tr>
			<tr>
                <th>첨부파일</th>
                <td colspan="3">
                    <c:forEach items="${list}" var="row" >
                        <p>
                            <input type="hidden" value="${row.IDX }" id="IDX">
                            <a href="#this" name="file">${row.ORIGINAL_FILE_NAME }</a>
                            (${row.FILE_SIZE }Byte)
                        </p>
                    </c:forEach>                          
            </tr>
		</tbody>
	</table><br>
	<form id="frm">
        <table class="board_view">
            <colgroup>
                <col width="15%">
                <col width="85%">
            </colgroup>
            <tbody>
                <tr>
                    <th>댓글</th>
                    <td>
                        ${fn:length(comment) }
                    </td>
                </tr>
                <c:if test="${fn:length(comment)>0 }">
                    <c:forEach items="${comment }" var="com">
                        <tr>
                            <td style="background:#f7f7f7;color:#3b3a3a;" >
                                ${com.CREA_ID }
                                <p style="font-size: 8px;" >${com.CREA_DTM }</p>
                            </td>
                            <td>
                                <input type="hidden" value="${com.IDX }" id="com_IDX">
                                <div id="com_Div"><input type="hidden" value ="${com.CONTENTS}" id="com_CON">${com.CONTENTS }</div>
                                <div align="right">
                                    <a href="#this" name="com_Del" class="btn">삭제</a>
                                    <a href="#this" name="com_Mod" class="btn">수정</a>
                                </div>                            
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <tr>
                    <td colspan="2">
                        <div>
                           	 작성자 : Admin<br/><br/>
                            <textarea  rows="5" cols="130" name="COM_CONTENTS" ></textarea>
                            <p align="right" ><a href="#this" id="com_write" class="btn">등록</a></p>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
	
	<a href="#this" id="list" class="btn">목록으로</a>
	<a href="#this" id="modify" class="btn">수정하기</a>
	<%@ include file="/WEB-INF/include/body.jsp"%>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#list").on("click", function(e) {
				e.preventDefault();
				fn_openBoardList();
			})
			$("#modify").on("click", function(e) {
				e.preventDefault();
				fn_openBoardModify();
			})

			$("a[name='file']").on("click",function(e){	//파일 다운로드
                e.preventDefault();
                fn_fileDownload($(this));
            })		
            
            $("#com_write").on("click",function(e){	//댓글쓰기
                e.preventDefault();
                fn_writeComment();
            })
            $("a[name=com_Del]").on("click",function(e){	//댓글지우기
                e.preventDefault();
                fn_deleteComment($(this));
            })
            $("a[name=com_Mod]").on("click",function(e){	//댓글수정
                e.preventDefault();
                fn_commentModify($(this));
            })
		})

		function fn_openBoardList() {
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/sample/openBoardList'/>");
			comSubmit.submit();
		}
		function fn_openBoardModify() {
			var idx = "${map.IDX}";
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/sample/openBoardModify'/>");
			comSubmit.addParam("IDX", idx);
			comSubmit.submit();
		}

		function fn_fileDownload(obj){	//파일 다운로드
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/common/downloadFile'/>");
            comSubmit.addParam("IDX",obj.parent().find("#IDX").val());
            comSubmit.submit();
            $("#commonForm").children().remove();
        } 
		
		function fn_writeComment(){
            var comSubmit = new ComSubmit("frm");
            comSubmit.addParam("IDX",${map.IDX})
            comSubmit.setUrl("<c:url value='/sample/writeComment'/>");
            comSubmit.submit();
        }
 
        function fn_deleteComment(obj){
            var comSubmit = new ComSubmit();
            comSubmit.addParam("IDX",${map.IDX})
            comSubmit.addParam("COM_IDX",obj.parent().parent().find("#com_IDX").val());
            comSubmit.setUrl("<c:url value='/sample/deleteComment'/>");
            comSubmit.submit();
        }  
 
        function fn_commentModify(obj){
            var con = obj.parent().parent().find("#com_Div").find("#com_CON").val();
            var str = "<textarea  rows='5' cols='100' name='COM_CONTENTS_UPD'>"+con+"</textarea><p align='right' ><a href=''#this' name='com_Upd' class='btn'>등록</a></p><hr/>";
            var div = obj.parent().parent().find("#com_Div");
 
            div.empty();
            div.append(str)
             
            $("a[name=com_Upd]").on("click",function(e){
                e.preventDefault();
                fn_updateComment($(this));
            })
        } 
 
        function fn_updateComment(obj){
            var comSubmit = new ComSubmit("frm");
            comSubmit.addParam("IDX",${map.IDX})
            comSubmit.addParam("COM_IDX",obj.parent().parent().parent().find("#com_IDX").val());
            comSubmit.setUrl("<c:url value='/sample/updateComment'/>");
            comSubmit.submit();
        }
		
	</script>
</body>
</html>