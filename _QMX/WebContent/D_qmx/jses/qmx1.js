//查找
function myFunction(){
    var input,table,tr,td,i,filter;
    input = document.getElementById("a1");
    filter=input.value.toUpperCase();
    table=document.getElementById("b1");
    tr = table.getElementsByTagName("tr");
    for (var i = tr.length - 1; i >= 0; i--){
        td=tr[i].getElementsByTagName("td")[1];
        if(td){
            if(td.innerHTML.toUpperCase().indexOf(filter)>-1){
                tr[i].style.display="";
            }else{
                tr[i].style.display="none";
            }
        }
    }
}

//取消查找
function cancel(){
    document.getElementById("a1").value="";
    var table,tr,td,i;
    table=document.getElementById("b1");
    tr = table.getElementsByTagName("tr");
    for (var i = tr.length - 1; i >= 0; i--){
        tr[i].style.display="";
    }
}

//删除
function myFunction1(r){
    var set;
    set=confirm("确定删除吗？")
    if(set==true){
        var table=document.getElementById("b1");
        table.deleteRow(r.parentNode.parentNode.rowIndex);
        var table1=document.getElementById("b1");
        var rows=table1.rows;
        for(var i=1;i<rows.length;i++) {
           rows[i].cells[0].innerHTML=i;
        }
    }
    else{
        r.parentNode.parentNode.style.display="";
    } 
}

//显示
function dis(){
    var display=document.getElementById("add");
    if(display.style.display=="block"){
        display.style.display="none";
    }else{
        display.style.display="block";
    }
}

//增加
function add(){
    var mytab=document.getElementById("b1");  
    var no=mytab.rows.length;
    var name=document.getElementById("name").value;
    var iname=document.getElementById("iname").value;
    var name1=document.getElementById("name1").value;
    var name2=document.getElementById("name2").value;
    var name3=document.getElementById("name3").value;
    var name4=document.getElementById("name4").value;
    var name5=document.getElementById("name5").value;
    var name6=document.getElementById("name6").value;
    var tabRow;
    for(var i=1;i<mytab.rows.length;i++){
        var num=parseInt(mytab.rows[i].cells[0].innerText);
        if(num==no){
            alert("编号重复");
            return false;
        }
        if(num>no){
            tabRow=mytab.insertRow(i);
            tabRow.insertCell(0).innerHTML=no;
            tabRow.insertCell(1).innerHTML=name;
            tabRow.insertCell(2).innerHTML=iname;
            tabRow.insertCell(3).innerHTML=name1;
            tabRow.insertCell(4).innerHTML=name2;
            tabRow.insertCell(5).innerHTML=name3;
            tabRow.insertCell(6).innerHTML=name4;
            tabRow.insertCell(7).innerHTML=name5;
            tabRow.insertCell(8).innerHTML=name6;
            tabRow.insertCell(9).innerHTML="<input type='button' value='修改' onclick='alter(this)' > <input type='button' value='删除' onclick='myFunction1(this)' ><input type='button' value='保存修改' onclick='' >";
            return;            
        }
    }
    tabRow=mytab.insertRow(mytab.rows.length);  
    tabRow.insertCell(0).innerHTML=no;
    tabRow.insertCell(1).innerHTML=name;
    tabRow.insertCell(2).innerHTML=iname;
    tabRow.insertCell(3).innerHTML=name1;
    tabRow.insertCell(4).innerHTML=name2;
    tabRow.insertCell(5).innerHTML=name3;
    tabRow.insertCell(6).innerHTML=name4;
    tabRow.insertCell(7).innerHTML=name5;
    tabRow.insertCell(8).innerHTML=name6;
    tabRow.insertCell(9).innerHTML="<input type='button' value='修改' onclick='alter(this)' > <input type='button' value='删除' onclick='myFunction1(this)' ><input type='button' value='保存修改' onclick='' >";
}

//修改
function alter(r){
    var a=window.prompt("请输入要修改的列数");
    a--;
    if(a==0){
        alert("编号不能修改");
        return;
    }
    var mytab=document.getElementById("b1");
    for(var i=1;i<mytab.rows.length;i++){
        if(i==r.parentNode.parentNode.rowIndex){
            if(a<mytab.rows[i].cells.length-1){
                var cellText=mytab.rows[i].cells[a].innerText;
                mytab.rows[i].cells[a].innerHTML="<input onblur=blur1(this,"+i+","+a+") type='text' value="+cellText+" style='width:64px'  />";
            }
        }
   }    
}
function blur1(obj,i,a){
    document.getElementById("b1").rows[i].cells[a].innerText=obj.value;
}