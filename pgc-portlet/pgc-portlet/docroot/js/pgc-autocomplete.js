 jQuery(document).ready(function(){	 
	 //auto complete for Requestor
	 jQuery("#reqInfo\\.requestorName").autocomplete('/o/pgc-portlet/jsps/include/getData.jsp?data='+jQuery("#requestor").val()+'&companyId='+jQuery("#companyId").val(), {
     	  dataType: "xml",
     	matchSubset: false,
     	cacheLength: 0,
     	  beforeSend: function(x) {
     	        if(x && x.overrideMimeType) {
     	            x.overrideMimeType("text/xml");
     	        }
     	    },
     	  parse: function(xml) {
			  var results = [];
   		  jQuery(xml).find('user').each(function(){
 				var name = jQuery(this).find('name').text();
 				var userId = jQuery(this).find('userId').text();
 				var employeeId = jQuery(this).find('employeeId').text();
				results[results.length] = { 'data': { name: name, userId: userId, employeeId: employeeId },
				'result': name, 'value': name};
 				});
				return results;
 			},
			formatItem: function(data) {
				return data.name;
			}
		}).result(function(e, data) {	
			jQuery("#reqInfo\\.requestorId").val(data.userId).change();
			jQuery("#reqInfo\\.requestorEmployeeId").val(data.employeeId).change();
		
		});
	 //auto complete for Requestor in dashboard
	 jQuery("#requestor").autocomplete('/o/pgc-portlet/jsps/include/getData.jsp?data='+jQuery("#requestorSearch").val()+'&companyId='+jQuery("#companyId").val(), {
     	  dataType: "xml",
     	matchSubset: false,
     	cacheLength: 0,
     	  beforeSend: function(x) {
     	        if(x && x.overrideMimeType) {
     	            x.overrideMimeType("text/xml");
     	        }
     	    },
     	  parse: function(xml) {
			  var results = [];
   		  jQuery(xml).find('user').each(function(){
 				var name = jQuery(this).find('name').text();
 				var userId = jQuery(this).find('userId').text();
 	
				results[results.length] = { 'data': { name: name, userId: userId },
				'result': name, 'value': name};
 				});
				return results;
 			},
			formatItem: function(data) {
				return data.name;
			}
		}).result(function(e, data) {	
			jQuery("#reqInfo\\.requestorId").val(data.userId).change();
			
		});
	//auto complete for Manager
	 jQuery("#reqInfo\\.managerName").autocomplete('/o/pgc-portlet/jsps/include/getData.jsp?data='+jQuery("#manager").val()+'&companyId='+jQuery("#companyId").val(), {
     	  dataType: "xml",
     	matchSubset: false,
     	cacheLength: 0,
     	  beforeSend: function(x) {
     	        if(x && x.overrideMimeType) {
     	            x.overrideMimeType("text/xml");
     	        }
     	    },
     	  parse: function(xml) {
			  var results = [];
   		  jQuery(xml).find('user').each(function(){
 				var name = jQuery(this).find('name').text();
 				var userId = jQuery(this).find('userId').text();
 				var email = jQuery(this).find('email').text();
 				results[results.length] = { 'data': { name: name, userId: userId,email:email },
				'result': name, 'value': name};
 				});
				return results;
 			},
			formatItem: function(data) {
				return data.name;
			}
		}).result(function(e, data) {
			
				jQuery("#reqInfo\\.managerEmployeeId").val(data.userId).change();
				jQuery("#reqInfo\\.managerEmail").val(data.email).change();
		
		});																														
	 //auto complete for Vice president
	 jQuery("#reqInfo\\.vpName").autocomplete('/o/pgc-portlet/jsps/include/getData.jsp?data='+jQuery("#vicepresident").val()+'&companyId='+jQuery("#companyId").val(), {
     	  dataType: "xml",
     	matchSubset: false,
     	cacheLength: 0,
     	  beforeSend: function(x) {
     	        if(x && x.overrideMimeType) {
     	            x.overrideMimeType("text/xml");
     	        }
     	    },
     	  parse: function(xml) {
			  var results = [];
   		  jQuery(xml).find('user').each(function(){
 				var name = jQuery(this).find('name').text();
 				var userId = jQuery(this).find('userId').text();
 				var email = jQuery(this).find('email').text();
 				results[results.length] = { 'data': { name: name, userId: userId,email:email },
				'result': name, 'value': name};
 				});
				return results;
 			},
			formatItem: function(data) {
				return data.name;
			}
		}).result(function(e, data) {
			
				jQuery("#reqInfo\\.vpEmployeeId").val(data.userId).change();
				jQuery("#reqInfo\\.vpEmail").val(data.email).change();
		
		});
	 
// autocomplete code for costCenter

	 	jQuery("#costCenterText").autocomplete('/o/pgc-portlet/jsps/include/getData.jsp?data='+jQuery("#costInfo").val()+'&companyId='+jQuery("#companyId").val(), {
 			 dataType: "xml",
 			matchSubset: false,
 			cacheLength: 0,
 	      	  beforeSend: function(x) {
 	      	        if(x && x.overrideMimeType) {
 	      	            x.overrideMimeType("text/xml");
 	      	        }
 	      	    },
 	      	  parse: function(xml) {
 				  var results = [];
 	    		  jQuery(xml).find('costcenter').each(function(){
 	  				var name = jQuery(this).find('name').text();
 	  			 	  				  			
 					results[results.length] = { 'data': { name: name},
 					'result': name, 'value': name};
 	  				});
 					return results;
 	  			},
 				formatItem: function(data) {
 					return data.name;
 				}
 			}).result(function(e, data) {	
 				jQuery("#costCenterId").val(data.name);
 					
 			});
	 	
	 	 // autocomplete code for wbs
	 	jQuery("#wbsElementText").autocomplete('/o/pgc-portlet/jsps/include/getData.jsp?data='+jQuery("#wbs").val()+'&companyId='+jQuery("#companyId").val(), {
 			 dataType: "xml",
 			matchSubset: false,
 			cacheLength: 0,
 	      	  beforeSend: function(x) {
 	      	        if(x && x.overrideMimeType) {
 	      	            x.overrideMimeType("text/xml");
 	      	        }
 	      	    },
 	      	  parse: function(xml) {
 				  var results = [];
 	    		  jQuery(xml).find('wbselement').each(function(){
 	  				var name = jQuery(this).find('name').text();
 	  				name = name.replace("&amp;", "&");
 					results[results.length] = { 'data': { name: name},
 					'result': name, 'value': name};
 	  				});
 					return results;
 	  			},
 				formatItem: function(data) {
 					var wbsName = data.name;
 					wbsName = wbsName.replace("&amp;", "&");
 					return wbsName;
 				}
 			}).result(function(e, data) {	
 				jQuery("#wbsElementId").val();
 			});
 });