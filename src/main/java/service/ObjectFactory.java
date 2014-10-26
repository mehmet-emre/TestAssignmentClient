
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
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

    private final static QName _UpdatePlayerBalanceResponse_QNAME = new QName("http://service/", "UpdatePlayerBalanceResponse");
    private final static QName _UpdatePlayerBalance_QNAME = new QName("http://service/", "UpdatePlayerBalance");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdatePlayerBalance }
     * 
     */
    public UpdatePlayerBalance createUpdatePlayerBalance() {
        return new UpdatePlayerBalance();
    }

    /**
     * Create an instance of {@link UpdatePlayerBalanceResponse }
     * 
     */
    public UpdatePlayerBalanceResponse createUpdatePlayerBalanceResponse() {
        return new UpdatePlayerBalanceResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePlayerBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "UpdatePlayerBalanceResponse")
    public JAXBElement<UpdatePlayerBalanceResponse> createUpdatePlayerBalanceResponse(UpdatePlayerBalanceResponse value) {
        return new JAXBElement<UpdatePlayerBalanceResponse>(_UpdatePlayerBalanceResponse_QNAME, UpdatePlayerBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePlayerBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "UpdatePlayerBalance")
    public JAXBElement<UpdatePlayerBalance> createUpdatePlayerBalance(UpdatePlayerBalance value) {
        return new JAXBElement<UpdatePlayerBalance>(_UpdatePlayerBalance_QNAME, UpdatePlayerBalance.class, null, value);
    }

}
