package com.foo2.web;
import com.foo2.domain.Timer;
import com.foo2.service.api.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = TimerDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Timer.class)
public class TimerDeserializer extends JsonObjectDeserializer<Timer> {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public TimerService timerService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param timerService
     * @param conversionService
     */
    @Autowired
    public TimerDeserializer(TimerService timerService, ConversionService conversionService) {
        this.timerService = timerService;
        this.conversionService = conversionService;
    }
}
