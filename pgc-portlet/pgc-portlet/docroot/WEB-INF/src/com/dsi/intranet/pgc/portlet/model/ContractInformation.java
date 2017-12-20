/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.model;

import java.io.Serializable;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumEmbeddedPropertyMapping;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumPropertyMapping;
import com.dsi.intranet.pgc.portlet.model.basic.Address;

/**
 * <a href="ContractInformation.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */

public class ContractInformation implements Serializable
{
    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;
    @DocumentumEmbeddedPropertyMapping(prefixName = "pgc_")
    private Address contractAddress;
    @DocumentumPropertyMapping(name = "pgc_cont_spec_name")
    private String contractSpecialist;
    @DocumentumPropertyMapping(name = "pgc_cust_name")
    private String customerName;
    @DocumentumPropertyMapping(name = "pgc_tax_id_ssn")
    private String payeeTaxIdSSN;
    private String otherContract;
    public ContractInformation()
    {
        contractAddress = new Address();
    }

    public Address getContractAddress()
    {
        return contractAddress;
    }

    public String getContractSpecialist()
    {
        return contractSpecialist;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public String getPayeeTaxIdSSN()
    {
        return payeeTaxIdSSN;
    }
    public String getOtherContract()
    {
        return otherContract;
    }
    public void setContractAddress(Address contractAddress)
    {
        this.contractAddress = contractAddress;
    }
    public void setOtherContract(String otherContract)
    {
        this.otherContract = otherContract;
    }

    public void setContractSpecialist(String contractSpecialist)
    {
        this.contractSpecialist = contractSpecialist;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public void setPayeeTaxIdSSN(String payeeTaxIdSSN)
    {
        this.payeeTaxIdSSN = payeeTaxIdSSN;
    }
}