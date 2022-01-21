package com.orangebuddies.orangutan.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "orangutan")
data class PartnerConfigs (val partners: Map<String, Map<String, String>> = HashMap())