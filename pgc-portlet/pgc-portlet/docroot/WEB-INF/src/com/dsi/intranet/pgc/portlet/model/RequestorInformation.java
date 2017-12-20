/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.model;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumPropertyMapping;

import java.io.Serializable;
import java.util.Date;

/**
 * <a href="RequestorInformation.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Resmy Mathew
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class RequestorInformation implements Serializable
{
    /** Default Serial version UID*/
    private static final long serialVersionUID = 1L;
  
    @DocumentumPropertyMapping(name = "pgc_req_phone_num")
    private String businessPhone;
    @DocumentumPropertyMapping(name = "pgc_cost_center")
    private String costCenter;
    @DocumentumPropertyMapping(name = "pgc_creator_name")
    private String createdBy;
    @DocumentumPropertyMapping(name = "pgc_creator_emp_id")
    private String createdUserEmployeeId;
    @DocumentumPropertyMapping(name = "pgc_date_req")
    private Date dateCompleted;
    @DocumentumPropertyMapping(name = "pgc_req_dept")
    private String deptTerritory;
    @DocumentumPropertyMapping(name = "pgc_req_email")
    private String email;
    @DocumentumPropertyMapping(name = "pgc_manager_email")
    private String managerEmail;
    @DocumentumPropertyMapping(name = "pgc_man_emp_id")
    private String managerEmployeeId;
    @DocumentumPropertyMapping(name = "pgc_manager_name")
    private String managerName;
    @DocumentumPropertyMapping(name = "pgc_manager_approval")
    private boolean mApprovalReq;
    @DocumentumPropertyMapping(name = "pgc_req_emp_id")
    private String requestorEmployeeId;
    private long requestorId;
    @DocumentumPropertyMapping(name = "pgc_req_name")
    private String requestorName;
    private String territoryCode;
    @DocumentumPropertyMapping(name = "pgc_vice_pres_approval")
    private boolean vpApprovalReq;
    @DocumentumPropertyMapping(name = "pgc_vice_pres_email")
    private String vpEmail;
    @DocumentumPropertyMapping(name = "pgc_vp_emp_id")
    private String vpEmployeeId;
    @DocumentumPropertyMapping(name = "pgc_vice_pres_name")
    private String vpName;
    @DocumentumPropertyMapping(name = "pgc_req_wbs")
    private String wbsElement;
        
    public RequestorInformation()
    {
    }

    public String getBusinessPhone()
    {
        return businessPhone;
    }

    public String getCostCenter()
    {
        return costCenter;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public String getCreatedUserEmployeeId()
    {
        return createdUserEmployeeId;
    }

    public Date getDateCompleted()
    {
        return dateCompleted;
    }

    public String getDeptTerritory()
    {
        return deptTerritory;
    }

    public String getEmail()
    {
        return email;
    }

    public String getManagerEmail()
    {
        return managerEmail;
    }

    public String getManagerEmployeeId()
    {
        return managerEmployeeId;

    }

    public String getManagerName()
    {
        return managerName;
    }

    public String getRequestorEmployeeId()
    {
        return requestorEmployeeId;
    }

    public long getRequestorId()
    {
        return requestorId;
    }

    public String getRequestorName()
    {
        return requestorName;
    }

    public String getTerritoryCode()
    {
        return territoryCode;
    }

    public String getVpEmail()
    {
        return vpEmail;
    }

    public String getVpEmployeeId()
    {
        return vpEmployeeId;
    }

    public String getVpName()
    {
        return vpName;
    }

    public String getWbsElement()
    {
        return wbsElement;
    }

    public boolean isMApprovalReq()
    {
        return mApprovalReq;
    }

    public boolean isVpApprovalReq()
    {
        return vpApprovalReq;
    }

    public void setBusinessPhone(String phone)
    {
        businessPhone = phone;
    }

    public void setCostCenter(String costCenter)
    {
        this.costCenter = costCenter;
    }

    public void setCreatedBy(String crName)
    {
        this.createdBy = crName;
    }

    public void setCreatedUserEmployeeId(String createdUserEmployeeId)
    {
        this.createdUserEmployeeId = createdUserEmployeeId;
    }

    public void setDateCompleted(Date dateCompleted)
    {
        this.dateCompleted = dateCompleted;
    }

    public void setDeptTerritory(String deptTerritory)
    {
        this.deptTerritory = deptTerritory;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setManagerEmail(String managerEmail)
    {
        this.managerEmail = managerEmail;
    }

    public void setManagerEmployeeId(String managerEmployeeId)
    {
        this.managerEmployeeId = managerEmployeeId;
    }

    public void setManagerName(String managerName)
    {
        this.managerName = managerName;
    }

    public void setMApprovalReq(boolean approvalReq)
    {
        mApprovalReq = approvalReq;
    }

    public void setRequestorEmployeeId(String employeeId)
    {
        this.requestorEmployeeId = employeeId;
    }

    public void setRequestorId(long userId)
    {
        this.requestorId = userId;
    }

    public void setRequestorName(String name)
    {
        this.requestorName = name;
    }

    public void setTerritoryCode(String territoryCode)
    {
        this.territoryCode = territoryCode;
    }

    public void setVpApprovalReq(boolean vpApprovalReq)
    {
        this.vpApprovalReq = vpApprovalReq;
    }

    public void setVpEmail(String vpEmail)
    {
        this.vpEmail = vpEmail;
    }

    public void setVpEmployeeId(String vpEmployeeId)
    {
        this.vpEmployeeId = vpEmployeeId;
    }

    public void setVpName(String vpName)
    {
        this.vpName = vpName;
    }

    public void setWbsElement(String wbsElement)
    {
        this.wbsElement = wbsElement;
    }

}
