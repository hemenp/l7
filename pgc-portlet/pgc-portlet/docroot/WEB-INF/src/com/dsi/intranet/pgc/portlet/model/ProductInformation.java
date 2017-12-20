/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.model;

import java.io.Serializable;
import java.util.List;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumPropertyMapping;

/**
 * <a href="ProductInformation.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date        |       Reason
 * ---------------------------------------------------------------------------------
 * Kruti Doshi					|	Sep 16 2014		|	Added new properties		
 */
public class ProductInformation implements Serializable
{
    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;

    private String otherMaterial;

    @DocumentumPropertyMapping(name = "pgc_product")
    private List<String> products;
    
    @DocumentumPropertyMapping(name = "pgc_therapeutic_area")
    private List<String> therapeuticArea;
    
    private String otherTherapeutic;

    public String getOtherMaterial()
    {
        return otherMaterial;
    }

    public List<String> getProducts()
    {
        return products;
    }

    public void setOtherMaterial(String otherMaterial)
    {
        this.otherMaterial = otherMaterial;
    }

    public void setProducts(List<String> products)
    {
        this.products = products;
    }

	public List<String> getTherapeuticArea() {
		return therapeuticArea;
	}

	public void setTherapeuticArea(List<String> therapeuticArea) {
		this.therapeuticArea = therapeuticArea;
	}

	public String getOtherTherapeutic() {
		return otherTherapeutic;
	}

	public void setOtherTherapeutic(String otherTherapeutic) {
		this.otherTherapeutic = otherTherapeutic;
	}
    
}
