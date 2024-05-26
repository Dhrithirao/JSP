$(document).ready(function() {
     $('a').click(function(e) {
     var a_class= $(this).attr('class');
     if(a_class=='insideTable'){
    	 e.preventDefault();
    	 var element=$(this);
    	var key=prompt('CS Given Permition to Decrypt File & Enter TA Sented File Key');
    	alert(key);
    	if(key.length>0)
		{
	
    var value ='county='+element.attr('href');
     $.ajax({
     url: "saveIt.jsp?key="+key,
     //type: "post",
     data: value,
     cache: false,
     success: function(data) {
    	 $('#msg_Display').html(data).hide();
    	 $('#msg_Display').html(data);
    	 var mtext=$('#msg').text();
    	 alert("mtext = "+mtext);
			if (mtext=="valid key") {
			
    	//if($('#msg').text()=='valid key'){
    		// $('#filename').attr('value',element.attr('href'));
    		 //$('#myForm').submit();
				if(element.text()=='Download'){
					alert("download");
				//alert('element.attr(href) = '+element.attr('href'));
				$("#filename").attr('value',element.attr('href'));
				$('#myForm').attr('action','Download');
				$('#myForm').submit();
				}
				
			}
			else {
						alert("Enter Correct Key");
						element.focus();
						return false;
					} 
				}
			});
		}else
			{
			alert("Please Enter TA Sented key");
			}
		}
	});
});