package com.koreacb.msa.loan;

import com.koreacb.msa.loan.model.Loan;
import com.koreacb.msa.loan.repository.LoanRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
@Slf4j
public class LoanApplication implements ApplicationRunner {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanApplication(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LoanApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        val now = new DateTime();
        loanRepository.save(new Loan(1, 1, 30000, 10000, now.minusYears(3).plusDays(39).toDate(), now.plusYears(2).plusDays(39).toDate()));
        loanRepository.save(new Loan(2, 1, 100000000, 100000000, now.minusYears(5).toDate(), now.plusYears(1).toDate()));
        loanRepository.save(new Loan(3, 1, 20000000, 1, now.minusMonths(2).toDate(), now.plusDays(33).toDate()));
        log.debug("Inserting automatically generated data");
    }
}