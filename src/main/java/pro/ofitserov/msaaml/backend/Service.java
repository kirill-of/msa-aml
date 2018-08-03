package pro.ofitserov.msaaml.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pro.ofitserov.msaaml.model.ML;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private static final Logger logger = LoggerFactory.getLogger(Service.class);

    @Autowired
    private Dao dao;

    public ResponseEntity checkMLList(String legalId, String fullName, String birthDate) {

        List<ML> result = new ArrayList<>();

        try {

            result = dao.getMLList(legalId, fullName, birthDate);

            if (result.isEmpty()) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity(result, HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.error("Error ", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}