package BeaureaticSystems.office;

import BeaureaticSystems.document.DocumentType;
import BeaureaticSystems.document.DocumentTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OfficeService {
    private OfficeRepository officeRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    public void createOffice(Office office){
        List<DocumentType> managedDocumentTypes = office.getCompatibleDocumentTypes().stream()
                .map(doc -> documentTypeRepository.findById(doc.getId())
                        .orElseThrow(() -> new RuntimeException("DocumentType not found: " + doc.getId())))
                .toList();
        office.setCompatibleDocumentTypes(managedDocumentTypes);
        officeRepository.save(office);
    }
    public Office getOfficeById(int id) {
        Optional<Office> office = officeRepository.findById(id);
        return office.orElse(null);
    }

    public Office saveOffice(Office office) {
        officeRepository.save(office);
        return office;
    }

    public Iterable<Office> getAllOffices() {
         return officeRepository.findAll();
    }
}
