create table eproc_item (
	itemId LONG not null primary key,
	itemName VARCHAR(75) null,
	itemDescription VARCHAR(75) null,
	quantity LONG,
	cost DOUBLE,
	originalCost DOUBLE,
	wbselement VARCHAR(75) null,
	glAccNo VARCHAR(75) null,
	costCenter VARCHAR(75) null,
	requestId LONG,
	itemInStock BOOLEAN,
	vendorCode VARCHAR(75) null,
	purchaseOrder VARCHAR(75) null,
	recievedDate DATE null,
	returnedDate DATE null,
	assetInfo VARCHAR(75) null,
	returnedAssets VARCHAR(75) null,
	createdBy LONG,
	createdDate DATE null,
	modifiedBy LONG,
	modifiedDate DATE null,
	companyId LONG,
	groupId LONG
);

create table eproc_location (
	locationId VARCHAR(75) not null primary key,
	companyId LONG,
	location VARCHAR(75) null,
	flowType VARCHAR(75) null,
	locationType VARCHAR(75) null,
	address VARCHAR(75) null,
	personnelArea VARCHAR(75) null,
	personnelSubArea VARCHAR(75) null,
	buildingNumber VARCHAR(75) null,
	appName VARCHAR(75) null
);

create table eproc_request (
	requestId LONG not null primary key,
	shipToOther VARCHAR(75) null,
	spendDepartment VARCHAR(75) null,
	spendYear VARCHAR(75) null,
	address VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	zip VARCHAR(75) null,
	isBudgetedRequest VARCHAR(75) null,
	isRelatedtoProject VARCHAR(75) null,
	projectName VARCHAR(75) null,
	projectOwnerId LONG,
	totalCost DOUBLE,
	originalCost DOUBLE,
	reason VARCHAR(75) null,
	notes VARCHAR(75) null,
	vendorCode VARCHAR(75) null,
	vendorEmail VARCHAR(75) null,
	contractId VARCHAR(75) null,
	purchaseOrder VARCHAR(75) null,
	itemInStock BOOLEAN,
	recievedDate DATE null,
	returnedDate DATE null,
	assetInfo VARCHAR(75) null,
	returnedAssets VARCHAR(75) null,
	createdBy LONG,
	createdDate DATE null,
	modifiedBy LONG,
	modifiedDate DATE null,
	companyId LONG,
	groupId LONG,
	requestorId LONG,
	supervisorId LONG,
	status VARCHAR(75) null,
	stage VARCHAR(75) null,
	nextStage VARCHAR(75) null,
	isApproverRole VARCHAR(75) null
);

create table eproc_request_attachment (
	requestAttachmentId LONG not null primary key,
	requestId LONG,
	fileEntryId LONG
);

create table eproc_workflow_definition (
	workflowDefinitionId LONG not null primary key,
	workflowName VARCHAR(75) null,
	stages VARCHAR(75) null,
	isActive BOOLEAN,
	createdBy LONG,
	createdDate DATE null,
	modifiedBy LONG,
	modifiedDate DATE null,
	companyId LONG,
	groupId LONG
);

create table eproc_workflow_request (
	workflowRequestId LONG not null primary key,
	workflowDefinitionId LONG,
	classNameId LONG,
	classPK LONG,
	isActive BOOLEAN,
	createdBy LONG,
	createdDate DATE null,
	modifiedBy LONG,
	modifiedDate DATE null,
	companyId LONG,
	groupId LONG
);

create table eproc_workflow_review (
	workflowReviewId LONG not null primary key,
	workflowRequestId LONG,
	classNameId LONG,
	classPK LONG,
	updatedBy LONG,
	updatedToStatus VARCHAR(75) null,
	nextStage VARCHAR(75) null,
	isApproverRole VARCHAR(75) null,
	updatedDate DATE null,
	approverComments VARCHAR(75) null,
	emailComments VARCHAR(75) null,
	companyId LONG,
	groupId LONG
);