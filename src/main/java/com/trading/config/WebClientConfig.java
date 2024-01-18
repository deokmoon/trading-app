package com.trading.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.trading.constant.WebClientConstants.CONNECTION_MAX_IDLE_TIME;
import static com.trading.constant.WebClientConstants.CONNECTION_MAX_TIMEOUT;
import static com.trading.constant.WebClientConstants.CONNECTION_NAME;
import static com.trading.constant.WebClientConstants.CONNECTION_PENDING_ACQUIRE_COUNT;
import static com.trading.constant.WebClientConstants.CONNECTION_PENDING_ACQUIRE_TIMEOUT;
import static com.trading.constant.WebClientConstants.CONNECT_TIMEOUT_MILLIS_VALUE;
import static com.trading.constant.WebClientConstants.MAX_INMEMORY_SIZE;
import static com.trading.constant.WebClientConstants.READ_TIMEOUT_MILLS_VALUE;
import static com.trading.constant.WebClientConstants.RESPONSE_TIMEOUT_MILLS_VALUE;
import static com.trading.constant.WebClientConstants.WRITE_TIMEOUT_MILLS_VALUE;

@Configuration
public class WebClientConfig {
    public final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(new JavaTimeModule());

    @Bean
    public WebClient commonWebClient(ExchangeStrategies exchangeStrategies, HttpClient httpClient) {
        return WebClient
                .builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .exchangeStrategies(exchangeStrategies)
                .build();
    }

    @Bean
    public HttpClient defaultHttpClient(ConnectionProvider provider) {
        return HttpClient.create(provider)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, CONNECT_TIMEOUT_MILLIS_VALUE)
                .responseTimeout(Duration.ofMillis(RESPONSE_TIMEOUT_MILLS_VALUE))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(READ_TIMEOUT_MILLS_VALUE, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(WRITE_TIMEOUT_MILLS_VALUE, TimeUnit.MILLISECONDS)));
    }

    @Bean
    public ConnectionProvider connectionProvider() {

        return ConnectionProvider.builder(CONNECTION_NAME)
                .maxConnections(CONNECTION_MAX_TIMEOUT)
                .pendingAcquireTimeout(Duration.ofMillis(CONNECTION_PENDING_ACQUIRE_TIMEOUT))
                .pendingAcquireMaxCount(CONNECTION_PENDING_ACQUIRE_COUNT)
                .maxIdleTime(Duration.ofMillis(CONNECTION_MAX_IDLE_TIME))
                .build();
    }

    @Bean
    public ExchangeStrategies defaultExchangeStrategies() {

        return ExchangeStrategies.builder().codecs(config -> {
            config.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(mapper, MediaType.APPLICATION_JSON));
            config.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(mapper, MediaType.APPLICATION_JSON));
            config.defaultCodecs().maxInMemorySize(MAX_INMEMORY_SIZE);
        }).build();
    }
}
