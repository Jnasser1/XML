package parsers;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dto.Event;
import dto.Organizer;
import dto.Venue;
import dto.Participant;


public class DOMparser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("xml/event.xml"));
		Event event = new Event();

		
		NodeList nameList = document.getElementsByTagName("tns:name");
		Node nameItem = nameList.item(0);
		event.setName(nameItem.getTextContent());

		NodeList descList = document.getElementsByTagName("tns:description");
		Node descriptionItem = descList.item(0);
		event.setDescription(descriptionItem.getTextContent());

		NodeList ticketPriceList = document.getElementsByTagName("tns:ticketPrice");
		Node ticketPriceItem = ticketPriceList.item(0);
		event.setTicketPrice(Double.parseDouble(ticketPriceItem.getTextContent()));

		NodeList startTimeList = document.getElementsByTagName("tns:startTime");
		Node startTimeItem = startTimeList.item(0);
		LocalDateTime date = LocalDateTime.parse(startTimeItem.getTextContent());
		System.out.println(date);
		event.setStartTime(date);

		
		
		NodeList endTimeList = document.getElementsByTagName("tns:endTime");
		Node endTimeItem = endTimeList.item(0);
		LocalDateTime endtimeDate = LocalDateTime.parse(endTimeItem.getTextContent());
		event.setEndTime(endtimeDate);

		// key is the attribute name.

		Element documentElement = document.getDocumentElement();
		event.setId(documentElement.getAttribute("id"));

		NodeList organizerList = document.getElementsByTagName("tns:organizer");
		Node organizerNode = organizerList.item(0);
		NodeList organizerChildNodes = organizerNode.getChildNodes();
		Organizer organizer = new Organizer();

		for (int i = 0; i < organizerChildNodes.getLength(); i++) {
			Node item = organizerChildNodes.item(i);

			if (item instanceof Element) {

				switch (item.getNodeName()) {
				case "tns:name":
					organizer.setName(item.getTextContent());
					break;
				case "tns:email":
					organizer.setEmail(item.getTextContent());
					break;
				case "tns:phone":
					organizer.setPhone(item.getTextContent());
					break;

				}
			}

		}

		event.setOrganizer(organizer);

		NodeList VenueList = document.getElementsByTagName("tns:venue");
		Node venueNode = VenueList.item(0);
		NodeList venueChildNodes = venueNode.getChildNodes();
		Venue venue = new Venue();

		for (int i = 0; i < venueChildNodes.getLength(); i++) {
			Node item = venueChildNodes.item(i);

			if (item instanceof Element) {

				switch (item.getNodeName()) {
				case "tns:name":
					venue.setName(item.getTextContent());
					break;
				case "tns:street":
					venue.setStreet(item.getTextContent());
					break;
				case "tns:city":
					venue.setCity(item.getTextContent());
					break;
				case "tns:state":
					venue.setState(item.getTextContent());
					break;
				case "tns:country":
					venue.setCountry(item.getTextContent());
					break;
				case "tns:zipcode":
					venue.setZipcode(item.getTextContent());
					break;
				}
			}

		}

		event.setVenue(venue);

		
	
		
//		NodeList participantList = document.getElementsByTagName("tns:participant");
//		Participant participant = new Participant();
//		Participant[] participants = new Participant[participantList.getLength()];
//		
//	for (int j=0; j<participantList.getLength(); j++) {
//		Node participantNode = participantList.item(j);
//		NodeList participantChildNodes = participantNode.getChildNodes();
//		
//		for (int i = 0; i < participantChildNodes.getLength(); i++) {
//			Node item = participantChildNodes.item(i);
//
//			if (item instanceof Element) {
//
//				switch (item.getNodeName()) {
//				case "tns:name":
//					participant.setName(item.getTextContent());
//					break;
//				case "tns:email":
//					participant.setEmail(item.getTextContent());
//					break;
//				case "tns:phone":
//					participant.setPhone(item.getTextContent());
//					break;
//
//				}
//			}
//
//			participants[i]=participant;
//		}
//	}
//		
//	event.SetArray(participants);
//	
	
		System.out.println(event.getId());
		System.out.println(event.getName());
		System.out.println(event.getDescription());
		System.out.println(event.getTicketPrice());
		System.out.println(event.getStartTime());
		System.out.println(event.getEndTime());
		System.out.println(event.getOrganizer().getName());
		System.out.println(event.getOrganizer().getEmail());
		System.out.println(event.getOrganizer().getPhone());

		
	}

}
