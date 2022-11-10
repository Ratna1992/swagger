package com.boot.ratna.txmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BootTxmgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootTxmgmtApplication.class, args);
	}

}
