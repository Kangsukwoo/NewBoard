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
<<<<<<< HEAD
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
=======
>>>>>>> a05ce23ba92f07d61f47e559fc40e72713a91e26
		</tbody>
	</table>
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
<<<<<<< HEAD
			$("a[name='file']").on("click",function(e){	//파일 다운로드
                e.preventDefault();
                fn_fileDownload($(this));
            })			
=======
>>>>>>> a05ce23ba92f07d61f47e559fc40e72713a91e26
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
<<<<<<< HEAD
		function fn_fileDownload(obj){	//파일 다운로드
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/common/downloadFile'/>");
            comSubmit.addParam("IDX",obj.parent().find("#IDX").val());
            comSubmit.submit();
            $("#commonForm").children().remove();
        } 
=======
>>>>>>> a05ce23ba92f07d61f47e559fc40e72713a91e26
	</script>
</body>
</html>