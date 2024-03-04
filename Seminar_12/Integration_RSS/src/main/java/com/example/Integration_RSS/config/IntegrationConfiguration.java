package com.example.Integration_RSS.config;

import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.feed.dsl.Feed;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.AbstractPayloadTransformer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class IntegrationConfiguration {
    /**
     * Описываем сервис который выполняет задачу сохранения
     * Настраиваем файл handler
     * @return
     */
    @Bean
//    @ServiceActivator(inputChannel = "messageChannelFileWriter")
    public FileWritingMessageHandler myFileWriter(){
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("./"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return  handler;
    }
    @Bean
    public AbstractPayloadTransformer<SyndEntry,String> extractLineFromRSS(){
        return new AbstractPayloadTransformer<SyndEntry, String>() {
            @Override
            protected String transformPayload(SyndEntry payload) {

                return payload.getTitle() + "; " +
                        payload.getAuthor() +"; " +
                        payload.getLink();
            }
        };
    }
    @Bean
    public IntegrationFlow feedRSSFlow() throws MalformedURLException {
        return IntegrationFlow.from(Feed.inboundAdapter(
                new URL("https://lenta.ru/rss"),"news"),
                e-> e.poller(p->p.fixedDelay(5000))).
                transform(extractLineFromRSS()).handle("myFileWriter").
                get();
    }

}
