/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.model;

import java.io.Serializable;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumEmbeddedPropertyMapping;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumPropertyMapping;
import com.dsi.intranet.pgc.portlet.model.basic.Address;

/**
 * <a href="CheckRequestInformation.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class CheckRequestInformation implements Serializable
{

    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;
    @DocumentumEmbeddedPropertyMapping(prefixName = "pgc_")
    private Address checkAddress;
    @DocumentumPropertyMapping(name = "pgc_payee_name")
    private String payeeName;
    @DocumentumPropertyMapping(name = "pgc_tax_id_ssn")
    private String payeeTaxIdSSN;
    @DocumentumPropertyMapping(name = "pgc_special_instructions")
    private String splInstructions;
    @DocumentumPropertyMapping(name = "pgc_check_amount")
    private String totalCheckAmt; 
    @DocumentumPropertyMapping(name = "pgc_purpose")
    private String purpose;
    @DocumentumPropertyMapping(name = "pgc_purpose_code")
    private String purposeCode;
    @DocumentumPropertyMapping(name = "pgc_nature")
    private String nature;
    @DocumentumPropertyMapping(name = "pgc_nature_code")
    private String natureCode;
    @DocumentumPropertyMapping(name = "pgc_recp_type")
    private String recipientType;
    @DocumentumPropertyMapping(name = "pgc_recp_code")
    private String recipientCode;
    @DocumentumPropertyMapping(name = "pgc_payment_form")
    private String paymentForm;
    @DocumentumPropertyMapping(name = "pgc_payment_code")
    private String paymentCode;
    @DocumentumPropertyMapping(name = "pgc_aggr_product")
    private String product;
    
    
    public CheckRequestInformation()
    {
        checkAddress = new Address();
    }

    public Address getCheckAddress()
    {
        return checkAddress;
    }

    public String getPayeeName()
    {
        return payeeName;
    }

    public String getPayeeTaxIdSSN()
    {
        return payeeTaxIdSSN;
    }

    public String getSplInstructions()
    {
        return splInstructions;
    }

    public String getTotalCheckAmt()
    {
        return totalCheckAmt;
    }
    public String getProduct()
    {
        return product;
    }
    public String getPurpose()
    {
        return purpose;
    }
    public String getPurposeCode()
    {
        return purposeCode;
    }
    public String getNature()
    {
        return nature;
    }
    public String getNatureCode()
    {
        return natureCode;
    }
    public String getRecipientType()
    {
        return recipientType;
    }
    public String getRecipientCode()
    {
        return recipientCode;
    }
    public String getPaymentForm()
    {
        return paymentForm;
    }
    public String getPaymentCode()
    {
        return paymentCode;
    }
    public void setCheckAddress(Address checkAddress)
    {
        this.checkAddress = checkAddress;
    }

    public void setPayeeName(String name)
    {
        this.payeeName = name;
    }

    public void setPayeeTaxIdSSN(String payeeTaxIdSSN)
    {
        this.payeeTaxIdSSN = payeeTaxIdSSN;
    }

    public void setSplInstructions(String splInstructions)
    {
        this.splInstructions = splInstructions;
    }

    public void setTotalCheckAmt(String totalCheckAmt)
    {
        this.totalCheckAmt = totalCheckAmt;
    }
    public void setPurpose(String purpose)
    {
        this.purpose = purpose;
    }
    public void setProduct(String product)
    {
        this.product = product;
    }
    public void setPurposeCode(String purposeCode)
    {
        this.purposeCode = purposeCode;
    }
    public void setNature(String nature)
    {
        this.nature = nature;
    }
    public void setNatureCode(String natureCode)
    {
        this.natureCode = natureCode;
    }
    public void setRecipientType(String recipientType)
    {
        this.recipientType = recipientType;
    }
    public void setRecipientCode(String recipientCode)
    {
        this.recipientCode = recipientCode;
    }
    public void setPaymentForm(String paymentForm)
    {
        this.paymentForm = paymentForm;
    }
    public void setPaymentCode(String paymentCode)
    {
        this.paymentCode = paymentCode;
    }

}
