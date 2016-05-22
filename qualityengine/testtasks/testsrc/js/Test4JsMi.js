function addEvent(elm, evType, fn, useCapture) {   
  if (elm.addEventListener) {   
    elm.addEventListener(evType, fn, useCapture);//DOM2.0   
    return true;   
  }   
  else if (elm.attachEvent) {   
    var r = elm.attachEvent('on' + evType, fn);//IE5+   
    return r;   
  }   
  else {   
    elm['on' + evType] = fn;//DOM 0   
  }   
}

var getElementsByClassName = function (searchClass, node,tag) {   
    if(document.getElementsByClassName){   
        return  document.getElementsByClassName(searchClass)   
    }else{   
        node = node || document;   
        tag = tag || "*";   
        var classes = searchClass.split(" "),   
        elements = (tag === "*" && node.all)? node.all : node.getElementsByTagName(tag),   
        patterns = [],   
        returnElements = [],   
        current,   
        match;   
        var i = classes.length;   
        while(--i >= 0){   
            patterns.push(new RegExp("(^|\\s)" + classes[i] + "(\\s|$)"));   
        }   
        var j = elements.length;   
        while(--j >= 0){   
            current = elements[j];   
            match = false;   
            for(var k=0, kl=patterns.length; k  
                match = patterns[k].test(current.className);   
                if (!match)  break;   
            }   
            if (match)  returnElements.push(current);   
        }   
        return returnElements;   
    }   
} 