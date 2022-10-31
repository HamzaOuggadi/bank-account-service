package ma.enset.bankaccountservice.web;

import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @QueryMapping
    public List<BankAccount> accountList() {
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account %s Not Found", id)));
    }
}
