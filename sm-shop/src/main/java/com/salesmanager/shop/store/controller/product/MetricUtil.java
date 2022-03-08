package com.salesmanager.shop.store.controller.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import static io.opentelemetry.api.common.AttributeKey.stringKey;

import com.dynatrace.opentelemetry.metric.DynatraceMetricExporter;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.BoundLongCounter;
import io.opentelemetry.api.metrics.GlobalMeterProvider;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MetricUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(MetricUtil.class);

    private static final Random random = new Random();

    private final LongCounter counter;

    public MetricUtil() {
        DynatraceMetricExporter exporter = null;

        // exporter = DynatraceMetricExporter.getDefault();

        String endpoint = "https://######.sprint.dynatracelabs.com/api/v2/metrics/ingest";
        try {
            exporter = DynatraceMetricExporter.builder()
                // .setPrefix("otel.java")
                // .setDefaultDimensions(Attributes.of(stringKey("environment"), "example"))
                .setUrl(endpoint)
                .setApiToken("################################################################################################")
                .build();
        } catch (MalformedURLException e) {
            LOGGER.warn(String.format("Endpoint '%s' is not a valid URL.", endpoint));
            this.counter = null;
            return;
        }                

        
        
        SdkMeterProvider.builder()
            .registerMetricReader(
                PeriodicMetricReader.builder(exporter)
                    .setInterval(Duration.ofMillis(60000))
                    .newMetricReaderFactory()
            )
            .buildAndRegisterGlobal();
        
        // Get or create a named meter instance. If a reference to the MeterProvider ist kept,
        // meterProvider.get(...) would do the same.
        Meter meter = GlobalMeterProvider.get()
            .meterBuilder(MetricUtil.class.getName())
            .setInstrumentationVersion("0.1.0-beta")
            .build();
            
        // Create a counter
        this.counter = meter
            .counterBuilder("ref_counter")
            .setDescription("Just some counter used as an example")
            .setUnit("1")
            .build();
    }

    public LongCounter referenceCounter() {
        return counter;
    }
}