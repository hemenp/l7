<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Devaki Subramaniam
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 *	Kruti Doshi		|	Sep 15 2014		|	Added Therapeutic Area check list
--%>
<%@ include file="/jsps/include/init_block.jsp" %>
<tr>
	<td class="form-content" style="padding: 0 10px;" colspan="3" id="ProdInfoBlk">
		<h3 class="acc-title">
			<c:choose>
				<c:when test="${appForm.formType != 'CharitableDonation'}">
					<liferay-ui:message key="prodInfoBlk.heading" />
				</c:when>
				<c:otherwise>
					<liferay-ui:message key="prodInfoBlk.contribution.heading" />	
				</c:otherwise>
			</c:choose>
		</h3>
		<div class="acc-content" style="display: block;">
			<table cellspacing="0" cellpadding="0" border="0" style="width:100%;" class="">
				<tbody>
					<tr>
						<td class="req_label vtop" colspan="3">
							<strong class="bold">
							<c:choose>
								<c:when test="${appForm.formType != 'CharitableDonation'}">
									<liferay-ui:message key="prodInfoBlk.label.note" />	
								</c:when>
								<c:otherwise>
									<liferay-ui:message key="prodInfoBlk.contribution.label.note" />	
								</c:otherwise>
							</c:choose>
							</strong>
							<span class="red_star">*</span>
							<br /><br />
						</td>												
					</tr>
					<c:if test="${appForm.formType != 'CharitableDonation'}">
					<tr>
						<td class="req_label vtop">
							<strong class="bold">
								<label for="productInfo.products">
									<liferay-ui:message key="prodInfoBlk.subtitle.product" />
								</label>
							</strong><br><br>
						</td>
						<td class="form-item nopad" colspan="3">
							<table width="100%" cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td width="320">
											<div class="checklist-cont">
												<ul class="checklist ">
												<c:choose>
												<c:when test="${appForm.formType== 'AdvBoard' || appForm.formType == 'EduItemsVal' || appForm.formType== 'HCPConsultant'}">
													<li class="alt">
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.azor" /><sup>&reg;</sup></span>
														<form:checkbox path="productInfo.products" value="Azor" cssClass="required-product" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li>
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.benicarReg" /><sup>&reg;</sup></span>
														<form:checkbox path="productInfo.products" value="Benicar / Benicar HCT" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li class="alt">
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.effient" /><sup>&reg;</sup></span>
														<form:checkbox path="productInfo.products" value="Effient" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li>
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.evoxac" /><sup>&reg;</sup></span>
														<form:checkbox path="productInfo.products" value="Evoxac" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li class="alt">
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.welchol" /><sup>&reg;</sup></span>
														<form:checkbox path="productInfo.products" value="Welchol" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li>
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.tribenzor" /><sup>&reg;</sup></span>
														<form:checkbox path="productInfo.products" value="Tribenzor" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li class="alt">
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.zelboraf" /><sup>&reg;</sup></span>
														<form:checkbox path="productInfo.products" value="Zelboraf" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
												</c:when>
												<c:otherwise>
													<li class="alt">
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.azor" /></span>
														<form:checkbox path="productInfo.products" value="Azor" cssClass="required-product" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li>
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.benicar" /></span>
														<form:checkbox path="productInfo.products" value="Benicar / Benicar HCT" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li class="alt">
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.effient" /></span>
														<form:checkbox path="productInfo.products" value="Effient" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li>
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.evoxac" /></span>
														<form:checkbox path="productInfo.products" value="Evoxac" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li class="alt">
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.welchol" /></span>
														<form:checkbox path="productInfo.products" value="Welchol" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li>
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.tribenzor" /></span>
														<form:checkbox path="productInfo.products" value="Tribenzor" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li class="alt">
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.zelboraf" /></span>
														<form:checkbox path="productInfo.products" value="Zelboraf" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													</c:otherwise>
													</c:choose>
												</ul>
											</div>
										</td>
										<td width="12">
											<form:checkbox path="productInfo.products" value="" onclick="otherProductMaterial(this.checked);" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
										</td>
										<td style="padding-top:5px" class="">
											<label for="productInfo.otherMaterial" style="vertical-align: top;">
												<liferay-ui:message key="dispExhibitInfoBlk.label.otherMaterials" />
											</label>
											<form:input path="productInfo.otherMaterial" cssClass="text-field width100 " maxlength = "75" onchange="otherProductValue();"/>
										</td>
									</tr>
									</tbody>
							</table>
						</td>
					</tr>
					</c:if>
					<tr>
						<td class="req_label vtop">
							<strong class="bold">
								<label for="productInfo.therapeuticArea">
									<liferay-ui:message key="prodInfoBlk.label.therapeuticArea" />
								</label>
							</strong><br><br>
						</td>
						<td class="form-item nopad" colspan="3">
							<table width="100%" cellspacing="0" cellpadding="0" border="0">
								<tbody>									
									<tr>
										<td width="320">
											<div class="checklist-cont">
												<ul class="checklist ">
												<c:choose>
													<c:when test="${appForm.formType == 'CharitableDonation'}">
														<li class="alt">
															<span><liferay-ui:message key="prodInfoBlk.contribution.therapetic.cardio" /></span>
															<form:checkbox path="productInfo.therapeuticArea" value="Cardiovascular and metabolic disorders" cssClass="required-therapeutic" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
														</li>
														<li>
															<span><liferay-ui:message key="prodInfoBlk.therapetic.oncology" /></span>
															<form:checkbox path="productInfo.therapeuticArea" value="Oncology" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
														</li>
														<li class="alt">
															<span><liferay-ui:message key="prodInfoBlk.contribution.therapetic.painmgt" /></span>
															<form:checkbox path="productInfo.therapeuticArea" value="Pain management and related conditions" cssClass="required-therapeutic" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
														</li>
														<li>
															<span><liferay-ui:message key="prodInfoBlk.contribution.therapetic.na" /></span>
															<form:checkbox path="productInfo.therapeuticArea" value="N/A" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
														</li>
													</c:when>
													<c:otherwise>
														<li class="alt">
															<span><liferay-ui:message key="prodInfoBlk.therapetic.cardio" /></span>
															<form:checkbox path="productInfo.therapeuticArea" value="Cardiovascular" cssClass="required-therapeutic" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
														</li>
														<li>
															<span><liferay-ui:message key="prodInfoBlk.therapetic.metabolic" /></span>
															<form:checkbox path="productInfo.therapeuticArea" value="Metabolic/Endocrine" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
														</li>
														<li class="alt">
															<span><liferay-ui:message key="prodInfoBlk.therapetic.oncology" /></span>
															<form:checkbox path="productInfo.therapeuticArea" value="Oncology" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
														</li>
														<li>
															<span><liferay-ui:message key="prodInfoBlk.therapetic.infectious" /></span>
															<form:checkbox path="productInfo.therapeuticArea" value="Infectious diseases" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
														</li>
														<li class="alt">
															<span><liferay-ui:message key="prodInfoBlk.therapetic.allergic" /></span>
															<form:checkbox path="productInfo.therapeuticArea" value="Immunological allergic diseases" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
														</li>
														<li>
															<span><liferay-ui:message key="prodInfoBlk.therapetic.pain" /></span>
															<form:checkbox path="productInfo.therapeuticArea" value="Pain Management" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
														</li>
													</c:otherwise>
												</c:choose>																																						
												</ul>
											</div>
										</td>
										
										<c:if test="${appForm.formType != 'CharitableDonation'}">
											<td width="12">
												<form:checkbox path="productInfo.therapeuticArea" value=""  onclick="otherTherapeuticAreaForProdInfo(this.checked);" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
											</td>
											<td style="padding-top:5px" class="">
												<label for="productInfo.otherTherapeutic" style="vertical-align: top;">
												<liferay-ui:message key="prodInfoBlk.therapetic.others" />
												</label>
												<form:input path="productInfo.otherTherapeutic" maxlength="75" cssClass="text-field width100 " onchange="otherTherapeuticForProdInfo();"/>
											</td>
										</c:if>
																				
									</tr>
								</tbody>
							</table>
						</td>
					</tr>					
					<c:if test="${OBJECTID == '' || OBJECTID == null}">
						<tr>
							<td style="text-align:right;padding:10px 0;" colspan="4">
								<input type="button" value='<liferay-ui:message key="clearbutton.label"/>' class="button input-button" onclick="javascript:clearProductBlock(this);" />
							</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>
	</td>
</tr>