//模板时间格式化
template.helper('dateFormat', function (date, format) {
 
			if(date==null||date=='') return;
			date = new Date(date);
			var map = {
				"M": date.getMonth() + 1, //月份 
				"d": date.getDate(), //日 
				"h": date.getHours(), //小时 
				"m": date.getMinutes(), //分 
				"s": date.getSeconds(), //秒 
				"q": Math.floor((date.getMonth() + 3) / 3), //季度 
				"S": date.getMilliseconds() //毫秒 
			};
			format = format.replace(/([yMdhmsqS])+/g, function (all, t) {
				var v = map[t];
				if (v !== undefined) {
					if (all.length > 1) {
						v = '0' + v;
						v = v.substr(v.length - 2);
					}
					return v;
				} else if (t === 'y') {
					return (date.getFullYear() + '').substr(4 - all.length);
				}
				return all;
			});
			return format;
		});
//文件大小格式化
template.helper('byteFormat', function (limit) {
	var size = "";
	if( limit < 0.1 * 1024 ){ //如果小于0.1KB转化成B
		size = limit.toFixed(2) + "B"; 	
	}else if(limit < 0.1 * 1024 * 1024 ){//如果小于0.1MB转化成KB
		size = (limit / 1024).toFixed(2) + "KB";			
	}else if(limit < 0.1 * 1024 * 1024 * 1024){ //如果小于0.1GB转化成MB
		size = (limit / (1024 * 1024)).toFixed(2) + "MB";
	}else{ //其他转化成GB
		size = (limit / (1024 * 1024 * 1024)).toFixed(2) + "GB";
	}
	var sizestr = size + ""; 
	var len = sizestr.indexOf("\.");
	var dec = sizestr.substr(len + 1, 2);
	if(dec == "00"){//当小数点后为00时 去掉小数部分
		return sizestr.substring(0,len) + sizestr.substr(len + 3,2);
	}
	return sizestr;
});