package com.dsi.intranet.pgc.portlet.util;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;
import com.dsi.intranet.rfc.service.EmployeeDataDumpLocalService;


public class EmployeeDataDumpServiceTracker extends ServiceTracker<EmployeeDataDumpLocalService, EmployeeDataDumpLocalService> {

    public EmployeeDataDumpServiceTracker(Object host) {
        super(FrameworkUtil.getBundle(host.getClass()).getBundleContext(),EmployeeDataDumpLocalService.class, null);   
    }
    
    /*public EmployeeDataDumpServiceTracker(BundleContext bundleContext) {
		super(bundleContext, EmployeeDataDumpLocalService.class, null);
	}
*/
}
