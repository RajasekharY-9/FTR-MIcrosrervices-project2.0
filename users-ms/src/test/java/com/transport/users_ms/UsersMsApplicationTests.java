package com.transport.users_ms;

import com.transport.users_ms.dto.UserProfileDTO;
import com.transport.users_ms.entity.UserProfile;
import com.transport.users_ms.exception.UserProfileException;
import com.transport.users_ms.repo.UserProfileRepository;
import com.transport.users_ms.service.UserProfileServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@WebMvcTest
class UsersMsApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	@Disabled
	public void getDataByIdValid() throws UserProfileException {
		UserProfileRepository repo=mock(UserProfileRepository.class);
		when(repo.findById(1l)).thenReturn(Optional.of(new UserProfile(155555l, "A", "b", "c", 55555555l, "j", "j", "j", "k", "l", 4444l)));

		UserProfileServiceImpl user=new UserProfileServiceImpl(repo);
		UserProfileDTO userProfileDTO = user.viewUserProfile(1l);
		assertEquals(155555l,userProfileDTO.getUserId());
	}

}
