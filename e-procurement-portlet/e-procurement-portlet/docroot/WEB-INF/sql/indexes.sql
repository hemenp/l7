create index IX_D9D1DB7D on eproc_item (requestId);

create index IX_CA8C0358 on eproc_request (companyId, groupId, status[$COLUMN_LENGTH:75$], city[$COLUMN_LENGTH:75$]);
create index IX_9DEE16C1 on eproc_request (modifiedDate, requestorId);
create index IX_5D27E56C on eproc_request (requestorId);

create index IX_78CAEC4 on eproc_request_attachment (fileEntryId);
create index IX_5DA628BD on eproc_request_attachment (requestId);

create index IX_E3750437 on eproc_workflow_definition (companyId, isActive);
create index IX_9FD42151 on eproc_workflow_definition (companyId, workflowName[$COLUMN_LENGTH:75$]);

create index IX_FD00B274 on eproc_workflow_request (companyId, groupId, classNameId, classPK, isActive);
create index IX_F52DED00 on eproc_workflow_request (companyId, groupId, workflowDefinitionId, isActive);

create index IX_99E44171 on eproc_workflow_review (companyId, groupId, classNameId, classPK);