package com.orangebuddies.orangutan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.StandardReflectionParameterNameDiscoverer
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean


//@EnableConfigurationProperties(PartnerConfigs::class)
@SpringBootApplication
class OBOrangutanApplication

fun main(args: Array<String>) {
	runApplication<OBOrangutanApplication>(*args)
}

/***
 * To support validation for suspend methods.
 * see: https://github.com/spring-projects/spring-framework/issues/23152
 */
@Configuration
class ValidationConfig {
	companion object {
		@Bean
		@Primary
		fun validator(): LocalValidatorFactoryBean {
			val factoryBean = LocalValidatorFactoryBean()
			factoryBean.setParameterNameDiscoverer(StandardReflectionParameterNameDiscoverer())
			return factoryBean
		}
	}
}