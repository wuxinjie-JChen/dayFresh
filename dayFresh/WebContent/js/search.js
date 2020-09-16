$('.input_btn').click(function(){
	var text=$('.input_text').val();
	if(text==null || text.length<=0){
		alert("请先输入要搜索的内容");
		return false;
	}
	$('.search_con form').submit();
});