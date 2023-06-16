package payroll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// tag::hateoas-imports[]
// end::hateoas-imports[]

@RestController
class WalletController {
	@GetMapping("/cdata")
		String something() {
		return JwtGenerator.produce_cdata();
	}
}
