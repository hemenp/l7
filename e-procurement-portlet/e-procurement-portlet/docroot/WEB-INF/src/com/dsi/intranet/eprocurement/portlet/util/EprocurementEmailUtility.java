package com.dsi.intranet.eprocurement.portlet.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletRequest;

import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * This utility is responsible for sending and emails in different scenarios
 * @author jitendra.rajput
 *
 */
public final class EprocurementEmailUtility
{
	private static final Log LOGGER = LogFactoryUtil.getLog(EprocurementEmailUtility.class);

    /**
     * Send email to requester when request approved by Intitial Approver
     * @param fromAddress
     * @param actionRequest
     * @param themeDisplay
     * @param eprocRequest
     * @throws Exception
     */
    
    private EprocurementEmailUtility()
    {
    }
    
    public static void sendEmailByInitialApprover(String fromAddress, PortletRequest actionRequest,
            ThemeDisplay themeDisplay, EprocurementRequest eprocRequest)
    {

        LOGGER.info("Inside sendEmailByInitialApprover()..");
        String toAddress = StringPool.BLANK;
        String toName = StringPool.BLANK;
        long requestId;
        ClassLoader classLoader = EprocurementEmailUtility.class.getClassLoader();
        String emailSubject = EProcurementConstants.EPROC_INTIAL_APPROVED_EMAIL_SUBJECT;
        String body = StringPool.BLANK;
        try
        {
            body = StringUtil.read(classLoader, EProcurementConstants.EPROC_INTIAL_APPROVED_EMAIL_BODY_TEMPLATE, true);
        } catch (IOException e)
        {
            LOGGER.error("Problem while reading template.." + e.getMessage());
        }

        try
        {
            if (eprocRequest != null)
            {
                long userId = eprocRequest.getRequestorId();
                requestId = eprocRequest.getRequestId();
                User user = UserLocalServiceUtil.getUser(userId);
                toName = user.getFirstName() + StringPool.BLANK + user.getLastName();
                toAddress = user.getEmailAddress();
                emailSubject = emailSubject.concat(String.valueOf(requestId));

                String redirectURL = EProcurementUtil.createSendRedirectURL(themeDisplay,
                        EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS);
                String viewRequestUrl = EProcurementUtil.createEditRequestURL(redirectURL, requestId);

                body = StringUtil.replace(body, new String[] { EProcurementConstants.REQUESTID_VAR, EProcurementConstants.VIEWREQUEST_VAR }, new String[] {
                        String.valueOf(requestId), viewRequestUrl });

            }

            InternetAddress from = new InternetAddress(fromAddress);
            InternetAddress to = new InternetAddress(toAddress, toName);
            MailMessage message = new MailMessage(from, to, emailSubject, body, true);
            message.setHTMLFormat(true);

            if (Validator.isNotNull(message))
            {
                MailServiceUtil.sendEmail(message);
                LOGGER.info("Mail sent to requester as request is approved by initial approver...");
            }
        } catch (Exception e)
        {
            LOGGER.error("Problem while sending email..." + e.getMessage());
        }

    }

    /**
     * Send email to requester on completion of all stage approval
     * @param actionRequest
     * @param themeDisplay
     * @param eprocRequest
     */
    public static void sendFinalApprovalEmail(PortletRequest actionRequest, ThemeDisplay themeDisplay,
            EprocurementRequest eprocRequest)
    {

        try
        {
           
            String fromEmailAddress = EProcurementConstants.EPROC_EMAIL_FROM_ADDRESS;
            long requestorId = eprocRequest.getRequestorId();
            long requestId = eprocRequest.getRequestId();
            User user;
            user = UserLocalServiceUtil.getUser(requestorId);
            String toName = user.getFirstName() + StringPool.BLANK + user.getLastName();
            String toEmailAddress = user.getEmailAddress();
            ClassLoader classLoader = EprocurementEmailUtility.class.getClassLoader();
            String emailSubject = EProcurementConstants.EPROC_FINAL_APPROVED_EMAIL_SUBJECT;
            emailSubject = emailSubject.concat(String.valueOf(eprocRequest.getRequestId()));
            String body = StringUtil.read(classLoader, EProcurementConstants.EPROC_FIN_APPROVED_EMAIL_BODY_TEMPLATE,
                    true);

            String redirectURL = EProcurementUtil.createSendRedirectURL(themeDisplay,
                    EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS);
            String viewRequestUrl = EProcurementUtil.createEditRequestURL(redirectURL, requestId);

            body = StringUtil.replace(body, new String[] { EProcurementConstants.REQUESTID_VAR, EProcurementConstants.VIEWREQUEST_VAR }, new String[] {
                    String.valueOf(requestId), viewRequestUrl });

            InternetAddress from = new InternetAddress(fromEmailAddress);
            InternetAddress to = new InternetAddress(toEmailAddress, toName);
            MailMessage message = new MailMessage(from, to, emailSubject, body, true);
            message.setHTMLFormat(true);

            if (Validator.isNotNull(message))
            {
                MailServiceUtil.sendEmail(message);
                LOGGER.info("Mail sent to requester for final approval of request ...");
            }

        } catch (Exception e)
        {
            LOGGER.error("Error occured while sending email ..." + e.getMessage());
        }

    }
    
    /**
     * If the request status is set to cancelled then notify requester about the same
     * @param actionRequest
     * @param themeDisplay
     * @param requestId
     * @param comments
     */
    public static void sendNotificationForCanceledRequest(PortletRequest actionRequest, ThemeDisplay themeDisplay,
           long requestId,String comments)
    {
        
        try
        {
            String body = StringPool.BLANK;
            String fromName = StringPool.BLANK;
            String fromEmailAddress = EProcurementConstants.EPROC_EMAIL_FROM_ADDRESS;
            EprocurementRequest eprocRequest = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
            long requestorId = eprocRequest.getRequestorId();
            
            String toName = EProcurementUtil.getUserName(requestorId);
            String toEmailAddress =  EProcurementUtil.getUserEmailAddress(requestorId);
            ClassLoader classLoader = EprocurementEmailUtility.class.getClassLoader();
            String emailSubject = EProcurementConstants.EPROC_CANCELLED_REQUEST_SUBJECT;
            emailSubject = emailSubject.concat(String.valueOf(requestId));
            String redirectURL = EProcurementUtil.createSendRedirectURL(themeDisplay,
                    EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS);
            String viewRequestUrl = EProcurementUtil.createEditRequestURL(redirectURL, requestId);
            fromName = themeDisplay.getUser().getFirstName() +StringPool.SPACE+ themeDisplay.getUser().getLastName();
            if(StringPool.BLANK.equals(comments))
            {
                comments = EProcurementConstants.NOT_AVAILABLE;
            }

            try
            {
                body = StringUtil.read(classLoader, EProcurementConstants.EPROC_CANCELLED_REQUEST_BODY_TEMPLATE, true);
                body = StringUtil.replace(body, new String[] { EProcurementConstants.REQUESTID_VAR, "[$fromName]","[$comments]",EProcurementConstants.VIEWREQUEST_VAR }, new String[] {
                        String.valueOf(requestId),fromName, comments,viewRequestUrl });
            } catch (IOException e)
            {
                LOGGER.error(e.getMessage());
            }
            
            InternetAddress from = new InternetAddress(fromEmailAddress);
            InternetAddress to = new InternetAddress(toEmailAddress, toName);
            MailMessage message = new MailMessage(from, to, emailSubject, body, true);
            message.setHTMLFormat(true);

            if (Validator.isNotNull(message))
            {
                MailServiceUtil.sendEmail(message);
                LOGGER.info("Mail sent to requester to notify about cancelled/declined request ...");
            }
        } catch (UnsupportedEncodingException e)
        {
            LOGGER.error("Problem occured while sending email on cancel.." + e.getMessage());
        } catch (AddressException e)
        {
           LOGGER.error("email not send on cancel.." + e.getMessage());
        } catch (PortalException e)
        {
            LOGGER.error("Failed to find eprocurement request details .." + e.getMessage());
        } catch (SystemException e)
        {
            LOGGER.error("Failed to find eprocurement request details .." + e.getMessage());
        }
       
    }
    

    /**
     * Notify requester about request.
     * i.e if request is approved by 1st stage approver then 
     * update next stage approver that request in his/her plate
     * @param actionRequest
     * @param themeDisplay
     * @param requestId
     * @param stageApproverID
     */
    public static void notifyStageApprover(PortletRequest actionRequest, ThemeDisplay themeDisplay, long requestId,
            long stageApproverID,boolean isReminder)
    {
        try
        {
            String body = StringPool.BLANK;
            String fromEmailAddress = EProcurementConstants.EPROC_EMAIL_FROM_ADDRESS;

            String toName = EProcurementUtil.getUserName(stageApproverID);
            String toEmailAddress = EProcurementUtil.getUserEmailAddress(stageApproverID);
            LOGGER.info("Email Sent to .." + toEmailAddress);
            ClassLoader classLoader = EprocurementEmailUtility.class.getClassLoader();
            String emailSubject = StringPool.BLANK;
            
            if(isReminder){
                
                emailSubject = EProcurementConstants.REMINDER_MSG;
                emailSubject = emailSubject.concat(StringPool.SPACE);
                emailSubject = emailSubject.concat(EProcurementConstants.EPROC_STAGE_APPROVER_NOTIFCATION_SUBJECT);
            }else{
                emailSubject = EProcurementConstants.EPROC_STAGE_APPROVER_NOTIFCATION_SUBJECT;
            }
            
            emailSubject = emailSubject.concat(String.valueOf(requestId));
            String redirectURL = EProcurementUtil.createSendRedirectURL(themeDisplay,
                    EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS);
            String viewRequestUrl = EProcurementUtil.createEditRequestURL(redirectURL, requestId);

            try
            {
				EprocurementRequest request = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
				request.setNextStage(String.valueOf(stageApproverID));
                body = StringUtil.read(classLoader,
                        EProcurementConstants.EPROC_STAGE_APPROVER_NOTIFCATION_BODY_TEMPLATE, true);
                body = StringUtil.replace(body, new String[] { EProcurementConstants.REQUESTID_VAR, EProcurementConstants.VIEWREQUEST_VAR,
                        "[$REQUEST_TRACKER_URL]" }, new String[] { String.valueOf(requestId), viewRequestUrl,
                        EProcurementRequestTrackerWSUtil.getRequestTrackerHrefForStageApprover(request, stageApproverID) });
            } catch (IOException e)
            {
                LOGGER.error(e.getMessage(),e);
            }
			catch (PortalException e)
            {
                LOGGER.error(e.getMessage(),e);
            } catch (SystemException e)
            {
                LOGGER.error(e.getMessage(),e);
            }

            InternetAddress from = new InternetAddress(fromEmailAddress);
            InternetAddress to = new InternetAddress(toEmailAddress, toName);
            MailMessage message = new MailMessage(from, to, emailSubject, body, true);
            message.setHTMLFormat(true);

            if (Validator.isNotNull(message))
            {
                MailServiceUtil.sendEmail(message);
                LOGGER.debug("Mail sent to stage approver to notify about request ...");
            }
        } catch (UnsupportedEncodingException e)
        {
            LOGGER.error("failed to notify stage approver.." + e.getMessage());
        } catch (AddressException e)
        {
            LOGGER.error("problem occured while sending an email to stage approver.." + e.getMessage());
        }
    }
}


