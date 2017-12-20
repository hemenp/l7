 $(document).ready(function(){
	 $("#eprocureUser").autocomplete('/o/e-procurement-portlet/jsps/workflow/getData.jsp?data='+$("#data").val()+'&companyId='+$("#companyId").val(), {
      	  dataType: "xml",
      	  max:25,
      	  matchSubset: false,
      	  cacheLength: 0,
      	  beforeSend: function(x) {
      	        if(x && x.overrideMimeType) {
      	            x.overrideMimeType("text/xml");
      	        }
      	    },
      	  parse: function(xml) {
			  var results = [];
    		  $(xml).find('user').each(function(){
  				var name = $(this).find('name').text();
  				var userId = $(this).find('userId').text();
  				var jobTitle = $(this).find('jobTitle').text();
				results[results.length] = { 'data': { name: name, userId: userId, jobTitle: jobTitle },
				'result': name, 'value': name};
  				});
				return results;
  			},
			formatItem: function(data) {
				return data.name;
			}
		}).result(function(e, data) {	
				$("#userId").val(data.userId);
				$("#jobTitle").val(data.jobTitle);
		});
	 
	// autocomplete code for reports webadmin
	 $("#stageUser").autocomplete('/o/e-procurement-portlet/jsps/workflow/getData.jsp?data='+$("#stagedata").val()+'&companyId='+$("#companyId").val(), {
     	  dataType: "xml",
     	  max:25,
     	  matchSubset: false,
     	  cacheLength: 0,
     	  beforeSend: function(x) {
     	        if(x && x.overrideMimeType) {
     	            x.overrideMimeType("text/xml");
     	        }
     	    },
     	  parse: function(xml) {
			  var results = [];
   		  $(xml).find('user').each(function(){
 				var name = $(this).find('name').text();
 				var userId = $(this).find('userId').text();
				results[results.length] = { 'data': { name: name, userId: userId },
				'result': name, 'value': name};
 				});
				return results;
 			},
			formatItem: function(data) {
				return data.name;
			}
		}).result(function(e, data) {	
				$("#stageUserId").val(data.userId);
		});
     
 	
 		// autocomplete code for supervisor
	 	$("#supervisorName").autocomplete('/o/e-procurement-portlet/jsps/purchase/getData.jsp?data='+$("#data").val()+'&companyId='+$("#companyId").val(), {
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
 	    		  $(xml).find('user').each(function(){
 	  				var name = $(this).find('name').text();
 	  				var userId = $(this).find('userId').text();
 	  				var email = $(this).find('email').text();
 	  			
 					results[results.length] = { 'data': { name: name, userId: userId,email:email },
 					'result': name, 'value': name};
 	  				});
 					return results;
 	  			},
 				formatItem: function(data) {
 					return data.name;
 				}
 			}).result(function(e, data) {	
 					$("#supervisorId").val(data.userId);
 					$("#supervisorEmail").val(data.email);
 					
 			}); 
	 // autocomplete code for vendor
	 	$("#vendorName").autocomplete('/o/e-procurement-portlet/jsps/purchase/getData.jsp?data='+$("#vendor").val()+'&companyId='+$("#companyId").val(), {
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
 	    		  $(xml).find('vendor').each(function(){
 	  				var name = $(this).find('name').text();
 	  				var vendorcode = $(this).find('vendorcode').text();
 	  				var email = $(this).find('email').text();
 	  				 	  				
 					results[results.length] = { 'data': { name: name, vendorcode:vendorcode, email: email },
 					'result': name, 'value': name};
 	  				});
 					return results;
 	  			},
 				formatItem: function(data) {
 					return data.name;
 				},
 				width: 260
 			}).result(function(e, data) {	
 					$("#vendorCode").val(data.vendorcode);
 					$("#vendorEmail").val(data.email);
 					
 			}); 
	 	 // autocomplete code for wbs
	 	$("#wbsElement").autocomplete('/o/e-procurement-portlet/jsps/purchase/getData.jsp?data='+$("#wbs").val()+'&companyId='+$("#companyId").val(), {
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
 	    		  $(xml).find('wbselement').each(function(){
 	  				var name = $(this).find('name').text();
 	  			
 	  				  			
 					results[results.length] = { 'data': { name: name},
 					'result': name, 'value': name};
 	  				});
 					return results;
 	  			},
 				formatItem: function(data) {
 					return data.name;
 				}
 			}).result(function(e, data) {	
 				$("#wbsElementId").val(data.name);
 					
 			});
	 	 // autocomplete code for glaccountno
	 	$("#glAccNo").autocomplete('/o/e-procurement-portlet/jsps/purchase/getData.jsp?data='+$("#glAcccount").val()+'&companyId='+$("#companyId").val(), {
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
 	    		  $(xml).find('glaccount').each(function(){
 	  				var name = $(this).find('name').text();
 	  			  				  			
 					results[results.length] = { 'data': { name: name},
 					'result': name, 'value': name};
 	  				});
 					return results;
 	  			},
 				formatItem: function(data) {
 					return data.name;
 				}
 			}).result(function(e, data) {	
 				$("#glAccountNoId").val(data.name);
 					
 			});
	 	 // autocomplete code for costCenter
	 	$("#costCenter").autocomplete('/o/e-procurement-portlet/jsps/purchase/getData.jsp?data='+$("#costInfo").val()+'&companyId='+$("#companyId").val(), {
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
 	    		  $(xml).find('costcenter').each(function(){
 	  				var name = $(this).find('name').text();
 	  			 	  				  			
 					results[results.length] = { 'data': { name: name},
 					'result': name, 'value': name};
 	  				});
 					return results;
 	  			},
 				formatItem: function(data) {
 					return data.name;
 				}
 			}).result(function(e, data) {	
 				$("#costCenterId").val(data.name);
 					
 			});
	 });
