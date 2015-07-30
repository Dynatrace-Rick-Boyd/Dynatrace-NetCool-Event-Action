package com.dynatrace.diagnostics.plugin;

import com.dynatrace.diagnostics.pdk.*;


import java.net.URL;

import java.util.Collection;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.ws.BindingProvider;



import com.micromuse.response.types.*;
import com.micromuse.response.wsdl.WSListenerException;
import com.micromuse.response.wsdl.*;

public class NetCoolEventAction implements Action {
	private static final Logger log = Logger.getLogger(NetCoolEventAction.class.getName());

	//WSDL Implementation
	private ImpactWebServiceListenerDL wsService;
	private ImpactWebServiceListenerDLIfc wsIFace;
	WSListenerId wslid;
	private List<WSPolicyUserParameter> params;
	
	//Config parameters
	String loginName;
	String loginPass;
	URL serviceURL;
	String command;
	String configParams;
	

	
	/**
	 * Initializes the Plugin. This method is called in the following cases:
	 * <ul>
	 * <li>before <tt>execute</tt> is called the first time for this
	 * scheduled Plugin</li>
	 * <li>before the next <tt>execute</tt> if <tt>teardown</tt> was called
	 * after the last execution</li>
	 * </ul>
	 * 
	 * <p>
	 * If the returned status is <tt>null</tt> or the status code is a
	 * non-success code then {@link #teardown(ActionEnvironment)} will be called
	 * next.
	 * 
	 * <p>
	 * Resources like sockets or files can be opened in this method.
	 * Resources like sockets or files can be opened in this method.
	 * @param env
	 *            the configured <tt>ActionEnvironment</tt> for this Plugin
	 * @see #teardown(ActionEnvironment)
	 * @return a <tt>Status</tt> object that describes the result of the
	 *         method call
	 */
	@Override
	public Status setup(ActionEnvironment env) throws Exception {
		wsService = new ImpactWebServiceListenerDL();
		wsIFace = wsService.getImpactWebServiceListenerDLIfcPort();
		
		loginName = env.getConfigString("loginName");
		loginPass = env.getConfigPassword("loginPass");
		serviceURL = env.getConfigUrl("serviceURL");
		command = env.getConfigString("command");
		configParams = env.getConfigString("configParams");
		
		
		((BindingProvider)wsIFace).getRequestContext().put(
	            BindingProvider.ENDPOINT_ADDRESS_PROPERTY, serviceURL.toString());
		try {
			wslid = wsIFace.login(loginName, loginPass);
		} catch (WSListenerException e) {
			logSevere("Login Failed.  Exception: " + e.getMessage());
			return new Status(Status.StatusCode.ErrorTargetService);
		}
		
		return new Status(Status.StatusCode.Success);
	}

	/**
	 * Executes the Action Plugin to process incidents.
	 * 
	 * <p>
	 * This method may be called at the scheduled intervals, but only if incidents
	 * occurred in the meantime. If the Plugin execution takes longer than the
	 * schedule interval, subsequent calls to
	 * {@link #execute(ActionEnvironment)} will be skipped until this method
	 * returns. After the execution duration exceeds the schedule timeout,
	 * {@link ActionEnvironment#isStopped()} will return <tt>true</tt>. In this
	 * case execution should be stopped as soon as possible. If the Plugin
	 * ignores {@link ActionEnvironment#isStopped()} or fails to stop execution in
	 * a reasonable timeframe, the execution thread will be stopped ungracefully
	 * which might lead to resource leaks!
	 * 
	 * @param env
	 *            a <tt>ActionEnvironment</tt> object that contains the Plugin
	 *            configuration and incidents
	 * @return a <tt>Status</tt> object that describes the result of the
	 *         method call
	 */
	@Override
	public Status execute(ActionEnvironment env) throws Exception {
		
		// this sample shows how to receive and act on incidents
		Collection<Incident> incidents = env.getIncidents();
		for (Incident incident : incidents) {
			String message = incident.getMessage();
			logInfo("Incident " + message + " triggered.");
			for (Violation violation : incident.getViolations()) {
				logInfo("Measure " + violation.getViolatedMeasure().getName() + " violated threshold.");
				
				// TODO
				//addParams("description", "String", "name", "value");
				addParams("Source dynaTrace Server", "String", "DT_SERVER", incident.getServerName());
				addParams("Incident Message", "String", "MESSAGE", incident.getMessage());
				
				wsIFace.runPolicy(wslid, command, params, true);
			}
		}
		

		
		return new Status(Status.StatusCode.Success);
	}

	/**
	 * Shuts the Plugin down and frees resources. This method is called in the
	 * following cases:
	 * <ul>
	 * <li>the <tt>setup</tt> method failed</li>
	 * <li>the Plugin configuration has changed</li>
	 * <li>the execution duration of the Plugin exceeded the schedule timeout</li>
	 * <li>the schedule associated with this Plugin was removed</li>
	 * </ul>
	 * <p>
	 * The Plugin methods <tt>setup</tt>, <tt>execute</tt> and
	 * <tt>teardown</tt> are called on different threads, but they are called
	 * sequentially. This means that the execution of these methods does not
	 * overlap, they are executed one after the other.
	 * 
	 * <p>
	 * Examples:
	 * <ul>
	 * <li><tt>setup</tt> (failed) -&gt; <tt>teardown</tt></li>
	 * <li><tt>execute</tt> starts, configuration changes, <tt>execute</tt>
	 * ends -&gt; <tt>teardown</tt><br>
	 * on next schedule interval: <tt>setup</tt> -&gt; <tt>execute</tt> ...</li>
	 * <li><tt>execute</tt> starts, execution duration timeout,
	 * <tt>execute</tt> stops -&gt; <tt>teardown</tt></li>
	 * <li><tt>execute</tt> starts, <tt>execute</tt> ends, schedule is
	 * removed -&gt; <tt>teardown</tt></li>
	 * </ul>
	 * Failed means that either an unhandled exception is thrown or the status
	 * returned by the method contains a non-success code.
	 * 
	 * <p>
	 * All by the Plugin allocated resources should be freed in this method.
	 * Examples are opened sockets or files.
	 * 
	 * @see #setup(ActionEnvironment)
	 */
	@Override
	public void teardown(ActionEnvironment env) throws Exception {
		// TODO
	}

	private void addParams(String desc, String format, String label, String value) {
		WSPolicyUserParameter param = new WSPolicyUserParameter();
		param.setFormat(format);
		
		param.setDesc(desc);
		param.setLabel(label);
		param.setValue(value);
		
		params.add(param);
	}
	
	private void logInfo(String message){
		if (log.isLoggable(Level.INFO))
			log.info(message);
	}
	
	private void logWarn(String message){
		if (log.isLoggable(Level.WARNING))
			log.warning(message);
	}
	
	private void logSevere(String message){
		if (log.isLoggable(Level.SEVERE))
			log.severe(message);
	}
	
}