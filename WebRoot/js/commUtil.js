
function selectall(checkedName,ischecked){
  var sum=document.all(checkedName).length;
  for (i=0;i<sum;i++){
      document.all(checkedName)[i].checked=ischecked;
  }
}






function checkRadio(radioName)
{
	    var sum = document.all(radioName).length;
	    var goon= false;
	    var funids="";
	    for(i=0;i<sum;i++) 
	    {
	     	if(document.all(radioName)[i].checked==true)
		{
			goon = true;			
		
		}
	    }
	    if(!goon)
	    {
		  alert("必须选择一项!!!!!!");
		  return false;
            }
	    else
	    {
	      return true;
	    }
}	






function    isDecimal(strValue )  {  
   var  objRegExp= /^\d+\.\d+$/;
   return  objRegExp.test(strValue);  
}  


function isDigit(str) 
{ 
var reg=/^[0-9]{1,20}$/;   
return reg.test(str);     
} 

function IsNull(strObj) {
	strObj = strObj.replace(/(^\s*)|(\s*$)/g, "");
	if(strObj.length > 0){
		return false;
	}else{
		return true;
	}
}


function IsNotNull(strObj) {
	strObj = strObj.replace(/(^\s*)|(\s*$)/g, "");
	if(strObj.length > 0){
		return true;
	}else{
		return false;
	}
}


function isPostalCode(str) 
{ 
var reg=/^[1-9][0-9]{5}$/; 
return reg.test(str);

} 


function IsEmail(str) 
{ 
var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/; 
return reg.test(str);

} 




function validateMobileTel(str) 
{ 
var reg=/1(3|5|8)[0-9]{9}$/
return reg.test(str);
} 



function IsPhone(str) 
{ 
var reg=/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/
return reg.test(str);
}





function showModalWindow(urlstr,width,height) 
{   
    var me;
    me=window;
   // alert(urlstr);
    x=(screen.availWidth-width)/2;
    y=(screen.availHeight-height)/2;
	//dWin=window.open(urlstr);
    dWin=window.showModelessDialog(urlstr,me,'dialogWidth='+width +'px;dialogHeight='+height+'px;help:no;status:no;scroll:no;dialogLeft='+x+';dialogTop='+y);
}


function isCheckboxSelected(checkedName)
{
 try
    { 
	    if(typeof(document.all(checkedName).length)=="undefined")  
            {  
                  if(document.all(checkedName).checked==false)
                  {
                  alert("请选择一条记录后再执行操作!!!!!!");
                  return false;
                  }
                  else
                  {
                  return true;
                  }
            }
            else
            { 
	        var sum = document.all(checkedName).length;
	        var goon= false;
	        var funids="";
	        for(i=0;i<sum;i++)
	        {
	     	  if(document.all(checkedName)[i].checked==true)
		  {
			goon = true;			
		
		  }
	        }
	       if(!goon)
	       {
		  alert("请选择一条记录后再执行操作!!!!!!");
		  return false;
               }
	       else
		   {
	           return true;
	           }
	   }
	 }
	 catch(e){ alert(E);}
}	 

