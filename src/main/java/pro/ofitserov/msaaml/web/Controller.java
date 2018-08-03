package pro.ofitserov.msaaml.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.ofitserov.msaaml.backend.Service;

@RestController
@RequestMapping("msa")
@Api(value = "aml-service", description = "MSA#AML")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("get")
    @ApiOperation(value = "checkMLList")
    public ResponseEntity checkMLList(@RequestHeader String legalId, @RequestHeader String fullName, @RequestHeader String birthDate) {

        return service.checkMLList(legalId, fullName, birthDate);

    }
}

