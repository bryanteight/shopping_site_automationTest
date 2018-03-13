package accountInfo;

import java.util.UUID;

public class Generator {
	
	protected String generateEmail() {
		return new String(UUID.randomUUID().toString().substring(0, 8) + "@test.com");
    }

}
