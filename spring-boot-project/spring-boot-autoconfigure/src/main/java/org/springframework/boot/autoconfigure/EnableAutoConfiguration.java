/*
 * Copyright 2012-2017 the original author or authors.
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

package org.springframework.boot.autoconfigure;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.SpringFactoriesLoader;

/**
 * Enable auto-configuration of the Spring Application Context, attempting to guess and
 * configure beans that you are likely to need. Auto-configuration classes are usually
 * applied based on your classpath and what beans you have defined. For example, if you
 * have {@code tomcat-embedded.jar} on your classpath you are likely to want a
 * {@link TomcatServletWebServerFactory} (unless you have defined your own
 * {@link ServletWebServerFactory} bean).
 *
 * 启用Spring应用程序上下文的自动配置，试图猜测和配置您可能需要的bean。
 * 自动配置类通常基于您的类路径和您定义的bean应用。 例如，如果您在类路径中有{tomcat-embedded.jar}，
 * 那么您可能需要一个{@link TomcatServletWebServerFactory}
 * （除非您已定义了自己的{@link ServletWebServerFactory} bean）。
 *
 * <p>
 * When using {@link SpringBootApplication}, the auto-configuration of the context is
 * automatically enabled and adding this annotation has therefore no additional effect.
 * <p>
 *
 *  <P>
 * 使用{@link SpringBootApplication}时，上下文的自动配置会自动启用，因此添加此注释不会产生额外的影响。
 * <p>
 *
 * Auto-configuration tries to be as intelligent as possible and will back-away as you
 * define more of your own configuration. You can always manually {@link #exclude()} any
 * configuration that you never want to apply (use {@link #excludeName()} if you don't
 * have access to them). You can also exclude them via the
 * {@code spring.autoconfigure.exclude} property. Auto-configuration is always applied
 * after user-defined beans have been registered.
 *
 * 自动配置会尝试尽可能地智能化，并会在您定义更多自己的配置时退出。
 * 您始终可以手动{@link #exclude（）}您永远不想应用的任何配置
 * （如果您无权访问，请使用{@link #excludeName（）}）。
 * 您还可以通过{@code spring.autoconfigure.exclude}属性排除它们。
 * 自动配置总是在用户定义的bean注册后应用。
 *
 * <p>
 * The package of the class that is annotated with {@code @EnableAutoConfiguration},
 * usually via {@code @SpringBootApplication}, has specific significance and is often used
 * as a 'default'. For example, it will be used when scanning for {@code @Entity} classes.
 * It is generally recommended that you place {@code @EnableAutoConfiguration} (if you're
 * not using {@code @SpringBootApplication}) in a root package so that all sub-packages
 * and classes can be searched.
 * <p>
 *
 * <P>
 * 使用{@code @EnableAutoConfiguration}进行注释的类的包通常通过
 * {@code @SpringBootApplication}具有特定的意义，并且通常用作“默认”。
 * 例如，它将在扫描{@code @Entity}类时使用。 通常建议您在根包中放置{@code @EnableAutoConfiguration}
 * （如果您未使用{@code @SpringBootApplication}），以便可以搜索所有子包和类。
 *<P>
 *
 * Auto-configuration classes are regular Spring {@link Configuration} beans. They are
 * located using the {@link SpringFactoriesLoader} mechanism (keyed against this class).
 * Generally auto-configuration beans are {@link Conditional @Conditional} beans (most
 * often using {@link ConditionalOnClass @ConditionalOnClass} and
 * {@link ConditionalOnMissingBean @ConditionalOnMissingBean} annotations).
 *
 * 自动配置类是普通的Spring {@link Configuration} bean。
 * 它们使用{@link SpringFactoriesLoader}机制进行定位（针对此类）。
 * 一般来说，自动配置bean是{@link Conditional @Conditional} bean
 * （通常使用{@ConditionalOnClass @ConditionalOnClass}和{@ConditionOnMissingBean @ConditionalOnMissingBean }注释）。
 *
 * @author Phillip Webb
 * @author Stephane Nicoll
 * @see ConditionalOnBean
 * @see ConditionalOnMissingBean
 * @see ConditionalOnClass
 * @see AutoConfigureAfter
 * @see SpringBootApplication
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import(AutoConfigurationImportSelector.class)
public @interface EnableAutoConfiguration {

	String ENABLED_OVERRIDE_PROPERTY = "spring.boot.enableautoconfiguration";

	/**
	 * Exclude specific auto-configuration classes such that they will never be applied.
	 *
	 * 排除特定的自动配置类，从而永远不会应用它们。
	 *
	 * @return the classes to exclude
	 */
	Class<?>[] exclude() default {};

	/**
	 * Exclude specific auto-configuration class names such that they will never be
	 * applied.
	 *
	 * 排除特定的自动配置类名称，使它们永远不会被应用。
	 *
	 * @return the class names to exclude
	 * @since 1.3.0
	 */
	String[] excludeName() default {};

}
