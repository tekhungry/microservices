package com.tekhungry.retail.inventroy;

import com.tekhungry.retail.inventroy.documents.Inventory;
import com.tekhungry.retail.inventroy.repository.InventoryRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class InventroyApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventroyApplication.class, args);
	}

	@Bean
	ApplicationRunner init(InventoryRepository repository) {

		Object[][] data = {
				{"Living", "sofa", "sofa 6 seater",300.12},
				{"Living", "sofa", "sofa 3 seater",200.12},
				{"Living", "bed", "king size",400.12}
		};

		return args -> {
			repository
					.deleteAll()
					.thenMany(
							Flux
									.just(data)
									.map(array -> {
										return new Inventory((String) array[0], (String) array[1], (String) array[2], (Number) array[3]);
									})
									.flatMap(repository::save)
					)
					.thenMany(repository.findAll())
					.subscribe(kayak -> System.out.println("saving " + kayak.toString()));

		};
	}
}
helm template install/kubernetes/helm/istio --name istio --set global.mtls.enabled=false --set tracing.enabled=true --set kiali.enabled=true --set grafana.enabled=true --namespace istio-system > istio.yaml