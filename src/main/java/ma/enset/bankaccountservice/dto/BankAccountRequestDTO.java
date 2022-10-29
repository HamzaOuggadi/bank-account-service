package ma.enset.bankaccountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.bankaccountservice.enums.AccountType;
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class BankAccountRequestDTO {
    private double balance;
    private String currency;
    private AccountType accountType;
}
