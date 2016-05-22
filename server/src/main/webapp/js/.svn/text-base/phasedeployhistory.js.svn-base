/**
 * bind the paginate to div element.
 * 
 */
$(document).ready(function() {
    $("#deployHistoryPaginate").paginate({
        count : $('#count').val(),
        start : 1,
        display : 5,
        border : true,
        border_color : '#fff',
        text_color : '#fff',
        background_color : 'black',
        border_hover_color : '#ccc',
        text_hover_color : '#000',
        background_hover_color : '#fff',
        images : true,
        mouse : 'press',
        onChange : function(page) {
            fixCompatibilityForIE10();
            getDeployHistoryInfoByAjax(page);
        }
    });
    fixCompatibilityForIE10();
});

/**
 * fix compatible problem for IE 10 other browser do not need it.
 */
function fixCompatibilityForIE10() {
    $(".jPag-pages").css({
        "width" : Number($('.jPag-pages')[0].style.width.replace(/px/, "")) + 10 + "px"
    });
}

/**
 * to get deploy history info by sending ajax.
 * 
 * @param page
 *            that current select
 */
function getDeployHistoryInfoByAjax(page) {
    var productId = $('#productId').val();
    var stage = $('#stage').val();
    var data = "productId=" + productId + "&stage=" + stage + "&page=" + page;
    createAjax("/updatephasedeployhistory", data, updateDeployHistoryInfo);
}

/**
 * update deploy history inof. make the inner table of div
 * 
 * @param response
 */
function updateDeployHistoryInfo(response) {
    var dateFormat = "yyyy-MM-dd hh:mm:ss.S";
    var nullTd = "<td>" + " " + "</td>";
    var table = "<table id=\"deployHistoryTable\" bordercolor=\"#00526a\" "
            + "border=\"2\" cellpadding=\"2\" cellspacing=\"0\" style=\"color:white;\">";
    table += "<tr><td>Status</td> " + "<td>Deploy Type</td>" + "<td>Version</td>" + "<td>Preview Deploy Time</td>"
            + "<td>Production Deploy Time</td> " + "<td>Create Time</td>" + "<td>Deploy By</td>" + " <td>Log</td></tr>";

    for ( var i = 0; i < response.length; i++) {
        var d = new Date();
        table += "<tr><td>" + response[i].result + "</td>";
        table += "<td>" + response[i].type + "</td>";
        table += "<td>" + response[i].version + "</td>";
        if (response[i].previewDeployTime != null) {
            d.setTime(response[i].previewDeployTime);
            table += "<td>" + d.Format(dateFormat) + "</td>";
        } else {
            table += nullTd;
        }
        if (response[i].productionDeployTime != null) {
            d.setTime(response[i].productionDeployTime);
            table += "<td>" + d.Format(dateFormat) + "</td>";
        } else {
            table += nullTd;
        }
        if (response[i].createTime != null) {
            d.setTime(response[i].createTime);
            table += "<td>" + d.Format(dateFormat) + "</td>";
        } else {
            table += nullTd;
        }

        table += "<td>" + response[i].deployUser + "</td>";
        if(response[i].log!=null){
        	table += "<td><a href=/getlogpage?logKey=\""+response[i].log+"\">log</a></td></tr>";
        } else {
        	table += "<td></td></tr>";
        }
    }
    table += "</table>";
    $('#deployHistory').html(table);
}

/**
 * date format.
 * 
 * @param data
 *            format
 */
Date.prototype.Format = function(fmt) {
    var o = {
        "M+" : this.getMonth() + 1,
        "d+" : this.getDate(),
        "h+" : this.getHours(),
        "m+" : this.getMinutes(),
        "s+" : this.getSeconds(),
        "q+" : Math.floor((this.getMonth() + 3) / 3),
        "S" : this.getMilliseconds()
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for ( var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}