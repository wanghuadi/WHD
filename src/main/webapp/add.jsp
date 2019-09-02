<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">

	$(function(){
		
		$.post("queryCatAll.do",function(data){
			
			var str = "";
			for(var i in data){
				str+="<option value='"+data[i].cid+"'>"+data[i].cname+"</option>";
			}
			$("#category").append(str);
			
		},"json");
	
		
		$("#category").change(function(){
			
			var cid = $(this).val();
			
			$.post("queryBrandByCid.do",{"cid":cid},function(data){
				
				var str = "";
				for(var i in data){
					str+="<option value='"+data[i].bid+"'>"+data[i].bname+"</option>";
				}
				$("#brand").append(str);
				
			},"json");
			
		})
		
	})
	
</script>
<script type="text/javascript">
	function addgoods(){
		$.post("addGoods.do",$("form").serialize(),function(data){
			
			if(data){
				alert("添加成功!");
				location.href="queryGoodsAll.do";
			}
			
		},"json");
		
	}
</script>
</head>
<body>
	
	<form action="#">
		商品分类:<select id="category" name="cid">
		   		<option value="0">请选择商品分类</option>
			   </select><br><br>
		品牌:<select id="brand" name="bid">
			   		<option value="0">请选择商品品牌</option>
			</select><br><br>
		商品名称:<input type="text" name="gname"><br><br>
		描述:<input type="text" name="gdesc"><br><br>
		商品价格:<input type="text" name="price"><br><br>
		<input type="button" value="提交" onclick="addgoods()">
		<input type="reset" value="重置">
	</form>
</body>
</html>