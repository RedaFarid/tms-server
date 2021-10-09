package TMSserver.RestControllers;

import TMSserver.SQL.Entities.TransactionDTO;
import TMSserver.Services.TransactionsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TransactionsController {

    private final TransactionsService TransactionsService;

    @GetMapping("/transactions")
    public Transactions getTransactions() {
        Transactions Transactions;
        try {
            Transactions = new Transactions(TransactionsService.findAll(), null);
        } catch (Exception e) {
            Transactions = new Transactions(null, e);
        }
        return Transactions;
    }

    @PostMapping("/saveTransaction")
    public String save(@RequestBody TransactionDTO tank) {
        String msg = "saved";
        try {
            TransactionsService.save(tank);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }

    @GetMapping("/transactionById/{id}")
    public Optional<TransactionDTO> getTransactionById(@PathVariable Long id) {
        return TransactionsService.findById(id);
    }
    
    @PostMapping("/deleteTransactionById")
    public String deleteTransactionById(@RequestBody Long id) {
        String msg = "deleted";
        try {
            TransactionsService.deleteById(id);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Transactions {
        private List<TransactionDTO> transaction;
        private Exception exception;
    }
}
