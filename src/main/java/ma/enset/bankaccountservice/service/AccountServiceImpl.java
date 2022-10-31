package ma.enset.bankaccountservice.service;

import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponseDTO;
import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.mappers.AccountMapper;
import ma.enset.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
//        BankAccount bankAccount = BankAccount.builder()
//                .id(UUID.randomUUID().toString())
//                .accountType(bankAccountRequestDTO.getAccountType())
//                .currency(bankAccountRequestDTO.getCurrency())
//                .balance(bankAccountRequestDTO.getBalance())
//                .createdAt(new Date())
//                .build();
        BankAccount bankAccount = accountMapper.fromBankAccountRequestDTO(bankAccountRequestDTO);
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }
    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .accountType(bankAccountRequestDTO.getAccountType())
                .currency(bankAccountRequestDTO.getCurrency())
                .balance(bankAccountRequestDTO.getBalance())
                .createdAt(new Date())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }
}
