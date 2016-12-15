// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.foo2.web;

import com.foo2.domain.Timer;
import com.foo2.service.api.TimerService;
import com.foo2.web.TimersCollectionThymeleafController;
import com.foo2.web.TimersItemThymeleafController;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesData;
import io.springlets.data.web.datatables.DatatablesPageable;
import io.springlets.data.web.select2.Select2Data;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

privileged aspect TimersCollectionThymeleafController_Roo_Thymeleaf {
    
    declare @type: TimersCollectionThymeleafController: @Controller;
    
    declare @type: TimersCollectionThymeleafController: @RequestMapping(value = "/timers", name = "TimersCollectionThymeleafController", produces = MediaType.TEXT_HTML_VALUE);
    
    /**
     * TODO Auto-generated attribute documentation
     */
    public MessageSource TimersCollectionThymeleafController.messageSource;
    
    /**
     * TODO Auto-generated constructor documentation
     * 
     * @param timerService
     * @param messageSource
     */
    @Autowired
    public TimersCollectionThymeleafController.new(TimerService timerService, MessageSource messageSource) {
        this.timerService = timerService;
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     * 
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "list")
    @ResponseBody
    public ModelAndView TimersCollectionThymeleafController.list(Model model) {
        return new ModelAndView("/timers/list");
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return UriComponents
     */
    public static UriComponents TimersCollectionThymeleafController.listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(
                MvcUriComponentsBuilder.on(TimersCollectionThymeleafController.class).list(null))
                .build().encode();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(produces = Datatables.MEDIA_TYPE, name = "datatables", value = "/dt")
    @ResponseBody
    public ResponseEntity<DatatablesData<Timer>> TimersCollectionThymeleafController.datatables(GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Timer> timers = timerService.findAll(search, pageable);
        long totalTimersCount = timers.getTotalElements();
        if (search != null && StringUtils.hasText(search.getText())) {
            totalTimersCount = timerService.count();
        }
        DatatablesData<Timer> datatablesData = new DatatablesData<Timer>(timers, totalTimersCount, draw);
        return  ResponseEntity.ok(datatablesData);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param search
     * @param pageable
     * @param locale
     * @return ResponseEntity
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, name = "select2", value = "/s2")
    @ResponseBody
    public ResponseEntity<Select2Data<Timer>> TimersCollectionThymeleafController.select2(GlobalSearch search, Pageable pageable, Locale locale) {
        Page<Timer> Timers = timerService.findAll(search, pageable);
        String idExpression = "#{id}";
        String textExpression = messageSource.getMessage("expression_timer", null, "#{toString()}", locale);
        Select2Data<Timer> select2Data = new Select2Data<Timer>(Timers, idExpression, textExpression);
        return  ResponseEntity.ok(select2Data);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param dataBinder
     */
    @InitBinder("timer")
    public void TimersCollectionThymeleafController.initTimerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param model
     */
    public void TimersCollectionThymeleafController.populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param model
     */
    public void TimersCollectionThymeleafController.populateForm(Model model) {
        populateFormats(model);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param timer
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView TimersCollectionThymeleafController.create(@Valid @ModelAttribute Timer timer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            
            return new ModelAndView("/timers/create");
        }
        Timer newTimer = timerService.save(timer);
        UriComponents showURI = TimersItemThymeleafController.showURI(newTimer);
        return new ModelAndView("redirect:" + showURI.toUriString());
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView TimersCollectionThymeleafController.createForm(Model model) {
        populateForm(model);
        
        model.addAttribute(new Timer());
        return new ModelAndView("timers/create");
    }
    
}
