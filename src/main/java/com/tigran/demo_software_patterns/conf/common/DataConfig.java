package com.tigran.demo_software_patterns.conf.common;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by Tigran Melkonyan
 * Date: 11/16/24
 * Time: 9:12 PM
 */
@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = {"com.tigran.demo_software_patterns"})
public class DataConfig {
}
