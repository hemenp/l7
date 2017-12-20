/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.model.basic;

import java.io.Serializable;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumPropertyMapping;

/**
 * <a href="Address.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author 	Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */

public class Address implements Serializable
{
	private static final long serialVersionUID = 1L;
    @DocumentumPropertyMapping(name = "address_line1")
    private String addressLine1;
    @DocumentumPropertyMapping(name = "address_line2")
    private String addressLine2;
    @DocumentumPropertyMapping(name = "city")
    private String city;
    @DocumentumPropertyMapping(name = "state")
    private String state;
    @DocumentumPropertyMapping(name = "zip_code1")
    private String zip;
    @DocumentumPropertyMapping(name = "zip_code2")
    private String zipExtra;

    public String getAddressLine1()
    {
        return addressLine1;
    }

    public String getAddressLine2()
    {
        return addressLine2;
    }

    public String getCity()
    {
        return city;
    }

    public String getState()
    {
        return state;
    }

    public String getZip()
    {
        return zip;
    }

    public String getZipExtra()
    {
        return zipExtra;
    }

    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public void setZipExtra(String zipExtra)
    {
        this.zipExtra = zipExtra;
    }
}
