<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%@ include file="/WEB-INF/include/header.jsp" %>
<body>
<<<<<<< HEAD
<form id="frm" name="frm" enctype="multipart/form-data">
=======
<form id="frm">
>>>>>>> a05ce23ba92f07d61f47e559fc40e72713a91e26
        <table class="board_view">
            <colgroup>
                <col width="15%" >
                <col width="*" >
            </colgroup>
            <caption>게시글 작성</caption>
            <tbody>
                <tr>
                    <th scope="row">제목</th>
<<<<<<< HEAD
                    <td><input type="text"  id="TITLE" name="TITLE" class="wdp_90" /></td>
=======
                    <td><input type="text"  name="TITLE" class="wdp_90" /></td>
>>>>>>> a05ce23ba92f07d61f47e559fc40e72713a91e26
                </tr>
                <tr>
                    <th scope="row">내용</th>
                    <td><textarea cols="100" rows="20" id="CONTENTS" name="CONTENTS" title="내용"></textarea></td>
                </tr>
            </tbody>
        </table>
<<<<<<< HEAD
        <div id="fileDiv">
            <p>
                <input type="file" name="file_0"/>
            </p> 
        </div>    
         <a href="#this" id="write" class="btn">글쓰기</a>
        <a href="#this" id="list" class="btn">목록으로</a>        
=======
         
        <a href="#this" id="list" class="btn">목록으로</a>
        <a href="#this" id="write" class="btn">글쓰기</a>
>>>>>>> a05ce23ba92f07d61f47e559fc40e72713a91e26
    </form>
<%@ include file="/WEB-INF/include/body.jsp" %>
     <script type="text/javascript">
        $(document).ready(function(){
            $("#list").on("click",function(e){
                e.preventDefault();
                fn_openBoardList();
            })
            $("#write").on("click",function(e){
                e.preventDefault();
                fn_writeBoard();
            })
        });
         
         
        function fn_openBoardList(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/sample/openBoardList'/>");
            comSubmit.submit();
        }
         
        function fn_writeBoard(){
            var comSubmit = new ComSubmit("frm");
            comSubmit.setUrl("<c:url value='/sample/writeBoard'/>");
            comSubmit.submit();
        }
    </script>  

</body>
</html>