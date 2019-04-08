package pt.isel.daw.LI61N.g10.dawproject.Configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import pt.isel.daw.LI61N.g10.dawproject.Interceptors.AuthorizationHeaderInterceptor

@Configuration
class MvcConfig : WebMvcConfigurer {

    @Bean
    fun authorizationHeaderInterceptor(): AuthorizationHeaderInterceptor {
        return AuthorizationHeaderInterceptor()
    }

    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        //resolvers.add(ClientIpArgumentResolver())
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(authorizationHeaderInterceptor())
    }

    override fun extendMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        //converters.add(0, ExampleMessageConverter())
    }
}