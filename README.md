# Dynatrace-NetCool-Event-Action
Plugin for Dynatrace Application Monitoring to send events to Netcool Impact Web Services via SOAP Message

Requires a policy to be created to receive events

Configuration Parameters:
* Login User - the user in the login call to Impact
* Login Password - user's password
* Service URL - full URL to the Web Service endpoint
* Policy - name of the policy created to accept events
* Override Parameter Names - Allows to specify your own names for the message parameters in 
	case of an existing policy or usage of a preferred naming convention
* Parameter names (populate to override):
* * DT Server Parameter - default "DYN_SERVER"
* * Incident Name Parameter - default "DYN_INCIDENT"
* * Incident Description Parameter - default "DYN_DESCRIPTION"
* * violated Measure Parameter - default "DYN_VIOLATEDMEASURE"
* * Source Type Parameter - default "DYN_SOURCETYPE"
* * Source Name Parameter - default "DYN_SOURCENAME"
* * Severity Parameter - default "DYN_SEVERITY"
* * Incident State Parameter - default "DYN_STATE"
* * Incident ID Parameter - default "DYN_UID"
* * System Profile Parameter - default "DYN_SYSTEM PROFILE"

Note that for out-of-the-box (event-driven) incidents, there will not be a Violated measure,
	source type, or source name for the incident as there is not a condition measure.
	
	Any questions please open an issue, ask on the forums (https://community.dynatrace.com/), or e-mail me
		directly at richard.boyd@dynatrace.com