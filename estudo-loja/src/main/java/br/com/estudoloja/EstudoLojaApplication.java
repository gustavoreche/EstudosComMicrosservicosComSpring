package br.com.estudoloja;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
@EnableScheduling
public class EstudoLojaApplication {
	
	@Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("infoFornecedor");
    }
	
	@CacheEvict(allEntries = true, value = "infoFornecedor")
    @Scheduled(cron = "0 * * * * *")
    public void reportCacheEvict() {
		System.out.println("passou aqui");
    }
	
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
		return factory -> factory
				.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(14)).build())
				.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
				.build());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EstudoLojaApplication.class, args);
	}

}
