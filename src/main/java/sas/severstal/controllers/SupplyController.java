package sas.severstal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sas.severstal.dto.SupplyDto;
import sas.severstal.service.SupplyService;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(path = "/supplies")
@Validated
public class SupplyController {

    private final SupplyService supplyService;


    public SupplyController(@Autowired SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @PostMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public SupplyDto createSupply(@RequestBody SupplyDto supplyDto) {
        return supplyService.saveSupply(supplyDto);
    }

    @CrossOrigin
    @GetMapping("/report")
    @ResponseStatus(HttpStatus.OK)
    public List<SupplyDto> getSuppliesBetweenDates(@RequestParam Timestamp startDate,
                                                   @RequestParam Timestamp endDate) {
        return supplyService.getSuppliesBetweenDates(startDate, endDate);
    }

}
