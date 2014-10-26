package client;

import static client.Client.ACCESS_KEY;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class PropertyInjector implements SOAPHandler<SOAPMessageContext> {
	
	public boolean handleMessage(SOAPMessageContext context) {
		
		Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		// If it is an outgoing message
		if (outboundProperty.booleanValue()) {

			try {
				SOAPMessage soapMessagg = context.getMessage();
				SOAPEnvelope soapEnvelope = soapMessagg.getSOAPPart().getEnvelope();
				SOAPHeader soapHeader = soapEnvelope.getHeader();

				if (soapHeader == null) {
					soapHeader = soapEnvelope.addHeader();
				}		

				QName qname = new QName("http://service/", "PROPERTY");
				
				SOAPHeaderElement soapHeaderElement = soapHeader.addHeaderElement(qname);
				soapHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				soapHeaderElement.addTextNode(ACCESS_KEY);
				soapMessagg.saveChanges();

			} catch (SOAPException e) {
				System.err.println(e);
			}

		}
		return true;
	}

	
	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	public void close(MessageContext context) {
	}

	public Set<QName> getHeaders() {
		return null;
	}
}