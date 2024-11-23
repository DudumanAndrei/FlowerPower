package BeaureaticSystems.cityhall;


import BeaureaticSystems.document.DocumentType;
import BeaureaticSystems.document.DocumentTypeRepository;
import BeaureaticSystems.office.Office;
import BeaureaticSystems.office.OfficeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@AllArgsConstructor
public class CityHallService {

//    private final DocumentTypeRepository documentTypeRepository;
//    private final OfficeRepository officeRepository;
//
//    private static final int NUM_OFFICES = 3;
//    private static final int MIN_NUM_COUNTERS_PER_OFFICE = 3;
//    private static final int MAX_NUM_COUNTERS_PER_OFFICE = 5;
//    private static final Random rnd = new Random();
//
//    // Generăm tipuri de documente
//    public List<DocumentType> generateDocumentTypes() {
//        // Dacă sunt deja în baza de date, returnăm
//        List<DocumentType> existingTypes = (List<DocumentType>) documentTypeRepository.findAll();
//        if (!existingTypes.isEmpty()) {
//            return existingTypes;
//        }
//
//        // Altfel, generăm și salvăm tipurile de documente
//        DocumentType d1 = new DocumentType(1, List.of(), "Identity Card");
//        DocumentType d2 = new DocumentType(2, List.of(), "Account Statement");
//        DocumentType d3 = new DocumentType(3, List.of(), "Property Documents");
//        DocumentType d4 = new DocumentType(4, List.of(d1, d2), "Tax Certificate");
//        DocumentType d5 = new DocumentType(5, List.of(d1, d4), "Planning Certificate");
//        DocumentType d6 = new DocumentType(6, List.of(d4, d5), "Demolition Permit");
//        DocumentType d7 = new DocumentType(7, List.of(d1, d3), "Tax Assessment Decision");
//        DocumentType d8 = new DocumentType(8, List.of(d1, d3, d7), "Tax Payment Receipt");
//        DocumentType d9 = new DocumentType(9, List.of(d1, d4), "Building Permit");
//
//        List<DocumentType> documentTypes = List.of(d1, d2, d3, d4, d5, d6, d7, d8, d9);
//        documentTypeRepository.saveAll(documentTypes);
//
//        return documentTypes;
//    }
//
//    // Generăm birouri
//    public List<Office> generateOffices() {
//        // Dacă birourile există deja, returnăm
//        List<Office> existingOffices = officeRepository.findAll();
//        if (!existingOffices.isEmpty()) {
//            return existingOffices;
//        }
//
//        List<DocumentType> documentTypes = generateDocumentTypes();
//        List<Office> offices = new ArrayList<>();
//        int remainder = documentTypes.size() % NUM_OFFICES;
//        int countPerOffice = documentTypes.size() / NUM_OFFICES;
//        int start = 0;
//
//        for (int i = 0; i < NUM_OFFICES; ++i) {
//            int end = start + countPerOffice;
//            if (remainder > 0) {
//                end += 1;
//                remainder -= 1;
//            }
//            Office office = new Office(
//                    i,
//                    documentTypes.subList(start, end),
//                    rnd.nextInt(MIN_NUM_COUNTERS_PER_OFFICE, MAX_NUM_COUNTERS_PER_OFFICE + 1)
//            );
//            offices.add(office);
//            start = end;
//        }
//
//        officeRepository.saveAll(offices);
//        return offices;
//    }
//
//    // Mapăm tipurile de documente cu birourile compatibile
//    public Map<DocumentType, Office> connectTypesAndOffices() {
//        List<DocumentType> documentTypes = generateDocumentTypes();
//        List<Office> offices = generateOffices();
//
//        Map<DocumentType, Office> typeOfficeMap = new HashMap<>();
//        for (DocumentType type : documentTypes) {
//            for (Office office : offices) {
//                if (office.getCompatibleDocumentTypes().contains(type)) {
//                    typeOfficeMap.put(type, office);
//                    break;
//                }
//            }
//        }
//        return typeOfficeMap;
//    }
//
//    // Obținem documentele care necesită alte documente
//    public List<DocumentType> getDocumentsRequiringOtherDocuments() {
//        return generateDocumentTypes().stream()
//                .filter(documentType -> !documentType.getRequiredDocs().isEmpty())
//                .toList();
//    }
}