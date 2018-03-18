package com.adithya.stock.dbservice.web;

import com.adithya.stock.dbservice.model.Quote;
import com.adithya.stock.dbservice.model.Quotes;
import com.adithya.stock.dbservice.repositories.QuotesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

    private QuotesRepository quotesRepository;

    public DbServiceResource(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") final String username){

        return quotesRepository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());


        //ddreturn null;
    }


    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quote){


        return null;
    }

}
