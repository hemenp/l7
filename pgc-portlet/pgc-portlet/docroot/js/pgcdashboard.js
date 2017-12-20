/**
 * Author: Vijayan Chendrayan
 */

var dashboard = jQuery.noConflict();

/**
 * This method belonging to clearing the inputs for dashboard search.
 */	
function clearSearchForm(clearButton)
{
	var buttonBlk = dashboard(clearButton).parents(".searchForm");
	clearInputs(buttonBlk);
}

/**
 * This method belonging to display popup.
 */	
dashboard(document).ready(function()
{
	dashboard("#reqsListTable").find("tr:even").addClass("alt");
	dashboard('#dialog_new').jqm();
	dashboard("#formType").change(function()
    {
		var title = dashboard("#formType option:selected").attr("title");
		var titlechange = dashboard("#titleon");
		
		if (title == "")
		{
			return false;
		}
		else
		{
			titlechange.text(title);
			dashboard('#dialog_new').jqmShow();	
		}	
	 });
	
	$(".jqmClose").click(function(){
		dashboard('#dialog_new').jqmHide();
	});
	
	dashboard(".search-title").click(function() {
		dashboard(this).toggleClass("inactive");
		if(dashboard(this).hasClass('inactive')){
			dashboard("#searchBlock").hide();	
		} else {
			dashboard("#searchBlock").show();	
		}
		
    });
	
	
});

dashboard(document).ready(function()
{
	dashboard("#startDate").datepick({
		pickerClass: 'noPrevNext',
        showTrigger: '<img src="/o/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">'
	});

	dashboard("#endDate").datepick({
		pickerClass: 'noPrevNext',
        showTrigger: '<img src="/o/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">'
	});
	
	dashboard('#endDate').change(function() {
		var startDate = dashboard('#startDate').val();
		var endDate = dashboard('#endDate').val();
		if (startDate != '' && endDate != ''){
			if (Date.parse(startDate) >= Date.parse(endDate)) {
				dashboard('#endDate').val('');
				alert('End Date should be greater than the start date');
			}
		}
	});
	
	dashboard('#startDate').change(function() {
		var startDate = dashboard('#startDate').val();
		var endDate = dashboard('#endDate').val();
		if (startDate != '' && endDate != '') {
			if (Date.parse(startDate) >= Date.parse(endDate)) {
				dashboard('#startDate').val('');
				alert('Start Date should be less than the end date');
			}
		}
	});
});

function checkNewReqType(form)
{
    var reqType = form.formType.value;
    if (reqType.length == 0)
    {
        alert('Please select a suitable Form for creation!');
        return false;
    }
    return true;
}