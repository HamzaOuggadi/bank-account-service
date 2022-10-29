package ma.enset.bankaccountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.bankaccountservice.enums.AccountType;

import java.util.Date;
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    private AccountType accountType;
}
