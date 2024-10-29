// UrbanPlanningOffice.java
import java.util.Arrays;

public class UrbanPlanningOffice extends Office {
    public UrbanPlanningOffice() {
        // Adăugăm ghișee pentru fiecare tip de document
        addCounter(new OfficeCounter("Ghișeul Urbanism 1", Arrays.asList("certificat de urbanism")));
        addCounter(new OfficeCounter("Ghișeul Urbanism 2", Arrays.asList("certificat de urbanism")));
        addCounter(new OfficeCounter("Ghișeul Construcții 1", Arrays.asList("autorizație de construire", "autorizație de demolare")));
        addCounter(new OfficeCounter("Ghișeul Construcții 2", Arrays.asList("autorizație de construire", "autorizație de demolare")));
    }

    @Override
    public Document officeRequestDocument(Person person, String documentName, CityHall cityHall) {
       // manageCoffeeBreaks(); // Gestionăm pauzele de cafea

        Document document = createDocument(documentName);
        for (OfficeCounter counter : counters) {
            // Verificăm dacă ghișeul este disponibil și încearcă să elibereze documentul, apelând cu parametrii necesari pentru recursivitate
            if (!counter.isOnBreak() && counter.requestDocumentWithRedirect(person, document, this, cityHall) != null) {
                person.addDocument(document.getName());
                return document;
            }
        }

        System.out.println("Toate ghișeele sunt în pauză sau nu pot emite documentul solicitat.");
        return null;
    }

    protected Document createDocument(String documentName) {
        switch (documentName) {
            case "certificat de urbanism":
                return new Document("certificat de urbanism", Arrays.asList("certificat fiscal","carte de identitate"));
            case "autorizație de construire":
                return new Document("autorizație de construire", Arrays.asList("certificat de urbanism", "certificat fiscal"));
            case "autorizație de demolare":
                return new Document("autorizație de demolare", Arrays.asList("certificat de urbanism", "certificat fiscal"));
            default:
                return new Document(documentName, Arrays.asList());
        }
    }
}