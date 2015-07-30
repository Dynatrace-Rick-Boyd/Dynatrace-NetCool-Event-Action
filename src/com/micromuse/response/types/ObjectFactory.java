
package com.micromuse.response.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.micromuse.response.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LoginResponse_QNAME = new QName("http://response.micromuse.com/types", "loginResponse");
    private final static QName _WSListenerException_QNAME = new QName("http://response.micromuse.com/types", "WSListenerException");
    private final static QName _RunPolicyResponse_QNAME = new QName("http://response.micromuse.com/types", "runPolicyResponse");
    private final static QName _Login_QNAME = new QName("http://response.micromuse.com/types", "login");
    private final static QName _RunPolicy_QNAME = new QName("http://response.micromuse.com/types", "runPolicy");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.micromuse.response.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link WSListenerException }
     * 
     */
    public WSListenerException createWSListenerException() {
        return new WSListenerException();
    }

    /**
     * Create an instance of {@link RunPolicyResponse }
     * 
     */
    public RunPolicyResponse createRunPolicyResponse() {
        return new RunPolicyResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link RunPolicy }
     * 
     */
    public RunPolicy createRunPolicy() {
        return new RunPolicy();
    }

    /**
     * Create an instance of {@link PolicyExecutionResult }
     * 
     */
    public PolicyExecutionResult createPolicyExecutionResult() {
        return new PolicyExecutionResult();
    }

    /**
     * Create an instance of {@link WSPolicyUserParameter }
     * 
     */
    public WSPolicyUserParameter createWSPolicyUserParameter() {
        return new WSPolicyUserParameter();
    }

    /**
     * Create an instance of {@link WSListenerId }
     * 
     */
    public WSListenerId createWSListenerId() {
        return new WSListenerId();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://response.micromuse.com/types", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WSListenerException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://response.micromuse.com/types", name = "WSListenerException")
    public JAXBElement<WSListenerException> createWSListenerException(WSListenerException value) {
        return new JAXBElement<WSListenerException>(_WSListenerException_QNAME, WSListenerException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunPolicyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://response.micromuse.com/types", name = "runPolicyResponse")
    public JAXBElement<RunPolicyResponse> createRunPolicyResponse(RunPolicyResponse value) {
        return new JAXBElement<RunPolicyResponse>(_RunPolicyResponse_QNAME, RunPolicyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://response.micromuse.com/types", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunPolicy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://response.micromuse.com/types", name = "runPolicy")
    public JAXBElement<RunPolicy> createRunPolicy(RunPolicy value) {
        return new JAXBElement<RunPolicy>(_RunPolicy_QNAME, RunPolicy.class, null, value);
    }

}
