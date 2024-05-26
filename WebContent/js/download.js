$(document).ready(function() {
	$('a').click(function(e) {
		var a_class = $(this).attr('class');
		if (a_class == 'insideTable') {
			e.preventDefault();
			var element = $(this);
			alert(element.text());
			var key = prompt('Enter the Key ');
			if(key.length>0)
				{
			var value = 'county=' + element.attr('href');
			$.ajax({
				url : "saveIt1.jsp?key="+ key,
				//type: "post",
				data : value,
				cache : false,
				success : function(data) {
					alert(data);
					$('#msg_Display').html(data);
					var mtext=$('#msg').text();
					alert("mtext = "+mtext);
					if (mtext=="valid key ") {
						///alert('element.text() = '+('#msg').text());
						if(element.text()=='Download'){
							alert("download");
						//alert('element.attr(href) = '+element.attr('href'));
						$("#filename").attr('value',element.attr('href'));
						$('#myForm').attr('action','Download ');
						$('#myForm').submit();
						}
						if(element.text()=='Edit'){
							alert("edit");
							//	alert('element.attr(href) = '+element.attr('href'));
							$("#filename").attr('value',element.attr('href'));
							$('#myForm').attr('action','Edit');
							$('#myForm').submit();
							}
						if(element.text()=='Delete'){
							alert("delete");
							//	alert('element.attr(href) = '+element.attr('href'));
							$("#filename").attr('value',element.attr('href'));
							$('#myForm').attr('action','Delete');
							$('#myForm').submit();
							}

					}
			else {
						alert("enter correct key ");
						element.focus();
						return false;
					} 
				}
			});
		}else
			{
			alert("pls enter key");
			}
		}
	});
});