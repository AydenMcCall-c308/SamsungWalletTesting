package payroll;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

// tag::hateoas-imports[]
// end::hateoas-imports[]

@RestController
class WalletController {
	@CrossOrigin(origins = {"http://192.168.0.3:8000/", "http://192.168.0.3:8000", "http://192.168.0.3:8000/cdata"})
	@GetMapping("/cdata")
    String something() {
		return JwtGenerator.produce_cdata();
	}

	@CrossOrigin(origins = {"http://192.168.0.2:8080/", "http://192.168.0.2:8081", "http://192.168.0.2:8080/cdata"})
	@GetMapping("/app-data")
	JSONObject data() {
		JSONObject item = new JSONObject();
		item.put("java_version", 1.8);
		item.put("runtime-environment", "Jetbrains Intellij");
		item.put("region", "United States");
		return item;
	}
}
