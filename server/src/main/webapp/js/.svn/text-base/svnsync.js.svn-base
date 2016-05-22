$.fn.dataTableExt.oApi.fnPagingInfo = function ( oSettings )
{
  return {
    "iStart":         oSettings._iDisplayStart,
    "iEnd":           oSettings.fnDisplayEnd(),
    "iLength":        oSettings._iDisplayLength,
    "iTotal":         oSettings.fnRecordsTotal(),
    "iFilteredTotal": oSettings.fnRecordsDisplay(),
    "iPage":          Math.ceil( oSettings._iDisplayStart / oSettings._iDisplayLength ) + 1,
    "iTotalPages":    Math.ceil( oSettings.fnRecordsDisplay() / oSettings._iDisplayLength )
  };
};

$.fn.dataTableExt.oApi.fnReloadAjax = function ( oSettings, sNewSource, fnCallback, bStandingRedraw )
{
    if ( typeof sNewSource != 'undefined' && sNewSource != null ) {
        oSettings.sAjaxSource = sNewSource;
    }
 
    // Server-side processing should just call fnDraw
    if ( oSettings.oFeatures.bServerSide ) {
        this.fnDraw();
        return;
    }
 
    this.oApi._fnProcessingDisplay( oSettings, true );
    var that = this;
    var iStart = oSettings._iDisplayStart;
    var aData = [];
  
    this.oApi._fnServerParams( oSettings, aData );
      
    oSettings.fnServerData.call( oSettings.oInstance, oSettings.sAjaxSource, aData, function(json) {
        /* Clear the old information from the table */
        that.oApi._fnClearTable( oSettings );
          
        /* Got the data - add it to the table */
        var aData =  (oSettings.sAjaxDataProp !== "") ?
            that.oApi._fnGetObjectDataFn( oSettings.sAjaxDataProp )( json ) : json;
          
        for ( var i=0 ; i<aData.length ; i++ )
        {
            that.oApi._fnAddData( oSettings, aData[i] );
        }
          
        oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
          
        if ( typeof bStandingRedraw != 'undefined' && bStandingRedraw === true )
        {
            oSettings._iDisplayStart = iStart;
            that.fnDraw( false );
        }
        else
        {
            that.fnDraw();
        }
          
        that.oApi._fnProcessingDisplay( oSettings, false );
          
        /* Callback user function - for event handlers etc */
        if ( typeof fnCallback == 'function' && fnCallback != null )
        {
            fnCallback( oSettings );
        }
    }, oSettings );
};

var productId = "";
var deployRevision = "";
var updateRevision = "";
var canDoUpdate = true; 
var oTable;

$(document).ready(function() {
	initParameter();
    $('#log').html( '<table class="display" id="log_table"></table>' );
    oTable = $('#log_table').dataTable( {
        "bProcessing": true,
        "bServerSide": true,
        "bLengthChange": false,
        "bSort": false,
		"fnRowCallback": function( nRow, aData, iDataIndex ) {
			if (aData[0] == deployRevision) {
				$('td:eq(1)', nRow).parent().css('background-color', '#fe9200');
			}
			$.get("/lastrefreshtime?productId=" + productId, showLastRefreshTime);
         },
        "fnDrawCallback": function() {
        	$('#page_span').remove();
        	$('<span id="page_span" style="position: relative; left:-54px; top: 15px; font-weight:bold; color: white;">'+this.fnPagingInfo().iPage+'</span>').insertAfter('.paginate_enabled_previous');
        	$('<span id="page_span" style="position: relative; left:-54px; top: 15px; font-weight:bold; color: white;">'+this.fnPagingInfo().iPage+'</span>').insertAfter('.paginate_disabled_previous');
        	if (deployRevision == undefined) {
        		$('.dataTables_info').css("color","red").css("font-weight","bold")
        		.css("font-size","14px").html("This build of the product has no hot deploy history");
        	} else {
        		$('.dataTables_info').css("display","none");
        	}
        },
        "sAjaxSource": "/svnlog?productId=" + productId + "&deployRevision=" + deployRevision,
        "aoColumns": [
            { "sTitle": "Revision", "sWidth": "15%" },
            { "sTitle": "Author", "sWidth": "15%" },
            { "sTitle": "Message", "sWidth": "40%"},
            { "sTitle": "Date", "sClass": "center", "sWidth": "30%" }
        ]
    } );   
    $('#log_table tbody tr').live('click', function() {
        if ( $(this).hasClass('row_selected') ) {
            $(this).removeClass('row_selected');
        }
        else {
            oTable.$('tr.row_selected').removeClass('row_selected');
            $(this).addClass('row_selected');
        }
        
        revisionNew = $(this).find('td').eq(0).html();
        revisionPrev = $(this).next().find('td').eq(0).html();
        updateRevision = revisionNew;
        
    	if (deployRevision != "nil" && revisionNew != deployRevision) {
    		$(".name_diff").html("Preview(" + deployRevision + ")" + " diff with Selected(" + revisionNew + ")")
            if (canDoUpdate) {
                $('#update_btn').css("font-size", "26px");
                $('#update_btn').empty();
                $('#update_btn').append('<div id="show_status">Update<div>');
             }
             
             $.get('/svndiff?revOne='+revisionNew+'&revTwo='+deployRevision+"&productId="+productId, showDiff);
             $('#diff').empty();
             $('#diff').append('<img id="updating" src="/image/loadinfo.gif" style="margin-top:140px;margin-left:250px;width:30px;height:30px;"></img>'); 		
    	} else {
    		$('#diff').empty();
    	}

    	if (revisionPrev != undefined) {
	        $(".name_svn_diff").html(revisionNew + " diff with " + revisionPrev);
	        $.get('/svndiff?revOne='+revisionNew+'&revTwo='+revisionPrev+"&productId="+productId, showDiffWithPrev);
	        $('#svn_diff').empty();
	        $('#svn_diff').append('<img id="updating" src="/image/loadinfo.gif" style="margin-top:140px;margin-left:250px;width:30px;height:30px;"></img>');
    	} else {
    		$('#svn_diff').empty();
    	}
    });

    $('#update_btn').click(function() {
        canDoUpdate = false;
        $.get('/svnupdate?updateRevision='+updateRevision+"&productId="+productId, showUpdateResult);
        $('#update_btn').empty();
        $('#update_btn').css("top", "140px");
        $('#note_div').remove();
        $('#update_btn').append('<img id="updating" src="/image/updating.gif"></img>');
        $('#update_container').append('<div id="block_div"></div>');        
    });
    $('#refresh_btn').unbind('click');
    $('#refresh_btn').click(function() {
        oTable.fnReloadAjax();
    });
} );

function showDiff(diffs) {
   $('#diff').empty();
   $('#diff').html(diffs);
}

function showDiffWithPrev(diffs) {
	$('#svn_diff').empty();
	$('#svn_diff').html(diffs);
}

function showUpdateResult(result) {
	$('#update_btn').css("top", "0px");
      if(result == "true") {
           $('#update_btn').empty();
           $('#update_btn').css("font-size", "18px");
           $('#update_btn').append('<div id="update_result_div"></div>');
           $('#update_result_div').append('<img class="result_img" src="/image/update_accepted.png">');
           $('#update_btn').append('<div>Update successfully</div>');
           $('#update_btn').append('<a id="check_preview" href="http://' + $('#targetUrl').val() + '" style="color:red">Preview Site</a>');
           $('#check_preview').click(function(event) {
               event.stopPropagation();
           })
      } else {
           $('#update_btn').empty();
           $('#update_btn').css("font-size", "18px");
           $('#update_btn').append('<div id="update_result_div"></div>');
           $('#update_result_div').append('<img class="result_img" src="/image/update_cancel.png">');
           $('#update_btn').append('<div>Update failed</div>');
      }
      $("#block_div").remove();
      canDoUpdate = true;
}

function initParameter() {
	productId = $("#productId").val();
	deployRevision = $("#deployRevision").val();
	updateRevision = $("#updateRevision").val();
}

function showLastRefreshTime(date) {
	$("#last_update").html(date);
}
