package ru.gb.Homework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfiguration {
    /**
     * Канал от входных данных до трансформера
     * @return
     */
    @Bean
    public MessageChannel messageChannelInput(){
        return new DirectChannel();
    }

    /**
     *
     * @return
     */
    @Bean
    public MessageChannel messageChannelFileWriter(){
       return new DirectChannel();
    }
    /**
     * Трансформер.
     * Настаивается маршрутизация, Указываем какие данные на входе, какие на выходе
     */
    @Bean
    @Transformer(inputChannel = "messageChannelInput", outputChannel = "messageChannelFileWriter")
    public GenericTransformer<String,String> myTransformer(){
        return text -> { // Входные данные передаем в трансформер
            return text.toUpperCase(); // Работаем с данными
        };
    }

    /**
     * Описываем сервис который выполняет задачу сохранения
     * Настраиваем файл handler
     * @return
     */
    @Bean
    @ServiceActivator(inputChannel = "messageChannelFileWriter")
    public FileWritingMessageHandler myFileWriter(){
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("./"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return  handler;
    }
}
