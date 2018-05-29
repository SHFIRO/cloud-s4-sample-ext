package com.sap.cloud.s4hana.eventing.security;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.security.KeyPair;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;

import com.sap.cloud.s4hana.eventing.testutil.EntitySupplier;

/**
 * @see LocalRSACipherTest
 * @see CloudRSACipherTest
 */
public abstract class RSACipherImplTester {
	
	RSACipher cipher;
	
	@Test
	public void testDecryptedStringMatchesEncryptedString() {
		final String message = "Hello World!";
		
		final String encrypted = cipher.encrypt(message);
		final String decrypted = cipher.decrypt(encrypted);
		
		assertThat("encrypted string should match original message after decryption", 
				decrypted, is(message));
	}
	
	@Test
	public void testDecryptedTesteeMatchesEncryptedTestee() {
		final AddressConfirmationToken token = AddressConfirmationToken.of(EntitySupplier.getDefaultAddress());
		
		final String encrypted = cipher.encrypt(token);
		final AddressConfirmationToken decrypted = cipher.decrypt(encrypted);
		
		assertThat("encrypted token should match original one after decryption", 
				EqualsBuilder.reflectionEquals(decrypted, token));
	}
	
	public void assertKeyPair(KeyPair keyPair, String algorithm) {
		assertThat("Private key's algorithm", keyPair.getPrivate().getAlgorithm(), is(algorithm));
		assertThat("Public key's algorithm", keyPair.getPublic().getAlgorithm(), is(algorithm));
	}

}
