function sort(data,name){
   return quickSort(data,name,0,data.length-1);
}

function quickSort(data,name,l,r){
	if(l<r){
		var mid=data[parseInt((l+r)/2)],i=l-1,j=r+1;
		while(true){
			while(name?(data[++i][name]<mid[name]):(data[++i]<mid));
            while(name?(data[--j][name]>mid[name]):(data[--j]>mid));
            if(i>=j){
            	break;
            }
            var temp = data[i];
            data[i]=data[j];
            data[j]=temp;
        }
		quickSort(data,name,l,i-1);
		quickSort(data,name,j+1,r);
    }
    return data;
}

function copy(src,dest){
	if(src&&dest){
		var name = null;
		for(name in src){
			dest[name]=src[name];
		}
	}
	return dest;
}

function clone(obj){
	var result = null;
	if(obj){
		result = new Object();
		var property_name = null;
		for(property_name in obj){
			result[property_name]=obj[property_name];
		}
	}else{
		result = obj;
	}
	return result;
}