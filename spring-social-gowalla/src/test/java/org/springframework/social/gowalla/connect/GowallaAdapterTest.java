/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.gowalla.connect;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.gowalla.api.Gowalla;
import org.springframework.social.gowalla.api.GowallaProfile;

public class GowallaAdapterTest {

	private GowallaAdapter apiAdapter = new GowallaAdapter();
	
	private Gowalla gowalla = Mockito.mock(Gowalla.class);
	
	@Test
	public void fetchProfile() {		
		Mockito.when(gowalla.getUserProfile()).thenReturn(new GowallaProfile("habuma", "Craig", "Walls", "Plano, TX", 1, 2, "https://s3.amazonaws.com/static.gowalla.com/users/362641-standard.jpg?1294162106"));
		UserProfile profile = apiAdapter.fetchUserProfile(gowalla);
		assertEquals("Craig Walls", profile.getName());
		assertEquals("Craig", profile.getFirstName());
		assertEquals("Walls", profile.getLastName());
		assertNull(profile.getEmail());
		assertEquals("habuma", profile.getUsername());
	}
	
}
