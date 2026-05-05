package org.example.walletwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for WalletWise.
 */
@SpringBootApplication
public class WalletWiseApplication {

    /**
     * Protected constructor for Checkstyle.
     */
    protected WalletWiseApplication() {
    }

    /**
     * Main method.
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        SpringApplication.run(
                WalletWiseApplication.class, args);
    }
}
