 function CPos(x, y)
 {
     this.x = x;
     this.y = y;
  }
    
 function GetObjPos(ATarget)
 {
     var target = ATarget;
	 var target = ATarget;
     var pos = new CPos(target.offsetLeft, target.offsetTop);      
     var target = target.offsetParent;  //(1)
	 var target = target.offsetParent;  //(1)
	 var target = target.offsetParent;  //(1)
     while (target)
     {
         pos.x += target.offsetLeft;
         pos.y += target.offsetTop;     
         target = target.offsetParent  //(2)
     }
     return pos;
 }
 