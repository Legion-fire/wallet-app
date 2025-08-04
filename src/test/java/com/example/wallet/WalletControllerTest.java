package com.example.wallet;

import com.example.wallet.entity.Wallet;
import com.example.wallet.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static com.example.wallet.dto.WalletOperationRequest.OperationType.DEPOSIT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class WalletControllerTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired
	WalletRepository walletRepository;

//	@Test
//	void deposit_and_get_balance() throws Exception {
//		UUID id = UUID.randomUUID();
//		walletRepository.save(new Wallet(id, 0L));
//
//		mockMvc.perform(post("/api/v1/wallet")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content("{"walletId":""+id+"","operationType":"DEPOSIT","amount":1000}"))
//				.andExpect(status().isOk());
//
//		mockMvc.perform(get("/api/v1/wallets/" + id))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.balance").value(1000));
//	}

//	@Test
//	void withdraw_insufficient_funds() throws Exception {
//		UUID id = UUID.randomUUID();
//		walletRepository.save(new Wallet(id, 100L));
//
//		mockMvc.perform(post("/api/v1/wallet")
//				.contentType(MediaType.APPLICATION_JSON)
//						.content("{"walletId":""+id+"","operationType":"WITHDRAW","amount":200}"))
//				.andExpect(status().isBadRequest())
//				.andExpect(jsonPath("$.error").value("INSUFFICIENT_FUNDS"));
//	}

}