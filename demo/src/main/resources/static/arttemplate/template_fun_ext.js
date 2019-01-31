/** 
 * 为模板引擎注册外部处理函数
 */




/** 
 * 对日期进行格式化， 
 * @param date 要格式化的日期 
 * @param format 进行格式化的模式字符串
 *     支持的模式字母有： 
 *     y:年, 
 *     M:年中的月份(1-12), 
 *     d:月份中的天(1-31), 
 *     h:小时(0-23), 
 *     m:分(0-59), 
 *     s:秒(0-59), 
 *     S:毫秒(0-999),
 *     q:季度(1-4)
 * @return String
 * @author Xu
 * @see	http://yaniswang.com/frontend/2013/02/16/dateformat-performance/
 */
template.helper('dateFormat', function (date, format) {
	if(date==null || date == "") return "";
	date = date.substr(0,date.lastIndexOf("."));
	date = date.replace(/-/g,"/");
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
    format = format.replace(/([yMdhmsqS])+/g, function(all, t){
        var v = map[t];
        if(v !== undefined){
            if(all.length > 1){
                v = '0' + v;
                v = v.substr(v.length-2);
            }
            return v;
        }
        else if(t === 'y'){
            return (date.getFullYear() + '').substr(4 - all.length);
        }
        return all;
    });
    return format;
});

/** 
 * 对日期进行格式化， 毫秒
 * @param date 要格式化的日期 
 * @param format 进行格式化的模式字符串
 *     支持的模式字母有： 
 *     y:年, 
 *     M:年中的月份(1-12), 
 *     d:月份中的天(1-31), 
 *     h:小时(0-23), 
 *     m:分(0-59), 
 *     s:秒(0-59), 
 *     S:毫秒(0-999),
 *     q:季度(1-4)
 * @return String
 * @author Xu
 * @see	http://yaniswang.com/frontend/2013/02/16/dateformat-performance/
 */
template.helper('timeFormat', function (date, format) {
	if(date==null || date == "") return "";
	format = new Date(date).Format("yyyy-MM-dd");
	return format;
});

/** 
 * 数字四舍五入
 * @param date 要四舍五入的数字
 * @param format 进行格式化的模式字符串
 * @return String
 * @author Xu
 * @see	http://yaniswang.com/frontend/2013/02/16/dateformat-performance/
 */
template.helper('mathRound', function (date, format) {
	if(date==null || date == "" || date == "0" || date == 0) return "0";
	format = Math.round(date);
	return format;
});

/** 
 * 数字保留小数点后两位
 * @param date 要四舍五入的数字
 * @param format 进行格式化的模式字符串
 * @return String
 * @author Xu
 * @see	http://yaniswang.com/frontend/2013/02/16/dateformat-performance/
 */
template.helper('mathRound2', function (date, format) {
	if(date==null || date == "" || date == "0" || date == 0) return "0";
	format = (date*100).toFixed(2);
	return format;
});

Date.prototype.Format = function (fmt) { //author: meizz 
var o = {
  "M+": this.getMonth() + 1, //月份 
  "d+": this.getDate(), //日 
  "h+": this.getHours(), //小时 
  "m+": this.getMinutes(), //分 
  "s+": this.getSeconds(), //秒 
  "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
  "S": this.getMilliseconds() //毫秒 
};
if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
for (var k in o)
if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
return fmt;
}

/**
 * 审核结论对比转换
 */
template.helper('resultHisTransStd', function (date) {
	if(date == null) {
		return "";
	}
    return commonMgr.resultHisTransStd.replace ? commonMgr.resultHisTransStd.replace("["+date+"]") : "";
});

/**
 * 审核结论对比转换
 */
template.helper('resultHisTrans', function (date) {
	if(date == null) {
		return "";
	}
    return commonMgr.resultHisTrans.replace ? commonMgr.resultHisTrans.replace("["+date+"]") : "";
});