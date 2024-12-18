package BeaureaticSystems.document;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DocumentTypeService {
    private DocumentTypeRepository documentTypeRepository;

    public void createDocumentType(DocumentType documentType) {
        documentTypeRepository.save(documentType);
    }

    public DocumentType getDocumentTypeById(int id) {
        Optional<DocumentType> documentType = documentTypeRepository.findById(id);
        return documentType.orElse(null);
    }

//    public List<DocumentType> getAllDocumentTypes() {
//        Optional<List<DocumentType>> docs = Optional.of(documentTypeRepository.findAll());
//        if (docs.isEmpty()) {
//            return null;
//        }
//        List<DocumentType> finalDocumentTypes = new ArrayList<>();
//        for (DocumentType documentType : docs.get()) {
//            if (!documentType.getRequiredDocs().isEmpty()) {
//                finalDocumentTypes.add(documentType);
//            }
//        }
//        return finalDocumentTypes;
//    }


    public List<DocumentType> getAllDocumentTypes() {
        Optional<List<DocumentType>> docs = Optional.of(documentTypeRepository.findAll());
        if (docs.isEmpty()) {
            return null;
        }

        List<DocumentType> finalDocumentTypes = new ArrayList<>();
        for (DocumentType documentType : docs.get()) {
            // Verificăm dacă documentul are dependențe (requiredDocs)
            if (documentType.getRequiredDocs() != null && !documentType.getRequiredDocs().isEmpty()) {
                finalDocumentTypes.add(documentType);
            }
        }
        return finalDocumentTypes;
    }

    public List<DocumentType> getAllDocumentTypesWithNoDependencies() {
        // Obținem toate documentele din repository
        List<DocumentType> docs = documentTypeRepository.findAll();

        // Verificăm dacă lista docs este null sau goală
        if (docs == null || docs.isEmpty()) {
            System.out.println("Lista documentelor este goală sau null.");
            return new ArrayList<>(); // Returnăm o listă goală
        }

        // Inițializăm lista finală
        List<DocumentType> finalDocumentTypes = new ArrayList<>();

        // Iterăm prin documente pentru a verifica dacă lista requiredDocs este goală
        for (DocumentType documentType : docs) {
            // Verificăm dacă requiredDocs nu este null și este goală
            if (documentType.getRequiredDocs() != null && documentType.getRequiredDocs().isEmpty()) {
                finalDocumentTypes.add(documentType);
            }
        }

        // Returnăm lista finală
        return finalDocumentTypes;
    }


}
