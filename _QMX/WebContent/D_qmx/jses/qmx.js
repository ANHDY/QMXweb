$(document).ready(function(){
	var ok1=false;
    var ok2=false;
    var ok3=false;
    var ok4=false;
    var ok5=false;
    var ok6=false;
    
 // 验证用户名不为空
    $('input[name="username"]').blur(function(){
        if($(this).val().length >= 1 && $(this).val().length <=10 && $(this).val()!='' && $(this).val().search(/^([\u4e00-\u9fa5]|\u3007)+([\.\uff0e\u00b7\u30fb]?|\u3007?)+([\u4e00-\u9fa5]|\u3007)+$/)==0){
        	$("#namesId").html("");
        	ok1 = true;
        }else{
        	$("#namesId").html("请输入正确姓名格式（不能为英文，数字）");
        	ok1=false;
        }
    });


//验证手机号
$('input[name="phone"]').blur(function(){
     if($(this).val().search(/^1(3|4|5|7|8)\d{9}$/)==-1){
         $("#dianhuaId").html("请输入正确的手机格式");
         ok6 = false;
     }else{       
    	 $("#dianhuaId").html("");
    	 ok6 = true;
     }

 });

//验证学院是否为空
$('input[name="xueyuan"]').blur(function(){
    if($(this).val()=="" || $(this).val().search(/^([\u4e00-\u9fa5]){1,20}$/)==-1){
        $("#xueyuanId").html("请输入正确的学院");
        ok3 = false;
     }else{
    	 $("#xueyuanId").html("");
    	 ok3 = true;
     }
});

//验证专业是否为空
$('input[name="zhuanye"]').blur(function(){
    if($(this).val()=="" || $(this).val().search(/^([\u4e00-\u9fa5]){1,20}$/)==-1){
        $("#zhuanyeId").html("请输入正确的专业");
        ok4 = false;
     }else{
    	 $("#zhuanyeId").html("");
    	 ok4 = true;
     }
})

//验证QQ号
$('input[name="qq"]').blur(function(){
    if( $(this).val() == "" || $(this).val().search(/^\d{6,10}$/)==-1){
        $("#qqId").html("请输入正确的QQ号");
        ok5 = false;
     }else{
    	 $("#qqId").html("");
    	 ok5 = true;
     }
})

//验证学号
$('input[name="xuehao"]').blur(function(){
    if($(this).val().search(/^201\d{7}$/)==-1){
        $("#xuehaoId").html("请输入正确的学号");     
        ok2 = false;
    }else{
        $.ajax({
            url:"hedui",
            data:{"xuehao":$(this).val()},
            dataType:"json",
            type:"post",
            success:function(msg){
                if(msg){
                    $("#xuehaoId").html("该学号已经报名");
                    ok2 = false;
                }else{
                	$("#xuehaoId").html("");
                	ok2 = true;
                }
            }
        });
    }

});

$("#form1").submit(function(){
    if(ok1 && ok2 && ok3 && ok4 && ok5 && ok6){
        return true;
    }else{
        alert("报名失败，请确认已正确填写所有内容");
        return false;
    }
});


});
