package BeaureaticSystems.document;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class DocumentTypeController {

    private DocumentTypeService documentTypeService;
    @GetMapping("/")
    public String root()
    {
        return "index";
    }

    @PostMapping("/create-document")
    public ResponseEntity createDocumentType(@RequestBody DocumentType docType) {
        documentTypeService.createDocumentType(docType);
        return new ResponseEntity<>(docType, HttpStatus.CREATED);
    }
}
