package com.dsi.intranet.eprocurement.portlet.model;

import java.net.MalformedURLException;
import java.net.URL;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.portlet.PortletProps;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class EProcumenentRequestWSObject
{

    private static final Log LOGGER = LogFactoryUtil.getLog(EProcumenentRequestWSObject.class);
    public static final String DOUBLE_SLASH = "://";
    public static final String KEY_HOST_NAME = "request.tracker.web.service.parameter.host.name";
    public static final String KEY_PASSWORD = "request.tracker.web.service.parameter.password";
    public static final String KEY_PORT = "request.tracker.web.service.parameter.port";
    public static final String KEY_SERVICE_NAME = "request.tracker.web.service.parameter.service.name";
    public static final String KEY_SUB_URL = "request.tracker.web.service.parameter.sub.url";
    public static final String KEY_USER_NAME = "request.tracker.web.service.parameter.user.name";

    private String hostName;

    private String password;
    private String port;
    private String serviceName;
    private String subUrl;
    private String userName;

    public String getHostName()
    {
        return hostName;
    }

    public String getPassword()
    {
        return password;
    }

    public String getPort()
    {
        return port;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public String getSubUrl()
    {
        return subUrl;
    }

    public URL getURL()
    {
        if (!Validator.isNotNull(this.hostName) || !Validator.isNotNull(this.serviceName))
        {
            load();
        }
        String serverName = this.hostName;
        if (Validator.isNotNull(this.port))
        {
            serverName = serverName.concat(StringPool.COLON);
            serverName = serverName.concat(this.port);
        }
        LOGGER.info("serverName..props :- " + serverName);

        URL wsURL = null;
        int pos = serverName.indexOf(DOUBLE_SLASH);
        String protocol = serverName.substring(0, pos + DOUBLE_SLASH.length());
        String host = serverName.substring(pos + DOUBLE_SLASH.length(), serverName.length());

        StringBuilder sb = new StringBuilder();
        sb.append(protocol);
        if (Validator.isNotNull(this.userName) && Validator.isNotNull(this.password))
        {
            sb.append(this.userName);
            sb.append(StringPool.COLON);
            sb.append(this.password);
        }

        sb.append(StringPool.AT);
        sb.append(host);
        sb.append(StringPool.FORWARD_SLASH);
        sb.append(this.subUrl);
        sb.append(StringPool.FORWARD_SLASH);
        sb.append(this.serviceName);
        LOGGER.info("web service url from props is :- " + sb.toString());
        try
        {
            wsURL = new URL(sb.toString());
        } catch (MalformedURLException e)
        {
            LOGGER.error("ERROR while load attributes ", e);
        }
        return wsURL;
    }

    public String getUserName()
    {
        return userName;
    }

    public void load()
    {
        this.hostName = PortletProps.get(KEY_HOST_NAME);
        this.port = PortletProps.get(KEY_PORT);
        this.serviceName = PortletProps.get(KEY_SERVICE_NAME);
        this.userName = PortletProps.get(KEY_USER_NAME);
        this.password = PortletProps.get(KEY_PASSWORD);
        this.subUrl = PortletProps.get(KEY_SUB_URL);
    }

    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setPort(String port)
    {
        this.port = port;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public void setSubUrl(String subUrl)
    {
        this.subUrl = subUrl;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

}
