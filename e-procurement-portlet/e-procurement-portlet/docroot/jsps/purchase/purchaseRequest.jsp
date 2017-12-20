<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project E-procurement
 * @author Resmy Mathew
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 *
--%>
<%@ include file="../init.jsp" %>

	       
  	<portlet:actionURL var="createRequestURL">
		<portlet:param name="eProcAction" value="saveRequest"/>	 
		<portlet:param name="action" value="ADD" />
	</portlet:actionURL>
	 <portlet:actionURL var="editRequestURL">
		<portlet:param name="eProcAction" value="editRequest"/>	 
		<portlet:param name="action" value="UPDATE" />
	</portlet:actionURL>
	<portlet:actionURL var="uploadRequestURL">
		<portlet:param name="eProcAction" value="uploadRequest"/>	
		<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
	</portlet:actionURL>
	
	 <portlet:actionURL var="emailRequesterURL">
		<portlet:param name="eProcAction" value="editRequest"/>	 
		<portlet:param name="action" value="UPDATE" />
		<portlet:param name="showEmailRequester" value="TRUE" />
	</portlet:actionURL>
	
	
	
  <% 
  	NumberFormat numberFormat = new DecimalFormat("0.00");
 	String isProject =StringPool.BLANK;
 	String isBudget = StringPool.BLANK;
  	String otherAddress=StringPool.BLANK;
  	String address=StringPool.BLANK;
  	String city=StringPool.BLANK;
  	String state=StringPool.BLANK;
  	String zip=StringPool.BLANK;
	String shipToOther=StringPool.BLANK;
  	String folderId="0";
	String allowedtypes="doc|xls|ppt|msg|pdf|txt|docx|rtf|odt|xlsx|pptx";
	String saveAction="ADD";
	long requestId=0;
	long companyId=0;
	EprocurementRequest eprocuRequest = null;
	Item item = null;
	DLFileEntry dlfFile = null;
	long itemId=0;
	String userId=StringPool.BLANK;
	long userid=0;
	long doUserId=0;
	String requestorName=StringPool.BLANK;
	String requestorEmail=StringPool.BLANK;
	String projectOwnerName=StringPool.BLANK;
	String supervisorName=StringPool.BLANK;
	String supervisorEmail=StringPool.BLANK;
	String projectOwnerEmail=StringPool.BLANK;
	String sPrimary="primaryKey";
	long projectOwnerId=0;
	long supervisorId=0;
	double total=0;
	double orgtotal=0;
	boolean IsWebAdmin = false;
	boolean showEditButton=true;
	String webAdminValue="No";
	String errorMessage=StringPool.BLANK;
	String status = StringPool.BLANK;
	
	String spendDept = StringPool.BLANK;
	String spendYear = StringPool.BLANK;
	
	String vendorName=StringPool.BLANK;
	eprocuRequest= (EprocurementRequest) request.getAttribute("eprocuRequest");
	Object obj= request.getAttribute("folderId");
	Object vendorObject= request.getAttribute("vendorName");
	if(Validator.isNotNull(vendorObject)){
	    vendorName = vendorObject.toString();
		
		}
	if(Validator.isNotNull(obj)){
	 folderId = obj.toString();
	
	}
	Object errorObj= request.getAttribute("errorMessage");
	Object succObj= request.getAttribute("successMsg");
	if(Validator.isNotNull(errorObj)){
	    errorMessage = errorObj.toString();
	
	}
	
	Boolean hasProjectSpendRole = (Boolean)request.getAttribute("hasProjectSpendRole");
	boolean showProjectSpend = false;
	if(hasProjectSpendRole != null) 
		showProjectSpend = hasProjectSpendRole.booleanValue();
	
	User supervisorUser = (User) request.getAttribute("supervisorUser");
	List<Item> items = (List<Item>)request.getAttribute("items");
	List<DLFileEntry> fileData = (List<DLFileEntry>)request.getAttribute("fileEntries");
	List<EprocurementLocation> locations = (List<EprocurementLocation>)request.getAttribute("locations");
	List<User> userGroups = (List<User>)request.getAttribute("userGroup");
	List<String> projectDetails =(List<String>) EprocurementCommonUtil.getProjectDetails();
	EprocurementLocation shipToAddress=null;
	String remoteUserId= request.getRemoteUser();
	if(Validator.isNotNull(remoteUserId)){
	    doUserId = Long.parseLong(remoteUserId);
	}
	if(Validator.isNull(eprocuRequest)){
			userId = request.getRemoteUser();
			if(Validator.isNotNull(userId)){
			userid= Long.parseLong(userId);
			}
			
			
	} else{
		saveAction="UPDATE";
		userid=eprocuRequest.getRequestorId();
		requestId=eprocuRequest.getRequestId();
		status =  eprocuRequest.getStatus();
		
		if(EProcurementPermissionUtil.showRequestChangeButton(themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),eprocuRequest))
		{
		    showEditButton=true;
	
		  
		} else {
		    showEditButton=false;
		}
	}
	if(Validator.isNotNull(userid)){
	    user = UserLocalServiceUtil.getUserById(userid); 
	  	requestorName=user.getFullName();
	  	requestorEmail=user.getEmailAddress();
	}

	if(EProcurementUtil.isWebAdmin(themeDisplay.getCompanyId(), themeDisplay.getUserId()))
	{
	    IsWebAdmin=true;
	    webAdminValue="yes";
	  
	}

%>
<portlet:renderURL var="showEmailRequestorURL">
	<portlet:param name="cmd" value="showEmailRequestor"/>
	<portlet:param name="requestId" value="<%= String.valueOf(requestId) %>"/>
	<portlet:param name="requestorId" value="<%=String.valueOf(userid) %>"/>
</portlet:renderURL>

<portlet:actionURL var="sendReminderVar">
		<portlet:param name="eProcAction" value="sendReminder"></portlet:param>
		<portlet:param name="requestId" value="<%= String.valueOf(requestId) %>"></portlet:param>
	</portlet:actionURL>

 <form name=requestForm id="requestForm" method=post enctype="multipart/form-data">
 <input type="hidden" name="edittedItems" id="edittedItems"  value=""/>
 <input type="hidden" name="editItemValues" id="editItemValues"  value=""/>
 <input type="hidden" name="deletedItems" id="deletedItems"  value=""/>
    <input type="hidden" name="noOfRows" id="noOfRows" value="<%= (Validator.isNotNull(items) ? items.size()+1 :1)%>"/>
    <input type="hidden" name="totalRowsCount" id="totalRowsCount" value="<%= (Validator.isNotNull(items) ? items.size()+1 :1)%>"/>
	<input type="hidden" name="rowBeingModified" id="rowBeingModified" value=""></input>
    <input type="hidden" name="newRows" id="newRows" value="1"/>
    <input type="hidden" name="rowCount" id="rowCount" value="<%= (Validator.isNotNull(items) ? items.size()+1 :1)%>"/>
	<input type="hidden" name="itemRequestString" id="itemRequestString" value=""></input>
	<input type="hidden" name="itemId" id="itemId"  value=""></input>
	<input type="hidden" name="qtyedit" id="qtyedit" value=""></input>
	<input type="hidden" name="costedit" id="costedit" value=""></input>
	<input type="hidden" name="costedit" id="orgcostedit" value=""></input>
	<input type="hidden" name="saveAction" id="saveAction" value="<%=saveAction%>"></input>
	<input type="hidden" name="companyId" id="companyId" value="<%=themeDisplay.getCompanyId() %>" />
	<input type="hidden" name="requestId" id="requestId" value="<%=requestId %>" />
	<input type="hidden" name="data" id="data" value="supervisor" />
	<input type="hidden" name="vendor" id="vendor" value="vendor" />
	<input type="hidden" name="wbs" id="wbs" value="wbselement" />
	<input type="hidden" name="glAcccount" id="glAcccount" value="glAcccount" />
	<input type="hidden" name="costInfo" id="costInfo" value="costInfo" />
	<input type="hidden" name="itemNo" id="itemNo" value="<%= (Validator.isNotNull(items) ? items.size() : "")%>" />
	<input type="hidden" name="requestorName" id="requestorName" value="<%=requestorName %>" />
	<input type="hidden" name="fromAddress" id="fromAddress" value="<%=requestorEmail %>" />
	<input type="hidden" name="webAdmin" id="webAdmin" value="<%=webAdminValue %>" />
	<input type="hidden" name="hiddenParam" value="this is hidden param"></input>
	
	<%if(Validator.isNotNull(errorMessage)) {%>
    
                   <span class="portlet-msg-error">                        
                              <%= errorMessage %>
                   </span>               

    <% 
    	}
	
	
	
	
    	
    	if(Validator.isNotNull(eprocuRequest)) {
    %>
          <h3>&nbsp;&nbsp;<liferay-ui:message key="req.purchase.approval"/></h3>
    <% } else { %> 
        <h3>&nbsp;&nbsp;<liferay-ui:message key="req.create.request"/></h3>
      
    <% } %> 
    				<div style="float: right; padding-right: 11px;">
                   		 <c:if test="${not empty reports}">
								<input type="button" class="button input-button" value='<liferay-ui:message key="req.back"/>' onClick="javascript: history.go(-1)"/>
						</c:if>
					 <% if(Validator.isNotNull(eprocuRequest)) { %>
						<input type="button" class="button input-button" value='<liferay-ui:message key="req.print"/>' onclick="printForm()"/>
					  <% } %> 
					</div>
					
                    <div class="group-list-content" id="divToPrint">
                    
                        <div id="cntr_contentOneCol" style="margin: 0pt auto; padding: 0pt; float: none; width: auto;">
              						    <table class="round-corners">
                                <tbody>
                                    <tr>
                                        <td class="tl">&nbsp;
                                            
                                        </td>
                                        <td>&nbsp;
                                            
                                        </td>
                                        <td class="tr">
                                            &nbsp;&nbsp;&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
									
                                        <td colspan="3" style="padding: 0pt 10px;" class="form-content">
                                           
										   <h3 class="section-title"><liferay-ui:message key="req.shipping.address"/></h3>
										 <div>
										    <table border="0" cellpadding="0" cellspacing="0">
                                                <tbody>
                                                <%	if(Validator.isNotNull(eprocuRequest)) { %>
                                                     <tr>
                                                        <td class="label">
                                                            Request Id
                                                        </td>
                                                        <td class="form-item heading13">
                                                            <%=requestId %>
                                                            
                                                        </td>
                                                        <td>
                                                        </td>
                                                        <td>
                                                        </td>
                                                    </tr>
                                                    <%} %>
                                                    <tr>
                                                        <td class="label">
                                                            <liferay-ui:message key="stage.approver.name"/>
                                                        </td>
                                                        <td class="form-item heading16">
                                                            <%=requestorName%>
                                                            <input type="hidden" name="requestorId" value="<%=userid %> "></input>
                                                        </td>
                                                        <td>
                                                        </td>
                                                        <td>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                    
                                                        <td class="label form-item">
                                                            <liferay-ui:message key="req.dashboard.shipto"/><span class="red_star">*</span>
                                                        </td>
                                                        <td class="form-item">
                                                <div class="field required">
                                                    <select style="width: 250px; _font-size:11px !important;" name="shipTo" id="shipTo">
                                                     <option value="select"><liferay-ui:message key="req.select"/></option>
                                                         
                                          <%  
                                                     if(Validator.isNotNull(eprocuRequest)){
													address = eprocuRequest.getAddress();
													shipToOther=eprocuRequest.getShipToOther();
											  } 
											if(Validator.isNotNull(locations)){
											    for (int i = 0; i < locations.size(); i++) {
												shipToAddress = locations.get(i);
												String sAddress= shipToAddress.getAddress();
												if(sAddress.equalsIgnoreCase(address)){
								      %>														
									 
                                     		<option selected="selected"  value="<%=shipToAddress.getAddress()%>"><%=shipToAddress.getAddress()%></option>
							 		<%			} else { %>
							 	    	<option  value="<%=shipToAddress.getAddress()%>"><%=shipToAddress.getAddress()%></option>
							 	    <%
							 			}

										}}
										if(shipToOther.equalsIgnoreCase("YES")) { %>
									 		<option value="Other" selected="selected"><liferay-ui:message key="req.other"/></option>
											<% } else { %>
												<option value="Other"><liferay-ui:message key="req.other"/></option>
											<%} %>
										</select>
                                                    </div>
                                                       </td>
                                                        <td class="label">
                                                        </td>
                                                        <td class="form-item">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="label form-item" style="vertical-align: text-top;">
                                                        </td>
                                                        <td class="form-item" colspan="3">
                                                        	
															<table id="addressTable" cellspacing="0" cellpadding="0" border="0" style="border-bottom: 0pt none;" class="search-result-table btmmargin">
				<tbody>
				<tr class="alt">
				  
					<th class="colm-1"><liferay-ui:message key="req.address"/></th>
					<th class="colm-2"><liferay-ui:message key="req.city"/></th>
					<th class="colm-2"><liferay-ui:message key="req.state"/></th>
					<th class="colm-2"><liferay-ui:message key="req.zip"/></th>
					</tr>
				
				
				<tr>
				<% 
					if(shipToOther.equalsIgnoreCase("YES")) {
					    otherAddress=eprocuRequest.getAddress();
					    city=eprocuRequest.getCity();
					    state=eprocuRequest.getState();
					    zip=eprocuRequest.getZip();
					}
				
				%>
				  <td class="colm-1"><input class="text-field width180"  value="<%= (Validator.isNotNull(otherAddress) ? otherAddress : "")%>" id="address"  name = "address" type="text" maxlength="60" /></td>
				  <td class="colm-2"><input class="text-field width100" value="<%= (Validator.isNotNull(city) ? city : "")%>" id="state"  name="state" type="text" maxlength="60" /></td>
				  <td class="colm-2"> <input class="text-field width70" value="<%= (Validator.isNotNull(state) ? state : "")%>" id="city"   name = "city"type="text" maxlength="3"/></td>
				  <td class="colm-2">  <input class="text-field width70" value="<%= (Validator.isNotNull(zip) ? zip : "")%>" id= "zip" name= "zip" type="text"  maxlength="5" /></td>
				</tr>
				
				</tbody>
			</table>
                                                        
                  </td>
                  </tr>
                                                </tbody>
                                            </table>
											</div>
											
										 <h3 class="section-title"><liferay-ui:message key="req.project.details"/></h3>
										 <div >
                                            <table class="btmmargin"  border="0" cellpadding="0" cellspacing="0">
										   
                                           
                                           <tr>                                      
										<td class="label width200"><liferay-ui:message key="req.is.budgeted"/><span class="red_star">*</span></td>
 										 <td class="form-item">
										    <select name="budgetedRequest" id="budgetedRequest"  class="width100" style="_font-size:11px !important;">
										 		<% 
										 	

										 	if(Validator.isNotNull(eprocuRequest)){
										 	    isBudget =eprocuRequest.getIsBudgetedRequest();
										 	} else { 
										 	    %>
										 	 	<option  value="0" selected="selected"><liferay-ui:message key="req.select"/></option>
										 	<%}
										 	  if(Validator.isNotNull(projectDetails)){
												    for(int i=0;i<projectDetails.size();i++){
												        String budgetedRequest=projectDetails.get(i) ;
												      
												        if(budgetedRequest.equalsIgnoreCase(isBudget)){
												    
												    
												
										  	
										  	%>  
										  	<option  value="<%=isBudget %>" selected="selected"><%=isBudget %></option>
										  	<% } else  { %>
                                              	<option  value="<%=budgetedRequest %>"><%=budgetedRequest %></option>
                                            <% 	
                                            	} // end of else
												    } // end of for
										 	  } //end of if
										 
											%>
                                       
                                             </select></td>
  <td  colspan="2" class="nopad" >
  <table border="0" cellpadding="0" cellspacing="0" class="pojectname">
    <tr>
       <td class="label width100 "> <liferay-ui:message key="req.project.name"/><span class="red_star">*</span></td>
        <td>
      <input title="Enter the Project Name" name="projectName" id="projectName" value="<%= (Validator.isNotNull(eprocuRequest) ? eprocuRequest.getProjectName() : "")%>" class="text-field"  style="width:190px" type="text" maxlength="65" />
      <td>

    </tr>
  </table>
    </td>
</tr>
         <tr>                                      
<td class="label width200"> <liferay-ui:message key="req.is.project.related"/><span class="red_star">*</span></td>
  <td class="form-item">
  								<select name="relatedProject" id="relatedProject" class="width100" style="_font-size:11px !important;">
  										<% 
  										if(Validator.isNotNull(eprocuRequest)){
  										   isProject=eprocuRequest.getIsRelatedtoProject();
										  		 
  										} else { 
										%>
										 	<option  value="0" selected="selected"><liferay-ui:message key="req.select"/></option>
										<%
										 	} 
											  if(Validator.isNotNull(projectDetails)){
												    for(int i=0;i<projectDetails.size();i++){
												        String relatedRequest=projectDetails.get(i) ;
												       
												        if(relatedRequest.equalsIgnoreCase(isProject)){
										%>  
										  	<option  value="<%=isProject %>" selected="selected"><%=isProject %></option>
										  	<% } else  { %>
                                              	<option  value="<%=relatedRequest %>"><%=relatedRequest %></option>
                                            <% 	
                                            	} // end of else
												    } // end of for
										 	  } //end of if
										 
											%>
 										 </select></td>
  <td  colspan="2" class="nopad" ><table border="0" cellpadding="0" cellspacing="0" class="pojectowner">
    <tr>
    <td class="label width100" > <liferay-ui:message key="req.project.manager"/><span class="red_star">*</span></td>
      <%	
     	 if(Validator.isNotNull(supervisorUser)){
          supervisorId=supervisorUser.getUserId();
          supervisorName=supervisorUser.getFullName();
          supervisorEmail = supervisorUser.getEmailAddress();
          
      	}
      
      	if(Validator.isNotNull(eprocuRequest)) {
    	  	projectOwnerId= eprocuRequest.getProjectOwnerId();
    	  	supervisorId = eprocuRequest.getSupervisorId();
    	  	if(Validator.isNotNull(projectOwnerId)){
    	  		user = UserLocalServiceUtil.getUserById(projectOwnerId); 
    	  		projectOwnerName= user.getFullName();
    	  		projectOwnerEmail = user.getEmailAddress();
    	  		
    	  	}
    	  	if(Validator.isNotNull(supervisorId)){
    	  		user = UserLocalServiceUtil.getUserById(supervisorId); 
    	  		supervisorName= user.getFullName();
    	  		supervisorEmail = user.getEmailAddress();
    	  		
    	  	}
      		}
    	 %>
        
      <td>
      <select name="projectManagerId" id="projectManagerId" style="_font-size:11px !important;">
      <option value="select" ><liferay-ui:message key="req.select"/></option>
     								<% if(Validator.isNotNull(userGroups)){
											    for (int i = 0; i < userGroups.size(); i++) {
												User userGroupUser = userGroups.get(i);
												long projectManagerId= userGroupUser.getUserId();
												if(projectManagerId==projectOwnerId){
												
								      %>														
									 
                                     		<option selected="selected"  value="<%=userGroupUser.getUserId()%>"><%=userGroupUser.getFullName()%></option>
                                     		
                                    	<% 	} else { %>
                                    	    <option value="<%=userGroupUser.getUserId()%>"><%=userGroupUser.getFullName()%></option>
                                    	
										<%	}	} // end of for
											 } //end of if
										%>
			</select>
      
    
      </td>
    </tr>
  </table>
    </td>
   </tr>
  
 
 
  <tr id="supervisorShow">


      <td class="label width100" > <liferay-ui:message key="req.supervisor"/><span class="red_star">*</span></td>
   <td colspan="3"><input title="Enter the Supervisor Name" name="supervisorName" id="supervisorName" style="width:238px" value="<%= supervisorName %>"class="text-field"  type="text"  maxlength="65" onKeyPress="resetSupervisor()";/>
    <input type="hidden" name="supervisorId" id="supervisorId" value="<%=supervisorId%>"></input>
      <input type="hidden"  name="supervisorEmail" id="supervisorEmail" value="<%=supervisorEmail %>"></input>
   </td>
     

   </tr>
 

  
    
<tr><td>&nbsp;</td>
  <td style="padding-left: 6px;" colspan="3" class="nopad">Please choose the supervisor from the  suggested pick list.</td>
</tr>
                                           </table>
									 </div>
									  <h3 class="section-title"><liferay-ui:message key="req.item.details"/></h3>
										 <div  >
                               				  
								  <table style="border-bottom: 0pt none;" class="search-result-table btmmargin" border="0" cellpadding="0" cellspacing="0">
                                                <tbody>
                                                    <tr class="alt">
                                      <th class="colm-1" style="width:156px"><liferay-ui:message key="req.item"/><span class="red_star">*</span></th>
                                      <th class="colm-2" style="width:354px" ><div ><liferay-ui:message key="req.item.desc"/></div></th>                
                                       <th class="colm-2" style="width:34px"><liferay-ui:message key="req.item.quantity"/><span class="red_star">*</span></th>
                                       <th class="colm-2" style="width:88px; border-right:1px solid #CCCCCC"><liferay-ui:message key="req.item.cost"/></th>
                                       
                                                    </tr>
													
                                                    <tr>
                                   <td class="colm-1"><input value="" name="itemName" id ="itemName" class="text-field" style="width:150px"  type="text" maxlength="75"/></td>
                                  <td class="colm-1"><input value="" name ="itemDescription" id="itemDescription" class="text-field " style="width:349px"  maxlength="200" type="text" /></td>
                                  <td class="colm-2"><input value="" name ="quantity" id="quantity" class="text-field" style="width: 29px;" type="text" maxlength="10" /></td>
                                  <td class="colm-2" style="border-right:1px solid #CCCCCC"><input value="" name="cost" id="cost" class="text-field"  maxlength="10" style="width: 82px;" type="text" /></td>
                                
                                                    </tr>
											<tr>
								
								<td colspan="4" class="nopad" style="border-right: 1px solid #CCCCCC;">
									<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
											<tr class="alt">
                                 <th class="colm-1" style="border-left:0px; width:171px"><liferay-ui:message key="req.gl.acc"/></th>
                                 <th class="colm-2"  style="width:171px"><liferay-ui:message key="req.wbs"/></th>
                                 <th class="colm-2"  style="width:155px"><liferay-ui:message key="req.cost.center"/></th>
								 <th class="colm-2" style="width:138px"><liferay-ui:message key="req.item.original.cost"/></th>
                                            </tr>
													
                                             <tr>
				      
				       <td class="colm-1 nobtmbrd" style=" border-left:0px;">
				    
				 
				        <input value="" name="glAccNo" id="glAccNo" class="text-field " style="width:165px; display: inline;" type="text" onKeyPress="resetGlAccountNo()" ; maxlength="60"/>
				    	  <input value="" name="glAccountNoId" id="glAccountNoId" class="text-field " style="width:165px; display: inline;" type="hidden" />
				       </td>

      <td class="colm-2 nobtmbrd">
      <input value="" name="wbsElement" id="wbsElement" class="text-field" style=" width:165px; display: inline;"  type="text" onKeyPress="resetWbsElement()"; maxlength="60"/>
        <input value="" name="wbsElementId" id="wbsElementId" class="text-field " style="width:165px; display: inline;" type="hidden"  />
      </td>
       
      <td class="colm-2 nobtmbrd">
     
      <input value="" name="costCenter" id="costCenter" class="text-field" style="width:133px;" type="text" onKeyPress="resetCostCenter()"; maxlength="60"/>
        <input value="" name="costCenterId" id="costCenterId" class="text-field " style="width:165px; display: inline;" type="hidden"  />
      </td>
	    <td class="colm-2"><input value="" name="originalCost" id="originalCost" class="text-field"  maxlength="10" style="width: 82px;" type="text" /></td>
                                                    </tr>
                                                    <tr style="border-bottom:1px solid #ccc">
                                                    	<td colspan="3">Please choose the values of WBS element / Cost Center / GL Accounts from the suggested pick list.
                                                    	</td>
                                                    </tr>
															</table>
															
														</td>
														
													</tr>
													
<tr class="alt">
                                                        <td  class="colm-1" colspan="5">
  <input title="Click to add an item to the request" name="addRow" id="addRow" value='<liferay-ui:message key="req.item.add"/> ' class="button input-button btmmargin rhtmargin" type="button" onclick="insertRow()" />
			  <input title=""  value='<liferay-ui:message key="req.clear"/>' name="clear" id="clear" class="button input-button btmmargin rhtmargin" type="button" onclick="clearModify()" />
			   <%if (Validator.isNull(items)) {%>	
											<div style="padding:10px  0px 0 0; display:none" id="itemTableDiv">
											<% }else { %>
											<div style="padding:10px  0px 0 0; display:block" id="itemTableDiv">
											<%} %>
     <table id="itemTable" style="border-bottom: 0pt none;" class="search-result-table btmmargin" border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<th class="colm-1" style="width:160px"><liferay-ui:message key="req.item"/></th>
			<th class="colm-2" style="width:250px"><liferay-ui:message key="req.item.desc"/></th>
			<th class="colm-2" style="width:30px"><liferay-ui:message key="req.item.quantity"/></th>
			<th class="colm-2" style="width:65px"><liferay-ui:message key="req.item.cost"/></th>
			<th class="colm-2" style="width:65px"><liferay-ui:message key="req.item.original.cost"/></th>
			<th class="colm-2" style="width:85px"><liferay-ui:message key="req.gl.acc"/></th>
			<th class="colm-2" style="width:80px"><liferay-ui:message key="req.wbs"/></th>
			<th class="colm-2" style="width:80px"><liferay-ui:message key="req.cost.center"/></th>
		   <th class="colm-2" style="width:30px"><liferay-ui:message key="req.item.edit"/></th>
            <th class="colm-2" style="width:44px">
                <liferay-ui:message key="req.item.delete"/>
            </th>
			
		</tr>
		 <%if (Validator.isNotNull(items)) {	
		     											int j=0;
                                                   	
                                                    	for (int i=0; i< items.size(); i++)
                									{
				
                        									item = items.get(i) ;
                        									itemId=item.getItemId();
                        									j=i+1;
                       										
                       								%>
                       										<tr id="<%=itemId %>">
                       										<td class=" "> <%=item.getItemName()%></td>
                       										<td class="colm-2"> <%=item.getItemDescription()%></td>
                       										<td class="colm-2 "> <%=item.getQuantity()%></td>
                       										<td class="colm-2 "> <%=item.getCost()%></td>
                       										<td class="colm-2 "> <%=item.getOriginalCost()%></td>
                       										<td class="colm-2 "><%=item.getGlAccNo()%></td>
                       										<td class="colm-2 "><%=item.getWbselement()%></td>
                       										<td class="colm-2 "><%=item.getCostCenter()%></td>
                       										<%if(showEditButton){ %>
																<td id="7"><a href="#" id="editItem" onclick="editItem(<%=j%>,<%=itemId%>);return false;"><liferay-ui:message key="req.item.edit"/></a></td>
                											<td id="8"><a href="#" id="deletItem" onclick ="deleteItem(<%=j%>,<%=itemId%>);return false;"><liferay-ui:message key="req.item.delete"/></a></td>
                											<input type="hidden" name="<%=sPrimary+j %>" id="<%=sPrimary+j %>" value="<%=j%>"/>
                											<%} else { %>
                											<td id="7"><a  href="#" onclick="return false"><liferay-ui:message key="req.item.edit"/></a></td>
                											<td id="8"><a href="#" onclick="return false"><liferay-ui:message key="req.item.delete"/></a></td>
                											<%} %>                											
                       										</tr>
                        							<% 
               										 	}
                                                    } else 
                  									  %>       
		
	</tbody>
</table>
</div></div>

                                                        </td>
                                                    </tr>
                                                     <tr>
                                                        <td class="label">
                                                            <liferay-ui:message key="req.item.total.cost"/>
                                                        </td>
                                                     <%   if(Validator.isNotNull(eprocuRequest)){
                                                         total = (double)eprocuRequest.getTotalCost();
                                                         orgtotal = (double)eprocuRequest.getOriginalCost();
                                                        } %>
                                                        <td class="form-item" colspan="5">
                                                            <input class="text-field"name="totalCost" id="totalCost" value="<%= numberFormat.format(total)%>" style="margin-right: 10px;"  readOnly="true" type="text" maxlength="20"/>
                                                        </td>
                                                        <input type="hidden" name="totalOriginalCost" id="totalOriginalCost" value="<%= numberFormat.format(orgtotal)%>" />
                                                    	</tr>
                                                </tbody>
                                            </table>
                                     
											</div>
											<%if(showProjectSpend){ %>
										 <h3 class="section-title"><liferay-ui:message key="req.project.spend"/></h3>
										 <div>
										    <table border="0" cellpadding="0" cellspacing="0">
                                                <tbody>
                                                <%
                                                	if(Validator.isNotNull(eprocuRequest) && Validator.isNotNull(eprocuRequest.getSpendDepartment())) { 
                                            	    	spendDept = eprocuRequest.getSpendDepartment();
                                            		}
                                            		if(Validator.isNotNull(eprocuRequest) && Validator.isNotNull(eprocuRequest.getSpendYear())) { 
                                            			spendYear = eprocuRequest.getSpendYear();
                                            		}
                                                %>
                                                    <tr>
                                                        <td class="label topalign width200">
                                                            <liferay-ui:message key="req.project.spend"/>
                                                        </td>
                                                        <td style="font: 12px Arial,Helvetica,sans-serif;">
                                                            <input type="radio" name="spendDepartment" id="it" value="it" <%=spendDept.equalsIgnoreCase("it")?"checked='checked'":"" %>/>&nbsp; Cost for IT only <br/>
                                                            <input type="radio" name="spendDepartment" id="bu" value="bu" <%=spendDept.equalsIgnoreCase("bu")?"checked='checked'":"" %>/>&nbsp; Cost for BU only <br/>
                                                            <input type="radio" name="spendDepartment" id="itandbu" value="both" <%=spendDept.equalsIgnoreCase("both")?"checked='checked'":"" %>/>&nbsp; Cost for IT and BU (provide breakout under Item Details) <br/>
                                                        </td>
                                                        <td>
                                                        </td>
                                                        <td>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                    
                                                        <td class="label topalign width200">
                                                            <liferay-ui:message key="req.project.spend.year"/>
                                                        </td>
                                                        <td style="font: 12px Arial,Helvetica,sans-serif;">
                                                        	<input type="radio" name="spendYear" id="new" value="new" <%=spendYear.equalsIgnoreCase("new")?"checked='checked'":"" %> />&nbsp; New for this year<br/>
                                                        	<input type="radio" name="spendYear" id="maintenance" value="maintenance" <%=spendYear.equalsIgnoreCase("maintenance")?"checked='checked'":"" %> />&nbsp; Maintenance (implemented in prior year)<br/>
	                                                    </td>
                                                        <td class="label">
                                                        </td>
                                                        <td class="form-item">
                                                        </td>
                                                    </tr>
                                                    
                                                </tbody>
                                            </table>
											</div>
											<% } %>
                                           <h3 class="section-title"><liferay-ui:message key="req.purchase.details"/></h3>
                                           
                                            <table id= "fileTags" border="0" cellpadding="0" cellspacing="0" width="100%">
                                                <tbody>
                                                   
                                                    <tr>
                                                        <td class="label">
                                                            <liferay-ui:message key="req.attachments"/></td>
 													   <td class="form-item" colspan="3">
   												       
														<input type="file" id="uploadFile" class="multi" name="uploadFile" accept="<%=allowedtypes %>" ;> 
													</td>
                                                       
                                                    </tr>
                                                    
                                                       <% if(Validator.isNotNull(fileData)){ %>
                                                       <tr>
                                                        <td class="label">
                                                           
                                                        </td>
                                                        <td class="form-item" colspan="3">
                                                                  				  
													  <table style="border-bottom: 0pt none;" class="search-result-table btmmargin" border="0" cellpadding="0" cellspacing="0">
	                                                <tbody>
                                                       <% for(int i=0;i<fileData.size();i++){
                                                            dlfFile=fileData.get(i);
                                                     %>
                                                        <tr id="<%=String.valueOf(dlfFile.getFileEntryId())%>">
                                                        <td class=" " width="85%">
                                                             <%  
                                                        
                                                       String rowHREF;
                                                        rowHREF =  "/documents/" + dlfFile.getGroupId() + "/" + dlfFile.getFolderId() + "/" + dlfFile.getTitle().replace('#','-')+"/"+dlfFile.getUuid();
                                                        
                                                        %> 
                                                      <%if(showEditButton){ %>
                                                    	<a href="<%=rowHREF %>"><%=dlfFile.getTitle()%></a>
                                                  	<%}else { %>
                                                  	 <a  href="#" onclick="return false"><%=dlfFile.getTitle()%></a>
                                                        <%} %>
                                                        </td>
                                                 
                                                        <td class="colm-2">
                                                             <%if(showEditButton){ %>
                                                             <liferay-ui:icon-menu>
																	<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="portletURL">
																		<portlet:param name="eProcAction" value="deleteAttachment" />
																		<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
																	
																		<portlet:param name="folderId" value="<%= String.valueOf(dlfFile.getFolderId())%>" />
																		<portlet:param name="name" value="<%= dlfFile.getName() %>" />
																		<portlet:param name="fileEnrtyId" value="<%=String.valueOf(dlfFile.getFileEntryId())%>" />
																	
																	</portlet:actionURL>
																	<%
																	String deleteJS = "javascript: deleteAttachments('" + portletURL + "','"+String.valueOf(dlfFile.getFileEntryId())+"');";
																	%>
																	<liferay-ui:icon-delete url="<%=deleteJS %>"/>
															</liferay-ui:icon-menu>		
															<%} %>
                                                        </td>
                                                    </tr>
                                                    <% } //end of for loop in upload file%>
                                                     
                                                     	</tbody>
                                            			</table>
                                                        </td>
                                                    </tr>
                                                    <%} //end of if of upload file %>  
											        <tr>
                                                        <td class="label topalign">
                                                            <liferay-ui:message key="req.reason"/><span class="red_star">*</span>
                                                        </td>
                                                        <td class="form-item" colspan="3">
                                                            <textarea onkeypress="return textMaxLength(this,'1000')"; onkeyup="return textMaxLength(this,'1000')"; name="reason" id="reason"  class="text-field"  title="Enter the reason for the request" style="padding: 3px; margin-right: 10px; width: 98.5%;"><%= (Validator.isNotNull(eprocuRequest) ? eprocuRequest.getReason() : "")%></textarea>
                                                        </td>
                                                      
                                                    </tr>
                                                    <tr>
                                                        <td class="label topalign">
                                                            <liferay-ui:message key="req.notes"/>
                                                        </td>
                                                        <td class="form-item" colspan="3">
                                                            <textarea onkeypress="return textMaxLength(this,'1000')"; onkeyup="return textMaxLength(this,'1000')"; name="notes" class="text-field" title="Enter appropriate comments" style="padding: 3px; margin-right: 10px; width: 98.5%;"><%= (Validator.isNotNull(eprocuRequest) ? eprocuRequest.getNotes() : "")%></textarea>
                                                        </td>
                                                    </tr>
                                                  <tr>
                                                        <td class="label">
                                                            <liferay-ui:message key="followup.vendor"/></td>
                                                        <td class="form-item nopad" colspan="3">
                                                          <table border="0" cellpadding="0" cellspacing="0">
                                                                <tbody>
                                                                    <tr>
                                                                       <td class="form-item"  style="width:100px;">
                                                                         <input maxlength="30" class="text-field"  name="vendorName"  id="vendorName" value="<%= (Validator.isNotNull(vendorName) ? vendorName : "")%>" style=" width: 135px" type="text" onKeyPress="resetVendorCode()";/>
                                                                       <input maxlength="30" class="text-field"  name="vendorCode"  id="vendorCode" value="<%= (Validator.isNotNull(eprocuRequest) ? eprocuRequest.getVendorCode() : "")%>" style=" width: 135px" type="hidden" />
                                                                        </td>
                                                                        <td class="label" style="width:79px; padding-right:0px"><liferay-ui:message key="req.vendor.email"/></td>
                                                                        <td class="form-item"  style="width:100px;">
                                                                         <input maxlength="30" class="text-field"  name="vendorEmail"  id="vendorEmail" value="<%= (Validator.isNotNull(eprocuRequest) ? eprocuRequest.getVendorEmail() : "")%>" style=" width: 135px" type="text" />
                                                                        </td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                           </td>
                                                    </tr>
                                                    <tr><td>&nbsp;</td>
                                                    	<td style="padding-top: 0px;" >Please choose vendor from the suggested pick list.
                                                    	</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="label">
                                                            <liferay-ui:message key="req.contract.id"/></td>
                                                        <td class="form-item nopad" colspan="3"><table border="0" cellpadding="0" cellspacing="0">
                                                          <tbody>
                                                                <tr>
                                                                  <td class="label form-item"><input class="text-field" name="contractId" value="<%= (Validator.isNotNull(eprocuRequest) ? eprocuRequest.getContractId() : "")%>" style="width:187px" type="text"  maxlength="50"/></td>
                                                                  <td class="label" style="width:25px; padding-right:0px;"><liferay-ui:message key="req.po"/></td>
                                                                  <td class="form-item"><input maxlength="30" name="purchaseOrder" value="<%= (Validator.isNotNull(eprocuRequest) ? eprocuRequest.getPurchaseOrder() : "")%>" class="text-field" style=" width:80px" type="text" /></td>
                                                                </tr>
                                                          </tbody>
                                                        </table></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="label">
                                                        </td>
                                                        <td class="form-item" colspan="3">
                                                            <%if(Validator.isNotNull(eprocuRequest)) {
                                                                if(showEditButton) {
                                                            %>
                                                            <input type="button" name="Ok" value='<liferay-ui:message key="req.submit.change"/>' class="button input-button" style="width: 170px;" title="Click to save request changes" onclick="ValidateForm('<%=editRequestURL %>')";>
                                                                <input type="button" value='<liferay-ui:message key="req.email.requester"/>' class="button input-button" title="Click to compose an email to the requester" onclick="ValidateForm('<%=emailRequesterURL%>');"/>
                                                            <%} %>
                                                          
                                                            <%
                                                                } else { %>
                                                               <input title="Click to submit completed request" value='<liferay-ui:message key="req.submit"/>' name="Ok" class="button input-button rhtmargin" type="button" onclick="ValidateForm('<%=createRequestURL %>')"; />
                                             				   <input title="Click to clear request information" value='<liferay-ui:message key="req.clear"/>' class="button input-button" type="reset" onclick="formReset()"; />
                                             				 <%  }%>
                                                            
															<%@include file="approveDecline.jsp" %>
															
															<% if(IsWebAdmin && Validator.isNotNull(eprocuRequest) && !EProcurementConstants.STATUS_COMPLETED.equals(status) && !EProcurementConstants.STATUS_CANCELLED.equals(status) && !EProcurementConstants.STATUS_INPROCESS.equals(status)){ %>
															
															 <input type="button" class="button input-button" value="Send Reminder" onclick="sendReminder()" />
															
															<%} %>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        <br/>
                                        <%@include file="../requestworkflow/workflowLinks.jsp" %>
                                        </td></tr>
                                        
                                    <tr>
                                        <td class="bl">
                                        </td>
                                        <td>
                                        </td>
                                        <td class="br">
                                        </td>
                                    </tr>
                                   
                                </tbody>
                            </table>
                            <br/>
                        </div>
                    </div>
          
                <!--Content Right Column --><!--End OF Content Right Column -->

        </form>
        
                
       <portlet:actionURL var="editItemURL">
		<portlet:param name="eProcAction" value="editItem"/>
		<portlet:param name="itemId" value="<%=String.valueOf(itemId)%>" />
		</portlet:actionURL>
	 <portlet:actionURL var="deleteItemURL">
		<portlet:param name="eProcAction" value="deleteItem"/>
		<portlet:param name="itemId" value="<%= String.valueOf(itemId) %>" />	 
	</portlet:actionURL>    

  <script type="text/javascript">
	
  function insertRow()
	{
		var check =/^(\d*)([\.]\d{1,2})?$/;
	
			
		if(jQuery("#itemName").val()==""){
			alert("Item Name is mandatory");
			document.getElementById('itemName').focus();
			return false;
		}
		if(jQuery("#quantity").val()==""){
			alert("Item quantity is mandatory");
			document.getElementById('quantity').focus();
			return false;
		}
		if (!isNumeric(document.getElementById("quantity").value))	
		{
			alert("The item quantity has to be numeric");
			document.getElementById('quantity').focus();
			return false;
		}
		if(isNumeric(document.getElementById("quantity").value)) {
			 if(!jQuery('#quantity').val().match('^(0|[1-9][0-9]*)$'))
		        {
				 	alert("Quantity has to be Integer");
				 	document.getElementById('quantity').focus();
				 	return false;
		        }
		}
		if(jQuery('#quantity').val()==0){
			alert("Quantity value should not be Zero");
			document.getElementById('quantity').focus();
		 	return false;
		}
		if(jQuery("#cost").val()!=""){
		if (!isNumeric(document.getElementById("cost").value))	
		{
			alert("The item cost has to be numeric");
			document.getElementById('cost').focus();
			return false;
		}
		if(isNumeric(document.getElementById("cost").value)){
			if(!jQuery("#cost").val().match(check)) {
		 		alert('Please enter only two digits after decimal');
		 		document.getElementById('cost').focus();
		 		return false;
			} 
			
		}
		}
		if(jQuery("#originalCost").val()!=""){
		if (!isNumeric(document.getElementById("originalCost").value))	
		{
			alert("The item original cost has to be numeric");
			document.getElementById('originalCost').focus();
			return false;
		}
		if(isNumeric(document.getElementById("originalCost").value)){
			if(!jQuery("#originalCost").val().match(check)) {
		 		alert('Please enter only two digits after decimal');
		 		document.getElementById('originalCost').focus();
		 		return false;
			} 
			
		}
		}
		if(jQuery("#glAccNo").val()!=""){
			if(jQuery("#glAccountNoId").val()==""){
				alert("Please select GL Account Number through auto pick list");
				document.getElementById("glAccNo").focus();
				return false;
			}
		}
		
		if(jQuery("#relatedProject").val()=="Yes"){
		
			if ((document.getElementById('wbsElement').value=="")&&(document.getElementById('costCenter').value=="")){
				
				alert("Please enter either wbselement or cost center");
				document.getElementById('wbsElement').focus();
				return false;
			}
		}
		if(jQuery("#wbsElement").val()!=""){
			if(jQuery("#wbsElementId").val()==""){
				alert("Please select WBS Element through auto pick list");
				document.getElementById("wbsElement").focus();
				return false;
			}
		}
		if(jQuery("#costCenter").val()!=""){
			if(jQuery("#costCenterId").val()==""){
				alert("Please select Cost Center through auto pick list");
				document.getElementById("costCenter").focus();
				return false;
			}
		}
		
		
		if(document.getElementById("cost").value.length<=0){
			document.getElementById("cost").value=0;
		}
		if(document.getElementById("originalCost").value.length<=0){
			document.getElementById("originalCost").value=0;
		}
			if(jQuery("#addRow").val() == "Update")
			{
				//Modify Logic
				onModify();
			}
			else
			{
				//Add New Row Logic
				addNewRow();
				document.getElementById('itemTableDiv').style.display='block';
			}		
			clearControls();
		
	}
	function onModify()
	{	
		var rowBeingEdited = jQuery("#rowBeingModified").val();
		document.getElementById('itemTable').rows[rowBeingEdited].cells[0].innerHTML = document.getElementById('itemName').value;
		document.getElementById('itemTable').rows[rowBeingEdited].cells[1].innerHTML = document.getElementById('itemDescription').value ;
		document.getElementById('itemTable').rows[rowBeingEdited].cells[2].innerHTML = document.getElementById('quantity').value;
		document.getElementById('itemTable').rows[rowBeingEdited].cells[3].innerHTML = document.getElementById('cost').value;
		document.getElementById('itemTable').rows[rowBeingEdited].cells[4].innerHTML = document.getElementById('originalCost').value;
		document.getElementById('itemTable').rows[rowBeingEdited].cells[5].innerHTML = document.getElementById('glAccNo').value;
		document.getElementById('itemTable').rows[rowBeingEdited].cells[6].innerHTML = document.getElementById('wbsElement').value;
		document.getElementById('itemTable').rows[rowBeingEdited].cells[7].innerHTML = document.getElementById('costCenter').value;
		
		var totalCostValue = parseFloat(document.getElementById('totalCost').value);
		var qty= parseInt(document.getElementById('qtyedit').value);
		var itemCost= parseFloat(document.getElementById('costedit').value);
		totalCostValue = parseFloat(totalCostValue)-(qty*itemCost);
		totalCostValue = parseFloat(totalCostValue)+(parseInt(document.getElementById('quantity').value)*parseFloat(document.getElementById('cost').value));
		document.getElementById('totalCost').value=totalCostValue;
		
		
		
		var totalOrgValue = parseFloat(document.getElementById('totalOriginalCost').value);
		var qty= parseInt(document.getElementById('qtyedit').value);
		var itemCost= parseFloat(document.getElementById('orgcostedit').value);
		totalOrgValue = parseFloat(totalOrgValue)-(qty*itemCost);
		totalOrgValue = parseFloat(totalOrgValue)+(parseInt(document.getElementById('quantity').value)*parseFloat(document.getElementById('originalCost').value));
		document.getElementById('totalOriginalCost').value=totalOrgValue;
		
		
		//

		var itemId = document.getElementById('itemId').value;
		if(itemId != ""){
	 		var columnDelimeter  = "^^^";
			var rowDelimeter = "~~~";
		 	var edittedItems = document.getElementById('edittedItems').value;
			if(edittedItems != ""){
				document.getElementById('edittedItems').value = edittedItems+','+itemId;
			}else{
				document.getElementById('edittedItems').value = itemId;
			}

			var itemValues = document.getElementById('editItemValues').value;
			for(var col=0; col < 8; col++)
			{
					
				itemValues = itemValues + document.getElementById('itemTable').rows[rowBeingEdited].cells[col].innerHTML;
				itemValues = itemValues + columnDelimeter;
			
			}
			itemValues = itemValues + itemId + rowDelimeter;
			document.getElementById('editItemValues').value = itemValues;
	 	}
		
		clearControls();
		jQuery("#addRow").val("Add");
	}
	function clearModify()
	{
		
		clearControls();
		jQuery("#addRow").val("Add");
		jQuery("#rowBeingModified").val("");
		
	}
	function editSelectedRow(index)
	{
		
		var rowToBeEdited = 0;
	
		if(jQuery("#addRow").val() == "Update")
		{
			alert("Please 'Update/Clear' existing row before editing any row.");
			return false;
		}
		else
		{
			for(var row=1; row <= parseInt(document.getElementById('totalRowsCount').value);row++)
			{	
				if(document.getElementById('primaryKey'+row))
				{
					rowToBeEdited = rowToBeEdited + 1;
				}
				if(document.getElementById('primaryKey'+row) && document.getElementById('primaryKey'+row).value == index)
				{
					
					document.getElementById('itemName').value = document.getElementById('itemTable').rows[rowToBeEdited].cells[0].innerHTML;
					document.getElementById('itemDescription').value = document.getElementById('itemTable').rows[rowToBeEdited].cells[1].innerHTML;
					var qty =trimStr(document.getElementById('itemTable').rows[rowToBeEdited].cells[2].innerHTML);
					var cost = trimStr(document.getElementById('itemTable').rows[rowToBeEdited].cells[3].innerHTML);
					var originalcost = trimStr(document.getElementById('itemTable').rows[rowToBeEdited].cells[4].innerHTML);
					var wbs = trimStr(document.getElementById('itemTable').rows[rowToBeEdited].cells[6].innerHTML);
					document.getElementById('quantity').value = qty;
					document.getElementById('qtyedit').value=document.getElementById('quantity').value
					document.getElementById('cost').value = cost;
					document.getElementById('originalCost').value = originalcost;
					document.getElementById('costedit').value = document.getElementById('cost').value;
					document.getElementById('orgcostedit').value = document.getElementById('originalCost').value;
					document.getElementById('glAccNo').value=document.getElementById('itemTable').rows[rowToBeEdited].cells[5].innerHTML;
					document.getElementById('glAccountNoId').value=document.getElementById('glAccNo').value;
					document.getElementById('wbsElement').value=wbs;
					document.getElementById('wbsElementId').value=document.getElementById('wbsElement').value;
					document.getElementById('costCenter').value=trimStr(document.getElementById('itemTable').rows[rowToBeEdited].cells[7].innerHTML);
					document.getElementById('costCenterId').value=document.getElementById('costCenter').value
					jQuery("#rowBeingModified").val(rowToBeEdited);	
					
				}
			}
	
			jQuery("#addRow").val("Update");
			
		}
	}
	function deleteSelectedRow(index)
	{
		
		var rowToBeDeleted = 0;
		if(jQuery("#addRow").val() == "Update")
		{
			alert("Please 'Update/Clear' existing row before deleting any row.");
			return false;
		}
		else
		{
			for(var row=1; row <= parseInt(document.getElementById('totalRowsCount').value);row++)
			{	
				if(document.getElementById('primaryKey'+row))
				{
					rowToBeDeleted = rowToBeDeleted + 1;
				}
				if(document.getElementById('primaryKey'+row) && document.getElementById('primaryKey'+row).value == index)
				{
					break;
				}
			}
			if(rowToBeDeleted > 0)
			{		
				var totalValue = parseFloat(document.getElementById('totalCost').value);
				var itemCost = document.getElementById('itemTable').rows[rowToBeDeleted].cells[3].innerHTML;
				var qty = document.getElementById('itemTable').rows[rowToBeDeleted].cells[2].innerHTML;
				totalValue = parseFloat(totalValue)-(parseInt(qty)*parseFloat(itemCost));
			   	var result=Math.round(totalValue*100)/100;
			   	document.getElementById('totalCost').value=result;
			   	
				var totalValue = parseFloat(document.getElementById('totalOriginalCost').value);
				var itemCost = document.getElementById('itemTable').rows[rowToBeDeleted].cells[4].innerHTML;
				var qty = document.getElementById('itemTable').rows[rowToBeDeleted].cells[2].innerHTML;
				totalValue = parseFloat(totalValue)-(parseInt(qty)*parseFloat(itemCost));
			   	var result=Math.round(totalValue*100)/100;
				document.getElementById('totalOriginalCost').value=result;
				
				document.getElementById('itemTable').deleteRow(rowToBeDeleted);
			}
			document.getElementById('noOfRows').value = document.getElementById('noOfRows').value - 1;
			
			if(document.getElementById('noOfRows').value <= 1)
			{
				if(document.getElementById('itemNo').value<=0){
				document.getElementById('itemTableDiv').style.display='none';
				}
			}
		}
	
	}
	function clearControls()
	{
		document.getElementById('itemName').value = "";
		document.getElementById('itemDescription').value = "";
		document.getElementById('quantity').value="";
		document.getElementById('cost').value="";
		document.getElementById('originalCost').value="";
		document.getElementById('glAccNo').value="";
		document.getElementById('wbsElement').value="";
		document.getElementById('costCenter').value="";
		document.getElementById('glAccountNoId').value="";
		document.getElementById('costCenterId').value="";
		document.getElementById('wbsElementId').value="";
		//wbs check

        if(jQuery("#costCenter").val().trim() != '') {
            jQuery("#wbsElement").not(this).attr('disabled','disabled');
		
			jQuery("#wbsElement").val("");
        } else {
            jQuery("#wbsElement").removeAttr('disabled');
          
        }
  
  //cost cent
   
        if(jQuery("#wbsElement").val().trim() != '') {
            jQuery("#costCenter").not(this).attr('disabled','disabled');
		
			jQuery("#costCenter").val("");
        } else {
            jQuery("#costCenter").removeAttr('disabled');
          
        }
	 
	}
	
	function editItem(index,itemId){
		var itemId=itemId;
		document.getElementById('itemId').value=itemId;
	 	editSelectedRow(index);
	}
	function deleteItem(index,itemId){
		var deleteItem = "deleteItem";
		var itemId=itemId;
		document.getElementById('itemId').value=itemId;
		deleteSelectedRow(index);
		document.getElementById('rowCount').value = document.getElementById('rowCount').value - 1;
		var deletedItems = document.getElementById('deletedItems').value;
		if(deletedItems != ""){
			document.getElementById('deletedItems').value = deletedItems+','+itemId;
		}else{
			document.getElementById('deletedItems').value = itemId;
		}
	}

	function deleteAttachments(deleteURL,rowId){
			jQuery.ajax({
	   			  type: "POST",  
	   			  url: deleteURL,
	   			  form: {
	   	         id: 'requestForm'
	   	     	}
	   		});	
		var row = document.getElementById(rowId);
		row.parentNode.removeChild(row); 
	}
	function addNewRow()
	{
		document.getElementById('itemTableDiv').style.display='block'; 
		var insertIndex = document.getElementById('noOfRows').value;
		var x=document.getElementById('itemTable').insertRow(insertIndex);
		
		var y=x.insertCell(0);
		y.innerHTML=document.getElementById('itemName').value;
		var y=x.insertCell(1);
		y.innerHTML=document.getElementById('itemDescription').value;
		var y=x.insertCell(2);
		var itemQty = document.getElementById('quantity').value;
		y.innerHTML=itemQty;	
		var y=x.insertCell(3);	
		var itemCost = document.getElementById('cost').value;
		y.innerHTML=itemCost;
		var y=x.insertCell(4);	
		var itemOriginalCost = document.getElementById('originalCost').value;
		y.innerHTML=itemOriginalCost;
		var y=x.insertCell(5);
		y.innerHTML=document.getElementById('glAccNo').value;
		
		var y=x.insertCell(6);
		y.innerHTML=document.getElementById('wbsElement').value;
		var y=x.insertCell(7);
		y.innerHTML=document.getElementById('costCenter').value;
	
		totalCostCal();
		totalOrginalCostCal();
		var y=x.insertCell(8);
		y.innerHTML="<a href=\"#\" name=\"edit\" id=\"edit\" onclick=\"editSelectedRow(" + document.getElementById('totalRowsCount').value + ") ;\ return false;\">Edit</a>";
		var y=x.insertCell(9);
		y.innerHTML="<a href=\"#\" name=\"delete\" id=\"delete\" onclick=\"deleteSelectedRow(" + document.getElementById('totalRowsCount').value + ");\ return false;\">Delete</a>";
		var inp = document.createElement('input');
		inp.setAttribute('type', 'hidden');
		inp.setAttribute('name', 'primaryKey' + document.getElementById('totalRowsCount').value);
		inp.setAttribute('id', 'primaryKey' + document.getElementById('totalRowsCount').value);
		inp.setAttribute('value',document.getElementById('totalRowsCount').value);
		y.appendChild(inp);

		var inp = document.createElement('input');
		inp.setAttribute('type', 'hidden');
	
		y.appendChild(inp);

		document.getElementById('noOfRows').value = parseInt(document.getElementById('noOfRows').value) + 1;		
		document.getElementById('totalRowsCount').value = parseInt(document.getElementById('totalRowsCount').value) + 1;
		document.getElementById('newRows').value = parseInt(document.getElementById('newRows').value) + 1;

		
}
	function totalCostCal(){
	
		var totalCostValue=0;
		var qty=0;
		var itemCost=0;
		var tCost = document.getElementById('totalCost').value;
	
		qty= parseInt(document.getElementById('quantity').value);
		itemCost= parseFloat(document.getElementById('cost').value);
		
		tCost = parseFloat(tCost) + (qty*itemCost);
	   	var result=Math.round(tCost*100)/100  
	   	document.getElementById('totalCost').value = result;
	
	}
	
	function totalOrginalCostCal(){
		
		var totalCostValue=0;
		var qty=0;
		var itemCost=0;
		var tCost = document.getElementById('totalOriginalCost').value;
		qty= parseInt(document.getElementById('quantity').value);
		itemCost= parseFloat(document.getElementById('originalCost').value);
		tCost = parseFloat(tCost) + (qty*itemCost);
	   	var result=Math.round(tCost*100)/100
	   	document.getElementById('totalOriginalCost').value = result;
	
	}

	function sendReminder(){

		document.requestForm.action= '<%= sendReminderVar %>';
		document.requestForm.submit();
		
	}
	

   	</script>
 <script type="text/javascript">
       
    	
	   jQuery(document).ready(function(){
		   var editCheck=true;
		
		   editCheck = <%=showEditButton%>;
		   
		   if(!editCheck){
			   jQuery("#requestForm :input").attr('disabled', 'disabled');
				
		   } else {
			   jQuery("#requestForm :input").removeAttr('disabled');
			}
		   
		 //wbs check
		    jQuery("#costCenter").keyup(function(e) {
		        if(jQuery(this).val().trim() != '') {
		            jQuery("#wbsElement").not(this).attr('disabled','disabled');
				
					jQuery("#wbsElement").val("");
		        } else {
		            jQuery("#wbsElement").removeAttr('disabled');
		          
		        }
		    });
		  //cost cent
		    jQuery("#wbsElement").keyup(function(e) {
		        if(jQuery(this).val().trim() != '') {
		            jQuery("#costCenter").not(this).attr('disabled','disabled');
				
					jQuery("#costCenter").val("");
		        } else {
		            jQuery("#costCenter").removeAttr('disabled');
		          
		        }
		    });
			
		   if(jQuery("#relatedProject").val() == "Yes"){
				jQuery(".pojectowner, .pojectname").show();
				jQuery(".costcenter").hide();
				jQuery(".costother2").hide();
				jQuery("#supervisorShow").hide();
		   } else {
				jQuery(".pojectowner, .pojectname").hide();
				jQuery(".costcenter").show();
				jQuery("#supervisorShow").show();
		   }
			if(document.getElementById("shipTo").value=="Other") {
				jQuery("#addressTable").show();
       			
			} else {
				jQuery("#addressTable").hide();
			}
			jQuery("#shipTo").change(function() 
              		{ 
                       		if(document.getElementById("shipTo").value=="Other") {
                       		jQuery("#addressTable").show();
                   		 } else {
              					jQuery("#addressTable").hide();
              				 }
              				 }
                       	); 
  		  // end of fucntion for validation if ship to address is selected as other
  		  	    
    		 	jQuery("#relatedProject").change(function(){
    					if(jQuery(this).val() == "Yes"){
    						jQuery(".pojectowner, .pojectname").show();
    						
    						jQuery("#supervisorShow").hide();
    					
    						}
    					else if(jQuery(this).val() == "No"){

    						jQuery("#supervisorShow").show();
    						jQuery(".pojectowner, .pojectname").hide();
    					
    						}
    						
    				   else {
    						jQuery(".pojectowner, .costcenter, .pojectname").hide();
    						jQuery(".costother2").hide();
    						jQuery("#supervisorShow").show();
    						}
    					
    					 });
    			
   			
    			
   			
  });
</script>


 <script type="text/javascript">
	jQuery(function(){ // wait for document to load
	jQuery('#uploadFile').MultiFile({
	STRING: {
	remove: '<img src="/o/e-procurement-portlet/images/close-icon.gif" height="16" width="16" alt="x"/>'
	}
	});
});
</script>
