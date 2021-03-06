/*
 * Copyright 2002-2018 the original author or authors.
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

package sample.user;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @author Rob Winch
 */
@Component
public class UserDataInitializer implements SmartInitializingSingleton {
	private final UserRepository users;

	public UserDataInitializer(UserRepository users) {
		this.users = users;
	}

	@Override
	public void afterSingletonsInstantiated() {
		this.users.save(new User("1", "rwinch@example.com", "Rob Winch"));
		this.users.save(new User("2", "jgrandja@example.com", "Joe Grandja"));
		this.users.save(new User("3", "jcummings@example.com", "Josh Cummings"));
		this.users.save(new User("4", "jlong@example.com", "Josh Long"));
	}
}
