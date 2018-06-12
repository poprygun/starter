package io.microsamples.integrations.soap;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.common.FileSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;

import java.util.Arrays;

@Slf4j
public class WireMockServiceTests {

    private WireMockServer wireMockServer = new WireMockServer(8787);

    @Before
    public void initWiremock(){

        FileSource mappings = new ClasspathFileSource("mappings");
        FileSource files = new ClasspathFileSource("__files");

        wireMockServer.enableRecordMappings(mappings, files);

        wireMockServer.start();
        log.info("Started wiremock server on port:{}", 8787);

        log.info("Wiremock stubs: {}", Arrays.toString(mappings.listFilesRecursively().toArray()));
    }

    @After
    public void shutdown() {
        wireMockServer.stop();
        log.info("Stopped wiremock server.");
    }
}
